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
public class r67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ln> b;
    public eo c;
    public p67 d;
    public u67 e;
    public k67 f;
    public m67 g;
    public l67 h;
    public n67 i;
    public o67 j;
    public q67 k;

    public r67(TbPageContext tbPageContext, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eoVar};
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
        this.c = eoVar;
        b();
    }

    public List<yn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (eoVar = this.c) != null) {
            eoVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new t67(this.a));
            this.b.add(new s67(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            p67 p67Var = new p67(this.a);
            this.d = p67Var;
            p67Var.v(this.c);
            this.b.add(this.d);
            u67 u67Var = new u67(this.a);
            this.e = u67Var;
            u67Var.v(this.c);
            this.b.add(this.e);
            k67 k67Var = new k67(this.a);
            this.f = k67Var;
            k67Var.v(this.c);
            this.b.add(this.f);
            m67 m67Var = new m67(this.a);
            this.g = m67Var;
            m67Var.v(this.c);
            this.b.add(this.g);
            l67 l67Var = new l67(this.a);
            this.h = l67Var;
            l67Var.v(this.c);
            this.b.add(this.h);
            n67 n67Var = new n67(this.a);
            this.i = n67Var;
            n67Var.v(this.c);
            this.b.add(this.i);
            o67 o67Var = new o67(this.a);
            this.j = o67Var;
            o67Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            q67 q67Var = new q67(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = q67Var;
            q67Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void d(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(vq4 vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vq4Var) == null) {
            for (ln lnVar : this.b) {
                if (lnVar instanceof j67) {
                    ((j67) lnVar).u(vq4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (ln lnVar : this.b) {
                lnVar.setPageId(bdUniqueId);
            }
        }
    }
}
