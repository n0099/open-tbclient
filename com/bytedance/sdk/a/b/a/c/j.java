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
    private final z f6182a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6183b;
    private Object d;
    private volatile boolean e;
    private com.bytedance.sdk.a.b.a.b.g pjD;

    public j(z zVar, boolean z) {
        this.f6182a = zVar;
        this.f6183b = z;
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
        ab eqO = aVar.eqO();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.h eqM = gVar.eqM();
        t eqN = gVar.eqN();
        this.pjD = new com.bytedance.sdk.a.b.a.b.g(this.f6182a.erP(), c(eqO.eql()), eqM, eqN, this.d);
        com.bytedance.sdk.a.b.b bVar = null;
        int i = 0;
        ab abVar = eqO;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(abVar, this.pjD, null, null);
                    if (bVar != null) {
                        a2 = a2.eri().j(bVar.eri().a((com.bytedance.sdk.a.b.c) null).erl()).erl();
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
                    if (!this.f6183b) {
                        this.pjD.c();
                    }
                    return a2;
                }
                com.bytedance.sdk.a.b.a.c.a(a2.erh());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.pjD.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (f.erX() instanceof l) {
                    this.pjD.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                } else {
                    if (!a(a2, f.eql())) {
                        this.pjD.c();
                        this.pjD = new com.bytedance.sdk.a.b.a.b.g(this.f6182a.erP(), c(f.eql()), eqM, eqN, this.d);
                    } else if (this.pjD.eqF() != null) {
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
            sSLSocketFactory = this.f6182a.erK();
            hostnameVerifier = this.f6182a.erL();
            jVar = this.f6182a.erM();
        } else {
            jVar = null;
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f6182a.erI(), this.f6182a.erJ(), sSLSocketFactory, hostnameVerifier, jVar, this.f6182a.erO(), this.f6182a.eqC(), this.f6182a.t(), this.f6182a.u(), this.f6182a.erF());
    }

    private boolean a(IOException iOException, boolean z, ab abVar) {
        this.pjD.a(iOException);
        if (this.f6182a.r()) {
            return !(z && (abVar.erX() instanceof l)) && a(iOException, z) && this.pjD.e();
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
        s YM;
        Proxy eqC;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.a.b.a.b.c eqH = this.pjD.eqH();
        com.bytedance.sdk.a.b.d eqy = eqH != null ? eqH.eqy() : null;
        int c = bVar.c();
        String b2 = bVar.eqO().b();
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
                return this.f6182a.erN().a(eqy, bVar);
            case 407:
                if (eqy != null) {
                    eqC = eqy.ero();
                } else {
                    eqC = this.f6182a.eqC();
                }
                if (eqC.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f6182a.erO().a(eqy, bVar);
            case 408:
                if (!this.f6182a.r() || (bVar.eqO().erX() instanceof l)) {
                    return null;
                }
                if (bVar.erj() == null || bVar.erj().c() != 408) {
                    return bVar.eqO();
                }
                return null;
            default:
                return null;
        }
        if (!this.f6182a.q() || (a2 = bVar.a(Headers.LOCATION)) == null || (YM = bVar.eqO().eql().YM(a2)) == null) {
            return null;
        }
        if (YM.b().equals(bVar.eqO().eql().b()) || this.f6182a.p()) {
            ab.a erY = bVar.eqO().erY();
            if (f.c(b2)) {
                boolean d = f.d(b2);
                if (f.e(b2)) {
                    erY.a("GET", null);
                } else {
                    erY.a(b2, d ? bVar.eqO().erX() : null);
                }
                if (!d) {
                    erY.YV("Transfer-Encoding");
                    erY.YV("Content-Length");
                    erY.YV("Content-Type");
                }
            }
            if (!a(bVar, YM)) {
                erY.YV("Authorization");
            }
            return erY.f(YM).esd();
        }
        return null;
    }

    private boolean a(com.bytedance.sdk.a.b.b bVar, s sVar) {
        s eql = bVar.eqO().eql();
        return eql.f().equals(sVar.f()) && eql.g() == sVar.g() && eql.b().equals(sVar.b());
    }
}
