package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ns7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public is7 a;
    public fs7 b;
    public gs7 c;
    public js7 d;
    public ks7 e;
    public hs7 f;
    public os7 g;
    public ps7 h;
    public ms7 i;
    public ls7 j;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public ns7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        PriorityOrganizer.create();
        this.a = new is7(frsActivity, frsFragment);
        this.b = new fs7(frsActivity, frsFragment);
        this.c = new gs7(frsActivity, frsFragment);
        this.d = new js7(frsActivity, frsFragment);
        this.e = new ks7(frsActivity, frsFragment);
        this.f = new hs7(frsActivity, frsFragment);
        this.g = new os7(frsActivity, frsFragment);
        this.h = new ps7(frsActivity, frsFragment);
        this.i = new ms7(frsActivity, frsFragment);
        ls7 ls7Var = new ls7(frsActivity, frsFragment);
        this.j = ls7Var;
        PriorityOrganizer.makeChain(this.a, this.b, this.c, ls7Var, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public void a(boolean z) {
        ks7 ks7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ks7Var = this.e) != null) {
            ks7Var.a(z);
        }
    }
}
