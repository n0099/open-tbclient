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
public class sf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vh8 A;
    public xe8 B;
    public hd8 C;
    public ArrayList<PostData> D;
    public ArrayList<Cdo> E;
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
    public TbRichTextView.a0 V;
    public View.OnClickListener W;
    public je8 X;
    public View.OnLongClickListener Y;
    public SortSwitchButton.f Z;
    public PbFragment a;
    public final List<qn> a0;
    public BdTypeListView b;
    public final List<qn> b0;
    public cg8 c;
    public Runnable c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public th8 g;
    public ThreadData g0;
    public bh8 h;
    public List<PostData> h0;
    public pg8 i;
    public final CustomMessageListener i0;
    public bh8 j;
    public CustomMessageListener j0;
    public wf8 k;
    public final CustomMessageListener k0;
    public fh8 l;
    public final View.OnClickListener l0;
    public kk8 m;
    public CustomMessageListener m0;
    public tg6 n;
    public List<qn> n0;
    public qn o;
    public qn p;
    public qn q;
    public qn r;
    public qn s;
    public xg8 t;
    public zg8 u;
    public wg8 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<we8> x;
    public tf8 y;
    public jg8 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf8 a;

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
        public c(sf8 sf8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf8Var, Integer.valueOf(i)};
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
            this.a = sf8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C != null && !da.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    gh.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ sf8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sf8 sf8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf8Var, Integer.valueOf(i)};
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
            this.a = sf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof u59)) {
                u59 u59Var = (u59) customResponsedMessage.getData();
                if (this.a.g0 != null && this.a.g0.funAdData == u59Var) {
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
        public final /* synthetic */ sf8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sf8 sf8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf8Var, Integer.valueOf(i)};
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
            this.a = sf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof l59)) {
                AbsDelegateAdapterList a = ((l59) customResponsedMessage.getData()).a();
                Iterator<qn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    qn<?, ?> next = it.next();
                    if (next instanceof yf8) {
                        ((yf8) next).t(this.a.a);
                        if (next instanceof we8) {
                            this.a.x.add((we8) next);
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
        public final /* synthetic */ sf8 a;

        public d(sf8 sf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.C != null && this.a.C.V() != null) {
                this.a.a.K5().b1().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ sf8 b;

        public e(sf8 sf8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sf8Var;
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
        public final /* synthetic */ sf8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sf8 sf8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf8Var, Integer.valueOf(i)};
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
            this.a = sf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.n0)) {
                this.a.n();
                sf8 sf8Var = this.a;
                sf8Var.h0(sf8Var.C, false);
            }
        }
    }

    public sf8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.O = ej.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.k0);
        this.e0 = ej.j(this.a.getContext()) / 3;
    }

    public void A0(je8 je8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je8Var) == null) {
            this.X = je8Var;
        }
    }

    public void d0(boolean z) {
        cg8 cg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (cg8Var = this.c) != null) {
            cg8Var.T(z);
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

    public final PostData q(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, hd8Var)) == null) {
            if (hd8Var != null && hd8Var.W() != null) {
                PostData W = hd8Var.W();
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
        wf8 wf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && (wf8Var = this.k) != null) {
            wf8Var.u0(z);
        }
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.S = onClickListener;
        }
    }

    public void v0(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, a0Var) == null) {
            this.V = a0Var;
        }
    }

    public void w0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.Y = onLongClickListener;
        }
    }

    public Cdo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            return this.b.G(i);
        }
        return (Cdo) invokeI.objValue;
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

    public final int A(hd8 hd8Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hd8Var, arrayList)) == null) {
            if (hd8Var == null || ListUtils.isEmpty(hd8Var.H()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(hd8Var.H(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    Cdo cdo = arrayList.get(i);
                    if (cdo instanceof PostData) {
                        PostData postData = (PostData) cdo;
                        if (postData.F() == 1 && postData.O == 0) {
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

    public final int F(hd8 hd8Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, hd8Var, arrayList)) == null) {
            int i = -1;
            if (hd8Var == null || hd8Var.z() == null) {
                return -1;
            }
            int i2 = 0;
            if (hd8Var.z().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof ud8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (hd8Var.N() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<Cdo> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = x75.i();
        int j = x75.j() - 1;
        if (bool.booleanValue()) {
            Cdo cdo = arrayList.get(0);
            if ((cdo instanceof PostData) && ((PostData) cdo).F() == 1) {
                j++;
            }
        }
        int k = x75.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.M() != null && this.a.M().C1() == 3) {
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
                    Cdo cdo = this.b.getData().get(i);
                    if (cdo != null && cdo.getType() == ud8.i) {
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
            gh.a().removeCallbacks(this.c0);
            bh8 bh8Var = this.h;
            if (bh8Var != null) {
                bh8Var.onDestroy();
            }
            bh8 bh8Var2 = this.j;
            if (bh8Var2 != null) {
                bh8Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            th8 th8Var = this.g;
            if (th8Var != null) {
                th8Var.onDestroy();
            }
            my5.k().q(false);
        }
    }

    public void B0() {
        pg8 pg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pg8Var = this.i) != null) {
            pg8Var.x(2);
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
            if (this.b.getAdapter2() instanceof un) {
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

    public ArrayList<Cdo> t() {
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

    public int C(hd8 hd8Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, hd8Var, arrayList, z)) == null) {
            if (hd8Var == null || hd8Var.H() == null || hd8Var.E() == null || hd8Var.H().size() == 0 || hd8Var.Q() == null || arrayList == null || !hd8Var.E().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (hd8Var.H().get(0) == null || hd8Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (hd8Var.z() == null || hd8Var.z().a() != hd8Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(hd8 hd8Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, hd8Var, arrayList, z)) == null) {
            if (hd8Var == null || hd8Var.H() == null || hd8Var.F() == null || hd8Var.H().size() == 0 || hd8Var.Q() == null || arrayList == null || !hd8Var.F().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (hd8Var.H().get(0) == null || hd8Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (hd8Var.z() == null || hd8Var.z().a() != hd8Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final Cdo R(hd8 hd8Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        jd8 jd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, hd8Var, arrayList, i)) == null) {
            if (hd8Var.l() != null && !StringUtils.isNull(hd8Var.l().getName())) {
                if (!TextUtils.equals(hd8Var.l().getName(), this.a.M().R0()) || !this.a.M().X0()) {
                    if (!this.a.v0() && !ListUtils.isEmpty(hd8Var.p())) {
                        jd8Var = new jd8(hd8Var.p().get(0));
                    } else {
                        jd8Var = new jd8(hd8Var.l());
                    }
                    jd8Var.g = this.a.M().M1();
                    ListUtils.add(arrayList, i + 1, jd8Var);
                    return jd8Var;
                }
                return null;
            }
            return null;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) {
            if (this.a.M() != null && postData != null && postData.O() != null && postData.O().equals(this.a.M().S1())) {
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
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof yv8)) {
                ((yv8) qnVar).setIsFromCDN(z);
            }
            Iterator<we8> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final PostData p(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.F() == 1) {
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
            wf8 wf8Var = this.k;
            if (wf8Var != null) {
                wf8Var.v0(z);
            }
            bh8 bh8Var = this.h;
            if (bh8Var != null) {
                bh8Var.y(z);
            }
            qn qnVar = this.s;
            if (qnVar != null) {
                qnVar.setMulDel(z);
            }
            qn qnVar2 = this.p;
            if (qnVar2 != null) {
                qnVar2.setMulDel(z);
            }
            cg8 cg8Var = this.c;
            if (cg8Var != null) {
                cg8Var.setMulDel(z);
            }
        }
    }

    public final void D0() {
        hd8 hd8Var;
        v59 v59Var;
        v59 v59Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (hd8Var = this.C) == null || hd8Var.c0 || hd8Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = hd8Var.H();
        ArrayList<v59> e2 = this.C.e();
        if (!ry7.e(H) && !ry7.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<v59> it = e2.iterator();
            while (it.hasNext()) {
                v59 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<v59> it2 = e2.iterator();
            while (it2.hasNext()) {
                v59 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<v59> it3 = e2.iterator();
            while (it3.hasNext()) {
                v59 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int l = next3.getAdvertAppInfo().l();
                    if (l != 0) {
                        px8.j(next3, l);
                        if (l != 28 && l != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            e2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                v59 v59Var3 = (v59) sparseArray.valueAt(i);
                if (v59Var3 != null && (v59Var2 = (v59) hashMap.put(v59Var3.p1(), v59Var3)) != null) {
                    px8.j(v59Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (v59Var = (v59) entry.getValue()) != null) {
                    sparseArray.put(v59Var.getPosition(), v59Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                ry7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < ry7.i(arrayList); i4++) {
                v59 v59Var4 = (v59) sparseArray.get(((Integer) ry7.d(arrayList, i4)).intValue());
                if (this.C.l() != null) {
                    v59Var4.b1 = this.C.l().getId();
                }
                if (this.C.Q() != null) {
                    v59Var4.e1 = dh.g(this.C.Q().getId(), 0L);
                }
                hd8 hd8Var2 = this.C;
                if (hd8Var2 != null && hd8Var2.z() != null) {
                    v59Var4.f1 = this.C.z().a();
                }
                l(v59Var4);
                int position = v59Var4.getPosition() + this.C.b0;
                if (position >= ry7.i(H)) {
                    v59Var4.h1 = position;
                    px8.k(v59Var4, 2, position, ry7.i(H));
                    return;
                }
                if (!this.I) {
                    position--;
                    v59Var4.h1 = position;
                }
                if (position < 0) {
                    px8.j(v59Var4, 23);
                } else {
                    v59Var4.i1 = i3;
                    ry7.b(H, v59Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", v59Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int E(hd8 hd8Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, hd8Var, arrayList, z)) == null) {
            if (hd8Var != null && !ListUtils.isEmpty(hd8Var.H()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (hd8Var.H().get(0) == null || hd8Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (hd8Var == null || !hd8Var.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void U(hd8 hd8Var, ArrayList<Cdo> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, hd8Var, arrayList, i) == null) {
            ud8 ud8Var = new ud8(ud8.i);
            ThreadData Q = hd8Var.Q();
            if (Q != null) {
                Q.getReply_num();
            }
            ud8Var.d = this.a.f6();
            ud8Var.c = hd8Var.g;
            hd8Var.c();
            ud8Var.e = hd8Var.l0();
            ud8Var.g = hd8Var.f;
            if (Q != null && Q.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            ud8Var.h = z;
            ListUtils.add(arrayList, i, ud8Var);
            if (hd8Var.N() == 4) {
                ListUtils.add(arrayList, i + 1, new td8());
            }
        }
    }

    public final ArrayList<Cdo> H(List<Cdo> list, List<Cdo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, list, list2)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            nd8 nd8Var = new nd8();
            PbListView f1 = this.a.K5().f1();
            if (f1 != null && f1.p()) {
                nd8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eba);
                nd8Var.b = true;
            } else {
                nd8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                nd8Var.b = false;
            }
            arrayList.add(nd8Var);
            wg6 wg6Var = new wg6();
            wg6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            wg6Var.needTopMargin = false;
            arrayList.add(wg6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final Cdo P(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        hd8 hd8Var;
        u59 u59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (hd8Var = this.C) != null && hd8Var.u0()) {
                String d2 = g97.e().d("pb_banner");
                if (this.g0 == null && a97.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.g0 = threadData;
                    threadData.funAdData = new u59();
                    hd8 hd8Var2 = this.C;
                    if (hd8Var2 != null) {
                        this.g0.funAdData.m(hd8Var2.m());
                        this.g0.funAdData.r(this.C.S());
                    }
                }
                ThreadData threadData2 = this.g0;
                if (threadData2 != null && (u59Var = threadData2.funAdData) != null) {
                    u59Var.j(1);
                    my5.k().q(true);
                    ListUtils.add(arrayList, i, this.g0);
                    if (ez5.i().q()) {
                        ez5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.g0;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final int u(hd8 hd8Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, hd8Var, arrayList)) == null) {
            if (!this.K && hd8Var != null && !ListUtils.isEmpty(hd8Var.H()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.M() != null && this.a.M().b1()) {
                    return -1;
                }
                if (this.a.K5() != null && this.a.K5().X0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        Cdo cdo = arrayList.get(i);
                        if (cdo instanceof PostData) {
                            PostData postData = (PostData) cdo;
                            if (postData.F() == 1 && postData.O == 0) {
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
                    if (hd8Var.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (hd8Var != null && hd8Var.y0() && this.I) {
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
            cg8 cg8Var = this.c;
            if (cg8Var != null && cg8Var.O() != null) {
                if (this.c.O().A != null && this.c.O().A.isShown()) {
                    return this.c.O().A;
                }
                return this.c.O().z;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f0() {
        PostData postData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.C != null && (postData = this.Q) != null && postData.W() != null && this.c.O() != null) {
            String S = this.C.S();
            String m = this.C.m();
            if (this.C.Q() != null) {
                i = this.C.Q().getThreadType();
            } else {
                i = 0;
            }
            xk5.a().c(S, m, this.Q.W(), this.c.O().t, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbFragment, bdTypeListView) == null) {
            cg8 cg8Var = new cg8(pbFragment, PostData.P0);
            this.c = cg8Var;
            cg8Var.e0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, vd8.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, jd8.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), kd8.c);
            this.g = new th8(pbFragment, cd8.c);
            this.h = new bh8(pbFragment, ud8.i);
            this.i = new pg8(pbFragment, pd8.c);
            this.j = new bh8(pbFragment, ud8.j);
            wf8 wf8Var = new wf8(pbFragment, PostData.Q0);
            this.k = wf8Var;
            wf8Var.x0(pbFragment);
            fh8 fh8Var = new fh8(pbFragment, PostData.R0);
            this.l = fh8Var;
            fh8Var.t0(pbFragment);
            this.o = cw8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = cw8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = b97.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = b97.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = b97.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new wg8(pbFragment, rd8.f1);
            this.t = new xg8(pbFragment, vg8.c1);
            this.u = new zg8(pbFragment, e05.i1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.X0);
            this.m = new kk8(pbFragment, lk8.a);
            this.n = new tg6(pbFragment.getPageContext());
            this.y = new tf8(pbFragment, qy4.e);
            this.z = new jg8(pbFragment, pbFragment.getUniqueId());
            this.A = new vh8(pbFragment.getPageContext(), jz5.g);
            xe8 xe8Var = new xe8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.B = xe8Var;
            this.a0.addAll(xe8Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new l59(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.a0);
        }
    }

    public final void L(@NonNull hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hd8Var) == null) {
            this.c.r(hd8Var);
            this.c.setFromCDN(this.F);
            this.c.l(this.O);
            this.c.c(this.H);
            this.c.e(this.T);
            this.c.k(this.S);
            this.c.n(this.V);
            this.c.d(this.Y);
            this.c.b0(this.W);
            this.c.d0(this.X);
            this.f.w(this.W);
            this.k.r(hd8Var);
            this.k.setFromCDN(this.F);
            this.k.o(this.P);
            this.k.c(this.H);
            this.k.e(this.T);
            this.k.k(this.S);
            this.k.n(this.V);
            this.k.d(this.Y);
            this.k.w0(this.X);
            this.l.r(hd8Var);
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
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof yv8)) {
                ((yv8) qnVar).setIsFromCDN(this.F);
            }
            Iterator<we8> it = this.x.iterator();
            while (it.hasNext()) {
                we8 next = it.next();
                if (next != null) {
                    next.r(hd8Var);
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
            this.h.r(hd8Var);
            this.g.r(hd8Var);
            this.j.r(hd8Var);
            this.t.r(hd8Var);
            this.u.r(hd8Var);
            this.y.y(hd8Var);
            this.y.x(this.a.r1);
            this.z.w(hd8Var);
            this.B.f(hd8Var);
        }
    }

    public final Cdo M(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, arrayList, i)) == null) {
            if (this.C == null) {
                return null;
            }
            v59 L0 = this.a.M().L0();
            if (L0 == null) {
                L0 = this.C.A();
            }
            if (L0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert s1 = L0.s1();
            if (s1 != null) {
                s1.setAdvertAppInfo(L0.getAdvertAppInfo());
            }
            int l = L0.getAdvertAppInfo().l();
            if (l != 0) {
                px8.j(L0, l);
                if (l != 28 && l != 31) {
                    L0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.C.l() != null) {
                L0.b1 = this.C.l().getId();
            }
            if (this.C.Q() != null) {
                L0.e1 = dh.g(this.C.Q().getId(), 0L);
            }
            hd8 hd8Var = this.C;
            if (hd8Var != null && hd8Var.z() != null) {
                L0.f1 = this.C.z().a();
            }
            l(L0);
            if (i < 0) {
                return null;
            }
            L0.i1 = 1;
            my5.k().q(true);
            ry7.b(arrayList, L0, i);
            if (ez5.i().q()) {
                ez5.i().n(arrayList, i + 1, 4);
            }
            return L0;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final boolean N(hd8 hd8Var, ArrayList<Cdo> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{hd8Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(hd8Var.f()) && hd8Var.f().size() > 2) {
                int min = Math.min(hd8Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    qy4 qy4Var = hd8Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        qy4Var.l(true);
                    }
                    if (qy4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            qy4Var.o(true);
                        }
                    } else if (i6 == min - 2) {
                        qy4Var.o(true);
                    } else if (i6 == min - 1) {
                        qy4Var.n(true);
                    }
                    arrayList2.add(qy4Var);
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

    public final Cdo O(hd8 hd8Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        cd8 cd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, hd8Var, arrayList, i)) == null) {
            if (i >= 0 && hd8Var != null && hd8Var.k && (cd8Var = hd8Var.l) != null) {
                ListUtils.add(arrayList, i, cd8Var);
                return cd8Var;
            }
            return null;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final void W(PostData postData, ArrayList<Cdo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, postData, arrayList, i) == null) {
            postData.h1(true);
            arrayList.add(i, postData);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<Cdo> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<Cdo> listIterator = arrayList.listIterator();
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
                        u59 u59Var = new u59();
                        hd8 hd8Var = this.C;
                        if (hd8Var == null) {
                            str3 = "";
                        } else {
                            str3 = hd8Var.m();
                        }
                        u59Var.m(str3);
                        hd8 hd8Var2 = this.C;
                        if (hd8Var2 != null) {
                            str = hd8Var2.S();
                        }
                        u59Var.r(str);
                        u59Var.n(true);
                        postData.w0 = u59Var;
                        u59Var.j(i7);
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
            if (i6 > 0 && ez5.i().q()) {
                ez5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                PostData postData2 = new PostData();
                u59 u59Var2 = new u59();
                hd8 hd8Var3 = this.C;
                if (hd8Var3 == null) {
                    str2 = "";
                } else {
                    str2 = hd8Var3.m();
                }
                u59Var2.m(str2);
                hd8 hd8Var4 = this.C;
                if (hd8Var4 != null) {
                    str = hd8Var4.S();
                }
                u59Var2.r(str);
                u59Var2.n(true);
                postData2.w0 = u59Var2;
                u59Var2.j(1);
                listIterator.add(postData2);
                this.h0.add(postData2);
                if (ez5.i().q()) {
                    ez5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final Cdo S(hd8 hd8Var, PostData postData, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048599, this, hd8Var, postData, arrayList, i)) == null) {
            kd8 kd8Var = null;
            if (hd8Var.l() != null && !StringUtils.isNull(hd8Var.l().getName()) && TextUtils.equals(hd8Var.l().getName(), this.a.M().R0()) && this.a.M().X0()) {
                return null;
            }
            if (postData != null) {
                if (postData.r0 != null) {
                    kd8Var = new kd8(postData.r0);
                }
            } else {
                PostData postData2 = this.Q;
                if (postData2 != null && postData2.r0 != null) {
                    kd8Var = new kd8(this.Q.r0);
                }
            }
            if (kd8Var != null) {
                kd8Var.b = this.a.M().M1();
                ListUtils.add(arrayList, i + 1, kd8Var);
            }
            return kd8Var;
        }
        return (Cdo) invokeLLLI.objValue;
    }

    public final kg8 T(ArrayList<Cdo> arrayList, Cdo cdo, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, arrayList, cdo, i, i2)) == null) {
            kg8 C = this.C.C();
            if (C != null) {
                if (cdo != null) {
                    if (i2 < 0 && cdo.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (cdo.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (C instanceof kg8)) {
                    ListUtils.add(arrayList, i2, C);
                    return C;
                }
                return null;
            }
            return null;
        }
        return (kg8) invokeLLII.objValue;
    }

    public final Cdo V(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, arrayList, i)) == null) {
            if (i < 0 || (M = this.a.M()) == null || TextUtils.isEmpty(M.w1())) {
                return null;
            }
            v59 v59Var = new v59();
            l(v59Var);
            ListUtils.add(arrayList, i + 1, v59Var);
            return v59Var;
        }
        return (Cdo) invokeLI.objValue;
    }

    public void b0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.K5() != null) {
            this.a.K5().g2(z, i);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        cg8 cg8Var = this.c;
                        if (cg8Var != null) {
                            cg8Var.V();
                        }
                        qn qnVar = this.p;
                        if (qnVar instanceof tv8) {
                            ((tv8) qnVar).onDestroy();
                        }
                        qn qnVar2 = this.q;
                        if (qnVar2 instanceof tv8) {
                            ((tv8) qnVar2).onDestroy();
                        }
                        qn qnVar3 = this.s;
                        if (qnVar3 instanceof tv8) {
                            ((tv8) qnVar3).onDestroy();
                        }
                        xf8.a().d();
                        return;
                    }
                    return;
                }
                cg8 cg8Var2 = this.c;
                if (cg8Var2 != null) {
                    cg8Var2.W();
                }
                qn qnVar4 = this.p;
                if (qnVar4 instanceof tv8) {
                    ((tv8) qnVar4).onResume();
                }
                qn qnVar5 = this.q;
                if (qnVar5 instanceof tv8) {
                    ((tv8) qnVar5).onResume();
                }
                qn qnVar6 = this.s;
                if (qnVar6 instanceof tv8) {
                    ((tv8) qnVar6).onResume();
                }
                g0(false);
                f0();
                return;
            }
            cg8 cg8Var3 = this.c;
            if (cg8Var3 != null) {
                cg8Var3.U();
            }
            qn qnVar7 = this.p;
            if (qnVar7 instanceof tv8) {
                ((tv8) qnVar7).onPause();
            }
            qn qnVar8 = this.q;
            if (qnVar8 instanceof tv8) {
                ((tv8) qnVar8).onPause();
            }
            qn qnVar9 = this.s;
            if (qnVar9 instanceof tv8) {
                ((tv8) qnVar9).onPause();
            }
            xf8.a().j(this.a.N());
            xk5.a().d();
        }
    }

    public final void l(v59 v59Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, v59Var) == null) && v59Var != null && this.C != null && v59Var.getAdvertAppInfo() != null) {
            v59Var.getAdvertAppInfo().i = new ey4();
            if (this.C.z() != null) {
                v59Var.getAdvertAppInfo().i.b = this.C.z().a();
            }
            v59Var.getAdvertAppInfo().i.a = v59Var.r1();
            if (this.C.l() != null && (l = this.C.l()) != null) {
                v59Var.getAdvertAppInfo().i.c = l.getId();
                v59Var.getAdvertAppInfo().i.d = l.getFirst_class();
                v59Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                v59Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            v59Var.getAdvertAppInfo().i.g = v59Var.getAdvertAppInfo().g;
            v59Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<Cdo> v(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, hd8Var)) == null) {
            if (hd8Var == null || hd8Var.V() == null || ListUtils.isEmpty(hd8Var.V().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = hd8Var.V().a;
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
            if (ListUtils.getCount(hd8Var.V().b) > 2) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo instanceof PostData) {
                    ((PostData) cdo).P = false;
                }
                arrayList.add(new lk8());
            } else {
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo2 instanceof PostData) {
                    ((PostData) cdo2).P = true;
                }
            }
            ud8 ud8Var = new ud8(ud8.j);
            ud8Var.a = hd8Var.V().c;
            arrayList.add(0, ud8Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void e0(boolean z, boolean z2, int i, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.L || this.K) && i != -1 && !ListUtils.isEmpty(list) && !this.M) {
                this.c0 = new e(this, list);
                gh.a().post(this.c0);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && this.a.K5() != null && this.a.N() != null && this.a.N().H1() != null) {
            xf8.a().g(this.a.N().H1().g2(), this.h.v(), this.a.K5().h1(), this.a.N().getPageStayDurationItem(), z, this.B.b(), this.a.getListView());
        }
    }

    public final void o(List<Cdo> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof PostData) {
                    if (i == 0 && (list.get(i2) instanceof v59)) {
                        i = i2 + 1;
                    }
                    PostData postData = (PostData) list.get(i2);
                    if (!TextUtils.isEmpty(postData.U())) {
                        pz4 pz4Var = new pz4();
                        pz4Var.g(postData.U());
                        list.set(i2, pz4Var);
                    }
                }
            }
            if (i > 0 && ez5.i().q()) {
                ez5.i().n(list, i, 5);
            }
        }
    }

    public void h0(hd8 hd8Var, boolean z) {
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
        kg8 kg8Var;
        List<Cdo> list;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        Cdo cdo;
        int i5;
        boolean z13;
        PostData postData3;
        PostData postData4;
        PostData postData5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048614, this, hd8Var, z) != null) || hd8Var == null) {
            return;
        }
        this.C = hd8Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.clear();
        hd8 hd8Var2 = this.C;
        if (hd8Var2 != null && hd8Var2.H() != null && this.C.H().size() > 0) {
            this.D.addAll(this.C.H());
        }
        if (hd8Var.Q() != null && hd8Var.Q().getAuthor() != null) {
            this.P = hd8Var.Q().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(hd8Var);
        ArrayList<Cdo> arrayList = new ArrayList<>(hd8Var.H());
        PostData p = p(arrayList);
        if (this.C.Q().isQuestionThread()) {
            postData = q(hd8Var);
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
        if (!h97.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.C.u0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.Q = p;
        }
        if (!this.I && p != null) {
            arrayList.remove(p);
            if (hd8Var.y0() && p.Z() != null) {
                p.b1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && hd8Var.j() != null) {
            PostData j = hd8Var.j();
            if (!this.I && hd8Var.y0() && j.Z() != null) {
                j.b1(null);
            }
            if (!this.I && (postData5 = this.Q) != null && j.i0 == null) {
                hd8Var.H0(postData5);
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
        if (this.a.B5()) {
            if (hd8Var.H().size() > 0 && (postData4 = hd8Var.H().get(0)) != null && postData4.F() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        v49.f(arrayList, 1);
        int A = A(hd8Var, arrayList);
        if (A >= 0) {
            U(hd8Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(hd8Var, arrayList);
        if (F >= 0) {
            pd8 pd8Var = new pd8(pd8.c);
            pd8Var.b(true);
            ListUtils.add(arrayList, F, pd8Var);
        }
        int u = u(hd8Var, arrayList);
        List<Cdo> v = v(hd8Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, u);
            if (cdo2 instanceof PostData) {
                ((PostData) cdo2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(hd8Var, arrayList, this.I);
        } else {
            i = -1;
        }
        if (i >= 0 && hd8Var.U() != null) {
            PostData Z = hd8Var.Z();
            ThreadData c2 = hd8Var.U().c();
            if (Z != null && Z.o0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure o0 = Z.o0();
                VirtualImageCustomState p0 = Z.p0();
                c2.setCustomFigure(o0);
                c2.setCustomState(p0);
            }
            ListUtils.add(arrayList, i, hd8Var.U());
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
        if (S(hd8Var, postData2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && R(hd8Var, arrayList, i) != null) {
            i++;
        }
        if (O(hd8Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            Cdo V = V(arrayList, i);
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
                cdo = M(arrayList, i5);
                if (cdo != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = z11;
                cdo = V;
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
                kg8Var = null;
            } else {
                kg8 T = T(arrayList, cdo, i, i5);
                if (T != null) {
                    if (!z12) {
                        kg8Var = T;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                kg8Var = T;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            kg8Var = null;
        }
        if (z2) {
            if (kg8Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean N = N(hd8Var, arrayList, z9, z10, i3, i6, u, A);
            if (kg8Var != null) {
                kg8Var.n = N;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.c0(!z6);
        boolean C0 = C0(postData2);
        if (this.J && !C0) {
            arrayList.remove(postData2);
            this.J = false;
        }
        if (hd8Var.U() != null) {
            hd8Var.U().i(!z7);
        }
        if (this.b != null) {
            this.E = arrayList;
            List<Cdo> T2 = hd8Var.T();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setData(H(arrayList, T2));
            } else {
                this.b.setData(this.E);
            }
        }
        e0(C0, z, i4, list);
        if (r(postData2, arrayList, z4)) {
            List<Cdo> T3 = hd8Var.T();
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
            ArrayList<BdUniqueId> g = v49.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                jy7 b2 = oz7.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public final boolean r(PostData postData, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, postData, arrayList, z)) == null) {
            if (postData == null) {
                PostData postData2 = this.Q;
                if (postData2 != null && !this.K) {
                    ListUtils.add(arrayList, 0, postData2);
                } else {
                    PostData postData3 = new PostData();
                    postData3.J0(1);
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
