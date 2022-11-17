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
public class t17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public r17 d;
    public w17 e;
    public m17 f;
    public o17 g;
    public n17 h;
    public p17 i;
    public q17 j;
    public s17 k;

    public t17(TbPageContext tbPageContext, Cdo cdo) {
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
            arrayList.add(new v17(this.a));
            this.b.add(new u17(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            r17 r17Var = new r17(this.a);
            this.d = r17Var;
            r17Var.v(this.c);
            this.b.add(this.d);
            w17 w17Var = new w17(this.a);
            this.e = w17Var;
            w17Var.v(this.c);
            this.b.add(this.e);
            m17 m17Var = new m17(this.a);
            this.f = m17Var;
            m17Var.v(this.c);
            this.b.add(this.f);
            o17 o17Var = new o17(this.a);
            this.g = o17Var;
            o17Var.v(this.c);
            this.b.add(this.g);
            n17 n17Var = new n17(this.a);
            this.h = n17Var;
            n17Var.v(this.c);
            this.b.add(this.h);
            p17 p17Var = new p17(this.a);
            this.i = p17Var;
            p17Var.v(this.c);
            this.b.add(this.i);
            q17 q17Var = new q17(this.a);
            this.j = q17Var;
            q17Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            s17 s17Var = new s17(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = s17Var;
            s17Var.v(this.c);
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

    public void e(kq4 kq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kq4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof l17) {
                    ((l17) knVar).u(kq4Var);
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
