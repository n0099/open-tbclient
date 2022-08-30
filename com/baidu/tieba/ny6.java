package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ny6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<cn> b;
    public vn c;
    public my6 d;
    public ry6 e;
    public ly6 f;
    public py6 g;
    public oy6 h;
    public qy6 i;
    public sy6 j;

    public ny6(TbPageContext tbPageContext, vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vnVar};
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
        this.c = vnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            my6 my6Var = new my6(this.a);
            this.d = my6Var;
            my6Var.v(this.c);
            this.b.add(this.d);
            ry6 ry6Var = new ry6(this.a);
            this.e = ry6Var;
            ry6Var.v(this.c);
            this.b.add(this.e);
            ly6 ly6Var = new ly6(this.a);
            this.f = ly6Var;
            ly6Var.v(this.c);
            this.b.add(this.f);
            py6 py6Var = new py6(this.a);
            this.g = py6Var;
            py6Var.v(this.c);
            this.b.add(this.g);
            oy6 oy6Var = new oy6(this.a);
            this.h = oy6Var;
            oy6Var.v(this.c);
            this.b.add(this.h);
            qy6 qy6Var = new qy6(this.a);
            this.i = qy6Var;
            qy6Var.v(this.c);
            this.b.add(this.i);
            sy6 sy6Var = new sy6(this.a);
            this.j = sy6Var;
            sy6Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        vn vnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (vnVar = this.c) == null) {
            return;
        }
        vnVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<pn> list) {
        vn vnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (vnVar = this.c) == null) {
            return;
        }
        vnVar.setData(list);
        b();
    }

    public void d(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cn4Var) == null) {
            for (cn cnVar : this.b) {
                if (cnVar instanceof ky6) {
                    ((ky6) cnVar).u(cn4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (cn cnVar : this.b) {
                cnVar.setPageId(bdUniqueId);
            }
        }
    }
}
