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
public class k06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<kn> c;
    public List<xn> d;
    public m16 e;
    public q06 f;

    public k06(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, m16 m16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, m16Var};
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
        this.e = m16Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j06 j06Var = new j06(this.a);
            n06 n06Var = new n06(this.a);
            o06 o06Var = new o06(this.a);
            h06 h06Var = new h06(this.a);
            m06 m06Var = new m06(this.a);
            p06 p06Var = new p06(this.a);
            l06 l06Var = new l06(this.a);
            i06 i06Var = new i06(this.a);
            this.f = new q06(this.a);
            s06 s06Var = new s06(this.a, this.e);
            r06 r06Var = new r06(this.a);
            this.c.add(j06Var);
            this.c.add(this.f);
            this.c.add(n06Var);
            this.c.add(o06Var);
            this.c.add(h06Var);
            this.c.add(m06Var);
            this.c.add(p06Var);
            this.c.add(l06Var);
            this.c.add(i06Var);
            this.c.add(s06Var);
            this.c.add(r06Var);
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
        q06 q06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (q06Var = this.f) != null) {
            q06Var.D(str);
        }
    }

    public void d(String str) {
        q06 q06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (q06Var = this.f) != null) {
            q06Var.a(str);
        }
    }

    public void e(String str) {
        q06 q06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (q06Var = this.f) != null) {
            q06Var.E(str);
        }
    }

    public void f(boolean z) {
        q06 q06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (q06Var = this.f) != null) {
            q06Var.F(z);
        }
    }
}
