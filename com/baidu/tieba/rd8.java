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
public class rd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<rn> b;
    public List<en> c;
    public nd8 d;
    public nd8 e;
    public nd8 f;
    public pd8 g;
    public pd8 h;
    public pd8 i;

    public rd8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, boVar) == null) {
            for (en enVar : this.c) {
                if (enVar != null) {
                    enVar.setOnAdapterItemClickListener(boVar);
                }
            }
        }
    }

    public void f(ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, coVar) == null) {
            for (en enVar : this.c) {
                if (enVar != null) {
                    enVar.setOnAdapterItemLongClickListener(coVar);
                }
            }
        }
    }

    public void h(vj6 vj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vj6Var) == null) {
            this.i.x(vj6Var);
            this.h.x(vj6Var);
            this.g.x(vj6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            nd8 nd8Var = new nd8(tbPageContext, ld8.C);
            this.d = nd8Var;
            nd8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nd8 nd8Var2 = new nd8(tbPageContext, ld8.D);
            this.e = nd8Var2;
            nd8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nd8 nd8Var3 = new nd8(tbPageContext, ld8.E);
            this.f = nd8Var3;
            nd8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            pd8 pd8Var = new pd8(tbPageContext, ld8.H);
            this.g = pd8Var;
            pd8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pd8 pd8Var2 = new pd8(tbPageContext, ld8.G);
            this.h = pd8Var2;
            pd8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            pd8 pd8Var3 = new pd8(tbPageContext, ld8.F);
            this.i = pd8Var3;
            pd8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (en enVar : this.c) {
            }
        }
    }
}
