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
public class p96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<vm> c;
    public List<in> d;
    public ra6 e;
    public v96 f;

    public p96(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ra6 ra6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, ra6Var};
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
        this.e = ra6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o96 o96Var = new o96(this.a);
            s96 s96Var = new s96(this.a);
            t96 t96Var = new t96(this.a);
            m96 m96Var = new m96(this.a);
            r96 r96Var = new r96(this.a);
            u96 u96Var = new u96(this.a);
            q96 q96Var = new q96(this.a);
            n96 n96Var = new n96(this.a);
            this.f = new v96(this.a);
            x96 x96Var = new x96(this.a, this.e);
            w96 w96Var = new w96(this.a);
            this.c.add(o96Var);
            this.c.add(this.f);
            this.c.add(s96Var);
            this.c.add(t96Var);
            this.c.add(m96Var);
            this.c.add(r96Var);
            this.c.add(u96Var);
            this.c.add(q96Var);
            this.c.add(n96Var);
            this.c.add(x96Var);
            this.c.add(w96Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        v96 v96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (v96Var = this.f) != null) {
            v96Var.F(str);
        }
    }

    public void d(String str) {
        v96 v96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (v96Var = this.f) != null) {
            v96Var.a(str);
        }
    }

    public void e(String str) {
        v96 v96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (v96Var = this.f) != null) {
            v96Var.G(str);
        }
    }

    public void f(boolean z) {
        v96 v96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (v96Var = this.f) != null) {
            v96Var.H(z);
        }
    }
}
