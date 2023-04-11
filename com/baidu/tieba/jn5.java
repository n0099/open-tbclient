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
public class jn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<um> a;
    public TbPageContext<?> b;
    public nn c;
    public yn5 d;
    public un5 e;
    public nn5 f;
    public pn5 g;
    public on5 h;
    public qn5 i;
    public rn5 j;
    public tn5 k;
    public sn5 l;
    public wn5 m;
    public vn5 n;
    public xn5 o;
    public ln5 p;
    public kn5 q;

    public jn5(TbPageContext tbPageContext, nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nnVar};
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
        this.c = nnVar;
        b();
    }

    public void a(List<um> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (um umVar : list) {
            if (!c(umVar.getType())) {
                this.a.add(umVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (um umVar : this.a) {
                    if (umVar != null && umVar.getType() == bdUniqueId) {
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
            yn5 yn5Var = new yn5(this.b);
            this.d = yn5Var;
            yn5Var.M(this.c);
            this.a.add(this.d);
            un5 un5Var = new un5(this.b);
            this.e = un5Var;
            un5Var.M(this.c);
            this.a.add(this.e);
            xn5 xn5Var = new xn5(this.b);
            this.o = xn5Var;
            xn5Var.M(this.c);
            this.a.add(this.o);
            nn5 nn5Var = new nn5(this.b);
            this.f = nn5Var;
            nn5Var.M(this.c);
            this.a.add(this.f);
            pn5 pn5Var = new pn5(this.b);
            this.g = pn5Var;
            pn5Var.M(this.c);
            this.a.add(this.g);
            on5 on5Var = new on5(this.b);
            this.h = on5Var;
            on5Var.M(this.c);
            this.a.add(this.h);
            qn5 qn5Var = new qn5(this.b);
            this.i = qn5Var;
            qn5Var.M(this.c);
            this.a.add(this.i);
            rn5 rn5Var = new rn5(this.b);
            this.j = rn5Var;
            rn5Var.M(this.c);
            this.a.add(this.j);
            tn5 tn5Var = new tn5(this.b);
            this.k = tn5Var;
            tn5Var.M(this.c);
            this.a.add(this.k);
            sn5 sn5Var = new sn5(this.b);
            this.l = sn5Var;
            sn5Var.M(this.c);
            this.a.add(this.l);
            wn5 wn5Var = new wn5(this.b);
            this.m = wn5Var;
            wn5Var.M(this.c);
            this.a.add(this.m);
            vn5 vn5Var = new vn5(this.b);
            this.n = vn5Var;
            vn5Var.M(this.c);
            this.a.add(this.n);
            ln5 ln5Var = new ln5(this.b);
            this.p = ln5Var;
            ln5Var.M(this.c);
            this.a.add(this.p);
            kn5 kn5Var = new kn5(this.b, lh6.Q0);
            this.q = kn5Var;
            this.a.add(kn5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        nn nnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (nnVar = this.c) != null && nnVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (um umVar : this.a) {
                if (umVar instanceof mn5) {
                    ((mn5) umVar).s(i);
                }
            }
        }
    }

    public void f(zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zn5Var) == null) {
            for (um umVar : this.a) {
                if (umVar instanceof mn5) {
                    ((mn5) umVar).I(zn5Var);
                }
            }
        }
    }

    public void g(List<um> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(zu4 zu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zu4Var) == null) {
            for (um umVar : this.a) {
                if (umVar instanceof mn5) {
                    ((mn5) umVar).J(zu4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (um umVar : this.a) {
                if (umVar instanceof mn5) {
                    ((mn5) umVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nnVar) == null) {
            for (um umVar : this.a) {
                if (umVar instanceof mn5) {
                    ((mn5) umVar).M(nnVar);
                }
            }
        }
    }
}
