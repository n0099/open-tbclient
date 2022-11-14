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
public class zf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kn> a;
    public TbPageContext<?> b;
    public Cdo c;
    public og5 d;
    public kg5 e;
    public dg5 f;
    public fg5 g;
    public eg5 h;
    public gg5 i;
    public hg5 j;
    public jg5 k;
    public ig5 l;
    public mg5 m;
    public lg5 n;
    public ng5 o;
    public bg5 p;
    public ag5 q;

    public zf5(TbPageContext tbPageContext, Cdo cdo) {
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
            og5 og5Var = new og5(this.b);
            this.d = og5Var;
            og5Var.K(this.c);
            this.a.add(this.d);
            kg5 kg5Var = new kg5(this.b);
            this.e = kg5Var;
            kg5Var.K(this.c);
            this.a.add(this.e);
            ng5 ng5Var = new ng5(this.b);
            this.o = ng5Var;
            ng5Var.K(this.c);
            this.a.add(this.o);
            dg5 dg5Var = new dg5(this.b);
            this.f = dg5Var;
            dg5Var.K(this.c);
            this.a.add(this.f);
            fg5 fg5Var = new fg5(this.b);
            this.g = fg5Var;
            fg5Var.K(this.c);
            this.a.add(this.g);
            eg5 eg5Var = new eg5(this.b);
            this.h = eg5Var;
            eg5Var.K(this.c);
            this.a.add(this.h);
            gg5 gg5Var = new gg5(this.b);
            this.i = gg5Var;
            gg5Var.K(this.c);
            this.a.add(this.i);
            hg5 hg5Var = new hg5(this.b);
            this.j = hg5Var;
            hg5Var.K(this.c);
            this.a.add(this.j);
            jg5 jg5Var = new jg5(this.b);
            this.k = jg5Var;
            jg5Var.K(this.c);
            this.a.add(this.k);
            ig5 ig5Var = new ig5(this.b);
            this.l = ig5Var;
            ig5Var.K(this.c);
            this.a.add(this.l);
            mg5 mg5Var = new mg5(this.b);
            this.m = mg5Var;
            mg5Var.K(this.c);
            this.a.add(this.m);
            lg5 lg5Var = new lg5(this.b);
            this.n = lg5Var;
            lg5Var.K(this.c);
            this.a.add(this.n);
            bg5 bg5Var = new bg5(this.b);
            this.p = bg5Var;
            bg5Var.K(this.c);
            this.a.add(this.p);
            ag5 ag5Var = new ag5(this.b, z46.N0);
            this.q = ag5Var;
            this.a.add(ag5Var);
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
                if (knVar instanceof cg5) {
                    ((cg5) knVar).s(i);
                }
            }
        }
    }

    public void f(pg5 pg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pg5Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof cg5) {
                    ((cg5) knVar).G(pg5Var);
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

    public void i(jq4 jq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jq4Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof cg5) {
                    ((cg5) knVar).H(jq4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof cg5) {
                    ((cg5) knVar).I(bdUniqueId);
                }
            }
        }
    }

    public void k(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cdo) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof cg5) {
                    ((cg5) knVar).K(cdo);
                }
            }
        }
    }
}
