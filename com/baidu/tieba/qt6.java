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
public class qt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public kt6 b;
    public lt6 c;
    public nt6 d;
    public ot6 e;
    public mt6 f;
    public rt6 g;
    public st6 h;
    public pt6 i;

    public qt6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.b = new kt6(frsActivity, frsFragment);
        this.c = new lt6(frsActivity, frsFragment);
        this.d = new nt6(frsActivity, frsFragment);
        this.e = new ot6(frsActivity, frsFragment);
        this.f = new mt6(frsActivity, frsFragment);
        this.g = new rt6(frsActivity, frsFragment);
        this.h = new st6(frsActivity, frsFragment);
        pt6 pt6Var = new pt6(frsActivity, frsFragment);
        this.i = pt6Var;
        PriorityOrganizer.m(this.b, this.c, this.d, this.e, this.f, this.g, this.h, pt6Var);
    }

    public void a(boolean z) {
        ot6 ot6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ot6Var = this.e) != null) {
            ot6Var.F(z);
        }
    }

    public void b() {
        kt6 kt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (kt6Var = this.b) != null && !kt6Var.v(true)) {
            this.b.E(true);
            this.a.t(this.b);
        }
    }
}
