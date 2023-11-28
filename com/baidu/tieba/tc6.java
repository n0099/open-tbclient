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
/* loaded from: classes8.dex */
public class tc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<ci> c;
    public List<pi> d;
    public vd6 e;
    public zc6 f;

    public tc6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, vd6 vd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, vd6Var};
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
        this.e = vd6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            sc6 sc6Var = new sc6(this.a);
            wc6 wc6Var = new wc6(this.a);
            xc6 xc6Var = new xc6(this.a);
            qc6 qc6Var = new qc6(this.a);
            vc6 vc6Var = new vc6(this.a);
            yc6 yc6Var = new yc6(this.a);
            uc6 uc6Var = new uc6(this.a);
            rc6 rc6Var = new rc6(this.a);
            this.f = new zc6(this.a);
            bd6 bd6Var = new bd6(this.a, this.e);
            ad6 ad6Var = new ad6(this.a);
            this.c.add(sc6Var);
            this.c.add(this.f);
            this.c.add(wc6Var);
            this.c.add(xc6Var);
            this.c.add(qc6Var);
            this.c.add(vc6Var);
            this.c.add(yc6Var);
            this.c.add(uc6Var);
            this.c.add(rc6Var);
            this.c.add(bd6Var);
            this.c.add(ad6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        zc6 zc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (zc6Var = this.f) != null) {
            zc6Var.C(str);
        }
    }

    public void d(String str) {
        zc6 zc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (zc6Var = this.f) != null) {
            zc6Var.a(str);
        }
    }

    public void e(String str) {
        zc6 zc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (zc6Var = this.f) != null) {
            zc6Var.D(str);
        }
    }

    public void f(boolean z) {
        zc6 zc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (zc6Var = this.f) != null) {
            zc6Var.E(z);
        }
    }
}
