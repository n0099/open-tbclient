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
public class je0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public le0 a;
    public pe0 b;
    public we0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947880276, "Lcom/baidu/tieba/je0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947880276, "Lcom/baidu/tieba/je0;");
        }
    }

    public je0(we0 we0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {we0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = we0Var;
        this.a = new le0(we0Var.f(), 1);
        d();
    }

    public void b(long j) {
        we0 we0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (we0Var = this.c) != null) {
            if (we0Var.l()) {
                d();
            }
            if (j != 0) {
                this.c.h().h(j);
            }
            this.b.a(this.c.e(), this.c.h());
        }
    }

    public final void a(pe0 pe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pe0Var) == null) {
            if (pe0Var == null) {
                this.b = new oe0();
            } else {
                this.b = pe0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void g(pe0 pe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pe0Var) == null) {
            we0 we0Var = this.c;
            if (we0Var != null) {
                we0Var.p(pe0Var);
            }
            this.b.release();
            a(pe0Var);
        }
    }

    public le0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (le0) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pe0 pe0Var = this.b;
            if (pe0Var != null) {
                pe0Var.release();
                this.b = null;
            }
            le0 le0Var = this.a;
            if (le0Var != null) {
                le0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            pe0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            ye0.b(b);
            ue0 c = this.c.c();
            ye0.e(b, c.g(), c.h());
            ye0.a(b, c.d());
            ye0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                ye0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            se0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            ye0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }
}
