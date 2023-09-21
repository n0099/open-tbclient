package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
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
/* loaded from: classes8.dex */
public class x68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r68 A;
    public o68 B;
    public h68 C;
    public l68 D;
    public n68 E;
    public w58 F;
    public u68 G;
    public u18 H;
    public v18 I;
    public w18 J;
    public y18 K;
    public i68 L;
    public x18 M;
    public u58 N;
    public om O;
    public om P;
    public om Q;
    public om R;
    public om S;

    /* renamed from: T  reason: collision with root package name */
    public om f1179T;
    public om U;
    public List<om> V;
    public boolean W;
    public boolean X;
    public f Y;
    @Nullable
    public nn Z;
    public List<om> a;
    public CustomMessageListener a0;
    public hn b;
    public CustomMessageListener b0;
    public List<bn> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public CustomMessageListener d0;
    public t58 e;
    public v68 f;
    public v58 g;
    public h68 h;
    public s68 i;
    public b68 j;
    public c68 k;
    public d68 l;
    public m68 m;
    public e68 n;
    public k68 o;
    public g68 p;
    public j68 q;
    public a68 r;
    public z58 s;
    public y58 t;
    public t68 u;
    public x58 v;
    public f68 w;
    public HomePageAlaLiveThreadAdapter x;
    public q68 y;
    public p68 z;

    /* loaded from: classes8.dex */
    public interface f {
        void a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ x68 b;

        /* renamed from: com.baidu.tieba.x68$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0518a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0518a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.b.setData(this.a.a);
                    a aVar = this.a;
                    aVar.b.c = aVar.a;
                    if (this.a.b.Y != null) {
                        this.a.b.Y.a();
                    }
                }
            }
        }

        public a(x68 x68Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x68Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Z != null) {
                this.b.Z.e(new RunnableC0518a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x68 x68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var, Integer.valueOf(i)};
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
            this.a = x68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    x68 x68Var = this.a;
                    x68Var.B(x68Var.c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x68 x68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var, Integer.valueOf(i)};
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
            this.a = x68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().isSucc) {
                return;
            }
            this.a.j(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x68 x68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var, Integer.valueOf(i)};
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
            this.a = x68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                h59 h59Var = new h59();
                h59Var.a = String.valueOf(customResponsedMessage.getData());
                h59Var.b = true;
                this.a.j(h59Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(x68 x68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var, Integer.valueOf(i)};
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
            this.a = x68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                h59 h59Var = new h59();
                h59Var.a = String.valueOf(customResponsedMessage.getData());
                h59Var.b = false;
                this.a.j(h59Var);
            }
        }
    }

    public x68(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a0 = new b(this, 2016470);
        this.b0 = new c(this, 2001115);
        this.c0 = new d(this, 2001335);
        this.d0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = hnVar;
        this.d = (TbPageContext) m9.a(context);
        l(context);
        A(hnVar);
        hnVar.addAdapters(this.a);
        if (hnVar instanceof RecyclerView) {
            this.Z = new nn((RecyclerView) hnVar);
        }
    }

    public void B(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            zia.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.Y;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        lg.g(new a(this, list));
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n();
            this.e.s(i);
        }
    }

    public final void s(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof p56) {
                ((p56) omVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof k08) {
                    ((k08) omVar).s(aVar);
                }
            }
        }
    }

    public void u(k58 k58Var) {
        c68 c68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, k58Var) == null) && (c68Var = this.k) != null) {
            c68Var.B(k58Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    public final void A(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hnVar) == null) {
            this.i.E(hnVar);
            this.j.C(hnVar);
            this.k.C(hnVar);
            this.l.C(hnVar);
            this.m.E(hnVar);
            this.n.u(hnVar);
            this.o.x(hnVar);
            this.p.u(hnVar);
            this.q.B(hnVar);
            this.r.D(hnVar);
            this.s.C(hnVar);
            this.t.C(hnVar);
            this.v.D(hnVar);
            this.u.F(hnVar);
            this.F.C(hnVar);
            this.z.F(hnVar);
            this.z.F(hnVar);
            this.B.C(hnVar);
            this.H.u(hnVar);
            this.I.u(hnVar);
            this.J.u(hnVar);
            this.K.u(hnVar);
            this.L.u(hnVar);
            this.M.u(hnVar);
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            h68 h68Var = this.h;
            if (h68Var != null) {
                h68Var.D(nEGFeedbackEventCallback);
            }
            m68 m68Var = this.m;
            if (m68Var != null) {
                m68Var.C(nEGFeedbackEventCallback);
            }
            c68 c68Var = this.k;
            if (c68Var != null) {
                c68Var.A(nEGFeedbackEventCallback);
            }
            f68 f68Var = this.w;
            if (f68Var != null) {
                f68Var.z(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(nEGFeedbackEventCallback);
            }
            q68 q68Var = this.y;
            if (q68Var != null) {
                q68Var.z(nEGFeedbackEventCallback);
            }
            p68 p68Var = this.z;
            if (p68Var != null) {
                p68Var.E(nEGFeedbackEventCallback);
            }
            o68 o68Var = this.B;
            if (o68Var != null) {
                o68Var.B(nEGFeedbackEventCallback);
            }
            r68 r68Var = this.A;
            if (r68Var != null) {
                r68Var.C(nEGFeedbackEventCallback);
            }
            h68 h68Var2 = this.C;
            if (h68Var2 != null) {
                h68Var2.D(nEGFeedbackEventCallback);
            }
            l68 l68Var = this.D;
            if (l68Var != null) {
                l68Var.C(nEGFeedbackEventCallback);
            }
            n68 n68Var = this.E;
            if (n68Var != null) {
                n68Var.x(nEGFeedbackEventCallback);
            }
            w58 w58Var = this.F;
            if (w58Var != null) {
                w58Var.B(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<bn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            zia.f(list, 2);
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
            D(list);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.X = i();
        }
    }

    public List<bn> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (hnVar = this.b) != null) {
            hnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        t68 t68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (t68Var = this.u) != null) {
            t68Var.onPause();
        }
    }

    public void r() {
        t68 t68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (t68Var = this.u) != null) {
            t68Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<om> list = this.V;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.V = new ArrayList();
            ArrayList<BdUniqueId> g = zia.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                l49 b2 = p59.d().b(this.d, g.get(i), 2);
                if (this.W) {
                    b2.s(3);
                }
                h68 h68Var = this.h;
                if (h68Var != null && (bdUniqueId = h68Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.V.add(b2);
            }
            this.b.addAdapters(this.V);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void j(Object obj) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (bn bnVar : list) {
                if ((bnVar instanceof ICardInfo) && ((ICardInfo) bnVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                n();
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            h68 h68Var = this.h;
            if (h68Var != null) {
                h68Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            d68 d68Var = this.l;
            if (d68Var != null) {
                d68Var.setFromCDN(z);
            }
            x58 x58Var = this.v;
            if (x58Var != null) {
                x58Var.setFromCDN(z);
            }
            om omVar = this.P;
            if (omVar != null && (omVar instanceof b5a)) {
                ((b5a) omVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new t58(this.d);
            this.f = new v68(this.d);
            this.g = new v58(this.d, f78.b);
            this.h = new h68(this.d, iq6.r0);
            this.i = new s68(this.d, iq6.E0);
            this.j = new b68(this.d, iq6.M0);
            this.k = new c68(this.d, iq6.F0);
            this.l = new d68(this.d, iq6.N0);
            this.m = new m68(this.d, iq6.L0);
            this.n = new e68(this.d, iq6.O0);
            this.o = new k68(this.d, iq6.P0);
            this.p = new g68(this.d, iq6.Q0);
            this.q = new j68(this.d, iq6.R0);
            this.r = new a68(this.d, iq6.G0);
            this.s = new z58(this.d, iq6.H0);
            this.t = new y58(this.d, iq6.I0);
            this.u = new t68(this.d, jq6.U);
            this.w = new f68(this.d, iq6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, hq6.S0);
            this.G = new u68(this.d, iq6.K0);
            this.y = new q68(this.d, iq6.u0);
            this.z = new p68(this.d, iq6.v0);
            this.A = new r68(this.d, iq6.x0);
            this.B = new o68(this.d, iq6.w0);
            this.C = new h68(this.d, iq6.s0);
            this.D = new l68(this.d, iq6.y0);
            this.E = new n68(this.d, ga8.d0);
            this.F = new w58(this.d, dq6.S0);
            this.v = new x58(this.d, iq6.J0);
            this.H = new u18(this.d, iq6.z0, (byte) 3);
            this.I = new v18(this.d, iq6.A0, (byte) 3);
            this.J = new w18(this.d, iq6.B0, (byte) 3);
            this.K = new y18(this.d, iq6.C0);
            this.N = new u58(this.d, w66.g);
            this.L = new i68(this.d, h78.g);
            this.M = new x18(this.d, nq6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, x78.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new w68(this.d, j78.h));
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.v);
            this.a.add(this.H);
            this.a.add(this.I);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.G);
            this.a.add(this.N);
            h();
            m();
            s("page_recommend");
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.w.set(false);
                return;
            }
            this.O = g5a.m().h(this.d, AdvertAppInfo.z, "INDEX");
            this.P = g5a.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.Q = g5a.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.R = g5a.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.S = g5a.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.f1179T = g5a.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.U = g5a.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1179T);
            this.a.add(this.U);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ly7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
                this.a.add(ly7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
            }
            AdvertAppInfo.w.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            v58 v58Var = this.g;
            if (v58Var != null) {
                v58Var.u(bdUniqueId);
            }
            h68 h68Var = this.h;
            if (h68Var != null) {
                h68Var.b = bdUniqueId;
            }
            s68 s68Var = this.i;
            if (s68Var != null) {
                s68Var.b = bdUniqueId;
            }
            b68 b68Var = this.j;
            if (b68Var != null) {
                b68Var.a = bdUniqueId;
            }
            c68 c68Var = this.k;
            if (c68Var != null) {
                c68Var.a = bdUniqueId;
            }
            d68 d68Var = this.l;
            if (d68Var != null) {
                d68Var.a = bdUniqueId;
            }
            m68 m68Var = this.m;
            if (m68Var != null) {
                m68Var.a = bdUniqueId;
            }
            e68 e68Var = this.n;
            if (e68Var != null) {
                e68Var.a = bdUniqueId;
            }
            k68 k68Var = this.o;
            if (k68Var != null) {
                k68Var.a = bdUniqueId;
            }
            g68 g68Var = this.p;
            if (g68Var != null) {
                g68Var.a = bdUniqueId;
            }
            j68 j68Var = this.q;
            if (j68Var != null) {
                j68Var.a = bdUniqueId;
            }
            a68 a68Var = this.r;
            if (a68Var != null) {
                a68Var.a = bdUniqueId;
            }
            z58 z58Var = this.s;
            if (z58Var != null) {
                z58Var.a = bdUniqueId;
            }
            y58 y58Var = this.t;
            if (y58Var != null) {
                y58Var.a = bdUniqueId;
            }
            f68 f68Var = this.w;
            if (f68Var != null) {
                f68Var.b = bdUniqueId;
            }
            t68 t68Var = this.u;
            if (t68Var != null) {
                t68Var.a = bdUniqueId;
            }
            t58 t58Var = this.e;
            if (t58Var != null) {
                t58Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            u68 u68Var = this.G;
            if (u68Var != null) {
                u68Var.a = bdUniqueId;
            }
            q68 q68Var = this.y;
            if (q68Var != null) {
                q68Var.b = bdUniqueId;
            }
            p68 p68Var = this.z;
            if (p68Var != null) {
                p68Var.b = bdUniqueId;
            }
            o68 o68Var = this.B;
            if (o68Var != null) {
                o68Var.b = bdUniqueId;
            }
            r68 r68Var = this.A;
            if (r68Var != null) {
                r68Var.b = bdUniqueId;
            }
            h68 h68Var2 = this.C;
            if (h68Var2 != null) {
                h68Var2.b = bdUniqueId;
            }
            l68 l68Var = this.D;
            if (l68Var != null) {
                l68Var.a = bdUniqueId;
            }
            n68 n68Var = this.E;
            if (n68Var != null) {
                n68Var.a = bdUniqueId;
            }
            w58 w58Var = this.F;
            if (w58Var != null) {
                w58Var.b = bdUniqueId;
            }
            x58 x58Var = this.v;
            if (x58Var != null) {
                x58Var.a = bdUniqueId;
            }
            u18 u18Var = this.H;
            if (u18Var != null) {
                u18Var.b = bdUniqueId;
            }
            v18 v18Var = this.I;
            if (v18Var != null) {
                v18Var.b = bdUniqueId;
            }
            w18 w18Var = this.J;
            if (w18Var != null) {
                w18Var.b = bdUniqueId;
            }
            i68 i68Var = this.L;
            if (i68Var != null) {
                i68Var.a = bdUniqueId;
            }
            x18 x18Var = this.M;
            if (x18Var != null) {
                x18Var.b = bdUniqueId;
            }
            y18 y18Var = this.K;
            if (y18Var != null) {
                y18Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.V)) {
                for (om omVar : this.V) {
                    if (omVar instanceof l49) {
                        ((l49) omVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.b0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.b0);
            this.c0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.c0);
            this.d0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.d0);
            if (!this.X) {
                this.a0.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.a0);
            }
        }
    }

    public void z(u78 u78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, u78Var) == null) {
            this.h.E(u78Var);
            this.i.D(u78Var);
            this.j.B(u78Var);
            this.l.B(u78Var);
            this.m.D(u78Var);
            this.q.A(u78Var);
            this.r.C(u78Var);
            this.s.B(u78Var);
            this.t.B(u78Var);
            this.u.E(u78Var);
            this.v.C(u78Var);
        }
    }
}
