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
    private final boolean myO;
    private final List<X509Certificate> myP;

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.mStatus = i;
        this.myO = z;
        this.myP = new ArrayList(list);
    }

    public AndroidCertVerifyResult(int i) {
        this.mStatus = i;
        this.myO = false;
        this.myP = Collections.emptyList();
    }

    @CalledByNative
    public int getStatus() {
        return this.mStatus;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.myO;
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.myP.size()];
        for (int i = 0; i < this.myP.size(); i++) {
            try {
                bArr[i] = this.myP.get(i).getEncoded();
            } catch (CertificateEncodingException e) {
                return new byte[0];
            }
        }
        return bArr;
    }
}
