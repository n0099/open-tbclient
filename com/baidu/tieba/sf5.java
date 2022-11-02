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
public class sf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<jn> a;
    public TbPageContext<?> b;
    public co c;
    public hg5 d;
    public dg5 e;
    public wf5 f;
    public yf5 g;
    public xf5 h;
    public zf5 i;
    public ag5 j;
    public cg5 k;
    public bg5 l;
    public fg5 m;
    public eg5 n;
    public gg5 o;
    public uf5 p;
    public tf5 q;

    public sf5(TbPageContext tbPageContext, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, coVar};
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
        this.c = coVar;
        b();
    }

    public void a(List<jn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (jn jnVar : list) {
            if (!c(jnVar.getType())) {
                this.a.add(jnVar);
            }
        }
        this.c.a(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (jn jnVar : this.a) {
                    if (jnVar != null && jnVar.getType() == bdUniqueId) {
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
            hg5 hg5Var = new hg5(this.b);
            this.d = hg5Var;
            hg5Var.K(this.c);
            this.a.add(this.d);
            dg5 dg5Var = new dg5(this.b);
            this.e = dg5Var;
            dg5Var.K(this.c);
            this.a.add(this.e);
            gg5 gg5Var = new gg5(this.b);
            this.o = gg5Var;
            gg5Var.K(this.c);
            this.a.add(this.o);
            wf5 wf5Var = new wf5(this.b);
            this.f = wf5Var;
            wf5Var.K(this.c);
            this.a.add(this.f);
            yf5 yf5Var = new yf5(this.b);
            this.g = yf5Var;
            yf5Var.K(this.c);
            this.a.add(this.g);
            xf5 xf5Var = new xf5(this.b);
            this.h = xf5Var;
            xf5Var.K(this.c);
            this.a.add(this.h);
            zf5 zf5Var = new zf5(this.b);
            this.i = zf5Var;
            zf5Var.K(this.c);
            this.a.add(this.i);
            ag5 ag5Var = new ag5(this.b);
            this.j = ag5Var;
            ag5Var.K(this.c);
            this.a.add(this.j);
            cg5 cg5Var = new cg5(this.b);
            this.k = cg5Var;
            cg5Var.K(this.c);
            this.a.add(this.k);
            bg5 bg5Var = new bg5(this.b);
            this.l = bg5Var;
            bg5Var.K(this.c);
            this.a.add(this.l);
            fg5 fg5Var = new fg5(this.b);
            this.m = fg5Var;
            fg5Var.K(this.c);
            this.a.add(this.m);
            eg5 eg5Var = new eg5(this.b);
            this.n = eg5Var;
            eg5Var.K(this.c);
            this.a.add(this.n);
            uf5 uf5Var = new uf5(this.b);
            this.p = uf5Var;
            uf5Var.K(this.c);
            this.a.add(this.p);
            tf5 tf5Var = new tf5(this.b, n46.N0);
            this.q = tf5Var;
            this.a.add(tf5Var);
            this.c.a(this.a);
        }
    }

    public void d() {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (coVar = this.c) != null && coVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof vf5) {
                    ((vf5) jnVar).s(i);
                }
            }
        }
    }

    public void f(ig5 ig5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ig5Var) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof vf5) {
                    ((vf5) jnVar).G(ig5Var);
                }
            }
        }
    }

    public void g(List<jn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(iq4 iq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iq4Var) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof vf5) {
                    ((vf5) jnVar).H(iq4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof vf5) {
                    ((vf5) jnVar).I(bdUniqueId);
                }
            }
        }
    }

    public void k(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, coVar) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof vf5) {
                    ((vf5) jnVar).K(coVar);
                }
            }
        }
    }
}
