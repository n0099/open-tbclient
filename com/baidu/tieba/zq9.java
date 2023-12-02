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
public class zq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public xq9 d;
    public qq9 e;
    public sq9 f;
    public rq9 g;
    public tq9 h;
    public yq9 i;
    public uq9 j;
    public vq9 k;
    public pq9 l;
    public ar9 m;
    public wq9 n;
    public List<ci> o;

    public zq9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            xq9 xq9Var = new xq9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = xq9Var;
            xq9Var.D(this.c);
            this.o.add(this.d);
            qq9 qq9Var = new qq9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = qq9Var;
            qq9Var.E(this.c);
            this.o.add(this.e);
            sq9 sq9Var = new sq9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = sq9Var;
            sq9Var.D(this.c);
            this.o.add(this.f);
            rq9 rq9Var = new rq9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = rq9Var;
            rq9Var.D(this.c);
            this.o.add(this.g);
            tq9 tq9Var = new tq9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = tq9Var;
            tq9Var.D(this.c);
            this.o.add(this.h);
            yq9 yq9Var = new yq9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = yq9Var;
            yq9Var.G(this.c);
            this.o.add(this.i);
            uq9 uq9Var = new uq9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = uq9Var;
            uq9Var.D(this.c);
            this.o.add(this.j);
            vq9 vq9Var = new vq9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = vq9Var;
            vq9Var.D(this.c);
            this.o.add(this.k);
            pq9 pq9Var = new pq9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = pq9Var;
            pq9Var.E(this.c);
            this.o.add(this.l);
            ar9 ar9Var = new ar9(this.a, gx4.b);
            this.m = ar9Var;
            ar9Var.C(this.c);
            this.o.add(this.m);
            wq9 wq9Var = new wq9(this.a, dn6.u0);
            this.n = wq9Var;
            this.o.add(wq9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (ci ciVar : this.o) {
                if (ciVar instanceof oq9) {
                    ((oq9) ciVar).x(z);
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
