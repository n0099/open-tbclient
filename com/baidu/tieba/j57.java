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
public class j57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b57 A;
    public d57 B;
    public a57 C;
    public t47 D;
    public w47 E;
    public x47 F;
    public z47 G;
    public i47 H;
    public g57 I;
    public u07 J;
    public v07 K;
    public g47 L;
    public kn M;
    public kn N;
    public kn O;
    public kn P;
    public kn Q;
    public kn R;
    public kn S;
    public List<kn> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<kn> a;
    public CustomMessageListener a0;
    public Cdo b;
    public List<xn> c;
    public TbPageContext<?> d;
    public f47 e;
    public h57 f;
    public h47 g;
    public t47 h;
    public e57 i;
    public n47 j;
    public o47 k;
    public p47 l;
    public y47 m;
    public q47 n;
    public v47 o;
    public s47 p;
    public u47 q;
    public m47 r;
    public l47 s;
    public k47 t;
    public f57 u;
    public j47 v;
    public r47 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public c57 z;

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
        public final /* synthetic */ j57 b;

        public a(j57 j57Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j57Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j57Var;
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
        public final /* synthetic */ j57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j57 j57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j57Var, Integer.valueOf(i)};
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
            this.a = j57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    j57 j57Var = this.a;
                    j57Var.y(j57Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j57 j57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j57Var, Integer.valueOf(i)};
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
            this.a = j57Var;
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
        public final /* synthetic */ j57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j57 j57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j57Var, Integer.valueOf(i)};
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
            this.a = j57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                um7 um7Var = new um7();
                um7Var.a = String.valueOf(customResponsedMessage.getData());
                um7Var.b = true;
                this.a.g(um7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(j57 j57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j57Var, Integer.valueOf(i)};
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
            this.a = j57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                um7 um7Var = new um7();
                um7Var.a = String.valueOf(customResponsedMessage.getData());
                um7Var.b = false;
                this.a.g(um7Var);
            }
        }
    }

    public j57(Context context, Cdo cdo) {
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
        this.X = new b(this, 2016470);
        this.Y = new c(this, 2001115);
        this.Z = new d(this, 2001335);
        this.a0 = new e(this, 2001336);
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
            if (knVar instanceof hr5) {
                ((hr5) knVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof kz6) {
                    ((kz6) knVar).s(aVar);
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

    public void y(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            lr8.f(list, 2);
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
        f57 f57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (f57Var = this.u) != null) {
            f57Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f57 f57Var = this.u;
            if (f57Var != null) {
                f57Var.onResume();
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
            List<kn> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = lr8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                xl7 b2 = cn7.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                t47 t47Var = this.h;
                if (t47Var != null && (bdUniqueId = t47Var.b) != null) {
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
            t47 t47Var = this.h;
            if (t47Var != null) {
                t47Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            p47 p47Var = this.l;
            if (p47Var != null) {
                p47Var.setFromCDN(z);
            }
            j47 j47Var = this.v;
            if (j47Var != null) {
                j47Var.setFromCDN(z);
            }
            kn knVar = this.N;
            if (knVar != null && (knVar instanceof wi8)) {
                ((wi8) knVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new f47(this.d);
            this.f = new h57(this.d);
            this.g = new h47(this.d, r57.b);
            this.h = new t47(this.d, w56.i0);
            this.i = new e57(this.d, w56.A0);
            this.j = new n47(this.d, w56.I0);
            this.k = new o47(this.d, w56.B0);
            this.l = new p47(this.d, w56.J0);
            this.m = new y47(this.d, w56.H0);
            this.n = new q47(this.d, w56.K0);
            this.o = new v47(this.d, w56.L0);
            this.p = new s47(this.d, w56.M0);
            this.q = new u47(this.d, w56.N0);
            this.r = new m47(this.d, w56.C0);
            this.s = new l47(this.d, w56.D0);
            this.t = new k47(this.d, w56.E0);
            this.u = new f57(this.d, x56.U);
            this.w = new r47(this.d, w56.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, v56.O0);
            this.I = new g57(this.d, w56.G0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, v56.P0);
            this.z = new c57(this.d, w56.r0);
            this.A = new b57(this.d, w56.s0);
            this.B = new d57(this.d, w56.u0);
            this.C = new a57(this.d, w56.t0);
            this.D = new t47(this.d, w56.j0);
            this.E = new w47(this.d, w56.v0);
            this.F = new x47(this.d, w56.w0);
            this.G = new z47(this.d, r87.d0);
            this.H = new i47(this.d, r56.O0);
            this.v = new j47(this.d, w56.F0);
            this.J = new u07(this.d, w56.x0, (byte) 3);
            this.K = new v07(this.d, w56.y0, (byte) 3);
            this.L = new g47(this.d, ms5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, d67.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new i57(this.d, t57.e));
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
            this.M = aj8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = aj8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = aj8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = aj8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = aj8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = aj8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = aj8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(wx6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(wx6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            t47 t47Var = this.h;
            if (t47Var != null) {
                t47Var.B(bVar);
            }
            y47 y47Var = this.m;
            if (y47Var != null) {
                y47Var.A(bVar);
            }
            o47 o47Var = this.k;
            if (o47Var != null) {
                o47Var.y(bVar);
            }
            r47 r47Var = this.w;
            if (r47Var != null) {
                r47Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            c57 c57Var = this.z;
            if (c57Var != null) {
                c57Var.x(bVar);
            }
            b57 b57Var = this.A;
            if (b57Var != null) {
                b57Var.C(bVar);
            }
            a57 a57Var = this.C;
            if (a57Var != null) {
                a57Var.z(bVar);
            }
            d57 d57Var = this.B;
            if (d57Var != null) {
                d57Var.A(bVar);
            }
            t47 t47Var2 = this.D;
            if (t47Var2 != null) {
                t47Var2.B(bVar);
            }
            w47 w47Var = this.E;
            if (w47Var != null) {
                w47Var.A(bVar);
            }
            x47 x47Var = this.F;
            if (x47Var != null) {
                x47Var.z(bVar);
            }
            z47 z47Var = this.G;
            if (z47Var != null) {
                z47Var.v(bVar);
            }
            i47 i47Var = this.H;
            if (i47Var != null) {
                i47Var.z(bVar);
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
            this.K.u(cdo);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            h47 h47Var = this.g;
            if (h47Var != null) {
                h47Var.u(bdUniqueId);
            }
            t47 t47Var = this.h;
            if (t47Var != null) {
                t47Var.b = bdUniqueId;
            }
            e57 e57Var = this.i;
            if (e57Var != null) {
                e57Var.b = bdUniqueId;
            }
            n47 n47Var = this.j;
            if (n47Var != null) {
                n47Var.a = bdUniqueId;
            }
            o47 o47Var = this.k;
            if (o47Var != null) {
                o47Var.a = bdUniqueId;
            }
            p47 p47Var = this.l;
            if (p47Var != null) {
                p47Var.a = bdUniqueId;
            }
            y47 y47Var = this.m;
            if (y47Var != null) {
                y47Var.a = bdUniqueId;
            }
            q47 q47Var = this.n;
            if (q47Var != null) {
                q47Var.a = bdUniqueId;
            }
            v47 v47Var = this.o;
            if (v47Var != null) {
                v47Var.a = bdUniqueId;
            }
            s47 s47Var = this.p;
            if (s47Var != null) {
                s47Var.a = bdUniqueId;
            }
            u47 u47Var = this.q;
            if (u47Var != null) {
                u47Var.a = bdUniqueId;
            }
            m47 m47Var = this.r;
            if (m47Var != null) {
                m47Var.a = bdUniqueId;
            }
            l47 l47Var = this.s;
            if (l47Var != null) {
                l47Var.a = bdUniqueId;
            }
            k47 k47Var = this.t;
            if (k47Var != null) {
                k47Var.a = bdUniqueId;
            }
            r47 r47Var = this.w;
            if (r47Var != null) {
                r47Var.b = bdUniqueId;
            }
            f57 f57Var = this.u;
            if (f57Var != null) {
                f57Var.a = bdUniqueId;
            }
            f47 f47Var = this.e;
            if (f47Var != null) {
                f47Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            g57 g57Var = this.I;
            if (g57Var != null) {
                g57Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            c57 c57Var = this.z;
            if (c57Var != null) {
                c57Var.b = bdUniqueId;
            }
            b57 b57Var = this.A;
            if (b57Var != null) {
                b57Var.b = bdUniqueId;
            }
            a57 a57Var = this.C;
            if (a57Var != null) {
                a57Var.b = bdUniqueId;
            }
            d57 d57Var = this.B;
            if (d57Var != null) {
                d57Var.b = bdUniqueId;
            }
            t47 t47Var2 = this.D;
            if (t47Var2 != null) {
                t47Var2.b = bdUniqueId;
            }
            w47 w47Var = this.E;
            if (w47Var != null) {
                w47Var.a = bdUniqueId;
            }
            x47 x47Var = this.F;
            if (x47Var != null) {
                x47Var.a = bdUniqueId;
            }
            z47 z47Var = this.G;
            if (z47Var != null) {
                z47Var.a = bdUniqueId;
            }
            i47 i47Var = this.H;
            if (i47Var != null) {
                i47Var.b = bdUniqueId;
            }
            j47 j47Var = this.v;
            if (j47Var != null) {
                j47Var.a = bdUniqueId;
            }
            u07 u07Var = this.J;
            if (u07Var != null) {
                u07Var.b = bdUniqueId;
            }
            v07 v07Var = this.K;
            if (v07Var != null) {
                v07Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (kn knVar : this.T) {
                    if (knVar instanceof xl7) {
                        ((xl7) knVar).setUniqueId(bdUniqueId);
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

    public void w(a67 a67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, a67Var) == null) {
            this.h.C(a67Var);
            this.i.B(a67Var);
            this.j.z(a67Var);
            this.l.z(a67Var);
            this.m.B(a67Var);
            this.q.z(a67Var);
            this.r.z(a67Var);
            this.s.z(a67Var);
            this.t.z(a67Var);
            this.u.C(a67Var);
            this.v.A(a67Var);
        }
    }

    public void z(List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            lr8.f(list, 2);
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
            eh.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
