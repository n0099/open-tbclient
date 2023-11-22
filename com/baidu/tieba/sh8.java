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
public class sh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<bi> c;
    public yh8 d;
    public th8 e;
    public wh8 f;
    public xh8 g;
    public vh8 h;
    public uh8 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public sh8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<oi> a() {
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
        th8 th8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (th8Var = this.e) != null) {
            th8Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new yh8(this.a, om6.E0);
            this.e = new th8(this.a, pm6.U);
            this.f = new wh8(this.a, om6.N0);
            this.g = new xh8(this.a, om6.L0);
            this.h = new vh8(this.a, om6.F0);
            this.i = new uh8(this.a, om6.M0);
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

    public void f(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nEGFeedbackEventCallback) == null) {
            xh8 xh8Var = this.g;
            if (xh8Var != null) {
                xh8Var.y(nEGFeedbackEventCallback);
            }
            yh8 yh8Var = this.d;
            if (yh8Var != null) {
                yh8Var.y(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(bf8 bf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bf8Var) == null) {
            th8 th8Var = this.e;
            if (th8Var != null) {
                th8Var.F(bf8Var);
            }
            uh8 uh8Var = this.i;
            if (uh8Var != null) {
                uh8Var.C(bf8Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            yh8 yh8Var = this.d;
            if (yh8Var != null) {
                yh8Var.z(bdUniqueId);
            }
            th8 th8Var = this.e;
            if (th8Var != null) {
                th8Var.E(bdUniqueId);
            }
            wh8 wh8Var = this.f;
            if (wh8Var != null) {
                wh8Var.y(bdUniqueId);
            }
            xh8 xh8Var = this.g;
            if (xh8Var != null) {
                xh8Var.z(bdUniqueId);
            }
            vh8 vh8Var = this.h;
            if (vh8Var != null) {
                vh8Var.A(bdUniqueId);
            }
            uh8 uh8Var = this.i;
            if (uh8Var != null) {
                uh8Var.B(bdUniqueId);
            }
        }
    }
}
