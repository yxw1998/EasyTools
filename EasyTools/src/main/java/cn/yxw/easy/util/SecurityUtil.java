package cn.yxw.easy;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author YangXw
 * @date 2022/3/28 18:02
 * @description
 */
public class SecurityUtil {

    /**
     * 空字符串
     */
    private static final String NULL_STR = "";

    /**
     * 获取MD5加密后的字符串
     *
     * @param str
     * @return
     */
    public static String MD5(String str) {
        return MD5(str, NULL_STR);
    }

    /**
     * 获取MD5加密后的字符串
     *
     * @param str
     * @param salt 加密盐
     * @return
     */
    public static String MD5(String str, String salt) {
        if (StrUtil.isEmpty(str)) {
            return NULL_STR;
        } else {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update((str+salt).getBytes(StandardCharsets.UTF_8));
                return String.valueOf(md5.digest());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return NULL_STR;
    }


    /**
     * 获取Base64加密后的字符串
     *
     * @param str
     * @return
     */
    public static String Base64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 获取Base64解密后的字符串
     *
     * @param str
     * @return
     */
    public static String Base64ToStr(String str) {
        return String.valueOf(Base64.getDecoder().decode(str));
    }

    /**
     * 获取SHA1加密后的字符串
     * @param str
     * @return
     */
    public static String SHA1(String str) {
        if (StrUtil.isEmpty(str)) {
            return NULL_STR;
        } else {
            try {
                MessageDigest sha = MessageDigest.getInstance("SHA");
                sha.update(str.getBytes(StandardCharsets.UTF_8));
                return String.valueOf(sha.digest());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return NULL_STR;
    }


}
