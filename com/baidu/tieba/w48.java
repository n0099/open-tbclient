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
public class w48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<lh> c;
    public c58 d;
    public x48 e;
    public a58 f;
    public b58 g;
    public z48 h;
    public y48 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public w48(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<yh> a() {
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
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (x48Var = this.e) != null) {
            x48Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new c58(this.a, rk6.E0);
            this.e = new x48(this.a, sk6.U);
            this.f = new a58(this.a, rk6.N0);
            this.g = new b58(this.a, rk6.L0);
            this.h = new z48(this.a, rk6.F0);
            this.i = new y48(this.a, rk6.M0);
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

    public void f(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nEGFeedbackEventCallback) == null) {
            b58 b58Var = this.g;
            if (b58Var != null) {
                b58Var.x(nEGFeedbackEventCallback);
            }
            c58 c58Var = this.d;
            if (c58Var != null) {
                c58Var.x(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f28Var) == null) {
            x48 x48Var = this.e;
            if (x48Var != null) {
                x48Var.E(f28Var);
            }
            y48 y48Var = this.i;
            if (y48Var != null) {
                y48Var.B(f28Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            c58 c58Var = this.d;
            if (c58Var != null) {
                c58Var.y(bdUniqueId);
            }
            x48 x48Var = this.e;
            if (x48Var != null) {
                x48Var.D(bdUniqueId);
            }
            a58 a58Var = this.f;
            if (a58Var != null) {
                a58Var.x(bdUniqueId);
            }
            b58 b58Var = this.g;
            if (b58Var != null) {
                b58Var.y(bdUniqueId);
            }
            z48 z48Var = this.h;
            if (z48Var != null) {
                z48Var.z(bdUniqueId);
            }
            y48 y48Var = this.i;
            if (y48Var != null) {
                y48Var.A(bdUniqueId);
            }
        }
    }
}
