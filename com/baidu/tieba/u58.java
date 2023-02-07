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
/* loaded from: classes6.dex */
public class u58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public s58 d;
    public l58 e;
    public n58 f;
    public m58 g;
    public o58 h;
    public t58 i;
    public p58 j;
    public q58 k;
    public k58 l;
    public v58 m;
    public r58 n;
    public List<qn> o;

    public u58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            s58 s58Var = new s58(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = s58Var;
            s58Var.A(this.c);
            this.o.add(this.d);
            l58 l58Var = new l58(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = l58Var;
            l58Var.B(this.c);
            this.o.add(this.e);
            n58 n58Var = new n58(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = n58Var;
            n58Var.A(this.c);
            this.o.add(this.f);
            m58 m58Var = new m58(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = m58Var;
            m58Var.A(this.c);
            this.o.add(this.g);
            o58 o58Var = new o58(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = o58Var;
            o58Var.A(this.c);
            this.o.add(this.h);
            t58 t58Var = new t58(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = t58Var;
            t58Var.D(this.c);
            this.o.add(this.i);
            p58 p58Var = new p58(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = p58Var;
            p58Var.A(this.c);
            this.o.add(this.j);
            q58 q58Var = new q58(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = q58Var;
            q58Var.A(this.c);
            this.o.add(this.k);
            k58 k58Var = new k58(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = k58Var;
            k58Var.B(this.c);
            this.o.add(this.l);
            v58 v58Var = new v58(this.a, qx4.b);
            this.m = v58Var;
            v58Var.z(this.c);
            this.o.add(this.m);
            r58 r58Var = new r58(this.a, ae6.s0);
            this.n = r58Var;
            this.o.add(r58Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (qn qnVar : this.o) {
                if (qnVar instanceof j58) {
                    ((j58) qnVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends Cdo> list) {
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
