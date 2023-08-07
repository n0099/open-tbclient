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
public class ip7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public dp7 c;
    public ap7 d;
    public bp7 e;
    public ep7 f;
    public fp7 g;
    public cp7 h;
    public jp7 i;
    public kp7 j;
    public hp7 k;
    public gp7 l;

    public ip7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.c = new dp7(frsActivity, frsFragment);
        this.d = new ap7(frsActivity, frsFragment);
        this.e = new bp7(frsActivity, frsFragment);
        this.f = new ep7(frsActivity, frsFragment);
        this.g = new fp7(frsActivity, frsFragment);
        this.h = new cp7(frsActivity, frsFragment);
        this.i = new jp7(frsActivity, frsFragment);
        this.j = new kp7(frsActivity, frsFragment);
        this.k = new hp7(frsActivity, frsFragment);
        gp7 gp7Var = new gp7(frsActivity, frsFragment);
        this.l = gp7Var;
        this.b = PriorityOrganizer.makeChain(this.c, this.d, this.e, gp7Var, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public void a(boolean z) {
        fp7 fp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (fp7Var = this.g) != null) {
            fp7Var.a(z);
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
