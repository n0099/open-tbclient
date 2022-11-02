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
public class n77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<jn> c;
    public t77 d;
    public o77 e;
    public r77 f;
    public s77 g;
    public q77 h;
    public p77 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public n77(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<wn> a() {
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
        o77 o77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (o77Var = this.e) != null) {
            o77Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new t77(this.a, o46.z0);
            this.e = new o77(this.a, p46.U);
            this.f = new r77(this.a, o46.I0);
            this.g = new s77(this.a, o46.G0);
            this.h = new q77(this.a, o46.A0);
            this.i = new p77(this.a, o46.H0);
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

    public void f(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            s77 s77Var = this.g;
            if (s77Var != null) {
                s77Var.v(bVar);
            }
            t77 t77Var = this.d;
            if (t77Var != null) {
                t77Var.v(bVar);
            }
        }
    }

    public void i(q47 q47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q47Var) == null) {
            o77 o77Var = this.e;
            if (o77Var != null) {
                o77Var.C(q47Var);
            }
            p77 p77Var = this.i;
            if (p77Var != null) {
                p77Var.z(q47Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            t77 t77Var = this.d;
            if (t77Var != null) {
                t77Var.w(bdUniqueId);
            }
            o77 o77Var = this.e;
            if (o77Var != null) {
                o77Var.B(bdUniqueId);
            }
            r77 r77Var = this.f;
            if (r77Var != null) {
                r77Var.v(bdUniqueId);
            }
            s77 s77Var = this.g;
            if (s77Var != null) {
                s77Var.w(bdUniqueId);
            }
            q77 q77Var = this.h;
            if (q77Var != null) {
                q77Var.x(bdUniqueId);
            }
            p77 p77Var = this.i;
            if (p77Var != null) {
                p77Var.y(bdUniqueId);
            }
        }
    }
}
