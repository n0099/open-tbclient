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
/* loaded from: classes5.dex */
public class p27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h27 A;
    public j27 B;
    public g27 C;
    public z17 D;
    public c27 E;
    public d27 F;
    public f27 G;
    public o17 H;
    public m27 I;
    public cy6 J;
    public rn K;
    public rn L;
    public rn M;
    public rn N;
    public rn O;
    public rn P;
    public rn Q;
    public List R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List a;
    public ko b;
    public List c;
    public TbPageContext d;
    public m17 e;
    public n27 f;
    public n17 g;
    public z17 h;
    public k27 i;
    public t17 j;
    public u17 k;
    public v17 l;
    public e27 m;
    public w17 n;
    public b27 o;
    public y17 p;
    public a27 q;
    public s17 r;
    public r17 s;
    public q17 t;
    public l27 u;
    public p17 v;
    public x17 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public i27 z;

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ p27 b;

        public a(p27 p27Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p27Var;
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

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p27 p27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var, Integer.valueOf(i)};
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
            this.a = p27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    p27 p27Var = this.a;
                    p27Var.y(p27Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(p27 p27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var, Integer.valueOf(i)};
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
            this.a = p27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !((UpdateAttentionMessage.a) updateAttentionMessage.getData()).a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(p27 p27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var, Integer.valueOf(i)};
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
            this.a = p27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ai7 ai7Var = new ai7();
                ai7Var.a = String.valueOf(customResponsedMessage.getData());
                ai7Var.b = true;
                this.a.g(ai7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(p27 p27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var, Integer.valueOf(i)};
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
            this.a = p27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ai7 ai7Var = new ai7();
                ai7Var.a = String.valueOf(customResponsedMessage.getData());
                ai7Var.b = false;
                this.a.g(ai7Var);
            }
        }
    }

    public p27(Context context, ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, koVar};
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
        this.b = koVar;
        this.d = (TbPageContext) w9.a(context);
        j(context);
        x(koVar);
        koVar.a(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (rn rnVar : list) {
            if (rnVar instanceof ap5) {
                ((ap5) rnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (rn rnVar : this.a) {
                if (rnVar instanceof sw6) {
                    ((sw6) rnVar).s(aVar);
                }
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void y(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            qm8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.T = f();
        }
    }

    public List h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void l() {
        ko koVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (koVar = this.b) != null) {
            koVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        l27 l27Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (l27Var = this.u) != null) {
            l27Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            l27 l27Var = this.u;
            if (l27Var != null) {
                l27Var.onResume();
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
            List list = this.R;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.R = new ArrayList();
            ArrayList g = qm8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                dh7 b2 = ii7.d().b(this.d, (BdUniqueId) g.get(i), 2);
                if (this.S) {
                    b2.s(3);
                }
                z17 z17Var = this.h;
                if (z17Var != null && (bdUniqueId = z17Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.R.add(b2);
            }
            this.b.a(this.R);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (eo eoVar : list) {
                if ((eoVar instanceof ICardInfo) && ((ICardInfo) eoVar).responseAttention(obj)) {
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
            z17 z17Var = this.h;
            if (z17Var != null) {
                z17Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            v17 v17Var = this.l;
            if (v17Var != null) {
                v17Var.setFromCDN(z);
            }
            p17 p17Var = this.v;
            if (p17Var != null) {
                p17Var.setFromCDN(z);
            }
            rn rnVar = this.L;
            if (rnVar != null && (rnVar instanceof he8)) {
                ((he8) rnVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new m17(this.d);
            this.f = new n27(this.d);
            this.g = new n17(this.d, x27.b);
            this.h = new z17(this.d, e36.i0);
            this.i = new k27(this.d, e36.z0);
            this.j = new t17(this.d, e36.H0);
            this.k = new u17(this.d, e36.A0);
            this.l = new v17(this.d, e36.I0);
            this.m = new e27(this.d, e36.G0);
            this.n = new w17(this.d, e36.J0);
            this.o = new b27(this.d, e36.K0);
            this.p = new y17(this.d, e36.L0);
            this.q = new a27(this.d, e36.M0);
            this.r = new s17(this.d, e36.B0);
            this.s = new r17(this.d, e36.C0);
            this.t = new q17(this.d, e36.D0);
            this.u = new l27(this.d, f36.U);
            this.w = new x17(this.d, e36.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, d36.N0);
            this.I = new m27(this.d, e36.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, d36.O0);
            this.z = new i27(this.d, e36.r0);
            this.A = new h27(this.d, e36.s0);
            this.B = new j27(this.d, e36.u0);
            this.C = new g27(this.d, e36.t0);
            this.D = new z17(this.d, e36.j0);
            this.E = new c27(this.d, e36.v0);
            this.F = new d27(this.d, e36.w0);
            this.G = new f27(this.d, x57.d0);
            this.H = new o17(this.d, z26.N0);
            this.v = new p17(this.d, e36.E0);
            this.J = new cy6(this.d, e36.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, j37.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new o27(this.d, z27.e));
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
            this.K = le8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = le8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = le8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = le8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = le8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = le8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = le8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ev6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ev6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            z17 z17Var = this.h;
            if (z17Var != null) {
                z17Var.B(bVar);
            }
            e27 e27Var = this.m;
            if (e27Var != null) {
                e27Var.A(bVar);
            }
            u17 u17Var = this.k;
            if (u17Var != null) {
                u17Var.y(bVar);
            }
            x17 x17Var = this.w;
            if (x17Var != null) {
                x17Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            i27 i27Var = this.z;
            if (i27Var != null) {
                i27Var.x(bVar);
            }
            h27 h27Var = this.A;
            if (h27Var != null) {
                h27Var.C(bVar);
            }
            g27 g27Var = this.C;
            if (g27Var != null) {
                g27Var.z(bVar);
            }
            j27 j27Var = this.B;
            if (j27Var != null) {
                j27Var.A(bVar);
            }
            z17 z17Var2 = this.D;
            if (z17Var2 != null) {
                z17Var2.B(bVar);
            }
            c27 c27Var = this.E;
            if (c27Var != null) {
                c27Var.A(bVar);
            }
            d27 d27Var = this.F;
            if (d27Var != null) {
                d27Var.z(bVar);
            }
            f27 f27Var = this.G;
            if (f27Var != null) {
                f27Var.v(bVar);
            }
            o17 o17Var = this.H;
            if (o17Var != null) {
                o17Var.z(bVar);
            }
        }
    }

    public final void x(ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, koVar) == null) {
            this.i.C(koVar);
            this.j.A(koVar);
            this.k.z(koVar);
            this.l.A(koVar);
            this.m.C(koVar);
            this.n.u(koVar);
            this.o.v(koVar);
            this.p.u(koVar);
            this.q.A(koVar);
            this.r.A(koVar);
            this.s.A(koVar);
            this.t.A(koVar);
            this.v.B(koVar);
            this.u.D(koVar);
            this.H.A(koVar);
            this.A.D(koVar);
            this.A.D(koVar);
            this.C.A(koVar);
            this.J.u(koVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            n17 n17Var = this.g;
            if (n17Var != null) {
                n17Var.u(bdUniqueId);
            }
            z17 z17Var = this.h;
            if (z17Var != null) {
                z17Var.b = bdUniqueId;
            }
            k27 k27Var = this.i;
            if (k27Var != null) {
                k27Var.b = bdUniqueId;
            }
            t17 t17Var = this.j;
            if (t17Var != null) {
                t17Var.a = bdUniqueId;
            }
            u17 u17Var = this.k;
            if (u17Var != null) {
                u17Var.a = bdUniqueId;
            }
            v17 v17Var = this.l;
            if (v17Var != null) {
                v17Var.a = bdUniqueId;
            }
            e27 e27Var = this.m;
            if (e27Var != null) {
                e27Var.a = bdUniqueId;
            }
            w17 w17Var = this.n;
            if (w17Var != null) {
                w17Var.a = bdUniqueId;
            }
            b27 b27Var = this.o;
            if (b27Var != null) {
                b27Var.a = bdUniqueId;
            }
            y17 y17Var = this.p;
            if (y17Var != null) {
                y17Var.a = bdUniqueId;
            }
            a27 a27Var = this.q;
            if (a27Var != null) {
                a27Var.a = bdUniqueId;
            }
            s17 s17Var = this.r;
            if (s17Var != null) {
                s17Var.a = bdUniqueId;
            }
            r17 r17Var = this.s;
            if (r17Var != null) {
                r17Var.a = bdUniqueId;
            }
            q17 q17Var = this.t;
            if (q17Var != null) {
                q17Var.a = bdUniqueId;
            }
            x17 x17Var = this.w;
            if (x17Var != null) {
                x17Var.b = bdUniqueId;
            }
            l27 l27Var = this.u;
            if (l27Var != null) {
                l27Var.a = bdUniqueId;
            }
            m17 m17Var = this.e;
            if (m17Var != null) {
                m17Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            m27 m27Var = this.I;
            if (m27Var != null) {
                m27Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            i27 i27Var = this.z;
            if (i27Var != null) {
                i27Var.b = bdUniqueId;
            }
            h27 h27Var = this.A;
            if (h27Var != null) {
                h27Var.b = bdUniqueId;
            }
            g27 g27Var = this.C;
            if (g27Var != null) {
                g27Var.b = bdUniqueId;
            }
            j27 j27Var = this.B;
            if (j27Var != null) {
                j27Var.b = bdUniqueId;
            }
            z17 z17Var2 = this.D;
            if (z17Var2 != null) {
                z17Var2.b = bdUniqueId;
            }
            c27 c27Var = this.E;
            if (c27Var != null) {
                c27Var.a = bdUniqueId;
            }
            d27 d27Var = this.F;
            if (d27Var != null) {
                d27Var.a = bdUniqueId;
            }
            f27 f27Var = this.G;
            if (f27Var != null) {
                f27Var.a = bdUniqueId;
            }
            o17 o17Var = this.H;
            if (o17Var != null) {
                o17Var.b = bdUniqueId;
            }
            p17 p17Var = this.v;
            if (p17Var != null) {
                p17Var.a = bdUniqueId;
            }
            cy6 cy6Var = this.J;
            if (cy6Var != null) {
                cy6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (rn rnVar : this.R) {
                    if (rnVar instanceof dh7) {
                        ((dh7) rnVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (!this.T) {
                this.V.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.V);
            }
        }
    }

    public void w(g37 g37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, g37Var) == null) {
            this.h.C(g37Var);
            this.i.B(g37Var);
            this.j.z(g37Var);
            this.l.z(g37Var);
            this.m.B(g37Var);
            this.q.z(g37Var);
            this.r.z(g37Var);
            this.s.z(g37Var);
            this.t.z(g37Var);
            this.u.C(g37Var);
            this.v.A(g37Var);
        }
    }

    public void z(List list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            qm8.f(list, 2);
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
            lh.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
