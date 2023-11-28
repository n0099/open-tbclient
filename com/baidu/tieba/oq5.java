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
public class oq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ci> a;
    public TbPageContext<?> b;
    public vi c;
    public dr5 d;
    public zq5 e;
    public sq5 f;
    public uq5 g;
    public tq5 h;
    public vq5 i;
    public wq5 j;
    public yq5 k;
    public xq5 l;
    public br5 m;
    public ar5 n;
    public cr5 o;
    public qq5 p;
    public pq5 q;

    public oq5(TbPageContext tbPageContext, vi viVar) {
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
            dr5 dr5Var = new dr5(this.b);
            this.d = dr5Var;
            dr5Var.M(this.c);
            this.a.add(this.d);
            zq5 zq5Var = new zq5(this.b);
            this.e = zq5Var;
            zq5Var.M(this.c);
            this.a.add(this.e);
            cr5 cr5Var = new cr5(this.b);
            this.o = cr5Var;
            cr5Var.M(this.c);
            this.a.add(this.o);
            sq5 sq5Var = new sq5(this.b);
            this.f = sq5Var;
            sq5Var.M(this.c);
            this.a.add(this.f);
            uq5 uq5Var = new uq5(this.b);
            this.g = uq5Var;
            uq5Var.M(this.c);
            this.a.add(this.g);
            tq5 tq5Var = new tq5(this.b);
            this.h = tq5Var;
            tq5Var.M(this.c);
            this.a.add(this.h);
            vq5 vq5Var = new vq5(this.b);
            this.i = vq5Var;
            vq5Var.M(this.c);
            this.a.add(this.i);
            wq5 wq5Var = new wq5(this.b);
            this.j = wq5Var;
            wq5Var.M(this.c);
            this.a.add(this.j);
            yq5 yq5Var = new yq5(this.b);
            this.k = yq5Var;
            yq5Var.M(this.c);
            this.a.add(this.k);
            xq5 xq5Var = new xq5(this.b);
            this.l = xq5Var;
            xq5Var.M(this.c);
            this.a.add(this.l);
            br5 br5Var = new br5(this.b);
            this.m = br5Var;
            br5Var.M(this.c);
            this.a.add(this.m);
            ar5 ar5Var = new ar5(this.b);
            this.n = ar5Var;
            ar5Var.M(this.c);
            this.a.add(this.n);
            qq5 qq5Var = new qq5(this.b);
            this.p = qq5Var;
            qq5Var.M(this.c);
            this.a.add(this.p);
            pq5 pq5Var = new pq5(this.b, ym6.S0);
            this.q = pq5Var;
            this.a.add(pq5Var);
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
                if (ciVar instanceof rq5) {
                    ((rq5) ciVar).t(i);
                }
            }
        }
    }

    public void f(er5 er5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, er5Var) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof rq5) {
                    ((rq5) ciVar).J(er5Var);
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

    public void i(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xu4Var) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof rq5) {
                    ((rq5) ciVar).K(xu4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof rq5) {
                    ((rq5) ciVar).L(bdUniqueId);
                }
            }
        }
    }

    public void k(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viVar) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof rq5) {
                    ((rq5) ciVar).M(viVar);
                }
            }
        }
    }
}
