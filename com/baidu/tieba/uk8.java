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
public class uk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<ci> c;
    public al8 d;
    public vk8 e;
    public yk8 f;
    public zk8 g;
    public xk8 h;
    public wk8 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public uk8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        vk8 vk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (vk8Var = this.e) != null) {
            vk8Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new al8(this.a, dn6.E0);
            this.e = new vk8(this.a, en6.U);
            this.f = new yk8(this.a, dn6.N0);
            this.g = new zk8(this.a, dn6.L0);
            this.h = new xk8(this.a, dn6.F0);
            this.i = new wk8(this.a, dn6.M0);
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
            zk8 zk8Var = this.g;
            if (zk8Var != null) {
                zk8Var.y(nEGFeedbackEventCallback);
            }
            al8 al8Var = this.d;
            if (al8Var != null) {
                al8Var.y(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(di8 di8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, di8Var) == null) {
            vk8 vk8Var = this.e;
            if (vk8Var != null) {
                vk8Var.F(di8Var);
            }
            wk8 wk8Var = this.i;
            if (wk8Var != null) {
                wk8Var.C(di8Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            al8 al8Var = this.d;
            if (al8Var != null) {
                al8Var.z(bdUniqueId);
            }
            vk8 vk8Var = this.e;
            if (vk8Var != null) {
                vk8Var.E(bdUniqueId);
            }
            yk8 yk8Var = this.f;
            if (yk8Var != null) {
                yk8Var.y(bdUniqueId);
            }
            zk8 zk8Var = this.g;
            if (zk8Var != null) {
                zk8Var.z(bdUniqueId);
            }
            xk8 xk8Var = this.h;
            if (xk8Var != null) {
                xk8Var.A(bdUniqueId);
            }
            wk8 wk8Var = this.i;
            if (wk8Var != null) {
                wk8Var.B(bdUniqueId);
            }
        }
    }
}
