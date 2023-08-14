package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c1c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.y0c;
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
public final class l5c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m1c<Throwable> a;
    public static volatile q1c<y0c.a, y0c.a> b;
    public static volatile q1c<c1c.c, c1c.c> c;
    public static volatile q1c<w0c.f, w0c.f> d;
    public static volatile r1c<y0c, y0c.a, y0c.a> e;
    public static volatile r1c<c1c, c1c.c, c1c.c> f;
    public static volatile r1c<w0c, w0c.f, w0c.f> g;
    public static volatile q1c<b1c, b1c> h;
    public static volatile q1c<b1c, b1c> i;
    public static volatile q1c<b1c, b1c> j;
    public static volatile q1c<l1c, l1c> k;
    public static volatile q1c<f1c, f1c> l;
    public static volatile q1c<f1c, f1c> m;
    public static volatile p1c<? extends ScheduledExecutorService> n;
    public static volatile q1c<Throwable, Throwable> o;
    public static volatile q1c<Throwable, Throwable> p;
    public static volatile q1c<Throwable, Throwable> q;
    public static volatile q1c<y0c.b, y0c.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements q1c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.q1c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                o5c.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements q1c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.q1c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                o5c.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements q1c<y0c.a, y0c.a> {
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
        @Override // com.baidu.tieba.q1c
        public y0c.a call(y0c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                o5c.c().d().a(aVar);
                return aVar;
            }
            return (y0c.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements q1c<c1c.c, c1c.c> {
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
        @Override // com.baidu.tieba.q1c
        public c1c.c call(c1c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                o5c.c().g().a(cVar);
                return cVar;
            }
            return (c1c.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements q1c<w0c.f, w0c.f> {
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
        @Override // com.baidu.tieba.q1c
        public w0c.f call(w0c.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                o5c.c().a().a(fVar);
                return fVar;
            }
            return (w0c.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements m1c<Throwable> {
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
        @Override // com.baidu.tieba.m1c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                o5c.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements r1c<y0c, y0c.a, y0c.a> {
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
        @Override // com.baidu.tieba.r1c
        public y0c.a call(y0c y0cVar, y0c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, y0cVar, aVar)) == null) {
                o5c.c().d().e(y0cVar, aVar);
                return aVar;
            }
            return (y0c.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements q1c<f1c, f1c> {
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
        @Override // com.baidu.tieba.q1c
        public f1c call(f1c f1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f1cVar)) == null) {
                o5c.c().d().d(f1cVar);
                return f1cVar;
            }
            return (f1c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements r1c<c1c, c1c.c, c1c.c> {
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
        @Override // com.baidu.tieba.r1c
        public c1c.c call(c1c c1cVar, c1c.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c1cVar, cVar)) == null) {
                q5c g = o5c.c().g();
                if (g == r5c.e()) {
                    return cVar;
                }
                w2c w2cVar = new w2c(cVar);
                g.d(c1cVar, w2cVar);
                return new t2c(w2cVar);
            }
            return (c1c.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements q1c<f1c, f1c> {
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
        @Override // com.baidu.tieba.q1c
        public f1c call(f1c f1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f1cVar)) == null) {
                o5c.c().g().c(f1cVar);
                return f1cVar;
            }
            return (f1c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements r1c<w0c, w0c.f, w0c.f> {
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
        @Override // com.baidu.tieba.r1c
        public w0c.f call(w0c w0cVar, w0c.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, w0cVar, fVar)) == null) {
                o5c.c().a().c(w0cVar, fVar);
                return fVar;
            }
            return (w0c.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements q1c<l1c, l1c> {
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
        @Override // com.baidu.tieba.q1c
        public l1c call(l1c l1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l1cVar)) == null) {
                o5c.c().f().k(l1cVar);
                return l1cVar;
            }
            return (l1c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements q1c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.q1c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                o5c.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements q1c<y0c.b, y0c.b> {
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
        @Override // com.baidu.tieba.q1c
        public y0c.b call(y0c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                o5c.c().d().b(bVar);
                return bVar;
            }
            return (y0c.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895311, "Lcom/baidu/tieba/l5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895311, "Lcom/baidu/tieba/l5c;");
                return;
            }
        }
        b();
    }

    public static p1c<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (p1c) invokeV.objValue;
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
            q1c<Throwable, Throwable> q1cVar = q;
            if (q1cVar != null) {
                return q1cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static b1c f(b1c b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, b1cVar)) == null) {
            q1c<b1c, b1c> q1cVar = h;
            if (q1cVar != null) {
                return q1cVar.call(b1cVar);
            }
            return b1cVar;
        }
        return (b1c) invokeL.objValue;
    }

    public static w0c.f g(w0c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            q1c<w0c.f, w0c.f> q1cVar = d;
            if (q1cVar != null) {
                return q1cVar.call(fVar);
            }
            return fVar;
        }
        return (w0c.f) invokeL.objValue;
    }

    public static <T> y0c.a<T> h(y0c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            q1c<y0c.a, y0c.a> q1cVar = b;
            if (q1cVar != null) {
                return q1cVar.call(aVar);
            }
            return aVar;
        }
        return (y0c.a) invokeL.objValue;
    }

    public static <T> c1c.c<T> i(c1c.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            q1c<c1c.c, c1c.c> q1cVar = c;
            if (q1cVar != null) {
                return q1cVar.call(cVar);
            }
            return cVar;
        }
        return (c1c.c) invokeL.objValue;
    }

    public static b1c k(b1c b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, b1cVar)) == null) {
            q1c<b1c, b1c> q1cVar = i;
            if (q1cVar != null) {
                return q1cVar.call(b1cVar);
            }
            return b1cVar;
        }
        return (b1c) invokeL.objValue;
    }

    public static b1c l(b1c b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, b1cVar)) == null) {
            q1c<b1c, b1c> q1cVar = j;
            if (q1cVar != null) {
                return q1cVar.call(b1cVar);
            }
            return b1cVar;
        }
        return (b1c) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            q1c<Throwable, Throwable> q1cVar = o;
            if (q1cVar != null) {
                return q1cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> y0c.b<R, T> n(y0c.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            q1c<y0c.b, y0c.b> q1cVar = r;
            if (q1cVar != null) {
                return q1cVar.call(bVar);
            }
            return bVar;
        }
        return (y0c.b) invokeL.objValue;
    }

    public static f1c o(f1c f1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, f1cVar)) == null) {
            q1c<f1c, f1c> q1cVar = l;
            if (q1cVar != null) {
                return q1cVar.call(f1cVar);
            }
            return f1cVar;
        }
        return (f1c) invokeL.objValue;
    }

    public static l1c q(l1c l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, l1cVar)) == null) {
            q1c<l1c, l1c> q1cVar = k;
            if (q1cVar != null) {
                return q1cVar.call(l1cVar);
            }
            return l1cVar;
        }
        return (l1c) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            q1c<Throwable, Throwable> q1cVar = p;
            if (q1cVar != null) {
                return q1cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static f1c s(f1c f1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, f1cVar)) == null) {
            q1c<f1c, f1c> q1cVar = m;
            if (q1cVar != null) {
                return q1cVar.call(f1cVar);
            }
            return f1cVar;
        }
        return (f1c) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> w0c.f e(w0c w0cVar, w0c.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, w0cVar, fVar)) == null) {
            r1c<w0c, w0c.f, w0c.f> r1cVar = g;
            if (r1cVar != null) {
                return r1cVar.call(w0cVar, fVar);
            }
            return fVar;
        }
        return (w0c.f) invokeLL.objValue;
    }

    public static <T> y0c.a<T> p(y0c<T> y0cVar, y0c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, y0cVar, aVar)) == null) {
            r1c<y0c, y0c.a, y0c.a> r1cVar = e;
            if (r1cVar != null) {
                return r1cVar.call(y0cVar, aVar);
            }
            return aVar;
        }
        return (y0c.a) invokeLL.objValue;
    }

    public static <T> c1c.c<T> t(c1c<T> c1cVar, c1c.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, c1cVar, cVar)) == null) {
            r1c<c1c, c1c.c, c1c.c> r1cVar = f;
            if (r1cVar != null) {
                return r1cVar.call(c1cVar, cVar);
            }
            return cVar;
        }
        return (c1c.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            m1c<Throwable> m1cVar = a;
            if (m1cVar != null) {
                try {
                    m1cVar.call(th);
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
