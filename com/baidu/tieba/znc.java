package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hjc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.njc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes9.dex */
public final class znc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xjc<Throwable> a;
    public static volatile ckc<jjc.a, jjc.a> b;
    public static volatile ckc<njc.c, njc.c> c;
    public static volatile ckc<hjc.f, hjc.f> d;
    public static volatile dkc<jjc, jjc.a, jjc.a> e;
    public static volatile dkc<njc, njc.c, njc.c> f;
    public static volatile dkc<hjc, hjc.f, hjc.f> g;
    public static volatile ckc<mjc, mjc> h;
    public static volatile ckc<mjc, mjc> i;
    public static volatile ckc<mjc, mjc> j;
    public static volatile ckc<wjc, wjc> k;
    public static volatile ckc<qjc, qjc> l;
    public static volatile ckc<qjc, qjc> m;
    public static volatile bkc<? extends ScheduledExecutorService> n;
    public static volatile ckc<Throwable, Throwable> o;
    public static volatile ckc<Throwable, Throwable> p;
    public static volatile ckc<Throwable, Throwable> q;
    public static volatile ckc<jjc.b, jjc.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements ckc<Throwable, Throwable> {
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

        public Throwable a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
                coc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements ckc<Throwable, Throwable> {
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

        public Throwable a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
                coc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements ckc<jjc.a, jjc.a> {
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

        public jjc.a a(jjc.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                coc.c().d().a(aVar);
                return aVar;
            }
            return (jjc.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ jjc.a call(jjc.a aVar) {
            jjc.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements ckc<njc.c, njc.c> {
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

        public njc.c a(njc.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                coc.c().g().a(cVar);
                return cVar;
            }
            return (njc.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ njc.c call(njc.c cVar) {
            njc.c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements ckc<hjc.f, hjc.f> {
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

        public hjc.f a(hjc.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                coc.c().a().a(fVar);
                return fVar;
            }
            return (hjc.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ hjc.f call(hjc.f fVar) {
            hjc.f fVar2 = fVar;
            a(fVar2);
            return fVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements xjc<Throwable> {
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
        @Override // com.baidu.tieba.xjc
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                coc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g implements dkc<jjc, jjc.a, jjc.a> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.dkc
        public /* bridge */ /* synthetic */ jjc.a a(jjc jjcVar, jjc.a aVar) {
            jjc.a aVar2 = aVar;
            b(jjcVar, aVar2);
            return aVar2;
        }

        public jjc.a b(jjc jjcVar, jjc.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jjcVar, aVar)) == null) {
                coc.c().d().e(jjcVar, aVar);
                return aVar;
            }
            return (jjc.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class h implements ckc<qjc, qjc> {
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

        public qjc a(qjc qjcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qjcVar)) == null) {
                coc.c().d().d(qjcVar);
                return qjcVar;
            }
            return (qjc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ qjc call(qjc qjcVar) {
            qjc qjcVar2 = qjcVar;
            a(qjcVar2);
            return qjcVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class i implements dkc<njc, njc.c, njc.c> {
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
        @Override // com.baidu.tieba.dkc
        /* renamed from: b */
        public njc.c a(njc njcVar, njc.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, njcVar, cVar)) == null) {
                eoc g = coc.c().g();
                if (g == foc.e()) {
                    return cVar;
                }
                klc klcVar = new klc(cVar);
                g.d(njcVar, klcVar);
                return new hlc(klcVar);
            }
            return (njc.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class j implements ckc<qjc, qjc> {
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

        public qjc a(qjc qjcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qjcVar)) == null) {
                coc.c().g().c(qjcVar);
                return qjcVar;
            }
            return (qjc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ qjc call(qjc qjcVar) {
            qjc qjcVar2 = qjcVar;
            a(qjcVar2);
            return qjcVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class k implements dkc<hjc, hjc.f, hjc.f> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.dkc
        public /* bridge */ /* synthetic */ hjc.f a(hjc hjcVar, hjc.f fVar) {
            hjc.f fVar2 = fVar;
            b(hjcVar, fVar2);
            return fVar2;
        }

        public hjc.f b(hjc hjcVar, hjc.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hjcVar, fVar)) == null) {
                coc.c().a().c(hjcVar, fVar);
                return fVar;
            }
            return (hjc.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class l implements ckc<wjc, wjc> {
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

        public wjc a(wjc wjcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wjcVar)) == null) {
                coc.c().f().k(wjcVar);
                return wjcVar;
            }
            return (wjc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ wjc call(wjc wjcVar) {
            wjc wjcVar2 = wjcVar;
            a(wjcVar2);
            return wjcVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class m implements ckc<Throwable, Throwable> {
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

        public Throwable a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
                coc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes9.dex */
    public static class n implements ckc<jjc.b, jjc.b> {
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

        public jjc.b a(jjc.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                coc.c().d().b(bVar);
                return bVar;
            }
            return (jjc.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ jjc.b call(jjc.b bVar) {
            jjc.b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948367162, "Lcom/baidu/tieba/znc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948367162, "Lcom/baidu/tieba/znc;");
                return;
            }
        }
        b();
    }

    public static bkc<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (bkc) invokeV.objValue;
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
            ckc<Throwable, Throwable> ckcVar = q;
            if (ckcVar != null) {
                return ckcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static mjc f(mjc mjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, mjcVar)) == null) {
            ckc<mjc, mjc> ckcVar = h;
            if (ckcVar != null) {
                return ckcVar.call(mjcVar);
            }
            return mjcVar;
        }
        return (mjc) invokeL.objValue;
    }

    public static hjc.f g(hjc.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            ckc<hjc.f, hjc.f> ckcVar = d;
            if (ckcVar != null) {
                return ckcVar.call(fVar);
            }
            return fVar;
        }
        return (hjc.f) invokeL.objValue;
    }

    public static <T> jjc.a<T> h(jjc.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            ckc<jjc.a, jjc.a> ckcVar = b;
            if (ckcVar != null) {
                return ckcVar.call(aVar);
            }
            return aVar;
        }
        return (jjc.a) invokeL.objValue;
    }

    public static <T> njc.c<T> i(njc.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            ckc<njc.c, njc.c> ckcVar = c;
            if (ckcVar != null) {
                return ckcVar.call(cVar);
            }
            return cVar;
        }
        return (njc.c) invokeL.objValue;
    }

    public static mjc k(mjc mjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, mjcVar)) == null) {
            ckc<mjc, mjc> ckcVar = i;
            if (ckcVar != null) {
                return ckcVar.call(mjcVar);
            }
            return mjcVar;
        }
        return (mjc) invokeL.objValue;
    }

    public static mjc l(mjc mjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, mjcVar)) == null) {
            ckc<mjc, mjc> ckcVar = j;
            if (ckcVar != null) {
                return ckcVar.call(mjcVar);
            }
            return mjcVar;
        }
        return (mjc) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            ckc<Throwable, Throwable> ckcVar = o;
            if (ckcVar != null) {
                return ckcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> jjc.b<R, T> n(jjc.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            ckc<jjc.b, jjc.b> ckcVar = r;
            if (ckcVar != null) {
                return ckcVar.call(bVar);
            }
            return bVar;
        }
        return (jjc.b) invokeL.objValue;
    }

    public static qjc o(qjc qjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, qjcVar)) == null) {
            ckc<qjc, qjc> ckcVar = l;
            if (ckcVar != null) {
                return ckcVar.call(qjcVar);
            }
            return qjcVar;
        }
        return (qjc) invokeL.objValue;
    }

    public static wjc q(wjc wjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, wjcVar)) == null) {
            ckc<wjc, wjc> ckcVar = k;
            if (ckcVar != null) {
                return ckcVar.call(wjcVar);
            }
            return wjcVar;
        }
        return (wjc) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            ckc<Throwable, Throwable> ckcVar = p;
            if (ckcVar != null) {
                return ckcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static qjc s(qjc qjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, qjcVar)) == null) {
            ckc<qjc, qjc> ckcVar = m;
            if (ckcVar != null) {
                return ckcVar.call(qjcVar);
            }
            return qjcVar;
        }
        return (qjc) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> hjc.f e(hjc hjcVar, hjc.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, hjcVar, fVar)) == null) {
            dkc<hjc, hjc.f, hjc.f> dkcVar = g;
            if (dkcVar != null) {
                return dkcVar.a(hjcVar, fVar);
            }
            return fVar;
        }
        return (hjc.f) invokeLL.objValue;
    }

    public static <T> jjc.a<T> p(jjc<T> jjcVar, jjc.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, jjcVar, aVar)) == null) {
            dkc<jjc, jjc.a, jjc.a> dkcVar = e;
            if (dkcVar != null) {
                return dkcVar.a(jjcVar, aVar);
            }
            return aVar;
        }
        return (jjc.a) invokeLL.objValue;
    }

    public static <T> njc.c<T> t(njc<T> njcVar, njc.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, njcVar, cVar)) == null) {
            dkc<njc, njc.c, njc.c> dkcVar = f;
            if (dkcVar != null) {
                return dkcVar.a(njcVar, cVar);
            }
            return cVar;
        }
        return (njc.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            xjc<Throwable> xjcVar = a;
            if (xjcVar != null) {
                try {
                    xjcVar.call(th);
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
