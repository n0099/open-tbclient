package com.baidu.tieba;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class rz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r9 a;
    public final List<kn> b;
    public BdTypeMultiColumnListView c;
    public sz5 d;
    public vz5 e;

    public rz5(r9 r9Var, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, bdTypeMultiColumnListView};
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
        this.a = r9Var;
        this.c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new sz5((TbPageContext) this.a, yz5.b);
            this.e = new vz5((TbPageContext) this.a, yz5.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.c.addAdapters(this.b);
        }
    }

    public void b(hw5 hw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hw5Var) == null) {
            sz5 sz5Var = this.d;
            if (sz5Var != null) {
                sz5Var.u(hw5Var);
            }
            vz5 vz5Var = this.e;
            if (vz5Var != null) {
                vz5Var.u(hw5Var);
            }
        }
    }

    public void c(List<xn> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeMultiColumnListView = this.c) != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
