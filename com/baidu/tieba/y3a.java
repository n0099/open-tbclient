package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pz9;
import com.baidu.tieba.rz9;
import com.baidu.tieba.vz9;
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
public final class y3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f0a<Throwable> a;
    public static volatile j0a<rz9.a, rz9.a> b;
    public static volatile j0a<vz9.c, vz9.c> c;
    public static volatile j0a<pz9.f, pz9.f> d;
    public static volatile k0a<rz9, rz9.a, rz9.a> e;
    public static volatile k0a<vz9, vz9.c, vz9.c> f;
    public static volatile k0a<pz9, pz9.f, pz9.f> g;
    public static volatile j0a<uz9, uz9> h;
    public static volatile j0a<uz9, uz9> i;
    public static volatile j0a<uz9, uz9> j;
    public static volatile j0a<e0a, e0a> k;
    public static volatile j0a<yz9, yz9> l;
    public static volatile j0a<yz9, yz9> m;
    public static volatile i0a<? extends ScheduledExecutorService> n;
    public static volatile j0a<Throwable, Throwable> o;
    public static volatile j0a<Throwable, Throwable> p;
    public static volatile j0a<Throwable, Throwable> q;
    public static volatile j0a<rz9.b, rz9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements j0a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.j0a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                b4a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements j0a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.j0a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                b4a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements j0a<rz9.a, rz9.a> {
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
        @Override // com.baidu.tieba.j0a
        public rz9.a call(rz9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                b4a.c().d().a(aVar);
                return aVar;
            }
            return (rz9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements j0a<vz9.c, vz9.c> {
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
        @Override // com.baidu.tieba.j0a
        public vz9.c call(vz9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                b4a.c().g().a(cVar);
                return cVar;
            }
            return (vz9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements j0a<pz9.f, pz9.f> {
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
        @Override // com.baidu.tieba.j0a
        public pz9.f call(pz9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                b4a.c().a().a(fVar);
                return fVar;
            }
            return (pz9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements f0a<Throwable> {
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
        @Override // com.baidu.tieba.f0a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                b4a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements k0a<rz9, rz9.a, rz9.a> {
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
        @Override // com.baidu.tieba.k0a
        public rz9.a call(rz9 rz9Var, rz9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rz9Var, aVar)) == null) {
                b4a.c().d().e(rz9Var, aVar);
                return aVar;
            }
            return (rz9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements j0a<yz9, yz9> {
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
        @Override // com.baidu.tieba.j0a
        public yz9 call(yz9 yz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yz9Var)) == null) {
                b4a.c().d().d(yz9Var);
                return yz9Var;
            }
            return (yz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements k0a<vz9, vz9.c, vz9.c> {
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
        @Override // com.baidu.tieba.k0a
        public vz9.c call(vz9 vz9Var, vz9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vz9Var, cVar)) == null) {
                d4a g = b4a.c().g();
                if (g == e4a.e()) {
                    return cVar;
                }
                j1a j1aVar = new j1a(cVar);
                g.d(vz9Var, j1aVar);
                return new g1a(j1aVar);
            }
            return (vz9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements j0a<yz9, yz9> {
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
        @Override // com.baidu.tieba.j0a
        public yz9 call(yz9 yz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yz9Var)) == null) {
                b4a.c().g().c(yz9Var);
                return yz9Var;
            }
            return (yz9) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements k0a<pz9, pz9.f, pz9.f> {
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
        @Override // com.baidu.tieba.k0a
        public pz9.f call(pz9 pz9Var, pz9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pz9Var, fVar)) == null) {
                b4a.c().a().c(pz9Var, fVar);
                return fVar;
            }
            return (pz9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements j0a<e0a, e0a> {
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
        @Override // com.baidu.tieba.j0a
        public e0a call(e0a e0aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0aVar)) == null) {
                b4a.c().f().k(e0aVar);
                return e0aVar;
            }
            return (e0a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements j0a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.j0a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                b4a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements j0a<rz9.b, rz9.b> {
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
        @Override // com.baidu.tieba.j0a
        public rz9.b call(rz9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                b4a.c().d().b(bVar);
                return bVar;
            }
            return (rz9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280610, "Lcom/baidu/tieba/y3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280610, "Lcom/baidu/tieba/y3a;");
                return;
            }
        }
        b();
    }

    public static i0a<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (i0a) invokeV.objValue;
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
            j0a<Throwable, Throwable> j0aVar = q;
            if (j0aVar != null) {
                return j0aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static uz9 f(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uz9Var)) == null) {
            j0a<uz9, uz9> j0aVar = h;
            if (j0aVar != null) {
                return j0aVar.call(uz9Var);
            }
            return uz9Var;
        }
        return (uz9) invokeL.objValue;
    }

    public static pz9.f g(pz9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            j0a<pz9.f, pz9.f> j0aVar = d;
            if (j0aVar != null) {
                return j0aVar.call(fVar);
            }
            return fVar;
        }
        return (pz9.f) invokeL.objValue;
    }

    public static <T> rz9.a<T> h(rz9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            j0a<rz9.a, rz9.a> j0aVar = b;
            if (j0aVar != null) {
                return j0aVar.call(aVar);
            }
            return aVar;
        }
        return (rz9.a) invokeL.objValue;
    }

    public static <T> vz9.c<T> i(vz9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            j0a<vz9.c, vz9.c> j0aVar = c;
            if (j0aVar != null) {
                return j0aVar.call(cVar);
            }
            return cVar;
        }
        return (vz9.c) invokeL.objValue;
    }

    public static uz9 k(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uz9Var)) == null) {
            j0a<uz9, uz9> j0aVar = i;
            if (j0aVar != null) {
                return j0aVar.call(uz9Var);
            }
            return uz9Var;
        }
        return (uz9) invokeL.objValue;
    }

    public static uz9 l(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uz9Var)) == null) {
            j0a<uz9, uz9> j0aVar = j;
            if (j0aVar != null) {
                return j0aVar.call(uz9Var);
            }
            return uz9Var;
        }
        return (uz9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            j0a<Throwable, Throwable> j0aVar = o;
            if (j0aVar != null) {
                return j0aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> rz9.b<R, T> n(rz9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            j0a<rz9.b, rz9.b> j0aVar = r;
            if (j0aVar != null) {
                return j0aVar.call(bVar);
            }
            return bVar;
        }
        return (rz9.b) invokeL.objValue;
    }

    public static yz9 o(yz9 yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, yz9Var)) == null) {
            j0a<yz9, yz9> j0aVar = l;
            if (j0aVar != null) {
                return j0aVar.call(yz9Var);
            }
            return yz9Var;
        }
        return (yz9) invokeL.objValue;
    }

    public static e0a q(e0a e0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, e0aVar)) == null) {
            j0a<e0a, e0a> j0aVar = k;
            if (j0aVar != null) {
                return j0aVar.call(e0aVar);
            }
            return e0aVar;
        }
        return (e0a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            j0a<Throwable, Throwable> j0aVar = p;
            if (j0aVar != null) {
                return j0aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static yz9 s(yz9 yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, yz9Var)) == null) {
            j0a<yz9, yz9> j0aVar = m;
            if (j0aVar != null) {
                return j0aVar.call(yz9Var);
            }
            return yz9Var;
        }
        return (yz9) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> pz9.f e(pz9 pz9Var, pz9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, pz9Var, fVar)) == null) {
            k0a<pz9, pz9.f, pz9.f> k0aVar = g;
            if (k0aVar != null) {
                return k0aVar.call(pz9Var, fVar);
            }
            return fVar;
        }
        return (pz9.f) invokeLL.objValue;
    }

    public static <T> rz9.a<T> p(rz9<T> rz9Var, rz9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, rz9Var, aVar)) == null) {
            k0a<rz9, rz9.a, rz9.a> k0aVar = e;
            if (k0aVar != null) {
                return k0aVar.call(rz9Var, aVar);
            }
            return aVar;
        }
        return (rz9.a) invokeLL.objValue;
    }

    public static <T> vz9.c<T> t(vz9<T> vz9Var, vz9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, vz9Var, cVar)) == null) {
            k0a<vz9, vz9.c, vz9.c> k0aVar = f;
            if (k0aVar != null) {
                return k0aVar.call(vz9Var, cVar);
            }
            return cVar;
        }
        return (vz9.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            f0a<Throwable> f0aVar = a;
            if (f0aVar != null) {
                try {
                    f0aVar.call(th);
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
