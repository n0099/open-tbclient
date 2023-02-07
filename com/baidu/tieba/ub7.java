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
public class ub7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public tb7 d;
    public yb7 e;
    public sb7 f;
    public wb7 g;
    public vb7 h;
    public xb7 i;
    public zb7 j;

    public ub7(TbPageContext tbPageContext, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, joVar};
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
        this.c = joVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            tb7 tb7Var = new tb7(this.a);
            this.d = tb7Var;
            tb7Var.v(this.c);
            this.b.add(this.d);
            yb7 yb7Var = new yb7(this.a);
            this.e = yb7Var;
            yb7Var.v(this.c);
            this.b.add(this.e);
            sb7 sb7Var = new sb7(this.a);
            this.f = sb7Var;
            sb7Var.v(this.c);
            this.b.add(this.f);
            wb7 wb7Var = new wb7(this.a);
            this.g = wb7Var;
            wb7Var.v(this.c);
            this.b.add(this.g);
            vb7 vb7Var = new vb7(this.a);
            this.h = vb7Var;
            vb7Var.v(this.c);
            this.b.add(this.h);
            xb7 xb7Var = new xb7(this.a);
            this.i = xb7Var;
            xb7Var.v(this.c);
            this.b.add(this.i);
            zb7 zb7Var = new zb7(this.a);
            this.j = zb7Var;
            zb7Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (joVar = this.c) != null) {
            joVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<Cdo> list) {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (joVar = this.c) != null) {
            joVar.setData(list);
            b();
        }
    }

    public void d(iv4 iv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iv4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof rb7) {
                    ((rb7) qnVar).u(iv4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (qn qnVar : this.b) {
                qnVar.setPageId(bdUniqueId);
            }
        }
    }
}
