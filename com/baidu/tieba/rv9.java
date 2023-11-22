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
/* loaded from: classes8.dex */
public class rv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<tu9> B;
    public sv9 C;
    public kw9 D;
    public xx9 E;
    public PbFirstFloorWebViewAdapter F;
    public uu9 G;
    public es9 H;
    public ArrayList<vra> I;
    public ArrayList<oi> J;
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
    public int f1159T;
    public String U;
    public vra V;
    public vra W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public dw9 c;
    public zt9 c0;
    public ew9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<bi> f0;
    public PbFirstFloorItemAdapter g;
    public final List<bi> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public yx9 j;
    public int j0;
    public vx9 k;
    public int k0;
    public bx9 l;
    public ThreadData l0;
    public ow9 m;
    public List<vra> m0;
    public bx9 n;
    public final CustomMessageListener n0;
    public uv9 o;
    public CustomMessageListener o0;
    public ex9 p;
    public final CustomMessageListener p0;
    public e1a q;
    public final View.OnClickListener q0;
    public wm6 r;
    public CustomMessageListener r0;
    public bi s;
    public List<bi> s0;
    public bi t;
    public bi u;
    public bi v;
    public bi w;
    public ww9 x;
    public zw9 y;
    public vw9 z;

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv9 a;

        /* loaded from: classes8.dex */
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
        public c(rv9 rv9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv9Var, Integer.valueOf(i)};
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
            this.a = rv9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !a5.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rv9 rv9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv9Var, Integer.valueOf(i)};
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
            this.a = rv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof tra)) {
                tra traVar = (tra) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == traVar) {
                    this.a.l0.funAdData.p(true);
                    this.a.b.setData(this.a.J);
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rv9 rv9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv9Var, Integer.valueOf(i)};
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
            this.a = rv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof kra)) {
                AbsDelegateAdapterList a = ((kra) customResponsedMessage.getData()).a();
                Iterator<bi<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    bi<?, ?> next = it.next();
                    if (next instanceof wv9) {
                        ((wv9) next).u(this.a.a);
                        if (next instanceof tu9) {
                            this.a.B.add((tu9) next);
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

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv9 a;

        public d(rv9 rv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.T() != null) {
                this.a.a.W6().p1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ rv9 b;

        public e(rv9 rv9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rv9Var;
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

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(rv9 rv9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv9Var, Integer.valueOf(i)};
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
            this.a = rv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                rv9 rv9Var = this.a;
                rv9Var.n0(rv9Var.H, false);
            }
        }
    }

    public rv9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1159T = 0;
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
        this.f1159T = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = BdUtilHelper.getEquipmentHeight(this.a.getContext()) / 3;
    }

    public final oi Q(ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            ura L0 = this.a.i0().L0();
            if (L0 == null) {
                L0 = this.H.z();
            }
            if (L0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert I1 = L0.I1();
            if (I1 != null) {
                I1.setAdvertAppInfo(L0.getAdvertAppInfo());
            }
            int h = L0.getAdvertAppInfo().h();
            if (h != 0) {
                oea.j(L0, h);
                if (h != 28 && h != 31) {
                    L0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                L0.i1 = this.H.k().getId();
            }
            if (this.H.O() != null) {
                L0.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
            }
            es9 es9Var = this.H;
            if (es9Var != null && es9Var.y() != null) {
                L0.m1 = this.H.y().a();
            }
            l(L0);
            if (i < 0) {
                return null;
            }
            L0.p1 = 1;
            c26.k().q(true);
            jc9.b(arrayList, L0, i);
            es9 es9Var2 = this.H;
            if (es9Var2 != null) {
                es9Var2.N0(L0);
            }
            if (v26.i().q()) {
                v26.i().n(arrayList, i + 1, 4);
            }
            return L0;
        }
        return (oi) invokeLI.objValue;
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

    public void H0(zt9 zt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zt9Var) == null) {
            this.c0 = zt9Var;
        }
    }

    public void J0(@NonNull es9 es9Var) {
        dw9 dw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, es9Var) == null) && (dw9Var = this.c) != null) {
            dw9Var.h0(es9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, ks9.c);
        }
    }

    public void j0(boolean z) {
        dw9 dw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (dw9Var = this.c) != null) {
            dw9Var.U(z);
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

    public final vra s(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, es9Var)) == null) {
            if (es9Var != null) {
                vra U = es9Var.U();
                this.W = U;
                return U;
            }
            return null;
        }
        return (vra) invokeL.objValue;
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
        uv9 uv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (uv9Var = this.o) != null) {
            uv9Var.x0(z);
        }
    }

    public oi z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (oi) invokeI.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public final void G0(es9 es9Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, es9Var, threadData) == null) && es9Var != null && es9Var.K() != null && threadData != null) {
            threadData.setRobotEntrance(es9Var.K());
        }
    }

    public final int I(is9 is9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, is9Var, i)) == null) {
            if (is9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (is9Var.Z()) {
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
            uv9 uv9Var = this.o;
            if (uv9Var != null) {
                uv9Var.y0(z);
            }
            bx9 bx9Var = this.l;
            if (bx9Var != null) {
                bx9Var.B(z);
            }
            bi biVar = this.w;
            if (biVar != null) {
                biVar.setMulDel(z);
            }
            bi biVar2 = this.t;
            if (biVar2 != null) {
                biVar2.setMulDel(z);
            }
            dw9 dw9Var = this.c;
            if (dw9Var != null) {
                dw9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vraVar)) == null) {
            if (this.a.i0() != null && vraVar != null && vraVar.T() != null && vraVar.T().equals(this.a.i0().T1())) {
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
            dw9 dw9Var = this.c;
            if (dw9Var != null) {
                dw9Var.setFromCDN(z);
            }
            bi biVar = this.t;
            if (biVar != null && (biVar instanceof uca)) {
                ((uca) biVar).setIsFromCDN(z);
            }
            Iterator<tu9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final vra r(ArrayList<oi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<oi> it = arrayList.iterator();
            while (it.hasNext()) {
                oi next = it.next();
                if (next instanceof vra) {
                    vra vraVar = (vra) next;
                    if (vraVar.J() == 1) {
                        return vraVar;
                    }
                }
            }
            return null;
        }
        return (vra) invokeL.objValue;
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
        ow9 ow9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (ow9Var = this.m) != null) {
            ow9Var.A(2);
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
            if (this.b.getAdapter2() instanceof fi) {
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

    public ArrayList<oi> v() {
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

    public final int C(es9 es9Var, ArrayList<oi> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, es9Var, arrayList)) == null) {
            if (es9Var == null || ListUtils.isEmpty(es9Var.F()) || ListUtils.isEmpty(arrayList) || ((vra) ListUtils.getItem(es9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    oi oiVar = arrayList.get(i);
                    if (oiVar instanceof vra) {
                        vra vraVar = (vra) oiVar;
                        if (vraVar.J() == 1 && vraVar.O == 0) {
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

    public final int H(es9 es9Var, ArrayList<oi> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, es9Var, arrayList)) == null) {
            int i = -1;
            if (es9Var == null || es9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (es9Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof ts9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (es9Var.J() == 4) {
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
                    oi oiVar = this.b.getData().get(i);
                    if (oiVar != null && oiVar.getType() == ts9.g) {
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
            bx9 bx9Var = this.l;
            if (bx9Var != null) {
                bx9Var.onDestroy();
            }
            bx9 bx9Var2 = this.n;
            if (bx9Var2 != null) {
                bx9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            vx9 vx9Var = this.k;
            if (vx9Var != null) {
                vx9Var.onDestroy();
            }
            c26.k().q(false);
        }
    }

    public int E(es9 es9Var, ArrayList<oi> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, es9Var, arrayList, z)) == null) {
            if (es9Var == null || es9Var.F() == null || es9Var.C() == null || es9Var.F().size() == 0 || es9Var.O() == null || arrayList == null || !es9Var.C().F1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (es9Var.F().get(0) == null || es9Var.F().get(0).J() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (es9Var.y() == null || es9Var.y().a() != es9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(es9 es9Var, ArrayList<oi> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, es9Var, arrayList, z)) == null) {
            if (es9Var == null || es9Var.F() == null || es9Var.D() == null || es9Var.F().size() == 0 || es9Var.O() == null || arrayList == null || !es9Var.D().F1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (es9Var.F().get(0) == null || es9Var.F().get(0).J() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (es9Var.y() == null || es9Var.y().a() != es9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final oi V(es9 es9Var, ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLLI;
        gs9 gs9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, es9Var, arrayList, i)) == null) {
            if (es9Var.k() != null && !StringUtils.isNull(es9Var.k().getName()) && !es9Var.m) {
                if (!TextUtils.equals(es9Var.k().getName(), this.a.i0().S0()) || !this.a.i0().Y0()) {
                    if (!this.a.Y0() && !ListUtils.isEmpty(es9Var.o())) {
                        gs9Var = new gs9(es9Var.o().get(0));
                    } else {
                        gs9Var = new gs9(es9Var.k());
                    }
                    gs9Var.g = this.a.i0().N1();
                    ListUtils.add(arrayList, i, gs9Var);
                    return gs9Var;
                }
                return null;
            }
            return null;
        }
        return (oi) invokeLLI.objValue;
    }

    public final int b0(es9 es9Var, ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, es9Var, arrayList, i)) == null) {
            is9 is9Var = new is9(es9Var.N());
            String tid = is9Var.X().getTid();
            int s1 = this.a.i0().s1();
            es9Var.P0(I(is9Var, s1));
            js9 js9Var = new js9(is9Var.V(), is9Var.W());
            js9Var.a = is9Var.X();
            js9Var.C = s1;
            js9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, js9Var);
            is9Var.X().isLinkThread();
            is9Var.X().isSmartAppThreadType();
            if (!is9Var.X().isLinkThread() && !is9Var.X().isSmartAppThreadType()) {
                is9Var.X().isGodThread();
            }
            is9Var.a = is9Var.X();
            is9Var.C = s1;
            is9Var.g = tid;
            is9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, is9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(es9 es9Var, ArrayList<oi> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, es9Var, arrayList, z)) == null) {
            if (es9Var != null && !ListUtils.isEmpty(es9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (es9Var.F().get(0) != null && es9Var.F().get(0).J() == 1) {
                    return 1;
                }
                if (es9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (es9Var == null || !es9Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(es9 es9Var, ArrayList<oi> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, es9Var, arrayList, i) == null) {
            ts9 ts9Var = new ts9(ts9.g);
            ThreadData O = es9Var.O();
            ts9Var.c = this.a.r7();
            ts9Var.b = es9Var.g;
            ts9Var.d = es9Var.j0();
            ts9Var.e = es9Var.f;
            if (O != null && O.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            ts9Var.f = z;
            ListUtils.add(arrayList, i, ts9Var);
            if (es9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new ss9());
            }
        }
    }

    public final ArrayList<oi> K(List<oi> list, List<oi> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<oi> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            ms9 ms9Var = new ms9();
            PbListView t1 = this.a.W6().t1();
            if (t1 != null && t1.q()) {
                ms9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1027);
                ms9Var.b = true;
            } else {
                ms9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                ms9Var.b = false;
            }
            arrayList.add(ms9Var);
            zm6 zm6Var = new zm6();
            zm6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            zm6Var.needTopMargin = false;
            arrayList.add(zm6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final void M(ArrayList<oi> arrayList, Boolean bool) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = s75.i();
        int j = s75.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            oi oiVar = arrayList.get(0);
            if ((oiVar instanceof vra) && ((vra) oiVar).J() == 1) {
                z = true;
            } else {
                z = false;
            }
            oi oiVar2 = arrayList.get(arrayList.size() - 1);
            if ((oiVar2 instanceof vra) && ((vra) oiVar2).J() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = s75.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.i0() != null && this.a.i0().E1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(es9 es9Var, ArrayList<oi> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, es9Var, arrayList)) == null) {
            if (!this.P && es9Var != null && !ListUtils.isEmpty(es9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.i0() != null && this.a.i0().c1()) {
                    return -1;
                }
                if (this.a.W6() != null && this.a.W6().k1()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        oi oiVar = arrayList.get(i);
                        if (oiVar instanceof vra) {
                            vra vraVar = (vra) oiVar;
                            if (vraVar.J() == 1 && vraVar.O == 0) {
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
                    if (es9Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (es9Var != null && es9Var.x0() && this.N) {
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
            dw9 dw9Var = this.c;
            if (dw9Var != null && dw9Var.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
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
                this.d = new ew9(this.a, vra.W0);
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
        es9 es9Var;
        ura uraVar;
        ura uraVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (es9Var = this.H) == null || es9Var.Z || es9Var.a0 == 2) {
            return;
        }
        ArrayList<vra> F = es9Var.F();
        ArrayList<ura> d2 = this.H.d();
        if (!jc9.e(F) && !jc9.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<ura> it = d2.iterator();
            while (it.hasNext()) {
                ura next = it.next();
                if (next != null && next.G1() != null) {
                    sb.append(next.G1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ura> it2 = d2.iterator();
            while (it2.hasNext()) {
                ura next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ura> it3 = d2.iterator();
            while (it3.hasNext()) {
                ura next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        oea.j(next3, h);
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
                ura uraVar3 = (ura) sparseArray.valueAt(i);
                if (uraVar3 != null && (uraVar2 = (ura) hashMap.put(uraVar3.F1(), uraVar3)) != null) {
                    oea.j(uraVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (uraVar = (ura) entry.getValue()) != null) {
                    sparseArray.put(uraVar.getPosition(), uraVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                jc9.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < jc9.i(arrayList); i4++) {
                ura uraVar4 = (ura) sparseArray.get(((Integer) jc9.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    uraVar4.i1 = this.H.k().getId();
                }
                if (this.H.O() != null) {
                    uraVar4.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
                }
                es9 es9Var2 = this.H;
                if (es9Var2 != null && es9Var2.y() != null) {
                    uraVar4.m1 = this.H.y().a();
                }
                l(uraVar4);
                int position = uraVar4.getPosition() + this.H.Y;
                if (position >= jc9.i(F)) {
                    uraVar4.o1 = position;
                    oea.k(uraVar4, 2, position, jc9.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    uraVar4.o1 = position;
                }
                if (position < 0) {
                    oea.j(uraVar4, 23);
                } else {
                    uraVar4.p1 = i3;
                    jc9.b(F, uraVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", uraVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        ew9 ew9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (ix9.E(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new ew9(pbFragment, vra.W0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                dw9 dw9Var = new dw9(pbFragment, vra.W0);
                this.c = dw9Var;
                dw9Var.f0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, us9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, gs9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), hs9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), js9.f1124T);
            this.j = new yx9(pbFragment.getPageContext(), is9.X0);
            this.k = new vx9(pbFragment, bs9.c);
            this.l = new bx9(pbFragment, ts9.g);
            this.m = new ow9(pbFragment, os9.c);
            this.n = new bx9(pbFragment, ts9.h);
            uv9 uv9Var = new uv9(pbFragment, vra.X0);
            this.o = uv9Var;
            uv9Var.A0(pbFragment);
            ex9 ex9Var = new ex9(pbFragment, vra.Y0);
            this.p = ex9Var;
            ex9Var.A0(pbFragment);
            this.s = zca.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.t = zca.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.B);
            this.u = s58.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.v = s58.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.w = s58.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.K);
            this.z = new vw9(pbFragment, qs9.k1);
            this.x = new ww9(pbFragment, uw9.j1);
            this.y = new zw9(pbFragment, iy4.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, vra.e1);
            this.q = new e1a(pbFragment, f1a.a);
            this.r = new wm6(pbFragment.getPageContext());
            this.C = new sv9(pbFragment, sw4.e);
            this.D = new kw9(pbFragment, pbFragment.getUniqueId());
            this.E = new xx9(pbFragment.getPageContext(), a36.g);
            if (ix9.E(pbFragment)) {
                P(pbFragment);
            }
            uu9 uu9Var = new uu9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = uu9Var;
            this.f0.addAll(uu9Var.a());
            if (ix9.E(pbFragment) && (ew9Var = this.d) != null) {
                this.f0.add(ew9Var);
            } else {
                dw9 dw9Var2 = this.c;
                if (dw9Var2 != null) {
                    this.f0.add(dw9Var2);
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
            if (ix9.E(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new kra(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, es9Var) == null) {
            dw9 dw9Var = this.c;
            if (dw9Var != null) {
                dw9Var.s(es9Var);
                this.c.setFromCDN(this.K);
                this.c.m(this.f1159T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.l(this.X);
                this.c.o(this.a0);
                this.c.d(this.d0);
                this.c.c0(this.b0);
                this.c.e0(this.c0);
            }
            this.g.z(this.b0);
            this.o.s(es9Var);
            this.o.setFromCDN(this.K);
            this.o.p(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.l(this.X);
            this.o.o(this.a0);
            this.o.d(this.d0);
            this.o.z0(this.c0);
            this.p.s(es9Var);
            this.p.setFromCDN(this.K);
            this.p.p(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.l(this.X);
            this.p.o(this.a0);
            this.p.d(this.d0);
            this.p.z0(this.c0);
            this.e.X(this.Y);
            this.A.z(this.Y);
            this.q.z(this.q0);
            bi biVar = this.t;
            if (biVar != null && (biVar instanceof uca)) {
                ((uca) biVar).setIsFromCDN(this.K);
            }
            Iterator<tu9> it = this.B.iterator();
            while (it.hasNext()) {
                tu9 next = it.next();
                if (next != null) {
                    next.s(es9Var);
                    next.setFromCDN(this.K);
                    next.p(this.U);
                    next.m(this.f1159T);
                    next.c(this.M);
                    next.f(this.N);
                    next.r(this.S);
                    next.e(this.Y);
                    next.l(this.X);
                    next.o(this.a0);
                    next.d(this.d0);
                }
            }
            this.l.e(this.Y);
            this.l.C(this.e0);
            this.m.e(this.Z);
            this.n.e(this.Y);
            this.l.s(es9Var);
            this.k.s(es9Var);
            this.n.s(es9Var);
            this.x.s(es9Var);
            this.y.s(es9Var);
            this.C.B(es9Var);
            this.C.A(this.a.u1);
            this.D.z(es9Var);
        }
    }

    public final boolean R(es9 es9Var, ArrayList<oi> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{es9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(es9Var.e()) && es9Var.e().size() > 2) {
                int min = Math.min(es9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    sw4 sw4Var = es9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        sw4Var.h(true);
                    }
                    if (sw4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            sw4Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        sw4Var.l(true);
                    } else if (i6 == min - 1) {
                        sw4Var.i(true);
                    }
                    arrayList2.add(sw4Var);
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
                        ListUtils.add(arrayList, i5, (oi) arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final oi S(es9 es9Var, ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLLI;
        bs9 bs9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, es9Var, arrayList, i)) == null) {
            if (i >= 0 && es9Var != null && es9Var.k && (bs9Var = es9Var.l) != null) {
                ListUtils.add(arrayList, i, bs9Var);
                return bs9Var;
            }
            return null;
        }
        return (oi) invokeLLI.objValue;
    }

    public final void c0(vra vraVar, ArrayList<oi> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, vraVar, arrayList, i) == null) {
            vraVar.w1(true);
            arrayList.add(i, vraVar);
        }
    }

    public final oi T(ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLI;
        es9 es9Var;
        tra traVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (ix9.E(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (es9Var = this.H) != null && es9Var.t0()) {
                String d2 = x58.e().d("pb_banner");
                if (this.l0 == null && r58.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new tra();
                    es9 es9Var2 = this.H;
                    if (es9Var2 != null) {
                        this.l0.funAdData.m(es9Var2.l());
                        this.l0.funAdData.r(this.H.Q());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (traVar = threadData2.funAdData) != null) {
                    traVar.j(1);
                    c26.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (v26.i().q()) {
                        v26.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (oi) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<oi> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<oi> listIterator = arrayList.listIterator();
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
                        vra vraVar = new vra();
                        tra traVar = new tra();
                        es9 es9Var = this.H;
                        if (es9Var == null) {
                            str3 = "";
                        } else {
                            str3 = es9Var.l();
                        }
                        traVar.m(str3);
                        es9 es9Var2 = this.H;
                        if (es9Var2 != null) {
                            str = es9Var2.Q();
                        }
                        traVar.r(str);
                        traVar.n(true);
                        vraVar.z0 = traVar;
                        traVar.j(i7);
                        listIterator.add(vraVar);
                        i7++;
                        this.m0.add(vraVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && v26.i().q()) {
                v26.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                vra vraVar2 = new vra();
                tra traVar2 = new tra();
                es9 es9Var3 = this.H;
                if (es9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = es9Var3.l();
                }
                traVar2.m(str2);
                es9 es9Var4 = this.H;
                if (es9Var4 != null) {
                    str = es9Var4.Q();
                }
                traVar2.r(str);
                traVar2.n(true);
                vraVar2.z0 = traVar2;
                traVar2.j(1);
                listIterator.add(vraVar2);
                this.m0.add(vraVar2);
                if (v26.i().q()) {
                    v26.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final oi W(es9 es9Var, vra vraVar, ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, es9Var, vraVar, arrayList, i)) == null) {
            hs9 hs9Var = null;
            if (es9Var.k() != null && !StringUtils.isNull(es9Var.k().getName()) && TextUtils.equals(es9Var.k().getName(), this.a.i0().S0()) && this.a.i0().Y0()) {
                return null;
            }
            if (vraVar != null) {
                if (vraVar.u0 != null) {
                    hs9Var = new hs9(vraVar.u0);
                }
            } else {
                vra vraVar2 = this.V;
                if (vraVar2 != null && vraVar2.u0 != null) {
                    hs9Var = new hs9(this.V.u0);
                }
            }
            if (hs9Var != null) {
                hs9Var.b = this.a.i0().N1();
                ListUtils.add(arrayList, i + 1, hs9Var);
            }
            return hs9Var;
        }
        return (oi) invokeLLLI.objValue;
    }

    public final oi X(es9 es9Var, vra vraVar, ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, es9Var, vraVar, arrayList, i)) == null) {
            if (vraVar != null && vraVar.b0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(vraVar.b0());
            } else {
                vra vraVar2 = this.V;
                if (vraVar2 != null && vraVar2.b0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.b0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (es9Var != null && !TextUtils.isEmpty(es9Var.Q())) {
                    pbFirstFloorRecommendData.f(es9Var.Q());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (oi) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                SafeHandler.getInst().post(this.h0);
            }
        }
    }

    public final lw9 Y(ArrayList<oi> arrayList, oi oiVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, oiVar, i, i2)) == null) {
            lw9 B = this.H.B();
            if (B != null) {
                if (oiVar != null) {
                    if (i2 < 0 && oiVar.getType() != AdvertAppInfo.B) {
                        i2 = i + 2;
                    } else if (oiVar.getType() != AdvertAppInfo.B) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof lw9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (lw9) invokeLLII.objValue;
    }

    public final oi a0(ArrayList<oi> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel i0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (i0 = this.a.i0()) == null || TextUtils.isEmpty(i0.x1())) {
                return null;
            }
            ura uraVar = new ura();
            l(uraVar);
            ListUtils.add(arrayList, i + 1, uraVar);
            return uraVar;
        }
        return (oi) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.W6() != null) {
            this.a.W6().D2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        dw9 dw9Var = this.c;
                        if (dw9Var != null) {
                            dw9Var.W();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        bi biVar = this.t;
                        if (biVar instanceof pca) {
                            ((pca) biVar).onDestroy();
                        }
                        bi biVar2 = this.u;
                        if (biVar2 instanceof pca) {
                            ((pca) biVar2).onDestroy();
                        }
                        bi biVar3 = this.w;
                        if (biVar3 instanceof pca) {
                            ((pca) biVar3).onDestroy();
                        }
                        vv9.a().d();
                        return;
                    }
                    return;
                }
                dw9 dw9Var2 = this.c;
                if (dw9Var2 != null) {
                    dw9Var2.X();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                bi biVar4 = this.t;
                if (biVar4 instanceof pca) {
                    ((pca) biVar4).onResume();
                }
                bi biVar5 = this.u;
                if (biVar5 instanceof pca) {
                    ((pca) biVar5).onResume();
                }
                bi biVar6 = this.w;
                if (biVar6 instanceof pca) {
                    ((pca) biVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            dw9 dw9Var3 = this.c;
            if (dw9Var3 != null) {
                dw9Var3.V();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            bi biVar7 = this.t;
            if (biVar7 instanceof pca) {
                ((pca) biVar7).onPause();
            }
            bi biVar8 = this.u;
            if (biVar8 instanceof pca) {
                ((pca) biVar8).onPause();
            }
            bi biVar9 = this.w;
            if (biVar9 instanceof pca) {
                ((pca) biVar9).onPause();
            }
            vv9.a().i(this.a.r0());
            fo5.a().d();
        }
    }

    public final void l(ura uraVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, uraVar) == null) && uraVar != null && this.H != null && uraVar.getAdvertAppInfo() != null) {
            uraVar.getAdvertAppInfo().i = new gw4();
            if (this.H.y() != null) {
                uraVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            uraVar.getAdvertAppInfo().i.a = uraVar.H1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                uraVar.getAdvertAppInfo().i.c = k.getId();
                uraVar.getAdvertAppInfo().i.d = k.getFirst_class();
                uraVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                uraVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            uraVar.getAdvertAppInfo().i.g = uraVar.getAdvertAppInfo().g;
            uraVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<oi> x(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, es9Var)) == null) {
            if (es9Var == null || es9Var.T() == null || ListUtils.isEmpty(es9Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<vra> list = es9Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                vra vraVar = list.get(i);
                if (vraVar != null) {
                    vraVar.f0 = true;
                    vraVar.P = true;
                    arrayList.add(vraVar);
                }
            }
            if (ListUtils.getCount(es9Var.T().b) > 2) {
                oi oiVar = (oi) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (oiVar instanceof vra) {
                    ((vra) oiVar).P = false;
                }
                arrayList.add(new f1a());
            } else {
                oi oiVar2 = (oi) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (oiVar2 instanceof vra) {
                    ((vra) oiVar2).P = true;
                }
            }
            arrayList.add(0, new ts9(ts9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void l0() {
        vra vraVar;
        dw9 dw9Var;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (vraVar = this.V) != null && vraVar.a0() != null && (dw9Var = this.c) != null && dw9Var.Q() != null) {
            String Q = this.H.Q();
            String l = this.H.l();
            if (this.H.O() != null) {
                i = this.H.O().getThreadType();
            } else {
                i = 0;
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.i0() == null) {
                str = "";
            } else {
                str = this.a.i0().M0();
            }
            PbFragment pbFragment2 = this.a;
            if (pbFragment2 == null || pbFragment2.i0() == null) {
                str2 = "";
            } else {
                str2 = this.a.i0().y1();
            }
            fo5.a().c(Q, l, this.V.a0(), this.c.Q().s, i, str, str2);
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
            ArrayList<BdUniqueId> g = vqa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                bc9 b2 = fd9.d().b(this.a.getPageContext(), g.get(i), 2);
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
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.W6() != null && this.a.r0() != null && this.a.r0().F1() != null) {
            vv9.a().f(this.a.r0().F1().h2(), this.l.y(), this.a.W6().v1(), this.a.r0().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<oi> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof vra) {
                    if (i == 0 && (list.get(i2) instanceof ura)) {
                        i = i2 + 1;
                    }
                    vra vraVar = (vra) list.get(i2);
                    if (!TextUtils.isEmpty(vraVar.Y())) {
                        ux4 ux4Var = new ux4();
                        ux4Var.e(vraVar.Y());
                        list.set(i2, ux4Var);
                    }
                }
            }
            if (i > 0 && v26.i().q()) {
                v26.i().n(list, i, 5);
            }
        }
    }

    public void q(es9 es9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, es9Var) == null) && es9Var.O() != null && es9Var.O().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(es9Var.O().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                ix9.J(this.a, es9Var.O().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.x() != 1 && (pbFragment = this.a) != null && pbFragment.W6() != null) {
                this.a.W6().O4();
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
    public void n0(es9 es9Var, boolean z) {
        vra vraVar;
        boolean z2;
        boolean z3;
        vra vraVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        lw9 lw9Var;
        boolean z9;
        List<oi> list;
        int i4;
        boolean z10;
        boolean z11;
        oi oiVar;
        int i5;
        boolean z12;
        dw9 dw9Var;
        vra vraVar3;
        vra vraVar4;
        vra vraVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048631, this, es9Var, z) != null) || es9Var == null) {
            return;
        }
        this.H = es9Var;
        q(es9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        es9 es9Var2 = this.H;
        if (es9Var2 != null && es9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (es9Var.O() != null && es9Var.O().getAuthor() != null) {
            this.U = es9Var.O().getAuthor().getUserId();
        }
        if (this.c == null && !ix9.E(this.a)) {
            return;
        }
        O(es9Var);
        ArrayList<oi> arrayList = new ArrayList<>(es9Var.F());
        vra r = r(arrayList);
        if (this.H.O().isQuestionThread()) {
            vraVar = s(es9Var);
        } else {
            vraVar = null;
        }
        if (vraVar != null) {
            arrayList.remove(vraVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!y58.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.t0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (es9Var.x0() && r.e0() != null) {
                r.p1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && es9Var.i() != null) {
            vra i6 = es9Var.i();
            if (!this.N && es9Var.x0() && i6.e0() != null) {
                i6.p1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (vraVar5 = this.V) != null && i6.s0 == null) {
                es9Var.H0(vraVar5);
                vraVar2 = vraVar5;
            } else {
                vraVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            vraVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.M6()) {
            if (es9Var.F().size() > 0 && (vraVar4 = es9Var.F().get(0)) != null && vraVar4.J() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        vqa.f(arrayList, 1);
        int C = C(es9Var, arrayList);
        if (C >= 0) {
            Z(es9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(es9Var, arrayList);
        if (H >= 0) {
            os9 os9Var = new os9(os9.c);
            os9Var.b(true);
            ListUtils.add(arrayList, H, os9Var);
        }
        int w = w(es9Var, arrayList);
        List<oi> x = x(es9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            oi oiVar2 = (oi) ListUtils.getItem(arrayList, w);
            if (oiVar2 instanceof vra) {
                ((vra) oiVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(es9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && es9Var.S() != null) {
            vra X = es9Var.X();
            ThreadData c2 = es9Var.S().c();
            if (X != null && X.v0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure v0 = X.v0();
                VirtualImageCustomState w0 = X.w0();
                c2.setCustomFigure(v0);
                c2.setCustomState(w0);
            }
            G0(this.H, c2);
            ListUtils.add(arrayList, i, es9Var.S());
            z6 = true;
            z7 = true;
        } else {
            if (vraVar2 != null) {
                vraVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.O().isQuestionThread() && vraVar != null) || (this.H.O().isQuestionThread() && this.W != null)) {
            if (vraVar == null && (vraVar3 = this.W) != null) {
                vraVar = vraVar3;
            }
            if (!arrayList.contains(vraVar)) {
                i++;
                c0(vraVar, arrayList, i);
            }
        }
        if (X(es9Var, vraVar2, arrayList, i) != null || W(es9Var, vraVar2, arrayList, i) != null || V(es9Var, arrayList, i) != null) {
            i++;
        }
        if (S(es9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && es9Var.N() != null && es9Var.N().similar_thread != null && es9Var.N().similar_thread.id.longValue() > 0) {
            b0(es9Var, arrayList, i);
        } else {
            if (z2) {
                oi a0 = a0(arrayList, i);
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
                    oiVar = Q(arrayList, i5);
                    if (oiVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    oiVar = a0;
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
                    lw9Var = null;
                } else {
                    lw9 Y = Y(arrayList, oiVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            lw9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    lw9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                lw9Var = null;
            }
            if (z2) {
                if (lw9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(es9Var, arrayList, z8, z9, i3, i7, w, C);
                if (lw9Var != null) {
                    lw9Var.n = R;
                }
                if (ix9.E(this.a)) {
                    ks9 ks9Var = new ks9();
                    if (es9Var.O().getTaskInfoData() != null) {
                        ks9Var.f(es9Var.O().getTaskInfoData().r());
                        ks9Var.e(es9Var.O().getTaskInfoData().q());
                    }
                    jc9.b(arrayList, ks9Var, 0);
                    if (!z7 && es9Var.S() != null) {
                        vra X2 = es9Var.X();
                        ThreadData c3 = es9Var.S().c();
                        if (X2 != null && X2.v0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure v02 = X2.v0();
                            VirtualImageCustomState w02 = X2.w0();
                            c3.setCustomFigure(v02);
                            c3.setCustomState(w02);
                        }
                        G0(this.H, c3);
                        ListUtils.add(arrayList, 1, es9Var.S());
                        z6 = true;
                        z7 = true;
                        dw9Var = this.c;
                        if (dw9Var != null) {
                            dw9Var.d0(!z6);
                        }
                        boolean K0 = K0(vraVar2);
                        if (this.O && !K0) {
                            arrayList.remove(vraVar2);
                            this.O = false;
                        }
                        if (es9Var.S() != null) {
                            es9Var.S().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<oi> R2 = es9Var.R();
                            if (!ListUtils.isEmpty(R2)) {
                                this.b.setData(K(arrayList, R2));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(vraVar2, arrayList, z4)) {
                            List<oi> R3 = es9Var.R();
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
                dw9Var = this.c;
                if (dw9Var != null) {
                }
                boolean K02 = K0(vraVar2);
                if (this.O) {
                    arrayList.remove(vraVar2);
                    this.O = false;
                }
                if (es9Var.S() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(vraVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (ix9.E(this.a)) {
        }
        dw9Var = this.c;
        if (dw9Var != null) {
        }
        boolean K022 = K0(vraVar2);
        if (this.O) {
        }
        if (es9Var.S() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(vraVar2, arrayList, z4)) {
        }
    }

    public final boolean t(vra vraVar, ArrayList<oi> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, vraVar, arrayList, z)) == null) {
            if (vraVar == null) {
                vra vraVar2 = this.V;
                if (vraVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, vraVar2);
                } else {
                    vra vraVar3 = new vra();
                    vraVar3.X0(1);
                    ListUtils.add(arrayList, 0, vraVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, vraVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
