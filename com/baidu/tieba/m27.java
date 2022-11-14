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
public class m27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public l27 d;
    public q27 e;
    public k27 f;
    public o27 g;
    public n27 h;
    public p27 i;
    public r27 j;

    public m27(TbPageContext tbPageContext, Cdo cdo) {
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
            l27 l27Var = new l27(this.a);
            this.d = l27Var;
            l27Var.v(this.c);
            this.b.add(this.d);
            q27 q27Var = new q27(this.a);
            this.e = q27Var;
            q27Var.v(this.c);
            this.b.add(this.e);
            k27 k27Var = new k27(this.a);
            this.f = k27Var;
            k27Var.v(this.c);
            this.b.add(this.f);
            o27 o27Var = new o27(this.a);
            this.g = o27Var;
            o27Var.v(this.c);
            this.b.add(this.g);
            n27 n27Var = new n27(this.a);
            this.h = n27Var;
            n27Var.v(this.c);
            this.b.add(this.h);
            p27 p27Var = new p27(this.a);
            this.i = p27Var;
            p27Var.v(this.c);
            this.b.add(this.i);
            r27 r27Var = new r27(this.a);
            this.j = r27Var;
            r27Var.v(this.c);
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

    public void d(jq4 jq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jq4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof j27) {
                    ((j27) knVar).u(jq4Var);
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
