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
public class rd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public final List<om> b;
    public BdTypeMultiColumnListView c;
    public sd6 d;
    public vd6 e;

    public rd6(BdPageContext bdPageContext, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
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
            this.d = new sd6((TbPageContext) this.a, yd6.b);
            this.e = new vd6((TbPageContext) this.a, yd6.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.c.addAdapters(this.b);
        }
    }

    public void b(ha6 ha6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha6Var) == null) {
            sd6 sd6Var = this.d;
            if (sd6Var != null) {
                sd6Var.u(ha6Var);
            }
            vd6 vd6Var = this.e;
            if (vd6Var != null) {
                vd6Var.u(ha6Var);
            }
        }
    }

    public void c(List<bn> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeMultiColumnListView = this.c) != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
