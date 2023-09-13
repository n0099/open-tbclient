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
public class wt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<cn> b;
    public List<pm> c;
    public yt8 d;
    public yt8 e;
    public yt8 f;

    public wt8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void d(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mnVar) == null) {
            for (pm pmVar : this.c) {
                if (pmVar != null) {
                    pmVar.setOnAdapterItemClickListener(mnVar);
                }
            }
        }
    }

    public void e(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void f(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nnVar) == null) {
            for (pm pmVar : this.c) {
                if (pmVar != null) {
                    pmVar.setOnAdapterItemLongClickListener(nnVar);
                }
            }
        }
    }

    public void g(mp6 mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mp6Var) == null) {
            this.f.x(mp6Var);
            this.e.x(mp6Var);
            this.d.x(mp6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            yt8 yt8Var = new yt8(tbPageContext, xt8.I);
            this.d = yt8Var;
            yt8Var.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            yt8 yt8Var2 = new yt8(tbPageContext, xt8.H);
            this.e = yt8Var2;
            yt8Var2.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            yt8 yt8Var3 = new yt8(tbPageContext, xt8.G);
            this.f = yt8Var3;
            yt8Var3.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            this.c.add(this.f);
            this.c.add(this.e);
            this.c.add(this.d);
            this.a.addAdapters(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }
}
