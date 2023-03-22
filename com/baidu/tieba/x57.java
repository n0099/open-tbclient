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
public class x57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public s57 c;
    public p57 d;
    public q57 e;
    public t57 f;
    public u57 g;
    public r57 h;
    public y57 i;
    public z57 j;
    public w57 k;
    public v57 l;

    public x57(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.h();
        this.c = new s57(frsActivity, frsFragment);
        this.d = new p57(frsActivity, frsFragment);
        this.e = new q57(frsActivity, frsFragment);
        this.f = new t57(frsActivity, frsFragment);
        this.g = new u57(frsActivity, frsFragment);
        this.h = new r57(frsActivity, frsFragment);
        this.i = new y57(frsActivity, frsFragment);
        this.j = new z57(frsActivity, frsFragment);
        this.k = new w57(frsActivity, frsFragment);
        v57 v57Var = new v57(frsActivity, frsFragment);
        this.l = v57Var;
        s57 s57Var = this.c;
        PriorityOrganizer.n(s57Var, this.d, this.e, v57Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = s57Var;
    }

    public void a(boolean z) {
        u57 u57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (u57Var = this.g) != null) {
            u57Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.u(this.b);
        }
    }
}
