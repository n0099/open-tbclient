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
public class n37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s37 A;
    public k47 B;
    public v37 C;
    public h47 D;
    public w37 E;
    public i47 F;
    public ConcernEmotionTipAdapter G;
    public s47 H;
    public ArrayList<ln> I;
    public List<yn> J;
    public List<ln> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public t37 f;
    public r37 g;
    public n47 h;
    public ArrayList<j47> i;
    public p47 j;
    public p47 k;
    public b47 l;
    public o47 m;
    public d47 n;
    public m47 o;
    public a47 p;
    public z37 q;
    public y37 r;
    public x37 s;
    public q47 t;
    public c47 u;
    public e47 v;
    public f47 w;
    public l47 x;
    public g47 y;
    public r47 z;

    public n37(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) y9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<yn> a() {
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
            for (int i = 0; i < g96.O.size(); i++) {
                for (int i2 = 0; i2 < g96.P.size(); i2++) {
                    this.i.add(new j47(this.c, g96.Q[i][i2], g96.O.get(i), g96.P.get(i2)));
                }
            }
            this.j = new p47(this.c, ThreadData.TYPE_VIDEO, g96.D);
            this.k = new p47(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, g96.E);
            this.l = new b47(this.c, ThreadData.TYPE_FAKE_VIDEO, g96.D);
            this.m = new o47(this.c, o96.A0);
            this.n = new d47(this.c, o96.B0);
            this.u = new c47(this.c, o96.I0);
            this.v = new e47(this.c, o96.J0);
            this.o = new m47(this.c, o96.H0);
            this.p = new a47(this.c, o96.C0);
            this.q = new z37(this.c, o96.D0);
            this.r = new y37(this.c, o96.E0);
            this.t = new q47(this.c, p96.U);
            this.C = new v37(this.c, j96.O0);
            this.s = new x37(this.c, o96.F0);
            this.B = new k47(this.c, yu4.e);
            this.w = new f47(this.c, o96.K0);
            this.x = new l47(this.c, o96.L0);
            this.y = new g47(this.c, o96.M0);
            this.z = new r47(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new t37(this.c, n96.O0);
            this.A = new s37(this.c, v47.b);
            this.g = new r37(this.c, n96.P0);
            this.h = new n47(this.c, o96.r0);
            this.D = new h47(this.c, o96.s0);
            this.E = new w37(this.c, o96.t0);
            this.F = new i47(this.c, o96.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), w47.f);
            this.H = new s47(this.c, o96.x0, (byte) 4);
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
            ln<?, ?> g = rn8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            ln<?, ?> g2 = rn8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            ln<?, ?> g3 = rn8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            ln<?, ?> g4 = rn8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            ln<?, ?> g5 = rn8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            ln<?, ?> g6 = rn8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            ln<?, ?> g7 = rn8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof bs5) {
                ((bs5) lnVar).g(str);
            }
        }
    }

    public void j(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || uq7.e(this.J)) {
            return;
        }
        Iterator<ln> it = this.I.iterator();
        while (it.hasNext()) {
            ln next = it.next();
            if (next instanceof in8) {
                ((in8) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<j47> it = this.i.iterator();
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

    public final void i(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eoVar) == null) {
            Iterator<j47> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(eoVar);
            }
            this.j.C(eoVar);
            this.k.C(eoVar);
            this.l.x(eoVar);
            this.m.x(eoVar);
            this.n.y(eoVar);
            this.u.x(eoVar);
            this.v.x(eoVar);
            this.o.x(eoVar);
            this.B.v(eoVar);
            this.w.u(eoVar);
            this.x.v(eoVar);
            this.y.u(eoVar);
            this.z.x(eoVar);
            this.p.x(eoVar);
            this.q.x(eoVar);
            this.r.x(eoVar);
            this.t.A(eoVar);
            this.s.y(eoVar);
            this.C.y(eoVar);
            this.E.x(eoVar);
            this.D.y(eoVar);
            this.F.y(eoVar);
            this.H.u(eoVar);
        }
    }
}
