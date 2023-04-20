package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ys0 extends kt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bt0 d;
    public ht0 e;
    public gt0 f;
    public ct0 g;
    public at0 h;

    public ys0() {
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
        gt0 gt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (gt0Var = this.f) != null) {
            gt0Var.b();
        }
    }

    public void C() {
        gt0 gt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (gt0Var = this.f) != null) {
            gt0Var.a();
        }
    }

    @Override // com.baidu.tieba.kt0, com.baidu.tieba.lt0
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
        at0 at0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (at0Var = this.h) != null) {
            at0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        ct0 ct0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (ct0Var = this.g) != null) {
            ct0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        ht0 ht0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ht0Var = this.e) != null) {
            ht0Var.a(z);
        }
    }

    public void G(int i) {
        bt0 bt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (bt0Var = this.d) != null) {
            bt0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.lt0
    public void b(tu0 tu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tu0Var) == null) {
            super.b(tu0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(tu0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(tu0Var.c())) {
                C();
            }
        }
    }
}
