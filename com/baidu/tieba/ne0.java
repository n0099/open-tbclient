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
public class ne0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pe0 a;
    public te0 b;
    public af0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947999440, "Lcom/baidu/tieba/ne0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947999440, "Lcom/baidu/tieba/ne0;");
        }
    }

    public ne0(af0 af0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = af0Var;
        this.a = new pe0(af0Var.f(), 1);
        d();
    }

    public void b(long j) {
        af0 af0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (af0Var = this.c) != null) {
            if (af0Var.l()) {
                d();
            }
            if (j != 0) {
                this.c.h().h(j);
            }
            this.b.a(this.c.e(), this.c.h());
        }
    }

    public final void a(te0 te0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, te0Var) == null) {
            if (te0Var == null) {
                this.b = new se0();
            } else {
                this.b = te0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void g(te0 te0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, te0Var) == null) {
            af0 af0Var = this.c;
            if (af0Var != null) {
                af0Var.p(te0Var);
            }
            this.b.release();
            a(te0Var);
        }
    }

    public pe0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (pe0) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            te0 te0Var = this.b;
            if (te0Var != null) {
                te0Var.release();
                this.b = null;
            }
            pe0 pe0Var = this.a;
            if (pe0Var != null) {
                pe0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            te0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            cf0.b(b);
            ye0 c = this.c.c();
            cf0.e(b, c.g(), c.h());
            cf0.a(b, c.d());
            cf0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                cf0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            we0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            cf0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }
}
