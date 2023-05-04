package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jc0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lc0 a;
    public pc0 b;
    public wc0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947878354, "Lcom/baidu/tieba/jc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947878354, "Lcom/baidu/tieba/jc0;");
        }
    }

    public jc0(wc0 wc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = wc0Var;
        this.a = new lc0(wc0Var.f(), 1);
        d();
    }

    public void b(long j) {
        wc0 wc0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (wc0Var = this.c) != null) {
            if (wc0Var.l()) {
                d();
            }
            if (j != 0) {
                this.c.h().h(j);
            }
            this.b.a(this.c.e(), this.c.h());
        }
    }

    public final void a(pc0 pc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pc0Var) == null) {
            if (pc0Var == null) {
                this.b = new oc0();
            } else {
                this.b = pc0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void g(pc0 pc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pc0Var) == null) {
            wc0 wc0Var = this.c;
            if (wc0Var != null) {
                wc0Var.p(pc0Var);
            }
            this.b.release();
            a(pc0Var);
        }
    }

    public lc0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (lc0) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pc0 pc0Var = this.b;
            if (pc0Var != null) {
                pc0Var.release();
                this.b = null;
            }
            lc0 lc0Var = this.a;
            if (lc0Var != null) {
                lc0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            pc0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            yc0.b(b);
            uc0 c = this.c.c();
            yc0.e(b, c.g(), c.h());
            yc0.a(b, c.d());
            yc0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                yc0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            sc0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            yc0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }
}
