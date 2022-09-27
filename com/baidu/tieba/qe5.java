package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class qe5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<qn> a;
    public TbPageContext<?> b;
    public jo c;
    public ff5 d;
    public bf5 e;
    public ue5 f;
    public we5 g;
    public ve5 h;
    public xe5 i;
    public ye5 j;
    public af5 k;
    public ze5 l;
    public df5 m;
    public cf5 n;
    public ef5 o;
    public se5 p;
    public re5 q;

    public qe5(TbPageContext tbPageContext, jo joVar) {
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
        this.a = new LinkedList();
        this.b = tbPageContext;
        this.c = joVar;
        b();
    }

    public void a(List<qn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (qn qnVar : list) {
            if (!c(qnVar.getType())) {
                this.a.add(qnVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ff5 ff5Var = new ff5(this.b);
            this.d = ff5Var;
            ff5Var.K(this.c);
            this.a.add(this.d);
            bf5 bf5Var = new bf5(this.b);
            this.e = bf5Var;
            bf5Var.K(this.c);
            this.a.add(this.e);
            ef5 ef5Var = new ef5(this.b);
            this.o = ef5Var;
            ef5Var.K(this.c);
            this.a.add(this.o);
            ue5 ue5Var = new ue5(this.b);
            this.f = ue5Var;
            ue5Var.K(this.c);
            this.a.add(this.f);
            we5 we5Var = new we5(this.b);
            this.g = we5Var;
            we5Var.K(this.c);
            this.a.add(this.g);
            ve5 ve5Var = new ve5(this.b);
            this.h = ve5Var;
            ve5Var.K(this.c);
            this.a.add(this.h);
            xe5 xe5Var = new xe5(this.b);
            this.i = xe5Var;
            xe5Var.K(this.c);
            this.a.add(this.i);
            ye5 ye5Var = new ye5(this.b);
            this.j = ye5Var;
            ye5Var.K(this.c);
            this.a.add(this.j);
            af5 af5Var = new af5(this.b);
            this.k = af5Var;
            af5Var.K(this.c);
            this.a.add(this.k);
            ze5 ze5Var = new ze5(this.b);
            this.l = ze5Var;
            ze5Var.K(this.c);
            this.a.add(this.l);
            df5 df5Var = new df5(this.b);
            this.m = df5Var;
            df5Var.K(this.c);
            this.a.add(this.m);
            cf5 cf5Var = new cf5(this.b);
            this.n = cf5Var;
            cf5Var.K(this.c);
            this.a.add(this.n);
            se5 se5Var = new se5(this.b);
            this.p = se5Var;
            se5Var.K(this.c);
            this.a.add(this.p);
            re5 re5Var = new re5(this.b, w26.N0);
            this.q = re5Var;
            this.a.add(re5Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (qn qnVar : this.a) {
                    if (qnVar != null && qnVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (joVar = this.c) == null || joVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof te5) {
                    ((te5) qnVar).s(i);
                }
            }
        }
    }

    public void f(gf5 gf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gf5Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof te5) {
                    ((te5) qnVar).G(gf5Var);
                }
            }
        }
    }

    public void g(List<qn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qp4Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof te5) {
                    ((te5) qnVar).H(qp4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof te5) {
                    ((te5) qnVar).I(bdUniqueId);
                }
            }
        }
    }

    public void k(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, joVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof te5) {
                    ((te5) qnVar).K(joVar);
                }
            }
        }
    }
}
