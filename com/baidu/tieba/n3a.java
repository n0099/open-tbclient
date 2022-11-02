package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ez9;
import com.baidu.tieba.gz9;
import com.baidu.tieba.kz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public final class n3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uz9<Throwable> a;
    public static volatile yz9<gz9.a, gz9.a> b;
    public static volatile yz9<kz9.c, kz9.c> c;
    public static volatile yz9<ez9.f, ez9.f> d;
    public static volatile zz9<gz9, gz9.a, gz9.a> e;
    public static volatile zz9<kz9, kz9.c, kz9.c> f;
    public static volatile zz9<ez9, ez9.f, ez9.f> g;
    public static volatile yz9<jz9, jz9> h;
    public static volatile yz9<jz9, jz9> i;
    public static volatile yz9<jz9, jz9> j;
    public static volatile yz9<tz9, tz9> k;
    public static volatile yz9<nz9, nz9> l;
    public static volatile yz9<nz9, nz9> m;
    public static volatile xz9<? extends ScheduledExecutorService> n;
    public static volatile yz9<Throwable, Throwable> o;
    public static volatile yz9<Throwable, Throwable> p;
    public static volatile yz9<Throwable, Throwable> q;
    public static volatile yz9<gz9.b, gz9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements yz9<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                q3a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements yz9<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                q3a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements yz9<gz9.a, gz9.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public gz9.a call(gz9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                q3a.c().d().a(aVar);
                return aVar;
            }
            return (gz9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements yz9<kz9.c, kz9.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public kz9.c call(kz9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                q3a.c().g().a(cVar);
                return cVar;
            }
            return (kz9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements yz9<ez9.f, ez9.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public ez9.f call(ez9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                q3a.c().a().a(fVar);
                return fVar;
            }
            return (ez9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements uz9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uz9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                q3a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements zz9<gz9, gz9.a, gz9.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zz9
        public gz9.a call(gz9 gz9Var, gz9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gz9Var, aVar)) == null) {
                q3a.c().d().e(gz9Var, aVar);
                return aVar;
            }
            return (gz9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements yz9<nz9, nz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public nz9 call(nz9 nz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nz9Var)) == null) {
                q3a.c().d().d(nz9Var);
                return nz9Var;
            }
            return (nz9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements zz9<kz9, kz9.c, kz9.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zz9
        public kz9.c call(kz9 kz9Var, kz9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kz9Var, cVar)) == null) {
                s3a g = q3a.c().g();
                if (g == t3a.e()) {
                    return cVar;
                }
                y0a y0aVar = new y0a(cVar);
                g.d(kz9Var, y0aVar);
                return new v0a(y0aVar);
            }
            return (kz9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements yz9<nz9, nz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public nz9 call(nz9 nz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nz9Var)) == null) {
                q3a.c().g().c(nz9Var);
                return nz9Var;
            }
            return (nz9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements zz9<ez9, ez9.f, ez9.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zz9
        public ez9.f call(ez9 ez9Var, ez9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ez9Var, fVar)) == null) {
                q3a.c().a().c(ez9Var, fVar);
                return fVar;
            }
            return (ez9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements yz9<tz9, tz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public tz9 call(tz9 tz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tz9Var)) == null) {
                q3a.c().f().k(tz9Var);
                return tz9Var;
            }
            return (tz9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements yz9<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                q3a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements yz9<gz9.b, gz9.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public gz9.b call(gz9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                q3a.c().d().b(bVar);
                return bVar;
            }
            return (gz9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947952909, "Lcom/baidu/tieba/n3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947952909, "Lcom/baidu/tieba/n3a;");
                return;
            }
        }
        b();
    }

    public static xz9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (xz9) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            b = new c();
            c = new d();
            d = new e();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a = new f();
            e = new g();
            l = new h();
            f = new i();
            m = new j();
            g = new k();
            k = new l();
            o = new m();
            r = new n();
            p = new a();
            q = new b();
            c();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            yz9<Throwable, Throwable> yz9Var = q;
            if (yz9Var != null) {
                return yz9Var.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static jz9 f(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jz9Var)) == null) {
            yz9<jz9, jz9> yz9Var = h;
            if (yz9Var != null) {
                return yz9Var.call(jz9Var);
            }
            return jz9Var;
        }
        return (jz9) invokeL.objValue;
    }

    public static ez9.f g(ez9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            yz9<ez9.f, ez9.f> yz9Var = d;
            if (yz9Var != null) {
                return yz9Var.call(fVar);
            }
            return fVar;
        }
        return (ez9.f) invokeL.objValue;
    }

    public static <T> gz9.a<T> h(gz9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            yz9<gz9.a, gz9.a> yz9Var = b;
            if (yz9Var != null) {
                return yz9Var.call(aVar);
            }
            return aVar;
        }
        return (gz9.a) invokeL.objValue;
    }

    public static <T> kz9.c<T> i(kz9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            yz9<kz9.c, kz9.c> yz9Var = c;
            if (yz9Var != null) {
                return yz9Var.call(cVar);
            }
            return cVar;
        }
        return (kz9.c) invokeL.objValue;
    }

    public static jz9 k(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jz9Var)) == null) {
            yz9<jz9, jz9> yz9Var = i;
            if (yz9Var != null) {
                return yz9Var.call(jz9Var);
            }
            return jz9Var;
        }
        return (jz9) invokeL.objValue;
    }

    public static jz9 l(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jz9Var)) == null) {
            yz9<jz9, jz9> yz9Var = j;
            if (yz9Var != null) {
                return yz9Var.call(jz9Var);
            }
            return jz9Var;
        }
        return (jz9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            yz9<Throwable, Throwable> yz9Var = o;
            if (yz9Var != null) {
                return yz9Var.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> gz9.b<R, T> n(gz9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            yz9<gz9.b, gz9.b> yz9Var = r;
            if (yz9Var != null) {
                return yz9Var.call(bVar);
            }
            return bVar;
        }
        return (gz9.b) invokeL.objValue;
    }

    public static nz9 o(nz9 nz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, nz9Var)) == null) {
            yz9<nz9, nz9> yz9Var = l;
            if (yz9Var != null) {
                return yz9Var.call(nz9Var);
            }
            return nz9Var;
        }
        return (nz9) invokeL.objValue;
    }

    public static tz9 q(tz9 tz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tz9Var)) == null) {
            yz9<tz9, tz9> yz9Var = k;
            if (yz9Var != null) {
                return yz9Var.call(tz9Var);
            }
            return tz9Var;
        }
        return (tz9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            yz9<Throwable, Throwable> yz9Var = p;
            if (yz9Var != null) {
                return yz9Var.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static nz9 s(nz9 nz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, nz9Var)) == null) {
            yz9<nz9, nz9> yz9Var = m;
            if (yz9Var != null) {
                return yz9Var.call(nz9Var);
            }
            return nz9Var;
        }
        return (nz9) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> ez9.f e(ez9 ez9Var, ez9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, ez9Var, fVar)) == null) {
            zz9<ez9, ez9.f, ez9.f> zz9Var = g;
            if (zz9Var != null) {
                return zz9Var.call(ez9Var, fVar);
            }
            return fVar;
        }
        return (ez9.f) invokeLL.objValue;
    }

    public static <T> gz9.a<T> p(gz9<T> gz9Var, gz9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, gz9Var, aVar)) == null) {
            zz9<gz9, gz9.a, gz9.a> zz9Var = e;
            if (zz9Var != null) {
                return zz9Var.call(gz9Var, aVar);
            }
            return aVar;
        }
        return (gz9.a) invokeLL.objValue;
    }

    public static <T> kz9.c<T> t(kz9<T> kz9Var, kz9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, kz9Var, cVar)) == null) {
            zz9<kz9, kz9.c, kz9.c> zz9Var = f;
            if (zz9Var != null) {
                return zz9Var.call(kz9Var, cVar);
            }
            return cVar;
        }
        return (kz9.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            uz9<Throwable> uz9Var = a;
            if (uz9Var != null) {
                try {
                    uz9Var.call(th);
                    return;
                } catch (Throwable th2) {
                    PrintStream printStream = System.err;
                    printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                    th2.printStackTrace();
                    u(th2);
                }
            }
            u(th);
        }
    }
}
