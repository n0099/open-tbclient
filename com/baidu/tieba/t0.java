package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class t0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z0<p0> a;
    public x7<s0, b7<p0>> b;
    public x7<s0, z0<p0>> c;
    public h8<c> d;
    public x7<s0, e7> e;
    public b f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends a8<e7> {
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
        @Override // com.baidu.tieba.a8
        /* renamed from: g */
        public e7 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new e7();
            }
            return (e7) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public q0 a;
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

    public t0(z0<p0> z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new x7<>();
        this.c = new x7<>();
        this.d = new h8<>(true, 16);
        this.e = new x7<>();
        this.f = new b(null);
        this.g = false;
        this.a = z0Var;
    }

    public final z0<p0> d(s0 s0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, s0Var)) == null) {
            z0<p0> c2 = this.c.c(s0Var);
            if (c2 == null) {
                b7<p0> b7Var = new b7<>(false, 16);
                z0<p0> z0Var = new z0<>(b7Var);
                this.b.i(s0Var, b7Var);
                this.c.i(s0Var, z0Var);
                this.e.i(s0Var, new e7());
                Iterator<p0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return z0Var;
            }
            return c2;
        }
        return (z0) invokeL.objValue;
    }

    public void e(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, q0Var) == null) {
            int i = 0;
            while (true) {
                h8<c> h8Var = this.d;
                if (i < h8Var.b) {
                    if (h8Var.get(i).a == q0Var) {
                        x7.e<e7> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            e7 next = n.next();
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
                        this.d.i(i);
                        i--;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(s0 s0Var, int i, q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, s0Var, i, q0Var) == null) {
            d(s0Var);
            int i2 = 0;
            while (true) {
                h8<c> h8Var = this.d;
                if (i2 >= h8Var.b || h8Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            x7.e<e7> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                e7 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(s0Var).k(i2);
            c cVar = new c(null);
            cVar.a = q0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public z0<p0> b(s0 s0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s0Var)) == null) {
            return d(s0Var);
        }
        return (z0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p0Var) == null) {
            e7 e = this.f.e();
            e7 e2 = this.f.e();
            x7.c<s0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                s0 next = f.next();
                int g = next.g();
                e7 f2 = p0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(p0Var) && !p0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    e7 c2 = this.e.c(next);
                    b7<p0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(p0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.j(p0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] p = this.d.p();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    p[i].a.a(p0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    p[i2].a.b(p0Var);
                }
            } finally {
                e.b();
                e2.b();
                this.f.c(e);
                this.f.c(e2);
                this.d.q();
                this.g = false;
            }
        }
    }
}
