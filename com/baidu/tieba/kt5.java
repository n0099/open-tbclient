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
/* loaded from: classes6.dex */
public class kt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<om> a;
    public TbPageContext<?> b;
    public hn c;
    public zt5 d;
    public vt5 e;
    public ot5 f;
    public qt5 g;
    public pt5 h;
    public rt5 i;
    public st5 j;
    public ut5 k;
    public tt5 l;
    public xt5 m;
    public wt5 n;
    public yt5 o;
    public mt5 p;
    public lt5 q;

    public kt5(TbPageContext tbPageContext, hn hnVar) {
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
        this.a = new LinkedList();
        this.b = tbPageContext;
        this.c = hnVar;
        b();
    }

    public void a(List<om> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (om omVar : list) {
            if (!c(omVar.getType())) {
                this.a.add(omVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (om omVar : this.a) {
                    if (omVar != null && omVar.getType() == bdUniqueId) {
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
            zt5 zt5Var = new zt5(this.b);
            this.d = zt5Var;
            zt5Var.L(this.c);
            this.a.add(this.d);
            vt5 vt5Var = new vt5(this.b);
            this.e = vt5Var;
            vt5Var.L(this.c);
            this.a.add(this.e);
            yt5 yt5Var = new yt5(this.b);
            this.o = yt5Var;
            yt5Var.L(this.c);
            this.a.add(this.o);
            ot5 ot5Var = new ot5(this.b);
            this.f = ot5Var;
            ot5Var.L(this.c);
            this.a.add(this.f);
            qt5 qt5Var = new qt5(this.b);
            this.g = qt5Var;
            qt5Var.L(this.c);
            this.a.add(this.g);
            pt5 pt5Var = new pt5(this.b);
            this.h = pt5Var;
            pt5Var.L(this.c);
            this.a.add(this.h);
            rt5 rt5Var = new rt5(this.b);
            this.i = rt5Var;
            rt5Var.L(this.c);
            this.a.add(this.i);
            st5 st5Var = new st5(this.b);
            this.j = st5Var;
            st5Var.L(this.c);
            this.a.add(this.j);
            ut5 ut5Var = new ut5(this.b);
            this.k = ut5Var;
            ut5Var.L(this.c);
            this.a.add(this.k);
            tt5 tt5Var = new tt5(this.b);
            this.l = tt5Var;
            tt5Var.L(this.c);
            this.a.add(this.l);
            xt5 xt5Var = new xt5(this.b);
            this.m = xt5Var;
            xt5Var.L(this.c);
            this.a.add(this.m);
            wt5 wt5Var = new wt5(this.b);
            this.n = wt5Var;
            wt5Var.L(this.c);
            this.a.add(this.n);
            mt5 mt5Var = new mt5(this.b);
            this.p = mt5Var;
            mt5Var.L(this.c);
            this.a.add(this.p);
            lt5 lt5Var = new lt5(this.b, yo6.S0);
            this.q = lt5Var;
            this.a.add(lt5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hnVar = this.c) != null && hnVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof nt5) {
                    ((nt5) omVar).s(i);
                }
            }
        }
    }

    public void f(au5 au5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, au5Var) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof nt5) {
                    ((nt5) omVar).I(au5Var);
                }
            }
        }
    }

    public void g(List<om> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(rz4 rz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rz4Var) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof nt5) {
                    ((nt5) omVar).J(rz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof nt5) {
                    ((nt5) omVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hnVar) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof nt5) {
                    ((nt5) omVar).L(hnVar);
                }
            }
        }
    }
}
