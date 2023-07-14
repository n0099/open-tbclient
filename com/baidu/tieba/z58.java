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
public class z58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t58 A;
    public q58 B;
    public k58 C;
    public n58 D;
    public p58 E;
    public z48 F;
    public w58 G;
    public c18 H;
    public d18 I;
    public e18 J;
    public f18 K;
    public x48 L;
    public ln M;
    public ln N;
    public ln O;
    public ln P;
    public ln Q;
    public ln R;
    public ln S;

    /* renamed from: T  reason: collision with root package name */
    public List<ln> f1188T;
    public boolean U;
    public boolean V;
    public f W;
    @Nullable
    public ko X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<ln> a;
    public CustomMessageListener a0;
    public eo b;
    public CustomMessageListener b0;
    public List<yn> c;
    public TbPageContext<?> d;
    public w48 e;
    public x58 f;
    public y48 g;
    public k58 h;
    public u58 i;
    public e58 j;
    public f58 k;
    public g58 l;
    public o58 m;
    public h58 n;
    public m58 o;
    public j58 p;
    public l58 q;
    public d58 r;
    public c58 s;
    public b58 t;
    public v58 u;
    public a58 v;
    public i58 w;
    public HomePageAlaLiveThreadAdapter x;
    public s58 y;
    public r58 z;

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
        public final /* synthetic */ z58 b;

        /* renamed from: com.baidu.tieba.z58$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0552a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0552a(a aVar) {
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
                    if (this.a.b.W != null) {
                        this.a.b.W.a();
                    }
                }
            }
        }

        public a(z58 z58Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z58Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z58Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.X != null) {
                this.b.X.e(new RunnableC0552a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(z58 z58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z58Var, Integer.valueOf(i)};
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
            this.a = z58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    z58 z58Var = this.a;
                    z58Var.B(z58Var.c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(z58 z58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z58Var, Integer.valueOf(i)};
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
            this.a = z58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.j(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(z58 z58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z58Var, Integer.valueOf(i)};
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
            this.a = z58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                v09 v09Var = new v09();
                v09Var.a = String.valueOf(customResponsedMessage.getData());
                v09Var.b = true;
                this.a.j(v09Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(z58 z58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z58Var, Integer.valueOf(i)};
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
            this.a = z58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                v09 v09Var = new v09();
                v09Var.a = String.valueOf(customResponsedMessage.getData());
                v09Var.b = false;
                this.a.j(v09Var);
            }
        }
    }

    public z58(Context context, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Y = new b(this, 2016470);
        this.Z = new c(this, 2001115);
        this.a0 = new d(this, 2001335);
        this.b0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = eoVar;
        this.d = (TbPageContext) r9.a(context);
        l(context);
        A(eoVar);
        eoVar.addAdapters(this.a);
        if (eoVar instanceof RecyclerView) {
            this.X = new ko((RecyclerView) eoVar);
        }
    }

    public void B(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            xba.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        dh.g(new a(this, list));
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n();
            this.e.s(i);
        }
    }

    public final void s(String str) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof t66) {
                ((t66) lnVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof tz7) {
                    ((tz7) lnVar).s(aVar);
                }
            }
        }
    }

    public void u(o48 o48Var) {
        f58 f58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, o48Var) == null) && (f58Var = this.k) != null) {
            f58Var.B(o48Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public final void A(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eoVar) == null) {
            this.i.E(eoVar);
            this.j.C(eoVar);
            this.k.C(eoVar);
            this.l.C(eoVar);
            this.m.E(eoVar);
            this.n.u(eoVar);
            this.o.x(eoVar);
            this.p.u(eoVar);
            this.q.C(eoVar);
            this.r.C(eoVar);
            this.s.C(eoVar);
            this.t.C(eoVar);
            this.v.D(eoVar);
            this.u.F(eoVar);
            this.F.C(eoVar);
            this.z.F(eoVar);
            this.z.F(eoVar);
            this.B.C(eoVar);
            this.H.u(eoVar);
            this.I.u(eoVar);
            this.J.u(eoVar);
            this.K.u(eoVar);
        }
    }

    public void w(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            k58 k58Var = this.h;
            if (k58Var != null) {
                k58Var.D(bVar);
            }
            o58 o58Var = this.m;
            if (o58Var != null) {
                o58Var.C(bVar);
            }
            f58 f58Var = this.k;
            if (f58Var != null) {
                f58Var.A(bVar);
            }
            i58 i58Var = this.w;
            if (i58Var != null) {
                i58Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            s58 s58Var = this.y;
            if (s58Var != null) {
                s58Var.z(bVar);
            }
            r58 r58Var = this.z;
            if (r58Var != null) {
                r58Var.E(bVar);
            }
            q58 q58Var = this.B;
            if (q58Var != null) {
                q58Var.B(bVar);
            }
            t58 t58Var = this.A;
            if (t58Var != null) {
                t58Var.C(bVar);
            }
            k58 k58Var2 = this.C;
            if (k58Var2 != null) {
                k58Var2.D(bVar);
            }
            n58 n58Var = this.D;
            if (n58Var != null) {
                n58Var.C(bVar);
            }
            p58 p58Var = this.E;
            if (p58Var != null) {
                p58Var.x(bVar);
            }
            z48 z48Var = this.F;
            if (z48Var != null) {
                z48Var.B(bVar);
            }
        }
    }

    public void C(List<yn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            xba.f(list, 2);
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
            this.V = i();
        }
    }

    public List<yn> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (eoVar = this.b) != null) {
            eoVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        v58 v58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (v58Var = this.u) != null) {
            v58Var.onPause();
        }
    }

    public void r() {
        v58 v58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (v58Var = this.u) != null) {
            v58Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<ln> list = this.f1188T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.f1188T = new ArrayList();
            ArrayList<BdUniqueId> g = xba.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                yz8 b2 = d19.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                k58 k58Var = this.h;
                if (k58Var != null && (bdUniqueId = k58Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.f1188T.add(b2);
            }
            this.b.addAdapters(this.f1188T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void j(Object obj) {
        List<yn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (yn ynVar : list) {
                if ((ynVar instanceof ICardInfo) && ((ICardInfo) ynVar).responseAttention(obj)) {
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
            k58 k58Var = this.h;
            if (k58Var != null) {
                k58Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            g58 g58Var = this.l;
            if (g58Var != null) {
                g58Var.setFromCDN(z);
            }
            a58 a58Var = this.v;
            if (a58Var != null) {
                a58Var.setFromCDN(z);
            }
            ln lnVar = this.N;
            if (lnVar != null && (lnVar instanceof py9)) {
                ((py9) lnVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new w48(this.d);
            this.f = new x58(this.d);
            this.g = new y48(this.d, h68.b);
            this.h = new k58(this.d, kq6.r0);
            this.i = new u58(this.d, kq6.E0);
            this.j = new e58(this.d, kq6.M0);
            this.k = new f58(this.d, kq6.F0);
            this.l = new g58(this.d, kq6.N0);
            this.m = new o58(this.d, kq6.L0);
            this.n = new h58(this.d, kq6.O0);
            this.o = new m58(this.d, kq6.P0);
            this.p = new j58(this.d, kq6.Q0);
            this.q = new l58(this.d, kq6.R0);
            this.r = new d58(this.d, kq6.G0);
            this.s = new c58(this.d, kq6.H0);
            this.t = new b58(this.d, kq6.I0);
            this.u = new v58(this.d, lq6.U);
            this.w = new i58(this.d, kq6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, jq6.S0);
            this.G = new w58(this.d, kq6.K0);
            this.y = new s58(this.d, kq6.u0);
            this.z = new r58(this.d, kq6.v0);
            this.A = new t58(this.d, kq6.x0);
            this.B = new q58(this.d, kq6.w0);
            this.C = new k58(this.d, kq6.s0);
            this.D = new n58(this.d, kq6.y0);
            this.E = new p58(this.d, t98.d0);
            this.F = new z48(this.d, fq6.S0);
            this.v = new a58(this.d, kq6.J0);
            this.H = new c18(this.d, kq6.z0, (byte) 3);
            this.I = new d18(this.d, kq6.A0, (byte) 3);
            this.J = new e18(this.d, kq6.B0, (byte) 3);
            this.K = new f18(this.d, kq6.C0);
            this.L = new x48(this.d, a86.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, v68.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new y58(this.d, k68.h));
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.v);
            this.a.add(this.H);
            this.a.add(this.I);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.G);
            this.a.add(this.L);
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
            this.M = uy9.m().h(this.d, AdvertAppInfo.z, "INDEX");
            this.N = uy9.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.O = uy9.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.P = uy9.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.Q = uy9.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.R = uy9.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.S = uy9.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(vx7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
                this.a.add(vx7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
            }
            AdvertAppInfo.w.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            y48 y48Var = this.g;
            if (y48Var != null) {
                y48Var.u(bdUniqueId);
            }
            k58 k58Var = this.h;
            if (k58Var != null) {
                k58Var.b = bdUniqueId;
            }
            u58 u58Var = this.i;
            if (u58Var != null) {
                u58Var.b = bdUniqueId;
            }
            e58 e58Var = this.j;
            if (e58Var != null) {
                e58Var.a = bdUniqueId;
            }
            f58 f58Var = this.k;
            if (f58Var != null) {
                f58Var.a = bdUniqueId;
            }
            g58 g58Var = this.l;
            if (g58Var != null) {
                g58Var.a = bdUniqueId;
            }
            o58 o58Var = this.m;
            if (o58Var != null) {
                o58Var.a = bdUniqueId;
            }
            h58 h58Var = this.n;
            if (h58Var != null) {
                h58Var.a = bdUniqueId;
            }
            m58 m58Var = this.o;
            if (m58Var != null) {
                m58Var.a = bdUniqueId;
            }
            j58 j58Var = this.p;
            if (j58Var != null) {
                j58Var.a = bdUniqueId;
            }
            l58 l58Var = this.q;
            if (l58Var != null) {
                l58Var.a = bdUniqueId;
            }
            d58 d58Var = this.r;
            if (d58Var != null) {
                d58Var.a = bdUniqueId;
            }
            c58 c58Var = this.s;
            if (c58Var != null) {
                c58Var.a = bdUniqueId;
            }
            b58 b58Var = this.t;
            if (b58Var != null) {
                b58Var.a = bdUniqueId;
            }
            i58 i58Var = this.w;
            if (i58Var != null) {
                i58Var.b = bdUniqueId;
            }
            v58 v58Var = this.u;
            if (v58Var != null) {
                v58Var.a = bdUniqueId;
            }
            w48 w48Var = this.e;
            if (w48Var != null) {
                w48Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            w58 w58Var = this.G;
            if (w58Var != null) {
                w58Var.a = bdUniqueId;
            }
            s58 s58Var = this.y;
            if (s58Var != null) {
                s58Var.b = bdUniqueId;
            }
            r58 r58Var = this.z;
            if (r58Var != null) {
                r58Var.b = bdUniqueId;
            }
            q58 q58Var = this.B;
            if (q58Var != null) {
                q58Var.b = bdUniqueId;
            }
            t58 t58Var = this.A;
            if (t58Var != null) {
                t58Var.b = bdUniqueId;
            }
            k58 k58Var2 = this.C;
            if (k58Var2 != null) {
                k58Var2.b = bdUniqueId;
            }
            n58 n58Var = this.D;
            if (n58Var != null) {
                n58Var.a = bdUniqueId;
            }
            p58 p58Var = this.E;
            if (p58Var != null) {
                p58Var.a = bdUniqueId;
            }
            z48 z48Var = this.F;
            if (z48Var != null) {
                z48Var.b = bdUniqueId;
            }
            a58 a58Var = this.v;
            if (a58Var != null) {
                a58Var.a = bdUniqueId;
            }
            c18 c18Var = this.H;
            if (c18Var != null) {
                c18Var.b = bdUniqueId;
            }
            d18 d18Var = this.I;
            if (d18Var != null) {
                d18Var.b = bdUniqueId;
            }
            e18 e18Var = this.J;
            if (e18Var != null) {
                e18Var.b = bdUniqueId;
            }
            f18 f18Var = this.K;
            if (f18Var != null) {
                f18Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.f1188T)) {
                for (ln lnVar : this.f1188T) {
                    if (lnVar instanceof yz8) {
                        ((yz8) lnVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            this.a0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
            this.b0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.b0);
            if (!this.V) {
                this.Y.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.Y);
            }
        }
    }

    public void z(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, s68Var) == null) {
            this.h.E(s68Var);
            this.i.D(s68Var);
            this.j.B(s68Var);
            this.l.B(s68Var);
            this.m.D(s68Var);
            this.q.B(s68Var);
            this.r.B(s68Var);
            this.s.B(s68Var);
            this.t.B(s68Var);
            this.u.E(s68Var);
            this.v.C(s68Var);
        }
    }
}
