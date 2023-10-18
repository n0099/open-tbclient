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
public class pa6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<lh> c;
    public List<yh> d;
    public rb6 e;
    public va6 f;

    public pa6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, rb6 rb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, rb6Var};
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
        this.e = rb6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            oa6 oa6Var = new oa6(this.a);
            sa6 sa6Var = new sa6(this.a);
            ta6 ta6Var = new ta6(this.a);
            ma6 ma6Var = new ma6(this.a);
            ra6 ra6Var = new ra6(this.a);
            ua6 ua6Var = new ua6(this.a);
            qa6 qa6Var = new qa6(this.a);
            na6 na6Var = new na6(this.a);
            this.f = new va6(this.a);
            xa6 xa6Var = new xa6(this.a, this.e);
            wa6 wa6Var = new wa6(this.a);
            this.c.add(oa6Var);
            this.c.add(this.f);
            this.c.add(sa6Var);
            this.c.add(ta6Var);
            this.c.add(ma6Var);
            this.c.add(ra6Var);
            this.c.add(ua6Var);
            this.c.add(qa6Var);
            this.c.add(na6Var);
            this.c.add(xa6Var);
            this.c.add(wa6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        va6 va6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (va6Var = this.f) != null) {
            va6Var.B(str);
        }
    }

    public void d(String str) {
        va6 va6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (va6Var = this.f) != null) {
            va6Var.a(str);
        }
    }

    public void e(String str) {
        va6 va6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (va6Var = this.f) != null) {
            va6Var.C(str);
        }
    }

    public void f(boolean z) {
        va6 va6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (va6Var = this.f) != null) {
            va6Var.D(z);
        }
    }
}
