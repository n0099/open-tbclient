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
public class ls7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<en> b;
    public xn c;
    public js7 d;
    public os7 e;
    public es7 f;
    public gs7 g;
    public fs7 h;
    public hs7 i;
    public is7 j;
    public ks7 k;

    public ls7(TbPageContext tbPageContext, xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xnVar};
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
        this.c = xnVar;
        b();
    }

    public List<rn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        xn xnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (xnVar = this.c) != null) {
            xnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ns7(this.a));
            this.b.add(new ms7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            js7 js7Var = new js7(this.a);
            this.d = js7Var;
            js7Var.x(this.c);
            this.b.add(this.d);
            os7 os7Var = new os7(this.a);
            this.e = os7Var;
            os7Var.x(this.c);
            this.b.add(this.e);
            es7 es7Var = new es7(this.a);
            this.f = es7Var;
            es7Var.x(this.c);
            this.b.add(this.f);
            gs7 gs7Var = new gs7(this.a);
            this.g = gs7Var;
            gs7Var.x(this.c);
            this.b.add(this.g);
            fs7 fs7Var = new fs7(this.a);
            this.h = fs7Var;
            fs7Var.x(this.c);
            this.b.add(this.h);
            hs7 hs7Var = new hs7(this.a);
            this.i = hs7Var;
            hs7Var.x(this.c);
            this.b.add(this.i);
            is7 is7Var = new is7(this.a);
            this.j = is7Var;
            is7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            ks7 ks7Var = new ks7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = ks7Var;
            ks7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zw4Var) == null) {
            for (en enVar : this.b) {
                if (enVar instanceof ds7) {
                    ((ds7) enVar).u(zw4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (en enVar : this.b) {
                enVar.setPageId(bdUniqueId);
            }
        }
    }
}
