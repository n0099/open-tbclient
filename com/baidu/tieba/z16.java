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
public class z16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<ln> c;
    public List<yn> d;
    public b36 e;
    public f26 f;

    public z16(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, b36 b36Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, b36Var};
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
        this.e = b36Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y16 y16Var = new y16(this.a);
            c26 c26Var = new c26(this.a);
            d26 d26Var = new d26(this.a);
            w16 w16Var = new w16(this.a);
            b26 b26Var = new b26(this.a);
            e26 e26Var = new e26(this.a);
            a26 a26Var = new a26(this.a);
            x16 x16Var = new x16(this.a);
            this.f = new f26(this.a);
            h26 h26Var = new h26(this.a, this.e);
            g26 g26Var = new g26(this.a);
            this.c.add(y16Var);
            this.c.add(this.f);
            this.c.add(c26Var);
            this.c.add(d26Var);
            this.c.add(w16Var);
            this.c.add(b26Var);
            this.c.add(e26Var);
            this.c.add(a26Var);
            this.c.add(x16Var);
            this.c.add(h26Var);
            this.c.add(g26Var);
            this.b.a(this.c);
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
        f26 f26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (f26Var = this.f) != null) {
            f26Var.D(str);
        }
    }

    public void d(String str) {
        f26 f26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (f26Var = this.f) != null) {
            f26Var.a(str);
        }
    }

    public void e(String str) {
        f26 f26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (f26Var = this.f) != null) {
            f26Var.E(str);
        }
    }

    public void f(boolean z) {
        f26 f26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (f26Var = this.f) != null) {
            f26Var.F(z);
        }
    }
}
