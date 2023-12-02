package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.boc;
import com.baidu.tieba.doc;
import com.baidu.tieba.hoc;
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
public final class tsc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile roc<Throwable> a;
    public static volatile woc<doc.a, doc.a> b;
    public static volatile woc<hoc.c, hoc.c> c;
    public static volatile woc<boc.f, boc.f> d;
    public static volatile xoc<doc, doc.a, doc.a> e;
    public static volatile xoc<hoc, hoc.c, hoc.c> f;
    public static volatile xoc<boc, boc.f, boc.f> g;
    public static volatile woc<goc, goc> h;
    public static volatile woc<goc, goc> i;
    public static volatile woc<goc, goc> j;
    public static volatile woc<qoc, qoc> k;
    public static volatile woc<koc, koc> l;
    public static volatile woc<koc, koc> m;
    public static volatile voc<? extends ScheduledExecutorService> n;
    public static volatile woc<Throwable, Throwable> o;
    public static volatile woc<Throwable, Throwable> p;
    public static volatile woc<Throwable, Throwable> q;
    public static volatile woc<doc.b, doc.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements woc<Throwable, Throwable> {
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
                wsc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements woc<Throwable, Throwable> {
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
                wsc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements woc<doc.a, doc.a> {
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

        public doc.a a(doc.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                wsc.c().d().a(aVar);
                return aVar;
            }
            return (doc.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ doc.a call(doc.a aVar) {
            doc.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements woc<hoc.c, hoc.c> {
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

        public hoc.c a(hoc.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                wsc.c().g().a(cVar);
                return cVar;
            }
            return (hoc.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ hoc.c call(hoc.c cVar) {
            hoc.c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements woc<boc.f, boc.f> {
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

        public boc.f a(boc.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                wsc.c().a().a(fVar);
                return fVar;
            }
            return (boc.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ boc.f call(boc.f fVar) {
            boc.f fVar2 = fVar;
            a(fVar2);
            return fVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements roc<Throwable> {
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
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                wsc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements xoc<doc, doc.a, doc.a> {
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
        @Override // com.baidu.tieba.xoc
        public /* bridge */ /* synthetic */ doc.a a(doc docVar, doc.a aVar) {
            doc.a aVar2 = aVar;
            b(docVar, aVar2);
            return aVar2;
        }

        public doc.a b(doc docVar, doc.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, docVar, aVar)) == null) {
                wsc.c().d().e(docVar, aVar);
                return aVar;
            }
            return (doc.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements woc<koc, koc> {
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

        public koc a(koc kocVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kocVar)) == null) {
                wsc.c().d().d(kocVar);
                return kocVar;
            }
            return (koc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ koc call(koc kocVar) {
            koc kocVar2 = kocVar;
            a(kocVar2);
            return kocVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements xoc<hoc, hoc.c, hoc.c> {
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
        @Override // com.baidu.tieba.xoc
        /* renamed from: b */
        public hoc.c a(hoc hocVar, hoc.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hocVar, cVar)) == null) {
                ysc g = wsc.c().g();
                if (g == zsc.e()) {
                    return cVar;
                }
                eqc eqcVar = new eqc(cVar);
                g.d(hocVar, eqcVar);
                return new bqc(eqcVar);
            }
            return (hoc.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j implements woc<koc, koc> {
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

        public koc a(koc kocVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kocVar)) == null) {
                wsc.c().g().c(kocVar);
                return kocVar;
            }
            return (koc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ koc call(koc kocVar) {
            koc kocVar2 = kocVar;
            a(kocVar2);
            return kocVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class k implements xoc<boc, boc.f, boc.f> {
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
        @Override // com.baidu.tieba.xoc
        public /* bridge */ /* synthetic */ boc.f a(boc bocVar, boc.f fVar) {
            boc.f fVar2 = fVar;
            b(bocVar, fVar2);
            return fVar2;
        }

        public boc.f b(boc bocVar, boc.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bocVar, fVar)) == null) {
                wsc.c().a().c(bocVar, fVar);
                return fVar;
            }
            return (boc.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class l implements woc<qoc, qoc> {
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

        public qoc a(qoc qocVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qocVar)) == null) {
                wsc.c().f().k(qocVar);
                return qocVar;
            }
            return (qoc) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ qoc call(qoc qocVar) {
            qoc qocVar2 = qocVar;
            a(qocVar2);
            return qocVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements woc<Throwable, Throwable> {
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
                wsc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class n implements woc<doc.b, doc.b> {
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

        public doc.b a(doc.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                wsc.c().d().b(bVar);
                return bVar;
            }
            return (doc.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.woc
        public /* bridge */ /* synthetic */ doc.b call(doc.b bVar) {
            doc.b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193221, "Lcom/baidu/tieba/tsc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193221, "Lcom/baidu/tieba/tsc;");
                return;
            }
        }
        b();
    }

    public static voc<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (voc) invokeV.objValue;
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
            woc<Throwable, Throwable> wocVar = q;
            if (wocVar != null) {
                return wocVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static goc f(goc gocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gocVar)) == null) {
            woc<goc, goc> wocVar = h;
            if (wocVar != null) {
                return wocVar.call(gocVar);
            }
            return gocVar;
        }
        return (goc) invokeL.objValue;
    }

    public static boc.f g(boc.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            woc<boc.f, boc.f> wocVar = d;
            if (wocVar != null) {
                return wocVar.call(fVar);
            }
            return fVar;
        }
        return (boc.f) invokeL.objValue;
    }

    public static <T> doc.a<T> h(doc.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            woc<doc.a, doc.a> wocVar = b;
            if (wocVar != null) {
                return wocVar.call(aVar);
            }
            return aVar;
        }
        return (doc.a) invokeL.objValue;
    }

    public static <T> hoc.c<T> i(hoc.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            woc<hoc.c, hoc.c> wocVar = c;
            if (wocVar != null) {
                return wocVar.call(cVar);
            }
            return cVar;
        }
        return (hoc.c) invokeL.objValue;
    }

    public static goc k(goc gocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gocVar)) == null) {
            woc<goc, goc> wocVar = i;
            if (wocVar != null) {
                return wocVar.call(gocVar);
            }
            return gocVar;
        }
        return (goc) invokeL.objValue;
    }

    public static goc l(goc gocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, gocVar)) == null) {
            woc<goc, goc> wocVar = j;
            if (wocVar != null) {
                return wocVar.call(gocVar);
            }
            return gocVar;
        }
        return (goc) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            woc<Throwable, Throwable> wocVar = o;
            if (wocVar != null) {
                return wocVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> doc.b<R, T> n(doc.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            woc<doc.b, doc.b> wocVar = r;
            if (wocVar != null) {
                return wocVar.call(bVar);
            }
            return bVar;
        }
        return (doc.b) invokeL.objValue;
    }

    public static koc o(koc kocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, kocVar)) == null) {
            woc<koc, koc> wocVar = l;
            if (wocVar != null) {
                return wocVar.call(kocVar);
            }
            return kocVar;
        }
        return (koc) invokeL.objValue;
    }

    public static qoc q(qoc qocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, qocVar)) == null) {
            woc<qoc, qoc> wocVar = k;
            if (wocVar != null) {
                return wocVar.call(qocVar);
            }
            return qocVar;
        }
        return (qoc) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            woc<Throwable, Throwable> wocVar = p;
            if (wocVar != null) {
                return wocVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static koc s(koc kocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, kocVar)) == null) {
            woc<koc, koc> wocVar = m;
            if (wocVar != null) {
                return wocVar.call(kocVar);
            }
            return kocVar;
        }
        return (koc) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> boc.f e(boc bocVar, boc.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bocVar, fVar)) == null) {
            xoc<boc, boc.f, boc.f> xocVar = g;
            if (xocVar != null) {
                return xocVar.a(bocVar, fVar);
            }
            return fVar;
        }
        return (boc.f) invokeLL.objValue;
    }

    public static <T> doc.a<T> p(doc<T> docVar, doc.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, docVar, aVar)) == null) {
            xoc<doc, doc.a, doc.a> xocVar = e;
            if (xocVar != null) {
                return xocVar.a(docVar, aVar);
            }
            return aVar;
        }
        return (doc.a) invokeLL.objValue;
    }

    public static <T> hoc.c<T> t(hoc<T> hocVar, hoc.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, hocVar, cVar)) == null) {
            xoc<hoc, hoc.c, hoc.c> xocVar = f;
            if (xocVar != null) {
                return xocVar.a(hocVar, cVar);
            }
            return cVar;
        }
        return (hoc.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            roc<Throwable> rocVar = a;
            if (rocVar != null) {
                try {
                    rocVar.call(th);
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
