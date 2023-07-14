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
public class z98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<ln> c;
    public fa8 d;
    public aa8 e;
    public da8 f;
    public ea8 g;
    public ca8 h;
    public ba8 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public z98(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<yn> a() {
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
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (aa8Var = this.e) != null) {
            aa8Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new fa8(this.a, kq6.E0);
            this.e = new aa8(this.a, lq6.U);
            this.f = new da8(this.a, kq6.N0);
            this.g = new ea8(this.a, kq6.L0);
            this.h = new ca8(this.a, kq6.F0);
            this.i = new ba8(this.a, kq6.M0);
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

    public void f(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ea8 ea8Var = this.g;
            if (ea8Var != null) {
                ea8Var.x(bVar);
            }
            fa8 fa8Var = this.d;
            if (fa8Var != null) {
                fa8Var.x(bVar);
            }
        }
    }

    public void i(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s68Var) == null) {
            aa8 aa8Var = this.e;
            if (aa8Var != null) {
                aa8Var.E(s68Var);
            }
            ba8 ba8Var = this.i;
            if (ba8Var != null) {
                ba8Var.B(s68Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            fa8 fa8Var = this.d;
            if (fa8Var != null) {
                fa8Var.y(bdUniqueId);
            }
            aa8 aa8Var = this.e;
            if (aa8Var != null) {
                aa8Var.D(bdUniqueId);
            }
            da8 da8Var = this.f;
            if (da8Var != null) {
                da8Var.x(bdUniqueId);
            }
            ea8 ea8Var = this.g;
            if (ea8Var != null) {
                ea8Var.y(bdUniqueId);
            }
            ca8 ca8Var = this.h;
            if (ca8Var != null) {
                ca8Var.z(bdUniqueId);
            }
            ba8 ba8Var = this.i;
            if (ba8Var != null) {
                ba8Var.A(bdUniqueId);
            }
        }
    }
}
