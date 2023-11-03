package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oq0 extends ar0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rq0 d;
    public xq0 e;
    public wq0 f;
    public sq0 g;
    public qq0 h;

    public oq0() {
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
        wq0 wq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (wq0Var = this.f) != null) {
            wq0Var.b();
        }
    }

    public void C() {
        wq0 wq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wq0Var = this.f) != null) {
            wq0Var.a();
        }
    }

    @Override // com.baidu.tieba.ar0, com.baidu.tieba.br0
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
        qq0 qq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (qq0Var = this.h) != null) {
            qq0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        sq0 sq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (sq0Var = this.g) != null) {
            sq0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (xq0Var = this.e) != null) {
            xq0Var.a(z);
        }
    }

    public void G(int i) {
        rq0 rq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (rq0Var = this.d) != null) {
            rq0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.br0
    public void b(js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, js0Var) == null) {
            super.b(js0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(js0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(js0Var.c())) {
                C();
            }
        }
    }
}
