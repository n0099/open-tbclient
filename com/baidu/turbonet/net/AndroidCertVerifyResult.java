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
    public final int f22297a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f22298b;

    /* renamed from: c  reason: collision with root package name */
    public final List<X509Certificate> f22299c;

    public AndroidCertVerifyResult(int i2, boolean z, List<X509Certificate> list) {
        this.f22297a = i2;
        this.f22298b = z;
        this.f22299c = new ArrayList(list);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.f22299c.size()];
        for (int i2 = 0; i2 < this.f22299c.size(); i2++) {
            try {
                bArr[i2] = this.f22299c.get(i2).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0];
            }
        }
        return bArr;
    }

    @CalledByNative
    public int getStatus() {
        return this.f22297a;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.f22298b;
    }

    public AndroidCertVerifyResult(int i2) {
        this.f22297a = i2;
        this.f22298b = false;
        this.f22299c = Collections.emptyList();
    }
}
