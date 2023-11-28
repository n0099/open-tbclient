package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pq0 extends br0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sq0 d;
    public yq0 e;
    public xq0 f;
    public tq0 g;
    public rq0 h;

    public pq0() {
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
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xq0Var = this.f) != null) {
            xq0Var.b();
        }
    }

    public void C() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (xq0Var = this.f) != null) {
            xq0Var.a();
        }
    }

    @Override // com.baidu.tieba.br0, com.baidu.tieba.cr0
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
        rq0 rq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (rq0Var = this.h) != null) {
            rq0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (tq0Var = this.g) != null) {
            tq0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (yq0Var = this.e) != null) {
            yq0Var.a(z);
        }
    }

    public void G(int i) {
        sq0 sq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (sq0Var = this.d) != null) {
            sq0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.cr0
    public void b(ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ks0Var) == null) {
            super.b(ks0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ks0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ks0Var.c())) {
                C();
            }
        }
    }
}
