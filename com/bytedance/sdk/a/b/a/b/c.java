package com.bytedance.sdk.a.b.a.b;

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
/* loaded from: classes6.dex */
public final class c extends g.b implements l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3951a;
    public int b;
    public int c = 1;
    public final List<Reference<g>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final m pre;
    private final com.bytedance.sdk.a.b.d prf;
    private Socket prg;
    private Socket prh;
    private u pri;
    private w prj;
    private com.bytedance.sdk.a.b.a.e.g prk;
    private com.bytedance.sdk.a.a.e prl;
    private com.bytedance.sdk.a.a.d prm;

    public c(m mVar, com.bytedance.sdk.a.b.d dVar) {
        this.pre = mVar;
        this.prf = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
        if (r9.prf.d() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r9.prg != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        throw new com.bytedance.sdk.a.b.a.b.e(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0107, code lost:
        if (r9.prk == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
        r1 = r9.pre;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
        r9.c = r9.prk.a();
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
        if (this.prj != null) {
            throw new IllegalStateException("already connected");
        }
        List<n> f = this.prf.eqa().f();
        b bVar = new b(f);
        if (this.prf.eqa().epe() == null) {
            if (!f.contains(n.pwb)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String f2 = this.prf.eqa().eoY().f();
            if (!com.bytedance.sdk.a.b.a.g.e.epO().b(f2)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
            }
        }
        e eVar2 = null;
        while (true) {
            try {
                if (this.prf.d()) {
                    a(i, i2, i3, hVar, tVar);
                    if (this.prg == null) {
                        break;
                    }
                } else {
                    a(i, i2, hVar, tVar);
                }
                a(bVar, hVar, tVar);
                tVar.a(hVar, this.prf.eqc(), this.prf.eqb(), this.prj);
                break;
            } catch (IOException e) {
                com.bytedance.sdk.a.b.a.c.a(this.prh);
                com.bytedance.sdk.a.b.a.c.a(this.prg);
                this.prh = null;
                this.prg = null;
                this.prl = null;
                this.prm = null;
                this.pri = null;
                this.prj = null;
                this.prk = null;
                tVar.a(hVar, this.prf.eqc(), this.prf.eqb(), null, e);
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
        ab epk = epk();
        s eoY = epk.eoY();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, hVar, tVar);
            epk = a(i2, i3, epk, eoY);
            if (epk != null) {
                com.bytedance.sdk.a.b.a.c.a(this.prg);
                this.prg = null;
                this.prm = null;
                this.prl = null;
                tVar.a(hVar, this.prf.eqc(), this.prf.eqb(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i, int i2, h hVar, t tVar) throws IOException {
        Proxy eqb = this.prf.eqb();
        this.prg = (eqb.type() == Proxy.Type.DIRECT || eqb.type() == Proxy.Type.HTTP) ? this.prf.eqa().epa().createSocket() : new Socket(eqb);
        tVar.a(hVar, this.prf.eqc(), eqb);
        this.prg.setSoTimeout(i2);
        try {
            com.bytedance.sdk.a.b.a.g.e.epO().a(this.prg, this.prf.eqc(), i);
            try {
                this.prl = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.prg));
                this.prm = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.prg));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.prf.eqc());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, h hVar, t tVar) throws IOException {
        if (this.prf.eqa().epe() == null) {
            this.prj = w.HTTP_1_1;
            this.prh = this.prg;
            return;
        }
        tVar.b(hVar);
        a(bVar);
        tVar.a(hVar, this.pri);
        if (this.prj == w.HTTP_2) {
            this.prh.setSoTimeout(0);
            this.prk = new g.a(true).a(this.prh, this.prf.eqa().eoY().f(), this.prl, this.prm).a(this).epH();
            this.prk.c();
        }
    }

    private void a(b bVar) throws IOException {
        Throwable th;
        AssertionError e;
        SSLSocket sSLSocket;
        SSLSocket sSLSocket2 = null;
        com.bytedance.sdk.a.b.a eqa = this.prf.eqa();
        try {
            try {
                sSLSocket = (SSLSocket) eqa.epe().createSocket(this.prg, eqa.eoY().f(), eqa.eoY().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            n a2 = bVar.a(sSLSocket);
            if (a2.d()) {
                com.bytedance.sdk.a.b.a.g.e.epO().a(sSLSocket, eqa.eoY().f(), eqa.e());
            }
            sSLSocket.startHandshake();
            u a3 = u.a(sSLSocket.getSession());
            if (!eqa.epf().verify(eqa.eoY().f(), sSLSocket.getSession())) {
                X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + eqa.eoY().f() + " not verified:\n    certificate: " + j.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
            }
            eqa.epg().a(eqa.eoY().f(), a3.b());
            String c = a2.d() ? com.bytedance.sdk.a.b.a.g.e.epO().c(sSLSocket) : null;
            this.prh = sSLSocket;
            this.prl = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.prh));
            this.prm = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.prh));
            this.pri = a3;
            this.prj = c != null ? w.a(c) : w.HTTP_1_1;
            if (sSLSocket != null) {
                com.bytedance.sdk.a.b.a.g.e.epO().d(sSLSocket);
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
                com.bytedance.sdk.a.b.a.g.e.epO().d(sSLSocket2);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private ab a(int i, int i2, ab abVar, s sVar) throws IOException {
        com.bytedance.sdk.a.b.b epY;
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        do {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.prl, this.prm);
            this.prl.eoF().b(i, TimeUnit.MILLISECONDS);
            this.prm.eoF().b(i2, TimeUnit.MILLISECONDS);
            aVar.a(abVar.epE(), str);
            aVar.b();
            epY = aVar.AZ(false).f(abVar).epY();
            long d = com.bytedance.sdk.a.b.a.c.e.d(epY);
            if (d == -1) {
                d = 0;
            }
            com.bytedance.sdk.a.a.s ir = aVar.ir(d);
            com.bytedance.sdk.a.b.a.c.b(ir, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            ir.close();
            switch (epY.c()) {
                case 200:
                    if (this.prl.eoG().e() && this.prm.eoG().e()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    abVar = this.prf.eqa().epb().a(this.prf, epY);
                    if (abVar != null) {
                        break;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + epY.c());
            }
        } while (!"close".equalsIgnoreCase(epY.a(HTTP.CONN_DIRECTIVE)));
        return abVar;
    }

    private ab epk() {
        return new ab.a().f(this.prf.eqa().eoY()).ho("Host", com.bytedance.sdk.a.b.a.c.a(this.prf.eqa().eoY(), true)).ho("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).ho("User-Agent", com.bytedance.sdk.a.b.a.d.a()).eqQ();
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.d dVar) {
        if (this.d.size() >= this.c || this.f3951a || !com.bytedance.sdk.a.b.a.a.pqK.a(this.prf.eqa(), aVar)) {
            return false;
        }
        if (aVar.eoY().f().equals(epl().eqa().eoY().f())) {
            return true;
        }
        if (this.prk != null && dVar != null && dVar.eqb().type() == Proxy.Type.DIRECT && this.prf.eqb().type() == Proxy.Type.DIRECT && this.prf.eqc().equals(dVar.eqc()) && dVar.eqa().epf() == com.bytedance.sdk.a.b.a.i.e.ptu && a(aVar.eoY())) {
            try {
                aVar.epg().a(aVar.eoY().f(), epn().b());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.prf.eqa().eoY().g()) {
            return false;
        }
        if (sVar.f().equals(this.prf.eqa().eoY().f())) {
            return true;
        }
        return this.pri != null && com.bytedance.sdk.a.b.a.i.e.ptu.a(sVar.f(), (X509Certificate) this.pri.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, g gVar) throws SocketException {
        if (this.prk != null) {
            return new com.bytedance.sdk.a.b.a.e.f(zVar, aVar, gVar, this.prk);
        }
        this.prh.setSoTimeout(aVar.c());
        this.prl.eoF().b(aVar.c(), TimeUnit.MILLISECONDS);
        this.prm.eoF().b(aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(zVar, gVar, this.prl, this.prm);
    }

    @Override // com.bytedance.sdk.a.b.l
    public com.bytedance.sdk.a.b.d epl() {
        return this.prf;
    }

    public Socket epm() {
        return this.prh;
    }

    public boolean a(boolean z) {
        boolean z2 = true;
        if (this.prh.isClosed() || this.prh.isInputShutdown() || this.prh.isOutputShutdown()) {
            return false;
        }
        if (this.prk != null) {
            return !this.prk.d();
        } else if (z) {
            try {
                int soTimeout = this.prh.getSoTimeout();
                this.prh.setSoTimeout(1);
                if (this.prl.e()) {
                    this.prh.setSoTimeout(soTimeout);
                    z2 = false;
                } else {
                    this.prh.setSoTimeout(soTimeout);
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
        synchronized (this.pre) {
            this.c = gVar.a();
        }
    }

    public u epn() {
        return this.pri;
    }

    public boolean d() {
        return this.prk != null;
    }

    public String toString() {
        return "Connection{" + this.prf.eqa().eoY().f() + ":" + this.prf.eqa().eoY().g() + ", proxy=" + this.prf.eqb() + " hostAddress=" + this.prf.eqc() + " cipherSuite=" + (this.pri != null ? this.pri.eqi() : "none") + " protocol=" + this.prj + '}';
    }
}
