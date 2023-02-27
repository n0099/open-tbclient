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
public class ua7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public za7 A;
    public rb7 B;
    public cb7 C;
    public ob7 D;
    public db7 E;
    public pb7 F;
    public ConcernEmotionTipAdapter G;
    public zb7 H;
    public ArrayList<qn> I;
    public List<Cdo> J;
    public List<qn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public ab7 f;
    public ya7 g;
    public ub7 h;
    public ArrayList<qb7> i;
    public wb7 j;
    public wb7 k;
    public ib7 l;
    public vb7 m;
    public kb7 n;
    public tb7 o;
    public hb7 p;
    public gb7 q;
    public fb7 r;
    public eb7 s;
    public xb7 t;
    public jb7 u;
    public lb7 v;
    public mb7 w;
    public sb7 x;
    public nb7 y;
    public yb7 z;

    public ua7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) da.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<Cdo> a() {
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
            for (int i = 0; i < eg6.O.size(); i++) {
                for (int i2 = 0; i2 < eg6.P.size(); i2++) {
                    this.i.add(new qb7(this.c, eg6.Q[i][i2], eg6.O.get(i), eg6.P.get(i2)));
                }
            }
            this.j = new wb7(this.c, ThreadData.TYPE_VIDEO, eg6.D);
            this.k = new wb7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, eg6.E);
            this.l = new ib7(this.c, ThreadData.TYPE_FAKE_VIDEO, eg6.D);
            this.m = new vb7(this.c, mg6.B0);
            this.n = new kb7(this.c, mg6.C0);
            this.u = new jb7(this.c, mg6.J0);
            this.v = new lb7(this.c, mg6.K0);
            this.o = new tb7(this.c, mg6.I0);
            this.p = new hb7(this.c, mg6.D0);
            this.q = new gb7(this.c, mg6.E0);
            this.r = new fb7(this.c, mg6.F0);
            this.t = new xb7(this.c, ng6.U);
            this.C = new cb7(this.c, hg6.P0);
            this.s = new eb7(this.c, mg6.G0);
            this.B = new rb7(this.c, s05.e);
            this.w = new mb7(this.c, mg6.L0);
            this.x = new sb7(this.c, mg6.M0);
            this.y = new nb7(this.c, mg6.N0);
            this.z = new yb7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new ab7(this.c, lg6.P0);
            this.A = new za7(this.c, cc7.b);
            this.g = new ya7(this.c, lg6.Q0);
            this.h = new ub7(this.c, mg6.s0);
            this.D = new ob7(this.c, mg6.t0);
            this.E = new db7(this.c, mg6.u0);
            this.F = new pb7(this.c, mg6.v0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), dc7.f);
            this.H = new zb7(this.c, mg6.y0, (byte) 4);
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
            qn<?, ?> g = cw8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            qn<?, ?> g2 = cw8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            qn<?, ?> g3 = cw8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            qn<?, ?> g4 = cw8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            qn<?, ?> g5 = cw8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            qn<?, ?> g6 = cw8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            qn<?, ?> g7 = cw8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof dy5) {
                ((dy5) qnVar).g(str);
            }
        }
    }

    public void j(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || ry7.e(this.J)) {
            return;
        }
        Iterator<qn> it = this.I.iterator();
        while (it.hasNext()) {
            qn next = it.next();
            if (next instanceof tv8) {
                ((tv8) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<qb7> it = this.i.iterator();
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
            Iterator<qb7> it = this.i.iterator();
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
}
