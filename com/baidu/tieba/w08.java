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
public class w08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<lm> b;
    public en c;
    public u08 d;
    public z08 e;
    public p08 f;
    public r08 g;
    public q08 h;
    public s08 i;
    public t08 j;
    public v08 k;

    public w08(TbPageContext tbPageContext, en enVar) {
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
            arrayList.add(new y08(this.a));
            this.b.add(new x08(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            u08 u08Var = new u08(this.a);
            this.d = u08Var;
            u08Var.x(this.c);
            this.b.add(this.d);
            z08 z08Var = new z08(this.a);
            this.e = z08Var;
            z08Var.x(this.c);
            this.b.add(this.e);
            p08 p08Var = new p08(this.a);
            this.f = p08Var;
            p08Var.x(this.c);
            this.b.add(this.f);
            r08 r08Var = new r08(this.a);
            this.g = r08Var;
            r08Var.x(this.c);
            this.b.add(this.g);
            q08 q08Var = new q08(this.a);
            this.h = q08Var;
            q08Var.x(this.c);
            this.b.add(this.h);
            s08 s08Var = new s08(this.a);
            this.i = s08Var;
            s08Var.x(this.c);
            this.b.add(this.i);
            t08 t08Var = new t08(this.a);
            this.j = t08Var;
            t08Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            v08 v08Var = new v08(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = v08Var;
            v08Var.x(this.c);
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
                if (lmVar instanceof o08) {
                    ((o08) lmVar).u(mz4Var);
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
