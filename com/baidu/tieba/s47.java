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
public class s47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public n47 c;
    public k47 d;
    public l47 e;
    public o47 f;
    public p47 g;
    public m47 h;
    public t47 i;
    public u47 j;
    public r47 k;
    public q47 l;

    public s47(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.i();
        this.c = new n47(frsActivity, frsFragment);
        this.d = new k47(frsActivity, frsFragment);
        this.e = new l47(frsActivity, frsFragment);
        this.f = new o47(frsActivity, frsFragment);
        this.g = new p47(frsActivity, frsFragment);
        this.h = new m47(frsActivity, frsFragment);
        this.i = new t47(frsActivity, frsFragment);
        this.j = new u47(frsActivity, frsFragment);
        this.k = new r47(frsActivity, frsFragment);
        q47 q47Var = new q47(frsActivity, frsFragment);
        this.l = q47Var;
        n47 n47Var = this.c;
        PriorityOrganizer.n(n47Var, this.d, this.e, q47Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = n47Var;
    }

    public void a(boolean z) {
        p47 p47Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (p47Var = this.g) != null) {
            p47Var.F(z);
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
