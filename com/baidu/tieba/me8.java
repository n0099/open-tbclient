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
public class me8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ci> b;
    public vi c;
    public ke8 d;
    public pe8 e;
    public fe8 f;
    public he8 g;
    public ge8 h;
    public ie8 i;
    public je8 j;
    public le8 k;

    public me8(TbPageContext tbPageContext, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viVar};
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
        this.c = viVar;
        b();
    }

    public List<pi> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (viVar = this.c) != null) {
            viVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new oe8(this.a));
            this.b.add(new ne8(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            ke8 ke8Var = new ke8(this.a);
            this.d = ke8Var;
            ke8Var.y(this.c);
            this.b.add(this.d);
            pe8 pe8Var = new pe8(this.a);
            this.e = pe8Var;
            pe8Var.y(this.c);
            this.b.add(this.e);
            fe8 fe8Var = new fe8(this.a);
            this.f = fe8Var;
            fe8Var.y(this.c);
            this.b.add(this.f);
            he8 he8Var = new he8(this.a);
            this.g = he8Var;
            he8Var.y(this.c);
            this.b.add(this.g);
            ge8 ge8Var = new ge8(this.a);
            this.h = ge8Var;
            ge8Var.y(this.c);
            this.b.add(this.h);
            ie8 ie8Var = new ie8(this.a);
            this.i = ie8Var;
            ie8Var.y(this.c);
            this.b.add(this.i);
            je8 je8Var = new je8(this.a);
            this.j = je8Var;
            je8Var.y(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            le8 le8Var = new le8(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = le8Var;
            le8Var.y(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, av4Var) == null) {
            for (ci ciVar : this.b) {
                if (ciVar instanceof ee8) {
                    ((ee8) ciVar).x(av4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (ci ciVar : this.b) {
                ciVar.setPageId(bdUniqueId);
            }
        }
    }
}
