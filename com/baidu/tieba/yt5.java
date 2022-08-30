package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ut5 b;
    public int c;

    public yt5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.a(viewGroup);
    }

    public void b(it5 it5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it5Var, z) == null) {
            if (it5Var == null) {
                this.c = -1;
                this.b = new vt5(this.a);
            } else if (z) {
                int i = it5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new xt5(this.a);
                } else if (i == 2) {
                    this.b = new zt5(this.a);
                } else if (i != 3) {
                    this.b = new vt5(this.a);
                } else {
                    this.b = new wt5(this.a);
                }
            }
            if (this.b.f(it5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(it5Var);
                return;
            }
            this.c = -1;
            vt5 vt5Var = new vt5(this.a);
            this.b = vt5Var;
            if (z) {
                vt5Var.d();
            }
            this.b.b(it5Var);
        }
    }

    public boolean c(it5 it5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, it5Var)) == null) ? it5Var == null || this.c != it5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.g(z);
    }

    public void e() {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.h();
    }

    public void f(int i) {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.i(i);
    }

    public void g() {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.j();
    }

    public void h() {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.k();
    }

    public void i() {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.l();
    }

    public void j() {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.m();
    }

    public void k() {
        ut5 ut5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ut5Var = this.b) == null) {
            return;
        }
        ut5Var.n();
    }
}
