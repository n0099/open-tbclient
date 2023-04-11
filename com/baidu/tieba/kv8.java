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
/* loaded from: classes5.dex */
public class kv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zv8 A;
    public kx8 B;
    public qu8 C;
    public zs8 D;
    public ArrayList<sl9> E;
    public ArrayList<hn> F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public String Q;
    public sl9 R;
    public sl9 S;
    public View.OnClickListener T;
    public View.OnClickListener U;
    public View.OnClickListener V;
    public TbRichTextView.a0 W;
    public View.OnClickListener X;
    public cu8 Y;
    public View.OnLongClickListener Z;
    public PbFragment a;
    public SortSwitchButton.f a0;
    public BdTypeListView b;
    public final List<um> b0;
    public sv8 c;
    public final List<um> c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public Runnable d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public PbFirstFloorRecommendAdapter g;
    public int g0;
    public ix8 h;
    public ThreadData h0;
    public pw8 i;
    public List<sl9> i0;
    public dw8 j;
    public final CustomMessageListener j0;
    public pw8 k;
    public CustomMessageListener k0;
    public nv8 l;
    public final CustomMessageListener l0;
    public sw8 m;
    public final View.OnClickListener m0;
    public vz8 n;
    public CustomMessageListener n0;
    public th6 o;
    public List<um> o0;
    public um p;
    public um q;
    public um r;
    public um s;
    public um t;
    public lw8 u;
    public nw8 v;
    public kw8 w;
    public PbReplyLoadMoreAdapter x;
    public ArrayList<pu8> y;
    public lv8 z;

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        /* loaded from: classes5.dex */
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
                    this.a.a.a0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kv8 kv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var, Integer.valueOf(i)};
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
            this.a = kv8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.D != null && !g9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    jg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kv8 kv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var, Integer.valueOf(i)};
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
            this.a = kv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ql9)) {
                ql9 ql9Var = (ql9) customResponsedMessage.getData();
                if (this.a.h0 != null && this.a.h0.funAdData == ql9Var) {
                    this.a.h0.funAdData.p(true);
                    this.a.b.setData(this.a.F);
                    this.a.a0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kv8 kv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var, Integer.valueOf(i)};
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
            this.a = kv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof hl9)) {
                AbsDelegateAdapterList a = ((hl9) customResponsedMessage.getData()).a();
                Iterator<um<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    um<?, ?> next = it.next();
                    if (next instanceof pv8) {
                        ((pv8) next).t(this.a.a);
                        if (next instanceof pu8) {
                            this.a.y.add((pu8) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.c0.clear();
                this.a.c0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        public d(kv8 kv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.D != null && this.a.D.R() != null) {
                this.a.a.G5().Y0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ kv8 b;

        public e(kv8 kv8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kv8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.f0);
                this.b.N = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(kv8 kv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var, Integer.valueOf(i)};
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
            this.a = kv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.o0)) {
                this.a.n();
                kv8 kv8Var = this.a;
                kv8Var.i0(kv8Var.D, false);
            }
        }
    }

    public kv8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.y = new ArrayList<>();
        this.E = new ArrayList<>();
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = false;
        this.O = false;
        this.P = 0;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = new ArrayList();
        this.c0 = new ArrayList();
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = -1;
        this.i0 = new ArrayList();
        this.j0 = new a(this, 2921523);
        this.k0 = new b(this, 2004015);
        this.l0 = new c(this, 2001118);
        this.m0 = new d(this);
        this.n0 = new f(this, 2016470);
        this.P = ii.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.l0);
        this.f0 = ii.j(this.a.getContext()) / 3;
    }

    public void A0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public void B0(cu8 cu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cu8Var) == null) {
            this.Y = cu8Var;
        }
    }

    public void e0(boolean z) {
        sv8 sv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (sv8Var = this.c) != null) {
            sv8Var.V(z);
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.H = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.K = z;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.I = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.O = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.L = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.M = z;
        }
    }

    public final sl9 q(zs8 zs8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, zs8Var)) == null) {
            if (zs8Var != null && zs8Var.S() != null) {
                sl9 S = zs8Var.S();
                this.S = S;
                return S;
            }
            return null;
        }
        return (sl9) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.J = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.N = z;
        }
    }

    public void s0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }

    public void t0(boolean z) {
        nv8 nv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (nv8Var = this.l) != null) {
            nv8Var.w0(z);
        }
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public void w0(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, a0Var) == null) {
            this.W = a0Var;
        }
    }

    public hn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i)) == null) {
            return this.b.F(i);
        }
        return (hn) invokeI.objValue;
    }

    public void x0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, onLongClickListener) == null) {
            this.Z = onLongClickListener;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i)) == null) {
            if (this.b.F(i) != null) {
                return this.b.F(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, fVar) == null) {
            this.a0 = fVar;
        }
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, onClickListener) == null) {
            this.U = onClickListener;
        }
    }

    public final int A(zs8 zs8Var, ArrayList<hn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zs8Var, arrayList)) == null) {
            if (zs8Var == null || ListUtils.isEmpty(zs8Var.F()) || ListUtils.isEmpty(arrayList) || ((sl9) ListUtils.getItem(zs8Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    hn hnVar = arrayList.get(i);
                    if (hnVar instanceof sl9) {
                        sl9 sl9Var = (sl9) hnVar;
                        if (sl9Var.E() == 1 && sl9Var.O == 0) {
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

    public final int F(zs8 zs8Var, ArrayList<hn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, zs8Var, arrayList)) == null) {
            int i = -1;
            if (zs8Var == null || zs8Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (zs8Var.y().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.H) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof mt8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (zs8Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<hn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = l75.i();
        int j = l75.j() - 1;
        if (bool.booleanValue()) {
            hn hnVar = arrayList.get(0);
            if ((hnVar instanceof sl9) && ((sl9) hnVar).E() == 1) {
                j++;
            }
        }
        int k = l75.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.P() != null && this.a.P().E1() == 3) {
            this.i0.clear();
        }
        Q(j, i, k, arrayList);
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    hn hnVar = this.b.getData().get(i);
                    if (hnVar != null && hnVar.getType() == mt8.g) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            jg.a().removeCallbacks(this.d0);
            pw8 pw8Var = this.i;
            if (pw8Var != null) {
                pw8Var.onDestroy();
            }
            pw8 pw8Var2 = this.k;
            if (pw8Var2 != null) {
                pw8Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            ix8 ix8Var = this.h;
            if (ix8Var != null) {
                ix8Var.onDestroy();
            }
            yy5.k().q(false);
        }
    }

    public int C(zs8 zs8Var, ArrayList<hn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, zs8Var, arrayList, z)) == null) {
            if (zs8Var == null || zs8Var.F() == null || zs8Var.C() == null || zs8Var.F().size() == 0 || zs8Var.M() == null || arrayList == null || !zs8Var.C().q1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (zs8Var.F().get(0) == null || zs8Var.F().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (zs8Var.y() == null || zs8Var.y().a() != zs8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(zs8 zs8Var, ArrayList<hn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, zs8Var, arrayList, z)) == null) {
            if (zs8Var == null || zs8Var.F() == null || zs8Var.D() == null || zs8Var.F().size() == 0 || zs8Var.M() == null || arrayList == null || !zs8Var.D().q1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (zs8Var.F().get(0) == null || zs8Var.F().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (zs8Var.y() == null || zs8Var.y().a() != zs8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final hn R(zs8 zs8Var, ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLLI;
        bt8 bt8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, zs8Var, arrayList, i)) == null) {
            if (zs8Var.k() != null && !StringUtils.isNull(zs8Var.k().getName())) {
                if (!TextUtils.equals(zs8Var.k().getName(), this.a.P().T0()) || !this.a.P().Z0()) {
                    if (!this.a.y0() && !ListUtils.isEmpty(zs8Var.o())) {
                        bt8Var = new bt8(zs8Var.o().get(0));
                    } else {
                        bt8Var = new bt8(zs8Var.k());
                    }
                    bt8Var.g = this.a.P().N1();
                    ListUtils.add(arrayList, i + 1, bt8Var);
                    return bt8Var;
                }
                return null;
            }
            return null;
        }
        return (hn) invokeLLI.objValue;
    }

    public void C0() {
        dw8 dw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (dw8Var = this.j) != null) {
            dw8Var.z(2);
        }
    }

    public void F0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (i = this.g0) > 0 && P(this.F, i) != null) {
            this.g0 = -1;
            this.b.setData(this.F);
            a0();
        }
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e0;
        }
        return invokeV.intValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.e0 = B();
            if (this.b.getAdapter2() instanceof ym) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.n0);
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.C.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<hn> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.F;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.d;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean D0(sl9 sl9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sl9Var)) == null) {
            if (this.a.P() != null && sl9Var != null && sl9Var.O() != null && sl9Var.O().equals(this.a.P().T1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.G = z;
            this.c.setFromCDN(z);
            um umVar = this.q;
            if (umVar != null && (umVar instanceof ra9)) {
                ((ra9) umVar).setIsFromCDN(z);
            }
            Iterator<pu8> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final sl9 p(ArrayList<hn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, arrayList)) == null) {
            Iterator<hn> it = arrayList.iterator();
            while (it.hasNext()) {
                hn next = it.next();
                if (next instanceof sl9) {
                    sl9 sl9Var = (sl9) next;
                    if (sl9Var.E() == 1) {
                        return sl9Var;
                    }
                }
            }
            return null;
        }
        return (sl9) invokeL.objValue;
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            nv8 nv8Var = this.l;
            if (nv8Var != null) {
                nv8Var.x0(z);
            }
            pw8 pw8Var = this.i;
            if (pw8Var != null) {
                pw8Var.A(z);
            }
            um umVar = this.t;
            if (umVar != null) {
                umVar.setMulDel(z);
            }
            um umVar2 = this.q;
            if (umVar2 != null) {
                umVar2.setMulDel(z);
            }
            sv8 sv8Var = this.c;
            if (sv8Var != null) {
                sv8Var.setMulDel(z);
            }
        }
    }

    public final int E(zs8 zs8Var, ArrayList<hn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, zs8Var, arrayList, z)) == null) {
            if (zs8Var != null && !ListUtils.isEmpty(zs8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (zs8Var.F().get(0) == null || zs8Var.F().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (zs8Var == null || !zs8Var.v0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void V(zs8 zs8Var, ArrayList<hn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, zs8Var, arrayList, i) == null) {
            mt8 mt8Var = new mt8(mt8.g);
            ThreadData M = zs8Var.M();
            mt8Var.c = this.a.Y5();
            mt8Var.b = zs8Var.g;
            mt8Var.d = zs8Var.h0();
            mt8Var.e = zs8Var.f;
            if (M != null && M.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            mt8Var.f = z;
            ListUtils.add(arrayList, i, mt8Var);
            if (zs8Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new lt8());
            }
        }
    }

    public final void E0() {
        zs8 zs8Var;
        rl9 rl9Var;
        rl9 rl9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (zs8Var = this.D) == null || zs8Var.Z || zs8Var.a0 == 2) {
            return;
        }
        ArrayList<sl9> F = zs8Var.F();
        ArrayList<rl9> d2 = this.D.d();
        if (!me8.e(F) && !me8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<rl9> it = d2.iterator();
            while (it.hasNext()) {
                rl9 next = it.next();
                if (next != null && next.r1() != null) {
                    sb.append(next.r1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<rl9> it2 = d2.iterator();
            while (it2.hasNext()) {
                rl9 next2 = it2.next();
                if (next2 != null) {
                    next2.i1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<rl9> it3 = d2.iterator();
            while (it3.hasNext()) {
                rl9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        jc9.j(next3, i);
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
                rl9 rl9Var3 = (rl9) sparseArray.valueAt(i2);
                if (rl9Var3 != null && (rl9Var2 = (rl9) hashMap.put(rl9Var3.q1(), rl9Var3)) != null) {
                    jc9.j(rl9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (rl9Var = (rl9) entry.getValue()) != null) {
                    sparseArray.put(rl9Var.getPosition(), rl9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                me8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < me8.i(arrayList); i5++) {
                rl9 rl9Var4 = (rl9) sparseArray.get(((Integer) me8.d(arrayList, i5)).intValue());
                if (this.D.k() != null) {
                    rl9Var4.c1 = this.D.k().getId();
                }
                if (this.D.M() != null) {
                    rl9Var4.f1 = gg.g(this.D.M().getId(), 0L);
                }
                zs8 zs8Var2 = this.D;
                if (zs8Var2 != null && zs8Var2.y() != null) {
                    rl9Var4.g1 = this.D.y().a();
                }
                l(rl9Var4);
                int position = rl9Var4.getPosition() + this.D.Y;
                if (position >= me8.i(F)) {
                    rl9Var4.i1 = position;
                    jc9.k(rl9Var4, 2, position, me8.i(F));
                    return;
                }
                if (!this.J) {
                    position--;
                    rl9Var4.i1 = position;
                }
                if (position < 0) {
                    jc9.j(rl9Var4, 23);
                } else {
                    rl9Var4.j1 = i4;
                    me8.b(F, rl9Var4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", rl9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final ArrayList<hn> H(List<hn> list, List<hn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList<hn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            ft8 ft8Var = new ft8();
            PbListView c1 = this.a.G5().c1();
            if (c1 != null && c1.p()) {
                ft8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ec3);
                ft8Var.b = true;
            } else {
                ft8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                ft8Var.b = false;
            }
            arrayList.add(ft8Var);
            wh6 wh6Var = new wh6();
            wh6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            wh6Var.needTopMargin = false;
            arrayList.add(wh6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final hn P(ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLI;
        zs8 zs8Var;
        ql9 ql9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (zs8Var = this.D) != null && zs8Var.r0()) {
                String d2 = jk7.e().d("pb_banner");
                if (this.h0 == null && dk7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.h0 = threadData;
                    threadData.funAdData = new ql9();
                    zs8 zs8Var2 = this.D;
                    if (zs8Var2 != null) {
                        this.h0.funAdData.m(zs8Var2.l());
                        this.h0.funAdData.r(this.D.O());
                    }
                }
                ThreadData threadData2 = this.h0;
                if (threadData2 != null && (ql9Var = threadData2.funAdData) != null) {
                    ql9Var.j(1);
                    yy5.k().q(true);
                    ListUtils.add(arrayList, i, this.h0);
                    if (qz5.i().q()) {
                        qz5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.h0;
        }
        return (hn) invokeLI.objValue;
    }

    public final int u(zs8 zs8Var, ArrayList<hn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, zs8Var, arrayList)) == null) {
            if (!this.L && zs8Var != null && !ListUtils.isEmpty(zs8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.P() != null && this.a.P().d1()) {
                    return -1;
                }
                if (this.a.G5() != null && this.a.G5().U0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        hn hnVar = arrayList.get(i);
                        if (hnVar instanceof sl9) {
                            sl9 sl9Var = (sl9) hnVar;
                            if (sl9Var.E() == 1 && sl9Var.O == 0) {
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
                    if (zs8Var.v0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (zs8Var != null && zs8Var.v0() && this.J) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            sv8 sv8Var = this.c;
            if (sv8Var != null && sv8Var.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void g0() {
        sl9 sl9Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.D != null && (sl9Var = this.R) != null && sl9Var.W() != null && this.c.Q() != null) {
            String O = this.D.O();
            String l = this.D.l();
            if (this.D.M() != null) {
                i = this.D.M().getThreadType();
            } else {
                i = 0;
            }
            al5.a().c(O, l, this.R.W(), this.c.Q().s, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbFragment, bdTypeListView) == null) {
            sv8 sv8Var = new sv8(pbFragment, sl9.Q0);
            this.c = sv8Var;
            sv8Var.g0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, nt8.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, bt8.j);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), ct8.c);
            this.g = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.h = new ix8(pbFragment, ws8.c);
            this.i = new pw8(pbFragment, mt8.g);
            this.j = new dw8(pbFragment, ht8.c);
            this.k = new pw8(pbFragment, mt8.h);
            nv8 nv8Var = new nv8(pbFragment, sl9.R0);
            this.l = nv8Var;
            nv8Var.z0(pbFragment);
            sw8 sw8Var = new sw8(pbFragment, sl9.S0);
            this.m = sw8Var;
            sw8Var.v0(pbFragment);
            this.p = va9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.q = va9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.r = ek7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.s = ek7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.t = ek7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.w = new kw8(pbFragment, jt8.f1);
            this.u = new lw8(pbFragment, jw8.d1);
            this.v = new nw8(pbFragment, py4.j1);
            this.x = new PbReplyLoadMoreAdapter(pbFragment, sl9.Y0);
            this.n = new vz8(pbFragment, wz8.a);
            this.o = new th6(pbFragment.getPageContext());
            this.z = new lv8(pbFragment, ax4.e);
            this.A = new zv8(pbFragment, pbFragment.getUniqueId());
            this.B = new kx8(pbFragment.getPageContext(), vz5.g);
            qu8 qu8Var = new qu8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.C = qu8Var;
            this.b0.addAll(qu8Var.a());
            this.b0.add(this.c);
            this.b0.add(this.d);
            this.b0.add(this.e);
            this.b0.add(this.f);
            this.b0.add(this.g);
            this.b0.add(this.h);
            this.b0.add(this.l);
            this.b0.add(this.m);
            this.b0.add(this.i);
            this.b0.add(this.j);
            this.b0.add(this.k);
            this.b0.add(this.p);
            this.b0.add(this.q);
            this.b0.add(this.r);
            this.b0.add(this.s);
            this.b0.add(this.t);
            this.b0.add(this.w);
            this.b0.add(this.u);
            this.b0.add(this.v);
            this.b0.add(this.n);
            this.b0.add(this.x);
            this.b0.add(this.o);
            this.b0.add(this.z);
            this.b0.add(this.A);
            this.b0.add(new PbPrivateTitleAdapter(pbFragment));
            this.b0.add(this.B);
            this.k0.setPriority(1);
            this.k0.setSelfListener(true);
            pbFragment.registerListener(this.k0);
            pbFragment.registerListener(this.j0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new hl9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.b0);
        }
    }

    public final void L(@NonNull zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zs8Var) == null) {
            this.c.r(zs8Var);
            this.c.setFromCDN(this.G);
            this.c.l(this.P);
            this.c.c(this.I);
            this.c.e(this.U);
            this.c.k(this.T);
            this.c.n(this.W);
            this.c.d(this.Z);
            this.c.d0(this.X);
            this.c.f0(this.Y);
            this.f.y(this.X);
            this.l.r(zs8Var);
            this.l.setFromCDN(this.G);
            this.l.o(this.Q);
            this.l.c(this.I);
            this.l.e(this.U);
            this.l.k(this.T);
            this.l.n(this.W);
            this.l.d(this.Z);
            this.l.y0(this.Y);
            this.m.r(zs8Var);
            this.m.setFromCDN(this.G);
            this.m.o(this.Q);
            this.m.c(this.I);
            this.m.e(this.U);
            this.m.k(this.T);
            this.m.n(this.W);
            this.m.d(this.Z);
            this.m.u0(this.Y);
            this.d.J(this.U);
            this.x.y(this.U);
            this.n.y(this.m0);
            um umVar = this.q;
            if (umVar != null && (umVar instanceof ra9)) {
                ((ra9) umVar).setIsFromCDN(this.G);
            }
            Iterator<pu8> it = this.y.iterator();
            while (it.hasNext()) {
                pu8 next = it.next();
                if (next != null) {
                    next.r(zs8Var);
                    next.setFromCDN(this.G);
                    next.o(this.Q);
                    next.l(this.P);
                    next.c(this.I);
                    next.f(this.J);
                    next.q(this.O);
                    next.e(this.U);
                    next.k(this.T);
                    next.n(this.W);
                    next.d(this.Z);
                }
            }
            this.i.e(this.U);
            this.i.B(this.a0);
            this.j.e(this.V);
            this.k.e(this.U);
            this.i.r(zs8Var);
            this.h.r(zs8Var);
            this.k.r(zs8Var);
            this.u.r(zs8Var);
            this.v.r(zs8Var);
            this.z.A(zs8Var);
            this.z.z(this.a.p1);
            this.A.y(zs8Var);
        }
    }

    public final hn M(ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (this.D == null) {
                return null;
            }
            rl9 N0 = this.a.P().N0();
            if (N0 == null) {
                N0 = this.D.z();
            }
            if (N0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert t1 = N0.t1();
            if (t1 != null) {
                t1.setAdvertAppInfo(N0.getAdvertAppInfo());
            }
            int i2 = N0.getAdvertAppInfo().i();
            if (i2 != 0) {
                jc9.j(N0, i2);
                if (i2 != 28 && i2 != 31) {
                    N0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.D.k() != null) {
                N0.c1 = this.D.k().getId();
            }
            if (this.D.M() != null) {
                N0.f1 = gg.g(this.D.M().getId(), 0L);
            }
            zs8 zs8Var = this.D;
            if (zs8Var != null && zs8Var.y() != null) {
                N0.g1 = this.D.y().a();
            }
            l(N0);
            if (i < 0) {
                return null;
            }
            N0.j1 = 1;
            yy5.k().q(true);
            me8.b(arrayList, N0, i);
            if (qz5.i().q()) {
                qz5.i().n(arrayList, i + 1, 4);
            }
            return N0;
        }
        return (hn) invokeLI.objValue;
    }

    public final boolean N(zs8 zs8Var, ArrayList<hn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{zs8Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(zs8Var.e()) && zs8Var.e().size() > 2) {
                int min = Math.min(zs8Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    ax4 ax4Var = zs8Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        ax4Var.i(true);
                    }
                    if (ax4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            ax4Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        ax4Var.l(true);
                    } else if (i6 == min - 1) {
                        ax4Var.k(true);
                    }
                    arrayList2.add(ax4Var);
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

    public final hn O(zs8 zs8Var, ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLLI;
        ws8 ws8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, zs8Var, arrayList, i)) == null) {
            if (i >= 0 && zs8Var != null && zs8Var.k && (ws8Var = zs8Var.l) != null) {
                ListUtils.add(arrayList, i, ws8Var);
                return ws8Var;
            }
            return null;
        }
        return (hn) invokeLLI.objValue;
    }

    public final void X(sl9 sl9Var, ArrayList<hn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048605, this, sl9Var, arrayList, i) == null) {
            sl9Var.i1(true);
            arrayList.add(i, sl9Var);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<hn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<hn> listIterator = arrayList.listIterator();
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
                    if (i5 < this.i0.size()) {
                        listIterator.add(this.i0.get(i5));
                    } else {
                        sl9 sl9Var = new sl9();
                        ql9 ql9Var = new ql9();
                        zs8 zs8Var = this.D;
                        if (zs8Var == null) {
                            str3 = "";
                        } else {
                            str3 = zs8Var.l();
                        }
                        ql9Var.m(str3);
                        zs8 zs8Var2 = this.D;
                        if (zs8Var2 != null) {
                            str = zs8Var2.O();
                        }
                        ql9Var.r(str);
                        ql9Var.n(true);
                        sl9Var.w0 = ql9Var;
                        ql9Var.j(i7);
                        listIterator.add(sl9Var);
                        i7++;
                        this.i0.add(sl9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && qz5.i().q()) {
                qz5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                sl9 sl9Var2 = new sl9();
                ql9 ql9Var2 = new ql9();
                zs8 zs8Var3 = this.D;
                if (zs8Var3 == null) {
                    str2 = "";
                } else {
                    str2 = zs8Var3.l();
                }
                ql9Var2.m(str2);
                zs8 zs8Var4 = this.D;
                if (zs8Var4 != null) {
                    str = zs8Var4.O();
                }
                ql9Var2.r(str);
                ql9Var2.n(true);
                sl9Var2.w0 = ql9Var2;
                ql9Var2.j(1);
                listIterator.add(sl9Var2);
                this.i0.add(sl9Var2);
                if (qz5.i().q()) {
                    qz5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final hn S(zs8 zs8Var, sl9 sl9Var, ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048600, this, zs8Var, sl9Var, arrayList, i)) == null) {
            ct8 ct8Var = null;
            if (zs8Var.k() != null && !StringUtils.isNull(zs8Var.k().getName()) && TextUtils.equals(zs8Var.k().getName(), this.a.P().T0()) && this.a.P().Z0()) {
                return null;
            }
            if (sl9Var != null) {
                if (sl9Var.r0 != null) {
                    ct8Var = new ct8(sl9Var.r0);
                }
            } else {
                sl9 sl9Var2 = this.R;
                if (sl9Var2 != null && sl9Var2.r0 != null) {
                    ct8Var = new ct8(this.R.r0);
                }
            }
            if (ct8Var != null) {
                ct8Var.b = this.a.P().N1();
                ListUtils.add(arrayList, i + 1, ct8Var);
            }
            return ct8Var;
        }
        return (hn) invokeLLLI.objValue;
    }

    public final hn T(zs8 zs8Var, sl9 sl9Var, ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048601, this, zs8Var, sl9Var, arrayList, i)) == null) {
            if (sl9Var != null && sl9Var.X() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(sl9Var.X());
            } else {
                sl9 sl9Var2 = this.R;
                if (sl9Var2 != null && sl9Var2.X() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.R.X());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (zs8Var != null && !TextUtils.isEmpty(zs8Var.O())) {
                    pbFirstFloorRecommendData.f(zs8Var.O());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (hn) invokeLLLI.objValue;
    }

    public final void f0(boolean z, boolean z2, int i, List<hn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.M || this.L) && i != -1 && !ListUtils.isEmpty(list) && !this.N) {
                this.d0 = new e(this, list);
                jg.a().post(this.d0);
            }
        }
    }

    public final aw8 U(ArrayList<hn> arrayList, hn hnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048602, this, arrayList, hnVar, i, i2)) == null) {
            aw8 B = this.D.B();
            if (B != null) {
                if (hnVar != null) {
                    if (i2 < 0 && hnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (hnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof aw8)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (aw8) invokeLLII.objValue;
    }

    public final hn W(ArrayList<hn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, arrayList, i)) == null) {
            if (i < 0 || (P = this.a.P()) == null || TextUtils.isEmpty(P.y1())) {
                return null;
            }
            rl9 rl9Var = new rl9();
            l(rl9Var);
            ListUtils.add(arrayList, i + 1, rl9Var);
            return rl9Var;
        }
        return (hn) invokeLI.objValue;
    }

    public void c0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.G5() != null) {
            this.a.G5().Y1(z, i);
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        sv8 sv8Var = this.c;
                        if (sv8Var != null) {
                            sv8Var.X();
                        }
                        um umVar = this.q;
                        if (umVar instanceof ma9) {
                            ((ma9) umVar).onDestroy();
                        }
                        um umVar2 = this.r;
                        if (umVar2 instanceof ma9) {
                            ((ma9) umVar2).onDestroy();
                        }
                        um umVar3 = this.t;
                        if (umVar3 instanceof ma9) {
                            ((ma9) umVar3).onDestroy();
                        }
                        ov8.a().d();
                        return;
                    }
                    return;
                }
                sv8 sv8Var2 = this.c;
                if (sv8Var2 != null) {
                    sv8Var2.Y();
                }
                um umVar4 = this.q;
                if (umVar4 instanceof ma9) {
                    ((ma9) umVar4).onResume();
                }
                um umVar5 = this.r;
                if (umVar5 instanceof ma9) {
                    ((ma9) umVar5).onResume();
                }
                um umVar6 = this.t;
                if (umVar6 instanceof ma9) {
                    ((ma9) umVar6).onResume();
                }
                h0(false);
                g0();
                return;
            }
            sv8 sv8Var3 = this.c;
            if (sv8Var3 != null) {
                sv8Var3.W();
            }
            um umVar7 = this.q;
            if (umVar7 instanceof ma9) {
                ((ma9) umVar7).onPause();
            }
            um umVar8 = this.r;
            if (umVar8 instanceof ma9) {
                ((ma9) umVar8).onPause();
            }
            um umVar9 = this.t;
            if (umVar9 instanceof ma9) {
                ((ma9) umVar9).onPause();
            }
            ov8.a().i(this.a.Q());
            al5.a().d();
        }
    }

    public final void l(rl9 rl9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, rl9Var) == null) && rl9Var != null && this.D != null && rl9Var.getAdvertAppInfo() != null) {
            rl9Var.getAdvertAppInfo().i = new ow4();
            if (this.D.y() != null) {
                rl9Var.getAdvertAppInfo().i.b = this.D.y().a();
            }
            rl9Var.getAdvertAppInfo().i.a = rl9Var.s1();
            if (this.D.k() != null && (k = this.D.k()) != null) {
                rl9Var.getAdvertAppInfo().i.c = k.getId();
                rl9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                rl9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                rl9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            rl9Var.getAdvertAppInfo().i.g = rl9Var.getAdvertAppInfo().g;
            rl9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<hn> v(zs8 zs8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, zs8Var)) == null) {
            if (zs8Var == null || zs8Var.R() == null || ListUtils.isEmpty(zs8Var.R().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<sl9> list = zs8Var.R().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                sl9 sl9Var = list.get(i);
                if (sl9Var != null) {
                    sl9Var.c0 = true;
                    sl9Var.P = true;
                    arrayList.add(sl9Var);
                }
            }
            if (ListUtils.getCount(zs8Var.R().b) > 2) {
                hn hnVar = (hn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (hnVar instanceof sl9) {
                    ((sl9) hnVar).P = false;
                }
                arrayList.add(new wz8());
            } else {
                hn hnVar2 = (hn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (hnVar2 instanceof sl9) {
                    ((sl9) hnVar2).P = true;
                }
            }
            arrayList.add(0, new mt8(mt8.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && this.a.G5() != null && this.a.Q() != null && this.a.Q().I1() != null) {
            ov8.a().f(this.a.Q().I1().h2(), this.i.x(), this.a.G5().e1(), this.a.Q().getPageStayDurationItem(), z, this.C.b(), this.a.getListView());
        }
    }

    public final void o(List<hn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof sl9) {
                    if (i == 0 && (list.get(i2) instanceof rl9)) {
                        i = i2 + 1;
                    }
                    sl9 sl9Var = (sl9) list.get(i2);
                    if (!TextUtils.isEmpty(sl9Var.U())) {
                        ay4 ay4Var = new ay4();
                        ay4Var.e(sl9Var.U());
                        list.set(i2, ay4Var);
                    }
                }
            }
            if (i > 0 && qz5.i().q()) {
                qz5.i().n(list, i, 5);
            }
        }
    }

    public void i0(zs8 zs8Var, boolean z) {
        sl9 sl9Var;
        boolean z2;
        boolean z3;
        sl9 sl9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        aw8 aw8Var;
        List<hn> list;
        int i4;
        boolean z9;
        boolean z10;
        boolean z11;
        hn hnVar;
        int i5;
        boolean z12;
        sl9 sl9Var3;
        sl9 sl9Var4;
        sl9 sl9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048616, this, zs8Var, z) != null) || zs8Var == null) {
            return;
        }
        this.D = zs8Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            E0();
        }
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.clear();
        zs8 zs8Var2 = this.D;
        if (zs8Var2 != null && zs8Var2.F() != null && this.D.F().size() > 0) {
            this.E.addAll(this.D.F());
        }
        if (zs8Var.M() != null && zs8Var.M().getAuthor() != null) {
            this.Q = zs8Var.M().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(zs8Var);
        ArrayList<hn> arrayList = new ArrayList<>(zs8Var.F());
        sl9 p = p(arrayList);
        if (this.D.M().isQuestionThread()) {
            sl9Var = q(zs8Var);
        } else {
            sl9Var = null;
        }
        if (sl9Var != null) {
            arrayList.remove(sl9Var);
        }
        if (p != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!kk7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.D.r0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.R = p;
        }
        if (!this.J && p != null) {
            arrayList.remove(p);
            if (zs8Var.v0() && p.a0() != null) {
                p.c1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && zs8Var.i() != null) {
            sl9 i6 = zs8Var.i();
            if (!this.J && zs8Var.v0() && i6.a0() != null) {
                i6.c1(null);
            }
            if (!this.J && (sl9Var5 = this.R) != null && i6.i0 == null) {
                zs8Var.E0(sl9Var5);
                sl9Var2 = sl9Var5;
            } else {
                sl9Var2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            sl9Var2 = p;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.x5()) {
            if (zs8Var.F().size() > 0 && (sl9Var4 = zs8Var.F().get(0)) != null && sl9Var4.E() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.D, arrayList, this.J);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.D.C());
            }
        }
        int D = D(this.D, arrayList, this.J);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.D.D());
        }
        rk9.f(arrayList, 1);
        int A = A(zs8Var, arrayList);
        if (A >= 0) {
            V(zs8Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(zs8Var, arrayList);
        if (F >= 0) {
            ht8 ht8Var = new ht8(ht8.c);
            ht8Var.b(true);
            ListUtils.add(arrayList, F, ht8Var);
        }
        int u = u(zs8Var, arrayList);
        List<hn> v = v(zs8Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            hn hnVar2 = (hn) ListUtils.getItem(arrayList, u);
            if (hnVar2 instanceof sl9) {
                ((sl9) hnVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(zs8Var, arrayList, this.J);
        } else {
            i = -1;
        }
        if (i >= 0 && zs8Var.Q() != null) {
            sl9 V = zs8Var.V();
            ThreadData c2 = zs8Var.Q().c();
            if (V != null && V.p0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure p0 = V.p0();
                VirtualImageCustomState q0 = V.q0();
                c2.setCustomFigure(p0);
                c2.setCustomState(q0);
            }
            ListUtils.add(arrayList, i, zs8Var.Q());
            z6 = true;
            z7 = true;
        } else {
            if (sl9Var2 != null) {
                sl9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.D.M().isQuestionThread() && sl9Var != null) || (this.D.M().isQuestionThread() && this.S != null)) {
            if (sl9Var == null && (sl9Var3 = this.S) != null) {
                sl9Var = sl9Var3;
            }
            if (!arrayList.contains(sl9Var)) {
                i++;
                X(sl9Var, arrayList, i);
            }
        }
        if (T(zs8Var, sl9Var2, arrayList, i) != null || S(zs8Var, sl9Var2, arrayList, i) != null || R(zs8Var, arrayList, i) != null) {
            i++;
        }
        if (O(zs8Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            hn W = W(arrayList, i);
            if (W != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (i >= 0) {
                    i5 = i + 1;
                } else if (u >= 0) {
                    i5 = u;
                } else if (A >= 0) {
                    i5 = A;
                } else {
                    i5 = -1;
                }
                hnVar = M(arrayList, i5);
                if (hnVar != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = z10;
                hnVar = W;
                i5 = -1;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12 && this.D.r0()) {
                this.g0 = i5;
                if (P(arrayList, i5) != null) {
                    this.g0 = -1;
                    i++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                z8 = z11;
                i2 = i;
                aw8Var = null;
            } else {
                aw8 U = U(arrayList, hnVar, i, i5);
                if (U != null) {
                    if (!z11) {
                        aw8Var = U;
                        i2 = i;
                        z8 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                aw8Var = U;
                z8 = z11;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z8 = false;
            i3 = -1;
            aw8Var = null;
        }
        if (z2) {
            if (aw8Var != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            list = v;
            int i7 = i2;
            i4 = u;
            boolean N = N(zs8Var, arrayList, z8, z9, i3, i7, u, A);
            if (aw8Var != null) {
                aw8Var.n = N;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.e0(!z6);
        boolean D0 = D0(sl9Var2);
        if (this.K && !D0) {
            arrayList.remove(sl9Var2);
            this.K = false;
        }
        if (zs8Var.Q() != null) {
            zs8Var.Q().h(!z7);
        }
        if (this.b != null) {
            this.F = arrayList;
            List<hn> P = zs8Var.P();
            if (!ListUtils.isEmpty(P)) {
                this.b.setData(H(arrayList, P));
            } else {
                this.b.setData(this.F);
            }
        }
        f0(D0, z, i4, list);
        if (r(sl9Var2, arrayList, z4)) {
            List<hn> P2 = zs8Var.P();
            if (!ListUtils.isEmpty(P2)) {
                this.b.setData(H(arrayList, P2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.o0 = new ArrayList();
            ArrayList<BdUniqueId> g = rk9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ee8 b2 = jf8.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.b0.add(b2);
                    this.o0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.o0)) {
                this.b.addAdapters(this.o0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean r(sl9 sl9Var, ArrayList<hn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048631, this, sl9Var, arrayList, z)) == null) {
            if (sl9Var == null) {
                sl9 sl9Var2 = this.R;
                if (sl9Var2 != null && !this.L) {
                    ListUtils.add(arrayList, 0, sl9Var2);
                } else {
                    sl9 sl9Var3 = new sl9();
                    sl9Var3.K0(1);
                    ListUtils.add(arrayList, 0, sl9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, sl9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
