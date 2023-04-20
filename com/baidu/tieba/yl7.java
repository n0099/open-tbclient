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
public class yl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dm7 A;
    public vm7 B;
    public gm7 C;
    public sm7 D;
    public hm7 E;
    public tm7 F;
    public ConcernEmotionTipAdapter G;
    public dn7 H;
    public ArrayList<vm> I;
    public List<in> J;
    public List<vm> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public em7 f;
    public cm7 g;
    public ym7 h;
    public ArrayList<um7> i;
    public an7 j;
    public an7 k;
    public mm7 l;
    public zm7 m;
    public om7 n;
    public xm7 o;
    public lm7 p;
    public km7 q;
    public jm7 r;
    public im7 s;
    public bn7 t;
    public nm7 u;
    public pm7 v;
    public qm7 w;
    public wm7 x;
    public rm7 y;
    public cn7 z;

    public yl7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) g9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<in> a() {
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
            for (int i = 0; i < fh6.O.size(); i++) {
                for (int i2 = 0; i2 < fh6.P.size(); i2++) {
                    this.i.add(new um7(this.c, fh6.Q[i][i2], fh6.O.get(i), fh6.P.get(i2)));
                }
            }
            this.j = new an7(this.c, ThreadData.TYPE_VIDEO, fh6.D);
            this.k = new an7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, fh6.E);
            this.l = new mm7(this.c, ThreadData.TYPE_FAKE_VIDEO, fh6.D);
            this.m = new zm7(this.c, nh6.C0);
            this.n = new om7(this.c, nh6.D0);
            this.u = new nm7(this.c, nh6.K0);
            this.v = new pm7(this.c, nh6.L0);
            this.o = new xm7(this.c, nh6.J0);
            this.p = new lm7(this.c, nh6.E0);
            this.q = new km7(this.c, nh6.F0);
            this.r = new jm7(this.c, nh6.G0);
            this.t = new bn7(this.c, oh6.U);
            this.C = new gm7(this.c, ih6.Q0);
            this.s = new im7(this.c, nh6.H0);
            this.B = new vm7(this.c, ez4.e);
            this.w = new qm7(this.c, nh6.M0);
            this.x = new wm7(this.c, nh6.N0);
            this.y = new rm7(this.c, nh6.O0);
            this.z = new cn7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new em7(this.c, mh6.Q0);
            this.A = new dm7(this.c, gn7.b);
            this.g = new cm7(this.c, mh6.R0);
            this.h = new ym7(this.c, nh6.t0);
            this.D = new sm7(this.c, nh6.u0);
            this.E = new hm7(this.c, nh6.v0);
            this.F = new tm7(this.c, nh6.w0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), hn7.f);
            this.H = new dn7(this.c, nh6.z0, (byte) 4);
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
            vm<?, ?> g = db9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            vm<?, ?> g2 = db9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            vm<?, ?> g3 = db9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            vm<?, ?> g4 = db9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            vm<?, ?> g5 = db9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            vm<?, ?> g6 = db9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            vm<?, ?> g7 = db9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof qy5) {
                ((qy5) vmVar).g(str);
            }
        }
    }

    public void j(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || ue8.e(this.J)) {
            return;
        }
        Iterator<vm> it = this.I.iterator();
        while (it.hasNext()) {
            vm next = it.next();
            if (next instanceof ua9) {
                ((ua9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<um7> it = this.i.iterator();
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

    public final void i(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onVar) == null) {
            Iterator<um7> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().J(onVar);
            }
            this.j.E(onVar);
            this.k.E(onVar);
            this.l.z(onVar);
            this.m.z(onVar);
            this.n.A(onVar);
            this.u.z(onVar);
            this.v.z(onVar);
            this.o.z(onVar);
            this.B.x(onVar);
            this.w.u(onVar);
            this.x.x(onVar);
            this.y.u(onVar);
            this.z.z(onVar);
            this.p.z(onVar);
            this.q.z(onVar);
            this.r.z(onVar);
            this.t.C(onVar);
            this.s.A(onVar);
            this.C.A(onVar);
            this.E.z(onVar);
            this.D.A(onVar);
            this.F.A(onVar);
            this.H.u(onVar);
        }
    }
}
