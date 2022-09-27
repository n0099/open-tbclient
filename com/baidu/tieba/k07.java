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
public class k07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public j07 d;
    public o07 e;
    public i07 f;
    public m07 g;
    public l07 h;
    public n07 i;
    public p07 j;

    public k07(TbPageContext tbPageContext, jo joVar) {
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
            j07 j07Var = new j07(this.a);
            this.d = j07Var;
            j07Var.v(this.c);
            this.b.add(this.d);
            o07 o07Var = new o07(this.a);
            this.e = o07Var;
            o07Var.v(this.c);
            this.b.add(this.e);
            i07 i07Var = new i07(this.a);
            this.f = i07Var;
            i07Var.v(this.c);
            this.b.add(this.f);
            m07 m07Var = new m07(this.a);
            this.g = m07Var;
            m07Var.v(this.c);
            this.b.add(this.g);
            l07 l07Var = new l07(this.a);
            this.h = l07Var;
            l07Var.v(this.c);
            this.b.add(this.h);
            n07 n07Var = new n07(this.a);
            this.i = n07Var;
            n07Var.v(this.c);
            this.b.add(this.i);
            p07 p07Var = new p07(this.a);
            this.j = p07Var;
            p07Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (joVar = this.c) == null) {
            return;
        }
        joVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<Cdo> list) {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (joVar = this.c) == null) {
            return;
        }
        joVar.setData(list);
        b();
    }

    public void d(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qp4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof h07) {
                    ((h07) qnVar).u(qp4Var);
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
