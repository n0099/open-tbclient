package com.baidu.ueg.encrypt;

import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class c implements a {
    private PublicKey hDq;

    public c(String str) throws Exception {
        wr(str);
    }

    private void wr(String str) throws Exception {
        if (com.baidu.ueg.a.a.i(str)) {
            throw new Exception("PubKey can not be blank.");
        }
        this.hDq = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(com.baidu.ueg.lib.a.ws(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
    }

    @Override // com.baidu.ueg.encrypt.a
    public String encrypt(String str) throws Exception {
        if (com.baidu.ueg.a.a.i(str)) {
            throw new Exception("Plaintext can not be blank.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, this.hDq);
        return com.baidu.ueg.lib.a.G(cipher.doFinal(str.getBytes()));
    }
}
