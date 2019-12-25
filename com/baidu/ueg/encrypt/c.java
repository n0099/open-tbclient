package com.baidu.ueg.encrypt;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes5.dex */
public class c implements a {
    private PublicKey kSC;

    public c(String str) throws Exception {
        init(str);
    }

    private void init(String str) throws Exception {
        if (com.baidu.ueg.a.a.isBlank(str)) {
            throw new Exception("PubKey can not be blank.");
        }
        this.kSC = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.ueg.lib.a.decodeBase64(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
    }

    @Override // com.baidu.ueg.encrypt.a
    public String encrypt(String str) throws Exception {
        if (com.baidu.ueg.a.a.isBlank(str)) {
            throw new Exception("Plaintext can not be blank.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, this.kSC);
        return com.baidu.ueg.lib.a.encodeBase64String(cipher.doFinal(str.getBytes()));
    }
}
