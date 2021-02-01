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
/* loaded from: classes6.dex */
public class z implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final List<w> f5986a = com.bytedance.sdk.a.b.a.c.P(w.HTTP_2, w.HTTP_1_1);

    /* renamed from: b  reason: collision with root package name */
    static final List<n> f5987b = com.bytedance.sdk.a.b.a.c.P(n.ptu, n.ptw);
    final int A;
    final int B;
    final int C;
    final List<w> e;
    final List<n> f;
    final List<x> g;
    final List<x> h;
    final q ptC;
    final Proxy ptD;
    final t.a ptE;
    final ProxySelector ptF;
    final p ptG;
    final f ptH;
    final com.bytedance.sdk.a.b.a.a.e ptI;
    final SocketFactory ptJ;
    final SSLSocketFactory ptK;
    final com.bytedance.sdk.a.b.a.i.c ptL;
    final HostnameVerifier ptM;
    final j ptN;
    final e ptO;
    final e ptP;
    final m ptQ;
    final r ptR;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.bytedance.sdk.a.b.a.a.poa = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str) {
                aVar.YE(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str, String str2) {
                aVar.hk(str, str2);
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
                return mVar.ptq;
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
        this.ptC = aVar.ptS;
        this.ptD = aVar.f5988b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = com.bytedance.sdk.a.b.a.c.a(aVar.e);
        this.h = com.bytedance.sdk.a.b.a.c.a(aVar.f);
        this.ptE = aVar.ptT;
        this.ptF = aVar.ptU;
        this.ptG = aVar.ptV;
        this.ptH = aVar.ptW;
        this.ptI = aVar.ptX;
        this.ptJ = aVar.ptY;
        boolean z = false;
        for (n nVar : this.f) {
            z = z || nVar.a();
        }
        if (aVar.m != null || !z) {
            this.ptK = aVar.m;
            this.ptL = aVar.ptZ;
        } else {
            X509TrustManager eqc = eqc();
            this.ptK = c(eqc);
            this.ptL = com.bytedance.sdk.a.b.a.i.c.a(eqc);
        }
        this.ptM = aVar.pua;
        this.ptN = aVar.pub.a(this.ptL);
        this.ptO = aVar.puc;
        this.ptP = aVar.pud;
        this.ptQ = aVar.pue;
        this.ptR = aVar.puf;
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

    private X509TrustManager eqc() {
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

    public Proxy epa() {
        return this.ptD;
    }

    public ProxySelector eqd() {
        return this.ptF;
    }

    public p eqe() {
        return this.ptG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.a.e eqf() {
        return this.ptH != null ? this.ptH.pob : this.ptI;
    }

    public r eqg() {
        return this.ptR;
    }

    public SocketFactory eqh() {
        return this.ptJ;
    }

    public SSLSocketFactory eqi() {
        return this.ptK;
    }

    public HostnameVerifier eqj() {
        return this.ptM;
    }

    public j eqk() {
        return this.ptN;
    }

    public e eql() {
        return this.ptP;
    }

    public e eqm() {
        return this.ptO;
    }

    public m eqn() {
        return this.ptQ;
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

    public q eqo() {
        return this.ptC;
    }

    public List<w> t() {
        return this.e;
    }

    public List<n> u() {
        return this.f;
    }

    public List<x> eqp() {
        return this.g;
    }

    public List<x> w() {
        return this.h;
    }

    public t.a eqq() {
        return this.ptE;
    }

    public h g(ab abVar) {
        return aa.a(this, abVar, false);
    }

    public a eqr() {
        return new a(this);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        int A;

        /* renamed from: b  reason: collision with root package name */
        Proxy f5988b;
        List<w> c;
        List<n> d;
        final List<x> e;
        final List<x> f;
        SSLSocketFactory m;
        q ptS;
        t.a ptT;
        ProxySelector ptU;
        p ptV;
        f ptW;
        com.bytedance.sdk.a.b.a.a.e ptX;
        SocketFactory ptY;
        com.bytedance.sdk.a.b.a.i.c ptZ;
        HostnameVerifier pua;
        j pub;
        e puc;
        e pud;
        m pue;
        r puf;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.ptS = new q();
            this.c = z.f5986a;
            this.d = z.f5987b;
            this.ptT = t.a(t.ptB);
            this.ptU = ProxySelector.getDefault();
            this.ptV = p.ppg;
            this.ptY = SocketFactory.getDefault();
            this.pua = com.bytedance.sdk.a.b.a.i.e.pqO;
            this.pub = j.prd;
            this.puc = e.pqZ;
            this.pud = e.pqZ;
            this.pue = new m();
            this.puf = r.ptA;
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
            this.ptS = zVar.ptC;
            this.f5988b = zVar.ptD;
            this.c = zVar.e;
            this.d = zVar.f;
            this.e.addAll(zVar.g);
            this.f.addAll(zVar.h);
            this.ptT = zVar.ptE;
            this.ptU = zVar.ptF;
            this.ptV = zVar.ptG;
            this.ptX = zVar.ptI;
            this.ptW = zVar.ptH;
            this.ptY = zVar.ptJ;
            this.m = zVar.ptK;
            this.ptZ = zVar.ptL;
            this.pua = zVar.ptM;
            this.pub = zVar.ptN;
            this.puc = zVar.ptO;
            this.pud = zVar.ptP;
            this.pue = zVar.ptQ;
            this.puf = zVar.ptR;
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
            this.ptZ = com.bytedance.sdk.a.b.a.g.e.epz().b(sSLSocketFactory);
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
            this.ptZ = com.bytedance.sdk.a.b.a.i.c.a(x509TrustManager);
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.pua = hostnameVerifier;
            return this;
        }

        public a Bc(boolean z) {
            this.u = z;
            return this;
        }

        public a Bd(boolean z) {
            this.v = z;
            return this;
        }

        public z eqs() {
            return new z(this);
        }
    }
}
