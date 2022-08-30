package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes4.dex */
public class l1 implements q8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m1 a;
    public final i1 b;
    public final n1 c;
    public final o8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile a7<i1> h;
    public volatile p8<Void> i;
    public volatile p8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public l1(m1 m1Var, i1 i1Var, n1 n1Var, o8 o8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m1Var, i1Var, n1Var, o8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m1Var;
        this.b = i1Var;
        this.c = n1Var;
        this.d = o8Var;
        this.e = m1Var.m.d() == 3 ? m8.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o1 o1Var = (o1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            m1 m1Var = this.a;
                            i1 i1Var = this.b;
                            this.k = o1Var.d(m1Var, i1Var.a, d(this.c, i1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                m1 m1Var2 = this.a;
                i1 i1Var2 = this.b;
                this.k = o1Var.d(m1Var2, i1Var2.a, d(this.c, i1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    m1 m1Var3 = this.a;
                    i1 i1Var3 = this.b;
                    this.k = o1Var.d(m1Var3, i1Var3.a, d(this.c, i1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a2 a2Var = (a2) this.c;
            if (!this.g) {
                this.g = true;
                i1 i1Var = this.b;
                this.h = a2Var.a(i1Var.a, d(this.c, i1Var), this.b.c);
                if (this.h == null) {
                    m1 m1Var = this.a;
                    i1 i1Var2 = this.b;
                    this.k = a2Var.c(m1Var, i1Var2.a, d(this.c, i1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            m1 m1Var2 = this.a;
            i1 i1Var3 = this.b;
            this.k = a2Var.c(m1Var2, i1Var3.a, d(this.c, i1Var3), this.b.c);
        }
    }

    public final void c(a7<i1> a7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a7Var) == null) {
            boolean z = a7Var.c;
            a7Var.c = true;
            for (int i = 0; i < a7Var.b; i++) {
                String str = a7Var.get(i).a;
                GenericDeclaration genericDeclaration = a7Var.get(i).b;
                for (int i2 = a7Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == a7Var.get(i2).b && str.equals(a7Var.get(i2).a)) {
                        a7Var.i(i2);
                    }
                }
            }
            a7Var.c = z;
        }
    }

    public final j3 d(n1 n1Var, i1 i1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, n1Var, i1Var)) == null) {
            if (i1Var.d == null) {
                i1Var.d = n1Var.b(i1Var.a);
            }
            return i1Var.d;
        }
        return (j3) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n1 n1Var = this.c;
            if (n1Var instanceof o1) {
                m1 m1Var = this.a;
                i1 i1Var = this.b;
                ((o1) n1Var).e(m1Var, i1Var.a, d(n1Var, i1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof a2) {
                b();
            } else {
                a();
            }
            return this.k != null;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            o1 o1Var = (o1) this.c;
            if (!this.g) {
                i1 i1Var = this.b;
                this.h = o1Var.a(i1Var.a, d(this.c, i1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    m1 m1Var = this.a;
                    i1 i1Var2 = this.b;
                    o1Var.c(m1Var, i1Var2.a, d(this.c, i1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                m1 m1Var2 = this.a;
                i1 i1Var3 = this.b;
                o1Var.c(m1Var2, i1Var3.a, d(this.c, i1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
