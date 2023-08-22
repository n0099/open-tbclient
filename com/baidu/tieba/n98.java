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
public class n98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<om> c;
    public t98 d;
    public o98 e;
    public r98 f;
    public s98 g;
    public q98 h;
    public p98 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public n98(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<bn> a() {
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
        o98 o98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (o98Var = this.e) != null) {
            o98Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new t98(this.a, zo6.E0);
            this.e = new o98(this.a, ap6.U);
            this.f = new r98(this.a, zo6.N0);
            this.g = new s98(this.a, zo6.L0);
            this.h = new q98(this.a, zo6.F0);
            this.i = new p98(this.a, zo6.M0);
            this.d.z(this.b);
            this.e.F(this.b);
            this.f.y(this.b);
            this.g.z(this.b);
            this.h.A(this.b);
            this.i.C(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.b.addAdapters(this.c);
        }
    }

    public void f(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nEGFeedbackEventCallback) == null) {
            s98 s98Var = this.g;
            if (s98Var != null) {
                s98Var.x(nEGFeedbackEventCallback);
            }
            t98 t98Var = this.d;
            if (t98Var != null) {
                t98Var.x(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(h68 h68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h68Var) == null) {
            o98 o98Var = this.e;
            if (o98Var != null) {
                o98Var.E(h68Var);
            }
            p98 p98Var = this.i;
            if (p98Var != null) {
                p98Var.B(h68Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            t98 t98Var = this.d;
            if (t98Var != null) {
                t98Var.y(bdUniqueId);
            }
            o98 o98Var = this.e;
            if (o98Var != null) {
                o98Var.D(bdUniqueId);
            }
            r98 r98Var = this.f;
            if (r98Var != null) {
                r98Var.x(bdUniqueId);
            }
            s98 s98Var = this.g;
            if (s98Var != null) {
                s98Var.y(bdUniqueId);
            }
            q98 q98Var = this.h;
            if (q98Var != null) {
                q98Var.z(bdUniqueId);
            }
            p98 p98Var = this.i;
            if (p98Var != null) {
                p98Var.A(bdUniqueId);
            }
        }
    }
}
