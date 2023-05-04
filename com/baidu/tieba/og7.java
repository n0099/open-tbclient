package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class og7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public jg7 c;
    public gg7 d;
    public hg7 e;
    public kg7 f;
    public lg7 g;
    public ig7 h;
    public pg7 i;
    public qg7 j;
    public ng7 k;
    public mg7 l;

    public og7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.o();
        this.c = new jg7(frsActivity, frsFragment);
        this.d = new gg7(frsActivity, frsFragment);
        this.e = new hg7(frsActivity, frsFragment);
        this.f = new kg7(frsActivity, frsFragment);
        this.g = new lg7(frsActivity, frsFragment);
        this.h = new ig7(frsActivity, frsFragment);
        this.i = new pg7(frsActivity, frsFragment);
        this.j = new qg7(frsActivity, frsFragment);
        this.k = new ng7(frsActivity, frsFragment);
        mg7 mg7Var = new mg7(frsActivity, frsFragment);
        this.l = mg7Var;
        jg7 jg7Var = this.c;
        PriorityOrganizer.u(jg7Var, this.d, this.e, mg7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = jg7Var;
    }

    public void a(boolean z) {
        lg7 lg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (lg7Var = this.g) != null) {
            lg7Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !LooperBlockSwitch.getIsOn() && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.A(this.b);
        }
    }
}
