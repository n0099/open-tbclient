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
public class t28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w48 A;
    public y18 B;
    public i08 C;
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
    public k18 X;
    public View.OnLongClickListener Y;
    public SortSwitchButton.f Z;
    public PbFragment a;
    public final List<kn> a0;
    public BdTypeListView b;
    public final List<kn> b0;
    public d38 c;
    public Runnable c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public u48 g;
    public ThreadData g0;
    public c48 h;
    public List<PostData> h0;
    public q38 i;
    public final CustomMessageListener i0;
    public c48 j;
    public CustomMessageListener j0;
    public x28 k;
    public final CustomMessageListener k0;
    public g48 l;
    public final View.OnClickListener l0;
    public k78 m;
    public CustomMessageListener m0;
    public d66 n;
    public List<kn> n0;
    public kn o;
    public kn p;
    public kn q;
    public kn r;
    public kn s;
    public y38 t;
    public a48 u;
    public x38 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<x18> x;
    public u28 y;
    public k38 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

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
        public c(t28 t28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, Integer.valueOf(i)};
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
            this.a = t28Var;
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
        public final /* synthetic */ t28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t28 t28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, Integer.valueOf(i)};
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
            this.a = t28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ks8)) {
                ks8 ks8Var = (ks8) customResponsedMessage.getData();
                if (this.a.g0 != null && this.a.g0.funAdData == ks8Var) {
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
        public final /* synthetic */ t28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t28 t28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, Integer.valueOf(i)};
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
            this.a = t28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof bs8)) {
                AbsDelegateAdapterList a = ((bs8) customResponsedMessage.getData()).a();
                Iterator<kn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    kn<?, ?> next = it.next();
                    if (next instanceof z28) {
                        ((z28) next).t(this.a.a);
                        if (next instanceof x18) {
                            this.a.x.add((x18) next);
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
        public final /* synthetic */ t28 a;

        public d(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.C != null && this.a.C.V() != null) {
                this.a.a.F5().V0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ t28 b;

        public e(t28 t28Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
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
        public final /* synthetic */ t28 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(t28 t28Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, Integer.valueOf(i)};
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
            this.a = t28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.n0)) {
                this.a.n();
                t28 t28Var = this.a;
                t28Var.h0(t28Var.C, false);
            }
        }
    }

    public t28(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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

    public void A0(k18 k18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k18Var) == null) {
            this.X = k18Var;
        }
    }

    public void d0(boolean z) {
        d38 d38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (d38Var = this.c) != null) {
            d38Var.T(z);
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

    public final PostData q(i08 i08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, i08Var)) == null) {
            if (i08Var != null && i08Var.W() != null) {
                PostData W = i08Var.W();
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
        x28 x28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && (x28Var = this.k) != null) {
            x28Var.u0(z);
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

    public final int A(i08 i08Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, i08Var, arrayList)) == null) {
            if (i08Var == null || ListUtils.isEmpty(i08Var.H()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(i08Var.H(), 0)) == null) {
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

    public final int F(i08 i08Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, i08Var, arrayList)) == null) {
            int i = -1;
            if (i08Var == null || i08Var.z() == null) {
                return -1;
            }
            int i2 = 0;
            if (i08Var.z().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof v08) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (i08Var.N() == 4) {
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
        int i = n15.i();
        int j = n15.j() - 1;
        if (bool.booleanValue()) {
            xn xnVar = arrayList.get(0);
            if ((xnVar instanceof PostData) && ((PostData) xnVar).D() == 1) {
                j++;
            }
        }
        int k = n15.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.M() != null && this.a.M().v1() == 3) {
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
                    if (xnVar != null && xnVar.getType() == v08.i) {
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
            c48 c48Var = this.h;
            if (c48Var != null) {
                c48Var.onDestroy();
            }
            c48 c48Var2 = this.j;
            if (c48Var2 != null) {
                c48Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            u48 u48Var = this.g;
            if (u48Var != null) {
                u48Var.onDestroy();
            }
            pr5.k().q(false);
        }
    }

    public void B0() {
        q38 q38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (q38Var = this.i) != null) {
            q38Var.x(2);
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

    public int C(i08 i08Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, i08Var, arrayList, z)) == null) {
            if (i08Var == null || i08Var.H() == null || i08Var.E() == null || i08Var.H().size() == 0 || i08Var.Q() == null || arrayList == null || !i08Var.E().m1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (i08Var.H().get(0) == null || i08Var.H().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (i08Var.z() == null || i08Var.z().a() != i08Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(i08 i08Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, i08Var, arrayList, z)) == null) {
            if (i08Var == null || i08Var.H() == null || i08Var.F() == null || i08Var.H().size() == 0 || i08Var.Q() == null || arrayList == null || !i08Var.F().m1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (i08Var.H().get(0) == null || i08Var.H().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (i08Var.z() == null || i08Var.z().a() != i08Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final xn R(i08 i08Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        k08 k08Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, i08Var, arrayList, i)) == null) {
            if (i08Var.l() != null && !StringUtils.isNull(i08Var.l().getName())) {
                if (!TextUtils.equals(i08Var.l().getName(), this.a.M().K0()) || !this.a.M().Q0()) {
                    if (!this.a.s0() && !ListUtils.isEmpty(i08Var.p())) {
                        k08Var = new k08(i08Var.p().get(0));
                    } else {
                        k08Var = new k08(i08Var.l());
                    }
                    k08Var.g = this.a.M().F1();
                    ListUtils.add(arrayList, i + 1, k08Var);
                    return k08Var;
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
            if (this.a.M() != null && postData != null && postData.M() != null && postData.M().equals(this.a.M().L1())) {
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
            if (knVar != null && (knVar instanceof wi8)) {
                ((wi8) knVar).setIsFromCDN(z);
            }
            Iterator<x18> it = this.x.iterator();
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
            x28 x28Var = this.k;
            if (x28Var != null) {
                x28Var.v0(z);
            }
            c48 c48Var = this.h;
            if (c48Var != null) {
                c48Var.y(z);
            }
            kn knVar = this.s;
            if (knVar != null) {
                knVar.setMulDel(z);
            }
            kn knVar2 = this.p;
            if (knVar2 != null) {
                knVar2.setMulDel(z);
            }
            d38 d38Var = this.c;
            if (d38Var != null) {
                d38Var.setMulDel(z);
            }
        }
    }

    public final void D0() {
        i08 i08Var;
        ls8 ls8Var;
        ls8 ls8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (i08Var = this.C) == null || i08Var.c0 || i08Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = i08Var.H();
        ArrayList<ls8> e2 = this.C.e();
        if (!fm7.e(H) && !fm7.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<ls8> it = e2.iterator();
            while (it.hasNext()) {
                ls8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ls8> it2 = e2.iterator();
            while (it2.hasNext()) {
                ls8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ls8> it3 = e2.iterator();
            while (it3.hasNext()) {
                ls8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        nk8.j(next3, m);
                        if (m != 28 && m != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            e2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                ls8 ls8Var3 = (ls8) sparseArray.valueAt(i);
                if (ls8Var3 != null && (ls8Var2 = (ls8) hashMap.put(ls8Var3.m1(), ls8Var3)) != null) {
                    nk8.j(ls8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (ls8Var = (ls8) entry.getValue()) != null) {
                    sparseArray.put(ls8Var.getPosition(), ls8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                fm7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < fm7.i(arrayList); i4++) {
                ls8 ls8Var4 = (ls8) sparseArray.get(((Integer) fm7.d(arrayList, i4)).intValue());
                if (this.C.l() != null) {
                    ls8Var4.Y0 = this.C.l().getId();
                }
                if (this.C.Q() != null) {
                    ls8Var4.b1 = xg.g(this.C.Q().getId(), 0L);
                }
                i08 i08Var2 = this.C;
                if (i08Var2 != null && i08Var2.z() != null) {
                    ls8Var4.c1 = this.C.z().a();
                }
                l(ls8Var4);
                int position = ls8Var4.getPosition() + this.C.b0;
                if (position >= fm7.i(H)) {
                    ls8Var4.e1 = position;
                    nk8.k(ls8Var4, 2, position, fm7.i(H));
                    return;
                }
                if (!this.I) {
                    position--;
                    ls8Var4.e1 = position;
                }
                if (position < 0) {
                    nk8.j(ls8Var4, 23);
                } else {
                    ls8Var4.f1 = i3;
                    fm7.b(H, ls8Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ls8Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int E(i08 i08Var, ArrayList<xn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, i08Var, arrayList, z)) == null) {
            if (i08Var != null && !ListUtils.isEmpty(i08Var.H()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (i08Var.H().get(0) == null || i08Var.H().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (i08Var == null || !i08Var.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void U(i08 i08Var, ArrayList<xn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, i08Var, arrayList, i) == null) {
            v08 v08Var = new v08(v08.i);
            ThreadData Q = i08Var.Q();
            if (Q != null) {
                Q.getReply_num();
            }
            v08Var.d = this.a.a6();
            v08Var.c = i08Var.g;
            i08Var.c();
            v08Var.e = i08Var.l0();
            v08Var.g = i08Var.f;
            if (Q != null && Q.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            v08Var.h = z;
            ListUtils.add(arrayList, i, v08Var);
            if (i08Var.N() == 4) {
                ListUtils.add(arrayList, i + 1, new u08());
            }
        }
    }

    public final ArrayList<xn> H(List<xn> list, List<xn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, list, list2)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            o08 o08Var = new o08();
            PbListView Z0 = this.a.F5().Z0();
            if (Z0 != null && Z0.p()) {
                o08Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e60);
                o08Var.b = true;
            } else {
                o08Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                o08Var.b = false;
            }
            arrayList.add(o08Var);
            g66 g66Var = new g66();
            g66Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            g66Var.needTopMargin = false;
            arrayList.add(g66Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final xn P(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        i08 i08Var;
        ks8 ks8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (i08Var = this.C) != null && i08Var.u0()) {
                String d2 = by6.e().d("pb_banner");
                if (this.g0 == null && vx6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.g0 = threadData;
                    threadData.funAdData = new ks8();
                    i08 i08Var2 = this.C;
                    if (i08Var2 != null) {
                        this.g0.funAdData.m(i08Var2.m());
                        this.g0.funAdData.r(this.C.S());
                    }
                }
                ThreadData threadData2 = this.g0;
                if (threadData2 != null && (ks8Var = threadData2.funAdData) != null) {
                    ks8Var.j(1);
                    pr5.k().q(true);
                    ListUtils.add(arrayList, i, this.g0);
                    if (hs5.i().q()) {
                        hs5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.g0;
        }
        return (xn) invokeLI.objValue;
    }

    public final int u(i08 i08Var, ArrayList<xn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, i08Var, arrayList)) == null) {
            if (!this.K && i08Var != null && !ListUtils.isEmpty(i08Var.H()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.M() != null && this.a.M().U0()) {
                    return -1;
                }
                if (this.a.F5() != null && this.a.F5().R0()) {
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
                    if (i08Var.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (i08Var != null && i08Var.y0() && this.I) {
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
            d38 d38Var = this.c;
            if (d38Var != null && d38Var.O() != null) {
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
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.C != null && (postData = this.Q) != null && postData.U() != null && this.c.O() != null) {
            String S = this.C.S();
            String m = this.C.m();
            if (this.C.Q() != null) {
                i = this.C.Q().getThreadType();
            } else {
                i = 0;
            }
            ke5.a().c(S, m, this.Q.U(), this.c.O().t, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbFragment, bdTypeListView) == null) {
            d38 d38Var = new d38(pbFragment, PostData.M0);
            this.c = d38Var;
            d38Var.e0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, w08.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, k08.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), l08.c);
            this.g = new u48(pbFragment, d08.c);
            this.h = new c48(pbFragment, v08.i);
            this.i = new q38(pbFragment, q08.c);
            this.j = new c48(pbFragment, v08.j);
            x28 x28Var = new x28(pbFragment, PostData.N0);
            this.k = x28Var;
            x28Var.x0(pbFragment);
            g48 g48Var = new g48(pbFragment, PostData.O0);
            this.l = g48Var;
            g48Var.t0(pbFragment);
            this.o = aj8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = aj8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = wx6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = wx6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = wx6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new x38(pbFragment, s08.c1);
            this.t = new y38(pbFragment, w38.Z0);
            this.u = new a48(pbFragment, zt4.f1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.U0);
            this.m = new k78(pbFragment, l78.a);
            this.n = new d66(pbFragment.getPageContext());
            this.y = new u28(pbFragment, ms4.e);
            this.z = new k38(pbFragment, pbFragment.getUniqueId());
            this.A = new w48(pbFragment.getPageContext(), ms5.g);
            y18 y18Var = new y18(pbFragment, pbFragment.getUniqueId(), this.b);
            this.B = y18Var;
            this.a0.addAll(y18Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new bs8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.a0);
        }
    }

    public final void L(@NonNull i08 i08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, i08Var) == null) {
            this.c.r(i08Var);
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
            this.k.r(i08Var);
            this.k.setFromCDN(this.F);
            this.k.o(this.P);
            this.k.c(this.H);
            this.k.e(this.T);
            this.k.k(this.S);
            this.k.n(this.V);
            this.k.d(this.Y);
            this.k.w0(this.X);
            this.l.r(i08Var);
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
            if (knVar != null && (knVar instanceof wi8)) {
                ((wi8) knVar).setIsFromCDN(this.F);
            }
            Iterator<x18> it = this.x.iterator();
            while (it.hasNext()) {
                x18 next = it.next();
                if (next != null) {
                    next.r(i08Var);
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
            this.h.r(i08Var);
            this.g.r(i08Var);
            this.j.r(i08Var);
            this.t.r(i08Var);
            this.u.r(i08Var);
            this.y.y(i08Var);
            this.y.x(this.a.r1);
            this.z.w(i08Var);
            this.B.f(i08Var);
        }
    }

    public final xn M(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, arrayList, i)) == null) {
            if (this.C == null) {
                return null;
            }
            ls8 E0 = this.a.M().E0();
            if (E0 == null) {
                E0 = this.C.A();
            }
            if (E0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert p1 = E0.p1();
            if (p1 != null) {
                p1.setAdvertAppInfo(E0.getAdvertAppInfo());
            }
            int m = E0.getAdvertAppInfo().m();
            if (m != 0) {
                nk8.j(E0, m);
                if (m != 28 && m != 31) {
                    E0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.C.l() != null) {
                E0.Y0 = this.C.l().getId();
            }
            if (this.C.Q() != null) {
                E0.b1 = xg.g(this.C.Q().getId(), 0L);
            }
            i08 i08Var = this.C;
            if (i08Var != null && i08Var.z() != null) {
                E0.c1 = this.C.z().a();
            }
            l(E0);
            if (i < 0) {
                return null;
            }
            E0.f1 = 1;
            pr5.k().q(true);
            fm7.b(arrayList, E0, i);
            if (hs5.i().q()) {
                hs5.i().n(arrayList, i + 1, 4);
            }
            return E0;
        }
        return (xn) invokeLI.objValue;
    }

    public final boolean N(i08 i08Var, ArrayList<xn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{i08Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(i08Var.f()) && i08Var.f().size() > 2) {
                int min = Math.min(i08Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    ms4 ms4Var = i08Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        ms4Var.m(true);
                    }
                    if (ms4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            ms4Var.p(true);
                        }
                    } else if (i6 == min - 2) {
                        ms4Var.p(true);
                    } else if (i6 == min - 1) {
                        ms4Var.o(true);
                    }
                    arrayList2.add(ms4Var);
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

    public final xn O(i08 i08Var, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLI;
        d08 d08Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, i08Var, arrayList, i)) == null) {
            if (i >= 0 && i08Var != null && i08Var.k && (d08Var = i08Var.l) != null) {
                ListUtils.add(arrayList, i, d08Var);
                return d08Var;
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
                        ks8 ks8Var = new ks8();
                        i08 i08Var = this.C;
                        if (i08Var == null) {
                            str3 = "";
                        } else {
                            str3 = i08Var.m();
                        }
                        ks8Var.m(str3);
                        i08 i08Var2 = this.C;
                        if (i08Var2 != null) {
                            str = i08Var2.S();
                        }
                        ks8Var.r(str);
                        ks8Var.n(true);
                        postData.v0 = ks8Var;
                        ks8Var.j(i7);
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
            if (i6 > 0 && hs5.i().q()) {
                hs5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                PostData postData2 = new PostData();
                ks8 ks8Var2 = new ks8();
                i08 i08Var3 = this.C;
                if (i08Var3 == null) {
                    str2 = "";
                } else {
                    str2 = i08Var3.m();
                }
                ks8Var2.m(str2);
                i08 i08Var4 = this.C;
                if (i08Var4 != null) {
                    str = i08Var4.S();
                }
                ks8Var2.r(str);
                ks8Var2.n(true);
                postData2.v0 = ks8Var2;
                ks8Var2.j(1);
                listIterator.add(postData2);
                this.h0.add(postData2);
                if (hs5.i().q()) {
                    hs5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final xn S(i08 i08Var, PostData postData, ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048599, this, i08Var, postData, arrayList, i)) == null) {
            l08 l08Var = null;
            if (i08Var.l() != null && !StringUtils.isNull(i08Var.l().getName()) && TextUtils.equals(i08Var.l().getName(), this.a.M().K0()) && this.a.M().Q0()) {
                return null;
            }
            if (postData != null) {
                if (postData.q0 != null) {
                    l08Var = new l08(postData.q0);
                }
            } else {
                PostData postData2 = this.Q;
                if (postData2 != null && postData2.q0 != null) {
                    l08Var = new l08(this.Q.q0);
                }
            }
            if (l08Var != null) {
                l08Var.b = this.a.M().F1();
                ListUtils.add(arrayList, i + 1, l08Var);
            }
            return l08Var;
        }
        return (xn) invokeLLLI.objValue;
    }

    public final l38 T(ArrayList<xn> arrayList, xn xnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, arrayList, xnVar, i, i2)) == null) {
            l38 C = this.C.C();
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
                if (i2 > 0 && (C instanceof l38)) {
                    ListUtils.add(arrayList, i2, C);
                    return C;
                }
                return null;
            }
            return null;
        }
        return (l38) invokeLLII.objValue;
    }

    public final xn V(ArrayList<xn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, arrayList, i)) == null) {
            if (i < 0 || (M = this.a.M()) == null || TextUtils.isEmpty(M.p1())) {
                return null;
            }
            ls8 ls8Var = new ls8();
            l(ls8Var);
            ListUtils.add(arrayList, i + 1, ls8Var);
            return ls8Var;
        }
        return (xn) invokeLI.objValue;
    }

    public void b0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.F5() != null) {
            this.a.F5().Z1(z, i);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        d38 d38Var = this.c;
                        if (d38Var != null) {
                            d38Var.V();
                        }
                        kn knVar = this.p;
                        if (knVar instanceof ri8) {
                            ((ri8) knVar).onDestroy();
                        }
                        kn knVar2 = this.q;
                        if (knVar2 instanceof ri8) {
                            ((ri8) knVar2).onDestroy();
                        }
                        kn knVar3 = this.s;
                        if (knVar3 instanceof ri8) {
                            ((ri8) knVar3).onDestroy();
                        }
                        y28.a().d();
                        return;
                    }
                    return;
                }
                d38 d38Var2 = this.c;
                if (d38Var2 != null) {
                    d38Var2.W();
                }
                kn knVar4 = this.p;
                if (knVar4 instanceof ri8) {
                    ((ri8) knVar4).onResume();
                }
                kn knVar5 = this.q;
                if (knVar5 instanceof ri8) {
                    ((ri8) knVar5).onResume();
                }
                kn knVar6 = this.s;
                if (knVar6 instanceof ri8) {
                    ((ri8) knVar6).onResume();
                }
                g0(false);
                f0();
                return;
            }
            d38 d38Var3 = this.c;
            if (d38Var3 != null) {
                d38Var3.U();
            }
            kn knVar7 = this.p;
            if (knVar7 instanceof ri8) {
                ((ri8) knVar7).onPause();
            }
            kn knVar8 = this.q;
            if (knVar8 instanceof ri8) {
                ((ri8) knVar8).onPause();
            }
            kn knVar9 = this.s;
            if (knVar9 instanceof ri8) {
                ((ri8) knVar9).onPause();
            }
            y28.a().j(this.a.R());
            ke5.a().d();
        }
    }

    public final void l(ls8 ls8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, ls8Var) == null) && ls8Var != null && this.C != null && ls8Var.getAdvertAppInfo() != null) {
            ls8Var.getAdvertAppInfo().i = new as4();
            if (this.C.z() != null) {
                ls8Var.getAdvertAppInfo().i.b = this.C.z().a();
            }
            ls8Var.getAdvertAppInfo().i.a = ls8Var.o1();
            if (this.C.l() != null && (l = this.C.l()) != null) {
                ls8Var.getAdvertAppInfo().i.c = l.getId();
                ls8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ls8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ls8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ls8Var.getAdvertAppInfo().i.g = ls8Var.getAdvertAppInfo().g;
            ls8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<xn> v(i08 i08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, i08Var)) == null) {
            if (i08Var == null || i08Var.V() == null || ListUtils.isEmpty(i08Var.V().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = i08Var.V().a;
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
            if (ListUtils.getCount(i08Var.V().b) > 2) {
                xn xnVar = (xn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (xnVar instanceof PostData) {
                    ((PostData) xnVar).P = false;
                }
                arrayList.add(new l78());
            } else {
                xn xnVar2 = (xn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (xnVar2 instanceof PostData) {
                    ((PostData) xnVar2).P = true;
                }
            }
            v08 v08Var = new v08(v08.j);
            v08Var.a = i08Var.V().c;
            arrayList.add(0, v08Var);
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
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && this.a.F5() != null && this.a.R() != null && this.a.R().j1() != null) {
            y28.a().g(this.a.R().j1().W1(), this.h.v(), this.a.F5().b1(), this.a.R().getPageStayDurationItem(), z, this.B.b(), this.a.getListView());
        }
    }

    public final void o(List<xn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof PostData) {
                    if (i == 0 && (list.get(i2) instanceof ls8)) {
                        i = i2 + 1;
                    }
                    PostData postData = (PostData) list.get(i2);
                    if (!TextUtils.isEmpty(postData.S())) {
                        kt4 kt4Var = new kt4();
                        kt4Var.g(postData.S());
                        list.set(i2, kt4Var);
                    }
                }
            }
            if (i > 0 && hs5.i().q()) {
                hs5.i().n(list, i, 5);
            }
        }
    }

    public void h0(i08 i08Var, boolean z) {
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
        l38 l38Var;
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
        if ((interceptable != null && interceptable.invokeLZ(1048614, this, i08Var, z) != null) || i08Var == null) {
            return;
        }
        this.C = i08Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.clear();
        i08 i08Var2 = this.C;
        if (i08Var2 != null && i08Var2.H() != null && this.C.H().size() > 0) {
            this.D.addAll(this.C.H());
        }
        if (i08Var.Q() != null && i08Var.Q().getAuthor() != null) {
            this.P = i08Var.Q().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(i08Var);
        ArrayList<xn> arrayList = new ArrayList<>(i08Var.H());
        PostData p = p(arrayList);
        if (this.C.Q().isQuestionThread()) {
            postData = q(i08Var);
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
        if (!cy6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.C.u0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.Q = p;
        }
        if (!this.I && p != null) {
            arrayList.remove(p);
            if (i08Var.y0() && p.X() != null) {
                p.Y0(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && i08Var.j() != null) {
            PostData j = i08Var.j();
            if (!this.I && i08Var.y0() && j.X() != null) {
                j.Y0(null);
            }
            if (!this.I && (postData5 = this.Q) != null && j.i0 == null) {
                i08Var.H0(postData5);
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
        if (this.a.w5()) {
            if (i08Var.H().size() > 0 && (postData4 = i08Var.H().get(0)) != null && postData4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        lr8.f(arrayList, 1);
        int A = A(i08Var, arrayList);
        if (A >= 0) {
            U(i08Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(i08Var, arrayList);
        if (F >= 0) {
            q08 q08Var = new q08(q08.c);
            q08Var.b(true);
            ListUtils.add(arrayList, F, q08Var);
        }
        int u = u(i08Var, arrayList);
        List<xn> v = v(i08Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            xn xnVar2 = (xn) ListUtils.getItem(arrayList, u);
            if (xnVar2 instanceof PostData) {
                ((PostData) xnVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(i08Var, arrayList, this.I);
        } else {
            i = -1;
        }
        if (i >= 0 && i08Var.U() != null) {
            PostData Z = i08Var.Z();
            ThreadData c2 = i08Var.U().c();
            if (Z != null && Z.m0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure m0 = Z.m0();
                VirtualImageCustomState n0 = Z.n0();
                c2.setCustomFigure(m0);
                c2.setCustomState(n0);
            }
            ListUtils.add(arrayList, i, i08Var.U());
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
        if (S(i08Var, postData2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && R(i08Var, arrayList, i) != null) {
            i++;
        }
        if (O(i08Var, arrayList, i) != null) {
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
                l38Var = null;
            } else {
                l38 T = T(arrayList, xnVar, i, i5);
                if (T != null) {
                    if (!z12) {
                        l38Var = T;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                l38Var = T;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            l38Var = null;
        }
        if (z2) {
            if (l38Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean N = N(i08Var, arrayList, z9, z10, i3, i6, u, A);
            if (l38Var != null) {
                l38Var.n = N;
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
        if (i08Var.U() != null) {
            i08Var.U().i(!z7);
        }
        if (this.b != null) {
            this.E = arrayList;
            List<xn> T2 = i08Var.T();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setData(H(arrayList, T2));
            } else {
                this.b.setData(this.E);
            }
        }
        e0(C0, z, i4, list);
        if (r(postData2, arrayList, z4)) {
            List<xn> T3 = i08Var.T();
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
            ArrayList<BdUniqueId> g = lr8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                xl7 b2 = cn7.d().b(this.a.getPageContext(), g.get(i), 2);
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
