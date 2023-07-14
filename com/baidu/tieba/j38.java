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
public class j38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ln> b;
    public eo c;
    public h38 d;
    public m38 e;
    public c38 f;
    public e38 g;
    public d38 h;
    public f38 i;
    public g38 j;
    public i38 k;

    public j38(TbPageContext tbPageContext, eo eoVar) {
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
            arrayList.add(new l38(this.a));
            this.b.add(new k38(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            h38 h38Var = new h38(this.a);
            this.d = h38Var;
            h38Var.x(this.c);
            this.b.add(this.d);
            m38 m38Var = new m38(this.a);
            this.e = m38Var;
            m38Var.x(this.c);
            this.b.add(this.e);
            c38 c38Var = new c38(this.a);
            this.f = c38Var;
            c38Var.x(this.c);
            this.b.add(this.f);
            e38 e38Var = new e38(this.a);
            this.g = e38Var;
            e38Var.x(this.c);
            this.b.add(this.g);
            d38 d38Var = new d38(this.a);
            this.h = d38Var;
            d38Var.x(this.c);
            this.b.add(this.h);
            f38 f38Var = new f38(this.a);
            this.i = f38Var;
            f38Var.x(this.c);
            this.b.add(this.i);
            g38 g38Var = new g38(this.a);
            this.j = g38Var;
            g38Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            i38 i38Var = new i38(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = i38Var;
            i38Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i05Var) == null) {
            for (ln lnVar : this.b) {
                if (lnVar instanceof b38) {
                    ((b38) lnVar).u(i05Var);
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
