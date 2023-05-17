package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes8.dex */
public class z0 implements e8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a1 a;
    public final w0 b;
    public final b1 c;
    public final c8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile o6<w0> h;
    public volatile d8<Void> i;
    public volatile d8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public z0(a1 a1Var, w0 w0Var, b1 b1Var, c8 c8Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1Var, w0Var, b1Var, c8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a1Var;
        this.b = w0Var;
        this.c = b1Var;
        this.d = c8Var;
        if (a1Var.m.d() == 3) {
            j = a8.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c1 c1Var = (c1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            a1 a1Var = this.a;
                            w0 w0Var = this.b;
                            this.k = c1Var.d(a1Var, w0Var.a, d(this.c, w0Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                a1 a1Var2 = this.a;
                w0 w0Var2 = this.b;
                this.k = c1Var.d(a1Var2, w0Var2.a, d(this.c, w0Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    a1 a1Var3 = this.a;
                    w0 w0Var3 = this.b;
                    this.k = c1Var.d(a1Var3, w0Var3.a, d(this.c, w0Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o1 o1Var = (o1) this.c;
            if (!this.g) {
                this.g = true;
                w0 w0Var = this.b;
                this.h = o1Var.a(w0Var.a, d(this.c, w0Var), this.b.c);
                if (this.h == null) {
                    a1 a1Var = this.a;
                    w0 w0Var2 = this.b;
                    this.k = o1Var.c(a1Var, w0Var2.a, d(this.c, w0Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            a1 a1Var2 = this.a;
            w0 w0Var3 = this.b;
            this.k = o1Var.c(a1Var2, w0Var3.a, d(this.c, w0Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.e8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            c1 c1Var = (c1) this.c;
            if (!this.g) {
                w0 w0Var = this.b;
                this.h = c1Var.a(w0Var.a, d(this.c, w0Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    a1 a1Var = this.a;
                    w0 w0Var2 = this.b;
                    c1Var.c(a1Var, w0Var2.a, d(this.c, w0Var2), this.b.c);
                    this.f = true;
                }
            } else {
                a1 a1Var2 = this.a;
                w0 w0Var3 = this.b;
                c1Var.c(a1Var2, w0Var3.a, d(this.c, w0Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(o6<w0> o6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o6Var) == null) {
            boolean z = o6Var.c;
            o6Var.c = true;
            for (int i = 0; i < o6Var.b; i++) {
                String str = o6Var.get(i).a;
                GenericDeclaration genericDeclaration = o6Var.get(i).b;
                for (int i2 = o6Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == o6Var.get(i2).b && str.equals(o6Var.get(i2).a)) {
                        o6Var.h(i2);
                    }
                }
            }
            o6Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b1 b1Var = this.c;
            if (b1Var instanceof c1) {
                a1 a1Var = this.a;
                w0 w0Var = this.b;
                ((c1) b1Var).e(a1Var, w0Var.a, d(b1Var, w0Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof o1) {
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

    public final x2 d(b1 b1Var, w0 w0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, b1Var, w0Var)) == null) {
            if (w0Var.d == null) {
                w0Var.d = b1Var.b(w0Var.a);
            }
            return w0Var.d;
        }
        return (x2) invokeLL.objValue;
    }
}
