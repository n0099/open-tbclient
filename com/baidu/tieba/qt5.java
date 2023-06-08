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
public class qt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<in> a;
    public TbPageContext<?> b;
    public bo c;
    public fu5 d;
    public bu5 e;
    public ut5 f;
    public wt5 g;
    public vt5 h;
    public xt5 i;
    public yt5 j;
    public au5 k;
    public zt5 l;
    public du5 m;
    public cu5 n;
    public eu5 o;
    public st5 p;
    public rt5 q;

    public qt5(TbPageContext tbPageContext, bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, boVar};
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
        this.c = boVar;
        b();
    }

    public void a(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (in inVar : list) {
            if (!c(inVar.getType())) {
                this.a.add(inVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (in inVar : this.a) {
                    if (inVar != null && inVar.getType() == bdUniqueId) {
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
            fu5 fu5Var = new fu5(this.b);
            this.d = fu5Var;
            fu5Var.M(this.c);
            this.a.add(this.d);
            bu5 bu5Var = new bu5(this.b);
            this.e = bu5Var;
            bu5Var.M(this.c);
            this.a.add(this.e);
            eu5 eu5Var = new eu5(this.b);
            this.o = eu5Var;
            eu5Var.M(this.c);
            this.a.add(this.o);
            ut5 ut5Var = new ut5(this.b);
            this.f = ut5Var;
            ut5Var.M(this.c);
            this.a.add(this.f);
            wt5 wt5Var = new wt5(this.b);
            this.g = wt5Var;
            wt5Var.M(this.c);
            this.a.add(this.g);
            vt5 vt5Var = new vt5(this.b);
            this.h = vt5Var;
            vt5Var.M(this.c);
            this.a.add(this.h);
            xt5 xt5Var = new xt5(this.b);
            this.i = xt5Var;
            xt5Var.M(this.c);
            this.a.add(this.i);
            yt5 yt5Var = new yt5(this.b);
            this.j = yt5Var;
            yt5Var.M(this.c);
            this.a.add(this.j);
            au5 au5Var = new au5(this.b);
            this.k = au5Var;
            au5Var.M(this.c);
            this.a.add(this.k);
            zt5 zt5Var = new zt5(this.b);
            this.l = zt5Var;
            zt5Var.M(this.c);
            this.a.add(this.l);
            du5 du5Var = new du5(this.b);
            this.m = du5Var;
            du5Var.M(this.c);
            this.a.add(this.m);
            cu5 cu5Var = new cu5(this.b);
            this.n = cu5Var;
            cu5Var.M(this.c);
            this.a.add(this.n);
            st5 st5Var = new st5(this.b);
            this.p = st5Var;
            st5Var.M(this.c);
            this.a.add(this.p);
            rt5 rt5Var = new rt5(this.b, vo6.Q0);
            this.q = rt5Var;
            this.a.add(rt5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        bo boVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (boVar = this.c) != null && boVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof tt5) {
                    ((tt5) inVar).s(i);
                }
            }
        }
    }

    public void f(gu5 gu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gu5Var) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof tt5) {
                    ((tt5) inVar).I(gu5Var);
                }
            }
        }
    }

    public void g(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(vz4 vz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vz4Var) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof tt5) {
                    ((tt5) inVar).J(vz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof tt5) {
                    ((tt5) inVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, boVar) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof tt5) {
                    ((tt5) inVar).M(boVar);
                }
            }
        }
    }
}
