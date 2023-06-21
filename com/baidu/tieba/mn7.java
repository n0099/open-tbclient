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
public class mn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public hn7 c;
    public en7 d;
    public fn7 e;
    public in7 f;
    public jn7 g;
    public gn7 h;
    public nn7 i;
    public on7 j;
    public ln7 k;
    public kn7 l;

    public mn7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.c = new hn7(frsActivity, frsFragment);
        this.d = new en7(frsActivity, frsFragment);
        this.e = new fn7(frsActivity, frsFragment);
        this.f = new in7(frsActivity, frsFragment);
        this.g = new jn7(frsActivity, frsFragment);
        this.h = new gn7(frsActivity, frsFragment);
        this.i = new nn7(frsActivity, frsFragment);
        this.j = new on7(frsActivity, frsFragment);
        this.k = new ln7(frsActivity, frsFragment);
        kn7 kn7Var = new kn7(frsActivity, frsFragment);
        this.l = kn7Var;
        hn7 hn7Var = this.c;
        PriorityOrganizer.t(hn7Var, this.d, this.e, kn7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = hn7Var;
    }

    public void a(boolean z) {
        jn7 jn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (jn7Var = this.g) != null) {
            jn7Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !LooperBlockSwitch.getIsOn() && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.z(this.b);
        }
    }
}
