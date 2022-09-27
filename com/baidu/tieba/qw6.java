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
public class qw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vw6 A;
    public nx6 B;
    public yw6 C;
    public kx6 D;
    public zw6 E;
    public lx6 F;
    public ConcernEmotionTipAdapter G;
    public vx6 H;
    public ArrayList<qn> I;
    public List<Cdo> J;
    public List<qn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public ww6 f;
    public uw6 g;
    public qx6 h;
    public ArrayList<mx6> i;
    public sx6 j;
    public sx6 k;
    public ex6 l;
    public rx6 m;
    public gx6 n;
    public px6 o;
    public dx6 p;
    public cx6 q;
    public bx6 r;
    public ax6 s;
    public tx6 t;
    public fx6 u;
    public hx6 v;
    public ix6 w;
    public ox6 x;
    public jx6 y;
    public ux6 z;

    public qw6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) w9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < p26.O.size(); i++) {
                for (int i2 = 0; i2 < p26.P.size(); i2++) {
                    this.i.add(new mx6(this.c, p26.Q[i][i2], p26.O.get(i), p26.P.get(i2)));
                }
            }
            this.j = new sx6(this.c, ThreadData.TYPE_VIDEO, p26.D);
            this.k = new sx6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, p26.E);
            this.l = new ex6(this.c, ThreadData.TYPE_FAKE_VIDEO, p26.D);
            this.m = new rx6(this.c, x26.z0);
            this.n = new gx6(this.c, x26.A0);
            this.u = new fx6(this.c, x26.H0);
            this.v = new hx6(this.c, x26.I0);
            this.o = new px6(this.c, x26.G0);
            this.p = new dx6(this.c, x26.B0);
            this.q = new cx6(this.c, x26.C0);
            this.r = new bx6(this.c, x26.D0);
            this.t = new tx6(this.c, y26.U);
            this.C = new yw6(this.c, s26.N0);
            this.s = new ax6(this.c, x26.E0);
            this.B = new nx6(this.c, st4.e);
            this.w = new ix6(this.c, x26.J0);
            this.x = new ox6(this.c, x26.K0);
            this.y = new jx6(this.c, x26.L0);
            this.z = new ux6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new ww6(this.c, w26.N0);
            this.A = new vw6(this.c, xx6.b);
            this.g = new uw6(this.c, w26.O0);
            this.h = new qx6(this.c, x26.r0);
            this.D = new kx6(this.c, x26.s0);
            this.E = new zw6(this.c, x26.t0);
            this.F = new lx6(this.c, x26.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), yx6.f);
            this.H = new vx6(this.c, x26.x0, (byte) 4);
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
            qn<?, ?> g = be8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            qn<?, ?> g2 = be8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            qn<?, ?> g3 = be8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            qn<?, ?> g4 = be8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            qn<?, ?> g5 = be8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            qn<?, ?> g6 = be8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            qn<?, ?> g7 = be8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ah7.e(this.J)) {
            return;
        }
        Iterator<qn> it = this.I.iterator();
        while (it.hasNext()) {
            qn next = it.next();
            if (next instanceof sd8) {
                ((sd8) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof to5) {
                ((to5) qnVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<mx6> it = this.i.iterator();
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

    public final void i(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, joVar) == null) {
            Iterator<mx6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(joVar);
            }
            this.j.C(joVar);
            this.k.C(joVar);
            this.l.x(joVar);
            this.m.x(joVar);
            this.n.y(joVar);
            this.u.x(joVar);
            this.v.x(joVar);
            this.o.x(joVar);
            this.B.v(joVar);
            this.w.u(joVar);
            this.x.v(joVar);
            this.y.u(joVar);
            this.z.x(joVar);
            this.p.x(joVar);
            this.q.x(joVar);
            this.r.x(joVar);
            this.t.A(joVar);
            this.s.y(joVar);
            this.C.y(joVar);
            this.E.x(joVar);
            this.D.y(joVar);
            this.F.y(joVar);
            this.H.u(joVar);
        }
    }

    public void j(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }
}
