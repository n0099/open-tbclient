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
/* loaded from: classes6.dex */
public class mb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<oa9> B;
    public nb9 C;
    public ec9 D;
    public rd9 E;
    public PbFirstFloorWebViewAdapter F;
    public pa9 G;
    public u89 H;
    public ArrayList<n4a> I;
    public ArrayList<xn> J;
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
    public int f1132T;
    public String U;
    public n4a V;
    public n4a W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public yb9 c;
    public ba9 c0;
    public zb9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<kn> f0;
    public PbFirstFloorItemAdapter g;
    public final List<kn> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public sd9 j;
    public int j0;
    public pd9 k;
    public int k0;
    public uc9 l;
    public ThreadData l0;
    public ic9 m;
    public List<n4a> m0;
    public uc9 n;
    public final CustomMessageListener n0;
    public pb9 o;
    public CustomMessageListener o0;
    public xc9 p;
    public final CustomMessageListener p0;
    public sg9 q;
    public final View.OnClickListener q0;
    public np6 r;
    public CustomMessageListener r0;
    public kn s;
    public List<kn> s0;
    public kn t;
    public kn u;
    public kn v;
    public kn w;
    public qc9 x;
    public sc9 y;
    public pc9 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb9 a;

        /* loaded from: classes6.dex */
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
        public c(mb9 mb9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb9Var, Integer.valueOf(i)};
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
            this.a = mb9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !r9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    yg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mb9 mb9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb9Var, Integer.valueOf(i)};
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
            this.a = mb9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof l4a)) {
                l4a l4aVar = (l4a) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == l4aVar) {
                    this.a.l0.funAdData.p(true);
                    this.a.b.setData(this.a.J);
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mb9 mb9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb9Var, Integer.valueOf(i)};
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
            this.a = mb9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof c4a)) {
                AbsDelegateAdapterList a = ((c4a) customResponsedMessage.getData()).a();
                Iterator<kn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    kn<?, ?> next = it.next();
                    if (next instanceof rb9) {
                        ((rb9) next).t(this.a.a);
                        if (next instanceof oa9) {
                            this.a.B.add((oa9) next);
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb9 a;

        public d(mb9 mb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mb9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.S() != null) {
                this.a.a.L5().Z0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ mb9 b;

        public e(mb9 mb9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mb9Var;
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

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(mb9 mb9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb9Var, Integer.valueOf(i)};
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
            this.a = mb9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                mb9 mb9Var = this.a;
                mb9Var.o0(mb9Var.H, false);
            }
        }
    }

    public mb9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1132T = 0;
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
        this.f1132T = xi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = xi.j(this.a.getContext()) / 3;
    }

    public final xn Q(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            m4a R0 = this.a.Q().R0();
            if (R0 == null) {
                R0 = this.H.z();
            }
            if (R0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert C1 = R0.C1();
            if (C1 != null) {
                C1.setAdvertAppInfo(R0.getAdvertAppInfo());
            }
            int i2 = R0.getAdvertAppInfo().i();
            if (i2 != 0) {
                bu9.j(R0, i2);
                if (i2 != 28 && i2 != 31) {
                    R0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                R0.i1 = this.H.k().getId();
            }
            if (this.H.N() != null) {
                R0.l1 = vg.g(this.H.N().getId(), 0L);
            }
            u89 u89Var = this.H;
            if (u89Var != null && u89Var.y() != null) {
                R0.m1 = this.H.y().a();
            }
            l(R0);
            if (i < 0) {
                return null;
            }
            R0.p1 = 1;
            y56.k().q(true);
            du8.b(arrayList, R0, i);
            u89 u89Var2 = this.H;
            if (u89Var2 != null) {
                u89Var2.L0(R0);
            }
            if (r66.i().q()) {
                r66.i().n(arrayList, i + 1, 4);
            }
            return R0;
        }
        return (xn) invokeLI.objValue;
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

    public void A0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public void C0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            this.a0 = zVar;
        }
    }

    public void D0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.d0 = onLongClickListener;
        }
    }

    public void E0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.e0 = fVar;
        }
    }

    public void F0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.Y = onClickListener;
        }
    }

    public void G0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void H0(ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ba9Var) == null) {
            this.c0 = ba9Var;
        }
    }

    public void J0(@NonNull u89 u89Var) {
        yb9 yb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, u89Var) == null) && (yb9Var = this.c) != null) {
            yb9Var.i0(u89Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, a99.c);
        }
    }

    public void j0(boolean z) {
        yb9 yb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (yb9Var = this.c) != null) {
            yb9Var.V(z);
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.L = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.O = z;
        }
    }

    public final n4a s(u89 u89Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, u89Var)) == null) {
            if (u89Var != null && u89Var.T() != null) {
                n4a T2 = u89Var.T();
                this.W = T2;
                return T2;
            }
            return null;
        }
        return (n4a) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.M = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.S = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.P = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.Q = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.N = z;
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.R = z;
        }
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public xn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (xn) invokeI.objValue;
    }

    public void z0(boolean z) {
        pb9 pb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z) == null) && (pb9Var = this.o) != null) {
            pb9Var.q0(z);
        }
    }

    public final int I(y89 y89Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, y89Var, i)) == null) {
            if (y89Var.e0()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (y89Var.f0()) {
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

    public final void n0(n4a n4aVar, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048631, this, n4aVar, threadData) == null) && n4aVar != null && n4aVar.x() != null && threadData != null && threadData.getCallRobotEntrance() == null) {
            threadData.setCallRobotEntrance(n4aVar.x());
        }
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
        ic9 ic9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (ic9Var = this.m) != null) {
            ic9Var.z(2);
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
            if (this.b.getAdapter2() instanceof on) {
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

    public ArrayList<xn> v() {
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

    public void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            pb9 pb9Var = this.o;
            if (pb9Var != null) {
                pb9Var.r0(z);
            }
            uc9 uc9Var = this.l;
            if (uc9Var != null) {
                uc9Var.A(z);
            }
            kn knVar = this.w;
            if (knVar != null) {
                knVar.setMulDel(z);
            }
            kn knVar2 = this.t;
            if (knVar2 != null) {
                knVar2.setMulDel(z);
            }
            yb9 yb9Var = this.c;
            if (yb9Var != null) {
                yb9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, n4aVar)) == null) {
            if (this.a.Q() != null && n4aVar != null && n4aVar.S() != null && n4aVar.S().equals(this.a.Q().X1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.K = z;
            yb9 yb9Var = this.c;
            if (yb9Var != null) {
                yb9Var.setFromCDN(z);
            }
            kn knVar = this.t;
            if (knVar != null && (knVar instanceof is9)) {
                ((is9) knVar).setIsFromCDN(z);
            }
            Iterator<oa9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final n4a r(ArrayList<xn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<xn> it = arrayList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof n4a) {
                    n4a n4aVar = (n4a) next;
                    if (n4aVar.I() == 1) {
                        return n4aVar;
                    }
                }
            }
            return null;
        }
        return (n4a) invokeL.objValue;
    }

    public final int C(u89 u89Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, u89Var, arrayList)) == null) {
            if (u89Var == null || ListUtils.isEmpty(u89Var.F()) || ListUtils.isEmpty(arrayList) || ((n4a) ListUtils.getItem(u89Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    xn xnVar = arrayList.get(i);
                    if (xnVar instanceof n4a) {
                        n4a n4aVar = (n4a) xnVar;
                        if (n4aVar.I() == 1 && n4aVar.O == 0) {
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

    public final int H(u89 u89Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, u89Var, arrayList)) == null) {
            int i = -1;
            if (u89Var == null || u89Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (u89Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof j99) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (u89Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void M(ArrayList<xn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = nc5.i();
        int j = nc5.j() - 1;
        if (bool.booleanValue()) {
            xn xnVar = arrayList.get(0);
            if ((xnVar instanceof n4a) && ((n4a) xnVar).I() == 1) {
                j++;
            }
        }
        int k = nc5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.Q() != null && this.a.Q().I1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    xn xnVar = this.b.getData().get(i);
                    if (xnVar != null && xnVar.getType() == j99.g) {
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
            yg.a().removeCallbacks(this.h0);
            uc9 uc9Var = this.l;
            if (uc9Var != null) {
                uc9Var.onDestroy();
            }
            uc9 uc9Var2 = this.n;
            if (uc9Var2 != null) {
                uc9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            pd9 pd9Var = this.k;
            if (pd9Var != null) {
                pd9Var.onDestroy();
            }
            y56.k().q(false);
        }
    }

    public int E(u89 u89Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, u89Var, arrayList, z)) == null) {
            if (u89Var == null || u89Var.F() == null || u89Var.C() == null || u89Var.F().size() == 0 || u89Var.N() == null || arrayList == null || !u89Var.C().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (u89Var.F().get(0) == null || u89Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (u89Var.y() == null || u89Var.y().a() != u89Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(u89 u89Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, u89Var, arrayList, z)) == null) {
            if (u89Var == null || u89Var.F() == null || u89Var.D() == null || u89Var.F().size() == 0 || u89Var.N() == null || arrayList == null || !u89Var.D().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (u89Var.F().get(0) == null || u89Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (u89Var.y() == null || u89Var.y().a() != u89Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final xn V(u89 u89Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        w89 w89Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, u89Var, arrayList, i)) == null) {
            if (u89Var.k() != null && !StringUtils.isNull(u89Var.k().getName()) && !u89Var.m) {
                if (!TextUtils.equals(u89Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1()) {
                    if (!this.a.z0() && !ListUtils.isEmpty(u89Var.o())) {
                        w89Var = new w89(u89Var.o().get(0));
                    } else {
                        w89Var = new w89(u89Var.k());
                    }
                    w89Var.g = this.a.Q().R1();
                    if (!UbsABTestHelper.isPbEnterForum()) {
                        i++;
                    }
                    ListUtils.add(arrayList, i, w89Var);
                    return w89Var;
                }
                return null;
            }
            return null;
        }
        return (xn) invokeLLI.objValue;
    }

    public final int b0(u89 u89Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, u89Var, arrayList, i)) == null) {
            y89 y89Var = new y89(u89Var.M());
            String tid = y89Var.d0().getTid();
            int x1 = this.a.Q().x1();
            u89Var.N0(I(y89Var, x1));
            z89 z89Var = new z89(y89Var.b0(), y89Var.c0());
            z89Var.a = y89Var.d0();
            z89Var.C = x1;
            z89Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, z89Var);
            y89Var.d0().isLinkThread();
            y89Var.d0().isSmartAppThreadType();
            if (!y89Var.d0().isLinkThread() && !y89Var.d0().isSmartAppThreadType()) {
                y89Var.d0().isGodThread();
            }
            y89Var.a = y89Var.d0();
            y89Var.C = x1;
            y89Var.g = tid;
            y89Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, y89Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(u89 u89Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, u89Var, arrayList, z)) == null) {
            if (u89Var != null && !ListUtils.isEmpty(u89Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (u89Var.F().get(0) != null && u89Var.F().get(0).I() == 1) {
                    return 1;
                }
                if (u89Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (u89Var == null || !u89Var.w0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(u89 u89Var, ArrayList<xn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, u89Var, arrayList, i) == null) {
            j99 j99Var = new j99(j99.g);
            ThreadData N = u89Var.N();
            j99Var.c = this.a.d6();
            j99Var.b = u89Var.g;
            j99Var.d = u89Var.i0();
            j99Var.e = u89Var.f;
            if (N != null && N.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            j99Var.f = z;
            ListUtils.add(arrayList, i, j99Var);
            if (u89Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new i99());
            }
        }
    }

    public final ArrayList<xn> K(List<xn> list, List<xn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            c99 c99Var = new c99();
            PbListView d1 = this.a.L5().d1();
            if (d1 != null && d1.q()) {
                c99Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fd0);
                c99Var.b = true;
            } else {
                c99Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                c99Var.b = false;
            }
            arrayList.add(c99Var);
            qp6 qp6Var = new qp6();
            qp6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            qp6Var.needTopMargin = false;
            arrayList.add(qp6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final int w(u89 u89Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, u89Var, arrayList)) == null) {
            if (!this.P && u89Var != null && !ListUtils.isEmpty(u89Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.Q() != null && this.a.Q().h1()) {
                    return -1;
                }
                if (this.a.L5() != null && this.a.L5().V0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        xn xnVar = arrayList.get(i);
                        if (xnVar instanceof n4a) {
                            n4a n4aVar = (n4a) xnVar;
                            if (n4aVar.I() == 1 && n4aVar.O == 0) {
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
                    if (u89Var.w0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (u89Var != null && u89Var.w0() && this.N) {
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
            yb9 yb9Var = this.c;
            if (yb9Var != null && yb9Var.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void l0() {
        n4a n4aVar;
        yb9 yb9Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (n4aVar = this.V) != null && n4aVar.a0() != null && (yb9Var = this.c) != null && yb9Var.Q() != null) {
            String P = this.H.P();
            String l = this.H.l();
            if (this.H.N() != null) {
                i = this.H.N().getThreadType();
            } else {
                i = 0;
            }
            rr5.a().c(P, l, this.V.a0(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new zb9(this.a, n4a.W0);
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
        u89 u89Var;
        m4a m4aVar;
        m4a m4aVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (u89Var = this.H) == null || u89Var.Z || u89Var.a0 == 2) {
            return;
        }
        ArrayList<n4a> F = u89Var.F();
        ArrayList<m4a> d2 = this.H.d();
        if (!du8.e(F) && !du8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<m4a> it = d2.iterator();
            while (it.hasNext()) {
                m4a next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<m4a> it2 = d2.iterator();
            while (it2.hasNext()) {
                m4a next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<m4a> it3 = d2.iterator();
            while (it3.hasNext()) {
                m4a next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        bu9.j(next3, i);
                        if (i != 28 && i != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            d2.clear();
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                m4a m4aVar3 = (m4a) sparseArray.valueAt(i2);
                if (m4aVar3 != null && (m4aVar2 = (m4a) hashMap.put(m4aVar3.z1(), m4aVar3)) != null) {
                    bu9.j(m4aVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (m4aVar = (m4a) entry.getValue()) != null) {
                    sparseArray.put(m4aVar.getPosition(), m4aVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                du8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < du8.i(arrayList); i5++) {
                m4a m4aVar4 = (m4a) sparseArray.get(((Integer) du8.d(arrayList, i5)).intValue());
                if (this.H.k() != null) {
                    m4aVar4.i1 = this.H.k().getId();
                }
                if (this.H.N() != null) {
                    m4aVar4.l1 = vg.g(this.H.N().getId(), 0L);
                }
                u89 u89Var2 = this.H;
                if (u89Var2 != null && u89Var2.y() != null) {
                    m4aVar4.m1 = this.H.y().a();
                }
                l(m4aVar4);
                int position = m4aVar4.getPosition() + this.H.Y;
                if (position >= du8.i(F)) {
                    m4aVar4.o1 = position;
                    bu9.k(m4aVar4, 2, position, du8.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    m4aVar4.o1 = position;
                }
                if (position < 0) {
                    bu9.j(m4aVar4, 23);
                } else {
                    m4aVar4.p1 = i4;
                    du8.b(F, m4aVar4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", m4aVar4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        zb9 zb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (cd9.D(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new zb9(pbFragment, n4a.W0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                yb9 yb9Var = new yb9(pbFragment, n4a.W0);
                this.c = yb9Var;
                yb9Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, k99.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, w89.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), x89.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), z89.f1189T);
            this.j = new sd9(pbFragment.getPageContext(), y89.W0);
            this.k = new pd9(pbFragment, r89.c);
            this.l = new uc9(pbFragment, j99.g);
            this.m = new ic9(pbFragment, e99.c);
            this.n = new uc9(pbFragment, j99.h);
            pb9 pb9Var = new pb9(pbFragment, n4a.X0);
            this.o = pb9Var;
            pb9Var.t0(pbFragment);
            xc9 xc9Var = new xc9(pbFragment, n4a.Y0);
            this.p = xc9Var;
            xc9Var.v0(pbFragment);
            this.s = ns9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.t = ns9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.u = gt7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.v = gt7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.w = gt7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.z = new pc9(pbFragment, g99.k1);
            this.x = new qc9(pbFragment, oc9.j1);
            this.y = new sc9(pbFragment, s35.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, n4a.e1);
            this.q = new sg9(pbFragment, tg9.a);
            this.r = new np6(pbFragment.getPageContext());
            this.C = new nb9(pbFragment, c25.e);
            this.D = new ec9(pbFragment, pbFragment.getUniqueId());
            this.E = new rd9(pbFragment.getPageContext(), w66.g);
            if (cd9.D(pbFragment)) {
                P(pbFragment);
            }
            pa9 pa9Var = new pa9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = pa9Var;
            this.f0.addAll(pa9Var.a());
            if (cd9.D(pbFragment) && (zb9Var = this.d) != null) {
                this.f0.add(zb9Var);
            } else {
                yb9 yb9Var2 = this.c;
                if (yb9Var2 != null) {
                    this.f0.add(yb9Var2);
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
            if (cd9.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new c4a(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, u89Var) == null) {
            yb9 yb9Var = this.c;
            if (yb9Var != null) {
                yb9Var.r(u89Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1132T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(u89Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.s0(this.c0);
            this.p.r(u89Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.u0(this.c0);
            this.e.W(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            kn knVar = this.t;
            if (knVar != null && (knVar instanceof is9)) {
                ((is9) knVar).setIsFromCDN(this.K);
            }
            Iterator<oa9> it = this.B.iterator();
            while (it.hasNext()) {
                oa9 next = it.next();
                if (next != null) {
                    next.r(u89Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1132T);
                    next.c(this.M);
                    next.f(this.N);
                    next.q(this.S);
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
            this.l.r(u89Var);
            this.k.r(u89Var);
            this.n.r(u89Var);
            this.x.r(u89Var);
            this.y.r(u89Var);
            this.C.A(u89Var);
            this.C.z(this.a.s1);
            this.D.y(u89Var);
        }
    }

    public final boolean R(u89 u89Var, ArrayList<xn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{u89Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(u89Var.e()) && u89Var.e().size() > 2) {
                int min = Math.min(u89Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    c25 c25Var = u89Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        c25Var.i(true);
                    }
                    if (c25Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            c25Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        c25Var.l(true);
                    } else if (i6 == min - 1) {
                        c25Var.k(true);
                    }
                    arrayList2.add(c25Var);
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
                        ListUtils.add(arrayList, i5, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final xn S(u89 u89Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        r89 r89Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, u89Var, arrayList, i)) == null) {
            if (i >= 0 && u89Var != null && u89Var.k && (r89Var = u89Var.l) != null) {
                ListUtils.add(arrayList, i, r89Var);
                return r89Var;
            }
            return null;
        }
        return (xn) invokeLLI.objValue;
    }

    public final void c0(n4a n4aVar, ArrayList<xn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, n4aVar, arrayList, i) == null) {
            n4aVar.q1(true);
            arrayList.add(i, n4aVar);
        }
    }

    public final xn T(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        u89 u89Var;
        l4a l4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (cd9.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (u89Var = this.H) != null && u89Var.s0()) {
                String d2 = lt7.e().d("pb_banner");
                if (this.l0 == null && ft7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new l4a();
                    u89 u89Var2 = this.H;
                    if (u89Var2 != null) {
                        this.l0.funAdData.m(u89Var2.l());
                        this.l0.funAdData.r(this.H.P());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (l4aVar = threadData2.funAdData) != null) {
                    l4aVar.j(1);
                    y56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (r66.i().q()) {
                        r66.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (xn) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<xn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<xn> listIterator = arrayList.listIterator();
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
                        n4a n4aVar = new n4a();
                        l4a l4aVar = new l4a();
                        u89 u89Var = this.H;
                        if (u89Var == null) {
                            str3 = "";
                        } else {
                            str3 = u89Var.l();
                        }
                        l4aVar.m(str3);
                        u89 u89Var2 = this.H;
                        if (u89Var2 != null) {
                            str = u89Var2.P();
                        }
                        l4aVar.r(str);
                        l4aVar.n(true);
                        n4aVar.x0 = l4aVar;
                        l4aVar.j(i7);
                        listIterator.add(n4aVar);
                        i7++;
                        this.m0.add(n4aVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && r66.i().q()) {
                r66.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                n4a n4aVar2 = new n4a();
                l4a l4aVar2 = new l4a();
                u89 u89Var3 = this.H;
                if (u89Var3 == null) {
                    str2 = "";
                } else {
                    str2 = u89Var3.l();
                }
                l4aVar2.m(str2);
                u89 u89Var4 = this.H;
                if (u89Var4 != null) {
                    str = u89Var4.P();
                }
                l4aVar2.r(str);
                l4aVar2.n(true);
                n4aVar2.x0 = l4aVar2;
                l4aVar2.j(1);
                listIterator.add(n4aVar2);
                this.m0.add(n4aVar2);
                if (r66.i().q()) {
                    r66.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final xn W(u89 u89Var, n4a n4aVar, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, u89Var, n4aVar, arrayList, i)) == null) {
            x89 x89Var = null;
            if (u89Var.k() != null && !StringUtils.isNull(u89Var.k().getName()) && TextUtils.equals(u89Var.k().getName(), this.a.Q().X0()) && this.a.Q().d1()) {
                return null;
            }
            if (n4aVar != null) {
                if (n4aVar.s0 != null) {
                    x89Var = new x89(n4aVar.s0);
                }
            } else {
                n4a n4aVar2 = this.V;
                if (n4aVar2 != null && n4aVar2.s0 != null) {
                    x89Var = new x89(this.V.s0);
                }
            }
            if (x89Var != null) {
                x89Var.b = this.a.Q().R1();
                ListUtils.add(arrayList, i + 1, x89Var);
            }
            return x89Var;
        }
        return (xn) invokeLLLI.objValue;
    }

    public final xn X(u89 u89Var, n4a n4aVar, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, u89Var, n4aVar, arrayList, i)) == null) {
            if (n4aVar != null && n4aVar.b0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(n4aVar.b0());
            } else {
                n4a n4aVar2 = this.V;
                if (n4aVar2 != null && n4aVar2.b0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.b0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (u89Var != null && !TextUtils.isEmpty(u89Var.P())) {
                    pbFirstFloorRecommendData.f(u89Var.P());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (xn) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                yg.a().post(this.h0);
            }
        }
    }

    public final fc9 Y(ArrayList<xn> arrayList, xn xnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, xnVar, i, i2)) == null) {
            fc9 B = this.H.B();
            if (B != null) {
                if (xnVar != null) {
                    if (i2 < 0 && xnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (xnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof fc9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (fc9) invokeLLII.objValue;
    }

    public final xn a0(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (Q = this.a.Q()) == null || TextUtils.isEmpty(Q.C1())) {
                return null;
            }
            m4a m4aVar = new m4a();
            l(m4aVar);
            ListUtils.add(arrayList, i + 1, m4aVar);
            return m4aVar;
        }
        return (xn) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.L5() != null) {
            this.a.L5().e2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        yb9 yb9Var = this.c;
                        if (yb9Var != null) {
                            yb9Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        kn knVar = this.t;
                        if (knVar instanceof ds9) {
                            ((ds9) knVar).onDestroy();
                        }
                        kn knVar2 = this.u;
                        if (knVar2 instanceof ds9) {
                            ((ds9) knVar2).onDestroy();
                        }
                        kn knVar3 = this.w;
                        if (knVar3 instanceof ds9) {
                            ((ds9) knVar3).onDestroy();
                        }
                        qb9.a().d();
                        return;
                    }
                    return;
                }
                yb9 yb9Var2 = this.c;
                if (yb9Var2 != null) {
                    yb9Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                kn knVar4 = this.t;
                if (knVar4 instanceof ds9) {
                    ((ds9) knVar4).onResume();
                }
                kn knVar5 = this.u;
                if (knVar5 instanceof ds9) {
                    ((ds9) knVar5).onResume();
                }
                kn knVar6 = this.w;
                if (knVar6 instanceof ds9) {
                    ((ds9) knVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            yb9 yb9Var3 = this.c;
            if (yb9Var3 != null) {
                yb9Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            kn knVar7 = this.t;
            if (knVar7 instanceof ds9) {
                ((ds9) knVar7).onPause();
            }
            kn knVar8 = this.u;
            if (knVar8 instanceof ds9) {
                ((ds9) knVar8).onPause();
            }
            kn knVar9 = this.w;
            if (knVar9 instanceof ds9) {
                ((ds9) knVar9).onPause();
            }
            qb9.a().i(this.a.V());
            rr5.a().d();
        }
    }

    public final void l(m4a m4aVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, m4aVar) == null) && m4aVar != null && this.H != null && m4aVar.getAdvertAppInfo() != null) {
            m4aVar.getAdvertAppInfo().i = new q15();
            if (this.H.y() != null) {
                m4aVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            m4aVar.getAdvertAppInfo().i.a = m4aVar.B1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                m4aVar.getAdvertAppInfo().i.c = k.getId();
                m4aVar.getAdvertAppInfo().i.d = k.getFirst_class();
                m4aVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                m4aVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            m4aVar.getAdvertAppInfo().i.g = m4aVar.getAdvertAppInfo().g;
            m4aVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<xn> x(u89 u89Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, u89Var)) == null) {
            if (u89Var == null || u89Var.S() == null || ListUtils.isEmpty(u89Var.S().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<n4a> list = u89Var.S().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                n4a n4aVar = list.get(i);
                if (n4aVar != null) {
                    n4aVar.d0 = true;
                    n4aVar.P = true;
                    arrayList.add(n4aVar);
                }
            }
            if (ListUtils.getCount(u89Var.S().b) > 2) {
                xn xnVar = (xn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (xnVar instanceof n4a) {
                    ((n4a) xnVar).P = false;
                }
                arrayList.add(new tg9());
            } else {
                xn xnVar2 = (xn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (xnVar2 instanceof n4a) {
                    ((n4a) xnVar2).P = true;
                }
            }
            arrayList.add(0, new j99(j99.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.L5() != null && this.a.V() != null && this.a.V().K1() != null) {
            qb9.a().f(this.a.V().K1().l2(), this.l.x(), this.a.L5().f1(), this.a.V().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<xn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof n4a) {
                    if (i == 0 && (list.get(i2) instanceof m4a)) {
                        i = i2 + 1;
                    }
                    n4a n4aVar = (n4a) list.get(i2);
                    if (!TextUtils.isEmpty(n4aVar.Y())) {
                        d35 d35Var = new d35();
                        d35Var.e(n4aVar.Y());
                        list.set(i2, d35Var);
                    }
                }
            }
            if (i > 0 && r66.i().q()) {
                r66.i().n(list, i, 5);
            }
        }
    }

    public void q(u89 u89Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, u89Var) == null) && u89Var.N() != null && u89Var.N().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(u89Var.N().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                cd9.H(this.a, u89Var.N().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.L5() != null) {
                this.a.L5().j4();
            }
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
            ArrayList<BdUniqueId> g = m3a.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                vt8 b2 = av8.d().b(this.a.getPageContext(), g.get(i), 2);
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

    /* JADX WARN: Removed duplicated region for block: B:219:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0(u89 u89Var, boolean z) {
        n4a n4aVar;
        boolean z2;
        boolean z3;
        n4a n4aVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        fc9 fc9Var;
        boolean z9;
        List<xn> list;
        int i4;
        boolean z10;
        boolean z11;
        xn xnVar;
        int i5;
        boolean z12;
        yb9 yb9Var;
        n4a n4aVar3;
        n4a n4aVar4;
        n4a n4aVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048633, this, u89Var, z) != null) || u89Var == null) {
            return;
        }
        this.H = u89Var;
        q(u89Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        u89 u89Var2 = this.H;
        if (u89Var2 != null && u89Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (u89Var.N() != null && u89Var.N().getAuthor() != null) {
            this.U = u89Var.N().getAuthor().getUserId();
        }
        if (this.c == null && !cd9.D(this.a)) {
            return;
        }
        O(u89Var);
        ArrayList<xn> arrayList = new ArrayList<>(u89Var.F());
        n4a r = r(arrayList);
        if (this.H.N().isQuestionThread()) {
            n4aVar = s(u89Var);
        } else {
            n4aVar = null;
        }
        if (n4aVar != null) {
            arrayList.remove(n4aVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!mt7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.s0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (u89Var.w0() && r.e0() != null) {
                r.k1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && u89Var.i() != null) {
            n4a i6 = u89Var.i();
            if (!this.N && u89Var.w0() && i6.e0() != null) {
                i6.k1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (n4aVar5 = this.V) != null && i6.j0 == null) {
                u89Var.F0(n4aVar5);
                n4aVar2 = n4aVar5;
            } else {
                n4aVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            n4aVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (u89Var.F().size() > 0 && (n4aVar4 = u89Var.F().get(0)) != null && n4aVar4.I() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        m3a.f(arrayList, 1);
        int C = C(u89Var, arrayList);
        if (C >= 0) {
            Z(u89Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(u89Var, arrayList);
        if (H >= 0) {
            e99 e99Var = new e99(e99.c);
            e99Var.b(true);
            ListUtils.add(arrayList, H, e99Var);
        }
        int w = w(u89Var, arrayList);
        List<xn> x = x(u89Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            xn xnVar2 = (xn) ListUtils.getItem(arrayList, w);
            if (xnVar2 instanceof n4a) {
                ((n4a) xnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(u89Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && u89Var.R() != null) {
            n4a W = u89Var.W();
            ThreadData c2 = u89Var.R().c();
            if (W != null && W.u0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure u0 = W.u0();
                VirtualImageCustomState v0 = W.v0();
                c2.setCustomFigure(u0);
                c2.setCustomState(v0);
            }
            n0(W, c2);
            ListUtils.add(arrayList, i, u89Var.R());
            z6 = true;
            z7 = true;
        } else {
            if (n4aVar2 != null) {
                n4aVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.N().isQuestionThread() && n4aVar != null) || (this.H.N().isQuestionThread() && this.W != null)) {
            if (n4aVar == null && (n4aVar3 = this.W) != null) {
                n4aVar = n4aVar3;
            }
            if (!arrayList.contains(n4aVar)) {
                i++;
                c0(n4aVar, arrayList, i);
            }
        }
        if (X(u89Var, n4aVar2, arrayList, i) != null || W(u89Var, n4aVar2, arrayList, i) != null || V(u89Var, arrayList, i) != null) {
            i++;
        }
        if (S(u89Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && u89Var.M() != null && u89Var.M().similar_thread != null && u89Var.M().similar_thread.id.longValue() > 0) {
            b0(u89Var, arrayList, i);
        } else {
            if (z2) {
                xn a0 = a0(arrayList, i);
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
                    xnVar = Q(arrayList, i5);
                    if (xnVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    xnVar = a0;
                    i5 = -1;
                }
                if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12 && this.H.s0()) {
                    this.k0 = i5;
                    if (T(arrayList, i5) != null) {
                        this.k0 = -1;
                        i++;
                    }
                }
                if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                    z8 = z11;
                    i2 = i;
                    fc9Var = null;
                } else {
                    fc9 Y = Y(arrayList, xnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            fc9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    fc9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                fc9Var = null;
            }
            if (z2) {
                if (fc9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(u89Var, arrayList, z8, z9, i3, i7, w, C);
                if (fc9Var != null) {
                    fc9Var.n = R;
                }
                if (cd9.D(this.a)) {
                    a99 a99Var = new a99();
                    if (u89Var.N().getTaskInfoData() != null) {
                        a99Var.f(u89Var.N().getTaskInfoData().r());
                        a99Var.e(u89Var.N().getTaskInfoData().q());
                    }
                    du8.b(arrayList, a99Var, 0);
                    if (!z7 && u89Var.R() != null) {
                        n4a W2 = u89Var.W();
                        ThreadData c3 = u89Var.R().c();
                        if (W2 != null && W2.u0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure u02 = W2.u0();
                            VirtualImageCustomState v02 = W2.v0();
                            c3.setCustomFigure(u02);
                            c3.setCustomState(v02);
                        }
                        n0(W2, c3);
                        ListUtils.add(arrayList, 1, u89Var.R());
                        z6 = true;
                        z7 = true;
                        yb9Var = this.c;
                        if (yb9Var != null) {
                            yb9Var.e0(!z6);
                        }
                        boolean K0 = K0(n4aVar2);
                        if (this.O && !K0) {
                            arrayList.remove(n4aVar2);
                            this.O = false;
                        }
                        if (u89Var.R() != null) {
                            u89Var.R().h(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<xn> Q = u89Var.Q();
                            if (!ListUtils.isEmpty(Q)) {
                                this.b.setData(K(arrayList, Q));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(n4aVar2, arrayList, z4)) {
                            List<xn> Q2 = u89Var.Q();
                            if (!ListUtils.isEmpty(Q2)) {
                                this.b.setData(K(arrayList, Q2));
                                return;
                            } else {
                                this.b.setData(arrayList);
                                return;
                            }
                        }
                        return;
                    }
                }
                yb9Var = this.c;
                if (yb9Var != null) {
                }
                boolean K02 = K0(n4aVar2);
                if (this.O) {
                    arrayList.remove(n4aVar2);
                    this.O = false;
                }
                if (u89Var.R() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(n4aVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (cd9.D(this.a)) {
        }
        yb9Var = this.c;
        if (yb9Var != null) {
        }
        boolean K022 = K0(n4aVar2);
        if (this.O) {
        }
        if (u89Var.R() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(n4aVar2, arrayList, z4)) {
        }
    }

    public final boolean t(n4a n4aVar, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, n4aVar, arrayList, z)) == null) {
            if (n4aVar == null) {
                n4a n4aVar2 = this.V;
                if (n4aVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, n4aVar2);
                } else {
                    n4a n4aVar3 = new n4a();
                    n4aVar3.S0(1);
                    ListUtils.add(arrayList, 0, n4aVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, n4aVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
