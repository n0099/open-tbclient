package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class sc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public BdTypeListView b;
    public final List<lm> c;
    public rc6 d;
    public oc6 e;
    public mc6 f;
    public nc6 g;

    public sc6(BdPageContext bdPageContext, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = bdPageContext;
        this.b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                oc6 oc6Var = new oc6((TbPageContext) this.a, hd6.c);
                this.e = oc6Var;
                this.c.add(oc6Var);
            } else {
                rc6 rc6Var = new rc6((TbPageContext) this.a, hd6.c);
                this.d = rc6Var;
                this.c.add(rc6Var);
            }
            this.f = new mc6((TbPageContext) this.a, uc6.a);
            this.g = new nc6((TbPageContext) this.a, vc6.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.addAdapters(this.c);
        }
    }

    public void b(f96 f96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f96Var) == null) {
            rc6 rc6Var = this.d;
            if (rc6Var != null) {
                rc6Var.u(f96Var);
            }
            oc6 oc6Var = this.e;
            if (oc6Var != null) {
                oc6Var.u(f96Var);
            }
        }
    }

    public void c(List<ym> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
