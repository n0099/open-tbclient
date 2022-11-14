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
/* loaded from: classes5.dex */
public class s17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public q17 d;
    public v17 e;
    public l17 f;
    public n17 g;
    public m17 h;
    public o17 i;
    public p17 j;
    public r17 k;

    public s17(TbPageContext tbPageContext, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cdo};
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
        this.c = cdo;
        b();
    }

    public List<xn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cdo = this.c) != null) {
            cdo.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new u17(this.a));
            this.b.add(new t17(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            q17 q17Var = new q17(this.a);
            this.d = q17Var;
            q17Var.v(this.c);
            this.b.add(this.d);
            v17 v17Var = new v17(this.a);
            this.e = v17Var;
            v17Var.v(this.c);
            this.b.add(this.e);
            l17 l17Var = new l17(this.a);
            this.f = l17Var;
            l17Var.v(this.c);
            this.b.add(this.f);
            n17 n17Var = new n17(this.a);
            this.g = n17Var;
            n17Var.v(this.c);
            this.b.add(this.g);
            m17 m17Var = new m17(this.a);
            this.h = m17Var;
            m17Var.v(this.c);
            this.b.add(this.h);
            o17 o17Var = new o17(this.a);
            this.i = o17Var;
            o17Var.v(this.c);
            this.b.add(this.i);
            p17 p17Var = new p17(this.a);
            this.j = p17Var;
            p17Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            r17 r17Var = new r17(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = r17Var;
            r17Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void d(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(jq4 jq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jq4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof k17) {
                    ((k17) knVar).u(jq4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (kn knVar : this.b) {
                knVar.setPageId(bdUniqueId);
            }
        }
    }
}
