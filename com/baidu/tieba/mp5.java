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
public class mp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<en> a;
    public TbPageContext<?> b;
    public xn c;
    public bq5 d;
    public xp5 e;
    public qp5 f;
    public sp5 g;
    public rp5 h;
    public tp5 i;
    public up5 j;
    public wp5 k;
    public vp5 l;
    public zp5 m;
    public yp5 n;
    public aq5 o;
    public op5 p;
    public np5 q;

    public mp5(TbPageContext tbPageContext, xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xnVar};
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
        this.c = xnVar;
        b();
    }

    public void a(List<en> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (en enVar : list) {
            if (!c(enVar.getType())) {
                this.a.add(enVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (en enVar : this.a) {
                    if (enVar != null && enVar.getType() == bdUniqueId) {
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
            bq5 bq5Var = new bq5(this.b);
            this.d = bq5Var;
            bq5Var.M(this.c);
            this.a.add(this.d);
            xp5 xp5Var = new xp5(this.b);
            this.e = xp5Var;
            xp5Var.M(this.c);
            this.a.add(this.e);
            aq5 aq5Var = new aq5(this.b);
            this.o = aq5Var;
            aq5Var.M(this.c);
            this.a.add(this.o);
            qp5 qp5Var = new qp5(this.b);
            this.f = qp5Var;
            qp5Var.M(this.c);
            this.a.add(this.f);
            sp5 sp5Var = new sp5(this.b);
            this.g = sp5Var;
            sp5Var.M(this.c);
            this.a.add(this.g);
            rp5 rp5Var = new rp5(this.b);
            this.h = rp5Var;
            rp5Var.M(this.c);
            this.a.add(this.h);
            tp5 tp5Var = new tp5(this.b);
            this.i = tp5Var;
            tp5Var.M(this.c);
            this.a.add(this.i);
            up5 up5Var = new up5(this.b);
            this.j = up5Var;
            up5Var.M(this.c);
            this.a.add(this.j);
            wp5 wp5Var = new wp5(this.b);
            this.k = wp5Var;
            wp5Var.M(this.c);
            this.a.add(this.k);
            vp5 vp5Var = new vp5(this.b);
            this.l = vp5Var;
            vp5Var.M(this.c);
            this.a.add(this.l);
            zp5 zp5Var = new zp5(this.b);
            this.m = zp5Var;
            zp5Var.M(this.c);
            this.a.add(this.m);
            yp5 yp5Var = new yp5(this.b);
            this.n = yp5Var;
            yp5Var.M(this.c);
            this.a.add(this.n);
            op5 op5Var = new op5(this.b);
            this.p = op5Var;
            op5Var.M(this.c);
            this.a.add(this.p);
            np5 np5Var = new np5(this.b, kk6.Q0);
            this.q = np5Var;
            this.a.add(np5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        xn xnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (xnVar = this.c) != null && xnVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (en enVar : this.a) {
                if (enVar instanceof pp5) {
                    ((pp5) enVar).s(i);
                }
            }
        }
    }

    public void f(cq5 cq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cq5Var) == null) {
            for (en enVar : this.a) {
                if (enVar instanceof pp5) {
                    ((pp5) enVar).I(cq5Var);
                }
            }
        }
    }

    public void g(List<en> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zw4Var) == null) {
            for (en enVar : this.a) {
                if (enVar instanceof pp5) {
                    ((pp5) enVar).J(zw4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (en enVar : this.a) {
                if (enVar instanceof pp5) {
                    ((pp5) enVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xnVar) == null) {
            for (en enVar : this.a) {
                if (enVar instanceof pp5) {
                    ((pp5) enVar).M(xnVar);
                }
            }
        }
    }
}
