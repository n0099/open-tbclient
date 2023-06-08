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
public class vu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rv7 A;
    public cv7 B;
    public ov7 C;
    public dv7 D;
    public pv7 E;
    public ConcernEmotionTipAdapter F;
    public zv7 G;
    public ArrayList<in> H;
    public List<vn> I;
    public List<in> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public av7 f;
    public uv7 g;
    public ArrayList<qv7> h;
    public wv7 i;
    public wv7 j;
    public iv7 k;
    public vv7 l;
    public kv7 m;
    public tv7 n;
    public hv7 o;
    public gv7 p;
    public fv7 q;
    public ev7 r;
    public xv7 s;
    public jv7 t;
    public lv7 u;
    public mv7 v;
    public sv7 w;
    public nv7 x;
    public yv7 y;
    public zu7 z;

    public vu7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (int i = 0; i < oo6.O.size(); i++) {
                for (int i2 = 0; i2 < oo6.P.size(); i2++) {
                    this.h.add(new qv7(this.c, oo6.Q[i][i2], oo6.O.get(i), oo6.P.get(i2)));
                }
            }
            this.i = new wv7(this.c, ThreadData.TYPE_VIDEO, oo6.D);
            this.j = new wv7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, oo6.E);
            this.k = new iv7(this.c, ThreadData.TYPE_FAKE_VIDEO, oo6.D);
            this.l = new vv7(this.c, wo6.C0);
            this.m = new kv7(this.c, wo6.D0);
            this.t = new jv7(this.c, wo6.K0);
            this.u = new lv7(this.c, wo6.L0);
            this.n = new tv7(this.c, wo6.J0);
            this.o = new hv7(this.c, wo6.E0);
            this.p = new gv7(this.c, wo6.F0);
            this.q = new fv7(this.c, wo6.G0);
            this.s = new xv7(this.c, xo6.U);
            this.B = new cv7(this.c, ro6.Q0);
            this.r = new ev7(this.c, wo6.H0);
            this.A = new rv7(this.c, c45.e);
            this.v = new mv7(this.c, wo6.M0);
            this.w = new sv7(this.c, wo6.N0);
            this.x = new nv7(this.c, wo6.O0);
            this.y = new yv7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new av7(this.c, vo6.Q0);
            this.z = new zu7(this.c, cw7.b);
            this.g = new uv7(this.c, wo6.u0);
            this.C = new ov7(this.c, wo6.v0);
            this.D = new dv7(this.c, wo6.w0);
            this.E = new pv7(this.c, wo6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, dw7.f);
            this.G = new zv7(this.c, wo6.z0, (byte) 4);
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
            in<?, ?> g = jm9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            in<?, ?> g2 = jm9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            in<?, ?> g3 = jm9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            in<?, ?> g4 = jm9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            in<?, ?> g5 = jm9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            in<?, ?> g6 = jm9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            in<?, ?> g7 = jm9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
            if (inVar instanceof f56) {
                ((f56) inVar).g(str);
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
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || yo8.e(this.I)) {
            return;
        }
        Iterator<in> it = this.H.iterator();
        while (it.hasNext()) {
            in next = it.next();
            if (next instanceof zl9) {
                ((zl9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<qv7> it = this.h.iterator();
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
            Iterator<qv7> it = this.h.iterator();
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
