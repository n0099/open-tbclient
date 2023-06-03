package com.bytedance.pangle.f;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class p extends r {
    public final byte[] a;
    public int b;

    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.b = -1;
        this.a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.f.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.b == -1) {
            try {
                this.b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.b = 0;
            }
        }
        return this.b;
    }
}
