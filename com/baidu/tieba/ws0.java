package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ws0 extends it0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zs0 d;
    public ft0 e;
    public et0 f;
    public at0 g;
    public ys0 h;

    public ws0() {
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
        et0 et0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (et0Var = this.f) != null) {
            et0Var.b();
        }
    }

    public void C() {
        et0 et0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (et0Var = this.f) != null) {
            et0Var.a();
        }
    }

    @Override // com.baidu.tieba.it0, com.baidu.tieba.jt0
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
        ys0 ys0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (ys0Var = this.h) != null) {
            ys0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        at0 at0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (at0Var = this.g) != null) {
            at0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        ft0 ft0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ft0Var = this.e) != null) {
            ft0Var.a(z);
        }
    }

    public void G(int i) {
        zs0 zs0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (zs0Var = this.d) != null) {
            zs0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.jt0
    public void b(ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ru0Var) == null) {
            super.b(ru0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ru0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ru0Var.c())) {
                C();
            }
        }
    }
}
