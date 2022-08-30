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
/* loaded from: classes6.dex */
public class tx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<cn> b;
    public vn c;
    public rx6 d;
    public wx6 e;
    public mx6 f;
    public ox6 g;
    public nx6 h;
    public px6 i;
    public qx6 j;
    public sx6 k;

    public tx6(TbPageContext tbPageContext, vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vnVar};
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
        this.c = vnVar;
        b();
    }

    public List<pn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new vx6(this.a));
            this.b.add(new ux6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            rx6 rx6Var = new rx6(this.a);
            this.d = rx6Var;
            rx6Var.v(this.c);
            this.b.add(this.d);
            wx6 wx6Var = new wx6(this.a);
            this.e = wx6Var;
            wx6Var.v(this.c);
            this.b.add(this.e);
            mx6 mx6Var = new mx6(this.a);
            this.f = mx6Var;
            mx6Var.v(this.c);
            this.b.add(this.f);
            ox6 ox6Var = new ox6(this.a);
            this.g = ox6Var;
            ox6Var.v(this.c);
            this.b.add(this.g);
            nx6 nx6Var = new nx6(this.a);
            this.h = nx6Var;
            nx6Var.v(this.c);
            this.b.add(this.h);
            px6 px6Var = new px6(this.a);
            this.i = px6Var;
            px6Var.v(this.c);
            this.b.add(this.i);
            qx6 qx6Var = new qx6(this.a);
            this.j = qx6Var;
            qx6Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            sx6 sx6Var = new sx6(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = sx6Var;
            sx6Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void c() {
        vn vnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (vnVar = this.c) == null) {
            return;
        }
        vnVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cn4Var) == null) {
            for (cn cnVar : this.b) {
                if (cnVar instanceof lx6) {
                    ((lx6) cnVar).u(cn4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (cn cnVar : this.b) {
                cnVar.setPageId(bdUniqueId);
            }
        }
    }
}
