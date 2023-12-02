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
/* loaded from: classes8.dex */
public class tk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<ci> c;
    public zk8 d;
    public uk8 e;
    public xk8 f;
    public yk8 g;
    public wk8 h;
    public vk8 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public tk8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        uk8 uk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (uk8Var = this.e) != null) {
            uk8Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new zk8(this.a, dn6.E0);
            this.e = new uk8(this.a, en6.U);
            this.f = new xk8(this.a, dn6.N0);
            this.g = new yk8(this.a, dn6.L0);
            this.h = new wk8(this.a, dn6.F0);
            this.i = new vk8(this.a, dn6.M0);
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
            yk8 yk8Var = this.g;
            if (yk8Var != null) {
                yk8Var.y(nEGFeedbackEventCallback);
            }
            zk8 zk8Var = this.d;
            if (zk8Var != null) {
                zk8Var.y(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(ci8 ci8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ci8Var) == null) {
            uk8 uk8Var = this.e;
            if (uk8Var != null) {
                uk8Var.F(ci8Var);
            }
            vk8 vk8Var = this.i;
            if (vk8Var != null) {
                vk8Var.C(ci8Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            zk8 zk8Var = this.d;
            if (zk8Var != null) {
                zk8Var.z(bdUniqueId);
            }
            uk8 uk8Var = this.e;
            if (uk8Var != null) {
                uk8Var.E(bdUniqueId);
            }
            xk8 xk8Var = this.f;
            if (xk8Var != null) {
                xk8Var.y(bdUniqueId);
            }
            yk8 yk8Var = this.g;
            if (yk8Var != null) {
                yk8Var.z(bdUniqueId);
            }
            wk8 wk8Var = this.h;
            if (wk8Var != null) {
                wk8Var.A(bdUniqueId);
            }
            vk8 vk8Var = this.i;
            if (vk8Var != null) {
                vk8Var.B(bdUniqueId);
            }
        }
    }
}
