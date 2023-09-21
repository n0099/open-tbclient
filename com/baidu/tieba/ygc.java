package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.icc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.occ;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public final class ygc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ycc<Throwable> a;
    public static volatile ddc<kcc.a, kcc.a> b;
    public static volatile ddc<occ.c, occ.c> c;
    public static volatile ddc<icc.f, icc.f> d;
    public static volatile edc<kcc, kcc.a, kcc.a> e;
    public static volatile edc<occ, occ.c, occ.c> f;
    public static volatile edc<icc, icc.f, icc.f> g;
    public static volatile ddc<ncc, ncc> h;
    public static volatile ddc<ncc, ncc> i;
    public static volatile ddc<ncc, ncc> j;
    public static volatile ddc<xcc, xcc> k;
    public static volatile ddc<rcc, rcc> l;
    public static volatile ddc<rcc, rcc> m;
    public static volatile cdc<? extends ScheduledExecutorService> n;
    public static volatile ddc<Throwable, Throwable> o;
    public static volatile ddc<Throwable, Throwable> p;
    public static volatile ddc<Throwable, Throwable> q;
    public static volatile ddc<kcc.b, kcc.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements ddc<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ddc
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                bhc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements ddc<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ddc
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                bhc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements ddc<kcc.a, kcc.a> {
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
        @Override // com.baidu.tieba.ddc
        public kcc.a call(kcc.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                bhc.c().d().a(aVar);
                return aVar;
            }
            return (kcc.a) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements ddc<occ.c, occ.c> {
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
        @Override // com.baidu.tieba.ddc
        public occ.c call(occ.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                bhc.c().g().a(cVar);
                return cVar;
            }
            return (occ.c) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements ddc<icc.f, icc.f> {
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
        @Override // com.baidu.tieba.ddc
        public icc.f call(icc.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                bhc.c().a().a(fVar);
                return fVar;
            }
            return (icc.f) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements ycc<Throwable> {
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
        @Override // com.baidu.tieba.ycc
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                bhc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements edc<kcc, kcc.a, kcc.a> {
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
        @Override // com.baidu.tieba.edc
        public kcc.a call(kcc kccVar, kcc.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kccVar, aVar)) == null) {
                bhc.c().d().e(kccVar, aVar);
                return aVar;
            }
            return (kcc.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements ddc<rcc, rcc> {
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
        @Override // com.baidu.tieba.ddc
        public rcc call(rcc rccVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rccVar)) == null) {
                bhc.c().d().d(rccVar);
                return rccVar;
            }
            return (rcc) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements edc<occ, occ.c, occ.c> {
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
        @Override // com.baidu.tieba.edc
        public occ.c call(occ occVar, occ.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, occVar, cVar)) == null) {
                dhc g = bhc.c().g();
                if (g == ehc.e()) {
                    return cVar;
                }
                jec jecVar = new jec(cVar);
                g.d(occVar, jecVar);
                return new gec(jecVar);
            }
            return (occ.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j implements ddc<rcc, rcc> {
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
        @Override // com.baidu.tieba.ddc
        public rcc call(rcc rccVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rccVar)) == null) {
                bhc.c().g().c(rccVar);
                return rccVar;
            }
            return (rcc) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class k implements edc<icc, icc.f, icc.f> {
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
        @Override // com.baidu.tieba.edc
        public icc.f call(icc iccVar, icc.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iccVar, fVar)) == null) {
                bhc.c().a().c(iccVar, fVar);
                return fVar;
            }
            return (icc.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class l implements ddc<xcc, xcc> {
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
        @Override // com.baidu.tieba.ddc
        public xcc call(xcc xccVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xccVar)) == null) {
                bhc.c().f().k(xccVar);
                return xccVar;
            }
            return (xcc) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements ddc<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ddc
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                bhc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class n implements ddc<kcc.b, kcc.b> {
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
        @Override // com.baidu.tieba.ddc
        public kcc.b call(kcc.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                bhc.c().d().b(bVar);
                return bVar;
            }
            return (kcc.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948330644, "Lcom/baidu/tieba/ygc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948330644, "Lcom/baidu/tieba/ygc;");
                return;
            }
        }
        b();
    }

    public static cdc<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (cdc) invokeV.objValue;
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
            ddc<Throwable, Throwable> ddcVar = q;
            if (ddcVar != null) {
                return ddcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static ncc f(ncc nccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, nccVar)) == null) {
            ddc<ncc, ncc> ddcVar = h;
            if (ddcVar != null) {
                return ddcVar.call(nccVar);
            }
            return nccVar;
        }
        return (ncc) invokeL.objValue;
    }

    public static icc.f g(icc.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            ddc<icc.f, icc.f> ddcVar = d;
            if (ddcVar != null) {
                return ddcVar.call(fVar);
            }
            return fVar;
        }
        return (icc.f) invokeL.objValue;
    }

    public static <T> kcc.a<T> h(kcc.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            ddc<kcc.a, kcc.a> ddcVar = b;
            if (ddcVar != null) {
                return ddcVar.call(aVar);
            }
            return aVar;
        }
        return (kcc.a) invokeL.objValue;
    }

    public static <T> occ.c<T> i(occ.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            ddc<occ.c, occ.c> ddcVar = c;
            if (ddcVar != null) {
                return ddcVar.call(cVar);
            }
            return cVar;
        }
        return (occ.c) invokeL.objValue;
    }

    public static ncc k(ncc nccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, nccVar)) == null) {
            ddc<ncc, ncc> ddcVar = i;
            if (ddcVar != null) {
                return ddcVar.call(nccVar);
            }
            return nccVar;
        }
        return (ncc) invokeL.objValue;
    }

    public static ncc l(ncc nccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, nccVar)) == null) {
            ddc<ncc, ncc> ddcVar = j;
            if (ddcVar != null) {
                return ddcVar.call(nccVar);
            }
            return nccVar;
        }
        return (ncc) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            ddc<Throwable, Throwable> ddcVar = o;
            if (ddcVar != null) {
                return ddcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> kcc.b<R, T> n(kcc.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            ddc<kcc.b, kcc.b> ddcVar = r;
            if (ddcVar != null) {
                return ddcVar.call(bVar);
            }
            return bVar;
        }
        return (kcc.b) invokeL.objValue;
    }

    public static rcc o(rcc rccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, rccVar)) == null) {
            ddc<rcc, rcc> ddcVar = l;
            if (ddcVar != null) {
                return ddcVar.call(rccVar);
            }
            return rccVar;
        }
        return (rcc) invokeL.objValue;
    }

    public static xcc q(xcc xccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, xccVar)) == null) {
            ddc<xcc, xcc> ddcVar = k;
            if (ddcVar != null) {
                return ddcVar.call(xccVar);
            }
            return xccVar;
        }
        return (xcc) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            ddc<Throwable, Throwable> ddcVar = p;
            if (ddcVar != null) {
                return ddcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static rcc s(rcc rccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, rccVar)) == null) {
            ddc<rcc, rcc> ddcVar = m;
            if (ddcVar != null) {
                return ddcVar.call(rccVar);
            }
            return rccVar;
        }
        return (rcc) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> icc.f e(icc iccVar, icc.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, iccVar, fVar)) == null) {
            edc<icc, icc.f, icc.f> edcVar = g;
            if (edcVar != null) {
                return edcVar.call(iccVar, fVar);
            }
            return fVar;
        }
        return (icc.f) invokeLL.objValue;
    }

    public static <T> kcc.a<T> p(kcc<T> kccVar, kcc.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, kccVar, aVar)) == null) {
            edc<kcc, kcc.a, kcc.a> edcVar = e;
            if (edcVar != null) {
                return edcVar.call(kccVar, aVar);
            }
            return aVar;
        }
        return (kcc.a) invokeLL.objValue;
    }

    public static <T> occ.c<T> t(occ<T> occVar, occ.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, occVar, cVar)) == null) {
            edc<occ, occ.c, occ.c> edcVar = f;
            if (edcVar != null) {
                return edcVar.call(occVar, cVar);
            }
            return cVar;
        }
        return (occ.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            ycc<Throwable> yccVar = a;
            if (yccVar != null) {
                try {
                    yccVar.call(th);
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
