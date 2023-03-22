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
public class mz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<gn> b;
    public List<tm> c;
    public iz7 d;
    public iz7 e;
    public iz7 f;
    public kz7 g;
    public kz7 h;
    public kz7 i;

    public mz7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(qn qnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qnVar) == null) {
            for (tm tmVar : this.c) {
                if (tmVar != null) {
                    tmVar.setOnAdapterItemClickListener(qnVar);
                }
            }
        }
    }

    public void f(ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rnVar) == null) {
            for (tm tmVar : this.c) {
                if (tmVar != null) {
                    tmVar.setOnAdapterItemLongClickListener(rnVar);
                }
            }
        }
    }

    public void h(lf6 lf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lf6Var) == null) {
            this.i.x(lf6Var);
            this.h.x(lf6Var);
            this.g.x(lf6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            iz7 iz7Var = new iz7(tbPageContext, gz7.C);
            this.d = iz7Var;
            iz7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            iz7 iz7Var2 = new iz7(tbPageContext, gz7.D);
            this.e = iz7Var2;
            iz7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            iz7 iz7Var3 = new iz7(tbPageContext, gz7.E);
            this.f = iz7Var3;
            iz7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            kz7 kz7Var = new kz7(tbPageContext, gz7.H);
            this.g = kz7Var;
            kz7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            kz7 kz7Var2 = new kz7(tbPageContext, gz7.G);
            this.h = kz7Var2;
            kz7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            kz7 kz7Var3 = new kz7(tbPageContext, gz7.F);
            this.i = kz7Var3;
            kz7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (tm tmVar : this.c) {
            }
        }
    }
}
