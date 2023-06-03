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
public class m08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g08 A;
    public d08 B;
    public xz7 C;
    public a08 D;
    public c08 E;
    public mz7 F;
    public j08 G;
    public xv7 H;
    public yv7 I;
    public kz7 J;
    public in K;
    public in L;
    public in M;
    public in N;
    public in O;
    public in P;
    public in Q;
    public List<in> R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1136T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<in> a;
    public bo b;
    public List<vn> c;
    public TbPageContext<?> d;
    public jz7 e;
    public k08 f;
    public lz7 g;
    public xz7 h;
    public h08 i;
    public rz7 j;
    public sz7 k;
    public tz7 l;
    public b08 m;
    public uz7 n;
    public zz7 o;
    public wz7 p;
    public yz7 q;
    public qz7 r;
    public pz7 s;
    public oz7 t;
    public i08 u;
    public nz7 v;
    public vz7 w;
    public HomePageAlaLiveThreadAdapter x;
    public f08 y;
    public e08 z;

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ m08 b;

        public a(m08 m08Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m08Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m08Var;
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
        public final /* synthetic */ m08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m08 m08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m08Var, Integer.valueOf(i)};
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
            this.a = m08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    m08 m08Var = this.a;
                    m08Var.z(m08Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(m08 m08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m08Var, Integer.valueOf(i)};
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
            this.a = m08Var;
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
        public final /* synthetic */ m08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(m08 m08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m08Var, Integer.valueOf(i)};
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
            this.a = m08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                kp8 kp8Var = new kp8();
                kp8Var.a = String.valueOf(customResponsedMessage.getData());
                kp8Var.b = true;
                this.a.g(kp8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m08 m08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m08Var, Integer.valueOf(i)};
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
            this.a = m08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                kp8 kp8Var = new kp8();
                kp8Var.a = String.valueOf(customResponsedMessage.getData());
                kp8Var.b = false;
                this.a.g(kp8Var);
            }
        }
    }

    public m08(Context context, bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, boVar};
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
        this.b = boVar;
        this.d = (TbPageContext) q9.a(context);
        j(context);
        y(boVar);
        boVar.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof d56) {
                ((d56) inVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof ou7) {
                    ((ou7) inVar).s(aVar);
                }
            }
        }
    }

    public void s(bz7 bz7Var) {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bz7Var) == null) && (sz7Var = this.k) != null) {
            sz7Var.B(bz7Var);
        }
    }

    public void v(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void z(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            dx9.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void A(List<vn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
            dx9.f(list, 2);
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
                    bdRecyclerView.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.stopIntercerceptLayout();
                }
            }
            ah.e(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1136T = f();
        }
    }

    public List<vn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void l() {
        bo boVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (boVar = this.b) != null) {
            boVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (i08Var = this.u) != null) {
            i08Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i08 i08Var = this.u;
            if (i08Var != null) {
                i08Var.onResume();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<in> list = this.R;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.R = new ArrayList();
            ArrayList<BdUniqueId> g = dx9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                no8 b2 = sp8.d().b(this.d, g.get(i), 2);
                if (this.S) {
                    b2.s(3);
                }
                xz7 xz7Var = this.h;
                if (xz7Var != null && (bdUniqueId = xz7Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.R.add(b2);
            }
            this.b.addAdapters(this.R);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<vn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (vn vnVar : list) {
                if ((vnVar instanceof ICardInfo) && ((ICardInfo) vnVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                l();
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            xz7 xz7Var = this.h;
            if (xz7Var != null) {
                xz7Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            tz7 tz7Var = this.l;
            if (tz7Var != null) {
                tz7Var.setFromCDN(z);
            }
            nz7 nz7Var = this.v;
            if (nz7Var != null) {
                nz7Var.setFromCDN(z);
            }
            in inVar = this.L;
            if (inVar != null && (inVar instanceof zl9)) {
                ((zl9) inVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.e = new jz7(this.d);
            this.f = new k08(this.d);
            this.g = new lz7(this.d, u08.b);
            this.h = new xz7(this.d, uo6.r0);
            this.i = new h08(this.d, uo6.C0);
            this.j = new rz7(this.d, uo6.K0);
            this.k = new sz7(this.d, uo6.D0);
            this.l = new tz7(this.d, uo6.L0);
            this.m = new b08(this.d, uo6.J0);
            this.n = new uz7(this.d, uo6.M0);
            this.o = new zz7(this.d, uo6.N0);
            this.p = new wz7(this.d, uo6.O0);
            this.q = new yz7(this.d, uo6.P0);
            this.r = new qz7(this.d, uo6.E0);
            this.s = new pz7(this.d, uo6.F0);
            this.t = new oz7(this.d, uo6.G0);
            this.u = new i08(this.d, vo6.U);
            this.w = new vz7(this.d, uo6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, to6.Q0);
            this.G = new j08(this.d, uo6.I0);
            this.y = new f08(this.d, uo6.u0);
            this.z = new e08(this.d, uo6.v0);
            this.A = new g08(this.d, uo6.x0);
            this.B = new d08(this.d, uo6.w0);
            this.C = new xz7(this.d, uo6.s0);
            this.D = new a08(this.d, uo6.y0);
            this.E = new c08(this.d, b48.d0);
            this.F = new mz7(this.d, po6.Q0);
            this.v = new nz7(this.d, uo6.H0);
            this.H = new xv7(this.d, uo6.z0, (byte) 3);
            this.I = new yv7(this.d, uo6.A0, (byte) 3);
            this.J = new kz7(this.d, k66.g);
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
            this.a.add(this.C);
            this.a.add(new ReadProgessDelegetAdapter(this.d, h18.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new l08(this.d, x08.h));
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.v);
            this.a.add(this.H);
            this.a.add(this.I);
            this.a.add(this.G);
            this.a.add(this.J);
            e();
            k();
            q("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.K = em9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = em9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = em9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = em9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = em9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = em9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = em9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(rs7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(rs7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            xz7 xz7Var = this.h;
            if (xz7Var != null) {
                xz7Var.D(bVar);
            }
            b08 b08Var = this.m;
            if (b08Var != null) {
                b08Var.C(bVar);
            }
            sz7 sz7Var = this.k;
            if (sz7Var != null) {
                sz7Var.A(bVar);
            }
            vz7 vz7Var = this.w;
            if (vz7Var != null) {
                vz7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            f08 f08Var = this.y;
            if (f08Var != null) {
                f08Var.z(bVar);
            }
            e08 e08Var = this.z;
            if (e08Var != null) {
                e08Var.E(bVar);
            }
            d08 d08Var = this.B;
            if (d08Var != null) {
                d08Var.B(bVar);
            }
            g08 g08Var = this.A;
            if (g08Var != null) {
                g08Var.C(bVar);
            }
            xz7 xz7Var2 = this.C;
            if (xz7Var2 != null) {
                xz7Var2.D(bVar);
            }
            a08 a08Var = this.D;
            if (a08Var != null) {
                a08Var.C(bVar);
            }
            c08 c08Var = this.E;
            if (c08Var != null) {
                c08Var.x(bVar);
            }
            mz7 mz7Var = this.F;
            if (mz7Var != null) {
                mz7Var.B(bVar);
            }
        }
    }

    public final void y(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, boVar) == null) {
            this.i.E(boVar);
            this.j.C(boVar);
            this.k.C(boVar);
            this.l.C(boVar);
            this.m.E(boVar);
            this.n.u(boVar);
            this.o.x(boVar);
            this.p.u(boVar);
            this.q.C(boVar);
            this.r.C(boVar);
            this.s.C(boVar);
            this.t.C(boVar);
            this.v.D(boVar);
            this.u.F(boVar);
            this.F.C(boVar);
            this.z.F(boVar);
            this.z.F(boVar);
            this.B.C(boVar);
            this.H.u(boVar);
            this.I.u(boVar);
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            lz7 lz7Var = this.g;
            if (lz7Var != null) {
                lz7Var.u(bdUniqueId);
            }
            xz7 xz7Var = this.h;
            if (xz7Var != null) {
                xz7Var.b = bdUniqueId;
            }
            h08 h08Var = this.i;
            if (h08Var != null) {
                h08Var.b = bdUniqueId;
            }
            rz7 rz7Var = this.j;
            if (rz7Var != null) {
                rz7Var.a = bdUniqueId;
            }
            sz7 sz7Var = this.k;
            if (sz7Var != null) {
                sz7Var.a = bdUniqueId;
            }
            tz7 tz7Var = this.l;
            if (tz7Var != null) {
                tz7Var.a = bdUniqueId;
            }
            b08 b08Var = this.m;
            if (b08Var != null) {
                b08Var.a = bdUniqueId;
            }
            uz7 uz7Var = this.n;
            if (uz7Var != null) {
                uz7Var.a = bdUniqueId;
            }
            zz7 zz7Var = this.o;
            if (zz7Var != null) {
                zz7Var.a = bdUniqueId;
            }
            wz7 wz7Var = this.p;
            if (wz7Var != null) {
                wz7Var.a = bdUniqueId;
            }
            yz7 yz7Var = this.q;
            if (yz7Var != null) {
                yz7Var.a = bdUniqueId;
            }
            qz7 qz7Var = this.r;
            if (qz7Var != null) {
                qz7Var.a = bdUniqueId;
            }
            pz7 pz7Var = this.s;
            if (pz7Var != null) {
                pz7Var.a = bdUniqueId;
            }
            oz7 oz7Var = this.t;
            if (oz7Var != null) {
                oz7Var.a = bdUniqueId;
            }
            vz7 vz7Var = this.w;
            if (vz7Var != null) {
                vz7Var.b = bdUniqueId;
            }
            i08 i08Var = this.u;
            if (i08Var != null) {
                i08Var.a = bdUniqueId;
            }
            jz7 jz7Var = this.e;
            if (jz7Var != null) {
                jz7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            j08 j08Var = this.G;
            if (j08Var != null) {
                j08Var.a = bdUniqueId;
            }
            f08 f08Var = this.y;
            if (f08Var != null) {
                f08Var.b = bdUniqueId;
            }
            e08 e08Var = this.z;
            if (e08Var != null) {
                e08Var.b = bdUniqueId;
            }
            d08 d08Var = this.B;
            if (d08Var != null) {
                d08Var.b = bdUniqueId;
            }
            g08 g08Var = this.A;
            if (g08Var != null) {
                g08Var.b = bdUniqueId;
            }
            xz7 xz7Var2 = this.C;
            if (xz7Var2 != null) {
                xz7Var2.b = bdUniqueId;
            }
            a08 a08Var = this.D;
            if (a08Var != null) {
                a08Var.a = bdUniqueId;
            }
            c08 c08Var = this.E;
            if (c08Var != null) {
                c08Var.a = bdUniqueId;
            }
            mz7 mz7Var = this.F;
            if (mz7Var != null) {
                mz7Var.b = bdUniqueId;
            }
            nz7 nz7Var = this.v;
            if (nz7Var != null) {
                nz7Var.a = bdUniqueId;
            }
            xv7 xv7Var = this.H;
            if (xv7Var != null) {
                xv7Var.b = bdUniqueId;
            }
            yv7 yv7Var = this.I;
            if (yv7Var != null) {
                yv7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (in inVar : this.R) {
                    if (inVar instanceof no8) {
                        ((no8) inVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (!this.f1136T) {
                this.V.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.V);
            }
        }
    }

    public void x(e18 e18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, e18Var) == null) {
            this.h.E(e18Var);
            this.i.D(e18Var);
            this.j.B(e18Var);
            this.l.B(e18Var);
            this.m.D(e18Var);
            this.q.B(e18Var);
            this.r.B(e18Var);
            this.s.B(e18Var);
            this.t.B(e18Var);
            this.u.E(e18Var);
            this.v.C(e18Var);
        }
    }
}
