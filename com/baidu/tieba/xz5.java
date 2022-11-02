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
public class xz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<jn> c;
    public List<wn> d;
    public z06 e;
    public d06 f;

    public xz5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, z06 z06Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, z06Var};
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
        this.e = z06Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            wz5 wz5Var = new wz5(this.a);
            a06 a06Var = new a06(this.a);
            b06 b06Var = new b06(this.a);
            uz5 uz5Var = new uz5(this.a);
            zz5 zz5Var = new zz5(this.a);
            c06 c06Var = new c06(this.a);
            yz5 yz5Var = new yz5(this.a);
            vz5 vz5Var = new vz5(this.a);
            this.f = new d06(this.a);
            f06 f06Var = new f06(this.a, this.e);
            e06 e06Var = new e06(this.a);
            this.c.add(wz5Var);
            this.c.add(this.f);
            this.c.add(a06Var);
            this.c.add(b06Var);
            this.c.add(uz5Var);
            this.c.add(zz5Var);
            this.c.add(c06Var);
            this.c.add(yz5Var);
            this.c.add(vz5Var);
            this.c.add(f06Var);
            this.c.add(e06Var);
            this.b.a(this.c);
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
        d06 d06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (d06Var = this.f) != null) {
            d06Var.D(str);
        }
    }

    public void d(String str) {
        d06 d06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (d06Var = this.f) != null) {
            d06Var.a(str);
        }
    }

    public void e(String str) {
        d06 d06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (d06Var = this.f) != null) {
            d06Var.E(str);
        }
    }

    public void f(boolean z) {
        d06 d06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (d06Var = this.f) != null) {
            d06Var.F(z);
        }
    }
}
