package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zr0 extends ls0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cs0 d;
    public is0 e;
    public hs0 f;
    public ds0 g;
    public bs0 h;

    public zr0() {
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
        hs0 hs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hs0Var = this.f) == null) {
            return;
        }
        hs0Var.b();
    }

    public void C() {
        hs0 hs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hs0Var = this.f) == null) {
            return;
        }
        hs0Var.a();
    }

    public void D(boolean z, boolean z2) {
        bs0 bs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (bs0Var = this.h) == null) {
            return;
        }
        bs0Var.a(z, z2);
    }

    public void E(boolean z) {
        is0 is0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (is0Var = this.e) == null) {
            return;
        }
        is0Var.a(z);
    }

    public void F(int i, int i2) {
        ds0 ds0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (ds0Var = this.g) == null) {
            return;
        }
        ds0Var.a(i, i2);
    }

    public void G(int i) {
        cs0 cs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (cs0Var = this.d) == null) {
            return;
        }
        cs0Var.a(i);
    }

    @Override // com.baidu.tieba.ms0
    public void b(ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ut0Var) == null) {
            super.b(ut0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ut0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ut0Var.c())) {
                C();
            }
        }
    }

    @Override // com.baidu.tieba.ls0, com.baidu.tieba.ms0
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
