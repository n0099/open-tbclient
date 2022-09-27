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
public class tq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public mq6 b;
    public nq6 c;
    public pq6 d;
    public qq6 e;
    public oq6 f;
    public uq6 g;
    public vq6 h;
    public rq6 i;
    public sq6 j;

    public tq6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.b = new mq6(frsActivity, frsFragment);
        this.c = new nq6(frsActivity, frsFragment);
        this.d = new pq6(frsActivity, frsFragment);
        this.e = new qq6(frsActivity, frsFragment);
        this.f = new oq6(frsActivity, frsFragment);
        this.g = new uq6(frsActivity, frsFragment);
        this.h = new vq6(frsActivity, frsFragment);
        this.i = new rq6(frsActivity, frsFragment);
        sq6 sq6Var = new sq6(frsActivity, frsFragment);
        this.j = sq6Var;
        PriorityOrganizer.s(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, sq6Var);
    }

    public void a(boolean z) {
        qq6 qq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (qq6Var = this.e) == null) {
            return;
        }
        qq6Var.H(z);
    }

    public void b() {
        mq6 mq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mq6Var = this.b) == null || mq6Var.w(true)) {
            return;
        }
        this.b.F(true);
        this.a.v(this.b);
    }
}
