package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.p;
import com.bytedance.sdk.component.b.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes9.dex */
public class w implements Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<x> f64595a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<k> f64596b;
    public transient /* synthetic */ FieldHolder $fh;
    public final int A;
    public final int B;
    public final int C;

    /* renamed from: c  reason: collision with root package name */
    public final n f64597c;

    /* renamed from: d  reason: collision with root package name */
    public final Proxy f64598d;

    /* renamed from: e  reason: collision with root package name */
    public final List<x> f64599e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f64600f;

    /* renamed from: g  reason: collision with root package name */
    public final List<u> f64601g;

    /* renamed from: h  reason: collision with root package name */
    public final List<u> f64602h;

    /* renamed from: i  reason: collision with root package name */
    public final p.a f64603i;

    /* renamed from: j  reason: collision with root package name */
    public final ProxySelector f64604j;
    public final m k;
    public final c l;
    public final com.bytedance.sdk.component.b.b.a.a.e m;
    public final SocketFactory n;
    public final SSLSocketFactory o;
    public final com.bytedance.sdk.component.b.b.a.i.c p;
    public final HostnameVerifier q;
    public final g r;
    public final b s;
    public final b t;
    public final j u;
    public final o v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final int z;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int A;

        /* renamed from: a  reason: collision with root package name */
        public n f64605a;

        /* renamed from: b  reason: collision with root package name */
        public Proxy f64606b;

        /* renamed from: c  reason: collision with root package name */
        public List<x> f64607c;

        /* renamed from: d  reason: collision with root package name */
        public List<k> f64608d;

        /* renamed from: e  reason: collision with root package name */
        public final List<u> f64609e;

        /* renamed from: f  reason: collision with root package name */
        public final List<u> f64610f;

        /* renamed from: g  reason: collision with root package name */
        public p.a f64611g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f64612h;

        /* renamed from: i  reason: collision with root package name */
        public m f64613i;

        /* renamed from: j  reason: collision with root package name */
        public c f64614j;
        public com.bytedance.sdk.component.b.b.a.a.e k;
        public SocketFactory l;
        public SSLSocketFactory m;
        public com.bytedance.sdk.component.b.b.a.i.c n;
        public HostnameVerifier o;
        public g p;
        public b q;
        public b r;
        public j s;
        public o t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64609e = new ArrayList();
            this.f64610f = new ArrayList();
            this.f64605a = new n();
            this.f64607c = w.f64595a;
            this.f64608d = w.f64596b;
            this.f64611g = p.a(p.f64551a);
            this.f64612h = ProxySelector.getDefault();
            this.f64613i = m.f64542a;
            this.l = SocketFactory.getDefault();
            this.o = com.bytedance.sdk.component.b.b.a.i.e.f64434a;
            this.p = g.f64493a;
            b bVar = b.f64472a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.f64550a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public a a(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, timeUnit)) == null) {
                this.x = com.bytedance.sdk.component.b.b.a.c.a("timeout", j2, timeUnit);
                return this;
            }
            return (a) invokeJL.objValue;
        }

        public a b(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j2, timeUnit)) == null) {
                this.y = com.bytedance.sdk.component.b.b.a.c.a("timeout", j2, timeUnit);
                return this;
            }
            return (a) invokeJL.objValue;
        }

        public a c(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j2, timeUnit)) == null) {
                this.z = com.bytedance.sdk.component.b.b.a.c.a("timeout", j2, timeUnit);
                return this;
            }
            return (a) invokeJL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.u = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.v = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a a(u uVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar)) == null) {
                if (uVar != null) {
                    this.f64609e.add(uVar);
                    return this;
                }
                throw new IllegalArgumentException("interceptor == null");
            }
            return (a) invokeL.objValue;
        }

        public w a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new w(this) : (w) invokeV.objValue;
        }

        public a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f64609e = new ArrayList();
            this.f64610f = new ArrayList();
            this.f64605a = wVar.f64597c;
            this.f64606b = wVar.f64598d;
            this.f64607c = wVar.f64599e;
            this.f64608d = wVar.f64600f;
            this.f64609e.addAll(wVar.f64601g);
            this.f64610f.addAll(wVar.f64602h);
            this.f64611g = wVar.f64603i;
            this.f64612h = wVar.f64604j;
            this.f64613i = wVar.k;
            this.k = wVar.m;
            this.f64614j = wVar.l;
            this.l = wVar.n;
            this.m = wVar.o;
            this.n = wVar.p;
            this.o = wVar.q;
            this.p = wVar.r;
            this.q = wVar.s;
            this.r = wVar.t;
            this.s = wVar.u;
            this.t = wVar.v;
            this.u = wVar.w;
            this.v = wVar.x;
            this.w = wVar.y;
            this.x = wVar.z;
            this.y = wVar.A;
            this.z = wVar.B;
            this.A = wVar.C;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731369219, "Lcom/bytedance/sdk/component/b/b/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731369219, "Lcom/bytedance/sdk/component/b/b/w;");
                return;
            }
        }
        f64595a = com.bytedance.sdk.component.b.b.a.c.a(x.f64618d, x.f64616b);
        f64596b = com.bytedance.sdk.component.b.b.a.c.a(k.f64520a, k.f64522c);
        com.bytedance.sdk.component.b.b.a.a.f64084a = new com.bytedance.sdk.component.b.b.a.a() { // from class: com.bytedance.sdk.component.b.b.w.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public void a(s.a aVar, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, aVar, str) == null) {
                    aVar.a(str);
                }
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public void b(j jVar, com.bytedance.sdk.component.b.b.a.b.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048585, this, jVar, cVar) == null) {
                    jVar.a(cVar);
                }
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public void a(s.a aVar, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048582, this, aVar, str, str2) == null) {
                    aVar.b(str, str2);
                }
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public boolean a(j jVar, com.bytedance.sdk.component.b.b.a.b.c cVar) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar, cVar)) == null) ? jVar.b(cVar) : invokeLL.booleanValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public com.bytedance.sdk.component.b.b.a.b.c a(j jVar, com.bytedance.sdk.component.b.b.a aVar, com.bytedance.sdk.component.b.b.a.b.g gVar, ad adVar) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, aVar, gVar, adVar)) == null) ? jVar.a(aVar, gVar, adVar) : (com.bytedance.sdk.component.b.b.a.b.c) invokeLLLL.objValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public boolean a(com.bytedance.sdk.component.b.b.a aVar, com.bytedance.sdk.component.b.b.a aVar2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048583, this, aVar, aVar2)) == null) ? aVar.a(aVar2) : invokeLL.booleanValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public Socket a(j jVar, com.bytedance.sdk.component.b.b.a aVar, com.bytedance.sdk.component.b.b.a.b.g gVar) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048579, this, jVar, aVar, gVar)) == null) ? jVar.a(aVar, gVar) : (Socket) invokeLLL.objValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public com.bytedance.sdk.component.b.b.a.b.d a(j jVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar)) == null) ? jVar.f64513a : (com.bytedance.sdk.component.b.b.a.b.d) invokeL.objValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public int a(ab.a aVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) ? aVar.f64451c : invokeL.intValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLZ(1048580, this, kVar, sSLSocket, z) == null) {
                    kVar.a(sSLSocket, z);
                }
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w() {
        this(new a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, x509TrustManager)) == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                return sSLContext.getSocketFactory();
            } catch (GeneralSecurityException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("No System TLS", (Exception) e2);
            }
        }
        return (SSLSocketFactory) invokeL.objValue;
    }

    private X509TrustManager z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                    return (X509TrustManager) trustManagers[0];
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("No System TLS", (Exception) e2);
            }
        }
        return (X509TrustManager) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.A : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.B : invokeV.intValue;
    }

    public Proxy d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64598d : (Proxy) invokeV.objValue;
    }

    public ProxySelector e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64604j : (ProxySelector) invokeV.objValue;
    }

    public m f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (m) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.b.a.a.e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c cVar = this.l;
            return cVar != null ? cVar.f64473a : this.m;
        }
        return (com.bytedance.sdk.component.b.b.a.a.e) invokeV.objValue;
    }

    public o h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (o) invokeV.objValue;
    }

    public SocketFactory i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : (SocketFactory) invokeV.objValue;
    }

    public SSLSocketFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (SSLSocketFactory) invokeV.objValue;
    }

    public HostnameVerifier k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.q : (HostnameVerifier) invokeV.objValue;
    }

    public g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.r : (g) invokeV.objValue;
    }

    public b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.t : (b) invokeV.objValue;
    }

    public b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (b) invokeV.objValue;
    }

    public j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u : (j) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public n s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f64597c : (n) invokeV.objValue;
    }

    public List<x> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f64599e : (List) invokeV.objValue;
    }

    public List<k> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f64600f : (List) invokeV.objValue;
    }

    public List<u> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f64601g : (List) invokeV.objValue;
    }

    public List<u> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f64602h : (List) invokeV.objValue;
    }

    public p.a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f64603i : (p.a) invokeV.objValue;
    }

    public a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public w(a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f64597c = aVar.f64605a;
        this.f64598d = aVar.f64606b;
        this.f64599e = aVar.f64607c;
        this.f64600f = aVar.f64608d;
        this.f64601g = com.bytedance.sdk.component.b.b.a.c.a(aVar.f64609e);
        this.f64602h = com.bytedance.sdk.component.b.b.a.c.a(aVar.f64610f);
        this.f64603i = aVar.f64611g;
        this.f64604j = aVar.f64612h;
        this.k = aVar.f64613i;
        this.l = aVar.f64614j;
        this.m = aVar.k;
        this.n = aVar.l;
        loop0: while (true) {
            for (k kVar : this.f64600f) {
                z = z || kVar.a();
            }
        }
        if (aVar.m == null && z) {
            X509TrustManager z2 = z();
            this.o = a(z2);
            this.p = com.bytedance.sdk.component.b.b.a.i.c.a(z2);
        } else {
            this.o = aVar.m;
            this.p = aVar.n;
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        if (!this.f64601g.contains(null)) {
            if (this.f64602h.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f64602h);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f64601g);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.z : invokeV.intValue;
    }

    public e a(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar)) == null) ? y.a(this, zVar, false) : (e) invokeL.objValue;
    }
}
