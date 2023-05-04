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
public class tn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yn7 A;
    public qo7 B;
    public bo7 C;
    public no7 D;
    public co7 E;
    public oo7 F;
    public ConcernEmotionTipAdapter G;
    public yo7 H;
    public ArrayList<vm> I;
    public List<in> J;
    public List<vm> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public zn7 f;
    public xn7 g;
    public to7 h;
    public ArrayList<po7> i;
    public vo7 j;
    public vo7 k;
    public ho7 l;
    public uo7 m;
    public jo7 n;
    public so7 o;
    public go7 p;
    public fo7 q;
    public eo7 r;
    public do7 s;
    public wo7 t;
    public io7 u;
    public ko7 v;
    public lo7 w;
    public ro7 x;
    public mo7 y;
    public xo7 z;

    public tn7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (int i = 0; i < qi6.O.size(); i++) {
                for (int i2 = 0; i2 < qi6.P.size(); i2++) {
                    this.i.add(new po7(this.c, qi6.Q[i][i2], qi6.O.get(i), qi6.P.get(i2)));
                }
            }
            this.j = new vo7(this.c, ThreadData.TYPE_VIDEO, qi6.D);
            this.k = new vo7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, qi6.E);
            this.l = new ho7(this.c, ThreadData.TYPE_FAKE_VIDEO, qi6.D);
            this.m = new uo7(this.c, yi6.C0);
            this.n = new jo7(this.c, yi6.D0);
            this.u = new io7(this.c, yi6.K0);
            this.v = new ko7(this.c, yi6.L0);
            this.o = new so7(this.c, yi6.J0);
            this.p = new go7(this.c, yi6.E0);
            this.q = new fo7(this.c, yi6.F0);
            this.r = new eo7(this.c, yi6.G0);
            this.t = new wo7(this.c, zi6.U);
            this.C = new bo7(this.c, ti6.Q0);
            this.s = new do7(this.c, yi6.H0);
            this.B = new qo7(this.c, uz4.e);
            this.w = new lo7(this.c, yi6.M0);
            this.x = new ro7(this.c, yi6.N0);
            this.y = new mo7(this.c, yi6.O0);
            this.z = new xo7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.e = new ConcernEmotionTipAdapter(this.c);
            this.f = new zn7(this.c, xi6.Q0);
            this.A = new yn7(this.c, bp7.b);
            this.g = new xn7(this.c, xi6.R0);
            this.h = new to7(this.c, yi6.t0);
            this.D = new no7(this.c, yi6.u0);
            this.E = new co7(this.c, yi6.v0);
            this.F = new oo7(this.c, yi6.w0);
            this.G = new ConcernEmotionTipAdapter(this.c, cp7.f);
            this.H = new yo7(this.c, yi6.z0, (byte) 4);
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
            vm<?, ?> g = ae9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            vm<?, ?> g2 = ae9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            vm<?, ?> g3 = ae9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            vm<?, ?> g4 = ae9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            vm<?, ?> g5 = ae9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            vm<?, ?> g6 = ae9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            vm<?, ?> g7 = ae9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
            if (vmVar instanceof qz5) {
                ((qz5) vmVar).g(str);
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
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || ch8.e(this.J)) {
            return;
        }
        Iterator<vm> it = this.I.iterator();
        while (it.hasNext()) {
            vm next = it.next();
            if (next instanceof qd9) {
                ((qd9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<po7> it = this.i.iterator();
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
            Iterator<po7> it = this.i.iterator();
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
