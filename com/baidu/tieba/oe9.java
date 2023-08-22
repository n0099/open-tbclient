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
public class oe9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<om> b;
    public List<bn> c;
    public ne9 d;
    public le9 e;
    public me9 f;
    public cf9 g;

    public oe9(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, te9 te9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), te9Var, Integer.valueOf(i2)}) == null) {
            new ye9().a(i, te9Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (list = this.c) != null && list.size() > 0) {
            for (bn bnVar : this.c) {
                if (bnVar != null && (bnVar instanceof ue9)) {
                    ue9 ue9Var = (ue9) bnVar;
                    ue9Var.r(z);
                    h(ue9Var);
                }
            }
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void j(List<re9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, list) != null) || this.a == null) {
            return;
        }
        List<bn> b = new ye9().b(list);
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

    public List<bn> c() {
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
            this.d = new ne9(context, we9.c);
            this.e = new le9(context, ue9.i);
            this.f = new me9(context, ve9.d);
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
            List<bn> list = this.c;
            if (list != null && list.size() > 0) {
                for (bn bnVar : this.c) {
                    if (bnVar != null && (bnVar instanceof ue9) && ((ue9) bnVar).h()) {
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
            List<bn> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (bn bnVar : this.c) {
                if (bnVar != null && (bnVar instanceof ue9) && !((ue9) bnVar).h()) {
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
            ne9 ne9Var = this.d;
            if (ne9Var != null) {
                ne9Var.notifyDataSetChanged();
            }
            le9 le9Var = this.e;
            if (le9Var != null) {
                le9Var.notifyDataSetChanged();
            }
            me9 me9Var = this.f;
            if (me9Var != null) {
                me9Var.notifyDataSetChanged();
            }
        }
    }

    public final void h(ue9 ue9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ue9Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", ue9Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(bf9 bf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bf9Var) == null) {
            this.f.z(bf9Var);
        }
    }

    public void k(cf9 cf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cf9Var) == null) {
            this.g = cf9Var;
            this.e.B(cf9Var);
            this.f.A(cf9Var);
        }
    }
}
