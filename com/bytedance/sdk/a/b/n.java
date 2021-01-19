package com.bytedance.sdk.a.b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes4.dex */
public final class n {
    private static final k[] pjd = {k.piN, k.piR, k.piO, k.piS, k.piY, k.piX, k.pio, k.piy, k.pip, k.piz, k.phT, k.phU, k.phr, k.phv, k.pgV};
    public static final n pje = new a(true).a(pjd).a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0).AI(true).enz();
    public static final n pjf = new a(pje).a(ad.TLS_1_0).AI(true).enz();
    public static final n pjg = new a(false).enz();
    final boolean d;
    final boolean e;
    final String[] f;
    final String[] g;

    n(a aVar) {
        this.d = aVar.f5965a;
        this.f = aVar.f5966b;
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
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.a(k.f5963a, sSLSocket.getEnabledCipherSuites(), this.f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.g != null) {
            enabledProtocols = com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.peO, sSLSocket.getEnabledProtocols(), this.g);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = com.bytedance.sdk.a.b.a.c.a(k.f5963a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.b(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        return new a(this).ag(enabledCipherSuites).ah(enabledProtocols).enz();
    }

    public boolean e(SSLSocket sSLSocket) {
        if (this.d) {
            if (this.g == null || com.bytedance.sdk.a.b.a.c.b(com.bytedance.sdk.a.b.a.c.peO, this.g, sSLSocket.getEnabledProtocols())) {
                return this.f == null || com.bytedance.sdk.a.b.a.c.b(k.f5963a, this.f, sSLSocket.getEnabledCipherSuites());
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
        boolean f5965a;

        /* renamed from: b  reason: collision with root package name */
        String[] f5966b;
        String[] c;
        boolean d;

        a(boolean z) {
            this.f5965a = z;
        }

        public a(n nVar) {
            this.f5965a = nVar.d;
            this.f5966b = nVar.f;
            this.c = nVar.g;
            this.d = nVar.e;
        }

        public a a(k... kVarArr) {
            if (this.f5965a) {
                String[] strArr = new String[kVarArr.length];
                for (int i = 0; i < kVarArr.length; i++) {
                    strArr[i] = kVarArr[i].piZ;
                }
                return ag(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a ag(String... strArr) {
            if (this.f5965a) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                this.f5966b = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(ad... adVarArr) {
            if (this.f5965a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f;
                }
                return ah(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a ah(String... strArr) {
            if (this.f5965a) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                this.c = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a AI(boolean z) {
            if (!this.f5965a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public n enz() {
            return new n(this);
        }
    }
}
