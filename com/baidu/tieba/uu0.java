package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uu0 extends gv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xu0 d;
    public dv0 e;
    public cv0 f;
    public yu0 g;
    public wu0 h;

    public uu0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void B() {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cv0Var = this.f) != null) {
            cv0Var.b();
        }
    }

    public void C() {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cv0Var = this.f) != null) {
            cv0Var.a();
        }
    }

    @Override // com.baidu.tieba.gv0, com.baidu.tieba.hv0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.r();
            this.d = null;
            this.e = null;
            this.g = null;
            this.f = null;
            this.h = null;
        }
    }

    public void D(boolean z, boolean z2) {
        wu0 wu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (wu0Var = this.h) != null) {
            wu0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        yu0 yu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (yu0Var = this.g) != null) {
            yu0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        dv0 dv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (dv0Var = this.e) != null) {
            dv0Var.a(z);
        }
    }

    public void G(int i) {
        xu0 xu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (xu0Var = this.d) != null) {
            xu0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.hv0
    public void b(pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pw0Var) == null) {
            super.b(pw0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(pw0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(pw0Var.c())) {
                C();
            }
        }
    }
}
