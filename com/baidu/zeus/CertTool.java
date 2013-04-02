package com.baidu.zeus;

import android.content.Context;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.zeus.bouncycastle.AlgorithmIdentifier;
import com.baidu.zeus.bouncycastle.Base64;
import com.baidu.zeus.bouncycastle.NetscapeCertRequest;
import com.baidu.zeus.bouncycastle.PKCSObjectIdentifiers;
import com.baidu.zeus.security.Credentials;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CertTool {
    static final String CERT = "CERT";
    private static final String LOGTAG = "CertTool";
    static final String PKCS12 = "PKCS12";
    private static final AlgorithmIdentifier MD5_WITH_RSA = new AlgorithmIdentifier(PKCSObjectIdentifiers.md5WithRSAEncryption);
    private static HashMap sCertificateTypeMap = new HashMap();

    static {
        sCertificateTypeMap.put("application/x-x509-ca-cert", "CERT");
        sCertificateTypeMap.put("application/x-x509-user-cert", "CERT");
        sCertificateTypeMap.put("application/x-pkcs12", "PKCS12");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] getKeyStrengthList() {
        return new String[]{"High Grade", "Medium Grade"};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSignedPublicKey(Context context, int i, String str) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAUtil.ALGORITHM_RSA);
            keyPairGenerator.initialize(i == 0 ? 2048 : NotificationProxy.MAX_URL_LENGTH);
            KeyPair genKeyPair = keyPairGenerator.genKeyPair();
            NetscapeCertRequest netscapeCertRequest = new NetscapeCertRequest(str, MD5_WITH_RSA, genKeyPair.getPublic());
            netscapeCertRequest.sign(genKeyPair.getPrivate());
            byte[] dEREncoded = netscapeCertRequest.toASN1Object().getDEREncoded();
            Credentials.getInstance().install(context, genKeyPair);
            return new String(Base64.encode(dEREncoded));
        } catch (Exception e) {
            Log.w(LOGTAG, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addCertificate(Context context, String str, byte[] bArr) {
        Credentials.getInstance().install(context, str, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCertType(String str) {
        return (String) sCertificateTypeMap.get(str);
    }

    private CertTool() {
    }
}
