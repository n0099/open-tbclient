package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i8a;
import com.baidu.tieba.k8a;
import com.baidu.tieba.o8a;
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
public final class rca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y8a<Throwable> a;
    public static volatile c9a<k8a.a, k8a.a> b;
    public static volatile c9a<o8a.c, o8a.c> c;
    public static volatile c9a<i8a.f, i8a.f> d;
    public static volatile d9a<k8a, k8a.a, k8a.a> e;
    public static volatile d9a<o8a, o8a.c, o8a.c> f;
    public static volatile d9a<i8a, i8a.f, i8a.f> g;
    public static volatile c9a<n8a, n8a> h;
    public static volatile c9a<n8a, n8a> i;
    public static volatile c9a<n8a, n8a> j;
    public static volatile c9a<x8a, x8a> k;
    public static volatile c9a<r8a, r8a> l;
    public static volatile c9a<r8a, r8a> m;
    public static volatile b9a<? extends ScheduledExecutorService> n;
    public static volatile c9a<Throwable, Throwable> o;
    public static volatile c9a<Throwable, Throwable> p;
    public static volatile c9a<Throwable, Throwable> q;
    public static volatile c9a<k8a.b, k8a.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements c9a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.c9a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                uca.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements c9a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.c9a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                uca.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements c9a<k8a.a, k8a.a> {
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
        @Override // com.baidu.tieba.c9a
        public k8a.a call(k8a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                uca.c().d().a(aVar);
                return aVar;
            }
            return (k8a.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements c9a<o8a.c, o8a.c> {
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
        @Override // com.baidu.tieba.c9a
        public o8a.c call(o8a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                uca.c().g().a(cVar);
                return cVar;
            }
            return (o8a.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements c9a<i8a.f, i8a.f> {
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
        @Override // com.baidu.tieba.c9a
        public i8a.f call(i8a.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                uca.c().a().a(fVar);
                return fVar;
            }
            return (i8a.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements y8a<Throwable> {
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
        @Override // com.baidu.tieba.y8a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                uca.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements d9a<k8a, k8a.a, k8a.a> {
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
        @Override // com.baidu.tieba.d9a
        public k8a.a call(k8a k8aVar, k8a.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k8aVar, aVar)) == null) {
                uca.c().d().e(k8aVar, aVar);
                return aVar;
            }
            return (k8a.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements c9a<r8a, r8a> {
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
        @Override // com.baidu.tieba.c9a
        public r8a call(r8a r8aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r8aVar)) == null) {
                uca.c().d().d(r8aVar);
                return r8aVar;
            }
            return (r8a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements d9a<o8a, o8a.c, o8a.c> {
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
        @Override // com.baidu.tieba.d9a
        public o8a.c call(o8a o8aVar, o8a.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o8aVar, cVar)) == null) {
                wca g = uca.c().g();
                if (g == xca.e()) {
                    return cVar;
                }
                caa caaVar = new caa(cVar);
                g.d(o8aVar, caaVar);
                return new z9a(caaVar);
            }
            return (o8a.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements c9a<r8a, r8a> {
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
        @Override // com.baidu.tieba.c9a
        public r8a call(r8a r8aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r8aVar)) == null) {
                uca.c().g().c(r8aVar);
                return r8aVar;
            }
            return (r8a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements d9a<i8a, i8a.f, i8a.f> {
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
        @Override // com.baidu.tieba.d9a
        public i8a.f call(i8a i8aVar, i8a.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, i8aVar, fVar)) == null) {
                uca.c().a().c(i8aVar, fVar);
                return fVar;
            }
            return (i8a.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements c9a<x8a, x8a> {
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
        @Override // com.baidu.tieba.c9a
        public x8a call(x8a x8aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x8aVar)) == null) {
                uca.c().f().k(x8aVar);
                return x8aVar;
            }
            return (x8a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements c9a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.c9a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                uca.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements c9a<k8a.b, k8a.b> {
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
        @Override // com.baidu.tieba.c9a
        public k8a.b call(k8a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                uca.c().d().b(bVar);
                return bVar;
            }
            return (k8a.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118201, "Lcom/baidu/tieba/rca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118201, "Lcom/baidu/tieba/rca;");
                return;
            }
        }
        b();
    }

    public static b9a<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (b9a) invokeV.objValue;
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
            c9a<Throwable, Throwable> c9aVar = q;
            if (c9aVar != null) {
                return c9aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static n8a f(n8a n8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, n8aVar)) == null) {
            c9a<n8a, n8a> c9aVar = h;
            if (c9aVar != null) {
                return c9aVar.call(n8aVar);
            }
            return n8aVar;
        }
        return (n8a) invokeL.objValue;
    }

    public static i8a.f g(i8a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            c9a<i8a.f, i8a.f> c9aVar = d;
            if (c9aVar != null) {
                return c9aVar.call(fVar);
            }
            return fVar;
        }
        return (i8a.f) invokeL.objValue;
    }

    public static <T> k8a.a<T> h(k8a.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            c9a<k8a.a, k8a.a> c9aVar = b;
            if (c9aVar != null) {
                return c9aVar.call(aVar);
            }
            return aVar;
        }
        return (k8a.a) invokeL.objValue;
    }

    public static <T> o8a.c<T> i(o8a.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            c9a<o8a.c, o8a.c> c9aVar = c;
            if (c9aVar != null) {
                return c9aVar.call(cVar);
            }
            return cVar;
        }
        return (o8a.c) invokeL.objValue;
    }

    public static n8a k(n8a n8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, n8aVar)) == null) {
            c9a<n8a, n8a> c9aVar = i;
            if (c9aVar != null) {
                return c9aVar.call(n8aVar);
            }
            return n8aVar;
        }
        return (n8a) invokeL.objValue;
    }

    public static n8a l(n8a n8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, n8aVar)) == null) {
            c9a<n8a, n8a> c9aVar = j;
            if (c9aVar != null) {
                return c9aVar.call(n8aVar);
            }
            return n8aVar;
        }
        return (n8a) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            c9a<Throwable, Throwable> c9aVar = o;
            if (c9aVar != null) {
                return c9aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> k8a.b<R, T> n(k8a.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            c9a<k8a.b, k8a.b> c9aVar = r;
            if (c9aVar != null) {
                return c9aVar.call(bVar);
            }
            return bVar;
        }
        return (k8a.b) invokeL.objValue;
    }

    public static r8a o(r8a r8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, r8aVar)) == null) {
            c9a<r8a, r8a> c9aVar = l;
            if (c9aVar != null) {
                return c9aVar.call(r8aVar);
            }
            return r8aVar;
        }
        return (r8a) invokeL.objValue;
    }

    public static x8a q(x8a x8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, x8aVar)) == null) {
            c9a<x8a, x8a> c9aVar = k;
            if (c9aVar != null) {
                return c9aVar.call(x8aVar);
            }
            return x8aVar;
        }
        return (x8a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            c9a<Throwable, Throwable> c9aVar = p;
            if (c9aVar != null) {
                return c9aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static r8a s(r8a r8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, r8aVar)) == null) {
            c9a<r8a, r8a> c9aVar = m;
            if (c9aVar != null) {
                return c9aVar.call(r8aVar);
            }
            return r8aVar;
        }
        return (r8a) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> i8a.f e(i8a i8aVar, i8a.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, i8aVar, fVar)) == null) {
            d9a<i8a, i8a.f, i8a.f> d9aVar = g;
            if (d9aVar != null) {
                return d9aVar.call(i8aVar, fVar);
            }
            return fVar;
        }
        return (i8a.f) invokeLL.objValue;
    }

    public static <T> k8a.a<T> p(k8a<T> k8aVar, k8a.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, k8aVar, aVar)) == null) {
            d9a<k8a, k8a.a, k8a.a> d9aVar = e;
            if (d9aVar != null) {
                return d9aVar.call(k8aVar, aVar);
            }
            return aVar;
        }
        return (k8a.a) invokeLL.objValue;
    }

    public static <T> o8a.c<T> t(o8a<T> o8aVar, o8a.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, o8aVar, cVar)) == null) {
            d9a<o8a, o8a.c, o8a.c> d9aVar = f;
            if (d9aVar != null) {
                return d9aVar.call(o8aVar, cVar);
            }
            return cVar;
        }
        return (o8a.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            y8a<Throwable> y8aVar = a;
            if (y8aVar != null) {
                try {
                    y8aVar.call(th);
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
