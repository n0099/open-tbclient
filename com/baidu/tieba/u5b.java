package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l1b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.r1b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public final class u5b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b2b<Throwable> a;
    public static volatile f2b<n1b.a, n1b.a> b;
    public static volatile f2b<r1b.c, r1b.c> c;
    public static volatile f2b<l1b.f, l1b.f> d;
    public static volatile g2b<n1b, n1b.a, n1b.a> e;
    public static volatile g2b<r1b, r1b.c, r1b.c> f;
    public static volatile g2b<l1b, l1b.f, l1b.f> g;
    public static volatile f2b<q1b, q1b> h;
    public static volatile f2b<q1b, q1b> i;
    public static volatile f2b<q1b, q1b> j;
    public static volatile f2b<a2b, a2b> k;
    public static volatile f2b<u1b, u1b> l;
    public static volatile f2b<u1b, u1b> m;
    public static volatile e2b<? extends ScheduledExecutorService> n;
    public static volatile f2b<Throwable, Throwable> o;
    public static volatile f2b<Throwable, Throwable> p;
    public static volatile f2b<Throwable, Throwable> q;
    public static volatile f2b<n1b.b, n1b.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements f2b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.f2b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                x5b.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f2b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.f2b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                x5b.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements f2b<n1b.a, n1b.a> {
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
        @Override // com.baidu.tieba.f2b
        public n1b.a call(n1b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                x5b.c().d().a(aVar);
                return aVar;
            }
            return (n1b.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements f2b<r1b.c, r1b.c> {
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
        @Override // com.baidu.tieba.f2b
        public r1b.c call(r1b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                x5b.c().g().a(cVar);
                return cVar;
            }
            return (r1b.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements f2b<l1b.f, l1b.f> {
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
        @Override // com.baidu.tieba.f2b
        public l1b.f call(l1b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                x5b.c().a().a(fVar);
                return fVar;
            }
            return (l1b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements b2b<Throwable> {
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
        @Override // com.baidu.tieba.b2b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                x5b.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements g2b<n1b, n1b.a, n1b.a> {
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
        @Override // com.baidu.tieba.g2b
        public n1b.a call(n1b n1bVar, n1b.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n1bVar, aVar)) == null) {
                x5b.c().d().e(n1bVar, aVar);
                return aVar;
            }
            return (n1b.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements f2b<u1b, u1b> {
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
        @Override // com.baidu.tieba.f2b
        public u1b call(u1b u1bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u1bVar)) == null) {
                x5b.c().d().d(u1bVar);
                return u1bVar;
            }
            return (u1b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements g2b<r1b, r1b.c, r1b.c> {
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
        @Override // com.baidu.tieba.g2b
        public r1b.c call(r1b r1bVar, r1b.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r1bVar, cVar)) == null) {
                z5b g = x5b.c().g();
                if (g == a6b.e()) {
                    return cVar;
                }
                f3b f3bVar = new f3b(cVar);
                g.d(r1bVar, f3bVar);
                return new c3b(f3bVar);
            }
            return (r1b.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements f2b<u1b, u1b> {
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
        @Override // com.baidu.tieba.f2b
        public u1b call(u1b u1bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u1bVar)) == null) {
                x5b.c().g().c(u1bVar);
                return u1bVar;
            }
            return (u1b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements g2b<l1b, l1b.f, l1b.f> {
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
        @Override // com.baidu.tieba.g2b
        public l1b.f call(l1b l1bVar, l1b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l1bVar, fVar)) == null) {
                x5b.c().a().c(l1bVar, fVar);
                return fVar;
            }
            return (l1b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements f2b<a2b, a2b> {
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
        @Override // com.baidu.tieba.f2b
        public a2b call(a2b a2bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2bVar)) == null) {
                x5b.c().f().k(a2bVar);
                return a2bVar;
            }
            return (a2b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements f2b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.f2b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                x5b.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements f2b<n1b.b, n1b.b> {
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
        @Override // com.baidu.tieba.f2b
        public n1b.b call(n1b.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                x5b.c().d().b(bVar);
                return bVar;
            }
            return (n1b.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163399, "Lcom/baidu/tieba/u5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163399, "Lcom/baidu/tieba/u5b;");
                return;
            }
        }
        b();
    }

    public static e2b<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (e2b) invokeV.objValue;
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
            f2b<Throwable, Throwable> f2bVar = q;
            if (f2bVar != null) {
                return f2bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static q1b f(q1b q1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, q1bVar)) == null) {
            f2b<q1b, q1b> f2bVar = h;
            if (f2bVar != null) {
                return f2bVar.call(q1bVar);
            }
            return q1bVar;
        }
        return (q1b) invokeL.objValue;
    }

    public static l1b.f g(l1b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            f2b<l1b.f, l1b.f> f2bVar = d;
            if (f2bVar != null) {
                return f2bVar.call(fVar);
            }
            return fVar;
        }
        return (l1b.f) invokeL.objValue;
    }

    public static <T> n1b.a<T> h(n1b.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            f2b<n1b.a, n1b.a> f2bVar = b;
            if (f2bVar != null) {
                return f2bVar.call(aVar);
            }
            return aVar;
        }
        return (n1b.a) invokeL.objValue;
    }

    public static <T> r1b.c<T> i(r1b.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            f2b<r1b.c, r1b.c> f2bVar = c;
            if (f2bVar != null) {
                return f2bVar.call(cVar);
            }
            return cVar;
        }
        return (r1b.c) invokeL.objValue;
    }

    public static q1b k(q1b q1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, q1bVar)) == null) {
            f2b<q1b, q1b> f2bVar = i;
            if (f2bVar != null) {
                return f2bVar.call(q1bVar);
            }
            return q1bVar;
        }
        return (q1b) invokeL.objValue;
    }

    public static q1b l(q1b q1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, q1bVar)) == null) {
            f2b<q1b, q1b> f2bVar = j;
            if (f2bVar != null) {
                return f2bVar.call(q1bVar);
            }
            return q1bVar;
        }
        return (q1b) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            f2b<Throwable, Throwable> f2bVar = o;
            if (f2bVar != null) {
                return f2bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> n1b.b<R, T> n(n1b.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            f2b<n1b.b, n1b.b> f2bVar = r;
            if (f2bVar != null) {
                return f2bVar.call(bVar);
            }
            return bVar;
        }
        return (n1b.b) invokeL.objValue;
    }

    public static u1b o(u1b u1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, u1bVar)) == null) {
            f2b<u1b, u1b> f2bVar = l;
            if (f2bVar != null) {
                return f2bVar.call(u1bVar);
            }
            return u1bVar;
        }
        return (u1b) invokeL.objValue;
    }

    public static a2b q(a2b a2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, a2bVar)) == null) {
            f2b<a2b, a2b> f2bVar = k;
            if (f2bVar != null) {
                return f2bVar.call(a2bVar);
            }
            return a2bVar;
        }
        return (a2b) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            f2b<Throwable, Throwable> f2bVar = p;
            if (f2bVar != null) {
                return f2bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static u1b s(u1b u1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, u1bVar)) == null) {
            f2b<u1b, u1b> f2bVar = m;
            if (f2bVar != null) {
                return f2bVar.call(u1bVar);
            }
            return u1bVar;
        }
        return (u1b) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> l1b.f e(l1b l1bVar, l1b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, l1bVar, fVar)) == null) {
            g2b<l1b, l1b.f, l1b.f> g2bVar = g;
            if (g2bVar != null) {
                return g2bVar.call(l1bVar, fVar);
            }
            return fVar;
        }
        return (l1b.f) invokeLL.objValue;
    }

    public static <T> n1b.a<T> p(n1b<T> n1bVar, n1b.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, n1bVar, aVar)) == null) {
            g2b<n1b, n1b.a, n1b.a> g2bVar = e;
            if (g2bVar != null) {
                return g2bVar.call(n1bVar, aVar);
            }
            return aVar;
        }
        return (n1b.a) invokeLL.objValue;
    }

    public static <T> r1b.c<T> t(r1b<T> r1bVar, r1b.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, r1bVar, cVar)) == null) {
            g2b<r1b, r1b.c, r1b.c> g2bVar = f;
            if (g2bVar != null) {
                return g2bVar.call(r1bVar, cVar);
            }
            return cVar;
        }
        return (r1b.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            b2b<Throwable> b2bVar = a;
            if (b2bVar != null) {
                try {
                    b2bVar.call(th);
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
