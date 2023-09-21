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
/* loaded from: classes7.dex */
public class q08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m18 A;
    public x08 B;
    public j18 C;
    public y08 D;
    public k18 E;
    public ConcernEmotionTipAdapter F;
    public u18 G;
    public ArrayList<om> H;
    public List<bn> I;
    public List<om> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public v08 f;
    public p18 g;
    public ArrayList<l18> h;
    public r18 i;
    public r18 j;
    public d18 k;
    public q18 l;
    public f18 m;
    public o18 n;
    public c18 o;
    public b18 p;
    public a18 q;
    public z08 r;
    public s18 s;
    public e18 t;
    public g18 u;
    public h18 v;
    public n18 w;
    public i18 x;
    public t18 y;
    public u08 z;

    public q08(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.h = new ArrayList<>();
        this.a = new ArrayList();
        this.b = bdTypeRecyclerView;
        this.c = (TbPageContext) m9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<bn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.I;
        }
        return (List) invokeV.objValue;
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.b) != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < aq6.O.size(); i++) {
                for (int i2 = 0; i2 < aq6.P.size(); i2++) {
                    this.h.add(new l18(this.c, aq6.Q[i][i2], aq6.O.get(i), aq6.P.get(i2)));
                }
            }
            this.i = new r18(this.c, ThreadData.TYPE_VIDEO, aq6.D);
            this.j = new r18(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, aq6.E);
            this.k = new d18(this.c, ThreadData.TYPE_FAKE_VIDEO, aq6.D);
            this.l = new q18(this.c, iq6.E0);
            this.m = new f18(this.c, iq6.F0);
            this.t = new e18(this.c, iq6.M0);
            this.u = new g18(this.c, iq6.N0);
            this.n = new o18(this.c, iq6.L0);
            this.o = new c18(this.c, iq6.G0);
            this.p = new b18(this.c, iq6.H0);
            this.q = new a18(this.c, iq6.I0);
            this.s = new s18(this.c, jq6.U);
            this.B = new x08(this.c, dq6.S0);
            this.r = new z08(this.c, iq6.J0);
            this.A = new m18(this.c, w35.e);
            this.v = new h18(this.c, iq6.O0);
            this.w = new n18(this.c, iq6.P0);
            this.x = new i18(this.c, iq6.Q0);
            this.y = new t18(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
            this.a.addAll(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.s);
            this.a.add(this.r);
            this.a.add(this.A);
            this.a.add(this.v);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.d = new ConcernTipAdapter(this.c.getContext());
            this.e = new ConcernEmotionTipAdapter(this.c);
            this.f = new v08(this.c, hq6.S0);
            this.z = new u08(this.c, a28.b);
            this.g = new p18(this.c, iq6.u0);
            this.C = new j18(this.c, iq6.v0);
            this.D = new y08(this.c, iq6.w0);
            this.E = new k18(this.c, iq6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, b28.f);
            this.G = new u18(this.c, iq6.z0, (byte) 4);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.z);
            this.a.add(this.g);
            this.a.add(this.C);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.B);
            this.a.add(this.F);
            this.a.add(this.G);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.w.set(false);
                return;
            }
            this.H = new ArrayList<>();
            om<?, ?> h = g5a.m().h(this.c, AdvertAppInfo.z, "CONCERN");
            om<?, ?> h2 = g5a.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            om<?, ?> h3 = g5a.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            om<?, ?> h4 = g5a.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            om<?, ?> h5 = g5a.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            om<?, ?> h6 = g5a.m().h(this.c, AdvertAppInfo.F, "CONCERN");
            om<?, ?> h7 = g5a.m().h(this.c, AdvertAppInfo.E, "CONCERN");
            this.H.add(h);
            this.H.add(h2);
            this.H.add(h3);
            this.H.add(h4);
            this.H.add(h5);
            this.H.add(h6);
            this.H.add(h7);
            this.a.addAll(this.H);
            AdvertAppInfo.w.set(true);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public final void g(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof p56) {
                ((p56) omVar).g(str);
            }
        }
    }

    public void j(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || t49.e(this.I)) {
            return;
        }
        Iterator<om> it = this.H.iterator();
        while (it.hasNext()) {
            om next = it.next();
            if (next instanceof w4a) {
                ((w4a) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<l18> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a = bdUniqueId;
            }
            this.f.a = bdUniqueId;
            this.g.a = bdUniqueId;
            this.E.a = bdUniqueId;
            this.C.a = bdUniqueId;
            this.D.a = bdUniqueId;
            this.B.a = bdUniqueId;
            this.r.a = bdUniqueId;
            this.A.a = bdUniqueId;
            this.G.b = bdUniqueId;
            this.y.a = bdUniqueId;
            this.z.u(bdUniqueId);
        }
    }

    public final void i(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hnVar) == null) {
            Iterator<l18> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(hnVar);
            }
            this.i.E(hnVar);
            this.j.E(hnVar);
            this.k.z(hnVar);
            this.l.z(hnVar);
            this.m.A(hnVar);
            this.t.z(hnVar);
            this.u.z(hnVar);
            this.n.z(hnVar);
            this.A.x(hnVar);
            this.v.u(hnVar);
            this.w.x(hnVar);
            this.x.u(hnVar);
            this.y.z(hnVar);
            this.o.z(hnVar);
            this.p.z(hnVar);
            this.q.z(hnVar);
            this.s.C(hnVar);
            this.r.A(hnVar);
            this.B.A(hnVar);
            this.D.z(hnVar);
            this.C.A(hnVar);
            this.E.A(hnVar);
            this.G.u(hnVar);
        }
    }
}
