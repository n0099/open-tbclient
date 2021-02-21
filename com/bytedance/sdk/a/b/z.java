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
    static final List<n> f5987b = com.bytedance.sdk.a.b.a.c.P(n.ptU, n.ptW);
    final int A;
    final int B;
    final int C;
    final List<w> e;
    final List<n> f;
    final List<x> g;
    final List<x> h;
    final q puc;
    final Proxy pud;
    final t.a pue;
    final ProxySelector puf;
    final p pug;
    final f puh;
    final com.bytedance.sdk.a.b.a.a.e pui;
    final SocketFactory puj;
    final SSLSocketFactory puk;
    final com.bytedance.sdk.a.b.a.i.c pul;
    final HostnameVerifier pum;
    final j pun;
    final e puo;
    final e pup;
    final m puq;
    final r pur;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.bytedance.sdk.a.b.a.a.poD = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str) {
                aVar.YQ(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str, String str2) {
                aVar.hm(str, str2);
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
                return mVar.ptR;
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
        this.puc = aVar.pus;
        this.pud = aVar.f5988b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = com.bytedance.sdk.a.b.a.c.a(aVar.e);
        this.h = com.bytedance.sdk.a.b.a.c.a(aVar.f);
        this.pue = aVar.put;
        this.puf = aVar.puu;
        this.pug = aVar.puv;
        this.puh = aVar.puw;
        this.pui = aVar.pux;
        this.puj = aVar.puy;
        boolean z = false;
        for (n nVar : this.f) {
            z = z || nVar.a();
        }
        if (aVar.m != null || !z) {
            this.puk = aVar.m;
            this.pul = aVar.puz;
        } else {
            X509TrustManager eqk = eqk();
            this.puk = c(eqk);
            this.pul = com.bytedance.sdk.a.b.a.i.c.a(eqk);
        }
        this.pum = aVar.puA;
        this.pun = aVar.puB.a(this.pul);
        this.puo = aVar.puC;
        this.pup = aVar.puD;
        this.puq = aVar.puE;
        this.pur = aVar.puF;
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

    private X509TrustManager eqk() {
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

    public Proxy epi() {
        return this.pud;
    }

    public ProxySelector eql() {
        return this.puf;
    }

    public p eqm() {
        return this.pug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.a.e eqn() {
        return this.puh != null ? this.puh.poE : this.pui;
    }

    public r eqo() {
        return this.pur;
    }

    public SocketFactory eqp() {
        return this.puj;
    }

    public SSLSocketFactory eqq() {
        return this.puk;
    }

    public HostnameVerifier eqr() {
        return this.pum;
    }

    public j eqs() {
        return this.pun;
    }

    public e eqt() {
        return this.pup;
    }

    public e equ() {
        return this.puo;
    }

    public m eqv() {
        return this.puq;
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

    public q eqw() {
        return this.puc;
    }

    public List<w> t() {
        return this.e;
    }

    public List<n> u() {
        return this.f;
    }

    public List<x> eqx() {
        return this.g;
    }

    public List<x> w() {
        return this.h;
    }

    public t.a eqy() {
        return this.pue;
    }

    public h g(ab abVar) {
        return aa.a(this, abVar, false);
    }

    public a eqz() {
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
        HostnameVerifier puA;
        j puB;
        e puC;
        e puD;
        m puE;
        r puF;
        q pus;
        t.a put;
        ProxySelector puu;
        p puv;
        f puw;
        com.bytedance.sdk.a.b.a.a.e pux;
        SocketFactory puy;
        com.bytedance.sdk.a.b.a.i.c puz;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.pus = new q();
            this.c = z.f5986a;
            this.d = z.f5987b;
            this.put = t.a(t.pub);
            this.puu = ProxySelector.getDefault();
            this.puv = p.ppI;
            this.puy = SocketFactory.getDefault();
            this.puA = com.bytedance.sdk.a.b.a.i.e.pro;
            this.puB = j.prD;
            this.puC = e.prz;
            this.puD = e.prz;
            this.puE = new m();
            this.puF = r.pua;
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
            this.pus = zVar.puc;
            this.f5988b = zVar.pud;
            this.c = zVar.e;
            this.d = zVar.f;
            this.e.addAll(zVar.g);
            this.f.addAll(zVar.h);
            this.put = zVar.pue;
            this.puu = zVar.puf;
            this.puv = zVar.pug;
            this.pux = zVar.pui;
            this.puw = zVar.puh;
            this.puy = zVar.puj;
            this.m = zVar.puk;
            this.puz = zVar.pul;
            this.puA = zVar.pum;
            this.puB = zVar.pun;
            this.puC = zVar.puo;
            this.puD = zVar.pup;
            this.puE = zVar.puq;
            this.puF = zVar.pur;
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
            this.puz = com.bytedance.sdk.a.b.a.g.e.epH().b(sSLSocketFactory);
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
            this.puz = com.bytedance.sdk.a.b.a.i.c.a(x509TrustManager);
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.puA = hostnameVerifier;
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

        public z eqA() {
            return new z(this);
        }
    }
}
