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
public class k07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c07 A;
    public e07 B;
    public b07 C;
    public uz6 D;
    public xz6 E;
    public yz6 F;
    public a07 G;
    public jz6 H;
    public h07 I;
    public yv6 J;
    public cn K;
    public cn L;
    public cn M;
    public cn N;
    public cn O;
    public cn P;
    public cn Q;
    public List<cn> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<cn> a;
    public vn b;
    public List<pn> c;
    public TbPageContext<?> d;
    public hz6 e;
    public i07 f;
    public iz6 g;
    public uz6 h;
    public f07 i;
    public oz6 j;
    public pz6 k;
    public qz6 l;
    public zz6 m;
    public rz6 n;
    public wz6 o;
    public tz6 p;
    public vz6 q;
    public nz6 r;
    public mz6 s;
    public lz6 t;
    public g07 u;
    public kz6 v;
    public sz6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public d07 z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k07 b;

        public a(k07 k07Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k07Var;
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
        public final /* synthetic */ k07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k07 k07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var, Integer.valueOf(i)};
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
            this.a = k07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.f();
            if (this.a.c != null) {
                k07 k07Var = this.a;
                k07Var.y(k07Var.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k07 k07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var, Integer.valueOf(i)};
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
            this.a = k07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k07 k07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var, Integer.valueOf(i)};
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
            this.a = k07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                xf7 xf7Var = new xf7();
                xf7Var.a = String.valueOf(customResponsedMessage.getData());
                xf7Var.b = true;
                this.a.g(xf7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k07 k07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var, Integer.valueOf(i)};
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
            this.a = k07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                xf7 xf7Var = new xf7();
                xf7Var.a = String.valueOf(customResponsedMessage.getData());
                xf7Var.b = false;
                this.a.g(xf7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public k07(Context context, vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.V = new b(this, 2016470);
        this.W = new c(this, 2001115);
        this.X = new d(this, 2001335);
        this.Y = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = vnVar;
        this.d = (TbPageContext) i9.a(context);
        j(context);
        x(vnVar);
        vnVar.a(this.a);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.T = f();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<cn> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = ik8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    af7 b2 = fg7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.s(3);
                    }
                    uz6 uz6Var = this.h;
                    if (uz6Var != null && (bdUniqueId = uz6Var.b) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.R.add(b2);
                }
                this.b.a(this.R);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<pn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (pn pnVar : list) {
            if ((pnVar instanceof ICardInfo) && ((ICardInfo) pnVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            l();
        }
    }

    public List<pn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (TbPageContext) invokeV.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new hz6(this.d);
            this.f = new i07(this.d);
            this.g = new iz6(this.d, s07.b);
            this.h = new uz6(this.d, v06.i0);
            this.i = new f07(this.d, v06.z0);
            this.j = new oz6(this.d, v06.H0);
            this.k = new pz6(this.d, v06.A0);
            this.l = new qz6(this.d, v06.I0);
            this.m = new zz6(this.d, v06.G0);
            this.n = new rz6(this.d, v06.J0);
            this.o = new wz6(this.d, v06.K0);
            this.p = new tz6(this.d, v06.L0);
            this.q = new vz6(this.d, v06.M0);
            this.r = new nz6(this.d, v06.B0);
            this.s = new mz6(this.d, v06.C0);
            this.t = new lz6(this.d, v06.D0);
            this.u = new g07(this.d, w06.U);
            this.w = new sz6(this.d, v06.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, u06.N0);
            this.I = new h07(this.d, v06.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, u06.O0);
            this.z = new d07(this.d, v06.r0);
            this.A = new c07(this.d, v06.s0);
            this.B = new e07(this.d, v06.u0);
            this.C = new b07(this.d, v06.t0);
            this.D = new uz6(this.d, v06.j0);
            this.E = new xz6(this.d, v06.v0);
            this.F = new yz6(this.d, v06.w0);
            this.G = new a07(this.d, w37.d0);
            this.H = new jz6(this.d, q06.N0);
            this.v = new kz6(this.d, v06.E0);
            this.J = new yv6(this.d, v06.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, g17.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new j07(this.d, u07.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
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
            this.K = gc8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = gc8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = gc8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = gc8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = gc8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = gc8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = gc8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(at6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(at6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void l() {
        vn vnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (vnVar = this.b) == null) {
            return;
        }
        vnVar.getListAdapter().notifyDataSetChanged();
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void o() {
        g07 g07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (g07Var = this.u) == null) {
            return;
        }
        g07Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            g07 g07Var = this.u;
            if (g07Var != null) {
                g07Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            l();
        }
    }

    public final void q(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof xl5) {
                ((xl5) cnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof ou6) {
                    ((ou6) cnVar).s(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            uz6 uz6Var = this.h;
            if (uz6Var != null) {
                uz6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            qz6 qz6Var = this.l;
            if (qz6Var != null) {
                qz6Var.setFromCDN(z);
            }
            kz6 kz6Var = this.v;
            if (kz6Var != null) {
                kz6Var.setFromCDN(z);
            }
            cn cnVar = this.L;
            if (cnVar == null || !(cnVar instanceof cc8)) {
                return;
            }
            ((cc8) cnVar).setIsFromCDN(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            uz6 uz6Var = this.h;
            if (uz6Var != null) {
                uz6Var.B(bVar);
            }
            zz6 zz6Var = this.m;
            if (zz6Var != null) {
                zz6Var.A(bVar);
            }
            pz6 pz6Var = this.k;
            if (pz6Var != null) {
                pz6Var.y(bVar);
            }
            sz6 sz6Var = this.w;
            if (sz6Var != null) {
                sz6Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            d07 d07Var = this.z;
            if (d07Var != null) {
                d07Var.x(bVar);
            }
            c07 c07Var = this.A;
            if (c07Var != null) {
                c07Var.C(bVar);
            }
            b07 b07Var = this.C;
            if (b07Var != null) {
                b07Var.z(bVar);
            }
            e07 e07Var = this.B;
            if (e07Var != null) {
                e07Var.A(bVar);
            }
            uz6 uz6Var2 = this.D;
            if (uz6Var2 != null) {
                uz6Var2.B(bVar);
            }
            xz6 xz6Var = this.E;
            if (xz6Var != null) {
                xz6Var.A(bVar);
            }
            yz6 yz6Var = this.F;
            if (yz6Var != null) {
                yz6Var.z(bVar);
            }
            a07 a07Var = this.G;
            if (a07Var != null) {
                a07Var.v(bVar);
            }
            jz6 jz6Var = this.H;
            if (jz6Var != null) {
                jz6Var.z(bVar);
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            iz6 iz6Var = this.g;
            if (iz6Var != null) {
                iz6Var.u(bdUniqueId);
            }
            uz6 uz6Var = this.h;
            if (uz6Var != null) {
                uz6Var.b = bdUniqueId;
            }
            f07 f07Var = this.i;
            if (f07Var != null) {
                f07Var.b = bdUniqueId;
            }
            oz6 oz6Var = this.j;
            if (oz6Var != null) {
                oz6Var.a = bdUniqueId;
            }
            pz6 pz6Var = this.k;
            if (pz6Var != null) {
                pz6Var.a = bdUniqueId;
            }
            qz6 qz6Var = this.l;
            if (qz6Var != null) {
                qz6Var.a = bdUniqueId;
            }
            zz6 zz6Var = this.m;
            if (zz6Var != null) {
                zz6Var.a = bdUniqueId;
            }
            rz6 rz6Var = this.n;
            if (rz6Var != null) {
                rz6Var.a = bdUniqueId;
            }
            wz6 wz6Var = this.o;
            if (wz6Var != null) {
                wz6Var.a = bdUniqueId;
            }
            tz6 tz6Var = this.p;
            if (tz6Var != null) {
                tz6Var.a = bdUniqueId;
            }
            vz6 vz6Var = this.q;
            if (vz6Var != null) {
                vz6Var.a = bdUniqueId;
            }
            nz6 nz6Var = this.r;
            if (nz6Var != null) {
                nz6Var.a = bdUniqueId;
            }
            mz6 mz6Var = this.s;
            if (mz6Var != null) {
                mz6Var.a = bdUniqueId;
            }
            lz6 lz6Var = this.t;
            if (lz6Var != null) {
                lz6Var.a = bdUniqueId;
            }
            sz6 sz6Var = this.w;
            if (sz6Var != null) {
                sz6Var.b = bdUniqueId;
            }
            g07 g07Var = this.u;
            if (g07Var != null) {
                g07Var.a = bdUniqueId;
            }
            hz6 hz6Var = this.e;
            if (hz6Var != null) {
                hz6Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            h07 h07Var = this.I;
            if (h07Var != null) {
                h07Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            d07 d07Var = this.z;
            if (d07Var != null) {
                d07Var.b = bdUniqueId;
            }
            c07 c07Var = this.A;
            if (c07Var != null) {
                c07Var.b = bdUniqueId;
            }
            b07 b07Var = this.C;
            if (b07Var != null) {
                b07Var.b = bdUniqueId;
            }
            e07 e07Var = this.B;
            if (e07Var != null) {
                e07Var.b = bdUniqueId;
            }
            uz6 uz6Var2 = this.D;
            if (uz6Var2 != null) {
                uz6Var2.b = bdUniqueId;
            }
            xz6 xz6Var = this.E;
            if (xz6Var != null) {
                xz6Var.a = bdUniqueId;
            }
            yz6 yz6Var = this.F;
            if (yz6Var != null) {
                yz6Var.a = bdUniqueId;
            }
            a07 a07Var = this.G;
            if (a07Var != null) {
                a07Var.a = bdUniqueId;
            }
            jz6 jz6Var = this.H;
            if (jz6Var != null) {
                jz6Var.b = bdUniqueId;
            }
            kz6 kz6Var = this.v;
            if (kz6Var != null) {
                kz6Var.a = bdUniqueId;
            }
            yv6 yv6Var = this.J;
            if (yv6Var != null) {
                yv6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (cn cnVar : this.R) {
                    if (cnVar instanceof af7) {
                        ((af7) cnVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (this.T) {
                return;
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
    }

    public void w(c17 c17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, c17Var) == null) {
            this.h.C(c17Var);
            this.i.B(c17Var);
            this.j.z(c17Var);
            this.l.z(c17Var);
            this.m.B(c17Var);
            this.q.z(c17Var);
            this.r.z(c17Var);
            this.s.z(c17Var);
            this.t.z(c17Var);
            this.u.C(c17Var);
            this.v.A(c17Var);
        }
    }

    public final void x(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vnVar) == null) {
            this.i.C(vnVar);
            this.j.A(vnVar);
            this.k.z(vnVar);
            this.l.A(vnVar);
            this.m.C(vnVar);
            this.n.u(vnVar);
            this.o.v(vnVar);
            this.p.u(vnVar);
            this.q.A(vnVar);
            this.r.A(vnVar);
            this.s.A(vnVar);
            this.t.A(vnVar);
            this.v.B(vnVar);
            this.u.D(vnVar);
            this.H.A(vnVar);
            this.A.D(vnVar);
            this.A.D(vnVar);
            this.C.A(vnVar);
            this.J.u(vnVar);
        }
    }

    public void y(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            ik8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void z(List<pn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            ik8.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i2 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    bdRecyclerView.A();
                }
            }
            wg.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
