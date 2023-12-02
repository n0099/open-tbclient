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
public class s69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<pi> b;
    public List<ci> c;
    public o69 d;
    public o69 e;
    public o69 f;
    public q69 g;
    public q69 h;
    public q69 i;

    public s69(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            o69 o69Var = new o69(tbPageContext, m69.D);
            this.d = o69Var;
            o69Var.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            o69 o69Var2 = new o69(tbPageContext, m69.E);
            this.e = o69Var2;
            o69Var2.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            o69 o69Var3 = new o69(tbPageContext, m69.F);
            this.f = o69Var3;
            o69Var3.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            q69 q69Var = new q69(tbPageContext, m69.I);
            this.g = q69Var;
            q69Var.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            q69 q69Var2 = new q69(tbPageContext, m69.H);
            this.h = q69Var2;
            q69Var2.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            q69 q69Var3 = new q69(tbPageContext, m69.G);
            this.i = q69Var3;
            q69Var3.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
