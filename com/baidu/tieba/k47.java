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
public class k47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c47 A;
    public e47 B;
    public b47 C;
    public u37 D;
    public x37 E;
    public y37 F;
    public a47 G;
    public j37 H;
    public h47 I;
    public wz6 J;
    public h37 K;
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
    public g37 e;
    public i47 f;
    public i37 g;
    public u37 h;
    public f47 i;
    public o37 j;
    public p37 k;
    public q37 l;
    public z37 m;
    public r37 n;
    public w37 o;
    public t37 p;
    public v37 q;
    public n37 r;
    public m37 s;
    public l37 t;
    public g47 u;
    public k37 v;
    public s37 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public d47 z;

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
        public final /* synthetic */ k47 b;

        public a(k47 k47Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k47Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k47Var;
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
        public final /* synthetic */ k47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k47 k47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k47Var, Integer.valueOf(i)};
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
            this.a = k47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    k47 k47Var = this.a;
                    k47Var.y(k47Var.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k47 k47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k47Var, Integer.valueOf(i)};
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
            this.a = k47Var;
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
        public final /* synthetic */ k47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k47 k47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k47Var, Integer.valueOf(i)};
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
            this.a = k47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                vj7 vj7Var = new vj7();
                vj7Var.a = String.valueOf(customResponsedMessage.getData());
                vj7Var.b = true;
                this.a.g(vj7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k47 k47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k47Var, Integer.valueOf(i)};
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
            this.a = k47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                vj7 vj7Var = new vj7();
                vj7Var.a = String.valueOf(customResponsedMessage.getData());
                vj7Var.b = false;
                this.a.g(vj7Var);
            }
        }
    }

    public k47(Context context, Cdo cdo) {
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
            if (knVar instanceof lq5) {
                ((lq5) knVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof my6) {
                    ((my6) knVar).s(aVar);
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
            ko8.f(list, 2);
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
        g47 g47Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (g47Var = this.u) != null) {
            g47Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            g47 g47Var = this.u;
            if (g47Var != null) {
                g47Var.onResume();
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
            ArrayList<BdUniqueId> g = ko8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                yi7 b2 = dk7.d().b(this.d, g.get(i), 2);
                if (this.T) {
                    b2.s(3);
                }
                u37 u37Var = this.h;
                if (u37Var != null && (bdUniqueId = u37Var.b) != null) {
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
            u37 u37Var = this.h;
            if (u37Var != null) {
                u37Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            q37 q37Var = this.l;
            if (q37Var != null) {
                q37Var.setFromCDN(z);
            }
            k37 k37Var = this.v;
            if (k37Var != null) {
                k37Var.setFromCDN(z);
            }
            kn knVar = this.M;
            if (knVar != null && (knVar instanceof cg8)) {
                ((cg8) knVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new g37(this.d);
            this.f = new i47(this.d);
            this.g = new i37(this.d, s47.b);
            this.h = new u37(this.d, a56.i0);
            this.i = new f47(this.d, a56.z0);
            this.j = new o37(this.d, a56.H0);
            this.k = new p37(this.d, a56.A0);
            this.l = new q37(this.d, a56.I0);
            this.m = new z37(this.d, a56.G0);
            this.n = new r37(this.d, a56.J0);
            this.o = new w37(this.d, a56.K0);
            this.p = new t37(this.d, a56.L0);
            this.q = new v37(this.d, a56.M0);
            this.r = new n37(this.d, a56.B0);
            this.s = new m37(this.d, a56.C0);
            this.t = new l37(this.d, a56.D0);
            this.u = new g47(this.d, b56.U);
            this.w = new s37(this.d, a56.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, z46.N0);
            this.I = new h47(this.d, a56.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, z46.O0);
            this.z = new d47(this.d, a56.r0);
            this.A = new c47(this.d, a56.s0);
            this.B = new e47(this.d, a56.u0);
            this.C = new b47(this.d, a56.t0);
            this.D = new u37(this.d, a56.j0);
            this.E = new x37(this.d, a56.v0);
            this.F = new y37(this.d, a56.w0);
            this.G = new a47(this.d, s77.d0);
            this.H = new j37(this.d, v46.N0);
            this.v = new k37(this.d, a56.E0);
            this.J = new wz6(this.d, a56.x0, (byte) 3);
            this.K = new h37(this.d, qr5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, e57.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new j47(this.d, u47.e));
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
            this.L = gg8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.M = gg8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.N = gg8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.O = gg8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.P = gg8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.Q = gg8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.R = gg8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(yw6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(yw6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            u37 u37Var = this.h;
            if (u37Var != null) {
                u37Var.B(bVar);
            }
            z37 z37Var = this.m;
            if (z37Var != null) {
                z37Var.A(bVar);
            }
            p37 p37Var = this.k;
            if (p37Var != null) {
                p37Var.y(bVar);
            }
            s37 s37Var = this.w;
            if (s37Var != null) {
                s37Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            d47 d47Var = this.z;
            if (d47Var != null) {
                d47Var.x(bVar);
            }
            c47 c47Var = this.A;
            if (c47Var != null) {
                c47Var.C(bVar);
            }
            b47 b47Var = this.C;
            if (b47Var != null) {
                b47Var.z(bVar);
            }
            e47 e47Var = this.B;
            if (e47Var != null) {
                e47Var.A(bVar);
            }
            u37 u37Var2 = this.D;
            if (u37Var2 != null) {
                u37Var2.B(bVar);
            }
            x37 x37Var = this.E;
            if (x37Var != null) {
                x37Var.A(bVar);
            }
            y37 y37Var = this.F;
            if (y37Var != null) {
                y37Var.z(bVar);
            }
            a47 a47Var = this.G;
            if (a47Var != null) {
                a47Var.v(bVar);
            }
            j37 j37Var = this.H;
            if (j37Var != null) {
                j37Var.z(bVar);
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
            i37 i37Var = this.g;
            if (i37Var != null) {
                i37Var.u(bdUniqueId);
            }
            u37 u37Var = this.h;
            if (u37Var != null) {
                u37Var.b = bdUniqueId;
            }
            f47 f47Var = this.i;
            if (f47Var != null) {
                f47Var.b = bdUniqueId;
            }
            o37 o37Var = this.j;
            if (o37Var != null) {
                o37Var.a = bdUniqueId;
            }
            p37 p37Var = this.k;
            if (p37Var != null) {
                p37Var.a = bdUniqueId;
            }
            q37 q37Var = this.l;
            if (q37Var != null) {
                q37Var.a = bdUniqueId;
            }
            z37 z37Var = this.m;
            if (z37Var != null) {
                z37Var.a = bdUniqueId;
            }
            r37 r37Var = this.n;
            if (r37Var != null) {
                r37Var.a = bdUniqueId;
            }
            w37 w37Var = this.o;
            if (w37Var != null) {
                w37Var.a = bdUniqueId;
            }
            t37 t37Var = this.p;
            if (t37Var != null) {
                t37Var.a = bdUniqueId;
            }
            v37 v37Var = this.q;
            if (v37Var != null) {
                v37Var.a = bdUniqueId;
            }
            n37 n37Var = this.r;
            if (n37Var != null) {
                n37Var.a = bdUniqueId;
            }
            m37 m37Var = this.s;
            if (m37Var != null) {
                m37Var.a = bdUniqueId;
            }
            l37 l37Var = this.t;
            if (l37Var != null) {
                l37Var.a = bdUniqueId;
            }
            s37 s37Var = this.w;
            if (s37Var != null) {
                s37Var.b = bdUniqueId;
            }
            g47 g47Var = this.u;
            if (g47Var != null) {
                g47Var.a = bdUniqueId;
            }
            g37 g37Var = this.e;
            if (g37Var != null) {
                g37Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            h47 h47Var = this.I;
            if (h47Var != null) {
                h47Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            d47 d47Var = this.z;
            if (d47Var != null) {
                d47Var.b = bdUniqueId;
            }
            c47 c47Var = this.A;
            if (c47Var != null) {
                c47Var.b = bdUniqueId;
            }
            b47 b47Var = this.C;
            if (b47Var != null) {
                b47Var.b = bdUniqueId;
            }
            e47 e47Var = this.B;
            if (e47Var != null) {
                e47Var.b = bdUniqueId;
            }
            u37 u37Var2 = this.D;
            if (u37Var2 != null) {
                u37Var2.b = bdUniqueId;
            }
            x37 x37Var = this.E;
            if (x37Var != null) {
                x37Var.a = bdUniqueId;
            }
            y37 y37Var = this.F;
            if (y37Var != null) {
                y37Var.a = bdUniqueId;
            }
            a47 a47Var = this.G;
            if (a47Var != null) {
                a47Var.a = bdUniqueId;
            }
            j37 j37Var = this.H;
            if (j37Var != null) {
                j37Var.b = bdUniqueId;
            }
            k37 k37Var = this.v;
            if (k37Var != null) {
                k37Var.a = bdUniqueId;
            }
            wz6 wz6Var = this.J;
            if (wz6Var != null) {
                wz6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.S)) {
                for (kn knVar : this.S) {
                    if (knVar instanceof yi7) {
                        ((yi7) knVar).setUniqueId(bdUniqueId);
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

    public void w(b57 b57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, b57Var) == null) {
            this.h.C(b57Var);
            this.i.B(b57Var);
            this.j.z(b57Var);
            this.l.z(b57Var);
            this.m.B(b57Var);
            this.q.z(b57Var);
            this.r.z(b57Var);
            this.s.z(b57Var);
            this.t.z(b57Var);
            this.u.C(b57Var);
            this.v.A(b57Var);
        }
    }

    public void z(List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            ko8.f(list, 2);
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
