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
    private final m poX;
    private final com.bytedance.sdk.a.b.d poY;
    private Socket poZ;
    private Socket ppa;
    private u ppb;
    private w ppc;
    private com.bytedance.sdk.a.b.a.e.g ppd;
    private com.bytedance.sdk.a.a.e ppe;
    private com.bytedance.sdk.a.a.d ppf;

    public c(m mVar, com.bytedance.sdk.a.b.d dVar) {
        this.poX = mVar;
        this.poY = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
        if (r9.poY.d() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r9.poZ != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        throw new com.bytedance.sdk.a.b.a.b.e(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0107, code lost:
        if (r9.ppd == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
        r1 = r9.poX;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
        r9.c = r9.ppd.a();
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
        if (this.ppc != null) {
            throw new IllegalStateException("already connected");
        }
        List<n> f = this.poY.epT().f();
        b bVar = new b(f);
        if (this.poY.epT().eoX() == null) {
            if (!f.contains(n.ptW)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String f2 = this.poY.epT().eoR().f();
            if (!com.bytedance.sdk.a.b.a.g.e.epH().b(f2)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
            }
        }
        e eVar2 = null;
        while (true) {
            try {
                if (this.poY.d()) {
                    a(i, i2, i3, hVar, tVar);
                    if (this.poZ == null) {
                        break;
                    }
                } else {
                    a(i, i2, hVar, tVar);
                }
                a(bVar, hVar, tVar);
                tVar.a(hVar, this.poY.epV(), this.poY.epU(), this.ppc);
                break;
            } catch (IOException e) {
                com.bytedance.sdk.a.b.a.c.a(this.ppa);
                com.bytedance.sdk.a.b.a.c.a(this.poZ);
                this.ppa = null;
                this.poZ = null;
                this.ppe = null;
                this.ppf = null;
                this.ppb = null;
                this.ppc = null;
                this.ppd = null;
                tVar.a(hVar, this.poY.epV(), this.poY.epU(), null, e);
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
        ab epd = epd();
        s eoR = epd.eoR();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, hVar, tVar);
            epd = a(i2, i3, epd, eoR);
            if (epd != null) {
                com.bytedance.sdk.a.b.a.c.a(this.poZ);
                this.poZ = null;
                this.ppf = null;
                this.ppe = null;
                tVar.a(hVar, this.poY.epV(), this.poY.epU(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i, int i2, h hVar, t tVar) throws IOException {
        Proxy epU = this.poY.epU();
        this.poZ = (epU.type() == Proxy.Type.DIRECT || epU.type() == Proxy.Type.HTTP) ? this.poY.epT().eoT().createSocket() : new Socket(epU);
        tVar.a(hVar, this.poY.epV(), epU);
        this.poZ.setSoTimeout(i2);
        try {
            com.bytedance.sdk.a.b.a.g.e.epH().a(this.poZ, this.poY.epV(), i);
            try {
                this.ppe = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.poZ));
                this.ppf = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.poZ));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.poY.epV());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, h hVar, t tVar) throws IOException {
        if (this.poY.epT().eoX() == null) {
            this.ppc = w.HTTP_1_1;
            this.ppa = this.poZ;
            return;
        }
        tVar.b(hVar);
        a(bVar);
        tVar.a(hVar, this.ppb);
        if (this.ppc == w.HTTP_2) {
            this.ppa.setSoTimeout(0);
            this.ppd = new g.a(true).a(this.ppa, this.poY.epT().eoR().f(), this.ppe, this.ppf).a(this).epA();
            this.ppd.c();
        }
    }

    private void a(b bVar) throws IOException {
        Throwable th;
        AssertionError e;
        SSLSocket sSLSocket;
        SSLSocket sSLSocket2 = null;
        com.bytedance.sdk.a.b.a epT = this.poY.epT();
        try {
            try {
                sSLSocket = (SSLSocket) epT.eoX().createSocket(this.poZ, epT.eoR().f(), epT.eoR().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            n a2 = bVar.a(sSLSocket);
            if (a2.d()) {
                com.bytedance.sdk.a.b.a.g.e.epH().a(sSLSocket, epT.eoR().f(), epT.e());
            }
            sSLSocket.startHandshake();
            u a3 = u.a(sSLSocket.getSession());
            if (!epT.eoY().verify(epT.eoR().f(), sSLSocket.getSession())) {
                X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + epT.eoR().f() + " not verified:\n    certificate: " + j.a(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
            }
            epT.eoZ().a(epT.eoR().f(), a3.b());
            String c = a2.d() ? com.bytedance.sdk.a.b.a.g.e.epH().c(sSLSocket) : null;
            this.ppa = sSLSocket;
            this.ppe = com.bytedance.sdk.a.a.l.c(com.bytedance.sdk.a.a.l.g(this.ppa));
            this.ppf = com.bytedance.sdk.a.a.l.b(com.bytedance.sdk.a.a.l.f(this.ppa));
            this.ppb = a3;
            this.ppc = c != null ? w.a(c) : w.HTTP_1_1;
            if (sSLSocket != null) {
                com.bytedance.sdk.a.b.a.g.e.epH().d(sSLSocket);
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
                com.bytedance.sdk.a.b.a.g.e.epH().d(sSLSocket2);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private ab a(int i, int i2, ab abVar, s sVar) throws IOException {
        com.bytedance.sdk.a.b.b epR;
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        do {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.ppe, this.ppf);
            this.ppe.eoy().c(i, TimeUnit.MILLISECONDS);
            this.ppf.eoy().c(i2, TimeUnit.MILLISECONDS);
            aVar.a(abVar.epx(), str);
            aVar.b();
            epR = aVar.Ba(false).f(abVar).epR();
            long d = com.bytedance.sdk.a.b.a.c.e.d(epR);
            if (d == -1) {
                d = 0;
            }
            com.bytedance.sdk.a.a.s ir = aVar.ir(d);
            com.bytedance.sdk.a.b.a.c.b(ir, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            ir.close();
            switch (epR.c()) {
                case 200:
                    if (this.ppe.eoz().e() && this.ppf.eoz().e()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    abVar = this.poY.epT().eoU().a(this.poY, epR);
                    if (abVar != null) {
                        break;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + epR.c());
            }
        } while (!"close".equalsIgnoreCase(epR.a(HTTP.CONN_DIRECTIVE)));
        return abVar;
    }

    private ab epd() {
        return new ab.a().f(this.poY.epT().eoR()).ho("Host", com.bytedance.sdk.a.b.a.c.a(this.poY.epT().eoR(), true)).ho("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).ho("User-Agent", com.bytedance.sdk.a.b.a.d.a()).eqJ();
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.d dVar) {
        if (this.d.size() >= this.c || this.f5864a || !com.bytedance.sdk.a.b.a.a.poD.a(this.poY.epT(), aVar)) {
            return false;
        }
        if (aVar.eoR().f().equals(epe().epT().eoR().f())) {
            return true;
        }
        if (this.ppd != null && dVar != null && dVar.epU().type() == Proxy.Type.DIRECT && this.poY.epU().type() == Proxy.Type.DIRECT && this.poY.epV().equals(dVar.epV()) && dVar.epT().eoY() == com.bytedance.sdk.a.b.a.i.e.pro && a(aVar.eoR())) {
            try {
                aVar.eoZ().a(aVar.eoR().f(), epg().b());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.poY.epT().eoR().g()) {
            return false;
        }
        if (sVar.f().equals(this.poY.epT().eoR().f())) {
            return true;
        }
        return this.ppb != null && com.bytedance.sdk.a.b.a.i.e.pro.a(sVar.f(), (X509Certificate) this.ppb.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, g gVar) throws SocketException {
        if (this.ppd != null) {
            return new com.bytedance.sdk.a.b.a.e.f(zVar, aVar, gVar, this.ppd);
        }
        this.ppa.setSoTimeout(aVar.c());
        this.ppe.eoy().c(aVar.c(), TimeUnit.MILLISECONDS);
        this.ppf.eoy().c(aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(zVar, gVar, this.ppe, this.ppf);
    }

    @Override // com.bytedance.sdk.a.b.l
    public com.bytedance.sdk.a.b.d epe() {
        return this.poY;
    }

    public Socket epf() {
        return this.ppa;
    }

    public boolean a(boolean z) {
        boolean z2 = true;
        if (this.ppa.isClosed() || this.ppa.isInputShutdown() || this.ppa.isOutputShutdown()) {
            return false;
        }
        if (this.ppd != null) {
            return !this.ppd.d();
        } else if (z) {
            try {
                int soTimeout = this.ppa.getSoTimeout();
                this.ppa.setSoTimeout(1);
                if (this.ppe.e()) {
                    this.ppa.setSoTimeout(soTimeout);
                    z2 = false;
                } else {
                    this.ppa.setSoTimeout(soTimeout);
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
        synchronized (this.poX) {
            this.c = gVar.a();
        }
    }

    public u epg() {
        return this.ppb;
    }

    public boolean d() {
        return this.ppd != null;
    }

    public String toString() {
        return "Connection{" + this.poY.epT().eoR().f() + ":" + this.poY.epT().eoR().g() + ", proxy=" + this.poY.epU() + " hostAddress=" + this.poY.epV() + " cipherSuite=" + (this.ppb != null ? this.ppb.eqb() : "none") + " protocol=" + this.ppc + '}';
    }
}
