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
/* loaded from: classes9.dex */
public class xc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<ci> c;
    public List<pi> d;
    public zd6 e;
    public dd6 f;

    public xc6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, zd6 zd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, zd6Var};
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
        this.e = zd6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            wc6 wc6Var = new wc6(this.a);
            ad6 ad6Var = new ad6(this.a);
            bd6 bd6Var = new bd6(this.a);
            uc6 uc6Var = new uc6(this.a);
            zc6 zc6Var = new zc6(this.a);
            cd6 cd6Var = new cd6(this.a);
            yc6 yc6Var = new yc6(this.a);
            vc6 vc6Var = new vc6(this.a);
            this.f = new dd6(this.a);
            fd6 fd6Var = new fd6(this.a, this.e);
            ed6 ed6Var = new ed6(this.a);
            this.c.add(wc6Var);
            this.c.add(this.f);
            this.c.add(ad6Var);
            this.c.add(bd6Var);
            this.c.add(uc6Var);
            this.c.add(zc6Var);
            this.c.add(cd6Var);
            this.c.add(yc6Var);
            this.c.add(vc6Var);
            this.c.add(fd6Var);
            this.c.add(ed6Var);
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
        dd6 dd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (dd6Var = this.f) != null) {
            dd6Var.C(str);
        }
    }

    public void d(String str) {
        dd6 dd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (dd6Var = this.f) != null) {
            dd6Var.a(str);
        }
    }

    public void e(String str) {
        dd6 dd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (dd6Var = this.f) != null) {
            dd6Var.D(str);
        }
    }

    public void f(boolean z) {
        dd6 dd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (dd6Var = this.f) != null) {
            dd6Var.E(z);
        }
    }
}
