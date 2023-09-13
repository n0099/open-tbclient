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
public class ja8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<pm> c;
    public pa8 d;
    public ka8 e;
    public na8 f;
    public oa8 g;
    public ma8 h;
    public la8 i;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public ja8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<cn> a() {
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
        ka8 ka8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ka8Var = this.e) != null) {
            ka8Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new pa8(this.a, cq6.E0);
            this.e = new ka8(this.a, dq6.U);
            this.f = new na8(this.a, cq6.N0);
            this.g = new oa8(this.a, cq6.L0);
            this.h = new ma8(this.a, cq6.F0);
            this.i = new la8(this.a, cq6.M0);
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

    public void f(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nEGFeedbackEventCallback) == null) {
            oa8 oa8Var = this.g;
            if (oa8Var != null) {
                oa8Var.x(nEGFeedbackEventCallback);
            }
            pa8 pa8Var = this.d;
            if (pa8Var != null) {
                pa8Var.x(nEGFeedbackEventCallback);
            }
        }
    }

    public void i(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s78Var) == null) {
            ka8 ka8Var = this.e;
            if (ka8Var != null) {
                ka8Var.E(s78Var);
            }
            la8 la8Var = this.i;
            if (la8Var != null) {
                la8Var.B(s78Var);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            pa8 pa8Var = this.d;
            if (pa8Var != null) {
                pa8Var.y(bdUniqueId);
            }
            ka8 ka8Var = this.e;
            if (ka8Var != null) {
                ka8Var.D(bdUniqueId);
            }
            na8 na8Var = this.f;
            if (na8Var != null) {
                na8Var.x(bdUniqueId);
            }
            oa8 oa8Var = this.g;
            if (oa8Var != null) {
                oa8Var.y(bdUniqueId);
            }
            ma8 ma8Var = this.h;
            if (ma8Var != null) {
                ma8Var.z(bdUniqueId);
            }
            la8 la8Var = this.i;
            if (la8Var != null) {
                la8Var.A(bdUniqueId);
            }
        }
    }
}
