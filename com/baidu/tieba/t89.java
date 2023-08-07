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
public class t89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public r89 d;
    public k89 e;
    public m89 f;
    public l89 g;
    public n89 h;
    public s89 i;
    public o89 j;
    public p89 k;
    public j89 l;
    public u89 m;
    public q89 n;
    public List<lm> o;

    public t89(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            r89 r89Var = new r89(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = r89Var;
            r89Var.C(this.c);
            this.o.add(this.d);
            k89 k89Var = new k89(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = k89Var;
            k89Var.D(this.c);
            this.o.add(this.e);
            m89 m89Var = new m89(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = m89Var;
            m89Var.C(this.c);
            this.o.add(this.f);
            l89 l89Var = new l89(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = l89Var;
            l89Var.C(this.c);
            this.o.add(this.g);
            n89 n89Var = new n89(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = n89Var;
            n89Var.C(this.c);
            this.o.add(this.h);
            s89 s89Var = new s89(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = s89Var;
            s89Var.F(this.c);
            this.o.add(this.i);
            o89 o89Var = new o89(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = o89Var;
            o89Var.C(this.c);
            this.o.add(this.j);
            p89 p89Var = new p89(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = p89Var;
            p89Var.C(this.c);
            this.o.add(this.k);
            j89 j89Var = new j89(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = j89Var;
            j89Var.D(this.c);
            this.o.add(this.l);
            u89 u89Var = new u89(this.a, q15.b);
            this.m = u89Var;
            u89Var.B(this.c);
            this.o.add(this.m);
            q89 q89Var = new q89(this.a, rn6.u0);
            this.n = q89Var;
            this.o.add(q89Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (lm lmVar : this.o) {
                if (lmVar instanceof i89) {
                    ((i89) lmVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends ym> list) {
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
