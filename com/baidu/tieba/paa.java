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
public class paa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oaa a;
    public daa b;
    public kaa c;
    public caa d;
    public eaa e;
    public jaa f;
    public gaa g;
    public maa h;
    public faa i;
    public j7a j;
    public g7a k;
    public raa l;
    public yaa m;
    public vaa n;
    public aba o;
    public zaa p;
    public saa q;
    public uaa r;
    public taa s;
    public waa t;
    public xaa u;
    public List<ci> v;
    public BdTypeRecyclerView w;

    public paa(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
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
            this.a = new oaa(tbPageContext);
            this.b = new daa(tbPageContext);
            this.c = new kaa(tbPageContext);
            this.d = new caa(tbPageContext);
            this.e = new eaa(tbPageContext);
            this.f = new jaa(tbPageContext, tbPageContext.getUniqueId());
            this.g = new gaa(tbPageContext, sba.h);
            this.h = new maa(tbPageContext);
            this.i = new faa(tbPageContext);
            this.j = new j7a(tbPageContext, l7a.b);
            this.k = new g7a(tbPageContext.getPageActivity(), b7a.d);
            this.l = new raa(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new yaa(tbPageContext, zm6.r0);
            this.n = new vaa(tbPageContext, zm6.t0);
            this.o = new aba(tbPageContext, an6.U);
            this.p = new zaa(tbPageContext, zm6.u0);
            this.s = new taa(tbPageContext, zm6.w0);
            this.t = new waa(tbPageContext, zm6.v0);
            this.u = new xaa(tbPageContext, zm6.x0);
            this.q = new saa(tbPageContext, tm6.S0);
            this.r = new uaa(tbPageContext, um6.S0);
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
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof a26) {
                ((a26) ciVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.x(z);
            this.c.z(z);
            this.m.A(z);
            this.n.y(z);
            this.o.z(z);
            this.p.y(z);
            this.q.B(z);
            this.r.A(z);
            this.s.A(z);
            this.t.A(z);
            this.u.A(z);
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

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
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

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m.D(i);
            this.n.B(i);
            this.o.C(i);
            this.p.B(i);
            this.q.E(i);
            this.r.D(i);
            this.s.D(i);
            this.t.D(i);
            this.u.D(i);
        }
    }
}
