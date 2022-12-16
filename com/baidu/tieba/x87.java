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
/* loaded from: classes6.dex */
public class x87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<kn> c;
    public d97 d;
    public y87 e;
    public b97 f;
    public c97 g;
    public a97 h;
    public z87 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public x87(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<xn> a() {
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
        y87 y87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (y87Var = this.e) != null) {
            y87Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new d97(this.a, w56.A0);
            this.e = new y87(this.a, x56.U);
            this.f = new b97(this.a, w56.J0);
            this.g = new c97(this.a, w56.H0);
            this.h = new a97(this.a, w56.B0);
            this.i = new z87(this.a, w56.I0);
            this.d.x(this.b);
            this.e.D(this.b);
            this.f.w(this.b);
            this.g.x(this.b);
            this.h.y(this.b);
            this.i.A(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.b.a(this.c);
        }
    }

    public void f(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            c97 c97Var = this.g;
            if (c97Var != null) {
                c97Var.v(bVar);
            }
            d97 d97Var = this.d;
            if (d97Var != null) {
                d97Var.v(bVar);
            }
        }
    }

    public void i(a67 a67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a67Var) == null) {
            y87 y87Var = this.e;
            if (y87Var != null) {
                y87Var.C(a67Var);
            }
            z87 z87Var = this.i;
            if (z87Var != null) {
                z87Var.z(a67Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            d97 d97Var = this.d;
            if (d97Var != null) {
                d97Var.w(bdUniqueId);
            }
            y87 y87Var = this.e;
            if (y87Var != null) {
                y87Var.B(bdUniqueId);
            }
            b97 b97Var = this.f;
            if (b97Var != null) {
                b97Var.v(bdUniqueId);
            }
            c97 c97Var = this.g;
            if (c97Var != null) {
                c97Var.w(bdUniqueId);
            }
            a97 a97Var = this.h;
            if (a97Var != null) {
                a97Var.x(bdUniqueId);
            }
            z87 z87Var = this.i;
            if (z87Var != null) {
                z87Var.y(bdUniqueId);
            }
        }
    }
}
