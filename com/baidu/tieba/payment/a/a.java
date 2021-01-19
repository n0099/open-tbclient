package com.baidu.tieba.payment.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.c;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes8.dex */
public class a {
    public static String encrypt(String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(c.decode(Oo(str2))));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            return c.encodeBytes(cipher.doFinal(str.getBytes("GBK")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String Oo(String str) {
        return StringUtils.isNull(str) ? "" : str.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");
    }
}
