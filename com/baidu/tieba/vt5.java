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
public class vt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<jn> a;
    public TbPageContext<?> b;
    public co c;
    public ku5 d;
    public gu5 e;
    public zt5 f;
    public bu5 g;
    public au5 h;
    public cu5 i;
    public du5 j;
    public fu5 k;
    public eu5 l;
    public iu5 m;
    public hu5 n;
    public ju5 o;
    public xt5 p;
    public wt5 q;

    public vt5(TbPageContext tbPageContext, co coVar) {
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
        this.c.addAdapters(this.a);
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
            ku5 ku5Var = new ku5(this.b);
            this.d = ku5Var;
            ku5Var.M(this.c);
            this.a.add(this.d);
            gu5 gu5Var = new gu5(this.b);
            this.e = gu5Var;
            gu5Var.M(this.c);
            this.a.add(this.e);
            ju5 ju5Var = new ju5(this.b);
            this.o = ju5Var;
            ju5Var.M(this.c);
            this.a.add(this.o);
            zt5 zt5Var = new zt5(this.b);
            this.f = zt5Var;
            zt5Var.M(this.c);
            this.a.add(this.f);
            bu5 bu5Var = new bu5(this.b);
            this.g = bu5Var;
            bu5Var.M(this.c);
            this.a.add(this.g);
            au5 au5Var = new au5(this.b);
            this.h = au5Var;
            au5Var.M(this.c);
            this.a.add(this.h);
            cu5 cu5Var = new cu5(this.b);
            this.i = cu5Var;
            cu5Var.M(this.c);
            this.a.add(this.i);
            du5 du5Var = new du5(this.b);
            this.j = du5Var;
            du5Var.M(this.c);
            this.a.add(this.j);
            fu5 fu5Var = new fu5(this.b);
            this.k = fu5Var;
            fu5Var.M(this.c);
            this.a.add(this.k);
            eu5 eu5Var = new eu5(this.b);
            this.l = eu5Var;
            eu5Var.M(this.c);
            this.a.add(this.l);
            iu5 iu5Var = new iu5(this.b);
            this.m = iu5Var;
            iu5Var.M(this.c);
            this.a.add(this.m);
            hu5 hu5Var = new hu5(this.b);
            this.n = hu5Var;
            hu5Var.M(this.c);
            this.a.add(this.n);
            xt5 xt5Var = new xt5(this.b);
            this.p = xt5Var;
            xt5Var.M(this.c);
            this.a.add(this.p);
            wt5 wt5Var = new wt5(this.b, ap6.R0);
            this.q = wt5Var;
            this.a.add(wt5Var);
            this.c.addAdapters(this.a);
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
                if (jnVar instanceof yt5) {
                    ((yt5) jnVar).s(i);
                }
            }
        }
    }

    public void f(lu5 lu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lu5Var) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof yt5) {
                    ((yt5) jnVar).I(lu5Var);
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
        this.c.addAdapters(this.a);
    }

    public void h(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wz4Var) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof yt5) {
                    ((yt5) jnVar).J(wz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof yt5) {
                    ((yt5) jnVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, coVar) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof yt5) {
                    ((yt5) jnVar).M(coVar);
                }
            }
        }
    }
}
