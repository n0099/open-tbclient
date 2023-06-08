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
/* loaded from: classes7.dex */
public class oj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<vn> b;
    public List<in> c;
    public kj8 d;
    public kj8 e;
    public kj8 f;
    public mj8 g;
    public mj8 h;
    public mj8 i;

    public oj8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void h(go6 go6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, go6Var) == null) {
            this.i.x(go6Var);
            this.h.x(go6Var);
            this.g.x(go6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            kj8 kj8Var = new kj8(tbPageContext, ij8.C);
            this.d = kj8Var;
            kj8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            kj8 kj8Var2 = new kj8(tbPageContext, ij8.D);
            this.e = kj8Var2;
            kj8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            kj8 kj8Var3 = new kj8(tbPageContext, ij8.E);
            this.f = kj8Var3;
            kj8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            mj8 mj8Var = new mj8(tbPageContext, ij8.H);
            this.g = mj8Var;
            mj8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            mj8 mj8Var2 = new mj8(tbPageContext, ij8.G);
            this.h = mj8Var2;
            mj8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            mj8 mj8Var3 = new mj8(tbPageContext, ij8.F);
            this.i = mj8Var3;
            mj8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
