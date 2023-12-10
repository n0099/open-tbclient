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
/* loaded from: classes8.dex */
public class t69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<pi> b;
    public List<ci> c;
    public p69 d;
    public p69 e;
    public p69 f;
    public r69 g;
    public r69 h;
    public r69 i;

    public t69(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(zi ziVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ziVar) == null) {
            for (ci ciVar : this.c) {
                if (ciVar != null) {
                    ciVar.setOnAdapterItemClickListener(ziVar);
                }
            }
        }
    }

    public void f(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(aj ajVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ajVar) == null) {
            for (ci ciVar : this.c) {
                if (ciVar != null) {
                    ciVar.setOnAdapterItemLongClickListener(ajVar);
                }
            }
        }
    }

    public void h(mm6 mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mm6Var) == null) {
            this.i.y(mm6Var);
            this.h.y(mm6Var);
            this.g.y(mm6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            p69 p69Var = new p69(tbPageContext, n69.D);
            this.d = p69Var;
            p69Var.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            p69 p69Var2 = new p69(tbPageContext, n69.E);
            this.e = p69Var2;
            p69Var2.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            p69 p69Var3 = new p69(tbPageContext, n69.F);
            this.f = p69Var3;
            p69Var3.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            r69 r69Var = new r69(tbPageContext, n69.I);
            this.g = r69Var;
            r69Var.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            r69 r69Var2 = new r69(tbPageContext, n69.H);
            this.h = r69Var2;
            r69Var2.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            r69 r69Var3 = new r69(tbPageContext, n69.G);
            this.i = r69Var3;
            r69Var3.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (ci ciVar : this.c) {
            }
        }
    }
}
