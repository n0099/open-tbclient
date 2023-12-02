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
/* loaded from: classes8.dex */
public class sq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ci> a;
    public TbPageContext<?> b;
    public vi c;
    public hr5 d;
    public dr5 e;
    public wq5 f;
    public yq5 g;
    public xq5 h;
    public zq5 i;
    public ar5 j;
    public cr5 k;
    public br5 l;
    public fr5 m;
    public er5 n;
    public gr5 o;
    public uq5 p;
    public tq5 q;

    public sq5(TbPageContext tbPageContext, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viVar};
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
        this.c = viVar;
        b();
    }

    public void a(List<ci> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (ci ciVar : list) {
            if (!c(ciVar.getType())) {
                this.a.add(ciVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (ci ciVar : this.a) {
                    if (ciVar != null && ciVar.getType() == bdUniqueId) {
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
            hr5 hr5Var = new hr5(this.b);
            this.d = hr5Var;
            hr5Var.M(this.c);
            this.a.add(this.d);
            dr5 dr5Var = new dr5(this.b);
            this.e = dr5Var;
            dr5Var.M(this.c);
            this.a.add(this.e);
            gr5 gr5Var = new gr5(this.b);
            this.o = gr5Var;
            gr5Var.M(this.c);
            this.a.add(this.o);
            wq5 wq5Var = new wq5(this.b);
            this.f = wq5Var;
            wq5Var.M(this.c);
            this.a.add(this.f);
            yq5 yq5Var = new yq5(this.b);
            this.g = yq5Var;
            yq5Var.M(this.c);
            this.a.add(this.g);
            xq5 xq5Var = new xq5(this.b);
            this.h = xq5Var;
            xq5Var.M(this.c);
            this.a.add(this.h);
            zq5 zq5Var = new zq5(this.b);
            this.i = zq5Var;
            zq5Var.M(this.c);
            this.a.add(this.i);
            ar5 ar5Var = new ar5(this.b);
            this.j = ar5Var;
            ar5Var.M(this.c);
            this.a.add(this.j);
            cr5 cr5Var = new cr5(this.b);
            this.k = cr5Var;
            cr5Var.M(this.c);
            this.a.add(this.k);
            br5 br5Var = new br5(this.b);
            this.l = br5Var;
            br5Var.M(this.c);
            this.a.add(this.l);
            fr5 fr5Var = new fr5(this.b);
            this.m = fr5Var;
            fr5Var.M(this.c);
            this.a.add(this.m);
            er5 er5Var = new er5(this.b);
            this.n = er5Var;
            er5Var.M(this.c);
            this.a.add(this.n);
            uq5 uq5Var = new uq5(this.b);
            this.p = uq5Var;
            uq5Var.M(this.c);
            this.a.add(this.p);
            tq5 tq5Var = new tq5(this.b, cn6.S0);
            this.q = tq5Var;
            this.a.add(tq5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (viVar = this.c) != null && viVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof vq5) {
                    ((vq5) ciVar).t(i);
                }
            }
        }
    }

    public void f(ir5 ir5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ir5Var) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof vq5) {
                    ((vq5) ciVar).J(ir5Var);
                }
            }
        }
    }

    public void g(List<ci> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, av4Var) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof vq5) {
                    ((vq5) ciVar).K(av4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof vq5) {
                    ((vq5) ciVar).L(bdUniqueId);
                }
            }
        }
    }

    public void k(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viVar) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof vq5) {
                    ((vq5) ciVar).M(viVar);
                }
            }
        }
    }
}
