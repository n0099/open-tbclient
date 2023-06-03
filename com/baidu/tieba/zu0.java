package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zu0 extends lv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cv0 d;
    public iv0 e;
    public hv0 f;
    public dv0 g;
    public bv0 h;

    public zu0() {
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
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hv0Var = this.f) != null) {
            hv0Var.b();
        }
    }

    public void C() {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hv0Var = this.f) != null) {
            hv0Var.a();
        }
    }

    @Override // com.baidu.tieba.lv0, com.baidu.tieba.mv0
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
        bv0 bv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (bv0Var = this.h) != null) {
            bv0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        dv0 dv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (dv0Var = this.g) != null) {
            dv0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (iv0Var = this.e) != null) {
            iv0Var.a(z);
        }
    }

    public void G(int i) {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (cv0Var = this.d) != null) {
            cv0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.mv0
    public void b(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uw0Var) == null) {
            super.b(uw0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(uw0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(uw0Var.c())) {
                C();
            }
        }
    }
}
