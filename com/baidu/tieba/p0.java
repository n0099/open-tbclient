package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x0 a;
    public final x0 b;
    public boolean c;
    public boolean d;
    public ComponentOperationHandler e;
    public y0 f;
    public b7 g;
    public e7 h;
    public e7 i;

    public p0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new y0();
        this.g = new b7(false, 16);
        this.h = new e7();
        this.i = new e7();
        this.a = new x0();
        this.b = new x0();
    }

    public p0 a(m0 m0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m0Var)) == null) {
            if (b(m0Var)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public m0 c(n0 n0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n0Var)) == null) {
            if (n0Var.c() < this.f.b()) {
                return (m0) this.f.a(n0Var.c());
            }
            return null;
        }
        return (m0) invokeL.objValue;
    }

    public m0 d(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            return c(n0.b(cls));
        }
        return (m0) invokeL.objValue;
    }

    public boolean b(m0 m0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m0Var)) == null) {
            Class<?> cls = m0Var.getClass();
            m0 d = d(cls);
            if (m0Var == d) {
                return false;
            }
            if (d != null) {
                k(cls);
            }
            int d2 = n0.d(cls);
            this.f.d(d2, m0Var);
            this.g.a(m0Var);
            this.h.k(d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public m0 i(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            m0 m0Var = (m0) this.f.a(n0.b(cls).c());
            if (m0Var != null && k(cls)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.c(this);
                } else {
                    h();
                }
            }
            return m0Var;
        }
        return (m0) invokeL.objValue;
    }

    public boolean k(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c = n0.b(cls).c();
            m0 m0Var = (m0) this.f.a(c);
            if (m0Var != null) {
                this.f.d(c, null);
                this.g.j(m0Var, true);
                this.h.c(c);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public e7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (e7) invokeV.objValue;
    }

    public e7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (e7) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.b(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.b(this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            b7 b7Var = this.g;
            if (b7Var.b > 0) {
                i(((m0) b7Var.get(0)).getClass());
            } else {
                return;
            }
        }
    }
}
