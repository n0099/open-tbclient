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
/* loaded from: classes6.dex */
public class jp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public ep7 c;
    public bp7 d;
    public cp7 e;
    public fp7 f;
    public gp7 g;
    public dp7 h;
    public kp7 i;
    public lp7 j;
    public ip7 k;
    public hp7 l;

    public jp7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.create();
        this.c = new ep7(frsActivity, frsFragment);
        this.d = new bp7(frsActivity, frsFragment);
        this.e = new cp7(frsActivity, frsFragment);
        this.f = new fp7(frsActivity, frsFragment);
        this.g = new gp7(frsActivity, frsFragment);
        this.h = new dp7(frsActivity, frsFragment);
        this.i = new kp7(frsActivity, frsFragment);
        this.j = new lp7(frsActivity, frsFragment);
        this.k = new ip7(frsActivity, frsFragment);
        hp7 hp7Var = new hp7(frsActivity, frsFragment);
        this.l = hp7Var;
        this.b = PriorityOrganizer.makeChain(this.c, this.d, this.e, hp7Var, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public void a(boolean z) {
        gp7 gp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (gp7Var = this.g) != null) {
            gp7Var.a(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !LooperBlockSwitch.getIsOn() && (task = this.b) != null && !task.isExecuting(true)) {
            this.b.reset(true);
            this.a.tryAdd(this.b);
        }
    }
}
