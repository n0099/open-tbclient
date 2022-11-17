package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class l47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d47 A;
    public f47 B;
    public c47 C;
    public v37 D;
    public y37 E;
    public z37 F;
    public b47 G;
    public k37 H;
    public i47 I;
    public xz6 J;
    public i37 K;
    public kn L;
    public kn M;
    public kn N;
    public kn O;
    public kn P;
    public kn Q;
    public kn R;
    public List<kn> S;
    public boolean T;
    public boolean U;
    public f V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<kn> a;
    public Cdo b;
    public List<xn> c;
    public TbPageContext<?> d;
    public h37 e;
    public j47 f;
    public j37 g;
    public v37 h;
    public g47 i;
    public p37 j;
    public q37 k;
    public r37 l;
    public a47 m;
    public s37 n;
    public x37 o;
    public u37 p;
    public w37 q;
    public o37 r;
    public n37 s;
    public m37 t;
    public h47 u;
    public l37 v;
    public t37 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public e47 z;

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l47 b;

        public a(l47 l47Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l47Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l47Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setData(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l47 l47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l47Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    l47 l47Var = this.a;
                    l47Var.y(l47Var.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l47 l47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l47Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l47 l47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l47Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                wj7 wj7Var = new wj7();
                wj7Var.a = String.valueOf(customResponsedMessage.getData());
                wj7Var.b = true;
                this.a.g(wj7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l47 l47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l47Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                wj7 wj7Var = new wj7();
                wj7Var.a = String.valueOf(customResponsedMessage.getData());
                wj7Var.b = false;
                this.a.g(wj7Var);
            }
        }
    }

    public l47(Context context, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cdo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.W = new b(this, 2016470);
        this.X = new c(this, 2001115);
        this.Y = new d(this, 2001335);
        this.Z = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = cdo;
        this.d = (TbPageContext) x9.a(context);
        j(context);
        x(cdo);
        cdo.a(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof mq5) {
                ((mq5) knVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof ny6) {
                    ((ny6) knVar).s(aVar);
                }
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.V = fVar;
        }
    }

    public void y(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            lo8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.V;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.U = f();
        }
    }

    public List<xn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void l() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (cdo = this.b) != null) {
            cdo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        h47 h47Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (h47Var = this.u) != null) {
            h47Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h47 h47Var = this.u;
            if (h47Var != null) {
                h47Var.onResume();
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition()) {
                l();
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<kn> list = this.S;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.S = new ArrayList();
            ArrayList<BdUniqueId> g = lo8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                zi7 b2 = ek7.d().b(this.d, g.get(i), 2);
                if (this.T) {
                    b2.s(3);
                }
                v37 v37Var = this.h;
                if (v37Var != null && (bdUniqueId = v37Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.S.add(b2);
            }
            this.b.a(this.S);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<xn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (xn xnVar : list) {
                if ((xnVar instanceof ICardInfo) && ((ICardInfo) xnVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                l();
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            v37 v37Var = this.h;
            if (v37Var != null) {
                v37Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            r37 r37Var = this.l;
            if (r37Var != null) {
                r37Var.setFromCDN(z);
            }
            l37 l37Var = this.v;
            if (l37Var != null) {
                l37Var.setFromCDN(z);
            }
            kn knVar = this.M;
            if (knVar != null && (knVar instanceof dg8)) {
                ((dg8) knVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new h37(this.d);
            this.f = new j47(this.d);
            this.g = new j37(this.d, t47.b);
            this.h = new v37(this.d, b56.i0);
            this.i = new g47(this.d, b56.z0);
            this.j = new p37(this.d, b56.H0);
            this.k = new q37(this.d, b56.A0);
            this.l = new r37(this.d, b56.I0);
            this.m = new a47(this.d, b56.G0);
            this.n = new s37(this.d, b56.J0);
            this.o = new x37(this.d, b56.K0);
            this.p = new u37(this.d, b56.L0);
            this.q = new w37(this.d, b56.M0);
            this.r = new o37(this.d, b56.B0);
            this.s = new n37(this.d, b56.C0);
            this.t = new m37(this.d, b56.D0);
            this.u = new h47(this.d, c56.U);
            this.w = new t37(this.d, b56.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, a56.N0);
            this.I = new i47(this.d, b56.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, a56.O0);
            this.z = new e47(this.d, b56.r0);
            this.A = new d47(this.d, b56.s0);
            this.B = new f47(this.d, b56.u0);
            this.C = new c47(this.d, b56.t0);
            this.D = new v37(this.d, b56.j0);
            this.E = new y37(this.d, b56.v0);
            this.F = new z37(this.d, b56.w0);
            this.G = new b47(this.d, t77.d0);
            this.H = new k37(this.d, w46.N0);
            this.v = new l37(this.d, b56.E0);
            this.J = new xz6(this.d, b56.x0, (byte) 3);
            this.K = new i37(this.d, rr5.g);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.s);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.w);
            this.a.add(this.D);
            this.a.add(new ReadProgessDelegetAdapter(this.d, f57.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new k47(this.d, v47.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
            this.a.add(this.K);
            e();
            k();
            q("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.L = hg8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.M = hg8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.N = hg8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.O = hg8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.P = hg8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.Q = hg8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.R = hg8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(zw6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(zw6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            v37 v37Var = this.h;
            if (v37Var != null) {
                v37Var.B(bVar);
            }
            a47 a47Var = this.m;
            if (a47Var != null) {
                a47Var.A(bVar);
            }
            q37 q37Var = this.k;
            if (q37Var != null) {
                q37Var.y(bVar);
            }
            t37 t37Var = this.w;
            if (t37Var != null) {
                t37Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            e47 e47Var = this.z;
            if (e47Var != null) {
                e47Var.x(bVar);
            }
            d47 d47Var = this.A;
            if (d47Var != null) {
                d47Var.C(bVar);
            }
            c47 c47Var = this.C;
            if (c47Var != null) {
                c47Var.z(bVar);
            }
            f47 f47Var = this.B;
            if (f47Var != null) {
                f47Var.A(bVar);
            }
            v37 v37Var2 = this.D;
            if (v37Var2 != null) {
                v37Var2.B(bVar);
            }
            y37 y37Var = this.E;
            if (y37Var != null) {
                y37Var.A(bVar);
            }
            z37 z37Var = this.F;
            if (z37Var != null) {
                z37Var.z(bVar);
            }
            b47 b47Var = this.G;
            if (b47Var != null) {
                b47Var.v(bVar);
            }
            k37 k37Var = this.H;
            if (k37Var != null) {
                k37Var.z(bVar);
            }
        }
    }

    public final void x(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cdo) == null) {
            this.i.C(cdo);
            this.j.A(cdo);
            this.k.z(cdo);
            this.l.A(cdo);
            this.m.C(cdo);
            this.n.u(cdo);
            this.o.v(cdo);
            this.p.u(cdo);
            this.q.A(cdo);
            this.r.A(cdo);
            this.s.A(cdo);
            this.t.A(cdo);
            this.v.B(cdo);
            this.u.D(cdo);
            this.H.A(cdo);
            this.A.D(cdo);
            this.A.D(cdo);
            this.C.A(cdo);
            this.J.u(cdo);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            j37 j37Var = this.g;
            if (j37Var != null) {
                j37Var.u(bdUniqueId);
            }
            v37 v37Var = this.h;
            if (v37Var != null) {
                v37Var.b = bdUniqueId;
            }
            g47 g47Var = this.i;
            if (g47Var != null) {
                g47Var.b = bdUniqueId;
            }
            p37 p37Var = this.j;
            if (p37Var != null) {
                p37Var.a = bdUniqueId;
            }
            q37 q37Var = this.k;
            if (q37Var != null) {
                q37Var.a = bdUniqueId;
            }
            r37 r37Var = this.l;
            if (r37Var != null) {
                r37Var.a = bdUniqueId;
            }
            a47 a47Var = this.m;
            if (a47Var != null) {
                a47Var.a = bdUniqueId;
            }
            s37 s37Var = this.n;
            if (s37Var != null) {
                s37Var.a = bdUniqueId;
            }
            x37 x37Var = this.o;
            if (x37Var != null) {
                x37Var.a = bdUniqueId;
            }
            u37 u37Var = this.p;
            if (u37Var != null) {
                u37Var.a = bdUniqueId;
            }
            w37 w37Var = this.q;
            if (w37Var != null) {
                w37Var.a = bdUniqueId;
            }
            o37 o37Var = this.r;
            if (o37Var != null) {
                o37Var.a = bdUniqueId;
            }
            n37 n37Var = this.s;
            if (n37Var != null) {
                n37Var.a = bdUniqueId;
            }
            m37 m37Var = this.t;
            if (m37Var != null) {
                m37Var.a = bdUniqueId;
            }
            t37 t37Var = this.w;
            if (t37Var != null) {
                t37Var.b = bdUniqueId;
            }
            h47 h47Var = this.u;
            if (h47Var != null) {
                h47Var.a = bdUniqueId;
            }
            h37 h37Var = this.e;
            if (h37Var != null) {
                h37Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            i47 i47Var = this.I;
            if (i47Var != null) {
                i47Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            e47 e47Var = this.z;
            if (e47Var != null) {
                e47Var.b = bdUniqueId;
            }
            d47 d47Var = this.A;
            if (d47Var != null) {
                d47Var.b = bdUniqueId;
            }
            c47 c47Var = this.C;
            if (c47Var != null) {
                c47Var.b = bdUniqueId;
            }
            f47 f47Var = this.B;
            if (f47Var != null) {
                f47Var.b = bdUniqueId;
            }
            v37 v37Var2 = this.D;
            if (v37Var2 != null) {
                v37Var2.b = bdUniqueId;
            }
            y37 y37Var = this.E;
            if (y37Var != null) {
                y37Var.a = bdUniqueId;
            }
            z37 z37Var = this.F;
            if (z37Var != null) {
                z37Var.a = bdUniqueId;
            }
            b47 b47Var = this.G;
            if (b47Var != null) {
                b47Var.a = bdUniqueId;
            }
            k37 k37Var = this.H;
            if (k37Var != null) {
                k37Var.b = bdUniqueId;
            }
            l37 l37Var = this.v;
            if (l37Var != null) {
                l37Var.a = bdUniqueId;
            }
            xz6 xz6Var = this.J;
            if (xz6Var != null) {
                xz6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.S)) {
                for (kn knVar : this.S) {
                    if (knVar instanceof zi7) {
                        ((zi7) knVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            if (!this.U) {
                this.W.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.W);
            }
        }
    }

    public void w(c57 c57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, c57Var) == null) {
            this.h.C(c57Var);
            this.i.B(c57Var);
            this.j.z(c57Var);
            this.l.z(c57Var);
            this.m.B(c57Var);
            this.q.z(c57Var);
            this.r.z(c57Var);
            this.s.z(c57Var);
            this.t.z(c57Var);
            this.u.C(c57Var);
            this.v.A(c57Var);
        }
    }

    public void z(List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            lo8.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                int i2 = 0;
                View childAt = bdRecyclerView.getChildAt(0);
                if (childAt != null) {
                    i2 = childAt.getTop();
                }
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i3 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.A();
                }
            }
            eh.b(new a(this, list));
            this.c = list;
            f fVar = this.V;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
