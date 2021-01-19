package com.bytedance.sdk.a.b.a.b;

import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.sdk.a.b.a.e.g;
import com.bytedance.sdk.a.b.a.e.i;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.h;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.l;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.n;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.x;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public final class c extends g.b implements l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5862a;

    /* renamed from: b  reason: collision with root package name */
    public int f5863b;
    public int c = 1;
    public final List<Reference<g>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final m peh;
    private final com.bytedance.sdk.a.b.d pei;
    private Socket pej;
    private Socket pek;
    private u pel;
    private w pem;
    private com.bytedance.sdk.a.b.a.e.g pen;
    private com.bytedance.sdk.a.a.e peo;
    private com.bytedance.sdk.a.a.d pep;

    public c(m mVar, com.bytedance.sdk.a.b.d dVar) {
        this.peh = mVar;
        this.pei = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
        if (r9.pei.d() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r9.pej != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        throw new com.bytedance.sdk.a.b.a.b.e(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0107, code lost:
        if (r9.pen == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
        r1 = r9.peh;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
        r9.c = r9.pen.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0114, code lost:
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0115, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, int i3, boolean z, h hVar, t tVar) {
        e eVar;
        if (this.pem != null) {
            throw new IllegalStateException("already connected");
        }
        List<n> f = this.pei.ens().f();
        b bVar = new b(f);
        if (this.pei.ens().emv() == null) {
            if (!f.contains(n.pjg)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String f2 = this.pei.ens().emp().f();
            if (!com.bytedance.sdk.a.b.a.g.e.eng().b(f2)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
            }
        }
        e eVar2 = null;
        while (true) {
            try {
                if (this.pei.d()) {
                    a(i, i2, i3, hVar, tVar);
                    if (this.pej == null) {
                        break;
                    }
                } else {
                    a(i, i2, hVar, tVar);
                }
                a(bVar, hVar, tVar);
                tVar.a(hVar, this.pei.enu(), this.pei.ent(), this.pem);
                break;
            } catch (IOException e) {
                com.bytedance.sdk.a.b.a.c.a(this.pek);
                com.bytedance.sdk.a.b.a.c.a(this.pej);
                this.pek = null;
                this.pej = null;
                this.peo = null;
                this.pep = null;
                this.pel = null;
                this.pem = null;
                this.pen = null;
                tVar.a(hVar, this.pei.enu(), this.pei.ent(), null, e);
                if (eVar2 == null) {
                    eVar = new e(e);
                } else {
                    eVar2.a(e);
                    eVar = eVar2;
                }
                if (!z || !bVar.g(e)) {
                    throw eVar;
                }
                eVar2 = eVar;
            }
        }
        throw eVar;
    }

    private void a(int i, int i2, int i3, h hVar, t tVar) throws IOException {
        ab emB = emB();
        s emp = emB.emp();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, hVar, tVar);
            emB = a(i2, i3, emB, emp);
            if (emB != null) {
                com.bytedance.sdk.a.b.a.c.a(this.pej);
                this.pej = null;
                this.pep = null;
                this.peo = null;
                tVar.a(hVar, this.pei.enu(), this.pei.ent(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i, int i2, h hVar, t tVar) throws IOException {
        Proxy ent = this.pei.ent();
        this.pej = (ent.type() == Proxy.Type.DIRECT || ent.type() == Proxy.Type.HTTP) ? this.pei.ens().emr().createSocket() : new Socket(ent);
        tVar.a(hVar, this.pei.enu(), ent);
        this.pej.setSoTimeout(i2);
        try {
            com.bytedance.sdk.a.b.a.g.e.eng().a(this.pej, this.pei.enu(), i);
            try {
                this.peo = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.pej));
                this.pep = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.pej));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.pei.enu());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, h hVar, t tVar) throws IOException {
        if (this.pei.ens().emv() == null) {
            this.pem = w.HTTP_1_1;
            this.pek = this.pej;
            return;
        }
        tVar.b(hVar);
        a(bVar);
        tVar.a(hVar, this.pel);
        if (this.pem == w.HTTP_2) {
            this.pek.setSoTimeout(0);
            this.pen = new g.a(true).a(this.pek, this.pei.ens().emp().f(), this.peo, this.pep).a(this).emY();
            this.pen.c();
        }
    }

    private void a(b bVar) throws IOException {
        Throwable th;
        AssertionError e;
        SSLSocket sSLSocket;
        SSLSocket sSLSocket2 = null;
        com.bytedance.sdk.a.b.a ens = this.pei.ens();
        try {
            try {
                sSLSocket = (SSLSocket) ens.emv().createSocket(this.pej, ens.emp().f(), ens.emp().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            n a2 = bVar.a(sSLSocket);
            if (a2.d()) {
                com.bytedance.sdk.a.b.a.g.e.eng().a(sSLSocket, ens.emp().f(), ens.e());
            }
            sSLSocket.startHandshake();
            u a3 = u.a(sSLSocket.getSession());
            if (!ens.emw().verify(ens.emp().f(), sSLSocket.getSession())) {
                X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + ens.emp().f() + " not verified:\n    certificate: " + j.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
            }
            ens.emx().a(ens.emp().f(), a3.b());
            String c = a2.d() ? com.bytedance.sdk.a.b.a.g.e.eng().c(sSLSocket) : null;
            this.pek = sSLSocket;
            this.peo = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.pek));
            this.pep = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.pek));
            this.pel = a3;
            this.pem = c != null ? w.a(c) : w.HTTP_1_1;
            if (sSLSocket != null) {
                com.bytedance.sdk.a.b.a.g.e.eng().d(sSLSocket);
            }
        } catch (AssertionError e3) {
            e = e3;
            if (!com.bytedance.sdk.a.b.a.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th3) {
            th = th3;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                com.bytedance.sdk.a.b.a.g.e.eng().d(sSLSocket2);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private ab a(int i, int i2, ab abVar, s sVar) throws IOException {
        com.bytedance.sdk.a.b.b enq;
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        do {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.peo, this.pep);
            this.peo.elW().c(i, TimeUnit.MILLISECONDS);
            this.pep.elW().c(i2, TimeUnit.MILLISECONDS);
            aVar.a(abVar.emV(), str);
            aVar.b();
            enq = aVar.AH(false).f(abVar).enq();
            long d = com.bytedance.sdk.a.b.a.c.e.d(enq);
            if (d == -1) {
                d = 0;
            }
            com.bytedance.sdk.a.a.s io2 = aVar.io(d);
            com.bytedance.sdk.a.b.a.c.b(io2, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            io2.close();
            switch (enq.c()) {
                case 200:
                    if (this.peo.elX().e() && this.pep.elX().e()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    abVar = this.pei.ens().ems().a(this.pei, enq);
                    if (abVar != null) {
                        break;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + enq.c());
            }
        } while (!"close".equalsIgnoreCase(enq.a(HTTP.CONN_DIRECTIVE)));
        return abVar;
    }

    private ab emB() {
        return new ab.a().f(this.pei.ens().emp()).hf("Host", com.bytedance.sdk.a.b.a.c.a(this.pei.ens().emp(), true)).hf("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).hf("User-Agent", com.bytedance.sdk.a.b.a.d.a()).eoj();
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.d dVar) {
        if (this.d.size() >= this.c || this.f5862a || !com.bytedance.sdk.a.b.a.a.pdN.a(this.pei.ens(), aVar)) {
            return false;
        }
        if (aVar.emp().f().equals(emC().ens().emp().f())) {
            return true;
        }
        if (this.pen != null && dVar != null && dVar.ent().type() == Proxy.Type.DIRECT && this.pei.ent().type() == Proxy.Type.DIRECT && this.pei.enu().equals(dVar.enu()) && dVar.ens().emw() == com.bytedance.sdk.a.b.a.i.e.pgw && a(aVar.emp())) {
            try {
                aVar.emx().a(aVar.emp().f(), emE().b());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.pei.ens().emp().g()) {
            return false;
        }
        if (sVar.f().equals(this.pei.ens().emp().f())) {
            return true;
        }
        return this.pel != null && com.bytedance.sdk.a.b.a.i.e.pgw.a(sVar.f(), (X509Certificate) this.pel.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, g gVar) throws SocketException {
        if (this.pen != null) {
            return new com.bytedance.sdk.a.b.a.e.f(zVar, aVar, gVar, this.pen);
        }
        this.pek.setSoTimeout(aVar.c());
        this.peo.elW().c(aVar.c(), TimeUnit.MILLISECONDS);
        this.pep.elW().c(aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(zVar, gVar, this.peo, this.pep);
    }

    @Override // com.bytedance.sdk.a.b.l
    public com.bytedance.sdk.a.b.d emC() {
        return this.pei;
    }

    public Socket emD() {
        return this.pek;
    }

    public boolean a(boolean z) {
        boolean z2 = true;
        if (this.pek.isClosed() || this.pek.isInputShutdown() || this.pek.isOutputShutdown()) {
            return false;
        }
        if (this.pen != null) {
            return !this.pen.d();
        } else if (z) {
            try {
                int soTimeout = this.pek.getSoTimeout();
                this.pek.setSoTimeout(1);
                if (this.peo.e()) {
                    this.pek.setSoTimeout(soTimeout);
                    z2 = false;
                } else {
                    this.pek.setSoTimeout(soTimeout);
                }
                return z2;
            } catch (SocketTimeoutException e) {
                return z2;
            } catch (IOException e2) {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(i iVar) throws IOException {
        iVar.a(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(com.bytedance.sdk.a.b.a.e.g gVar) {
        synchronized (this.peh) {
            this.c = gVar.a();
        }
    }

    public u emE() {
        return this.pel;
    }

    public boolean d() {
        return this.pen != null;
    }

    public String toString() {
        return "Connection{" + this.pei.ens().emp().f() + ":" + this.pei.ens().emp().g() + ", proxy=" + this.pei.ent() + " hostAddress=" + this.pei.enu() + " cipherSuite=" + (this.pel != null ? this.pel.enA() : "none") + " protocol=" + this.pem + '}';
    }
}
