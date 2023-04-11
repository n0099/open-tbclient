package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d1b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.j1b;
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
public final class m5b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t1b<Throwable> a;
    public static volatile x1b<f1b.a, f1b.a> b;
    public static volatile x1b<j1b.c, j1b.c> c;
    public static volatile x1b<d1b.f, d1b.f> d;
    public static volatile y1b<f1b, f1b.a, f1b.a> e;
    public static volatile y1b<j1b, j1b.c, j1b.c> f;
    public static volatile y1b<d1b, d1b.f, d1b.f> g;
    public static volatile x1b<i1b, i1b> h;
    public static volatile x1b<i1b, i1b> i;
    public static volatile x1b<i1b, i1b> j;
    public static volatile x1b<s1b, s1b> k;
    public static volatile x1b<m1b, m1b> l;
    public static volatile x1b<m1b, m1b> m;
    public static volatile w1b<? extends ScheduledExecutorService> n;
    public static volatile x1b<Throwable, Throwable> o;
    public static volatile x1b<Throwable, Throwable> p;
    public static volatile x1b<Throwable, Throwable> q;
    public static volatile x1b<f1b.b, f1b.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements x1b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.x1b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                p5b.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements x1b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.x1b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                p5b.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements x1b<f1b.a, f1b.a> {
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
        @Override // com.baidu.tieba.x1b
        public f1b.a call(f1b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                p5b.c().d().a(aVar);
                return aVar;
            }
            return (f1b.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements x1b<j1b.c, j1b.c> {
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
        @Override // com.baidu.tieba.x1b
        public j1b.c call(j1b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                p5b.c().g().a(cVar);
                return cVar;
            }
            return (j1b.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements x1b<d1b.f, d1b.f> {
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
        @Override // com.baidu.tieba.x1b
        public d1b.f call(d1b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                p5b.c().a().a(fVar);
                return fVar;
            }
            return (d1b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements t1b<Throwable> {
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
        @Override // com.baidu.tieba.t1b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                p5b.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements y1b<f1b, f1b.a, f1b.a> {
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
        @Override // com.baidu.tieba.y1b
        public f1b.a call(f1b f1bVar, f1b.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f1bVar, aVar)) == null) {
                p5b.c().d().e(f1bVar, aVar);
                return aVar;
            }
            return (f1b.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements x1b<m1b, m1b> {
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
        @Override // com.baidu.tieba.x1b
        public m1b call(m1b m1bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m1bVar)) == null) {
                p5b.c().d().d(m1bVar);
                return m1bVar;
            }
            return (m1b) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements y1b<j1b, j1b.c, j1b.c> {
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
        @Override // com.baidu.tieba.y1b
        public j1b.c call(j1b j1bVar, j1b.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, j1bVar, cVar)) == null) {
                r5b g = p5b.c().g();
                if (g == s5b.e()) {
                    return cVar;
                }
                x2b x2bVar = new x2b(cVar);
                g.d(j1bVar, x2bVar);
                return new u2b(x2bVar);
            }
            return (j1b.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements x1b<m1b, m1b> {
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
        @Override // com.baidu.tieba.x1b
        public m1b call(m1b m1bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m1bVar)) == null) {
                p5b.c().g().c(m1bVar);
                return m1bVar;
            }
            return (m1b) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements y1b<d1b, d1b.f, d1b.f> {
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
        @Override // com.baidu.tieba.y1b
        public d1b.f call(d1b d1bVar, d1b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d1bVar, fVar)) == null) {
                p5b.c().a().c(d1bVar, fVar);
                return fVar;
            }
            return (d1b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements x1b<s1b, s1b> {
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
        @Override // com.baidu.tieba.x1b
        public s1b call(s1b s1bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, s1bVar)) == null) {
                p5b.c().f().k(s1bVar);
                return s1bVar;
            }
            return (s1b) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements x1b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.x1b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                p5b.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements x1b<f1b.b, f1b.b> {
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
        @Override // com.baidu.tieba.x1b
        public f1b.b call(f1b.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                p5b.c().d().b(bVar);
                return bVar;
            }
            return (f1b.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925071, "Lcom/baidu/tieba/m5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925071, "Lcom/baidu/tieba/m5b;");
                return;
            }
        }
        b();
    }

    public static w1b<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (w1b) invokeV.objValue;
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
            x1b<Throwable, Throwable> x1bVar = q;
            if (x1bVar != null) {
                return x1bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static i1b f(i1b i1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, i1bVar)) == null) {
            x1b<i1b, i1b> x1bVar = h;
            if (x1bVar != null) {
                return x1bVar.call(i1bVar);
            }
            return i1bVar;
        }
        return (i1b) invokeL.objValue;
    }

    public static d1b.f g(d1b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            x1b<d1b.f, d1b.f> x1bVar = d;
            if (x1bVar != null) {
                return x1bVar.call(fVar);
            }
            return fVar;
        }
        return (d1b.f) invokeL.objValue;
    }

    public static <T> f1b.a<T> h(f1b.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            x1b<f1b.a, f1b.a> x1bVar = b;
            if (x1bVar != null) {
                return x1bVar.call(aVar);
            }
            return aVar;
        }
        return (f1b.a) invokeL.objValue;
    }

    public static <T> j1b.c<T> i(j1b.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            x1b<j1b.c, j1b.c> x1bVar = c;
            if (x1bVar != null) {
                return x1bVar.call(cVar);
            }
            return cVar;
        }
        return (j1b.c) invokeL.objValue;
    }

    public static i1b k(i1b i1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, i1bVar)) == null) {
            x1b<i1b, i1b> x1bVar = i;
            if (x1bVar != null) {
                return x1bVar.call(i1bVar);
            }
            return i1bVar;
        }
        return (i1b) invokeL.objValue;
    }

    public static i1b l(i1b i1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, i1bVar)) == null) {
            x1b<i1b, i1b> x1bVar = j;
            if (x1bVar != null) {
                return x1bVar.call(i1bVar);
            }
            return i1bVar;
        }
        return (i1b) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            x1b<Throwable, Throwable> x1bVar = o;
            if (x1bVar != null) {
                return x1bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> f1b.b<R, T> n(f1b.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            x1b<f1b.b, f1b.b> x1bVar = r;
            if (x1bVar != null) {
                return x1bVar.call(bVar);
            }
            return bVar;
        }
        return (f1b.b) invokeL.objValue;
    }

    public static m1b o(m1b m1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, m1bVar)) == null) {
            x1b<m1b, m1b> x1bVar = l;
            if (x1bVar != null) {
                return x1bVar.call(m1bVar);
            }
            return m1bVar;
        }
        return (m1b) invokeL.objValue;
    }

    public static s1b q(s1b s1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, s1bVar)) == null) {
            x1b<s1b, s1b> x1bVar = k;
            if (x1bVar != null) {
                return x1bVar.call(s1bVar);
            }
            return s1bVar;
        }
        return (s1b) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            x1b<Throwable, Throwable> x1bVar = p;
            if (x1bVar != null) {
                return x1bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static m1b s(m1b m1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, m1bVar)) == null) {
            x1b<m1b, m1b> x1bVar = m;
            if (x1bVar != null) {
                return x1bVar.call(m1bVar);
            }
            return m1bVar;
        }
        return (m1b) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> d1b.f e(d1b d1bVar, d1b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, d1bVar, fVar)) == null) {
            y1b<d1b, d1b.f, d1b.f> y1bVar = g;
            if (y1bVar != null) {
                return y1bVar.call(d1bVar, fVar);
            }
            return fVar;
        }
        return (d1b.f) invokeLL.objValue;
    }

    public static <T> f1b.a<T> p(f1b<T> f1bVar, f1b.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, f1bVar, aVar)) == null) {
            y1b<f1b, f1b.a, f1b.a> y1bVar = e;
            if (y1bVar != null) {
                return y1bVar.call(f1bVar, aVar);
            }
            return aVar;
        }
        return (f1b.a) invokeLL.objValue;
    }

    public static <T> j1b.c<T> t(j1b<T> j1bVar, j1b.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, j1bVar, cVar)) == null) {
            y1b<j1b, j1b.c, j1b.c> y1bVar = f;
            if (y1bVar != null) {
                return y1bVar.call(j1bVar, cVar);
            }
            return cVar;
        }
        return (j1b.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            t1b<Throwable> t1bVar = a;
            if (t1bVar != null) {
                try {
                    t1bVar.call(th);
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
