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
public class wx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<in> b;
    public bo c;
    public ux7 d;
    public zx7 e;
    public px7 f;
    public rx7 g;
    public qx7 h;
    public sx7 i;
    public tx7 j;
    public vx7 k;

    public wx7(TbPageContext tbPageContext, bo boVar) {
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
            arrayList.add(new yx7(this.a));
            this.b.add(new xx7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            ux7 ux7Var = new ux7(this.a);
            this.d = ux7Var;
            ux7Var.x(this.c);
            this.b.add(this.d);
            zx7 zx7Var = new zx7(this.a);
            this.e = zx7Var;
            zx7Var.x(this.c);
            this.b.add(this.e);
            px7 px7Var = new px7(this.a);
            this.f = px7Var;
            px7Var.x(this.c);
            this.b.add(this.f);
            rx7 rx7Var = new rx7(this.a);
            this.g = rx7Var;
            rx7Var.x(this.c);
            this.b.add(this.g);
            qx7 qx7Var = new qx7(this.a);
            this.h = qx7Var;
            qx7Var.x(this.c);
            this.b.add(this.h);
            sx7 sx7Var = new sx7(this.a);
            this.i = sx7Var;
            sx7Var.x(this.c);
            this.b.add(this.i);
            tx7 tx7Var = new tx7(this.a);
            this.j = tx7Var;
            tx7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            vx7 vx7Var = new vx7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = vx7Var;
            vx7Var.x(this.c);
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
                if (inVar instanceof ox7) {
                    ((ox7) inVar).u(vz4Var);
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
