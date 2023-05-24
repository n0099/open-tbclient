package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g7b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.m7b;
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
public final class sbb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w7b<Throwable> a;
    public static volatile a8b<i7b.a, i7b.a> b;
    public static volatile a8b<m7b.c, m7b.c> c;
    public static volatile a8b<g7b.f, g7b.f> d;
    public static volatile b8b<i7b, i7b.a, i7b.a> e;
    public static volatile b8b<m7b, m7b.c, m7b.c> f;
    public static volatile b8b<g7b, g7b.f, g7b.f> g;
    public static volatile a8b<l7b, l7b> h;
    public static volatile a8b<l7b, l7b> i;
    public static volatile a8b<l7b, l7b> j;
    public static volatile a8b<v7b, v7b> k;
    public static volatile a8b<p7b, p7b> l;
    public static volatile a8b<p7b, p7b> m;
    public static volatile z7b<? extends ScheduledExecutorService> n;
    public static volatile a8b<Throwable, Throwable> o;
    public static volatile a8b<Throwable, Throwable> p;
    public static volatile a8b<Throwable, Throwable> q;
    public static volatile a8b<i7b.b, i7b.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements a8b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.a8b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                vbb.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a8b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.a8b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                vbb.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements a8b<i7b.a, i7b.a> {
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
        @Override // com.baidu.tieba.a8b
        public i7b.a call(i7b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                vbb.c().d().a(aVar);
                return aVar;
            }
            return (i7b.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements a8b<m7b.c, m7b.c> {
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
        @Override // com.baidu.tieba.a8b
        public m7b.c call(m7b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                vbb.c().g().a(cVar);
                return cVar;
            }
            return (m7b.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements a8b<g7b.f, g7b.f> {
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
        @Override // com.baidu.tieba.a8b
        public g7b.f call(g7b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                vbb.c().a().a(fVar);
                return fVar;
            }
            return (g7b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements w7b<Throwable> {
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
        @Override // com.baidu.tieba.w7b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                vbb.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements b8b<i7b, i7b.a, i7b.a> {
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
        @Override // com.baidu.tieba.b8b
        public i7b.a call(i7b i7bVar, i7b.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, i7bVar, aVar)) == null) {
                vbb.c().d().e(i7bVar, aVar);
                return aVar;
            }
            return (i7b.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements a8b<p7b, p7b> {
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
        @Override // com.baidu.tieba.a8b
        public p7b call(p7b p7bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p7bVar)) == null) {
                vbb.c().d().d(p7bVar);
                return p7bVar;
            }
            return (p7b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements b8b<m7b, m7b.c, m7b.c> {
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
        @Override // com.baidu.tieba.b8b
        public m7b.c call(m7b m7bVar, m7b.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, m7bVar, cVar)) == null) {
                xbb g = vbb.c().g();
                if (g == ybb.e()) {
                    return cVar;
                }
                d9b d9bVar = new d9b(cVar);
                g.d(m7bVar, d9bVar);
                return new a9b(d9bVar);
            }
            return (m7b.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements a8b<p7b, p7b> {
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
        @Override // com.baidu.tieba.a8b
        public p7b call(p7b p7bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p7bVar)) == null) {
                vbb.c().g().c(p7bVar);
                return p7bVar;
            }
            return (p7b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements b8b<g7b, g7b.f, g7b.f> {
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
        @Override // com.baidu.tieba.b8b
        public g7b.f call(g7b g7bVar, g7b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g7bVar, fVar)) == null) {
                vbb.c().a().c(g7bVar, fVar);
                return fVar;
            }
            return (g7b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements a8b<v7b, v7b> {
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
        @Override // com.baidu.tieba.a8b
        public v7b call(v7b v7bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v7bVar)) == null) {
                vbb.c().f().k(v7bVar);
                return v7bVar;
            }
            return (v7b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements a8b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.a8b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                vbb.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements a8b<i7b.b, i7b.b> {
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
        @Override // com.baidu.tieba.a8b
        public i7b.b call(i7b.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                vbb.c().d().b(bVar);
                return bVar;
            }
            return (i7b.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948147062, "Lcom/baidu/tieba/sbb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948147062, "Lcom/baidu/tieba/sbb;");
                return;
            }
        }
        b();
    }

    public static z7b<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (z7b) invokeV.objValue;
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
            a8b<Throwable, Throwable> a8bVar = q;
            if (a8bVar != null) {
                return a8bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static l7b f(l7b l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, l7bVar)) == null) {
            a8b<l7b, l7b> a8bVar = h;
            if (a8bVar != null) {
                return a8bVar.call(l7bVar);
            }
            return l7bVar;
        }
        return (l7b) invokeL.objValue;
    }

    public static g7b.f g(g7b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            a8b<g7b.f, g7b.f> a8bVar = d;
            if (a8bVar != null) {
                return a8bVar.call(fVar);
            }
            return fVar;
        }
        return (g7b.f) invokeL.objValue;
    }

    public static <T> i7b.a<T> h(i7b.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            a8b<i7b.a, i7b.a> a8bVar = b;
            if (a8bVar != null) {
                return a8bVar.call(aVar);
            }
            return aVar;
        }
        return (i7b.a) invokeL.objValue;
    }

    public static <T> m7b.c<T> i(m7b.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            a8b<m7b.c, m7b.c> a8bVar = c;
            if (a8bVar != null) {
                return a8bVar.call(cVar);
            }
            return cVar;
        }
        return (m7b.c) invokeL.objValue;
    }

    public static l7b k(l7b l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, l7bVar)) == null) {
            a8b<l7b, l7b> a8bVar = i;
            if (a8bVar != null) {
                return a8bVar.call(l7bVar);
            }
            return l7bVar;
        }
        return (l7b) invokeL.objValue;
    }

    public static l7b l(l7b l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, l7bVar)) == null) {
            a8b<l7b, l7b> a8bVar = j;
            if (a8bVar != null) {
                return a8bVar.call(l7bVar);
            }
            return l7bVar;
        }
        return (l7b) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            a8b<Throwable, Throwable> a8bVar = o;
            if (a8bVar != null) {
                return a8bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> i7b.b<R, T> n(i7b.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            a8b<i7b.b, i7b.b> a8bVar = r;
            if (a8bVar != null) {
                return a8bVar.call(bVar);
            }
            return bVar;
        }
        return (i7b.b) invokeL.objValue;
    }

    public static p7b o(p7b p7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, p7bVar)) == null) {
            a8b<p7b, p7b> a8bVar = l;
            if (a8bVar != null) {
                return a8bVar.call(p7bVar);
            }
            return p7bVar;
        }
        return (p7b) invokeL.objValue;
    }

    public static v7b q(v7b v7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, v7bVar)) == null) {
            a8b<v7b, v7b> a8bVar = k;
            if (a8bVar != null) {
                return a8bVar.call(v7bVar);
            }
            return v7bVar;
        }
        return (v7b) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            a8b<Throwable, Throwable> a8bVar = p;
            if (a8bVar != null) {
                return a8bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static p7b s(p7b p7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, p7bVar)) == null) {
            a8b<p7b, p7b> a8bVar = m;
            if (a8bVar != null) {
                return a8bVar.call(p7bVar);
            }
            return p7bVar;
        }
        return (p7b) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> g7b.f e(g7b g7bVar, g7b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, g7bVar, fVar)) == null) {
            b8b<g7b, g7b.f, g7b.f> b8bVar = g;
            if (b8bVar != null) {
                return b8bVar.call(g7bVar, fVar);
            }
            return fVar;
        }
        return (g7b.f) invokeLL.objValue;
    }

    public static <T> i7b.a<T> p(i7b<T> i7bVar, i7b.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, i7bVar, aVar)) == null) {
            b8b<i7b, i7b.a, i7b.a> b8bVar = e;
            if (b8bVar != null) {
                return b8bVar.call(i7bVar, aVar);
            }
            return aVar;
        }
        return (i7b.a) invokeLL.objValue;
    }

    public static <T> m7b.c<T> t(m7b<T> m7bVar, m7b.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, m7bVar, cVar)) == null) {
            b8b<m7b, m7b.c, m7b.c> b8bVar = f;
            if (b8bVar != null) {
                return b8bVar.call(m7bVar, cVar);
            }
            return cVar;
        }
        return (m7b.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            w7b<Throwable> w7bVar = a;
            if (w7bVar != null) {
                try {
                    w7bVar.call(th);
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
