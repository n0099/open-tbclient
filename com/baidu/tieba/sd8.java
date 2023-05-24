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
public class sd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<rn> b;
    public List<en> c;
    public od8 d;
    public od8 e;
    public od8 f;
    public qd8 g;
    public qd8 h;
    public qd8 i;

    public sd8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void h(wj6 wj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wj6Var) == null) {
            this.i.x(wj6Var);
            this.h.x(wj6Var);
            this.g.x(wj6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            od8 od8Var = new od8(tbPageContext, md8.C);
            this.d = od8Var;
            od8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            od8 od8Var2 = new od8(tbPageContext, md8.D);
            this.e = od8Var2;
            od8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            od8 od8Var3 = new od8(tbPageContext, md8.E);
            this.f = od8Var3;
            od8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            qd8 qd8Var = new qd8(tbPageContext, md8.H);
            this.g = qd8Var;
            qd8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            qd8 qd8Var2 = new qd8(tbPageContext, md8.G);
            this.h = qd8Var2;
            qd8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            qd8 qd8Var3 = new qd8(tbPageContext, md8.F);
            this.i = qd8Var3;
            qd8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
