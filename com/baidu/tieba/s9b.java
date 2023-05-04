package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h5b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.n5b;
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
public final class s9b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x5b<Throwable> a;
    public static volatile b6b<j5b.a, j5b.a> b;
    public static volatile b6b<n5b.c, n5b.c> c;
    public static volatile b6b<h5b.f, h5b.f> d;
    public static volatile c6b<j5b, j5b.a, j5b.a> e;
    public static volatile c6b<n5b, n5b.c, n5b.c> f;
    public static volatile c6b<h5b, h5b.f, h5b.f> g;
    public static volatile b6b<m5b, m5b> h;
    public static volatile b6b<m5b, m5b> i;
    public static volatile b6b<m5b, m5b> j;
    public static volatile b6b<w5b, w5b> k;
    public static volatile b6b<q5b, q5b> l;
    public static volatile b6b<q5b, q5b> m;
    public static volatile a6b<? extends ScheduledExecutorService> n;
    public static volatile b6b<Throwable, Throwable> o;
    public static volatile b6b<Throwable, Throwable> p;
    public static volatile b6b<Throwable, Throwable> q;
    public static volatile b6b<j5b.b, j5b.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements b6b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.b6b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                v9b.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements b6b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.b6b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                v9b.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements b6b<j5b.a, j5b.a> {
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
        @Override // com.baidu.tieba.b6b
        public j5b.a call(j5b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                v9b.c().d().a(aVar);
                return aVar;
            }
            return (j5b.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements b6b<n5b.c, n5b.c> {
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
        @Override // com.baidu.tieba.b6b
        public n5b.c call(n5b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                v9b.c().g().a(cVar);
                return cVar;
            }
            return (n5b.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements b6b<h5b.f, h5b.f> {
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
        @Override // com.baidu.tieba.b6b
        public h5b.f call(h5b.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                v9b.c().a().a(fVar);
                return fVar;
            }
            return (h5b.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements x5b<Throwable> {
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
        @Override // com.baidu.tieba.x5b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                v9b.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements c6b<j5b, j5b.a, j5b.a> {
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
        @Override // com.baidu.tieba.c6b
        public j5b.a call(j5b j5bVar, j5b.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, j5bVar, aVar)) == null) {
                v9b.c().d().e(j5bVar, aVar);
                return aVar;
            }
            return (j5b.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements b6b<q5b, q5b> {
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
        @Override // com.baidu.tieba.b6b
        public q5b call(q5b q5bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q5bVar)) == null) {
                v9b.c().d().d(q5bVar);
                return q5bVar;
            }
            return (q5b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements c6b<n5b, n5b.c, n5b.c> {
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
        @Override // com.baidu.tieba.c6b
        public n5b.c call(n5b n5bVar, n5b.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n5bVar, cVar)) == null) {
                x9b g = v9b.c().g();
                if (g == y9b.e()) {
                    return cVar;
                }
                d7b d7bVar = new d7b(cVar);
                g.d(n5bVar, d7bVar);
                return new a7b(d7bVar);
            }
            return (n5b.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements b6b<q5b, q5b> {
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
        @Override // com.baidu.tieba.b6b
        public q5b call(q5b q5bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q5bVar)) == null) {
                v9b.c().g().c(q5bVar);
                return q5bVar;
            }
            return (q5b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements c6b<h5b, h5b.f, h5b.f> {
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
        @Override // com.baidu.tieba.c6b
        public h5b.f call(h5b h5bVar, h5b.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h5bVar, fVar)) == null) {
                v9b.c().a().c(h5bVar, fVar);
                return fVar;
            }
            return (h5b.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements b6b<w5b, w5b> {
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
        @Override // com.baidu.tieba.b6b
        public w5b call(w5b w5bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w5bVar)) == null) {
                v9b.c().f().k(w5bVar);
                return w5bVar;
            }
            return (w5b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements b6b<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.b6b
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                v9b.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements b6b<j5b.b, j5b.b> {
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
        @Override // com.baidu.tieba.b6b
        public j5b.b call(j5b.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                v9b.c().d().b(bVar);
                return bVar;
            }
            return (j5b.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948107661, "Lcom/baidu/tieba/s9b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948107661, "Lcom/baidu/tieba/s9b;");
                return;
            }
        }
        b();
    }

    public static a6b<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (a6b) invokeV.objValue;
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
            b6b<Throwable, Throwable> b6bVar = q;
            if (b6bVar != null) {
                return b6bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static m5b f(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, m5bVar)) == null) {
            b6b<m5b, m5b> b6bVar = h;
            if (b6bVar != null) {
                return b6bVar.call(m5bVar);
            }
            return m5bVar;
        }
        return (m5b) invokeL.objValue;
    }

    public static h5b.f g(h5b.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            b6b<h5b.f, h5b.f> b6bVar = d;
            if (b6bVar != null) {
                return b6bVar.call(fVar);
            }
            return fVar;
        }
        return (h5b.f) invokeL.objValue;
    }

    public static <T> j5b.a<T> h(j5b.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            b6b<j5b.a, j5b.a> b6bVar = b;
            if (b6bVar != null) {
                return b6bVar.call(aVar);
            }
            return aVar;
        }
        return (j5b.a) invokeL.objValue;
    }

    public static <T> n5b.c<T> i(n5b.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            b6b<n5b.c, n5b.c> b6bVar = c;
            if (b6bVar != null) {
                return b6bVar.call(cVar);
            }
            return cVar;
        }
        return (n5b.c) invokeL.objValue;
    }

    public static m5b k(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, m5bVar)) == null) {
            b6b<m5b, m5b> b6bVar = i;
            if (b6bVar != null) {
                return b6bVar.call(m5bVar);
            }
            return m5bVar;
        }
        return (m5b) invokeL.objValue;
    }

    public static m5b l(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, m5bVar)) == null) {
            b6b<m5b, m5b> b6bVar = j;
            if (b6bVar != null) {
                return b6bVar.call(m5bVar);
            }
            return m5bVar;
        }
        return (m5b) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            b6b<Throwable, Throwable> b6bVar = o;
            if (b6bVar != null) {
                return b6bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> j5b.b<R, T> n(j5b.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            b6b<j5b.b, j5b.b> b6bVar = r;
            if (b6bVar != null) {
                return b6bVar.call(bVar);
            }
            return bVar;
        }
        return (j5b.b) invokeL.objValue;
    }

    public static q5b o(q5b q5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, q5bVar)) == null) {
            b6b<q5b, q5b> b6bVar = l;
            if (b6bVar != null) {
                return b6bVar.call(q5bVar);
            }
            return q5bVar;
        }
        return (q5b) invokeL.objValue;
    }

    public static w5b q(w5b w5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, w5bVar)) == null) {
            b6b<w5b, w5b> b6bVar = k;
            if (b6bVar != null) {
                return b6bVar.call(w5bVar);
            }
            return w5bVar;
        }
        return (w5b) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            b6b<Throwable, Throwable> b6bVar = p;
            if (b6bVar != null) {
                return b6bVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static q5b s(q5b q5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, q5bVar)) == null) {
            b6b<q5b, q5b> b6bVar = m;
            if (b6bVar != null) {
                return b6bVar.call(q5bVar);
            }
            return q5bVar;
        }
        return (q5b) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> h5b.f e(h5b h5bVar, h5b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, h5bVar, fVar)) == null) {
            c6b<h5b, h5b.f, h5b.f> c6bVar = g;
            if (c6bVar != null) {
                return c6bVar.call(h5bVar, fVar);
            }
            return fVar;
        }
        return (h5b.f) invokeLL.objValue;
    }

    public static <T> j5b.a<T> p(j5b<T> j5bVar, j5b.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, j5bVar, aVar)) == null) {
            c6b<j5b, j5b.a, j5b.a> c6bVar = e;
            if (c6bVar != null) {
                return c6bVar.call(j5bVar, aVar);
            }
            return aVar;
        }
        return (j5b.a) invokeLL.objValue;
    }

    public static <T> n5b.c<T> t(n5b<T> n5bVar, n5b.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, n5bVar, cVar)) == null) {
            c6b<n5b, n5b.c, n5b.c> c6bVar = f;
            if (c6bVar != null) {
                return c6bVar.call(n5bVar, cVar);
            }
            return cVar;
        }
        return (n5b.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            x5b<Throwable> x5bVar = a;
            if (x5bVar != null) {
                try {
                    x5bVar.call(th);
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
