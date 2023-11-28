package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class pk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<ci> c;
    public vk8 d;
    public qk8 e;
    public tk8 f;
    public uk8 g;
    public sk8 h;
    public rk8 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public pk8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = bdTypeRecyclerView;
        this.c = new LinkedList<>();
        b();
    }

    public List<pi> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeRecyclerView = this.b) != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e() {
        qk8 qk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qk8Var = this.e) != null) {
            qk8Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new vk8(this.a, zm6.E0);
            this.e = new qk8(this.a, an6.U);
            this.f = new tk8(this.a, zm6.N0);
            this.g = new uk8(this.a, zm6.L0);
            this.h = new sk8(this.a, zm6.F0);
            this.i = new rk8(this.a, zm6.M0);
            this.d.A(this.b);
            this.e.G(this.b);
            this.f.z(this.b);
            this.g.A(this.b);
            this.h.B(this.b);
            this.i.D(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.b.addAdapters(this.c);
        }
    }

    public void f(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nEGFeedbackEventCallback) == null) {
            uk8 uk8Var = this.g;
            if (uk8Var != null) {
                uk8Var.y(nEGFeedbackEventCallback);
            }
            vk8 vk8Var = this.d;
            if (vk8Var != null) {
                vk8Var.y(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(yh8 yh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yh8Var) == null) {
            qk8 qk8Var = this.e;
            if (qk8Var != null) {
                qk8Var.F(yh8Var);
            }
            rk8 rk8Var = this.i;
            if (rk8Var != null) {
                rk8Var.C(yh8Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            vk8 vk8Var = this.d;
            if (vk8Var != null) {
                vk8Var.z(bdUniqueId);
            }
            qk8 qk8Var = this.e;
            if (qk8Var != null) {
                qk8Var.E(bdUniqueId);
            }
            tk8 tk8Var = this.f;
            if (tk8Var != null) {
                tk8Var.y(bdUniqueId);
            }
            uk8 uk8Var = this.g;
            if (uk8Var != null) {
                uk8Var.z(bdUniqueId);
            }
            sk8 sk8Var = this.h;
            if (sk8Var != null) {
                sk8Var.A(bdUniqueId);
            }
            rk8 rk8Var = this.i;
            if (rk8Var != null) {
                rk8Var.B(bdUniqueId);
            }
        }
    }
}
