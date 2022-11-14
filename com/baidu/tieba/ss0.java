package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ss0 extends et0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vs0 d;
    public bt0 e;
    public at0 f;
    public ws0 g;
    public us0 h;

    public ss0() {
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
        at0 at0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (at0Var = this.f) != null) {
            at0Var.b();
        }
    }

    public void C() {
        at0 at0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (at0Var = this.f) != null) {
            at0Var.a();
        }
    }

    @Override // com.baidu.tieba.et0, com.baidu.tieba.ft0
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
        us0 us0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (us0Var = this.h) != null) {
            us0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        ws0 ws0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (ws0Var = this.g) != null) {
            ws0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        bt0 bt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (bt0Var = this.e) != null) {
            bt0Var.a(z);
        }
    }

    public void G(int i) {
        vs0 vs0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (vs0Var = this.d) != null) {
            vs0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.ft0
    public void b(nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nu0Var) == null) {
            super.b(nu0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(nu0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(nu0Var.c())) {
                C();
            }
        }
    }
}
