package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class t17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public o17 c;
    public l17 d;
    public m17 e;
    public p17 f;
    public q17 g;
    public n17 h;
    public u17 i;
    public v17 j;
    public s17 k;
    public r17 l;

    public t17(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.g();
        this.c = new o17(frsActivity, frsFragment);
        this.d = new l17(frsActivity, frsFragment);
        this.e = new m17(frsActivity, frsFragment);
        this.f = new p17(frsActivity, frsFragment);
        this.g = new q17(frsActivity, frsFragment);
        this.h = new n17(frsActivity, frsFragment);
        this.i = new u17(frsActivity, frsFragment);
        this.j = new v17(frsActivity, frsFragment);
        this.k = new s17(frsActivity, frsFragment);
        r17 r17Var = new r17(frsActivity, frsFragment);
        this.l = r17Var;
        o17 o17Var = this.c;
        PriorityOrganizer.m(o17Var, this.d, this.e, r17Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = o17Var;
    }

    public void a(boolean z) {
        q17 q17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (q17Var = this.g) != null) {
            q17Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.t(this.b);
        }
    }
}
