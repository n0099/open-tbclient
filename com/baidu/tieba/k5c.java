package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b1c;
import com.baidu.tieba.v0c;
import com.baidu.tieba.x0c;
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
public final class k5c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l1c<Throwable> a;
    public static volatile p1c<x0c.a, x0c.a> b;
    public static volatile p1c<b1c.c, b1c.c> c;
    public static volatile p1c<v0c.f, v0c.f> d;
    public static volatile q1c<x0c, x0c.a, x0c.a> e;
    public static volatile q1c<b1c, b1c.c, b1c.c> f;
    public static volatile q1c<v0c, v0c.f, v0c.f> g;
    public static volatile p1c<a1c, a1c> h;
    public static volatile p1c<a1c, a1c> i;
    public static volatile p1c<a1c, a1c> j;
    public static volatile p1c<k1c, k1c> k;
    public static volatile p1c<e1c, e1c> l;
    public static volatile p1c<e1c, e1c> m;
    public static volatile o1c<? extends ScheduledExecutorService> n;
    public static volatile p1c<Throwable, Throwable> o;
    public static volatile p1c<Throwable, Throwable> p;
    public static volatile p1c<Throwable, Throwable> q;
    public static volatile p1c<x0c.b, x0c.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements p1c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.p1c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                n5c.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements p1c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.p1c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                n5c.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements p1c<x0c.a, x0c.a> {
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
        @Override // com.baidu.tieba.p1c
        public x0c.a call(x0c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                n5c.c().d().a(aVar);
                return aVar;
            }
            return (x0c.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements p1c<b1c.c, b1c.c> {
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
        @Override // com.baidu.tieba.p1c
        public b1c.c call(b1c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                n5c.c().g().a(cVar);
                return cVar;
            }
            return (b1c.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements p1c<v0c.f, v0c.f> {
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
        @Override // com.baidu.tieba.p1c
        public v0c.f call(v0c.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                n5c.c().a().a(fVar);
                return fVar;
            }
            return (v0c.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements l1c<Throwable> {
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
        @Override // com.baidu.tieba.l1c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                n5c.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements q1c<x0c, x0c.a, x0c.a> {
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
        @Override // com.baidu.tieba.q1c
        public x0c.a call(x0c x0cVar, x0c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, x0cVar, aVar)) == null) {
                n5c.c().d().e(x0cVar, aVar);
                return aVar;
            }
            return (x0c.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements p1c<e1c, e1c> {
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
        @Override // com.baidu.tieba.p1c
        public e1c call(e1c e1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e1cVar)) == null) {
                n5c.c().d().d(e1cVar);
                return e1cVar;
            }
            return (e1c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements q1c<b1c, b1c.c, b1c.c> {
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
        @Override // com.baidu.tieba.q1c
        public b1c.c call(b1c b1cVar, b1c.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, b1cVar, cVar)) == null) {
                p5c g = n5c.c().g();
                if (g == q5c.e()) {
                    return cVar;
                }
                v2c v2cVar = new v2c(cVar);
                g.d(b1cVar, v2cVar);
                return new s2c(v2cVar);
            }
            return (b1c.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements p1c<e1c, e1c> {
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
        @Override // com.baidu.tieba.p1c
        public e1c call(e1c e1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e1cVar)) == null) {
                n5c.c().g().c(e1cVar);
                return e1cVar;
            }
            return (e1c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements q1c<v0c, v0c.f, v0c.f> {
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
        @Override // com.baidu.tieba.q1c
        public v0c.f call(v0c v0cVar, v0c.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v0cVar, fVar)) == null) {
                n5c.c().a().c(v0cVar, fVar);
                return fVar;
            }
            return (v0c.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements p1c<k1c, k1c> {
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
        @Override // com.baidu.tieba.p1c
        public k1c call(k1c k1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k1cVar)) == null) {
                n5c.c().f().k(k1cVar);
                return k1cVar;
            }
            return (k1c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements p1c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.p1c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                n5c.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements p1c<x0c.b, x0c.b> {
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
        @Override // com.baidu.tieba.p1c
        public x0c.b call(x0c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                n5c.c().d().b(bVar);
                return bVar;
            }
            return (x0c.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947865520, "Lcom/baidu/tieba/k5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947865520, "Lcom/baidu/tieba/k5c;");
                return;
            }
        }
        b();
    }

    public static o1c<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (o1c) invokeV.objValue;
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
            p1c<Throwable, Throwable> p1cVar = q;
            if (p1cVar != null) {
                return p1cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static a1c f(a1c a1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, a1cVar)) == null) {
            p1c<a1c, a1c> p1cVar = h;
            if (p1cVar != null) {
                return p1cVar.call(a1cVar);
            }
            return a1cVar;
        }
        return (a1c) invokeL.objValue;
    }

    public static v0c.f g(v0c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            p1c<v0c.f, v0c.f> p1cVar = d;
            if (p1cVar != null) {
                return p1cVar.call(fVar);
            }
            return fVar;
        }
        return (v0c.f) invokeL.objValue;
    }

    public static <T> x0c.a<T> h(x0c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            p1c<x0c.a, x0c.a> p1cVar = b;
            if (p1cVar != null) {
                return p1cVar.call(aVar);
            }
            return aVar;
        }
        return (x0c.a) invokeL.objValue;
    }

    public static <T> b1c.c<T> i(b1c.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            p1c<b1c.c, b1c.c> p1cVar = c;
            if (p1cVar != null) {
                return p1cVar.call(cVar);
            }
            return cVar;
        }
        return (b1c.c) invokeL.objValue;
    }

    public static a1c k(a1c a1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, a1cVar)) == null) {
            p1c<a1c, a1c> p1cVar = i;
            if (p1cVar != null) {
                return p1cVar.call(a1cVar);
            }
            return a1cVar;
        }
        return (a1c) invokeL.objValue;
    }

    public static a1c l(a1c a1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, a1cVar)) == null) {
            p1c<a1c, a1c> p1cVar = j;
            if (p1cVar != null) {
                return p1cVar.call(a1cVar);
            }
            return a1cVar;
        }
        return (a1c) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            p1c<Throwable, Throwable> p1cVar = o;
            if (p1cVar != null) {
                return p1cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> x0c.b<R, T> n(x0c.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            p1c<x0c.b, x0c.b> p1cVar = r;
            if (p1cVar != null) {
                return p1cVar.call(bVar);
            }
            return bVar;
        }
        return (x0c.b) invokeL.objValue;
    }

    public static e1c o(e1c e1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, e1cVar)) == null) {
            p1c<e1c, e1c> p1cVar = l;
            if (p1cVar != null) {
                return p1cVar.call(e1cVar);
            }
            return e1cVar;
        }
        return (e1c) invokeL.objValue;
    }

    public static k1c q(k1c k1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, k1cVar)) == null) {
            p1c<k1c, k1c> p1cVar = k;
            if (p1cVar != null) {
                return p1cVar.call(k1cVar);
            }
            return k1cVar;
        }
        return (k1c) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            p1c<Throwable, Throwable> p1cVar = p;
            if (p1cVar != null) {
                return p1cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static e1c s(e1c e1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, e1cVar)) == null) {
            p1c<e1c, e1c> p1cVar = m;
            if (p1cVar != null) {
                return p1cVar.call(e1cVar);
            }
            return e1cVar;
        }
        return (e1c) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> v0c.f e(v0c v0cVar, v0c.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, v0cVar, fVar)) == null) {
            q1c<v0c, v0c.f, v0c.f> q1cVar = g;
            if (q1cVar != null) {
                return q1cVar.call(v0cVar, fVar);
            }
            return fVar;
        }
        return (v0c.f) invokeLL.objValue;
    }

    public static <T> x0c.a<T> p(x0c<T> x0cVar, x0c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, x0cVar, aVar)) == null) {
            q1c<x0c, x0c.a, x0c.a> q1cVar = e;
            if (q1cVar != null) {
                return q1cVar.call(x0cVar, aVar);
            }
            return aVar;
        }
        return (x0c.a) invokeLL.objValue;
    }

    public static <T> b1c.c<T> t(b1c<T> b1cVar, b1c.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, b1cVar, cVar)) == null) {
            q1c<b1c, b1c.c, b1c.c> q1cVar = f;
            if (q1cVar != null) {
                return q1cVar.call(b1cVar, cVar);
            }
            return cVar;
        }
        return (b1c.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            l1c<Throwable> l1cVar = a;
            if (l1cVar != null) {
                try {
                    l1cVar.call(th);
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
