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
public class xl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cm7 A;
    public um7 B;
    public fm7 C;
    public rm7 D;
    public gm7 E;
    public sm7 F;
    public ConcernEmotionTipAdapter G;
    public cn7 H;
    public ArrayList<um> I;
    public List<hn> J;
    public List<um> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public dm7 f;
    public bm7 g;
    public xm7 h;
    public ArrayList<tm7> i;
    public zm7 j;
    public zm7 k;
    public lm7 l;
    public ym7 m;
    public nm7 n;
    public wm7 o;
    public km7 p;
    public jm7 q;
    public im7 r;
    public hm7 s;
    public an7 t;
    public mm7 u;
    public om7 v;
    public pm7 w;
    public vm7 x;
    public qm7 y;
    public bn7 z;

    public xl7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<hn> a() {
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
            for (int i = 0; i < eh6.O.size(); i++) {
                for (int i2 = 0; i2 < eh6.P.size(); i2++) {
                    this.i.add(new tm7(this.c, eh6.Q[i][i2], eh6.O.get(i), eh6.P.get(i2)));
                }
            }
            this.j = new zm7(this.c, ThreadData.TYPE_VIDEO, eh6.D);
            this.k = new zm7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, eh6.E);
            this.l = new lm7(this.c, ThreadData.TYPE_FAKE_VIDEO, eh6.D);
            this.m = new ym7(this.c, mh6.C0);
            this.n = new nm7(this.c, mh6.D0);
            this.u = new mm7(this.c, mh6.K0);
            this.v = new om7(this.c, mh6.L0);
            this.o = new wm7(this.c, mh6.J0);
            this.p = new km7(this.c, mh6.E0);
            this.q = new jm7(this.c, mh6.F0);
            this.r = new im7(this.c, mh6.G0);
            this.t = new an7(this.c, nh6.U);
            this.C = new fm7(this.c, hh6.Q0);
            this.s = new hm7(this.c, mh6.H0);
            this.B = new um7(this.c, dz4.e);
            this.w = new pm7(this.c, mh6.M0);
            this.x = new vm7(this.c, mh6.N0);
            this.y = new qm7(this.c, mh6.O0);
            this.z = new bn7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new dm7(this.c, lh6.Q0);
            this.A = new cm7(this.c, fn7.b);
            this.g = new bm7(this.c, lh6.R0);
            this.h = new xm7(this.c, mh6.t0);
            this.D = new rm7(this.c, mh6.u0);
            this.E = new gm7(this.c, mh6.v0);
            this.F = new sm7(this.c, mh6.w0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), gn7.f);
            this.H = new cn7(this.c, mh6.z0, (byte) 4);
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
            um<?, ?> g = va9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            um<?, ?> g2 = va9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            um<?, ?> g3 = va9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            um<?, ?> g4 = va9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            um<?, ?> g5 = va9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            um<?, ?> g6 = va9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            um<?, ?> g7 = va9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (um umVar : list) {
            if (umVar instanceof py5) {
                ((py5) umVar).g(str);
            }
        }
    }

    public void j(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || me8.e(this.J)) {
            return;
        }
        Iterator<um> it = this.I.iterator();
        while (it.hasNext()) {
            um next = it.next();
            if (next instanceof ma9) {
                ((ma9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<tm7> it = this.i.iterator();
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

    public final void i(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nnVar) == null) {
            Iterator<tm7> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().J(nnVar);
            }
            this.j.E(nnVar);
            this.k.E(nnVar);
            this.l.z(nnVar);
            this.m.z(nnVar);
            this.n.A(nnVar);
            this.u.z(nnVar);
            this.v.z(nnVar);
            this.o.z(nnVar);
            this.B.x(nnVar);
            this.w.u(nnVar);
            this.x.x(nnVar);
            this.y.u(nnVar);
            this.z.z(nnVar);
            this.p.z(nnVar);
            this.q.z(nnVar);
            this.r.z(nnVar);
            this.t.C(nnVar);
            this.s.A(nnVar);
            this.C.A(nnVar);
            this.E.z(nnVar);
            this.D.A(nnVar);
            this.F.A(nnVar);
            this.H.u(nnVar);
        }
    }
}
