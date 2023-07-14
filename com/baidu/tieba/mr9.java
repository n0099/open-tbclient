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
public class mr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lr9 a;
    public ar9 b;
    public hr9 c;
    public zq9 d;
    public br9 e;
    public gr9 f;
    public dr9 g;
    public jr9 h;
    public cr9 i;
    public go9 j;
    public do9 k;
    public or9 l;
    public vr9 m;
    public sr9 n;
    public xr9 o;
    public wr9 p;
    public pr9 q;
    public rr9 r;
    public qr9 s;
    public tr9 t;
    public ur9 u;
    public List<ln> v;
    public BdTypeRecyclerView w;

    public mr9(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
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
            this.a = new lr9(tbPageContext);
            this.b = new ar9(tbPageContext);
            this.c = new hr9(tbPageContext);
            this.d = new zq9(tbPageContext);
            this.e = new br9(tbPageContext);
            this.f = new gr9(tbPageContext, tbPageContext.getUniqueId());
            this.g = new dr9(tbPageContext, ps9.h);
            this.h = new jr9(tbPageContext);
            this.i = new cr9(tbPageContext);
            this.j = new go9(tbPageContext, io9.b);
            this.k = new do9(tbPageContext.getPageActivity(), zn9.d);
            this.l = new or9(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new vr9(tbPageContext, kq6.r0);
            this.n = new sr9(tbPageContext, kq6.t0);
            this.o = new xr9(tbPageContext, lq6.U);
            this.p = new wr9(tbPageContext, kq6.u0);
            this.s = new qr9(tbPageContext, kq6.w0);
            this.t = new tr9(tbPageContext, kq6.v0);
            this.u = new ur9(tbPageContext, kq6.x0);
            this.q = new pr9(tbPageContext, fq6.S0);
            this.r = new rr9(tbPageContext, gq6.S0);
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
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof t66) {
                ((t66) lnVar).g(str);
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
