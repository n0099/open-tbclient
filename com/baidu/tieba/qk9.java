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
public class qk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<sj9> B;
    public rk9 C;
    public jl9 D;
    public vm9 E;
    public PbFirstFloorWebViewAdapter F;
    public tj9 G;
    public yh9 H;
    public ArrayList<zfa> I;
    public ArrayList<bn> J;
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
    public int f1162T;
    public String U;
    public zfa V;
    public zfa W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public cl9 c;
    public fj9 c0;
    public dl9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<om> f0;
    public PbFirstFloorItemAdapter g;
    public final List<om> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public wm9 j;
    public int j0;
    public tm9 k;
    public int k0;
    public zl9 l;
    public ThreadData l0;
    public nl9 m;
    public List<zfa> m0;
    public zl9 n;
    public final CustomMessageListener n0;
    public tk9 o;
    public CustomMessageListener o0;
    public cm9 p;
    public final CustomMessageListener p0;
    public xp9 q;
    public final View.OnClickListener q0;
    public gp6 r;
    public CustomMessageListener r0;
    public om s;
    public List<om> s0;
    public om t;
    public om u;
    public om v;
    public om w;
    public vl9 x;
    public xl9 y;
    public ul9 z;

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk9 a;

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
        public c(qk9 qk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk9Var, Integer.valueOf(i)};
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
            this.a = qk9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !l9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
        public final /* synthetic */ qk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qk9 qk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk9Var, Integer.valueOf(i)};
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
            this.a = qk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof xfa)) {
                xfa xfaVar = (xfa) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == xfaVar) {
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
        public final /* synthetic */ qk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qk9 qk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk9Var, Integer.valueOf(i)};
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
            this.a = qk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof pfa)) {
                AbsDelegateAdapterList a = ((pfa) customResponsedMessage.getData()).a();
                Iterator<om<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof vk9) {
                        ((vk9) next).t(this.a.a);
                        if (next instanceof sj9) {
                            this.a.B.add((sj9) next);
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
        public final /* synthetic */ qk9 a;

        public d(qk9 qk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.T() != null) {
                this.a.a.Y5().o1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ qk9 b;

        public e(qk9 qk9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qk9Var;
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
        public final /* synthetic */ qk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(qk9 qk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk9Var, Integer.valueOf(i)};
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
            this.a = qk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                qk9 qk9Var = this.a;
                qk9Var.n0(qk9Var.H, false);
            }
        }
    }

    public qk9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1162T = 0;
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
        this.f1162T = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = BdUtilHelper.getEquipmentHeight(this.a.getContext()) / 3;
    }

    public final bn Q(ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            yfa K0 = this.a.W().K0();
            if (K0 == null) {
                K0 = this.H.z();
            }
            if (K0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert C1 = K0.C1();
            if (C1 != null) {
                C1.setAdvertAppInfo(K0.getAdvertAppInfo());
            }
            int h = K0.getAdvertAppInfo().h();
            if (h != 0) {
                g3a.j(K0, h);
                if (h != 28 && h != 31) {
                    K0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                K0.h1 = this.H.k().getId();
            }
            if (this.H.O() != null) {
                K0.k1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
            }
            yh9 yh9Var = this.H;
            if (yh9Var != null && yh9Var.y() != null) {
                K0.l1 = this.H.y().a();
            }
            l(K0);
            if (i < 0) {
                return null;
            }
            K0.o1 = 1;
            b56.k().q(true);
            g29.b(arrayList, K0, i);
            yh9 yh9Var2 = this.H;
            if (yh9Var2 != null) {
                yh9Var2.M0(K0);
            }
            if (u56.i().q()) {
                u56.i().n(arrayList, i + 1, 4);
            }
            return K0;
        }
        return (bn) invokeLI.objValue;
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

    public void H0(fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fj9Var) == null) {
            this.c0 = fj9Var;
        }
    }

    public void J0(@NonNull yh9 yh9Var) {
        cl9 cl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, yh9Var) == null) && (cl9Var = this.c) != null) {
            cl9Var.i0(yh9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, ei9.c);
        }
    }

    public void j0(boolean z) {
        cl9 cl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (cl9Var = this.c) != null) {
            cl9Var.U(z);
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

    public final zfa s(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, yh9Var)) == null) {
            if (yh9Var != null && yh9Var.U() != null) {
                zfa U = yh9Var.U();
                this.W = U;
                return U;
            }
            return null;
        }
        return (zfa) invokeL.objValue;
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
        tk9 tk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (tk9Var = this.o) != null) {
            tk9Var.q0(z);
        }
    }

    public bn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (bn) invokeI.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public final void G0(yh9 yh9Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, yh9Var, threadData) == null) && yh9Var != null && yh9Var.K() != null && threadData != null) {
            threadData.setRobotEntrance(yh9Var.K());
        }
    }

    public final int I(ci9 ci9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, ci9Var, i)) == null) {
            if (ci9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (ci9Var.Z()) {
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
            tk9 tk9Var = this.o;
            if (tk9Var != null) {
                tk9Var.r0(z);
            }
            zl9 zl9Var = this.l;
            if (zl9Var != null) {
                zl9Var.A(z);
            }
            om omVar = this.w;
            if (omVar != null) {
                omVar.setMulDel(z);
            }
            om omVar2 = this.t;
            if (omVar2 != null) {
                omVar2.setMulDel(z);
            }
            cl9 cl9Var = this.c;
            if (cl9Var != null) {
                cl9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, zfaVar)) == null) {
            if (this.a.W() != null && zfaVar != null && zfaVar.S() != null && zfaVar.S().equals(this.a.W().S1())) {
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
            cl9 cl9Var = this.c;
            if (cl9Var != null) {
                cl9Var.setFromCDN(z);
            }
            om omVar = this.t;
            if (omVar != null && (omVar instanceof m1a)) {
                ((m1a) omVar).setIsFromCDN(z);
            }
            Iterator<sj9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final zfa r(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof zfa) {
                    zfa zfaVar = (zfa) next;
                    if (zfaVar.I() == 1) {
                        return zfaVar;
                    }
                }
            }
            return null;
        }
        return (zfa) invokeL.objValue;
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
        nl9 nl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (nl9Var = this.m) != null) {
            nl9Var.z(2);
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
            if (this.b.getAdapter2() instanceof sm) {
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

    public ArrayList<bn> v() {
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

    public final int C(yh9 yh9Var, ArrayList<bn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, yh9Var, arrayList)) == null) {
            if (yh9Var == null || ListUtils.isEmpty(yh9Var.F()) || ListUtils.isEmpty(arrayList) || ((zfa) ListUtils.getItem(yh9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    bn bnVar = arrayList.get(i);
                    if (bnVar instanceof zfa) {
                        zfa zfaVar = (zfa) bnVar;
                        if (zfaVar.I() == 1 && zfaVar.O == 0) {
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

    public final int H(yh9 yh9Var, ArrayList<bn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, yh9Var, arrayList)) == null) {
            int i = -1;
            if (yh9Var == null || yh9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (yh9Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof ni9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (yh9Var.J() == 4) {
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
                    bn bnVar = this.b.getData().get(i);
                    if (bnVar != null && bnVar.getType() == ni9.g) {
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
            zl9 zl9Var = this.l;
            if (zl9Var != null) {
                zl9Var.onDestroy();
            }
            zl9 zl9Var2 = this.n;
            if (zl9Var2 != null) {
                zl9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            tm9 tm9Var = this.k;
            if (tm9Var != null) {
                tm9Var.onDestroy();
            }
            b56.k().q(false);
        }
    }

    public int E(yh9 yh9Var, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, yh9Var, arrayList, z)) == null) {
            if (yh9Var == null || yh9Var.F() == null || yh9Var.C() == null || yh9Var.F().size() == 0 || yh9Var.O() == null || arrayList == null || !yh9Var.C().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (yh9Var.F().get(0) == null || yh9Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (yh9Var.y() == null || yh9Var.y().a() != yh9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(yh9 yh9Var, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, yh9Var, arrayList, z)) == null) {
            if (yh9Var == null || yh9Var.F() == null || yh9Var.D() == null || yh9Var.F().size() == 0 || yh9Var.O() == null || arrayList == null || !yh9Var.D().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (yh9Var.F().get(0) == null || yh9Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (yh9Var.y() == null || yh9Var.y().a() != yh9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final bn V(yh9 yh9Var, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLI;
        ai9 ai9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, yh9Var, arrayList, i)) == null) {
            if (yh9Var.k() != null && !StringUtils.isNull(yh9Var.k().getName()) && !yh9Var.m) {
                if (!TextUtils.equals(yh9Var.k().getName(), this.a.W().R0()) || !this.a.W().X0()) {
                    if (!this.a.H0() && !ListUtils.isEmpty(yh9Var.o())) {
                        ai9Var = new ai9(yh9Var.o().get(0));
                    } else {
                        ai9Var = new ai9(yh9Var.k());
                    }
                    ai9Var.g = this.a.W().M1();
                    ListUtils.add(arrayList, i, ai9Var);
                    return ai9Var;
                }
                return null;
            }
            return null;
        }
        return (bn) invokeLLI.objValue;
    }

    public final int b0(yh9 yh9Var, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, yh9Var, arrayList, i)) == null) {
            ci9 ci9Var = new ci9(yh9Var.N());
            String tid = ci9Var.X().getTid();
            int r1 = this.a.W().r1();
            yh9Var.O0(I(ci9Var, r1));
            di9 di9Var = new di9(ci9Var.V(), ci9Var.W());
            di9Var.a = ci9Var.X();
            di9Var.C = r1;
            di9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, di9Var);
            ci9Var.X().isLinkThread();
            ci9Var.X().isSmartAppThreadType();
            if (!ci9Var.X().isLinkThread() && !ci9Var.X().isSmartAppThreadType()) {
                ci9Var.X().isGodThread();
            }
            ci9Var.a = ci9Var.X();
            ci9Var.C = r1;
            ci9Var.g = tid;
            ci9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, ci9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(yh9 yh9Var, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, yh9Var, arrayList, z)) == null) {
            if (yh9Var != null && !ListUtils.isEmpty(yh9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (yh9Var.F().get(0) != null && yh9Var.F().get(0).I() == 1) {
                    return 1;
                }
                if (yh9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (yh9Var == null || !yh9Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(yh9 yh9Var, ArrayList<bn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, yh9Var, arrayList, i) == null) {
            ni9 ni9Var = new ni9(ni9.g);
            ThreadData O = yh9Var.O();
            ni9Var.c = this.a.q6();
            ni9Var.b = yh9Var.g;
            ni9Var.d = yh9Var.j0();
            ni9Var.e = yh9Var.f;
            if (O != null && O.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            ni9Var.f = z;
            ListUtils.add(arrayList, i, ni9Var);
            if (yh9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new mi9());
            }
        }
    }

    public final ArrayList<bn> K(List<bn> list, List<bn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<bn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            gi9 gi9Var = new gi9();
            PbListView s1 = this.a.Y5().s1();
            if (s1 != null && s1.q()) {
                gi9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fef);
                gi9Var.b = true;
            } else {
                gi9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                gi9Var.b = false;
            }
            arrayList.add(gi9Var);
            jp6 jp6Var = new jp6();
            jp6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            jp6Var.needTopMargin = false;
            arrayList.add(jp6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final void M(ArrayList<bn> arrayList, Boolean bool) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = ac5.i();
        int j = ac5.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            bn bnVar = arrayList.get(0);
            if ((bnVar instanceof zfa) && ((zfa) bnVar).I() == 1) {
                z = true;
            } else {
                z = false;
            }
            bn bnVar2 = arrayList.get(arrayList.size() - 1);
            if ((bnVar2 instanceof zfa) && ((zfa) bnVar2).I() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = ac5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.W() != null && this.a.W().D1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(yh9 yh9Var, ArrayList<bn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, yh9Var, arrayList)) == null) {
            if (!this.P && yh9Var != null && !ListUtils.isEmpty(yh9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.W() != null && this.a.W().b1()) {
                    return -1;
                }
                if (this.a.Y5() != null && this.a.Y5().k1()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        bn bnVar = arrayList.get(i);
                        if (bnVar instanceof zfa) {
                            zfa zfaVar = (zfa) bnVar;
                            if (zfaVar.I() == 1 && zfaVar.O == 0) {
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
                    if (yh9Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (yh9Var != null && yh9Var.x0() && this.N) {
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
            cl9 cl9Var = this.c;
            if (cl9Var != null && cl9Var.P() != null) {
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
                this.d = new dl9(this.a, zfa.V0);
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
        yh9 yh9Var;
        yfa yfaVar;
        yfa yfaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (yh9Var = this.H) == null || yh9Var.Z || yh9Var.a0 == 2) {
            return;
        }
        ArrayList<zfa> F = yh9Var.F();
        ArrayList<yfa> d2 = this.H.d();
        if (!g29.e(F) && !g29.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<yfa> it = d2.iterator();
            while (it.hasNext()) {
                yfa next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<yfa> it2 = d2.iterator();
            while (it2.hasNext()) {
                yfa next2 = it2.next();
                if (next2 != null) {
                    next2.n1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<yfa> it3 = d2.iterator();
            while (it3.hasNext()) {
                yfa next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        g3a.j(next3, h);
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
                yfa yfaVar3 = (yfa) sparseArray.valueAt(i);
                if (yfaVar3 != null && (yfaVar2 = (yfa) hashMap.put(yfaVar3.z1(), yfaVar3)) != null) {
                    g3a.j(yfaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (yfaVar = (yfa) entry.getValue()) != null) {
                    sparseArray.put(yfaVar.getPosition(), yfaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                g29.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < g29.i(arrayList); i4++) {
                yfa yfaVar4 = (yfa) sparseArray.get(((Integer) g29.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    yfaVar4.h1 = this.H.k().getId();
                }
                if (this.H.O() != null) {
                    yfaVar4.k1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
                }
                yh9 yh9Var2 = this.H;
                if (yh9Var2 != null && yh9Var2.y() != null) {
                    yfaVar4.l1 = this.H.y().a();
                }
                l(yfaVar4);
                int position = yfaVar4.getPosition() + this.H.Y;
                if (position >= g29.i(F)) {
                    yfaVar4.n1 = position;
                    g3a.k(yfaVar4, 2, position, g29.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    yfaVar4.n1 = position;
                }
                if (position < 0) {
                    g3a.j(yfaVar4, 23);
                } else {
                    yfaVar4.o1 = i3;
                    g29.b(F, yfaVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", yfaVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        dl9 dl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (gm9.D(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new dl9(pbFragment, zfa.V0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                cl9 cl9Var = new cl9(pbFragment, zfa.V0);
                this.c = cl9Var;
                cl9Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, oi9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, ai9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), bi9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), di9.f1098T);
            this.j = new wm9(pbFragment.getPageContext(), ci9.X0);
            this.k = new tm9(pbFragment, vh9.c);
            this.l = new zl9(pbFragment, ni9.g);
            this.m = new nl9(pbFragment, ii9.c);
            this.n = new zl9(pbFragment, ni9.h);
            tk9 tk9Var = new tk9(pbFragment, zfa.W0);
            this.o = tk9Var;
            tk9Var.t0(pbFragment);
            cm9 cm9Var = new cm9(pbFragment, zfa.X0);
            this.p = cm9Var;
            cm9Var.v0(pbFragment);
            this.s = r1a.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.y);
            this.t = r1a.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.A);
            this.u = zw7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.v = zw7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = zw7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J);
            this.z = new ul9(pbFragment, ki9.j1);
            this.x = new vl9(pbFragment, tl9.i1);
            this.y = new xl9(pbFragment, d35.o1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, zfa.d1);
            this.q = new xp9(pbFragment, yp9.a);
            this.r = new gp6(pbFragment.getPageContext());
            this.C = new rk9(pbFragment, n15.e);
            this.D = new jl9(pbFragment, pbFragment.getUniqueId());
            this.E = new vm9(pbFragment.getPageContext(), z56.g);
            if (gm9.D(pbFragment)) {
                P(pbFragment);
            }
            tj9 tj9Var = new tj9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = tj9Var;
            this.f0.addAll(tj9Var.a());
            if (gm9.D(pbFragment) && (dl9Var = this.d) != null) {
                this.f0.add(dl9Var);
            } else {
                cl9 cl9Var2 = this.c;
                if (cl9Var2 != null) {
                    this.f0.add(cl9Var2);
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
            if (gm9.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new pfa(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, yh9Var) == null) {
            cl9 cl9Var = this.c;
            if (cl9Var != null) {
                cl9Var.r(yh9Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1162T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(yh9Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.s0(this.c0);
            this.p.r(yh9Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.u0(this.c0);
            this.e.X(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            om omVar = this.t;
            if (omVar != null && (omVar instanceof m1a)) {
                ((m1a) omVar).setIsFromCDN(this.K);
            }
            Iterator<sj9> it = this.B.iterator();
            while (it.hasNext()) {
                sj9 next = it.next();
                if (next != null) {
                    next.r(yh9Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1162T);
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
            this.l.r(yh9Var);
            this.k.r(yh9Var);
            this.n.r(yh9Var);
            this.x.r(yh9Var);
            this.y.r(yh9Var);
            this.C.A(yh9Var);
            this.C.z(this.a.t1);
            this.D.y(yh9Var);
        }
    }

    public final boolean R(yh9 yh9Var, ArrayList<bn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{yh9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(yh9Var.e()) && yh9Var.e().size() > 2) {
                int min = Math.min(yh9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    n15 n15Var = yh9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        n15Var.h(true);
                    }
                    if (n15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            n15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        n15Var.l(true);
                    } else if (i6 == min - 1) {
                        n15Var.i(true);
                    }
                    arrayList2.add(n15Var);
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

    public final bn S(yh9 yh9Var, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLI;
        vh9 vh9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, yh9Var, arrayList, i)) == null) {
            if (i >= 0 && yh9Var != null && yh9Var.k && (vh9Var = yh9Var.l) != null) {
                ListUtils.add(arrayList, i, vh9Var);
                return vh9Var;
            }
            return null;
        }
        return (bn) invokeLLI.objValue;
    }

    public final void c0(zfa zfaVar, ArrayList<bn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, zfaVar, arrayList, i) == null) {
            zfaVar.q1(true);
            arrayList.add(i, zfaVar);
        }
    }

    public final bn T(ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLI;
        yh9 yh9Var;
        xfa xfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (gm9.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (yh9Var = this.H) != null && yh9Var.t0()) {
                String d2 = ex7.e().d("pb_banner");
                if (this.l0 == null && yw7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new xfa();
                    yh9 yh9Var2 = this.H;
                    if (yh9Var2 != null) {
                        this.l0.funAdData.m(yh9Var2.l());
                        this.l0.funAdData.r(this.H.Q());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (xfaVar = threadData2.funAdData) != null) {
                    xfaVar.j(1);
                    b56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (u56.i().q()) {
                        u56.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (bn) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<bn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<bn> listIterator = arrayList.listIterator();
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
                        zfa zfaVar = new zfa();
                        xfa xfaVar = new xfa();
                        yh9 yh9Var = this.H;
                        if (yh9Var == null) {
                            str3 = "";
                        } else {
                            str3 = yh9Var.l();
                        }
                        xfaVar.m(str3);
                        yh9 yh9Var2 = this.H;
                        if (yh9Var2 != null) {
                            str = yh9Var2.Q();
                        }
                        xfaVar.r(str);
                        xfaVar.n(true);
                        zfaVar.x0 = xfaVar;
                        xfaVar.j(i7);
                        listIterator.add(zfaVar);
                        i7++;
                        this.m0.add(zfaVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && u56.i().q()) {
                u56.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                zfa zfaVar2 = new zfa();
                xfa xfaVar2 = new xfa();
                yh9 yh9Var3 = this.H;
                if (yh9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = yh9Var3.l();
                }
                xfaVar2.m(str2);
                yh9 yh9Var4 = this.H;
                if (yh9Var4 != null) {
                    str = yh9Var4.Q();
                }
                xfaVar2.r(str);
                xfaVar2.n(true);
                zfaVar2.x0 = xfaVar2;
                xfaVar2.j(1);
                listIterator.add(zfaVar2);
                this.m0.add(zfaVar2);
                if (u56.i().q()) {
                    u56.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final bn W(yh9 yh9Var, zfa zfaVar, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, yh9Var, zfaVar, arrayList, i)) == null) {
            bi9 bi9Var = null;
            if (yh9Var.k() != null && !StringUtils.isNull(yh9Var.k().getName()) && TextUtils.equals(yh9Var.k().getName(), this.a.W().R0()) && this.a.W().X0()) {
                return null;
            }
            if (zfaVar != null) {
                if (zfaVar.s0 != null) {
                    bi9Var = new bi9(zfaVar.s0);
                }
            } else {
                zfa zfaVar2 = this.V;
                if (zfaVar2 != null && zfaVar2.s0 != null) {
                    bi9Var = new bi9(this.V.s0);
                }
            }
            if (bi9Var != null) {
                bi9Var.b = this.a.W().M1();
                ListUtils.add(arrayList, i + 1, bi9Var);
            }
            return bi9Var;
        }
        return (bn) invokeLLLI.objValue;
    }

    public final bn X(yh9 yh9Var, zfa zfaVar, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, yh9Var, zfaVar, arrayList, i)) == null) {
            if (zfaVar != null && zfaVar.b0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(zfaVar.b0());
            } else {
                zfa zfaVar2 = this.V;
                if (zfaVar2 != null && zfaVar2.b0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.b0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (yh9Var != null && !TextUtils.isEmpty(yh9Var.Q())) {
                    pbFirstFloorRecommendData.f(yh9Var.Q());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (bn) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                SafeHandler.getInst().post(this.h0);
            }
        }
    }

    public final kl9 Y(ArrayList<bn> arrayList, bn bnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, bnVar, i, i2)) == null) {
            kl9 B = this.H.B();
            if (B != null) {
                if (bnVar != null) {
                    if (i2 < 0 && bnVar.getType() != AdvertAppInfo.A) {
                        i2 = i + 2;
                    } else if (bnVar.getType() != AdvertAppInfo.A) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof kl9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (kl9) invokeLLII.objValue;
    }

    public final bn a0(ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (W = this.a.W()) == null || TextUtils.isEmpty(W.w1())) {
                return null;
            }
            yfa yfaVar = new yfa();
            l(yfaVar);
            ListUtils.add(arrayList, i + 1, yfaVar);
            return yfaVar;
        }
        return (bn) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.Y5() != null) {
            this.a.Y5().w2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        cl9 cl9Var = this.c;
                        if (cl9Var != null) {
                            cl9Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        om omVar = this.t;
                        if (omVar instanceof h1a) {
                            ((h1a) omVar).onDestroy();
                        }
                        om omVar2 = this.u;
                        if (omVar2 instanceof h1a) {
                            ((h1a) omVar2).onDestroy();
                        }
                        om omVar3 = this.w;
                        if (omVar3 instanceof h1a) {
                            ((h1a) omVar3).onDestroy();
                        }
                        uk9.a().d();
                        return;
                    }
                    return;
                }
                cl9 cl9Var2 = this.c;
                if (cl9Var2 != null) {
                    cl9Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                om omVar4 = this.t;
                if (omVar4 instanceof h1a) {
                    ((h1a) omVar4).onResume();
                }
                om omVar5 = this.u;
                if (omVar5 instanceof h1a) {
                    ((h1a) omVar5).onResume();
                }
                om omVar6 = this.w;
                if (omVar6 instanceof h1a) {
                    ((h1a) omVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            cl9 cl9Var3 = this.c;
            if (cl9Var3 != null) {
                cl9Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            om omVar7 = this.t;
            if (omVar7 instanceof h1a) {
                ((h1a) omVar7).onPause();
            }
            om omVar8 = this.u;
            if (omVar8 instanceof h1a) {
                ((h1a) omVar8).onPause();
            }
            om omVar9 = this.w;
            if (omVar9 instanceof h1a) {
                ((h1a) omVar9).onPause();
            }
            uk9.a().i(this.a.d0());
            mr5.a().d();
        }
    }

    public final void l(yfa yfaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, yfaVar) == null) && yfaVar != null && this.H != null && yfaVar.getAdvertAppInfo() != null) {
            yfaVar.getAdvertAppInfo().i = new b15();
            if (this.H.y() != null) {
                yfaVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            yfaVar.getAdvertAppInfo().i.a = yfaVar.B1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                yfaVar.getAdvertAppInfo().i.c = k.getId();
                yfaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                yfaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                yfaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            yfaVar.getAdvertAppInfo().i.g = yfaVar.getAdvertAppInfo().g;
            yfaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<bn> x(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, yh9Var)) == null) {
            if (yh9Var == null || yh9Var.T() == null || ListUtils.isEmpty(yh9Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<zfa> list = yh9Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                zfa zfaVar = list.get(i);
                if (zfaVar != null) {
                    zfaVar.d0 = true;
                    zfaVar.P = true;
                    arrayList.add(zfaVar);
                }
            }
            if (ListUtils.getCount(yh9Var.T().b) > 2) {
                bn bnVar = (bn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (bnVar instanceof zfa) {
                    ((zfa) bnVar).P = false;
                }
                arrayList.add(new yp9());
            } else {
                bn bnVar2 = (bn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (bnVar2 instanceof zfa) {
                    ((zfa) bnVar2).P = true;
                }
            }
            arrayList.add(0, new ni9(ni9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void l0() {
        zfa zfaVar;
        cl9 cl9Var;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (zfaVar = this.V) != null && zfaVar.a0() != null && (cl9Var = this.c) != null && cl9Var.P() != null) {
            String Q = this.H.Q();
            String l = this.H.l();
            if (this.H.O() != null) {
                i = this.H.O().getThreadType();
            } else {
                i = 0;
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.W() == null) {
                str = "";
            } else {
                str = this.a.W().L0();
            }
            PbFragment pbFragment2 = this.a;
            if (pbFragment2 == null || pbFragment2.W() == null) {
                str2 = "";
            } else {
                str2 = this.a.W().x1();
            }
            mr5.a().c(Q, l, this.V.a0(), this.c.P().s, i, str, str2);
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
            ArrayList<BdUniqueId> g = afa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                y19 b2 = c39.d().b(this.a.getPageContext(), g.get(i), 2);
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
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.Y5() != null && this.a.d0() != null && this.a.d0().I1() != null) {
            uk9.a().f(this.a.d0().I1().g2(), this.l.x(), this.a.Y5().u1(), this.a.d0().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<bn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof zfa) {
                    if (i == 0 && (list.get(i2) instanceof yfa)) {
                        i = i2 + 1;
                    }
                    zfa zfaVar = (zfa) list.get(i2);
                    if (!TextUtils.isEmpty(zfaVar.Y())) {
                        p25 p25Var = new p25();
                        p25Var.e(zfaVar.Y());
                        list.set(i2, p25Var);
                    }
                }
            }
            if (i > 0 && u56.i().q()) {
                u56.i().n(list, i, 5);
            }
        }
    }

    public void q(yh9 yh9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, yh9Var) == null) && yh9Var.O() != null && yh9Var.O().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(yh9Var.O().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                gm9.H(this.a, yh9Var.O().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.Y5() != null) {
                this.a.Y5().E4();
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
    public void n0(yh9 yh9Var, boolean z) {
        zfa zfaVar;
        boolean z2;
        boolean z3;
        zfa zfaVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        kl9 kl9Var;
        boolean z9;
        List<bn> list;
        int i4;
        boolean z10;
        boolean z11;
        bn bnVar;
        int i5;
        boolean z12;
        cl9 cl9Var;
        zfa zfaVar3;
        zfa zfaVar4;
        zfa zfaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048631, this, yh9Var, z) != null) || yh9Var == null) {
            return;
        }
        this.H = yh9Var;
        q(yh9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        yh9 yh9Var2 = this.H;
        if (yh9Var2 != null && yh9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (yh9Var.O() != null && yh9Var.O().getAuthor() != null) {
            this.U = yh9Var.O().getAuthor().getUserId();
        }
        if (this.c == null && !gm9.D(this.a)) {
            return;
        }
        O(yh9Var);
        ArrayList<bn> arrayList = new ArrayList<>(yh9Var.F());
        zfa r = r(arrayList);
        if (this.H.O().isQuestionThread()) {
            zfaVar = s(yh9Var);
        } else {
            zfaVar = null;
        }
        if (zfaVar != null) {
            arrayList.remove(zfaVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!fx7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.t0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (yh9Var.x0() && r.e0() != null) {
                r.k1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && yh9Var.i() != null) {
            zfa i6 = yh9Var.i();
            if (!this.N && yh9Var.x0() && i6.e0() != null) {
                i6.k1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (zfaVar5 = this.V) != null && i6.j0 == null) {
                yh9Var.G0(zfaVar5);
                zfaVar2 = zfaVar5;
            } else {
                zfaVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            zfaVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.O5()) {
            if (yh9Var.F().size() > 0 && (zfaVar4 = yh9Var.F().get(0)) != null && zfaVar4.I() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        afa.f(arrayList, 1);
        int C = C(yh9Var, arrayList);
        if (C >= 0) {
            Z(yh9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(yh9Var, arrayList);
        if (H >= 0) {
            ii9 ii9Var = new ii9(ii9.c);
            ii9Var.b(true);
            ListUtils.add(arrayList, H, ii9Var);
        }
        int w = w(yh9Var, arrayList);
        List<bn> x = x(yh9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            bn bnVar2 = (bn) ListUtils.getItem(arrayList, w);
            if (bnVar2 instanceof zfa) {
                ((zfa) bnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(yh9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && yh9Var.S() != null) {
            zfa X = yh9Var.X();
            ThreadData c2 = yh9Var.S().c();
            if (X != null && X.u0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure u0 = X.u0();
                VirtualImageCustomState v0 = X.v0();
                c2.setCustomFigure(u0);
                c2.setCustomState(v0);
            }
            G0(this.H, c2);
            ListUtils.add(arrayList, i, yh9Var.S());
            z6 = true;
            z7 = true;
        } else {
            if (zfaVar2 != null) {
                zfaVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.O().isQuestionThread() && zfaVar != null) || (this.H.O().isQuestionThread() && this.W != null)) {
            if (zfaVar == null && (zfaVar3 = this.W) != null) {
                zfaVar = zfaVar3;
            }
            if (!arrayList.contains(zfaVar)) {
                i++;
                c0(zfaVar, arrayList, i);
            }
        }
        if (X(yh9Var, zfaVar2, arrayList, i) != null || W(yh9Var, zfaVar2, arrayList, i) != null || V(yh9Var, arrayList, i) != null) {
            i++;
        }
        if (S(yh9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && yh9Var.N() != null && yh9Var.N().similar_thread != null && yh9Var.N().similar_thread.id.longValue() > 0) {
            b0(yh9Var, arrayList, i);
        } else {
            if (z2) {
                bn a0 = a0(arrayList, i);
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
                    bnVar = Q(arrayList, i5);
                    if (bnVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    bnVar = a0;
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
                    kl9Var = null;
                } else {
                    kl9 Y = Y(arrayList, bnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            kl9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    kl9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                kl9Var = null;
            }
            if (z2) {
                if (kl9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(yh9Var, arrayList, z8, z9, i3, i7, w, C);
                if (kl9Var != null) {
                    kl9Var.n = R;
                }
                if (gm9.D(this.a)) {
                    ei9 ei9Var = new ei9();
                    if (yh9Var.O().getTaskInfoData() != null) {
                        ei9Var.f(yh9Var.O().getTaskInfoData().r());
                        ei9Var.e(yh9Var.O().getTaskInfoData().q());
                    }
                    g29.b(arrayList, ei9Var, 0);
                    if (!z7 && yh9Var.S() != null) {
                        zfa X2 = yh9Var.X();
                        ThreadData c3 = yh9Var.S().c();
                        if (X2 != null && X2.u0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure u02 = X2.u0();
                            VirtualImageCustomState v02 = X2.v0();
                            c3.setCustomFigure(u02);
                            c3.setCustomState(v02);
                        }
                        G0(this.H, c3);
                        ListUtils.add(arrayList, 1, yh9Var.S());
                        z6 = true;
                        z7 = true;
                        cl9Var = this.c;
                        if (cl9Var != null) {
                            cl9Var.e0(!z6);
                        }
                        boolean K0 = K0(zfaVar2);
                        if (this.O && !K0) {
                            arrayList.remove(zfaVar2);
                            this.O = false;
                        }
                        if (yh9Var.S() != null) {
                            yh9Var.S().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<bn> R2 = yh9Var.R();
                            if (!ListUtils.isEmpty(R2)) {
                                this.b.setData(K(arrayList, R2));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(zfaVar2, arrayList, z4)) {
                            List<bn> R3 = yh9Var.R();
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
                cl9Var = this.c;
                if (cl9Var != null) {
                }
                boolean K02 = K0(zfaVar2);
                if (this.O) {
                    arrayList.remove(zfaVar2);
                    this.O = false;
                }
                if (yh9Var.S() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(zfaVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (gm9.D(this.a)) {
        }
        cl9Var = this.c;
        if (cl9Var != null) {
        }
        boolean K022 = K0(zfaVar2);
        if (this.O) {
        }
        if (yh9Var.S() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(zfaVar2, arrayList, z4)) {
        }
    }

    public final boolean t(zfa zfaVar, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, zfaVar, arrayList, z)) == null) {
            if (zfaVar == null) {
                zfa zfaVar2 = this.V;
                if (zfaVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, zfaVar2);
                } else {
                    zfa zfaVar3 = new zfa();
                    zfaVar3.S0(1);
                    ListUtils.add(arrayList, 0, zfaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, zfaVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
