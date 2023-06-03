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
public class tu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pv7 A;
    public av7 B;
    public mv7 C;
    public bv7 D;
    public nv7 E;
    public ConcernEmotionTipAdapter F;
    public xv7 G;
    public ArrayList<in> H;
    public List<vn> I;
    public List<in> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public yu7 f;
    public sv7 g;
    public ArrayList<ov7> h;
    public uv7 i;
    public uv7 j;
    public gv7 k;
    public tv7 l;
    public iv7 m;
    public rv7 n;
    public fv7 o;
    public ev7 p;
    public dv7 q;
    public cv7 r;
    public vv7 s;
    public hv7 t;
    public jv7 u;
    public kv7 v;
    public qv7 w;
    public lv7 x;
    public wv7 y;
    public xu7 z;

    public tu7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) q9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<vn> a() {
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
            for (int i = 0; i < mo6.O.size(); i++) {
                for (int i2 = 0; i2 < mo6.P.size(); i2++) {
                    this.h.add(new ov7(this.c, mo6.Q[i][i2], mo6.O.get(i), mo6.P.get(i2)));
                }
            }
            this.i = new uv7(this.c, ThreadData.TYPE_VIDEO, mo6.D);
            this.j = new uv7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, mo6.E);
            this.k = new gv7(this.c, ThreadData.TYPE_FAKE_VIDEO, mo6.D);
            this.l = new tv7(this.c, uo6.C0);
            this.m = new iv7(this.c, uo6.D0);
            this.t = new hv7(this.c, uo6.K0);
            this.u = new jv7(this.c, uo6.L0);
            this.n = new rv7(this.c, uo6.J0);
            this.o = new fv7(this.c, uo6.E0);
            this.p = new ev7(this.c, uo6.F0);
            this.q = new dv7(this.c, uo6.G0);
            this.s = new vv7(this.c, vo6.U);
            this.B = new av7(this.c, po6.Q0);
            this.r = new cv7(this.c, uo6.H0);
            this.A = new pv7(this.c, a45.e);
            this.v = new kv7(this.c, uo6.M0);
            this.w = new qv7(this.c, uo6.N0);
            this.x = new lv7(this.c, uo6.O0);
            this.y = new wv7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new yu7(this.c, to6.Q0);
            this.z = new xu7(this.c, aw7.b);
            this.g = new sv7(this.c, uo6.u0);
            this.C = new mv7(this.c, uo6.v0);
            this.D = new bv7(this.c, uo6.w0);
            this.E = new nv7(this.c, uo6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, bw7.f);
            this.G = new xv7(this.c, uo6.z0, (byte) 4);
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
                AdvertAppInfo.v.set(false);
                return;
            }
            this.H = new ArrayList<>();
            in<?, ?> g = em9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            in<?, ?> g2 = em9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            in<?, ?> g3 = em9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            in<?, ?> g4 = em9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            in<?, ?> g5 = em9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            in<?, ?> g6 = em9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            in<?, ?> g7 = em9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
            this.H.add(g);
            this.H.add(g2);
            this.H.add(g3);
            this.H.add(g4);
            this.H.add(g5);
            this.H.add(g6);
            this.H.add(g7);
            this.a.addAll(this.H);
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
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof d56) {
                ((d56) inVar).g(str);
            }
        }
    }

    public void j(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || vo8.e(this.I)) {
            return;
        }
        Iterator<in> it = this.H.iterator();
        while (it.hasNext()) {
            in next = it.next();
            if (next instanceof ul9) {
                ((ul9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<ov7> it = this.h.iterator();
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

    public final void i(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, boVar) == null) {
            Iterator<ov7> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(boVar);
            }
            this.i.E(boVar);
            this.j.E(boVar);
            this.k.z(boVar);
            this.l.z(boVar);
            this.m.A(boVar);
            this.t.z(boVar);
            this.u.z(boVar);
            this.n.z(boVar);
            this.A.x(boVar);
            this.v.u(boVar);
            this.w.x(boVar);
            this.x.u(boVar);
            this.y.z(boVar);
            this.o.z(boVar);
            this.p.z(boVar);
            this.q.z(boVar);
            this.s.C(boVar);
            this.r.A(boVar);
            this.B.A(boVar);
            this.D.z(boVar);
            this.C.A(boVar);
            this.E.A(boVar);
            this.G.u(boVar);
        }
    }
}
