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
    public static final List<x> f65321a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<k> f65322b;
    public transient /* synthetic */ FieldHolder $fh;
    public final int A;
    public final int B;
    public final int C;

    /* renamed from: c  reason: collision with root package name */
    public final n f65323c;

    /* renamed from: d  reason: collision with root package name */
    public final Proxy f65324d;

    /* renamed from: e  reason: collision with root package name */
    public final List<x> f65325e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f65326f;

    /* renamed from: g  reason: collision with root package name */
    public final List<u> f65327g;

    /* renamed from: h  reason: collision with root package name */
    public final List<u> f65328h;

    /* renamed from: i  reason: collision with root package name */
    public final p.a f65329i;

    /* renamed from: j  reason: collision with root package name */
    public final ProxySelector f65330j;
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
        public n f65331a;

        /* renamed from: b  reason: collision with root package name */
        public Proxy f65332b;

        /* renamed from: c  reason: collision with root package name */
        public List<x> f65333c;

        /* renamed from: d  reason: collision with root package name */
        public List<k> f65334d;

        /* renamed from: e  reason: collision with root package name */
        public final List<u> f65335e;

        /* renamed from: f  reason: collision with root package name */
        public final List<u> f65336f;

        /* renamed from: g  reason: collision with root package name */
        public p.a f65337g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f65338h;

        /* renamed from: i  reason: collision with root package name */
        public m f65339i;

        /* renamed from: j  reason: collision with root package name */
        public c f65340j;
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
            this.f65335e = new ArrayList();
            this.f65336f = new ArrayList();
            this.f65331a = new n();
            this.f65333c = w.f65321a;
            this.f65334d = w.f65322b;
            this.f65337g = p.a(p.f65277a);
            this.f65338h = ProxySelector.getDefault();
            this.f65339i = m.f65268a;
            this.l = SocketFactory.getDefault();
            this.o = com.bytedance.sdk.component.b.b.a.i.e.f65160a;
            this.p = g.f65219a;
            b bVar = b.f65198a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.f65276a;
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
                    this.f65335e.add(uVar);
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
            this.f65335e = new ArrayList();
            this.f65336f = new ArrayList();
            this.f65331a = wVar.f65323c;
            this.f65332b = wVar.f65324d;
            this.f65333c = wVar.f65325e;
            this.f65334d = wVar.f65326f;
            this.f65335e.addAll(wVar.f65327g);
            this.f65336f.addAll(wVar.f65328h);
            this.f65337g = wVar.f65329i;
            this.f65338h = wVar.f65330j;
            this.f65339i = wVar.k;
            this.k = wVar.m;
            this.f65340j = wVar.l;
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
        f65321a = com.bytedance.sdk.component.b.b.a.c.a(x.f65344d, x.f65342b);
        f65322b = com.bytedance.sdk.component.b.b.a.c.a(k.f65246a, k.f65248c);
        com.bytedance.sdk.component.b.b.a.a.f64810a = new com.bytedance.sdk.component.b.b.a.a() { // from class: com.bytedance.sdk.component.b.b.w.1
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
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar)) == null) ? jVar.f65239a : (com.bytedance.sdk.component.b.b.a.b.d) invokeL.objValue;
            }

            @Override // com.bytedance.sdk.component.b.b.a.a
            public int a(ab.a aVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) ? aVar.f65177c : invokeL.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65324d : (Proxy) invokeV.objValue;
    }

    public ProxySelector e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65330j : (ProxySelector) invokeV.objValue;
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
            return cVar != null ? cVar.f65199a : this.m;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f65323c : (n) invokeV.objValue;
    }

    public List<x> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f65325e : (List) invokeV.objValue;
    }

    public List<k> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f65326f : (List) invokeV.objValue;
    }

    public List<u> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f65327g : (List) invokeV.objValue;
    }

    public List<u> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f65328h : (List) invokeV.objValue;
    }

    public p.a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f65329i : (p.a) invokeV.objValue;
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
        this.f65323c = aVar.f65331a;
        this.f65324d = aVar.f65332b;
        this.f65325e = aVar.f65333c;
        this.f65326f = aVar.f65334d;
        this.f65327g = com.bytedance.sdk.component.b.b.a.c.a(aVar.f65335e);
        this.f65328h = com.bytedance.sdk.component.b.b.a.c.a(aVar.f65336f);
        this.f65329i = aVar.f65337g;
        this.f65330j = aVar.f65338h;
        this.k = aVar.f65339i;
        this.l = aVar.f65340j;
        this.m = aVar.k;
        this.n = aVar.l;
        loop0: while (true) {
            for (k kVar : this.f65326f) {
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
        if (!this.f65327g.contains(null)) {
            if (this.f65328h.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f65328h);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f65327g);
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
