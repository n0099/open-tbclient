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
public class te7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public oe7 c;
    public le7 d;
    public me7 e;
    public pe7 f;
    public qe7 g;
    public ne7 h;
    public ue7 i;
    public ve7 j;
    public se7 k;
    public re7 l;

    public te7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.c = new oe7(frsActivity, frsFragment);
        this.d = new le7(frsActivity, frsFragment);
        this.e = new me7(frsActivity, frsFragment);
        this.f = new pe7(frsActivity, frsFragment);
        this.g = new qe7(frsActivity, frsFragment);
        this.h = new ne7(frsActivity, frsFragment);
        this.i = new ue7(frsActivity, frsFragment);
        this.j = new ve7(frsActivity, frsFragment);
        this.k = new se7(frsActivity, frsFragment);
        this.l = new re7(frsActivity, frsFragment);
        if (LooperBlockSwitch.getIsOn()) {
            oe7 oe7Var = this.c;
            PriorityOrganizer.r(oe7Var, new PriorityOrganizer.Task[0]);
            this.b = oe7Var;
            return;
        }
        oe7 oe7Var2 = this.c;
        PriorityOrganizer.r(oe7Var2, this.d, this.e, this.l, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = oe7Var2;
    }

    public void a(boolean z) {
        qe7 qe7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (qe7Var = this.g) != null) {
            qe7Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.w(this.b);
        }
    }
}
