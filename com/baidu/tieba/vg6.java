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
public class vg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<ln> c;
    public List<yn> d;
    public xh6 e;
    public bh6 f;

    public vg6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, xh6 xh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, xh6Var};
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
        this.e = xh6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ug6 ug6Var = new ug6(this.a);
            yg6 yg6Var = new yg6(this.a);
            zg6 zg6Var = new zg6(this.a);
            sg6 sg6Var = new sg6(this.a);
            xg6 xg6Var = new xg6(this.a);
            ah6 ah6Var = new ah6(this.a);
            wg6 wg6Var = new wg6(this.a);
            tg6 tg6Var = new tg6(this.a);
            this.f = new bh6(this.a);
            dh6 dh6Var = new dh6(this.a, this.e);
            ch6 ch6Var = new ch6(this.a);
            this.c.add(ug6Var);
            this.c.add(this.f);
            this.c.add(yg6Var);
            this.c.add(zg6Var);
            this.c.add(sg6Var);
            this.c.add(xg6Var);
            this.c.add(ah6Var);
            this.c.add(wg6Var);
            this.c.add(tg6Var);
            this.c.add(dh6Var);
            this.c.add(ch6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        bh6 bh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (bh6Var = this.f) != null) {
            bh6Var.B(str);
        }
    }

    public void d(String str) {
        bh6 bh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (bh6Var = this.f) != null) {
            bh6Var.a(str);
        }
    }

    public void e(String str) {
        bh6 bh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (bh6Var = this.f) != null) {
            bh6Var.C(str);
        }
    }

    public void f(boolean z) {
        bh6 bh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (bh6Var = this.f) != null) {
            bh6Var.D(z);
        }
    }
}
