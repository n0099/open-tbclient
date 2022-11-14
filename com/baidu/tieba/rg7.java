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
public class rg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<xn> b;
    public List<kn> c;
    public ng7 d;
    public ng7 e;
    public ng7 f;
    public pg7 g;
    public pg7 h;
    public pg7 i;

    public rg7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            bdTypeRecyclerView.D(i);
        }
    }

    public void e(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hoVar) == null) {
            for (kn knVar : this.c) {
                if (knVar != null) {
                    knVar.setOnAdapterItemClickListener(hoVar);
                }
            }
        }
    }

    public void f(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(io ioVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ioVar) == null) {
            for (kn knVar : this.c) {
                if (knVar != null) {
                    knVar.setOnAdapterItemLongClickListener(ioVar);
                }
            }
        }
    }

    public void h(l46 l46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, l46Var) == null) {
            this.i.v(l46Var);
            this.h.v(l46Var);
            this.g.v(l46Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            ng7 ng7Var = new ng7(tbPageContext, lg7.A);
            this.d = ng7Var;
            ng7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ng7 ng7Var2 = new ng7(tbPageContext, lg7.B);
            this.e = ng7Var2;
            ng7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ng7 ng7Var3 = new ng7(tbPageContext, lg7.C);
            this.f = ng7Var3;
            ng7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            pg7 pg7Var = new pg7(tbPageContext, lg7.F);
            this.g = pg7Var;
            pg7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pg7 pg7Var2 = new pg7(tbPageContext, lg7.E);
            this.h = pg7Var2;
            pg7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pg7 pg7Var3 = new pg7(tbPageContext, lg7.D);
            this.i = pg7Var3;
            pg7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
            this.a.a(this.c);
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
            for (kn knVar : this.c) {
            }
        }
    }
}
