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
/* loaded from: classes7.dex */
public class rf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<kn> c;
    public List<xn> d;
    public tg6 e;
    public xf6 f;

    public rf6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, tg6 tg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, tg6Var};
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
        this.e = tg6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qf6 qf6Var = new qf6(this.a);
            uf6 uf6Var = new uf6(this.a);
            vf6 vf6Var = new vf6(this.a);
            of6 of6Var = new of6(this.a);
            tf6 tf6Var = new tf6(this.a);
            wf6 wf6Var = new wf6(this.a);
            sf6 sf6Var = new sf6(this.a);
            pf6 pf6Var = new pf6(this.a);
            this.f = new xf6(this.a);
            zf6 zf6Var = new zf6(this.a, this.e);
            yf6 yf6Var = new yf6(this.a);
            this.c.add(qf6Var);
            this.c.add(this.f);
            this.c.add(uf6Var);
            this.c.add(vf6Var);
            this.c.add(of6Var);
            this.c.add(tf6Var);
            this.c.add(wf6Var);
            this.c.add(sf6Var);
            this.c.add(pf6Var);
            this.c.add(zf6Var);
            this.c.add(yf6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        xf6 xf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (xf6Var = this.f) != null) {
            xf6Var.B(str);
        }
    }

    public void d(String str) {
        xf6 xf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (xf6Var = this.f) != null) {
            xf6Var.a(str);
        }
    }

    public void e(String str) {
        xf6 xf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (xf6Var = this.f) != null) {
            xf6Var.C(str);
        }
    }

    public void f(boolean z) {
        xf6 xf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (xf6Var = this.f) != null) {
            xf6Var.D(z);
        }
    }
}
