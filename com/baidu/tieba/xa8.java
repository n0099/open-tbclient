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
/* loaded from: classes9.dex */
public class xa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tb8 A;
    public eb8 B;
    public qb8 C;
    public fb8 D;
    public rb8 E;
    public ConcernEmotionTipAdapter F;
    public bc8 G;
    public ArrayList<ci> H;
    public List<pi> I;
    public List<ci> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public cb8 f;
    public wb8 g;
    public ArrayList<sb8> h;
    public yb8 i;
    public yb8 j;
    public kb8 k;
    public xb8 l;
    public mb8 m;
    public vb8 n;
    public jb8 o;
    public ib8 p;
    public hb8 q;
    public gb8 r;
    public zb8 s;
    public lb8 t;
    public nb8 u;
    public ob8 v;
    public ub8 w;
    public pb8 x;
    public ac8 y;
    public bb8 z;

    public xa8(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (int i = 0; i < um6.O.size(); i++) {
                for (int i2 = 0; i2 < um6.P.size(); i2++) {
                    this.h.add(new sb8(this.c, um6.Q[i][i2], um6.O.get(i), um6.P.get(i2)));
                }
            }
            this.i = new yb8(this.c, ThreadData.TYPE_VIDEO, um6.D);
            this.j = new yb8(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, um6.E);
            this.k = new kb8(this.c, ThreadData.TYPE_FAKE_VIDEO, um6.D);
            this.l = new xb8(this.c, dn6.E0);
            this.m = new mb8(this.c, dn6.F0);
            this.t = new lb8(this.c, dn6.M0);
            this.u = new nb8(this.c, dn6.N0);
            this.n = new vb8(this.c, dn6.L0);
            this.o = new jb8(this.c, dn6.G0);
            this.p = new ib8(this.c, dn6.H0);
            this.q = new hb8(this.c, dn6.I0);
            this.s = new zb8(this.c, en6.U);
            this.B = new eb8(this.c, xm6.S0);
            this.r = new gb8(this.c, dn6.J0);
            this.A = new tb8(this.c, bz4.e);
            this.v = new ob8(this.c, dn6.O0);
            this.w = new ub8(this.c, dn6.P0);
            this.x = new pb8(this.c, dn6.Q0);
            this.y = new ac8(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new cb8(this.c, cn6.S0);
            this.z = new bb8(this.c, hc8.b);
            this.g = new wb8(this.c, dn6.u0);
            this.C = new qb8(this.c, dn6.v0);
            this.D = new fb8(this.c, dn6.w0);
            this.E = new rb8(this.c, dn6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, ic8.f);
            this.G = new bc8(this.c, dn6.z0, (byte) 4);
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
            ci<?, ?> h = wha.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            ci<?, ?> h2 = wha.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            ci<?, ?> h3 = wha.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            ci<?, ?> h4 = wha.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            ci<?, ?> h5 = wha.m().h(this.c, AdvertAppInfo.E, "CONCERN");
            ci<?, ?> h6 = wha.m().h(this.c, AdvertAppInfo.G, "CONCERN");
            ci<?, ?> h7 = wha.m().h(this.c, AdvertAppInfo.F, "CONCERN");
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
            if (ciVar instanceof e26) {
                ((e26) ciVar).g(str);
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
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || eg9.e(this.I)) {
            return;
        }
        Iterator<ci> it = this.H.iterator();
        while (it.hasNext()) {
            ci next = it.next();
            if (next instanceof mha) {
                ((mha) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<sb8> it = this.h.iterator();
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
            Iterator<sb8> it = this.h.iterator();
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
