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
    private final z f5882a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5883b;
    private Object d;
    private volatile boolean e;
    private com.bytedance.sdk.a.b.a.b.g peY;

    public j(z zVar, boolean z) {
        this.f5882a = zVar;
        this.f5883b = z;
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
        ab emS = aVar.emS();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.h emQ = gVar.emQ();
        t emR = gVar.emR();
        this.peY = new com.bytedance.sdk.a.b.a.b.g(this.f5882a.enU(), c(emS.emp()), emQ, emR, this.d);
        com.bytedance.sdk.a.b.b bVar = null;
        int i = 0;
        ab abVar = emS;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(abVar, this.peY, null, null);
                    if (bVar != null) {
                        a2 = a2.enn().j(bVar.enn().a((com.bytedance.sdk.a.b.c) null).enq()).enq();
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
                    if (!this.f5883b) {
                        this.peY.c();
                    }
                    return a2;
                }
                com.bytedance.sdk.a.b.a.c.a(a2.enm());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.peY.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (f.eoc() instanceof l) {
                    this.peY.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                } else {
                    if (!a(a2, f.emp())) {
                        this.peY.c();
                        this.peY = new com.bytedance.sdk.a.b.a.b.g(this.f5882a.enU(), c(f.emp()), emQ, emR, this.d);
                    } else if (this.peY.emJ() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    bVar = a2;
                    i = i2;
                    abVar = f;
                }
            } catch (Throwable th) {
                this.peY.a((IOException) null);
                this.peY.c();
                throw th;
            }
        }
        this.peY.c();
        throw new IOException(ResponseException.CANCELED);
    }

    private com.bytedance.sdk.a.b.a c(s sVar) {
        com.bytedance.sdk.a.b.j jVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (sVar.c()) {
            sSLSocketFactory = this.f5882a.enP();
            hostnameVerifier = this.f5882a.enQ();
            jVar = this.f5882a.enR();
        } else {
            jVar = null;
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f5882a.enN(), this.f5882a.enO(), sSLSocketFactory, hostnameVerifier, jVar, this.f5882a.enT(), this.f5882a.emG(), this.f5882a.t(), this.f5882a.u(), this.f5882a.enK());
    }

    private boolean a(IOException iOException, boolean z, ab abVar) {
        this.peY.a(iOException);
        if (this.f5882a.r()) {
            return !(z && (abVar.eoc() instanceof l)) && a(iOException, z) && this.peY.e();
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
        s XE;
        Proxy emG;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.a.b.a.b.c emL = this.peY.emL();
        com.bytedance.sdk.a.b.d emC = emL != null ? emL.emC() : null;
        int c = bVar.c();
        String b2 = bVar.emS().b();
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
                return this.f5882a.enS().a(emC, bVar);
            case 407:
                if (emC != null) {
                    emG = emC.ent();
                } else {
                    emG = this.f5882a.emG();
                }
                if (emG.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f5882a.enT().a(emC, bVar);
            case 408:
                if (!this.f5882a.r() || (bVar.emS().eoc() instanceof l)) {
                    return null;
                }
                if (bVar.eno() == null || bVar.eno().c() != 408) {
                    return bVar.emS();
                }
                return null;
            default:
                return null;
        }
        if (!this.f5882a.q() || (a2 = bVar.a(Headers.LOCATION)) == null || (XE = bVar.emS().emp().XE(a2)) == null) {
            return null;
        }
        if (XE.b().equals(bVar.emS().emp().b()) || this.f5882a.p()) {
            ab.a eod = bVar.emS().eod();
            if (f.c(b2)) {
                boolean d = f.d(b2);
                if (f.e(b2)) {
                    eod.a("GET", null);
                } else {
                    eod.a(b2, d ? bVar.emS().eoc() : null);
                }
                if (!d) {
                    eod.XN("Transfer-Encoding");
                    eod.XN("Content-Length");
                    eod.XN("Content-Type");
                }
            }
            if (!a(bVar, XE)) {
                eod.XN("Authorization");
            }
            return eod.f(XE).eoj();
        }
        return null;
    }

    private boolean a(com.bytedance.sdk.a.b.b bVar, s sVar) {
        s emp = bVar.emS().emp();
        return emp.f().equals(sVar.f()) && emp.g() == sVar.g() && emp.b().equals(sVar.b());
    }
}
