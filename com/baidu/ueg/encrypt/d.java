package com.baidu.ueg.encrypt;

import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class d implements a {
    private PublicKey cDz;

    public d(String str) {
        init(str);
    }

    private void init(String str) {
        if (com.baidu.ueg.a.a.e(str)) {
            throw new Exception("PubKey can not be blank.");
        }
        this.cDz = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(com.baidu.ueg.lib.a.kf(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
    }

    @Override // com.baidu.ueg.encrypt.a
    public String encrypt(String str) {
        if (com.baidu.ueg.a.a.e(str)) {
            throw new Exception("Plaintext can not be blank.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, this.cDz);
        return com.baidu.ueg.lib.a.E(cipher.doFinal(str.getBytes()));
    }
}
