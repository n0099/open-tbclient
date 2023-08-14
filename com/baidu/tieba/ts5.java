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
public class ts5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<lm> a;
    public TbPageContext<?> b;
    public en c;
    public it5 d;
    public et5 e;
    public xs5 f;
    public zs5 g;
    public ys5 h;
    public at5 i;
    public bt5 j;
    public dt5 k;
    public ct5 l;
    public gt5 m;
    public ft5 n;
    public ht5 o;
    public vs5 p;
    public us5 q;

    public ts5(TbPageContext tbPageContext, en enVar) {
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
            it5 it5Var = new it5(this.b);
            this.d = it5Var;
            it5Var.M(this.c);
            this.a.add(this.d);
            et5 et5Var = new et5(this.b);
            this.e = et5Var;
            et5Var.M(this.c);
            this.a.add(this.e);
            ht5 ht5Var = new ht5(this.b);
            this.o = ht5Var;
            ht5Var.M(this.c);
            this.a.add(this.o);
            xs5 xs5Var = new xs5(this.b);
            this.f = xs5Var;
            xs5Var.M(this.c);
            this.a.add(this.f);
            zs5 zs5Var = new zs5(this.b);
            this.g = zs5Var;
            zs5Var.M(this.c);
            this.a.add(this.g);
            ys5 ys5Var = new ys5(this.b);
            this.h = ys5Var;
            ys5Var.M(this.c);
            this.a.add(this.h);
            at5 at5Var = new at5(this.b);
            this.i = at5Var;
            at5Var.M(this.c);
            this.a.add(this.i);
            bt5 bt5Var = new bt5(this.b);
            this.j = bt5Var;
            bt5Var.M(this.c);
            this.a.add(this.j);
            dt5 dt5Var = new dt5(this.b);
            this.k = dt5Var;
            dt5Var.M(this.c);
            this.a.add(this.k);
            ct5 ct5Var = new ct5(this.b);
            this.l = ct5Var;
            ct5Var.M(this.c);
            this.a.add(this.l);
            gt5 gt5Var = new gt5(this.b);
            this.m = gt5Var;
            gt5Var.M(this.c);
            this.a.add(this.m);
            ft5 ft5Var = new ft5(this.b);
            this.n = ft5Var;
            ft5Var.M(this.c);
            this.a.add(this.n);
            vs5 vs5Var = new vs5(this.b);
            this.p = vs5Var;
            vs5Var.M(this.c);
            this.a.add(this.p);
            us5 us5Var = new us5(this.b, rn6.S0);
            this.q = us5Var;
            this.a.add(us5Var);
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
                if (lmVar instanceof ws5) {
                    ((ws5) lmVar).s(i);
                }
            }
        }
    }

    public void f(jt5 jt5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jt5Var) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof ws5) {
                    ((ws5) lmVar).I(jt5Var);
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
                if (lmVar instanceof ws5) {
                    ((ws5) lmVar).J(mz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof ws5) {
                    ((ws5) lmVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, enVar) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof ws5) {
                    ((ws5) lmVar).M(enVar);
                }
            }
        }
    }
}
