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
public class we7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList b;
    public List c;
    public se7 d;
    public se7 e;
    public se7 f;
    public ue7 g;
    public ue7 h;
    public ue7 i;

    public we7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            bdTypeRecyclerView.D(i);
        }
    }

    public void e(oo ooVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ooVar) == null) {
            for (rn rnVar : this.c) {
                if (rnVar != null) {
                    rnVar.setOnAdapterItemClickListener(ooVar);
                }
            }
        }
    }

    public void f(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(po poVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, poVar) == null) {
            for (rn rnVar : this.c) {
                if (rnVar != null) {
                    rnVar.setOnAdapterItemLongClickListener(poVar);
                }
            }
        }
    }

    public void h(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p26Var) == null) {
            this.i.v(p26Var);
            this.h.v(p26Var);
            this.g.v(p26Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            se7 se7Var = new se7(tbPageContext, qe7.A);
            this.d = se7Var;
            se7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            se7 se7Var2 = new se7(tbPageContext, qe7.B);
            this.e = se7Var2;
            se7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            se7 se7Var3 = new se7(tbPageContext, qe7.C);
            this.f = se7Var3;
            se7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ue7 ue7Var = new ue7(tbPageContext, qe7.F);
            this.g = ue7Var;
            ue7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ue7 ue7Var2 = new ue7(tbPageContext, qe7.E);
            this.h = ue7Var2;
            ue7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ue7 ue7Var3 = new ue7(tbPageContext, qe7.D);
            this.i = ue7Var3;
            ue7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (rn rnVar : this.c) {
            }
        }
    }
}
