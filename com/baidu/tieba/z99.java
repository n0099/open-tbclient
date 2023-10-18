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
/* loaded from: classes9.dex */
public class z99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public x99 d;
    public q99 e;
    public s99 f;
    public r99 g;
    public t99 h;
    public y99 i;
    public u99 j;
    public v99 k;
    public p99 l;
    public aa9 m;
    public w99 n;
    public List<lh> o;

    public z99(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            x99 x99Var = new x99(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = x99Var;
            x99Var.C(this.c);
            this.o.add(this.d);
            q99 q99Var = new q99(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = q99Var;
            q99Var.D(this.c);
            this.o.add(this.e);
            s99 s99Var = new s99(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = s99Var;
            s99Var.C(this.c);
            this.o.add(this.f);
            r99 r99Var = new r99(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = r99Var;
            r99Var.C(this.c);
            this.o.add(this.g);
            t99 t99Var = new t99(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = t99Var;
            t99Var.C(this.c);
            this.o.add(this.h);
            y99 y99Var = new y99(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = y99Var;
            y99Var.F(this.c);
            this.o.add(this.i);
            u99 u99Var = new u99(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = u99Var;
            u99Var.C(this.c);
            this.o.add(this.j);
            v99 v99Var = new v99(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = v99Var;
            v99Var.C(this.c);
            this.o.add(this.k);
            p99 p99Var = new p99(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = p99Var;
            p99Var.D(this.c);
            this.o.add(this.l);
            aa9 aa9Var = new aa9(this.a, jw4.b);
            this.m = aa9Var;
            aa9Var.B(this.c);
            this.o.add(this.m);
            w99 w99Var = new w99(this.a, rk6.u0);
            this.n = w99Var;
            this.o.add(w99Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (lh lhVar : this.o) {
                if (lhVar instanceof o99) {
                    ((o99) lhVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends yh> list) {
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
