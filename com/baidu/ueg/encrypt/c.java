package com.baidu.ueg.encrypt;

import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class c implements a {
    private PublicKey fEP;

    public c(String str) throws Exception {
        init(str);
    }

    private void init(String str) throws Exception {
        if (com.baidu.ueg.a.a.h(str)) {
            throw new Exception("PubKey can not be blank.");
        }
        this.fEP = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(com.baidu.ueg.lib.a.rx(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
    }

    @Override // com.baidu.ueg.encrypt.a
    public String encrypt(String str) throws Exception {
        if (com.baidu.ueg.a.a.h(str)) {
            throw new Exception("Plaintext can not be blank.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, this.fEP);
        return com.baidu.ueg.lib.a.E(cipher.doFinal(str.getBytes()));
    }
}
