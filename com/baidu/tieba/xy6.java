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
public class xy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList c;
    public cz6 d;
    public zy6 e;
    public az6 f;
    public bz6 g;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public xy6(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new LinkedList();
        b();
    }

    public List a() {
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
        zy6 zy6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (zy6Var = this.e) != null) {
            zy6Var.onPause();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new cz6(this.a, e36.z0);
            this.e = new zy6(this.a, f36.U);
            this.f = new az6(this.a, e36.I0);
            this.g = new bz6(this.a, e36.G0);
            this.d.y(this.b);
            this.e.A(this.b);
            this.f.x(this.b);
            this.g.z(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.a(this.c);
        }
    }

    public void f(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            cz6 cz6Var = this.d;
            if (cz6Var != null) {
                cz6Var.w(i);
            }
            zy6 zy6Var = this.e;
            if (zy6Var != null) {
                zy6Var.y(i);
            }
            az6 az6Var = this.f;
            if (az6Var != null) {
                az6Var.v(i);
            }
            bz6 bz6Var = this.g;
            if (bz6Var != null) {
                bz6Var.x(i);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        bz6 bz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && (bz6Var = this.g) != null) {
            bz6Var.w(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            cz6 cz6Var = this.d;
            if (cz6Var != null) {
                cz6Var.x(bdUniqueId);
            }
            zy6 zy6Var = this.e;
            if (zy6Var != null) {
                zy6Var.z(bdUniqueId);
            }
            az6 az6Var = this.f;
            if (az6Var != null) {
                az6Var.w(bdUniqueId);
            }
            bz6 bz6Var = this.g;
            if (bz6Var != null) {
                bz6Var.y(bdUniqueId);
            }
        }
    }
}
