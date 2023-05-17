package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qt0 extends cu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tt0 d;
    public zt0 e;
    public yt0 f;
    public ut0 g;
    public st0 h;

    public qt0() {
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
        yt0 yt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (yt0Var = this.f) != null) {
            yt0Var.b();
        }
    }

    public void C() {
        yt0 yt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (yt0Var = this.f) != null) {
            yt0Var.a();
        }
    }

    @Override // com.baidu.tieba.cu0, com.baidu.tieba.du0
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
        st0 st0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (st0Var = this.h) != null) {
            st0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        ut0 ut0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (ut0Var = this.g) != null) {
            ut0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        zt0 zt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (zt0Var = this.e) != null) {
            zt0Var.a(z);
        }
    }

    public void G(int i) {
        tt0 tt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (tt0Var = this.d) != null) {
            tt0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.du0
    public void b(lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lv0Var) == null) {
            super.b(lv0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(lv0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(lv0Var.c())) {
                C();
            }
        }
    }
}
