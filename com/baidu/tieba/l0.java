package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r0<h0> a;
    public p7<k0, t6<h0>> b;
    public p7<k0, r0<h0>> c;
    public z7<c> d;
    public p7<k0, w6> e;
    public b f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends s7<w6> {
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
        @Override // com.baidu.tieba.s7
        /* renamed from: g */
        public w6 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new w6();
            }
            return (w6) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public i0 a;
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

    public l0(r0<h0> r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new p7<>();
        this.c = new p7<>();
        this.d = new z7<>(true, 16);
        this.e = new p7<>();
        this.f = new b(null);
        this.g = false;
        this.a = r0Var;
    }

    public final r0<h0> d(k0 k0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k0Var)) == null) {
            r0<h0> c2 = this.c.c(k0Var);
            if (c2 == null) {
                t6<h0> t6Var = new t6<>(false, 16);
                r0<h0> r0Var = new r0<>(t6Var);
                this.b.i(k0Var, t6Var);
                this.c.i(k0Var, r0Var);
                this.e.i(k0Var, new w6());
                Iterator<h0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return r0Var;
            }
            return c2;
        }
        return (r0) invokeL.objValue;
    }

    public void e(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i0Var) == null) {
            int i = 0;
            while (true) {
                z7<c> z7Var = this.d;
                if (i < z7Var.b) {
                    if (z7Var.get(i).a == i0Var) {
                        p7.e<w6> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            w6 next = n.next();
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

    public void a(k0 k0Var, int i, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, k0Var, i, i0Var) == null) {
            d(k0Var);
            int i2 = 0;
            while (true) {
                z7<c> z7Var = this.d;
                if (i2 >= z7Var.b || z7Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            p7.e<w6> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                w6 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(k0Var).k(i2);
            c cVar = new c(null);
            cVar.a = i0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public r0<h0> b(k0 k0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k0Var)) == null) {
            return d(k0Var);
        }
        return (r0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h0Var) == null) {
            w6 e = this.f.e();
            w6 e2 = this.f.e();
            p7.c<k0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                k0 next = f.next();
                int g = next.g();
                w6 f2 = h0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(h0Var) && !h0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    w6 c2 = this.e.c(next);
                    t6<h0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(h0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(h0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(h0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(h0Var);
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
