package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes4.dex */
public class z implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final List<w> f5984a = com.bytedance.sdk.a.b.a.c.P(w.HTTP_2, w.HTTP_1_1);

    /* renamed from: b  reason: collision with root package name */
    static final List<n> f5985b = com.bytedance.sdk.a.b.a.c.P(n.pjd, n.pjf);
    final int A;
    final int B;
    final int C;
    final List<w> e;
    final List<n> f;
    final List<x> g;
    final List<x> h;
    final r pjA;
    final q pjl;
    final Proxy pjm;
    final t.a pjn;
    final ProxySelector pjo;
    final p pjp;
    final f pjq;
    final com.bytedance.sdk.a.b.a.a.e pjr;
    final SocketFactory pjs;
    final SSLSocketFactory pjt;
    final com.bytedance.sdk.a.b.a.i.c pju;
    final HostnameVerifier pjv;
    final j pjw;
    final e pjx;
    final e pjy;
    final m pjz;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.bytedance.sdk.a.b.a.a.pdM = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str) {
                aVar.XC(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str, String str2) {
                aVar.hd(str, str2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean b(m mVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                return mVar.d(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.c a(m mVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, d dVar) {
                return mVar.a(aVar, gVar, dVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public Socket a(m mVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a.b.g gVar) {
                return mVar.a(aVar, gVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(m mVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                mVar.c(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.d a(m mVar) {
                return mVar.pja;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public int a(b.a aVar) {
                return aVar.c;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(n nVar, SSLSocket sSLSocket, boolean z) {
                nVar.a(sSLSocket, z);
            }
        };
    }

    public z() {
        this(new a());
    }

    z(a aVar) {
        this.pjl = aVar.pjB;
        this.pjm = aVar.f5986b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = com.bytedance.sdk.a.b.a.c.a(aVar.e);
        this.h = com.bytedance.sdk.a.b.a.c.a(aVar.f);
        this.pjn = aVar.pjC;
        this.pjo = aVar.pjD;
        this.pjp = aVar.pjE;
        this.pjq = aVar.pjF;
        this.pjr = aVar.pjG;
        this.pjs = aVar.pjH;
        boolean z = false;
        for (n nVar : this.f) {
            z = z || nVar.a();
        }
        if (aVar.m != null || !z) {
            this.pjt = aVar.m;
            this.pju = aVar.pjI;
        } else {
            X509TrustManager enJ = enJ();
            this.pjt = c(enJ);
            this.pju = com.bytedance.sdk.a.b.a.i.c.a(enJ);
        }
        this.pjv = aVar.pjJ;
        this.pjw = aVar.pjK.a(this.pju);
        this.pjx = aVar.pjL;
        this.pjy = aVar.pjM;
        this.pjz = aVar.pjN;
        this.pjA = aVar.pjO;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        }
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private X509TrustManager enJ() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.a.b.a.c.f("No System TLS", e);
        }
    }

    private SSLSocketFactory c(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.a.b.a.c.f("No System TLS", e);
        }
    }

    public int a() {
        return this.z;
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public Proxy emG() {
        return this.pjm;
    }

    public ProxySelector enK() {
        return this.pjo;
    }

    public p enL() {
        return this.pjp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.a.e enM() {
        return this.pjq != null ? this.pjq.pdN : this.pjr;
    }

    public r enN() {
        return this.pjA;
    }

    public SocketFactory enO() {
        return this.pjs;
    }

    public SSLSocketFactory enP() {
        return this.pjt;
    }

    public HostnameVerifier enQ() {
        return this.pjv;
    }

    public j enR() {
        return this.pjw;
    }

    public e enS() {
        return this.pjy;
    }

    public e enT() {
        return this.pjx;
    }

    public m enU() {
        return this.pjz;
    }

    public boolean p() {
        return this.w;
    }

    public boolean q() {
        return this.x;
    }

    public boolean r() {
        return this.y;
    }

    public q enV() {
        return this.pjl;
    }

    public List<w> t() {
        return this.e;
    }

    public List<n> u() {
        return this.f;
    }

    public List<x> enW() {
        return this.g;
    }

    public List<x> w() {
        return this.h;
    }

    public t.a enX() {
        return this.pjn;
    }

    public h g(ab abVar) {
        return aa.a(this, abVar, false);
    }

    public a enY() {
        return new a(this);
    }

    /* loaded from: classes4.dex */
    public static final class a {
        int A;

        /* renamed from: b  reason: collision with root package name */
        Proxy f5986b;
        List<w> c;
        List<n> d;
        final List<x> e;
        final List<x> f;
        SSLSocketFactory m;
        q pjB;
        t.a pjC;
        ProxySelector pjD;
        p pjE;
        f pjF;
        com.bytedance.sdk.a.b.a.a.e pjG;
        SocketFactory pjH;
        com.bytedance.sdk.a.b.a.i.c pjI;
        HostnameVerifier pjJ;
        j pjK;
        e pjL;
        e pjM;
        m pjN;
        r pjO;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.pjB = new q();
            this.c = z.f5984a;
            this.d = z.f5985b;
            this.pjC = t.a(t.pjk);
            this.pjD = ProxySelector.getDefault();
            this.pjE = p.peP;
            this.pjH = SocketFactory.getDefault();
            this.pjJ = com.bytedance.sdk.a.b.a.i.e.pgv;
            this.pjK = j.pgK;
            this.pjL = e.pgG;
            this.pjM = e.pgG;
            this.pjN = new m();
            this.pjO = r.pjj;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        a(z zVar) {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.pjB = zVar.pjl;
            this.f5986b = zVar.pjm;
            this.c = zVar.e;
            this.d = zVar.f;
            this.e.addAll(zVar.g);
            this.f.addAll(zVar.h);
            this.pjC = zVar.pjn;
            this.pjD = zVar.pjo;
            this.pjE = zVar.pjp;
            this.pjG = zVar.pjr;
            this.pjF = zVar.pjq;
            this.pjH = zVar.pjs;
            this.m = zVar.pjt;
            this.pjI = zVar.pju;
            this.pjJ = zVar.pjv;
            this.pjK = zVar.pjw;
            this.pjL = zVar.pjx;
            this.pjM = zVar.pjy;
            this.pjN = zVar.pjz;
            this.pjO = zVar.pjA;
            this.u = zVar.w;
            this.v = zVar.x;
            this.w = zVar.y;
            this.x = zVar.z;
            this.y = zVar.A;
            this.z = zVar.B;
            this.A = zVar.C;
        }

        public a d(long j, TimeUnit timeUnit) {
            this.x = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a e(long j, TimeUnit timeUnit) {
            this.y = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a f(long j, TimeUnit timeUnit) {
            this.z = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a c(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.m = sSLSocketFactory;
            this.pjI = com.bytedance.sdk.a.b.a.g.e.eng().b(sSLSocketFactory);
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.m = sSLSocketFactory;
            this.pjI = com.bytedance.sdk.a.b.a.i.c.a(x509TrustManager);
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.pjJ = hostnameVerifier;
            return this;
        }

        public a AJ(boolean z) {
            this.u = z;
            return this;
        }

        public a AK(boolean z) {
            this.v = z;
            return this;
        }

        public z enZ() {
            return new z(this);
        }
    }
}
