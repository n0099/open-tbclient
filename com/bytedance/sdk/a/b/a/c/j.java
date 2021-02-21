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
/* loaded from: classes6.dex */
public final class j implements x {

    /* renamed from: a  reason: collision with root package name */
    private final z f5884a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5885b;
    private Object d;
    private volatile boolean e;
    private com.bytedance.sdk.a.b.a.b.g ppR;

    public j(z zVar, boolean z) {
        this.f5884a = zVar;
        this.f5885b = z;
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
        ab epu = aVar.epu();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.h eps = gVar.eps();
        t ept = gVar.ept();
        this.ppR = new com.bytedance.sdk.a.b.a.b.g(this.f5884a.eqv(), c(epu.eoR()), eps, ept, this.d);
        com.bytedance.sdk.a.b.b bVar = null;
        int i = 0;
        ab abVar = epu;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(abVar, this.ppR, null, null);
                    if (bVar != null) {
                        a2 = a2.epO().j(bVar.epO().a((com.bytedance.sdk.a.b.c) null).epR()).epR();
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
                    if (!this.f5885b) {
                        this.ppR.c();
                    }
                    return a2;
                }
                com.bytedance.sdk.a.b.a.c.a(a2.epN());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.ppR.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (f.eqD() instanceof l) {
                    this.ppR.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                } else {
                    if (!a(a2, f.eoR())) {
                        this.ppR.c();
                        this.ppR = new com.bytedance.sdk.a.b.a.b.g(this.f5884a.eqv(), c(f.eoR()), eps, ept, this.d);
                    } else if (this.ppR.epl() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    bVar = a2;
                    i = i2;
                    abVar = f;
                }
            } catch (Throwable th) {
                this.ppR.a((IOException) null);
                this.ppR.c();
                throw th;
            }
        }
        this.ppR.c();
        throw new IOException(ResponseException.CANCELED);
    }

    private com.bytedance.sdk.a.b.a c(s sVar) {
        com.bytedance.sdk.a.b.j jVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.c()) {
            sSLSocketFactory = this.f5884a.eqq();
            hostnameVerifier = this.f5884a.eqr();
            jVar = this.f5884a.eqs();
        } else {
            jVar = null;
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f5884a.eqo(), this.f5884a.eqp(), sSLSocketFactory, hostnameVerifier, jVar, this.f5884a.equ(), this.f5884a.epi(), this.f5884a.t(), this.f5884a.u(), this.f5884a.eql());
    }

    private boolean a(IOException iOException, boolean z, ab abVar) {
        this.ppR.a(iOException);
        if (this.f5884a.r()) {
            return !(z && (abVar.eqD() instanceof l)) && a(iOException, z) && this.ppR.e();
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
        s YS;
        Proxy epi;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.a.b.a.b.c epn = this.ppR.epn();
        com.bytedance.sdk.a.b.d epe = epn != null ? epn.epe() : null;
        int c = bVar.c();
        String b2 = bVar.epu().b();
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
                return this.f5884a.eqt().a(epe, bVar);
            case 407:
                if (epe != null) {
                    epi = epe.epU();
                } else {
                    epi = this.f5884a.epi();
                }
                if (epi.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f5884a.equ().a(epe, bVar);
            case 408:
                if (!this.f5884a.r() || (bVar.epu().eqD() instanceof l)) {
                    return null;
                }
                if (bVar.epP() == null || bVar.epP().c() != 408) {
                    return bVar.epu();
                }
                return null;
            default:
                return null;
        }
        if (!this.f5884a.q() || (a2 = bVar.a(Headers.LOCATION)) == null || (YS = bVar.epu().eoR().YS(a2)) == null) {
            return null;
        }
        if (YS.b().equals(bVar.epu().eoR().b()) || this.f5884a.p()) {
            ab.a eqE = bVar.epu().eqE();
            if (f.c(b2)) {
                boolean d = f.d(b2);
                if (f.e(b2)) {
                    eqE.a("GET", null);
                } else {
                    eqE.a(b2, d ? bVar.epu().eqD() : null);
                }
                if (!d) {
                    eqE.Zb("Transfer-Encoding");
                    eqE.Zb("Content-Length");
                    eqE.Zb("Content-Type");
                }
            }
            if (!a(bVar, YS)) {
                eqE.Zb("Authorization");
            }
            return eqE.f(YS).eqJ();
        }
        return null;
    }

    private boolean a(com.bytedance.sdk.a.b.b bVar, s sVar) {
        s eoR = bVar.epu().eoR();
        return eoR.f().equals(sVar.f()) && eoR.g() == sVar.g() && eoR.b().equals(sVar.b());
    }
}
