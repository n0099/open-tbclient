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
public class us6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public os6 b;
    public ps6 c;
    public rs6 d;
    public ss6 e;
    public qs6 f;
    public vs6 g;
    public ws6 h;
    public ts6 i;

    public us6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.b = new os6(frsActivity, frsFragment);
        this.c = new ps6(frsActivity, frsFragment);
        this.d = new rs6(frsActivity, frsFragment);
        this.e = new ss6(frsActivity, frsFragment);
        this.f = new qs6(frsActivity, frsFragment);
        this.g = new vs6(frsActivity, frsFragment);
        this.h = new ws6(frsActivity, frsFragment);
        ts6 ts6Var = new ts6(frsActivity, frsFragment);
        this.i = ts6Var;
        PriorityOrganizer.s(this.b, this.c, this.d, this.e, this.f, this.g, this.h, ts6Var);
    }

    public void a(boolean z) {
        ss6 ss6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ss6Var = this.e) != null) {
            ss6Var.F(z);
        }
    }

    public void b() {
        os6 os6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (os6Var = this.b) != null && !os6Var.v(true)) {
            this.b.E(true);
            this.a.v(this.b);
        }
    }
}
