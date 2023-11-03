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
public class lb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<bi> b;
    public ui c;
    public jb8 d;
    public ob8 e;
    public eb8 f;
    public gb8 g;
    public fb8 h;
    public hb8 i;
    public ib8 j;
    public kb8 k;

    public lb8(TbPageContext tbPageContext, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, uiVar};
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
        this.c = uiVar;
        b();
    }

    public List<oi> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        ui uiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (uiVar = this.c) != null) {
            uiVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new nb8(this.a));
            this.b.add(new mb8(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            jb8 jb8Var = new jb8(this.a);
            this.d = jb8Var;
            jb8Var.y(this.c);
            this.b.add(this.d);
            ob8 ob8Var = new ob8(this.a);
            this.e = ob8Var;
            ob8Var.y(this.c);
            this.b.add(this.e);
            eb8 eb8Var = new eb8(this.a);
            this.f = eb8Var;
            eb8Var.y(this.c);
            this.b.add(this.f);
            gb8 gb8Var = new gb8(this.a);
            this.g = gb8Var;
            gb8Var.y(this.c);
            this.b.add(this.g);
            fb8 fb8Var = new fb8(this.a);
            this.h = fb8Var;
            fb8Var.y(this.c);
            this.b.add(this.h);
            hb8 hb8Var = new hb8(this.a);
            this.i = hb8Var;
            hb8Var.y(this.c);
            this.b.add(this.i);
            ib8 ib8Var = new ib8(this.a);
            this.j = ib8Var;
            ib8Var.y(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            kb8 kb8Var = new kb8(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = kb8Var;
            kb8Var.y(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vu4Var) == null) {
            for (bi biVar : this.b) {
                if (biVar instanceof db8) {
                    ((db8) biVar).x(vu4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (bi biVar : this.b) {
                biVar.setPageId(bdUniqueId);
            }
        }
    }
}
