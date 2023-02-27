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
public class qe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public pe7 d;
    public ue7 e;
    public oe7 f;
    public se7 g;
    public re7 h;
    public te7 i;
    public ve7 j;

    public qe7(TbPageContext tbPageContext, jo joVar) {
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
            pe7 pe7Var = new pe7(this.a);
            this.d = pe7Var;
            pe7Var.v(this.c);
            this.b.add(this.d);
            ue7 ue7Var = new ue7(this.a);
            this.e = ue7Var;
            ue7Var.v(this.c);
            this.b.add(this.e);
            oe7 oe7Var = new oe7(this.a);
            this.f = oe7Var;
            oe7Var.v(this.c);
            this.b.add(this.f);
            se7 se7Var = new se7(this.a);
            this.g = se7Var;
            se7Var.v(this.c);
            this.b.add(this.g);
            re7 re7Var = new re7(this.a);
            this.h = re7Var;
            re7Var.v(this.c);
            this.b.add(this.h);
            te7 te7Var = new te7(this.a);
            this.i = te7Var;
            te7Var.v(this.c);
            this.b.add(this.i);
            ve7 ve7Var = new ve7(this.a);
            this.j = ve7Var;
            ve7Var.v(this.c);
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

    public void d(pw4 pw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pw4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof ne7) {
                    ((ne7) qnVar).u(pw4Var);
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
