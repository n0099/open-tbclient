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
public class ss5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<lm> a;
    public TbPageContext<?> b;
    public en c;
    public ht5 d;
    public dt5 e;
    public ws5 f;
    public ys5 g;
    public xs5 h;
    public zs5 i;
    public at5 j;
    public ct5 k;
    public bt5 l;
    public ft5 m;
    public et5 n;
    public gt5 o;
    public us5 p;
    public ts5 q;

    public ss5(TbPageContext tbPageContext, en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, enVar};
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
        this.c = enVar;
        b();
    }

    public void a(List<lm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (lm lmVar : list) {
            if (!c(lmVar.getType())) {
                this.a.add(lmVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (lm lmVar : this.a) {
                    if (lmVar != null && lmVar.getType() == bdUniqueId) {
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
            ht5 ht5Var = new ht5(this.b);
            this.d = ht5Var;
            ht5Var.M(this.c);
            this.a.add(this.d);
            dt5 dt5Var = new dt5(this.b);
            this.e = dt5Var;
            dt5Var.M(this.c);
            this.a.add(this.e);
            gt5 gt5Var = new gt5(this.b);
            this.o = gt5Var;
            gt5Var.M(this.c);
            this.a.add(this.o);
            ws5 ws5Var = new ws5(this.b);
            this.f = ws5Var;
            ws5Var.M(this.c);
            this.a.add(this.f);
            ys5 ys5Var = new ys5(this.b);
            this.g = ys5Var;
            ys5Var.M(this.c);
            this.a.add(this.g);
            xs5 xs5Var = new xs5(this.b);
            this.h = xs5Var;
            xs5Var.M(this.c);
            this.a.add(this.h);
            zs5 zs5Var = new zs5(this.b);
            this.i = zs5Var;
            zs5Var.M(this.c);
            this.a.add(this.i);
            at5 at5Var = new at5(this.b);
            this.j = at5Var;
            at5Var.M(this.c);
            this.a.add(this.j);
            ct5 ct5Var = new ct5(this.b);
            this.k = ct5Var;
            ct5Var.M(this.c);
            this.a.add(this.k);
            bt5 bt5Var = new bt5(this.b);
            this.l = bt5Var;
            bt5Var.M(this.c);
            this.a.add(this.l);
            ft5 ft5Var = new ft5(this.b);
            this.m = ft5Var;
            ft5Var.M(this.c);
            this.a.add(this.m);
            et5 et5Var = new et5(this.b);
            this.n = et5Var;
            et5Var.M(this.c);
            this.a.add(this.n);
            us5 us5Var = new us5(this.b);
            this.p = us5Var;
            us5Var.M(this.c);
            this.a.add(this.p);
            ts5 ts5Var = new ts5(this.b, qn6.S0);
            this.q = ts5Var;
            this.a.add(ts5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        en enVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (enVar = this.c) != null && enVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof vs5) {
                    ((vs5) lmVar).s(i);
                }
            }
        }
    }

    public void f(it5 it5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, it5Var) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof vs5) {
                    ((vs5) lmVar).I(it5Var);
                }
            }
        }
    }

    public void g(List<lm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(mz4 mz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mz4Var) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof vs5) {
                    ((vs5) lmVar).J(mz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof vs5) {
                    ((vs5) lmVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, enVar) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof vs5) {
                    ((vs5) lmVar).M(enVar);
                }
            }
        }
    }
}
