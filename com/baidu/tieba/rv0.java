package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rv0 extends dw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uv0 d;
    public aw0 e;
    public zv0 f;
    public vv0 g;
    public tv0 h;

    public rv0() {
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
        zv0 zv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (zv0Var = this.f) != null) {
            zv0Var.b();
        }
    }

    public void C() {
        zv0 zv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zv0Var = this.f) != null) {
            zv0Var.a();
        }
    }

    @Override // com.baidu.tieba.dw0, com.baidu.tieba.ew0
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
        tv0 tv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (tv0Var = this.h) != null) {
            tv0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        vv0 vv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (vv0Var = this.g) != null) {
            vv0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        aw0 aw0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (aw0Var = this.e) != null) {
            aw0Var.a(z);
        }
    }

    public void G(int i) {
        uv0 uv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (uv0Var = this.d) != null) {
            uv0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.ew0
    public void b(mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mx0Var) == null) {
            super.b(mx0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(mx0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(mx0Var.c())) {
                C();
            }
        }
    }
}
