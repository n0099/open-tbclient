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
/* loaded from: classes6.dex */
public class k38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<om> b;
    public hn c;
    public j38 d;
    public o38 e;
    public i38 f;
    public m38 g;
    public l38 h;
    public n38 i;
    public p38 j;

    public k38(TbPageContext tbPageContext, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hnVar};
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
        this.c = hnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            j38 j38Var = new j38(this.a);
            this.d = j38Var;
            j38Var.x(this.c);
            this.b.add(this.d);
            o38 o38Var = new o38(this.a);
            this.e = o38Var;
            o38Var.x(this.c);
            this.b.add(this.e);
            i38 i38Var = new i38(this.a);
            this.f = i38Var;
            i38Var.x(this.c);
            this.b.add(this.f);
            m38 m38Var = new m38(this.a);
            this.g = m38Var;
            m38Var.x(this.c);
            this.b.add(this.g);
            l38 l38Var = new l38(this.a);
            this.h = l38Var;
            l38Var.x(this.c);
            this.b.add(this.h);
            n38 n38Var = new n38(this.a);
            this.i = n38Var;
            n38Var.x(this.c);
            this.b.add(this.i);
            p38 p38Var = new p38(this.a);
            this.j = p38Var;
            p38Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hnVar = this.c) != null) {
            hnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<bn> list) {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (hnVar = this.c) != null) {
            hnVar.setData(list);
            b();
        }
    }

    public void d(rz4 rz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rz4Var) == null) {
            for (om omVar : this.b) {
                if (omVar instanceof h38) {
                    ((h38) omVar).u(rz4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (om omVar : this.b) {
                omVar.setPageId(bdUniqueId);
            }
        }
    }
}
