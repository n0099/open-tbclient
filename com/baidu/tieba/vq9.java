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
public class vq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public tq9 d;
    public mq9 e;
    public oq9 f;
    public nq9 g;
    public pq9 h;
    public uq9 i;
    public qq9 j;
    public rq9 k;
    public lq9 l;
    public wq9 m;
    public sq9 n;
    public List<ci> o;

    public vq9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            tq9 tq9Var = new tq9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = tq9Var;
            tq9Var.D(this.c);
            this.o.add(this.d);
            mq9 mq9Var = new mq9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = mq9Var;
            mq9Var.E(this.c);
            this.o.add(this.e);
            oq9 oq9Var = new oq9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = oq9Var;
            oq9Var.D(this.c);
            this.o.add(this.f);
            nq9 nq9Var = new nq9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = nq9Var;
            nq9Var.D(this.c);
            this.o.add(this.g);
            pq9 pq9Var = new pq9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = pq9Var;
            pq9Var.D(this.c);
            this.o.add(this.h);
            uq9 uq9Var = new uq9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = uq9Var;
            uq9Var.G(this.c);
            this.o.add(this.i);
            qq9 qq9Var = new qq9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = qq9Var;
            qq9Var.D(this.c);
            this.o.add(this.j);
            rq9 rq9Var = new rq9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = rq9Var;
            rq9Var.D(this.c);
            this.o.add(this.k);
            lq9 lq9Var = new lq9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = lq9Var;
            lq9Var.E(this.c);
            this.o.add(this.l);
            wq9 wq9Var = new wq9(this.a, dx4.b);
            this.m = wq9Var;
            wq9Var.C(this.c);
            this.o.add(this.m);
            sq9 sq9Var = new sq9(this.a, zm6.u0);
            this.n = sq9Var;
            this.o.add(sq9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (ci ciVar : this.o) {
                if (ciVar instanceof kq9) {
                    ((kq9) ciVar).x(z);
                }
            }
        }
    }

    public void d(List<? extends pi> list) {
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
