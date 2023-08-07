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
/* loaded from: classes6.dex */
public class kg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<mf9> B;
    public lg9 C;
    public dh9 D;
    public pi9 E;
    public PbFirstFloorWebViewAdapter F;
    public nf9 G;
    public sd9 H;
    public ArrayList<qba> I;
    public ArrayList<ym> J;
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
    public int f1126T;
    public String U;
    public qba V;
    public qba W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public wg9 c;
    public ze9 c0;
    public xg9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<lm> f0;
    public PbFirstFloorItemAdapter g;
    public final List<lm> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public qi9 j;
    public int j0;
    public ni9 k;
    public int k0;
    public th9 l;
    public ThreadData l0;
    public hh9 m;
    public List<qba> m0;
    public th9 n;
    public final CustomMessageListener n0;
    public ng9 o;
    public CustomMessageListener o0;
    public wh9 p;
    public final CustomMessageListener p0;
    public rl9 q;
    public final View.OnClickListener q0;
    public yn6 r;
    public CustomMessageListener r0;
    public lm s;
    public List<lm> s0;
    public lm t;
    public lm u;
    public lm v;
    public lm w;
    public ph9 x;
    public rh9 y;
    public oh9 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg9 a;

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
        public c(kg9 kg9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var, Integer.valueOf(i)};
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
            this.a = kg9Var;
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

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kg9 kg9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var, Integer.valueOf(i)};
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
            this.a = kg9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof oba)) {
                oba obaVar = (oba) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == obaVar) {
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
        public final /* synthetic */ kg9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kg9 kg9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var, Integer.valueOf(i)};
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
            this.a = kg9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof gba)) {
                AbsDelegateAdapterList a = ((gba) customResponsedMessage.getData()).a();
                Iterator<lm<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    lm<?, ?> next = it.next();
                    if (next instanceof pg9) {
                        ((pg9) next).t(this.a.a);
                        if (next instanceof mf9) {
                            this.a.B.add((mf9) next);
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
        public final /* synthetic */ kg9 a;

        public d(kg9 kg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.T() != null) {
                this.a.a.M5().o1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ kg9 b;

        public e(kg9 kg9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kg9Var;
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
        public final /* synthetic */ kg9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(kg9 kg9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var, Integer.valueOf(i)};
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
            this.a = kg9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                kg9 kg9Var = this.a;
                kg9Var.n0(kg9Var.H, false);
            }
        }
    }

    public kg9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1126T = 0;
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
        this.f1126T = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = BdUtilHelper.getEquipmentHeight(this.a.getContext()) / 3;
    }

    public final ym Q(ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            pba K0 = this.a.R().K0();
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
                az9.j(K0, h);
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
            sd9 sd9Var = this.H;
            if (sd9Var != null && sd9Var.y() != null) {
                K0.l1 = this.H.y().a();
            }
            l(K0);
            if (i < 0) {
                return null;
            }
            K0.o1 = 1;
            j46.k().q(true);
            cy8.b(arrayList, K0, i);
            sd9 sd9Var2 = this.H;
            if (sd9Var2 != null) {
                sd9Var2.M0(K0);
            }
            if (c56.i().q()) {
                c56.i().n(arrayList, i + 1, 4);
            }
            return K0;
        }
        return (ym) invokeLI.objValue;
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

    public void H0(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ze9Var) == null) {
            this.c0 = ze9Var;
        }
    }

    public void J0(@NonNull sd9 sd9Var) {
        wg9 wg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, sd9Var) == null) && (wg9Var = this.c) != null) {
            wg9Var.i0(sd9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, yd9.c);
        }
    }

    public void j0(boolean z) {
        wg9 wg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (wg9Var = this.c) != null) {
            wg9Var.V(z);
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

    public final qba s(sd9 sd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, sd9Var)) == null) {
            if (sd9Var != null && sd9Var.U() != null) {
                qba U = sd9Var.U();
                this.W = U;
                return U;
            }
            return null;
        }
        return (qba) invokeL.objValue;
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
        ng9 ng9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (ng9Var = this.o) != null) {
            ng9Var.q0(z);
        }
    }

    public ym z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (ym) invokeI.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public final void G0(sd9 sd9Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, sd9Var, threadData) == null) && sd9Var != null && sd9Var.K() != null && threadData != null) {
            threadData.setRobotEntrance(sd9Var.K());
        }
    }

    public final int I(wd9 wd9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, wd9Var, i)) == null) {
            if (wd9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (wd9Var.Z()) {
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
            ng9 ng9Var = this.o;
            if (ng9Var != null) {
                ng9Var.r0(z);
            }
            th9 th9Var = this.l;
            if (th9Var != null) {
                th9Var.A(z);
            }
            lm lmVar = this.w;
            if (lmVar != null) {
                lmVar.setMulDel(z);
            }
            lm lmVar2 = this.t;
            if (lmVar2 != null) {
                lmVar2.setMulDel(z);
            }
            wg9 wg9Var = this.c;
            if (wg9Var != null) {
                wg9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(qba qbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, qbaVar)) == null) {
            if (this.a.R() != null && qbaVar != null && qbaVar.S() != null && qbaVar.S().equals(this.a.R().Q1())) {
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
            wg9 wg9Var = this.c;
            if (wg9Var != null) {
                wg9Var.setFromCDN(z);
            }
            lm lmVar = this.t;
            if (lmVar != null && (lmVar instanceof gx9)) {
                ((gx9) lmVar).setIsFromCDN(z);
            }
            Iterator<mf9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final qba r(ArrayList<ym> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<ym> it = arrayList.iterator();
            while (it.hasNext()) {
                ym next = it.next();
                if (next instanceof qba) {
                    qba qbaVar = (qba) next;
                    if (qbaVar.I() == 1) {
                        return qbaVar;
                    }
                }
            }
            return null;
        }
        return (qba) invokeL.objValue;
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
        hh9 hh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (hh9Var = this.m) != null) {
            hh9Var.z(2);
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
            if (this.b.getAdapter2() instanceof pm) {
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

    public ArrayList<ym> v() {
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

    public final int C(sd9 sd9Var, ArrayList<ym> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, sd9Var, arrayList)) == null) {
            if (sd9Var == null || ListUtils.isEmpty(sd9Var.F()) || ListUtils.isEmpty(arrayList) || ((qba) ListUtils.getItem(sd9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    ym ymVar = arrayList.get(i);
                    if (ymVar instanceof qba) {
                        qba qbaVar = (qba) ymVar;
                        if (qbaVar.I() == 1 && qbaVar.O == 0) {
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

    public final int H(sd9 sd9Var, ArrayList<ym> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, sd9Var, arrayList)) == null) {
            int i = -1;
            if (sd9Var == null || sd9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (sd9Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof he9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (sd9Var.J() == 4) {
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
                    ym ymVar = this.b.getData().get(i);
                    if (ymVar != null && ymVar.getType() == he9.g) {
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
            th9 th9Var = this.l;
            if (th9Var != null) {
                th9Var.onDestroy();
            }
            th9 th9Var2 = this.n;
            if (th9Var2 != null) {
                th9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            ni9 ni9Var = this.k;
            if (ni9Var != null) {
                ni9Var.onDestroy();
            }
            j46.k().q(false);
        }
    }

    public int E(sd9 sd9Var, ArrayList<ym> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, sd9Var, arrayList, z)) == null) {
            if (sd9Var == null || sd9Var.F() == null || sd9Var.C() == null || sd9Var.F().size() == 0 || sd9Var.O() == null || arrayList == null || !sd9Var.C().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (sd9Var.F().get(0) == null || sd9Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (sd9Var.y() == null || sd9Var.y().a() != sd9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(sd9 sd9Var, ArrayList<ym> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, sd9Var, arrayList, z)) == null) {
            if (sd9Var == null || sd9Var.F() == null || sd9Var.D() == null || sd9Var.F().size() == 0 || sd9Var.O() == null || arrayList == null || !sd9Var.D().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (sd9Var.F().get(0) == null || sd9Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (sd9Var.y() == null || sd9Var.y().a() != sd9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final ym V(sd9 sd9Var, ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLLI;
        ud9 ud9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, sd9Var, arrayList, i)) == null) {
            if (sd9Var.k() != null && !StringUtils.isNull(sd9Var.k().getName()) && !sd9Var.m) {
                if (!TextUtils.equals(sd9Var.k().getName(), this.a.R().Q0()) || !this.a.R().W0()) {
                    if (!this.a.A0() && !ListUtils.isEmpty(sd9Var.o())) {
                        ud9Var = new ud9(sd9Var.o().get(0));
                    } else {
                        ud9Var = new ud9(sd9Var.k());
                    }
                    ud9Var.g = this.a.R().K1();
                    if (!UbsABTestHelper.isPbEnterForum()) {
                        i++;
                    }
                    ListUtils.add(arrayList, i, ud9Var);
                    return ud9Var;
                }
                return null;
            }
            return null;
        }
        return (ym) invokeLLI.objValue;
    }

    public final int b0(sd9 sd9Var, ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, sd9Var, arrayList, i)) == null) {
            wd9 wd9Var = new wd9(sd9Var.N());
            String tid = wd9Var.X().getTid();
            int q1 = this.a.R().q1();
            sd9Var.O0(I(wd9Var, q1));
            xd9 xd9Var = new xd9(wd9Var.V(), wd9Var.W());
            xd9Var.a = wd9Var.X();
            xd9Var.C = q1;
            xd9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, xd9Var);
            wd9Var.X().isLinkThread();
            wd9Var.X().isSmartAppThreadType();
            if (!wd9Var.X().isLinkThread() && !wd9Var.X().isSmartAppThreadType()) {
                wd9Var.X().isGodThread();
            }
            wd9Var.a = wd9Var.X();
            wd9Var.C = q1;
            wd9Var.g = tid;
            wd9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, wd9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(sd9 sd9Var, ArrayList<ym> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, sd9Var, arrayList, z)) == null) {
            if (sd9Var != null && !ListUtils.isEmpty(sd9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (sd9Var.F().get(0) != null && sd9Var.F().get(0).I() == 1) {
                    return 1;
                }
                if (sd9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (sd9Var == null || !sd9Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(sd9 sd9Var, ArrayList<ym> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, sd9Var, arrayList, i) == null) {
            he9 he9Var = new he9(he9.g);
            ThreadData O = sd9Var.O();
            he9Var.c = this.a.e6();
            he9Var.b = sd9Var.g;
            he9Var.d = sd9Var.j0();
            he9Var.e = sd9Var.f;
            if (O != null && O.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            he9Var.f = z;
            ListUtils.add(arrayList, i, he9Var);
            if (sd9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new ge9());
            }
        }
    }

    public final ArrayList<ym> K(List<ym> list, List<ym> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<ym> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            ae9 ae9Var = new ae9();
            PbListView s1 = this.a.M5().s1();
            if (s1 != null && s1.q()) {
                ae9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe5);
                ae9Var.b = true;
            } else {
                ae9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                ae9Var.b = false;
            }
            arrayList.add(ae9Var);
            bo6 bo6Var = new bo6();
            bo6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            bo6Var.needTopMargin = false;
            arrayList.add(bo6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final void M(ArrayList<ym> arrayList, Boolean bool) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = tb5.i();
        int j = tb5.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            ym ymVar = arrayList.get(0);
            if ((ymVar instanceof qba) && ((qba) ymVar).I() == 1) {
                z = true;
            } else {
                z = false;
            }
            ym ymVar2 = arrayList.get(arrayList.size() - 1);
            if ((ymVar2 instanceof qba) && ((qba) ymVar2).I() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = tb5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.R() != null && this.a.R().B1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(sd9 sd9Var, ArrayList<ym> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, sd9Var, arrayList)) == null) {
            if (!this.P && sd9Var != null && !ListUtils.isEmpty(sd9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.R() != null && this.a.R().a1()) {
                    return -1;
                }
                if (this.a.M5() != null && this.a.M5().k1()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        ym ymVar = arrayList.get(i);
                        if (ymVar instanceof qba) {
                            qba qbaVar = (qba) ymVar;
                            if (qbaVar.I() == 1 && qbaVar.O == 0) {
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
                    if (sd9Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (sd9Var != null && sd9Var.x0() && this.N) {
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
            wg9 wg9Var = this.c;
            if (wg9Var != null && wg9Var.Q() != null) {
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
        qba qbaVar;
        wg9 wg9Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (qbaVar = this.V) != null && qbaVar.a0() != null && (wg9Var = this.c) != null && wg9Var.Q() != null) {
            String Q = this.H.Q();
            String l = this.H.l();
            if (this.H.O() != null) {
                i = this.H.O().getThreadType();
            } else {
                i = 0;
            }
            vq5.a().c(Q, l, this.V.a0(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new xg9(this.a, qba.V0);
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
        sd9 sd9Var;
        pba pbaVar;
        pba pbaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (sd9Var = this.H) == null || sd9Var.Z || sd9Var.a0 == 2) {
            return;
        }
        ArrayList<qba> F = sd9Var.F();
        ArrayList<pba> d2 = this.H.d();
        if (!cy8.e(F) && !cy8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<pba> it = d2.iterator();
            while (it.hasNext()) {
                pba next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<pba> it2 = d2.iterator();
            while (it2.hasNext()) {
                pba next2 = it2.next();
                if (next2 != null) {
                    next2.n1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<pba> it3 = d2.iterator();
            while (it3.hasNext()) {
                pba next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        az9.j(next3, h);
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
                pba pbaVar3 = (pba) sparseArray.valueAt(i);
                if (pbaVar3 != null && (pbaVar2 = (pba) hashMap.put(pbaVar3.z1(), pbaVar3)) != null) {
                    az9.j(pbaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (pbaVar = (pba) entry.getValue()) != null) {
                    sparseArray.put(pbaVar.getPosition(), pbaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                cy8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < cy8.i(arrayList); i4++) {
                pba pbaVar4 = (pba) sparseArray.get(((Integer) cy8.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    pbaVar4.h1 = this.H.k().getId();
                }
                if (this.H.O() != null) {
                    pbaVar4.k1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
                }
                sd9 sd9Var2 = this.H;
                if (sd9Var2 != null && sd9Var2.y() != null) {
                    pbaVar4.l1 = this.H.y().a();
                }
                l(pbaVar4);
                int position = pbaVar4.getPosition() + this.H.Y;
                if (position >= cy8.i(F)) {
                    pbaVar4.n1 = position;
                    az9.k(pbaVar4, 2, position, cy8.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    pbaVar4.n1 = position;
                }
                if (position < 0) {
                    az9.j(pbaVar4, 23);
                } else {
                    pbaVar4.o1 = i3;
                    cy8.b(F, pbaVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pbaVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        xg9 xg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (ai9.D(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new xg9(pbFragment, qba.V0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                wg9 wg9Var = new wg9(pbFragment, qba.V0);
                this.c = wg9Var;
                wg9Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, ie9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, ud9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), vd9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), xd9.f1186T);
            this.j = new qi9(pbFragment.getPageContext(), wd9.X0);
            this.k = new ni9(pbFragment, pd9.c);
            this.l = new th9(pbFragment, he9.g);
            this.m = new hh9(pbFragment, ce9.c);
            this.n = new th9(pbFragment, he9.h);
            ng9 ng9Var = new ng9(pbFragment, qba.W0);
            this.o = ng9Var;
            ng9Var.t0(pbFragment);
            wh9 wh9Var = new wh9(pbFragment, qba.X0);
            this.p = wh9Var;
            wh9Var.v0(pbFragment);
            this.s = lx9.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.y);
            this.t = lx9.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.A);
            this.u = dv7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.v = dv7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = dv7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J);
            this.z = new oh9(pbFragment, ee9.j1);
            this.x = new ph9(pbFragment, nh9.i1);
            this.y = new rh9(pbFragment, x25.o1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, qba.d1);
            this.q = new rl9(pbFragment, sl9.a);
            this.r = new yn6(pbFragment.getPageContext());
            this.C = new lg9(pbFragment, h15.e);
            this.D = new dh9(pbFragment, pbFragment.getUniqueId());
            this.E = new pi9(pbFragment.getPageContext(), h56.g);
            if (ai9.D(pbFragment)) {
                P(pbFragment);
            }
            nf9 nf9Var = new nf9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = nf9Var;
            this.f0.addAll(nf9Var.a());
            if (ai9.D(pbFragment) && (xg9Var = this.d) != null) {
                this.f0.add(xg9Var);
            } else {
                wg9 wg9Var2 = this.c;
                if (wg9Var2 != null) {
                    this.f0.add(wg9Var2);
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
            if (ai9.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new gba(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull sd9 sd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sd9Var) == null) {
            wg9 wg9Var = this.c;
            if (wg9Var != null) {
                wg9Var.r(sd9Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1126T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(sd9Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.s0(this.c0);
            this.p.r(sd9Var);
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
            lm lmVar = this.t;
            if (lmVar != null && (lmVar instanceof gx9)) {
                ((gx9) lmVar).setIsFromCDN(this.K);
            }
            Iterator<mf9> it = this.B.iterator();
            while (it.hasNext()) {
                mf9 next = it.next();
                if (next != null) {
                    next.r(sd9Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1126T);
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
            this.l.r(sd9Var);
            this.k.r(sd9Var);
            this.n.r(sd9Var);
            this.x.r(sd9Var);
            this.y.r(sd9Var);
            this.C.A(sd9Var);
            this.C.z(this.a.s1);
            this.D.y(sd9Var);
        }
    }

    public final boolean R(sd9 sd9Var, ArrayList<ym> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{sd9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(sd9Var.e()) && sd9Var.e().size() > 2) {
                int min = Math.min(sd9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    h15 h15Var = sd9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        h15Var.h(true);
                    }
                    if (h15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            h15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        h15Var.l(true);
                    } else if (i6 == min - 1) {
                        h15Var.i(true);
                    }
                    arrayList2.add(h15Var);
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

    public final ym S(sd9 sd9Var, ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLLI;
        pd9 pd9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, sd9Var, arrayList, i)) == null) {
            if (i >= 0 && sd9Var != null && sd9Var.k && (pd9Var = sd9Var.l) != null) {
                ListUtils.add(arrayList, i, pd9Var);
                return pd9Var;
            }
            return null;
        }
        return (ym) invokeLLI.objValue;
    }

    public final void c0(qba qbaVar, ArrayList<ym> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, qbaVar, arrayList, i) == null) {
            qbaVar.q1(true);
            arrayList.add(i, qbaVar);
        }
    }

    public final ym T(ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLI;
        sd9 sd9Var;
        oba obaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (ai9.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (sd9Var = this.H) != null && sd9Var.t0()) {
                String d2 = iv7.e().d("pb_banner");
                if (this.l0 == null && cv7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new oba();
                    sd9 sd9Var2 = this.H;
                    if (sd9Var2 != null) {
                        this.l0.funAdData.m(sd9Var2.l());
                        this.l0.funAdData.r(this.H.Q());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (obaVar = threadData2.funAdData) != null) {
                    obaVar.j(1);
                    j46.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (c56.i().q()) {
                        c56.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (ym) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<ym> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<ym> listIterator = arrayList.listIterator();
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
                        qba qbaVar = new qba();
                        oba obaVar = new oba();
                        sd9 sd9Var = this.H;
                        if (sd9Var == null) {
                            str3 = "";
                        } else {
                            str3 = sd9Var.l();
                        }
                        obaVar.m(str3);
                        sd9 sd9Var2 = this.H;
                        if (sd9Var2 != null) {
                            str = sd9Var2.Q();
                        }
                        obaVar.r(str);
                        obaVar.n(true);
                        qbaVar.x0 = obaVar;
                        obaVar.j(i7);
                        listIterator.add(qbaVar);
                        i7++;
                        this.m0.add(qbaVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && c56.i().q()) {
                c56.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                qba qbaVar2 = new qba();
                oba obaVar2 = new oba();
                sd9 sd9Var3 = this.H;
                if (sd9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = sd9Var3.l();
                }
                obaVar2.m(str2);
                sd9 sd9Var4 = this.H;
                if (sd9Var4 != null) {
                    str = sd9Var4.Q();
                }
                obaVar2.r(str);
                obaVar2.n(true);
                qbaVar2.x0 = obaVar2;
                obaVar2.j(1);
                listIterator.add(qbaVar2);
                this.m0.add(qbaVar2);
                if (c56.i().q()) {
                    c56.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final ym W(sd9 sd9Var, qba qbaVar, ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, sd9Var, qbaVar, arrayList, i)) == null) {
            vd9 vd9Var = null;
            if (sd9Var.k() != null && !StringUtils.isNull(sd9Var.k().getName()) && TextUtils.equals(sd9Var.k().getName(), this.a.R().Q0()) && this.a.R().W0()) {
                return null;
            }
            if (qbaVar != null) {
                if (qbaVar.s0 != null) {
                    vd9Var = new vd9(qbaVar.s0);
                }
            } else {
                qba qbaVar2 = this.V;
                if (qbaVar2 != null && qbaVar2.s0 != null) {
                    vd9Var = new vd9(this.V.s0);
                }
            }
            if (vd9Var != null) {
                vd9Var.b = this.a.R().K1();
                ListUtils.add(arrayList, i + 1, vd9Var);
            }
            return vd9Var;
        }
        return (ym) invokeLLLI.objValue;
    }

    public final ym X(sd9 sd9Var, qba qbaVar, ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, sd9Var, qbaVar, arrayList, i)) == null) {
            if (qbaVar != null && qbaVar.b0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(qbaVar.b0());
            } else {
                qba qbaVar2 = this.V;
                if (qbaVar2 != null && qbaVar2.b0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.b0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (sd9Var != null && !TextUtils.isEmpty(sd9Var.Q())) {
                    pbFirstFloorRecommendData.f(sd9Var.Q());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (ym) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<ym> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                SafeHandler.getInst().post(this.h0);
            }
        }
    }

    public final eh9 Y(ArrayList<ym> arrayList, ym ymVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, ymVar, i, i2)) == null) {
            eh9 B = this.H.B();
            if (B != null) {
                if (ymVar != null) {
                    if (i2 < 0 && ymVar.getType() != AdvertAppInfo.A) {
                        i2 = i + 2;
                    } else if (ymVar.getType() != AdvertAppInfo.A) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof eh9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (eh9) invokeLLII.objValue;
    }

    public final ym a0(ArrayList<ym> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (R = this.a.R()) == null || TextUtils.isEmpty(R.v1())) {
                return null;
            }
            pba pbaVar = new pba();
            l(pbaVar);
            ListUtils.add(arrayList, i + 1, pbaVar);
            return pbaVar;
        }
        return (ym) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.M5() != null) {
            this.a.M5().w2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        wg9 wg9Var = this.c;
                        if (wg9Var != null) {
                            wg9Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        lm lmVar = this.t;
                        if (lmVar instanceof bx9) {
                            ((bx9) lmVar).onDestroy();
                        }
                        lm lmVar2 = this.u;
                        if (lmVar2 instanceof bx9) {
                            ((bx9) lmVar2).onDestroy();
                        }
                        lm lmVar3 = this.w;
                        if (lmVar3 instanceof bx9) {
                            ((bx9) lmVar3).onDestroy();
                        }
                        og9.a().d();
                        return;
                    }
                    return;
                }
                wg9 wg9Var2 = this.c;
                if (wg9Var2 != null) {
                    wg9Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                lm lmVar4 = this.t;
                if (lmVar4 instanceof bx9) {
                    ((bx9) lmVar4).onResume();
                }
                lm lmVar5 = this.u;
                if (lmVar5 instanceof bx9) {
                    ((bx9) lmVar5).onResume();
                }
                lm lmVar6 = this.w;
                if (lmVar6 instanceof bx9) {
                    ((bx9) lmVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            wg9 wg9Var3 = this.c;
            if (wg9Var3 != null) {
                wg9Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            lm lmVar7 = this.t;
            if (lmVar7 instanceof bx9) {
                ((bx9) lmVar7).onPause();
            }
            lm lmVar8 = this.u;
            if (lmVar8 instanceof bx9) {
                ((bx9) lmVar8).onPause();
            }
            lm lmVar9 = this.w;
            if (lmVar9 instanceof bx9) {
                ((bx9) lmVar9).onPause();
            }
            og9.a().i(this.a.Y());
            vq5.a().d();
        }
    }

    public final void l(pba pbaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, pbaVar) == null) && pbaVar != null && this.H != null && pbaVar.getAdvertAppInfo() != null) {
            pbaVar.getAdvertAppInfo().i = new v05();
            if (this.H.y() != null) {
                pbaVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            pbaVar.getAdvertAppInfo().i.a = pbaVar.B1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                pbaVar.getAdvertAppInfo().i.c = k.getId();
                pbaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                pbaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                pbaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            pbaVar.getAdvertAppInfo().i.g = pbaVar.getAdvertAppInfo().g;
            pbaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<ym> x(sd9 sd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, sd9Var)) == null) {
            if (sd9Var == null || sd9Var.T() == null || ListUtils.isEmpty(sd9Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<qba> list = sd9Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                qba qbaVar = list.get(i);
                if (qbaVar != null) {
                    qbaVar.d0 = true;
                    qbaVar.P = true;
                    arrayList.add(qbaVar);
                }
            }
            if (ListUtils.getCount(sd9Var.T().b) > 2) {
                ym ymVar = (ym) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (ymVar instanceof qba) {
                    ((qba) ymVar).P = false;
                }
                arrayList.add(new sl9());
            } else {
                ym ymVar2 = (ym) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (ymVar2 instanceof qba) {
                    ((qba) ymVar2).P = true;
                }
            }
            arrayList.add(0, new he9(he9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.M5() != null && this.a.Y() != null && this.a.Y().J1() != null) {
            og9.a().f(this.a.Y().J1().e2(), this.l.x(), this.a.M5().u1(), this.a.Y().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<ym> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof qba) {
                    if (i == 0 && (list.get(i2) instanceof pba)) {
                        i = i2 + 1;
                    }
                    qba qbaVar = (qba) list.get(i2);
                    if (!TextUtils.isEmpty(qbaVar.Y())) {
                        j25 j25Var = new j25();
                        j25Var.e(qbaVar.Y());
                        list.set(i2, j25Var);
                    }
                }
            }
            if (i > 0 && c56.i().q()) {
                c56.i().n(list, i, 5);
            }
        }
    }

    public void q(sd9 sd9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, sd9Var) == null) && sd9Var.O() != null && sd9Var.O().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(sd9Var.O().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                ai9.H(this.a, sd9Var.O().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.M5() != null) {
                this.a.M5().E4();
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
            ArrayList<BdUniqueId> g = raa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ux8 b2 = yy8.d().b(this.a.getPageContext(), g.get(i), 2);
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
    public void n0(sd9 sd9Var, boolean z) {
        qba qbaVar;
        boolean z2;
        boolean z3;
        qba qbaVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        eh9 eh9Var;
        boolean z9;
        List<ym> list;
        int i4;
        boolean z10;
        boolean z11;
        ym ymVar;
        int i5;
        boolean z12;
        wg9 wg9Var;
        qba qbaVar3;
        qba qbaVar4;
        qba qbaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048631, this, sd9Var, z) != null) || sd9Var == null) {
            return;
        }
        this.H = sd9Var;
        q(sd9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        sd9 sd9Var2 = this.H;
        if (sd9Var2 != null && sd9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (sd9Var.O() != null && sd9Var.O().getAuthor() != null) {
            this.U = sd9Var.O().getAuthor().getUserId();
        }
        if (this.c == null && !ai9.D(this.a)) {
            return;
        }
        O(sd9Var);
        ArrayList<ym> arrayList = new ArrayList<>(sd9Var.F());
        qba r = r(arrayList);
        if (this.H.O().isQuestionThread()) {
            qbaVar = s(sd9Var);
        } else {
            qbaVar = null;
        }
        if (qbaVar != null) {
            arrayList.remove(qbaVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!jv7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.t0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (sd9Var.x0() && r.e0() != null) {
                r.k1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && sd9Var.i() != null) {
            qba i6 = sd9Var.i();
            if (!this.N && sd9Var.x0() && i6.e0() != null) {
                i6.k1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (qbaVar5 = this.V) != null && i6.j0 == null) {
                sd9Var.G0(qbaVar5);
                qbaVar2 = qbaVar5;
            } else {
                qbaVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            qbaVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.C5()) {
            if (sd9Var.F().size() > 0 && (qbaVar4 = sd9Var.F().get(0)) != null && qbaVar4.I() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        raa.f(arrayList, 1);
        int C = C(sd9Var, arrayList);
        if (C >= 0) {
            Z(sd9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(sd9Var, arrayList);
        if (H >= 0) {
            ce9 ce9Var = new ce9(ce9.c);
            ce9Var.b(true);
            ListUtils.add(arrayList, H, ce9Var);
        }
        int w = w(sd9Var, arrayList);
        List<ym> x = x(sd9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            ym ymVar2 = (ym) ListUtils.getItem(arrayList, w);
            if (ymVar2 instanceof qba) {
                ((qba) ymVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(sd9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && sd9Var.S() != null) {
            qba X = sd9Var.X();
            ThreadData c2 = sd9Var.S().c();
            if (X != null && X.u0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure u0 = X.u0();
                VirtualImageCustomState v0 = X.v0();
                c2.setCustomFigure(u0);
                c2.setCustomState(v0);
            }
            G0(this.H, c2);
            ListUtils.add(arrayList, i, sd9Var.S());
            z6 = true;
            z7 = true;
        } else {
            if (qbaVar2 != null) {
                qbaVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.O().isQuestionThread() && qbaVar != null) || (this.H.O().isQuestionThread() && this.W != null)) {
            if (qbaVar == null && (qbaVar3 = this.W) != null) {
                qbaVar = qbaVar3;
            }
            if (!arrayList.contains(qbaVar)) {
                i++;
                c0(qbaVar, arrayList, i);
            }
        }
        if (X(sd9Var, qbaVar2, arrayList, i) != null || W(sd9Var, qbaVar2, arrayList, i) != null || V(sd9Var, arrayList, i) != null) {
            i++;
        }
        if (S(sd9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && sd9Var.N() != null && sd9Var.N().similar_thread != null && sd9Var.N().similar_thread.id.longValue() > 0) {
            b0(sd9Var, arrayList, i);
        } else {
            if (z2) {
                ym a0 = a0(arrayList, i);
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
                    ymVar = Q(arrayList, i5);
                    if (ymVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    ymVar = a0;
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
                    eh9Var = null;
                } else {
                    eh9 Y = Y(arrayList, ymVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            eh9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    eh9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                eh9Var = null;
            }
            if (z2) {
                if (eh9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(sd9Var, arrayList, z8, z9, i3, i7, w, C);
                if (eh9Var != null) {
                    eh9Var.n = R;
                }
                if (ai9.D(this.a)) {
                    yd9 yd9Var = new yd9();
                    if (sd9Var.O().getTaskInfoData() != null) {
                        yd9Var.f(sd9Var.O().getTaskInfoData().r());
                        yd9Var.e(sd9Var.O().getTaskInfoData().q());
                    }
                    cy8.b(arrayList, yd9Var, 0);
                    if (!z7 && sd9Var.S() != null) {
                        qba X2 = sd9Var.X();
                        ThreadData c3 = sd9Var.S().c();
                        if (X2 != null && X2.u0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure u02 = X2.u0();
                            VirtualImageCustomState v02 = X2.v0();
                            c3.setCustomFigure(u02);
                            c3.setCustomState(v02);
                        }
                        G0(this.H, c3);
                        ListUtils.add(arrayList, 1, sd9Var.S());
                        z6 = true;
                        z7 = true;
                        wg9Var = this.c;
                        if (wg9Var != null) {
                            wg9Var.e0(!z6);
                        }
                        boolean K0 = K0(qbaVar2);
                        if (this.O && !K0) {
                            arrayList.remove(qbaVar2);
                            this.O = false;
                        }
                        if (sd9Var.S() != null) {
                            sd9Var.S().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<ym> R2 = sd9Var.R();
                            if (!ListUtils.isEmpty(R2)) {
                                this.b.setData(K(arrayList, R2));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(qbaVar2, arrayList, z4)) {
                            List<ym> R3 = sd9Var.R();
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
                wg9Var = this.c;
                if (wg9Var != null) {
                }
                boolean K02 = K0(qbaVar2);
                if (this.O) {
                    arrayList.remove(qbaVar2);
                    this.O = false;
                }
                if (sd9Var.S() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(qbaVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (ai9.D(this.a)) {
        }
        wg9Var = this.c;
        if (wg9Var != null) {
        }
        boolean K022 = K0(qbaVar2);
        if (this.O) {
        }
        if (sd9Var.S() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(qbaVar2, arrayList, z4)) {
        }
    }

    public final boolean t(qba qbaVar, ArrayList<ym> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, qbaVar, arrayList, z)) == null) {
            if (qbaVar == null) {
                qba qbaVar2 = this.V;
                if (qbaVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, qbaVar2);
                } else {
                    qba qbaVar3 = new qba();
                    qbaVar3.S0(1);
                    ListUtils.add(arrayList, 0, qbaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, qbaVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
