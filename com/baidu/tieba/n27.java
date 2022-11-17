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
public class n27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public m27 d;
    public r27 e;
    public l27 f;
    public p27 g;
    public o27 h;
    public q27 i;
    public s27 j;

    public n27(TbPageContext tbPageContext, Cdo cdo) {
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
            m27 m27Var = new m27(this.a);
            this.d = m27Var;
            m27Var.v(this.c);
            this.b.add(this.d);
            r27 r27Var = new r27(this.a);
            this.e = r27Var;
            r27Var.v(this.c);
            this.b.add(this.e);
            l27 l27Var = new l27(this.a);
            this.f = l27Var;
            l27Var.v(this.c);
            this.b.add(this.f);
            p27 p27Var = new p27(this.a);
            this.g = p27Var;
            p27Var.v(this.c);
            this.b.add(this.g);
            o27 o27Var = new o27(this.a);
            this.h = o27Var;
            o27Var.v(this.c);
            this.b.add(this.h);
            q27 q27Var = new q27(this.a);
            this.i = q27Var;
            q27Var.v(this.c);
            this.b.add(this.i);
            s27 s27Var = new s27(this.a);
            this.j = s27Var;
            s27Var.v(this.c);
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

    public void d(kq4 kq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kq4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof k27) {
                    ((k27) knVar).u(kq4Var);
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
