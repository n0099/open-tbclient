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
public class tr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lr7 A;
    public nr7 B;
    public kr7 C;
    public dr7 D;
    public gr7 E;
    public hr7 F;
    public jr7 G;
    public sq7 H;
    public qr7 I;
    public dn7 J;
    public en7 K;
    public qq7 L;
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
    public pq7 e;
    public rr7 f;
    public rq7 g;
    public dr7 h;
    public or7 i;
    public xq7 j;
    public yq7 k;
    public zq7 l;
    public ir7 m;
    public ar7 n;
    public fr7 o;
    public cr7 p;
    public er7 q;
    public wq7 r;
    public vq7 s;
    public uq7 t;
    public pr7 u;
    public tq7 v;
    public br7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public mr7 z;

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
        public final /* synthetic */ tr7 b;

        public a(tr7 tr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tr7Var;
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
        public final /* synthetic */ tr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tr7 tr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var, Integer.valueOf(i)};
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
            this.a = tr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    tr7 tr7Var = this.a;
                    tr7Var.y(tr7Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(tr7 tr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var, Integer.valueOf(i)};
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
            this.a = tr7Var;
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
        public final /* synthetic */ tr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(tr7 tr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var, Integer.valueOf(i)};
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
            this.a = tr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                jf8 jf8Var = new jf8();
                jf8Var.a = String.valueOf(customResponsedMessage.getData());
                jf8Var.b = true;
                this.a.g(jf8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(tr7 tr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr7Var, Integer.valueOf(i)};
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
            this.a = tr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                jf8 jf8Var = new jf8();
                jf8Var.a = String.valueOf(customResponsedMessage.getData());
                jf8Var.b = false;
                this.a.g(jf8Var);
            }
        }
    }

    public tr7(Context context, on onVar) {
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
            if (vmVar instanceof qy5) {
                ((qy5) vmVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof tl7) {
                    ((tl7) vmVar).s(aVar);
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
            zk9.f(list, 2);
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
        pr7 pr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pr7Var = this.u) != null) {
            pr7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pr7 pr7Var = this.u;
            if (pr7Var != null) {
                pr7Var.onResume();
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
            ArrayList<BdUniqueId> g = zk9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                me8 b2 = rf8.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                dr7 dr7Var = this.h;
                if (dr7Var != null && (bdUniqueId = dr7Var.b) != null) {
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
            dr7 dr7Var = this.h;
            if (dr7Var != null) {
                dr7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            zq7 zq7Var = this.l;
            if (zq7Var != null) {
                zq7Var.setFromCDN(z);
            }
            tq7 tq7Var = this.v;
            if (tq7Var != null) {
                tq7Var.setFromCDN(z);
            }
            vm vmVar = this.N;
            if (vmVar != null && (vmVar instanceof za9)) {
                ((za9) vmVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new pq7(this.d);
            this.f = new rr7(this.d);
            this.g = new rq7(this.d, as7.b);
            this.h = new dr7(this.d, nh6.j0);
            this.i = new or7(this.d, nh6.C0);
            this.j = new xq7(this.d, nh6.K0);
            this.k = new yq7(this.d, nh6.D0);
            this.l = new zq7(this.d, nh6.L0);
            this.m = new ir7(this.d, nh6.J0);
            this.n = new ar7(this.d, nh6.M0);
            this.o = new fr7(this.d, nh6.N0);
            this.p = new cr7(this.d, nh6.O0);
            this.q = new er7(this.d, nh6.P0);
            this.r = new wq7(this.d, nh6.E0);
            this.s = new vq7(this.d, nh6.F0);
            this.t = new uq7(this.d, nh6.G0);
            this.u = new pr7(this.d, oh6.U);
            this.w = new br7(this.d, nh6.s0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, mh6.Q0);
            this.I = new qr7(this.d, nh6.I0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, mh6.R0);
            this.z = new mr7(this.d, nh6.t0);
            this.A = new lr7(this.d, nh6.u0);
            this.B = new nr7(this.d, nh6.w0);
            this.C = new kr7(this.d, nh6.v0);
            this.D = new dr7(this.d, nh6.r0);
            this.E = new gr7(this.d, nh6.x0);
            this.F = new hr7(this.d, nh6.y0);
            this.G = new jr7(this.d, cv7.d0);
            this.H = new sq7(this.d, ih6.Q0);
            this.v = new tq7(this.d, nh6.H0);
            this.J = new dn7(this.d, nh6.z0, (byte) 3);
            this.K = new en7(this.d, nh6.A0, (byte) 3);
            this.L = new qq7(this.d, wz5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, ls7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new sr7(this.d, cs7.e));
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
            this.M = db9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = db9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = db9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = db9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = db9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = db9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = db9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(fk7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(fk7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            dr7 dr7Var = this.h;
            if (dr7Var != null) {
                dr7Var.D(bVar);
            }
            ir7 ir7Var = this.m;
            if (ir7Var != null) {
                ir7Var.C(bVar);
            }
            yq7 yq7Var = this.k;
            if (yq7Var != null) {
                yq7Var.A(bVar);
            }
            br7 br7Var = this.w;
            if (br7Var != null) {
                br7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.z(bVar);
            }
            mr7 mr7Var = this.z;
            if (mr7Var != null) {
                mr7Var.z(bVar);
            }
            lr7 lr7Var = this.A;
            if (lr7Var != null) {
                lr7Var.E(bVar);
            }
            kr7 kr7Var = this.C;
            if (kr7Var != null) {
                kr7Var.B(bVar);
            }
            nr7 nr7Var = this.B;
            if (nr7Var != null) {
                nr7Var.C(bVar);
            }
            dr7 dr7Var2 = this.D;
            if (dr7Var2 != null) {
                dr7Var2.D(bVar);
            }
            gr7 gr7Var = this.E;
            if (gr7Var != null) {
                gr7Var.C(bVar);
            }
            hr7 hr7Var = this.F;
            if (hr7Var != null) {
                hr7Var.B(bVar);
            }
            jr7 jr7Var = this.G;
            if (jr7Var != null) {
                jr7Var.x(bVar);
            }
            sq7 sq7Var = this.H;
            if (sq7Var != null) {
                sq7Var.B(bVar);
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
            rq7 rq7Var = this.g;
            if (rq7Var != null) {
                rq7Var.u(bdUniqueId);
            }
            dr7 dr7Var = this.h;
            if (dr7Var != null) {
                dr7Var.b = bdUniqueId;
            }
            or7 or7Var = this.i;
            if (or7Var != null) {
                or7Var.b = bdUniqueId;
            }
            xq7 xq7Var = this.j;
            if (xq7Var != null) {
                xq7Var.a = bdUniqueId;
            }
            yq7 yq7Var = this.k;
            if (yq7Var != null) {
                yq7Var.a = bdUniqueId;
            }
            zq7 zq7Var = this.l;
            if (zq7Var != null) {
                zq7Var.a = bdUniqueId;
            }
            ir7 ir7Var = this.m;
            if (ir7Var != null) {
                ir7Var.a = bdUniqueId;
            }
            ar7 ar7Var = this.n;
            if (ar7Var != null) {
                ar7Var.a = bdUniqueId;
            }
            fr7 fr7Var = this.o;
            if (fr7Var != null) {
                fr7Var.a = bdUniqueId;
            }
            cr7 cr7Var = this.p;
            if (cr7Var != null) {
                cr7Var.a = bdUniqueId;
            }
            er7 er7Var = this.q;
            if (er7Var != null) {
                er7Var.a = bdUniqueId;
            }
            wq7 wq7Var = this.r;
            if (wq7Var != null) {
                wq7Var.a = bdUniqueId;
            }
            vq7 vq7Var = this.s;
            if (vq7Var != null) {
                vq7Var.a = bdUniqueId;
            }
            uq7 uq7Var = this.t;
            if (uq7Var != null) {
                uq7Var.a = bdUniqueId;
            }
            br7 br7Var = this.w;
            if (br7Var != null) {
                br7Var.b = bdUniqueId;
            }
            pr7 pr7Var = this.u;
            if (pr7Var != null) {
                pr7Var.a = bdUniqueId;
            }
            pq7 pq7Var = this.e;
            if (pq7Var != null) {
                pq7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            qr7 qr7Var = this.I;
            if (qr7Var != null) {
                qr7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            mr7 mr7Var = this.z;
            if (mr7Var != null) {
                mr7Var.b = bdUniqueId;
            }
            lr7 lr7Var = this.A;
            if (lr7Var != null) {
                lr7Var.b = bdUniqueId;
            }
            kr7 kr7Var = this.C;
            if (kr7Var != null) {
                kr7Var.b = bdUniqueId;
            }
            nr7 nr7Var = this.B;
            if (nr7Var != null) {
                nr7Var.b = bdUniqueId;
            }
            dr7 dr7Var2 = this.D;
            if (dr7Var2 != null) {
                dr7Var2.b = bdUniqueId;
            }
            gr7 gr7Var = this.E;
            if (gr7Var != null) {
                gr7Var.a = bdUniqueId;
            }
            hr7 hr7Var = this.F;
            if (hr7Var != null) {
                hr7Var.a = bdUniqueId;
            }
            jr7 jr7Var = this.G;
            if (jr7Var != null) {
                jr7Var.a = bdUniqueId;
            }
            sq7 sq7Var = this.H;
            if (sq7Var != null) {
                sq7Var.b = bdUniqueId;
            }
            tq7 tq7Var = this.v;
            if (tq7Var != null) {
                tq7Var.a = bdUniqueId;
            }
            dn7 dn7Var = this.J;
            if (dn7Var != null) {
                dn7Var.b = bdUniqueId;
            }
            en7 en7Var = this.K;
            if (en7Var != null) {
                en7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (vm vmVar : this.T) {
                    if (vmVar instanceof me8) {
                        ((me8) vmVar).setUniqueId(bdUniqueId);
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

    public void w(is7 is7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, is7Var) == null) {
            this.h.E(is7Var);
            this.i.D(is7Var);
            this.j.B(is7Var);
            this.l.B(is7Var);
            this.m.D(is7Var);
            this.q.B(is7Var);
            this.r.B(is7Var);
            this.s.B(is7Var);
            this.t.B(is7Var);
            this.u.E(is7Var);
            this.v.C(is7Var);
        }
    }

    public void z(List<in> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            zk9.f(list, 2);
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
