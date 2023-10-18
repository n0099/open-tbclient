package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xp0 extends jq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aq0 d;
    public gq0 e;
    public fq0 f;
    public bq0 g;
    public zp0 h;

    public xp0() {
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
        fq0 fq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fq0Var = this.f) != null) {
            fq0Var.b();
        }
    }

    public void C() {
        fq0 fq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fq0Var = this.f) != null) {
            fq0Var.a();
        }
    }

    @Override // com.baidu.tieba.jq0, com.baidu.tieba.kq0
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
        zp0 zp0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (zp0Var = this.h) != null) {
            zp0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        bq0 bq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (bq0Var = this.g) != null) {
            bq0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        gq0 gq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (gq0Var = this.e) != null) {
            gq0Var.a(z);
        }
    }

    public void G(int i) {
        aq0 aq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (aq0Var = this.d) != null) {
            aq0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.kq0
    public void b(sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sr0Var) == null) {
            super.b(sr0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(sr0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(sr0Var.c())) {
                C();
            }
        }
    }
}
