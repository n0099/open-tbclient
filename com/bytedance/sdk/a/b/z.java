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
    static final List<w> f6283a = com.bytedance.sdk.a.b.a.c.P(w.HTTP_2, w.HTTP_1_1);

    /* renamed from: b  reason: collision with root package name */
    static final List<n> f6284b = com.bytedance.sdk.a.b.a.c.P(n.pnG, n.pnI);
    final int A;
    final int B;
    final int C;
    final List<w> e;
    final List<n> f;
    final List<x> g;
    final List<x> h;
    final q pnO;
    final Proxy pnP;
    final t.a pnQ;
    final ProxySelector pnR;
    final p pnS;
    final f pnT;
    final com.bytedance.sdk.a.b.a.a.e pnU;
    final SocketFactory pnV;
    final SSLSocketFactory pnW;
    final com.bytedance.sdk.a.b.a.i.c pnX;
    final HostnameVerifier pnY;
    final j pnZ;
    final e poa;
    final e pob;
    final m poc;
    final r pod;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.bytedance.sdk.a.b.a.a.pir = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str) {
                aVar.YL(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str, String str2) {
                aVar.he(str, str2);
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
                return mVar.pnD;
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
        this.pnO = aVar.poe;
        this.pnP = aVar.f6285b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = com.bytedance.sdk.a.b.a.c.a(aVar.e);
        this.h = com.bytedance.sdk.a.b.a.c.a(aVar.f);
        this.pnQ = aVar.pof;
        this.pnR = aVar.pog;
        this.pnS = aVar.poh;
        this.pnT = aVar.poj;
        this.pnU = aVar.pok;
        this.pnV = aVar.pol;
        boolean z = false;
        for (n nVar : this.f) {
            z = z || nVar.a();
        }
        if (aVar.m != null || !z) {
            this.pnW = aVar.m;
            this.pnX = aVar.pom;
        } else {
            X509TrustManager erD = erD();
            this.pnW = c(erD);
            this.pnX = com.bytedance.sdk.a.b.a.i.c.a(erD);
        }
        this.pnY = aVar.pon;
        this.pnZ = aVar.poo.a(this.pnX);
        this.poa = aVar.poq;
        this.pob = aVar.por;
        this.poc = aVar.pot;
        this.pod = aVar.pou;
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

    private X509TrustManager erD() {
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

    public Proxy eqB() {
        return this.pnP;
    }

    public ProxySelector erE() {
        return this.pnR;
    }

    public p erF() {
        return this.pnS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.a.e erG() {
        return this.pnT != null ? this.pnT.pis : this.pnU;
    }

    public r erH() {
        return this.pod;
    }

    public SocketFactory erI() {
        return this.pnV;
    }

    public SSLSocketFactory erJ() {
        return this.pnW;
    }

    public HostnameVerifier erK() {
        return this.pnY;
    }

    public j erL() {
        return this.pnZ;
    }

    public e erM() {
        return this.pob;
    }

    public e erN() {
        return this.poa;
    }

    public m erO() {
        return this.poc;
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

    public q erP() {
        return this.pnO;
    }

    public List<w> t() {
        return this.e;
    }

    public List<n> u() {
        return this.f;
    }

    public List<x> erQ() {
        return this.g;
    }

    public List<x> w() {
        return this.h;
    }

    public t.a erR() {
        return this.pnQ;
    }

    public h g(ab abVar) {
        return aa.a(this, abVar, false);
    }

    public a erS() {
        return new a(this);
    }

    /* loaded from: classes4.dex */
    public static final class a {
        int A;

        /* renamed from: b  reason: collision with root package name */
        Proxy f6285b;
        List<w> c;
        List<n> d;
        final List<x> e;
        final List<x> f;
        SSLSocketFactory m;
        q poe;
        t.a pof;
        ProxySelector pog;
        p poh;
        f poj;
        com.bytedance.sdk.a.b.a.a.e pok;
        SocketFactory pol;
        com.bytedance.sdk.a.b.a.i.c pom;
        HostnameVerifier pon;
        j poo;
        e poq;
        e por;
        m pot;
        r pou;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.poe = new q();
            this.c = z.f6283a;
            this.d = z.f6284b;
            this.pof = t.a(t.pnN);
            this.pog = ProxySelector.getDefault();
            this.poh = p.pju;
            this.pol = SocketFactory.getDefault();
            this.pon = com.bytedance.sdk.a.b.a.i.e.plb;
            this.poo = j.plq;
            this.poq = e.plm;
            this.por = e.plm;
            this.pot = new m();
            this.pou = r.pnM;
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
            this.poe = zVar.pnO;
            this.f6285b = zVar.pnP;
            this.c = zVar.e;
            this.d = zVar.f;
            this.e.addAll(zVar.g);
            this.f.addAll(zVar.h);
            this.pof = zVar.pnQ;
            this.pog = zVar.pnR;
            this.poh = zVar.pnS;
            this.pok = zVar.pnU;
            this.poj = zVar.pnT;
            this.pol = zVar.pnV;
            this.m = zVar.pnW;
            this.pom = zVar.pnX;
            this.pon = zVar.pnY;
            this.poo = zVar.pnZ;
            this.poq = zVar.poa;
            this.por = zVar.pob;
            this.pot = zVar.poc;
            this.pou = zVar.pod;
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
            this.pom = com.bytedance.sdk.a.b.a.g.e.era().b(sSLSocketFactory);
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
            this.pom = com.bytedance.sdk.a.b.a.i.c.a(x509TrustManager);
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.pon = hostnameVerifier;
            return this;
        }

        public a AN(boolean z) {
            this.u = z;
            return this;
        }

        public a AO(boolean z) {
            this.v = z;
            return this;
        }

        public z erT() {
            return new z(this);
        }
    }
}
