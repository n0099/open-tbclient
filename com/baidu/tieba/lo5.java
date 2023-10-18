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
/* loaded from: classes7.dex */
public class lo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<lh> a;
    public TbPageContext<?> b;
    public ei c;
    public ap5 d;
    public wo5 e;
    public po5 f;
    public ro5 g;
    public qo5 h;
    public so5 i;
    public to5 j;
    public vo5 k;
    public uo5 l;
    public yo5 m;
    public xo5 n;
    public zo5 o;
    public no5 p;
    public mo5 q;

    public lo5(TbPageContext tbPageContext, ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eiVar};
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
        this.c = eiVar;
        b();
    }

    public void a(List<lh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (lh lhVar : list) {
            if (!c(lhVar.getType())) {
                this.a.add(lhVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (lh lhVar : this.a) {
                    if (lhVar != null && lhVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ap5 ap5Var = new ap5(this.b);
            this.d = ap5Var;
            ap5Var.L(this.c);
            this.a.add(this.d);
            wo5 wo5Var = new wo5(this.b);
            this.e = wo5Var;
            wo5Var.L(this.c);
            this.a.add(this.e);
            zo5 zo5Var = new zo5(this.b);
            this.o = zo5Var;
            zo5Var.L(this.c);
            this.a.add(this.o);
            po5 po5Var = new po5(this.b);
            this.f = po5Var;
            po5Var.L(this.c);
            this.a.add(this.f);
            ro5 ro5Var = new ro5(this.b);
            this.g = ro5Var;
            ro5Var.L(this.c);
            this.a.add(this.g);
            qo5 qo5Var = new qo5(this.b);
            this.h = qo5Var;
            qo5Var.L(this.c);
            this.a.add(this.h);
            so5 so5Var = new so5(this.b);
            this.i = so5Var;
            so5Var.L(this.c);
            this.a.add(this.i);
            to5 to5Var = new to5(this.b);
            this.j = to5Var;
            to5Var.L(this.c);
            this.a.add(this.j);
            vo5 vo5Var = new vo5(this.b);
            this.k = vo5Var;
            vo5Var.L(this.c);
            this.a.add(this.k);
            uo5 uo5Var = new uo5(this.b);
            this.l = uo5Var;
            uo5Var.L(this.c);
            this.a.add(this.l);
            yo5 yo5Var = new yo5(this.b);
            this.m = yo5Var;
            yo5Var.L(this.c);
            this.a.add(this.m);
            xo5 xo5Var = new xo5(this.b);
            this.n = xo5Var;
            xo5Var.L(this.c);
            this.a.add(this.n);
            no5 no5Var = new no5(this.b);
            this.p = no5Var;
            no5Var.L(this.c);
            this.a.add(this.p);
            mo5 mo5Var = new mo5(this.b, qk6.S0);
            this.q = mo5Var;
            this.a.add(mo5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        ei eiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (eiVar = this.c) != null && eiVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (lh lhVar : this.a) {
                if (lhVar instanceof oo5) {
                    ((oo5) lhVar).s(i);
                }
            }
        }
    }

    public void f(bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bp5Var) == null) {
            for (lh lhVar : this.a) {
                if (lhVar instanceof oo5) {
                    ((oo5) lhVar).I(bp5Var);
                }
            }
        }
    }

    public void g(List<lh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(eu4 eu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eu4Var) == null) {
            for (lh lhVar : this.a) {
                if (lhVar instanceof oo5) {
                    ((oo5) lhVar).J(eu4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (lh lhVar : this.a) {
                if (lhVar instanceof oo5) {
                    ((oo5) lhVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eiVar) == null) {
            for (lh lhVar : this.a) {
                if (lhVar instanceof oo5) {
                    ((oo5) lhVar).L(eiVar);
                }
            }
        }
    }
}
