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
public class pz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz6 A;
    public m07 B;
    public xz6 C;
    public j07 D;
    public yz6 E;
    public k07 F;
    public ConcernEmotionTipAdapter G;
    public u07 H;
    public ArrayList<kn> I;
    public List<xn> J;
    public List<kn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public vz6 f;
    public tz6 g;
    public p07 h;
    public ArrayList<l07> i;
    public r07 j;
    public r07 k;
    public d07 l;
    public q07 m;
    public f07 n;
    public o07 o;
    public c07 p;
    public b07 q;
    public a07 r;
    public zz6 s;
    public s07 t;
    public e07 u;
    public g07 v;
    public h07 w;
    public n07 x;
    public i07 y;
    public t07 z;

    public pz6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) x9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<xn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.J;
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
            for (int i = 0; i < o56.O.size(); i++) {
                for (int i2 = 0; i2 < o56.P.size(); i2++) {
                    this.i.add(new l07(this.c, o56.Q[i][i2], o56.O.get(i), o56.P.get(i2)));
                }
            }
            this.j = new r07(this.c, ThreadData.TYPE_VIDEO, o56.D);
            this.k = new r07(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, o56.E);
            this.l = new d07(this.c, ThreadData.TYPE_FAKE_VIDEO, o56.D);
            this.m = new q07(this.c, w56.A0);
            this.n = new f07(this.c, w56.B0);
            this.u = new e07(this.c, w56.I0);
            this.v = new g07(this.c, w56.J0);
            this.o = new o07(this.c, w56.H0);
            this.p = new c07(this.c, w56.C0);
            this.q = new b07(this.c, w56.D0);
            this.r = new a07(this.c, w56.E0);
            this.t = new s07(this.c, x56.U);
            this.C = new xz6(this.c, r56.O0);
            this.s = new zz6(this.c, w56.F0);
            this.B = new m07(this.c, nu4.e);
            this.w = new h07(this.c, w56.K0);
            this.x = new n07(this.c, w56.L0);
            this.y = new i07(this.c, w56.M0);
            this.z = new t07(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new vz6(this.c, v56.O0);
            this.A = new uz6(this.c, x07.b);
            this.g = new tz6(this.c, v56.P0);
            this.h = new p07(this.c, w56.r0);
            this.D = new j07(this.c, w56.s0);
            this.E = new yz6(this.c, w56.t0);
            this.F = new k07(this.c, w56.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), y07.f);
            this.H = new u07(this.c, w56.x0, (byte) 4);
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
            kn<?, ?> g = zi8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            kn<?, ?> g2 = zi8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            kn<?, ?> g3 = zi8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            kn<?, ?> g4 = zi8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            kn<?, ?> g5 = zi8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            kn<?, ?> g6 = zi8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            kn<?, ?> g7 = zi8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public final void g(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof hr5) {
                ((hr5) knVar).g(str);
            }
        }
    }

    public void j(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || em7.e(this.J)) {
            return;
        }
        Iterator<kn> it = this.I.iterator();
        while (it.hasNext()) {
            kn next = it.next();
            if (next instanceof qi8) {
                ((qi8) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<l07> it = this.i.iterator();
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

    public final void i(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cdo) == null) {
            Iterator<l07> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(cdo);
            }
            this.j.C(cdo);
            this.k.C(cdo);
            this.l.x(cdo);
            this.m.x(cdo);
            this.n.y(cdo);
            this.u.x(cdo);
            this.v.x(cdo);
            this.o.x(cdo);
            this.B.v(cdo);
            this.w.u(cdo);
            this.x.v(cdo);
            this.y.u(cdo);
            this.z.x(cdo);
            this.p.x(cdo);
            this.q.x(cdo);
            this.r.x(cdo);
            this.t.A(cdo);
            this.s.y(cdo);
            this.C.y(cdo);
            this.E.x(cdo);
            this.D.y(cdo);
            this.F.y(cdo);
            this.H.u(cdo);
        }
    }
}
