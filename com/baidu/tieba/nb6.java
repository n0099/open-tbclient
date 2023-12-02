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
public class nb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public BdTypeListView b;
    public final List<ci> c;
    public mb6 d;
    public jb6 e;
    public hb6 f;
    public ib6 g;

    public nb6(BdPageContext bdPageContext, BdTypeListView bdTypeListView, boolean z) {
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
                jb6 jb6Var = new jb6((TbPageContext) this.a, cc6.c);
                this.e = jb6Var;
                this.c.add(jb6Var);
            } else {
                mb6 mb6Var = new mb6((TbPageContext) this.a, cc6.c);
                this.d = mb6Var;
                this.c.add(mb6Var);
            }
            this.f = new hb6((TbPageContext) this.a, pb6.a);
            this.g = new ib6((TbPageContext) this.a, qb6.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.addAdapters(this.c);
        }
    }

    public void b(z76 z76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z76Var) == null) {
            mb6 mb6Var = this.d;
            if (mb6Var != null) {
                mb6Var.x(z76Var);
            }
            jb6 jb6Var = this.e;
            if (jb6Var != null) {
                jb6Var.x(z76Var);
            }
        }
    }

    public void c(List<pi> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
