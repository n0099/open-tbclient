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
public class z78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y78 a;
    public n78 b;
    public u78 c;
    public m78 d;
    public o78 e;
    public t78 f;
    public q78 g;
    public w78 h;
    public p78 i;
    public v48 j;
    public s48 k;
    public b88 l;
    public i88 m;
    public f88 n;
    public k88 o;
    public j88 p;
    public c88 q;
    public e88 r;
    public d88 s;
    public g88 t;
    public h88 u;
    public List v;
    public BdTypeRecyclerView w;

    public z78(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
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
            this.a = new y78(tbPageContext);
            this.b = new n78(tbPageContext);
            this.c = new u78(tbPageContext);
            this.d = new m78(tbPageContext);
            this.e = new o78(tbPageContext);
            this.f = new t78(tbPageContext, tbPageContext.getUniqueId());
            this.g = new q78(tbPageContext, c98.h);
            this.h = new w78(tbPageContext);
            this.i = new p78(tbPageContext);
            this.j = new v48(tbPageContext, x48.b);
            this.k = new s48(tbPageContext.getPageActivity(), o48.d);
            this.l = new b88(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new i88(tbPageContext, e36.i0);
            this.n = new f88(tbPageContext, e36.q0);
            this.o = new k88(tbPageContext, f36.U);
            this.p = new j88(tbPageContext, e36.r0);
            this.s = new d88(tbPageContext, e36.t0);
            this.t = new g88(tbPageContext, e36.s0);
            this.u = new h88(tbPageContext, e36.u0);
            this.q = new c88(tbPageContext, z26.N0);
            this.r = new e88(tbPageContext, a36.N0);
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
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (rn rnVar : list) {
            if (rnVar instanceof ap5) {
                ((ap5) rnVar).g(str);
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
