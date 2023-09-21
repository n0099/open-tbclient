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
public class yn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<an9> B;
    public zn9 C;
    public ro9 D;
    public eq9 E;
    public PbFirstFloorWebViewAdapter F;
    public bn9 G;
    public lk9 H;
    public ArrayList<zja> I;
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
    public int f1182T;
    public String U;
    public zja V;
    public zja W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public ko9 c;
    public gm9 c0;
    public lo9 d;
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
    public fq9 j;
    public int j0;
    public cq9 k;
    public int k0;
    public ip9 l;
    public ThreadData l0;
    public vo9 m;
    public List<zja> m0;
    public ip9 n;
    public final CustomMessageListener n0;
    public bo9 o;
    public CustomMessageListener o0;
    public lp9 p;
    public final CustomMessageListener p0;
    public lt9 q;
    public final View.OnClickListener q0;
    public qq6 r;
    public CustomMessageListener r0;
    public om s;
    public List<om> s0;
    public om t;
    public om u;
    public om v;
    public om w;
    public dp9 x;
    public gp9 y;
    public cp9 z;

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yn9 a;

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
        public c(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !m9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
        public final /* synthetic */ yn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof xja)) {
                xja xjaVar = (xja) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == xjaVar) {
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
        public final /* synthetic */ yn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof oja)) {
                AbsDelegateAdapterList a = ((oja) customResponsedMessage.getData()).a();
                Iterator<om<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof do9) {
                        ((do9) next).t(this.a.a);
                        if (next instanceof an9) {
                            this.a.B.add((an9) next);
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
        public final /* synthetic */ yn9 a;

        public d(yn9 yn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.T() != null) {
                this.a.a.G6().p1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ yn9 b;

        public e(yn9 yn9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yn9Var;
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
        public final /* synthetic */ yn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                yn9 yn9Var = this.a;
                yn9Var.n0(yn9Var.H, false);
            }
        }
    }

    public yn9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1182T = 0;
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
        this.f1182T = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
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
            yja J0 = this.a.f0().J0();
            if (J0 == null) {
                J0 = this.H.z();
            }
            if (J0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert G1 = J0.G1();
            if (G1 != null) {
                G1.setAdvertAppInfo(J0.getAdvertAppInfo());
            }
            int h = J0.getAdvertAppInfo().h();
            if (h != 0) {
                v6a.j(J0, h);
                if (h != 28 && h != 31) {
                    J0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                J0.i1 = this.H.k().getId();
            }
            if (this.H.O() != null) {
                J0.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
            }
            lk9 lk9Var = this.H;
            if (lk9Var != null && lk9Var.y() != null) {
                J0.m1 = this.H.y().a();
            }
            l(J0);
            if (i < 0) {
                return null;
            }
            J0.p1 = 1;
            y56.k().q(true);
            t49.b(arrayList, J0, i);
            lk9 lk9Var2 = this.H;
            if (lk9Var2 != null) {
                lk9Var2.N0(J0);
            }
            if (r66.i().q()) {
                r66.i().n(arrayList, i + 1, 4);
            }
            return J0;
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

    public void H0(gm9 gm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gm9Var) == null) {
            this.c0 = gm9Var;
        }
    }

    public void J0(@NonNull lk9 lk9Var) {
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, lk9Var) == null) && (ko9Var = this.c) != null) {
            ko9Var.h0(lk9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, rk9.c);
        }
    }

    public void j0(boolean z) {
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (ko9Var = this.c) != null) {
            ko9Var.T(z);
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

    public final zja s(lk9 lk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, lk9Var)) == null) {
            if (lk9Var != null) {
                zja U = lk9Var.U();
                this.W = U;
                return U;
            }
            return null;
        }
        return (zja) invokeL.objValue;
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
        bo9 bo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (bo9Var = this.o) != null) {
            bo9Var.v0(z);
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

    public final void G0(lk9 lk9Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, lk9Var, threadData) == null) && lk9Var != null && lk9Var.K() != null && threadData != null) {
            threadData.setRobotEntrance(lk9Var.K());
        }
    }

    public final int I(pk9 pk9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, pk9Var, i)) == null) {
            if (pk9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (pk9Var.Z()) {
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
            bo9 bo9Var = this.o;
            if (bo9Var != null) {
                bo9Var.w0(z);
            }
            ip9 ip9Var = this.l;
            if (ip9Var != null) {
                ip9Var.A(z);
            }
            om omVar = this.w;
            if (omVar != null) {
                omVar.setMulDel(z);
            }
            om omVar2 = this.t;
            if (omVar2 != null) {
                omVar2.setMulDel(z);
            }
            ko9 ko9Var = this.c;
            if (ko9Var != null) {
                ko9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(zja zjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, zjaVar)) == null) {
            if (this.a.f0() != null && zjaVar != null && zjaVar.U() != null && zjaVar.U().equals(this.a.f0().R1())) {
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
            ko9 ko9Var = this.c;
            if (ko9Var != null) {
                ko9Var.setFromCDN(z);
            }
            om omVar = this.t;
            if (omVar != null && (omVar instanceof b5a)) {
                ((b5a) omVar).setIsFromCDN(z);
            }
            Iterator<an9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final zja r(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof zja) {
                    zja zjaVar = (zja) next;
                    if (zjaVar.L() == 1) {
                        return zjaVar;
                    }
                }
            }
            return null;
        }
        return (zja) invokeL.objValue;
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
        vo9 vo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (vo9Var = this.m) != null) {
            vo9Var.z(2);
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

    public final int C(lk9 lk9Var, ArrayList<bn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, lk9Var, arrayList)) == null) {
            if (lk9Var == null || ListUtils.isEmpty(lk9Var.F()) || ListUtils.isEmpty(arrayList) || ((zja) ListUtils.getItem(lk9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    bn bnVar = arrayList.get(i);
                    if (bnVar instanceof zja) {
                        zja zjaVar = (zja) bnVar;
                        if (zjaVar.L() == 1 && zjaVar.O == 0) {
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

    public final int H(lk9 lk9Var, ArrayList<bn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, lk9Var, arrayList)) == null) {
            int i = -1;
            if (lk9Var == null || lk9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (lk9Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof al9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (lk9Var.J() == 4) {
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
                    if (bnVar != null && bnVar.getType() == al9.g) {
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
            ip9 ip9Var = this.l;
            if (ip9Var != null) {
                ip9Var.onDestroy();
            }
            ip9 ip9Var2 = this.n;
            if (ip9Var2 != null) {
                ip9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            cq9 cq9Var = this.k;
            if (cq9Var != null) {
                cq9Var.onDestroy();
            }
            y56.k().q(false);
        }
    }

    public int E(lk9 lk9Var, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, lk9Var, arrayList, z)) == null) {
            if (lk9Var == null || lk9Var.F() == null || lk9Var.C() == null || lk9Var.F().size() == 0 || lk9Var.O() == null || arrayList == null || !lk9Var.C().D1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (lk9Var.F().get(0) == null || lk9Var.F().get(0).L() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (lk9Var.y() == null || lk9Var.y().a() != lk9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(lk9 lk9Var, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, lk9Var, arrayList, z)) == null) {
            if (lk9Var == null || lk9Var.F() == null || lk9Var.D() == null || lk9Var.F().size() == 0 || lk9Var.O() == null || arrayList == null || !lk9Var.D().D1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (lk9Var.F().get(0) == null || lk9Var.F().get(0).L() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (lk9Var.y() == null || lk9Var.y().a() != lk9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final bn V(lk9 lk9Var, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLI;
        nk9 nk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, lk9Var, arrayList, i)) == null) {
            if (lk9Var.k() != null && !StringUtils.isNull(lk9Var.k().getName()) && !lk9Var.m) {
                if (!TextUtils.equals(lk9Var.k().getName(), this.a.f0().Q0()) || !this.a.f0().W0()) {
                    if (!this.a.Q0() && !ListUtils.isEmpty(lk9Var.o())) {
                        nk9Var = new nk9(lk9Var.o().get(0));
                    } else {
                        nk9Var = new nk9(lk9Var.k());
                    }
                    nk9Var.g = this.a.f0().L1();
                    ListUtils.add(arrayList, i, nk9Var);
                    return nk9Var;
                }
                return null;
            }
            return null;
        }
        return (bn) invokeLLI.objValue;
    }

    public final int b0(lk9 lk9Var, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, lk9Var, arrayList, i)) == null) {
            pk9 pk9Var = new pk9(lk9Var.N());
            String tid = pk9Var.X().getTid();
            int q1 = this.a.f0().q1();
            lk9Var.P0(I(pk9Var, q1));
            qk9 qk9Var = new qk9(pk9Var.V(), pk9Var.W());
            qk9Var.a = pk9Var.X();
            qk9Var.C = q1;
            qk9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, qk9Var);
            pk9Var.X().isLinkThread();
            pk9Var.X().isSmartAppThreadType();
            if (!pk9Var.X().isLinkThread() && !pk9Var.X().isSmartAppThreadType()) {
                pk9Var.X().isGodThread();
            }
            pk9Var.a = pk9Var.X();
            pk9Var.C = q1;
            pk9Var.g = tid;
            pk9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, pk9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(lk9 lk9Var, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, lk9Var, arrayList, z)) == null) {
            if (lk9Var != null && !ListUtils.isEmpty(lk9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (lk9Var.F().get(0) != null && lk9Var.F().get(0).L() == 1) {
                    return 1;
                }
                if (lk9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (lk9Var == null || !lk9Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(lk9 lk9Var, ArrayList<bn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, lk9Var, arrayList, i) == null) {
            al9 al9Var = new al9(al9.g);
            ThreadData O = lk9Var.O();
            al9Var.c = this.a.b7();
            al9Var.b = lk9Var.g;
            al9Var.d = lk9Var.j0();
            al9Var.e = lk9Var.f;
            if (O != null && O.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            al9Var.f = z;
            ListUtils.add(arrayList, i, al9Var);
            if (lk9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new zk9());
            }
        }
    }

    public final ArrayList<bn> K(List<bn> list, List<bn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<bn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            tk9 tk9Var = new tk9();
            PbListView t1 = this.a.G6().t1();
            if (t1 != null && t1.q()) {
                tk9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1008);
                tk9Var.b = true;
            } else {
                tk9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                tk9Var.b = false;
            }
            arrayList.add(tk9Var);
            tq6 tq6Var = new tq6();
            tq6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            tq6Var.needTopMargin = false;
            arrayList.add(tq6Var);
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
        int i = oc5.i();
        int j = oc5.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            bn bnVar = arrayList.get(0);
            if ((bnVar instanceof zja) && ((zja) bnVar).L() == 1) {
                z = true;
            } else {
                z = false;
            }
            bn bnVar2 = arrayList.get(arrayList.size() - 1);
            if ((bnVar2 instanceof zja) && ((zja) bnVar2).L() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = oc5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.f0() != null && this.a.f0().C1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(lk9 lk9Var, ArrayList<bn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, lk9Var, arrayList)) == null) {
            if (!this.P && lk9Var != null && !ListUtils.isEmpty(lk9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.f0() != null && this.a.f0().a1()) {
                    return -1;
                }
                if (this.a.G6() != null && this.a.G6().k1()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        bn bnVar = arrayList.get(i);
                        if (bnVar instanceof zja) {
                            zja zjaVar = (zja) bnVar;
                            if (zjaVar.L() == 1 && zjaVar.O == 0) {
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
                    if (lk9Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (lk9Var != null && lk9Var.x0() && this.N) {
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
            ko9 ko9Var = this.c;
            if (ko9Var != null && ko9Var.P() != null) {
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
                this.d = new lo9(this.a, zja.W0);
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
        lk9 lk9Var;
        yja yjaVar;
        yja yjaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (lk9Var = this.H) == null || lk9Var.Z || lk9Var.a0 == 2) {
            return;
        }
        ArrayList<zja> F = lk9Var.F();
        ArrayList<yja> d2 = this.H.d();
        if (!t49.e(F) && !t49.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<yja> it = d2.iterator();
            while (it.hasNext()) {
                yja next = it.next();
                if (next != null && next.E1() != null) {
                    sb.append(next.E1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<yja> it2 = d2.iterator();
            while (it2.hasNext()) {
                yja next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<yja> it3 = d2.iterator();
            while (it3.hasNext()) {
                yja next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        v6a.j(next3, h);
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
                yja yjaVar3 = (yja) sparseArray.valueAt(i);
                if (yjaVar3 != null && (yjaVar2 = (yja) hashMap.put(yjaVar3.D1(), yjaVar3)) != null) {
                    v6a.j(yjaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (yjaVar = (yja) entry.getValue()) != null) {
                    sparseArray.put(yjaVar.getPosition(), yjaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                t49.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < t49.i(arrayList); i4++) {
                yja yjaVar4 = (yja) sparseArray.get(((Integer) t49.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    yjaVar4.i1 = this.H.k().getId();
                }
                if (this.H.O() != null) {
                    yjaVar4.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
                }
                lk9 lk9Var2 = this.H;
                if (lk9Var2 != null && lk9Var2.y() != null) {
                    yjaVar4.m1 = this.H.y().a();
                }
                l(yjaVar4);
                int position = yjaVar4.getPosition() + this.H.Y;
                if (position >= t49.i(F)) {
                    yjaVar4.o1 = position;
                    v6a.k(yjaVar4, 2, position, t49.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    yjaVar4.o1 = position;
                }
                if (position < 0) {
                    v6a.j(yjaVar4, 23);
                } else {
                    yjaVar4.p1 = i3;
                    t49.b(F, yjaVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", yjaVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        lo9 lo9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (pp9.D(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new lo9(pbFragment, zja.W0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                ko9 ko9Var = new ko9(pbFragment, zja.W0);
                this.c = ko9Var;
                ko9Var.f0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, bl9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, nk9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), ok9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), qk9.f1147T);
            this.j = new fq9(pbFragment.getPageContext(), pk9.X0);
            this.k = new cq9(pbFragment, ik9.c);
            this.l = new ip9(pbFragment, al9.g);
            this.m = new vo9(pbFragment, vk9.c);
            this.n = new ip9(pbFragment, al9.h);
            bo9 bo9Var = new bo9(pbFragment, zja.X0);
            this.o = bo9Var;
            bo9Var.y0(pbFragment);
            lp9 lp9Var = new lp9(pbFragment, zja.Y0);
            this.p = lp9Var;
            lp9Var.y0(pbFragment);
            this.s = g5a.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.y);
            this.t = g5a.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.A);
            this.u = ly7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.v = ly7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = ly7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J);
            this.z = new cp9(pbFragment, xk9.k1);
            this.x = new dp9(pbFragment, bp9.j1);
            this.y = new gp9(pbFragment, i35.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, zja.e1);
            this.q = new lt9(pbFragment, mt9.a);
            this.r = new qq6(pbFragment.getPageContext());
            this.C = new zn9(pbFragment, s15.e);
            this.D = new ro9(pbFragment, pbFragment.getUniqueId());
            this.E = new eq9(pbFragment.getPageContext(), w66.g);
            if (pp9.D(pbFragment)) {
                P(pbFragment);
            }
            bn9 bn9Var = new bn9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = bn9Var;
            this.f0.addAll(bn9Var.a());
            if (pp9.D(pbFragment) && (lo9Var = this.d) != null) {
                this.f0.add(lo9Var);
            } else {
                ko9 ko9Var2 = this.c;
                if (ko9Var2 != null) {
                    this.f0.add(ko9Var2);
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
            if (pp9.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new oja(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull lk9 lk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, lk9Var) == null) {
            ko9 ko9Var = this.c;
            if (ko9Var != null) {
                ko9Var.r(lk9Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1182T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.c0(this.b0);
                this.c.e0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(lk9Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.x0(this.c0);
            this.p.r(lk9Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.x0(this.c0);
            this.e.W(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            om omVar = this.t;
            if (omVar != null && (omVar instanceof b5a)) {
                ((b5a) omVar).setIsFromCDN(this.K);
            }
            Iterator<an9> it = this.B.iterator();
            while (it.hasNext()) {
                an9 next = it.next();
                if (next != null) {
                    next.r(lk9Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1182T);
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
            this.l.r(lk9Var);
            this.k.r(lk9Var);
            this.n.r(lk9Var);
            this.x.r(lk9Var);
            this.y.r(lk9Var);
            this.C.A(lk9Var);
            this.C.z(this.a.v1);
            this.D.y(lk9Var);
        }
    }

    public final boolean R(lk9 lk9Var, ArrayList<bn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{lk9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(lk9Var.e()) && lk9Var.e().size() > 2) {
                int min = Math.min(lk9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    s15 s15Var = lk9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        s15Var.h(true);
                    }
                    if (s15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            s15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        s15Var.l(true);
                    } else if (i6 == min - 1) {
                        s15Var.i(true);
                    }
                    arrayList2.add(s15Var);
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
                        ListUtils.add(arrayList, i5, (bn) arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final bn S(lk9 lk9Var, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLI;
        ik9 ik9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, lk9Var, arrayList, i)) == null) {
            if (i >= 0 && lk9Var != null && lk9Var.k && (ik9Var = lk9Var.l) != null) {
                ListUtils.add(arrayList, i, ik9Var);
                return ik9Var;
            }
            return null;
        }
        return (bn) invokeLLI.objValue;
    }

    public final void c0(zja zjaVar, ArrayList<bn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, zjaVar, arrayList, i) == null) {
            zjaVar.u1(true);
            arrayList.add(i, zjaVar);
        }
    }

    public final bn T(ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLI;
        lk9 lk9Var;
        xja xjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (pp9.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (lk9Var = this.H) != null && lk9Var.t0()) {
                String d2 = qy7.e().d("pb_banner");
                if (this.l0 == null && ky7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new xja();
                    lk9 lk9Var2 = this.H;
                    if (lk9Var2 != null) {
                        this.l0.funAdData.m(lk9Var2.l());
                        this.l0.funAdData.r(this.H.Q());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (xjaVar = threadData2.funAdData) != null) {
                    xjaVar.j(1);
                    y56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (r66.i().q()) {
                        r66.i().n(arrayList, i + 1, 4);
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
                        zja zjaVar = new zja();
                        xja xjaVar = new xja();
                        lk9 lk9Var = this.H;
                        if (lk9Var == null) {
                            str3 = "";
                        } else {
                            str3 = lk9Var.l();
                        }
                        xjaVar.m(str3);
                        lk9 lk9Var2 = this.H;
                        if (lk9Var2 != null) {
                            str = lk9Var2.Q();
                        }
                        xjaVar.r(str);
                        xjaVar.n(true);
                        zjaVar.y0 = xjaVar;
                        xjaVar.j(i7);
                        listIterator.add(zjaVar);
                        i7++;
                        this.m0.add(zjaVar);
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
                zja zjaVar2 = new zja();
                xja xjaVar2 = new xja();
                lk9 lk9Var3 = this.H;
                if (lk9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = lk9Var3.l();
                }
                xjaVar2.m(str2);
                lk9 lk9Var4 = this.H;
                if (lk9Var4 != null) {
                    str = lk9Var4.Q();
                }
                xjaVar2.r(str);
                xjaVar2.n(true);
                zjaVar2.y0 = xjaVar2;
                xjaVar2.j(1);
                listIterator.add(zjaVar2);
                this.m0.add(zjaVar2);
                if (r66.i().q()) {
                    r66.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final bn W(lk9 lk9Var, zja zjaVar, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, lk9Var, zjaVar, arrayList, i)) == null) {
            ok9 ok9Var = null;
            if (lk9Var.k() != null && !StringUtils.isNull(lk9Var.k().getName()) && TextUtils.equals(lk9Var.k().getName(), this.a.f0().Q0()) && this.a.f0().W0()) {
                return null;
            }
            if (zjaVar != null) {
                if (zjaVar.t0 != null) {
                    ok9Var = new ok9(zjaVar.t0);
                }
            } else {
                zja zjaVar2 = this.V;
                if (zjaVar2 != null && zjaVar2.t0 != null) {
                    ok9Var = new ok9(this.V.t0);
                }
            }
            if (ok9Var != null) {
                ok9Var.b = this.a.f0().L1();
                ListUtils.add(arrayList, i + 1, ok9Var);
            }
            return ok9Var;
        }
        return (bn) invokeLLLI.objValue;
    }

    public final bn X(lk9 lk9Var, zja zjaVar, ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, lk9Var, zjaVar, arrayList, i)) == null) {
            if (zjaVar != null && zjaVar.c0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(zjaVar.c0());
            } else {
                zja zjaVar2 = this.V;
                if (zjaVar2 != null && zjaVar2.c0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.c0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (lk9Var != null && !TextUtils.isEmpty(lk9Var.Q())) {
                    pbFirstFloorRecommendData.f(lk9Var.Q());
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

    public final so9 Y(ArrayList<bn> arrayList, bn bnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, bnVar, i, i2)) == null) {
            so9 B = this.H.B();
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
                if (i2 > 0 && (B instanceof so9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (so9) invokeLLII.objValue;
    }

    public final bn a0(ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (f0 = this.a.f0()) == null || TextUtils.isEmpty(f0.v1())) {
                return null;
            }
            yja yjaVar = new yja();
            l(yjaVar);
            ListUtils.add(arrayList, i + 1, yjaVar);
            return yjaVar;
        }
        return (bn) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.G6() != null) {
            this.a.G6().C2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ko9 ko9Var = this.c;
                        if (ko9Var != null) {
                            ko9Var.V();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        om omVar = this.t;
                        if (omVar instanceof w4a) {
                            ((w4a) omVar).onDestroy();
                        }
                        om omVar2 = this.u;
                        if (omVar2 instanceof w4a) {
                            ((w4a) omVar2).onDestroy();
                        }
                        om omVar3 = this.w;
                        if (omVar3 instanceof w4a) {
                            ((w4a) omVar3).onDestroy();
                        }
                        co9.a().d();
                        return;
                    }
                    return;
                }
                ko9 ko9Var2 = this.c;
                if (ko9Var2 != null) {
                    ko9Var2.W();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                om omVar4 = this.t;
                if (omVar4 instanceof w4a) {
                    ((w4a) omVar4).onResume();
                }
                om omVar5 = this.u;
                if (omVar5 instanceof w4a) {
                    ((w4a) omVar5).onResume();
                }
                om omVar6 = this.w;
                if (omVar6 instanceof w4a) {
                    ((w4a) omVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            ko9 ko9Var3 = this.c;
            if (ko9Var3 != null) {
                ko9Var3.U();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            om omVar7 = this.t;
            if (omVar7 instanceof w4a) {
                ((w4a) omVar7).onPause();
            }
            om omVar8 = this.u;
            if (omVar8 instanceof w4a) {
                ((w4a) omVar8).onPause();
            }
            om omVar9 = this.w;
            if (omVar9 instanceof w4a) {
                ((w4a) omVar9).onPause();
            }
            co9.a().i(this.a.m0());
            hs5.a().d();
        }
    }

    public final void l(yja yjaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, yjaVar) == null) && yjaVar != null && this.H != null && yjaVar.getAdvertAppInfo() != null) {
            yjaVar.getAdvertAppInfo().i = new g15();
            if (this.H.y() != null) {
                yjaVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            yjaVar.getAdvertAppInfo().i.a = yjaVar.F1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                yjaVar.getAdvertAppInfo().i.c = k.getId();
                yjaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                yjaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                yjaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            yjaVar.getAdvertAppInfo().i.g = yjaVar.getAdvertAppInfo().g;
            yjaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<bn> x(lk9 lk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, lk9Var)) == null) {
            if (lk9Var == null || lk9Var.T() == null || ListUtils.isEmpty(lk9Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<zja> list = lk9Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                zja zjaVar = list.get(i);
                if (zjaVar != null) {
                    zjaVar.e0 = true;
                    zjaVar.P = true;
                    arrayList.add(zjaVar);
                }
            }
            if (ListUtils.getCount(lk9Var.T().b) > 2) {
                bn bnVar = (bn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (bnVar instanceof zja) {
                    ((zja) bnVar).P = false;
                }
                arrayList.add(new mt9());
            } else {
                bn bnVar2 = (bn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (bnVar2 instanceof zja) {
                    ((zja) bnVar2).P = true;
                }
            }
            arrayList.add(0, new al9(al9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void l0() {
        zja zjaVar;
        ko9 ko9Var;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (zjaVar = this.V) != null && zjaVar.b0() != null && (ko9Var = this.c) != null && ko9Var.P() != null) {
            String Q = this.H.Q();
            String l = this.H.l();
            if (this.H.O() != null) {
                i = this.H.O().getThreadType();
            } else {
                i = 0;
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.f0() == null) {
                str = "";
            } else {
                str = this.a.f0().K0();
            }
            PbFragment pbFragment2 = this.a;
            if (pbFragment2 == null || pbFragment2.f0() == null) {
                str2 = "";
            } else {
                str2 = this.a.f0().w1();
            }
            hs5.a().c(Q, l, this.V.b0(), this.c.P().s, i, str, str2);
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
            ArrayList<BdUniqueId> g = zia.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                l49 b2 = p59.d().b(this.a.getPageContext(), g.get(i), 2);
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
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.G6() != null && this.a.m0() != null && this.a.m0().J1() != null) {
            co9.a().f(this.a.m0().J1().f2(), this.l.x(), this.a.G6().v1(), this.a.m0().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<bn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof zja) {
                    if (i == 0 && (list.get(i2) instanceof yja)) {
                        i = i2 + 1;
                    }
                    zja zjaVar = (zja) list.get(i2);
                    if (!TextUtils.isEmpty(zjaVar.Z())) {
                        u25 u25Var = new u25();
                        u25Var.e(zjaVar.Z());
                        list.set(i2, u25Var);
                    }
                }
            }
            if (i > 0 && r66.i().q()) {
                r66.i().n(list, i, 5);
            }
        }
    }

    public void q(lk9 lk9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, lk9Var) == null) && lk9Var.O() != null && lk9Var.O().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(lk9Var.O().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                pp9.I(this.a, lk9Var.O().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.G6() != null) {
                this.a.G6().M4();
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
    public void n0(lk9 lk9Var, boolean z) {
        zja zjaVar;
        boolean z2;
        boolean z3;
        zja zjaVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        so9 so9Var;
        boolean z9;
        List<bn> list;
        int i4;
        boolean z10;
        boolean z11;
        bn bnVar;
        int i5;
        boolean z12;
        ko9 ko9Var;
        zja zjaVar3;
        zja zjaVar4;
        zja zjaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048631, this, lk9Var, z) != null) || lk9Var == null) {
            return;
        }
        this.H = lk9Var;
        q(lk9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        lk9 lk9Var2 = this.H;
        if (lk9Var2 != null && lk9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (lk9Var.O() != null && lk9Var.O().getAuthor() != null) {
            this.U = lk9Var.O().getAuthor().getUserId();
        }
        if (this.c == null && !pp9.D(this.a)) {
            return;
        }
        O(lk9Var);
        ArrayList<bn> arrayList = new ArrayList<>(lk9Var.F());
        zja r = r(arrayList);
        if (this.H.O().isQuestionThread()) {
            zjaVar = s(lk9Var);
        } else {
            zjaVar = null;
        }
        if (zjaVar != null) {
            arrayList.remove(zjaVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!ry7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.t0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (lk9Var.x0() && r.f0() != null) {
                r.o1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && lk9Var.i() != null) {
            zja i6 = lk9Var.i();
            if (!this.N && lk9Var.x0() && i6.f0() != null) {
                i6.o1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (zjaVar5 = this.V) != null && i6.r0 == null) {
                lk9Var.H0(zjaVar5);
                zjaVar2 = zjaVar5;
            } else {
                zjaVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            zjaVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.w6()) {
            if (lk9Var.F().size() > 0 && (zjaVar4 = lk9Var.F().get(0)) != null && zjaVar4.L() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        zia.f(arrayList, 1);
        int C = C(lk9Var, arrayList);
        if (C >= 0) {
            Z(lk9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(lk9Var, arrayList);
        if (H >= 0) {
            vk9 vk9Var = new vk9(vk9.c);
            vk9Var.b(true);
            ListUtils.add(arrayList, H, vk9Var);
        }
        int w = w(lk9Var, arrayList);
        List<bn> x = x(lk9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            bn bnVar2 = (bn) ListUtils.getItem(arrayList, w);
            if (bnVar2 instanceof zja) {
                ((zja) bnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(lk9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && lk9Var.S() != null) {
            zja X = lk9Var.X();
            ThreadData c2 = lk9Var.S().c();
            if (X != null && X.v0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure v0 = X.v0();
                VirtualImageCustomState w0 = X.w0();
                c2.setCustomFigure(v0);
                c2.setCustomState(w0);
            }
            G0(this.H, c2);
            ListUtils.add(arrayList, i, lk9Var.S());
            z6 = true;
            z7 = true;
        } else {
            if (zjaVar2 != null) {
                zjaVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.O().isQuestionThread() && zjaVar != null) || (this.H.O().isQuestionThread() && this.W != null)) {
            if (zjaVar == null && (zjaVar3 = this.W) != null) {
                zjaVar = zjaVar3;
            }
            if (!arrayList.contains(zjaVar)) {
                i++;
                c0(zjaVar, arrayList, i);
            }
        }
        if (X(lk9Var, zjaVar2, arrayList, i) != null || W(lk9Var, zjaVar2, arrayList, i) != null || V(lk9Var, arrayList, i) != null) {
            i++;
        }
        if (S(lk9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && lk9Var.N() != null && lk9Var.N().similar_thread != null && lk9Var.N().similar_thread.id.longValue() > 0) {
            b0(lk9Var, arrayList, i);
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
                    so9Var = null;
                } else {
                    so9 Y = Y(arrayList, bnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            so9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    so9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                so9Var = null;
            }
            if (z2) {
                if (so9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(lk9Var, arrayList, z8, z9, i3, i7, w, C);
                if (so9Var != null) {
                    so9Var.n = R;
                }
                if (pp9.D(this.a)) {
                    rk9 rk9Var = new rk9();
                    if (lk9Var.O().getTaskInfoData() != null) {
                        rk9Var.f(lk9Var.O().getTaskInfoData().r());
                        rk9Var.e(lk9Var.O().getTaskInfoData().q());
                    }
                    t49.b(arrayList, rk9Var, 0);
                    if (!z7 && lk9Var.S() != null) {
                        zja X2 = lk9Var.X();
                        ThreadData c3 = lk9Var.S().c();
                        if (X2 != null && X2.v0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure v02 = X2.v0();
                            VirtualImageCustomState w02 = X2.w0();
                            c3.setCustomFigure(v02);
                            c3.setCustomState(w02);
                        }
                        G0(this.H, c3);
                        ListUtils.add(arrayList, 1, lk9Var.S());
                        z6 = true;
                        z7 = true;
                        ko9Var = this.c;
                        if (ko9Var != null) {
                            ko9Var.d0(!z6);
                        }
                        boolean K0 = K0(zjaVar2);
                        if (this.O && !K0) {
                            arrayList.remove(zjaVar2);
                            this.O = false;
                        }
                        if (lk9Var.S() != null) {
                            lk9Var.S().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<bn> R2 = lk9Var.R();
                            if (!ListUtils.isEmpty(R2)) {
                                this.b.setData(K(arrayList, R2));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(zjaVar2, arrayList, z4)) {
                            List<bn> R3 = lk9Var.R();
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
                ko9Var = this.c;
                if (ko9Var != null) {
                }
                boolean K02 = K0(zjaVar2);
                if (this.O) {
                    arrayList.remove(zjaVar2);
                    this.O = false;
                }
                if (lk9Var.S() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(zjaVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (pp9.D(this.a)) {
        }
        ko9Var = this.c;
        if (ko9Var != null) {
        }
        boolean K022 = K0(zjaVar2);
        if (this.O) {
        }
        if (lk9Var.S() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(zjaVar2, arrayList, z4)) {
        }
    }

    public final boolean t(zja zjaVar, ArrayList<bn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, zjaVar, arrayList, z)) == null) {
            if (zjaVar == null) {
                zja zjaVar2 = this.V;
                if (zjaVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, zjaVar2);
                } else {
                    zja zjaVar3 = new zja();
                    zjaVar3.W0(1);
                    ListUtils.add(arrayList, 0, zjaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, zjaVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
