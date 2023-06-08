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
/* loaded from: classes7.dex */
public class o08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i08 A;
    public f08 B;
    public zz7 C;
    public c08 D;
    public e08 E;
    public oz7 F;
    public l08 G;
    public zv7 H;
    public aw7 I;
    public mz7 J;
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
    public boolean f1143T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<in> a;
    public bo b;
    public List<vn> c;
    public TbPageContext<?> d;
    public lz7 e;
    public m08 f;
    public nz7 g;
    public zz7 h;
    public j08 i;
    public tz7 j;
    public uz7 k;
    public vz7 l;
    public d08 m;
    public wz7 n;
    public b08 o;
    public yz7 p;
    public a08 q;
    public sz7 r;
    public rz7 s;
    public qz7 t;
    public k08 u;
    public pz7 v;
    public xz7 w;
    public HomePageAlaLiveThreadAdapter x;
    public h08 y;
    public g08 z;

    /* loaded from: classes7.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ o08 b;

        public a(o08 o08Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o08Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o08Var;
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

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o08 o08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o08Var, Integer.valueOf(i)};
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
            this.a = o08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    o08 o08Var = this.a;
                    o08Var.z(o08Var.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(o08 o08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o08Var, Integer.valueOf(i)};
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
            this.a = o08Var;
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(o08 o08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o08Var, Integer.valueOf(i)};
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
            this.a = o08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                np8 np8Var = new np8();
                np8Var.a = String.valueOf(customResponsedMessage.getData());
                np8Var.b = true;
                this.a.g(np8Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(o08 o08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o08Var, Integer.valueOf(i)};
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
            this.a = o08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                np8 np8Var = new np8();
                np8Var.a = String.valueOf(customResponsedMessage.getData());
                np8Var.b = false;
                this.a.g(np8Var);
            }
        }
    }

    public o08(Context context, bo boVar) {
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
            if (inVar instanceof f56) {
                ((f56) inVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            for (in inVar : this.a) {
                if (inVar instanceof qu7) {
                    ((qu7) inVar).s(aVar);
                }
            }
        }
    }

    public void s(dz7 dz7Var) {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, dz7Var) == null) && (uz7Var = this.k) != null) {
            uz7Var.B(dz7Var);
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
            ix9.f(list, 2);
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
            ix9.f(list, 2);
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
            this.f1143T = f();
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
        k08 k08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (k08Var = this.u) != null) {
            k08Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            k08 k08Var = this.u;
            if (k08Var != null) {
                k08Var.onResume();
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
            ArrayList<BdUniqueId> g = ix9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                qo8 b2 = vp8.d().b(this.d, g.get(i), 2);
                if (this.S) {
                    b2.s(3);
                }
                zz7 zz7Var = this.h;
                if (zz7Var != null && (bdUniqueId = zz7Var.b) != null) {
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
            zz7 zz7Var = this.h;
            if (zz7Var != null) {
                zz7Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            vz7 vz7Var = this.l;
            if (vz7Var != null) {
                vz7Var.setFromCDN(z);
            }
            pz7 pz7Var = this.v;
            if (pz7Var != null) {
                pz7Var.setFromCDN(z);
            }
            in inVar = this.L;
            if (inVar != null && (inVar instanceof em9)) {
                ((em9) inVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.e = new lz7(this.d);
            this.f = new m08(this.d);
            this.g = new nz7(this.d, w08.b);
            this.h = new zz7(this.d, wo6.r0);
            this.i = new j08(this.d, wo6.C0);
            this.j = new tz7(this.d, wo6.K0);
            this.k = new uz7(this.d, wo6.D0);
            this.l = new vz7(this.d, wo6.L0);
            this.m = new d08(this.d, wo6.J0);
            this.n = new wz7(this.d, wo6.M0);
            this.o = new b08(this.d, wo6.N0);
            this.p = new yz7(this.d, wo6.O0);
            this.q = new a08(this.d, wo6.P0);
            this.r = new sz7(this.d, wo6.E0);
            this.s = new rz7(this.d, wo6.F0);
            this.t = new qz7(this.d, wo6.G0);
            this.u = new k08(this.d, xo6.U);
            this.w = new xz7(this.d, wo6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, vo6.Q0);
            this.G = new l08(this.d, wo6.I0);
            this.y = new h08(this.d, wo6.u0);
            this.z = new g08(this.d, wo6.v0);
            this.A = new i08(this.d, wo6.x0);
            this.B = new f08(this.d, wo6.w0);
            this.C = new zz7(this.d, wo6.s0);
            this.D = new c08(this.d, wo6.y0);
            this.E = new e08(this.d, d48.d0);
            this.F = new oz7(this.d, ro6.Q0);
            this.v = new pz7(this.d, wo6.H0);
            this.H = new zv7(this.d, wo6.z0, (byte) 3);
            this.I = new aw7(this.d, wo6.A0, (byte) 3);
            this.J = new mz7(this.d, m66.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, j18.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new n08(this.d, z08.h));
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
            this.K = jm9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = jm9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = jm9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = jm9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = jm9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = jm9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = jm9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ts7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ts7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            zz7 zz7Var = this.h;
            if (zz7Var != null) {
                zz7Var.D(bVar);
            }
            d08 d08Var = this.m;
            if (d08Var != null) {
                d08Var.C(bVar);
            }
            uz7 uz7Var = this.k;
            if (uz7Var != null) {
                uz7Var.A(bVar);
            }
            xz7 xz7Var = this.w;
            if (xz7Var != null) {
                xz7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            h08 h08Var = this.y;
            if (h08Var != null) {
                h08Var.z(bVar);
            }
            g08 g08Var = this.z;
            if (g08Var != null) {
                g08Var.E(bVar);
            }
            f08 f08Var = this.B;
            if (f08Var != null) {
                f08Var.B(bVar);
            }
            i08 i08Var = this.A;
            if (i08Var != null) {
                i08Var.C(bVar);
            }
            zz7 zz7Var2 = this.C;
            if (zz7Var2 != null) {
                zz7Var2.D(bVar);
            }
            c08 c08Var = this.D;
            if (c08Var != null) {
                c08Var.C(bVar);
            }
            e08 e08Var = this.E;
            if (e08Var != null) {
                e08Var.x(bVar);
            }
            oz7 oz7Var = this.F;
            if (oz7Var != null) {
                oz7Var.B(bVar);
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
            nz7 nz7Var = this.g;
            if (nz7Var != null) {
                nz7Var.u(bdUniqueId);
            }
            zz7 zz7Var = this.h;
            if (zz7Var != null) {
                zz7Var.b = bdUniqueId;
            }
            j08 j08Var = this.i;
            if (j08Var != null) {
                j08Var.b = bdUniqueId;
            }
            tz7 tz7Var = this.j;
            if (tz7Var != null) {
                tz7Var.a = bdUniqueId;
            }
            uz7 uz7Var = this.k;
            if (uz7Var != null) {
                uz7Var.a = bdUniqueId;
            }
            vz7 vz7Var = this.l;
            if (vz7Var != null) {
                vz7Var.a = bdUniqueId;
            }
            d08 d08Var = this.m;
            if (d08Var != null) {
                d08Var.a = bdUniqueId;
            }
            wz7 wz7Var = this.n;
            if (wz7Var != null) {
                wz7Var.a = bdUniqueId;
            }
            b08 b08Var = this.o;
            if (b08Var != null) {
                b08Var.a = bdUniqueId;
            }
            yz7 yz7Var = this.p;
            if (yz7Var != null) {
                yz7Var.a = bdUniqueId;
            }
            a08 a08Var = this.q;
            if (a08Var != null) {
                a08Var.a = bdUniqueId;
            }
            sz7 sz7Var = this.r;
            if (sz7Var != null) {
                sz7Var.a = bdUniqueId;
            }
            rz7 rz7Var = this.s;
            if (rz7Var != null) {
                rz7Var.a = bdUniqueId;
            }
            qz7 qz7Var = this.t;
            if (qz7Var != null) {
                qz7Var.a = bdUniqueId;
            }
            xz7 xz7Var = this.w;
            if (xz7Var != null) {
                xz7Var.b = bdUniqueId;
            }
            k08 k08Var = this.u;
            if (k08Var != null) {
                k08Var.a = bdUniqueId;
            }
            lz7 lz7Var = this.e;
            if (lz7Var != null) {
                lz7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            l08 l08Var = this.G;
            if (l08Var != null) {
                l08Var.a = bdUniqueId;
            }
            h08 h08Var = this.y;
            if (h08Var != null) {
                h08Var.b = bdUniqueId;
            }
            g08 g08Var = this.z;
            if (g08Var != null) {
                g08Var.b = bdUniqueId;
            }
            f08 f08Var = this.B;
            if (f08Var != null) {
                f08Var.b = bdUniqueId;
            }
            i08 i08Var = this.A;
            if (i08Var != null) {
                i08Var.b = bdUniqueId;
            }
            zz7 zz7Var2 = this.C;
            if (zz7Var2 != null) {
                zz7Var2.b = bdUniqueId;
            }
            c08 c08Var = this.D;
            if (c08Var != null) {
                c08Var.a = bdUniqueId;
            }
            e08 e08Var = this.E;
            if (e08Var != null) {
                e08Var.a = bdUniqueId;
            }
            oz7 oz7Var = this.F;
            if (oz7Var != null) {
                oz7Var.b = bdUniqueId;
            }
            pz7 pz7Var = this.v;
            if (pz7Var != null) {
                pz7Var.a = bdUniqueId;
            }
            zv7 zv7Var = this.H;
            if (zv7Var != null) {
                zv7Var.b = bdUniqueId;
            }
            aw7 aw7Var = this.I;
            if (aw7Var != null) {
                aw7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (in inVar : this.R) {
                    if (inVar instanceof qo8) {
                        ((qo8) inVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (!this.f1143T) {
                this.V.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.V);
            }
        }
    }

    public void x(g18 g18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, g18Var) == null) {
            this.h.E(g18Var);
            this.i.D(g18Var);
            this.j.B(g18Var);
            this.l.B(g18Var);
            this.m.D(g18Var);
            this.q.B(g18Var);
            this.r.B(g18Var);
            this.s.B(g18Var);
            this.t.B(g18Var);
            this.u.E(g18Var);
            this.v.C(g18Var);
        }
    }
}
