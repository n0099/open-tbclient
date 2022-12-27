package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a3a;
import com.baidu.tieba.c3a;
import com.baidu.tieba.g3a;
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
public final class j7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q3a<Throwable> a;
    public static volatile u3a<c3a.a, c3a.a> b;
    public static volatile u3a<g3a.c, g3a.c> c;
    public static volatile u3a<a3a.f, a3a.f> d;
    public static volatile v3a<c3a, c3a.a, c3a.a> e;
    public static volatile v3a<g3a, g3a.c, g3a.c> f;
    public static volatile v3a<a3a, a3a.f, a3a.f> g;
    public static volatile u3a<f3a, f3a> h;
    public static volatile u3a<f3a, f3a> i;
    public static volatile u3a<f3a, f3a> j;
    public static volatile u3a<p3a, p3a> k;
    public static volatile u3a<j3a, j3a> l;
    public static volatile u3a<j3a, j3a> m;
    public static volatile t3a<? extends ScheduledExecutorService> n;
    public static volatile u3a<Throwable, Throwable> o;
    public static volatile u3a<Throwable, Throwable> p;
    public static volatile u3a<Throwable, Throwable> q;
    public static volatile u3a<c3a.b, c3a.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements u3a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.u3a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                m7a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements u3a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.u3a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                m7a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements u3a<c3a.a, c3a.a> {
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
        @Override // com.baidu.tieba.u3a
        public c3a.a call(c3a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                m7a.c().d().a(aVar);
                return aVar;
            }
            return (c3a.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements u3a<g3a.c, g3a.c> {
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
        @Override // com.baidu.tieba.u3a
        public g3a.c call(g3a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                m7a.c().g().a(cVar);
                return cVar;
            }
            return (g3a.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements u3a<a3a.f, a3a.f> {
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
        @Override // com.baidu.tieba.u3a
        public a3a.f call(a3a.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                m7a.c().a().a(fVar);
                return fVar;
            }
            return (a3a.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements q3a<Throwable> {
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
        @Override // com.baidu.tieba.q3a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                m7a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements v3a<c3a, c3a.a, c3a.a> {
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
        @Override // com.baidu.tieba.v3a
        public c3a.a call(c3a c3aVar, c3a.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c3aVar, aVar)) == null) {
                m7a.c().d().e(c3aVar, aVar);
                return aVar;
            }
            return (c3a.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements u3a<j3a, j3a> {
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
        @Override // com.baidu.tieba.u3a
        public j3a call(j3a j3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j3aVar)) == null) {
                m7a.c().d().d(j3aVar);
                return j3aVar;
            }
            return (j3a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements v3a<g3a, g3a.c, g3a.c> {
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
        @Override // com.baidu.tieba.v3a
        public g3a.c call(g3a g3aVar, g3a.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g3aVar, cVar)) == null) {
                o7a g = m7a.c().g();
                if (g == p7a.e()) {
                    return cVar;
                }
                u4a u4aVar = new u4a(cVar);
                g.d(g3aVar, u4aVar);
                return new r4a(u4aVar);
            }
            return (g3a.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements u3a<j3a, j3a> {
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
        @Override // com.baidu.tieba.u3a
        public j3a call(j3a j3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j3aVar)) == null) {
                m7a.c().g().c(j3aVar);
                return j3aVar;
            }
            return (j3a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements v3a<a3a, a3a.f, a3a.f> {
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
        @Override // com.baidu.tieba.v3a
        public a3a.f call(a3a a3aVar, a3a.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a3aVar, fVar)) == null) {
                m7a.c().a().c(a3aVar, fVar);
                return fVar;
            }
            return (a3a.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements u3a<p3a, p3a> {
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
        @Override // com.baidu.tieba.u3a
        public p3a call(p3a p3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p3aVar)) == null) {
                m7a.c().f().k(p3aVar);
                return p3aVar;
            }
            return (p3a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements u3a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.u3a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                m7a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements u3a<c3a.b, c3a.b> {
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
        @Override // com.baidu.tieba.u3a
        public c3a.b call(c3a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                m7a.c().d().b(bVar);
                return bVar;
            }
            return (c3a.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837589, "Lcom/baidu/tieba/j7a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837589, "Lcom/baidu/tieba/j7a;");
                return;
            }
        }
        b();
    }

    public static t3a<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (t3a) invokeV.objValue;
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
            u3a<Throwable, Throwable> u3aVar = q;
            if (u3aVar != null) {
                return u3aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static f3a f(f3a f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, f3aVar)) == null) {
            u3a<f3a, f3a> u3aVar = h;
            if (u3aVar != null) {
                return u3aVar.call(f3aVar);
            }
            return f3aVar;
        }
        return (f3a) invokeL.objValue;
    }

    public static a3a.f g(a3a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            u3a<a3a.f, a3a.f> u3aVar = d;
            if (u3aVar != null) {
                return u3aVar.call(fVar);
            }
            return fVar;
        }
        return (a3a.f) invokeL.objValue;
    }

    public static <T> c3a.a<T> h(c3a.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            u3a<c3a.a, c3a.a> u3aVar = b;
            if (u3aVar != null) {
                return u3aVar.call(aVar);
            }
            return aVar;
        }
        return (c3a.a) invokeL.objValue;
    }

    public static <T> g3a.c<T> i(g3a.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            u3a<g3a.c, g3a.c> u3aVar = c;
            if (u3aVar != null) {
                return u3aVar.call(cVar);
            }
            return cVar;
        }
        return (g3a.c) invokeL.objValue;
    }

    public static f3a k(f3a f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, f3aVar)) == null) {
            u3a<f3a, f3a> u3aVar = i;
            if (u3aVar != null) {
                return u3aVar.call(f3aVar);
            }
            return f3aVar;
        }
        return (f3a) invokeL.objValue;
    }

    public static f3a l(f3a f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, f3aVar)) == null) {
            u3a<f3a, f3a> u3aVar = j;
            if (u3aVar != null) {
                return u3aVar.call(f3aVar);
            }
            return f3aVar;
        }
        return (f3a) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            u3a<Throwable, Throwable> u3aVar = o;
            if (u3aVar != null) {
                return u3aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> c3a.b<R, T> n(c3a.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            u3a<c3a.b, c3a.b> u3aVar = r;
            if (u3aVar != null) {
                return u3aVar.call(bVar);
            }
            return bVar;
        }
        return (c3a.b) invokeL.objValue;
    }

    public static j3a o(j3a j3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, j3aVar)) == null) {
            u3a<j3a, j3a> u3aVar = l;
            if (u3aVar != null) {
                return u3aVar.call(j3aVar);
            }
            return j3aVar;
        }
        return (j3a) invokeL.objValue;
    }

    public static p3a q(p3a p3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, p3aVar)) == null) {
            u3a<p3a, p3a> u3aVar = k;
            if (u3aVar != null) {
                return u3aVar.call(p3aVar);
            }
            return p3aVar;
        }
        return (p3a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            u3a<Throwable, Throwable> u3aVar = p;
            if (u3aVar != null) {
                return u3aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static j3a s(j3a j3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, j3aVar)) == null) {
            u3a<j3a, j3a> u3aVar = m;
            if (u3aVar != null) {
                return u3aVar.call(j3aVar);
            }
            return j3aVar;
        }
        return (j3a) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> a3a.f e(a3a a3aVar, a3a.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, a3aVar, fVar)) == null) {
            v3a<a3a, a3a.f, a3a.f> v3aVar = g;
            if (v3aVar != null) {
                return v3aVar.call(a3aVar, fVar);
            }
            return fVar;
        }
        return (a3a.f) invokeLL.objValue;
    }

    public static <T> c3a.a<T> p(c3a<T> c3aVar, c3a.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, c3aVar, aVar)) == null) {
            v3a<c3a, c3a.a, c3a.a> v3aVar = e;
            if (v3aVar != null) {
                return v3aVar.call(c3aVar, aVar);
            }
            return aVar;
        }
        return (c3a.a) invokeLL.objValue;
    }

    public static <T> g3a.c<T> t(g3a<T> g3aVar, g3a.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, g3aVar, cVar)) == null) {
            v3a<g3a, g3a.c, g3a.c> v3aVar = f;
            if (v3aVar != null) {
                return v3aVar.call(g3aVar, cVar);
            }
            return cVar;
        }
        return (g3a.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            q3a<Throwable> q3aVar = a;
            if (q3aVar != null) {
                try {
                    q3aVar.call(th);
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
