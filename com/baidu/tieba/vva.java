package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mra;
import com.baidu.tieba.ora;
import com.baidu.tieba.sra;
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
public final class vva {
    public static /* synthetic */ Interceptable $ic;
    public static volatile csa<Throwable> a;
    public static volatile gsa<ora.a, ora.a> b;
    public static volatile gsa<sra.c, sra.c> c;
    public static volatile gsa<mra.f, mra.f> d;
    public static volatile hsa<ora, ora.a, ora.a> e;
    public static volatile hsa<sra, sra.c, sra.c> f;
    public static volatile hsa<mra, mra.f, mra.f> g;
    public static volatile gsa<rra, rra> h;
    public static volatile gsa<rra, rra> i;
    public static volatile gsa<rra, rra> j;
    public static volatile gsa<bsa, bsa> k;
    public static volatile gsa<vra, vra> l;
    public static volatile gsa<vra, vra> m;
    public static volatile fsa<? extends ScheduledExecutorService> n;
    public static volatile gsa<Throwable, Throwable> o;
    public static volatile gsa<Throwable, Throwable> p;
    public static volatile gsa<Throwable, Throwable> q;
    public static volatile gsa<ora.b, ora.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements gsa<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.gsa
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                yva.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements gsa<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.gsa
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                yva.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements gsa<ora.a, ora.a> {
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
        @Override // com.baidu.tieba.gsa
        public ora.a call(ora.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                yva.c().d().a(aVar);
                return aVar;
            }
            return (ora.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements gsa<sra.c, sra.c> {
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
        @Override // com.baidu.tieba.gsa
        public sra.c call(sra.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                yva.c().g().a(cVar);
                return cVar;
            }
            return (sra.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements gsa<mra.f, mra.f> {
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
        @Override // com.baidu.tieba.gsa
        public mra.f call(mra.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                yva.c().a().a(fVar);
                return fVar;
            }
            return (mra.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements csa<Throwable> {
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
        @Override // com.baidu.tieba.csa
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                yva.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements hsa<ora, ora.a, ora.a> {
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
        @Override // com.baidu.tieba.hsa
        public ora.a call(ora oraVar, ora.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, oraVar, aVar)) == null) {
                yva.c().d().e(oraVar, aVar);
                return aVar;
            }
            return (ora.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements gsa<vra, vra> {
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
        @Override // com.baidu.tieba.gsa
        public vra call(vra vraVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vraVar)) == null) {
                yva.c().d().d(vraVar);
                return vraVar;
            }
            return (vra) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements hsa<sra, sra.c, sra.c> {
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
        @Override // com.baidu.tieba.hsa
        public sra.c call(sra sraVar, sra.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sraVar, cVar)) == null) {
                awa g = yva.c().g();
                if (g == bwa.e()) {
                    return cVar;
                }
                gta gtaVar = new gta(cVar);
                g.d(sraVar, gtaVar);
                return new dta(gtaVar);
            }
            return (sra.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements gsa<vra, vra> {
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
        @Override // com.baidu.tieba.gsa
        public vra call(vra vraVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vraVar)) == null) {
                yva.c().g().c(vraVar);
                return vraVar;
            }
            return (vra) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements hsa<mra, mra.f, mra.f> {
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
        @Override // com.baidu.tieba.hsa
        public mra.f call(mra mraVar, mra.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mraVar, fVar)) == null) {
                yva.c().a().c(mraVar, fVar);
                return fVar;
            }
            return (mra.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements gsa<bsa, bsa> {
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
        @Override // com.baidu.tieba.gsa
        public bsa call(bsa bsaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bsaVar)) == null) {
                yva.c().f().k(bsaVar);
                return bsaVar;
            }
            return (bsa) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements gsa<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.gsa
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                yva.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements gsa<ora.b, ora.b> {
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
        @Override // com.baidu.tieba.gsa
        public ora.b call(ora.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                yva.c().d().b(bVar);
                return bVar;
            }
            return (ora.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255624, "Lcom/baidu/tieba/vva;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255624, "Lcom/baidu/tieba/vva;");
                return;
            }
        }
        b();
    }

    public static fsa<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (fsa) invokeV.objValue;
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
            gsa<Throwable, Throwable> gsaVar = q;
            if (gsaVar != null) {
                return gsaVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static rra f(rra rraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, rraVar)) == null) {
            gsa<rra, rra> gsaVar = h;
            if (gsaVar != null) {
                return gsaVar.call(rraVar);
            }
            return rraVar;
        }
        return (rra) invokeL.objValue;
    }

    public static mra.f g(mra.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            gsa<mra.f, mra.f> gsaVar = d;
            if (gsaVar != null) {
                return gsaVar.call(fVar);
            }
            return fVar;
        }
        return (mra.f) invokeL.objValue;
    }

    public static <T> ora.a<T> h(ora.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            gsa<ora.a, ora.a> gsaVar = b;
            if (gsaVar != null) {
                return gsaVar.call(aVar);
            }
            return aVar;
        }
        return (ora.a) invokeL.objValue;
    }

    public static <T> sra.c<T> i(sra.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            gsa<sra.c, sra.c> gsaVar = c;
            if (gsaVar != null) {
                return gsaVar.call(cVar);
            }
            return cVar;
        }
        return (sra.c) invokeL.objValue;
    }

    public static rra k(rra rraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, rraVar)) == null) {
            gsa<rra, rra> gsaVar = i;
            if (gsaVar != null) {
                return gsaVar.call(rraVar);
            }
            return rraVar;
        }
        return (rra) invokeL.objValue;
    }

    public static rra l(rra rraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, rraVar)) == null) {
            gsa<rra, rra> gsaVar = j;
            if (gsaVar != null) {
                return gsaVar.call(rraVar);
            }
            return rraVar;
        }
        return (rra) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            gsa<Throwable, Throwable> gsaVar = o;
            if (gsaVar != null) {
                return gsaVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> ora.b<R, T> n(ora.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            gsa<ora.b, ora.b> gsaVar = r;
            if (gsaVar != null) {
                return gsaVar.call(bVar);
            }
            return bVar;
        }
        return (ora.b) invokeL.objValue;
    }

    public static vra o(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, vraVar)) == null) {
            gsa<vra, vra> gsaVar = l;
            if (gsaVar != null) {
                return gsaVar.call(vraVar);
            }
            return vraVar;
        }
        return (vra) invokeL.objValue;
    }

    public static bsa q(bsa bsaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bsaVar)) == null) {
            gsa<bsa, bsa> gsaVar = k;
            if (gsaVar != null) {
                return gsaVar.call(bsaVar);
            }
            return bsaVar;
        }
        return (bsa) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            gsa<Throwable, Throwable> gsaVar = p;
            if (gsaVar != null) {
                return gsaVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static vra s(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, vraVar)) == null) {
            gsa<vra, vra> gsaVar = m;
            if (gsaVar != null) {
                return gsaVar.call(vraVar);
            }
            return vraVar;
        }
        return (vra) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> mra.f e(mra mraVar, mra.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mraVar, fVar)) == null) {
            hsa<mra, mra.f, mra.f> hsaVar = g;
            if (hsaVar != null) {
                return hsaVar.call(mraVar, fVar);
            }
            return fVar;
        }
        return (mra.f) invokeLL.objValue;
    }

    public static <T> ora.a<T> p(ora<T> oraVar, ora.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, oraVar, aVar)) == null) {
            hsa<ora, ora.a, ora.a> hsaVar = e;
            if (hsaVar != null) {
                return hsaVar.call(oraVar, aVar);
            }
            return aVar;
        }
        return (ora.a) invokeLL.objValue;
    }

    public static <T> sra.c<T> t(sra<T> sraVar, sra.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, sraVar, cVar)) == null) {
            hsa<sra, sra.c, sra.c> hsaVar = f;
            if (hsaVar != null) {
                return hsaVar.call(sraVar, cVar);
            }
            return cVar;
        }
        return (sra.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            csa<Throwable> csaVar = a;
            if (csaVar != null) {
                try {
                    csaVar.call(th);
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
