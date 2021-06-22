package com.baidu.turbonet.net;

import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@JNINamespace
/* loaded from: classes5.dex */
public class AndroidCertVerifyResult {

    /* renamed from: a  reason: collision with root package name */
    public final int f22411a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f22412b;

    /* renamed from: c  reason: collision with root package name */
    public final List<X509Certificate> f22413c;

    public AndroidCertVerifyResult(int i2, boolean z, List<X509Certificate> list) {
        this.f22411a = i2;
        this.f22412b = z;
        this.f22413c = new ArrayList(list);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.f22413c.size()];
        for (int i2 = 0; i2 < this.f22413c.size(); i2++) {
            try {
                bArr[i2] = this.f22413c.get(i2).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0];
            }
        }
        return bArr;
    }

    @CalledByNative
    public int getStatus() {
        return this.f22411a;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.f22412b;
    }

    public AndroidCertVerifyResult(int i2) {
        this.f22411a = i2;
        this.f22412b = false;
        this.f22413c = Collections.emptyList();
    }
}
