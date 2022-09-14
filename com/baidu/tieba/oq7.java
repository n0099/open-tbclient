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
/* loaded from: classes5.dex */
public class oq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public mq7 d;
    public fq7 e;
    public hq7 f;
    public gq7 g;
    public iq7 h;
    public nq7 i;
    public jq7 j;
    public kq7 k;
    public eq7 l;
    public pq7 m;
    public lq7 n;
    public List<qn> o;

    public oq7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            mq7 mq7Var = new mq7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = mq7Var;
            mq7Var.A(this.c);
            this.o.add(this.d);
            fq7 fq7Var = new fq7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = fq7Var;
            fq7Var.B(this.c);
            this.o.add(this.e);
            hq7 hq7Var = new hq7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = hq7Var;
            hq7Var.A(this.c);
            this.o.add(this.f);
            gq7 gq7Var = new gq7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = gq7Var;
            gq7Var.A(this.c);
            this.o.add(this.g);
            iq7 iq7Var = new iq7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = iq7Var;
            iq7Var.A(this.c);
            this.o.add(this.h);
            nq7 nq7Var = new nq7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = nq7Var;
            nq7Var.D(this.c);
            this.o.add(this.i);
            jq7 jq7Var = new jq7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = jq7Var;
            jq7Var.A(this.c);
            this.o.add(this.j);
            kq7 kq7Var = new kq7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = kq7Var;
            kq7Var.A(this.c);
            this.o.add(this.k);
            eq7 eq7Var = new eq7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = eq7Var;
            eq7Var.B(this.c);
            this.o.add(this.l);
            pq7 pq7Var = new pq7(this.a, jr4.b);
            this.m = pq7Var;
            pq7Var.z(this.c);
            this.o.add(this.m);
            lq7 lq7Var = new lq7(this.a, k26.r0);
            this.n = lq7Var;
            this.o.add(lq7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (qn qnVar : this.o) {
                if (qnVar instanceof dq7) {
                    ((dq7) qnVar).u(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
