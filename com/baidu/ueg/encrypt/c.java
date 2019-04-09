package com.baidu.ueg.encrypt;

import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class c implements a {
    private PublicKey jxA;

    public c(String str) throws Exception {
        Ff(str);
    }

    private void Ff(String str) throws Exception {
        if (com.baidu.ueg.a.a.m(str)) {
            throw new Exception("PubKey can not be blank.");
        }
        this.jxA = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(com.baidu.ueg.lib.a.Fg(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
    }

    @Override // com.baidu.ueg.encrypt.a
    public String encrypt(String str) throws Exception {
        if (com.baidu.ueg.a.a.m(str)) {
            throw new Exception("Plaintext can not be blank.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, this.jxA);
        return com.baidu.ueg.lib.a.U(cipher.doFinal(str.getBytes()));
    }
}
