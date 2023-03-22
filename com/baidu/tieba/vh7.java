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
public class vh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nh7 A;
    public ph7 B;
    public mh7 C;
    public fh7 D;
    public ih7 E;
    public jh7 F;
    public lh7 G;
    public ug7 H;
    public sh7 I;
    public fd7 J;
    public gd7 K;
    public sg7 L;
    public tm M;
    public tm N;
    public tm O;
    public tm P;
    public tm Q;
    public tm R;
    public tm S;
    public List<tm> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<tm> a;
    public CustomMessageListener a0;
    public mn b;
    public List<gn> c;
    public TbPageContext<?> d;
    public rg7 e;
    public th7 f;
    public tg7 g;
    public fh7 h;
    public qh7 i;
    public zg7 j;
    public ah7 k;
    public bh7 l;
    public kh7 m;
    public ch7 n;
    public hh7 o;
    public eh7 p;
    public gh7 q;
    public yg7 r;
    public xg7 s;
    public wg7 t;
    public rh7 u;
    public vg7 v;
    public dh7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public oh7 z;

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
        public final /* synthetic */ vh7 b;

        public a(vh7 vh7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vh7Var;
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
        public final /* synthetic */ vh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vh7 vh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh7Var, Integer.valueOf(i)};
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
            this.a = vh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    vh7 vh7Var = this.a;
                    vh7Var.y(vh7Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vh7 vh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh7Var, Integer.valueOf(i)};
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
            this.a = vh7Var;
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
        public final /* synthetic */ vh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vh7 vh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh7Var, Integer.valueOf(i)};
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
            this.a = vh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                k48 k48Var = new k48();
                k48Var.a = String.valueOf(customResponsedMessage.getData());
                k48Var.b = true;
                this.a.g(k48Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(vh7 vh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh7Var, Integer.valueOf(i)};
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
            this.a = vh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                k48 k48Var = new k48();
                k48Var.a = String.valueOf(customResponsedMessage.getData());
                k48Var.b = false;
                this.a.g(k48Var);
            }
        }
    }

    public vh7(Context context, mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.X = new b(this, 2016470);
        this.Y = new c(this, 2001115);
        this.Z = new d(this, 2001335);
        this.a0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = mnVar;
        this.d = (TbPageContext) g9.a(context);
        j(context);
        x(mnVar);
        mnVar.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (tm tmVar : list) {
            if (tmVar instanceof jx5) {
                ((jx5) tmVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (tm tmVar : this.a) {
                if (tmVar instanceof vb7) {
                    ((vb7) tmVar).s(aVar);
                }
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public void y(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            ab9.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.V = f();
        }
    }

    public List<gn> h() {
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
        mn mnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (mnVar = this.b) != null) {
            mnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        rh7 rh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rh7Var = this.u) != null) {
            rh7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rh7 rh7Var = this.u;
            if (rh7Var != null) {
                rh7Var.onResume();
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
            List<tm> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = ab9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                n38 b2 = s48.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                fh7 fh7Var = this.h;
                if (fh7Var != null && (bdUniqueId = fh7Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.T.add(b2);
            }
            this.b.addAdapters(this.T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<gn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (gn gnVar : list) {
                if ((gnVar instanceof ICardInfo) && ((ICardInfo) gnVar).responseAttention(obj)) {
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
            fh7 fh7Var = this.h;
            if (fh7Var != null) {
                fh7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            bh7 bh7Var = this.l;
            if (bh7Var != null) {
                bh7Var.setFromCDN(z);
            }
            vg7 vg7Var = this.v;
            if (vg7Var != null) {
                vg7Var.setFromCDN(z);
            }
            tm tmVar = this.N;
            if (tmVar != null && (tmVar instanceof b19)) {
                ((b19) tmVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new rg7(this.d);
            this.f = new th7(this.d);
            this.g = new tg7(this.d, ci7.b);
            this.h = new fh7(this.d, ag6.j0);
            this.i = new qh7(this.d, ag6.C0);
            this.j = new zg7(this.d, ag6.K0);
            this.k = new ah7(this.d, ag6.D0);
            this.l = new bh7(this.d, ag6.L0);
            this.m = new kh7(this.d, ag6.J0);
            this.n = new ch7(this.d, ag6.M0);
            this.o = new hh7(this.d, ag6.N0);
            this.p = new eh7(this.d, ag6.O0);
            this.q = new gh7(this.d, ag6.P0);
            this.r = new yg7(this.d, ag6.E0);
            this.s = new xg7(this.d, ag6.F0);
            this.t = new wg7(this.d, ag6.G0);
            this.u = new rh7(this.d, bg6.U);
            this.w = new dh7(this.d, ag6.s0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, zf6.Q0);
            this.I = new sh7(this.d, ag6.I0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, zf6.R0);
            this.z = new oh7(this.d, ag6.t0);
            this.A = new nh7(this.d, ag6.u0);
            this.B = new ph7(this.d, ag6.w0);
            this.C = new mh7(this.d, ag6.v0);
            this.D = new fh7(this.d, ag6.r0);
            this.E = new ih7(this.d, ag6.x0);
            this.F = new jh7(this.d, ag6.y0);
            this.G = new lh7(this.d, el7.d0);
            this.H = new ug7(this.d, vf6.Q0);
            this.v = new vg7(this.d, ag6.H0);
            this.J = new fd7(this.d, ag6.z0, (byte) 3);
            this.K = new gd7(this.d, ag6.A0, (byte) 3);
            this.L = new sg7(this.d, py5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, ni7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new uh7(this.d, ei7.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.I);
            this.a.add(this.L);
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
            this.M = f19.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = f19.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = f19.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = f19.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = f19.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = f19.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = f19.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ha7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ha7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            fh7 fh7Var = this.h;
            if (fh7Var != null) {
                fh7Var.D(bVar);
            }
            kh7 kh7Var = this.m;
            if (kh7Var != null) {
                kh7Var.C(bVar);
            }
            ah7 ah7Var = this.k;
            if (ah7Var != null) {
                ah7Var.A(bVar);
            }
            dh7 dh7Var = this.w;
            if (dh7Var != null) {
                dh7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.z(bVar);
            }
            oh7 oh7Var = this.z;
            if (oh7Var != null) {
                oh7Var.z(bVar);
            }
            nh7 nh7Var = this.A;
            if (nh7Var != null) {
                nh7Var.E(bVar);
            }
            mh7 mh7Var = this.C;
            if (mh7Var != null) {
                mh7Var.B(bVar);
            }
            ph7 ph7Var = this.B;
            if (ph7Var != null) {
                ph7Var.C(bVar);
            }
            fh7 fh7Var2 = this.D;
            if (fh7Var2 != null) {
                fh7Var2.D(bVar);
            }
            ih7 ih7Var = this.E;
            if (ih7Var != null) {
                ih7Var.C(bVar);
            }
            jh7 jh7Var = this.F;
            if (jh7Var != null) {
                jh7Var.B(bVar);
            }
            lh7 lh7Var = this.G;
            if (lh7Var != null) {
                lh7Var.x(bVar);
            }
            ug7 ug7Var = this.H;
            if (ug7Var != null) {
                ug7Var.B(bVar);
            }
        }
    }

    public final void x(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mnVar) == null) {
            this.i.E(mnVar);
            this.j.C(mnVar);
            this.k.B(mnVar);
            this.l.C(mnVar);
            this.m.E(mnVar);
            this.n.u(mnVar);
            this.o.x(mnVar);
            this.p.u(mnVar);
            this.q.C(mnVar);
            this.r.C(mnVar);
            this.s.C(mnVar);
            this.t.C(mnVar);
            this.v.D(mnVar);
            this.u.F(mnVar);
            this.H.C(mnVar);
            this.A.F(mnVar);
            this.A.F(mnVar);
            this.C.C(mnVar);
            this.J.u(mnVar);
            this.K.u(mnVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            tg7 tg7Var = this.g;
            if (tg7Var != null) {
                tg7Var.u(bdUniqueId);
            }
            fh7 fh7Var = this.h;
            if (fh7Var != null) {
                fh7Var.b = bdUniqueId;
            }
            qh7 qh7Var = this.i;
            if (qh7Var != null) {
                qh7Var.b = bdUniqueId;
            }
            zg7 zg7Var = this.j;
            if (zg7Var != null) {
                zg7Var.a = bdUniqueId;
            }
            ah7 ah7Var = this.k;
            if (ah7Var != null) {
                ah7Var.a = bdUniqueId;
            }
            bh7 bh7Var = this.l;
            if (bh7Var != null) {
                bh7Var.a = bdUniqueId;
            }
            kh7 kh7Var = this.m;
            if (kh7Var != null) {
                kh7Var.a = bdUniqueId;
            }
            ch7 ch7Var = this.n;
            if (ch7Var != null) {
                ch7Var.a = bdUniqueId;
            }
            hh7 hh7Var = this.o;
            if (hh7Var != null) {
                hh7Var.a = bdUniqueId;
            }
            eh7 eh7Var = this.p;
            if (eh7Var != null) {
                eh7Var.a = bdUniqueId;
            }
            gh7 gh7Var = this.q;
            if (gh7Var != null) {
                gh7Var.a = bdUniqueId;
            }
            yg7 yg7Var = this.r;
            if (yg7Var != null) {
                yg7Var.a = bdUniqueId;
            }
            xg7 xg7Var = this.s;
            if (xg7Var != null) {
                xg7Var.a = bdUniqueId;
            }
            wg7 wg7Var = this.t;
            if (wg7Var != null) {
                wg7Var.a = bdUniqueId;
            }
            dh7 dh7Var = this.w;
            if (dh7Var != null) {
                dh7Var.b = bdUniqueId;
            }
            rh7 rh7Var = this.u;
            if (rh7Var != null) {
                rh7Var.a = bdUniqueId;
            }
            rg7 rg7Var = this.e;
            if (rg7Var != null) {
                rg7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            sh7 sh7Var = this.I;
            if (sh7Var != null) {
                sh7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            oh7 oh7Var = this.z;
            if (oh7Var != null) {
                oh7Var.b = bdUniqueId;
            }
            nh7 nh7Var = this.A;
            if (nh7Var != null) {
                nh7Var.b = bdUniqueId;
            }
            mh7 mh7Var = this.C;
            if (mh7Var != null) {
                mh7Var.b = bdUniqueId;
            }
            ph7 ph7Var = this.B;
            if (ph7Var != null) {
                ph7Var.b = bdUniqueId;
            }
            fh7 fh7Var2 = this.D;
            if (fh7Var2 != null) {
                fh7Var2.b = bdUniqueId;
            }
            ih7 ih7Var = this.E;
            if (ih7Var != null) {
                ih7Var.a = bdUniqueId;
            }
            jh7 jh7Var = this.F;
            if (jh7Var != null) {
                jh7Var.a = bdUniqueId;
            }
            lh7 lh7Var = this.G;
            if (lh7Var != null) {
                lh7Var.a = bdUniqueId;
            }
            ug7 ug7Var = this.H;
            if (ug7Var != null) {
                ug7Var.b = bdUniqueId;
            }
            vg7 vg7Var = this.v;
            if (vg7Var != null) {
                vg7Var.a = bdUniqueId;
            }
            fd7 fd7Var = this.J;
            if (fd7Var != null) {
                fd7Var.b = bdUniqueId;
            }
            gd7 gd7Var = this.K;
            if (gd7Var != null) {
                gd7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (tm tmVar : this.T) {
                    if (tmVar instanceof n38) {
                        ((n38) tmVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            this.a0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
            if (!this.V) {
                this.X.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.X);
            }
        }
    }

    public void w(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ki7Var) == null) {
            this.h.E(ki7Var);
            this.i.D(ki7Var);
            this.j.B(ki7Var);
            this.l.B(ki7Var);
            this.m.D(ki7Var);
            this.q.B(ki7Var);
            this.r.B(ki7Var);
            this.s.B(ki7Var);
            this.t.B(ki7Var);
            this.u.E(ki7Var);
            this.v.C(ki7Var);
        }
    }

    public void z(List<gn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            ab9.f(list, 2);
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
            ng.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
