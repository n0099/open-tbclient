package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dx9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.jx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
public final class m1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tx9<Throwable> a;
    public static volatile xx9<fx9.a, fx9.a> b;
    public static volatile xx9<jx9.c, jx9.c> c;
    public static volatile xx9<dx9.f, dx9.f> d;
    public static volatile yx9<fx9, fx9.a, fx9.a> e;
    public static volatile yx9<jx9, jx9.c, jx9.c> f;
    public static volatile yx9<dx9, dx9.f, dx9.f> g;
    public static volatile xx9<ix9, ix9> h;
    public static volatile xx9<ix9, ix9> i;
    public static volatile xx9<ix9, ix9> j;
    public static volatile xx9<sx9, sx9> k;
    public static volatile xx9<mx9, mx9> l;
    public static volatile xx9<mx9, mx9> m;
    public static volatile wx9<? extends ScheduledExecutorService> n;
    public static volatile xx9<Throwable, Throwable> o;
    public static volatile xx9<Throwable, Throwable> p;
    public static volatile xx9<Throwable, Throwable> q;
    public static volatile xx9<fx9.b, fx9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements xx9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.xx9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                p1a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements xx9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.xx9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                p1a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements xx9<fx9.a, fx9.a> {
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
        @Override // com.baidu.tieba.xx9
        public fx9.a call(fx9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                p1a.c().d().a(aVar);
                return aVar;
            }
            return (fx9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements xx9<jx9.c, jx9.c> {
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
        @Override // com.baidu.tieba.xx9
        public jx9.c call(jx9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                p1a.c().g().a(cVar);
                return cVar;
            }
            return (jx9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements xx9<dx9.f, dx9.f> {
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
        @Override // com.baidu.tieba.xx9
        public dx9.f call(dx9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                p1a.c().a().a(fVar);
                return fVar;
            }
            return (dx9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements tx9<Throwable> {
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
        @Override // com.baidu.tieba.tx9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                p1a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements yx9<fx9, fx9.a, fx9.a> {
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
        @Override // com.baidu.tieba.yx9
        public fx9.a call(fx9 fx9Var, fx9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fx9Var, aVar)) == null) {
                p1a.c().d().e(fx9Var, aVar);
                return aVar;
            }
            return (fx9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements xx9<mx9, mx9> {
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
        @Override // com.baidu.tieba.xx9
        public mx9 call(mx9 mx9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mx9Var)) == null) {
                p1a.c().d().d(mx9Var);
                return mx9Var;
            }
            return (mx9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements yx9<jx9, jx9.c, jx9.c> {
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
        @Override // com.baidu.tieba.yx9
        public jx9.c call(jx9 jx9Var, jx9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jx9Var, cVar)) == null) {
                r1a g = p1a.c().g();
                if (g == s1a.e()) {
                    return cVar;
                }
                xy9 xy9Var = new xy9(cVar);
                g.d(jx9Var, xy9Var);
                return new uy9(xy9Var);
            }
            return (jx9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements xx9<mx9, mx9> {
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
        @Override // com.baidu.tieba.xx9
        public mx9 call(mx9 mx9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mx9Var)) == null) {
                p1a.c().g().c(mx9Var);
                return mx9Var;
            }
            return (mx9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements yx9<dx9, dx9.f, dx9.f> {
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
        @Override // com.baidu.tieba.yx9
        public dx9.f call(dx9 dx9Var, dx9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dx9Var, fVar)) == null) {
                p1a.c().a().c(dx9Var, fVar);
                return fVar;
            }
            return (dx9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements xx9<sx9, sx9> {
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
        @Override // com.baidu.tieba.xx9
        public sx9 call(sx9 sx9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sx9Var)) == null) {
                p1a.c().f().k(sx9Var);
                return sx9Var;
            }
            return (sx9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements xx9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.xx9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                p1a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements xx9<fx9.b, fx9.b> {
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
        @Override // com.baidu.tieba.xx9
        public fx9.b call(fx9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                p1a.c().d().b(bVar);
                return bVar;
            }
            return (fx9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921196, "Lcom/baidu/tieba/m1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921196, "Lcom/baidu/tieba/m1a;");
                return;
            }
        }
        b();
    }

    public static wx9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (wx9) invokeV.objValue;
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
            xx9<Throwable, Throwable> xx9Var = q;
            return xx9Var != null ? xx9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> dx9.f e(dx9 dx9Var, dx9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, dx9Var, fVar)) == null) {
            yx9<dx9, dx9.f, dx9.f> yx9Var = g;
            return yx9Var != null ? yx9Var.call(dx9Var, fVar) : fVar;
        }
        return (dx9.f) invokeLL.objValue;
    }

    public static ix9 f(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ix9Var)) == null) {
            xx9<ix9, ix9> xx9Var = h;
            return xx9Var != null ? xx9Var.call(ix9Var) : ix9Var;
        }
        return (ix9) invokeL.objValue;
    }

    public static dx9.f g(dx9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            xx9<dx9.f, dx9.f> xx9Var = d;
            return xx9Var != null ? xx9Var.call(fVar) : fVar;
        }
        return (dx9.f) invokeL.objValue;
    }

    public static <T> fx9.a<T> h(fx9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            xx9<fx9.a, fx9.a> xx9Var = b;
            return xx9Var != null ? xx9Var.call(aVar) : aVar;
        }
        return (fx9.a) invokeL.objValue;
    }

    public static <T> jx9.c<T> i(jx9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            xx9<jx9.c, jx9.c> xx9Var = c;
            return xx9Var != null ? xx9Var.call(cVar) : cVar;
        }
        return (jx9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            tx9<Throwable> tx9Var = a;
            if (tx9Var != null) {
                try {
                    tx9Var.call(th);
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

    public static ix9 k(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ix9Var)) == null) {
            xx9<ix9, ix9> xx9Var = i;
            return xx9Var != null ? xx9Var.call(ix9Var) : ix9Var;
        }
        return (ix9) invokeL.objValue;
    }

    public static ix9 l(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, ix9Var)) == null) {
            xx9<ix9, ix9> xx9Var = j;
            return xx9Var != null ? xx9Var.call(ix9Var) : ix9Var;
        }
        return (ix9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            xx9<Throwable, Throwable> xx9Var = o;
            return xx9Var != null ? xx9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> fx9.b<R, T> n(fx9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            xx9<fx9.b, fx9.b> xx9Var = r;
            return xx9Var != null ? xx9Var.call(bVar) : bVar;
        }
        return (fx9.b) invokeL.objValue;
    }

    public static mx9 o(mx9 mx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, mx9Var)) == null) {
            xx9<mx9, mx9> xx9Var = l;
            return xx9Var != null ? xx9Var.call(mx9Var) : mx9Var;
        }
        return (mx9) invokeL.objValue;
    }

    public static <T> fx9.a<T> p(fx9<T> fx9Var, fx9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, fx9Var, aVar)) == null) {
            yx9<fx9, fx9.a, fx9.a> yx9Var = e;
            return yx9Var != null ? yx9Var.call(fx9Var, aVar) : aVar;
        }
        return (fx9.a) invokeLL.objValue;
    }

    public static sx9 q(sx9 sx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, sx9Var)) == null) {
            xx9<sx9, sx9> xx9Var = k;
            return xx9Var != null ? xx9Var.call(sx9Var) : sx9Var;
        }
        return (sx9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            xx9<Throwable, Throwable> xx9Var = p;
            return xx9Var != null ? xx9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static mx9 s(mx9 mx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, mx9Var)) == null) {
            xx9<mx9, mx9> xx9Var = m;
            return xx9Var != null ? xx9Var.call(mx9Var) : mx9Var;
        }
        return (mx9) invokeL.objValue;
    }

    public static <T> jx9.c<T> t(jx9<T> jx9Var, jx9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, jx9Var, cVar)) == null) {
            yx9<jx9, jx9.c, jx9.c> yx9Var = f;
            return yx9Var != null ? yx9Var.call(jx9Var, cVar) : cVar;
        }
        return (jx9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
