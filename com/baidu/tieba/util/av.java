package com.baidu.tieba.util;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class av {
    public static String a(String str) {
        String str2 = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append(SocialConstants.FALSE);
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            str2 = stringBuffer.toString();
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            String str3 = str2;
            com.baidu.adp.lib.g.e.a(e.getMessage());
            return str3;
        }
    }
}
