package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class z0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f1<v0> a;
    public d8<y0, h7<v0>> b;
    public d8<y0, f1<v0>> c;
    public n8<c> d;
    public d8<y0, k7> e;
    public b f;
    public boolean g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends g8<k7> {
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
        @Override // com.baidu.tieba.g8
        /* renamed from: g */
        public k7 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new k7();
            }
            return (k7) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w0 a;
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

    public z0(f1<v0> f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new d8<>();
        this.c = new d8<>();
        this.d = new n8<>(true, 16);
        this.e = new d8<>();
        this.f = new b(null);
        this.g = false;
        this.a = f1Var;
    }

    public final f1<v0> d(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, y0Var)) == null) {
            f1<v0> c2 = this.c.c(y0Var);
            if (c2 == null) {
                h7<v0> h7Var = new h7<>(false, 16);
                f1<v0> f1Var = new f1<>(h7Var);
                this.b.i(y0Var, h7Var);
                this.c.i(y0Var, f1Var);
                this.e.i(y0Var, new k7());
                Iterator<v0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return f1Var;
            }
            return c2;
        }
        return (f1) invokeL.objValue;
    }

    public void e(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, w0Var) == null) {
            int i = 0;
            while (true) {
                n8<c> n8Var = this.d;
                if (i < n8Var.b) {
                    if (n8Var.get(i).a == w0Var) {
                        d8.e<k7> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            k7 next = n.next();
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

    public void a(y0 y0Var, int i, w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, y0Var, i, w0Var) == null) {
            d(y0Var);
            int i2 = 0;
            while (true) {
                n8<c> n8Var = this.d;
                if (i2 >= n8Var.b || n8Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            d8.e<k7> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                k7 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(y0Var).k(i2);
            c cVar = new c(null);
            cVar.a = w0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public f1<v0> b(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y0Var)) == null) {
            return d(y0Var);
        }
        return (f1) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, v0Var) == null) {
            k7 e = this.f.e();
            k7 e2 = this.f.e();
            d8.c<y0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                y0 next = f.next();
                int g = next.g();
                k7 f2 = v0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(v0Var) && !v0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    k7 c2 = this.e.c(next);
                    h7<v0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(v0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(v0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(v0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(v0Var);
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
