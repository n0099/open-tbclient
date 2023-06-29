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
/* loaded from: classes7.dex */
public class s49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public q49 d;
    public j49 e;
    public l49 f;
    public k49 g;
    public m49 h;
    public r49 i;
    public n49 j;
    public o49 k;
    public i49 l;
    public t49 m;
    public p49 n;
    public List<kn> o;

    public s49(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            q49 q49Var = new q49(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = q49Var;
            q49Var.C(this.c);
            this.o.add(this.d);
            j49 j49Var = new j49(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = j49Var;
            j49Var.D(this.c);
            this.o.add(this.e);
            l49 l49Var = new l49(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = l49Var;
            l49Var.C(this.c);
            this.o.add(this.f);
            k49 k49Var = new k49(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = k49Var;
            k49Var.C(this.c);
            this.o.add(this.g);
            m49 m49Var = new m49(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = m49Var;
            m49Var.C(this.c);
            this.o.add(this.h);
            r49 r49Var = new r49(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = r49Var;
            r49Var.F(this.c);
            this.o.add(this.i);
            n49 n49Var = new n49(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = n49Var;
            n49Var.C(this.c);
            this.o.add(this.j);
            o49 o49Var = new o49(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = o49Var;
            o49Var.C(this.c);
            this.o.add(this.k);
            i49 i49Var = new i49(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = i49Var;
            i49Var.D(this.c);
            this.o.add(this.l);
            t49 t49Var = new t49(this.a, k25.b);
            this.m = t49Var;
            t49Var.B(this.c);
            this.o.add(this.m);
            p49 p49Var = new p49(this.a, gp6.u0);
            this.n = p49Var;
            this.o.add(p49Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (kn knVar : this.o) {
                if (knVar instanceof h49) {
                    ((h49) knVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends xn> list) {
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
