package com.bytedance.sdk.component.b.b.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.s;
import com.bytedance.sdk.component.b.b.a.e.g;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ad;
import com.bytedance.sdk.component.b.b.i;
import com.bytedance.sdk.component.b.b.j;
import com.bytedance.sdk.component.b.b.k;
import com.bytedance.sdk.component.b.b.p;
import com.bytedance.sdk.component.b.b.r;
import com.bytedance.sdk.component.b.b.t;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.x;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.connection.RealConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class c extends g.b implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28080a;

    /* renamed from: b  reason: collision with root package name */
    public int f28081b;

    /* renamed from: c  reason: collision with root package name */
    public int f28082c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Reference<g>> f28083d;

    /* renamed from: e  reason: collision with root package name */
    public long f28084e;

    /* renamed from: g  reason: collision with root package name */
    public final j f28085g;

    /* renamed from: h  reason: collision with root package name */
    public final ad f28086h;

    /* renamed from: i  reason: collision with root package name */
    public Socket f28087i;
    public Socket j;
    public r k;
    public x l;
    public com.bytedance.sdk.component.b.b.a.e.g m;
    public com.bytedance.sdk.component.b.a.e n;
    public com.bytedance.sdk.component.b.a.d o;

    public c(j jVar, ad adVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, adVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28082c = 1;
        this.f28083d = new ArrayList();
        this.f28084e = Long.MAX_VALUE;
        this.f28085g = jVar;
        this.f28086h = adVar;
    }

    private z f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? new z.a().a(this.f28086h.a().a()).a("Host", com.bytedance.sdk.component.b.b.a.c.a(this.f28086h.a().a(), true)).a("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).a("User-Agent", com.bytedance.sdk.component.b.b.a.d.a()).d() : (z) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081 A[Catch: IOException -> 0x00e5, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e5, blocks: (B:18:0x0079, B:20:0x0081), top: B:63:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, int i3, int i4, boolean z, com.bytedance.sdk.component.b.b.e eVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), eVar, pVar}) == null) {
            if (this.l == null) {
                List<k> f2 = this.f28086h.a().f();
                b bVar = new b(f2);
                if (this.f28086h.a().i() == null) {
                    if (f2.contains(k.f28460c)) {
                        String g2 = this.f28086h.a().a().g();
                        if (!com.bytedance.sdk.component.b.b.a.g.e.b().b(g2)) {
                            throw new e(new UnknownServiceException("CLEARTEXT communication to " + g2 + " not permitted by network security policy"));
                        }
                    } else {
                        throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                    }
                }
                e eVar2 = null;
                do {
                    try {
                        if (!this.f28086h.d()) {
                            a(i2, i3, i4, eVar, pVar);
                            if (this.f28087i == null) {
                                if (!this.f28086h.d() && this.f28087i == null) {
                                    throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
                                }
                                if (this.m != null) {
                                    synchronized (this.f28085g) {
                                        this.f28082c = this.m.a();
                                    }
                                    return;
                                }
                                return;
                            }
                        } else {
                            try {
                                a(i2, i3, eVar, pVar);
                            } catch (IOException e2) {
                                e = e2;
                                com.bytedance.sdk.component.b.b.a.c.a(this.j);
                                com.bytedance.sdk.component.b.b.a.c.a(this.f28087i);
                                this.j = null;
                                this.f28087i = null;
                                this.n = null;
                                this.o = null;
                                this.k = null;
                                this.l = null;
                                this.m = null;
                                pVar.a(eVar, this.f28086h.c(), this.f28086h.b(), null, e);
                                if (eVar2 == null) {
                                    eVar2 = new e(e);
                                } else {
                                    eVar2.a(e);
                                }
                                if (!z || bVar.a(e)) {
                                    throw eVar2;
                                }
                                do {
                                    if (!this.f28086h.d()) {
                                    }
                                    a(bVar, eVar, pVar);
                                    pVar.a(eVar, this.f28086h.c(), this.f28086h.b(), this.l);
                                    if (!this.f28086h.d()) {
                                    }
                                    if (this.m != null) {
                                    }
                                } while (bVar.a(e));
                                throw eVar2;
                            }
                        }
                        a(bVar, eVar, pVar);
                        pVar.a(eVar, this.f28086h.c(), this.f28086h.b(), this.l);
                        if (!this.f28086h.d()) {
                        }
                        if (this.m != null) {
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } while (bVar.a(e));
                throw eVar2;
            }
            throw new IllegalStateException("already connected");
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.bytedance.sdk.component.b.b.a.c.a(this.f28087i);
        }
    }

    public Socket c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (Socket) invokeV.objValue;
    }

    public r d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (r) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Connection{");
            sb.append(this.f28086h.a().a().g());
            sb.append(":");
            sb.append(this.f28086h.a().a().h());
            sb.append(", proxy=");
            sb.append(this.f28086h.b());
            sb.append(" hostAddress=");
            sb.append(this.f28086h.c());
            sb.append(" cipherSuite=");
            r rVar = this.k;
            sb.append(rVar != null ? rVar.a() : "none");
            sb.append(" protocol=");
            sb.append(this.l);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private void a(int i2, int i3, int i4, com.bytedance.sdk.component.b.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, pVar}) == null) {
            z f2 = f();
            t a2 = f2.a();
            for (int i5 = 0; i5 < 21; i5++) {
                a(i2, i3, eVar, pVar);
                f2 = a(i3, i4, f2, a2);
                if (f2 == null) {
                    return;
                }
                com.bytedance.sdk.component.b.b.a.c.a(this.f28087i);
                this.f28087i = null;
                this.o = null;
                this.n = null;
                pVar.a(eVar, this.f28086h.c(), this.f28086h.b(), null);
            }
        }
    }

    private void a(int i2, int i3, com.bytedance.sdk.component.b.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, pVar}) == null) {
            Proxy b2 = this.f28086h.b();
            this.f28087i = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f28086h.a().c().createSocket() : new Socket(b2);
            pVar.a(eVar, this.f28086h.c(), b2);
            this.f28087i.setSoTimeout(i3);
            try {
                com.bytedance.sdk.component.b.b.a.g.e.b().a(this.f28087i, this.f28086h.c(), i2);
                try {
                    this.n = l.a(l.b(this.f28087i));
                    this.o = l.a(l.a(this.f28087i));
                } catch (NullPointerException e2) {
                    if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                        throw new IOException(e2);
                    }
                }
            } catch (ConnectException e3) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.f28086h.c());
                connectException.initCause(e3);
                throw connectException;
            }
        }
    }

    private void a(b bVar, com.bytedance.sdk.component.b.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, bVar, eVar, pVar) == null) {
            if (this.f28086h.a().i() == null) {
                this.l = x.f28550b;
                this.j = this.f28087i;
                return;
            }
            pVar.b(eVar);
            a(bVar);
            pVar.a(eVar, this.k);
            if (this.l == x.f28552d) {
                this.j.setSoTimeout(0);
                com.bytedance.sdk.component.b.b.a.e.g a2 = new g.a(true).a(this.j, this.f28086h.a().a().g(), this.n, this.o).a(this).a();
                this.m = a2;
                a2.c();
            }
        }
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, bVar) == null) {
            com.bytedance.sdk.component.b.b.a a2 = this.f28086h.a();
            SSLSocket sSLSocket2 = null;
            try {
                try {
                    sSLSocket = (SSLSocket) a2.i().createSocket(this.f28087i, a2.a().g(), a2.a().h(), true);
                } catch (AssertionError e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                k a3 = bVar.a(sSLSocket);
                if (a3.d()) {
                    com.bytedance.sdk.component.b.b.a.g.e.b().a(sSLSocket, a2.a().g(), a2.e());
                }
                sSLSocket.startHandshake();
                r a4 = r.a(sSLSocket.getSession());
                if (a2.j().verify(a2.a().g(), sSLSocket.getSession())) {
                    a2.k().a(a2.a().g(), a4.b());
                    String a5 = a3.d() ? com.bytedance.sdk.component.b.b.a.g.e.b().a(sSLSocket) : null;
                    this.j = sSLSocket;
                    this.n = l.a(l.b(sSLSocket));
                    this.o = l.a(l.a(this.j));
                    this.k = a4;
                    this.l = a5 != null ? x.a(a5) : x.f28550b;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.component.b.b.a.g.e.b().b(sSLSocket);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) a4.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + a2.a().g() + " not verified:\n    certificate: " + com.bytedance.sdk.component.b.b.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.b.b.a.i.e.a(x509Certificate));
            } catch (AssertionError e3) {
                e = e3;
                if (!com.bytedance.sdk.component.b.b.a.c.a(e)) {
                    throw e;
                }
                throw new IOException(e);
            } catch (Throwable th2) {
                th = th2;
                sSLSocket2 = sSLSocket;
                if (sSLSocket2 != null) {
                    com.bytedance.sdk.component.b.b.a.g.e.b().b(sSLSocket2);
                }
                com.bytedance.sdk.component.b.b.a.c.a((Socket) sSLSocket2);
                throw th;
            }
        }
    }

    private z a(int i2, int i3, z zVar, t tVar) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), zVar, tVar})) != null) {
            return (z) invokeCommon.objValue;
        }
        String str = "CONNECT " + com.bytedance.sdk.component.b.b.a.c.a(tVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.b.b.a.d.a aVar = new com.bytedance.sdk.component.b.b.a.d.a(null, null, this.n, this.o);
            this.n.a().a(i2, TimeUnit.MILLISECONDS);
            this.o.a().a(i3, TimeUnit.MILLISECONDS);
            aVar.a(zVar.c(), str);
            aVar.b();
            ab a2 = aVar.a(false).a(zVar).a();
            long a3 = com.bytedance.sdk.component.b.b.a.c.e.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            s b2 = aVar.b(a3);
            com.bytedance.sdk.component.b.b.a.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int c2 = a2.c();
            if (c2 == 200) {
                if (this.n.c().e() && this.o.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (c2 == 407) {
                z a4 = this.f28086h.a().d().a(this.f28086h, a2);
                if (a4 != null) {
                    if (IntentConfig.CLOSE.equalsIgnoreCase(a2.a(HTTP.CONN_DIRECTIVE))) {
                        return a4;
                    }
                    zVar = a4;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a2.c());
            }
        }
    }

    public boolean a(com.bytedance.sdk.component.b.b.a aVar, ad adVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, adVar)) == null) {
            if (this.f28083d.size() >= this.f28082c || this.f28080a || !com.bytedance.sdk.component.b.b.a.a.f28036a.a(this.f28086h.a(), aVar)) {
                return false;
            }
            if (aVar.a().g().equals(a().a().a().g())) {
                return true;
            }
            if (this.m != null && adVar != null && adVar.b().type() == Proxy.Type.DIRECT && this.f28086h.b().type() == Proxy.Type.DIRECT && this.f28086h.c().equals(adVar.c()) && adVar.a().j() == com.bytedance.sdk.component.b.b.a.i.e.f28376a && a(aVar.a())) {
                try {
                    aVar.k().a(aVar.a().g(), d().b());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tVar)) == null) {
            if (tVar.h() != this.f28086h.a().a().h()) {
                return false;
            }
            if (tVar.g().equals(this.f28086h.a().a().g())) {
                return true;
            }
            return this.k != null && com.bytedance.sdk.component.b.b.a.i.e.f28376a.a(tVar.g(), (X509Certificate) this.k.b().get(0));
        }
        return invokeL.booleanValue;
    }

    public com.bytedance.sdk.component.b.b.a.c.c a(w wVar, u.a aVar, g gVar) throws SocketException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, wVar, aVar, gVar)) == null) {
            if (this.m != null) {
                return new com.bytedance.sdk.component.b.b.a.e.f(wVar, aVar, gVar, this.m);
            }
            this.j.setSoTimeout(aVar.c());
            this.n.a().a(aVar.c(), TimeUnit.MILLISECONDS);
            this.o.a().a(aVar.d(), TimeUnit.MILLISECONDS);
            return new com.bytedance.sdk.component.b.b.a.d.a(wVar, gVar, this.n, this.o);
        }
        return (com.bytedance.sdk.component.b.b.a.c.c) invokeLLL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.i
    public ad a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28086h : (ad) invokeV.objValue;
    }

    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
                return false;
            }
            com.bytedance.sdk.component.b.b.a.e.g gVar = this.m;
            if (gVar != null) {
                return !gVar.d();
            }
            if (z) {
                try {
                    int soTimeout = this.j.getSoTimeout();
                    try {
                        this.j.setSoTimeout(1);
                        return !this.n.e();
                    } finally {
                        this.j.setSoTimeout(soTimeout);
                    }
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.e.g.b
    public void a(com.bytedance.sdk.component.b.b.a.e.i iVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            iVar.a(com.bytedance.sdk.component.b.b.a.e.b.f28178e);
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.e.g.b
    public void a(com.bytedance.sdk.component.b.b.a.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            synchronized (this.f28085g) {
                this.f28082c = gVar.a();
            }
        }
    }
}
