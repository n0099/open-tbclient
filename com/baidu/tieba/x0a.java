package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ow9;
import com.baidu.tieba.qw9;
import com.baidu.tieba.uw9;
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
public final class x0a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ex9<Throwable> a;
    public static volatile ix9<qw9.a, qw9.a> b;
    public static volatile ix9<uw9.c, uw9.c> c;
    public static volatile ix9<ow9.f, ow9.f> d;
    public static volatile jx9<qw9, qw9.a, qw9.a> e;
    public static volatile jx9<uw9, uw9.c, uw9.c> f;
    public static volatile jx9<ow9, ow9.f, ow9.f> g;
    public static volatile ix9<tw9, tw9> h;
    public static volatile ix9<tw9, tw9> i;
    public static volatile ix9<tw9, tw9> j;
    public static volatile ix9<dx9, dx9> k;
    public static volatile ix9<xw9, xw9> l;
    public static volatile ix9<xw9, xw9> m;
    public static volatile hx9<? extends ScheduledExecutorService> n;
    public static volatile ix9<Throwable, Throwable> o;
    public static volatile ix9<Throwable, Throwable> p;
    public static volatile ix9<Throwable, Throwable> q;
    public static volatile ix9<qw9.b, qw9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ix9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ix9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                a1a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ix9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ix9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                a1a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements ix9<qw9.a, qw9.a> {
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
        @Override // com.baidu.tieba.ix9
        public qw9.a call(qw9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                a1a.c().d().a(aVar);
                return aVar;
            }
            return (qw9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements ix9<uw9.c, uw9.c> {
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
        @Override // com.baidu.tieba.ix9
        public uw9.c call(uw9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                a1a.c().g().a(cVar);
                return cVar;
            }
            return (uw9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements ix9<ow9.f, ow9.f> {
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
        @Override // com.baidu.tieba.ix9
        public ow9.f call(ow9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                a1a.c().a().a(fVar);
                return fVar;
            }
            return (ow9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements ex9<Throwable> {
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
        @Override // com.baidu.tieba.ex9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                a1a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements jx9<qw9, qw9.a, qw9.a> {
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
        @Override // com.baidu.tieba.jx9
        public qw9.a call(qw9 qw9Var, qw9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qw9Var, aVar)) == null) {
                a1a.c().d().e(qw9Var, aVar);
                return aVar;
            }
            return (qw9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements ix9<xw9, xw9> {
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
        @Override // com.baidu.tieba.ix9
        public xw9 call(xw9 xw9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xw9Var)) == null) {
                a1a.c().d().d(xw9Var);
                return xw9Var;
            }
            return (xw9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements jx9<uw9, uw9.c, uw9.c> {
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
        @Override // com.baidu.tieba.jx9
        public uw9.c call(uw9 uw9Var, uw9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uw9Var, cVar)) == null) {
                c1a g = a1a.c().g();
                if (g == d1a.e()) {
                    return cVar;
                }
                iy9 iy9Var = new iy9(cVar);
                g.d(uw9Var, iy9Var);
                return new fy9(iy9Var);
            }
            return (uw9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements ix9<xw9, xw9> {
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
        @Override // com.baidu.tieba.ix9
        public xw9 call(xw9 xw9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xw9Var)) == null) {
                a1a.c().g().c(xw9Var);
                return xw9Var;
            }
            return (xw9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements jx9<ow9, ow9.f, ow9.f> {
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
        @Override // com.baidu.tieba.jx9
        public ow9.f call(ow9 ow9Var, ow9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ow9Var, fVar)) == null) {
                a1a.c().a().c(ow9Var, fVar);
                return fVar;
            }
            return (ow9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements ix9<dx9, dx9> {
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
        @Override // com.baidu.tieba.ix9
        public dx9 call(dx9 dx9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dx9Var)) == null) {
                a1a.c().f().k(dx9Var);
                return dx9Var;
            }
            return (dx9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements ix9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ix9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                a1a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements ix9<qw9.b, qw9.b> {
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
        @Override // com.baidu.tieba.ix9
        public qw9.b call(qw9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                a1a.c().d().b(bVar);
                return bVar;
            }
            return (qw9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948247936, "Lcom/baidu/tieba/x0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948247936, "Lcom/baidu/tieba/x0a;");
                return;
            }
        }
        b();
    }

    public static hx9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (hx9) invokeV.objValue;
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

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            b = new c();
            c = new d();
            d = new e();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            ix9<Throwable, Throwable> ix9Var = q;
            return ix9Var != null ? ix9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> ow9.f e(ow9 ow9Var, ow9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, ow9Var, fVar)) == null) {
            jx9<ow9, ow9.f, ow9.f> jx9Var = g;
            return jx9Var != null ? jx9Var.call(ow9Var, fVar) : fVar;
        }
        return (ow9.f) invokeLL.objValue;
    }

    public static tw9 f(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tw9Var)) == null) {
            ix9<tw9, tw9> ix9Var = h;
            return ix9Var != null ? ix9Var.call(tw9Var) : tw9Var;
        }
        return (tw9) invokeL.objValue;
    }

    public static ow9.f g(ow9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            ix9<ow9.f, ow9.f> ix9Var = d;
            return ix9Var != null ? ix9Var.call(fVar) : fVar;
        }
        return (ow9.f) invokeL.objValue;
    }

    public static <T> qw9.a<T> h(qw9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            ix9<qw9.a, qw9.a> ix9Var = b;
            return ix9Var != null ? ix9Var.call(aVar) : aVar;
        }
        return (qw9.a) invokeL.objValue;
    }

    public static <T> uw9.c<T> i(uw9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            ix9<uw9.c, uw9.c> ix9Var = c;
            return ix9Var != null ? ix9Var.call(cVar) : cVar;
        }
        return (uw9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            ex9<Throwable> ex9Var = a;
            if (ex9Var != null) {
                try {
                    ex9Var.call(th);
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

    public static tw9 k(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tw9Var)) == null) {
            ix9<tw9, tw9> ix9Var = i;
            return ix9Var != null ? ix9Var.call(tw9Var) : tw9Var;
        }
        return (tw9) invokeL.objValue;
    }

    public static tw9 l(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, tw9Var)) == null) {
            ix9<tw9, tw9> ix9Var = j;
            return ix9Var != null ? ix9Var.call(tw9Var) : tw9Var;
        }
        return (tw9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            ix9<Throwable, Throwable> ix9Var = o;
            return ix9Var != null ? ix9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> qw9.b<R, T> n(qw9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            ix9<qw9.b, qw9.b> ix9Var = r;
            return ix9Var != null ? ix9Var.call(bVar) : bVar;
        }
        return (qw9.b) invokeL.objValue;
    }

    public static xw9 o(xw9 xw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, xw9Var)) == null) {
            ix9<xw9, xw9> ix9Var = l;
            return ix9Var != null ? ix9Var.call(xw9Var) : xw9Var;
        }
        return (xw9) invokeL.objValue;
    }

    public static <T> qw9.a<T> p(qw9<T> qw9Var, qw9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, qw9Var, aVar)) == null) {
            jx9<qw9, qw9.a, qw9.a> jx9Var = e;
            return jx9Var != null ? jx9Var.call(qw9Var, aVar) : aVar;
        }
        return (qw9.a) invokeLL.objValue;
    }

    public static dx9 q(dx9 dx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, dx9Var)) == null) {
            ix9<dx9, dx9> ix9Var = k;
            return ix9Var != null ? ix9Var.call(dx9Var) : dx9Var;
        }
        return (dx9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            ix9<Throwable, Throwable> ix9Var = p;
            return ix9Var != null ? ix9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static xw9 s(xw9 xw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, xw9Var)) == null) {
            ix9<xw9, xw9> ix9Var = m;
            return ix9Var != null ? ix9Var.call(xw9Var) : xw9Var;
        }
        return (xw9) invokeL.objValue;
    }

    public static <T> uw9.c<T> t(uw9<T> uw9Var, uw9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, uw9Var, cVar)) == null) {
            jx9<uw9, uw9.c, uw9.c> jx9Var = f;
            return jx9Var != null ? jx9Var.call(uw9Var, cVar) : cVar;
        }
        return (uw9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
