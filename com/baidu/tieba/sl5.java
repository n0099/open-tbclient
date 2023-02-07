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
public class sl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<qn> a;
    public TbPageContext<?> b;
    public jo c;
    public hm5 d;
    public dm5 e;
    public wl5 f;
    public yl5 g;
    public xl5 h;
    public zl5 i;
    public am5 j;
    public cm5 k;
    public bm5 l;
    public fm5 m;
    public em5 n;
    public gm5 o;
    public ul5 p;
    public tl5 q;

    public sl5(TbPageContext tbPageContext, jo joVar) {
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
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (qn qnVar : list) {
            if (!c(qnVar.getType())) {
                this.a.add(qnVar);
            }
        }
        this.c.a(this.a);
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hm5 hm5Var = new hm5(this.b);
            this.d = hm5Var;
            hm5Var.K(this.c);
            this.a.add(this.d);
            dm5 dm5Var = new dm5(this.b);
            this.e = dm5Var;
            dm5Var.K(this.c);
            this.a.add(this.e);
            gm5 gm5Var = new gm5(this.b);
            this.o = gm5Var;
            gm5Var.K(this.c);
            this.a.add(this.o);
            wl5 wl5Var = new wl5(this.b);
            this.f = wl5Var;
            wl5Var.K(this.c);
            this.a.add(this.f);
            yl5 yl5Var = new yl5(this.b);
            this.g = yl5Var;
            yl5Var.K(this.c);
            this.a.add(this.g);
            xl5 xl5Var = new xl5(this.b);
            this.h = xl5Var;
            xl5Var.K(this.c);
            this.a.add(this.h);
            zl5 zl5Var = new zl5(this.b);
            this.i = zl5Var;
            zl5Var.K(this.c);
            this.a.add(this.i);
            am5 am5Var = new am5(this.b);
            this.j = am5Var;
            am5Var.K(this.c);
            this.a.add(this.j);
            cm5 cm5Var = new cm5(this.b);
            this.k = cm5Var;
            cm5Var.K(this.c);
            this.a.add(this.k);
            bm5 bm5Var = new bm5(this.b);
            this.l = bm5Var;
            bm5Var.K(this.c);
            this.a.add(this.l);
            fm5 fm5Var = new fm5(this.b);
            this.m = fm5Var;
            fm5Var.K(this.c);
            this.a.add(this.m);
            em5 em5Var = new em5(this.b);
            this.n = em5Var;
            em5Var.K(this.c);
            this.a.add(this.n);
            ul5 ul5Var = new ul5(this.b);
            this.p = ul5Var;
            ul5Var.K(this.c);
            this.a.add(this.p);
            tl5 tl5Var = new tl5(this.b, zd6.P0);
            this.q = tl5Var;
            this.a.add(tl5Var);
            this.c.a(this.a);
        }
    }

    public void d() {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (joVar = this.c) != null && joVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof vl5) {
                    ((vl5) qnVar).s(i);
                }
            }
        }
    }

    public void f(im5 im5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, im5Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof vl5) {
                    ((vl5) qnVar).G(im5Var);
                }
            }
        }
    }

    public void g(List<qn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
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

    public void i(iv4 iv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iv4Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof vl5) {
                    ((vl5) qnVar).H(iv4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof vl5) {
                    ((vl5) qnVar).J(bdUniqueId);
                }
            }
        }
    }

    public void k(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, joVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof vl5) {
                    ((vl5) qnVar).K(joVar);
                }
            }
        }
    }
}
