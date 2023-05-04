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
public class ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gt7 A;
    public it7 B;
    public ft7 C;
    public ys7 D;
    public bt7 E;
    public ct7 F;
    public et7 G;
    public ns7 H;
    public lt7 I;
    public yo7 J;
    public zo7 K;
    public ls7 L;
    public vm M;
    public vm N;
    public vm O;
    public vm P;
    public vm Q;
    public vm R;
    public vm S;
    public List<vm> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<vm> a;
    public CustomMessageListener a0;
    public on b;
    public List<in> c;
    public TbPageContext<?> d;
    public ks7 e;
    public mt7 f;
    public ms7 g;
    public ys7 h;
    public jt7 i;
    public ss7 j;
    public ts7 k;
    public us7 l;
    public dt7 m;
    public vs7 n;
    public at7 o;
    public xs7 p;
    public zs7 q;
    public rs7 r;
    public qs7 s;
    public ps7 t;
    public kt7 u;
    public os7 v;
    public ws7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public ht7 z;

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
        public final /* synthetic */ ot7 b;

        public a(ot7 ot7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
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
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    ot7 ot7Var = this.a;
                    ot7Var.y(ot7Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
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
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                rh8 rh8Var = new rh8();
                rh8Var.a = String.valueOf(customResponsedMessage.getData());
                rh8Var.b = true;
                this.a.g(rh8Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                rh8 rh8Var = new rh8();
                rh8Var.a = String.valueOf(customResponsedMessage.getData());
                rh8Var.b = false;
                this.a.g(rh8Var);
            }
        }
    }

    public ot7(Context context, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onVar};
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
        this.b = onVar;
        this.d = (TbPageContext) g9.a(context);
        j(context);
        x(onVar);
        onVar.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof qz5) {
                ((qz5) vmVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof on7) {
                    ((on7) vmVar).s(aVar);
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

    public void y(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            oo9.f(list, 2);
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

    public List<in> h() {
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
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (onVar = this.b) != null) {
            onVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        kt7 kt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (kt7Var = this.u) != null) {
            kt7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            kt7 kt7Var = this.u;
            if (kt7Var != null) {
                kt7Var.onResume();
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
            List<vm> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = oo9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ug8 b2 = zh8.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                ys7 ys7Var = this.h;
                if (ys7Var != null && (bdUniqueId = ys7Var.b) != null) {
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
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (in inVar : list) {
                if ((inVar instanceof ICardInfo) && ((ICardInfo) inVar).responseAttention(obj)) {
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
            ys7 ys7Var = this.h;
            if (ys7Var != null) {
                ys7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            us7 us7Var = this.l;
            if (us7Var != null) {
                us7Var.setFromCDN(z);
            }
            os7 os7Var = this.v;
            if (os7Var != null) {
                os7Var.setFromCDN(z);
            }
            vm vmVar = this.N;
            if (vmVar != null && (vmVar instanceof vd9)) {
                ((vd9) vmVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new ks7(this.d);
            this.f = new mt7(this.d);
            this.g = new ms7(this.d, vt7.b);
            this.h = new ys7(this.d, yi6.j0);
            this.i = new jt7(this.d, yi6.C0);
            this.j = new ss7(this.d, yi6.K0);
            this.k = new ts7(this.d, yi6.D0);
            this.l = new us7(this.d, yi6.L0);
            this.m = new dt7(this.d, yi6.J0);
            this.n = new vs7(this.d, yi6.M0);
            this.o = new at7(this.d, yi6.N0);
            this.p = new xs7(this.d, yi6.O0);
            this.q = new zs7(this.d, yi6.P0);
            this.r = new rs7(this.d, yi6.E0);
            this.s = new qs7(this.d, yi6.F0);
            this.t = new ps7(this.d, yi6.G0);
            this.u = new kt7(this.d, zi6.U);
            this.w = new ws7(this.d, yi6.s0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, xi6.Q0);
            this.I = new lt7(this.d, yi6.I0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, xi6.R0);
            this.z = new ht7(this.d, yi6.t0);
            this.A = new gt7(this.d, yi6.u0);
            this.B = new it7(this.d, yi6.w0);
            this.C = new ft7(this.d, yi6.v0);
            this.D = new ys7(this.d, yi6.r0);
            this.E = new bt7(this.d, yi6.x0);
            this.F = new ct7(this.d, yi6.y0);
            this.G = new et7(this.d, xw7.d0);
            this.H = new ns7(this.d, ti6.Q0);
            this.v = new os7(this.d, yi6.H0);
            this.J = new yo7(this.d, yi6.z0, (byte) 3);
            this.K = new zo7(this.d, yi6.A0, (byte) 3);
            this.L = new ls7(this.d, x06.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, gu7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new nt7(this.d, xt7.e));
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
            this.M = ae9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = ae9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = ae9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = ae9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = ae9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = ae9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = ae9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(am7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(am7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            ys7 ys7Var = this.h;
            if (ys7Var != null) {
                ys7Var.D(bVar);
            }
            dt7 dt7Var = this.m;
            if (dt7Var != null) {
                dt7Var.C(bVar);
            }
            ts7 ts7Var = this.k;
            if (ts7Var != null) {
                ts7Var.A(bVar);
            }
            ws7 ws7Var = this.w;
            if (ws7Var != null) {
                ws7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.z(bVar);
            }
            ht7 ht7Var = this.z;
            if (ht7Var != null) {
                ht7Var.z(bVar);
            }
            gt7 gt7Var = this.A;
            if (gt7Var != null) {
                gt7Var.E(bVar);
            }
            ft7 ft7Var = this.C;
            if (ft7Var != null) {
                ft7Var.B(bVar);
            }
            it7 it7Var = this.B;
            if (it7Var != null) {
                it7Var.C(bVar);
            }
            ys7 ys7Var2 = this.D;
            if (ys7Var2 != null) {
                ys7Var2.D(bVar);
            }
            bt7 bt7Var = this.E;
            if (bt7Var != null) {
                bt7Var.C(bVar);
            }
            ct7 ct7Var = this.F;
            if (ct7Var != null) {
                ct7Var.B(bVar);
            }
            et7 et7Var = this.G;
            if (et7Var != null) {
                et7Var.x(bVar);
            }
            ns7 ns7Var = this.H;
            if (ns7Var != null) {
                ns7Var.B(bVar);
            }
        }
    }

    public final void x(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onVar) == null) {
            this.i.E(onVar);
            this.j.C(onVar);
            this.k.B(onVar);
            this.l.C(onVar);
            this.m.E(onVar);
            this.n.u(onVar);
            this.o.x(onVar);
            this.p.u(onVar);
            this.q.C(onVar);
            this.r.C(onVar);
            this.s.C(onVar);
            this.t.C(onVar);
            this.v.D(onVar);
            this.u.F(onVar);
            this.H.C(onVar);
            this.A.F(onVar);
            this.A.F(onVar);
            this.C.C(onVar);
            this.J.u(onVar);
            this.K.u(onVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            ms7 ms7Var = this.g;
            if (ms7Var != null) {
                ms7Var.u(bdUniqueId);
            }
            ys7 ys7Var = this.h;
            if (ys7Var != null) {
                ys7Var.b = bdUniqueId;
            }
            jt7 jt7Var = this.i;
            if (jt7Var != null) {
                jt7Var.b = bdUniqueId;
            }
            ss7 ss7Var = this.j;
            if (ss7Var != null) {
                ss7Var.a = bdUniqueId;
            }
            ts7 ts7Var = this.k;
            if (ts7Var != null) {
                ts7Var.a = bdUniqueId;
            }
            us7 us7Var = this.l;
            if (us7Var != null) {
                us7Var.a = bdUniqueId;
            }
            dt7 dt7Var = this.m;
            if (dt7Var != null) {
                dt7Var.a = bdUniqueId;
            }
            vs7 vs7Var = this.n;
            if (vs7Var != null) {
                vs7Var.a = bdUniqueId;
            }
            at7 at7Var = this.o;
            if (at7Var != null) {
                at7Var.a = bdUniqueId;
            }
            xs7 xs7Var = this.p;
            if (xs7Var != null) {
                xs7Var.a = bdUniqueId;
            }
            zs7 zs7Var = this.q;
            if (zs7Var != null) {
                zs7Var.a = bdUniqueId;
            }
            rs7 rs7Var = this.r;
            if (rs7Var != null) {
                rs7Var.a = bdUniqueId;
            }
            qs7 qs7Var = this.s;
            if (qs7Var != null) {
                qs7Var.a = bdUniqueId;
            }
            ps7 ps7Var = this.t;
            if (ps7Var != null) {
                ps7Var.a = bdUniqueId;
            }
            ws7 ws7Var = this.w;
            if (ws7Var != null) {
                ws7Var.b = bdUniqueId;
            }
            kt7 kt7Var = this.u;
            if (kt7Var != null) {
                kt7Var.a = bdUniqueId;
            }
            ks7 ks7Var = this.e;
            if (ks7Var != null) {
                ks7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            lt7 lt7Var = this.I;
            if (lt7Var != null) {
                lt7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            ht7 ht7Var = this.z;
            if (ht7Var != null) {
                ht7Var.b = bdUniqueId;
            }
            gt7 gt7Var = this.A;
            if (gt7Var != null) {
                gt7Var.b = bdUniqueId;
            }
            ft7 ft7Var = this.C;
            if (ft7Var != null) {
                ft7Var.b = bdUniqueId;
            }
            it7 it7Var = this.B;
            if (it7Var != null) {
                it7Var.b = bdUniqueId;
            }
            ys7 ys7Var2 = this.D;
            if (ys7Var2 != null) {
                ys7Var2.b = bdUniqueId;
            }
            bt7 bt7Var = this.E;
            if (bt7Var != null) {
                bt7Var.a = bdUniqueId;
            }
            ct7 ct7Var = this.F;
            if (ct7Var != null) {
                ct7Var.a = bdUniqueId;
            }
            et7 et7Var = this.G;
            if (et7Var != null) {
                et7Var.a = bdUniqueId;
            }
            ns7 ns7Var = this.H;
            if (ns7Var != null) {
                ns7Var.b = bdUniqueId;
            }
            os7 os7Var = this.v;
            if (os7Var != null) {
                os7Var.a = bdUniqueId;
            }
            yo7 yo7Var = this.J;
            if (yo7Var != null) {
                yo7Var.b = bdUniqueId;
            }
            zo7 zo7Var = this.K;
            if (zo7Var != null) {
                zo7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (vm vmVar : this.T) {
                    if (vmVar instanceof ug8) {
                        ((ug8) vmVar).setUniqueId(bdUniqueId);
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

    public void w(du7 du7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, du7Var) == null) {
            this.h.E(du7Var);
            this.i.D(du7Var);
            this.j.B(du7Var);
            this.l.B(du7Var);
            this.m.D(du7Var);
            this.q.B(du7Var);
            this.r.B(du7Var);
            this.s.B(du7Var);
            this.t.B(du7Var);
            this.u.E(du7Var);
            this.v.C(du7Var);
        }
    }

    public void z(List<in> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            oo9.f(list, 2);
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
