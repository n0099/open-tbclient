package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class k0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q0<g0> a;
    public o7<j0, s6<g0>> b;
    public o7<j0, q0<g0>> c;
    public y7<c> d;
    public o7<j0, v6> e;
    public b f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends r7<v6> {
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
        @Override // com.baidu.tieba.r7
        /* renamed from: g */
        public v6 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new v6();
            }
            return (v6) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public h0 a;
        public int b;

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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public k0(q0<g0> q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new o7<>();
        this.c = new o7<>();
        this.d = new y7<>(true, 16);
        this.e = new o7<>();
        this.f = new b(null);
        this.g = false;
        this.a = q0Var;
    }

    public final q0<g0> d(j0 j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, j0Var)) == null) {
            q0<g0> c2 = this.c.c(j0Var);
            if (c2 == null) {
                s6<g0> s6Var = new s6<>(false, 16);
                q0<g0> q0Var = new q0<>(s6Var);
                this.b.i(j0Var, s6Var);
                this.c.i(j0Var, q0Var);
                this.e.i(j0Var, new v6());
                Iterator<g0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return q0Var;
            }
            return c2;
        }
        return (q0) invokeL.objValue;
    }

    public void e(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h0Var) == null) {
            int i = 0;
            while (true) {
                y7<c> y7Var = this.d;
                if (i < y7Var.b) {
                    if (y7Var.get(i).a == h0Var) {
                        o7.e<v6> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            v6 next = n.next();
                            int h = next.h();
                            int i2 = i;
                            while (i2 < h) {
                                int i3 = i2 + 1;
                                if (next.e(i3)) {
                                    next.k(i2);
                                } else {
                                    next.c(i2);
                                }
                                i2 = i3;
                            }
                        }
                        this.d.h(i);
                        i--;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(j0 j0Var, int i, h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, j0Var, i, h0Var) == null) {
            d(j0Var);
            int i2 = 0;
            while (true) {
                y7<c> y7Var = this.d;
                if (i2 >= y7Var.b || y7Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            o7.e<v6> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                v6 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(j0Var).k(i2);
            c cVar = new c(null);
            cVar.a = h0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public q0<g0> b(j0 j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j0Var)) == null) {
            return d(j0Var);
        }
        return (q0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g0Var) == null) {
            v6 e = this.f.e();
            v6 e2 = this.f.e();
            o7.c<j0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                j0 next = f.next();
                int g = next.g();
                v6 f2 = g0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(g0Var) && !g0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    v6 c2 = this.e.c(next);
                    s6<g0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(g0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(g0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(g0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(g0Var);
                }
            } finally {
                e.b();
                e2.b();
                this.f.c(e);
                this.f.c(e2);
                this.d.p();
                this.g = false;
            }
        }
    }
}
