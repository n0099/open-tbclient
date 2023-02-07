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
public class ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<Cdo> b;
    public List<qn> c;
    public kt7 d;
    public kt7 e;
    public kt7 f;
    public mt7 g;
    public mt7 h;
    public mt7 i;

    public ot7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(no noVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, noVar) == null) {
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    qnVar.setOnAdapterItemClickListener(noVar);
                }
            }
        }
    }

    public void f(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(oo ooVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ooVar) == null) {
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    qnVar.setOnAdapterItemLongClickListener(ooVar);
                }
            }
        }
    }

    public void h(ld6 ld6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ld6Var) == null) {
            this.i.v(ld6Var);
            this.h.v(ld6Var);
            this.g.v(ld6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            kt7 kt7Var = new kt7(tbPageContext, it7.A);
            this.d = kt7Var;
            kt7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            kt7 kt7Var2 = new kt7(tbPageContext, it7.B);
            this.e = kt7Var2;
            kt7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            kt7 kt7Var3 = new kt7(tbPageContext, it7.C);
            this.f = kt7Var3;
            kt7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            mt7 mt7Var = new mt7(tbPageContext, it7.F);
            this.g = mt7Var;
            mt7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            mt7 mt7Var2 = new mt7(tbPageContext, it7.E);
            this.h = mt7Var2;
            mt7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            mt7 mt7Var3 = new mt7(tbPageContext, it7.D);
            this.i = mt7Var3;
            mt7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (qn qnVar : this.c) {
            }
        }
    }
}
