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
public class s1 implements x8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t1 a;
    public final p1 b;
    public final u1 c;
    public final v8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile h7<p1> h;
    public volatile w8<Void> i;
    public volatile w8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public s1(t1 t1Var, p1 p1Var, u1 u1Var, v8 v8Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1Var, p1Var, u1Var, v8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t1Var;
        this.b = p1Var;
        this.c = u1Var;
        this.d = v8Var;
        if (t1Var.m.d() == 3) {
            j = t8.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v1 v1Var = (v1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            t1 t1Var = this.a;
                            p1 p1Var = this.b;
                            this.k = v1Var.d(t1Var, p1Var.a, d(this.c, p1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                t1 t1Var2 = this.a;
                p1 p1Var2 = this.b;
                this.k = v1Var.d(t1Var2, p1Var2.a, d(this.c, p1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    t1 t1Var3 = this.a;
                    p1 p1Var3 = this.b;
                    this.k = v1Var.d(t1Var3, p1Var3.a, d(this.c, p1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h2 h2Var = (h2) this.c;
            if (!this.g) {
                this.g = true;
                p1 p1Var = this.b;
                this.h = h2Var.a(p1Var.a, d(this.c, p1Var), this.b.c);
                if (this.h == null) {
                    t1 t1Var = this.a;
                    p1 p1Var2 = this.b;
                    this.k = h2Var.c(t1Var, p1Var2.a, d(this.c, p1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            t1 t1Var2 = this.a;
            p1 p1Var3 = this.b;
            this.k = h2Var.c(t1Var2, p1Var3.a, d(this.c, p1Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            v1 v1Var = (v1) this.c;
            if (!this.g) {
                p1 p1Var = this.b;
                this.h = v1Var.a(p1Var.a, d(this.c, p1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    t1 t1Var = this.a;
                    p1 p1Var2 = this.b;
                    v1Var.c(t1Var, p1Var2.a, d(this.c, p1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                t1 t1Var2 = this.a;
                p1 p1Var3 = this.b;
                v1Var.c(t1Var2, p1Var3.a, d(this.c, p1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(h7<p1> h7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h7Var) == null) {
            boolean z = h7Var.c;
            h7Var.c = true;
            for (int i = 0; i < h7Var.b; i++) {
                String str = h7Var.get(i).a;
                GenericDeclaration genericDeclaration = h7Var.get(i).b;
                for (int i2 = h7Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == h7Var.get(i2).b && str.equals(h7Var.get(i2).a)) {
                        h7Var.h(i2);
                    }
                }
            }
            h7Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            u1 u1Var = this.c;
            if (u1Var instanceof v1) {
                t1 t1Var = this.a;
                p1 p1Var = this.b;
                ((v1) u1Var).e(t1Var, p1Var.a, d(u1Var, p1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof h2) {
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

    public final q3 d(u1 u1Var, p1 p1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, u1Var, p1Var)) == null) {
            if (p1Var.d == null) {
                p1Var.d = u1Var.b(p1Var.a);
            }
            return p1Var.d;
        }
        return (q3) invokeLL.objValue;
    }
}
