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
public class x08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<lm> b;
    public en c;
    public v08 d;
    public a18 e;
    public q08 f;
    public s08 g;
    public r08 h;
    public t08 i;
    public u08 j;
    public w08 k;

    public x08(TbPageContext tbPageContext, en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, enVar};
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
        this.c = enVar;
        b();
    }

    public List<ym> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        en enVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (enVar = this.c) != null) {
            enVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new z08(this.a));
            this.b.add(new y08(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            v08 v08Var = new v08(this.a);
            this.d = v08Var;
            v08Var.x(this.c);
            this.b.add(this.d);
            a18 a18Var = new a18(this.a);
            this.e = a18Var;
            a18Var.x(this.c);
            this.b.add(this.e);
            q08 q08Var = new q08(this.a);
            this.f = q08Var;
            q08Var.x(this.c);
            this.b.add(this.f);
            s08 s08Var = new s08(this.a);
            this.g = s08Var;
            s08Var.x(this.c);
            this.b.add(this.g);
            r08 r08Var = new r08(this.a);
            this.h = r08Var;
            r08Var.x(this.c);
            this.b.add(this.h);
            t08 t08Var = new t08(this.a);
            this.i = t08Var;
            t08Var.x(this.c);
            this.b.add(this.i);
            u08 u08Var = new u08(this.a);
            this.j = u08Var;
            u08Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            w08 w08Var = new w08(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = w08Var;
            w08Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(mz4 mz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mz4Var) == null) {
            for (lm lmVar : this.b) {
                if (lmVar instanceof p08) {
                    ((p08) lmVar).u(mz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (lm lmVar : this.b) {
                lmVar.setPageId(bdUniqueId);
            }
        }
    }
}
