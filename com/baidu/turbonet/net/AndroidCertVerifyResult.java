package com.baidu.turbonet.net;

import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@JNINamespace
/* loaded from: classes.dex */
public class AndroidCertVerifyResult {
    private final int mStatus;
    private final boolean myR;
    private final List<X509Certificate> myS;

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.mStatus = i;
        this.myR = z;
        this.myS = new ArrayList(list);
    }

    public AndroidCertVerifyResult(int i) {
        this.mStatus = i;
        this.myR = false;
        this.myS = Collections.emptyList();
    }

    @CalledByNative
    public int getStatus() {
        return this.mStatus;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.myR;
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.myS.size()];
        for (int i = 0; i < this.myS.size(); i++) {
            try {
                bArr[i] = this.myS.get(i).getEncoded();
            } catch (CertificateEncodingException e) {
                return new byte[0];
            }
        }
        return bArr;
    }
}
