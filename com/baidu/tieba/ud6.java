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
/* loaded from: classes8.dex */
public class ud6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public BdTypeListView b;
    public final List<om> c;
    public td6 d;
    public qd6 e;
    public od6 f;
    public pd6 g;

    public ud6(BdPageContext bdPageContext, BdTypeListView bdTypeListView, boolean z) {
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
                qd6 qd6Var = new qd6((TbPageContext) this.a, je6.c);
                this.e = qd6Var;
                this.c.add(qd6Var);
            } else {
                td6 td6Var = new td6((TbPageContext) this.a, je6.c);
                this.d = td6Var;
                this.c.add(td6Var);
            }
            this.f = new od6((TbPageContext) this.a, wd6.a);
            this.g = new pd6((TbPageContext) this.a, xd6.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.addAdapters(this.c);
        }
    }

    public void b(ha6 ha6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha6Var) == null) {
            td6 td6Var = this.d;
            if (td6Var != null) {
                td6Var.u(ha6Var);
            }
            qd6 qd6Var = this.e;
            if (qd6Var != null) {
                qd6Var.u(ha6Var);
            }
        }
    }

    public void c(List<bn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
