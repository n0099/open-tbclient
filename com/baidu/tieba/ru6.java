package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ru6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wu6 A;
    public ov6 B;
    public zu6 C;
    public lv6 D;
    public av6 E;
    public mv6 F;
    public ConcernEmotionTipAdapter G;
    public wv6 H;
    public ArrayList<cn> I;
    public List<pn> J;
    public List<cn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public xu6 f;
    public vu6 g;
    public rv6 h;
    public ArrayList<nv6> i;
    public tv6 j;
    public tv6 k;
    public fv6 l;
    public sv6 m;
    public hv6 n;
    public qv6 o;
    public ev6 p;
    public dv6 q;
    public cv6 r;
    public bv6 s;
    public uv6 t;
    public gv6 u;
    public iv6 v;
    public jv6 w;
    public pv6 x;
    public kv6 y;
    public vv6 z;

    public ru6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList<>();
        this.a = new ArrayList();
        this.b = bdTypeRecyclerView;
        this.c = (TbPageContext) i9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<pn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < l06.O.size(); i++) {
                for (int i2 = 0; i2 < l06.P.size(); i2++) {
                    this.i.add(new nv6(this.c, l06.Q[i][i2], l06.O.get(i), l06.P.get(i2)));
                }
            }
            this.j = new tv6(this.c, ThreadData.TYPE_VIDEO, l06.D);
            this.k = new tv6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, l06.E);
            this.l = new fv6(this.c, ThreadData.TYPE_FAKE_VIDEO, l06.D);
            this.m = new sv6(this.c, t06.z0);
            this.n = new hv6(this.c, t06.A0);
            this.u = new gv6(this.c, t06.H0);
            this.v = new iv6(this.c, t06.I0);
            this.o = new qv6(this.c, t06.G0);
            this.p = new ev6(this.c, t06.B0);
            this.q = new dv6(this.c, t06.C0);
            this.r = new cv6(this.c, t06.D0);
            this.t = new uv6(this.c, u06.U);
            this.C = new zu6(this.c, o06.N0);
            this.s = new bv6(this.c, t06.E0);
            this.B = new ov6(this.c, ar4.e);
            this.w = new jv6(this.c, t06.J0);
            this.x = new pv6(this.c, t06.K0);
            this.y = new kv6(this.c, t06.L0);
            this.z = new vv6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
            this.a.addAll(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.u);
            this.a.add(this.v);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.t);
            this.a.add(this.s);
            this.a.add(this.B);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.d = new ConcernTipAdapter(this.c.getContext());
            this.e = new ConcernEmotionTipAdapter(this.c.getContext());
            this.f = new xu6(this.c, s06.N0);
            this.A = new wu6(this.c, yv6.b);
            this.g = new vu6(this.c, s06.O0);
            this.h = new rv6(this.c, t06.r0);
            this.D = new lv6(this.c, t06.s0);
            this.E = new av6(this.c, t06.t0);
            this.F = new mv6(this.c, t06.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), zv6.f);
            this.H = new wv6(this.c, t06.x0, (byte) 4);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.A);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.C);
            this.a.add(this.G);
            this.a.add(this.H);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.I = new ArrayList<>();
            cn<?, ?> g = ec8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            cn<?, ?> g2 = ec8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            cn<?, ?> g3 = ec8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            cn<?, ?> g4 = ec8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            cn<?, ?> g5 = ec8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            cn<?, ?> g6 = ec8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            cn<?, ?> g7 = ec8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
            this.I.add(g);
            this.I.add(g2);
            this.I.add(g3);
            this.I.add(g4);
            this.I.add(g5);
            this.I.add(g6);
            this.I.add(g7);
            this.a.addAll(this.I);
            AdvertAppInfo.v.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || gf7.e(this.J)) {
            return;
        }
        Iterator<cn> it = this.I.iterator();
        while (it.hasNext()) {
            cn next = it.next();
            if (next instanceof vb8) {
                ((vb8) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof vl5) {
                ((vl5) cnVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<nv6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a = bdUniqueId;
            }
            this.f.a = bdUniqueId;
            this.g.a = bdUniqueId;
            this.h.a = bdUniqueId;
            this.F.a = bdUniqueId;
            this.D.a = bdUniqueId;
            this.E.a = bdUniqueId;
            this.C.a = bdUniqueId;
            this.s.a = bdUniqueId;
            this.B.a = bdUniqueId;
            this.H.b = bdUniqueId;
            this.z.a = bdUniqueId;
            this.A.u(bdUniqueId);
        }
    }

    public final void i(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vnVar) == null) {
            Iterator<nv6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(vnVar);
            }
            this.j.C(vnVar);
            this.k.C(vnVar);
            this.l.x(vnVar);
            this.m.x(vnVar);
            this.n.y(vnVar);
            this.u.x(vnVar);
            this.v.x(vnVar);
            this.o.x(vnVar);
            this.B.v(vnVar);
            this.w.u(vnVar);
            this.x.v(vnVar);
            this.y.u(vnVar);
            this.z.x(vnVar);
            this.p.x(vnVar);
            this.q.x(vnVar);
            this.r.x(vnVar);
            this.t.A(vnVar);
            this.s.y(vnVar);
            this.C.y(vnVar);
            this.E.x(vnVar);
            this.D.y(vnVar);
            this.F.y(vnVar);
            this.H.u(vnVar);
        }
    }

    public void j(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }
}
