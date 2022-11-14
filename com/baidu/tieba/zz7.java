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
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
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
public class zz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c28 A;
    public ez7 B;
    public ox7 C;
    public ArrayList<PostData> D;
    public ArrayList<xn> E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public String P;
    public PostData Q;
    public PostData R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    public View.OnClickListener U;
    public TbRichTextView.y V;
    public View.OnClickListener W;
    public qy7 X;
    public View.OnLongClickListener Y;
    public SortSwitchButton.f Z;
    public PbFragment a;
    public final List<kn> a0;
    public BdTypeListView b;
    public final List<kn> b0;
    public j08 c;
    public Runnable c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public a28 g;
    public ThreadData g0;
    public i18 h;
    public List<PostData> h0;
    public w08 i;
    public final CustomMessageListener i0;
    public i18 j;
    public CustomMessageListener j0;
    public d08 k;
    public final CustomMessageListener k0;
    public m18 l;
    public final View.OnClickListener l0;
    public q48 m;
    public CustomMessageListener m0;
    public h56 n;
    public List<kn> n0;
    public kn o;
    public kn p;
    public kn q;
    public kn r;
    public kn s;
    public e18 t;
    public g18 u;
    public d18 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<dz7> x;
    public a08 y;
    public q08 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

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
                    this.a.a.Z();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C != null && !x9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    ah.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof jp8)) {
                jp8 jp8Var = (jp8) customResponsedMessage.getData();
                if (this.a.g0 != null && this.a.g0.funAdData == jp8Var) {
                    this.a.g0.funAdData.p(true);
                    this.a.b.setData(this.a.E);
                    this.a.Z();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof ap8)) {
                AbsDelegateAdapterList a = ((ap8) customResponsedMessage.getData()).a();
                Iterator<kn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    kn<?, ?> next = it.next();
                    if (next instanceof f08) {
                        ((f08) next).t(this.a.a);
                        if (next instanceof dz7) {
                            this.a.x.add((dz7) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.b0.clear();
                this.a.b0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public d(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.C != null && this.a.C.V() != null) {
                this.a.a.y5().V0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ zz7 b;

        public e(zz7 zz7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zz7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.e0);
                this.b.M = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.n0)) {
                this.a.n();
                zz7 zz7Var = this.a;
                zz7Var.h0(zz7Var.C, false);
            }
        }
    }

    public zz7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.x = new ArrayList<>();
        this.D = new ArrayList<>();
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = 0;
        this.P = null;
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
        this.a0 = new ArrayList();
        this.b0 = new ArrayList();
        this.d0 = -1;
        this.e0 = 0;
        this.f0 = -1;
        this.h0 = new ArrayList();
        this.i0 = new a(this, 2921523);
        this.j0 = new b(this, 2004015);
        this.k0 = new c(this, 2001118);
        this.l0 = new d(this);
        this.m0 = new f(this, 2016470);
        this.O = yi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.k0);
        this.e0 = yi.j(this.a.getContext()) / 3;
    }

    public void A0(qy7 qy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qy7Var) == null) {
            this.X = qy7Var;
        }
    }

    public void d0(boolean z) {
        j08 j08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (j08Var = this.c) != null) {
            j08Var.S(z);
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.G = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.J = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.H = z;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.N = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.K = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.L = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.I = z;
        }
    }

    public final PostData q(ox7 ox7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, ox7Var)) == null) {
            if (ox7Var != null && ox7Var.W() != null) {
                PostData W = ox7Var.W();
                this.R = W;
                return W;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.M = z;
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.U = onClickListener;
        }
    }

    public void s0(boolean z) {
        d08 d08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && (d08Var = this.k) != null) {
            d08Var.u0(z);
        }
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.S = onClickListener;
        }
    }

    public void v0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yVar) == null) {
            this.V = yVar;
        }
    }

    public void w0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.Y = onLongClickListener;
        }
    }

    public xn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            return this.b.G(i);
        }
        return (xn) invokeI.objValue;
    }

    public void x0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) {
            this.Z = fVar;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.W = onClickListener;
        }
    }

    public final int A(ox7 ox7Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ox7Var, arrayList)) == null) {
            if (ox7Var == null || ListUtils.isEmpty(ox7Var.H()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(ox7Var.H(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    xn xnVar = arrayList.get(i);
                    if (xnVar instanceof PostData) {
                        PostData postData = (PostData) xnVar;
                        if (postData.D() == 1 && postData.O == 0) {
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

    public final int F(ox7 ox7Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, ox7Var, arrayList)) == null) {
            int i = -1;
            if (ox7Var == null || ox7Var.z() == null) {
                return -1;
            }
            int i2 = 0;
            if (ox7Var.z().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.G) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof by7) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (ox7Var.N() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<xn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = m15.i();
        int j = m15.j() - 1;
        if (bool.booleanValue()) {
            xn xnVar = arrayList.get(0);
            if ((xnVar instanceof PostData) && ((PostData) xnVar).D() == 1) {
                j++;
            }
        }
        int k = m15.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.K() != null && this.a.K().c2() == 3) {
            this.h0.clear();
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
                    xn xnVar = this.b.getData().get(i);
                    if (xnVar != null && xnVar.getType() == by7.i) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            ah.a().removeCallbacks(this.c0);
            i18 i18Var = this.h;
            if (i18Var != null) {
                i18Var.onDestroy();
            }
            i18 i18Var2 = this.j;
            if (i18Var2 != null) {
                i18Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            a28 a28Var = this.g;
            if (a28Var != null) {
                a28Var.onDestroy();
            }
            tq5.k().q(false);
        }
    }

    public void B0() {
        w08 w08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (w08Var = this.i) != null) {
            w08Var.x(2);
        }
    }

    public void E0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (i = this.f0) > 0 && P(this.E, i) != null) {
            this.f0 = -1;
            this.b.setData(this.E);
            Z();
        }
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d0;
        }
        return invokeV.intValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.F;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.d0 = B();
            if (this.b.getAdapter2() instanceof on) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.m0);
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.B.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<xn> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.E;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.d;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public int C(ox7 ox7Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, ox7Var, arrayList, z)) == null) {
            if (ox7Var == null || ox7Var.H() == null || ox7Var.E() == null || ox7Var.H().size() == 0 || ox7Var.Q() == null || arrayList == null || !ox7Var.E().m1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ox7Var.H().get(0) == null || ox7Var.H().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ox7Var.z() == null || ox7Var.z().a() != ox7Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(ox7 ox7Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, ox7Var, arrayList, z)) == null) {
            if (ox7Var == null || ox7Var.H() == null || ox7Var.F() == null || ox7Var.H().size() == 0 || ox7Var.Q() == null || arrayList == null || !ox7Var.F().m1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ox7Var.H().get(0) == null || ox7Var.H().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ox7Var.z() == null || ox7Var.z().a() != ox7Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final xn R(ox7 ox7Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        qx7 qx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, ox7Var, arrayList, i)) == null) {
            if (ox7Var.l() != null && !StringUtils.isNull(ox7Var.l().getName())) {
                if (!TextUtils.equals(ox7Var.l().getName(), this.a.K().r1()) || !this.a.K().x1()) {
                    if (!this.a.t0() && !ListUtils.isEmpty(ox7Var.p())) {
                        qx7Var = new qx7(ox7Var.p().get(0));
                    } else {
                        qx7Var = new qx7(ox7Var.l());
                    }
                    qx7Var.g = this.a.K().m2();
                    ListUtils.add(arrayList, i + 1, qx7Var);
                    return qx7Var;
                }
                return null;
            }
            return null;
        }
        return (xn) invokeLLI.objValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) {
            if (this.a.K() != null && postData != null && postData.M() != null && postData.M().equals(this.a.K().s2())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.F = z;
            this.c.setFromCDN(z);
            kn knVar = this.p;
            if (knVar != null && (knVar instanceof cg8)) {
                ((cg8) knVar).setIsFromCDN(z);
            }
            Iterator<dz7> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final PostData p(ArrayList<xn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<xn> it = arrayList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.D() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            d08 d08Var = this.k;
            if (d08Var != null) {
                d08Var.v0(z);
            }
            i18 i18Var = this.h;
            if (i18Var != null) {
                i18Var.y(z);
            }
            kn knVar = this.s;
            if (knVar != null) {
                knVar.setMulDel(z);
            }
            kn knVar2 = this.p;
            if (knVar2 != null) {
                knVar2.setMulDel(z);
            }
            j08 j08Var = this.c;
            if (j08Var != null) {
                j08Var.setMulDel(z);
            }
        }
    }

    public final void D0() {
        ox7 ox7Var;
        kp8 kp8Var;
        kp8 kp8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ox7Var = this.C) == null || ox7Var.c0 || ox7Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = ox7Var.H();
        ArrayList<kp8> e2 = this.C.e();
        if (!gj7.e(H) && !gj7.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<kp8> it = e2.iterator();
            while (it.hasNext()) {
                kp8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<kp8> it2 = e2.iterator();
            while (it2.hasNext()) {
                kp8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<kp8> it3 = e2.iterator();
            while (it3.hasNext()) {
                kp8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int n = next3.getAdvertAppInfo().n();
                    if (n != 0) {
                        th8.j(next3, n);
                        if (n != 28 && n != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            e2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                kp8 kp8Var3 = (kp8) sparseArray.valueAt(i);
                if (kp8Var3 != null && (kp8Var2 = (kp8) hashMap.put(kp8Var3.m1(), kp8Var3)) != null) {
                    th8.j(kp8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (kp8Var = (kp8) entry.getValue()) != null) {
                    sparseArray.put(kp8Var.getPosition(), kp8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                gj7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < gj7.i(arrayList); i4++) {
                kp8 kp8Var4 = (kp8) sparseArray.get(((Integer) gj7.d(arrayList, i4)).intValue());
                if (this.C.l() != null) {
                    kp8Var4.Y0 = this.C.l().getId();
                }
                if (this.C.Q() != null) {
                    kp8Var4.b1 = xg.g(this.C.Q().getId(), 0L);
                }
                ox7 ox7Var2 = this.C;
                if (ox7Var2 != null && ox7Var2.z() != null) {
                    kp8Var4.c1 = this.C.z().a();
                }
                l(kp8Var4);
                int position = kp8Var4.getPosition() + this.C.b0;
                if (position >= gj7.i(H)) {
                    kp8Var4.e1 = position;
                    th8.k(kp8Var4, 2, position, gj7.i(H));
                    return;
                }
                if (!this.I) {
                    position--;
                    kp8Var4.e1 = position;
                }
                if (position < 0) {
                    th8.j(kp8Var4, 23);
                } else {
                    kp8Var4.f1 = i3;
                    gj7.b(H, kp8Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", kp8Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int E(ox7 ox7Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, ox7Var, arrayList, z)) == null) {
            if (ox7Var != null && !ListUtils.isEmpty(ox7Var.H()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (ox7Var.H().get(0) == null || ox7Var.H().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (ox7Var == null || !ox7Var.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void U(ox7 ox7Var, ArrayList<xn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, ox7Var, arrayList, i) == null) {
            by7 by7Var = new by7(by7.i);
            ThreadData Q = ox7Var.Q();
            if (Q != null) {
                Q.getReply_num();
            }
            by7Var.d = this.a.S5();
            by7Var.c = ox7Var.g;
            ox7Var.c();
            by7Var.e = ox7Var.l0();
            by7Var.g = ox7Var.f;
            if (Q != null && Q.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            by7Var.h = z;
            ListUtils.add(arrayList, i, by7Var);
            if (ox7Var.N() == 4) {
                ListUtils.add(arrayList, i + 1, new ay7());
            }
        }
    }

    public final ArrayList<xn> H(List<xn> list, List<xn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, list, list2)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            ux7 ux7Var = new ux7();
            PbListView Z0 = this.a.y5().Z0();
            if (Z0 != null && Z0.o()) {
                ux7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e29);
                ux7Var.b = true;
            } else {
                ux7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a1a);
                ux7Var.b = false;
            }
            arrayList.add(ux7Var);
            k56 k56Var = new k56();
            k56Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe5);
            k56Var.needTopMargin = false;
            arrayList.add(k56Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final xn P(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        ox7 ox7Var;
        jp8 jp8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (ox7Var = this.C) != null && ox7Var.u0()) {
                String d2 = dx6.e().d("pb_banner");
                if (this.g0 == null && xw6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.g0 = threadData;
                    threadData.funAdData = new jp8();
                    ox7 ox7Var2 = this.C;
                    if (ox7Var2 != null) {
                        this.g0.funAdData.m(ox7Var2.m());
                        this.g0.funAdData.r(this.C.S());
                    }
                }
                ThreadData threadData2 = this.g0;
                if (threadData2 != null && (jp8Var = threadData2.funAdData) != null) {
                    jp8Var.j(1);
                    tq5.k().q(true);
                    ListUtils.add(arrayList, i, this.g0);
                    if (lr5.i().q()) {
                        lr5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.g0;
        }
        return (xn) invokeLI.objValue;
    }

    public final int u(ox7 ox7Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, ox7Var, arrayList)) == null) {
            if (!this.K && ox7Var != null && !ListUtils.isEmpty(ox7Var.H()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.K() != null && this.a.K().B1()) {
                    return -1;
                }
                if (this.a.y5() != null && this.a.y5().R0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        xn xnVar = arrayList.get(i);
                        if (xnVar instanceof PostData) {
                            PostData postData = (PostData) xnVar;
                            if (postData.D() == 1 && postData.O == 0) {
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
                    if (ox7Var.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (ox7Var != null && ox7Var.y0() && this.I) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            j08 j08Var = this.c;
            if (j08Var != null && j08Var.N() != null) {
                if (this.c.N().A != null && this.c.N().A.isShown()) {
                    return this.c.N().A;
                }
                return this.c.N().z;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f0() {
        PostData postData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.C != null && (postData = this.Q) != null && postData.U() != null && this.c.N() != null) {
            String S = this.C.S();
            String m = this.C.m();
            if (this.C.Q() != null) {
                i = this.C.Q().getThreadType();
            } else {
                i = 0;
            }
            rd5.a().c(S, m, this.Q.U(), this.c.N().t, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbFragment, bdTypeListView) == null) {
            j08 j08Var = new j08(pbFragment, PostData.M0);
            this.c = j08Var;
            j08Var.a0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, cy7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, qx7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), rx7.c);
            this.g = new a28(pbFragment, jx7.c);
            this.h = new i18(pbFragment, by7.i);
            this.i = new w08(pbFragment, wx7.c);
            this.j = new i18(pbFragment, by7.j);
            d08 d08Var = new d08(pbFragment, PostData.N0);
            this.k = d08Var;
            d08Var.x0(pbFragment);
            m18 m18Var = new m18(pbFragment, PostData.O0);
            this.l = m18Var;
            m18Var.t0(pbFragment);
            this.o = gg8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = gg8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = yw6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = yw6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = yw6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new d18(pbFragment, yx7.c1);
            this.t = new e18(pbFragment, c18.Z0);
            this.u = new g18(pbFragment, xt4.f1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.U0);
            this.m = new q48(pbFragment, r48.a);
            this.n = new h56(pbFragment.getPageContext());
            this.y = new a08(pbFragment, js4.e);
            this.z = new q08(pbFragment, pbFragment.getUniqueId());
            this.A = new c28(pbFragment.getPageContext(), qr5.g);
            ez7 ez7Var = new ez7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.B = ez7Var;
            this.a0.addAll(ez7Var.a());
            this.a0.add(this.c);
            this.a0.add(this.d);
            this.a0.add(this.e);
            this.a0.add(this.f);
            this.a0.add(this.g);
            this.a0.add(this.k);
            this.a0.add(this.l);
            this.a0.add(this.h);
            this.a0.add(this.i);
            this.a0.add(this.j);
            this.a0.add(this.o);
            this.a0.add(this.p);
            this.a0.add(this.q);
            this.a0.add(this.r);
            this.a0.add(this.s);
            this.a0.add(this.v);
            this.a0.add(this.t);
            this.a0.add(this.u);
            this.a0.add(this.m);
            this.a0.add(this.w);
            this.a0.add(this.n);
            this.a0.add(this.y);
            this.a0.add(this.z);
            this.a0.add(new PbPrivateTitleAdapter(pbFragment));
            this.a0.add(this.A);
            this.j0.setPriority(1);
            this.j0.setSelfListener(true);
            pbFragment.registerListener(this.j0);
            pbFragment.registerListener(this.i0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new ap8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.a0);
        }
    }

    public final void L(@NonNull ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ox7Var) == null) {
            this.c.r(ox7Var);
            this.c.setFromCDN(this.F);
            this.c.l(this.O);
            this.c.c(this.H);
            this.c.e(this.T);
            this.c.k(this.S);
            this.c.n(this.V);
            this.c.d(this.Y);
            this.c.X(this.W);
            this.c.Z(this.X);
            this.f.w(this.W);
            this.k.r(ox7Var);
            this.k.setFromCDN(this.F);
            this.k.o(this.P);
            this.k.c(this.H);
            this.k.e(this.T);
            this.k.k(this.S);
            this.k.n(this.V);
            this.k.d(this.Y);
            this.k.w0(this.X);
            this.l.r(ox7Var);
            this.l.setFromCDN(this.F);
            this.l.o(this.P);
            this.l.c(this.H);
            this.l.e(this.T);
            this.l.k(this.S);
            this.l.n(this.V);
            this.l.d(this.Y);
            this.l.s0(this.X);
            this.d.H(this.T);
            this.w.w(this.T);
            this.m.w(this.l0);
            kn knVar = this.p;
            if (knVar != null && (knVar instanceof cg8)) {
                ((cg8) knVar).setIsFromCDN(this.F);
            }
            Iterator<dz7> it = this.x.iterator();
            while (it.hasNext()) {
                dz7 next = it.next();
                if (next != null) {
                    next.r(ox7Var);
                    next.setFromCDN(this.F);
                    next.o(this.P);
                    next.l(this.O);
                    next.c(this.H);
                    next.f(this.I);
                    next.q(this.N);
                    next.e(this.T);
                    next.k(this.S);
                    next.n(this.V);
                    next.d(this.Y);
                }
            }
            this.h.e(this.T);
            this.h.z(this.Z);
            this.i.e(this.U);
            this.j.e(this.T);
            this.h.r(ox7Var);
            this.g.r(ox7Var);
            this.j.r(ox7Var);
            this.t.r(ox7Var);
            this.u.r(ox7Var);
            this.y.y(ox7Var);
            this.y.x(this.a.q1);
            this.z.w(ox7Var);
            this.B.f(ox7Var);
        }
    }

    public final xn M(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, arrayList, i)) == null) {
            if (this.C == null) {
                return null;
            }
            kp8 l1 = this.a.K().l1();
            if (l1 == null) {
                l1 = this.C.A();
            }
            if (l1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert p1 = l1.p1();
            if (p1 != null) {
                p1.setAdvertAppInfo(l1.getAdvertAppInfo());
            }
            int n = l1.getAdvertAppInfo().n();
            if (n != 0) {
                th8.j(l1, n);
                if (n != 28 && n != 31) {
                    l1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.C.l() != null) {
                l1.Y0 = this.C.l().getId();
            }
            if (this.C.Q() != null) {
                l1.b1 = xg.g(this.C.Q().getId(), 0L);
            }
            ox7 ox7Var = this.C;
            if (ox7Var != null && ox7Var.z() != null) {
                l1.c1 = this.C.z().a();
            }
            l(l1);
            if (i < 0) {
                return null;
            }
            l1.f1 = 1;
            tq5.k().q(true);
            gj7.b(arrayList, l1, i);
            if (lr5.i().q()) {
                lr5.i().n(arrayList, i + 1, 4);
            }
            return l1;
        }
        return (xn) invokeLI.objValue;
    }

    public final boolean N(ox7 ox7Var, ArrayList<xn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{ox7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(ox7Var.f()) && ox7Var.f().size() > 2) {
                int min = Math.min(ox7Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    js4 js4Var = ox7Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        js4Var.n(true);
                    }
                    if (js4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            js4Var.s(true);
                        }
                    } else if (i6 == min - 2) {
                        js4Var.s(true);
                    } else if (i6 == min - 1) {
                        js4Var.r(true);
                    }
                    arrayList2.add(js4Var);
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

    public final xn O(ox7 ox7Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        jx7 jx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, ox7Var, arrayList, i)) == null) {
            if (i >= 0 && ox7Var != null && ox7Var.k && (jx7Var = ox7Var.l) != null) {
                ListUtils.add(arrayList, i, jx7Var);
                return jx7Var;
            }
            return null;
        }
        return (xn) invokeLLI.objValue;
    }

    public final void W(PostData postData, ArrayList<xn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, postData, arrayList, i) == null) {
            postData.e1(true);
            arrayList.add(i, postData);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<xn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
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
                    if (i5 < this.h0.size()) {
                        listIterator.add(this.h0.get(i5));
                    } else {
                        PostData postData = new PostData();
                        jp8 jp8Var = new jp8();
                        ox7 ox7Var = this.C;
                        if (ox7Var == null) {
                            str3 = "";
                        } else {
                            str3 = ox7Var.m();
                        }
                        jp8Var.m(str3);
                        ox7 ox7Var2 = this.C;
                        if (ox7Var2 != null) {
                            str = ox7Var2.S();
                        }
                        jp8Var.r(str);
                        jp8Var.n(true);
                        postData.v0 = jp8Var;
                        jp8Var.j(i7);
                        listIterator.add(postData);
                        i7++;
                        this.h0.add(postData);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && lr5.i().q()) {
                lr5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                PostData postData2 = new PostData();
                jp8 jp8Var2 = new jp8();
                ox7 ox7Var3 = this.C;
                if (ox7Var3 == null) {
                    str2 = "";
                } else {
                    str2 = ox7Var3.m();
                }
                jp8Var2.m(str2);
                ox7 ox7Var4 = this.C;
                if (ox7Var4 != null) {
                    str = ox7Var4.S();
                }
                jp8Var2.r(str);
                jp8Var2.n(true);
                postData2.v0 = jp8Var2;
                jp8Var2.j(1);
                listIterator.add(postData2);
                this.h0.add(postData2);
                if (lr5.i().q()) {
                    lr5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final xn S(ox7 ox7Var, PostData postData, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048599, this, ox7Var, postData, arrayList, i)) == null) {
            rx7 rx7Var = null;
            if (ox7Var.l() != null && !StringUtils.isNull(ox7Var.l().getName()) && TextUtils.equals(ox7Var.l().getName(), this.a.K().r1()) && this.a.K().x1()) {
                return null;
            }
            if (postData != null) {
                if (postData.q0 != null) {
                    rx7Var = new rx7(postData.q0);
                }
            } else {
                PostData postData2 = this.Q;
                if (postData2 != null && postData2.q0 != null) {
                    rx7Var = new rx7(this.Q.q0);
                }
            }
            if (rx7Var != null) {
                rx7Var.b = this.a.K().m2();
                ListUtils.add(arrayList, i + 1, rx7Var);
            }
            return rx7Var;
        }
        return (xn) invokeLLLI.objValue;
    }

    public final r08 T(ArrayList<xn> arrayList, xn xnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, arrayList, xnVar, i, i2)) == null) {
            r08 C = this.C.C();
            if (C != null) {
                if (xnVar != null) {
                    if (i2 < 0 && xnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (xnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (C instanceof r08)) {
                    ListUtils.add(arrayList, i2, C);
                    return C;
                }
                return null;
            }
            return null;
        }
        return (r08) invokeLLII.objValue;
    }

    public final xn V(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, arrayList, i)) == null) {
            if (i < 0 || (K = this.a.K()) == null || TextUtils.isEmpty(K.W1())) {
                return null;
            }
            kp8 kp8Var = new kp8();
            l(kp8Var);
            ListUtils.add(arrayList, i + 1, kp8Var);
            return kp8Var;
        }
        return (xn) invokeLI.objValue;
    }

    public void b0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.y5() != null) {
            this.a.y5().Z1(z, i);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        j08 j08Var = this.c;
                        if (j08Var != null) {
                            j08Var.U();
                        }
                        kn knVar = this.p;
                        if (knVar instanceof xf8) {
                            ((xf8) knVar).onDestroy();
                        }
                        kn knVar2 = this.q;
                        if (knVar2 instanceof xf8) {
                            ((xf8) knVar2).onDestroy();
                        }
                        kn knVar3 = this.s;
                        if (knVar3 instanceof xf8) {
                            ((xf8) knVar3).onDestroy();
                        }
                        e08.a().d();
                        return;
                    }
                    return;
                }
                j08 j08Var2 = this.c;
                if (j08Var2 != null) {
                    j08Var2.V();
                }
                kn knVar4 = this.p;
                if (knVar4 instanceof xf8) {
                    ((xf8) knVar4).onResume();
                }
                kn knVar5 = this.q;
                if (knVar5 instanceof xf8) {
                    ((xf8) knVar5).onResume();
                }
                kn knVar6 = this.s;
                if (knVar6 instanceof xf8) {
                    ((xf8) knVar6).onResume();
                }
                g0(false);
                f0();
                return;
            }
            j08 j08Var3 = this.c;
            if (j08Var3 != null) {
                j08Var3.T();
            }
            kn knVar7 = this.p;
            if (knVar7 instanceof xf8) {
                ((xf8) knVar7).onPause();
            }
            kn knVar8 = this.q;
            if (knVar8 instanceof xf8) {
                ((xf8) knVar8).onPause();
            }
            kn knVar9 = this.s;
            if (knVar9 instanceof xf8) {
                ((xf8) knVar9).onPause();
            }
            e08.a().j(this.a.P());
            rd5.a().d();
        }
    }

    public final void l(kp8 kp8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, kp8Var) == null) && kp8Var != null && this.C != null && kp8Var.getAdvertAppInfo() != null) {
            kp8Var.getAdvertAppInfo().i = new xr4();
            if (this.C.z() != null) {
                kp8Var.getAdvertAppInfo().i.b = this.C.z().a();
            }
            kp8Var.getAdvertAppInfo().i.a = kp8Var.o1();
            if (this.C.l() != null && (l = this.C.l()) != null) {
                kp8Var.getAdvertAppInfo().i.c = l.getId();
                kp8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                kp8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                kp8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            kp8Var.getAdvertAppInfo().i.g = kp8Var.getAdvertAppInfo().g;
            kp8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<xn> v(ox7 ox7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, ox7Var)) == null) {
            if (ox7Var == null || ox7Var.V() == null || ListUtils.isEmpty(ox7Var.V().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = ox7Var.V().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.c0 = true;
                    postData.P = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(ox7Var.V().b) > 2) {
                xn xnVar = (xn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (xnVar instanceof PostData) {
                    ((PostData) xnVar).P = false;
                }
                arrayList.add(new r48());
            } else {
                xn xnVar2 = (xn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (xnVar2 instanceof PostData) {
                    ((PostData) xnVar2).P = true;
                }
            }
            by7 by7Var = new by7(by7.j);
            by7Var.a = ox7Var.V().c;
            arrayList.add(0, by7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void e0(boolean z, boolean z2, int i, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.L || this.K) && i != -1 && !ListUtils.isEmpty(list) && !this.M) {
                this.c0 = new e(this, list);
                ah.a().post(this.c0);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && this.a.y5() != null && this.a.P() != null && this.a.P().j1() != null) {
            e08.a().g(this.a.P().j1().D2(), this.h.v(), this.a.y5().b1(), this.a.P().getPageStayDurationItem(), z, this.B.b(), this.a.getListView());
        }
    }

    public final void o(List<xn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof PostData) {
                    if (i == 0 && (list.get(i2) instanceof kp8)) {
                        i = i2 + 1;
                    }
                    PostData postData = (PostData) list.get(i2);
                    if (!TextUtils.isEmpty(postData.S())) {
                        it4 it4Var = new it4();
                        it4Var.h(postData.S());
                        list.set(i2, it4Var);
                    }
                }
            }
            if (i > 0 && lr5.i().q()) {
                lr5.i().n(list, i, 5);
            }
        }
    }

    public void h0(ox7 ox7Var, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        PostData postData2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        boolean z8;
        int i2;
        boolean z9;
        int i3;
        r08 r08Var;
        List<xn> list;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        xn xnVar;
        int i5;
        boolean z13;
        PostData postData3;
        PostData postData4;
        PostData postData5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048614, this, ox7Var, z) != null) || ox7Var == null) {
            return;
        }
        this.C = ox7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.clear();
        ox7 ox7Var2 = this.C;
        if (ox7Var2 != null && ox7Var2.H() != null && this.C.H().size() > 0) {
            this.D.addAll(this.C.H());
        }
        if (ox7Var.Q() != null && ox7Var.Q().getAuthor() != null) {
            this.P = ox7Var.Q().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(ox7Var);
        ArrayList<xn> arrayList = new ArrayList<>(ox7Var.H());
        PostData p = p(arrayList);
        if (this.C.Q().isQuestionThread()) {
            postData = q(ox7Var);
        } else {
            postData = null;
        }
        if (postData != null) {
            arrayList.remove(postData);
        }
        if (p != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!ex6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.C.u0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.Q = p;
        }
        if (!this.I && p != null) {
            arrayList.remove(p);
            if (ox7Var.y0() && p.X() != null) {
                p.Y0(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && ox7Var.j() != null) {
            PostData j = ox7Var.j();
            if (!this.I && ox7Var.y0() && j.X() != null) {
                j.Y0(null);
            }
            if (!this.I && (postData5 = this.Q) != null && j.i0 == null) {
                ox7Var.H0(postData5);
                postData2 = postData5;
            } else {
                postData2 = j;
            }
            z2 = true;
            z4 = true;
        } else {
            postData2 = p;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.p5()) {
            if (ox7Var.H().size() > 0 && (postData4 = ox7Var.H().get(0)) != null && postData4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.C, arrayList, this.I);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.C.E());
            }
        }
        int D = D(this.C, arrayList, this.I);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.C.F());
        }
        ko8.f(arrayList, 1);
        int A = A(ox7Var, arrayList);
        if (A >= 0) {
            U(ox7Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(ox7Var, arrayList);
        if (F >= 0) {
            wx7 wx7Var = new wx7(wx7.c);
            wx7Var.b(true);
            ListUtils.add(arrayList, F, wx7Var);
        }
        int u = u(ox7Var, arrayList);
        List<xn> v = v(ox7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            xn xnVar2 = (xn) ListUtils.getItem(arrayList, u);
            if (xnVar2 instanceof PostData) {
                ((PostData) xnVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(ox7Var, arrayList, this.I);
        } else {
            i = -1;
        }
        if (i >= 0 && ox7Var.U() != null) {
            PostData Z = ox7Var.Z();
            ThreadData c2 = ox7Var.U().c();
            if (Z != null && Z.m0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure m0 = Z.m0();
                VirtualImageCustomState n0 = Z.n0();
                c2.setCustomFigure(m0);
                c2.setCustomState(n0);
            }
            ListUtils.add(arrayList, i, ox7Var.U());
            z6 = true;
            z7 = true;
        } else {
            if (postData2 != null) {
                postData2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.C.Q().isQuestionThread() && postData != null) || (this.C.Q().isQuestionThread() && this.R != null)) {
            if (postData == null && (postData3 = this.R) != null) {
                postData = postData3;
            }
            if (!arrayList.contains(postData)) {
                i++;
                W(postData, arrayList, i);
            }
        }
        if (S(ox7Var, postData2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && R(ox7Var, arrayList, i) != null) {
            i++;
        }
        if (O(ox7Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            xn V = V(arrayList, i);
            if (V != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (i >= 0) {
                    i5 = i + 1;
                } else if (u >= 0) {
                    i5 = u;
                } else if (A >= 0) {
                    i5 = A;
                } else {
                    i5 = -1;
                }
                xnVar = M(arrayList, i5);
                if (xnVar != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = z11;
                xnVar = V;
                i5 = -1;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13 && this.C.u0()) {
                this.f0 = i5;
                if (P(arrayList, i5) != null) {
                    this.f0 = -1;
                    i++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z13) {
                z9 = z12;
                i2 = i;
                r08Var = null;
            } else {
                r08 T = T(arrayList, xnVar, i, i5);
                if (T != null) {
                    if (!z12) {
                        r08Var = T;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                r08Var = T;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            r08Var = null;
        }
        if (z2) {
            if (r08Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean N = N(ox7Var, arrayList, z9, z10, i3, i6, u, A);
            if (r08Var != null) {
                r08Var.n = N;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.Y(!z6);
        boolean C0 = C0(postData2);
        if (this.J && !C0) {
            arrayList.remove(postData2);
            this.J = false;
        }
        if (ox7Var.U() != null) {
            ox7Var.U().j(!z7);
        }
        if (this.b != null) {
            this.E = arrayList;
            List<xn> T2 = ox7Var.T();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setData(H(arrayList, T2));
            } else {
                this.b.setData(this.E);
            }
        }
        e0(C0, z, i4, list);
        if (r(postData2, arrayList, z4)) {
            List<xn> T3 = ox7Var.T();
            if (!ListUtils.isEmpty(T3)) {
                this.b.setData(H(arrayList, T3));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.n0 = new ArrayList();
            ArrayList<BdUniqueId> g = ko8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                yi7 b2 = dk7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.a0.add(b2);
                    this.n0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.n0)) {
                this.b.a(this.n0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean r(PostData postData, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, postData, arrayList, z)) == null) {
            if (postData == null) {
                PostData postData2 = this.Q;
                if (postData2 != null && !this.K) {
                    ListUtils.add(arrayList, 0, postData2);
                } else {
                    PostData postData3 = new PostData();
                    postData3.G0(1);
                    ListUtils.add(arrayList, 0, postData3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, postData);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
