package com.bytedance.sdk.a.b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes6.dex */
public final class j {
    public static final j ptJ = new a().eqg();
    private final Set<b> b;
    private final com.bytedance.sdk.a.b.a.i.c ptK;

    j(Set<b> set, com.bytedance.sdk.a.b.a.i.c cVar) {
        this.b = set;
        this.ptK = cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof j) && com.bytedance.sdk.a.b.a.c.a(this.ptK, ((j) obj).ptK) && this.b.equals(((j) obj).b);
    }

    public int hashCode() {
        return ((this.ptK != null ? this.ptK.hashCode() : 0) * 31) + this.b.hashCode();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (!a2.isEmpty()) {
            if (this.ptK != null) {
                list = this.ptK.s(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a2.size();
                int i2 = 0;
                com.bytedance.sdk.a.a.f fVar = null;
                com.bytedance.sdk.a.a.f fVar2 = null;
                while (i2 < size2) {
                    b bVar = a2.get(i2);
                    if (bVar.c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = d(x509Certificate);
                        }
                        if (bVar.psf.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = c(x509Certificate);
                        }
                        if (bVar.psf.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                    }
                    i2++;
                    fVar = fVar;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                append.append("\n    ").append(a(x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            int size4 = a2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                append.append("\n    ").append(a2.get(i4));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j a(com.bytedance.sdk.a.b.a.i.c cVar) {
        return com.bytedance.sdk.a.b.a.c.a(this.ptK, cVar) ? this : new j(this.b, cVar);
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + d((X509Certificate) certificate).b();
    }

    static com.bytedance.sdk.a.a.f c(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    static com.bytedance.sdk.a.a.f d(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f4003a;
        final String b;
        final String c;
        final com.bytedance.sdk.a.a.f psf;

        boolean a(String str) {
            if (this.f4003a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                return (str.length() - indexOf) + (-1) == this.b.length() && str.regionMatches(false, indexOf + 1, this.b, 0, this.b.length());
            }
            return str.equals(this.b);
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && this.f4003a.equals(((b) obj).f4003a) && this.c.equals(((b) obj).c) && this.psf.equals(((b) obj).psf);
        }

        public int hashCode() {
            return ((((this.f4003a.hashCode() + 527) * 31) + this.c.hashCode()) * 31) + this.psf.hashCode();
        }

        public String toString() {
            return this.c + this.psf.b();
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f4002a = new ArrayList();

        public j eqg() {
            return new j(new LinkedHashSet(this.f4002a), null);
        }
    }
}
