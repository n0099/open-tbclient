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
public class pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hg7 A;
    public jg7 B;
    public gg7 C;
    public zf7 D;
    public cg7 E;
    public dg7 F;
    public fg7 G;
    public of7 H;
    public mg7 I;
    public zb7 J;
    public ac7 K;
    public mf7 L;
    public qn M;
    public qn N;
    public qn O;
    public qn P;
    public qn Q;
    public qn R;
    public qn S;
    public List<qn> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<qn> a;
    public CustomMessageListener a0;
    public jo b;
    public List<Cdo> c;
    public TbPageContext<?> d;
    public lf7 e;
    public ng7 f;
    public nf7 g;
    public zf7 h;
    public kg7 i;
    public tf7 j;
    public uf7 k;
    public vf7 l;
    public eg7 m;
    public wf7 n;
    public bg7 o;
    public yf7 p;
    public ag7 q;
    public sf7 r;
    public rf7 s;
    public qf7 t;
    public lg7 u;
    public pf7 v;
    public xf7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public ig7 z;

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
        public final /* synthetic */ pg7 b;

        public a(pg7 pg7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pg7Var;
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
        public final /* synthetic */ pg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pg7 pg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg7Var, Integer.valueOf(i)};
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
            this.a = pg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    pg7 pg7Var = this.a;
                    pg7Var.y(pg7Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pg7 pg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg7Var, Integer.valueOf(i)};
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
            this.a = pg7Var;
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(pg7 pg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg7Var, Integer.valueOf(i)};
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
            this.a = pg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                gz7 gz7Var = new gz7();
                gz7Var.a = String.valueOf(customResponsedMessage.getData());
                gz7Var.b = true;
                this.a.g(gz7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(pg7 pg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg7Var, Integer.valueOf(i)};
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
            this.a = pg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                gz7 gz7Var = new gz7();
                gz7Var.a = String.valueOf(customResponsedMessage.getData());
                gz7Var.b = false;
                this.a.g(gz7Var);
            }
        }
    }

    public pg7(Context context, jo joVar) {
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
        this.X = new b(this, 2016470);
        this.Y = new c(this, 2001115);
        this.Z = new d(this, 2001335);
        this.a0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = joVar;
        this.d = (TbPageContext) da.a(context);
        j(context);
        x(joVar);
        joVar.a(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof dy5) {
                ((dy5) qnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof pa7) {
                    ((pa7) qnVar).s(aVar);
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

    public void y(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            v49.f(list, 2);
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

    public List<Cdo> h() {
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
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (joVar = this.b) != null) {
            joVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        lg7 lg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (lg7Var = this.u) != null) {
            lg7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            lg7 lg7Var = this.u;
            if (lg7Var != null) {
                lg7Var.onResume();
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
            List<qn> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = v49.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                jy7 b2 = oz7.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                zf7 zf7Var = this.h;
                if (zf7Var != null && (bdUniqueId = zf7Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.T.add(b2);
            }
            this.b.a(this.T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
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
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            zf7 zf7Var = this.h;
            if (zf7Var != null) {
                zf7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            vf7 vf7Var = this.l;
            if (vf7Var != null) {
                vf7Var.setFromCDN(z);
            }
            pf7 pf7Var = this.v;
            if (pf7Var != null) {
                pf7Var.setFromCDN(z);
            }
            qn qnVar = this.N;
            if (qnVar != null && (qnVar instanceof yv8)) {
                ((yv8) qnVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new lf7(this.d);
            this.f = new ng7(this.d);
            this.g = new nf7(this.d, xg7.b);
            this.h = new zf7(this.d, mg6.i0);
            this.i = new kg7(this.d, mg6.B0);
            this.j = new tf7(this.d, mg6.J0);
            this.k = new uf7(this.d, mg6.C0);
            this.l = new vf7(this.d, mg6.K0);
            this.m = new eg7(this.d, mg6.I0);
            this.n = new wf7(this.d, mg6.L0);
            this.o = new bg7(this.d, mg6.M0);
            this.p = new yf7(this.d, mg6.N0);
            this.q = new ag7(this.d, mg6.O0);
            this.r = new sf7(this.d, mg6.D0);
            this.s = new rf7(this.d, mg6.E0);
            this.t = new qf7(this.d, mg6.F0);
            this.u = new lg7(this.d, ng6.U);
            this.w = new xf7(this.d, mg6.r0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, lg6.P0);
            this.I = new mg7(this.d, mg6.H0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, lg6.Q0);
            this.z = new ig7(this.d, mg6.s0);
            this.A = new hg7(this.d, mg6.t0);
            this.B = new jg7(this.d, mg6.v0);
            this.C = new gg7(this.d, mg6.u0);
            this.D = new zf7(this.d, mg6.j0);
            this.E = new cg7(this.d, mg6.w0);
            this.F = new dg7(this.d, mg6.x0);
            this.G = new fg7(this.d, xj7.d0);
            this.H = new of7(this.d, hg6.P0);
            this.v = new pf7(this.d, mg6.G0);
            this.J = new zb7(this.d, mg6.y0, (byte) 3);
            this.K = new ac7(this.d, mg6.z0, (byte) 3);
            this.L = new mf7(this.d, jz5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, ih7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new og7(this.d, zg7.e));
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
            this.M = cw8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = cw8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = cw8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = cw8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = cw8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = cw8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = cw8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(b97.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(b97.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            zf7 zf7Var = this.h;
            if (zf7Var != null) {
                zf7Var.B(bVar);
            }
            eg7 eg7Var = this.m;
            if (eg7Var != null) {
                eg7Var.A(bVar);
            }
            uf7 uf7Var = this.k;
            if (uf7Var != null) {
                uf7Var.y(bVar);
            }
            xf7 xf7Var = this.w;
            if (xf7Var != null) {
                xf7Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            ig7 ig7Var = this.z;
            if (ig7Var != null) {
                ig7Var.x(bVar);
            }
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.C(bVar);
            }
            gg7 gg7Var = this.C;
            if (gg7Var != null) {
                gg7Var.z(bVar);
            }
            jg7 jg7Var = this.B;
            if (jg7Var != null) {
                jg7Var.A(bVar);
            }
            zf7 zf7Var2 = this.D;
            if (zf7Var2 != null) {
                zf7Var2.B(bVar);
            }
            cg7 cg7Var = this.E;
            if (cg7Var != null) {
                cg7Var.A(bVar);
            }
            dg7 dg7Var = this.F;
            if (dg7Var != null) {
                dg7Var.z(bVar);
            }
            fg7 fg7Var = this.G;
            if (fg7Var != null) {
                fg7Var.v(bVar);
            }
            of7 of7Var = this.H;
            if (of7Var != null) {
                of7Var.z(bVar);
            }
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
            this.K.u(joVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            nf7 nf7Var = this.g;
            if (nf7Var != null) {
                nf7Var.u(bdUniqueId);
            }
            zf7 zf7Var = this.h;
            if (zf7Var != null) {
                zf7Var.b = bdUniqueId;
            }
            kg7 kg7Var = this.i;
            if (kg7Var != null) {
                kg7Var.b = bdUniqueId;
            }
            tf7 tf7Var = this.j;
            if (tf7Var != null) {
                tf7Var.a = bdUniqueId;
            }
            uf7 uf7Var = this.k;
            if (uf7Var != null) {
                uf7Var.a = bdUniqueId;
            }
            vf7 vf7Var = this.l;
            if (vf7Var != null) {
                vf7Var.a = bdUniqueId;
            }
            eg7 eg7Var = this.m;
            if (eg7Var != null) {
                eg7Var.a = bdUniqueId;
            }
            wf7 wf7Var = this.n;
            if (wf7Var != null) {
                wf7Var.a = bdUniqueId;
            }
            bg7 bg7Var = this.o;
            if (bg7Var != null) {
                bg7Var.a = bdUniqueId;
            }
            yf7 yf7Var = this.p;
            if (yf7Var != null) {
                yf7Var.a = bdUniqueId;
            }
            ag7 ag7Var = this.q;
            if (ag7Var != null) {
                ag7Var.a = bdUniqueId;
            }
            sf7 sf7Var = this.r;
            if (sf7Var != null) {
                sf7Var.a = bdUniqueId;
            }
            rf7 rf7Var = this.s;
            if (rf7Var != null) {
                rf7Var.a = bdUniqueId;
            }
            qf7 qf7Var = this.t;
            if (qf7Var != null) {
                qf7Var.a = bdUniqueId;
            }
            xf7 xf7Var = this.w;
            if (xf7Var != null) {
                xf7Var.b = bdUniqueId;
            }
            lg7 lg7Var = this.u;
            if (lg7Var != null) {
                lg7Var.a = bdUniqueId;
            }
            lf7 lf7Var = this.e;
            if (lf7Var != null) {
                lf7Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            mg7 mg7Var = this.I;
            if (mg7Var != null) {
                mg7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            ig7 ig7Var = this.z;
            if (ig7Var != null) {
                ig7Var.b = bdUniqueId;
            }
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.b = bdUniqueId;
            }
            gg7 gg7Var = this.C;
            if (gg7Var != null) {
                gg7Var.b = bdUniqueId;
            }
            jg7 jg7Var = this.B;
            if (jg7Var != null) {
                jg7Var.b = bdUniqueId;
            }
            zf7 zf7Var2 = this.D;
            if (zf7Var2 != null) {
                zf7Var2.b = bdUniqueId;
            }
            cg7 cg7Var = this.E;
            if (cg7Var != null) {
                cg7Var.a = bdUniqueId;
            }
            dg7 dg7Var = this.F;
            if (dg7Var != null) {
                dg7Var.a = bdUniqueId;
            }
            fg7 fg7Var = this.G;
            if (fg7Var != null) {
                fg7Var.a = bdUniqueId;
            }
            of7 of7Var = this.H;
            if (of7Var != null) {
                of7Var.b = bdUniqueId;
            }
            pf7 pf7Var = this.v;
            if (pf7Var != null) {
                pf7Var.a = bdUniqueId;
            }
            zb7 zb7Var = this.J;
            if (zb7Var != null) {
                zb7Var.b = bdUniqueId;
            }
            ac7 ac7Var = this.K;
            if (ac7Var != null) {
                ac7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (qn qnVar : this.T) {
                    if (qnVar instanceof jy7) {
                        ((jy7) qnVar).setUniqueId(bdUniqueId);
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

    public void w(fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fh7Var) == null) {
            this.h.C(fh7Var);
            this.i.B(fh7Var);
            this.j.z(fh7Var);
            this.l.z(fh7Var);
            this.m.B(fh7Var);
            this.q.z(fh7Var);
            this.r.z(fh7Var);
            this.s.z(fh7Var);
            this.t.z(fh7Var);
            this.u.C(fh7Var);
            this.v.A(fh7Var);
        }
    }

    public void z(List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            v49.f(list, 2);
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
                    bdRecyclerView.B();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.C();
                }
            }
            kh.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
