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
/* loaded from: classes4.dex */
public class j06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<kn> c;
    public List<xn> d;
    public l16 e;
    public p06 f;

    public j06(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, l16 l16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, l16Var};
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
        this.e = l16Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i06 i06Var = new i06(this.a);
            m06 m06Var = new m06(this.a);
            n06 n06Var = new n06(this.a);
            g06 g06Var = new g06(this.a);
            l06 l06Var = new l06(this.a);
            o06 o06Var = new o06(this.a);
            k06 k06Var = new k06(this.a);
            h06 h06Var = new h06(this.a);
            this.f = new p06(this.a);
            r06 r06Var = new r06(this.a, this.e);
            q06 q06Var = new q06(this.a);
            this.c.add(i06Var);
            this.c.add(this.f);
            this.c.add(m06Var);
            this.c.add(n06Var);
            this.c.add(g06Var);
            this.c.add(l06Var);
            this.c.add(o06Var);
            this.c.add(k06Var);
            this.c.add(h06Var);
            this.c.add(r06Var);
            this.c.add(q06Var);
            this.b.a(this.c);
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
        p06 p06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (p06Var = this.f) != null) {
            p06Var.D(str);
        }
    }

    public void d(String str) {
        p06 p06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (p06Var = this.f) != null) {
            p06Var.a(str);
        }
    }

    public void e(String str) {
        p06 p06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (p06Var = this.f) != null) {
            p06Var.E(str);
        }
    }

    public void f(boolean z) {
        p06 p06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (p06Var = this.f) != null) {
            p06Var.F(z);
        }
    }
}
