package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f7b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.l7b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public final class rbb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v7b<Throwable> a;
    public static volatile z7b<h7b.a, h7b.a> b;
    public static volatile z7b<l7b.c, l7b.c> c;
    public static volatile z7b<f7b.f, f7b.f> d;
    public static volatile a8b<h7b, h7b.a, h7b.a> e;
    public static volatile a8b<l7b, l7b.c, l7b.c> f;
    public static volatile a8b<f7b, f7b.f, f7b.f> g;
    public static volatile z7b<k7b, k7b> h;
    public static volatile z7b<k7b, k7b> i;
    public static volatile z7b<k7b, k7b> j;
    public static volatile z7b<u7b, u7b> k;
    public static volatile z7b<o7b, o7b> l;
    public static volatile z7b<o7b, o7b> m;
    public static volatile y7b<? extends ScheduledExecutorService> n;
    public static volatile z7b<Throwable, Throwable> o;
    public static volatile z7b<Throwable, Throwable> p;
    public static volatile z7b<Throwable, Throwable> q;
    public static volatile z7b<h7b.b, h7b.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements z7b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.z7b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ubb.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements z7b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.z7b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ubb.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements z7b<h7b.a, h7b.a> {
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
        @Override // com.baidu.tieba.z7b
        public h7b.a call(h7b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                ubb.c().d().a(aVar);
                return aVar;
            }
            return (h7b.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements z7b<l7b.c, l7b.c> {
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
        @Override // com.baidu.tieba.z7b
        public l7b.c call(l7b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                ubb.c().g().a(cVar);
                return cVar;
            }
            return (l7b.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements z7b<f7b.f, f7b.f> {
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
        @Override // com.baidu.tieba.z7b
        public f7b.f call(f7b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                ubb.c().a().a(fVar);
                return fVar;
            }
            return (f7b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements v7b<Throwable> {
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
        @Override // com.baidu.tieba.v7b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                ubb.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements a8b<h7b, h7b.a, h7b.a> {
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
        @Override // com.baidu.tieba.a8b
        public h7b.a call(h7b h7bVar, h7b.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h7bVar, aVar)) == null) {
                ubb.c().d().e(h7bVar, aVar);
                return aVar;
            }
            return (h7b.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements z7b<o7b, o7b> {
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
        @Override // com.baidu.tieba.z7b
        public o7b call(o7b o7bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o7bVar)) == null) {
                ubb.c().d().d(o7bVar);
                return o7bVar;
            }
            return (o7b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements a8b<l7b, l7b.c, l7b.c> {
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
        @Override // com.baidu.tieba.a8b
        public l7b.c call(l7b l7bVar, l7b.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l7bVar, cVar)) == null) {
                wbb g = ubb.c().g();
                if (g == xbb.e()) {
                    return cVar;
                }
                c9b c9bVar = new c9b(cVar);
                g.d(l7bVar, c9bVar);
                return new z8b(c9bVar);
            }
            return (l7b.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements z7b<o7b, o7b> {
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
        @Override // com.baidu.tieba.z7b
        public o7b call(o7b o7bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o7bVar)) == null) {
                ubb.c().g().c(o7bVar);
                return o7bVar;
            }
            return (o7b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements a8b<f7b, f7b.f, f7b.f> {
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
        @Override // com.baidu.tieba.a8b
        public f7b.f call(f7b f7bVar, f7b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f7bVar, fVar)) == null) {
                ubb.c().a().c(f7bVar, fVar);
                return fVar;
            }
            return (f7b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements z7b<u7b, u7b> {
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
        @Override // com.baidu.tieba.z7b
        public u7b call(u7b u7bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u7bVar)) == null) {
                ubb.c().f().k(u7bVar);
                return u7bVar;
            }
            return (u7b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements z7b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.z7b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ubb.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements z7b<h7b.b, h7b.b> {
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
        @Override // com.baidu.tieba.z7b
        public h7b.b call(h7b.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                ubb.c().d().b(bVar);
                return bVar;
            }
            return (h7b.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117271, "Lcom/baidu/tieba/rbb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117271, "Lcom/baidu/tieba/rbb;");
                return;
            }
        }
        b();
    }

    public static y7b<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (y7b) invokeV.objValue;
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
            z7b<Throwable, Throwable> z7bVar = q;
            if (z7bVar != null) {
                return z7bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static k7b f(k7b k7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, k7bVar)) == null) {
            z7b<k7b, k7b> z7bVar = h;
            if (z7bVar != null) {
                return z7bVar.call(k7bVar);
            }
            return k7bVar;
        }
        return (k7b) invokeL.objValue;
    }

    public static f7b.f g(f7b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            z7b<f7b.f, f7b.f> z7bVar = d;
            if (z7bVar != null) {
                return z7bVar.call(fVar);
            }
            return fVar;
        }
        return (f7b.f) invokeL.objValue;
    }

    public static <T> h7b.a<T> h(h7b.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            z7b<h7b.a, h7b.a> z7bVar = b;
            if (z7bVar != null) {
                return z7bVar.call(aVar);
            }
            return aVar;
        }
        return (h7b.a) invokeL.objValue;
    }

    public static <T> l7b.c<T> i(l7b.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            z7b<l7b.c, l7b.c> z7bVar = c;
            if (z7bVar != null) {
                return z7bVar.call(cVar);
            }
            return cVar;
        }
        return (l7b.c) invokeL.objValue;
    }

    public static k7b k(k7b k7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, k7bVar)) == null) {
            z7b<k7b, k7b> z7bVar = i;
            if (z7bVar != null) {
                return z7bVar.call(k7bVar);
            }
            return k7bVar;
        }
        return (k7b) invokeL.objValue;
    }

    public static k7b l(k7b k7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, k7bVar)) == null) {
            z7b<k7b, k7b> z7bVar = j;
            if (z7bVar != null) {
                return z7bVar.call(k7bVar);
            }
            return k7bVar;
        }
        return (k7b) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            z7b<Throwable, Throwable> z7bVar = o;
            if (z7bVar != null) {
                return z7bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> h7b.b<R, T> n(h7b.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            z7b<h7b.b, h7b.b> z7bVar = r;
            if (z7bVar != null) {
                return z7bVar.call(bVar);
            }
            return bVar;
        }
        return (h7b.b) invokeL.objValue;
    }

    public static o7b o(o7b o7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, o7bVar)) == null) {
            z7b<o7b, o7b> z7bVar = l;
            if (z7bVar != null) {
                return z7bVar.call(o7bVar);
            }
            return o7bVar;
        }
        return (o7b) invokeL.objValue;
    }

    public static u7b q(u7b u7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, u7bVar)) == null) {
            z7b<u7b, u7b> z7bVar = k;
            if (z7bVar != null) {
                return z7bVar.call(u7bVar);
            }
            return u7bVar;
        }
        return (u7b) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            z7b<Throwable, Throwable> z7bVar = p;
            if (z7bVar != null) {
                return z7bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static o7b s(o7b o7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, o7bVar)) == null) {
            z7b<o7b, o7b> z7bVar = m;
            if (z7bVar != null) {
                return z7bVar.call(o7bVar);
            }
            return o7bVar;
        }
        return (o7b) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> f7b.f e(f7b f7bVar, f7b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, f7bVar, fVar)) == null) {
            a8b<f7b, f7b.f, f7b.f> a8bVar = g;
            if (a8bVar != null) {
                return a8bVar.call(f7bVar, fVar);
            }
            return fVar;
        }
        return (f7b.f) invokeLL.objValue;
    }

    public static <T> h7b.a<T> p(h7b<T> h7bVar, h7b.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, h7bVar, aVar)) == null) {
            a8b<h7b, h7b.a, h7b.a> a8bVar = e;
            if (a8bVar != null) {
                return a8bVar.call(h7bVar, aVar);
            }
            return aVar;
        }
        return (h7b.a) invokeLL.objValue;
    }

    public static <T> l7b.c<T> t(l7b<T> l7bVar, l7b.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, l7bVar, cVar)) == null) {
            a8b<l7b, l7b.c, l7b.c> a8bVar = f;
            if (a8bVar != null) {
                return a8bVar.call(l7bVar, cVar);
            }
            return cVar;
        }
        return (l7b.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            v7b<Throwable> v7bVar = a;
            if (v7bVar != null) {
                try {
                    v7bVar.call(th);
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
