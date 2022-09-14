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
public class wz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public vz6 d;
    public a07 e;
    public uz6 f;
    public yz6 g;
    public xz6 h;
    public zz6 i;
    public b07 j;

    public wz6(TbPageContext tbPageContext, jo joVar) {
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
            vz6 vz6Var = new vz6(this.a);
            this.d = vz6Var;
            vz6Var.v(this.c);
            this.b.add(this.d);
            a07 a07Var = new a07(this.a);
            this.e = a07Var;
            a07Var.v(this.c);
            this.b.add(this.e);
            uz6 uz6Var = new uz6(this.a);
            this.f = uz6Var;
            uz6Var.v(this.c);
            this.b.add(this.f);
            yz6 yz6Var = new yz6(this.a);
            this.g = yz6Var;
            yz6Var.v(this.c);
            this.b.add(this.g);
            xz6 xz6Var = new xz6(this.a);
            this.h = xz6Var;
            xz6Var.v(this.c);
            this.b.add(this.h);
            zz6 zz6Var = new zz6(this.a);
            this.i = zz6Var;
            zz6Var.v(this.c);
            this.b.add(this.i);
            b07 b07Var = new b07(this.a);
            this.j = b07Var;
            b07Var.v(this.c);
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

    public void d(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dp4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof tz6) {
                    ((tz6) qnVar).u(dp4Var);
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
