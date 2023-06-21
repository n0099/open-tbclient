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
public class mf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<jn> c;
    public List<wn> d;
    public og6 e;
    public sf6 f;

    public mf6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, og6 og6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, og6Var};
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
        this.e = og6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            lf6 lf6Var = new lf6(this.a);
            pf6 pf6Var = new pf6(this.a);
            qf6 qf6Var = new qf6(this.a);
            jf6 jf6Var = new jf6(this.a);
            of6 of6Var = new of6(this.a);
            rf6 rf6Var = new rf6(this.a);
            nf6 nf6Var = new nf6(this.a);
            kf6 kf6Var = new kf6(this.a);
            this.f = new sf6(this.a);
            uf6 uf6Var = new uf6(this.a, this.e);
            tf6 tf6Var = new tf6(this.a);
            this.c.add(lf6Var);
            this.c.add(this.f);
            this.c.add(pf6Var);
            this.c.add(qf6Var);
            this.c.add(jf6Var);
            this.c.add(of6Var);
            this.c.add(rf6Var);
            this.c.add(nf6Var);
            this.c.add(kf6Var);
            this.c.add(uf6Var);
            this.c.add(tf6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        sf6 sf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (sf6Var = this.f) != null) {
            sf6Var.B(str);
        }
    }

    public void d(String str) {
        sf6 sf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (sf6Var = this.f) != null) {
            sf6Var.a(str);
        }
    }

    public void e(String str) {
        sf6 sf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (sf6Var = this.f) != null) {
            sf6Var.C(str);
        }
    }

    public void f(boolean z) {
        sf6 sf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (sf6Var = this.f) != null) {
            sf6Var.D(z);
        }
    }
}
