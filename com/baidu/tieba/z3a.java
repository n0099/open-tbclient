package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qz9;
import com.baidu.tieba.sz9;
import com.baidu.tieba.wz9;
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
public final class z3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g0a<Throwable> a;
    public static volatile k0a<sz9.a, sz9.a> b;
    public static volatile k0a<wz9.c, wz9.c> c;
    public static volatile k0a<qz9.f, qz9.f> d;
    public static volatile l0a<sz9, sz9.a, sz9.a> e;
    public static volatile l0a<wz9, wz9.c, wz9.c> f;
    public static volatile l0a<qz9, qz9.f, qz9.f> g;
    public static volatile k0a<vz9, vz9> h;
    public static volatile k0a<vz9, vz9> i;
    public static volatile k0a<vz9, vz9> j;
    public static volatile k0a<f0a, f0a> k;
    public static volatile k0a<zz9, zz9> l;
    public static volatile k0a<zz9, zz9> m;
    public static volatile j0a<? extends ScheduledExecutorService> n;
    public static volatile k0a<Throwable, Throwable> o;
    public static volatile k0a<Throwable, Throwable> p;
    public static volatile k0a<Throwable, Throwable> q;
    public static volatile k0a<sz9.b, sz9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements k0a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.k0a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                c4a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements k0a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.k0a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                c4a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements k0a<sz9.a, sz9.a> {
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
        @Override // com.baidu.tieba.k0a
        public sz9.a call(sz9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                c4a.c().d().a(aVar);
                return aVar;
            }
            return (sz9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements k0a<wz9.c, wz9.c> {
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
        @Override // com.baidu.tieba.k0a
        public wz9.c call(wz9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                c4a.c().g().a(cVar);
                return cVar;
            }
            return (wz9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements k0a<qz9.f, qz9.f> {
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
        @Override // com.baidu.tieba.k0a
        public qz9.f call(qz9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                c4a.c().a().a(fVar);
                return fVar;
            }
            return (qz9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements g0a<Throwable> {
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
        @Override // com.baidu.tieba.g0a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                c4a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements l0a<sz9, sz9.a, sz9.a> {
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
        @Override // com.baidu.tieba.l0a
        public sz9.a call(sz9 sz9Var, sz9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sz9Var, aVar)) == null) {
                c4a.c().d().e(sz9Var, aVar);
                return aVar;
            }
            return (sz9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements k0a<zz9, zz9> {
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
        @Override // com.baidu.tieba.k0a
        public zz9 call(zz9 zz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zz9Var)) == null) {
                c4a.c().d().d(zz9Var);
                return zz9Var;
            }
            return (zz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements l0a<wz9, wz9.c, wz9.c> {
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
        @Override // com.baidu.tieba.l0a
        public wz9.c call(wz9 wz9Var, wz9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wz9Var, cVar)) == null) {
                e4a g = c4a.c().g();
                if (g == f4a.e()) {
                    return cVar;
                }
                k1a k1aVar = new k1a(cVar);
                g.d(wz9Var, k1aVar);
                return new h1a(k1aVar);
            }
            return (wz9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements k0a<zz9, zz9> {
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
        @Override // com.baidu.tieba.k0a
        public zz9 call(zz9 zz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zz9Var)) == null) {
                c4a.c().g().c(zz9Var);
                return zz9Var;
            }
            return (zz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements l0a<qz9, qz9.f, qz9.f> {
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
        @Override // com.baidu.tieba.l0a
        public qz9.f call(qz9 qz9Var, qz9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qz9Var, fVar)) == null) {
                c4a.c().a().c(qz9Var, fVar);
                return fVar;
            }
            return (qz9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements k0a<f0a, f0a> {
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
        @Override // com.baidu.tieba.k0a
        public f0a call(f0a f0aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f0aVar)) == null) {
                c4a.c().f().k(f0aVar);
                return f0aVar;
            }
            return (f0a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements k0a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.k0a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                c4a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements k0a<sz9.b, sz9.b> {
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
        @Override // com.baidu.tieba.k0a
        public sz9.b call(sz9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                c4a.c().d().b(bVar);
                return bVar;
            }
            return (sz9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310401, "Lcom/baidu/tieba/z3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310401, "Lcom/baidu/tieba/z3a;");
                return;
            }
        }
        b();
    }

    public static j0a<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (j0a) invokeV.objValue;
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
            k0a<Throwable, Throwable> k0aVar = q;
            if (k0aVar != null) {
                return k0aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static vz9 f(vz9 vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, vz9Var)) == null) {
            k0a<vz9, vz9> k0aVar = h;
            if (k0aVar != null) {
                return k0aVar.call(vz9Var);
            }
            return vz9Var;
        }
        return (vz9) invokeL.objValue;
    }

    public static qz9.f g(qz9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            k0a<qz9.f, qz9.f> k0aVar = d;
            if (k0aVar != null) {
                return k0aVar.call(fVar);
            }
            return fVar;
        }
        return (qz9.f) invokeL.objValue;
    }

    public static <T> sz9.a<T> h(sz9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            k0a<sz9.a, sz9.a> k0aVar = b;
            if (k0aVar != null) {
                return k0aVar.call(aVar);
            }
            return aVar;
        }
        return (sz9.a) invokeL.objValue;
    }

    public static <T> wz9.c<T> i(wz9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            k0a<wz9.c, wz9.c> k0aVar = c;
            if (k0aVar != null) {
                return k0aVar.call(cVar);
            }
            return cVar;
        }
        return (wz9.c) invokeL.objValue;
    }

    public static vz9 k(vz9 vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, vz9Var)) == null) {
            k0a<vz9, vz9> k0aVar = i;
            if (k0aVar != null) {
                return k0aVar.call(vz9Var);
            }
            return vz9Var;
        }
        return (vz9) invokeL.objValue;
    }

    public static vz9 l(vz9 vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, vz9Var)) == null) {
            k0a<vz9, vz9> k0aVar = j;
            if (k0aVar != null) {
                return k0aVar.call(vz9Var);
            }
            return vz9Var;
        }
        return (vz9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            k0a<Throwable, Throwable> k0aVar = o;
            if (k0aVar != null) {
                return k0aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> sz9.b<R, T> n(sz9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            k0a<sz9.b, sz9.b> k0aVar = r;
            if (k0aVar != null) {
                return k0aVar.call(bVar);
            }
            return bVar;
        }
        return (sz9.b) invokeL.objValue;
    }

    public static zz9 o(zz9 zz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, zz9Var)) == null) {
            k0a<zz9, zz9> k0aVar = l;
            if (k0aVar != null) {
                return k0aVar.call(zz9Var);
            }
            return zz9Var;
        }
        return (zz9) invokeL.objValue;
    }

    public static f0a q(f0a f0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, f0aVar)) == null) {
            k0a<f0a, f0a> k0aVar = k;
            if (k0aVar != null) {
                return k0aVar.call(f0aVar);
            }
            return f0aVar;
        }
        return (f0a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            k0a<Throwable, Throwable> k0aVar = p;
            if (k0aVar != null) {
                return k0aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static zz9 s(zz9 zz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, zz9Var)) == null) {
            k0a<zz9, zz9> k0aVar = m;
            if (k0aVar != null) {
                return k0aVar.call(zz9Var);
            }
            return zz9Var;
        }
        return (zz9) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> qz9.f e(qz9 qz9Var, qz9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, qz9Var, fVar)) == null) {
            l0a<qz9, qz9.f, qz9.f> l0aVar = g;
            if (l0aVar != null) {
                return l0aVar.call(qz9Var, fVar);
            }
            return fVar;
        }
        return (qz9.f) invokeLL.objValue;
    }

    public static <T> sz9.a<T> p(sz9<T> sz9Var, sz9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, sz9Var, aVar)) == null) {
            l0a<sz9, sz9.a, sz9.a> l0aVar = e;
            if (l0aVar != null) {
                return l0aVar.call(sz9Var, aVar);
            }
            return aVar;
        }
        return (sz9.a) invokeLL.objValue;
    }

    public static <T> wz9.c<T> t(wz9<T> wz9Var, wz9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, wz9Var, cVar)) == null) {
            l0a<wz9, wz9.c, wz9.c> l0aVar = f;
            if (l0aVar != null) {
                return l0aVar.call(wz9Var, cVar);
            }
            return cVar;
        }
        return (wz9.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            g0a<Throwable> g0aVar = a;
            if (g0aVar != null) {
                try {
                    g0aVar.call(th);
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
