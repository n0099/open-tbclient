package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gjc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.mjc;
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
public final class ync {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wjc<Throwable> a;
    public static volatile bkc<ijc.a, ijc.a> b;
    public static volatile bkc<mjc.c, mjc.c> c;
    public static volatile bkc<gjc.f, gjc.f> d;
    public static volatile ckc<ijc, ijc.a, ijc.a> e;
    public static volatile ckc<mjc, mjc.c, mjc.c> f;
    public static volatile ckc<gjc, gjc.f, gjc.f> g;
    public static volatile bkc<ljc, ljc> h;
    public static volatile bkc<ljc, ljc> i;
    public static volatile bkc<ljc, ljc> j;
    public static volatile bkc<vjc, vjc> k;
    public static volatile bkc<pjc, pjc> l;
    public static volatile bkc<pjc, pjc> m;
    public static volatile akc<? extends ScheduledExecutorService> n;
    public static volatile bkc<Throwable, Throwable> o;
    public static volatile bkc<Throwable, Throwable> p;
    public static volatile bkc<Throwable, Throwable> q;
    public static volatile bkc<ijc.b, ijc.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements bkc<Throwable, Throwable> {
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
                boc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements bkc<Throwable, Throwable> {
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
                boc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements bkc<ijc.a, ijc.a> {
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

        public ijc.a a(ijc.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                boc.c().d().a(aVar);
                return aVar;
            }
            return (ijc.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ ijc.a call(ijc.a aVar) {
            ijc.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements bkc<mjc.c, mjc.c> {
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

        public mjc.c a(mjc.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                boc.c().g().a(cVar);
                return cVar;
            }
            return (mjc.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ mjc.c call(mjc.c cVar) {
            mjc.c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements bkc<gjc.f, gjc.f> {
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

        public gjc.f a(gjc.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                boc.c().a().a(fVar);
                return fVar;
            }
            return (gjc.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ gjc.f call(gjc.f fVar) {
            gjc.f fVar2 = fVar;
            a(fVar2);
            return fVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements wjc<Throwable> {
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
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                boc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g implements ckc<ijc, ijc.a, ijc.a> {
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
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ ijc.a a(ijc ijcVar, ijc.a aVar) {
            ijc.a aVar2 = aVar;
            b(ijcVar, aVar2);
            return aVar2;
        }

        public ijc.a b(ijc ijcVar, ijc.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ijcVar, aVar)) == null) {
                boc.c().d().e(ijcVar, aVar);
                return aVar;
            }
            return (ijc.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class h implements bkc<pjc, pjc> {
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

        public pjc a(pjc pjcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pjcVar)) == null) {
                boc.c().d().d(pjcVar);
                return pjcVar;
            }
            return (pjc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ pjc call(pjc pjcVar) {
            pjc pjcVar2 = pjcVar;
            a(pjcVar2);
            return pjcVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class i implements ckc<mjc, mjc.c, mjc.c> {
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
        @Override // com.baidu.tieba.ckc
        /* renamed from: b */
        public mjc.c a(mjc mjcVar, mjc.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mjcVar, cVar)) == null) {
                doc g = boc.c().g();
                if (g == eoc.e()) {
                    return cVar;
                }
                jlc jlcVar = new jlc(cVar);
                g.d(mjcVar, jlcVar);
                return new glc(jlcVar);
            }
            return (mjc.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class j implements bkc<pjc, pjc> {
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

        public pjc a(pjc pjcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pjcVar)) == null) {
                boc.c().g().c(pjcVar);
                return pjcVar;
            }
            return (pjc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ pjc call(pjc pjcVar) {
            pjc pjcVar2 = pjcVar;
            a(pjcVar2);
            return pjcVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class k implements ckc<gjc, gjc.f, gjc.f> {
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
        @Override // com.baidu.tieba.ckc
        public /* bridge */ /* synthetic */ gjc.f a(gjc gjcVar, gjc.f fVar) {
            gjc.f fVar2 = fVar;
            b(gjcVar, fVar2);
            return fVar2;
        }

        public gjc.f b(gjc gjcVar, gjc.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gjcVar, fVar)) == null) {
                boc.c().a().c(gjcVar, fVar);
                return fVar;
            }
            return (gjc.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class l implements bkc<vjc, vjc> {
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

        public vjc a(vjc vjcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vjcVar)) == null) {
                boc.c().f().k(vjcVar);
                return vjcVar;
            }
            return (vjc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ vjc call(vjc vjcVar) {
            vjc vjcVar2 = vjcVar;
            a(vjcVar2);
            return vjcVar2;
        }
    }

    /* loaded from: classes9.dex */
    public static class m implements bkc<Throwable, Throwable> {
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
                boc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes9.dex */
    public static class n implements bkc<ijc.b, ijc.b> {
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

        public ijc.b a(ijc.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                boc.c().d().b(bVar);
                return bVar;
            }
            return (ijc.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bkc
        public /* bridge */ /* synthetic */ ijc.b call(ijc.b bVar) {
            ijc.b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948337371, "Lcom/baidu/tieba/ync;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948337371, "Lcom/baidu/tieba/ync;");
                return;
            }
        }
        b();
    }

    public static akc<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (akc) invokeV.objValue;
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
            bkc<Throwable, Throwable> bkcVar = q;
            if (bkcVar != null) {
                return bkcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static ljc f(ljc ljcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ljcVar)) == null) {
            bkc<ljc, ljc> bkcVar = h;
            if (bkcVar != null) {
                return bkcVar.call(ljcVar);
            }
            return ljcVar;
        }
        return (ljc) invokeL.objValue;
    }

    public static gjc.f g(gjc.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            bkc<gjc.f, gjc.f> bkcVar = d;
            if (bkcVar != null) {
                return bkcVar.call(fVar);
            }
            return fVar;
        }
        return (gjc.f) invokeL.objValue;
    }

    public static <T> ijc.a<T> h(ijc.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            bkc<ijc.a, ijc.a> bkcVar = b;
            if (bkcVar != null) {
                return bkcVar.call(aVar);
            }
            return aVar;
        }
        return (ijc.a) invokeL.objValue;
    }

    public static <T> mjc.c<T> i(mjc.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            bkc<mjc.c, mjc.c> bkcVar = c;
            if (bkcVar != null) {
                return bkcVar.call(cVar);
            }
            return cVar;
        }
        return (mjc.c) invokeL.objValue;
    }

    public static ljc k(ljc ljcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ljcVar)) == null) {
            bkc<ljc, ljc> bkcVar = i;
            if (bkcVar != null) {
                return bkcVar.call(ljcVar);
            }
            return ljcVar;
        }
        return (ljc) invokeL.objValue;
    }

    public static ljc l(ljc ljcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, ljcVar)) == null) {
            bkc<ljc, ljc> bkcVar = j;
            if (bkcVar != null) {
                return bkcVar.call(ljcVar);
            }
            return ljcVar;
        }
        return (ljc) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            bkc<Throwable, Throwable> bkcVar = o;
            if (bkcVar != null) {
                return bkcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> ijc.b<R, T> n(ijc.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            bkc<ijc.b, ijc.b> bkcVar = r;
            if (bkcVar != null) {
                return bkcVar.call(bVar);
            }
            return bVar;
        }
        return (ijc.b) invokeL.objValue;
    }

    public static pjc o(pjc pjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, pjcVar)) == null) {
            bkc<pjc, pjc> bkcVar = l;
            if (bkcVar != null) {
                return bkcVar.call(pjcVar);
            }
            return pjcVar;
        }
        return (pjc) invokeL.objValue;
    }

    public static vjc q(vjc vjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, vjcVar)) == null) {
            bkc<vjc, vjc> bkcVar = k;
            if (bkcVar != null) {
                return bkcVar.call(vjcVar);
            }
            return vjcVar;
        }
        return (vjc) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            bkc<Throwable, Throwable> bkcVar = p;
            if (bkcVar != null) {
                return bkcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static pjc s(pjc pjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, pjcVar)) == null) {
            bkc<pjc, pjc> bkcVar = m;
            if (bkcVar != null) {
                return bkcVar.call(pjcVar);
            }
            return pjcVar;
        }
        return (pjc) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> gjc.f e(gjc gjcVar, gjc.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, gjcVar, fVar)) == null) {
            ckc<gjc, gjc.f, gjc.f> ckcVar = g;
            if (ckcVar != null) {
                return ckcVar.a(gjcVar, fVar);
            }
            return fVar;
        }
        return (gjc.f) invokeLL.objValue;
    }

    public static <T> ijc.a<T> p(ijc<T> ijcVar, ijc.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, ijcVar, aVar)) == null) {
            ckc<ijc, ijc.a, ijc.a> ckcVar = e;
            if (ckcVar != null) {
                return ckcVar.a(ijcVar, aVar);
            }
            return aVar;
        }
        return (ijc.a) invokeLL.objValue;
    }

    public static <T> mjc.c<T> t(mjc<T> mjcVar, mjc.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, mjcVar, cVar)) == null) {
            ckc<mjc, mjc.c, mjc.c> ckcVar = f;
            if (ckcVar != null) {
                return ckcVar.a(mjcVar, cVar);
            }
            return cVar;
        }
        return (mjc.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            wjc<Throwable> wjcVar = a;
            if (wjcVar != null) {
                try {
                    wjcVar.call(th);
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
