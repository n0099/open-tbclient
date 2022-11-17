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
public class sy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xy6 A;
    public pz6 B;
    public az6 C;
    public mz6 D;
    public bz6 E;
    public nz6 F;
    public ConcernEmotionTipAdapter G;
    public xz6 H;
    public ArrayList<kn> I;
    public List<xn> J;
    public List<kn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public yy6 f;
    public wy6 g;
    public sz6 h;
    public ArrayList<oz6> i;
    public uz6 j;
    public uz6 k;
    public gz6 l;
    public tz6 m;
    public iz6 n;
    public rz6 o;
    public fz6 p;
    public ez6 q;
    public dz6 r;
    public cz6 s;
    public vz6 t;
    public hz6 u;
    public jz6 v;
    public kz6 w;
    public qz6 x;
    public lz6 y;
    public wz6 z;

    public sy6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (int i = 0; i < t46.O.size(); i++) {
                for (int i2 = 0; i2 < t46.P.size(); i2++) {
                    this.i.add(new oz6(this.c, t46.Q[i][i2], t46.O.get(i), t46.P.get(i2)));
                }
            }
            this.j = new uz6(this.c, ThreadData.TYPE_VIDEO, t46.D);
            this.k = new uz6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, t46.E);
            this.l = new gz6(this.c, ThreadData.TYPE_FAKE_VIDEO, t46.D);
            this.m = new tz6(this.c, b56.z0);
            this.n = new iz6(this.c, b56.A0);
            this.u = new hz6(this.c, b56.H0);
            this.v = new jz6(this.c, b56.I0);
            this.o = new rz6(this.c, b56.G0);
            this.p = new fz6(this.c, b56.B0);
            this.q = new ez6(this.c, b56.C0);
            this.r = new dz6(this.c, b56.D0);
            this.t = new vz6(this.c, c56.U);
            this.C = new az6(this.c, w46.N0);
            this.s = new cz6(this.c, b56.E0);
            this.B = new pz6(this.c, mu4.e);
            this.w = new kz6(this.c, b56.J0);
            this.x = new qz6(this.c, b56.K0);
            this.y = new lz6(this.c, b56.L0);
            this.z = new wz6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new yy6(this.c, a56.N0);
            this.A = new xy6(this.c, zz6.b);
            this.g = new wy6(this.c, a56.O0);
            this.h = new sz6(this.c, b56.r0);
            this.D = new mz6(this.c, b56.s0);
            this.E = new bz6(this.c, b56.t0);
            this.F = new nz6(this.c, b56.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), a07.f);
            this.H = new xz6(this.c, b56.x0, (byte) 4);
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
            kn<?, ?> g = hg8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            kn<?, ?> g2 = hg8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            kn<?, ?> g3 = hg8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            kn<?, ?> g4 = hg8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            kn<?, ?> g5 = hg8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            kn<?, ?> g6 = hg8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            kn<?, ?> g7 = hg8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
            if (knVar instanceof mq5) {
                ((mq5) knVar).g(str);
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
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || hj7.e(this.J)) {
            return;
        }
        Iterator<kn> it = this.I.iterator();
        while (it.hasNext()) {
            kn next = it.next();
            if (next instanceof yf8) {
                ((yf8) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<oz6> it = this.i.iterator();
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
            Iterator<oz6> it = this.i.iterator();
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
