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
/* loaded from: classes6.dex */
public class iv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ew7 A;
    public pv7 B;
    public bw7 C;
    public qv7 D;
    public cw7 E;
    public ConcernEmotionTipAdapter F;
    public mw7 G;
    public ArrayList<kn> H;
    public List<xn> I;
    public List<kn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public nv7 f;
    public hw7 g;
    public ArrayList<dw7> h;
    public jw7 i;
    public jw7 j;
    public vv7 k;
    public iw7 l;
    public xv7 m;
    public gw7 n;
    public uv7 o;
    public tv7 p;
    public sv7 q;
    public rv7 r;
    public kw7 s;
    public wv7 t;
    public yv7 u;
    public zv7 v;
    public fw7 w;
    public aw7 x;
    public lw7 y;
    public mv7 z;

    public iv7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<xn> a() {
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
            for (int i = 0; i < yo6.O.size(); i++) {
                for (int i2 = 0; i2 < yo6.P.size(); i2++) {
                    this.h.add(new dw7(this.c, yo6.Q[i][i2], yo6.O.get(i), yo6.P.get(i2)));
                }
            }
            this.i = new jw7(this.c, ThreadData.TYPE_VIDEO, yo6.D);
            this.j = new jw7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, yo6.E);
            this.k = new vv7(this.c, ThreadData.TYPE_FAKE_VIDEO, yo6.D);
            this.l = new iw7(this.c, gp6.D0);
            this.m = new xv7(this.c, gp6.E0);
            this.t = new wv7(this.c, gp6.L0);
            this.u = new yv7(this.c, gp6.M0);
            this.n = new gw7(this.c, gp6.K0);
            this.o = new uv7(this.c, gp6.F0);
            this.p = new tv7(this.c, gp6.G0);
            this.q = new sv7(this.c, gp6.H0);
            this.s = new kw7(this.c, hp6.U);
            this.B = new pv7(this.c, bp6.R0);
            this.r = new rv7(this.c, gp6.I0);
            this.A = new ew7(this.c, g45.e);
            this.v = new zv7(this.c, gp6.N0);
            this.w = new fw7(this.c, gp6.O0);
            this.x = new aw7(this.c, gp6.P0);
            this.y = new lw7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new nv7(this.c, fp6.R0);
            this.z = new mv7(this.c, qw7.b);
            this.g = new hw7(this.c, gp6.u0);
            this.C = new bw7(this.c, gp6.v0);
            this.D = new qv7(this.c, gp6.w0);
            this.E = new cw7(this.c, gp6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, rw7.f);
            this.G = new mw7(this.c, gp6.z0, (byte) 4);
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
            kn<?, ?> g = ns9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            kn<?, ?> g2 = ns9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            kn<?, ?> g3 = ns9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            kn<?, ?> g4 = ns9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            kn<?, ?> g5 = ns9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            kn<?, ?> g6 = ns9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            kn<?, ?> g7 = ns9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof p56) {
                ((p56) knVar).g(str);
            }
        }
    }

    public void j(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || du8.e(this.I)) {
            return;
        }
        Iterator<kn> it = this.H.iterator();
        while (it.hasNext()) {
            kn next = it.next();
            if (next instanceof ds9) {
                ((ds9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<dw7> it = this.h.iterator();
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

    public final void i(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cdo) == null) {
            Iterator<dw7> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(cdo);
            }
            this.i.E(cdo);
            this.j.E(cdo);
            this.k.z(cdo);
            this.l.z(cdo);
            this.m.A(cdo);
            this.t.z(cdo);
            this.u.z(cdo);
            this.n.z(cdo);
            this.A.x(cdo);
            this.v.u(cdo);
            this.w.x(cdo);
            this.x.u(cdo);
            this.y.z(cdo);
            this.o.z(cdo);
            this.p.z(cdo);
            this.q.z(cdo);
            this.s.C(cdo);
            this.r.A(cdo);
            this.B.A(cdo);
            this.D.z(cdo);
            this.C.A(cdo);
            this.E.A(cdo);
            this.G.u(cdo);
        }
    }
}
