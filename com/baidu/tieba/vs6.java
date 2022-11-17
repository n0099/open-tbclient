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
public class vs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public ps6 b;
    public qs6 c;
    public ss6 d;
    public ts6 e;
    public rs6 f;
    public ws6 g;
    public xs6 h;
    public us6 i;

    public vs6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.n();
        this.b = new ps6(frsActivity, frsFragment);
        this.c = new qs6(frsActivity, frsFragment);
        this.d = new ss6(frsActivity, frsFragment);
        this.e = new ts6(frsActivity, frsFragment);
        this.f = new rs6(frsActivity, frsFragment);
        this.g = new ws6(frsActivity, frsFragment);
        this.h = new xs6(frsActivity, frsFragment);
        us6 us6Var = new us6(frsActivity, frsFragment);
        this.i = us6Var;
        PriorityOrganizer.s(this.b, this.c, this.d, this.e, this.f, this.g, this.h, us6Var);
    }

    public void a(boolean z) {
        ts6 ts6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ts6Var = this.e) != null) {
            ts6Var.F(z);
        }
    }

    public void b() {
        ps6 ps6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ps6Var = this.b) != null && !ps6Var.v(true)) {
            this.b.E(true);
            this.a.v(this.b);
        }
    }
}
