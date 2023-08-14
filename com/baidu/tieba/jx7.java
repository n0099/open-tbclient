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
public class jx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fy7 A;
    public qx7 B;
    public cy7 C;
    public rx7 D;
    public dy7 E;
    public ConcernEmotionTipAdapter F;
    public ny7 G;
    public ArrayList<lm> H;
    public List<ym> I;
    public List<lm> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public ox7 f;
    public iy7 g;
    public ArrayList<ey7> h;
    public ky7 i;
    public ky7 j;
    public wx7 k;
    public jy7 l;
    public yx7 m;
    public hy7 n;
    public vx7 o;
    public ux7 p;
    public tx7 q;
    public sx7 r;
    public ly7 s;
    public xx7 t;
    public zx7 u;
    public ay7 v;
    public gy7 w;
    public by7 x;
    public my7 y;
    public nx7 z;

    public jx7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) l9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<ym> a() {
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
            for (int i = 0; i < kn6.O.size(); i++) {
                for (int i2 = 0; i2 < kn6.P.size(); i2++) {
                    this.h.add(new ey7(this.c, kn6.Q[i][i2], kn6.O.get(i), kn6.P.get(i2)));
                }
            }
            this.i = new ky7(this.c, ThreadData.TYPE_VIDEO, kn6.D);
            this.j = new ky7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, kn6.E);
            this.k = new wx7(this.c, ThreadData.TYPE_FAKE_VIDEO, kn6.D);
            this.l = new jy7(this.c, sn6.E0);
            this.m = new yx7(this.c, sn6.F0);
            this.t = new xx7(this.c, sn6.M0);
            this.u = new zx7(this.c, sn6.N0);
            this.n = new hy7(this.c, sn6.L0);
            this.o = new vx7(this.c, sn6.G0);
            this.p = new ux7(this.c, sn6.H0);
            this.q = new tx7(this.c, sn6.I0);
            this.s = new ly7(this.c, tn6.U);
            this.B = new qx7(this.c, nn6.S0);
            this.r = new sx7(this.c, sn6.J0);
            this.A = new fy7(this.c, l35.e);
            this.v = new ay7(this.c, sn6.O0);
            this.w = new gy7(this.c, sn6.P0);
            this.x = new by7(this.c, sn6.Q0);
            this.y = new my7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new ox7(this.c, rn6.S0);
            this.z = new nx7(this.c, sy7.b);
            this.g = new iy7(this.c, sn6.u0);
            this.C = new cy7(this.c, sn6.v0);
            this.D = new rx7(this.c, sn6.w0);
            this.E = new dy7(this.c, sn6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, ty7.f);
            this.G = new ny7(this.c, sn6.z0, (byte) 4);
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
                AdvertAppInfo.w.set(false);
                return;
            }
            this.H = new ArrayList<>();
            lm<?, ?> h = mx9.m().h(this.c, AdvertAppInfo.z, "CONCERN");
            lm<?, ?> h2 = mx9.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            lm<?, ?> h3 = mx9.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            lm<?, ?> h4 = mx9.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            lm<?, ?> h5 = mx9.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            lm<?, ?> h6 = mx9.m().h(this.c, AdvertAppInfo.F, "CONCERN");
            lm<?, ?> h7 = mx9.m().h(this.c, AdvertAppInfo.E, "CONCERN");
            this.H.add(h);
            this.H.add(h2);
            this.H.add(h3);
            this.H.add(h4);
            this.H.add(h5);
            this.H.add(h6);
            this.H.add(h7);
            this.a.addAll(this.H);
            AdvertAppInfo.w.set(true);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public final void g(String str) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (lm lmVar : list) {
            if (lmVar instanceof b46) {
                ((b46) lmVar).g(str);
            }
        }
    }

    public void j(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || dy8.e(this.I)) {
            return;
        }
        Iterator<lm> it = this.H.iterator();
        while (it.hasNext()) {
            lm next = it.next();
            if (next instanceof cx9) {
                ((cx9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<ey7> it = this.h.iterator();
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

    public final void i(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, enVar) == null) {
            Iterator<ey7> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(enVar);
            }
            this.i.E(enVar);
            this.j.E(enVar);
            this.k.z(enVar);
            this.l.z(enVar);
            this.m.A(enVar);
            this.t.z(enVar);
            this.u.z(enVar);
            this.n.z(enVar);
            this.A.x(enVar);
            this.v.u(enVar);
            this.w.x(enVar);
            this.x.u(enVar);
            this.y.z(enVar);
            this.o.z(enVar);
            this.p.z(enVar);
            this.q.z(enVar);
            this.s.C(enVar);
            this.r.A(enVar);
            this.B.A(enVar);
            this.D.z(enVar);
            this.C.A(enVar);
            this.E.A(enVar);
            this.G.u(enVar);
        }
    }
}
