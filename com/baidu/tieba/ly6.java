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
/* loaded from: classes4.dex */
public class ly6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<cn> b;
    public vn c;
    public ky6 d;
    public py6 e;
    public jy6 f;
    public ny6 g;
    public my6 h;
    public oy6 i;
    public qy6 j;

    public ly6(TbPageContext tbPageContext, vn vnVar) {
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
            ky6 ky6Var = new ky6(this.a);
            this.d = ky6Var;
            ky6Var.v(this.c);
            this.b.add(this.d);
            py6 py6Var = new py6(this.a);
            this.e = py6Var;
            py6Var.v(this.c);
            this.b.add(this.e);
            jy6 jy6Var = new jy6(this.a);
            this.f = jy6Var;
            jy6Var.v(this.c);
            this.b.add(this.f);
            ny6 ny6Var = new ny6(this.a);
            this.g = ny6Var;
            ny6Var.v(this.c);
            this.b.add(this.g);
            my6 my6Var = new my6(this.a);
            this.h = my6Var;
            my6Var.v(this.c);
            this.b.add(this.h);
            oy6 oy6Var = new oy6(this.a);
            this.i = oy6Var;
            oy6Var.v(this.c);
            this.b.add(this.i);
            qy6 qy6Var = new qy6(this.a);
            this.j = qy6Var;
            qy6Var.v(this.c);
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
                if (cnVar instanceof iy6) {
                    ((iy6) cnVar).u(cn4Var);
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
