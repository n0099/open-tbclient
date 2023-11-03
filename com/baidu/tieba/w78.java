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
public class w78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s88 A;
    public d88 B;
    public p88 C;
    public e88 D;
    public q88 E;
    public ConcernEmotionTipAdapter F;
    public a98 G;
    public ArrayList<bi> H;
    public List<oi> I;
    public List<bi> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public b88 f;
    public v88 g;
    public ArrayList<r88> h;
    public x88 i;
    public x88 j;
    public j88 k;
    public w88 l;
    public l88 m;
    public u88 n;
    public i88 o;
    public h88 p;
    public g88 q;
    public f88 r;
    public y88 s;
    public k88 t;
    public m88 u;
    public n88 v;
    public t88 w;
    public o88 x;
    public z88 y;
    public a88 z;

    public w78(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<oi> a() {
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
            for (int i = 0; i < fm6.O.size(); i++) {
                for (int i2 = 0; i2 < fm6.P.size(); i2++) {
                    this.h.add(new r88(this.c, fm6.Q[i][i2], fm6.O.get(i), fm6.P.get(i2)));
                }
            }
            this.i = new x88(this.c, ThreadData.TYPE_VIDEO, fm6.D);
            this.j = new x88(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, fm6.E);
            this.k = new j88(this.c, ThreadData.TYPE_FAKE_VIDEO, fm6.D);
            this.l = new w88(this.c, nm6.E0);
            this.m = new l88(this.c, nm6.F0);
            this.t = new k88(this.c, nm6.M0);
            this.u = new m88(this.c, nm6.N0);
            this.n = new u88(this.c, nm6.L0);
            this.o = new i88(this.c, nm6.G0);
            this.p = new h88(this.c, nm6.H0);
            this.q = new g88(this.c, nm6.I0);
            this.s = new y88(this.c, om6.U);
            this.B = new d88(this.c, im6.S0);
            this.r = new f88(this.c, nm6.J0);
            this.A = new s88(this.c, wy4.e);
            this.v = new n88(this.c, nm6.O0);
            this.w = new t88(this.c, nm6.P0);
            this.x = new o88(this.c, nm6.Q0);
            this.y = new z88(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new b88(this.c, mm6.S0);
            this.z = new a88(this.c, g98.b);
            this.g = new v88(this.c, nm6.u0);
            this.C = new p88(this.c, nm6.v0);
            this.D = new e88(this.c, nm6.w0);
            this.E = new q88(this.c, nm6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, h98.f);
            this.G = new a98(this.c, nm6.z0, (byte) 4);
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
            bi<?, ?> h = yca.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            bi<?, ?> h2 = yca.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            bi<?, ?> h3 = yca.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            bi<?, ?> h4 = yca.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            bi<?, ?> h5 = yca.m().h(this.c, AdvertAppInfo.E, "CONCERN");
            bi<?, ?> h6 = yca.m().h(this.c, AdvertAppInfo.G, "CONCERN");
            bi<?, ?> h7 = yca.m().h(this.c, AdvertAppInfo.F, "CONCERN");
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
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof s16) {
                ((s16) biVar).g(str);
            }
        }
    }

    public void j(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || ic9.e(this.I)) {
            return;
        }
        Iterator<bi> it = this.H.iterator();
        while (it.hasNext()) {
            bi next = it.next();
            if (next instanceof oca) {
                ((oca) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r88> it = this.h.iterator();
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

    public final void i(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uiVar) == null) {
            Iterator<r88> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().K(uiVar);
            }
            this.i.F(uiVar);
            this.j.F(uiVar);
            this.k.A(uiVar);
            this.l.A(uiVar);
            this.m.B(uiVar);
            this.t.A(uiVar);
            this.u.A(uiVar);
            this.n.A(uiVar);
            this.A.y(uiVar);
            this.v.x(uiVar);
            this.w.y(uiVar);
            this.x.x(uiVar);
            this.y.A(uiVar);
            this.o.A(uiVar);
            this.p.A(uiVar);
            this.q.A(uiVar);
            this.s.D(uiVar);
            this.r.B(uiVar);
            this.B.B(uiVar);
            this.D.A(uiVar);
            this.C.B(uiVar);
            this.E.B(uiVar);
            this.G.x(uiVar);
        }
    }
}
