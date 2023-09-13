package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pe6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public final List<pm> b;
    public BdTypeMultiColumnListView c;
    public qe6 d;
    public te6 e;

    public pe6(BdPageContext bdPageContext, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = bdPageContext;
        this.c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new qe6((TbPageContext) this.a, we6.b);
            this.e = new te6((TbPageContext) this.a, we6.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.c.addAdapters(this.b);
        }
    }

    public void b(fb6 fb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fb6Var) == null) {
            qe6 qe6Var = this.d;
            if (qe6Var != null) {
                qe6Var.u(fb6Var);
            }
            te6 te6Var = this.e;
            if (te6Var != null) {
                te6Var.u(fb6Var);
            }
        }
    }

    public void c(List<cn> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeMultiColumnListView = this.c) != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
