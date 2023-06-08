package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lmb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.rmb;
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
public final class xqb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bnb<Throwable> a;
    public static volatile fnb<nmb.a, nmb.a> b;
    public static volatile fnb<rmb.c, rmb.c> c;
    public static volatile fnb<lmb.f, lmb.f> d;
    public static volatile gnb<nmb, nmb.a, nmb.a> e;
    public static volatile gnb<rmb, rmb.c, rmb.c> f;
    public static volatile gnb<lmb, lmb.f, lmb.f> g;
    public static volatile fnb<qmb, qmb> h;
    public static volatile fnb<qmb, qmb> i;
    public static volatile fnb<qmb, qmb> j;
    public static volatile fnb<anb, anb> k;
    public static volatile fnb<umb, umb> l;
    public static volatile fnb<umb, umb> m;
    public static volatile enb<? extends ScheduledExecutorService> n;
    public static volatile fnb<Throwable, Throwable> o;
    public static volatile fnb<Throwable, Throwable> p;
    public static volatile fnb<Throwable, Throwable> q;
    public static volatile fnb<nmb.b, nmb.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements fnb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.fnb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                arb.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements fnb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.fnb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                arb.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements fnb<nmb.a, nmb.a> {
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
        @Override // com.baidu.tieba.fnb
        public nmb.a call(nmb.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                arb.c().d().a(aVar);
                return aVar;
            }
            return (nmb.a) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements fnb<rmb.c, rmb.c> {
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
        @Override // com.baidu.tieba.fnb
        public rmb.c call(rmb.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                arb.c().g().a(cVar);
                return cVar;
            }
            return (rmb.c) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements fnb<lmb.f, lmb.f> {
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
        @Override // com.baidu.tieba.fnb
        public lmb.f call(lmb.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                arb.c().a().a(fVar);
                return fVar;
            }
            return (lmb.f) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements bnb<Throwable> {
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
        @Override // com.baidu.tieba.bnb
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                arb.c().b().a(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements gnb<nmb, nmb.a, nmb.a> {
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
        @Override // com.baidu.tieba.gnb
        public nmb.a call(nmb nmbVar, nmb.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, nmbVar, aVar)) == null) {
                arb.c().d().e(nmbVar, aVar);
                return aVar;
            }
            return (nmb.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements fnb<umb, umb> {
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
        @Override // com.baidu.tieba.fnb
        public umb call(umb umbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, umbVar)) == null) {
                arb.c().d().d(umbVar);
                return umbVar;
            }
            return (umb) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements gnb<rmb, rmb.c, rmb.c> {
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
        @Override // com.baidu.tieba.gnb
        public rmb.c call(rmb rmbVar, rmb.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rmbVar, cVar)) == null) {
                crb g = arb.c().g();
                if (g == drb.e()) {
                    return cVar;
                }
                iob iobVar = new iob(cVar);
                g.d(rmbVar, iobVar);
                return new fob(iobVar);
            }
            return (rmb.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j implements fnb<umb, umb> {
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
        @Override // com.baidu.tieba.fnb
        public umb call(umb umbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, umbVar)) == null) {
                arb.c().g().c(umbVar);
                return umbVar;
            }
            return (umb) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class k implements gnb<lmb, lmb.f, lmb.f> {
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
        @Override // com.baidu.tieba.gnb
        public lmb.f call(lmb lmbVar, lmb.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lmbVar, fVar)) == null) {
                arb.c().a().c(lmbVar, fVar);
                return fVar;
            }
            return (lmb.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class l implements fnb<anb, anb> {
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
        @Override // com.baidu.tieba.fnb
        public anb call(anb anbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, anbVar)) == null) {
                arb.c().f().k(anbVar);
                return anbVar;
            }
            return (anb) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements fnb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.fnb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                arb.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class n implements fnb<nmb.b, nmb.b> {
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
        @Override // com.baidu.tieba.fnb
        public nmb.b call(nmb.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                arb.c().d().b(bVar);
                return bVar;
            }
            return (nmb.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310432, "Lcom/baidu/tieba/xqb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310432, "Lcom/baidu/tieba/xqb;");
                return;
            }
        }
        b();
    }

    public static enb<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (enb) invokeV.objValue;
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
            fnb<Throwable, Throwable> fnbVar = q;
            if (fnbVar != null) {
                return fnbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static qmb f(qmb qmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qmbVar)) == null) {
            fnb<qmb, qmb> fnbVar = h;
            if (fnbVar != null) {
                return fnbVar.call(qmbVar);
            }
            return qmbVar;
        }
        return (qmb) invokeL.objValue;
    }

    public static lmb.f g(lmb.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            fnb<lmb.f, lmb.f> fnbVar = d;
            if (fnbVar != null) {
                return fnbVar.call(fVar);
            }
            return fVar;
        }
        return (lmb.f) invokeL.objValue;
    }

    public static <T> nmb.a<T> h(nmb.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            fnb<nmb.a, nmb.a> fnbVar = b;
            if (fnbVar != null) {
                return fnbVar.call(aVar);
            }
            return aVar;
        }
        return (nmb.a) invokeL.objValue;
    }

    public static <T> rmb.c<T> i(rmb.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            fnb<rmb.c, rmb.c> fnbVar = c;
            if (fnbVar != null) {
                return fnbVar.call(cVar);
            }
            return cVar;
        }
        return (rmb.c) invokeL.objValue;
    }

    public static qmb k(qmb qmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, qmbVar)) == null) {
            fnb<qmb, qmb> fnbVar = i;
            if (fnbVar != null) {
                return fnbVar.call(qmbVar);
            }
            return qmbVar;
        }
        return (qmb) invokeL.objValue;
    }

    public static qmb l(qmb qmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, qmbVar)) == null) {
            fnb<qmb, qmb> fnbVar = j;
            if (fnbVar != null) {
                return fnbVar.call(qmbVar);
            }
            return qmbVar;
        }
        return (qmb) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            fnb<Throwable, Throwable> fnbVar = o;
            if (fnbVar != null) {
                return fnbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> nmb.b<R, T> n(nmb.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            fnb<nmb.b, nmb.b> fnbVar = r;
            if (fnbVar != null) {
                return fnbVar.call(bVar);
            }
            return bVar;
        }
        return (nmb.b) invokeL.objValue;
    }

    public static umb o(umb umbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, umbVar)) == null) {
            fnb<umb, umb> fnbVar = l;
            if (fnbVar != null) {
                return fnbVar.call(umbVar);
            }
            return umbVar;
        }
        return (umb) invokeL.objValue;
    }

    public static anb q(anb anbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, anbVar)) == null) {
            fnb<anb, anb> fnbVar = k;
            if (fnbVar != null) {
                return fnbVar.call(anbVar);
            }
            return anbVar;
        }
        return (anb) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            fnb<Throwable, Throwable> fnbVar = p;
            if (fnbVar != null) {
                return fnbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static umb s(umb umbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, umbVar)) == null) {
            fnb<umb, umb> fnbVar = m;
            if (fnbVar != null) {
                return fnbVar.call(umbVar);
            }
            return umbVar;
        }
        return (umb) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> lmb.f e(lmb lmbVar, lmb.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, lmbVar, fVar)) == null) {
            gnb<lmb, lmb.f, lmb.f> gnbVar = g;
            if (gnbVar != null) {
                return gnbVar.call(lmbVar, fVar);
            }
            return fVar;
        }
        return (lmb.f) invokeLL.objValue;
    }

    public static <T> nmb.a<T> p(nmb<T> nmbVar, nmb.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, nmbVar, aVar)) == null) {
            gnb<nmb, nmb.a, nmb.a> gnbVar = e;
            if (gnbVar != null) {
                return gnbVar.call(nmbVar, aVar);
            }
            return aVar;
        }
        return (nmb.a) invokeLL.objValue;
    }

    public static <T> rmb.c<T> t(rmb<T> rmbVar, rmb.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, rmbVar, cVar)) == null) {
            gnb<rmb, rmb.c, rmb.c> gnbVar = f;
            if (gnbVar != null) {
                return gnbVar.call(rmbVar, cVar);
            }
            return cVar;
        }
        return (rmb.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            bnb<Throwable> bnbVar = a;
            if (bnbVar != null) {
                try {
                    bnbVar.call(th);
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
