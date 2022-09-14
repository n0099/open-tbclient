package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mr0 extends yr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pr0 d;
    public vr0 e;
    public ur0 f;
    public qr0 g;
    public or0 h;

    public mr0() {
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
        ur0 ur0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ur0Var = this.f) == null) {
            return;
        }
        ur0Var.b();
    }

    public void C() {
        ur0 ur0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ur0Var = this.f) == null) {
            return;
        }
        ur0Var.a();
    }

    public void D(boolean z, boolean z2) {
        or0 or0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (or0Var = this.h) == null) {
            return;
        }
        or0Var.a(z, z2);
    }

    public void E(boolean z) {
        vr0 vr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (vr0Var = this.e) == null) {
            return;
        }
        vr0Var.a(z);
    }

    public void F(int i, int i2) {
        qr0 qr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (qr0Var = this.g) == null) {
            return;
        }
        qr0Var.a(i, i2);
    }

    public void G(int i) {
        pr0 pr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (pr0Var = this.d) == null) {
            return;
        }
        pr0Var.a(i);
    }

    @Override // com.baidu.tieba.zr0
    public void b(ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ht0Var) == null) {
            super.b(ht0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ht0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ht0Var.c())) {
                C();
            }
        }
    }

    @Override // com.baidu.tieba.yr0, com.baidu.tieba.zr0
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
}
