package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n80 a;
    public r80 b;
    public y80 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947896613, "Lcom/baidu/tieba/l80;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947896613, "Lcom/baidu/tieba/l80;");
        }
    }

    public l80(y80 y80Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y80Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = y80Var;
        this.a = new n80(y80Var.f(), 1);
        d();
    }

    public void b(long j) {
        y80 y80Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (y80Var = this.c) != null) {
            if (y80Var.m()) {
                d();
            }
            if (j != 0) {
                this.c.h().h(j);
            }
            this.b.a(this.c.e(), this.c.h());
        }
    }

    public final void a(r80 r80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r80Var) == null) {
            if (r80Var == null) {
                this.b = new q80();
            } else {
                this.b = r80Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void g(r80 r80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, r80Var) == null) {
            y80 y80Var = this.c;
            if (y80Var != null) {
                y80Var.p(r80Var);
            }
            this.b.release();
            a(r80Var);
        }
    }

    public n80 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (n80) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r80 r80Var = this.b;
            if (r80Var != null) {
                r80Var.release();
                this.b = null;
            }
            n80 n80Var = this.a;
            if (n80Var != null) {
                n80Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r80 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            a90.b(b);
            w80 c = this.c.c();
            a90.e(b, c.g(), c.h());
            a90.a(b, c.d());
            a90.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                a90.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            u80 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            a90.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }
}
