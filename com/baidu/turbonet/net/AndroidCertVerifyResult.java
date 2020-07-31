package com.baidu.turbonet.net;

import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@JNINamespace
/* loaded from: classes19.dex */
public class AndroidCertVerifyResult {
    private final boolean mGW;
    private final List<X509Certificate> mGX;
    private final int mStatus;

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.mStatus = i;
        this.mGW = z;
        this.mGX = new ArrayList(list);
    }

    public AndroidCertVerifyResult(int i) {
        this.mStatus = i;
        this.mGW = false;
        this.mGX = Collections.emptyList();
    }

    @CalledByNative
    public int getStatus() {
        return this.mStatus;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.mGW;
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.mGX.size()];
        for (int i = 0; i < this.mGX.size(); i++) {
            try {
                bArr[i] = this.mGX.get(i).getEncoded();
            } catch (CertificateEncodingException e) {
                return new byte[0];
            }
        }
        return bArr;
    }
}
