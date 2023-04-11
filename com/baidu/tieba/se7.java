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
public class se7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public ne7 c;
    public ke7 d;
    public le7 e;
    public oe7 f;
    public pe7 g;
    public me7 h;
    public te7 i;
    public ue7 j;
    public re7 k;
    public qe7 l;

    public se7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.l();
        this.c = new ne7(frsActivity, frsFragment);
        this.d = new ke7(frsActivity, frsFragment);
        this.e = new le7(frsActivity, frsFragment);
        this.f = new oe7(frsActivity, frsFragment);
        this.g = new pe7(frsActivity, frsFragment);
        this.h = new me7(frsActivity, frsFragment);
        this.i = new te7(frsActivity, frsFragment);
        this.j = new ue7(frsActivity, frsFragment);
        this.k = new re7(frsActivity, frsFragment);
        qe7 qe7Var = new qe7(frsActivity, frsFragment);
        this.l = qe7Var;
        ne7 ne7Var = this.c;
        PriorityOrganizer.r(ne7Var, this.d, this.e, qe7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = ne7Var;
    }

    public void a(boolean z) {
        pe7 pe7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (pe7Var = this.g) != null) {
            pe7Var.F(z);
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
