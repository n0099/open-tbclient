package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rq0 extends dr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uq0 d;
    public ar0 e;
    public zq0 f;
    public vq0 g;
    public tq0 h;

    public rq0() {
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
        zq0 zq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (zq0Var = this.f) != null) {
            zq0Var.b();
        }
    }

    public void C() {
        zq0 zq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zq0Var = this.f) != null) {
            zq0Var.a();
        }
    }

    @Override // com.baidu.tieba.dr0, com.baidu.tieba.er0
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
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (tq0Var = this.h) != null) {
            tq0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        vq0 vq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (vq0Var = this.g) != null) {
            vq0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        ar0 ar0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ar0Var = this.e) != null) {
            ar0Var.a(z);
        }
    }

    public void G(int i) {
        uq0 uq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (uq0Var = this.d) != null) {
            uq0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.er0
    public void b(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ms0Var) == null) {
            super.b(ms0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ms0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ms0Var.c())) {
                C();
            }
        }
    }
}
