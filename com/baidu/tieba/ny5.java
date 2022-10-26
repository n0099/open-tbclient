package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ny5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List c;
    public List d;
    public pz5 e;
    public ty5 f;

    public ny5(TbPageContext tbPageContext, BdTypeListView bdTypeListView, pz5 pz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, pz5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = bdTypeListView;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = pz5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            my5 my5Var = new my5(this.a);
            qy5 qy5Var = new qy5(this.a);
            ry5 ry5Var = new ry5(this.a);
            ky5 ky5Var = new ky5(this.a);
            py5 py5Var = new py5(this.a);
            sy5 sy5Var = new sy5(this.a);
            oy5 oy5Var = new oy5(this.a);
            ly5 ly5Var = new ly5(this.a);
            this.f = new ty5(this.a);
            vy5 vy5Var = new vy5(this.a, this.e);
            uy5 uy5Var = new uy5(this.a);
            this.c.add(my5Var);
            this.c.add(this.f);
            this.c.add(qy5Var);
            this.c.add(ry5Var);
            this.c.add(ky5Var);
            this.c.add(py5Var);
            this.c.add(sy5Var);
            this.c.add(oy5Var);
            this.c.add(ly5Var);
            this.c.add(vy5Var);
            this.c.add(uy5Var);
            this.b.a(this.c);
        }
    }

    public void b(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        ty5 ty5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (ty5Var = this.f) != null) {
            ty5Var.D(str);
        }
    }

    public void d(String str) {
        ty5 ty5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (ty5Var = this.f) != null) {
            ty5Var.a(str);
        }
    }

    public void e(String str) {
        ty5 ty5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (ty5Var = this.f) != null) {
            ty5Var.E(str);
        }
    }

    public void f(boolean z) {
        ty5 ty5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (ty5Var = this.f) != null) {
            ty5Var.F(z);
        }
    }
}
