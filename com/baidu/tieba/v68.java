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
public class v68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p68 A;
    public m68 B;
    public f68 C;
    public j68 D;
    public l68 E;
    public u58 F;
    public s68 G;
    public s18 H;
    public t18 I;
    public u18 J;
    public w18 K;
    public g68 L;
    public v18 M;
    public s58 N;
    public pm O;
    public pm P;
    public pm Q;
    public pm R;
    public pm S;

    /* renamed from: T  reason: collision with root package name */
    public pm f1165T;
    public pm U;
    public List<pm> V;
    public boolean W;
    public boolean X;
    public f Y;
    @Nullable
    public on Z;
    public List<pm> a;
    public CustomMessageListener a0;
    public in b;
    public CustomMessageListener b0;
    public List<cn> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public CustomMessageListener d0;
    public r58 e;
    public t68 f;
    public t58 g;
    public f68 h;
    public q68 i;
    public z58 j;
    public a68 k;
    public b68 l;
    public k68 m;
    public c68 n;
    public i68 o;
    public e68 p;
    public h68 q;
    public y58 r;
    public x58 s;
    public w58 t;
    public r68 u;
    public v58 v;
    public d68 w;
    public HomePageAlaLiveThreadAdapter x;
    public o68 y;
    public n68 z;

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
        public final /* synthetic */ v68 b;

        /* renamed from: com.baidu.tieba.v68$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0502a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0502a(a aVar) {
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

        public a(v68 v68Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v68Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v68Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Z != null) {
                this.b.Z.e(new RunnableC0502a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v68 v68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v68Var, Integer.valueOf(i)};
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
            this.a = v68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    v68 v68Var = this.a;
                    v68Var.B(v68Var.c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v68 v68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v68Var, Integer.valueOf(i)};
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
            this.a = v68Var;
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
        public final /* synthetic */ v68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(v68 v68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v68Var, Integer.valueOf(i)};
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
            this.a = v68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                w39 w39Var = new w39();
                w39Var.a = String.valueOf(customResponsedMessage.getData());
                w39Var.b = true;
                this.a.j(w39Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v68 v68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v68Var, Integer.valueOf(i)};
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
            this.a = v68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                w39 w39Var = new w39();
                w39Var.a = String.valueOf(customResponsedMessage.getData());
                w39Var.b = false;
                this.a.j(w39Var);
            }
        }
    }

    public v68(Context context, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, inVar};
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
        this.b = inVar;
        this.d = (TbPageContext) m9.a(context);
        l(context);
        A(inVar);
        inVar.addAdapters(this.a);
        if (inVar instanceof RecyclerView) {
            this.Z = new on((RecyclerView) inVar);
        }
    }

    public void B(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            tga.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.Y;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<cn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        mg.g(new a(this, list));
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n();
            this.e.s(i);
        }
    }

    public final void s(String str) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (pm pmVar : list) {
            if (pmVar instanceof o56) {
                ((o56) pmVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (pm pmVar : this.a) {
                if (pmVar instanceof i08) {
                    ((i08) pmVar).s(aVar);
                }
            }
        }
    }

    public void u(i58 i58Var) {
        a68 a68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, i58Var) == null) && (a68Var = this.k) != null) {
            a68Var.B(i58Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    public final void A(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, inVar) == null) {
            this.i.E(inVar);
            this.j.C(inVar);
            this.k.C(inVar);
            this.l.C(inVar);
            this.m.E(inVar);
            this.n.u(inVar);
            this.o.x(inVar);
            this.p.u(inVar);
            this.q.B(inVar);
            this.r.D(inVar);
            this.s.C(inVar);
            this.t.C(inVar);
            this.v.D(inVar);
            this.u.F(inVar);
            this.F.C(inVar);
            this.z.F(inVar);
            this.z.F(inVar);
            this.B.C(inVar);
            this.H.u(inVar);
            this.I.u(inVar);
            this.J.u(inVar);
            this.K.u(inVar);
            this.L.u(inVar);
            this.M.u(inVar);
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            f68 f68Var = this.h;
            if (f68Var != null) {
                f68Var.D(nEGFeedbackEventCallback);
            }
            k68 k68Var = this.m;
            if (k68Var != null) {
                k68Var.C(nEGFeedbackEventCallback);
            }
            a68 a68Var = this.k;
            if (a68Var != null) {
                a68Var.A(nEGFeedbackEventCallback);
            }
            d68 d68Var = this.w;
            if (d68Var != null) {
                d68Var.z(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(nEGFeedbackEventCallback);
            }
            o68 o68Var = this.y;
            if (o68Var != null) {
                o68Var.z(nEGFeedbackEventCallback);
            }
            n68 n68Var = this.z;
            if (n68Var != null) {
                n68Var.E(nEGFeedbackEventCallback);
            }
            m68 m68Var = this.B;
            if (m68Var != null) {
                m68Var.B(nEGFeedbackEventCallback);
            }
            p68 p68Var = this.A;
            if (p68Var != null) {
                p68Var.C(nEGFeedbackEventCallback);
            }
            f68 f68Var2 = this.C;
            if (f68Var2 != null) {
                f68Var2.D(nEGFeedbackEventCallback);
            }
            j68 j68Var = this.D;
            if (j68Var != null) {
                j68Var.C(nEGFeedbackEventCallback);
            }
            l68 l68Var = this.E;
            if (l68Var != null) {
                l68Var.x(nEGFeedbackEventCallback);
            }
            u58 u58Var = this.F;
            if (u58Var != null) {
                u58Var.B(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<cn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            tga.f(list, 2);
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

    public List<cn> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (inVar = this.b) != null) {
            inVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        r68 r68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (r68Var = this.u) != null) {
            r68Var.onPause();
        }
    }

    public void r() {
        r68 r68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (r68Var = this.u) != null) {
            r68Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<pm> list = this.V;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.V = new ArrayList();
            ArrayList<BdUniqueId> g = tga.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                a39 b2 = e49.d().b(this.d, g.get(i), 2);
                if (this.W) {
                    b2.s(3);
                }
                f68 f68Var = this.h;
                if (f68Var != null && (bdUniqueId = f68Var.b) != null) {
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
        List<cn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (cn cnVar : list) {
                if ((cnVar instanceof ICardInfo) && ((ICardInfo) cnVar).responseAttention(obj)) {
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
            f68 f68Var = this.h;
            if (f68Var != null) {
                f68Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            b68 b68Var = this.l;
            if (b68Var != null) {
                b68Var.setFromCDN(z);
            }
            v58 v58Var = this.v;
            if (v58Var != null) {
                v58Var.setFromCDN(z);
            }
            pm pmVar = this.P;
            if (pmVar != null && (pmVar instanceof d3a)) {
                ((d3a) pmVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new r58(this.d);
            this.f = new t68(this.d);
            this.g = new t58(this.d, d78.b);
            this.h = new f68(this.d, cq6.r0);
            this.i = new q68(this.d, cq6.E0);
            this.j = new z58(this.d, cq6.M0);
            this.k = new a68(this.d, cq6.F0);
            this.l = new b68(this.d, cq6.N0);
            this.m = new k68(this.d, cq6.L0);
            this.n = new c68(this.d, cq6.O0);
            this.o = new i68(this.d, cq6.P0);
            this.p = new e68(this.d, cq6.Q0);
            this.q = new h68(this.d, cq6.R0);
            this.r = new y58(this.d, cq6.G0);
            this.s = new x58(this.d, cq6.H0);
            this.t = new w58(this.d, cq6.I0);
            this.u = new r68(this.d, dq6.U);
            this.w = new d68(this.d, cq6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, bq6.S0);
            this.G = new s68(this.d, cq6.K0);
            this.y = new o68(this.d, cq6.u0);
            this.z = new n68(this.d, cq6.v0);
            this.A = new p68(this.d, cq6.x0);
            this.B = new m68(this.d, cq6.w0);
            this.C = new f68(this.d, cq6.s0);
            this.D = new j68(this.d, cq6.y0);
            this.E = new l68(this.d, ea8.d0);
            this.F = new u58(this.d, xp6.S0);
            this.v = new v58(this.d, cq6.J0);
            this.H = new s18(this.d, cq6.z0, (byte) 3);
            this.I = new t18(this.d, cq6.A0, (byte) 3);
            this.J = new u18(this.d, cq6.B0, (byte) 3);
            this.K = new w18(this.d, cq6.C0);
            this.N = new s58(this.d, v66.g);
            this.L = new g68(this.d, f78.g);
            this.M = new v18(this.d, hq6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, v78.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new u68(this.d, h78.h));
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
            this.O = i3a.m().h(this.d, AdvertAppInfo.z, "INDEX");
            this.P = i3a.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.Q = i3a.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.R = i3a.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.S = i3a.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.f1165T = i3a.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.U = i3a.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1165T);
            this.a.add(this.U);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(jy7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
                this.a.add(jy7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
            }
            AdvertAppInfo.w.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            t58 t58Var = this.g;
            if (t58Var != null) {
                t58Var.u(bdUniqueId);
            }
            f68 f68Var = this.h;
            if (f68Var != null) {
                f68Var.b = bdUniqueId;
            }
            q68 q68Var = this.i;
            if (q68Var != null) {
                q68Var.b = bdUniqueId;
            }
            z58 z58Var = this.j;
            if (z58Var != null) {
                z58Var.a = bdUniqueId;
            }
            a68 a68Var = this.k;
            if (a68Var != null) {
                a68Var.a = bdUniqueId;
            }
            b68 b68Var = this.l;
            if (b68Var != null) {
                b68Var.a = bdUniqueId;
            }
            k68 k68Var = this.m;
            if (k68Var != null) {
                k68Var.a = bdUniqueId;
            }
            c68 c68Var = this.n;
            if (c68Var != null) {
                c68Var.a = bdUniqueId;
            }
            i68 i68Var = this.o;
            if (i68Var != null) {
                i68Var.a = bdUniqueId;
            }
            e68 e68Var = this.p;
            if (e68Var != null) {
                e68Var.a = bdUniqueId;
            }
            h68 h68Var = this.q;
            if (h68Var != null) {
                h68Var.a = bdUniqueId;
            }
            y58 y58Var = this.r;
            if (y58Var != null) {
                y58Var.a = bdUniqueId;
            }
            x58 x58Var = this.s;
            if (x58Var != null) {
                x58Var.a = bdUniqueId;
            }
            w58 w58Var = this.t;
            if (w58Var != null) {
                w58Var.a = bdUniqueId;
            }
            d68 d68Var = this.w;
            if (d68Var != null) {
                d68Var.b = bdUniqueId;
            }
            r68 r68Var = this.u;
            if (r68Var != null) {
                r68Var.a = bdUniqueId;
            }
            r58 r58Var = this.e;
            if (r58Var != null) {
                r58Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            s68 s68Var = this.G;
            if (s68Var != null) {
                s68Var.a = bdUniqueId;
            }
            o68 o68Var = this.y;
            if (o68Var != null) {
                o68Var.b = bdUniqueId;
            }
            n68 n68Var = this.z;
            if (n68Var != null) {
                n68Var.b = bdUniqueId;
            }
            m68 m68Var = this.B;
            if (m68Var != null) {
                m68Var.b = bdUniqueId;
            }
            p68 p68Var = this.A;
            if (p68Var != null) {
                p68Var.b = bdUniqueId;
            }
            f68 f68Var2 = this.C;
            if (f68Var2 != null) {
                f68Var2.b = bdUniqueId;
            }
            j68 j68Var = this.D;
            if (j68Var != null) {
                j68Var.a = bdUniqueId;
            }
            l68 l68Var = this.E;
            if (l68Var != null) {
                l68Var.a = bdUniqueId;
            }
            u58 u58Var = this.F;
            if (u58Var != null) {
                u58Var.b = bdUniqueId;
            }
            v58 v58Var = this.v;
            if (v58Var != null) {
                v58Var.a = bdUniqueId;
            }
            s18 s18Var = this.H;
            if (s18Var != null) {
                s18Var.b = bdUniqueId;
            }
            t18 t18Var = this.I;
            if (t18Var != null) {
                t18Var.b = bdUniqueId;
            }
            u18 u18Var = this.J;
            if (u18Var != null) {
                u18Var.b = bdUniqueId;
            }
            g68 g68Var = this.L;
            if (g68Var != null) {
                g68Var.a = bdUniqueId;
            }
            v18 v18Var = this.M;
            if (v18Var != null) {
                v18Var.b = bdUniqueId;
            }
            w18 w18Var = this.K;
            if (w18Var != null) {
                w18Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.V)) {
                for (pm pmVar : this.V) {
                    if (pmVar instanceof a39) {
                        ((a39) pmVar).setUniqueId(bdUniqueId);
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

    public void z(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, s78Var) == null) {
            this.h.E(s78Var);
            this.i.D(s78Var);
            this.j.B(s78Var);
            this.l.B(s78Var);
            this.m.D(s78Var);
            this.q.A(s78Var);
            this.r.C(s78Var);
            this.s.B(s78Var);
            this.t.B(s78Var);
            this.u.E(s78Var);
            this.v.C(s78Var);
        }
    }
}
