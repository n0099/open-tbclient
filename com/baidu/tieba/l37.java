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
public class l37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public k37 d;
    public p37 e;
    public j37 f;
    public n37 g;
    public m37 h;
    public o37 i;
    public q37 j;

    public l37(TbPageContext tbPageContext, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cdo};
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
        this.c = cdo;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            k37 k37Var = new k37(this.a);
            this.d = k37Var;
            k37Var.v(this.c);
            this.b.add(this.d);
            p37 p37Var = new p37(this.a);
            this.e = p37Var;
            p37Var.v(this.c);
            this.b.add(this.e);
            j37 j37Var = new j37(this.a);
            this.f = j37Var;
            j37Var.v(this.c);
            this.b.add(this.f);
            n37 n37Var = new n37(this.a);
            this.g = n37Var;
            n37Var.v(this.c);
            this.b.add(this.g);
            m37 m37Var = new m37(this.a);
            this.h = m37Var;
            m37Var.v(this.c);
            this.b.add(this.h);
            o37 o37Var = new o37(this.a);
            this.i = o37Var;
            o37Var.v(this.c);
            this.b.add(this.i);
            q37 q37Var = new q37(this.a);
            this.j = q37Var;
            q37Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cdo = this.c) != null) {
            cdo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<xn> list) {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (cdo = this.c) != null) {
            cdo.setData(list);
            b();
        }
    }

    public void d(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lq4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof i37) {
                    ((i37) knVar).u(lq4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (kn knVar : this.b) {
                knVar.setPageId(bdUniqueId);
            }
        }
    }
}
