package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<in> b;
    public bo c;
    public wx7 d;
    public by7 e;
    public rx7 f;
    public tx7 g;
    public sx7 h;
    public ux7 i;
    public vx7 j;
    public xx7 k;

    public yx7(TbPageContext tbPageContext, bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, boVar};
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
        this.c = boVar;
        b();
    }

    public List<vn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        bo boVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (boVar = this.c) != null) {
            boVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ay7(this.a));
            this.b.add(new zx7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            wx7 wx7Var = new wx7(this.a);
            this.d = wx7Var;
            wx7Var.x(this.c);
            this.b.add(this.d);
            by7 by7Var = new by7(this.a);
            this.e = by7Var;
            by7Var.x(this.c);
            this.b.add(this.e);
            rx7 rx7Var = new rx7(this.a);
            this.f = rx7Var;
            rx7Var.x(this.c);
            this.b.add(this.f);
            tx7 tx7Var = new tx7(this.a);
            this.g = tx7Var;
            tx7Var.x(this.c);
            this.b.add(this.g);
            sx7 sx7Var = new sx7(this.a);
            this.h = sx7Var;
            sx7Var.x(this.c);
            this.b.add(this.h);
            ux7 ux7Var = new ux7(this.a);
            this.i = ux7Var;
            ux7Var.x(this.c);
            this.b.add(this.i);
            vx7 vx7Var = new vx7(this.a);
            this.j = vx7Var;
            vx7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            xx7 xx7Var = new xx7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = xx7Var;
            xx7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(vz4 vz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vz4Var) == null) {
            for (in inVar : this.b) {
                if (inVar instanceof qx7) {
                    ((qx7) inVar).u(vz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (in inVar : this.b) {
                inVar.setPageId(bdUniqueId);
            }
        }
    }
}
