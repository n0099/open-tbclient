package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes5.dex */
public class n1 implements s8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o1 a;
    public final k1 b;
    public final p1 c;
    public final q8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile c7<k1> h;
    public volatile r8<Void> i;
    public volatile r8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public n1(o1 o1Var, k1 k1Var, p1 p1Var, q8 q8Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o1Var, k1Var, p1Var, q8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = o1Var;
        this.b = k1Var;
        this.c = p1Var;
        this.d = q8Var;
        if (o1Var.m.d() == 3) {
            j = o8.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q1 q1Var = (q1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            o1 o1Var = this.a;
                            k1 k1Var = this.b;
                            this.k = q1Var.d(o1Var, k1Var.a, d(this.c, k1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                o1 o1Var2 = this.a;
                k1 k1Var2 = this.b;
                this.k = q1Var.d(o1Var2, k1Var2.a, d(this.c, k1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    o1 o1Var3 = this.a;
                    k1 k1Var3 = this.b;
                    this.k = q1Var.d(o1Var3, k1Var3.a, d(this.c, k1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c2 c2Var = (c2) this.c;
            if (!this.g) {
                this.g = true;
                k1 k1Var = this.b;
                this.h = c2Var.a(k1Var.a, d(this.c, k1Var), this.b.c);
                if (this.h == null) {
                    o1 o1Var = this.a;
                    k1 k1Var2 = this.b;
                    this.k = c2Var.c(o1Var, k1Var2.a, d(this.c, k1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            o1 o1Var2 = this.a;
            k1 k1Var3 = this.b;
            this.k = c2Var.c(o1Var2, k1Var3.a, d(this.c, k1Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            q1 q1Var = (q1) this.c;
            if (!this.g) {
                k1 k1Var = this.b;
                this.h = q1Var.a(k1Var.a, d(this.c, k1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    o1 o1Var = this.a;
                    k1 k1Var2 = this.b;
                    q1Var.c(o1Var, k1Var2.a, d(this.c, k1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                o1 o1Var2 = this.a;
                k1 k1Var3 = this.b;
                q1Var.c(o1Var2, k1Var3.a, d(this.c, k1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(c7<k1> c7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c7Var) == null) {
            boolean z = c7Var.c;
            c7Var.c = true;
            for (int i = 0; i < c7Var.b; i++) {
                String str = c7Var.get(i).a;
                GenericDeclaration genericDeclaration = c7Var.get(i).b;
                for (int i2 = c7Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == c7Var.get(i2).b && str.equals(c7Var.get(i2).a)) {
                        c7Var.h(i2);
                    }
                }
            }
            c7Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            p1 p1Var = this.c;
            if (p1Var instanceof q1) {
                o1 o1Var = this.a;
                k1 k1Var = this.b;
                ((q1) p1Var).e(o1Var, k1Var.a, d(p1Var, k1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof c2) {
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

    public final l3 d(p1 p1Var, k1 k1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, p1Var, k1Var)) == null) {
            if (k1Var.d == null) {
                k1Var.d = p1Var.b(k1Var.a);
            }
            return k1Var.d;
        }
        return (l3) invokeLL.objValue;
    }
}
