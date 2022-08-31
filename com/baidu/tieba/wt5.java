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
public class wt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public st5 b;
    public int c;

    public wt5(TbPageContext tbPageContext) {
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
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.a(viewGroup);
    }

    public void b(gt5 gt5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gt5Var, z) == null) {
            if (gt5Var == null) {
                this.c = -1;
                this.b = new tt5(this.a);
            } else if (z) {
                int i = gt5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new vt5(this.a);
                } else if (i == 2) {
                    this.b = new xt5(this.a);
                } else if (i != 3) {
                    this.b = new tt5(this.a);
                } else {
                    this.b = new ut5(this.a);
                }
            }
            if (this.b.f(gt5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(gt5Var);
                return;
            }
            this.c = -1;
            tt5 tt5Var = new tt5(this.a);
            this.b = tt5Var;
            if (z) {
                tt5Var.d();
            }
            this.b.b(gt5Var);
        }
    }

    public boolean c(gt5 gt5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gt5Var)) == null) ? gt5Var == null || this.c != gt5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.g(z);
    }

    public void e() {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.h();
    }

    public void f(int i) {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.i(i);
    }

    public void g() {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.j();
    }

    public void h() {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.k();
    }

    public void i() {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.l();
    }

    public void j() {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.m();
    }

    public void k() {
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (st5Var = this.b) == null) {
            return;
        }
        st5Var.n();
    }
}
