package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gmb;
import com.baidu.tieba.imb;
import com.baidu.tieba.mmb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public final class sqb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wmb<Throwable> a;
    public static volatile anb<imb.a, imb.a> b;
    public static volatile anb<mmb.c, mmb.c> c;
    public static volatile anb<gmb.f, gmb.f> d;
    public static volatile bnb<imb, imb.a, imb.a> e;
    public static volatile bnb<mmb, mmb.c, mmb.c> f;
    public static volatile bnb<gmb, gmb.f, gmb.f> g;
    public static volatile anb<lmb, lmb> h;
    public static volatile anb<lmb, lmb> i;
    public static volatile anb<lmb, lmb> j;
    public static volatile anb<vmb, vmb> k;
    public static volatile anb<pmb, pmb> l;
    public static volatile anb<pmb, pmb> m;
    public static volatile zmb<? extends ScheduledExecutorService> n;
    public static volatile anb<Throwable, Throwable> o;
    public static volatile anb<Throwable, Throwable> p;
    public static volatile anb<Throwable, Throwable> q;
    public static volatile anb<imb.b, imb.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements anb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.anb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                vqb.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements anb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.anb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                vqb.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements anb<imb.a, imb.a> {
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
        @Override // com.baidu.tieba.anb
        public imb.a call(imb.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                vqb.c().d().a(aVar);
                return aVar;
            }
            return (imb.a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements anb<mmb.c, mmb.c> {
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
        @Override // com.baidu.tieba.anb
        public mmb.c call(mmb.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                vqb.c().g().a(cVar);
                return cVar;
            }
            return (mmb.c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements anb<gmb.f, gmb.f> {
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
        @Override // com.baidu.tieba.anb
        public gmb.f call(gmb.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                vqb.c().a().a(fVar);
                return fVar;
            }
            return (gmb.f) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements wmb<Throwable> {
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
        @Override // com.baidu.tieba.wmb
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                vqb.c().b().a(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements bnb<imb, imb.a, imb.a> {
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
        @Override // com.baidu.tieba.bnb
        public imb.a call(imb imbVar, imb.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, imbVar, aVar)) == null) {
                vqb.c().d().e(imbVar, aVar);
                return aVar;
            }
            return (imb.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements anb<pmb, pmb> {
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
        @Override // com.baidu.tieba.anb
        public pmb call(pmb pmbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pmbVar)) == null) {
                vqb.c().d().d(pmbVar);
                return pmbVar;
            }
            return (pmb) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements bnb<mmb, mmb.c, mmb.c> {
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
        @Override // com.baidu.tieba.bnb
        public mmb.c call(mmb mmbVar, mmb.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mmbVar, cVar)) == null) {
                xqb g = vqb.c().g();
                if (g == yqb.e()) {
                    return cVar;
                }
                dob dobVar = new dob(cVar);
                g.d(mmbVar, dobVar);
                return new aob(dobVar);
            }
            return (mmb.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements anb<pmb, pmb> {
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
        @Override // com.baidu.tieba.anb
        public pmb call(pmb pmbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pmbVar)) == null) {
                vqb.c().g().c(pmbVar);
                return pmbVar;
            }
            return (pmb) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements bnb<gmb, gmb.f, gmb.f> {
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
        @Override // com.baidu.tieba.bnb
        public gmb.f call(gmb gmbVar, gmb.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gmbVar, fVar)) == null) {
                vqb.c().a().c(gmbVar, fVar);
                return fVar;
            }
            return (gmb.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements anb<vmb, vmb> {
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
        @Override // com.baidu.tieba.anb
        public vmb call(vmb vmbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vmbVar)) == null) {
                vqb.c().f().k(vmbVar);
                return vmbVar;
            }
            return (vmb) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements anb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.anb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                vqb.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements anb<imb.b, imb.b> {
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
        @Override // com.baidu.tieba.anb
        public imb.b call(imb.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                vqb.c().d().b(bVar);
                return bVar;
            }
            return (imb.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161477, "Lcom/baidu/tieba/sqb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161477, "Lcom/baidu/tieba/sqb;");
                return;
            }
        }
        b();
    }

    public static zmb<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (zmb) invokeV.objValue;
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
            anb<Throwable, Throwable> anbVar = q;
            if (anbVar != null) {
                return anbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static lmb f(lmb lmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, lmbVar)) == null) {
            anb<lmb, lmb> anbVar = h;
            if (anbVar != null) {
                return anbVar.call(lmbVar);
            }
            return lmbVar;
        }
        return (lmb) invokeL.objValue;
    }

    public static gmb.f g(gmb.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            anb<gmb.f, gmb.f> anbVar = d;
            if (anbVar != null) {
                return anbVar.call(fVar);
            }
            return fVar;
        }
        return (gmb.f) invokeL.objValue;
    }

    public static <T> imb.a<T> h(imb.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            anb<imb.a, imb.a> anbVar = b;
            if (anbVar != null) {
                return anbVar.call(aVar);
            }
            return aVar;
        }
        return (imb.a) invokeL.objValue;
    }

    public static <T> mmb.c<T> i(mmb.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            anb<mmb.c, mmb.c> anbVar = c;
            if (anbVar != null) {
                return anbVar.call(cVar);
            }
            return cVar;
        }
        return (mmb.c) invokeL.objValue;
    }

    public static lmb k(lmb lmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, lmbVar)) == null) {
            anb<lmb, lmb> anbVar = i;
            if (anbVar != null) {
                return anbVar.call(lmbVar);
            }
            return lmbVar;
        }
        return (lmb) invokeL.objValue;
    }

    public static lmb l(lmb lmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, lmbVar)) == null) {
            anb<lmb, lmb> anbVar = j;
            if (anbVar != null) {
                return anbVar.call(lmbVar);
            }
            return lmbVar;
        }
        return (lmb) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            anb<Throwable, Throwable> anbVar = o;
            if (anbVar != null) {
                return anbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> imb.b<R, T> n(imb.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            anb<imb.b, imb.b> anbVar = r;
            if (anbVar != null) {
                return anbVar.call(bVar);
            }
            return bVar;
        }
        return (imb.b) invokeL.objValue;
    }

    public static pmb o(pmb pmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, pmbVar)) == null) {
            anb<pmb, pmb> anbVar = l;
            if (anbVar != null) {
                return anbVar.call(pmbVar);
            }
            return pmbVar;
        }
        return (pmb) invokeL.objValue;
    }

    public static vmb q(vmb vmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, vmbVar)) == null) {
            anb<vmb, vmb> anbVar = k;
            if (anbVar != null) {
                return anbVar.call(vmbVar);
            }
            return vmbVar;
        }
        return (vmb) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            anb<Throwable, Throwable> anbVar = p;
            if (anbVar != null) {
                return anbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static pmb s(pmb pmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, pmbVar)) == null) {
            anb<pmb, pmb> anbVar = m;
            if (anbVar != null) {
                return anbVar.call(pmbVar);
            }
            return pmbVar;
        }
        return (pmb) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> gmb.f e(gmb gmbVar, gmb.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, gmbVar, fVar)) == null) {
            bnb<gmb, gmb.f, gmb.f> bnbVar = g;
            if (bnbVar != null) {
                return bnbVar.call(gmbVar, fVar);
            }
            return fVar;
        }
        return (gmb.f) invokeLL.objValue;
    }

    public static <T> imb.a<T> p(imb<T> imbVar, imb.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, imbVar, aVar)) == null) {
            bnb<imb, imb.a, imb.a> bnbVar = e;
            if (bnbVar != null) {
                return bnbVar.call(imbVar, aVar);
            }
            return aVar;
        }
        return (imb.a) invokeLL.objValue;
    }

    public static <T> mmb.c<T> t(mmb<T> mmbVar, mmb.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, mmbVar, cVar)) == null) {
            bnb<mmb, mmb.c, mmb.c> bnbVar = f;
            if (bnbVar != null) {
                return bnbVar.call(mmbVar, cVar);
            }
            return cVar;
        }
        return (mmb.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            wmb<Throwable> wmbVar = a;
            if (wmbVar != null) {
                try {
                    wmbVar.call(th);
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
