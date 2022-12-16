package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rs0 extends dt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public us0 d;
    public at0 e;
    public zs0 f;
    public vs0 g;
    public ts0 h;

    public rs0() {
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
        zs0 zs0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (zs0Var = this.f) != null) {
            zs0Var.b();
        }
    }

    public void C() {
        zs0 zs0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zs0Var = this.f) != null) {
            zs0Var.a();
        }
    }

    @Override // com.baidu.tieba.dt0, com.baidu.tieba.et0
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
        ts0 ts0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (ts0Var = this.h) != null) {
            ts0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        vs0 vs0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (vs0Var = this.g) != null) {
            vs0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        at0 at0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (at0Var = this.e) != null) {
            at0Var.a(z);
        }
    }

    public void G(int i) {
        us0 us0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (us0Var = this.d) != null) {
            us0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.et0
    public void b(mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mu0Var) == null) {
            super.b(mu0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(mu0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(mu0Var.c())) {
                C();
            }
        }
    }
}
