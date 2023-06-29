package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class me0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oe0 a;
    public se0 b;
    public ze0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947969649, "Lcom/baidu/tieba/me0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947969649, "Lcom/baidu/tieba/me0;");
        }
    }

    public me0(ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ze0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = ze0Var;
        this.a = new oe0(ze0Var.f(), 1);
        d();
    }

    public void b(long j) {
        ze0 ze0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (ze0Var = this.c) != null) {
            if (ze0Var.l()) {
                d();
            }
            if (j != 0) {
                this.c.h().h(j);
            }
            this.b.a(this.c.e(), this.c.h());
        }
    }

    public final void a(se0 se0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, se0Var) == null) {
            if (se0Var == null) {
                this.b = new re0();
            } else {
                this.b = se0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void g(se0 se0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, se0Var) == null) {
            ze0 ze0Var = this.c;
            if (ze0Var != null) {
                ze0Var.p(se0Var);
            }
            this.b.release();
            a(se0Var);
        }
    }

    public oe0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (oe0) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            se0 se0Var = this.b;
            if (se0Var != null) {
                se0Var.release();
                this.b = null;
            }
            oe0 oe0Var = this.a;
            if (oe0Var != null) {
                oe0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            se0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            bf0.b(b);
            xe0 c = this.c.c();
            bf0.e(b, c.g(), c.h());
            bf0.a(b, c.d());
            bf0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                bf0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            ve0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            bf0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }
}
