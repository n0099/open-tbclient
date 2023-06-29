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
/* loaded from: classes7.dex */
public class rn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public mn7 c;
    public jn7 d;
    public kn7 e;
    public nn7 f;
    public on7 g;
    public ln7 h;
    public sn7 i;
    public tn7 j;
    public qn7 k;
    public pn7 l;

    public rn7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.m();
        this.c = new mn7(frsActivity, frsFragment);
        this.d = new jn7(frsActivity, frsFragment);
        this.e = new kn7(frsActivity, frsFragment);
        this.f = new nn7(frsActivity, frsFragment);
        this.g = new on7(frsActivity, frsFragment);
        this.h = new ln7(frsActivity, frsFragment);
        this.i = new sn7(frsActivity, frsFragment);
        this.j = new tn7(frsActivity, frsFragment);
        this.k = new qn7(frsActivity, frsFragment);
        pn7 pn7Var = new pn7(frsActivity, frsFragment);
        this.l = pn7Var;
        mn7 mn7Var = this.c;
        PriorityOrganizer.t(mn7Var, this.d, this.e, pn7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = mn7Var;
    }

    public void a(boolean z) {
        on7 on7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (on7Var = this.g) != null) {
            on7Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !LooperBlockSwitch.getIsOn() && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.w(this.b);
        }
    }
}
