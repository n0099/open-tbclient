package com.bytedance.sdk.a.b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes4.dex */
public final class n {
    private static final k[] pnF = {k.pnp, k.pnt, k.pnq, k.pnu, k.pnA, k.pnz, k.pmQ, k.pna, k.pmR, k.pnb, k.pmy, k.pmz, k.plW, k.pma, k.plA};
    public static final n pnG = new a(true).a(pnF).a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0).AM(true).eru();
    public static final n pnH = new a(pnG).a(ad.TLS_1_0).AM(true).eru();
    public static final n pnI = new a(false).eru();
    final boolean d;
    final boolean e;
    final String[] f;
    final String[] g;

    n(a aVar) {
        this.d = aVar.f6264a;
        this.f = aVar.f6265b;
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
        n b2 = b(sSLSocket, z);
        if (b2.g != null) {
            sSLSocket.setEnabledProtocols(b2.g);
        }
        if (b2.f != null) {
            sSLSocket.setEnabledCipherSuites(b2.f);
        }
    }

    private n b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f != null) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.a(k.f6262a, sSLSocket.getEnabledCipherSuites(), this.f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.g != null) {
            enabledProtocols = com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.pjs, sSLSocket.getEnabledProtocols(), this.g);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = com.bytedance.sdk.a.b.a.c.a(k.f6262a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.b(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        return new a(this).ag(enabledCipherSuites).ah(enabledProtocols).eru();
    }

    public boolean e(SSLSocket sSLSocket) {
        if (this.d) {
            if (this.g == null || com.bytedance.sdk.a.b.a.c.b(com.bytedance.sdk.a.b.a.c.pjs, this.g, sSLSocket.getEnabledProtocols())) {
                return this.f == null || com.bytedance.sdk.a.b.a.c.b(k.f6262a, this.f, sSLSocket.getEnabledCipherSuites());
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

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f6264a;

        /* renamed from: b  reason: collision with root package name */
        String[] f6265b;
        String[] c;
        boolean d;

        a(boolean z) {
            this.f6264a = z;
        }

        public a(n nVar) {
            this.f6264a = nVar.d;
            this.f6265b = nVar.f;
            this.c = nVar.g;
            this.d = nVar.e;
        }

        public a a(k... kVarArr) {
            if (this.f6264a) {
                String[] strArr = new String[kVarArr.length];
                for (int i = 0; i < kVarArr.length; i++) {
                    strArr[i] = kVarArr[i].pnB;
                }
                return ag(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a ag(String... strArr) {
            if (this.f6264a) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                this.f6265b = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(ad... adVarArr) {
            if (this.f6264a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f;
                }
                return ah(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a ah(String... strArr) {
            if (this.f6264a) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                this.c = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a AM(boolean z) {
            if (!this.f6264a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public n eru() {
            return new n(this);
        }
    }
}
