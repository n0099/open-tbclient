package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<pm> b;
    public List<cn> c;
    public pf9 d;
    public nf9 e;
    public of9 f;
    public eg9 g;

    public qf9(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i, vf9 vf9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), vf9Var, Integer.valueOf(i2)}) == null) {
            new ag9().a(i, vf9Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (list = this.c) != null && list.size() > 0) {
            for (cn cnVar : this.c) {
                if (cnVar != null && (cnVar instanceof wf9)) {
                    wf9 wf9Var = (wf9) cnVar;
                    wf9Var.s(z);
                    h(wf9Var);
                }
            }
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void j(List<tf9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, list) != null) || this.a == null) {
            return;
        }
        List<cn> b = new ag9().b(list);
        if (ListUtils.isEmpty(this.c)) {
            this.c = b;
        } else {
            this.c.addAll(b);
        }
        if (!ListUtils.isEmpty(this.c)) {
            this.a.setData(this.c);
            this.g.a();
        }
    }

    public List<cn> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.d = new pf9(context, yf9.c);
            this.e = new nf9(context, wf9.i);
            this.f = new of9(context, xf9.d);
            this.b.add(this.d);
            this.b.add(this.e);
            this.b.add(this.f);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<cn> list = this.c;
            if (list != null && list.size() > 0) {
                for (cn cnVar : this.c) {
                    if (cnVar != null && (cnVar instanceof wf9) && ((wf9) cnVar).h()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<cn> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (cn cnVar : this.c) {
                if (cnVar != null && (cnVar instanceof wf9) && !((wf9) cnVar).h()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            pf9 pf9Var = this.d;
            if (pf9Var != null) {
                pf9Var.notifyDataSetChanged();
            }
            nf9 nf9Var = this.e;
            if (nf9Var != null) {
                nf9Var.notifyDataSetChanged();
            }
            of9 of9Var = this.f;
            if (of9Var != null) {
                of9Var.notifyDataSetChanged();
            }
        }
    }

    public final void h(wf9 wf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wf9Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", wf9Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(dg9 dg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dg9Var) == null) {
            this.f.z(dg9Var);
        }
    }

    public void k(eg9 eg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eg9Var) == null) {
            this.g = eg9Var;
            this.e.B(eg9Var);
            this.f.A(eg9Var);
        }
    }
}
