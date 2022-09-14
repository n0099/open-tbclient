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
/* loaded from: classes6.dex */
public class tx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<qn> c;
    public List<Cdo> d;
    public vy5 e;
    public zx5 f;

    public tx5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, vy5 vy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, vy5Var};
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
        this.e = vy5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            sx5 sx5Var = new sx5(this.a);
            wx5 wx5Var = new wx5(this.a);
            xx5 xx5Var = new xx5(this.a);
            qx5 qx5Var = new qx5(this.a);
            vx5 vx5Var = new vx5(this.a);
            yx5 yx5Var = new yx5(this.a);
            ux5 ux5Var = new ux5(this.a);
            rx5 rx5Var = new rx5(this.a);
            this.f = new zx5(this.a);
            by5 by5Var = new by5(this.a, this.e);
            ay5 ay5Var = new ay5(this.a);
            this.c.add(sx5Var);
            this.c.add(this.f);
            this.c.add(wx5Var);
            this.c.add(xx5Var);
            this.c.add(qx5Var);
            this.c.add(vx5Var);
            this.c.add(yx5Var);
            this.c.add(ux5Var);
            this.c.add(rx5Var);
            this.c.add(by5Var);
            this.c.add(ay5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (zx5Var = this.f) == null) {
            return;
        }
        zx5Var.D(str);
    }

    public void d(String str) {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (zx5Var = this.f) == null) {
            return;
        }
        zx5Var.a(str);
    }

    public void e(String str) {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (zx5Var = this.f) == null) {
            return;
        }
        zx5Var.E(str);
    }

    public void f(boolean z) {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (zx5Var = this.f) == null) {
            return;
        }
        zx5Var.F(z);
    }
}
