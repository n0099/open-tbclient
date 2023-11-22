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
public class mb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<bi> b;
    public ui c;
    public kb8 d;
    public pb8 e;
    public fb8 f;
    public hb8 g;
    public gb8 h;
    public ib8 i;
    public jb8 j;
    public lb8 k;

    public mb8(TbPageContext tbPageContext, ui uiVar) {
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
            arrayList.add(new ob8(this.a));
            this.b.add(new nb8(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            kb8 kb8Var = new kb8(this.a);
            this.d = kb8Var;
            kb8Var.y(this.c);
            this.b.add(this.d);
            pb8 pb8Var = new pb8(this.a);
            this.e = pb8Var;
            pb8Var.y(this.c);
            this.b.add(this.e);
            fb8 fb8Var = new fb8(this.a);
            this.f = fb8Var;
            fb8Var.y(this.c);
            this.b.add(this.f);
            hb8 hb8Var = new hb8(this.a);
            this.g = hb8Var;
            hb8Var.y(this.c);
            this.b.add(this.g);
            gb8 gb8Var = new gb8(this.a);
            this.h = gb8Var;
            gb8Var.y(this.c);
            this.b.add(this.h);
            ib8 ib8Var = new ib8(this.a);
            this.i = ib8Var;
            ib8Var.y(this.c);
            this.b.add(this.i);
            jb8 jb8Var = new jb8(this.a);
            this.j = jb8Var;
            jb8Var.y(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            lb8 lb8Var = new lb8(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = lb8Var;
            lb8Var.y(this.c);
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
                if (biVar instanceof eb8) {
                    ((eb8) biVar).x(vu4Var);
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
