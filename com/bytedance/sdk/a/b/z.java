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
    static final List<w> f4016a = com.bytedance.sdk.a.b.a.c.O(w.HTTP_2, w.HTTP_1_1);
    static final List<n> b = com.bytedance.sdk.a.b.a.c.O(n.pvZ, n.pwb);
    final int A;
    final int B;
    final int C;
    final List<w> e;
    final List<n> f;
    final List<x> g;
    final List<x> h;
    final q pwh;
    final Proxy pwi;
    final t.a pwj;
    final ProxySelector pwk;
    final p pwl;
    final f pwm;
    final com.bytedance.sdk.a.b.a.a.e pwn;
    final SocketFactory pwo;
    final SSLSocketFactory pwp;
    final com.bytedance.sdk.a.b.a.i.c pwq;
    final HostnameVerifier pwr;
    final j pws;
    final e pwt;
    final e pwu;
    final m pwv;
    final r pww;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        com.bytedance.sdk.a.b.a.a.pqK = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(v.a aVar, String str) {
                aVar.YX(str);
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
                return mVar.pvW;
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
        this.pwh = aVar.pwx;
        this.pwi = aVar.b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = com.bytedance.sdk.a.b.a.c.a(aVar.e);
        this.h = com.bytedance.sdk.a.b.a.c.a(aVar.f);
        this.pwj = aVar.pwy;
        this.pwk = aVar.pwz;
        this.pwl = aVar.pwA;
        this.pwm = aVar.pwB;
        this.pwn = aVar.pwC;
        this.pwo = aVar.pwD;
        boolean z = false;
        for (n nVar : this.f) {
            z = z || nVar.a();
        }
        if (aVar.m != null || !z) {
            this.pwp = aVar.m;
            this.pwq = aVar.pwE;
        } else {
            X509TrustManager eqr = eqr();
            this.pwp = c(eqr);
            this.pwq = com.bytedance.sdk.a.b.a.i.c.a(eqr);
        }
        this.pwr = aVar.pwF;
        this.pws = aVar.pwG.a(this.pwq);
        this.pwt = aVar.pwH;
        this.pwu = aVar.pwI;
        this.pwv = aVar.pwJ;
        this.pww = aVar.pwK;
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

    private X509TrustManager eqr() {
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

    public Proxy epp() {
        return this.pwi;
    }

    public ProxySelector eqs() {
        return this.pwk;
    }

    public p eqt() {
        return this.pwl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.a.e equ() {
        return this.pwm != null ? this.pwm.pqL : this.pwn;
    }

    public r eqv() {
        return this.pww;
    }

    public SocketFactory eqw() {
        return this.pwo;
    }

    public SSLSocketFactory eqx() {
        return this.pwp;
    }

    public HostnameVerifier eqy() {
        return this.pwr;
    }

    public j eqz() {
        return this.pws;
    }

    public e eqA() {
        return this.pwu;
    }

    public e eqB() {
        return this.pwt;
    }

    public m eqC() {
        return this.pwv;
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

    public q eqD() {
        return this.pwh;
    }

    public List<w> t() {
        return this.e;
    }

    public List<n> u() {
        return this.f;
    }

    public List<x> eqE() {
        return this.g;
    }

    public List<x> w() {
        return this.h;
    }

    public t.a eqF() {
        return this.pwj;
    }

    public h g(ab abVar) {
        return aa.a(this, abVar, false);
    }

    public a eqG() {
        return new a(this);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        int A;
        Proxy b;
        List<w> c;
        List<n> d;
        final List<x> e;
        final List<x> f;
        SSLSocketFactory m;
        p pwA;
        f pwB;
        com.bytedance.sdk.a.b.a.a.e pwC;
        SocketFactory pwD;
        com.bytedance.sdk.a.b.a.i.c pwE;
        HostnameVerifier pwF;
        j pwG;
        e pwH;
        e pwI;
        m pwJ;
        r pwK;
        q pwx;
        t.a pwy;
        ProxySelector pwz;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.pwx = new q();
            this.c = z.f4016a;
            this.d = z.b;
            this.pwy = t.a(t.pwg);
            this.pwz = ProxySelector.getDefault();
            this.pwA = p.prN;
            this.pwD = SocketFactory.getDefault();
            this.pwF = com.bytedance.sdk.a.b.a.i.e.ptu;
            this.pwG = j.ptJ;
            this.pwH = e.ptF;
            this.pwI = e.ptF;
            this.pwJ = new m();
            this.pwK = r.pwf;
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
            this.pwx = zVar.pwh;
            this.b = zVar.pwi;
            this.c = zVar.e;
            this.d = zVar.f;
            this.e.addAll(zVar.g);
            this.f.addAll(zVar.h);
            this.pwy = zVar.pwj;
            this.pwz = zVar.pwk;
            this.pwA = zVar.pwl;
            this.pwC = zVar.pwn;
            this.pwB = zVar.pwm;
            this.pwD = zVar.pwo;
            this.m = zVar.pwp;
            this.pwE = zVar.pwq;
            this.pwF = zVar.pwr;
            this.pwG = zVar.pws;
            this.pwH = zVar.pwt;
            this.pwI = zVar.pwu;
            this.pwJ = zVar.pwv;
            this.pwK = zVar.pww;
            this.u = zVar.w;
            this.v = zVar.x;
            this.w = zVar.y;
            this.x = zVar.z;
            this.y = zVar.A;
            this.z = zVar.B;
            this.A = zVar.C;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.x = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a d(long j, TimeUnit timeUnit) {
            this.y = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a e(long j, TimeUnit timeUnit) {
            this.z = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a Bb(boolean z) {
            this.u = z;
            return this;
        }

        public a Bc(boolean z) {
            this.v = z;
            return this;
        }

        public z eqH() {
            return new z(this);
        }
    }
}
