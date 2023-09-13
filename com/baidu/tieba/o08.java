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
public class o08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k18 A;
    public v08 B;
    public h18 C;
    public w08 D;
    public i18 E;
    public ConcernEmotionTipAdapter F;
    public s18 G;
    public ArrayList<pm> H;
    public List<cn> I;
    public List<pm> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public t08 f;
    public n18 g;
    public ArrayList<j18> h;
    public p18 i;
    public p18 j;
    public b18 k;
    public o18 l;
    public d18 m;
    public m18 n;
    public a18 o;
    public z08 p;
    public y08 q;
    public x08 r;
    public q18 s;
    public c18 t;
    public e18 u;
    public f18 v;
    public l18 w;
    public g18 x;
    public r18 y;
    public s08 z;

    public o08(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<cn> a() {
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
            for (int i = 0; i < up6.O.size(); i++) {
                for (int i2 = 0; i2 < up6.P.size(); i2++) {
                    this.h.add(new j18(this.c, up6.Q[i][i2], up6.O.get(i), up6.P.get(i2)));
                }
            }
            this.i = new p18(this.c, ThreadData.TYPE_VIDEO, up6.D);
            this.j = new p18(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, up6.E);
            this.k = new b18(this.c, ThreadData.TYPE_FAKE_VIDEO, up6.D);
            this.l = new o18(this.c, cq6.E0);
            this.m = new d18(this.c, cq6.F0);
            this.t = new c18(this.c, cq6.M0);
            this.u = new e18(this.c, cq6.N0);
            this.n = new m18(this.c, cq6.L0);
            this.o = new a18(this.c, cq6.G0);
            this.p = new z08(this.c, cq6.H0);
            this.q = new y08(this.c, cq6.I0);
            this.s = new q18(this.c, dq6.U);
            this.B = new v08(this.c, xp6.S0);
            this.r = new x08(this.c, cq6.J0);
            this.A = new k18(this.c, w35.e);
            this.v = new f18(this.c, cq6.O0);
            this.w = new l18(this.c, cq6.P0);
            this.x = new g18(this.c, cq6.Q0);
            this.y = new r18(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new t08(this.c, bq6.S0);
            this.z = new s08(this.c, y18.b);
            this.g = new n18(this.c, cq6.u0);
            this.C = new h18(this.c, cq6.v0);
            this.D = new w08(this.c, cq6.w0);
            this.E = new i18(this.c, cq6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, z18.f);
            this.G = new s18(this.c, cq6.z0, (byte) 4);
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
            pm<?, ?> h = i3a.m().h(this.c, AdvertAppInfo.z, "CONCERN");
            pm<?, ?> h2 = i3a.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            pm<?, ?> h3 = i3a.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            pm<?, ?> h4 = i3a.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            pm<?, ?> h5 = i3a.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            pm<?, ?> h6 = i3a.m().h(this.c, AdvertAppInfo.F, "CONCERN");
            pm<?, ?> h7 = i3a.m().h(this.c, AdvertAppInfo.E, "CONCERN");
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
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (pm pmVar : list) {
            if (pmVar instanceof o56) {
                ((o56) pmVar).g(str);
            }
        }
    }

    public void j(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || i39.e(this.I)) {
            return;
        }
        Iterator<pm> it = this.H.iterator();
        while (it.hasNext()) {
            pm next = it.next();
            if (next instanceof y2a) {
                ((y2a) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<j18> it = this.h.iterator();
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

    public final void i(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, inVar) == null) {
            Iterator<j18> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(inVar);
            }
            this.i.E(inVar);
            this.j.E(inVar);
            this.k.z(inVar);
            this.l.z(inVar);
            this.m.A(inVar);
            this.t.z(inVar);
            this.u.z(inVar);
            this.n.z(inVar);
            this.A.x(inVar);
            this.v.u(inVar);
            this.w.x(inVar);
            this.x.u(inVar);
            this.y.z(inVar);
            this.o.z(inVar);
            this.p.z(inVar);
            this.q.z(inVar);
            this.s.C(inVar);
            this.r.A(inVar);
            this.B.A(inVar);
            this.D.z(inVar);
            this.C.A(inVar);
            this.E.A(inVar);
            this.G.u(inVar);
        }
    }
}
