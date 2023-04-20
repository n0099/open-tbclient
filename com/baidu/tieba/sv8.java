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
/* loaded from: classes6.dex */
public class sv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hw8 A;
    public sx8 B;
    public yu8 C;
    public ht8 D;
    public ArrayList<am9> E;
    public ArrayList<in> F;
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
    public am9 R;
    public am9 S;
    public View.OnClickListener T;
    public View.OnClickListener U;
    public View.OnClickListener V;
    public TbRichTextView.a0 W;
    public View.OnClickListener X;
    public ku8 Y;
    public View.OnLongClickListener Z;
    public PbFragment a;
    public SortSwitchButton.f a0;
    public BdTypeListView b;
    public final List<vm> b0;
    public aw8 c;
    public final List<vm> c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public Runnable d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public PbFirstFloorRecommendAdapter g;
    public int g0;
    public qx8 h;
    public ThreadData h0;
    public xw8 i;
    public List<am9> i0;
    public lw8 j;
    public final CustomMessageListener j0;
    public xw8 k;
    public CustomMessageListener k0;
    public vv8 l;
    public final CustomMessageListener l0;
    public ax8 m;
    public final View.OnClickListener m0;
    public d09 n;
    public CustomMessageListener n0;
    public uh6 o;
    public List<vm> o0;
    public vm p;
    public vm q;
    public vm r;
    public vm s;
    public vm t;
    public tw8 u;
    public vw8 v;
    public sw8 w;
    public PbReplyLoadMoreAdapter x;
    public ArrayList<xu8> y;
    public tv8 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv8 a;

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
                    this.a.a.a0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sv8 sv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv8Var, Integer.valueOf(i)};
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
            this.a = sv8Var;
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

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sv8 sv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv8Var, Integer.valueOf(i)};
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
            this.a = sv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof yl9)) {
                yl9 yl9Var = (yl9) customResponsedMessage.getData();
                if (this.a.h0 != null && this.a.h0.funAdData == yl9Var) {
                    this.a.h0.funAdData.p(true);
                    this.a.b.setData(this.a.F);
                    this.a.a0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sv8 sv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv8Var, Integer.valueOf(i)};
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
            this.a = sv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof pl9)) {
                AbsDelegateAdapterList a = ((pl9) customResponsedMessage.getData()).a();
                Iterator<vm<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    vm<?, ?> next = it.next();
                    if (next instanceof xv8) {
                        ((xv8) next).t(this.a.a);
                        if (next instanceof xu8) {
                            this.a.y.add((xu8) next);
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv8 a;

        public d(sv8 sv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sv8Var;
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

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ sv8 b;

        public e(sv8 sv8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sv8Var;
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

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sv8 sv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv8Var, Integer.valueOf(i)};
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
            this.a = sv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.o0)) {
                this.a.n();
                sv8 sv8Var = this.a;
                sv8Var.i0(sv8Var.D, false);
            }
        }
    }

    public sv8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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

    public void B0(ku8 ku8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ku8Var) == null) {
            this.Y = ku8Var;
        }
    }

    public void e0(boolean z) {
        aw8 aw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (aw8Var = this.c) != null) {
            aw8Var.V(z);
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

    public final am9 q(ht8 ht8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, ht8Var)) == null) {
            if (ht8Var != null && ht8Var.S() != null) {
                am9 S = ht8Var.S();
                this.S = S;
                return S;
            }
            return null;
        }
        return (am9) invokeL.objValue;
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
        vv8 vv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (vv8Var = this.l) != null) {
            vv8Var.w0(z);
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

    public in x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i)) == null) {
            return this.b.F(i);
        }
        return (in) invokeI.objValue;
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

    public final int A(ht8 ht8Var, ArrayList<in> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ht8Var, arrayList)) == null) {
            if (ht8Var == null || ListUtils.isEmpty(ht8Var.F()) || ListUtils.isEmpty(arrayList) || ((am9) ListUtils.getItem(ht8Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    in inVar = arrayList.get(i);
                    if (inVar instanceof am9) {
                        am9 am9Var = (am9) inVar;
                        if (am9Var.E() == 1 && am9Var.O == 0) {
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

    public final int F(ht8 ht8Var, ArrayList<in> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, ht8Var, arrayList)) == null) {
            int i = -1;
            if (ht8Var == null || ht8Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (ht8Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof ut8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (ht8Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<in> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = m75.i();
        int j = m75.j() - 1;
        if (bool.booleanValue()) {
            in inVar = arrayList.get(0);
            if ((inVar instanceof am9) && ((am9) inVar).E() == 1) {
                j++;
            }
        }
        int k = m75.k() + 1;
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
                    in inVar = this.b.getData().get(i);
                    if (inVar != null && inVar.getType() == ut8.g) {
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
            xw8 xw8Var = this.i;
            if (xw8Var != null) {
                xw8Var.onDestroy();
            }
            xw8 xw8Var2 = this.k;
            if (xw8Var2 != null) {
                xw8Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            qx8 qx8Var = this.h;
            if (qx8Var != null) {
                qx8Var.onDestroy();
            }
            zy5.k().q(false);
        }
    }

    public int C(ht8 ht8Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, ht8Var, arrayList, z)) == null) {
            if (ht8Var == null || ht8Var.F() == null || ht8Var.C() == null || ht8Var.F().size() == 0 || ht8Var.M() == null || arrayList == null || !ht8Var.C().q1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ht8Var.F().get(0) == null || ht8Var.F().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ht8Var.y() == null || ht8Var.y().a() != ht8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(ht8 ht8Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, ht8Var, arrayList, z)) == null) {
            if (ht8Var == null || ht8Var.F() == null || ht8Var.D() == null || ht8Var.F().size() == 0 || ht8Var.M() == null || arrayList == null || !ht8Var.D().q1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ht8Var.F().get(0) == null || ht8Var.F().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ht8Var.y() == null || ht8Var.y().a() != ht8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final in R(ht8 ht8Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLI;
        jt8 jt8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, ht8Var, arrayList, i)) == null) {
            if (ht8Var.k() != null && !StringUtils.isNull(ht8Var.k().getName())) {
                if (!TextUtils.equals(ht8Var.k().getName(), this.a.P().T0()) || !this.a.P().Z0()) {
                    if (!this.a.y0() && !ListUtils.isEmpty(ht8Var.o())) {
                        jt8Var = new jt8(ht8Var.o().get(0));
                    } else {
                        jt8Var = new jt8(ht8Var.k());
                    }
                    jt8Var.g = this.a.P().N1();
                    ListUtils.add(arrayList, i + 1, jt8Var);
                    return jt8Var;
                }
                return null;
            }
            return null;
        }
        return (in) invokeLLI.objValue;
    }

    public void C0() {
        lw8 lw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (lw8Var = this.j) != null) {
            lw8Var.z(2);
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
            if (this.b.getAdapter2() instanceof zm) {
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

    public ArrayList<in> t() {
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

    public final boolean D0(am9 am9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, am9Var)) == null) {
            if (this.a.P() != null && am9Var != null && am9Var.O() != null && am9Var.O().equals(this.a.P().T1())) {
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
            vm vmVar = this.q;
            if (vmVar != null && (vmVar instanceof za9)) {
                ((za9) vmVar).setIsFromCDN(z);
            }
            Iterator<xu8> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final am9 p(ArrayList<in> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, arrayList)) == null) {
            Iterator<in> it = arrayList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if (next instanceof am9) {
                    am9 am9Var = (am9) next;
                    if (am9Var.E() == 1) {
                        return am9Var;
                    }
                }
            }
            return null;
        }
        return (am9) invokeL.objValue;
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            vv8 vv8Var = this.l;
            if (vv8Var != null) {
                vv8Var.x0(z);
            }
            xw8 xw8Var = this.i;
            if (xw8Var != null) {
                xw8Var.A(z);
            }
            vm vmVar = this.t;
            if (vmVar != null) {
                vmVar.setMulDel(z);
            }
            vm vmVar2 = this.q;
            if (vmVar2 != null) {
                vmVar2.setMulDel(z);
            }
            aw8 aw8Var = this.c;
            if (aw8Var != null) {
                aw8Var.setMulDel(z);
            }
        }
    }

    public final int E(ht8 ht8Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, ht8Var, arrayList, z)) == null) {
            if (ht8Var != null && !ListUtils.isEmpty(ht8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (ht8Var.F().get(0) == null || ht8Var.F().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (ht8Var == null || !ht8Var.v0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void V(ht8 ht8Var, ArrayList<in> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, ht8Var, arrayList, i) == null) {
            ut8 ut8Var = new ut8(ut8.g);
            ThreadData M = ht8Var.M();
            ut8Var.c = this.a.Y5();
            ut8Var.b = ht8Var.g;
            ut8Var.d = ht8Var.h0();
            ut8Var.e = ht8Var.f;
            if (M != null && M.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            ut8Var.f = z;
            ListUtils.add(arrayList, i, ut8Var);
            if (ht8Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new tt8());
            }
        }
    }

    public final void E0() {
        ht8 ht8Var;
        zl9 zl9Var;
        zl9 zl9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (ht8Var = this.D) == null || ht8Var.Z || ht8Var.a0 == 2) {
            return;
        }
        ArrayList<am9> F = ht8Var.F();
        ArrayList<zl9> d2 = this.D.d();
        if (!ue8.e(F) && !ue8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<zl9> it = d2.iterator();
            while (it.hasNext()) {
                zl9 next = it.next();
                if (next != null && next.r1() != null) {
                    sb.append(next.r1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<zl9> it2 = d2.iterator();
            while (it2.hasNext()) {
                zl9 next2 = it2.next();
                if (next2 != null) {
                    next2.i1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<zl9> it3 = d2.iterator();
            while (it3.hasNext()) {
                zl9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        rc9.j(next3, i);
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
                zl9 zl9Var3 = (zl9) sparseArray.valueAt(i2);
                if (zl9Var3 != null && (zl9Var2 = (zl9) hashMap.put(zl9Var3.q1(), zl9Var3)) != null) {
                    rc9.j(zl9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (zl9Var = (zl9) entry.getValue()) != null) {
                    sparseArray.put(zl9Var.getPosition(), zl9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                ue8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < ue8.i(arrayList); i5++) {
                zl9 zl9Var4 = (zl9) sparseArray.get(((Integer) ue8.d(arrayList, i5)).intValue());
                if (this.D.k() != null) {
                    zl9Var4.c1 = this.D.k().getId();
                }
                if (this.D.M() != null) {
                    zl9Var4.f1 = gg.g(this.D.M().getId(), 0L);
                }
                ht8 ht8Var2 = this.D;
                if (ht8Var2 != null && ht8Var2.y() != null) {
                    zl9Var4.g1 = this.D.y().a();
                }
                l(zl9Var4);
                int position = zl9Var4.getPosition() + this.D.Y;
                if (position >= ue8.i(F)) {
                    zl9Var4.i1 = position;
                    rc9.k(zl9Var4, 2, position, ue8.i(F));
                    return;
                }
                if (!this.J) {
                    position--;
                    zl9Var4.i1 = position;
                }
                if (position < 0) {
                    rc9.j(zl9Var4, 23);
                } else {
                    zl9Var4.j1 = i4;
                    ue8.b(F, zl9Var4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", zl9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final ArrayList<in> H(List<in> list, List<in> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList<in> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            nt8 nt8Var = new nt8();
            PbListView c1 = this.a.G5().c1();
            if (c1 != null && c1.p()) {
                nt8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ec3);
                nt8Var.b = true;
            } else {
                nt8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                nt8Var.b = false;
            }
            arrayList.add(nt8Var);
            xh6 xh6Var = new xh6();
            xh6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            xh6Var.needTopMargin = false;
            arrayList.add(xh6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final in P(ArrayList<in> arrayList, int i) {
        InterceptResult invokeLI;
        ht8 ht8Var;
        yl9 yl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (ht8Var = this.D) != null && ht8Var.r0()) {
                String d2 = kk7.e().d("pb_banner");
                if (this.h0 == null && ek7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.h0 = threadData;
                    threadData.funAdData = new yl9();
                    ht8 ht8Var2 = this.D;
                    if (ht8Var2 != null) {
                        this.h0.funAdData.m(ht8Var2.l());
                        this.h0.funAdData.r(this.D.O());
                    }
                }
                ThreadData threadData2 = this.h0;
                if (threadData2 != null && (yl9Var = threadData2.funAdData) != null) {
                    yl9Var.j(1);
                    zy5.k().q(true);
                    ListUtils.add(arrayList, i, this.h0);
                    if (rz5.i().q()) {
                        rz5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.h0;
        }
        return (in) invokeLI.objValue;
    }

    public final int u(ht8 ht8Var, ArrayList<in> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, ht8Var, arrayList)) == null) {
            if (!this.L && ht8Var != null && !ListUtils.isEmpty(ht8Var.F()) && arrayList != null && arrayList.size() > 0) {
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
                        in inVar = arrayList.get(i);
                        if (inVar instanceof am9) {
                            am9 am9Var = (am9) inVar;
                            if (am9Var.E() == 1 && am9Var.O == 0) {
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
                    if (ht8Var.v0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (ht8Var != null && ht8Var.v0() && this.J) {
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
            aw8 aw8Var = this.c;
            if (aw8Var != null && aw8Var.Q() != null) {
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
        am9 am9Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.D != null && (am9Var = this.R) != null && am9Var.W() != null && this.c.Q() != null) {
            String O = this.D.O();
            String l = this.D.l();
            if (this.D.M() != null) {
                i = this.D.M().getThreadType();
            } else {
                i = 0;
            }
            bl5.a().c(O, l, this.R.W(), this.c.Q().s, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbFragment, bdTypeListView) == null) {
            aw8 aw8Var = new aw8(pbFragment, am9.Q0);
            this.c = aw8Var;
            aw8Var.g0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, vt8.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, jt8.j);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), kt8.c);
            this.g = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.h = new qx8(pbFragment, et8.c);
            this.i = new xw8(pbFragment, ut8.g);
            this.j = new lw8(pbFragment, pt8.c);
            this.k = new xw8(pbFragment, ut8.h);
            vv8 vv8Var = new vv8(pbFragment, am9.R0);
            this.l = vv8Var;
            vv8Var.z0(pbFragment);
            ax8 ax8Var = new ax8(pbFragment, am9.S0);
            this.m = ax8Var;
            ax8Var.v0(pbFragment);
            this.p = db9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.q = db9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.r = fk7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.s = fk7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.t = fk7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.w = new sw8(pbFragment, rt8.f1);
            this.u = new tw8(pbFragment, rw8.d1);
            this.v = new vw8(pbFragment, qy4.j1);
            this.x = new PbReplyLoadMoreAdapter(pbFragment, am9.Y0);
            this.n = new d09(pbFragment, e09.a);
            this.o = new uh6(pbFragment.getPageContext());
            this.z = new tv8(pbFragment, bx4.e);
            this.A = new hw8(pbFragment, pbFragment.getUniqueId());
            this.B = new sx8(pbFragment.getPageContext(), wz5.g);
            yu8 yu8Var = new yu8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.C = yu8Var;
            this.b0.addAll(yu8Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new pl9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.b0);
        }
    }

    public final void L(@NonNull ht8 ht8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ht8Var) == null) {
            this.c.r(ht8Var);
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
            this.l.r(ht8Var);
            this.l.setFromCDN(this.G);
            this.l.o(this.Q);
            this.l.c(this.I);
            this.l.e(this.U);
            this.l.k(this.T);
            this.l.n(this.W);
            this.l.d(this.Z);
            this.l.y0(this.Y);
            this.m.r(ht8Var);
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
            vm vmVar = this.q;
            if (vmVar != null && (vmVar instanceof za9)) {
                ((za9) vmVar).setIsFromCDN(this.G);
            }
            Iterator<xu8> it = this.y.iterator();
            while (it.hasNext()) {
                xu8 next = it.next();
                if (next != null) {
                    next.r(ht8Var);
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
            this.i.r(ht8Var);
            this.h.r(ht8Var);
            this.k.r(ht8Var);
            this.u.r(ht8Var);
            this.v.r(ht8Var);
            this.z.A(ht8Var);
            this.z.z(this.a.p1);
            this.A.y(ht8Var);
        }
    }

    public final in M(ArrayList<in> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (this.D == null) {
                return null;
            }
            zl9 N0 = this.a.P().N0();
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
                rc9.j(N0, i2);
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
            ht8 ht8Var = this.D;
            if (ht8Var != null && ht8Var.y() != null) {
                N0.g1 = this.D.y().a();
            }
            l(N0);
            if (i < 0) {
                return null;
            }
            N0.j1 = 1;
            zy5.k().q(true);
            ue8.b(arrayList, N0, i);
            if (rz5.i().q()) {
                rz5.i().n(arrayList, i + 1, 4);
            }
            return N0;
        }
        return (in) invokeLI.objValue;
    }

    public final boolean N(ht8 ht8Var, ArrayList<in> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{ht8Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(ht8Var.e()) && ht8Var.e().size() > 2) {
                int min = Math.min(ht8Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    bx4 bx4Var = ht8Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        bx4Var.i(true);
                    }
                    if (bx4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            bx4Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        bx4Var.l(true);
                    } else if (i6 == min - 1) {
                        bx4Var.k(true);
                    }
                    arrayList2.add(bx4Var);
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

    public final in O(ht8 ht8Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLI;
        et8 et8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, ht8Var, arrayList, i)) == null) {
            if (i >= 0 && ht8Var != null && ht8Var.k && (et8Var = ht8Var.l) != null) {
                ListUtils.add(arrayList, i, et8Var);
                return et8Var;
            }
            return null;
        }
        return (in) invokeLLI.objValue;
    }

    public final void X(am9 am9Var, ArrayList<in> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048605, this, am9Var, arrayList, i) == null) {
            am9Var.i1(true);
            arrayList.add(i, am9Var);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<in> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<in> listIterator = arrayList.listIterator();
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
                        am9 am9Var = new am9();
                        yl9 yl9Var = new yl9();
                        ht8 ht8Var = this.D;
                        if (ht8Var == null) {
                            str3 = "";
                        } else {
                            str3 = ht8Var.l();
                        }
                        yl9Var.m(str3);
                        ht8 ht8Var2 = this.D;
                        if (ht8Var2 != null) {
                            str = ht8Var2.O();
                        }
                        yl9Var.r(str);
                        yl9Var.n(true);
                        am9Var.w0 = yl9Var;
                        yl9Var.j(i7);
                        listIterator.add(am9Var);
                        i7++;
                        this.i0.add(am9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && rz5.i().q()) {
                rz5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                am9 am9Var2 = new am9();
                yl9 yl9Var2 = new yl9();
                ht8 ht8Var3 = this.D;
                if (ht8Var3 == null) {
                    str2 = "";
                } else {
                    str2 = ht8Var3.l();
                }
                yl9Var2.m(str2);
                ht8 ht8Var4 = this.D;
                if (ht8Var4 != null) {
                    str = ht8Var4.O();
                }
                yl9Var2.r(str);
                yl9Var2.n(true);
                am9Var2.w0 = yl9Var2;
                yl9Var2.j(1);
                listIterator.add(am9Var2);
                this.i0.add(am9Var2);
                if (rz5.i().q()) {
                    rz5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final in S(ht8 ht8Var, am9 am9Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048600, this, ht8Var, am9Var, arrayList, i)) == null) {
            kt8 kt8Var = null;
            if (ht8Var.k() != null && !StringUtils.isNull(ht8Var.k().getName()) && TextUtils.equals(ht8Var.k().getName(), this.a.P().T0()) && this.a.P().Z0()) {
                return null;
            }
            if (am9Var != null) {
                if (am9Var.r0 != null) {
                    kt8Var = new kt8(am9Var.r0);
                }
            } else {
                am9 am9Var2 = this.R;
                if (am9Var2 != null && am9Var2.r0 != null) {
                    kt8Var = new kt8(this.R.r0);
                }
            }
            if (kt8Var != null) {
                kt8Var.b = this.a.P().N1();
                ListUtils.add(arrayList, i + 1, kt8Var);
            }
            return kt8Var;
        }
        return (in) invokeLLLI.objValue;
    }

    public final in T(ht8 ht8Var, am9 am9Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048601, this, ht8Var, am9Var, arrayList, i)) == null) {
            if (am9Var != null && am9Var.X() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(am9Var.X());
            } else {
                am9 am9Var2 = this.R;
                if (am9Var2 != null && am9Var2.X() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.R.X());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (ht8Var != null && !TextUtils.isEmpty(ht8Var.O())) {
                    pbFirstFloorRecommendData.f(ht8Var.O());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (in) invokeLLLI.objValue;
    }

    public final void f0(boolean z, boolean z2, int i, List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.M || this.L) && i != -1 && !ListUtils.isEmpty(list) && !this.N) {
                this.d0 = new e(this, list);
                jg.a().post(this.d0);
            }
        }
    }

    public final iw8 U(ArrayList<in> arrayList, in inVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048602, this, arrayList, inVar, i, i2)) == null) {
            iw8 B = this.D.B();
            if (B != null) {
                if (inVar != null) {
                    if (i2 < 0 && inVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (inVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof iw8)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (iw8) invokeLLII.objValue;
    }

    public final in W(ArrayList<in> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, arrayList, i)) == null) {
            if (i < 0 || (P = this.a.P()) == null || TextUtils.isEmpty(P.y1())) {
                return null;
            }
            zl9 zl9Var = new zl9();
            l(zl9Var);
            ListUtils.add(arrayList, i + 1, zl9Var);
            return zl9Var;
        }
        return (in) invokeLI.objValue;
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
                        aw8 aw8Var = this.c;
                        if (aw8Var != null) {
                            aw8Var.X();
                        }
                        vm vmVar = this.q;
                        if (vmVar instanceof ua9) {
                            ((ua9) vmVar).onDestroy();
                        }
                        vm vmVar2 = this.r;
                        if (vmVar2 instanceof ua9) {
                            ((ua9) vmVar2).onDestroy();
                        }
                        vm vmVar3 = this.t;
                        if (vmVar3 instanceof ua9) {
                            ((ua9) vmVar3).onDestroy();
                        }
                        wv8.a().d();
                        return;
                    }
                    return;
                }
                aw8 aw8Var2 = this.c;
                if (aw8Var2 != null) {
                    aw8Var2.Y();
                }
                vm vmVar4 = this.q;
                if (vmVar4 instanceof ua9) {
                    ((ua9) vmVar4).onResume();
                }
                vm vmVar5 = this.r;
                if (vmVar5 instanceof ua9) {
                    ((ua9) vmVar5).onResume();
                }
                vm vmVar6 = this.t;
                if (vmVar6 instanceof ua9) {
                    ((ua9) vmVar6).onResume();
                }
                h0(false);
                g0();
                return;
            }
            aw8 aw8Var3 = this.c;
            if (aw8Var3 != null) {
                aw8Var3.W();
            }
            vm vmVar7 = this.q;
            if (vmVar7 instanceof ua9) {
                ((ua9) vmVar7).onPause();
            }
            vm vmVar8 = this.r;
            if (vmVar8 instanceof ua9) {
                ((ua9) vmVar8).onPause();
            }
            vm vmVar9 = this.t;
            if (vmVar9 instanceof ua9) {
                ((ua9) vmVar9).onPause();
            }
            wv8.a().i(this.a.Q());
            bl5.a().d();
        }
    }

    public final void l(zl9 zl9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, zl9Var) == null) && zl9Var != null && this.D != null && zl9Var.getAdvertAppInfo() != null) {
            zl9Var.getAdvertAppInfo().i = new pw4();
            if (this.D.y() != null) {
                zl9Var.getAdvertAppInfo().i.b = this.D.y().a();
            }
            zl9Var.getAdvertAppInfo().i.a = zl9Var.s1();
            if (this.D.k() != null && (k = this.D.k()) != null) {
                zl9Var.getAdvertAppInfo().i.c = k.getId();
                zl9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                zl9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                zl9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            zl9Var.getAdvertAppInfo().i.g = zl9Var.getAdvertAppInfo().g;
            zl9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<in> v(ht8 ht8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, ht8Var)) == null) {
            if (ht8Var == null || ht8Var.R() == null || ListUtils.isEmpty(ht8Var.R().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<am9> list = ht8Var.R().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                am9 am9Var = list.get(i);
                if (am9Var != null) {
                    am9Var.c0 = true;
                    am9Var.P = true;
                    arrayList.add(am9Var);
                }
            }
            if (ListUtils.getCount(ht8Var.R().b) > 2) {
                in inVar = (in) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (inVar instanceof am9) {
                    ((am9) inVar).P = false;
                }
                arrayList.add(new e09());
            } else {
                in inVar2 = (in) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (inVar2 instanceof am9) {
                    ((am9) inVar2).P = true;
                }
            }
            arrayList.add(0, new ut8(ut8.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && this.a.G5() != null && this.a.Q() != null && this.a.Q().I1() != null) {
            wv8.a().f(this.a.Q().I1().h2(), this.i.x(), this.a.G5().e1(), this.a.Q().getPageStayDurationItem(), z, this.C.b(), this.a.getListView());
        }
    }

    public final void o(List<in> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof am9) {
                    if (i == 0 && (list.get(i2) instanceof zl9)) {
                        i = i2 + 1;
                    }
                    am9 am9Var = (am9) list.get(i2);
                    if (!TextUtils.isEmpty(am9Var.U())) {
                        by4 by4Var = new by4();
                        by4Var.e(am9Var.U());
                        list.set(i2, by4Var);
                    }
                }
            }
            if (i > 0 && rz5.i().q()) {
                rz5.i().n(list, i, 5);
            }
        }
    }

    public void i0(ht8 ht8Var, boolean z) {
        am9 am9Var;
        boolean z2;
        boolean z3;
        am9 am9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        iw8 iw8Var;
        List<in> list;
        int i4;
        boolean z9;
        boolean z10;
        boolean z11;
        in inVar;
        int i5;
        boolean z12;
        am9 am9Var3;
        am9 am9Var4;
        am9 am9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048616, this, ht8Var, z) != null) || ht8Var == null) {
            return;
        }
        this.D = ht8Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            E0();
        }
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.clear();
        ht8 ht8Var2 = this.D;
        if (ht8Var2 != null && ht8Var2.F() != null && this.D.F().size() > 0) {
            this.E.addAll(this.D.F());
        }
        if (ht8Var.M() != null && ht8Var.M().getAuthor() != null) {
            this.Q = ht8Var.M().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(ht8Var);
        ArrayList<in> arrayList = new ArrayList<>(ht8Var.F());
        am9 p = p(arrayList);
        if (this.D.M().isQuestionThread()) {
            am9Var = q(ht8Var);
        } else {
            am9Var = null;
        }
        if (am9Var != null) {
            arrayList.remove(am9Var);
        }
        if (p != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!lk7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.D.r0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.R = p;
        }
        if (!this.J && p != null) {
            arrayList.remove(p);
            if (ht8Var.v0() && p.a0() != null) {
                p.c1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && ht8Var.i() != null) {
            am9 i6 = ht8Var.i();
            if (!this.J && ht8Var.v0() && i6.a0() != null) {
                i6.c1(null);
            }
            if (!this.J && (am9Var5 = this.R) != null && i6.i0 == null) {
                ht8Var.E0(am9Var5);
                am9Var2 = am9Var5;
            } else {
                am9Var2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            am9Var2 = p;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.x5()) {
            if (ht8Var.F().size() > 0 && (am9Var4 = ht8Var.F().get(0)) != null && am9Var4.E() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        zk9.f(arrayList, 1);
        int A = A(ht8Var, arrayList);
        if (A >= 0) {
            V(ht8Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(ht8Var, arrayList);
        if (F >= 0) {
            pt8 pt8Var = new pt8(pt8.c);
            pt8Var.b(true);
            ListUtils.add(arrayList, F, pt8Var);
        }
        int u = u(ht8Var, arrayList);
        List<in> v = v(ht8Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            in inVar2 = (in) ListUtils.getItem(arrayList, u);
            if (inVar2 instanceof am9) {
                ((am9) inVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(ht8Var, arrayList, this.J);
        } else {
            i = -1;
        }
        if (i >= 0 && ht8Var.Q() != null) {
            am9 V = ht8Var.V();
            ThreadData c2 = ht8Var.Q().c();
            if (V != null && V.p0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure p0 = V.p0();
                VirtualImageCustomState q0 = V.q0();
                c2.setCustomFigure(p0);
                c2.setCustomState(q0);
            }
            ListUtils.add(arrayList, i, ht8Var.Q());
            z6 = true;
            z7 = true;
        } else {
            if (am9Var2 != null) {
                am9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.D.M().isQuestionThread() && am9Var != null) || (this.D.M().isQuestionThread() && this.S != null)) {
            if (am9Var == null && (am9Var3 = this.S) != null) {
                am9Var = am9Var3;
            }
            if (!arrayList.contains(am9Var)) {
                i++;
                X(am9Var, arrayList, i);
            }
        }
        if (T(ht8Var, am9Var2, arrayList, i) != null || S(ht8Var, am9Var2, arrayList, i) != null || R(ht8Var, arrayList, i) != null) {
            i++;
        }
        if (O(ht8Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            in W = W(arrayList, i);
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
                inVar = M(arrayList, i5);
                if (inVar != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = z10;
                inVar = W;
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
                iw8Var = null;
            } else {
                iw8 U = U(arrayList, inVar, i, i5);
                if (U != null) {
                    if (!z11) {
                        iw8Var = U;
                        i2 = i;
                        z8 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                iw8Var = U;
                z8 = z11;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z8 = false;
            i3 = -1;
            iw8Var = null;
        }
        if (z2) {
            if (iw8Var != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            list = v;
            int i7 = i2;
            i4 = u;
            boolean N = N(ht8Var, arrayList, z8, z9, i3, i7, u, A);
            if (iw8Var != null) {
                iw8Var.n = N;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.e0(!z6);
        boolean D0 = D0(am9Var2);
        if (this.K && !D0) {
            arrayList.remove(am9Var2);
            this.K = false;
        }
        if (ht8Var.Q() != null) {
            ht8Var.Q().h(!z7);
        }
        if (this.b != null) {
            this.F = arrayList;
            List<in> P = ht8Var.P();
            if (!ListUtils.isEmpty(P)) {
                this.b.setData(H(arrayList, P));
            } else {
                this.b.setData(this.F);
            }
        }
        f0(D0, z, i4, list);
        if (r(am9Var2, arrayList, z4)) {
            List<in> P2 = ht8Var.P();
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
            ArrayList<BdUniqueId> g = zk9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                me8 b2 = rf8.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public final boolean r(am9 am9Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048631, this, am9Var, arrayList, z)) == null) {
            if (am9Var == null) {
                am9 am9Var2 = this.R;
                if (am9Var2 != null && !this.L) {
                    ListUtils.add(arrayList, 0, am9Var2);
                } else {
                    am9 am9Var3 = new am9();
                    am9Var3.K0(1);
                    ListUtils.add(arrayList, 0, am9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, am9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
