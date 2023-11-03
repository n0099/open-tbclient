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
public class kc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<bi> c;
    public List<oi> d;
    public md6 e;
    public qc6 f;

    public kc6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, md6 md6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, md6Var};
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
        this.e = md6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jc6 jc6Var = new jc6(this.a);
            nc6 nc6Var = new nc6(this.a);
            oc6 oc6Var = new oc6(this.a);
            hc6 hc6Var = new hc6(this.a);
            mc6 mc6Var = new mc6(this.a);
            pc6 pc6Var = new pc6(this.a);
            lc6 lc6Var = new lc6(this.a);
            ic6 ic6Var = new ic6(this.a);
            this.f = new qc6(this.a);
            sc6 sc6Var = new sc6(this.a, this.e);
            rc6 rc6Var = new rc6(this.a);
            this.c.add(jc6Var);
            this.c.add(this.f);
            this.c.add(nc6Var);
            this.c.add(oc6Var);
            this.c.add(hc6Var);
            this.c.add(mc6Var);
            this.c.add(pc6Var);
            this.c.add(lc6Var);
            this.c.add(ic6Var);
            this.c.add(sc6Var);
            this.c.add(rc6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        qc6 qc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (qc6Var = this.f) != null) {
            qc6Var.C(str);
        }
    }

    public void d(String str) {
        qc6 qc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (qc6Var = this.f) != null) {
            qc6Var.a(str);
        }
    }

    public void e(String str) {
        qc6 qc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (qc6Var = this.f) != null) {
            qc6Var.D(str);
        }
    }

    public void f(boolean z) {
        qc6 qc6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (qc6Var = this.f) != null) {
            qc6Var.E(z);
        }
    }
}
