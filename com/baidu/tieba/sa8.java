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
public class sa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ob8 A;
    public za8 B;
    public lb8 C;
    public ab8 D;
    public mb8 E;
    public ConcernEmotionTipAdapter F;
    public wb8 G;
    public ArrayList<ci> H;
    public List<pi> I;
    public List<ci> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public xa8 f;
    public rb8 g;
    public ArrayList<nb8> h;
    public tb8 i;
    public tb8 j;
    public fb8 k;
    public sb8 l;
    public hb8 m;
    public qb8 n;
    public eb8 o;
    public db8 p;
    public cb8 q;
    public bb8 r;
    public ub8 s;
    public gb8 t;
    public ib8 u;
    public jb8 v;
    public pb8 w;
    public kb8 x;
    public vb8 y;
    public wa8 z;

    public sa8(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) a5.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<pi> a() {
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
            for (int i = 0; i < qm6.O.size(); i++) {
                for (int i2 = 0; i2 < qm6.P.size(); i2++) {
                    this.h.add(new nb8(this.c, qm6.Q[i][i2], qm6.O.get(i), qm6.P.get(i2)));
                }
            }
            this.i = new tb8(this.c, ThreadData.TYPE_VIDEO, qm6.D);
            this.j = new tb8(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, qm6.E);
            this.k = new fb8(this.c, ThreadData.TYPE_FAKE_VIDEO, qm6.D);
            this.l = new sb8(this.c, zm6.E0);
            this.m = new hb8(this.c, zm6.F0);
            this.t = new gb8(this.c, zm6.M0);
            this.u = new ib8(this.c, zm6.N0);
            this.n = new qb8(this.c, zm6.L0);
            this.o = new eb8(this.c, zm6.G0);
            this.p = new db8(this.c, zm6.H0);
            this.q = new cb8(this.c, zm6.I0);
            this.s = new ub8(this.c, an6.U);
            this.B = new za8(this.c, tm6.S0);
            this.r = new bb8(this.c, zm6.J0);
            this.A = new ob8(this.c, yy4.e);
            this.v = new jb8(this.c, zm6.O0);
            this.w = new pb8(this.c, zm6.P0);
            this.x = new kb8(this.c, zm6.Q0);
            this.y = new vb8(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new xa8(this.c, ym6.S0);
            this.z = new wa8(this.c, cc8.b);
            this.g = new rb8(this.c, zm6.u0);
            this.C = new lb8(this.c, zm6.v0);
            this.D = new ab8(this.c, zm6.w0);
            this.E = new mb8(this.c, zm6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, dc8.f);
            this.G = new wb8(this.c, zm6.z0, (byte) 4);
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
                AdvertAppInfo.x.set(false);
                return;
            }
            this.H = new ArrayList<>();
            ci<?, ?> h = rha.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            ci<?, ?> h2 = rha.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            ci<?, ?> h3 = rha.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            ci<?, ?> h4 = rha.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            ci<?, ?> h5 = rha.m().h(this.c, AdvertAppInfo.E, "CONCERN");
            ci<?, ?> h6 = rha.m().h(this.c, AdvertAppInfo.G, "CONCERN");
            ci<?, ?> h7 = rha.m().h(this.c, AdvertAppInfo.F, "CONCERN");
            this.H.add(h);
            this.H.add(h2);
            this.H.add(h3);
            this.H.add(h4);
            this.H.add(h5);
            this.H.add(h6);
            this.H.add(h7);
            this.a.addAll(this.H);
            AdvertAppInfo.x.set(true);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public final void g(String str) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof a26) {
                ((a26) ciVar).g(str);
            }
        }
    }

    public void j(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || zf9.e(this.I)) {
            return;
        }
        Iterator<ci> it = this.H.iterator();
        while (it.hasNext()) {
            ci next = it.next();
            if (next instanceof hha) {
                ((hha) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<nb8> it = this.h.iterator();
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
            this.z.x(bdUniqueId);
        }
    }

    public final void i(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viVar) == null) {
            Iterator<nb8> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().K(viVar);
            }
            this.i.F(viVar);
            this.j.F(viVar);
            this.k.A(viVar);
            this.l.A(viVar);
            this.m.B(viVar);
            this.t.A(viVar);
            this.u.A(viVar);
            this.n.A(viVar);
            this.A.y(viVar);
            this.v.x(viVar);
            this.w.y(viVar);
            this.x.x(viVar);
            this.y.A(viVar);
            this.o.A(viVar);
            this.p.A(viVar);
            this.q.A(viVar);
            this.s.D(viVar);
            this.r.B(viVar);
            this.B.B(viVar);
            this.D.A(viVar);
            this.C.B(viVar);
            this.E.B(viVar);
            this.G.x(viVar);
        }
    }
}
