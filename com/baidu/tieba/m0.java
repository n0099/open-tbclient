package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a3;
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
    public a3<l0, r2<i0>> b;
    public a3<l0, s0<i0>> c;
    public g3<c> d;
    public a3<l0, s2> e;
    public b f;
    public boolean g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends c3<s2> {
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
        @Override // com.baidu.tieba.c3
        /* renamed from: g */
        public s2 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new s2();
            }
            return (s2) invokeV.objValue;
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
        this.b = new a3<>();
        this.c = new a3<>();
        this.d = new g3<>(true, 16);
        this.e = new a3<>();
        this.f = new b(null);
        this.g = false;
        this.a = s0Var;
    }

    public final s0<i0> d(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l0Var)) == null) {
            s0<i0> b2 = this.c.b(l0Var);
            if (b2 == null) {
                r2<i0> r2Var = new r2<>(false, 16);
                s0<i0> s0Var = new s0<>(r2Var);
                this.b.h(l0Var, r2Var);
                this.c.h(l0Var, s0Var);
                this.e.h(l0Var, new s2());
                Iterator<i0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return s0Var;
            }
            return b2;
        }
        return (s0) invokeL.objValue;
    }

    public void e(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j0Var) == null) {
            int i = 0;
            while (true) {
                g3<c> g3Var = this.d;
                if (i < g3Var.b) {
                    if (g3Var.get(i).a == j0Var) {
                        a3.e<s2> m = this.e.m();
                        m.c();
                        while (m.hasNext()) {
                            s2 next = m.next();
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
                        this.d.f(i);
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
                g3<c> g3Var = this.d;
                if (i2 >= g3Var.b || g3Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            a3.e<s2> m = this.e.m();
            m.c();
            while (m.hasNext()) {
                s2 next = m.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.b(l0Var).k(i2);
            c cVar = new c(null);
            cVar.a = j0Var;
            cVar.b = i;
            this.d.d(i2, cVar);
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
            s2 e = this.f.e();
            s2 e2 = this.f.e();
            a3.c<l0> e3 = this.e.e();
            e3.c();
            while (true) {
                boolean z = false;
                if (!e3.hasNext()) {
                    break;
                }
                l0 next = e3.next();
                int g = next.g();
                s2 f = i0Var.f();
                boolean e4 = f.e(g);
                if (next.h(i0Var) && !i0Var.d) {
                    z = true;
                }
                if (e4 != z) {
                    s2 b2 = this.e.b(next);
                    r2<i0> b3 = this.b.b(next);
                    if (z) {
                        e.j(b2);
                        b3.a(i0Var);
                        f.k(g);
                    } else {
                        e2.j(b2);
                        b3.g(i0Var, true);
                        f.c(g);
                    }
                }
            }
            this.g = true;
            c[] i = this.d.i();
            try {
                for (int i2 = e2.i(0); i2 >= 0; i2 = e2.i(i2 + 1)) {
                    i[i2].a.a(i0Var);
                }
                for (int i3 = e.i(0); i3 >= 0; i3 = e.i(i3 + 1)) {
                    i[i3].a.b(i0Var);
                }
            } finally {
                e.b();
                e2.b();
                this.f.c(e);
                this.f.c(e2);
                this.d.j();
                this.g = false;
            }
        }
    }
}
