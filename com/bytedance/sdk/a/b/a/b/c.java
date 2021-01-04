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
    public boolean f6161a;

    /* renamed from: b  reason: collision with root package name */
    public int f6162b;
    public int c = 1;
    public final List<Reference<g>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final m piL;
    private final com.bytedance.sdk.a.b.d piM;
    private Socket piN;
    private Socket piO;
    private u piP;
    private w piQ;
    private com.bytedance.sdk.a.b.a.e.g piR;
    private com.bytedance.sdk.a.a.e piS;
    private com.bytedance.sdk.a.a.d piT;

    public c(m mVar, com.bytedance.sdk.a.b.d dVar) {
        this.piL = mVar;
        this.piM = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
        if (r9.piM.d() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r9.piN != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        throw new com.bytedance.sdk.a.b.a.b.e(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0107, code lost:
        if (r9.piR == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
        r1 = r9.piL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
        r9.c = r9.piR.a();
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
        if (this.piQ != null) {
            throw new IllegalStateException("already connected");
        }
        List<n> f = this.piM.erm().f();
        b bVar = new b(f);
        if (this.piM.erm().eqq() == null) {
            if (!f.contains(n.pnI)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String f2 = this.piM.erm().eqk().f();
            if (!com.bytedance.sdk.a.b.a.g.e.era().b(f2)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
            }
        }
        e eVar2 = null;
        while (true) {
            try {
                if (this.piM.d()) {
                    a(i, i2, i3, hVar, tVar);
                    if (this.piN == null) {
                        break;
                    }
                } else {
                    a(i, i2, hVar, tVar);
                }
                a(bVar, hVar, tVar);
                tVar.a(hVar, this.piM.ero(), this.piM.ern(), this.piQ);
                break;
            } catch (IOException e) {
                com.bytedance.sdk.a.b.a.c.a(this.piO);
                com.bytedance.sdk.a.b.a.c.a(this.piN);
                this.piO = null;
                this.piN = null;
                this.piS = null;
                this.piT = null;
                this.piP = null;
                this.piQ = null;
                this.piR = null;
                tVar.a(hVar, this.piM.ero(), this.piM.ern(), null, e);
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
        ab eqw = eqw();
        s eqk = eqw.eqk();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, hVar, tVar);
            eqw = a(i2, i3, eqw, eqk);
            if (eqw != null) {
                com.bytedance.sdk.a.b.a.c.a(this.piN);
                this.piN = null;
                this.piT = null;
                this.piS = null;
                tVar.a(hVar, this.piM.ero(), this.piM.ern(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i, int i2, h hVar, t tVar) throws IOException {
        Proxy ern = this.piM.ern();
        this.piN = (ern.type() == Proxy.Type.DIRECT || ern.type() == Proxy.Type.HTTP) ? this.piM.erm().eqm().createSocket() : new Socket(ern);
        tVar.a(hVar, this.piM.ero(), ern);
        this.piN.setSoTimeout(i2);
        try {
            com.bytedance.sdk.a.b.a.g.e.era().a(this.piN, this.piM.ero(), i);
            try {
                this.piS = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.piN));
                this.piT = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.piN));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.piM.ero());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, h hVar, t tVar) throws IOException {
        if (this.piM.erm().eqq() == null) {
            this.piQ = w.HTTP_1_1;
            this.piO = this.piN;
            return;
        }
        tVar.b(hVar);
        a(bVar);
        tVar.a(hVar, this.piP);
        if (this.piQ == w.HTTP_2) {
            this.piO.setSoTimeout(0);
            this.piR = new g.a(true).a(this.piO, this.piM.erm().eqk().f(), this.piS, this.piT).a(this).eqT();
            this.piR.c();
        }
    }

    private void a(b bVar) throws IOException {
        Throwable th;
        AssertionError e;
        SSLSocket sSLSocket;
        SSLSocket sSLSocket2 = null;
        com.bytedance.sdk.a.b.a erm = this.piM.erm();
        try {
            try {
                sSLSocket = (SSLSocket) erm.eqq().createSocket(this.piN, erm.eqk().f(), erm.eqk().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            n a2 = bVar.a(sSLSocket);
            if (a2.d()) {
                com.bytedance.sdk.a.b.a.g.e.era().a(sSLSocket, erm.eqk().f(), erm.e());
            }
            sSLSocket.startHandshake();
            u a3 = u.a(sSLSocket.getSession());
            if (!erm.eqr().verify(erm.eqk().f(), sSLSocket.getSession())) {
                X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + erm.eqk().f() + " not verified:\n    certificate: " + j.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
            }
            erm.eqs().a(erm.eqk().f(), a3.b());
            String c = a2.d() ? com.bytedance.sdk.a.b.a.g.e.era().c(sSLSocket) : null;
            this.piO = sSLSocket;
            this.piS = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.piO));
            this.piT = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.piO));
            this.piP = a3;
            this.piQ = c != null ? w.a(c) : w.HTTP_1_1;
            if (sSLSocket != null) {
                com.bytedance.sdk.a.b.a.g.e.era().d(sSLSocket);
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
                com.bytedance.sdk.a.b.a.g.e.era().d(sSLSocket2);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private ab a(int i, int i2, ab abVar, s sVar) throws IOException {
        com.bytedance.sdk.a.b.b erk;
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        do {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.piS, this.piT);
            this.piS.epR().c(i, TimeUnit.MILLISECONDS);
            this.piT.epR().c(i2, TimeUnit.MILLISECONDS);
            aVar.a(abVar.eqQ(), str);
            aVar.b();
            erk = aVar.AL(false).f(abVar).erk();
            long d = com.bytedance.sdk.a.b.a.c.e.d(erk);
            if (d == -1) {
                d = 0;
            }
            com.bytedance.sdk.a.a.s io2 = aVar.io(d);
            com.bytedance.sdk.a.b.a.c.b(io2, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            io2.close();
            switch (erk.c()) {
                case 200:
                    if (this.piS.epS().e() && this.piT.epS().e()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    abVar = this.piM.erm().eqn().a(this.piM, erk);
                    if (abVar != null) {
                        break;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + erk.c());
            }
        } while (!"close".equalsIgnoreCase(erk.a(HTTP.CONN_DIRECTIVE)));
        return abVar;
    }

    private ab eqw() {
        return new ab.a().f(this.piM.erm().eqk()).hg("Host", com.bytedance.sdk.a.b.a.c.a(this.piM.erm().eqk(), true)).hg("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).hg("User-Agent", com.bytedance.sdk.a.b.a.d.a()).esc();
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.d dVar) {
        if (this.d.size() >= this.c || this.f6161a || !com.bytedance.sdk.a.b.a.a.pir.a(this.piM.erm(), aVar)) {
            return false;
        }
        if (aVar.eqk().f().equals(eqx().erm().eqk().f())) {
            return true;
        }
        if (this.piR != null && dVar != null && dVar.ern().type() == Proxy.Type.DIRECT && this.piM.ern().type() == Proxy.Type.DIRECT && this.piM.ero().equals(dVar.ero()) && dVar.erm().eqr() == com.bytedance.sdk.a.b.a.i.e.plb && a(aVar.eqk())) {
            try {
                aVar.eqs().a(aVar.eqk().f(), eqz().b());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.piM.erm().eqk().g()) {
            return false;
        }
        if (sVar.f().equals(this.piM.erm().eqk().f())) {
            return true;
        }
        return this.piP != null && com.bytedance.sdk.a.b.a.i.e.plb.a(sVar.f(), (X509Certificate) this.piP.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, g gVar) throws SocketException {
        if (this.piR != null) {
            return new com.bytedance.sdk.a.b.a.e.f(zVar, aVar, gVar, this.piR);
        }
        this.piO.setSoTimeout(aVar.c());
        this.piS.epR().c(aVar.c(), TimeUnit.MILLISECONDS);
        this.piT.epR().c(aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(zVar, gVar, this.piS, this.piT);
    }

    @Override // com.bytedance.sdk.a.b.l
    public com.bytedance.sdk.a.b.d eqx() {
        return this.piM;
    }

    public Socket eqy() {
        return this.piO;
    }

    public boolean a(boolean z) {
        boolean z2 = true;
        if (this.piO.isClosed() || this.piO.isInputShutdown() || this.piO.isOutputShutdown()) {
            return false;
        }
        if (this.piR != null) {
            return !this.piR.d();
        } else if (z) {
            try {
                int soTimeout = this.piO.getSoTimeout();
                this.piO.setSoTimeout(1);
                if (this.piS.e()) {
                    this.piO.setSoTimeout(soTimeout);
                    z2 = false;
                } else {
                    this.piO.setSoTimeout(soTimeout);
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
        synchronized (this.piL) {
            this.c = gVar.a();
        }
    }

    public u eqz() {
        return this.piP;
    }

    public boolean d() {
        return this.piR != null;
    }

    public String toString() {
        return "Connection{" + this.piM.erm().eqk().f() + ":" + this.piM.erm().eqk().g() + ", proxy=" + this.piM.ern() + " hostAddress=" + this.piM.ero() + " cipherSuite=" + (this.piP != null ? this.piP.erv() : "none") + " protocol=" + this.piQ + '}';
    }
}
