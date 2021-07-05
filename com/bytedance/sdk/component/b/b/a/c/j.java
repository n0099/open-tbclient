package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.aa;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.ad;
import com.bytedance.sdk.component.b.b.p;
import com.bytedance.sdk.component.b.b.t;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
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
/* loaded from: classes6.dex */
public final class j implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f28141a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f28142b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.b.b.a.b.g f28143c;

    /* renamed from: d  reason: collision with root package name */
    public Object f28144d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f28145e;

    public j(w wVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28141a = wVar;
        this.f28142b = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28145e = true;
            com.bytedance.sdk.component.b.b.a.b.g gVar = this.f28143c;
            if (gVar != null) {
                gVar.e();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28145e : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u
    public ab intercept(u.a aVar) throws IOException {
        InterceptResult invokeL;
        ab a2;
        z a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            z a4 = aVar.a();
            g gVar = (g) aVar;
            com.bytedance.sdk.component.b.b.e h2 = gVar.h();
            p i2 = gVar.i();
            this.f28143c = new com.bytedance.sdk.component.b.b.a.b.g(this.f28141a.o(), a(a4.a()), h2, i2, this.f28144d);
            ab abVar = null;
            int i3 = 0;
            while (!this.f28145e) {
                try {
                    try {
                        a2 = gVar.a(a4, this.f28143c, null, null);
                        if (abVar != null) {
                            a2 = a2.i().c(abVar.i().a((ac) null).a()).a();
                        }
                        a3 = a(a2);
                    } catch (com.bytedance.sdk.component.b.b.a.b.e e2) {
                        if (!a(e2.a(), false, a4)) {
                            throw e2.a();
                        }
                    } catch (IOException e3) {
                        if (!a(e3, !(e3 instanceof com.bytedance.sdk.component.b.b.a.e.a), a4)) {
                            throw e3;
                        }
                    }
                    if (a3 == null) {
                        if (!this.f28142b) {
                            this.f28143c.c();
                        }
                        return a2;
                    }
                    com.bytedance.sdk.component.b.b.a.c.a(a2.h());
                    int i4 = i3 + 1;
                    if (i4 <= 20) {
                        if (!(a3.d() instanceof l)) {
                            if (!a(a2, a3.a())) {
                                this.f28143c.c();
                                this.f28143c = new com.bytedance.sdk.component.b.b.a.b.g(this.f28141a.o(), a(a3.a()), h2, i2, this.f28144d);
                            } else if (this.f28143c.a() != null) {
                                throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                            }
                            abVar = a2;
                            a4 = a3;
                            i3 = i4;
                        } else {
                            this.f28143c.c();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                        }
                    } else {
                        this.f28143c.c();
                        throw new ProtocolException("Too many follow-up requests: " + i4);
                    }
                } catch (Throwable th) {
                    this.f28143c.a((IOException) null);
                    this.f28143c.c();
                    throw th;
                }
            }
            this.f28143c.c();
            throw new IOException(ResponseException.CANCELED);
        }
        return (ab) invokeL.objValue;
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.f28144d = obj;
        }
    }

    private com.bytedance.sdk.component.b.b.a a(t tVar) {
        InterceptResult invokeL;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.bytedance.sdk.component.b.b.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, tVar)) == null) {
            if (tVar.d()) {
                SSLSocketFactory j = this.f28141a.j();
                hostnameVerifier = this.f28141a.k();
                sSLSocketFactory = j;
                gVar = this.f28141a.l();
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                gVar = null;
            }
            return new com.bytedance.sdk.component.b.b.a(tVar.g(), tVar.h(), this.f28141a.h(), this.f28141a.i(), sSLSocketFactory, hostnameVerifier, gVar, this.f28141a.n(), this.f28141a.d(), this.f28141a.t(), this.f28141a.u(), this.f28141a.e());
        }
        return (com.bytedance.sdk.component.b.b.a) invokeL.objValue;
    }

    private boolean a(IOException iOException, boolean z, z zVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{iOException, Boolean.valueOf(z), zVar})) == null) {
            this.f28143c.a(iOException);
            if (this.f28141a.r()) {
                return !(z && (zVar.d() instanceof l)) && a(iOException, z) && this.f28143c.f();
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(IOException iOException, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65540, this, iOException, z)) == null) {
            if (iOException instanceof ProtocolException) {
                return false;
            }
            return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        }
        return invokeLZ.booleanValue;
    }

    private z a(ab abVar) throws IOException {
        InterceptResult invokeL;
        String a2;
        t c2;
        Proxy d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, abVar)) == null) {
            if (abVar != null) {
                com.bytedance.sdk.component.b.b.a.b.c b2 = this.f28143c.b();
                ad a3 = b2 != null ? b2.a() : null;
                int c3 = abVar.c();
                String b3 = abVar.a().b();
                if (c3 == 307 || c3 == 308) {
                    if (!b3.equals("GET") && !b3.equals("HEAD")) {
                        return null;
                    }
                } else if (c3 != 401) {
                    if (c3 == 407) {
                        if (a3 != null) {
                            d2 = a3.b();
                        } else {
                            d2 = this.f28141a.d();
                        }
                        if (d2.type() == Proxy.Type.HTTP) {
                            return this.f28141a.n().a(a3, abVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (c3 == 408) {
                        if (this.f28141a.r() && !(abVar.a().d() instanceof l)) {
                            if (abVar.j() == null || abVar.j().c() != 408) {
                                return abVar.a();
                            }
                            return null;
                        }
                        return null;
                    } else {
                        switch (c3) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    }
                } else {
                    return this.f28141a.m().a(a3, abVar);
                }
                if (!this.f28141a.q() || (a2 = abVar.a("Location")) == null || (c2 = abVar.a().a().c(a2)) == null) {
                    return null;
                }
                if (c2.c().equals(abVar.a().a().c()) || this.f28141a.p()) {
                    z.a f2 = abVar.a().f();
                    if (f.c(b3)) {
                        boolean d3 = f.d(b3);
                        if (f.e(b3)) {
                            f2.a("GET", (aa) null);
                        } else {
                            f2.a(b3, d3 ? abVar.a().d() : null);
                        }
                        if (!d3) {
                            f2.b("Transfer-Encoding");
                            f2.b("Content-Length");
                            f2.b("Content-Type");
                        }
                    }
                    if (!a(abVar, c2)) {
                        f2.b("Authorization");
                    }
                    return f2.a(c2).d();
                }
                return null;
            }
            throw new IllegalStateException();
        }
        return (z) invokeL.objValue;
    }

    private boolean a(ab abVar, t tVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, abVar, tVar)) == null) {
            t a2 = abVar.a().a();
            return a2.g().equals(tVar.g()) && a2.h() == tVar.h() && a2.c().equals(tVar.c());
        }
        return invokeLL.booleanValue;
    }
}
