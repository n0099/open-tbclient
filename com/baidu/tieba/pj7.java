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
public class pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<xn> b;
    public List<kn> c;
    public lj7 d;
    public lj7 e;
    public lj7 f;
    public nj7 g;
    public nj7 h;
    public nj7 i;

    public pj7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            bdTypeRecyclerView.G(i);
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

    public void h(h56 h56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h56Var) == null) {
            this.i.v(h56Var);
            this.h.v(h56Var);
            this.g.v(h56Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            lj7 lj7Var = new lj7(tbPageContext, jj7.A);
            this.d = lj7Var;
            lj7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            lj7 lj7Var2 = new lj7(tbPageContext, jj7.B);
            this.e = lj7Var2;
            lj7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            lj7 lj7Var3 = new lj7(tbPageContext, jj7.C);
            this.f = lj7Var3;
            lj7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nj7 nj7Var = new nj7(tbPageContext, jj7.F);
            this.g = nj7Var;
            nj7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            nj7 nj7Var2 = new nj7(tbPageContext, jj7.E);
            this.h = nj7Var2;
            nj7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            nj7 nj7Var3 = new nj7(tbPageContext, jj7.D);
            this.i = nj7Var3;
            nj7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
