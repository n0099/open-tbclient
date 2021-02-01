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
    private com.bytedance.sdk.a.b.a.b.g ppq;

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
        ab epm = aVar.epm();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.h epk = gVar.epk();
        t epl = gVar.epl();
        this.ppq = new com.bytedance.sdk.a.b.a.b.g(this.f5884a.eqn(), c(epm.eoJ()), epk, epl, this.d);
        com.bytedance.sdk.a.b.b bVar = null;
        int i = 0;
        ab abVar = epm;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(abVar, this.ppq, null, null);
                    if (bVar != null) {
                        a2 = a2.epG().j(bVar.epG().a((com.bytedance.sdk.a.b.c) null).epJ()).epJ();
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
                        this.ppq.c();
                    }
                    return a2;
                }
                com.bytedance.sdk.a.b.a.c.a(a2.epF());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.ppq.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (f.eqv() instanceof l) {
                    this.ppq.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                } else {
                    if (!a(a2, f.eoJ())) {
                        this.ppq.c();
                        this.ppq = new com.bytedance.sdk.a.b.a.b.g(this.f5884a.eqn(), c(f.eoJ()), epk, epl, this.d);
                    } else if (this.ppq.epd() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    bVar = a2;
                    i = i2;
                    abVar = f;
                }
            } catch (Throwable th) {
                this.ppq.a((IOException) null);
                this.ppq.c();
                throw th;
            }
        }
        this.ppq.c();
        throw new IOException(ResponseException.CANCELED);
    }

    private com.bytedance.sdk.a.b.a c(s sVar) {
        com.bytedance.sdk.a.b.j jVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.c()) {
            sSLSocketFactory = this.f5884a.eqi();
            hostnameVerifier = this.f5884a.eqj();
            jVar = this.f5884a.eqk();
        } else {
            jVar = null;
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f5884a.eqg(), this.f5884a.eqh(), sSLSocketFactory, hostnameVerifier, jVar, this.f5884a.eqm(), this.f5884a.epa(), this.f5884a.t(), this.f5884a.u(), this.f5884a.eqd());
    }

    private boolean a(IOException iOException, boolean z, ab abVar) {
        this.ppq.a(iOException);
        if (this.f5884a.r()) {
            return !(z && (abVar.eqv() instanceof l)) && a(iOException, z) && this.ppq.e();
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
        s YG;
        Proxy epa;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.a.b.a.b.c epf = this.ppq.epf();
        com.bytedance.sdk.a.b.d eoW = epf != null ? epf.eoW() : null;
        int c = bVar.c();
        String b2 = bVar.epm().b();
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
                return this.f5884a.eql().a(eoW, bVar);
            case 407:
                if (eoW != null) {
                    epa = eoW.epM();
                } else {
                    epa = this.f5884a.epa();
                }
                if (epa.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f5884a.eqm().a(eoW, bVar);
            case 408:
                if (!this.f5884a.r() || (bVar.epm().eqv() instanceof l)) {
                    return null;
                }
                if (bVar.epH() == null || bVar.epH().c() != 408) {
                    return bVar.epm();
                }
                return null;
            default:
                return null;
        }
        if (!this.f5884a.q() || (a2 = bVar.a(Headers.LOCATION)) == null || (YG = bVar.epm().eoJ().YG(a2)) == null) {
            return null;
        }
        if (YG.b().equals(bVar.epm().eoJ().b()) || this.f5884a.p()) {
            ab.a eqw = bVar.epm().eqw();
            if (f.c(b2)) {
                boolean d = f.d(b2);
                if (f.e(b2)) {
                    eqw.a("GET", null);
                } else {
                    eqw.a(b2, d ? bVar.epm().eqv() : null);
                }
                if (!d) {
                    eqw.YP("Transfer-Encoding");
                    eqw.YP("Content-Length");
                    eqw.YP("Content-Type");
                }
            }
            if (!a(bVar, YG)) {
                eqw.YP("Authorization");
            }
            return eqw.f(YG).eqB();
        }
        return null;
    }

    private boolean a(com.bytedance.sdk.a.b.b bVar, s sVar) {
        s eoJ = bVar.epm().eoJ();
        return eoJ.f().equals(sVar.f()) && eoJ.g() == sVar.g() && eoJ.b().equals(sVar.b());
    }
}
