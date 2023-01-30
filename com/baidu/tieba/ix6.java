package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.ic5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ix6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public dx6 c;
    public ax6 d;
    public bx6 e;
    public ex6 f;
    public fx6 g;
    public cx6 h;
    public jx6 i;
    public kx6 j;
    public hx6 k;
    public gx6 l;

    public ix6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.c = new dx6(frsActivity, frsFragment);
        this.d = new ax6(frsActivity, frsFragment);
        this.e = new bx6(frsActivity, frsFragment);
        this.f = new ex6(frsActivity, frsFragment);
        this.g = new fx6(frsActivity, frsFragment);
        this.h = new cx6(frsActivity, frsFragment);
        this.i = new jx6(frsActivity, frsFragment);
        this.j = new kx6(frsActivity, frsFragment);
        this.k = new hx6(frsActivity, frsFragment);
        gx6 gx6Var = new gx6(frsActivity, frsFragment);
        this.l = gx6Var;
        dx6 dx6Var = this.c;
        PriorityOrganizer.m(dx6Var, this.d, this.e, gx6Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = dx6Var;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            fx6 fx6Var = this.g;
            if (fx6Var != null) {
                fx6Var.F(z);
            }
            c();
        }
    }

    public void b(ic5.b bVar) {
        gx6 gx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (gx6Var = this.l) != null) {
            gx6Var.F(bVar);
        }
    }

    public void c() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.t(this.b);
        }
    }
}
