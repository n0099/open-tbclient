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
/* loaded from: classes5.dex */
public class rs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<qn> b;
    public List<Cdo> c;
    public qs7 d;
    public os7 e;
    public ps7 f;
    public ft7 g;

    public rs7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, ws7 ws7Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ws7Var, Integer.valueOf(i2)}) == null) {
            new bt7().a(i, ws7Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.c) == null || list.size() <= 0) {
            return;
        }
        for (Cdo cdo : this.c) {
            if (cdo != null && (cdo instanceof xs7)) {
                xs7 xs7Var = (xs7) cdo;
                xs7Var.t(z);
                h(xs7Var);
            }
        }
        this.a.getAdapter().notifyDataSetChanged();
    }

    public List<Cdo> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.d = new qs7(context, zs7.c);
            this.e = new os7(context, xs7.i);
            this.f = new ps7(context, ys7.d);
            this.b.add(this.d);
            this.b.add(this.e);
            this.b.add(this.f);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.a(this.b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<Cdo> list = this.c;
            if (list != null && list.size() > 0) {
                for (Cdo cdo : this.c) {
                    if (cdo != null && (cdo instanceof xs7) && ((xs7) cdo).k()) {
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
            List<Cdo> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (Cdo cdo : this.c) {
                if (cdo != null && (cdo instanceof xs7) && !((xs7) cdo).k()) {
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
            qs7 qs7Var = this.d;
            if (qs7Var != null) {
                qs7Var.notifyDataSetChanged();
            }
            os7 os7Var = this.e;
            if (os7Var != null) {
                os7Var.notifyDataSetChanged();
            }
            ps7 ps7Var = this.f;
            if (ps7Var != null) {
                ps7Var.notifyDataSetChanged();
            }
        }
    }

    public final void h(xs7 xs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xs7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", xs7Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, et7Var) == null) {
            this.f.x(et7Var);
        }
    }

    public void j(List<us7> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<Cdo> b = new bt7().b(list);
        if (ListUtils.isEmpty(this.c)) {
            this.c = b;
        } else {
            this.c.addAll(b);
        }
        if (ListUtils.isEmpty(this.c)) {
            return;
        }
        this.a.setData(this.c);
        this.g.a();
    }

    public void k(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ft7Var) == null) {
            this.g = ft7Var;
            this.e.z(ft7Var);
            this.f.y(ft7Var);
        }
    }
}
