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
public class uc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<pn> b;
    public List<cn> c;
    public qc7 d;
    public qc7 e;
    public qc7 f;
    public sc7 g;
    public sc7 h;
    public sc7 i;

    public uc7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (bdTypeRecyclerView = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.D(i);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            qc7 qc7Var = new qc7(tbPageContext, oc7.A);
            this.d = qc7Var;
            qc7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            qc7 qc7Var2 = new qc7(tbPageContext, oc7.B);
            this.e = qc7Var2;
            qc7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            qc7 qc7Var3 = new qc7(tbPageContext, oc7.C);
            this.f = qc7Var3;
            qc7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            sc7 sc7Var = new sc7(tbPageContext, oc7.F);
            this.g = sc7Var;
            sc7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            sc7 sc7Var2 = new sc7(tbPageContext, oc7.E);
            this.h = sc7Var2;
            sc7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            sc7 sc7Var3 = new sc7(tbPageContext, oc7.D);
            this.i = sc7Var3;
            sc7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (cn cnVar : this.c) {
            }
        }
    }

    public void e(zn znVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, znVar) == null) {
            for (cn cnVar : this.c) {
                if (cnVar != null) {
                    cnVar.setOnAdapterItemClickListener(znVar);
                }
            }
        }
    }

    public void f(ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aoVar) == null) {
            for (cn cnVar : this.c) {
                if (cnVar != null) {
                    cnVar.setOnAdapterItemLongClickListener(aoVar);
                }
            }
        }
    }

    public void h(h06 h06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h06Var) == null) {
            this.i.v(h06Var);
            this.h.v(h06Var);
            this.g.v(h06Var);
        }
    }
}
