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
public class se6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public BdTypeListView b;
    public final List<pm> c;
    public re6 d;
    public oe6 e;
    public me6 f;
    public ne6 g;

    public se6(BdPageContext bdPageContext, BdTypeListView bdTypeListView, boolean z) {
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
                oe6 oe6Var = new oe6((TbPageContext) this.a, hf6.c);
                this.e = oe6Var;
                this.c.add(oe6Var);
            } else {
                re6 re6Var = new re6((TbPageContext) this.a, hf6.c);
                this.d = re6Var;
                this.c.add(re6Var);
            }
            this.f = new me6((TbPageContext) this.a, ue6.a);
            this.g = new ne6((TbPageContext) this.a, ve6.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.addAdapters(this.c);
        }
    }

    public void b(fb6 fb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fb6Var) == null) {
            re6 re6Var = this.d;
            if (re6Var != null) {
                re6Var.u(fb6Var);
            }
            oe6 oe6Var = this.e;
            if (oe6Var != null) {
                oe6Var.u(fb6Var);
            }
        }
    }

    public void c(List<cn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
