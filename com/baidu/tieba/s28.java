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
/* loaded from: classes7.dex */
public class s28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<om> b;
    public hn c;
    public q28 d;
    public v28 e;
    public l28 f;
    public n28 g;
    public m28 h;
    public o28 i;
    public p28 j;
    public r28 k;

    public s28(TbPageContext tbPageContext, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hnVar};
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
        this.c = hnVar;
        b();
    }

    public List<bn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hnVar = this.c) != null) {
            hnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new u28(this.a));
            this.b.add(new t28(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            q28 q28Var = new q28(this.a);
            this.d = q28Var;
            q28Var.x(this.c);
            this.b.add(this.d);
            v28 v28Var = new v28(this.a);
            this.e = v28Var;
            v28Var.x(this.c);
            this.b.add(this.e);
            l28 l28Var = new l28(this.a);
            this.f = l28Var;
            l28Var.x(this.c);
            this.b.add(this.f);
            n28 n28Var = new n28(this.a);
            this.g = n28Var;
            n28Var.x(this.c);
            this.b.add(this.g);
            m28 m28Var = new m28(this.a);
            this.h = m28Var;
            m28Var.x(this.c);
            this.b.add(this.h);
            o28 o28Var = new o28(this.a);
            this.i = o28Var;
            o28Var.x(this.c);
            this.b.add(this.i);
            p28 p28Var = new p28(this.a);
            this.j = p28Var;
            p28Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            r28 r28Var = new r28(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = r28Var;
            r28Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(rz4 rz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rz4Var) == null) {
            for (om omVar : this.b) {
                if (omVar instanceof k28) {
                    ((k28) omVar).u(rz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (om omVar : this.b) {
                omVar.setPageId(bdUniqueId);
            }
        }
    }
}
