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
public class rl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<xn> b;
    public List<kn> c;
    public nl8 d;
    public nl8 e;
    public nl8 f;
    public pl8 g;
    public pl8 h;
    public pl8 i;

    public rl8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void h(qo6 qo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, qo6Var) == null) {
            this.i.x(qo6Var);
            this.h.x(qo6Var);
            this.g.x(qo6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            nl8 nl8Var = new nl8(tbPageContext, ll8.D);
            this.d = nl8Var;
            nl8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nl8 nl8Var2 = new nl8(tbPageContext, ll8.E);
            this.e = nl8Var2;
            nl8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nl8 nl8Var3 = new nl8(tbPageContext, ll8.F);
            this.f = nl8Var3;
            nl8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            pl8 pl8Var = new pl8(tbPageContext, ll8.I);
            this.g = pl8Var;
            pl8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pl8 pl8Var2 = new pl8(tbPageContext, ll8.H);
            this.h = pl8Var2;
            pl8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pl8 pl8Var3 = new pl8(tbPageContext, ll8.G);
            this.i = pl8Var3;
            pl8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (kn knVar : this.c) {
            }
        }
    }
}
