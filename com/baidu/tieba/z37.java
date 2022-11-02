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
/* loaded from: classes6.dex */
public class z37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r37 A;
    public t37 B;
    public q37 C;
    public j37 D;
    public m37 E;
    public n37 F;
    public p37 G;
    public y27 H;
    public w37 I;
    public lz6 J;
    public w27 K;
    public jn L;
    public jn M;
    public jn N;
    public jn O;
    public jn P;
    public jn Q;
    public jn R;
    public List<jn> S;
    public boolean T;
    public boolean U;
    public f V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<jn> a;
    public co b;
    public List<wn> c;
    public TbPageContext<?> d;
    public v27 e;
    public x37 f;
    public x27 g;
    public j37 h;
    public u37 i;
    public d37 j;
    public e37 k;
    public f37 l;
    public o37 m;
    public g37 n;
    public l37 o;
    public i37 p;
    public k37 q;
    public c37 r;
    public b37 s;
    public a37 t;
    public v37 u;
    public z27 v;
    public h37 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public s37 z;

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ z37 b;

        public a(z37 z37Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z37Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z37Var;
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

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(z37 z37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z37Var, Integer.valueOf(i)};
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
            this.a = z37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    z37 z37Var = this.a;
                    z37Var.y(z37Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(z37 z37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z37Var, Integer.valueOf(i)};
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
            this.a = z37Var;
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

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(z37 z37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z37Var, Integer.valueOf(i)};
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
            this.a = z37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                kj7 kj7Var = new kj7();
                kj7Var.a = String.valueOf(customResponsedMessage.getData());
                kj7Var.b = true;
                this.a.g(kj7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(z37 z37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z37Var, Integer.valueOf(i)};
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
            this.a = z37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                kj7 kj7Var = new kj7();
                kj7Var.a = String.valueOf(customResponsedMessage.getData());
                kj7Var.b = false;
                this.a.g(kj7Var);
            }
        }
    }

    public z37(Context context, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, coVar};
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
        this.b = coVar;
        this.d = (TbPageContext) w9.a(context);
        j(context);
        x(coVar);
        coVar.a(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof zp5) {
                ((zp5) jnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof by6) {
                    ((by6) jnVar).s(aVar);
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

    public void y(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            zn8.f(list, 2);
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

    public List<wn> h() {
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
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (coVar = this.b) != null) {
            coVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        v37 v37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (v37Var = this.u) != null) {
            v37Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            v37 v37Var = this.u;
            if (v37Var != null) {
                v37Var.onResume();
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
            List<jn> list = this.S;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.S = new ArrayList();
            ArrayList<BdUniqueId> g = zn8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ni7 b2 = sj7.d().b(this.d, g.get(i), 2);
                if (this.T) {
                    b2.s(3);
                }
                j37 j37Var = this.h;
                if (j37Var != null && (bdUniqueId = j37Var.b) != null) {
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
        List<wn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (wn wnVar : list) {
                if ((wnVar instanceof ICardInfo) && ((ICardInfo) wnVar).responseAttention(obj)) {
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
            j37 j37Var = this.h;
            if (j37Var != null) {
                j37Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            f37 f37Var = this.l;
            if (f37Var != null) {
                f37Var.setFromCDN(z);
            }
            z27 z27Var = this.v;
            if (z27Var != null) {
                z27Var.setFromCDN(z);
            }
            jn jnVar = this.M;
            if (jnVar != null && (jnVar instanceof rf8)) {
                ((rf8) jnVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new v27(this.d);
            this.f = new x37(this.d);
            this.g = new x27(this.d, h47.b);
            this.h = new j37(this.d, o46.i0);
            this.i = new u37(this.d, o46.z0);
            this.j = new d37(this.d, o46.H0);
            this.k = new e37(this.d, o46.A0);
            this.l = new f37(this.d, o46.I0);
            this.m = new o37(this.d, o46.G0);
            this.n = new g37(this.d, o46.J0);
            this.o = new l37(this.d, o46.K0);
            this.p = new i37(this.d, o46.L0);
            this.q = new k37(this.d, o46.M0);
            this.r = new c37(this.d, o46.B0);
            this.s = new b37(this.d, o46.C0);
            this.t = new a37(this.d, o46.D0);
            this.u = new v37(this.d, p46.U);
            this.w = new h37(this.d, o46.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, n46.N0);
            this.I = new w37(this.d, o46.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, n46.O0);
            this.z = new s37(this.d, o46.r0);
            this.A = new r37(this.d, o46.s0);
            this.B = new t37(this.d, o46.u0);
            this.C = new q37(this.d, o46.t0);
            this.D = new j37(this.d, o46.j0);
            this.E = new m37(this.d, o46.v0);
            this.F = new n37(this.d, o46.w0);
            this.G = new p37(this.d, h77.d0);
            this.H = new y27(this.d, j46.N0);
            this.v = new z27(this.d, o46.E0);
            this.J = new lz6(this.d, o46.x0, (byte) 3);
            this.K = new w27(this.d, er5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, t47.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new y37(this.d, j47.e));
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
            this.L = vf8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.M = vf8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.N = vf8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.O = vf8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.P = vf8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.Q = vf8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.R = vf8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(nw6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(nw6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            j37 j37Var = this.h;
            if (j37Var != null) {
                j37Var.B(bVar);
            }
            o37 o37Var = this.m;
            if (o37Var != null) {
                o37Var.A(bVar);
            }
            e37 e37Var = this.k;
            if (e37Var != null) {
                e37Var.y(bVar);
            }
            h37 h37Var = this.w;
            if (h37Var != null) {
                h37Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            s37 s37Var = this.z;
            if (s37Var != null) {
                s37Var.x(bVar);
            }
            r37 r37Var = this.A;
            if (r37Var != null) {
                r37Var.C(bVar);
            }
            q37 q37Var = this.C;
            if (q37Var != null) {
                q37Var.z(bVar);
            }
            t37 t37Var = this.B;
            if (t37Var != null) {
                t37Var.A(bVar);
            }
            j37 j37Var2 = this.D;
            if (j37Var2 != null) {
                j37Var2.B(bVar);
            }
            m37 m37Var = this.E;
            if (m37Var != null) {
                m37Var.A(bVar);
            }
            n37 n37Var = this.F;
            if (n37Var != null) {
                n37Var.z(bVar);
            }
            p37 p37Var = this.G;
            if (p37Var != null) {
                p37Var.v(bVar);
            }
            y27 y27Var = this.H;
            if (y27Var != null) {
                y27Var.z(bVar);
            }
        }
    }

    public final void x(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, coVar) == null) {
            this.i.C(coVar);
            this.j.A(coVar);
            this.k.z(coVar);
            this.l.A(coVar);
            this.m.C(coVar);
            this.n.u(coVar);
            this.o.v(coVar);
            this.p.u(coVar);
            this.q.A(coVar);
            this.r.A(coVar);
            this.s.A(coVar);
            this.t.A(coVar);
            this.v.B(coVar);
            this.u.D(coVar);
            this.H.A(coVar);
            this.A.D(coVar);
            this.A.D(coVar);
            this.C.A(coVar);
            this.J.u(coVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            x27 x27Var = this.g;
            if (x27Var != null) {
                x27Var.u(bdUniqueId);
            }
            j37 j37Var = this.h;
            if (j37Var != null) {
                j37Var.b = bdUniqueId;
            }
            u37 u37Var = this.i;
            if (u37Var != null) {
                u37Var.b = bdUniqueId;
            }
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.a = bdUniqueId;
            }
            e37 e37Var = this.k;
            if (e37Var != null) {
                e37Var.a = bdUniqueId;
            }
            f37 f37Var = this.l;
            if (f37Var != null) {
                f37Var.a = bdUniqueId;
            }
            o37 o37Var = this.m;
            if (o37Var != null) {
                o37Var.a = bdUniqueId;
            }
            g37 g37Var = this.n;
            if (g37Var != null) {
                g37Var.a = bdUniqueId;
            }
            l37 l37Var = this.o;
            if (l37Var != null) {
                l37Var.a = bdUniqueId;
            }
            i37 i37Var = this.p;
            if (i37Var != null) {
                i37Var.a = bdUniqueId;
            }
            k37 k37Var = this.q;
            if (k37Var != null) {
                k37Var.a = bdUniqueId;
            }
            c37 c37Var = this.r;
            if (c37Var != null) {
                c37Var.a = bdUniqueId;
            }
            b37 b37Var = this.s;
            if (b37Var != null) {
                b37Var.a = bdUniqueId;
            }
            a37 a37Var = this.t;
            if (a37Var != null) {
                a37Var.a = bdUniqueId;
            }
            h37 h37Var = this.w;
            if (h37Var != null) {
                h37Var.b = bdUniqueId;
            }
            v37 v37Var = this.u;
            if (v37Var != null) {
                v37Var.a = bdUniqueId;
            }
            v27 v27Var = this.e;
            if (v27Var != null) {
                v27Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            w37 w37Var = this.I;
            if (w37Var != null) {
                w37Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            s37 s37Var = this.z;
            if (s37Var != null) {
                s37Var.b = bdUniqueId;
            }
            r37 r37Var = this.A;
            if (r37Var != null) {
                r37Var.b = bdUniqueId;
            }
            q37 q37Var = this.C;
            if (q37Var != null) {
                q37Var.b = bdUniqueId;
            }
            t37 t37Var = this.B;
            if (t37Var != null) {
                t37Var.b = bdUniqueId;
            }
            j37 j37Var2 = this.D;
            if (j37Var2 != null) {
                j37Var2.b = bdUniqueId;
            }
            m37 m37Var = this.E;
            if (m37Var != null) {
                m37Var.a = bdUniqueId;
            }
            n37 n37Var = this.F;
            if (n37Var != null) {
                n37Var.a = bdUniqueId;
            }
            p37 p37Var = this.G;
            if (p37Var != null) {
                p37Var.a = bdUniqueId;
            }
            y27 y27Var = this.H;
            if (y27Var != null) {
                y27Var.b = bdUniqueId;
            }
            z27 z27Var = this.v;
            if (z27Var != null) {
                z27Var.a = bdUniqueId;
            }
            lz6 lz6Var = this.J;
            if (lz6Var != null) {
                lz6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.S)) {
                for (jn jnVar : this.S) {
                    if (jnVar instanceof ni7) {
                        ((ni7) jnVar).setUniqueId(bdUniqueId);
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

    public void w(q47 q47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, q47Var) == null) {
            this.h.C(q47Var);
            this.i.B(q47Var);
            this.j.z(q47Var);
            this.l.z(q47Var);
            this.m.B(q47Var);
            this.q.z(q47Var);
            this.r.z(q47Var);
            this.s.z(q47Var);
            this.t.z(q47Var);
            this.u.C(q47Var);
            this.v.A(q47Var);
        }
    }

    public void z(List<wn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            zn8.f(list, 2);
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
            dh.b(new a(this, list));
            this.c = list;
            f fVar = this.V;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
