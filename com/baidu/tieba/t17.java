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
public class t17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l17 A;
    public n17 B;
    public k17 C;
    public d17 D;
    public g17 E;
    public h17 F;
    public j17 G;
    public s07 H;
    public q17 I;
    public hx6 J;
    public qn K;
    public qn L;
    public qn M;
    public qn N;
    public qn O;
    public qn P;
    public qn Q;
    public List<qn> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<qn> a;
    public jo b;
    public List<Cdo> c;
    public TbPageContext<?> d;
    public q07 e;
    public r17 f;
    public r07 g;
    public d17 h;
    public o17 i;
    public x07 j;
    public y07 k;
    public z07 l;
    public i17 m;
    public a17 n;
    public f17 o;
    public c17 p;
    public e17 q;
    public w07 r;
    public v07 s;
    public u07 t;
    public p17 u;
    public t07 v;
    public b17 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public m17 z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ t17 b;

        public a(t17 t17Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t17Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t17Var;
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
        public final /* synthetic */ t17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t17 t17Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t17Var, Integer.valueOf(i)};
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
            this.a = t17Var;
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
                t17 t17Var = this.a;
                t17Var.y(t17Var.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(t17 t17Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t17Var, Integer.valueOf(i)};
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
            this.a = t17Var;
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(t17 t17Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t17Var, Integer.valueOf(i)};
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
            this.a = t17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                bh7 bh7Var = new bh7();
                bh7Var.a = String.valueOf(customResponsedMessage.getData());
                bh7Var.b = true;
                this.a.g(bh7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(t17 t17Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t17Var, Integer.valueOf(i)};
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
            this.a = t17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                bh7 bh7Var = new bh7();
                bh7Var.a = String.valueOf(customResponsedMessage.getData());
                bh7Var.b = false;
                this.a.g(bh7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public t17(Context context, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, joVar};
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
        this.b = joVar;
        this.d = (TbPageContext) w9.a(context);
        j(context);
        x(joVar);
        joVar.a(this.a);
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
            List<qn> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = ul8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    eg7 b2 = jh7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.s(3);
                    }
                    d17 d17Var = this.h;
                    if (d17Var != null && (bdUniqueId = d17Var.b) != null) {
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
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (Cdo cdo : list) {
            if ((cdo instanceof ICardInfo) && ((ICardInfo) cdo).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            l();
        }
    }

    public List<Cdo> h() {
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
            this.e = new q07(this.d);
            this.f = new r17(this.d);
            this.g = new r07(this.d, b27.b);
            this.h = new d17(this.d, k26.i0);
            this.i = new o17(this.d, k26.z0);
            this.j = new x07(this.d, k26.H0);
            this.k = new y07(this.d, k26.A0);
            this.l = new z07(this.d, k26.I0);
            this.m = new i17(this.d, k26.G0);
            this.n = new a17(this.d, k26.J0);
            this.o = new f17(this.d, k26.K0);
            this.p = new c17(this.d, k26.L0);
            this.q = new e17(this.d, k26.M0);
            this.r = new w07(this.d, k26.B0);
            this.s = new v07(this.d, k26.C0);
            this.t = new u07(this.d, k26.D0);
            this.u = new p17(this.d, l26.U);
            this.w = new b17(this.d, k26.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, j26.N0);
            this.I = new q17(this.d, k26.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, j26.O0);
            this.z = new m17(this.d, k26.r0);
            this.A = new l17(this.d, k26.s0);
            this.B = new n17(this.d, k26.u0);
            this.C = new k17(this.d, k26.t0);
            this.D = new d17(this.d, k26.j0);
            this.E = new g17(this.d, k26.v0);
            this.F = new h17(this.d, k26.w0);
            this.G = new j17(this.d, b57.d0);
            this.H = new s07(this.d, f26.N0);
            this.v = new t07(this.d, k26.E0);
            this.J = new hx6(this.d, k26.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, n27.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new s17(this.d, d27.e));
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
            this.K = md8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = md8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = md8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = md8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = md8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = md8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = md8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ju6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ju6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void l() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (joVar = this.b) == null) {
            return;
        }
        joVar.getListAdapter().notifyDataSetChanged();
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
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (p17Var = this.u) == null) {
            return;
        }
        p17Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p17 p17Var = this.u;
            if (p17Var != null) {
                p17Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            l();
        }
    }

    public final void q(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof go5) {
                ((go5) qnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof xv6) {
                    ((xv6) qnVar).s(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            d17 d17Var = this.h;
            if (d17Var != null) {
                d17Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            z07 z07Var = this.l;
            if (z07Var != null) {
                z07Var.setFromCDN(z);
            }
            t07 t07Var = this.v;
            if (t07Var != null) {
                t07Var.setFromCDN(z);
            }
            qn qnVar = this.L;
            if (qnVar == null || !(qnVar instanceof id8)) {
                return;
            }
            ((id8) qnVar).setIsFromCDN(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            d17 d17Var = this.h;
            if (d17Var != null) {
                d17Var.B(bVar);
            }
            i17 i17Var = this.m;
            if (i17Var != null) {
                i17Var.A(bVar);
            }
            y07 y07Var = this.k;
            if (y07Var != null) {
                y07Var.y(bVar);
            }
            b17 b17Var = this.w;
            if (b17Var != null) {
                b17Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            m17 m17Var = this.z;
            if (m17Var != null) {
                m17Var.x(bVar);
            }
            l17 l17Var = this.A;
            if (l17Var != null) {
                l17Var.C(bVar);
            }
            k17 k17Var = this.C;
            if (k17Var != null) {
                k17Var.z(bVar);
            }
            n17 n17Var = this.B;
            if (n17Var != null) {
                n17Var.A(bVar);
            }
            d17 d17Var2 = this.D;
            if (d17Var2 != null) {
                d17Var2.B(bVar);
            }
            g17 g17Var = this.E;
            if (g17Var != null) {
                g17Var.A(bVar);
            }
            h17 h17Var = this.F;
            if (h17Var != null) {
                h17Var.z(bVar);
            }
            j17 j17Var = this.G;
            if (j17Var != null) {
                j17Var.v(bVar);
            }
            s07 s07Var = this.H;
            if (s07Var != null) {
                s07Var.z(bVar);
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
            r07 r07Var = this.g;
            if (r07Var != null) {
                r07Var.u(bdUniqueId);
            }
            d17 d17Var = this.h;
            if (d17Var != null) {
                d17Var.b = bdUniqueId;
            }
            o17 o17Var = this.i;
            if (o17Var != null) {
                o17Var.b = bdUniqueId;
            }
            x07 x07Var = this.j;
            if (x07Var != null) {
                x07Var.a = bdUniqueId;
            }
            y07 y07Var = this.k;
            if (y07Var != null) {
                y07Var.a = bdUniqueId;
            }
            z07 z07Var = this.l;
            if (z07Var != null) {
                z07Var.a = bdUniqueId;
            }
            i17 i17Var = this.m;
            if (i17Var != null) {
                i17Var.a = bdUniqueId;
            }
            a17 a17Var = this.n;
            if (a17Var != null) {
                a17Var.a = bdUniqueId;
            }
            f17 f17Var = this.o;
            if (f17Var != null) {
                f17Var.a = bdUniqueId;
            }
            c17 c17Var = this.p;
            if (c17Var != null) {
                c17Var.a = bdUniqueId;
            }
            e17 e17Var = this.q;
            if (e17Var != null) {
                e17Var.a = bdUniqueId;
            }
            w07 w07Var = this.r;
            if (w07Var != null) {
                w07Var.a = bdUniqueId;
            }
            v07 v07Var = this.s;
            if (v07Var != null) {
                v07Var.a = bdUniqueId;
            }
            u07 u07Var = this.t;
            if (u07Var != null) {
                u07Var.a = bdUniqueId;
            }
            b17 b17Var = this.w;
            if (b17Var != null) {
                b17Var.b = bdUniqueId;
            }
            p17 p17Var = this.u;
            if (p17Var != null) {
                p17Var.a = bdUniqueId;
            }
            q07 q07Var = this.e;
            if (q07Var != null) {
                q07Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            q17 q17Var = this.I;
            if (q17Var != null) {
                q17Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            m17 m17Var = this.z;
            if (m17Var != null) {
                m17Var.b = bdUniqueId;
            }
            l17 l17Var = this.A;
            if (l17Var != null) {
                l17Var.b = bdUniqueId;
            }
            k17 k17Var = this.C;
            if (k17Var != null) {
                k17Var.b = bdUniqueId;
            }
            n17 n17Var = this.B;
            if (n17Var != null) {
                n17Var.b = bdUniqueId;
            }
            d17 d17Var2 = this.D;
            if (d17Var2 != null) {
                d17Var2.b = bdUniqueId;
            }
            g17 g17Var = this.E;
            if (g17Var != null) {
                g17Var.a = bdUniqueId;
            }
            h17 h17Var = this.F;
            if (h17Var != null) {
                h17Var.a = bdUniqueId;
            }
            j17 j17Var = this.G;
            if (j17Var != null) {
                j17Var.a = bdUniqueId;
            }
            s07 s07Var = this.H;
            if (s07Var != null) {
                s07Var.b = bdUniqueId;
            }
            t07 t07Var = this.v;
            if (t07Var != null) {
                t07Var.a = bdUniqueId;
            }
            hx6 hx6Var = this.J;
            if (hx6Var != null) {
                hx6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (qn qnVar : this.R) {
                    if (qnVar instanceof eg7) {
                        ((eg7) qnVar).setUniqueId(bdUniqueId);
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

    public void w(k27 k27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, k27Var) == null) {
            this.h.C(k27Var);
            this.i.B(k27Var);
            this.j.z(k27Var);
            this.l.z(k27Var);
            this.m.B(k27Var);
            this.q.z(k27Var);
            this.r.z(k27Var);
            this.s.z(k27Var);
            this.t.z(k27Var);
            this.u.C(k27Var);
            this.v.A(k27Var);
        }
    }

    public final void x(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, joVar) == null) {
            this.i.C(joVar);
            this.j.A(joVar);
            this.k.z(joVar);
            this.l.A(joVar);
            this.m.C(joVar);
            this.n.u(joVar);
            this.o.v(joVar);
            this.p.u(joVar);
            this.q.A(joVar);
            this.r.A(joVar);
            this.s.A(joVar);
            this.t.A(joVar);
            this.v.B(joVar);
            this.u.D(joVar);
            this.H.A(joVar);
            this.A.D(joVar);
            this.A.D(joVar);
            this.C.A(joVar);
            this.J.u(joVar);
        }
    }

    public void y(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            ul8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void z(List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            ul8.f(list, 2);
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
            kh.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
