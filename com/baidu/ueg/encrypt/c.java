package com.baidu.ueg.encrypt;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class c implements a {
    private PublicKey jYB;

    public c(String str) throws Exception {
        Hx(str);
    }

    private void Hx(String str) throws Exception {
        if (com.baidu.ueg.a.a.n(str)) {
            throw new Exception("PubKey can not be blank.");
        }
        this.jYB = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.ueg.lib.a.Hy(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
    }

    @Override // com.baidu.ueg.encrypt.a
    public String encrypt(String str) throws Exception {
        if (com.baidu.ueg.a.a.n(str)) {
            throw new Exception("Plaintext can not be blank.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, this.jYB);
        return com.baidu.ueg.lib.a.T(cipher.doFinal(str.getBytes()));
    }
}
