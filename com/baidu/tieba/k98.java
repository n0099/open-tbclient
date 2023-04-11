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
/* loaded from: classes5.dex */
public class k98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<hn> b;
    public List<um> c;
    public g98 d;
    public g98 e;
    public g98 f;
    public i98 g;
    public i98 h;
    public i98 i;

    public k98(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rnVar) == null) {
            for (um umVar : this.c) {
                if (umVar != null) {
                    umVar.setOnAdapterItemClickListener(rnVar);
                }
            }
        }
    }

    public void f(ArrayList<hn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, snVar) == null) {
            for (um umVar : this.c) {
                if (umVar != null) {
                    umVar.setOnAdapterItemLongClickListener(snVar);
                }
            }
        }
    }

    public void h(xg6 xg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xg6Var) == null) {
            this.i.x(xg6Var);
            this.h.x(xg6Var);
            this.g.x(xg6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            g98 g98Var = new g98(tbPageContext, e98.C);
            this.d = g98Var;
            g98Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            g98 g98Var2 = new g98(tbPageContext, e98.D);
            this.e = g98Var2;
            g98Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            g98 g98Var3 = new g98(tbPageContext, e98.E);
            this.f = g98Var3;
            g98Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            i98 i98Var = new i98(tbPageContext, e98.H);
            this.g = i98Var;
            i98Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            i98 i98Var2 = new i98(tbPageContext, e98.G);
            this.h = i98Var2;
            i98Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            i98 i98Var3 = new i98(tbPageContext, e98.F);
            this.i = i98Var3;
            i98Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (um umVar : this.c) {
            }
        }
    }
}
