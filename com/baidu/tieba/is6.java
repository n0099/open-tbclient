package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class is6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public cs6 b;
    public ds6 c;
    public fs6 d;
    public gs6 e;
    public es6 f;
    public js6 g;
    public ks6 h;
    public hs6 i;

    public is6(FrsActivity frsActivity, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity, frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = PriorityOrganizer.n();
        this.b = new cs6(frsActivity, frsFragment);
        this.c = new ds6(frsActivity, frsFragment);
        this.d = new fs6(frsActivity, frsFragment);
        this.e = new gs6(frsActivity, frsFragment);
        this.f = new es6(frsActivity, frsFragment);
        this.g = new js6(frsActivity, frsFragment);
        this.h = new ks6(frsActivity, frsFragment);
        hs6 hs6Var = new hs6(frsActivity, frsFragment);
        this.i = hs6Var;
        PriorityOrganizer.s(this.b, this.c, this.d, this.e, this.f, this.g, this.h, hs6Var);
    }

    public void a(boolean z) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (gs6Var = this.e) != null) {
            gs6Var.F(z);
        }
    }

    public void b() {
        cs6 cs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cs6Var = this.b) != null && !cs6Var.v(true)) {
            this.b.E(true);
            this.a.v(this.b);
        }
    }
}
