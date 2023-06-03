package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class lj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<vn> b;
    public List<in> c;
    public hj8 d;
    public hj8 e;
    public hj8 f;
    public jj8 g;
    public jj8 h;
    public jj8 i;

    public lj8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.a = bdTypeRecyclerView;
            b(tbPageContext);
        }
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (bdTypeRecyclerView = this.a) != null) {
            bdTypeRecyclerView.removeItem(i);
        }
    }

    public void e(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, foVar) == null) {
            for (in inVar : this.c) {
                if (inVar != null) {
                    inVar.setOnAdapterItemClickListener(foVar);
                }
            }
        }
    }

    public void f(ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(go goVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, goVar) == null) {
            for (in inVar : this.c) {
                if (inVar != null) {
                    inVar.setOnAdapterItemLongClickListener(goVar);
                }
            }
        }
    }

    public void h(eo6 eo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eo6Var) == null) {
            this.i.x(eo6Var);
            this.h.x(eo6Var);
            this.g.x(eo6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            hj8 hj8Var = new hj8(tbPageContext, fj8.C);
            this.d = hj8Var;
            hj8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            hj8 hj8Var2 = new hj8(tbPageContext, fj8.D);
            this.e = hj8Var2;
            hj8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            hj8 hj8Var3 = new hj8(tbPageContext, fj8.E);
            this.f = hj8Var3;
            hj8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            jj8 jj8Var = new jj8(tbPageContext, fj8.H);
            this.g = jj8Var;
            jj8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            jj8 jj8Var2 = new jj8(tbPageContext, fj8.G);
            this.h = jj8Var2;
            jj8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            jj8 jj8Var3 = new jj8(tbPageContext, fj8.F);
            this.i = jj8Var3;
            jj8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
            this.a.addAdapters(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (in inVar : this.c) {
            }
        }
    }
}
