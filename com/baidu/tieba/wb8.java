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
public class wb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<in> b;
    public List<vm> c;
    public sb8 d;
    public sb8 e;
    public sb8 f;
    public ub8 g;
    public ub8 h;
    public ub8 i;

    public wb8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, snVar) == null) {
            for (vm vmVar : this.c) {
                if (vmVar != null) {
                    vmVar.setOnAdapterItemClickListener(snVar);
                }
            }
        }
    }

    public void f(ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tnVar) == null) {
            for (vm vmVar : this.c) {
                if (vmVar != null) {
                    vmVar.setOnAdapterItemLongClickListener(tnVar);
                }
            }
        }
    }

    public void h(ji6 ji6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ji6Var) == null) {
            this.i.x(ji6Var);
            this.h.x(ji6Var);
            this.g.x(ji6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            sb8 sb8Var = new sb8(tbPageContext, qb8.C);
            this.d = sb8Var;
            sb8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            sb8 sb8Var2 = new sb8(tbPageContext, qb8.D);
            this.e = sb8Var2;
            sb8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            sb8 sb8Var3 = new sb8(tbPageContext, qb8.E);
            this.f = sb8Var3;
            sb8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ub8 ub8Var = new ub8(tbPageContext, qb8.H);
            this.g = ub8Var;
            ub8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ub8 ub8Var2 = new ub8(tbPageContext, qb8.G);
            this.h = ub8Var2;
            ub8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ub8 ub8Var3 = new ub8(tbPageContext, qb8.F);
            this.i = ub8Var3;
            ub8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (vm vmVar : this.c) {
            }
        }
    }
}
