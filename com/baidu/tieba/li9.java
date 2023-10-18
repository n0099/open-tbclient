package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.data.PbFirstFloorRecommendData;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorRecommendAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorSimilarTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorWebViewAdapter;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class li9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<nh9> B;
    public mi9 C;
    public ej9 D;
    public rk9 E;
    public PbFirstFloorWebViewAdapter F;
    public oh9 G;
    public ye9 H;
    public ArrayList<pea> I;
    public ArrayList<yh> J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public int f1133T;
    public String U;
    public pea V;
    public pea W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public xi9 c;
    public tg9 c0;
    public yi9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<lh> f0;
    public PbFirstFloorItemAdapter g;
    public final List<lh> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public sk9 j;
    public int j0;
    public pk9 k;
    public int k0;
    public vj9 l;
    public ThreadData l0;
    public ij9 m;
    public List<pea> m0;
    public vj9 n;
    public final CustomMessageListener n0;
    public oi9 o;
    public CustomMessageListener o0;
    public yj9 p;
    public final CustomMessageListener p0;
    public yn9 q;
    public final View.OnClickListener q0;
    public zk6 r;
    public CustomMessageListener r0;
    public lh s;
    public List<lh> s0;
    public lh t;
    public lh u;
    public lh v;
    public lh w;
    public qj9 x;
    public tj9 y;
    public pj9 z;

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li9 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(li9 li9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var, Integer.valueOf(i)};
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
            this.a = li9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !k4.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                boolean z = false;
                Iterator<DownloadData> it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().getStatus() == 0) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    SafeHandler.getInst().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(li9 li9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var, Integer.valueOf(i)};
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
            this.a = li9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof nea)) {
                nea neaVar = (nea) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == neaVar) {
                    this.a.l0.funAdData.p(true);
                    this.a.b.setData(this.a.J);
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(li9 li9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var, Integer.valueOf(i)};
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
            this.a = li9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof eea)) {
                AbsDelegateAdapterList a = ((eea) customResponsedMessage.getData()).a();
                Iterator<lh<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    lh<?, ?> next = it.next();
                    if (next instanceof qi9) {
                        ((qi9) next).t(this.a.a);
                        if (next instanceof nh9) {
                            this.a.B.add((nh9) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.g0.clear();
                this.a.g0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li9 a;

        public d(li9 li9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.T() != null) {
                this.a.a.E6().p1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ li9 b;

        public e(li9 li9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li9Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.j0);
                this.b.R = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(li9 li9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var, Integer.valueOf(i)};
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
            this.a = li9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                li9 li9Var = this.a;
                li9Var.n0(li9Var.H, false);
            }
        }
    }

    public li9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = new ArrayList<>();
        this.I = new ArrayList<>();
        this.K = false;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = false;
        this.S = false;
        this.f1133T = 0;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        this.f0 = new ArrayList();
        this.g0 = new ArrayList();
        this.i0 = -1;
        this.j0 = 0;
        this.k0 = -1;
        this.m0 = new ArrayList();
        this.n0 = new a(this, 2921523);
        this.o0 = new b(this, 2004015);
        this.p0 = new c(this, 2001118);
        this.q0 = new d(this);
        this.r0 = new f(this, 2016470);
        this.f1133T = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = BdUtilHelper.getEquipmentHeight(this.a.getContext()) / 3;
    }

    public final yh Q(ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            oea K0 = this.a.e0().K0();
            if (K0 == null) {
                K0 = this.H.z();
            }
            if (K0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert G1 = K0.G1();
            if (G1 != null) {
                G1.setAdvertAppInfo(K0.getAdvertAppInfo());
            }
            int h = K0.getAdvertAppInfo().h();
            if (h != 0) {
                i1a.j(K0, h);
                if (h != 28 && h != 31) {
                    K0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                K0.i1 = this.H.k().getId();
            }
            if (this.H.O() != null) {
                K0.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
            }
            ye9 ye9Var = this.H;
            if (ye9Var != null && ye9Var.y() != null) {
                K0.m1 = this.H.y().a();
            }
            l(K0);
            if (i < 0) {
                return null;
            }
            K0.p1 = 1;
            h06.k().q(true);
            ez8.b(arrayList, K0, i);
            ye9 ye9Var2 = this.H;
            if (ye9Var2 != null) {
                ye9Var2.N0(K0);
            }
            if (a16.i().q()) {
                a16.i().n(arrayList, i + 1, 4);
            }
            return K0;
        }
        return (yh) invokeLI.objValue;
    }

    public BdUniqueId A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void B0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zVar) == null) {
            this.a0 = zVar;
        }
    }

    public void C0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onLongClickListener) == null) {
            this.d0 = onLongClickListener;
        }
    }

    public void D0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.e0 = fVar;
        }
    }

    public void E0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.Y = onClickListener;
        }
    }

    public void F0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void H0(tg9 tg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tg9Var) == null) {
            this.c0 = tg9Var;
        }
    }

    public void J0(@NonNull ye9 ye9Var) {
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, ye9Var) == null) && (xi9Var = this.c) != null) {
            xi9Var.h0(ye9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, ef9.c);
        }
    }

    public void j0(boolean z) {
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (xi9Var = this.c) != null) {
            xi9Var.T(z);
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.L = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.O = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.M = z;
        }
    }

    public final pea s(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, ye9Var)) == null) {
            if (ye9Var != null) {
                pea U = ye9Var.U();
                this.W = U;
                return U;
            }
            return null;
        }
        return (pea) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.S = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.P = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.Q = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.N = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.R = z;
        }
    }

    public void x0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public void y0(boolean z) {
        oi9 oi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (oi9Var = this.o) != null) {
            oi9Var.x0(z);
        }
    }

    public yh z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (yh) invokeI.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public final void G0(ye9 ye9Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, ye9Var, threadData) == null) && ye9Var != null && ye9Var.K() != null && threadData != null) {
            threadData.setRobotEntrance(ye9Var.K());
        }
    }

    public final int I(cf9 cf9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, cf9Var, i)) == null) {
            if (cf9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (cf9Var.Z()) {
                if (i == 2) {
                    return 1;
                }
                if (i == 3) {
                    return 2;
                }
            }
            return 3;
        }
        return invokeLI.intValue;
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            oi9 oi9Var = this.o;
            if (oi9Var != null) {
                oi9Var.y0(z);
            }
            vj9 vj9Var = this.l;
            if (vj9Var != null) {
                vj9Var.A(z);
            }
            lh lhVar = this.w;
            if (lhVar != null) {
                lhVar.setMulDel(z);
            }
            lh lhVar2 = this.t;
            if (lhVar2 != null) {
                lhVar2.setMulDel(z);
            }
            xi9 xi9Var = this.c;
            if (xi9Var != null) {
                xi9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, peaVar)) == null) {
            if (this.a.e0() != null && peaVar != null && peaVar.U() != null && peaVar.U().equals(this.a.e0().S1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.K = z;
            xi9 xi9Var = this.c;
            if (xi9Var != null) {
                xi9Var.setFromCDN(z);
            }
            lh lhVar = this.t;
            if (lhVar != null && (lhVar instanceof oz9)) {
                ((oz9) lhVar).setIsFromCDN(z);
            }
            Iterator<nh9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final pea r(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<yh> it = arrayList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof pea) {
                    pea peaVar = (pea) next;
                    if (peaVar.L() == 1) {
                        return peaVar;
                    }
                }
            }
            return null;
        }
        return (pea) invokeL.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void I0() {
        ij9 ij9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (ij9Var = this.m) != null) {
            ij9Var.z(2);
        }
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i0;
        }
        return invokeV.intValue;
    }

    public void M0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (i = this.k0) > 0 && T(this.J, i) != null) {
            this.k0 = -1;
            this.b.setData(this.J);
            f0();
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.i0 = D();
            if (this.b.getAdapter2() instanceof ph) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.r0);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.G.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<yh> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.J;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public final int C(ye9 ye9Var, ArrayList<yh> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ye9Var, arrayList)) == null) {
            if (ye9Var == null || ListUtils.isEmpty(ye9Var.F()) || ListUtils.isEmpty(arrayList) || ((pea) ListUtils.getItem(ye9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    yh yhVar = arrayList.get(i);
                    if (yhVar instanceof pea) {
                        pea peaVar = (pea) yhVar;
                        if (peaVar.L() == 1 && peaVar.O == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                } else {
                    z = false;
                    i = 0;
                    break;
                }
            }
            if (!z) {
                return 0;
            }
            return i + 1;
        }
        return invokeLL.intValue;
    }

    public final int H(ye9 ye9Var, ArrayList<yh> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, ye9Var, arrayList)) == null) {
            int i = -1;
            if (ye9Var == null || ye9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (ye9Var.y().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.L) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof nf9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (ye9Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    yh yhVar = this.b.getData().get(i);
                    if (yhVar != null && yhVar.getType() == nf9.g) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.h0);
            vj9 vj9Var = this.l;
            if (vj9Var != null) {
                vj9Var.onDestroy();
            }
            vj9 vj9Var2 = this.n;
            if (vj9Var2 != null) {
                vj9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            pk9 pk9Var = this.k;
            if (pk9Var != null) {
                pk9Var.onDestroy();
            }
            h06.k().q(false);
        }
    }

    public int E(ye9 ye9Var, ArrayList<yh> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, ye9Var, arrayList, z)) == null) {
            if (ye9Var == null || ye9Var.F() == null || ye9Var.C() == null || ye9Var.F().size() == 0 || ye9Var.O() == null || arrayList == null || !ye9Var.C().D1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ye9Var.F().get(0) == null || ye9Var.F().get(0).L() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ye9Var.y() == null || ye9Var.y().a() != ye9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(ye9 ye9Var, ArrayList<yh> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, ye9Var, arrayList, z)) == null) {
            if (ye9Var == null || ye9Var.F() == null || ye9Var.D() == null || ye9Var.F().size() == 0 || ye9Var.O() == null || arrayList == null || !ye9Var.D().D1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ye9Var.F().get(0) == null || ye9Var.F().get(0).L() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ye9Var.y() == null || ye9Var.y().a() != ye9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final yh V(ye9 ye9Var, ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLLI;
        af9 af9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, ye9Var, arrayList, i)) == null) {
            if (ye9Var.k() != null && !StringUtils.isNull(ye9Var.k().getName()) && !ye9Var.m) {
                if (!TextUtils.equals(ye9Var.k().getName(), this.a.e0().R0()) || !this.a.e0().X0()) {
                    if (!this.a.P0() && !ListUtils.isEmpty(ye9Var.o())) {
                        af9Var = new af9(ye9Var.o().get(0));
                    } else {
                        af9Var = new af9(ye9Var.k());
                    }
                    af9Var.g = this.a.e0().M1();
                    ListUtils.add(arrayList, i, af9Var);
                    return af9Var;
                }
                return null;
            }
            return null;
        }
        return (yh) invokeLLI.objValue;
    }

    public final int b0(ye9 ye9Var, ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, ye9Var, arrayList, i)) == null) {
            cf9 cf9Var = new cf9(ye9Var.N());
            String tid = cf9Var.X().getTid();
            int r1 = this.a.e0().r1();
            ye9Var.P0(I(cf9Var, r1));
            df9 df9Var = new df9(cf9Var.V(), cf9Var.W());
            df9Var.a = cf9Var.X();
            df9Var.C = r1;
            df9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, df9Var);
            cf9Var.X().isLinkThread();
            cf9Var.X().isSmartAppThreadType();
            if (!cf9Var.X().isLinkThread() && !cf9Var.X().isSmartAppThreadType()) {
                cf9Var.X().isGodThread();
            }
            cf9Var.a = cf9Var.X();
            cf9Var.C = r1;
            cf9Var.g = tid;
            cf9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, cf9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(ye9 ye9Var, ArrayList<yh> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, ye9Var, arrayList, z)) == null) {
            if (ye9Var != null && !ListUtils.isEmpty(ye9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (ye9Var.F().get(0) != null && ye9Var.F().get(0).L() == 1) {
                    return 1;
                }
                if (ye9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (ye9Var == null || !ye9Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(ye9 ye9Var, ArrayList<yh> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, ye9Var, arrayList, i) == null) {
            nf9 nf9Var = new nf9(nf9.g);
            ThreadData O = ye9Var.O();
            nf9Var.c = this.a.Z6();
            nf9Var.b = ye9Var.g;
            nf9Var.d = ye9Var.j0();
            nf9Var.e = ye9Var.f;
            if (O != null && O.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            nf9Var.f = z;
            ListUtils.add(arrayList, i, nf9Var);
            if (ye9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new mf9());
            }
        }
    }

    public final ArrayList<yh> K(List<yh> list, List<yh> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<yh> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            gf9 gf9Var = new gf9();
            PbListView t1 = this.a.E6().t1();
            if (t1 != null && t1.q()) {
                gf9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1015);
                gf9Var.b = true;
            } else {
                gf9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                gf9Var.b = false;
            }
            arrayList.add(gf9Var);
            cl6 cl6Var = new cl6();
            cl6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            cl6Var.needTopMargin = false;
            arrayList.add(cl6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final void M(ArrayList<yh> arrayList, Boolean bool) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = w65.i();
        int j = w65.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            yh yhVar = arrayList.get(0);
            if ((yhVar instanceof pea) && ((pea) yhVar).L() == 1) {
                z = true;
            } else {
                z = false;
            }
            yh yhVar2 = arrayList.get(arrayList.size() - 1);
            if ((yhVar2 instanceof pea) && ((pea) yhVar2).L() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = w65.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.e0() != null && this.a.e0().D1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(ye9 ye9Var, ArrayList<yh> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, ye9Var, arrayList)) == null) {
            if (!this.P && ye9Var != null && !ListUtils.isEmpty(ye9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.e0() != null && this.a.e0().b1()) {
                    return -1;
                }
                if (this.a.E6() != null && this.a.E6().k1()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        yh yhVar = arrayList.get(i);
                        if (yhVar instanceof pea) {
                            pea peaVar = (pea) yhVar;
                            if (peaVar.L() == 1 && peaVar.O == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    } else {
                        z = false;
                        i = -1;
                        break;
                    }
                }
                if (!z) {
                    if (ye9Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (ye9Var != null && ye9Var.x0() && this.N) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            xi9 xi9Var = this.c;
            if (xi9Var != null && xi9Var.P() != null) {
                if (this.c.P().z != null && this.c.P().z.isShown()) {
                    return this.c.P().z;
                }
                return this.c.P().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new yi9(this.a, pea.W0);
            }
            if (!this.f0.contains(this.d)) {
                this.f0.add(this.d);
            }
            if (this.F == null) {
                P(this.a);
            }
            if (!this.f0.contains(this.F)) {
                this.f0.add(this.F);
            }
        }
    }

    public final void L0() {
        ye9 ye9Var;
        oea oeaVar;
        oea oeaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (ye9Var = this.H) == null || ye9Var.Z || ye9Var.a0 == 2) {
            return;
        }
        ArrayList<pea> F = ye9Var.F();
        ArrayList<oea> d2 = this.H.d();
        if (!ez8.e(F) && !ez8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<oea> it = d2.iterator();
            while (it.hasNext()) {
                oea next = it.next();
                if (next != null && next.E1() != null) {
                    sb.append(next.E1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<oea> it2 = d2.iterator();
            while (it2.hasNext()) {
                oea next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<oea> it3 = d2.iterator();
            while (it3.hasNext()) {
                oea next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        i1a.j(next3, h);
                        if (h != 28 && h != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            d2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                oea oeaVar3 = (oea) sparseArray.valueAt(i);
                if (oeaVar3 != null && (oeaVar2 = (oea) hashMap.put(oeaVar3.D1(), oeaVar3)) != null) {
                    i1a.j(oeaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (oeaVar = (oea) entry.getValue()) != null) {
                    sparseArray.put(oeaVar.getPosition(), oeaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                ez8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < ez8.i(arrayList); i4++) {
                oea oeaVar4 = (oea) sparseArray.get(((Integer) ez8.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    oeaVar4.i1 = this.H.k().getId();
                }
                if (this.H.O() != null) {
                    oeaVar4.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
                }
                ye9 ye9Var2 = this.H;
                if (ye9Var2 != null && ye9Var2.y() != null) {
                    oeaVar4.m1 = this.H.y().a();
                }
                l(oeaVar4);
                int position = oeaVar4.getPosition() + this.H.Y;
                if (position >= ez8.i(F)) {
                    oeaVar4.o1 = position;
                    i1a.k(oeaVar4, 2, position, ez8.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    oeaVar4.o1 = position;
                }
                if (position < 0) {
                    i1a.j(oeaVar4, 23);
                } else {
                    oeaVar4.p1 = i3;
                    ez8.b(F, oeaVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oeaVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        yi9 yi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (ck9.D(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new yi9(pbFragment, pea.W0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                xi9 xi9Var = new xi9(pbFragment, pea.W0);
                this.c = xi9Var;
                xi9Var.f0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, of9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, af9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), bf9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), df9.f1092T);
            this.j = new sk9(pbFragment.getPageContext(), cf9.X0);
            this.k = new pk9(pbFragment, ve9.c);
            this.l = new vj9(pbFragment, nf9.g);
            this.m = new ij9(pbFragment, if9.c);
            this.n = new vj9(pbFragment, nf9.h);
            oi9 oi9Var = new oi9(pbFragment, pea.X0);
            this.o = oi9Var;
            oi9Var.A0(pbFragment);
            yj9 yj9Var = new yj9(pbFragment, pea.Y0);
            this.p = yj9Var;
            yj9Var.A0(pbFragment);
            this.s = tz9.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.y);
            this.t = tz9.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.A);
            this.u = ws7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.v = ws7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = ws7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J);
            this.z = new pj9(pbFragment, kf9.k1);
            this.x = new qj9(pbFragment, oj9.j1);
            this.y = new tj9(pbFragment, qx4.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, pea.e1);
            this.q = new yn9(pbFragment, zn9.a);
            this.r = new zk6(pbFragment.getPageContext());
            this.C = new mi9(pbFragment, aw4.e);
            this.D = new ej9(pbFragment, pbFragment.getUniqueId());
            this.E = new rk9(pbFragment.getPageContext(), f16.g);
            if (ck9.D(pbFragment)) {
                P(pbFragment);
            }
            oh9 oh9Var = new oh9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = oh9Var;
            this.f0.addAll(oh9Var.a());
            if (ck9.D(pbFragment) && (yi9Var = this.d) != null) {
                this.f0.add(yi9Var);
            } else {
                xi9 xi9Var2 = this.c;
                if (xi9Var2 != null) {
                    this.f0.add(xi9Var2);
                }
            }
            this.f0.add(this.e);
            this.f0.add(this.f);
            this.f0.add(this.g);
            this.f0.add(this.h);
            this.f0.add(this.i);
            this.f0.add(this.j);
            this.f0.add(this.k);
            this.f0.add(this.o);
            this.f0.add(this.p);
            this.f0.add(this.l);
            this.f0.add(this.m);
            this.f0.add(this.n);
            this.f0.add(this.s);
            this.f0.add(this.t);
            this.f0.add(this.u);
            this.f0.add(this.v);
            this.f0.add(this.w);
            this.f0.add(this.z);
            this.f0.add(this.x);
            this.f0.add(this.y);
            this.f0.add(this.q);
            this.f0.add(this.A);
            this.f0.add(this.r);
            this.f0.add(this.C);
            this.f0.add(this.D);
            this.f0.add(new PbPrivateTitleAdapter(pbFragment));
            this.f0.add(this.E);
            if (ck9.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new eea(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, ye9Var) == null) {
            xi9 xi9Var = this.c;
            if (xi9Var != null) {
                xi9Var.q(ye9Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1133T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.c0(this.b0);
                this.c.e0(this.c0);
            }
            this.g.y(this.b0);
            this.o.q(ye9Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.z0(this.c0);
            this.p.q(ye9Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.z0(this.c0);
            this.e.W(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            lh lhVar = this.t;
            if (lhVar != null && (lhVar instanceof oz9)) {
                ((oz9) lhVar).setIsFromCDN(this.K);
            }
            Iterator<nh9> it = this.B.iterator();
            while (it.hasNext()) {
                nh9 next = it.next();
                if (next != null) {
                    next.q(ye9Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1133T);
                    next.c(this.M);
                    next.f(this.N);
                    next.p(this.S);
                    next.e(this.Y);
                    next.k(this.X);
                    next.n(this.a0);
                    next.d(this.d0);
                }
            }
            this.l.e(this.Y);
            this.l.B(this.e0);
            this.m.e(this.Z);
            this.n.e(this.Y);
            this.l.q(ye9Var);
            this.k.q(ye9Var);
            this.n.q(ye9Var);
            this.x.q(ye9Var);
            this.y.q(ye9Var);
            this.C.A(ye9Var);
            this.C.z(this.a.u1);
            this.D.y(ye9Var);
        }
    }

    public final boolean R(ye9 ye9Var, ArrayList<yh> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{ye9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(ye9Var.e()) && ye9Var.e().size() > 2) {
                int min = Math.min(ye9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    aw4 aw4Var = ye9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        aw4Var.h(true);
                    }
                    if (aw4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            aw4Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        aw4Var.l(true);
                    } else if (i6 == min - 1) {
                        aw4Var.i(true);
                    }
                    arrayList2.add(aw4Var);
                }
            }
            if (arrayList2.size() > 0) {
                if (z && i >= 0) {
                    i5 = i + 1;
                } else if (z) {
                    i5 = i2 + 2;
                } else if (i2 >= 0) {
                    i5 = i2 + 1;
                } else if (i3 >= 0) {
                    i5 = i3;
                } else if (i4 >= 0) {
                    i5 = i4;
                } else {
                    i5 = -1;
                }
                if (i5 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i5, (yh) arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final yh S(ye9 ye9Var, ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLLI;
        ve9 ve9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, ye9Var, arrayList, i)) == null) {
            if (i >= 0 && ye9Var != null && ye9Var.k && (ve9Var = ye9Var.l) != null) {
                ListUtils.add(arrayList, i, ve9Var);
                return ve9Var;
            }
            return null;
        }
        return (yh) invokeLLI.objValue;
    }

    public final void c0(pea peaVar, ArrayList<yh> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, peaVar, arrayList, i) == null) {
            peaVar.u1(true);
            arrayList.add(i, peaVar);
        }
    }

    public final yh T(ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLI;
        ye9 ye9Var;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (ck9.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (ye9Var = this.H) != null && ye9Var.t0()) {
                String d2 = bt7.e().d("pb_banner");
                if (this.l0 == null && vs7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new nea();
                    ye9 ye9Var2 = this.H;
                    if (ye9Var2 != null) {
                        this.l0.funAdData.m(ye9Var2.l());
                        this.l0.funAdData.r(this.H.Q());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (neaVar = threadData2.funAdData) != null) {
                    neaVar.j(1);
                    h06.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (a16.i().q()) {
                        a16.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (yh) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<yh> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<yh> listIterator = arrayList.listIterator();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (true) {
                str = "";
                if (!listIterator.hasNext()) {
                    break;
                }
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 >= i3) {
                        break;
                    }
                    if (i5 < this.m0.size()) {
                        listIterator.add(this.m0.get(i5));
                    } else {
                        pea peaVar = new pea();
                        nea neaVar = new nea();
                        ye9 ye9Var = this.H;
                        if (ye9Var == null) {
                            str3 = "";
                        } else {
                            str3 = ye9Var.l();
                        }
                        neaVar.m(str3);
                        ye9 ye9Var2 = this.H;
                        if (ye9Var2 != null) {
                            str = ye9Var2.Q();
                        }
                        neaVar.r(str);
                        neaVar.n(true);
                        peaVar.y0 = neaVar;
                        neaVar.j(i7);
                        listIterator.add(peaVar);
                        i7++;
                        this.m0.add(peaVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && a16.i().q()) {
                a16.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                pea peaVar2 = new pea();
                nea neaVar2 = new nea();
                ye9 ye9Var3 = this.H;
                if (ye9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = ye9Var3.l();
                }
                neaVar2.m(str2);
                ye9 ye9Var4 = this.H;
                if (ye9Var4 != null) {
                    str = ye9Var4.Q();
                }
                neaVar2.r(str);
                neaVar2.n(true);
                peaVar2.y0 = neaVar2;
                neaVar2.j(1);
                listIterator.add(peaVar2);
                this.m0.add(peaVar2);
                if (a16.i().q()) {
                    a16.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final yh W(ye9 ye9Var, pea peaVar, ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, ye9Var, peaVar, arrayList, i)) == null) {
            bf9 bf9Var = null;
            if (ye9Var.k() != null && !StringUtils.isNull(ye9Var.k().getName()) && TextUtils.equals(ye9Var.k().getName(), this.a.e0().R0()) && this.a.e0().X0()) {
                return null;
            }
            if (peaVar != null) {
                if (peaVar.t0 != null) {
                    bf9Var = new bf9(peaVar.t0);
                }
            } else {
                pea peaVar2 = this.V;
                if (peaVar2 != null && peaVar2.t0 != null) {
                    bf9Var = new bf9(this.V.t0);
                }
            }
            if (bf9Var != null) {
                bf9Var.b = this.a.e0().M1();
                ListUtils.add(arrayList, i + 1, bf9Var);
            }
            return bf9Var;
        }
        return (yh) invokeLLLI.objValue;
    }

    public final yh X(ye9 ye9Var, pea peaVar, ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, ye9Var, peaVar, arrayList, i)) == null) {
            if (peaVar != null && peaVar.c0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(peaVar.c0());
            } else {
                pea peaVar2 = this.V;
                if (peaVar2 != null && peaVar2.c0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.c0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (ye9Var != null && !TextUtils.isEmpty(ye9Var.Q())) {
                    pbFirstFloorRecommendData.f(ye9Var.Q());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (yh) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                SafeHandler.getInst().post(this.h0);
            }
        }
    }

    public final fj9 Y(ArrayList<yh> arrayList, yh yhVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, yhVar, i, i2)) == null) {
            fj9 B = this.H.B();
            if (B != null) {
                if (yhVar != null) {
                    if (i2 < 0 && yhVar.getType() != AdvertAppInfo.A) {
                        i2 = i + 2;
                    } else if (yhVar.getType() != AdvertAppInfo.A) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof fj9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (fj9) invokeLLII.objValue;
    }

    public final yh a0(ArrayList<yh> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (e0 = this.a.e0()) == null || TextUtils.isEmpty(e0.w1())) {
                return null;
            }
            oea oeaVar = new oea();
            l(oeaVar);
            ListUtils.add(arrayList, i + 1, oeaVar);
            return oeaVar;
        }
        return (yh) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.E6() != null) {
            this.a.E6().C2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        xi9 xi9Var = this.c;
                        if (xi9Var != null) {
                            xi9Var.V();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        lh lhVar = this.t;
                        if (lhVar instanceof jz9) {
                            ((jz9) lhVar).onDestroy();
                        }
                        lh lhVar2 = this.u;
                        if (lhVar2 instanceof jz9) {
                            ((jz9) lhVar2).onDestroy();
                        }
                        lh lhVar3 = this.w;
                        if (lhVar3 instanceof jz9) {
                            ((jz9) lhVar3).onDestroy();
                        }
                        pi9.a().d();
                        return;
                    }
                    return;
                }
                xi9 xi9Var2 = this.c;
                if (xi9Var2 != null) {
                    xi9Var2.W();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                lh lhVar4 = this.t;
                if (lhVar4 instanceof jz9) {
                    ((jz9) lhVar4).onResume();
                }
                lh lhVar5 = this.u;
                if (lhVar5 instanceof jz9) {
                    ((jz9) lhVar5).onResume();
                }
                lh lhVar6 = this.w;
                if (lhVar6 instanceof jz9) {
                    ((jz9) lhVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            xi9 xi9Var3 = this.c;
            if (xi9Var3 != null) {
                xi9Var3.U();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            lh lhVar7 = this.t;
            if (lhVar7 instanceof jz9) {
                ((jz9) lhVar7).onPause();
            }
            lh lhVar8 = this.u;
            if (lhVar8 instanceof jz9) {
                ((jz9) lhVar8).onPause();
            }
            lh lhVar9 = this.w;
            if (lhVar9 instanceof jz9) {
                ((jz9) lhVar9).onPause();
            }
            pi9.a().i(this.a.l0());
            nm5.a().d();
        }
    }

    public final void l(oea oeaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, oeaVar) == null) && oeaVar != null && this.H != null && oeaVar.getAdvertAppInfo() != null) {
            oeaVar.getAdvertAppInfo().i = new ov4();
            if (this.H.y() != null) {
                oeaVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            oeaVar.getAdvertAppInfo().i.a = oeaVar.F1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                oeaVar.getAdvertAppInfo().i.c = k.getId();
                oeaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                oeaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oeaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oeaVar.getAdvertAppInfo().i.g = oeaVar.getAdvertAppInfo().g;
            oeaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<yh> x(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, ye9Var)) == null) {
            if (ye9Var == null || ye9Var.T() == null || ListUtils.isEmpty(ye9Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<pea> list = ye9Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                pea peaVar = list.get(i);
                if (peaVar != null) {
                    peaVar.e0 = true;
                    peaVar.P = true;
                    arrayList.add(peaVar);
                }
            }
            if (ListUtils.getCount(ye9Var.T().b) > 2) {
                yh yhVar = (yh) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (yhVar instanceof pea) {
                    ((pea) yhVar).P = false;
                }
                arrayList.add(new zn9());
            } else {
                yh yhVar2 = (yh) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (yhVar2 instanceof pea) {
                    ((pea) yhVar2).P = true;
                }
            }
            arrayList.add(0, new nf9(nf9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void l0() {
        pea peaVar;
        xi9 xi9Var;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (peaVar = this.V) != null && peaVar.b0() != null && (xi9Var = this.c) != null && xi9Var.P() != null) {
            String Q = this.H.Q();
            String l = this.H.l();
            if (this.H.O() != null) {
                i = this.H.O().getThreadType();
            } else {
                i = 0;
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.e0() == null) {
                str = "";
            } else {
                str = this.a.e0().L0();
            }
            PbFragment pbFragment2 = this.a;
            if (pbFragment2 == null || pbFragment2.e0() == null) {
                str2 = "";
            } else {
                str2 = this.a.e0().x1();
            }
            nm5.a().c(Q, l, this.V.b0(), this.c.P().s, i, str, str2);
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.s0 = new ArrayList();
            ArrayList<BdUniqueId> g = pda.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                wy8 b2 = a09.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.f0.add(b2);
                    this.s0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.s0)) {
                this.b.addAdapters(this.s0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.E6() != null && this.a.l0() != null && this.a.l0().J1() != null) {
            pi9.a().f(this.a.l0().J1().g2(), this.l.x(), this.a.E6().v1(), this.a.l0().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<yh> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof pea) {
                    if (i == 0 && (list.get(i2) instanceof oea)) {
                        i = i2 + 1;
                    }
                    pea peaVar = (pea) list.get(i2);
                    if (!TextUtils.isEmpty(peaVar.Z())) {
                        cx4 cx4Var = new cx4();
                        cx4Var.e(peaVar.Z());
                        list.set(i2, cx4Var);
                    }
                }
            }
            if (i > 0 && a16.i().q()) {
                a16.i().n(list, i, 5);
            }
        }
    }

    public void q(ye9 ye9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, ye9Var) == null) && ye9Var.O() != null && ye9Var.O().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(ye9Var.O().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                ck9.I(this.a, ye9Var.O().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.E6() != null) {
                this.a.E6().M4();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n0(ye9 ye9Var, boolean z) {
        pea peaVar;
        boolean z2;
        boolean z3;
        pea peaVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        fj9 fj9Var;
        boolean z9;
        List<yh> list;
        int i4;
        boolean z10;
        boolean z11;
        yh yhVar;
        int i5;
        boolean z12;
        xi9 xi9Var;
        pea peaVar3;
        pea peaVar4;
        pea peaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048631, this, ye9Var, z) != null) || ye9Var == null) {
            return;
        }
        this.H = ye9Var;
        q(ye9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        ye9 ye9Var2 = this.H;
        if (ye9Var2 != null && ye9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (ye9Var.O() != null && ye9Var.O().getAuthor() != null) {
            this.U = ye9Var.O().getAuthor().getUserId();
        }
        if (this.c == null && !ck9.D(this.a)) {
            return;
        }
        O(ye9Var);
        ArrayList<yh> arrayList = new ArrayList<>(ye9Var.F());
        pea r = r(arrayList);
        if (this.H.O().isQuestionThread()) {
            peaVar = s(ye9Var);
        } else {
            peaVar = null;
        }
        if (peaVar != null) {
            arrayList.remove(peaVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!ct7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.t0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (ye9Var.x0() && r.f0() != null) {
                r.o1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && ye9Var.i() != null) {
            pea i6 = ye9Var.i();
            if (!this.N && ye9Var.x0() && i6.f0() != null) {
                i6.o1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (peaVar5 = this.V) != null && i6.r0 == null) {
                ye9Var.H0(peaVar5);
                peaVar2 = peaVar5;
            } else {
                peaVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            peaVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.u6()) {
            if (ye9Var.F().size() > 0 && (peaVar4 = ye9Var.F().get(0)) != null && peaVar4.L() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int E = E(this.H, arrayList, this.N);
            if (E >= 0) {
                ListUtils.add(arrayList, E, this.H.C());
            }
        }
        int F = F(this.H, arrayList, this.N);
        if (F >= 0) {
            ListUtils.add(arrayList, F, this.H.D());
        }
        pda.f(arrayList, 1);
        int C = C(ye9Var, arrayList);
        if (C >= 0) {
            Z(ye9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(ye9Var, arrayList);
        if (H >= 0) {
            if9 if9Var = new if9(if9.c);
            if9Var.b(true);
            ListUtils.add(arrayList, H, if9Var);
        }
        int w = w(ye9Var, arrayList);
        List<yh> x = x(ye9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            yh yhVar2 = (yh) ListUtils.getItem(arrayList, w);
            if (yhVar2 instanceof pea) {
                ((pea) yhVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(ye9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && ye9Var.S() != null) {
            pea X = ye9Var.X();
            ThreadData c2 = ye9Var.S().c();
            if (X != null && X.v0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure v0 = X.v0();
                VirtualImageCustomState w0 = X.w0();
                c2.setCustomFigure(v0);
                c2.setCustomState(w0);
            }
            G0(this.H, c2);
            ListUtils.add(arrayList, i, ye9Var.S());
            z6 = true;
            z7 = true;
        } else {
            if (peaVar2 != null) {
                peaVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.O().isQuestionThread() && peaVar != null) || (this.H.O().isQuestionThread() && this.W != null)) {
            if (peaVar == null && (peaVar3 = this.W) != null) {
                peaVar = peaVar3;
            }
            if (!arrayList.contains(peaVar)) {
                i++;
                c0(peaVar, arrayList, i);
            }
        }
        if (X(ye9Var, peaVar2, arrayList, i) != null || W(ye9Var, peaVar2, arrayList, i) != null || V(ye9Var, arrayList, i) != null) {
            i++;
        }
        if (S(ye9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && ye9Var.N() != null && ye9Var.N().similar_thread != null && ye9Var.N().similar_thread.id.longValue() > 0) {
            b0(ye9Var, arrayList, i);
        } else {
            if (z2) {
                yh a0 = a0(arrayList, i);
                if (a0 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    if (i >= 0) {
                        i5 = i + 1;
                    } else if (w >= 0) {
                        i5 = w;
                    } else if (C >= 0) {
                        i5 = C;
                    } else {
                        i5 = -1;
                    }
                    yhVar = Q(arrayList, i5);
                    if (yhVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    yhVar = a0;
                    i5 = -1;
                }
                if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12 && this.H.t0()) {
                    this.k0 = i5;
                    if (T(arrayList, i5) != null) {
                        this.k0 = -1;
                        i++;
                    }
                }
                if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                    z8 = z11;
                    i2 = i;
                    fj9Var = null;
                } else {
                    fj9 Y = Y(arrayList, yhVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            fj9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    fj9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                fj9Var = null;
            }
            if (z2) {
                if (fj9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(ye9Var, arrayList, z8, z9, i3, i7, w, C);
                if (fj9Var != null) {
                    fj9Var.n = R;
                }
                if (ck9.D(this.a)) {
                    ef9 ef9Var = new ef9();
                    if (ye9Var.O().getTaskInfoData() != null) {
                        ef9Var.f(ye9Var.O().getTaskInfoData().r());
                        ef9Var.e(ye9Var.O().getTaskInfoData().q());
                    }
                    ez8.b(arrayList, ef9Var, 0);
                    if (!z7 && ye9Var.S() != null) {
                        pea X2 = ye9Var.X();
                        ThreadData c3 = ye9Var.S().c();
                        if (X2 != null && X2.v0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure v02 = X2.v0();
                            VirtualImageCustomState w02 = X2.w0();
                            c3.setCustomFigure(v02);
                            c3.setCustomState(w02);
                        }
                        G0(this.H, c3);
                        ListUtils.add(arrayList, 1, ye9Var.S());
                        z6 = true;
                        z7 = true;
                        xi9Var = this.c;
                        if (xi9Var != null) {
                            xi9Var.d0(!z6);
                        }
                        boolean K0 = K0(peaVar2);
                        if (this.O && !K0) {
                            arrayList.remove(peaVar2);
                            this.O = false;
                        }
                        if (ye9Var.S() != null) {
                            ye9Var.S().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<yh> R2 = ye9Var.R();
                            if (!ListUtils.isEmpty(R2)) {
                                this.b.setData(K(arrayList, R2));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(peaVar2, arrayList, z4)) {
                            List<yh> R3 = ye9Var.R();
                            if (!ListUtils.isEmpty(R3)) {
                                this.b.setData(K(arrayList, R3));
                                return;
                            } else {
                                this.b.setData(arrayList);
                                return;
                            }
                        }
                        return;
                    }
                }
                xi9Var = this.c;
                if (xi9Var != null) {
                }
                boolean K02 = K0(peaVar2);
                if (this.O) {
                    arrayList.remove(peaVar2);
                    this.O = false;
                }
                if (ye9Var.S() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(peaVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (ck9.D(this.a)) {
        }
        xi9Var = this.c;
        if (xi9Var != null) {
        }
        boolean K022 = K0(peaVar2);
        if (this.O) {
        }
        if (ye9Var.S() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(peaVar2, arrayList, z4)) {
        }
    }

    public final boolean t(pea peaVar, ArrayList<yh> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, peaVar, arrayList, z)) == null) {
            if (peaVar == null) {
                pea peaVar2 = this.V;
                if (peaVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, peaVar2);
                } else {
                    pea peaVar3 = new pea();
                    peaVar3.W0(1);
                    ListUtils.add(arrayList, 0, peaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, peaVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
