package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class v98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u98 a;
    public j98 b;
    public q98 c;
    public i98 d;
    public k98 e;
    public p98 f;
    public m98 g;
    public s98 h;
    public l98 i;
    public r68 j;
    public o68 k;
    public x98 l;
    public ea8 m;
    public ba8 n;
    public ga8 o;
    public fa8 p;
    public y98 q;
    public aa8 r;
    public z98 s;
    public ca8 t;
    public da8 u;
    public List<kn> v;
    public BdTypeRecyclerView w;

    public v98(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new ArrayList();
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bdTypeRecyclerView) == null) {
            this.w = bdTypeRecyclerView;
            this.a = new u98(tbPageContext);
            this.b = new j98(tbPageContext);
            this.c = new q98(tbPageContext);
            this.d = new i98(tbPageContext);
            this.e = new k98(tbPageContext);
            this.f = new p98(tbPageContext, tbPageContext.getUniqueId());
            this.g = new m98(tbPageContext, ya8.h);
            this.h = new s98(tbPageContext);
            this.i = new l98(tbPageContext);
            this.j = new r68(tbPageContext, t68.b);
            this.k = new o68(tbPageContext.getPageActivity(), k68.d);
            this.l = new x98(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new ea8(tbPageContext, b56.i0);
            this.n = new ba8(tbPageContext, b56.q0);
            this.o = new ga8(tbPageContext, c56.U);
            this.p = new fa8(tbPageContext, b56.r0);
            this.s = new z98(tbPageContext, b56.t0);
            this.t = new ca8(tbPageContext, b56.s0);
            this.u = new da8(tbPageContext, b56.u0);
            this.q = new y98(tbPageContext, w46.N0);
            this.r = new aa8(tbPageContext, x46.N0);
            this.v.add(this.a);
            this.v.add(this.b);
            this.v.add(this.c);
            this.v.add(this.d);
            this.v.add(this.e);
            this.v.add(this.f);
            this.v.add(this.g);
            this.v.add(this.h);
            this.v.add(this.i);
            this.v.add(this.j);
            this.v.add(this.k);
            this.v.add(this.l);
            this.v.add(this.m);
            this.v.add(this.n);
            this.v.add(this.o);
            this.v.add(this.p);
            this.v.add(this.s);
            this.v.add(this.t);
            this.v.add(this.u);
            this.v.add(this.q);
            this.v.add(this.r);
            bdTypeRecyclerView.a(this.v);
            c("page_recommend");
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.w.getListAdapter() != null) {
            this.w.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void c(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof mq5) {
                ((mq5) knVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.u(z);
            this.c.w(z);
            this.m.x(z);
            this.n.v(z);
            this.o.w(z);
            this.p.v(z);
            this.q.y(z);
            this.r.x(z);
            this.s.x(z);
            this.t.x(z);
            this.u.x(z);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.m.a = bdUniqueId;
            this.n.a = bdUniqueId;
            this.o.a = bdUniqueId;
            this.p.a = bdUniqueId;
            this.s.a = bdUniqueId;
            this.t.a = bdUniqueId;
            this.u.a = bdUniqueId;
            this.q.a = bdUniqueId;
            this.r.a = bdUniqueId;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.m.y(i);
            this.n.w(i);
            this.o.x(i);
            this.p.w(i);
            this.q.z(i);
            this.r.y(i);
            this.s.y(i);
            this.t.y(i);
            this.u.y(i);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m.z(i);
            this.n.x(i);
            this.o.y(i);
            this.p.x(i);
            this.q.A(i);
            this.r.z(i);
            this.s.z(i);
            this.t.z(i);
            this.u.z(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m.A(i);
            this.n.y(i);
            this.o.z(i);
            this.p.y(i);
            this.q.B(i);
            this.r.A(i);
            this.s.A(i);
            this.t.A(i);
            this.u.A(i);
        }
    }
}
