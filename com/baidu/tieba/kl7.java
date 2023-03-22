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
/* loaded from: classes5.dex */
public class kl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<tm> c;
    public ql7 d;
    public ll7 e;
    public ol7 f;
    public pl7 g;
    public nl7 h;
    public ml7 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public kl7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<gn> a() {
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
        ll7 ll7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ll7Var = this.e) != null) {
            ll7Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new ql7(this.a, ag6.C0);
            this.e = new ll7(this.a, bg6.U);
            this.f = new ol7(this.a, ag6.L0);
            this.g = new pl7(this.a, ag6.J0);
            this.h = new nl7(this.a, ag6.D0);
            this.i = new ml7(this.a, ag6.K0);
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

    public void f(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            pl7 pl7Var = this.g;
            if (pl7Var != null) {
                pl7Var.x(bVar);
            }
            ql7 ql7Var = this.d;
            if (ql7Var != null) {
                ql7Var.x(bVar);
            }
        }
    }

    public void i(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ki7Var) == null) {
            ll7 ll7Var = this.e;
            if (ll7Var != null) {
                ll7Var.E(ki7Var);
            }
            ml7 ml7Var = this.i;
            if (ml7Var != null) {
                ml7Var.B(ki7Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            ql7 ql7Var = this.d;
            if (ql7Var != null) {
                ql7Var.y(bdUniqueId);
            }
            ll7 ll7Var = this.e;
            if (ll7Var != null) {
                ll7Var.D(bdUniqueId);
            }
            ol7 ol7Var = this.f;
            if (ol7Var != null) {
                ol7Var.x(bdUniqueId);
            }
            pl7 pl7Var = this.g;
            if (pl7Var != null) {
                pl7Var.y(bdUniqueId);
            }
            nl7 nl7Var = this.h;
            if (nl7Var != null) {
                nl7Var.z(bdUniqueId);
            }
            ml7 ml7Var = this.i;
            if (ml7Var != null) {
                ml7Var.A(bdUniqueId);
            }
        }
    }
}
