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
public class rv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<bn> b;
    public List<om> c;
    public nv8 d;
    public nv8 e;
    public nv8 f;
    public pv8 g;
    public pv8 h;
    public pv8 i;

    public rv8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ln lnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lnVar) == null) {
            for (om omVar : this.c) {
                if (omVar != null) {
                    omVar.setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    public void f(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mnVar) == null) {
            for (om omVar : this.c) {
                if (omVar != null) {
                    omVar.setOnAdapterItemLongClickListener(mnVar);
                }
            }
        }
    }

    public void h(sp6 sp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sp6Var) == null) {
            this.i.x(sp6Var);
            this.h.x(sp6Var);
            this.g.x(sp6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            nv8 nv8Var = new nv8(tbPageContext, lv8.D);
            this.d = nv8Var;
            nv8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nv8 nv8Var2 = new nv8(tbPageContext, lv8.E);
            this.e = nv8Var2;
            nv8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nv8 nv8Var3 = new nv8(tbPageContext, lv8.F);
            this.f = nv8Var3;
            nv8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            pv8 pv8Var = new pv8(tbPageContext, lv8.I);
            this.g = pv8Var;
            pv8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pv8 pv8Var2 = new pv8(tbPageContext, lv8.H);
            this.h = pv8Var2;
            pv8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pv8 pv8Var3 = new pv8(tbPageContext, lv8.G);
            this.i = pv8Var3;
            pv8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (om omVar : this.c) {
            }
        }
    }
}
