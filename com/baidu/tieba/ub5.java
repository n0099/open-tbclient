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
public class ub5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<cn> a;
    public TbPageContext<?> b;
    public vn c;
    public jc5 d;
    public fc5 e;
    public yb5 f;
    public ac5 g;
    public zb5 h;
    public bc5 i;
    public cc5 j;
    public ec5 k;
    public dc5 l;
    public hc5 m;
    public gc5 n;
    public ic5 o;
    public wb5 p;
    public vb5 q;

    public ub5(TbPageContext tbPageContext, vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vnVar};
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
        this.c = vnVar;
        b();
    }

    public void a(List<cn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (cn cnVar : list) {
            if (!c(cnVar.getType())) {
                this.a.add(cnVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            jc5 jc5Var = new jc5(this.b);
            this.d = jc5Var;
            jc5Var.K(this.c);
            this.a.add(this.d);
            fc5 fc5Var = new fc5(this.b);
            this.e = fc5Var;
            fc5Var.K(this.c);
            this.a.add(this.e);
            ic5 ic5Var = new ic5(this.b);
            this.o = ic5Var;
            ic5Var.K(this.c);
            this.a.add(this.o);
            yb5 yb5Var = new yb5(this.b);
            this.f = yb5Var;
            yb5Var.K(this.c);
            this.a.add(this.f);
            ac5 ac5Var = new ac5(this.b);
            this.g = ac5Var;
            ac5Var.K(this.c);
            this.a.add(this.g);
            zb5 zb5Var = new zb5(this.b);
            this.h = zb5Var;
            zb5Var.K(this.c);
            this.a.add(this.h);
            bc5 bc5Var = new bc5(this.b);
            this.i = bc5Var;
            bc5Var.K(this.c);
            this.a.add(this.i);
            cc5 cc5Var = new cc5(this.b);
            this.j = cc5Var;
            cc5Var.K(this.c);
            this.a.add(this.j);
            ec5 ec5Var = new ec5(this.b);
            this.k = ec5Var;
            ec5Var.K(this.c);
            this.a.add(this.k);
            dc5 dc5Var = new dc5(this.b);
            this.l = dc5Var;
            dc5Var.K(this.c);
            this.a.add(this.l);
            hc5 hc5Var = new hc5(this.b);
            this.m = hc5Var;
            hc5Var.K(this.c);
            this.a.add(this.m);
            gc5 gc5Var = new gc5(this.b);
            this.n = gc5Var;
            gc5Var.K(this.c);
            this.a.add(this.n);
            wb5 wb5Var = new wb5(this.b);
            this.p = wb5Var;
            wb5Var.K(this.c);
            this.a.add(this.p);
            vb5 vb5Var = new vb5(this.b, s06.N0);
            this.q = vb5Var;
            this.a.add(vb5Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (cn cnVar : this.a) {
                    if (cnVar != null && cnVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        vn vnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (vnVar = this.c) == null || vnVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof xb5) {
                    ((xb5) cnVar).s(i);
                }
            }
        }
    }

    public void f(kc5 kc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kc5Var) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof xb5) {
                    ((xb5) cnVar).G(kc5Var);
                }
            }
        }
    }

    public void g(List<cn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cn4Var) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof xb5) {
                    ((xb5) cnVar).H(cn4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof xb5) {
                    ((xb5) cnVar).J(bdUniqueId);
                }
            }
        }
    }

    public void k(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vnVar) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof xb5) {
                    ((xb5) cnVar).K(vnVar);
                }
            }
        }
    }
}
