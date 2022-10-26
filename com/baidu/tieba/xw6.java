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
public class xw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cx6 A;
    public ux6 B;
    public fx6 C;
    public rx6 D;
    public gx6 E;
    public sx6 F;
    public ConcernEmotionTipAdapter G;
    public cy6 H;
    public ArrayList I;
    public List J;
    public List a;
    public BdTypeRecyclerView b;
    public TbPageContext c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public dx6 f;
    public bx6 g;
    public xx6 h;
    public ArrayList i;
    public zx6 j;
    public zx6 k;
    public lx6 l;
    public yx6 m;
    public nx6 n;
    public wx6 o;
    public kx6 p;
    public jx6 q;
    public ix6 r;
    public hx6 s;
    public ay6 t;
    public mx6 u;
    public ox6 v;
    public px6 w;
    public vx6 x;
    public qx6 y;
    public by6 z;

    public xw6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.i = new ArrayList();
        this.a = new ArrayList();
        this.b = bdTypeRecyclerView;
        this.c = (TbPageContext) w9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List a() {
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
            for (int i = 0; i < w26.O.size(); i++) {
                for (int i2 = 0; i2 < w26.P.size(); i2++) {
                    this.i.add(new tx6(this.c, w26.Q[i][i2], (BdUniqueId) w26.O.get(i), (BdUniqueId) w26.P.get(i2)));
                }
            }
            this.j = new zx6(this.c, ThreadData.TYPE_VIDEO, w26.D);
            this.k = new zx6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, w26.E);
            this.l = new lx6(this.c, ThreadData.TYPE_FAKE_VIDEO, w26.D);
            this.m = new yx6(this.c, e36.z0);
            this.n = new nx6(this.c, e36.A0);
            this.u = new mx6(this.c, e36.H0);
            this.v = new ox6(this.c, e36.I0);
            this.o = new wx6(this.c, e36.G0);
            this.p = new kx6(this.c, e36.B0);
            this.q = new jx6(this.c, e36.C0);
            this.r = new ix6(this.c, e36.D0);
            this.t = new ay6(this.c, f36.U);
            this.C = new fx6(this.c, z26.N0);
            this.s = new hx6(this.c, e36.E0);
            this.B = new ux6(this.c, ut4.e);
            this.w = new px6(this.c, e36.J0);
            this.x = new vx6(this.c, e36.K0);
            this.y = new qx6(this.c, e36.L0);
            this.z = new by6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new dx6(this.c, d36.N0);
            this.A = new cx6(this.c, ey6.b);
            this.g = new bx6(this.c, d36.O0);
            this.h = new xx6(this.c, e36.r0);
            this.D = new rx6(this.c, e36.s0);
            this.E = new gx6(this.c, e36.t0);
            this.F = new sx6(this.c, e36.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), fy6.f);
            this.H = new cy6(this.c, e36.x0, (byte) 4);
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
            this.I = new ArrayList();
            rn g = le8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            rn g2 = le8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            rn g3 = le8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            rn g4 = le8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            rn g5 = le8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            rn g6 = le8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            rn g7 = le8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (rn rnVar : list) {
            if (rnVar instanceof ap5) {
                ((ap5) rnVar).g(str);
            }
        }
    }

    public void j(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || lh7.e(this.J)) {
            return;
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            rn rnVar = (rn) it.next();
            if (rnVar instanceof ce8) {
                ((ce8) rnVar).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((tx6) it.next()).a = bdUniqueId;
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

    public final void i(ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, koVar) == null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((tx6) it.next()).H(koVar);
            }
            this.j.C(koVar);
            this.k.C(koVar);
            this.l.x(koVar);
            this.m.x(koVar);
            this.n.y(koVar);
            this.u.x(koVar);
            this.v.x(koVar);
            this.o.x(koVar);
            this.B.v(koVar);
            this.w.u(koVar);
            this.x.v(koVar);
            this.y.u(koVar);
            this.z.x(koVar);
            this.p.x(koVar);
            this.q.x(koVar);
            this.r.x(koVar);
            this.t.A(koVar);
            this.s.y(koVar);
            this.C.y(koVar);
            this.E.x(koVar);
            this.D.y(koVar);
            this.F.y(koVar);
            this.H.u(koVar);
        }
    }
}
