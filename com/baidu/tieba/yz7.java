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
/* loaded from: classes8.dex */
public class yz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u08 A;
    public f08 B;
    public r08 C;
    public g08 D;
    public s08 E;
    public ConcernEmotionTipAdapter F;
    public c18 G;
    public ArrayList<ln> H;
    public List<yn> I;
    public List<ln> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public d08 f;
    public x08 g;
    public ArrayList<t08> h;
    public z08 i;
    public z08 j;
    public l08 k;
    public y08 l;
    public n08 m;
    public w08 n;
    public k08 o;
    public j08 p;
    public i08 q;
    public h08 r;
    public a18 s;
    public m08 t;
    public o08 u;
    public p08 v;
    public v08 w;
    public q08 x;
    public b18 y;
    public c08 z;

    public yz7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) r9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<yn> a() {
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
            for (int i = 0; i < cq6.O.size(); i++) {
                for (int i2 = 0; i2 < cq6.P.size(); i2++) {
                    this.h.add(new t08(this.c, cq6.Q[i][i2], cq6.O.get(i), cq6.P.get(i2)));
                }
            }
            this.i = new z08(this.c, ThreadData.TYPE_VIDEO, cq6.D);
            this.j = new z08(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, cq6.E);
            this.k = new l08(this.c, ThreadData.TYPE_FAKE_VIDEO, cq6.D);
            this.l = new y08(this.c, kq6.E0);
            this.m = new n08(this.c, kq6.F0);
            this.t = new m08(this.c, kq6.M0);
            this.u = new o08(this.c, kq6.N0);
            this.n = new w08(this.c, kq6.L0);
            this.o = new k08(this.c, kq6.G0);
            this.p = new j08(this.c, kq6.H0);
            this.q = new i08(this.c, kq6.I0);
            this.s = new a18(this.c, lq6.U);
            this.B = new f08(this.c, fq6.S0);
            this.r = new h08(this.c, kq6.J0);
            this.A = new u08(this.c, o45.e);
            this.v = new p08(this.c, kq6.O0);
            this.w = new v08(this.c, kq6.P0);
            this.x = new q08(this.c, kq6.Q0);
            this.y = new b18(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new d08(this.c, jq6.S0);
            this.z = new c08(this.c, h18.b);
            this.g = new x08(this.c, kq6.u0);
            this.C = new r08(this.c, kq6.v0);
            this.D = new g08(this.c, kq6.w0);
            this.E = new s08(this.c, kq6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, i18.f);
            this.G = new c18(this.c, kq6.z0, (byte) 4);
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
            ln<?, ?> h = uy9.m().h(this.c, AdvertAppInfo.z, "CONCERN");
            ln<?, ?> h2 = uy9.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            ln<?, ?> h3 = uy9.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            ln<?, ?> h4 = uy9.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            ln<?, ?> h5 = uy9.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            ln<?, ?> h6 = uy9.m().h(this.c, AdvertAppInfo.F, "CONCERN");
            ln<?, ?> h7 = uy9.m().h(this.c, AdvertAppInfo.E, "CONCERN");
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
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof t66) {
                ((t66) lnVar).g(str);
            }
        }
    }

    public void j(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || g09.e(this.I)) {
            return;
        }
        Iterator<ln> it = this.H.iterator();
        while (it.hasNext()) {
            ln next = it.next();
            if (next instanceof ky9) {
                ((ky9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<t08> it = this.h.iterator();
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

    public final void i(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eoVar) == null) {
            Iterator<t08> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(eoVar);
            }
            this.i.E(eoVar);
            this.j.E(eoVar);
            this.k.z(eoVar);
            this.l.z(eoVar);
            this.m.A(eoVar);
            this.t.z(eoVar);
            this.u.z(eoVar);
            this.n.z(eoVar);
            this.A.x(eoVar);
            this.v.u(eoVar);
            this.w.x(eoVar);
            this.x.u(eoVar);
            this.y.z(eoVar);
            this.o.z(eoVar);
            this.p.z(eoVar);
            this.q.z(eoVar);
            this.s.C(eoVar);
            this.r.A(eoVar);
            this.B.A(eoVar);
            this.D.z(eoVar);
            this.C.A(eoVar);
            this.E.A(eoVar);
            this.G.u(eoVar);
        }
    }
}
