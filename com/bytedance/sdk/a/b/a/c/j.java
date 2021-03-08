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
    private final z f3964a;
    private final boolean b;
    private Object d;
    private volatile boolean e;
    private com.bytedance.sdk.a.b.a.b.g prW;

    public j(z zVar, boolean z) {
        this.f3964a = zVar;
        this.b = z;
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
        ab epB = aVar.epB();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.h epz = gVar.epz();
        t epA = gVar.epA();
        this.prW = new com.bytedance.sdk.a.b.a.b.g(this.f3964a.eqC(), c(epB.eoY()), epz, epA, this.d);
        com.bytedance.sdk.a.b.b bVar = null;
        int i = 0;
        ab abVar = epB;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(abVar, this.prW, null, null);
                    if (bVar != null) {
                        a2 = a2.epV().j(bVar.epV().a((com.bytedance.sdk.a.b.c) null).epY()).epY();
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
                    if (!this.b) {
                        this.prW.c();
                    }
                    return a2;
                }
                com.bytedance.sdk.a.b.a.c.a(a2.epU());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.prW.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (f.eqK() instanceof l) {
                    this.prW.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                } else {
                    if (!a(a2, f.eoY())) {
                        this.prW.c();
                        this.prW = new com.bytedance.sdk.a.b.a.b.g(this.f3964a.eqC(), c(f.eoY()), epz, epA, this.d);
                    } else if (this.prW.eps() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    bVar = a2;
                    i = i2;
                    abVar = f;
                }
            } catch (Throwable th) {
                this.prW.a((IOException) null);
                this.prW.c();
                throw th;
            }
        }
        this.prW.c();
        throw new IOException(ResponseException.CANCELED);
    }

    private com.bytedance.sdk.a.b.a c(s sVar) {
        com.bytedance.sdk.a.b.j jVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.c()) {
            sSLSocketFactory = this.f3964a.eqx();
            hostnameVerifier = this.f3964a.eqy();
            jVar = this.f3964a.eqz();
        } else {
            jVar = null;
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f3964a.eqv(), this.f3964a.eqw(), sSLSocketFactory, hostnameVerifier, jVar, this.f3964a.eqB(), this.f3964a.epp(), this.f3964a.t(), this.f3964a.u(), this.f3964a.eqs());
    }

    private boolean a(IOException iOException, boolean z, ab abVar) {
        this.prW.a(iOException);
        if (this.f3964a.r()) {
            return !(z && (abVar.eqK() instanceof l)) && a(iOException, z) && this.prW.e();
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
        s YZ;
        Proxy epp;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.a.b.a.b.c epu = this.prW.epu();
        com.bytedance.sdk.a.b.d epl = epu != null ? epu.epl() : null;
        int c = bVar.c();
        String b = bVar.epB().b();
        switch (c) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                if (!b.equals("GET") && !b.equals(HttpHead.METHOD_NAME)) {
                    return null;
                }
                break;
            case 401:
                return this.f3964a.eqA().a(epl, bVar);
            case 407:
                if (epl != null) {
                    epp = epl.eqb();
                } else {
                    epp = this.f3964a.epp();
                }
                if (epp.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f3964a.eqB().a(epl, bVar);
            case 408:
                if (!this.f3964a.r() || (bVar.epB().eqK() instanceof l)) {
                    return null;
                }
                if (bVar.epW() == null || bVar.epW().c() != 408) {
                    return bVar.epB();
                }
                return null;
            default:
                return null;
        }
        if (!this.f3964a.q() || (a2 = bVar.a(Headers.LOCATION)) == null || (YZ = bVar.epB().eoY().YZ(a2)) == null) {
            return null;
        }
        if (YZ.b().equals(bVar.epB().eoY().b()) || this.f3964a.p()) {
            ab.a eqL = bVar.epB().eqL();
            if (f.c(b)) {
                boolean d = f.d(b);
                if (f.e(b)) {
                    eqL.a("GET", null);
                } else {
                    eqL.a(b, d ? bVar.epB().eqK() : null);
                }
                if (!d) {
                    eqL.Zi("Transfer-Encoding");
                    eqL.Zi("Content-Length");
                    eqL.Zi("Content-Type");
                }
            }
            if (!a(bVar, YZ)) {
                eqL.Zi("Authorization");
            }
            return eqL.f(YZ).eqQ();
        }
        return null;
    }

    private boolean a(com.bytedance.sdk.a.b.b bVar, s sVar) {
        s eoY = bVar.epB().eoY();
        return eoY.f().equals(sVar.f()) && eoY.g() == sVar.g() && eoY.b().equals(sVar.b());
    }
}
