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
/* loaded from: classes7.dex */
public class p38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j38 A;
    public g38 B;
    public z28 C;
    public d38 D;
    public f38 E;
    public o28 F;
    public m38 G;
    public ny7 H;
    public oy7 I;
    public py7 J;
    public qy7 K;
    public a38 L;
    public m28 M;
    public lm N;
    public lm O;
    public lm P;
    public lm Q;
    public lm R;
    public lm S;

    /* renamed from: T  reason: collision with root package name */
    public lm f1142T;
    public List<lm> U;
    public boolean V;
    public boolean W;
    public f X;
    @Nullable
    public kn Y;
    public CustomMessageListener Z;
    public List<lm> a;
    public CustomMessageListener a0;
    public en b;
    public CustomMessageListener b0;
    public List<ym> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public l28 e;
    public n38 f;
    public n28 g;
    public z28 h;
    public k38 i;
    public t28 j;
    public u28 k;
    public v28 l;
    public e38 m;
    public w28 n;
    public c38 o;
    public y28 p;
    public b38 q;
    public s28 r;
    public r28 s;
    public q28 t;
    public l38 u;
    public p28 v;
    public x28 w;
    public HomePageAlaLiveThreadAdapter x;
    public i38 y;
    public h38 z;

    /* loaded from: classes7.dex */
    public interface f {
        void a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ p38 b;

        /* renamed from: com.baidu.tieba.p38$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0423a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0423a(a aVar) {
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

        public a(p38 p38Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p38Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p38Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Y != null) {
                this.b.Y.e(new RunnableC0423a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p38 p38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p38Var, Integer.valueOf(i)};
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
            this.a = p38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    p38 p38Var = this.a;
                    p38Var.B(p38Var.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(p38 p38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p38Var, Integer.valueOf(i)};
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
            this.a = p38Var;
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(p38 p38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p38Var, Integer.valueOf(i)};
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
            this.a = p38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ry8 ry8Var = new ry8();
                ry8Var.a = String.valueOf(customResponsedMessage.getData());
                ry8Var.b = true;
                this.a.j(ry8Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(p38 p38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p38Var, Integer.valueOf(i)};
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
            this.a = p38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ry8 ry8Var = new ry8();
                ry8Var.a = String.valueOf(customResponsedMessage.getData());
                ry8Var.b = false;
                this.a.j(ry8Var);
            }
        }
    }

    public p38(Context context, en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, enVar};
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
        this.b = enVar;
        this.d = (TbPageContext) l9.a(context);
        l(context);
        A(enVar);
        enVar.addAdapters(this.a);
        if (enVar instanceof RecyclerView) {
            this.Y = new kn((RecyclerView) enVar);
        }
    }

    public void B(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            saa.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.X;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<ym> list) {
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
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (lm lmVar : list) {
            if (lmVar instanceof b46) {
                ((b46) lmVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (lm lmVar : this.a) {
                if (lmVar instanceof dx7) {
                    ((dx7) lmVar).s(aVar);
                }
            }
        }
    }

    public void u(c28 c28Var) {
        u28 u28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, c28Var) == null) && (u28Var = this.k) != null) {
            u28Var.B(c28Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.X = fVar;
        }
    }

    public final void A(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, enVar) == null) {
            this.i.E(enVar);
            this.j.C(enVar);
            this.k.C(enVar);
            this.l.C(enVar);
            this.m.E(enVar);
            this.n.u(enVar);
            this.o.x(enVar);
            this.p.u(enVar);
            this.q.C(enVar);
            this.r.C(enVar);
            this.s.C(enVar);
            this.t.C(enVar);
            this.v.D(enVar);
            this.u.F(enVar);
            this.F.C(enVar);
            this.z.F(enVar);
            this.z.F(enVar);
            this.B.C(enVar);
            this.H.u(enVar);
            this.I.u(enVar);
            this.J.u(enVar);
            this.K.u(enVar);
            this.L.u(enVar);
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            z28 z28Var = this.h;
            if (z28Var != null) {
                z28Var.D(nEGFeedbackEventCallback);
            }
            e38 e38Var = this.m;
            if (e38Var != null) {
                e38Var.C(nEGFeedbackEventCallback);
            }
            u28 u28Var = this.k;
            if (u28Var != null) {
                u28Var.A(nEGFeedbackEventCallback);
            }
            x28 x28Var = this.w;
            if (x28Var != null) {
                x28Var.z(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(nEGFeedbackEventCallback);
            }
            i38 i38Var = this.y;
            if (i38Var != null) {
                i38Var.z(nEGFeedbackEventCallback);
            }
            h38 h38Var = this.z;
            if (h38Var != null) {
                h38Var.E(nEGFeedbackEventCallback);
            }
            g38 g38Var = this.B;
            if (g38Var != null) {
                g38Var.B(nEGFeedbackEventCallback);
            }
            j38 j38Var = this.A;
            if (j38Var != null) {
                j38Var.C(nEGFeedbackEventCallback);
            }
            z28 z28Var2 = this.C;
            if (z28Var2 != null) {
                z28Var2.D(nEGFeedbackEventCallback);
            }
            d38 d38Var = this.D;
            if (d38Var != null) {
                d38Var.C(nEGFeedbackEventCallback);
            }
            f38 f38Var = this.E;
            if (f38Var != null) {
                f38Var.x(nEGFeedbackEventCallback);
            }
            o28 o28Var = this.F;
            if (o28Var != null) {
                o28Var.B(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<ym> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            saa.f(list, 2);
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

    public List<ym> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        en enVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (enVar = this.b) != null) {
            enVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        l38 l38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (l38Var = this.u) != null) {
            l38Var.onPause();
        }
    }

    public void r() {
        l38 l38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (l38Var = this.u) != null) {
            l38Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<lm> list = this.U;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.U = new ArrayList();
            ArrayList<BdUniqueId> g = saa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                vx8 b2 = zy8.d().b(this.d, g.get(i), 2);
                if (this.V) {
                    b2.s(3);
                }
                z28 z28Var = this.h;
                if (z28Var != null && (bdUniqueId = z28Var.b) != null) {
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
        List<ym> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (ym ymVar : list) {
                if ((ymVar instanceof ICardInfo) && ((ICardInfo) ymVar).responseAttention(obj)) {
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
            z28 z28Var = this.h;
            if (z28Var != null) {
                z28Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            v28 v28Var = this.l;
            if (v28Var != null) {
                v28Var.setFromCDN(z);
            }
            p28 p28Var = this.v;
            if (p28Var != null) {
                p28Var.setFromCDN(z);
            }
            lm lmVar = this.O;
            if (lmVar != null && (lmVar instanceof hx9)) {
                ((hx9) lmVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new l28(this.d);
            this.f = new n38(this.d);
            this.g = new n28(this.d, x38.b);
            this.h = new z28(this.d, sn6.r0);
            this.i = new k38(this.d, sn6.E0);
            this.j = new t28(this.d, sn6.M0);
            this.k = new u28(this.d, sn6.F0);
            this.l = new v28(this.d, sn6.N0);
            this.m = new e38(this.d, sn6.L0);
            this.n = new w28(this.d, sn6.O0);
            this.o = new c38(this.d, sn6.P0);
            this.p = new y28(this.d, sn6.Q0);
            this.q = new b38(this.d, sn6.R0);
            this.r = new s28(this.d, sn6.G0);
            this.s = new r28(this.d, sn6.H0);
            this.t = new q28(this.d, sn6.I0);
            this.u = new l38(this.d, tn6.U);
            this.w = new x28(this.d, sn6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, rn6.S0);
            this.G = new m38(this.d, sn6.K0);
            this.y = new i38(this.d, sn6.u0);
            this.z = new h38(this.d, sn6.v0);
            this.A = new j38(this.d, sn6.x0);
            this.B = new g38(this.d, sn6.w0);
            this.C = new z28(this.d, sn6.s0);
            this.D = new d38(this.d, sn6.y0);
            this.E = new f38(this.d, o78.d0);
            this.F = new o28(this.d, nn6.S0);
            this.v = new p28(this.d, sn6.J0);
            this.H = new ny7(this.d, sn6.z0, (byte) 3);
            this.I = new oy7(this.d, sn6.A0, (byte) 3);
            this.J = new py7(this.d, sn6.B0, (byte) 3);
            this.K = new qy7(this.d, sn6.C0);
            this.M = new m28(this.d, i56.g);
            this.L = new a38(this.d, z38.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, p48.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new o38(this.d, b48.h));
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
            this.N = mx9.m().h(this.d, AdvertAppInfo.z, "INDEX");
            this.O = mx9.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.P = mx9.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = mx9.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.R = mx9.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.S = mx9.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.f1142T = mx9.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1142T);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ev7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
                this.a.add(ev7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
            }
            AdvertAppInfo.w.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            n28 n28Var = this.g;
            if (n28Var != null) {
                n28Var.u(bdUniqueId);
            }
            z28 z28Var = this.h;
            if (z28Var != null) {
                z28Var.b = bdUniqueId;
            }
            k38 k38Var = this.i;
            if (k38Var != null) {
                k38Var.b = bdUniqueId;
            }
            t28 t28Var = this.j;
            if (t28Var != null) {
                t28Var.a = bdUniqueId;
            }
            u28 u28Var = this.k;
            if (u28Var != null) {
                u28Var.a = bdUniqueId;
            }
            v28 v28Var = this.l;
            if (v28Var != null) {
                v28Var.a = bdUniqueId;
            }
            e38 e38Var = this.m;
            if (e38Var != null) {
                e38Var.a = bdUniqueId;
            }
            w28 w28Var = this.n;
            if (w28Var != null) {
                w28Var.a = bdUniqueId;
            }
            c38 c38Var = this.o;
            if (c38Var != null) {
                c38Var.a = bdUniqueId;
            }
            y28 y28Var = this.p;
            if (y28Var != null) {
                y28Var.a = bdUniqueId;
            }
            b38 b38Var = this.q;
            if (b38Var != null) {
                b38Var.a = bdUniqueId;
            }
            s28 s28Var = this.r;
            if (s28Var != null) {
                s28Var.a = bdUniqueId;
            }
            r28 r28Var = this.s;
            if (r28Var != null) {
                r28Var.a = bdUniqueId;
            }
            q28 q28Var = this.t;
            if (q28Var != null) {
                q28Var.a = bdUniqueId;
            }
            x28 x28Var = this.w;
            if (x28Var != null) {
                x28Var.b = bdUniqueId;
            }
            l38 l38Var = this.u;
            if (l38Var != null) {
                l38Var.a = bdUniqueId;
            }
            l28 l28Var = this.e;
            if (l28Var != null) {
                l28Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            m38 m38Var = this.G;
            if (m38Var != null) {
                m38Var.a = bdUniqueId;
            }
            i38 i38Var = this.y;
            if (i38Var != null) {
                i38Var.b = bdUniqueId;
            }
            h38 h38Var = this.z;
            if (h38Var != null) {
                h38Var.b = bdUniqueId;
            }
            g38 g38Var = this.B;
            if (g38Var != null) {
                g38Var.b = bdUniqueId;
            }
            j38 j38Var = this.A;
            if (j38Var != null) {
                j38Var.b = bdUniqueId;
            }
            z28 z28Var2 = this.C;
            if (z28Var2 != null) {
                z28Var2.b = bdUniqueId;
            }
            d38 d38Var = this.D;
            if (d38Var != null) {
                d38Var.a = bdUniqueId;
            }
            f38 f38Var = this.E;
            if (f38Var != null) {
                f38Var.a = bdUniqueId;
            }
            o28 o28Var = this.F;
            if (o28Var != null) {
                o28Var.b = bdUniqueId;
            }
            p28 p28Var = this.v;
            if (p28Var != null) {
                p28Var.a = bdUniqueId;
            }
            ny7 ny7Var = this.H;
            if (ny7Var != null) {
                ny7Var.b = bdUniqueId;
            }
            oy7 oy7Var = this.I;
            if (oy7Var != null) {
                oy7Var.b = bdUniqueId;
            }
            py7 py7Var = this.J;
            if (py7Var != null) {
                py7Var.b = bdUniqueId;
            }
            a38 a38Var = this.L;
            if (a38Var != null) {
                a38Var.a = bdUniqueId;
            }
            qy7 qy7Var = this.K;
            if (qy7Var != null) {
                qy7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.U)) {
                for (lm lmVar : this.U) {
                    if (lmVar instanceof vx8) {
                        ((vx8) lmVar).setUniqueId(bdUniqueId);
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

    public void z(m48 m48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, m48Var) == null) {
            this.h.E(m48Var);
            this.i.D(m48Var);
            this.j.B(m48Var);
            this.l.B(m48Var);
            this.m.D(m48Var);
            this.q.B(m48Var);
            this.r.B(m48Var);
            this.s.B(m48Var);
            this.t.B(m48Var);
            this.u.E(m48Var);
            this.v.C(m48Var);
        }
    }
}
