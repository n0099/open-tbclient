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
public class x08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public v08 d;
    public o08 e;
    public q08 f;
    public p08 g;
    public r08 h;
    public w08 i;
    public s08 j;
    public t08 k;
    public n08 l;
    public y08 m;
    public u08 n;
    public List<ln> o;

    public x08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            v08 v08Var = new v08(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = v08Var;
            v08Var.A(this.c);
            this.o.add(this.d);
            o08 o08Var = new o08(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = o08Var;
            o08Var.B(this.c);
            this.o.add(this.e);
            q08 q08Var = new q08(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = q08Var;
            q08Var.A(this.c);
            this.o.add(this.f);
            p08 p08Var = new p08(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = p08Var;
            p08Var.A(this.c);
            this.o.add(this.g);
            r08 r08Var = new r08(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = r08Var;
            r08Var.A(this.c);
            this.o.add(this.h);
            w08 w08Var = new w08(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = w08Var;
            w08Var.D(this.c);
            this.o.add(this.i);
            s08 s08Var = new s08(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = s08Var;
            s08Var.A(this.c);
            this.o.add(this.j);
            t08 t08Var = new t08(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = t08Var;
            t08Var.A(this.c);
            this.o.add(this.k);
            n08 n08Var = new n08(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = n08Var;
            n08Var.B(this.c);
            this.o.add(this.l);
            y08 y08Var = new y08(this.a, dt4.b);
            this.m = y08Var;
            y08Var.z(this.c);
            this.o.add(this.m);
            u08 u08Var = new u08(this.a, o96.r0);
            this.n = u08Var;
            this.o.add(u08Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (ln lnVar : this.o) {
                if (lnVar instanceof m08) {
                    ((m08) lnVar).u(z);
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
