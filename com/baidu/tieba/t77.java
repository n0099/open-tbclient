package com.baidu.tieba;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.u77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class t77 implements o77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s77 a;
    public TbPageContext b;
    public BdTypeListView c;
    public List<hn> d;
    public final List<um> e;
    public boolean f;
    public int g;

    public t77(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = false;
        this.g = -1;
        this.b = tbPageContext;
        this.c = bdTypeListView;
        this.f = z;
        d();
    }

    @Override // com.baidu.tieba.o77
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.g = i;
            if (!ListUtils.isEmpty(this.d) && this.c != null) {
                for (hn hnVar : this.d) {
                    if (hnVar instanceof u77) {
                        ((u77) hnVar).s = false;
                    }
                }
                if (BdNetTypeUtil.isWifiNet()) {
                    if (this.g < this.d.size() - 1) {
                        List<hn> list = this.d;
                        int i2 = this.g + 1;
                        this.g = i2;
                        if (list.get(i2) instanceof u77) {
                            ((u77) this.d.get(this.g)).s = true;
                            BdTypeListView bdTypeListView = this.c;
                            bdTypeListView.smoothScrollToPositionFromTop(i + bdTypeListView.getHeaderViewsCount() + 1, 0);
                            g();
                        }
                    } else if (this.g == this.d.size() - 1 && (this.d.get(this.g) instanceof u77)) {
                        ((u77) this.d.get(this.g)).s = false;
                    }
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !ListUtils.isEmpty(this.d)) {
            Iterator<hn> it = this.d.iterator();
            while (it.hasNext()) {
                ((u77) it.next()).s = false;
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.o77
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s77 s77Var = new s77(this.b, this, this.f);
            this.a = s77Var;
            this.e.add(s77Var);
            this.c.addAdapters(this.e);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.y();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeListView = this.c) != null && bdTypeListView.getAdapter2() != null && (this.c.getAdapter2() instanceof BaseAdapter)) {
            this.c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.onDestroy();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.D();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b();
            this.g = 0;
            k();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.E();
        }
    }

    public void f(String str, boolean z) {
        u77 u77Var;
        u77.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048582, this, str, z) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (hn hnVar : this.d) {
            if (hnVar != null && (hnVar instanceof u77) && (bVar = (u77Var = (u77) hnVar).m) != null && str.equals(bVar.a)) {
                u77Var.m.e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void h(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            this.a.z(configuration);
        }
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return this.a.C(i);
        }
        return invokeI.booleanValue;
    }

    public void m(List<u77> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048589, this, list, z) != null) || list == null) {
            return;
        }
        if (z) {
            this.d.clear();
        }
        this.d.addAll(list);
        this.c.setData(this.d);
        if (z && list.size() > 0 && this.f && BdNetTypeUtil.isWifiNet()) {
            l();
            list.get(0).s = true;
        }
    }
}
