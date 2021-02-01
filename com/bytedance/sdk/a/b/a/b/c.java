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
    public boolean f5864a;

    /* renamed from: b  reason: collision with root package name */
    public int f5865b;
    public int c = 1;
    public final List<Reference<g>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private Socket poA;
    private u poB;
    private w poC;
    private com.bytedance.sdk.a.b.a.e.g poD;
    private com.bytedance.sdk.a.a.e poE;
    private com.bytedance.sdk.a.a.d poF;
    private final m pox;
    private final com.bytedance.sdk.a.b.d poy;
    private Socket poz;

    public c(m mVar, com.bytedance.sdk.a.b.d dVar) {
        this.pox = mVar;
        this.poy = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
        if (r9.poy.d() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r9.poz != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        throw new com.bytedance.sdk.a.b.a.b.e(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0107, code lost:
        if (r9.poD == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
        r1 = r9.pox;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
        r9.c = r9.poD.a();
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
        if (this.poC != null) {
            throw new IllegalStateException("already connected");
        }
        List<n> f = this.poy.epL().f();
        b bVar = new b(f);
        if (this.poy.epL().eoP() == null) {
            if (!f.contains(n.ptw)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String f2 = this.poy.epL().eoJ().f();
            if (!com.bytedance.sdk.a.b.a.g.e.epz().b(f2)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
            }
        }
        e eVar2 = null;
        while (true) {
            try {
                if (this.poy.d()) {
                    a(i, i2, i3, hVar, tVar);
                    if (this.poz == null) {
                        break;
                    }
                } else {
                    a(i, i2, hVar, tVar);
                }
                a(bVar, hVar, tVar);
                tVar.a(hVar, this.poy.epN(), this.poy.epM(), this.poC);
                break;
            } catch (IOException e) {
                com.bytedance.sdk.a.b.a.c.a(this.poA);
                com.bytedance.sdk.a.b.a.c.a(this.poz);
                this.poA = null;
                this.poz = null;
                this.poE = null;
                this.poF = null;
                this.poB = null;
                this.poC = null;
                this.poD = null;
                tVar.a(hVar, this.poy.epN(), this.poy.epM(), null, e);
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
        ab eoV = eoV();
        s eoJ = eoV.eoJ();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, hVar, tVar);
            eoV = a(i2, i3, eoV, eoJ);
            if (eoV != null) {
                com.bytedance.sdk.a.b.a.c.a(this.poz);
                this.poz = null;
                this.poF = null;
                this.poE = null;
                tVar.a(hVar, this.poy.epN(), this.poy.epM(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i, int i2, h hVar, t tVar) throws IOException {
        Proxy epM = this.poy.epM();
        this.poz = (epM.type() == Proxy.Type.DIRECT || epM.type() == Proxy.Type.HTTP) ? this.poy.epL().eoL().createSocket() : new Socket(epM);
        tVar.a(hVar, this.poy.epN(), epM);
        this.poz.setSoTimeout(i2);
        try {
            com.bytedance.sdk.a.b.a.g.e.epz().a(this.poz, this.poy.epN(), i);
            try {
                this.poE = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.poz));
                this.poF = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.poz));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.poy.epN());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, h hVar, t tVar) throws IOException {
        if (this.poy.epL().eoP() == null) {
            this.poC = w.HTTP_1_1;
            this.poA = this.poz;
            return;
        }
        tVar.b(hVar);
        a(bVar);
        tVar.a(hVar, this.poB);
        if (this.poC == w.HTTP_2) {
            this.poA.setSoTimeout(0);
            this.poD = new g.a(true).a(this.poA, this.poy.epL().eoJ().f(), this.poE, this.poF).a(this).eps();
            this.poD.c();
        }
    }

    private void a(b bVar) throws IOException {
        Throwable th;
        AssertionError e;
        SSLSocket sSLSocket;
        SSLSocket sSLSocket2 = null;
        com.bytedance.sdk.a.b.a epL = this.poy.epL();
        try {
            try {
                sSLSocket = (SSLSocket) epL.eoP().createSocket(this.poz, epL.eoJ().f(), epL.eoJ().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            n a2 = bVar.a(sSLSocket);
            if (a2.d()) {
                com.bytedance.sdk.a.b.a.g.e.epz().a(sSLSocket, epL.eoJ().f(), epL.e());
            }
            sSLSocket.startHandshake();
            u a3 = u.a(sSLSocket.getSession());
            if (!epL.eoQ().verify(epL.eoJ().f(), sSLSocket.getSession())) {
                X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + epL.eoJ().f() + " not verified:\n    certificate: " + j.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
            }
            epL.eoR().a(epL.eoJ().f(), a3.b());
            String c = a2.d() ? com.bytedance.sdk.a.b.a.g.e.epz().c(sSLSocket) : null;
            this.poA = sSLSocket;
            this.poE = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.poA));
            this.poF = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.poA));
            this.poB = a3;
            this.poC = c != null ? w.a(c) : w.HTTP_1_1;
            if (sSLSocket != null) {
                com.bytedance.sdk.a.b.a.g.e.epz().d(sSLSocket);
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
                com.bytedance.sdk.a.b.a.g.e.epz().d(sSLSocket2);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private ab a(int i, int i2, ab abVar, s sVar) throws IOException {
        com.bytedance.sdk.a.b.b epJ;
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        do {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.poE, this.poF);
            this.poE.eoq().c(i, TimeUnit.MILLISECONDS);
            this.poF.eoq().c(i2, TimeUnit.MILLISECONDS);
            aVar.a(abVar.epp(), str);
            aVar.b();
            epJ = aVar.Ba(false).f(abVar).epJ();
            long d = com.bytedance.sdk.a.b.a.c.e.d(epJ);
            if (d == -1) {
                d = 0;
            }
            com.bytedance.sdk.a.a.s ir = aVar.ir(d);
            com.bytedance.sdk.a.b.a.c.b(ir, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            ir.close();
            switch (epJ.c()) {
                case 200:
                    if (this.poE.eor().e() && this.poF.eor().e()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    abVar = this.poy.epL().eoM().a(this.poy, epJ);
                    if (abVar != null) {
                        break;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + epJ.c());
            }
        } while (!"close".equalsIgnoreCase(epJ.a(HTTP.CONN_DIRECTIVE)));
        return abVar;
    }

    private ab eoV() {
        return new ab.a().f(this.poy.epL().eoJ()).hm("Host", com.bytedance.sdk.a.b.a.c.a(this.poy.epL().eoJ(), true)).hm("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).hm("User-Agent", com.bytedance.sdk.a.b.a.d.a()).eqB();
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.d dVar) {
        if (this.d.size() >= this.c || this.f5864a || !com.bytedance.sdk.a.b.a.a.poa.a(this.poy.epL(), aVar)) {
            return false;
        }
        if (aVar.eoJ().f().equals(eoW().epL().eoJ().f())) {
            return true;
        }
        if (this.poD != null && dVar != null && dVar.epM().type() == Proxy.Type.DIRECT && this.poy.epM().type() == Proxy.Type.DIRECT && this.poy.epN().equals(dVar.epN()) && dVar.epL().eoQ() == com.bytedance.sdk.a.b.a.i.e.pqO && a(aVar.eoJ())) {
            try {
                aVar.eoR().a(aVar.eoJ().f(), eoY().b());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.poy.epL().eoJ().g()) {
            return false;
        }
        if (sVar.f().equals(this.poy.epL().eoJ().f())) {
            return true;
        }
        return this.poB != null && com.bytedance.sdk.a.b.a.i.e.pqO.a(sVar.f(), (X509Certificate) this.poB.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, g gVar) throws SocketException {
        if (this.poD != null) {
            return new com.bytedance.sdk.a.b.a.e.f(zVar, aVar, gVar, this.poD);
        }
        this.poA.setSoTimeout(aVar.c());
        this.poE.eoq().c(aVar.c(), TimeUnit.MILLISECONDS);
        this.poF.eoq().c(aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(zVar, gVar, this.poE, this.poF);
    }

    @Override // com.bytedance.sdk.a.b.l
    public com.bytedance.sdk.a.b.d eoW() {
        return this.poy;
    }

    public Socket eoX() {
        return this.poA;
    }

    public boolean a(boolean z) {
        boolean z2 = true;
        if (this.poA.isClosed() || this.poA.isInputShutdown() || this.poA.isOutputShutdown()) {
            return false;
        }
        if (this.poD != null) {
            return !this.poD.d();
        } else if (z) {
            try {
                int soTimeout = this.poA.getSoTimeout();
                this.poA.setSoTimeout(1);
                if (this.poE.e()) {
                    this.poA.setSoTimeout(soTimeout);
                    z2 = false;
                } else {
                    this.poA.setSoTimeout(soTimeout);
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
        synchronized (this.pox) {
            this.c = gVar.a();
        }
    }

    public u eoY() {
        return this.poB;
    }

    public boolean d() {
        return this.poD != null;
    }

    public String toString() {
        return "Connection{" + this.poy.epL().eoJ().f() + ":" + this.poy.epL().eoJ().g() + ", proxy=" + this.poy.epM() + " hostAddress=" + this.poy.epN() + " cipherSuite=" + (this.poB != null ? this.poB.epT() : "none") + " protocol=" + this.poC + '}';
    }
}
