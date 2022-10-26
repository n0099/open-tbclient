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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class we5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List a;
    public TbPageContext b;
    public ko c;
    public lf5 d;
    public hf5 e;
    public af5 f;
    public cf5 g;
    public bf5 h;
    public df5 i;
    public ef5 j;
    public gf5 k;
    public ff5 l;
    public jf5 m;
    public if5 n;
    public kf5 o;
    public ye5 p;
    public xe5 q;

    public we5(TbPageContext tbPageContext, ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, koVar};
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
        this.c = koVar;
        b();
    }

    public void a(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rn rnVar = (rn) it.next();
            if (!c(rnVar.getType())) {
                this.a.add(rnVar);
            }
        }
        this.c.a(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (rn rnVar : this.a) {
                    if (rnVar != null && rnVar.getType() == bdUniqueId) {
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
            lf5 lf5Var = new lf5(this.b);
            this.d = lf5Var;
            lf5Var.K(this.c);
            this.a.add(this.d);
            hf5 hf5Var = new hf5(this.b);
            this.e = hf5Var;
            hf5Var.K(this.c);
            this.a.add(this.e);
            kf5 kf5Var = new kf5(this.b);
            this.o = kf5Var;
            kf5Var.K(this.c);
            this.a.add(this.o);
            af5 af5Var = new af5(this.b);
            this.f = af5Var;
            af5Var.K(this.c);
            this.a.add(this.f);
            cf5 cf5Var = new cf5(this.b);
            this.g = cf5Var;
            cf5Var.K(this.c);
            this.a.add(this.g);
            bf5 bf5Var = new bf5(this.b);
            this.h = bf5Var;
            bf5Var.K(this.c);
            this.a.add(this.h);
            df5 df5Var = new df5(this.b);
            this.i = df5Var;
            df5Var.K(this.c);
            this.a.add(this.i);
            ef5 ef5Var = new ef5(this.b);
            this.j = ef5Var;
            ef5Var.K(this.c);
            this.a.add(this.j);
            gf5 gf5Var = new gf5(this.b);
            this.k = gf5Var;
            gf5Var.K(this.c);
            this.a.add(this.k);
            ff5 ff5Var = new ff5(this.b);
            this.l = ff5Var;
            ff5Var.K(this.c);
            this.a.add(this.l);
            jf5 jf5Var = new jf5(this.b);
            this.m = jf5Var;
            jf5Var.K(this.c);
            this.a.add(this.m);
            if5 if5Var = new if5(this.b);
            this.n = if5Var;
            if5Var.K(this.c);
            this.a.add(this.n);
            ye5 ye5Var = new ye5(this.b);
            this.p = ye5Var;
            ye5Var.K(this.c);
            this.a.add(this.p);
            xe5 xe5Var = new xe5(this.b, d36.N0);
            this.q = xe5Var;
            this.a.add(xe5Var);
            this.c.a(this.a);
        }
    }

    public void d() {
        ko koVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (koVar = this.c) != null && koVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (rn rnVar : this.a) {
                if (rnVar instanceof ze5) {
                    ((ze5) rnVar).s(i);
                }
            }
        }
    }

    public void f(mf5 mf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mf5Var) == null) {
            for (rn rnVar : this.a) {
                if (rnVar instanceof ze5) {
                    ((ze5) rnVar).G(mf5Var);
                }
            }
        }
    }

    public void g(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(rp4 rp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rp4Var) == null) {
            for (rn rnVar : this.a) {
                if (rnVar instanceof ze5) {
                    ((ze5) rnVar).H(rp4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (rn rnVar : this.a) {
                if (rnVar instanceof ze5) {
                    ((ze5) rnVar).I(bdUniqueId);
                }
            }
        }
    }

    public void k(ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, koVar) == null) {
            for (rn rnVar : this.a) {
                if (rnVar instanceof ze5) {
                    ((ze5) rnVar).K(koVar);
                }
            }
        }
    }
}
