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
public class vk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ym8 A;
    public ak8 B;
    public ki8 C;
    public ArrayList<bc9> D;
    public ArrayList<gn> E;
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
    public bc9 Q;
    public bc9 R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    public View.OnClickListener U;
    public TbRichTextView.a0 V;
    public View.OnClickListener W;
    public mj8 X;
    public View.OnLongClickListener Y;
    public SortSwitchButton.f Z;
    public PbFragment a;
    public final List<tm> a0;
    public BdTypeListView b;
    public final List<tm> b0;
    public fl8 c;
    public Runnable c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public wm8 g;
    public ThreadData g0;
    public em8 h;
    public List<bc9> h0;
    public sl8 i;
    public final CustomMessageListener i0;
    public em8 j;
    public CustomMessageListener j0;
    public zk8 k;
    public final CustomMessageListener k0;
    public im8 l;
    public final View.OnClickListener l0;
    public np8 m;
    public CustomMessageListener m0;
    public hg6 n;
    public List<tm> n0;
    public tm o;
    public tm p;
    public tm q;
    public tm r;
    public tm s;
    public am8 t;
    public cm8 u;
    public zl8 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<zj8> x;
    public wk8 y;
    public ml8 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk8 a;

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
        public c(vk8 vk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk8Var, Integer.valueOf(i)};
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
            this.a = vk8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C != null && !g9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
        public final /* synthetic */ vk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vk8 vk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk8Var, Integer.valueOf(i)};
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
            this.a = vk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof zb9)) {
                zb9 zb9Var = (zb9) customResponsedMessage.getData();
                if (this.a.g0 != null && this.a.g0.funAdData == zb9Var) {
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
        public final /* synthetic */ vk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vk8 vk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk8Var, Integer.valueOf(i)};
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
            this.a = vk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof qb9)) {
                AbsDelegateAdapterList a = ((qb9) customResponsedMessage.getData()).a();
                Iterator<tm<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    tm<?, ?> next = it.next();
                    if (next instanceof bl8) {
                        ((bl8) next).t(this.a.a);
                        if (next instanceof zj8) {
                            this.a.x.add((zj8) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.b0.clear();
                this.a.b0.addAll(arrayList);
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
        public final /* synthetic */ vk8 a;

        public d(vk8 vk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.C != null && this.a.C.V() != null) {
                this.a.a.M5().b1().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ vk8 b;

        public e(vk8 vk8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vk8Var;
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
        public final /* synthetic */ vk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(vk8 vk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk8Var, Integer.valueOf(i)};
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
            this.a = vk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.n0)) {
                this.a.n();
                vk8 vk8Var = this.a;
                vk8Var.h0(vk8Var.C, false);
            }
        }
    }

    public vk8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.O = hi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.k0);
        this.e0 = hi.j(this.a.getContext()) / 3;
    }

    public void A0(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mj8Var) == null) {
            this.X = mj8Var;
        }
    }

    public void d0(boolean z) {
        fl8 fl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (fl8Var = this.c) != null) {
            fl8Var.V(z);
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

    public final bc9 q(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, ki8Var)) == null) {
            if (ki8Var != null && ki8Var.W() != null) {
                bc9 W = ki8Var.W();
                this.R = W;
                return W;
            }
            return null;
        }
        return (bc9) invokeL.objValue;
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
        zk8 zk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && (zk8Var = this.k) != null) {
            zk8Var.w0(z);
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

    public gn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            return this.b.F(i);
        }
        return (gn) invokeI.objValue;
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
            if (this.b.F(i) != null) {
                return this.b.F(i).getType();
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

    public final int A(ki8 ki8Var, ArrayList<gn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ki8Var, arrayList)) == null) {
            if (ki8Var == null || ListUtils.isEmpty(ki8Var.H()) || ListUtils.isEmpty(arrayList) || ((bc9) ListUtils.getItem(ki8Var.H(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    gn gnVar = arrayList.get(i);
                    if (gnVar instanceof bc9) {
                        bc9 bc9Var = (bc9) gnVar;
                        if (bc9Var.E() == 1 && bc9Var.O == 0) {
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

    public final int F(ki8 ki8Var, ArrayList<gn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, ki8Var, arrayList)) == null) {
            int i = -1;
            if (ki8Var == null || ki8Var.z() == null) {
                return -1;
            }
            int i2 = 0;
            if (ki8Var.z().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof xi8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (ki8Var.N() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<gn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = i65.i();
        int j = i65.j() - 1;
        if (bool.booleanValue()) {
            gn gnVar = arrayList.get(0);
            if ((gnVar instanceof bc9) && ((bc9) gnVar).E() == 1) {
                j++;
            }
        }
        int k = i65.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.L() != null && this.a.L().G1() == 3) {
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
                    gn gnVar = this.b.getData().get(i);
                    if (gnVar != null && gnVar.getType() == xi8.i) {
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
            jg.a().removeCallbacks(this.c0);
            em8 em8Var = this.h;
            if (em8Var != null) {
                em8Var.onDestroy();
            }
            em8 em8Var2 = this.j;
            if (em8Var2 != null) {
                em8Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            wm8 wm8Var = this.g;
            if (wm8Var != null) {
                wm8Var.onDestroy();
            }
            sx5.k().q(false);
        }
    }

    public void B0() {
        sl8 sl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (sl8Var = this.i) != null) {
            sl8Var.z(2);
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
            if (this.b.getAdapter2() instanceof xm) {
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

    public ArrayList<gn> t() {
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

    public int C(ki8 ki8Var, ArrayList<gn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, ki8Var, arrayList, z)) == null) {
            if (ki8Var == null || ki8Var.H() == null || ki8Var.E() == null || ki8Var.H().size() == 0 || ki8Var.Q() == null || arrayList == null || !ki8Var.E().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ki8Var.H().get(0) == null || ki8Var.H().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ki8Var.z() == null || ki8Var.z().a() != ki8Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(ki8 ki8Var, ArrayList<gn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, ki8Var, arrayList, z)) == null) {
            if (ki8Var == null || ki8Var.H() == null || ki8Var.F() == null || ki8Var.H().size() == 0 || ki8Var.Q() == null || arrayList == null || !ki8Var.F().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (ki8Var.H().get(0) == null || ki8Var.H().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (ki8Var.z() == null || ki8Var.z().a() != ki8Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final gn R(ki8 ki8Var, ArrayList<gn> arrayList, int i) {
        InterceptResult invokeLLI;
        mi8 mi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, ki8Var, arrayList, i)) == null) {
            if (ki8Var.l() != null && !StringUtils.isNull(ki8Var.l().getName())) {
                if (!TextUtils.equals(ki8Var.l().getName(), this.a.L().V0()) || !this.a.L().b1()) {
                    if (!this.a.x0() && !ListUtils.isEmpty(ki8Var.p())) {
                        mi8Var = new mi8(ki8Var.p().get(0));
                    } else {
                        mi8Var = new mi8(ki8Var.l());
                    }
                    mi8Var.g = this.a.L().Q1();
                    ListUtils.add(arrayList, i + 1, mi8Var);
                    return mi8Var;
                }
                return null;
            }
            return null;
        }
        return (gn) invokeLLI.objValue;
    }

    public final boolean C0(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bc9Var)) == null) {
            if (this.a.L() != null && bc9Var != null && bc9Var.O() != null && bc9Var.O().equals(this.a.L().W1())) {
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
            tm tmVar = this.p;
            if (tmVar != null && (tmVar instanceof b19)) {
                ((b19) tmVar).setIsFromCDN(z);
            }
            Iterator<zj8> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final bc9 p(ArrayList<gn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<gn> it = arrayList.iterator();
            while (it.hasNext()) {
                gn next = it.next();
                if (next instanceof bc9) {
                    bc9 bc9Var = (bc9) next;
                    if (bc9Var.E() == 1) {
                        return bc9Var;
                    }
                }
            }
            return null;
        }
        return (bc9) invokeL.objValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            zk8 zk8Var = this.k;
            if (zk8Var != null) {
                zk8Var.x0(z);
            }
            em8 em8Var = this.h;
            if (em8Var != null) {
                em8Var.A(z);
            }
            tm tmVar = this.s;
            if (tmVar != null) {
                tmVar.setMulDel(z);
            }
            tm tmVar2 = this.p;
            if (tmVar2 != null) {
                tmVar2.setMulDel(z);
            }
            fl8 fl8Var = this.c;
            if (fl8Var != null) {
                fl8Var.setMulDel(z);
            }
        }
    }

    public final void D0() {
        ki8 ki8Var;
        ac9 ac9Var;
        ac9 ac9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ki8Var = this.C) == null || ki8Var.c0 || ki8Var.d0 == 2) {
            return;
        }
        ArrayList<bc9> H = ki8Var.H();
        ArrayList<ac9> e2 = this.C.e();
        if (!v38.e(H) && !v38.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<ac9> it = e2.iterator();
            while (it.hasNext()) {
                ac9 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ac9> it2 = e2.iterator();
            while (it2.hasNext()) {
                ac9 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ac9> it3 = e2.iterator();
            while (it3.hasNext()) {
                ac9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int k = next3.getAdvertAppInfo().k();
                    if (k != 0) {
                        s29.j(next3, k);
                        if (k != 28 && k != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            e2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                ac9 ac9Var3 = (ac9) sparseArray.valueAt(i);
                if (ac9Var3 != null && (ac9Var2 = (ac9) hashMap.put(ac9Var3.p1(), ac9Var3)) != null) {
                    s29.j(ac9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (ac9Var = (ac9) entry.getValue()) != null) {
                    sparseArray.put(ac9Var.getPosition(), ac9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                v38.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < v38.i(arrayList); i4++) {
                ac9 ac9Var4 = (ac9) sparseArray.get(((Integer) v38.d(arrayList, i4)).intValue());
                if (this.C.l() != null) {
                    ac9Var4.b1 = this.C.l().getId();
                }
                if (this.C.Q() != null) {
                    ac9Var4.e1 = gg.g(this.C.Q().getId(), 0L);
                }
                ki8 ki8Var2 = this.C;
                if (ki8Var2 != null && ki8Var2.z() != null) {
                    ac9Var4.f1 = this.C.z().a();
                }
                l(ac9Var4);
                int position = ac9Var4.getPosition() + this.C.b0;
                if (position >= v38.i(H)) {
                    ac9Var4.h1 = position;
                    s29.k(ac9Var4, 2, position, v38.i(H));
                    return;
                }
                if (!this.I) {
                    position--;
                    ac9Var4.h1 = position;
                }
                if (position < 0) {
                    s29.j(ac9Var4, 23);
                } else {
                    ac9Var4.i1 = i3;
                    v38.b(H, ac9Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ac9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int E(ki8 ki8Var, ArrayList<gn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, ki8Var, arrayList, z)) == null) {
            if (ki8Var != null && !ListUtils.isEmpty(ki8Var.H()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (ki8Var.H().get(0) == null || ki8Var.H().get(0).E() != 1) {
                    return -1;
                }
                return 1;
            } else if (ki8Var == null || !ki8Var.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void U(ki8 ki8Var, ArrayList<gn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, ki8Var, arrayList, i) == null) {
            xi8 xi8Var = new xi8(xi8.i);
            ThreadData Q = ki8Var.Q();
            if (Q != null) {
                Q.getReply_num();
            }
            xi8Var.d = this.a.h6();
            xi8Var.c = ki8Var.g;
            ki8Var.c();
            xi8Var.e = ki8Var.l0();
            xi8Var.g = ki8Var.f;
            if (Q != null && Q.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            xi8Var.h = z;
            ListUtils.add(arrayList, i, xi8Var);
            if (ki8Var.N() == 4) {
                ListUtils.add(arrayList, i + 1, new wi8());
            }
        }
    }

    public final ArrayList<gn> H(List<gn> list, List<gn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, list, list2)) == null) {
            ArrayList<gn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            qi8 qi8Var = new qi8();
            PbListView f1 = this.a.M5().f1();
            if (f1 != null && f1.p()) {
                qi8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eca);
                qi8Var.b = true;
            } else {
                qi8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                qi8Var.b = false;
            }
            arrayList.add(qi8Var);
            kg6 kg6Var = new kg6();
            kg6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            kg6Var.needTopMargin = false;
            arrayList.add(kg6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final gn P(ArrayList<gn> arrayList, int i) {
        InterceptResult invokeLI;
        ki8 ki8Var;
        zb9 zb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (ki8Var = this.C) != null && ki8Var.u0()) {
                String d2 = ma7.e().d("pb_banner");
                if (this.g0 == null && ga7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.g0 = threadData;
                    threadData.funAdData = new zb9();
                    ki8 ki8Var2 = this.C;
                    if (ki8Var2 != null) {
                        this.g0.funAdData.m(ki8Var2.m());
                        this.g0.funAdData.r(this.C.S());
                    }
                }
                ThreadData threadData2 = this.g0;
                if (threadData2 != null && (zb9Var = threadData2.funAdData) != null) {
                    zb9Var.j(1);
                    sx5.k().q(true);
                    ListUtils.add(arrayList, i, this.g0);
                    if (ky5.i().q()) {
                        ky5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.g0;
        }
        return (gn) invokeLI.objValue;
    }

    public final int u(ki8 ki8Var, ArrayList<gn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, ki8Var, arrayList)) == null) {
            if (!this.K && ki8Var != null && !ListUtils.isEmpty(ki8Var.H()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.L() != null && this.a.L().f1()) {
                    return -1;
                }
                if (this.a.M5() != null && this.a.M5().X0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        gn gnVar = arrayList.get(i);
                        if (gnVar instanceof bc9) {
                            bc9 bc9Var = (bc9) gnVar;
                            if (bc9Var.E() == 1 && bc9Var.O == 0) {
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
                    if (ki8Var.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (ki8Var != null && ki8Var.y0() && this.I) {
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
            fl8 fl8Var = this.c;
            if (fl8Var != null && fl8Var.Q() != null) {
                if (this.c.Q().A != null && this.c.Q().A.isShown()) {
                    return this.c.Q().A;
                }
                return this.c.Q().z;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f0() {
        bc9 bc9Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.C != null && (bc9Var = this.Q) != null && bc9Var.W() != null && this.c.Q() != null) {
            String S = this.C.S();
            String m = this.C.m();
            if (this.C.Q() != null) {
                i = this.C.Q().getThreadType();
            } else {
                i = 0;
            }
            uj5.a().c(S, m, this.Q.W(), this.c.Q().t, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbFragment, bdTypeListView) == null) {
            fl8 fl8Var = new fl8(pbFragment, bc9.P0);
            this.c = fl8Var;
            fl8Var.g0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, yi8.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, mi8.j);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), ni8.c);
            this.g = new wm8(pbFragment, fi8.c);
            this.h = new em8(pbFragment, xi8.i);
            this.i = new sl8(pbFragment, si8.c);
            this.j = new em8(pbFragment, xi8.j);
            zk8 zk8Var = new zk8(pbFragment, bc9.Q0);
            this.k = zk8Var;
            zk8Var.z0(pbFragment);
            im8 im8Var = new im8(pbFragment, bc9.R0);
            this.l = im8Var;
            im8Var.v0(pbFragment);
            this.o = f19.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = f19.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = ha7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = ha7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = ha7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new zl8(pbFragment, ui8.f1);
            this.t = new am8(pbFragment, yl8.c1);
            this.u = new cm8(pbFragment, ny4.i1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, bc9.X0);
            this.m = new np8(pbFragment, op8.a);
            this.n = new hg6(pbFragment.getPageContext());
            this.y = new wk8(pbFragment, yw4.e);
            this.z = new ml8(pbFragment, pbFragment.getUniqueId());
            this.A = new ym8(pbFragment.getPageContext(), py5.g);
            ak8 ak8Var = new ak8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.B = ak8Var;
            this.a0.addAll(ak8Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new qb9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.a0);
        }
    }

    public final void L(@NonNull ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ki8Var) == null) {
            this.c.r(ki8Var);
            this.c.setFromCDN(this.F);
            this.c.l(this.O);
            this.c.c(this.H);
            this.c.e(this.T);
            this.c.k(this.S);
            this.c.n(this.V);
            this.c.d(this.Y);
            this.c.d0(this.W);
            this.c.f0(this.X);
            this.f.y(this.W);
            this.k.r(ki8Var);
            this.k.setFromCDN(this.F);
            this.k.o(this.P);
            this.k.c(this.H);
            this.k.e(this.T);
            this.k.k(this.S);
            this.k.n(this.V);
            this.k.d(this.Y);
            this.k.y0(this.X);
            this.l.r(ki8Var);
            this.l.setFromCDN(this.F);
            this.l.o(this.P);
            this.l.c(this.H);
            this.l.e(this.T);
            this.l.k(this.S);
            this.l.n(this.V);
            this.l.d(this.Y);
            this.l.u0(this.X);
            this.d.J(this.T);
            this.w.y(this.T);
            this.m.y(this.l0);
            tm tmVar = this.p;
            if (tmVar != null && (tmVar instanceof b19)) {
                ((b19) tmVar).setIsFromCDN(this.F);
            }
            Iterator<zj8> it = this.x.iterator();
            while (it.hasNext()) {
                zj8 next = it.next();
                if (next != null) {
                    next.r(ki8Var);
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
            this.h.B(this.Z);
            this.i.e(this.U);
            this.j.e(this.T);
            this.h.r(ki8Var);
            this.g.r(ki8Var);
            this.j.r(ki8Var);
            this.t.r(ki8Var);
            this.u.r(ki8Var);
            this.y.A(ki8Var);
            this.y.z(this.a.r1);
            this.z.y(ki8Var);
            this.B.f(ki8Var);
        }
    }

    public final gn M(ArrayList<gn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, arrayList, i)) == null) {
            if (this.C == null) {
                return null;
            }
            ac9 P0 = this.a.L().P0();
            if (P0 == null) {
                P0 = this.C.A();
            }
            if (P0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert s1 = P0.s1();
            if (s1 != null) {
                s1.setAdvertAppInfo(P0.getAdvertAppInfo());
            }
            int k = P0.getAdvertAppInfo().k();
            if (k != 0) {
                s29.j(P0, k);
                if (k != 28 && k != 31) {
                    P0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.C.l() != null) {
                P0.b1 = this.C.l().getId();
            }
            if (this.C.Q() != null) {
                P0.e1 = gg.g(this.C.Q().getId(), 0L);
            }
            ki8 ki8Var = this.C;
            if (ki8Var != null && ki8Var.z() != null) {
                P0.f1 = this.C.z().a();
            }
            l(P0);
            if (i < 0) {
                return null;
            }
            P0.i1 = 1;
            sx5.k().q(true);
            v38.b(arrayList, P0, i);
            if (ky5.i().q()) {
                ky5.i().n(arrayList, i + 1, 4);
            }
            return P0;
        }
        return (gn) invokeLI.objValue;
    }

    public final boolean N(ki8 ki8Var, ArrayList<gn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{ki8Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(ki8Var.f()) && ki8Var.f().size() > 2) {
                int min = Math.min(ki8Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    yw4 yw4Var = ki8Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        yw4Var.k(true);
                    }
                    if (yw4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            yw4Var.o(true);
                        }
                    } else if (i6 == min - 2) {
                        yw4Var.o(true);
                    } else if (i6 == min - 1) {
                        yw4Var.m(true);
                    }
                    arrayList2.add(yw4Var);
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

    public final gn O(ki8 ki8Var, ArrayList<gn> arrayList, int i) {
        InterceptResult invokeLLI;
        fi8 fi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, ki8Var, arrayList, i)) == null) {
            if (i >= 0 && ki8Var != null && ki8Var.k && (fi8Var = ki8Var.l) != null) {
                ListUtils.add(arrayList, i, fi8Var);
                return fi8Var;
            }
            return null;
        }
        return (gn) invokeLLI.objValue;
    }

    public final void W(bc9 bc9Var, ArrayList<gn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, bc9Var, arrayList, i) == null) {
            bc9Var.h1(true);
            arrayList.add(i, bc9Var);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<gn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<gn> listIterator = arrayList.listIterator();
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
                        bc9 bc9Var = new bc9();
                        zb9 zb9Var = new zb9();
                        ki8 ki8Var = this.C;
                        if (ki8Var == null) {
                            str3 = "";
                        } else {
                            str3 = ki8Var.m();
                        }
                        zb9Var.m(str3);
                        ki8 ki8Var2 = this.C;
                        if (ki8Var2 != null) {
                            str = ki8Var2.S();
                        }
                        zb9Var.r(str);
                        zb9Var.n(true);
                        bc9Var.w0 = zb9Var;
                        zb9Var.j(i7);
                        listIterator.add(bc9Var);
                        i7++;
                        this.h0.add(bc9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && ky5.i().q()) {
                ky5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                bc9 bc9Var2 = new bc9();
                zb9 zb9Var2 = new zb9();
                ki8 ki8Var3 = this.C;
                if (ki8Var3 == null) {
                    str2 = "";
                } else {
                    str2 = ki8Var3.m();
                }
                zb9Var2.m(str2);
                ki8 ki8Var4 = this.C;
                if (ki8Var4 != null) {
                    str = ki8Var4.S();
                }
                zb9Var2.r(str);
                zb9Var2.n(true);
                bc9Var2.w0 = zb9Var2;
                zb9Var2.j(1);
                listIterator.add(bc9Var2);
                this.h0.add(bc9Var2);
                if (ky5.i().q()) {
                    ky5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final gn S(ki8 ki8Var, bc9 bc9Var, ArrayList<gn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048599, this, ki8Var, bc9Var, arrayList, i)) == null) {
            ni8 ni8Var = null;
            if (ki8Var.l() != null && !StringUtils.isNull(ki8Var.l().getName()) && TextUtils.equals(ki8Var.l().getName(), this.a.L().V0()) && this.a.L().b1()) {
                return null;
            }
            if (bc9Var != null) {
                if (bc9Var.r0 != null) {
                    ni8Var = new ni8(bc9Var.r0);
                }
            } else {
                bc9 bc9Var2 = this.Q;
                if (bc9Var2 != null && bc9Var2.r0 != null) {
                    ni8Var = new ni8(this.Q.r0);
                }
            }
            if (ni8Var != null) {
                ni8Var.b = this.a.L().Q1();
                ListUtils.add(arrayList, i + 1, ni8Var);
            }
            return ni8Var;
        }
        return (gn) invokeLLLI.objValue;
    }

    public final nl8 T(ArrayList<gn> arrayList, gn gnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, arrayList, gnVar, i, i2)) == null) {
            nl8 C = this.C.C();
            if (C != null) {
                if (gnVar != null) {
                    if (i2 < 0 && gnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (gnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (C instanceof nl8)) {
                    ListUtils.add(arrayList, i2, C);
                    return C;
                }
                return null;
            }
            return null;
        }
        return (nl8) invokeLLII.objValue;
    }

    public final gn V(ArrayList<gn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, arrayList, i)) == null) {
            if (i < 0 || (L = this.a.L()) == null || TextUtils.isEmpty(L.A1())) {
                return null;
            }
            ac9 ac9Var = new ac9();
            l(ac9Var);
            ListUtils.add(arrayList, i + 1, ac9Var);
            return ac9Var;
        }
        return (gn) invokeLI.objValue;
    }

    public void b0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.M5() != null) {
            this.a.M5().g2(z, i);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        fl8 fl8Var = this.c;
                        if (fl8Var != null) {
                            fl8Var.X();
                        }
                        tm tmVar = this.p;
                        if (tmVar instanceof w09) {
                            ((w09) tmVar).onDestroy();
                        }
                        tm tmVar2 = this.q;
                        if (tmVar2 instanceof w09) {
                            ((w09) tmVar2).onDestroy();
                        }
                        tm tmVar3 = this.s;
                        if (tmVar3 instanceof w09) {
                            ((w09) tmVar3).onDestroy();
                        }
                        al8.a().d();
                        return;
                    }
                    return;
                }
                fl8 fl8Var2 = this.c;
                if (fl8Var2 != null) {
                    fl8Var2.Y();
                }
                tm tmVar4 = this.p;
                if (tmVar4 instanceof w09) {
                    ((w09) tmVar4).onResume();
                }
                tm tmVar5 = this.q;
                if (tmVar5 instanceof w09) {
                    ((w09) tmVar5).onResume();
                }
                tm tmVar6 = this.s;
                if (tmVar6 instanceof w09) {
                    ((w09) tmVar6).onResume();
                }
                g0(false);
                f0();
                return;
            }
            fl8 fl8Var3 = this.c;
            if (fl8Var3 != null) {
                fl8Var3.W();
            }
            tm tmVar7 = this.p;
            if (tmVar7 instanceof w09) {
                ((w09) tmVar7).onPause();
            }
            tm tmVar8 = this.q;
            if (tmVar8 instanceof w09) {
                ((w09) tmVar8).onPause();
            }
            tm tmVar9 = this.s;
            if (tmVar9 instanceof w09) {
                ((w09) tmVar9).onPause();
            }
            al8.a().j(this.a.M());
            uj5.a().d();
        }
    }

    public final void l(ac9 ac9Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, ac9Var) == null) && ac9Var != null && this.C != null && ac9Var.getAdvertAppInfo() != null) {
            ac9Var.getAdvertAppInfo().i = new mw4();
            if (this.C.z() != null) {
                ac9Var.getAdvertAppInfo().i.b = this.C.z().a();
            }
            ac9Var.getAdvertAppInfo().i.a = ac9Var.r1();
            if (this.C.l() != null && (l = this.C.l()) != null) {
                ac9Var.getAdvertAppInfo().i.c = l.getId();
                ac9Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ac9Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ac9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ac9Var.getAdvertAppInfo().i.g = ac9Var.getAdvertAppInfo().g;
            ac9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<gn> v(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, ki8Var)) == null) {
            if (ki8Var == null || ki8Var.V() == null || ListUtils.isEmpty(ki8Var.V().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<bc9> list = ki8Var.V().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                bc9 bc9Var = list.get(i);
                if (bc9Var != null) {
                    bc9Var.c0 = true;
                    bc9Var.P = true;
                    arrayList.add(bc9Var);
                }
            }
            if (ListUtils.getCount(ki8Var.V().b) > 2) {
                gn gnVar = (gn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (gnVar instanceof bc9) {
                    ((bc9) gnVar).P = false;
                }
                arrayList.add(new op8());
            } else {
                gn gnVar2 = (gn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (gnVar2 instanceof bc9) {
                    ((bc9) gnVar2).P = true;
                }
            }
            xi8 xi8Var = new xi8(xi8.j);
            xi8Var.a = ki8Var.V().c;
            arrayList.add(0, xi8Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void e0(boolean z, boolean z2, int i, List<gn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.L || this.K) && i != -1 && !ListUtils.isEmpty(list) && !this.M) {
                this.c0 = new e(this, list);
                jg.a().post(this.c0);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && this.a.M5() != null && this.a.M() != null && this.a.M().K1() != null) {
            al8.a().g(this.a.M().K1().l2(), this.h.x(), this.a.M5().h1(), this.a.M().getPageStayDurationItem(), z, this.B.b(), this.a.getListView());
        }
    }

    public final void o(List<gn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof bc9) {
                    if (i == 0 && (list.get(i2) instanceof ac9)) {
                        i = i2 + 1;
                    }
                    bc9 bc9Var = (bc9) list.get(i2);
                    if (!TextUtils.isEmpty(bc9Var.U())) {
                        yx4 yx4Var = new yx4();
                        yx4Var.g(bc9Var.U());
                        list.set(i2, yx4Var);
                    }
                }
            }
            if (i > 0 && ky5.i().q()) {
                ky5.i().n(list, i, 5);
            }
        }
    }

    public void h0(ki8 ki8Var, boolean z) {
        bc9 bc9Var;
        boolean z2;
        boolean z3;
        bc9 bc9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        boolean z8;
        int i2;
        boolean z9;
        int i3;
        nl8 nl8Var;
        List<gn> list;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        gn gnVar;
        int i5;
        boolean z13;
        bc9 bc9Var3;
        bc9 bc9Var4;
        bc9 bc9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048614, this, ki8Var, z) != null) || ki8Var == null) {
            return;
        }
        this.C = ki8Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.clear();
        ki8 ki8Var2 = this.C;
        if (ki8Var2 != null && ki8Var2.H() != null && this.C.H().size() > 0) {
            this.D.addAll(this.C.H());
        }
        if (ki8Var.Q() != null && ki8Var.Q().getAuthor() != null) {
            this.P = ki8Var.Q().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(ki8Var);
        ArrayList<gn> arrayList = new ArrayList<>(ki8Var.H());
        bc9 p = p(arrayList);
        if (this.C.Q().isQuestionThread()) {
            bc9Var = q(ki8Var);
        } else {
            bc9Var = null;
        }
        if (bc9Var != null) {
            arrayList.remove(bc9Var);
        }
        if (p != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!na7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.C.u0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.Q = p;
        }
        if (!this.I && p != null) {
            arrayList.remove(p);
            if (ki8Var.y0() && p.Z() != null) {
                p.b1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && ki8Var.j() != null) {
            bc9 j = ki8Var.j();
            if (!this.I && ki8Var.y0() && j.Z() != null) {
                j.b1(null);
            }
            if (!this.I && (bc9Var5 = this.Q) != null && j.i0 == null) {
                ki8Var.H0(bc9Var5);
                bc9Var2 = bc9Var5;
            } else {
                bc9Var2 = j;
            }
            z2 = true;
            z4 = true;
        } else {
            bc9Var2 = p;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.D5()) {
            if (ki8Var.H().size() > 0 && (bc9Var4 = ki8Var.H().get(0)) != null && bc9Var4.E() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        ab9.f(arrayList, 1);
        int A = A(ki8Var, arrayList);
        if (A >= 0) {
            U(ki8Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(ki8Var, arrayList);
        if (F >= 0) {
            si8 si8Var = new si8(si8.c);
            si8Var.b(true);
            ListUtils.add(arrayList, F, si8Var);
        }
        int u = u(ki8Var, arrayList);
        List<gn> v = v(ki8Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            gn gnVar2 = (gn) ListUtils.getItem(arrayList, u);
            if (gnVar2 instanceof bc9) {
                ((bc9) gnVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(ki8Var, arrayList, this.I);
        } else {
            i = -1;
        }
        if (i >= 0 && ki8Var.U() != null) {
            bc9 Z = ki8Var.Z();
            ThreadData c2 = ki8Var.U().c();
            if (Z != null && Z.o0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure o0 = Z.o0();
                VirtualImageCustomState p0 = Z.p0();
                c2.setCustomFigure(o0);
                c2.setCustomState(p0);
            }
            ListUtils.add(arrayList, i, ki8Var.U());
            z6 = true;
            z7 = true;
        } else {
            if (bc9Var2 != null) {
                bc9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.C.Q().isQuestionThread() && bc9Var != null) || (this.C.Q().isQuestionThread() && this.R != null)) {
            if (bc9Var == null && (bc9Var3 = this.R) != null) {
                bc9Var = bc9Var3;
            }
            if (!arrayList.contains(bc9Var)) {
                i++;
                W(bc9Var, arrayList, i);
            }
        }
        if (S(ki8Var, bc9Var2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && R(ki8Var, arrayList, i) != null) {
            i++;
        }
        if (O(ki8Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            gn V = V(arrayList, i);
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
                gnVar = M(arrayList, i5);
                if (gnVar != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = z11;
                gnVar = V;
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
                nl8Var = null;
            } else {
                nl8 T = T(arrayList, gnVar, i, i5);
                if (T != null) {
                    if (!z12) {
                        nl8Var = T;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                nl8Var = T;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            nl8Var = null;
        }
        if (z2) {
            if (nl8Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean N = N(ki8Var, arrayList, z9, z10, i3, i6, u, A);
            if (nl8Var != null) {
                nl8Var.n = N;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.e0(!z6);
        boolean C0 = C0(bc9Var2);
        if (this.J && !C0) {
            arrayList.remove(bc9Var2);
            this.J = false;
        }
        if (ki8Var.U() != null) {
            ki8Var.U().i(!z7);
        }
        if (this.b != null) {
            this.E = arrayList;
            List<gn> T2 = ki8Var.T();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setData(H(arrayList, T2));
            } else {
                this.b.setData(this.E);
            }
        }
        e0(C0, z, i4, list);
        if (r(bc9Var2, arrayList, z4)) {
            List<gn> T3 = ki8Var.T();
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
            ArrayList<BdUniqueId> g = ab9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                n38 b2 = s48.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.a0.add(b2);
                    this.n0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.n0)) {
                this.b.addAdapters(this.n0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean r(bc9 bc9Var, ArrayList<gn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, bc9Var, arrayList, z)) == null) {
            if (bc9Var == null) {
                bc9 bc9Var2 = this.Q;
                if (bc9Var2 != null && !this.K) {
                    ListUtils.add(arrayList, 0, bc9Var2);
                } else {
                    bc9 bc9Var3 = new bc9();
                    bc9Var3.J0(1);
                    ListUtils.add(arrayList, 0, bc9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, bc9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
