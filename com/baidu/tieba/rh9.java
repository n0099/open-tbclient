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
/* loaded from: classes7.dex */
public class rh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<tg9> B;
    public sh9 C;
    public ji9 D;
    public wj9 E;
    public PbFirstFloorWebViewAdapter F;
    public ug9 G;
    public ze9 H;
    public ArrayList<yca> I;
    public ArrayList<yn> J;
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
    public int f1166T;
    public String U;
    public yca V;
    public yca W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public di9 c;
    public gg9 c0;
    public ei9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<ln> f0;
    public PbFirstFloorItemAdapter g;
    public final List<ln> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public xj9 j;
    public int j0;
    public uj9 k;
    public int k0;
    public zi9 l;
    public ThreadData l0;
    public ni9 m;
    public List<yca> m0;
    public zi9 n;
    public final CustomMessageListener n0;
    public uh9 o;
    public CustomMessageListener o0;
    public cj9 p;
    public final CustomMessageListener p0;
    public ym9 q;
    public final View.OnClickListener q0;
    public rq6 r;
    public CustomMessageListener r0;
    public ln s;
    public List<ln> s0;
    public ln t;
    public ln u;
    public ln v;
    public ln w;
    public vi9 x;
    public xi9 y;
    public ui9 z;

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh9 a;

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
        public c(rh9 rh9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh9Var, Integer.valueOf(i)};
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
            this.a = rh9Var;
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
                    zg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ rh9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rh9 rh9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh9Var, Integer.valueOf(i)};
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
            this.a = rh9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof wca)) {
                wca wcaVar = (wca) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == wcaVar) {
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
        public final /* synthetic */ rh9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rh9 rh9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh9Var, Integer.valueOf(i)};
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
            this.a = rh9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof nca)) {
                AbsDelegateAdapterList a = ((nca) customResponsedMessage.getData()).a();
                Iterator<ln<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    ln<?, ?> next = it.next();
                    if (next instanceof wh9) {
                        ((wh9) next).t(this.a.a);
                        if (next instanceof tg9) {
                            this.a.B.add((tg9) next);
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
        public final /* synthetic */ rh9 a;

        public d(rh9 rh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh9Var;
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

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ rh9 b;

        public e(rh9 rh9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh9Var;
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
        public final /* synthetic */ rh9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(rh9 rh9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh9Var, Integer.valueOf(i)};
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
            this.a = rh9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                rh9 rh9Var = this.a;
                rh9Var.o0(rh9Var.H, false);
            }
        }
    }

    public rh9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1166T = 0;
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
        this.f1166T = yi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = yi.j(this.a.getContext()) / 3;
    }

    public final yn Q(ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            xca S0 = this.a.Q().S0();
            if (S0 == null) {
                S0 = this.H.z();
            }
            if (S0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert C1 = S0.C1();
            if (C1 != null) {
                C1.setAdvertAppInfo(S0.getAdvertAppInfo());
            }
            int h = S0.getAdvertAppInfo().h();
            if (h != 0) {
                j0a.j(S0, h);
                if (h != 28 && h != 31) {
                    S0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                S0.i1 = this.H.k().getId();
            }
            if (this.H.N() != null) {
                S0.l1 = wg.g(this.H.N().getId(), 0L);
            }
            ze9 ze9Var = this.H;
            if (ze9Var != null && ze9Var.y() != null) {
                S0.m1 = this.H.y().a();
            }
            l(S0);
            if (i < 0) {
                return null;
            }
            S0.p1 = 1;
            c76.k().q(true);
            g09.b(arrayList, S0, i);
            ze9 ze9Var2 = this.H;
            if (ze9Var2 != null) {
                ze9Var2.L0(S0);
            }
            if (v76.i().q()) {
                v76.i().n(arrayList, i + 1, 4);
            }
            return S0;
        }
        return (yn) invokeLI.objValue;
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

    public void H0(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gg9Var) == null) {
            this.c0 = gg9Var;
        }
    }

    public void J0(@NonNull ze9 ze9Var) {
        di9 di9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, ze9Var) == null) && (di9Var = this.c) != null) {
            di9Var.i0(ze9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, ff9.c);
        }
    }

    public void j0(boolean z) {
        di9 di9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (di9Var = this.c) != null) {
            di9Var.V(z);
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

    public final yca s(ze9 ze9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, ze9Var)) == null) {
            if (ze9Var != null && ze9Var.T() != null) {
                yca T2 = ze9Var.T();
                this.W = T2;
                return T2;
            }
            return null;
        }
        return (yca) invokeL.objValue;
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

    public yn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (yn) invokeI.objValue;
    }

    public void z0(boolean z) {
        uh9 uh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z) == null) && (uh9Var = this.o) != null) {
            uh9Var.q0(z);
        }
    }

    public final int I(df9 df9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, df9Var, i)) == null) {
            if (df9Var.e0()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (df9Var.f0()) {
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

    public final void n0(yca ycaVar, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048631, this, ycaVar, threadData) == null) && ycaVar != null && ycaVar.x() != null && threadData != null && threadData.getCallRobotEntrance() == null) {
            threadData.setCallRobotEntrance(ycaVar.x());
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
        ni9 ni9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (ni9Var = this.m) != null) {
            ni9Var.z(2);
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
            if (this.b.getAdapter2() instanceof pn) {
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

    public ArrayList<yn> v() {
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
            uh9 uh9Var = this.o;
            if (uh9Var != null) {
                uh9Var.r0(z);
            }
            zi9 zi9Var = this.l;
            if (zi9Var != null) {
                zi9Var.A(z);
            }
            ln lnVar = this.w;
            if (lnVar != null) {
                lnVar.setMulDel(z);
            }
            ln lnVar2 = this.t;
            if (lnVar2 != null) {
                lnVar2.setMulDel(z);
            }
            di9 di9Var = this.c;
            if (di9Var != null) {
                di9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, ycaVar)) == null) {
            if (this.a.Q() != null && ycaVar != null && ycaVar.S() != null && ycaVar.S().equals(this.a.Q().Y1())) {
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
            di9 di9Var = this.c;
            if (di9Var != null) {
                di9Var.setFromCDN(z);
            }
            ln lnVar = this.t;
            if (lnVar != null && (lnVar instanceof py9)) {
                ((py9) lnVar).setIsFromCDN(z);
            }
            Iterator<tg9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final yca r(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof yca) {
                    yca ycaVar = (yca) next;
                    if (ycaVar.I() == 1) {
                        return ycaVar;
                    }
                }
            }
            return null;
        }
        return (yca) invokeL.objValue;
    }

    public final int C(ze9 ze9Var, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ze9Var, arrayList)) == null) {
            if (ze9Var == null || ListUtils.isEmpty(ze9Var.F()) || ListUtils.isEmpty(arrayList) || ((yca) ListUtils.getItem(ze9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    yn ynVar = arrayList.get(i);
                    if (ynVar instanceof yca) {
                        yca ycaVar = (yca) ynVar;
                        if (ycaVar.I() == 1 && ycaVar.O == 0) {
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

    public final int H(ze9 ze9Var, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, ze9Var, arrayList)) == null) {
            int i = -1;
            if (ze9Var == null || ze9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (ze9Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof of9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (ze9Var.J() == 4) {
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
                    yn ynVar = this.b.getData().get(i);
                    if (ynVar != null && ynVar.getType() == of9.g) {
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
            zg.a().removeCallbacks(this.h0);
            zi9 zi9Var = this.l;
            if (zi9Var != null) {
                zi9Var.onDestroy();
            }
            zi9 zi9Var2 = this.n;
            if (zi9Var2 != null) {
                zi9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            uj9 uj9Var = this.k;
            if (uj9Var != null) {
                uj9Var.onDestroy();
            }
            c76.k().q(false);
        }
    }

    public int E(ze9 ze9Var, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, ze9Var, arrayList, z)) == null) {
            if (ze9Var == null || ze9Var.F() == null || ze9Var.C() == null || ze9Var.F().size() == 0 || ze9Var.N() == null || arrayList == null || !ze9Var.C().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ze9Var.F().get(0) == null || ze9Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ze9Var.y() == null || ze9Var.y().a() != ze9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(ze9 ze9Var, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, ze9Var, arrayList, z)) == null) {
            if (ze9Var == null || ze9Var.F() == null || ze9Var.D() == null || ze9Var.F().size() == 0 || ze9Var.N() == null || arrayList == null || !ze9Var.D().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ze9Var.F().get(0) == null || ze9Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ze9Var.y() == null || ze9Var.y().a() != ze9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final yn V(ze9 ze9Var, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLI;
        bf9 bf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, ze9Var, arrayList, i)) == null) {
            if (ze9Var.k() != null && !StringUtils.isNull(ze9Var.k().getName()) && !ze9Var.m) {
                if (!TextUtils.equals(ze9Var.k().getName(), this.a.Q().Y0()) || !this.a.Q().e1()) {
                    if (!this.a.z0() && !ListUtils.isEmpty(ze9Var.o())) {
                        bf9Var = new bf9(ze9Var.o().get(0));
                    } else {
                        bf9Var = new bf9(ze9Var.k());
                    }
                    bf9Var.g = this.a.Q().S1();
                    if (!UbsABTestHelper.isPbEnterForum()) {
                        i++;
                    }
                    ListUtils.add(arrayList, i, bf9Var);
                    return bf9Var;
                }
                return null;
            }
            return null;
        }
        return (yn) invokeLLI.objValue;
    }

    public final int b0(ze9 ze9Var, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, ze9Var, arrayList, i)) == null) {
            df9 df9Var = new df9(ze9Var.M());
            String tid = df9Var.d0().getTid();
            int y1 = this.a.Q().y1();
            ze9Var.N0(I(df9Var, y1));
            ef9 ef9Var = new ef9(df9Var.b0(), df9Var.c0());
            ef9Var.a = df9Var.d0();
            ef9Var.C = y1;
            ef9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, ef9Var);
            df9Var.d0().isLinkThread();
            df9Var.d0().isSmartAppThreadType();
            if (!df9Var.d0().isLinkThread() && !df9Var.d0().isSmartAppThreadType()) {
                df9Var.d0().isGodThread();
            }
            df9Var.a = df9Var.d0();
            df9Var.C = y1;
            df9Var.g = tid;
            df9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, df9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(ze9 ze9Var, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, ze9Var, arrayList, z)) == null) {
            if (ze9Var != null && !ListUtils.isEmpty(ze9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (ze9Var.F().get(0) != null && ze9Var.F().get(0).I() == 1) {
                    return 1;
                }
                if (ze9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (ze9Var == null || !ze9Var.w0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(ze9 ze9Var, ArrayList<yn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, ze9Var, arrayList, i) == null) {
            of9 of9Var = new of9(of9.g);
            ThreadData N = ze9Var.N();
            of9Var.c = this.a.d6();
            of9Var.b = ze9Var.g;
            of9Var.d = ze9Var.i0();
            of9Var.e = ze9Var.f;
            if (N != null && N.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            of9Var.f = z;
            ListUtils.add(arrayList, i, of9Var);
            if (ze9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new nf9());
            }
        }
    }

    public final ArrayList<yn> K(List<yn> list, List<yn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<yn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            hf9 hf9Var = new hf9();
            PbListView d1 = this.a.L5().d1();
            if (d1 != null && d1.q()) {
                hf9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe2);
                hf9Var.b = true;
            } else {
                hf9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                hf9Var.b = false;
            }
            arrayList.add(hf9Var);
            uq6 uq6Var = new uq6();
            uq6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            uq6Var.needTopMargin = false;
            arrayList.add(uq6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final void M(ArrayList<yn> arrayList, Boolean bool) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = fd5.i();
        int j = fd5.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            yn ynVar = arrayList.get(0);
            if ((ynVar instanceof yca) && ((yca) ynVar).I() == 1) {
                z = true;
            } else {
                z = false;
            }
            yn ynVar2 = arrayList.get(arrayList.size() - 1);
            if ((ynVar2 instanceof yca) && ((yca) ynVar2).I() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = fd5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.Q() != null && this.a.Q().J1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(ze9 ze9Var, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, ze9Var, arrayList)) == null) {
            if (!this.P && ze9Var != null && !ListUtils.isEmpty(ze9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.Q() != null && this.a.Q().i1()) {
                    return -1;
                }
                if (this.a.L5() != null && this.a.L5().V0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        yn ynVar = arrayList.get(i);
                        if (ynVar instanceof yca) {
                            yca ycaVar = (yca) ynVar;
                            if (ycaVar.I() == 1 && ycaVar.O == 0) {
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
                    if (ze9Var.w0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (ze9Var != null && ze9Var.w0() && this.N) {
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
            di9 di9Var = this.c;
            if (di9Var != null && di9Var.Q() != null) {
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
        yca ycaVar;
        di9 di9Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (ycaVar = this.V) != null && ycaVar.a0() != null && (di9Var = this.c) != null && di9Var.Q() != null) {
            String P = this.H.P();
            String l = this.H.l();
            if (this.H.N() != null) {
                i = this.H.N().getThreadType();
            } else {
                i = 0;
            }
            vs5.a().c(P, l, this.V.a0(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new ei9(this.a, yca.W0);
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
        ze9 ze9Var;
        xca xcaVar;
        xca xcaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (ze9Var = this.H) == null || ze9Var.Z || ze9Var.a0 == 2) {
            return;
        }
        ArrayList<yca> F = ze9Var.F();
        ArrayList<xca> d2 = this.H.d();
        if (!g09.e(F) && !g09.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<xca> it = d2.iterator();
            while (it.hasNext()) {
                xca next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<xca> it2 = d2.iterator();
            while (it2.hasNext()) {
                xca next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<xca> it3 = d2.iterator();
            while (it3.hasNext()) {
                xca next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        j0a.j(next3, h);
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
                xca xcaVar3 = (xca) sparseArray.valueAt(i);
                if (xcaVar3 != null && (xcaVar2 = (xca) hashMap.put(xcaVar3.z1(), xcaVar3)) != null) {
                    j0a.j(xcaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (xcaVar = (xca) entry.getValue()) != null) {
                    sparseArray.put(xcaVar.getPosition(), xcaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                g09.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < g09.i(arrayList); i4++) {
                xca xcaVar4 = (xca) sparseArray.get(((Integer) g09.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    xcaVar4.i1 = this.H.k().getId();
                }
                if (this.H.N() != null) {
                    xcaVar4.l1 = wg.g(this.H.N().getId(), 0L);
                }
                ze9 ze9Var2 = this.H;
                if (ze9Var2 != null && ze9Var2.y() != null) {
                    xcaVar4.m1 = this.H.y().a();
                }
                l(xcaVar4);
                int position = xcaVar4.getPosition() + this.H.Y;
                if (position >= g09.i(F)) {
                    xcaVar4.o1 = position;
                    j0a.k(xcaVar4, 2, position, g09.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    xcaVar4.o1 = position;
                }
                if (position < 0) {
                    j0a.j(xcaVar4, 23);
                } else {
                    xcaVar4.p1 = i3;
                    g09.b(F, xcaVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", xcaVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        ei9 ei9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (hj9.D(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new ei9(pbFragment, yca.W0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                di9 di9Var = new di9(pbFragment, yca.W0);
                this.c = di9Var;
                di9Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, pf9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, bf9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), cf9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), ef9.f1095T);
            this.j = new xj9(pbFragment.getPageContext(), df9.X0);
            this.k = new uj9(pbFragment, we9.c);
            this.l = new zi9(pbFragment, of9.g);
            this.m = new ni9(pbFragment, jf9.c);
            this.n = new zi9(pbFragment, of9.h);
            uh9 uh9Var = new uh9(pbFragment, yca.X0);
            this.o = uh9Var;
            uh9Var.t0(pbFragment);
            cj9 cj9Var = new cj9(pbFragment, yca.Y0);
            this.p = cj9Var;
            cj9Var.v0(pbFragment);
            this.s = uy9.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.y);
            this.t = uy9.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.A);
            this.u = vx7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.v = vx7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = vx7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J);
            this.z = new ui9(pbFragment, lf9.k1);
            this.x = new vi9(pbFragment, ti9.j1);
            this.y = new xi9(pbFragment, a45.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, yca.e1);
            this.q = new ym9(pbFragment, zm9.a);
            this.r = new rq6(pbFragment.getPageContext());
            this.C = new sh9(pbFragment, k25.e);
            this.D = new ji9(pbFragment, pbFragment.getUniqueId());
            this.E = new wj9(pbFragment.getPageContext(), a86.g);
            if (hj9.D(pbFragment)) {
                P(pbFragment);
            }
            ug9 ug9Var = new ug9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = ug9Var;
            this.f0.addAll(ug9Var.a());
            if (hj9.D(pbFragment) && (ei9Var = this.d) != null) {
                this.f0.add(ei9Var);
            } else {
                di9 di9Var2 = this.c;
                if (di9Var2 != null) {
                    this.f0.add(di9Var2);
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
            if (hj9.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new nca(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, ze9Var) == null) {
            di9 di9Var = this.c;
            if (di9Var != null) {
                di9Var.r(ze9Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1166T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(ze9Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.s0(this.c0);
            this.p.r(ze9Var);
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
            ln lnVar = this.t;
            if (lnVar != null && (lnVar instanceof py9)) {
                ((py9) lnVar).setIsFromCDN(this.K);
            }
            Iterator<tg9> it = this.B.iterator();
            while (it.hasNext()) {
                tg9 next = it.next();
                if (next != null) {
                    next.r(ze9Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1166T);
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
            this.l.r(ze9Var);
            this.k.r(ze9Var);
            this.n.r(ze9Var);
            this.x.r(ze9Var);
            this.y.r(ze9Var);
            this.C.A(ze9Var);
            this.C.z(this.a.s1);
            this.D.y(ze9Var);
        }
    }

    public final boolean R(ze9 ze9Var, ArrayList<yn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{ze9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(ze9Var.e()) && ze9Var.e().size() > 2) {
                int min = Math.min(ze9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    k25 k25Var = ze9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        k25Var.h(true);
                    }
                    if (k25Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            k25Var.k(true);
                        }
                    } else if (i6 == min - 2) {
                        k25Var.k(true);
                    } else if (i6 == min - 1) {
                        k25Var.i(true);
                    }
                    arrayList2.add(k25Var);
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

    public final yn S(ze9 ze9Var, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLI;
        we9 we9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, ze9Var, arrayList, i)) == null) {
            if (i >= 0 && ze9Var != null && ze9Var.k && (we9Var = ze9Var.l) != null) {
                ListUtils.add(arrayList, i, we9Var);
                return we9Var;
            }
            return null;
        }
        return (yn) invokeLLI.objValue;
    }

    public final void c0(yca ycaVar, ArrayList<yn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, ycaVar, arrayList, i) == null) {
            ycaVar.q1(true);
            arrayList.add(i, ycaVar);
        }
    }

    public final yn T(ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLI;
        ze9 ze9Var;
        wca wcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (hj9.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (ze9Var = this.H) != null && ze9Var.s0()) {
                String d2 = ay7.e().d("pb_banner");
                if (this.l0 == null && ux7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new wca();
                    ze9 ze9Var2 = this.H;
                    if (ze9Var2 != null) {
                        this.l0.funAdData.m(ze9Var2.l());
                        this.l0.funAdData.r(this.H.P());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (wcaVar = threadData2.funAdData) != null) {
                    wcaVar.j(1);
                    c76.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (v76.i().q()) {
                        v76.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (yn) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<yn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<yn> listIterator = arrayList.listIterator();
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
                        yca ycaVar = new yca();
                        wca wcaVar = new wca();
                        ze9 ze9Var = this.H;
                        if (ze9Var == null) {
                            str3 = "";
                        } else {
                            str3 = ze9Var.l();
                        }
                        wcaVar.m(str3);
                        ze9 ze9Var2 = this.H;
                        if (ze9Var2 != null) {
                            str = ze9Var2.P();
                        }
                        wcaVar.r(str);
                        wcaVar.n(true);
                        ycaVar.x0 = wcaVar;
                        wcaVar.j(i7);
                        listIterator.add(ycaVar);
                        i7++;
                        this.m0.add(ycaVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && v76.i().q()) {
                v76.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                yca ycaVar2 = new yca();
                wca wcaVar2 = new wca();
                ze9 ze9Var3 = this.H;
                if (ze9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = ze9Var3.l();
                }
                wcaVar2.m(str2);
                ze9 ze9Var4 = this.H;
                if (ze9Var4 != null) {
                    str = ze9Var4.P();
                }
                wcaVar2.r(str);
                wcaVar2.n(true);
                ycaVar2.x0 = wcaVar2;
                wcaVar2.j(1);
                listIterator.add(ycaVar2);
                this.m0.add(ycaVar2);
                if (v76.i().q()) {
                    v76.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final yn W(ze9 ze9Var, yca ycaVar, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, ze9Var, ycaVar, arrayList, i)) == null) {
            cf9 cf9Var = null;
            if (ze9Var.k() != null && !StringUtils.isNull(ze9Var.k().getName()) && TextUtils.equals(ze9Var.k().getName(), this.a.Q().Y0()) && this.a.Q().e1()) {
                return null;
            }
            if (ycaVar != null) {
                if (ycaVar.s0 != null) {
                    cf9Var = new cf9(ycaVar.s0);
                }
            } else {
                yca ycaVar2 = this.V;
                if (ycaVar2 != null && ycaVar2.s0 != null) {
                    cf9Var = new cf9(this.V.s0);
                }
            }
            if (cf9Var != null) {
                cf9Var.b = this.a.Q().S1();
                ListUtils.add(arrayList, i + 1, cf9Var);
            }
            return cf9Var;
        }
        return (yn) invokeLLLI.objValue;
    }

    public final yn X(ze9 ze9Var, yca ycaVar, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, ze9Var, ycaVar, arrayList, i)) == null) {
            if (ycaVar != null && ycaVar.b0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(ycaVar.b0());
            } else {
                yca ycaVar2 = this.V;
                if (ycaVar2 != null && ycaVar2.b0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.b0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (ze9Var != null && !TextUtils.isEmpty(ze9Var.P())) {
                    pbFirstFloorRecommendData.f(ze9Var.P());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (yn) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                zg.a().post(this.h0);
            }
        }
    }

    public final ki9 Y(ArrayList<yn> arrayList, yn ynVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, ynVar, i, i2)) == null) {
            ki9 B = this.H.B();
            if (B != null) {
                if (ynVar != null) {
                    if (i2 < 0 && ynVar.getType() != AdvertAppInfo.A) {
                        i2 = i + 2;
                    } else if (ynVar.getType() != AdvertAppInfo.A) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof ki9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (ki9) invokeLLII.objValue;
    }

    public final yn a0(ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (Q = this.a.Q()) == null || TextUtils.isEmpty(Q.D1())) {
                return null;
            }
            xca xcaVar = new xca();
            l(xcaVar);
            ListUtils.add(arrayList, i + 1, xcaVar);
            return xcaVar;
        }
        return (yn) invokeLI.objValue;
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
                        di9 di9Var = this.c;
                        if (di9Var != null) {
                            di9Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        ln lnVar = this.t;
                        if (lnVar instanceof ky9) {
                            ((ky9) lnVar).onDestroy();
                        }
                        ln lnVar2 = this.u;
                        if (lnVar2 instanceof ky9) {
                            ((ky9) lnVar2).onDestroy();
                        }
                        ln lnVar3 = this.w;
                        if (lnVar3 instanceof ky9) {
                            ((ky9) lnVar3).onDestroy();
                        }
                        vh9.a().d();
                        return;
                    }
                    return;
                }
                di9 di9Var2 = this.c;
                if (di9Var2 != null) {
                    di9Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                ln lnVar4 = this.t;
                if (lnVar4 instanceof ky9) {
                    ((ky9) lnVar4).onResume();
                }
                ln lnVar5 = this.u;
                if (lnVar5 instanceof ky9) {
                    ((ky9) lnVar5).onResume();
                }
                ln lnVar6 = this.w;
                if (lnVar6 instanceof ky9) {
                    ((ky9) lnVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            di9 di9Var3 = this.c;
            if (di9Var3 != null) {
                di9Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            ln lnVar7 = this.t;
            if (lnVar7 instanceof ky9) {
                ((ky9) lnVar7).onPause();
            }
            ln lnVar8 = this.u;
            if (lnVar8 instanceof ky9) {
                ((ky9) lnVar8).onPause();
            }
            ln lnVar9 = this.w;
            if (lnVar9 instanceof ky9) {
                ((ky9) lnVar9).onPause();
            }
            vh9.a().i(this.a.X());
            vs5.a().d();
        }
    }

    public final void l(xca xcaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, xcaVar) == null) && xcaVar != null && this.H != null && xcaVar.getAdvertAppInfo() != null) {
            xcaVar.getAdvertAppInfo().i = new y15();
            if (this.H.y() != null) {
                xcaVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            xcaVar.getAdvertAppInfo().i.a = xcaVar.B1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                xcaVar.getAdvertAppInfo().i.c = k.getId();
                xcaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                xcaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                xcaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            xcaVar.getAdvertAppInfo().i.g = xcaVar.getAdvertAppInfo().g;
            xcaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<yn> x(ze9 ze9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, ze9Var)) == null) {
            if (ze9Var == null || ze9Var.S() == null || ListUtils.isEmpty(ze9Var.S().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<yca> list = ze9Var.S().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                yca ycaVar = list.get(i);
                if (ycaVar != null) {
                    ycaVar.d0 = true;
                    ycaVar.P = true;
                    arrayList.add(ycaVar);
                }
            }
            if (ListUtils.getCount(ze9Var.S().b) > 2) {
                yn ynVar = (yn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (ynVar instanceof yca) {
                    ((yca) ynVar).P = false;
                }
                arrayList.add(new zm9());
            } else {
                yn ynVar2 = (yn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (ynVar2 instanceof yca) {
                    ((yca) ynVar2).P = true;
                }
            }
            arrayList.add(0, new of9(of9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.L5() != null && this.a.X() != null && this.a.X().K1() != null) {
            vh9.a().f(this.a.X().K1().m2(), this.l.x(), this.a.L5().f1(), this.a.X().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<yn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof yca) {
                    if (i == 0 && (list.get(i2) instanceof xca)) {
                        i = i2 + 1;
                    }
                    yca ycaVar = (yca) list.get(i2);
                    if (!TextUtils.isEmpty(ycaVar.Y())) {
                        l35 l35Var = new l35();
                        l35Var.e(ycaVar.Y());
                        list.set(i2, l35Var);
                    }
                }
            }
            if (i > 0 && v76.i().q()) {
                v76.i().n(list, i, 5);
            }
        }
    }

    public void q(ze9 ze9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, ze9Var) == null) && ze9Var.N() != null && ze9Var.N().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(ze9Var.N().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                hj9.H(this.a, ze9Var.N().getTaskInfoData().j());
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
            ArrayList<BdUniqueId> g = xba.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                yz8 b2 = d19.d().b(this.a.getPageContext(), g.get(i), 2);
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
    public void o0(ze9 ze9Var, boolean z) {
        yca ycaVar;
        boolean z2;
        boolean z3;
        yca ycaVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        ki9 ki9Var;
        boolean z9;
        List<yn> list;
        int i4;
        boolean z10;
        boolean z11;
        yn ynVar;
        int i5;
        boolean z12;
        di9 di9Var;
        yca ycaVar3;
        yca ycaVar4;
        yca ycaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048633, this, ze9Var, z) != null) || ze9Var == null) {
            return;
        }
        this.H = ze9Var;
        q(ze9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        ze9 ze9Var2 = this.H;
        if (ze9Var2 != null && ze9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (ze9Var.N() != null && ze9Var.N().getAuthor() != null) {
            this.U = ze9Var.N().getAuthor().getUserId();
        }
        if (this.c == null && !hj9.D(this.a)) {
            return;
        }
        O(ze9Var);
        ArrayList<yn> arrayList = new ArrayList<>(ze9Var.F());
        yca r = r(arrayList);
        if (this.H.N().isQuestionThread()) {
            ycaVar = s(ze9Var);
        } else {
            ycaVar = null;
        }
        if (ycaVar != null) {
            arrayList.remove(ycaVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!by7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.s0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (ze9Var.w0() && r.e0() != null) {
                r.k1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && ze9Var.i() != null) {
            yca i6 = ze9Var.i();
            if (!this.N && ze9Var.w0() && i6.e0() != null) {
                i6.k1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (ycaVar5 = this.V) != null && i6.j0 == null) {
                ze9Var.F0(ycaVar5);
                ycaVar2 = ycaVar5;
            } else {
                ycaVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            ycaVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (ze9Var.F().size() > 0 && (ycaVar4 = ze9Var.F().get(0)) != null && ycaVar4.I() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        xba.f(arrayList, 1);
        int C = C(ze9Var, arrayList);
        if (C >= 0) {
            Z(ze9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(ze9Var, arrayList);
        if (H >= 0) {
            jf9 jf9Var = new jf9(jf9.c);
            jf9Var.b(true);
            ListUtils.add(arrayList, H, jf9Var);
        }
        int w = w(ze9Var, arrayList);
        List<yn> x = x(ze9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            yn ynVar2 = (yn) ListUtils.getItem(arrayList, w);
            if (ynVar2 instanceof yca) {
                ((yca) ynVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(ze9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && ze9Var.R() != null) {
            yca W = ze9Var.W();
            ThreadData c2 = ze9Var.R().c();
            if (W != null && W.u0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure u0 = W.u0();
                VirtualImageCustomState v0 = W.v0();
                c2.setCustomFigure(u0);
                c2.setCustomState(v0);
            }
            n0(W, c2);
            ListUtils.add(arrayList, i, ze9Var.R());
            z6 = true;
            z7 = true;
        } else {
            if (ycaVar2 != null) {
                ycaVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.N().isQuestionThread() && ycaVar != null) || (this.H.N().isQuestionThread() && this.W != null)) {
            if (ycaVar == null && (ycaVar3 = this.W) != null) {
                ycaVar = ycaVar3;
            }
            if (!arrayList.contains(ycaVar)) {
                i++;
                c0(ycaVar, arrayList, i);
            }
        }
        if (X(ze9Var, ycaVar2, arrayList, i) != null || W(ze9Var, ycaVar2, arrayList, i) != null || V(ze9Var, arrayList, i) != null) {
            i++;
        }
        if (S(ze9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && ze9Var.M() != null && ze9Var.M().similar_thread != null && ze9Var.M().similar_thread.id.longValue() > 0) {
            b0(ze9Var, arrayList, i);
        } else {
            if (z2) {
                yn a0 = a0(arrayList, i);
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
                    ynVar = Q(arrayList, i5);
                    if (ynVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    ynVar = a0;
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
                    ki9Var = null;
                } else {
                    ki9 Y = Y(arrayList, ynVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            ki9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    ki9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                ki9Var = null;
            }
            if (z2) {
                if (ki9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(ze9Var, arrayList, z8, z9, i3, i7, w, C);
                if (ki9Var != null) {
                    ki9Var.n = R;
                }
                if (hj9.D(this.a)) {
                    ff9 ff9Var = new ff9();
                    if (ze9Var.N().getTaskInfoData() != null) {
                        ff9Var.f(ze9Var.N().getTaskInfoData().r());
                        ff9Var.e(ze9Var.N().getTaskInfoData().q());
                    }
                    g09.b(arrayList, ff9Var, 0);
                    if (!z7 && ze9Var.R() != null) {
                        yca W2 = ze9Var.W();
                        ThreadData c3 = ze9Var.R().c();
                        if (W2 != null && W2.u0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure u02 = W2.u0();
                            VirtualImageCustomState v02 = W2.v0();
                            c3.setCustomFigure(u02);
                            c3.setCustomState(v02);
                        }
                        n0(W2, c3);
                        ListUtils.add(arrayList, 1, ze9Var.R());
                        z6 = true;
                        z7 = true;
                        di9Var = this.c;
                        if (di9Var != null) {
                            di9Var.e0(!z6);
                        }
                        boolean K0 = K0(ycaVar2);
                        if (this.O && !K0) {
                            arrayList.remove(ycaVar2);
                            this.O = false;
                        }
                        if (ze9Var.R() != null) {
                            ze9Var.R().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<yn> Q = ze9Var.Q();
                            if (!ListUtils.isEmpty(Q)) {
                                this.b.setData(K(arrayList, Q));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(ycaVar2, arrayList, z4)) {
                            List<yn> Q2 = ze9Var.Q();
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
                di9Var = this.c;
                if (di9Var != null) {
                }
                boolean K02 = K0(ycaVar2);
                if (this.O) {
                    arrayList.remove(ycaVar2);
                    this.O = false;
                }
                if (ze9Var.R() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(ycaVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (hj9.D(this.a)) {
        }
        di9Var = this.c;
        if (di9Var != null) {
        }
        boolean K022 = K0(ycaVar2);
        if (this.O) {
        }
        if (ze9Var.R() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(ycaVar2, arrayList, z4)) {
        }
    }

    public final boolean t(yca ycaVar, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, ycaVar, arrayList, z)) == null) {
            if (ycaVar == null) {
                yca ycaVar2 = this.V;
                if (ycaVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, ycaVar2);
                } else {
                    yca ycaVar3 = new yca();
                    ycaVar3.S0(1);
                    ListUtils.add(arrayList, 0, ycaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, ycaVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
