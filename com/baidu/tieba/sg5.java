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
public class sg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kn> a;
    public TbPageContext<?> b;
    public Cdo c;
    public hh5 d;
    public dh5 e;
    public wg5 f;
    public yg5 g;
    public xg5 h;
    public zg5 i;
    public ah5 j;
    public ch5 k;
    public bh5 l;
    public fh5 m;
    public eh5 n;
    public gh5 o;
    public ug5 p;
    public tg5 q;

    public sg5(TbPageContext tbPageContext, Cdo cdo) {
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
        this.a = new LinkedList();
        this.b = tbPageContext;
        this.c = cdo;
        b();
    }

    public void a(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (kn knVar : list) {
            if (!c(knVar.getType())) {
                this.a.add(knVar);
            }
        }
        this.c.a(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (kn knVar : this.a) {
                    if (knVar != null && knVar.getType() == bdUniqueId) {
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
            hh5 hh5Var = new hh5(this.b);
            this.d = hh5Var;
            hh5Var.K(this.c);
            this.a.add(this.d);
            dh5 dh5Var = new dh5(this.b);
            this.e = dh5Var;
            dh5Var.K(this.c);
            this.a.add(this.e);
            gh5 gh5Var = new gh5(this.b);
            this.o = gh5Var;
            gh5Var.K(this.c);
            this.a.add(this.o);
            wg5 wg5Var = new wg5(this.b);
            this.f = wg5Var;
            wg5Var.K(this.c);
            this.a.add(this.f);
            yg5 yg5Var = new yg5(this.b);
            this.g = yg5Var;
            yg5Var.K(this.c);
            this.a.add(this.g);
            xg5 xg5Var = new xg5(this.b);
            this.h = xg5Var;
            xg5Var.K(this.c);
            this.a.add(this.h);
            zg5 zg5Var = new zg5(this.b);
            this.i = zg5Var;
            zg5Var.K(this.c);
            this.a.add(this.i);
            ah5 ah5Var = new ah5(this.b);
            this.j = ah5Var;
            ah5Var.K(this.c);
            this.a.add(this.j);
            ch5 ch5Var = new ch5(this.b);
            this.k = ch5Var;
            ch5Var.K(this.c);
            this.a.add(this.k);
            bh5 bh5Var = new bh5(this.b);
            this.l = bh5Var;
            bh5Var.K(this.c);
            this.a.add(this.l);
            fh5 fh5Var = new fh5(this.b);
            this.m = fh5Var;
            fh5Var.K(this.c);
            this.a.add(this.m);
            eh5 eh5Var = new eh5(this.b);
            this.n = eh5Var;
            eh5Var.K(this.c);
            this.a.add(this.n);
            ug5 ug5Var = new ug5(this.b);
            this.p = ug5Var;
            ug5Var.K(this.c);
            this.a.add(this.p);
            tg5 tg5Var = new tg5(this.b, v56.O0);
            this.q = tg5Var;
            this.a.add(tg5Var);
            this.c.a(this.a);
        }
    }

    public void d() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cdo = this.c) != null && cdo.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof vg5) {
                    ((vg5) knVar).s(i);
                }
            }
        }
    }

    public void f(ih5 ih5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ih5Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof vg5) {
                    ((vg5) knVar).G(ih5Var);
                }
            }
        }
    }

    public void g(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lq4Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof vg5) {
                    ((vg5) knVar).H(lq4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof vg5) {
                    ((vg5) knVar).J(bdUniqueId);
                }
            }
        }
    }

    public void k(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cdo) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof vg5) {
                    ((vg5) knVar).K(cdo);
                }
            }
        }
    }
}
