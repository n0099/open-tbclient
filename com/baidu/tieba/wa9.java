package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class wa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public ua9 d;
    public na9 e;
    public pa9 f;
    public oa9 g;
    public qa9 h;
    public va9 i;
    public ra9 j;
    public sa9 k;
    public ma9 l;
    public xa9 m;
    public ta9 n;
    public List<ln> o;

    public wa9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.a = tbPageContext;
        this.b = bdUniqueId;
        this.c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ua9 ua9Var = new ua9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = ua9Var;
            ua9Var.C(this.c);
            this.o.add(this.d);
            na9 na9Var = new na9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = na9Var;
            na9Var.D(this.c);
            this.o.add(this.e);
            pa9 pa9Var = new pa9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = pa9Var;
            pa9Var.C(this.c);
            this.o.add(this.f);
            oa9 oa9Var = new oa9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = oa9Var;
            oa9Var.C(this.c);
            this.o.add(this.g);
            qa9 qa9Var = new qa9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = qa9Var;
            qa9Var.C(this.c);
            this.o.add(this.h);
            va9 va9Var = new va9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = va9Var;
            va9Var.F(this.c);
            this.o.add(this.i);
            ra9 ra9Var = new ra9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = ra9Var;
            ra9Var.C(this.c);
            this.o.add(this.j);
            sa9 sa9Var = new sa9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = sa9Var;
            sa9Var.C(this.c);
            this.o.add(this.k);
            ma9 ma9Var = new ma9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = ma9Var;
            ma9Var.D(this.c);
            this.o.add(this.l);
            xa9 xa9Var = new xa9(this.a, s25.b);
            this.m = xa9Var;
            xa9Var.B(this.c);
            this.o.add(this.m);
            ta9 ta9Var = new ta9(this.a, kq6.u0);
            this.n = ta9Var;
            this.o.add(ta9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (ln lnVar : this.o) {
                if (lnVar instanceof la9) {
                    ((la9) lnVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }
}
