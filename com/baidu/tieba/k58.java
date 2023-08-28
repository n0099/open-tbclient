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
/* loaded from: classes6.dex */
public class k58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e58 A;
    public b58 B;
    public u48 C;
    public y48 D;
    public a58 E;
    public j48 F;
    public h58 G;
    public i08 H;
    public j08 I;
    public k08 J;
    public l08 K;
    public v48 L;
    public h48 M;
    public om N;
    public om O;
    public om P;
    public om Q;
    public om R;
    public om S;

    /* renamed from: T  reason: collision with root package name */
    public om f1142T;
    public List<om> U;
    public boolean V;
    public boolean W;
    public f X;
    @Nullable
    public nn Y;
    public CustomMessageListener Z;
    public List<om> a;
    public CustomMessageListener a0;
    public hn b;
    public CustomMessageListener b0;
    public List<bn> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public g48 e;
    public i58 f;
    public i48 g;
    public u48 h;
    public f58 i;
    public o48 j;
    public p48 k;
    public q48 l;
    public z48 m;
    public r48 n;
    public x48 o;
    public t48 p;
    public w48 q;
    public n48 r;
    public m48 s;
    public l48 t;
    public g58 u;
    public k48 v;
    public s48 w;
    public HomePageAlaLiveThreadAdapter x;
    public d58 y;
    public c58 z;

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k58 b;

        /* renamed from: com.baidu.tieba.k58$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0383a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0383a(a aVar) {
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
                    if (this.a.b.X != null) {
                        this.a.b.X.a();
                    }
                }
            }
        }

        public a(k58 k58Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k58Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Y != null) {
                this.b.Y.e(new RunnableC0383a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k58 k58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Integer.valueOf(i)};
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
            this.a = k58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    k58 k58Var = this.a;
                    k58Var.B(k58Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k58 k58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Integer.valueOf(i)};
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
            this.a = k58Var;
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

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k58 k58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Integer.valueOf(i)};
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
            this.a = k58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                u29 u29Var = new u29();
                u29Var.a = String.valueOf(customResponsedMessage.getData());
                u29Var.b = true;
                this.a.j(u29Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k58 k58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, Integer.valueOf(i)};
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
            this.a = k58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                u29 u29Var = new u29();
                u29Var.a = String.valueOf(customResponsedMessage.getData());
                u29Var.b = false;
                this.a.j(u29Var);
            }
        }
    }

    public k58(Context context, hn hnVar) {
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
        this.Z = new b(this, 2016470);
        this.a0 = new c(this, 2001115);
        this.b0 = new d(this, 2001335);
        this.c0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = hnVar;
        this.d = (TbPageContext) l9.a(context);
        l(context);
        A(hnVar);
        hnVar.addAdapters(this.a);
        if (hnVar instanceof RecyclerView) {
            this.Y = new nn((RecyclerView) hnVar);
        }
    }

    public void B(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            afa.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.X;
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
            if (omVar instanceof s46) {
                ((s46) omVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof yy7) {
                    ((yy7) omVar).s(aVar);
                }
            }
        }
    }

    public void u(x38 x38Var) {
        p48 p48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, x38Var) == null) && (p48Var = this.k) != null) {
            p48Var.B(x38Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.X = fVar;
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
            this.q.C(hnVar);
            this.r.C(hnVar);
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
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            u48 u48Var = this.h;
            if (u48Var != null) {
                u48Var.D(nEGFeedbackEventCallback);
            }
            z48 z48Var = this.m;
            if (z48Var != null) {
                z48Var.C(nEGFeedbackEventCallback);
            }
            p48 p48Var = this.k;
            if (p48Var != null) {
                p48Var.A(nEGFeedbackEventCallback);
            }
            s48 s48Var = this.w;
            if (s48Var != null) {
                s48Var.z(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(nEGFeedbackEventCallback);
            }
            d58 d58Var = this.y;
            if (d58Var != null) {
                d58Var.z(nEGFeedbackEventCallback);
            }
            c58 c58Var = this.z;
            if (c58Var != null) {
                c58Var.E(nEGFeedbackEventCallback);
            }
            b58 b58Var = this.B;
            if (b58Var != null) {
                b58Var.B(nEGFeedbackEventCallback);
            }
            e58 e58Var = this.A;
            if (e58Var != null) {
                e58Var.C(nEGFeedbackEventCallback);
            }
            u48 u48Var2 = this.C;
            if (u48Var2 != null) {
                u48Var2.D(nEGFeedbackEventCallback);
            }
            y48 y48Var = this.D;
            if (y48Var != null) {
                y48Var.C(nEGFeedbackEventCallback);
            }
            a58 a58Var = this.E;
            if (a58Var != null) {
                a58Var.x(nEGFeedbackEventCallback);
            }
            j48 j48Var = this.F;
            if (j48Var != null) {
                j48Var.B(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<bn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            afa.f(list, 2);
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
            this.W = i();
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
        g58 g58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (g58Var = this.u) != null) {
            g58Var.onPause();
        }
    }

    public void r() {
        g58 g58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (g58Var = this.u) != null) {
            g58Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<om> list = this.U;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.U = new ArrayList();
            ArrayList<BdUniqueId> g = afa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                y19 b2 = c39.d().b(this.d, g.get(i), 2);
                if (this.V) {
                    b2.s(3);
                }
                u48 u48Var = this.h;
                if (u48Var != null && (bdUniqueId = u48Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.U.add(b2);
            }
            this.b.addAdapters(this.U);
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
            u48 u48Var = this.h;
            if (u48Var != null) {
                u48Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            q48 q48Var = this.l;
            if (q48Var != null) {
                q48Var.setFromCDN(z);
            }
            k48 k48Var = this.v;
            if (k48Var != null) {
                k48Var.setFromCDN(z);
            }
            om omVar = this.O;
            if (omVar != null && (omVar instanceof m1a)) {
                ((m1a) omVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new g48(this.d);
            this.f = new i58(this.d);
            this.g = new i48(this.d, s58.b);
            this.h = new u48(this.d, zo6.r0);
            this.i = new f58(this.d, zo6.E0);
            this.j = new o48(this.d, zo6.M0);
            this.k = new p48(this.d, zo6.F0);
            this.l = new q48(this.d, zo6.N0);
            this.m = new z48(this.d, zo6.L0);
            this.n = new r48(this.d, zo6.O0);
            this.o = new x48(this.d, zo6.P0);
            this.p = new t48(this.d, zo6.Q0);
            this.q = new w48(this.d, zo6.R0);
            this.r = new n48(this.d, zo6.G0);
            this.s = new m48(this.d, zo6.H0);
            this.t = new l48(this.d, zo6.I0);
            this.u = new g58(this.d, ap6.U);
            this.w = new s48(this.d, zo6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, yo6.S0);
            this.G = new h58(this.d, zo6.K0);
            this.y = new d58(this.d, zo6.u0);
            this.z = new c58(this.d, zo6.v0);
            this.A = new e58(this.d, zo6.x0);
            this.B = new b58(this.d, zo6.w0);
            this.C = new u48(this.d, zo6.s0);
            this.D = new y48(this.d, zo6.y0);
            this.E = new a58(this.d, h98.d0);
            this.F = new j48(this.d, uo6.S0);
            this.v = new k48(this.d, zo6.J0);
            this.H = new i08(this.d, zo6.z0, (byte) 3);
            this.I = new j08(this.d, zo6.A0, (byte) 3);
            this.J = new k08(this.d, zo6.B0, (byte) 3);
            this.K = new l08(this.d, zo6.C0);
            this.M = new h48(this.d, z56.g);
            this.L = new v48(this.d, u58.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, k68.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new j58(this.d, w58.h));
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.v);
            this.a.add(this.H);
            this.a.add(this.I);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.G);
            this.a.add(this.M);
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
            this.N = r1a.m().h(this.d, AdvertAppInfo.z, "INDEX");
            this.O = r1a.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.P = r1a.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = r1a.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.R = r1a.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.S = r1a.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.f1142T = r1a.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1142T);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(zw7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
                this.a.add(zw7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
            }
            AdvertAppInfo.w.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            i48 i48Var = this.g;
            if (i48Var != null) {
                i48Var.u(bdUniqueId);
            }
            u48 u48Var = this.h;
            if (u48Var != null) {
                u48Var.b = bdUniqueId;
            }
            f58 f58Var = this.i;
            if (f58Var != null) {
                f58Var.b = bdUniqueId;
            }
            o48 o48Var = this.j;
            if (o48Var != null) {
                o48Var.a = bdUniqueId;
            }
            p48 p48Var = this.k;
            if (p48Var != null) {
                p48Var.a = bdUniqueId;
            }
            q48 q48Var = this.l;
            if (q48Var != null) {
                q48Var.a = bdUniqueId;
            }
            z48 z48Var = this.m;
            if (z48Var != null) {
                z48Var.a = bdUniqueId;
            }
            r48 r48Var = this.n;
            if (r48Var != null) {
                r48Var.a = bdUniqueId;
            }
            x48 x48Var = this.o;
            if (x48Var != null) {
                x48Var.a = bdUniqueId;
            }
            t48 t48Var = this.p;
            if (t48Var != null) {
                t48Var.a = bdUniqueId;
            }
            w48 w48Var = this.q;
            if (w48Var != null) {
                w48Var.a = bdUniqueId;
            }
            n48 n48Var = this.r;
            if (n48Var != null) {
                n48Var.a = bdUniqueId;
            }
            m48 m48Var = this.s;
            if (m48Var != null) {
                m48Var.a = bdUniqueId;
            }
            l48 l48Var = this.t;
            if (l48Var != null) {
                l48Var.a = bdUniqueId;
            }
            s48 s48Var = this.w;
            if (s48Var != null) {
                s48Var.b = bdUniqueId;
            }
            g58 g58Var = this.u;
            if (g58Var != null) {
                g58Var.a = bdUniqueId;
            }
            g48 g48Var = this.e;
            if (g48Var != null) {
                g48Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            h58 h58Var = this.G;
            if (h58Var != null) {
                h58Var.a = bdUniqueId;
            }
            d58 d58Var = this.y;
            if (d58Var != null) {
                d58Var.b = bdUniqueId;
            }
            c58 c58Var = this.z;
            if (c58Var != null) {
                c58Var.b = bdUniqueId;
            }
            b58 b58Var = this.B;
            if (b58Var != null) {
                b58Var.b = bdUniqueId;
            }
            e58 e58Var = this.A;
            if (e58Var != null) {
                e58Var.b = bdUniqueId;
            }
            u48 u48Var2 = this.C;
            if (u48Var2 != null) {
                u48Var2.b = bdUniqueId;
            }
            y48 y48Var = this.D;
            if (y48Var != null) {
                y48Var.a = bdUniqueId;
            }
            a58 a58Var = this.E;
            if (a58Var != null) {
                a58Var.a = bdUniqueId;
            }
            j48 j48Var = this.F;
            if (j48Var != null) {
                j48Var.b = bdUniqueId;
            }
            k48 k48Var = this.v;
            if (k48Var != null) {
                k48Var.a = bdUniqueId;
            }
            i08 i08Var = this.H;
            if (i08Var != null) {
                i08Var.b = bdUniqueId;
            }
            j08 j08Var = this.I;
            if (j08Var != null) {
                j08Var.b = bdUniqueId;
            }
            k08 k08Var = this.J;
            if (k08Var != null) {
                k08Var.b = bdUniqueId;
            }
            v48 v48Var = this.L;
            if (v48Var != null) {
                v48Var.a = bdUniqueId;
            }
            l08 l08Var = this.K;
            if (l08Var != null) {
                l08Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.U)) {
                for (om omVar : this.U) {
                    if (omVar instanceof y19) {
                        ((y19) omVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.a0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
            this.b0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.b0);
            this.c0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.c0);
            if (!this.W) {
                this.Z.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.Z);
            }
        }
    }

    public void z(h68 h68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, h68Var) == null) {
            this.h.E(h68Var);
            this.i.D(h68Var);
            this.j.B(h68Var);
            this.l.B(h68Var);
            this.m.D(h68Var);
            this.q.B(h68Var);
            this.r.B(h68Var);
            this.s.B(h68Var);
            this.t.B(h68Var);
            this.u.E(h68Var);
            this.v.C(h68Var);
        }
    }
}
