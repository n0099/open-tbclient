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
public class od0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qd0 a;
    public ud0 b;
    public be0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948028270, "Lcom/baidu/tieba/od0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948028270, "Lcom/baidu/tieba/od0;");
        }
    }

    public od0(be0 be0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {be0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = be0Var;
        this.a = new qd0(be0Var.f(), 1);
        d();
    }

    public void b(long j) {
        be0 be0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (be0Var = this.c) != null) {
            if (be0Var.l()) {
                d();
            }
            if (j != 0) {
                this.c.h().h(j);
            }
            this.b.a(this.c.e(), this.c.h());
        }
    }

    public final void a(ud0 ud0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ud0Var) == null) {
            if (ud0Var == null) {
                this.b = new td0();
            } else {
                this.b = ud0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void g(ud0 ud0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ud0Var) == null) {
            be0 be0Var = this.c;
            if (be0Var != null) {
                be0Var.p(ud0Var);
            }
            this.b.release();
            a(ud0Var);
        }
    }

    public qd0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (qd0) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ud0 ud0Var = this.b;
            if (ud0Var != null) {
                ud0Var.release();
                this.b = null;
            }
            qd0 qd0Var = this.a;
            if (qd0Var != null) {
                qd0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ud0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            de0.b(b);
            zd0 c = this.c.c();
            de0.e(b, c.g(), c.h());
            de0.a(b, c.d());
            de0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                de0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            xd0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            de0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }
}
