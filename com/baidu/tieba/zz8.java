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
public class zz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a09 A;
    public p09 B;
    public b29 C;
    public PbFirstFloorWebViewAdapter D;
    public dz8 E;
    public lx8 F;
    public ArrayList<rr9> G;
    public ArrayList<rn> H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public String S;
    public rr9 T;
    public rr9 U;
    public View.OnClickListener V;
    public View.OnClickListener W;
    public View.OnClickListener X;
    public TbRichTextView.a0 Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public py8 a0;
    public BdTypeListView b;
    public View.OnLongClickListener b0;
    public h09 c;
    public SortSwitchButton.f c0;
    public i09 d;
    public final List<en> d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public final List<en> e0;
    public PbFirstFloorEnterForumAdapter f;
    public Runnable f0;
    public PbFirstFloorItemAdapter g;
    public int g0;
    public PbFirstFloorRecommendAdapter h;
    public int h0;
    public z19 i;
    public int i0;
    public f19 j;
    public ThreadData j0;
    public t09 k;
    public List<rr9> k0;
    public f19 l;
    public final CustomMessageListener l0;
    public c09 m;
    public CustomMessageListener m0;
    public i19 n;
    public final CustomMessageListener n0;
    public s49 o;
    public final View.OnClickListener o0;
    public rk6 p;
    public CustomMessageListener p0;
    public en q;
    public List<en> q0;
    public en r;
    public en s;
    public en t;
    public en u;
    public b19 v;
    public d19 w;
    public a19 x;
    public PbReplyLoadMoreAdapter y;
    public ArrayList<cz8> z;

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz8 a;

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
                    this.a.a.d0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zz8 zz8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz8Var, Integer.valueOf(i)};
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
            this.a = zz8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F != null && !m9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    sg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ zz8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zz8 zz8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz8Var, Integer.valueOf(i)};
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
            this.a = zz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof pr9)) {
                pr9 pr9Var = (pr9) customResponsedMessage.getData();
                if (this.a.j0 != null && this.a.j0.funAdData == pr9Var) {
                    this.a.j0.funAdData.p(true);
                    this.a.b.setData(this.a.H);
                    this.a.d0();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zz8 zz8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz8Var, Integer.valueOf(i)};
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
            this.a = zz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof gr9)) {
                AbsDelegateAdapterList a = ((gr9) customResponsedMessage.getData()).a();
                Iterator<en<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    en<?, ?> next = it.next();
                    if (next instanceof e09) {
                        ((e09) next).t(this.a.a);
                        if (next instanceof cz8) {
                            this.a.z.add((cz8) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.e0.clear();
                this.a.e0.addAll(arrayList);
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
        public final /* synthetic */ zz8 a;

        public d(zz8 zz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.F != null && this.a.F.R() != null) {
                this.a.a.K5().Z0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ zz8 b;

        public e(zz8 zz8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zz8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.h0);
                this.b.P = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(zz8 zz8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz8Var, Integer.valueOf(i)};
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
            this.a = zz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.q0)) {
                this.a.n();
                zz8 zz8Var = this.a;
                zz8Var.l0(zz8Var.F, false);
            }
        }
    }

    public zz8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.z = new ArrayList<>();
        this.G = new ArrayList<>();
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.Q = false;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = new ArrayList();
        this.e0 = new ArrayList();
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = -1;
        this.k0 = new ArrayList();
        this.l0 = new a(this, 2921523);
        this.m0 = new b(this, 2004015);
        this.n0 = new c(this, 2001118);
        this.o0 = new d(this);
        this.p0 = new f(this, 2016470);
        this.R = ri.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        M(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.n0);
        this.h0 = ri.j(this.a.getContext()) / 3;
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

    public void A0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
            this.b0 = onLongClickListener;
        }
    }

    public void B0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.c0 = fVar;
        }
    }

    public void C0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.W = onClickListener;
        }
    }

    public void D0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public void E0(py8 py8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, py8Var) == null) {
            this.a0 = py8Var;
        }
    }

    public void G0(@NonNull lx8 lx8Var) {
        h09 h09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, lx8Var) == null) && (h09Var = this.c) != null) {
            h09Var.i0(lx8Var);
        }
    }

    public final void O(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.D = new PbFirstFloorWebViewAdapter(pbFragment, px8.c);
        }
    }

    public void h0(boolean z) {
        h09 h09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z) == null) && (h09Var = this.c) != null) {
            h09Var.V(z);
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.J = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.M = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.K = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.Q = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.N = z;
        }
    }

    public final rr9 s(lx8 lx8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, lx8Var)) == null) {
            if (lx8Var != null && lx8Var.S() != null) {
                rr9 S = lx8Var.S();
                this.U = S;
                return S;
            }
            return null;
        }
        return (rr9) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.O = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.L = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.P = z;
        }
    }

    public void v0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public void w0(boolean z) {
        c09 c09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048646, this, z) == null) && (c09Var = this.m) != null) {
            c09Var.p0(z);
        }
    }

    public void x0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }

    public rn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i)) == null) {
            return this.b.G(i);
        }
        return (rn) invokeI.objValue;
    }

    public void z0(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, a0Var) == null) {
            this.Y = a0Var;
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

    public void F0() {
        t09 t09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (t09Var = this.k) != null) {
            t09Var.z(2);
        }
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g0;
        }
        return invokeV.intValue;
    }

    public void J0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (i = this.i0) > 0 && S(this.H, i) != null) {
            this.i0 = -1;
            this.b.setData(this.H);
            d0();
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.g0 = D();
            if (this.b.getAdapter2() instanceof in) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.p0);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.E.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<rn> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.H;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public final int C(lx8 lx8Var, ArrayList<rn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, lx8Var, arrayList)) == null) {
            if (lx8Var == null || ListUtils.isEmpty(lx8Var.F()) || ListUtils.isEmpty(arrayList) || ((rr9) ListUtils.getItem(lx8Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    rn rnVar = arrayList.get(i);
                    if (rnVar instanceof rr9) {
                        rr9 rr9Var = (rr9) rnVar;
                        if (rr9Var.D() == 1 && rr9Var.O == 0) {
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

    public final int H(lx8 lx8Var, ArrayList<rn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, lx8Var, arrayList)) == null) {
            int i = -1;
            if (lx8Var == null || lx8Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (lx8Var.y().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.J) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof zx8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (lx8Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void L(ArrayList<rn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048597, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = l95.i();
        int j = l95.j() - 1;
        if (bool.booleanValue()) {
            rn rnVar = arrayList.get(0);
            if ((rnVar instanceof rr9) && ((rr9) rnVar).D() == 1) {
                j++;
            }
        }
        int k = l95.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.P() != null && this.a.P().I1() == 3) {
            this.k0.clear();
        }
        T(j, i, k, arrayList);
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    rn rnVar = this.b.getData().get(i);
                    if (rnVar != null && rnVar.getType() == zx8.g) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            sg.a().removeCallbacks(this.f0);
            f19 f19Var = this.j;
            if (f19Var != null) {
                f19Var.onDestroy();
            }
            f19 f19Var2 = this.l;
            if (f19Var2 != null) {
                f19Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            z19 z19Var = this.i;
            if (z19Var != null) {
                z19Var.onDestroy();
            }
            l16.k().q(false);
        }
    }

    public int E(lx8 lx8Var, ArrayList<rn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, lx8Var, arrayList, z)) == null) {
            if (lx8Var == null || lx8Var.F() == null || lx8Var.C() == null || lx8Var.F().size() == 0 || lx8Var.M() == null || arrayList == null || !lx8Var.C().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (lx8Var.F().get(0) == null || lx8Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (lx8Var.y() == null || lx8Var.y().a() != lx8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(lx8 lx8Var, ArrayList<rn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, lx8Var, arrayList, z)) == null) {
            if (lx8Var == null || lx8Var.F() == null || lx8Var.D() == null || lx8Var.F().size() == 0 || lx8Var.M() == null || arrayList == null || !lx8Var.D().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (lx8Var.F().get(0) == null || lx8Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (lx8Var.y() == null || lx8Var.y().a() != lx8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final rn U(lx8 lx8Var, ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLLI;
        nx8 nx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048606, this, lx8Var, arrayList, i)) == null) {
            if (lx8Var.k() != null && !StringUtils.isNull(lx8Var.k().getName())) {
                if (!TextUtils.equals(lx8Var.k().getName(), this.a.P().X0()) || !this.a.P().d1()) {
                    if (!this.a.y0() && !ListUtils.isEmpty(lx8Var.o())) {
                        nx8Var = new nx8(lx8Var.o().get(0));
                    } else {
                        nx8Var = new nx8(lx8Var.k());
                    }
                    nx8Var.g = this.a.P().R1();
                    ListUtils.add(arrayList, i + 1, nx8Var);
                    return nx8Var;
                }
                return null;
            }
            return null;
        }
        return (rn) invokeLLI.objValue;
    }

    public final int G(lx8 lx8Var, ArrayList<rn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, lx8Var, arrayList, z)) == null) {
            if (lx8Var != null && !ListUtils.isEmpty(lx8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (lx8Var.F().get(0) == null || lx8Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (lx8Var == null || !lx8Var.v0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Y(lx8 lx8Var, ArrayList<rn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, lx8Var, arrayList, i) == null) {
            zx8 zx8Var = new zx8(zx8.g);
            ThreadData M = lx8Var.M();
            zx8Var.c = this.a.c6();
            zx8Var.b = lx8Var.g;
            zx8Var.d = lx8Var.h0();
            zx8Var.e = lx8Var.f;
            if (M != null && M.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            zx8Var.f = z;
            ListUtils.add(arrayList, i, zx8Var);
            if (lx8Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new yx8());
            }
        }
    }

    public final boolean H0(rr9 rr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, rr9Var)) == null) {
            if (this.a.P() != null && rr9Var != null && rr9Var.O() != null && rr9Var.O().equals(this.a.P().X1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.I = z;
            h09 h09Var = this.c;
            if (h09Var != null) {
                h09Var.setFromCDN(z);
            }
            en enVar = this.r;
            if (enVar != null && (enVar instanceof rf9)) {
                ((rf9) enVar).setIsFromCDN(z);
            }
            Iterator<cz8> it = this.z.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final rr9 r(ArrayList<rn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, arrayList)) == null) {
            Iterator<rn> it = arrayList.iterator();
            while (it.hasNext()) {
                rn next = it.next();
                if (next instanceof rr9) {
                    rr9 rr9Var = (rr9) next;
                    if (rr9Var.D() == 1) {
                        return rr9Var;
                    }
                }
            }
            return null;
        }
        return (rr9) invokeL.objValue;
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            c09 c09Var = this.m;
            if (c09Var != null) {
                c09Var.q0(z);
            }
            f19 f19Var = this.j;
            if (f19Var != null) {
                f19Var.A(z);
            }
            en enVar = this.u;
            if (enVar != null) {
                enVar.setMulDel(z);
            }
            en enVar2 = this.r;
            if (enVar2 != null) {
                enVar2.setMulDel(z);
            }
            h09 h09Var = this.c;
            if (h09Var != null) {
                h09Var.setMulDel(z);
            }
        }
    }

    public final void I0() {
        lx8 lx8Var;
        qr9 qr9Var;
        qr9 qr9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (lx8Var = this.F) == null || lx8Var.Z || lx8Var.a0 == 2) {
            return;
        }
        ArrayList<rr9> F = lx8Var.F();
        ArrayList<qr9> d2 = this.F.d();
        if (!xi8.e(F) && !xi8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<qr9> it = d2.iterator();
            while (it.hasNext()) {
                qr9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<qr9> it2 = d2.iterator();
            while (it2.hasNext()) {
                qr9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<qr9> it3 = d2.iterator();
            while (it3.hasNext()) {
                qr9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        kh9.j(next3, i);
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
                qr9 qr9Var3 = (qr9) sparseArray.valueAt(i2);
                if (qr9Var3 != null && (qr9Var2 = (qr9) hashMap.put(qr9Var3.s1(), qr9Var3)) != null) {
                    kh9.j(qr9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (qr9Var = (qr9) entry.getValue()) != null) {
                    sparseArray.put(qr9Var.getPosition(), qr9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                xi8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < xi8.i(arrayList); i5++) {
                qr9 qr9Var4 = (qr9) sparseArray.get(((Integer) xi8.d(arrayList, i5)).intValue());
                if (this.F.k() != null) {
                    qr9Var4.d1 = this.F.k().getId();
                }
                if (this.F.M() != null) {
                    qr9Var4.g1 = pg.g(this.F.M().getId(), 0L);
                }
                lx8 lx8Var2 = this.F;
                if (lx8Var2 != null && lx8Var2.y() != null) {
                    qr9Var4.h1 = this.F.y().a();
                }
                l(qr9Var4);
                int position = qr9Var4.getPosition() + this.F.Y;
                if (position >= xi8.i(F)) {
                    qr9Var4.j1 = position;
                    kh9.k(qr9Var4, 2, position, xi8.i(F));
                    return;
                }
                if (!this.L) {
                    position--;
                    qr9Var4.j1 = position;
                }
                if (position < 0) {
                    kh9.j(qr9Var4, 23);
                } else {
                    qr9Var4.k1 = i4;
                    xi8.b(F, qr9Var4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", qr9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final ArrayList<rn> J(List<rn> list, List<rn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, list, list2)) == null) {
            ArrayList<rn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            sx8 sx8Var = new sx8();
            PbListView d1 = this.a.K5().d1();
            if (d1 != null && d1.p()) {
                sx8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f71);
                sx8Var.b = true;
            } else {
                sx8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                sx8Var.b = false;
            }
            arrayList.add(sx8Var);
            uk6 uk6Var = new uk6();
            uk6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            uk6Var.needTopMargin = false;
            arrayList.add(uk6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final int w(lx8 lx8Var, ArrayList<rn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, lx8Var, arrayList)) == null) {
            if (!this.N && lx8Var != null && !ListUtils.isEmpty(lx8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.P() != null && this.a.P().h1()) {
                    return -1;
                }
                if (this.a.K5() != null && this.a.K5().V0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        rn rnVar = arrayList.get(i);
                        if (rnVar instanceof rr9) {
                            rr9 rr9Var = (rr9) rnVar;
                            if (rr9Var.D() == 1 && rr9Var.O == 0) {
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
                    if (lx8Var.v0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (lx8Var != null && lx8Var.v0() && this.L) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            h09 h09Var = this.c;
            if (h09Var != null && h09Var.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void j0() {
        rr9 rr9Var;
        h09 h09Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.F != null && (rr9Var = this.T) != null && rr9Var.W() != null && (h09Var = this.c) != null && h09Var.Q() != null) {
            String O = this.F.O();
            String l = this.F.l();
            if (this.F.M() != null) {
                i = this.F.M().getThreadType();
            } else {
                i = 0;
            }
            dn5.a().c(O, l, this.T.W(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && this.d0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.d0.remove(this.c);
            if (this.d == null) {
                this.d = new i09(this.a, rr9.R0);
            }
            if (!this.d0.contains(this.d)) {
                this.d0.add(this.d);
            }
            if (this.D == null) {
                O(this.a);
            }
            if (!this.d0.contains(this.D)) {
                this.d0.add(this.D);
            }
        }
    }

    public void M(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        i09 i09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, pbFragment, bdTypeListView) == null) {
            if (n19.D(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new i09(pbFragment, rr9.R0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                h09 h09Var = new h09(pbFragment, rr9.R0);
                this.c = h09Var;
                h09Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, ay8.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, nx8.j);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), ox8.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new z19(pbFragment, ix8.c);
            this.j = new f19(pbFragment, zx8.g);
            this.k = new t09(pbFragment, ux8.c);
            this.l = new f19(pbFragment, zx8.h);
            c09 c09Var = new c09(pbFragment, rr9.S0);
            this.m = c09Var;
            c09Var.s0(pbFragment);
            i19 i19Var = new i19(pbFragment, rr9.T0);
            this.n = i19Var;
            i19Var.v0(pbFragment);
            this.q = wf9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.r = wf9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.s = nn7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.t = nn7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.u = nn7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.x = new a19(pbFragment, wx8.f1);
            this.v = new b19(pbFragment, z09.e1);
            this.w = new d19(pbFragment, p05.k1);
            this.y = new PbReplyLoadMoreAdapter(pbFragment, rr9.Z0);
            this.o = new s49(pbFragment, t49.a);
            this.p = new rk6(pbFragment.getPageContext());
            this.A = new a09(pbFragment, az4.e);
            this.B = new p09(pbFragment, pbFragment.getUniqueId());
            this.C = new b29(pbFragment.getPageContext(), j26.g);
            if (n19.D(pbFragment)) {
                O(pbFragment);
            }
            dz8 dz8Var = new dz8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.E = dz8Var;
            this.d0.addAll(dz8Var.a());
            if (n19.D(pbFragment) && (i09Var = this.d) != null) {
                this.d0.add(i09Var);
            } else {
                h09 h09Var2 = this.c;
                if (h09Var2 != null) {
                    this.d0.add(h09Var2);
                }
            }
            this.d0.add(this.e);
            this.d0.add(this.f);
            this.d0.add(this.g);
            this.d0.add(this.h);
            this.d0.add(this.i);
            this.d0.add(this.m);
            this.d0.add(this.n);
            this.d0.add(this.j);
            this.d0.add(this.k);
            this.d0.add(this.l);
            this.d0.add(this.q);
            this.d0.add(this.r);
            this.d0.add(this.s);
            this.d0.add(this.t);
            this.d0.add(this.u);
            this.d0.add(this.x);
            this.d0.add(this.v);
            this.d0.add(this.w);
            this.d0.add(this.o);
            this.d0.add(this.y);
            this.d0.add(this.p);
            this.d0.add(this.A);
            this.d0.add(this.B);
            this.d0.add(new PbPrivateTitleAdapter(pbFragment));
            this.d0.add(this.C);
            if (n19.D(pbFragment)) {
                this.d0.add(this.D);
            }
            this.m0.setPriority(1);
            this.m0.setSelfListener(true);
            pbFragment.registerListener(this.m0);
            pbFragment.registerListener(this.l0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new gr9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.d0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:227:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:251:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0(lx8 lx8Var, boolean z) {
        rr9 rr9Var;
        boolean z2;
        boolean z3;
        rr9 rr9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        q09 q09Var;
        List<rn> list;
        int i4;
        h09 h09Var;
        boolean z9;
        boolean z10;
        boolean z11;
        rn rnVar;
        int i5;
        boolean z12;
        rr9 rr9Var3;
        rr9 rr9Var4;
        rr9 rr9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048624, this, lx8Var, z) != null) || lx8Var == null) {
            return;
        }
        this.F = lx8Var;
        q(lx8Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            I0();
        }
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        this.G.clear();
        lx8 lx8Var2 = this.F;
        if (lx8Var2 != null && lx8Var2.F() != null && this.F.F().size() > 0) {
            this.G.addAll(this.F.F());
        }
        if (lx8Var.M() != null && lx8Var.M().getAuthor() != null) {
            this.S = lx8Var.M().getAuthor().getUserId();
        }
        if (this.c == null && !n19.D(this.a)) {
            return;
        }
        N(lx8Var);
        ArrayList<rn> arrayList = new ArrayList<>(lx8Var.F());
        rr9 r = r(arrayList);
        if (this.F.M().isQuestionThread()) {
            rr9Var = s(lx8Var);
        } else {
            rr9Var = null;
        }
        if (rr9Var != null) {
            arrayList.remove(rr9Var);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!tn7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.F.r0()) {
            L(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.T = r;
        }
        if (!this.L && r != null) {
            arrayList.remove(r);
            if (lx8Var.v0() && r.a0() != null) {
                r.d1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && lx8Var.i() != null) {
            rr9 i6 = lx8Var.i();
            if (!this.L && lx8Var.v0() && i6.a0() != null) {
                i6.d1(null);
            }
            if (!this.L && (rr9Var5 = this.T) != null && i6.i0 == null) {
                lx8Var.E0(rr9Var5);
                rr9Var2 = rr9Var5;
            } else {
                rr9Var2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            rr9Var2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.A5()) {
            if (lx8Var.F().size() > 0 && (rr9Var4 = lx8Var.F().get(0)) != null && rr9Var4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int E = E(this.F, arrayList, this.L);
            if (E >= 0) {
                ListUtils.add(arrayList, E, this.F.C());
            }
        }
        int F = F(this.F, arrayList, this.L);
        if (F >= 0) {
            ListUtils.add(arrayList, F, this.F.D());
        }
        qq9.f(arrayList, 1);
        int C = C(lx8Var, arrayList);
        if (C >= 0) {
            Y(lx8Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(lx8Var, arrayList);
        if (H >= 0) {
            ux8 ux8Var = new ux8(ux8.c);
            ux8Var.b(true);
            ListUtils.add(arrayList, H, ux8Var);
        }
        int w = w(lx8Var, arrayList);
        List<rn> x = x(lx8Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            rn rnVar2 = (rn) ListUtils.getItem(arrayList, w);
            if (rnVar2 instanceof rr9) {
                ((rr9) rnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(lx8Var, arrayList, this.L);
        } else {
            i = -1;
        }
        if (i >= 0 && lx8Var.Q() != null) {
            rr9 V = lx8Var.V();
            ThreadData c2 = lx8Var.Q().c();
            if (V != null && V.q0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure q0 = V.q0();
                VirtualImageCustomState r0 = V.r0();
                c2.setCustomFigure(q0);
                c2.setCustomState(r0);
            }
            ListUtils.add(arrayList, i, lx8Var.Q());
            z6 = true;
            z7 = true;
        } else {
            if (rr9Var2 != null) {
                rr9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.F.M().isQuestionThread() && rr9Var != null) || (this.F.M().isQuestionThread() && this.U != null)) {
            if (rr9Var == null && (rr9Var3 = this.U) != null) {
                rr9Var = rr9Var3;
            }
            if (!arrayList.contains(rr9Var)) {
                i++;
                a0(rr9Var, arrayList, i);
            }
        }
        if (W(lx8Var, rr9Var2, arrayList, i) != null || V(lx8Var, rr9Var2, arrayList, i) != null || U(lx8Var, arrayList, i) != null) {
            i++;
        }
        if (R(lx8Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            rn Z = Z(arrayList, i);
            if (Z != null) {
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
                rnVar = P(arrayList, i5);
                if (rnVar != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = z10;
                rnVar = Z;
                i5 = -1;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12 && this.F.r0()) {
                this.i0 = i5;
                if (S(arrayList, i5) != null) {
                    this.i0 = -1;
                    i++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                z8 = z11;
                i2 = i;
                q09Var = null;
            } else {
                q09 X = X(arrayList, rnVar, i, i5);
                if (X != null) {
                    if (!z11) {
                        q09Var = X;
                        i2 = i;
                        z8 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                q09Var = X;
                z8 = z11;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z8 = false;
            i3 = -1;
            q09Var = null;
        }
        if (z2) {
            if (q09Var != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            list = x;
            int i7 = i2;
            i4 = w;
            boolean Q = Q(lx8Var, arrayList, z8, z9, i3, i7, w, C);
            if (q09Var != null) {
                q09Var.n = Q;
            }
        } else {
            list = x;
            i4 = w;
        }
        if (n19.D(this.a)) {
            px8 px8Var = new px8();
            if (lx8Var.M().getTaskInfoData() != null) {
                px8Var.f(lx8Var.M().getTaskInfoData().r());
                px8Var.e(lx8Var.M().getTaskInfoData().q());
            }
            xi8.b(arrayList, px8Var, 0);
            if (!z7 && lx8Var.Q() != null) {
                rr9 V2 = lx8Var.V();
                ThreadData c3 = lx8Var.Q().c();
                if (V2 != null && V2.q0() != null && c3 != null && c3.getCustomFigure() == null) {
                    VirtualImageCustomFigure q02 = V2.q0();
                    VirtualImageCustomState r02 = V2.r0();
                    c3.setCustomFigure(q02);
                    c3.setCustomState(r02);
                }
                ListUtils.add(arrayList, 1, lx8Var.Q());
                z6 = true;
                z7 = true;
                h09Var = this.c;
                if (h09Var != null) {
                    h09Var.e0(!z6);
                }
                boolean H0 = H0(rr9Var2);
                if (this.M && !H0) {
                    arrayList.remove(rr9Var2);
                    this.M = false;
                }
                if (lx8Var.Q() != null) {
                    lx8Var.Q().h(!z7);
                }
                if (this.b != null) {
                    this.H = arrayList;
                    List<rn> P = lx8Var.P();
                    if (!ListUtils.isEmpty(P)) {
                        this.b.setData(J(arrayList, P));
                    } else {
                        this.b.setData(this.H);
                    }
                }
                i0(H0, z, i4, list);
                if (!t(rr9Var2, arrayList, z4)) {
                    List<rn> P2 = lx8Var.P();
                    if (!ListUtils.isEmpty(P2)) {
                        this.b.setData(J(arrayList, P2));
                        return;
                    } else {
                        this.b.setData(arrayList);
                        return;
                    }
                }
                return;
            }
        }
        h09Var = this.c;
        if (h09Var != null) {
        }
        boolean H02 = H0(rr9Var2);
        if (this.M) {
            arrayList.remove(rr9Var2);
            this.M = false;
        }
        if (lx8Var.Q() != null) {
        }
        if (this.b != null) {
        }
        i0(H02, z, i4, list);
        if (!t(rr9Var2, arrayList, z4)) {
        }
    }

    public final void N(@NonNull lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, lx8Var) == null) {
            h09 h09Var = this.c;
            if (h09Var != null) {
                h09Var.r(lx8Var);
                this.c.setFromCDN(this.I);
                this.c.l(this.R);
                this.c.c(this.K);
                this.c.e(this.W);
                this.c.k(this.V);
                this.c.n(this.Y);
                this.c.d(this.b0);
                this.c.d0(this.Z);
                this.c.f0(this.a0);
            }
            this.g.y(this.Z);
            this.m.r(lx8Var);
            this.m.setFromCDN(this.I);
            this.m.o(this.S);
            this.m.c(this.K);
            this.m.e(this.W);
            this.m.k(this.V);
            this.m.n(this.Y);
            this.m.d(this.b0);
            this.m.r0(this.a0);
            this.n.r(lx8Var);
            this.n.setFromCDN(this.I);
            this.n.o(this.S);
            this.n.c(this.K);
            this.n.e(this.W);
            this.n.k(this.V);
            this.n.n(this.Y);
            this.n.d(this.b0);
            this.n.u0(this.a0);
            this.e.J(this.W);
            this.y.y(this.W);
            this.o.y(this.o0);
            en enVar = this.r;
            if (enVar != null && (enVar instanceof rf9)) {
                ((rf9) enVar).setIsFromCDN(this.I);
            }
            Iterator<cz8> it = this.z.iterator();
            while (it.hasNext()) {
                cz8 next = it.next();
                if (next != null) {
                    next.r(lx8Var);
                    next.setFromCDN(this.I);
                    next.o(this.S);
                    next.l(this.R);
                    next.c(this.K);
                    next.f(this.L);
                    next.q(this.Q);
                    next.e(this.W);
                    next.k(this.V);
                    next.n(this.Y);
                    next.d(this.b0);
                }
            }
            this.j.e(this.W);
            this.j.B(this.c0);
            this.k.e(this.X);
            this.l.e(this.W);
            this.j.r(lx8Var);
            this.i.r(lx8Var);
            this.l.r(lx8Var);
            this.v.r(lx8Var);
            this.w.r(lx8Var);
            this.A.A(lx8Var);
            this.A.z(this.a.r1);
            this.B.y(lx8Var);
        }
    }

    public final rn P(ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, arrayList, i)) == null) {
            if (this.F == null) {
                return null;
            }
            qr9 R0 = this.a.P().R0();
            if (R0 == null) {
                R0 = this.F.z();
            }
            if (R0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert v1 = R0.v1();
            if (v1 != null) {
                v1.setAdvertAppInfo(R0.getAdvertAppInfo());
            }
            int i2 = R0.getAdvertAppInfo().i();
            if (i2 != 0) {
                kh9.j(R0, i2);
                if (i2 != 28 && i2 != 31) {
                    R0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.F.k() != null) {
                R0.d1 = this.F.k().getId();
            }
            if (this.F.M() != null) {
                R0.g1 = pg.g(this.F.M().getId(), 0L);
            }
            lx8 lx8Var = this.F;
            if (lx8Var != null && lx8Var.y() != null) {
                R0.h1 = this.F.y().a();
            }
            l(R0);
            if (i < 0) {
                return null;
            }
            R0.k1 = 1;
            l16.k().q(true);
            xi8.b(arrayList, R0, i);
            if (e26.i().q()) {
                e26.i().n(arrayList, i + 1, 4);
            }
            return R0;
        }
        return (rn) invokeLI.objValue;
    }

    public final rn S(ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLI;
        lx8 lx8Var;
        pr9 pr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, arrayList, i)) == null) {
            if (n19.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (lx8Var = this.F) != null && lx8Var.r0()) {
                String d2 = sn7.e().d("pb_banner");
                if (this.j0 == null && mn7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.j0 = threadData;
                    threadData.funAdData = new pr9();
                    lx8 lx8Var2 = this.F;
                    if (lx8Var2 != null) {
                        this.j0.funAdData.m(lx8Var2.l());
                        this.j0.funAdData.r(this.F.O());
                    }
                }
                ThreadData threadData2 = this.j0;
                if (threadData2 != null && (pr9Var = threadData2.funAdData) != null) {
                    pr9Var.j(1);
                    l16.k().q(true);
                    ListUtils.add(arrayList, i, this.j0);
                    if (e26.i().q()) {
                        e26.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.j0;
        }
        return (rn) invokeLI.objValue;
    }

    public final boolean Q(lx8 lx8Var, ArrayList<rn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{lx8Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(lx8Var.e()) && lx8Var.e().size() > 2) {
                int min = Math.min(lx8Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    az4 az4Var = lx8Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        az4Var.i(true);
                    }
                    if (az4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            az4Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        az4Var.l(true);
                    } else if (i6 == min - 1) {
                        az4Var.k(true);
                    }
                    arrayList2.add(az4Var);
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

    public final rn R(lx8 lx8Var, ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLLI;
        ix8 ix8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048603, this, lx8Var, arrayList, i)) == null) {
            if (i >= 0 && lx8Var != null && lx8Var.k && (ix8Var = lx8Var.l) != null) {
                ListUtils.add(arrayList, i, ix8Var);
                return ix8Var;
            }
            return null;
        }
        return (rn) invokeLLI.objValue;
    }

    public final void a0(rr9 rr9Var, ArrayList<rn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048612, this, rr9Var, arrayList, i) == null) {
            rr9Var.j1(true);
            arrayList.add(i, rr9Var);
        }
    }

    public final void T(int i, int i2, int i3, ArrayList<rn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<rn> listIterator = arrayList.listIterator();
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
                    if (i5 < this.k0.size()) {
                        listIterator.add(this.k0.get(i5));
                    } else {
                        rr9 rr9Var = new rr9();
                        pr9 pr9Var = new pr9();
                        lx8 lx8Var = this.F;
                        if (lx8Var == null) {
                            str3 = "";
                        } else {
                            str3 = lx8Var.l();
                        }
                        pr9Var.m(str3);
                        lx8 lx8Var2 = this.F;
                        if (lx8Var2 != null) {
                            str = lx8Var2.O();
                        }
                        pr9Var.r(str);
                        pr9Var.n(true);
                        rr9Var.w0 = pr9Var;
                        pr9Var.j(i7);
                        listIterator.add(rr9Var);
                        i7++;
                        this.k0.add(rr9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && e26.i().q()) {
                e26.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                rr9 rr9Var2 = new rr9();
                pr9 pr9Var2 = new pr9();
                lx8 lx8Var3 = this.F;
                if (lx8Var3 == null) {
                    str2 = "";
                } else {
                    str2 = lx8Var3.l();
                }
                pr9Var2.m(str2);
                lx8 lx8Var4 = this.F;
                if (lx8Var4 != null) {
                    str = lx8Var4.O();
                }
                pr9Var2.r(str);
                pr9Var2.n(true);
                rr9Var2.w0 = pr9Var2;
                pr9Var2.j(1);
                listIterator.add(rr9Var2);
                this.k0.add(rr9Var2);
                if (e26.i().q()) {
                    e26.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final rn V(lx8 lx8Var, rr9 rr9Var, ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048607, this, lx8Var, rr9Var, arrayList, i)) == null) {
            ox8 ox8Var = null;
            if (lx8Var.k() != null && !StringUtils.isNull(lx8Var.k().getName()) && TextUtils.equals(lx8Var.k().getName(), this.a.P().X0()) && this.a.P().d1()) {
                return null;
            }
            if (rr9Var != null) {
                if (rr9Var.r0 != null) {
                    ox8Var = new ox8(rr9Var.r0);
                }
            } else {
                rr9 rr9Var2 = this.T;
                if (rr9Var2 != null && rr9Var2.r0 != null) {
                    ox8Var = new ox8(this.T.r0);
                }
            }
            if (ox8Var != null) {
                ox8Var.b = this.a.P().R1();
                ListUtils.add(arrayList, i + 1, ox8Var);
            }
            return ox8Var;
        }
        return (rn) invokeLLLI.objValue;
    }

    public final rn W(lx8 lx8Var, rr9 rr9Var, ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048608, this, lx8Var, rr9Var, arrayList, i)) == null) {
            if (rr9Var != null && rr9Var.X() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(rr9Var.X());
            } else {
                rr9 rr9Var2 = this.T;
                if (rr9Var2 != null && rr9Var2.X() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.T.X());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (lx8Var != null && !TextUtils.isEmpty(lx8Var.O())) {
                    pbFirstFloorRecommendData.f(lx8Var.O());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (rn) invokeLLLI.objValue;
    }

    public final void i0(boolean z, boolean z2, int i, List<rn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.O || this.N) && i != -1 && !ListUtils.isEmpty(list) && !this.P) {
                this.f0 = new e(this, list);
                sg.a().post(this.f0);
            }
        }
    }

    public final q09 X(ArrayList<rn> arrayList, rn rnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048609, this, arrayList, rnVar, i, i2)) == null) {
            q09 B = this.F.B();
            if (B != null) {
                if (rnVar != null) {
                    if (i2 < 0 && rnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (rnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof q09)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (q09) invokeLLII.objValue;
    }

    public final rn Z(ArrayList<rn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048611, this, arrayList, i)) == null) {
            if (i < 0 || (P = this.a.P()) == null || TextUtils.isEmpty(P.C1())) {
                return null;
            }
            qr9 qr9Var = new qr9();
            l(qr9Var);
            ListUtils.add(arrayList, i + 1, qr9Var);
            return qr9Var;
        }
        return (rn) invokeLI.objValue;
    }

    public void f0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.K5() != null) {
            this.a.K5().a2(z, i);
        }
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        h09 h09Var = this.c;
                        if (h09Var != null) {
                            h09Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.D;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        en enVar = this.r;
                        if (enVar instanceof mf9) {
                            ((mf9) enVar).onDestroy();
                        }
                        en enVar2 = this.s;
                        if (enVar2 instanceof mf9) {
                            ((mf9) enVar2).onDestroy();
                        }
                        en enVar3 = this.u;
                        if (enVar3 instanceof mf9) {
                            ((mf9) enVar3).onDestroy();
                        }
                        d09.a().d();
                        return;
                    }
                    return;
                }
                h09 h09Var2 = this.c;
                if (h09Var2 != null) {
                    h09Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.D;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                en enVar4 = this.r;
                if (enVar4 instanceof mf9) {
                    ((mf9) enVar4).onResume();
                }
                en enVar5 = this.s;
                if (enVar5 instanceof mf9) {
                    ((mf9) enVar5).onResume();
                }
                en enVar6 = this.u;
                if (enVar6 instanceof mf9) {
                    ((mf9) enVar6).onResume();
                }
                k0(false);
                j0();
                return;
            }
            h09 h09Var3 = this.c;
            if (h09Var3 != null) {
                h09Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.D;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            en enVar7 = this.r;
            if (enVar7 instanceof mf9) {
                ((mf9) enVar7).onPause();
            }
            en enVar8 = this.s;
            if (enVar8 instanceof mf9) {
                ((mf9) enVar8).onPause();
            }
            en enVar9 = this.u;
            if (enVar9 instanceof mf9) {
                ((mf9) enVar9).onPause();
            }
            d09.a().i(this.a.R());
            dn5.a().d();
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && this.a.K5() != null && this.a.R() != null && this.a.R().K1() != null) {
            d09.a().f(this.a.R().K1().l2(), this.j.x(), this.a.K5().f1(), this.a.R().getPageStayDurationItem(), z, this.E.b(), this.a.getListView());
        }
    }

    public final void o(List<rn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof rr9) {
                    if (i == 0 && (list.get(i2) instanceof qr9)) {
                        i = i2 + 1;
                    }
                    rr9 rr9Var = (rr9) list.get(i2);
                    if (!TextUtils.isEmpty(rr9Var.U())) {
                        a05 a05Var = new a05();
                        a05Var.e(rr9Var.U());
                        list.set(i2, a05Var);
                    }
                }
            }
            if (i > 0 && e26.i().q()) {
                e26.i().n(list, i, 5);
            }
        }
    }

    public void q(lx8 lx8Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, lx8Var) == null) && lx8Var.M() != null && lx8Var.M().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(lx8Var.M().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.D == null && this.b != null) {
                n19.H(this.a, lx8Var.M().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.d0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.D;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.t() != 1 && (pbFragment = this.a) != null && pbFragment.K5() != null) {
                this.a.K5().e4();
            }
        }
    }

    public final void l(qr9 qr9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, qr9Var) == null) && qr9Var != null && this.F != null && qr9Var.getAdvertAppInfo() != null) {
            qr9Var.getAdvertAppInfo().i = new oy4();
            if (this.F.y() != null) {
                qr9Var.getAdvertAppInfo().i.b = this.F.y().a();
            }
            qr9Var.getAdvertAppInfo().i.a = qr9Var.u1();
            if (this.F.k() != null && (k = this.F.k()) != null) {
                qr9Var.getAdvertAppInfo().i.c = k.getId();
                qr9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                qr9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qr9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qr9Var.getAdvertAppInfo().i.g = qr9Var.getAdvertAppInfo().g;
            qr9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<rn> x(lx8 lx8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, lx8Var)) == null) {
            if (lx8Var == null || lx8Var.R() == null || ListUtils.isEmpty(lx8Var.R().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<rr9> list = lx8Var.R().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                rr9 rr9Var = list.get(i);
                if (rr9Var != null) {
                    rr9Var.c0 = true;
                    rr9Var.P = true;
                    arrayList.add(rr9Var);
                }
            }
            if (ListUtils.getCount(lx8Var.R().b) > 2) {
                rn rnVar = (rn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (rnVar instanceof rr9) {
                    ((rr9) rnVar).P = false;
                }
                arrayList.add(new t49());
            } else {
                rn rnVar2 = (rn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (rnVar2 instanceof rr9) {
                    ((rr9) rnVar2).P = true;
                }
            }
            arrayList.add(0, new zx8(zx8.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.q0 = new ArrayList();
            ArrayList<BdUniqueId> g = qq9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                pi8 b2 = uj8.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.d0.add(b2);
                    this.q0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.q0)) {
                this.b.addAdapters(this.q0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean t(rr9 rr9Var, ArrayList<rn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048639, this, rr9Var, arrayList, z)) == null) {
            if (rr9Var == null) {
                rr9 rr9Var2 = this.T;
                if (rr9Var2 != null && !this.N) {
                    ListUtils.add(arrayList, 0, rr9Var2);
                } else {
                    rr9 rr9Var3 = new rr9();
                    rr9Var3.L0(1);
                    ListUtils.add(arrayList, 0, rr9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, rr9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
