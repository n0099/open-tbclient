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
public class m1 implements r8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n1 a;
    public final j1 b;
    public final o1 c;
    public final p8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile b7<j1> h;
    public volatile q8<Void> i;
    public volatile q8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public m1(n1 n1Var, j1 j1Var, o1 o1Var, p8 p8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n1Var, j1Var, o1Var, p8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n1Var;
        this.b = j1Var;
        this.c = o1Var;
        this.d = p8Var;
        this.e = n1Var.m.d() == 3 ? n8.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p1 p1Var = (p1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            n1 n1Var = this.a;
                            j1 j1Var = this.b;
                            this.k = p1Var.d(n1Var, j1Var.a, d(this.c, j1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                n1 n1Var2 = this.a;
                j1 j1Var2 = this.b;
                this.k = p1Var.d(n1Var2, j1Var2.a, d(this.c, j1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    n1 n1Var3 = this.a;
                    j1 j1Var3 = this.b;
                    this.k = p1Var.d(n1Var3, j1Var3.a, d(this.c, j1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b2 b2Var = (b2) this.c;
            if (!this.g) {
                this.g = true;
                j1 j1Var = this.b;
                this.h = b2Var.a(j1Var.a, d(this.c, j1Var), this.b.c);
                if (this.h == null) {
                    n1 n1Var = this.a;
                    j1 j1Var2 = this.b;
                    this.k = b2Var.c(n1Var, j1Var2.a, d(this.c, j1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            n1 n1Var2 = this.a;
            j1 j1Var3 = this.b;
            this.k = b2Var.c(n1Var2, j1Var3.a, d(this.c, j1Var3), this.b.c);
        }
    }

    public final void c(b7<j1> b7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b7Var) == null) {
            boolean z = b7Var.c;
            b7Var.c = true;
            for (int i = 0; i < b7Var.b; i++) {
                String str = b7Var.get(i).a;
                GenericDeclaration genericDeclaration = b7Var.get(i).b;
                for (int i2 = b7Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == b7Var.get(i2).b && str.equals(b7Var.get(i2).a)) {
                        b7Var.i(i2);
                    }
                }
            }
            b7Var.c = z;
        }
    }

    public final k3 d(o1 o1Var, j1 j1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, o1Var, j1Var)) == null) {
            if (j1Var.d == null) {
                j1Var.d = o1Var.b(j1Var.a);
            }
            return j1Var.d;
        }
        return (k3) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o1 o1Var = this.c;
            if (o1Var instanceof p1) {
                n1 n1Var = this.a;
                j1 j1Var = this.b;
                ((p1) o1Var).e(n1Var, j1Var.a, d(o1Var, j1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof b2) {
                b();
            } else {
                a();
            }
            return this.k != null;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            p1 p1Var = (p1) this.c;
            if (!this.g) {
                j1 j1Var = this.b;
                this.h = p1Var.a(j1Var.a, d(this.c, j1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    n1 n1Var = this.a;
                    j1 j1Var2 = this.b;
                    p1Var.c(n1Var, j1Var2.a, d(this.c, j1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                n1 n1Var2 = this.a;
                j1 j1Var3 = this.b;
                p1Var.c(n1Var2, j1Var3.a, d(this.c, j1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
