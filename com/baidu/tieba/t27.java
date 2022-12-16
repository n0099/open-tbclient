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
public class t27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public r27 d;
    public w27 e;
    public m27 f;
    public o27 g;
    public n27 h;
    public p27 i;
    public q27 j;
    public s27 k;

    public t27(TbPageContext tbPageContext, Cdo cdo) {
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
            arrayList.add(new v27(this.a));
            this.b.add(new u27(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            r27 r27Var = new r27(this.a);
            this.d = r27Var;
            r27Var.v(this.c);
            this.b.add(this.d);
            w27 w27Var = new w27(this.a);
            this.e = w27Var;
            w27Var.v(this.c);
            this.b.add(this.e);
            m27 m27Var = new m27(this.a);
            this.f = m27Var;
            m27Var.v(this.c);
            this.b.add(this.f);
            o27 o27Var = new o27(this.a);
            this.g = o27Var;
            o27Var.v(this.c);
            this.b.add(this.g);
            n27 n27Var = new n27(this.a);
            this.h = n27Var;
            n27Var.v(this.c);
            this.b.add(this.h);
            p27 p27Var = new p27(this.a);
            this.i = p27Var;
            p27Var.v(this.c);
            this.b.add(this.i);
            q27 q27Var = new q27(this.a);
            this.j = q27Var;
            q27Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            s27 s27Var = new s27(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = s27Var;
            s27Var.v(this.c);
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

    public void e(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lq4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof l27) {
                    ((l27) knVar).u(lq4Var);
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
