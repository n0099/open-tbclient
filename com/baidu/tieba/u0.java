package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a1<q0> a;
    public y7<t0, c7<q0>> b;
    public y7<t0, a1<q0>> c;
    public i8<c> d;
    public y7<t0, f7> e;
    public b f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends b8<f7> {
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
        @Override // com.baidu.tieba.b8
        /* renamed from: g */
        public f7 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new f7();
            }
            return (f7) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r0 a;
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

    public u0(a1<q0> a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new y7<>();
        this.c = new y7<>();
        this.d = new i8<>(true, 16);
        this.e = new y7<>();
        this.f = new b(null);
        this.g = false;
        this.a = a1Var;
    }

    public final a1<q0> d(t0 t0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t0Var)) == null) {
            a1<q0> c2 = this.c.c(t0Var);
            if (c2 == null) {
                c7<q0> c7Var = new c7<>(false, 16);
                a1<q0> a1Var = new a1<>(c7Var);
                this.b.i(t0Var, c7Var);
                this.c.i(t0Var, a1Var);
                this.e.i(t0Var, new f7());
                Iterator<q0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return a1Var;
            }
            return c2;
        }
        return (a1) invokeL.objValue;
    }

    public void e(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, r0Var) == null) {
            int i = 0;
            while (true) {
                i8<c> i8Var = this.d;
                if (i < i8Var.b) {
                    if (i8Var.get(i).a == r0Var) {
                        y7.e<f7> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            f7 next = n.next();
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

    public void a(t0 t0Var, int i, r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, t0Var, i, r0Var) == null) {
            d(t0Var);
            int i2 = 0;
            while (true) {
                i8<c> i8Var = this.d;
                if (i2 >= i8Var.b || i8Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            y7.e<f7> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                f7 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(t0Var).k(i2);
            c cVar = new c(null);
            cVar.a = r0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public a1<q0> b(t0 t0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t0Var)) == null) {
            return d(t0Var);
        }
        return (a1) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, q0Var) == null) {
            f7 e = this.f.e();
            f7 e2 = this.f.e();
            y7.c<t0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                t0 next = f.next();
                int g = next.g();
                f7 f2 = q0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(q0Var) && !q0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    f7 c2 = this.e.c(next);
                    c7<q0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(q0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(q0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(q0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(q0Var);
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
