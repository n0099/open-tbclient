package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s0<i0> a;
    public q7<l0, u6<i0>> b;
    public q7<l0, s0<i0>> c;
    public a8<c> d;
    public q7<l0, x6> e;
    public b f;
    public boolean g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends t7<x6> {
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
        @Override // com.baidu.tieba.t7
        /* renamed from: g */
        public x6 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new x6();
            }
            return (x6) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public j0 a;
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

    public m0(s0<i0> s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new q7<>();
        this.c = new q7<>();
        this.d = new a8<>(true, 16);
        this.e = new q7<>();
        this.f = new b(null);
        this.g = false;
        this.a = s0Var;
    }

    public final s0<i0> d(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l0Var)) == null) {
            s0<i0> c2 = this.c.c(l0Var);
            if (c2 == null) {
                u6<i0> u6Var = new u6<>(false, 16);
                s0<i0> s0Var = new s0<>(u6Var);
                this.b.i(l0Var, u6Var);
                this.c.i(l0Var, s0Var);
                this.e.i(l0Var, new x6());
                Iterator<i0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return s0Var;
            }
            return c2;
        }
        return (s0) invokeL.objValue;
    }

    public void e(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j0Var) == null) {
            int i = 0;
            while (true) {
                a8<c> a8Var = this.d;
                if (i < a8Var.b) {
                    if (a8Var.get(i).a == j0Var) {
                        q7.e<x6> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            x6 next = n.next();
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

    public void a(l0 l0Var, int i, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, l0Var, i, j0Var) == null) {
            d(l0Var);
            int i2 = 0;
            while (true) {
                a8<c> a8Var = this.d;
                if (i2 >= a8Var.b || a8Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            q7.e<x6> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                x6 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(l0Var).k(i2);
            c cVar = new c(null);
            cVar.a = j0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public s0<i0> b(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var)) == null) {
            return d(l0Var);
        }
        return (s0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, i0Var) == null) {
            x6 e = this.f.e();
            x6 e2 = this.f.e();
            q7.c<l0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                l0 next = f.next();
                int g = next.g();
                x6 f2 = i0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(i0Var) && !i0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    x6 c2 = this.e.c(next);
                    u6<i0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(i0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(i0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(i0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(i0Var);
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
