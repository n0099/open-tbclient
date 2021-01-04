package com.bytedance.sdk.a.b.a.c;

import com.baidu.searchbox.http.response.ResponseException;
import com.baidubce.http.Headers;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.x;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.http.StatusLine;
import org.apache.http.client.methods.HttpHead;
/* loaded from: classes4.dex */
public final class j implements x {

    /* renamed from: a  reason: collision with root package name */
    private final z f6181a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6182b;
    private Object d;
    private volatile boolean e;
    private com.bytedance.sdk.a.b.a.b.g pjD;

    public j(z zVar, boolean z) {
        this.f6181a = zVar;
        this.f6182b = z;
    }

    public boolean a() {
        return this.e;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        com.bytedance.sdk.a.b.b a2;
        ab f;
        ab eqN = aVar.eqN();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.h eqL = gVar.eqL();
        t eqM = gVar.eqM();
        this.pjD = new com.bytedance.sdk.a.b.a.b.g(this.f6181a.erO(), c(eqN.eqk()), eqL, eqM, this.d);
        com.bytedance.sdk.a.b.b bVar = null;
        int i = 0;
        ab abVar = eqN;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(abVar, this.pjD, null, null);
                    if (bVar != null) {
                        a2 = a2.erh().j(bVar.erh().a((com.bytedance.sdk.a.b.c) null).erk()).erk();
                    }
                    f = f(a2);
                } catch (com.bytedance.sdk.a.b.a.b.e e) {
                    if (!a(e.a(), false, abVar)) {
                        throw e.a();
                    }
                } catch (IOException e2) {
                    if (!a(e2, !(e2 instanceof com.bytedance.sdk.a.b.a.e.a), abVar)) {
                        throw e2;
                    }
                }
                if (f == null) {
                    if (!this.f6182b) {
                        this.pjD.c();
                    }
                    return a2;
                }
                com.bytedance.sdk.a.b.a.c.a(a2.erg());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.pjD.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (f.erW() instanceof l) {
                    this.pjD.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                } else {
                    if (!a(a2, f.eqk())) {
                        this.pjD.c();
                        this.pjD = new com.bytedance.sdk.a.b.a.b.g(this.f6181a.erO(), c(f.eqk()), eqL, eqM, this.d);
                    } else if (this.pjD.eqE() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    bVar = a2;
                    i = i2;
                    abVar = f;
                }
            } catch (Throwable th) {
                this.pjD.a((IOException) null);
                this.pjD.c();
                throw th;
            }
        }
        this.pjD.c();
        throw new IOException(ResponseException.CANCELED);
    }

    private com.bytedance.sdk.a.b.a c(s sVar) {
        com.bytedance.sdk.a.b.j jVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.c()) {
            sSLSocketFactory = this.f6181a.erJ();
            hostnameVerifier = this.f6181a.erK();
            jVar = this.f6181a.erL();
        } else {
            jVar = null;
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f6181a.erH(), this.f6181a.erI(), sSLSocketFactory, hostnameVerifier, jVar, this.f6181a.erN(), this.f6181a.eqB(), this.f6181a.t(), this.f6181a.u(), this.f6181a.erE());
    }

    private boolean a(IOException iOException, boolean z, ab abVar) {
        this.pjD.a(iOException);
        if (this.f6181a.r()) {
            return !(z && (abVar.erW() instanceof l)) && a(iOException, z) && this.pjD.e();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        boolean z2 = true;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        }
        if (!(iOException instanceof SocketTimeoutException) || z) {
            z2 = false;
        }
        return z2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private ab f(com.bytedance.sdk.a.b.b bVar) throws IOException {
        String a2;
        s YN;
        Proxy eqB;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.a.b.a.b.c eqG = this.pjD.eqG();
        com.bytedance.sdk.a.b.d eqx = eqG != null ? eqG.eqx() : null;
        int c = bVar.c();
        String b2 = bVar.eqN().b();
        switch (c) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                if (!b2.equals("GET") && !b2.equals(HttpHead.METHOD_NAME)) {
                    return null;
                }
                break;
            case 401:
                return this.f6181a.erM().a(eqx, bVar);
            case 407:
                if (eqx != null) {
                    eqB = eqx.ern();
                } else {
                    eqB = this.f6181a.eqB();
                }
                if (eqB.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f6181a.erN().a(eqx, bVar);
            case 408:
                if (!this.f6181a.r() || (bVar.eqN().erW() instanceof l)) {
                    return null;
                }
                if (bVar.eri() == null || bVar.eri().c() != 408) {
                    return bVar.eqN();
                }
                return null;
            default:
                return null;
        }
        if (!this.f6181a.q() || (a2 = bVar.a(Headers.LOCATION)) == null || (YN = bVar.eqN().eqk().YN(a2)) == null) {
            return null;
        }
        if (YN.b().equals(bVar.eqN().eqk().b()) || this.f6181a.p()) {
            ab.a erX = bVar.eqN().erX();
            if (f.c(b2)) {
                boolean d = f.d(b2);
                if (f.e(b2)) {
                    erX.a("GET", null);
                } else {
                    erX.a(b2, d ? bVar.eqN().erW() : null);
                }
                if (!d) {
                    erX.YW("Transfer-Encoding");
                    erX.YW("Content-Length");
                    erX.YW("Content-Type");
                }
            }
            if (!a(bVar, YN)) {
                erX.YW("Authorization");
            }
            return erX.f(YN).esc();
        }
        return null;
    }

    private boolean a(com.bytedance.sdk.a.b.b bVar, s sVar) {
        s eqk = bVar.eqN().eqk();
        return eqk.f().equals(sVar.f()) && eqk.g() == sVar.g() && eqk.b().equals(sVar.b());
    }
}
