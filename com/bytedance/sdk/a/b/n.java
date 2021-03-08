package com.bytedance.sdk.a.b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class n {
    private static final k[] pvY = {k.pvI, k.pvM, k.pvJ, k.pvN, k.pvT, k.pvS, k.pvj, k.pvt, k.pvk, k.pvu, k.puR, k.puS, k.pup, k.put, k.ptT};
    public static final n pvZ = new a(true).a(pvY).a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0).Ba(true).eqh();
    public static final n pwa = new a(pvZ).a(ad.TLS_1_0).Ba(true).eqh();
    public static final n pwb = new a(false).eqh();
    final boolean d;
    final boolean e;
    final String[] f;
    final String[] g;

    n(a aVar) {
        this.d = aVar.f4005a;
        this.f = aVar.b;
        this.g = aVar.c;
        this.e = aVar.d;
    }

    public boolean a() {
        return this.d;
    }

    public List<k> b() {
        if (this.f != null) {
            return k.a(this.f);
        }
        return null;
    }

    public List<ad> c() {
        if (this.g != null) {
            return ad.a(this.g);
        }
        return null;
    }

    public boolean d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        n b = b(sSLSocket, z);
        if (b.g != null) {
            sSLSocket.setEnabledProtocols(b.g);
        }
        if (b.f != null) {
            sSLSocket.setEnabledCipherSuites(b.f);
        }
    }

    private n b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f != null) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.a(k.f4004a, sSLSocket.getEnabledCipherSuites(), this.f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.g != null) {
            enabledProtocols = com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.prL, sSLSocket.getEnabledProtocols(), this.g);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = com.bytedance.sdk.a.b.a.c.a(k.f4004a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.b(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        return new a(this).ag(enabledCipherSuites).ah(enabledProtocols).eqh();
    }

    public boolean e(SSLSocket sSLSocket) {
        if (this.d) {
            if (this.g == null || com.bytedance.sdk.a.b.a.c.b(com.bytedance.sdk.a.b.a.c.prL, this.g, sSLSocket.getEnabledProtocols())) {
                return this.f == null || com.bytedance.sdk.a.b.a.c.b(k.f4004a, this.f, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            if (obj == this) {
                return true;
            }
            n nVar = (n) obj;
            if (this.d == nVar.d) {
                return !this.d || (Arrays.equals(this.f, nVar.f) && Arrays.equals(this.g, nVar.g) && this.e == nVar.e);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        if (!this.d) {
            return 17;
        }
        return (this.e ? 0 : 1) + ((((Arrays.hashCode(this.f) + 527) * 31) + Arrays.hashCode(this.g)) * 31);
    }

    public String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.g != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.e + ")";
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f4005a;
        String[] b;
        String[] c;
        boolean d;

        a(boolean z) {
            this.f4005a = z;
        }

        public a(n nVar) {
            this.f4005a = nVar.d;
            this.b = nVar.f;
            this.c = nVar.g;
            this.d = nVar.e;
        }

        public a a(k... kVarArr) {
            if (this.f4005a) {
                String[] strArr = new String[kVarArr.length];
                for (int i = 0; i < kVarArr.length; i++) {
                    strArr[i] = kVarArr[i].pvU;
                }
                return ag(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a ag(String... strArr) {
            if (this.f4005a) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                this.b = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(ad... adVarArr) {
            if (this.f4005a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f;
                }
                return ah(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a ah(String... strArr) {
            if (this.f4005a) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                this.c = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a Ba(boolean z) {
            if (!this.f4005a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public n eqh() {
            return new n(this);
        }
    }
}
