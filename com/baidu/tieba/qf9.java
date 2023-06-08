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
/* loaded from: classes7.dex */
public class qf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pf9 a;
    public ef9 b;
    public lf9 c;
    public df9 d;
    public ff9 e;
    public kf9 f;
    public hf9 g;
    public nf9 h;
    public gf9 i;
    public kc9 j;
    public hc9 k;
    public sf9 l;
    public zf9 m;
    public wf9 n;
    public bg9 o;
    public ag9 p;
    public tf9 q;
    public vf9 r;
    public uf9 s;
    public xf9 t;
    public yf9 u;
    public List<in> v;
    public BdTypeRecyclerView w;

    public qf9(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
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
            this.a = new pf9(tbPageContext);
            this.b = new ef9(tbPageContext);
            this.c = new lf9(tbPageContext);
            this.d = new df9(tbPageContext);
            this.e = new ff9(tbPageContext);
            this.f = new kf9(tbPageContext, tbPageContext.getUniqueId());
            this.g = new hf9(tbPageContext, tg9.h);
            this.h = new nf9(tbPageContext);
            this.i = new gf9(tbPageContext);
            this.j = new kc9(tbPageContext, mc9.b);
            this.k = new hc9(tbPageContext.getPageActivity(), dc9.d);
            this.l = new sf9(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new zf9(tbPageContext, wo6.r0);
            this.n = new wf9(tbPageContext, wo6.t0);
            this.o = new bg9(tbPageContext, xo6.U);
            this.p = new ag9(tbPageContext, wo6.u0);
            this.s = new uf9(tbPageContext, wo6.w0);
            this.t = new xf9(tbPageContext, wo6.v0);
            this.u = new yf9(tbPageContext, wo6.x0);
            this.q = new tf9(tbPageContext, ro6.Q0);
            this.r = new vf9(tbPageContext, so6.Q0);
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
            bdTypeRecyclerView.addAdapters(this.v);
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
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof f56) {
                ((f56) inVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.u(z);
            this.c.y(z);
            this.m.z(z);
            this.n.x(z);
            this.o.y(z);
            this.p.x(z);
            this.q.A(z);
            this.r.z(z);
            this.s.z(z);
            this.t.z(z);
            this.u.z(z);
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

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m.B(i);
            this.n.z(i);
            this.o.A(i);
            this.p.z(i);
            this.q.C(i);
            this.r.B(i);
            this.s.B(i);
            this.t.B(i);
            this.u.B(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m.C(i);
            this.n.A(i);
            this.o.B(i);
            this.p.A(i);
            this.q.D(i);
            this.r.C(i);
            this.s.C(i);
            this.t.C(i);
            this.u.C(i);
        }
    }
}
