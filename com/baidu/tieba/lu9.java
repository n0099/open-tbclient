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
public class lu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ku9 a;
    public zt9 b;
    public gu9 c;
    public yt9 d;
    public au9 e;
    public fu9 f;
    public cu9 g;
    public iu9 h;
    public bu9 i;
    public fr9 j;
    public cr9 k;
    public nu9 l;
    public uu9 m;
    public ru9 n;
    public wu9 o;
    public vu9 p;
    public ou9 q;
    public qu9 r;
    public pu9 s;
    public su9 t;
    public tu9 u;
    public List<om> v;
    public BdTypeRecyclerView w;

    public lu9(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
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
            this.a = new ku9(tbPageContext);
            this.b = new zt9(tbPageContext);
            this.c = new gu9(tbPageContext);
            this.d = new yt9(tbPageContext);
            this.e = new au9(tbPageContext);
            this.f = new fu9(tbPageContext, tbPageContext.getUniqueId());
            this.g = new cu9(tbPageContext, ov9.h);
            this.h = new iu9(tbPageContext);
            this.i = new bu9(tbPageContext);
            this.j = new fr9(tbPageContext, hr9.b);
            this.k = new cr9(tbPageContext.getPageActivity(), yq9.d);
            this.l = new nu9(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new uu9(tbPageContext, zo6.r0);
            this.n = new ru9(tbPageContext, zo6.t0);
            this.o = new wu9(tbPageContext, ap6.U);
            this.p = new vu9(tbPageContext, zo6.u0);
            this.s = new pu9(tbPageContext, zo6.w0);
            this.t = new su9(tbPageContext, zo6.v0);
            this.u = new tu9(tbPageContext, zo6.x0);
            this.q = new ou9(tbPageContext, uo6.S0);
            this.r = new qu9(tbPageContext, vo6.S0);
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
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof s46) {
                ((s46) omVar).g(str);
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
