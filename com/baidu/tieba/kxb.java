package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.btb;
import com.baidu.tieba.vsb;
import com.baidu.tieba.xsb;
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
public final class kxb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ltb<Throwable> a;
    public static volatile ptb<xsb.a, xsb.a> b;
    public static volatile ptb<btb.c, btb.c> c;
    public static volatile ptb<vsb.f, vsb.f> d;
    public static volatile qtb<xsb, xsb.a, xsb.a> e;
    public static volatile qtb<btb, btb.c, btb.c> f;
    public static volatile qtb<vsb, vsb.f, vsb.f> g;
    public static volatile ptb<atb, atb> h;
    public static volatile ptb<atb, atb> i;
    public static volatile ptb<atb, atb> j;
    public static volatile ptb<ktb, ktb> k;
    public static volatile ptb<etb, etb> l;
    public static volatile ptb<etb, etb> m;
    public static volatile otb<? extends ScheduledExecutorService> n;
    public static volatile ptb<Throwable, Throwable> o;
    public static volatile ptb<Throwable, Throwable> p;
    public static volatile ptb<Throwable, Throwable> q;
    public static volatile ptb<xsb.b, xsb.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ptb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ptb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                nxb.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ptb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ptb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                nxb.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements ptb<xsb.a, xsb.a> {
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
        @Override // com.baidu.tieba.ptb
        public xsb.a call(xsb.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                nxb.c().d().a(aVar);
                return aVar;
            }
            return (xsb.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements ptb<btb.c, btb.c> {
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
        @Override // com.baidu.tieba.ptb
        public btb.c call(btb.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                nxb.c().g().a(cVar);
                return cVar;
            }
            return (btb.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements ptb<vsb.f, vsb.f> {
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
        @Override // com.baidu.tieba.ptb
        public vsb.f call(vsb.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                nxb.c().a().a(fVar);
                return fVar;
            }
            return (vsb.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements ltb<Throwable> {
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
        @Override // com.baidu.tieba.ltb
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                nxb.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements qtb<xsb, xsb.a, xsb.a> {
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
        @Override // com.baidu.tieba.qtb
        public xsb.a call(xsb xsbVar, xsb.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xsbVar, aVar)) == null) {
                nxb.c().d().e(xsbVar, aVar);
                return aVar;
            }
            return (xsb.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements ptb<etb, etb> {
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
        @Override // com.baidu.tieba.ptb
        public etb call(etb etbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, etbVar)) == null) {
                nxb.c().d().d(etbVar);
                return etbVar;
            }
            return (etb) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements qtb<btb, btb.c, btb.c> {
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
        @Override // com.baidu.tieba.qtb
        public btb.c call(btb btbVar, btb.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, btbVar, cVar)) == null) {
                pxb g = nxb.c().g();
                if (g == qxb.e()) {
                    return cVar;
                }
                vub vubVar = new vub(cVar);
                g.d(btbVar, vubVar);
                return new sub(vubVar);
            }
            return (btb.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements ptb<etb, etb> {
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
        @Override // com.baidu.tieba.ptb
        public etb call(etb etbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, etbVar)) == null) {
                nxb.c().g().c(etbVar);
                return etbVar;
            }
            return (etb) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements qtb<vsb, vsb.f, vsb.f> {
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
        @Override // com.baidu.tieba.qtb
        public vsb.f call(vsb vsbVar, vsb.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vsbVar, fVar)) == null) {
                nxb.c().a().c(vsbVar, fVar);
                return fVar;
            }
            return (vsb.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements ptb<ktb, ktb> {
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
        @Override // com.baidu.tieba.ptb
        public ktb call(ktb ktbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ktbVar)) == null) {
                nxb.c().f().k(ktbVar);
                return ktbVar;
            }
            return (ktb) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements ptb<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.ptb
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                nxb.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements ptb<xsb.b, xsb.b> {
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
        @Override // com.baidu.tieba.ptb
        public xsb.b call(xsb.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                nxb.c().d().b(bVar);
                return bVar;
            }
            return (xsb.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947929876, "Lcom/baidu/tieba/kxb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947929876, "Lcom/baidu/tieba/kxb;");
                return;
            }
        }
        b();
    }

    public static otb<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (otb) invokeV.objValue;
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
            ptb<Throwable, Throwable> ptbVar = q;
            if (ptbVar != null) {
                return ptbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static atb f(atb atbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, atbVar)) == null) {
            ptb<atb, atb> ptbVar = h;
            if (ptbVar != null) {
                return ptbVar.call(atbVar);
            }
            return atbVar;
        }
        return (atb) invokeL.objValue;
    }

    public static vsb.f g(vsb.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            ptb<vsb.f, vsb.f> ptbVar = d;
            if (ptbVar != null) {
                return ptbVar.call(fVar);
            }
            return fVar;
        }
        return (vsb.f) invokeL.objValue;
    }

    public static <T> xsb.a<T> h(xsb.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            ptb<xsb.a, xsb.a> ptbVar = b;
            if (ptbVar != null) {
                return ptbVar.call(aVar);
            }
            return aVar;
        }
        return (xsb.a) invokeL.objValue;
    }

    public static <T> btb.c<T> i(btb.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            ptb<btb.c, btb.c> ptbVar = c;
            if (ptbVar != null) {
                return ptbVar.call(cVar);
            }
            return cVar;
        }
        return (btb.c) invokeL.objValue;
    }

    public static atb k(atb atbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, atbVar)) == null) {
            ptb<atb, atb> ptbVar = i;
            if (ptbVar != null) {
                return ptbVar.call(atbVar);
            }
            return atbVar;
        }
        return (atb) invokeL.objValue;
    }

    public static atb l(atb atbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, atbVar)) == null) {
            ptb<atb, atb> ptbVar = j;
            if (ptbVar != null) {
                return ptbVar.call(atbVar);
            }
            return atbVar;
        }
        return (atb) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            ptb<Throwable, Throwable> ptbVar = o;
            if (ptbVar != null) {
                return ptbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> xsb.b<R, T> n(xsb.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            ptb<xsb.b, xsb.b> ptbVar = r;
            if (ptbVar != null) {
                return ptbVar.call(bVar);
            }
            return bVar;
        }
        return (xsb.b) invokeL.objValue;
    }

    public static etb o(etb etbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, etbVar)) == null) {
            ptb<etb, etb> ptbVar = l;
            if (ptbVar != null) {
                return ptbVar.call(etbVar);
            }
            return etbVar;
        }
        return (etb) invokeL.objValue;
    }

    public static ktb q(ktb ktbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, ktbVar)) == null) {
            ptb<ktb, ktb> ptbVar = k;
            if (ptbVar != null) {
                return ptbVar.call(ktbVar);
            }
            return ktbVar;
        }
        return (ktb) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            ptb<Throwable, Throwable> ptbVar = p;
            if (ptbVar != null) {
                return ptbVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static etb s(etb etbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, etbVar)) == null) {
            ptb<etb, etb> ptbVar = m;
            if (ptbVar != null) {
                return ptbVar.call(etbVar);
            }
            return etbVar;
        }
        return (etb) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> vsb.f e(vsb vsbVar, vsb.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, vsbVar, fVar)) == null) {
            qtb<vsb, vsb.f, vsb.f> qtbVar = g;
            if (qtbVar != null) {
                return qtbVar.call(vsbVar, fVar);
            }
            return fVar;
        }
        return (vsb.f) invokeLL.objValue;
    }

    public static <T> xsb.a<T> p(xsb<T> xsbVar, xsb.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, xsbVar, aVar)) == null) {
            qtb<xsb, xsb.a, xsb.a> qtbVar = e;
            if (qtbVar != null) {
                return qtbVar.call(xsbVar, aVar);
            }
            return aVar;
        }
        return (xsb.a) invokeLL.objValue;
    }

    public static <T> btb.c<T> t(btb<T> btbVar, btb.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, btbVar, cVar)) == null) {
            qtb<btb, btb.c, btb.c> qtbVar = f;
            if (qtbVar != null) {
                return qtbVar.call(btbVar, cVar);
            }
            return cVar;
        }
        return (btb.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            ltb<Throwable> ltbVar = a;
            if (ltbVar != null) {
                try {
                    ltbVar.call(th);
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
