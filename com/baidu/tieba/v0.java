package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes6.dex */
public class v0 implements a8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w0 a;
    public final s0 b;
    public final x0 c;
    public final y7 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile k6<s0> h;
    public volatile z7<Void> i;
    public volatile z7<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public v0(w0 w0Var, s0 s0Var, x0 x0Var, y7 y7Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w0Var, s0Var, x0Var, y7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = w0Var;
        this.b = s0Var;
        this.c = x0Var;
        this.d = y7Var;
        if (w0Var.m.d() == 3) {
            j = w7.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y0 y0Var = (y0) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            w0 w0Var = this.a;
                            s0 s0Var = this.b;
                            this.k = y0Var.d(w0Var, s0Var.a, d(this.c, s0Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                w0 w0Var2 = this.a;
                s0 s0Var2 = this.b;
                this.k = y0Var.d(w0Var2, s0Var2.a, d(this.c, s0Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    w0 w0Var3 = this.a;
                    s0 s0Var3 = this.b;
                    this.k = y0Var.d(w0Var3, s0Var3.a, d(this.c, s0Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k1 k1Var = (k1) this.c;
            if (!this.g) {
                this.g = true;
                s0 s0Var = this.b;
                this.h = k1Var.a(s0Var.a, d(this.c, s0Var), this.b.c);
                if (this.h == null) {
                    w0 w0Var = this.a;
                    s0 s0Var2 = this.b;
                    this.k = k1Var.c(w0Var, s0Var2.a, d(this.c, s0Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            w0 w0Var2 = this.a;
            s0 s0Var3 = this.b;
            this.k = k1Var.c(w0Var2, s0Var3.a, d(this.c, s0Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            y0 y0Var = (y0) this.c;
            if (!this.g) {
                s0 s0Var = this.b;
                this.h = y0Var.a(s0Var.a, d(this.c, s0Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    w0 w0Var = this.a;
                    s0 s0Var2 = this.b;
                    y0Var.c(w0Var, s0Var2.a, d(this.c, s0Var2), this.b.c);
                    this.f = true;
                }
            } else {
                w0 w0Var2 = this.a;
                s0 s0Var3 = this.b;
                y0Var.c(w0Var2, s0Var3.a, d(this.c, s0Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(k6<s0> k6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k6Var) == null) {
            boolean z = k6Var.c;
            k6Var.c = true;
            for (int i = 0; i < k6Var.b; i++) {
                String str = k6Var.get(i).a;
                GenericDeclaration genericDeclaration = k6Var.get(i).b;
                for (int i2 = k6Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == k6Var.get(i2).b && str.equals(k6Var.get(i2).a)) {
                        k6Var.h(i2);
                    }
                }
            }
            k6Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            x0 x0Var = this.c;
            if (x0Var instanceof y0) {
                w0 w0Var = this.a;
                s0 s0Var = this.b;
                ((y0) x0Var).e(w0Var, s0Var.a, d(x0Var, s0Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof k1) {
                b();
            } else {
                a();
            }
            if (this.k != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final t2 d(x0 x0Var, s0 s0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, x0Var, s0Var)) == null) {
            if (s0Var.d == null) {
                s0Var.d = x0Var.b(s0Var.a);
            }
            return s0Var.d;
        }
        return (t2) invokeLL.objValue;
    }
}
