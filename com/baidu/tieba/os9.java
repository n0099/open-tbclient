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
public class os9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<ci> b;
    public List<pi> c;
    public ns9 d;
    public ls9 e;
    public ms9 f;
    public ct9 g;

    public os9(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, ts9 ts9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ts9Var, Integer.valueOf(i2)}) == null) {
            new ys9().a(i, ts9Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<pi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (list = this.c) != null && list.size() > 0) {
            for (pi piVar : this.c) {
                if (piVar != null && (piVar instanceof us9)) {
                    us9 us9Var = (us9) piVar;
                    us9Var.s(z);
                    h(us9Var);
                }
            }
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void j(List<rs9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, list) != null) || this.a == null) {
            return;
        }
        List<pi> b = new ys9().b(list);
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

    public List<pi> c() {
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
            this.d = new ns9(context, ws9.c);
            this.e = new ls9(context, us9.i);
            this.f = new ms9(context, vs9.d);
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
            List<pi> list = this.c;
            if (list != null && list.size() > 0) {
                for (pi piVar : this.c) {
                    if (piVar != null && (piVar instanceof us9) && ((us9) piVar).h()) {
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
            List<pi> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (pi piVar : this.c) {
                if (piVar != null && (piVar instanceof us9) && !((us9) piVar).h()) {
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
            ns9 ns9Var = this.d;
            if (ns9Var != null) {
                ns9Var.notifyDataSetChanged();
            }
            ls9 ls9Var = this.e;
            if (ls9Var != null) {
                ls9Var.notifyDataSetChanged();
            }
            ms9 ms9Var = this.f;
            if (ms9Var != null) {
                ms9Var.notifyDataSetChanged();
            }
        }
    }

    public final void h(us9 us9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, us9Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", us9Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(bt9 bt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bt9Var) == null) {
            this.f.A(bt9Var);
        }
    }

    public void k(ct9 ct9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ct9Var) == null) {
            this.g = ct9Var;
            this.e.C(ct9Var);
            this.f.B(ct9Var);
        }
    }
}
