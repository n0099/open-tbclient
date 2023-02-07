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
public class l66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<qn> c;
    public List<Cdo> d;
    public n76 e;
    public r66 f;

    public l66(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, n76 n76Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, n76Var};
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
        this.e = n76Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k66 k66Var = new k66(this.a);
            o66 o66Var = new o66(this.a);
            p66 p66Var = new p66(this.a);
            i66 i66Var = new i66(this.a);
            n66 n66Var = new n66(this.a);
            q66 q66Var = new q66(this.a);
            m66 m66Var = new m66(this.a);
            j66 j66Var = new j66(this.a);
            this.f = new r66(this.a);
            t66 t66Var = new t66(this.a, this.e);
            s66 s66Var = new s66(this.a);
            this.c.add(k66Var);
            this.c.add(this.f);
            this.c.add(o66Var);
            this.c.add(p66Var);
            this.c.add(i66Var);
            this.c.add(n66Var);
            this.c.add(q66Var);
            this.c.add(m66Var);
            this.c.add(j66Var);
            this.c.add(t66Var);
            this.c.add(s66Var);
            this.b.a(this.c);
        }
    }

    public void b(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        r66 r66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (r66Var = this.f) != null) {
            r66Var.D(str);
        }
    }

    public void d(String str) {
        r66 r66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (r66Var = this.f) != null) {
            r66Var.a(str);
        }
    }

    public void e(String str) {
        r66 r66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (r66Var = this.f) != null) {
            r66Var.E(str);
        }
    }

    public void f(boolean z) {
        r66 r66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (r66Var = this.f) != null) {
            r66Var.F(z);
        }
    }
}
