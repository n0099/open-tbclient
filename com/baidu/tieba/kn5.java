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
public class kn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<vm> a;
    public TbPageContext<?> b;
    public on c;
    public zn5 d;
    public vn5 e;
    public on5 f;
    public qn5 g;
    public pn5 h;
    public rn5 i;
    public sn5 j;
    public un5 k;
    public tn5 l;
    public xn5 m;
    public wn5 n;
    public yn5 o;
    public mn5 p;
    public ln5 q;

    public kn5(TbPageContext tbPageContext, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onVar};
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
        this.c = onVar;
        b();
    }

    public void a(List<vm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (vm vmVar : list) {
            if (!c(vmVar.getType())) {
                this.a.add(vmVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (vm vmVar : this.a) {
                    if (vmVar != null && vmVar.getType() == bdUniqueId) {
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
            zn5 zn5Var = new zn5(this.b);
            this.d = zn5Var;
            zn5Var.M(this.c);
            this.a.add(this.d);
            vn5 vn5Var = new vn5(this.b);
            this.e = vn5Var;
            vn5Var.M(this.c);
            this.a.add(this.e);
            yn5 yn5Var = new yn5(this.b);
            this.o = yn5Var;
            yn5Var.M(this.c);
            this.a.add(this.o);
            on5 on5Var = new on5(this.b);
            this.f = on5Var;
            on5Var.M(this.c);
            this.a.add(this.f);
            qn5 qn5Var = new qn5(this.b);
            this.g = qn5Var;
            qn5Var.M(this.c);
            this.a.add(this.g);
            pn5 pn5Var = new pn5(this.b);
            this.h = pn5Var;
            pn5Var.M(this.c);
            this.a.add(this.h);
            rn5 rn5Var = new rn5(this.b);
            this.i = rn5Var;
            rn5Var.M(this.c);
            this.a.add(this.i);
            sn5 sn5Var = new sn5(this.b);
            this.j = sn5Var;
            sn5Var.M(this.c);
            this.a.add(this.j);
            un5 un5Var = new un5(this.b);
            this.k = un5Var;
            un5Var.M(this.c);
            this.a.add(this.k);
            tn5 tn5Var = new tn5(this.b);
            this.l = tn5Var;
            tn5Var.M(this.c);
            this.a.add(this.l);
            xn5 xn5Var = new xn5(this.b);
            this.m = xn5Var;
            xn5Var.M(this.c);
            this.a.add(this.m);
            wn5 wn5Var = new wn5(this.b);
            this.n = wn5Var;
            wn5Var.M(this.c);
            this.a.add(this.n);
            mn5 mn5Var = new mn5(this.b);
            this.p = mn5Var;
            mn5Var.M(this.c);
            this.a.add(this.p);
            ln5 ln5Var = new ln5(this.b, mh6.Q0);
            this.q = ln5Var;
            this.a.add(ln5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (onVar = this.c) != null && onVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof nn5) {
                    ((nn5) vmVar).s(i);
                }
            }
        }
    }

    public void f(ao5 ao5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ao5Var) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof nn5) {
                    ((nn5) vmVar).I(ao5Var);
                }
            }
        }
    }

    public void g(List<vm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, av4Var) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof nn5) {
                    ((nn5) vmVar).J(av4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof nn5) {
                    ((nn5) vmVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onVar) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof nn5) {
                    ((nn5) vmVar).M(onVar);
                }
            }
        }
    }
}
