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
    public final int f22666a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f22667b;

    /* renamed from: c  reason: collision with root package name */
    public final List<X509Certificate> f22668c;

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.f22666a = i;
        this.f22667b = z;
        this.f22668c = new ArrayList(list);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.f22668c.size()];
        for (int i = 0; i < this.f22668c.size(); i++) {
            try {
                bArr[i] = this.f22668c.get(i).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0];
            }
        }
        return bArr;
    }

    @CalledByNative
    public int getStatus() {
        return this.f22666a;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.f22667b;
    }

    public AndroidCertVerifyResult(int i) {
        this.f22666a = i;
        this.f22667b = false;
        this.f22668c = Collections.emptyList();
    }
}
