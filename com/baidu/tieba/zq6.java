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
public class zq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public tq6 b;
    public uq6 c;
    public wq6 d;
    public xq6 e;
    public vq6 f;
    public ar6 g;
    public br6 h;
    public yq6 i;

    public zq6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.b = new tq6(frsActivity, frsFragment);
        this.c = new uq6(frsActivity, frsFragment);
        this.d = new wq6(frsActivity, frsFragment);
        this.e = new xq6(frsActivity, frsFragment);
        this.f = new vq6(frsActivity, frsFragment);
        this.g = new ar6(frsActivity, frsFragment);
        this.h = new br6(frsActivity, frsFragment);
        yq6 yq6Var = new yq6(frsActivity, frsFragment);
        this.i = yq6Var;
        PriorityOrganizer.s(this.b, this.c, this.d, this.e, this.f, this.g, this.h, yq6Var);
    }

    public void a(boolean z) {
        xq6 xq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (xq6Var = this.e) != null) {
            xq6Var.F(z);
        }
    }

    public void b() {
        tq6 tq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tq6Var = this.b) != null && !tq6Var.v(true)) {
            this.b.E(true);
            this.a.v(this.b);
        }
    }
}
