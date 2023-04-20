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
public class s98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<in> b;
    public List<vm> c;
    public o98 d;
    public o98 e;
    public o98 f;
    public q98 g;
    public q98 h;
    public q98 i;

    public s98(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void h(yg6 yg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yg6Var) == null) {
            this.i.x(yg6Var);
            this.h.x(yg6Var);
            this.g.x(yg6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            o98 o98Var = new o98(tbPageContext, m98.C);
            this.d = o98Var;
            o98Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            o98 o98Var2 = new o98(tbPageContext, m98.D);
            this.e = o98Var2;
            o98Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            o98 o98Var3 = new o98(tbPageContext, m98.E);
            this.f = o98Var3;
            o98Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            q98 q98Var = new q98(tbPageContext, m98.H);
            this.g = q98Var;
            q98Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            q98 q98Var2 = new q98(tbPageContext, m98.G);
            this.h = q98Var2;
            q98Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            q98 q98Var3 = new q98(tbPageContext, m98.F);
            this.i = q98Var3;
            q98Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
