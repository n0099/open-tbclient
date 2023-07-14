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
/* loaded from: classes6.dex */
public class lc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<ln> b;
    public List<yn> c;
    public kc9 d;
    public ic9 e;
    public jc9 f;
    public zc9 g;

    public lc9(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, qc9 qc9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), qc9Var, Integer.valueOf(i2)}) == null) {
            new vc9().a(i, qc9Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<yn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (list = this.c) != null && list.size() > 0) {
            for (yn ynVar : this.c) {
                if (ynVar != null && (ynVar instanceof rc9)) {
                    rc9 rc9Var = (rc9) ynVar;
                    rc9Var.q(z);
                    h(rc9Var);
                }
            }
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void j(List<oc9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, list) != null) || this.a == null) {
            return;
        }
        List<yn> b = new vc9().b(list);
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

    public List<yn> c() {
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
            this.d = new kc9(context, tc9.c);
            this.e = new ic9(context, rc9.i);
            this.f = new jc9(context, sc9.d);
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
            List<yn> list = this.c;
            if (list != null && list.size() > 0) {
                for (yn ynVar : this.c) {
                    if (ynVar != null && (ynVar instanceof rc9) && ((rc9) ynVar).h()) {
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
            List<yn> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (yn ynVar : this.c) {
                if (ynVar != null && (ynVar instanceof rc9) && !((rc9) ynVar).h()) {
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
            kc9 kc9Var = this.d;
            if (kc9Var != null) {
                kc9Var.notifyDataSetChanged();
            }
            ic9 ic9Var = this.e;
            if (ic9Var != null) {
                ic9Var.notifyDataSetChanged();
            }
            jc9 jc9Var = this.f;
            if (jc9Var != null) {
                jc9Var.notifyDataSetChanged();
            }
        }
    }

    public final void h(rc9 rc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rc9Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", rc9Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(yc9 yc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yc9Var) == null) {
            this.f.z(yc9Var);
        }
    }

    public void k(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zc9Var) == null) {
            this.g = zc9Var;
            this.e.B(zc9Var);
            this.f.A(zc9Var);
        }
    }
}
