package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f6c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.l6c;
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
public final class xac {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v6c<Throwable> a;
    public static volatile a7c<h6c.a, h6c.a> b;
    public static volatile a7c<l6c.c, l6c.c> c;
    public static volatile a7c<f6c.f, f6c.f> d;
    public static volatile b7c<h6c, h6c.a, h6c.a> e;
    public static volatile b7c<l6c, l6c.c, l6c.c> f;
    public static volatile b7c<f6c, f6c.f, f6c.f> g;
    public static volatile a7c<k6c, k6c> h;
    public static volatile a7c<k6c, k6c> i;
    public static volatile a7c<k6c, k6c> j;
    public static volatile a7c<u6c, u6c> k;
    public static volatile a7c<o6c, o6c> l;
    public static volatile a7c<o6c, o6c> m;
    public static volatile z6c<? extends ScheduledExecutorService> n;
    public static volatile a7c<Throwable, Throwable> o;
    public static volatile a7c<Throwable, Throwable> p;
    public static volatile a7c<Throwable, Throwable> q;
    public static volatile a7c<h6c.b, h6c.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements a7c<Throwable, Throwable> {
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
                abc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements a7c<Throwable, Throwable> {
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
                abc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a7c<h6c.a, h6c.a> {
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

        public h6c.a a(h6c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                abc.c().d().a(aVar);
                return aVar;
            }
            return (h6c.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ h6c.a call(h6c.a aVar) {
            h6c.a aVar2 = aVar;
            a(aVar2);
            return aVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a7c<l6c.c, l6c.c> {
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

        public l6c.c a(l6c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                abc.c().g().a(cVar);
                return cVar;
            }
            return (l6c.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ l6c.c call(l6c.c cVar) {
            l6c.c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements a7c<f6c.f, f6c.f> {
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

        public f6c.f a(f6c.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                abc.c().a().a(fVar);
                return fVar;
            }
            return (f6c.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ f6c.f call(f6c.f fVar) {
            f6c.f fVar2 = fVar;
            a(fVar2);
            return fVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements v6c<Throwable> {
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
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                abc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements b7c<h6c, h6c.a, h6c.a> {
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
        @Override // com.baidu.tieba.b7c
        public /* bridge */ /* synthetic */ h6c.a a(h6c h6cVar, h6c.a aVar) {
            h6c.a aVar2 = aVar;
            b(h6cVar, aVar2);
            return aVar2;
        }

        public h6c.a b(h6c h6cVar, h6c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h6cVar, aVar)) == null) {
                abc.c().d().e(h6cVar, aVar);
                return aVar;
            }
            return (h6c.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements a7c<o6c, o6c> {
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

        public o6c a(o6c o6cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o6cVar)) == null) {
                abc.c().d().d(o6cVar);
                return o6cVar;
            }
            return (o6c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ o6c call(o6c o6cVar) {
            o6c o6cVar2 = o6cVar;
            a(o6cVar2);
            return o6cVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements b7c<l6c, l6c.c, l6c.c> {
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
        @Override // com.baidu.tieba.b7c
        /* renamed from: b */
        public l6c.c a(l6c l6cVar, l6c.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l6cVar, cVar)) == null) {
                cbc g = abc.c().g();
                if (g == dbc.e()) {
                    return cVar;
                }
                i8c i8cVar = new i8c(cVar);
                g.d(l6cVar, i8cVar);
                return new f8c(i8cVar);
            }
            return (l6c.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j implements a7c<o6c, o6c> {
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

        public o6c a(o6c o6cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o6cVar)) == null) {
                abc.c().g().c(o6cVar);
                return o6cVar;
            }
            return (o6c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ o6c call(o6c o6cVar) {
            o6c o6cVar2 = o6cVar;
            a(o6cVar2);
            return o6cVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class k implements b7c<f6c, f6c.f, f6c.f> {
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
        @Override // com.baidu.tieba.b7c
        public /* bridge */ /* synthetic */ f6c.f a(f6c f6cVar, f6c.f fVar) {
            f6c.f fVar2 = fVar;
            b(f6cVar, fVar2);
            return fVar2;
        }

        public f6c.f b(f6c f6cVar, f6c.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f6cVar, fVar)) == null) {
                abc.c().a().c(f6cVar, fVar);
                return fVar;
            }
            return (f6c.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class l implements a7c<u6c, u6c> {
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

        public u6c a(u6c u6cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u6cVar)) == null) {
                abc.c().f().k(u6cVar);
                return u6cVar;
            }
            return (u6c) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ u6c call(u6c u6cVar) {
            u6c u6cVar2 = u6cVar;
            a(u6cVar2);
            return u6cVar2;
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements a7c<Throwable, Throwable> {
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
                abc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ Throwable call(Throwable th) {
            Throwable th2 = th;
            a(th2);
            return th2;
        }
    }

    /* loaded from: classes8.dex */
    public static class n implements a7c<h6c.b, h6c.b> {
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

        public h6c.b a(h6c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                abc.c().d().b(bVar);
                return bVar;
            }
            return (h6c.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.a7c
        public /* bridge */ /* synthetic */ h6c.b call(h6c.b bVar) {
            h6c.b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295087, "Lcom/baidu/tieba/xac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295087, "Lcom/baidu/tieba/xac;");
                return;
            }
        }
        b();
    }

    public static z6c<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (z6c) invokeV.objValue;
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
            a7c<Throwable, Throwable> a7cVar = q;
            if (a7cVar != null) {
                return a7cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static k6c f(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, k6cVar)) == null) {
            a7c<k6c, k6c> a7cVar = h;
            if (a7cVar != null) {
                return a7cVar.call(k6cVar);
            }
            return k6cVar;
        }
        return (k6c) invokeL.objValue;
    }

    public static f6c.f g(f6c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            a7c<f6c.f, f6c.f> a7cVar = d;
            if (a7cVar != null) {
                return a7cVar.call(fVar);
            }
            return fVar;
        }
        return (f6c.f) invokeL.objValue;
    }

    public static <T> h6c.a<T> h(h6c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            a7c<h6c.a, h6c.a> a7cVar = b;
            if (a7cVar != null) {
                return a7cVar.call(aVar);
            }
            return aVar;
        }
        return (h6c.a) invokeL.objValue;
    }

    public static <T> l6c.c<T> i(l6c.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            a7c<l6c.c, l6c.c> a7cVar = c;
            if (a7cVar != null) {
                return a7cVar.call(cVar);
            }
            return cVar;
        }
        return (l6c.c) invokeL.objValue;
    }

    public static k6c k(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, k6cVar)) == null) {
            a7c<k6c, k6c> a7cVar = i;
            if (a7cVar != null) {
                return a7cVar.call(k6cVar);
            }
            return k6cVar;
        }
        return (k6c) invokeL.objValue;
    }

    public static k6c l(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, k6cVar)) == null) {
            a7c<k6c, k6c> a7cVar = j;
            if (a7cVar != null) {
                return a7cVar.call(k6cVar);
            }
            return k6cVar;
        }
        return (k6c) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            a7c<Throwable, Throwable> a7cVar = o;
            if (a7cVar != null) {
                return a7cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> h6c.b<R, T> n(h6c.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            a7c<h6c.b, h6c.b> a7cVar = r;
            if (a7cVar != null) {
                return a7cVar.call(bVar);
            }
            return bVar;
        }
        return (h6c.b) invokeL.objValue;
    }

    public static o6c o(o6c o6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, o6cVar)) == null) {
            a7c<o6c, o6c> a7cVar = l;
            if (a7cVar != null) {
                return a7cVar.call(o6cVar);
            }
            return o6cVar;
        }
        return (o6c) invokeL.objValue;
    }

    public static u6c q(u6c u6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, u6cVar)) == null) {
            a7c<u6c, u6c> a7cVar = k;
            if (a7cVar != null) {
                return a7cVar.call(u6cVar);
            }
            return u6cVar;
        }
        return (u6c) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            a7c<Throwable, Throwable> a7cVar = p;
            if (a7cVar != null) {
                return a7cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static o6c s(o6c o6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, o6cVar)) == null) {
            a7c<o6c, o6c> a7cVar = m;
            if (a7cVar != null) {
                return a7cVar.call(o6cVar);
            }
            return o6cVar;
        }
        return (o6c) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> f6c.f e(f6c f6cVar, f6c.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, f6cVar, fVar)) == null) {
            b7c<f6c, f6c.f, f6c.f> b7cVar = g;
            if (b7cVar != null) {
                return b7cVar.a(f6cVar, fVar);
            }
            return fVar;
        }
        return (f6c.f) invokeLL.objValue;
    }

    public static <T> h6c.a<T> p(h6c<T> h6cVar, h6c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, h6cVar, aVar)) == null) {
            b7c<h6c, h6c.a, h6c.a> b7cVar = e;
            if (b7cVar != null) {
                return b7cVar.a(h6cVar, aVar);
            }
            return aVar;
        }
        return (h6c.a) invokeLL.objValue;
    }

    public static <T> l6c.c<T> t(l6c<T> l6cVar, l6c.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, l6cVar, cVar)) == null) {
            b7c<l6c, l6c.c, l6c.c> b7cVar = f;
            if (b7cVar != null) {
                return b7cVar.a(l6cVar, cVar);
            }
            return cVar;
        }
        return (l6c.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            v6c<Throwable> v6cVar = a;
            if (v6cVar != null) {
                try {
                    v6cVar.call(th);
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
