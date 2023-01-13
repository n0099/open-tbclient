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
/* loaded from: classes5.dex */
public class j78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m98 A;
    public o68 B;
    public y48 C;
    public ArrayList<PostData> D;
    public ArrayList<yn> E;
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
    public a68 X;
    public View.OnLongClickListener Y;
    public SortSwitchButton.f Z;
    public PbFragment a;
    public final List<ln> a0;
    public BdTypeListView b;
    public final List<ln> b0;
    public t78 c;
    public Runnable c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public k98 g;
    public ThreadData g0;
    public s88 h;
    public List<PostData> h0;
    public g88 i;
    public final CustomMessageListener i0;
    public s88 j;
    public CustomMessageListener j0;
    public n78 k;
    public final CustomMessageListener k0;
    public w88 l;
    public final View.OnClickListener l0;
    public bc8 m;
    public CustomMessageListener m0;
    public v96 n;
    public List<ln> n0;
    public ln o;
    public ln p;
    public ln q;
    public ln r;
    public ln s;
    public o88 t;
    public q88 u;
    public n88 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<n68> x;
    public k78 y;
    public a88 z;

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

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
                    this.a.a.Z();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j78 j78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, Integer.valueOf(i)};
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
            this.a = j78Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C != null && !y9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    bh.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ j78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j78 j78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, Integer.valueOf(i)};
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
            this.a = j78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof gx8)) {
                gx8 gx8Var = (gx8) customResponsedMessage.getData();
                if (this.a.g0 != null && this.a.g0.funAdData == gx8Var) {
                    this.a.g0.funAdData.p(true);
                    this.a.b.setData(this.a.E);
                    this.a.Z();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j78 j78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, Integer.valueOf(i)};
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
            this.a = j78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof xw8)) {
                AbsDelegateAdapterList a = ((xw8) customResponsedMessage.getData()).a();
                Iterator<ln<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    ln<?, ?> next = it.next();
                    if (next instanceof p78) {
                        ((p78) next).t(this.a.a);
                        if (next instanceof n68) {
                            this.a.x.add((n68) next);
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        public d(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j78Var;
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

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ j78 b;

        public e(j78 j78Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j78Var;
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

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(j78 j78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, Integer.valueOf(i)};
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
            this.a = j78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.n0)) {
                this.a.n();
                j78 j78Var = this.a;
                j78Var.h0(j78Var.C, false);
            }
        }
    }

    public j78(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.O = zi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.k0);
        this.e0 = zi.j(this.a.getContext()) / 3;
    }

    public void A0(a68 a68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a68Var) == null) {
            this.X = a68Var;
        }
    }

    public void d0(boolean z) {
        t78 t78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (t78Var = this.c) != null) {
            t78Var.T(z);
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

    public final PostData q(y48 y48Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, y48Var)) == null) {
            if (y48Var != null && y48Var.W() != null) {
                PostData W = y48Var.W();
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
        n78 n78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && (n78Var = this.k) != null) {
            n78Var.u0(z);
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

    public yn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            return this.b.G(i);
        }
        return (yn) invokeI.objValue;
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

    public final int A(y48 y48Var, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, y48Var, arrayList)) == null) {
            if (y48Var == null || ListUtils.isEmpty(y48Var.H()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(y48Var.H(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    yn ynVar = arrayList.get(i);
                    if (ynVar instanceof PostData) {
                        PostData postData = (PostData) ynVar;
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

    public final int F(y48 y48Var, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, y48Var, arrayList)) == null) {
            int i = -1;
            if (y48Var == null || y48Var.z() == null) {
                return -1;
            }
            int i2 = 0;
            if (y48Var.z().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof l58) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (y48Var.N() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<yn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = y15.i();
        int j = y15.j() - 1;
        if (bool.booleanValue()) {
            yn ynVar = arrayList.get(0);
            if ((ynVar instanceof PostData) && ((PostData) ynVar).F() == 1) {
                j++;
            }
        }
        int k = y15.k() + 1;
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
                    yn ynVar = this.b.getData().get(i);
                    if (ynVar != null && ynVar.getType() == l58.i) {
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
            bh.a().removeCallbacks(this.c0);
            s88 s88Var = this.h;
            if (s88Var != null) {
                s88Var.onDestroy();
            }
            s88 s88Var2 = this.j;
            if (s88Var2 != null) {
                s88Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            k98 k98Var = this.g;
            if (k98Var != null) {
                k98Var.onDestroy();
            }
            js5.k().q(false);
        }
    }

    public void B0() {
        g88 g88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (g88Var = this.i) != null) {
            g88Var.x(2);
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
            if (this.b.getAdapter2() instanceof pn) {
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

    public ArrayList<yn> t() {
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

    public int C(y48 y48Var, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, y48Var, arrayList, z)) == null) {
            if (y48Var == null || y48Var.H() == null || y48Var.E() == null || y48Var.H().size() == 0 || y48Var.Q() == null || arrayList == null || !y48Var.E().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (y48Var.H().get(0) == null || y48Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (y48Var.z() == null || y48Var.z().a() != y48Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(y48 y48Var, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, y48Var, arrayList, z)) == null) {
            if (y48Var == null || y48Var.H() == null || y48Var.F() == null || y48Var.H().size() == 0 || y48Var.Q() == null || arrayList == null || !y48Var.F().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (y48Var.H().get(0) == null || y48Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (y48Var.z() == null || y48Var.z().a() != y48Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final yn R(y48 y48Var, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLI;
        a58 a58Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, y48Var, arrayList, i)) == null) {
            if (y48Var.l() != null && !StringUtils.isNull(y48Var.l().getName())) {
                if (!TextUtils.equals(y48Var.l().getName(), this.a.M().K0()) || !this.a.M().Q0()) {
                    if (!this.a.u0() && !ListUtils.isEmpty(y48Var.p())) {
                        a58Var = new a58(y48Var.p().get(0));
                    } else {
                        a58Var = new a58(y48Var.l());
                    }
                    a58Var.g = this.a.M().F1();
                    ListUtils.add(arrayList, i + 1, a58Var);
                    return a58Var;
                }
                return null;
            }
            return null;
        }
        return (yn) invokeLLI.objValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) {
            if (this.a.M() != null && postData != null && postData.O() != null && postData.O().equals(this.a.M().L1())) {
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
            ln lnVar = this.p;
            if (lnVar != null && (lnVar instanceof nn8)) {
                ((nn8) lnVar).setIsFromCDN(z);
            }
            Iterator<n68> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final PostData p(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
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
            n78 n78Var = this.k;
            if (n78Var != null) {
                n78Var.v0(z);
            }
            s88 s88Var = this.h;
            if (s88Var != null) {
                s88Var.y(z);
            }
            ln lnVar = this.s;
            if (lnVar != null) {
                lnVar.setMulDel(z);
            }
            ln lnVar2 = this.p;
            if (lnVar2 != null) {
                lnVar2.setMulDel(z);
            }
            t78 t78Var = this.c;
            if (t78Var != null) {
                t78Var.setMulDel(z);
            }
        }
    }

    public final void D0() {
        y48 y48Var;
        hx8 hx8Var;
        hx8 hx8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (y48Var = this.C) == null || y48Var.c0 || y48Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = y48Var.H();
        ArrayList<hx8> e2 = this.C.e();
        if (!uq7.e(H) && !uq7.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<hx8> it = e2.iterator();
            while (it.hasNext()) {
                hx8 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<hx8> it2 = e2.iterator();
            while (it2.hasNext()) {
                hx8 next2 = it2.next();
                if (next2 != null) {
                    next2.g1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<hx8> it3 = e2.iterator();
            while (it3.hasNext()) {
                hx8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        ep8.j(next3, m);
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
                hx8 hx8Var3 = (hx8) sparseArray.valueAt(i);
                if (hx8Var3 != null && (hx8Var2 = (hx8) hashMap.put(hx8Var3.p1(), hx8Var3)) != null) {
                    ep8.j(hx8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (hx8Var = (hx8) entry.getValue()) != null) {
                    sparseArray.put(hx8Var.getPosition(), hx8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                uq7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < uq7.i(arrayList); i4++) {
                hx8 hx8Var4 = (hx8) sparseArray.get(((Integer) uq7.d(arrayList, i4)).intValue());
                if (this.C.l() != null) {
                    hx8Var4.a1 = this.C.l().getId();
                }
                if (this.C.Q() != null) {
                    hx8Var4.d1 = yg.g(this.C.Q().getId(), 0L);
                }
                y48 y48Var2 = this.C;
                if (y48Var2 != null && y48Var2.z() != null) {
                    hx8Var4.e1 = this.C.z().a();
                }
                l(hx8Var4);
                int position = hx8Var4.getPosition() + this.C.b0;
                if (position >= uq7.i(H)) {
                    hx8Var4.g1 = position;
                    ep8.k(hx8Var4, 2, position, uq7.i(H));
                    return;
                }
                if (!this.I) {
                    position--;
                    hx8Var4.g1 = position;
                }
                if (position < 0) {
                    ep8.j(hx8Var4, 23);
                } else {
                    hx8Var4.h1 = i3;
                    uq7.b(H, hx8Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", hx8Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int E(y48 y48Var, ArrayList<yn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, y48Var, arrayList, z)) == null) {
            if (y48Var != null && !ListUtils.isEmpty(y48Var.H()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (y48Var.H().get(0) == null || y48Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (y48Var == null || !y48Var.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void U(y48 y48Var, ArrayList<yn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, y48Var, arrayList, i) == null) {
            l58 l58Var = new l58(l58.i);
            ThreadData Q = y48Var.Q();
            if (Q != null) {
                Q.getReply_num();
            }
            l58Var.d = this.a.f6();
            l58Var.c = y48Var.g;
            y48Var.c();
            l58Var.e = y48Var.l0();
            l58Var.g = y48Var.f;
            if (Q != null && Q.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            l58Var.h = z;
            ListUtils.add(arrayList, i, l58Var);
            if (y48Var.N() == 4) {
                ListUtils.add(arrayList, i + 1, new k58());
            }
        }
    }

    public final ArrayList<yn> H(List<yn> list, List<yn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, list, list2)) == null) {
            ArrayList<yn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            e58 e58Var = new e58();
            PbListView f1 = this.a.K5().f1();
            if (f1 != null && f1.p()) {
                e58Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e79);
                e58Var.b = true;
            } else {
                e58Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                e58Var.b = false;
            }
            arrayList.add(e58Var);
            y96 y96Var = new y96();
            y96Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            y96Var.needTopMargin = false;
            arrayList.add(y96Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final yn P(ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLI;
        y48 y48Var;
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (y48Var = this.C) != null && y48Var.u0()) {
                String d2 = z17.e().d("pb_banner");
                if (this.g0 == null && t17.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.g0 = threadData;
                    threadData.funAdData = new gx8();
                    y48 y48Var2 = this.C;
                    if (y48Var2 != null) {
                        this.g0.funAdData.m(y48Var2.m());
                        this.g0.funAdData.r(this.C.S());
                    }
                }
                ThreadData threadData2 = this.g0;
                if (threadData2 != null && (gx8Var = threadData2.funAdData) != null) {
                    gx8Var.j(1);
                    js5.k().q(true);
                    ListUtils.add(arrayList, i, this.g0);
                    if (bt5.i().q()) {
                        bt5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.g0;
        }
        return (yn) invokeLI.objValue;
    }

    public final int u(y48 y48Var, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, y48Var, arrayList)) == null) {
            if (!this.K && y48Var != null && !ListUtils.isEmpty(y48Var.H()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.M() != null && this.a.M().U0()) {
                    return -1;
                }
                if (this.a.K5() != null && this.a.K5().X0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        yn ynVar = arrayList.get(i);
                        if (ynVar instanceof PostData) {
                            PostData postData = (PostData) ynVar;
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
                    if (y48Var.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (y48Var != null && y48Var.y0() && this.I) {
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
            t78 t78Var = this.c;
            if (t78Var != null && t78Var.O() != null) {
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
            ze5.a().c(S, m, this.Q.W(), this.c.O().t, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbFragment, bdTypeListView) == null) {
            t78 t78Var = new t78(pbFragment, PostData.O0);
            this.c = t78Var;
            t78Var.e0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, m58.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, a58.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), b58.c);
            this.g = new k98(pbFragment, t48.c);
            this.h = new s88(pbFragment, l58.i);
            this.i = new g88(pbFragment, g58.c);
            this.j = new s88(pbFragment, l58.j);
            n78 n78Var = new n78(pbFragment, PostData.P0);
            this.k = n78Var;
            n78Var.x0(pbFragment);
            w88 w88Var = new w88(pbFragment, PostData.Q0);
            this.l = w88Var;
            w88Var.t0(pbFragment);
            this.o = rn8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = rn8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = u17.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = u17.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = u17.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new n88(pbFragment, i58.e1);
            this.t = new o88(pbFragment, m88.b1);
            this.u = new q88(pbFragment, ku4.h1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.W0);
            this.m = new bc8(pbFragment, cc8.a);
            this.n = new v96(pbFragment.getPageContext());
            this.y = new k78(pbFragment, ws4.e);
            this.z = new a88(pbFragment, pbFragment.getUniqueId());
            this.A = new m98(pbFragment.getPageContext(), gt5.g);
            o68 o68Var = new o68(pbFragment, pbFragment.getUniqueId(), this.b);
            this.B = o68Var;
            this.a0.addAll(o68Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new xw8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.a0);
        }
    }

    public final void L(@NonNull y48 y48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, y48Var) == null) {
            this.c.r(y48Var);
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
            this.k.r(y48Var);
            this.k.setFromCDN(this.F);
            this.k.o(this.P);
            this.k.c(this.H);
            this.k.e(this.T);
            this.k.k(this.S);
            this.k.n(this.V);
            this.k.d(this.Y);
            this.k.w0(this.X);
            this.l.r(y48Var);
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
            ln lnVar = this.p;
            if (lnVar != null && (lnVar instanceof nn8)) {
                ((nn8) lnVar).setIsFromCDN(this.F);
            }
            Iterator<n68> it = this.x.iterator();
            while (it.hasNext()) {
                n68 next = it.next();
                if (next != null) {
                    next.r(y48Var);
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
            this.h.r(y48Var);
            this.g.r(y48Var);
            this.j.r(y48Var);
            this.t.r(y48Var);
            this.u.r(y48Var);
            this.y.y(y48Var);
            this.y.x(this.a.s1);
            this.z.w(y48Var);
            this.B.f(y48Var);
        }
    }

    public final yn M(ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, arrayList, i)) == null) {
            if (this.C == null) {
                return null;
            }
            hx8 E0 = this.a.M().E0();
            if (E0 == null) {
                E0 = this.C.A();
            }
            if (E0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert s1 = E0.s1();
            if (s1 != null) {
                s1.setAdvertAppInfo(E0.getAdvertAppInfo());
            }
            int m = E0.getAdvertAppInfo().m();
            if (m != 0) {
                ep8.j(E0, m);
                if (m != 28 && m != 31) {
                    E0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.C.l() != null) {
                E0.a1 = this.C.l().getId();
            }
            if (this.C.Q() != null) {
                E0.d1 = yg.g(this.C.Q().getId(), 0L);
            }
            y48 y48Var = this.C;
            if (y48Var != null && y48Var.z() != null) {
                E0.e1 = this.C.z().a();
            }
            l(E0);
            if (i < 0) {
                return null;
            }
            E0.h1 = 1;
            js5.k().q(true);
            uq7.b(arrayList, E0, i);
            if (bt5.i().q()) {
                bt5.i().n(arrayList, i + 1, 4);
            }
            return E0;
        }
        return (yn) invokeLI.objValue;
    }

    public final boolean N(y48 y48Var, ArrayList<yn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{y48Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(y48Var.f()) && y48Var.f().size() > 2) {
                int min = Math.min(y48Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    ws4 ws4Var = y48Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        ws4Var.m(true);
                    }
                    if (ws4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            ws4Var.p(true);
                        }
                    } else if (i6 == min - 2) {
                        ws4Var.p(true);
                    } else if (i6 == min - 1) {
                        ws4Var.o(true);
                    }
                    arrayList2.add(ws4Var);
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

    public final yn O(y48 y48Var, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLI;
        t48 t48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, y48Var, arrayList, i)) == null) {
            if (i >= 0 && y48Var != null && y48Var.k && (t48Var = y48Var.l) != null) {
                ListUtils.add(arrayList, i, t48Var);
                return t48Var;
            }
            return null;
        }
        return (yn) invokeLLI.objValue;
    }

    public final void W(PostData postData, ArrayList<yn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, postData, arrayList, i) == null) {
            postData.h1(true);
            arrayList.add(i, postData);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<yn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<yn> listIterator = arrayList.listIterator();
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
                        gx8 gx8Var = new gx8();
                        y48 y48Var = this.C;
                        if (y48Var == null) {
                            str3 = "";
                        } else {
                            str3 = y48Var.m();
                        }
                        gx8Var.m(str3);
                        y48 y48Var2 = this.C;
                        if (y48Var2 != null) {
                            str = y48Var2.S();
                        }
                        gx8Var.r(str);
                        gx8Var.n(true);
                        postData.v0 = gx8Var;
                        gx8Var.j(i7);
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
            if (i6 > 0 && bt5.i().q()) {
                bt5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                PostData postData2 = new PostData();
                gx8 gx8Var2 = new gx8();
                y48 y48Var3 = this.C;
                if (y48Var3 == null) {
                    str2 = "";
                } else {
                    str2 = y48Var3.m();
                }
                gx8Var2.m(str2);
                y48 y48Var4 = this.C;
                if (y48Var4 != null) {
                    str = y48Var4.S();
                }
                gx8Var2.r(str);
                gx8Var2.n(true);
                postData2.v0 = gx8Var2;
                gx8Var2.j(1);
                listIterator.add(postData2);
                this.h0.add(postData2);
                if (bt5.i().q()) {
                    bt5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final yn S(y48 y48Var, PostData postData, ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048599, this, y48Var, postData, arrayList, i)) == null) {
            b58 b58Var = null;
            if (y48Var.l() != null && !StringUtils.isNull(y48Var.l().getName()) && TextUtils.equals(y48Var.l().getName(), this.a.M().K0()) && this.a.M().Q0()) {
                return null;
            }
            if (postData != null) {
                if (postData.q0 != null) {
                    b58Var = new b58(postData.q0);
                }
            } else {
                PostData postData2 = this.Q;
                if (postData2 != null && postData2.q0 != null) {
                    b58Var = new b58(this.Q.q0);
                }
            }
            if (b58Var != null) {
                b58Var.b = this.a.M().F1();
                ListUtils.add(arrayList, i + 1, b58Var);
            }
            return b58Var;
        }
        return (yn) invokeLLLI.objValue;
    }

    public final b88 T(ArrayList<yn> arrayList, yn ynVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, arrayList, ynVar, i, i2)) == null) {
            b88 C = this.C.C();
            if (C != null) {
                if (ynVar != null) {
                    if (i2 < 0 && ynVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (ynVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (C instanceof b88)) {
                    ListUtils.add(arrayList, i2, C);
                    return C;
                }
                return null;
            }
            return null;
        }
        return (b88) invokeLLII.objValue;
    }

    public final yn V(ArrayList<yn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, arrayList, i)) == null) {
            if (i < 0 || (M = this.a.M()) == null || TextUtils.isEmpty(M.p1())) {
                return null;
            }
            hx8 hx8Var = new hx8();
            l(hx8Var);
            ListUtils.add(arrayList, i + 1, hx8Var);
            return hx8Var;
        }
        return (yn) invokeLI.objValue;
    }

    public void b0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.K5() != null) {
            this.a.K5().h2(z, i);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        t78 t78Var = this.c;
                        if (t78Var != null) {
                            t78Var.V();
                        }
                        ln lnVar = this.p;
                        if (lnVar instanceof in8) {
                            ((in8) lnVar).onDestroy();
                        }
                        ln lnVar2 = this.q;
                        if (lnVar2 instanceof in8) {
                            ((in8) lnVar2).onDestroy();
                        }
                        ln lnVar3 = this.s;
                        if (lnVar3 instanceof in8) {
                            ((in8) lnVar3).onDestroy();
                        }
                        o78.a().d();
                        return;
                    }
                    return;
                }
                t78 t78Var2 = this.c;
                if (t78Var2 != null) {
                    t78Var2.W();
                }
                ln lnVar4 = this.p;
                if (lnVar4 instanceof in8) {
                    ((in8) lnVar4).onResume();
                }
                ln lnVar5 = this.q;
                if (lnVar5 instanceof in8) {
                    ((in8) lnVar5).onResume();
                }
                ln lnVar6 = this.s;
                if (lnVar6 instanceof in8) {
                    ((in8) lnVar6).onResume();
                }
                g0(false);
                f0();
                return;
            }
            t78 t78Var3 = this.c;
            if (t78Var3 != null) {
                t78Var3.U();
            }
            ln lnVar7 = this.p;
            if (lnVar7 instanceof in8) {
                ((in8) lnVar7).onPause();
            }
            ln lnVar8 = this.q;
            if (lnVar8 instanceof in8) {
                ((in8) lnVar8).onPause();
            }
            ln lnVar9 = this.s;
            if (lnVar9 instanceof in8) {
                ((in8) lnVar9).onPause();
            }
            o78.a().j(this.a.S());
            ze5.a().d();
        }
    }

    public final void l(hx8 hx8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, hx8Var) == null) && hx8Var != null && this.C != null && hx8Var.getAdvertAppInfo() != null) {
            hx8Var.getAdvertAppInfo().i = new ks4();
            if (this.C.z() != null) {
                hx8Var.getAdvertAppInfo().i.b = this.C.z().a();
            }
            hx8Var.getAdvertAppInfo().i.a = hx8Var.r1();
            if (this.C.l() != null && (l = this.C.l()) != null) {
                hx8Var.getAdvertAppInfo().i.c = l.getId();
                hx8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                hx8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                hx8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            hx8Var.getAdvertAppInfo().i.g = hx8Var.getAdvertAppInfo().g;
            hx8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<yn> v(y48 y48Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, y48Var)) == null) {
            if (y48Var == null || y48Var.V() == null || ListUtils.isEmpty(y48Var.V().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = y48Var.V().a;
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
            if (ListUtils.getCount(y48Var.V().b) > 2) {
                yn ynVar = (yn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (ynVar instanceof PostData) {
                    ((PostData) ynVar).P = false;
                }
                arrayList.add(new cc8());
            } else {
                yn ynVar2 = (yn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (ynVar2 instanceof PostData) {
                    ((PostData) ynVar2).P = true;
                }
            }
            l58 l58Var = new l58(l58.j);
            l58Var.a = y48Var.V().c;
            arrayList.add(0, l58Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void e0(boolean z, boolean z2, int i, List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.L || this.K) && i != -1 && !ListUtils.isEmpty(list) && !this.M) {
                this.c0 = new e(this, list);
                bh.a().post(this.c0);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && this.a.K5() != null && this.a.S() != null && this.a.S().l1() != null) {
            o78.a().g(this.a.S().l1().W1(), this.h.v(), this.a.K5().h1(), this.a.S().getPageStayDurationItem(), z, this.B.b(), this.a.getListView());
        }
    }

    public final void o(List<yn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof PostData) {
                    if (i == 0 && (list.get(i2) instanceof hx8)) {
                        i = i2 + 1;
                    }
                    PostData postData = (PostData) list.get(i2);
                    if (!TextUtils.isEmpty(postData.U())) {
                        vt4 vt4Var = new vt4();
                        vt4Var.g(postData.U());
                        list.set(i2, vt4Var);
                    }
                }
            }
            if (i > 0 && bt5.i().q()) {
                bt5.i().n(list, i, 5);
            }
        }
    }

    public void h0(y48 y48Var, boolean z) {
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
        b88 b88Var;
        List<yn> list;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        yn ynVar;
        int i5;
        boolean z13;
        PostData postData3;
        PostData postData4;
        PostData postData5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048614, this, y48Var, z) != null) || y48Var == null) {
            return;
        }
        this.C = y48Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.clear();
        y48 y48Var2 = this.C;
        if (y48Var2 != null && y48Var2.H() != null && this.C.H().size() > 0) {
            this.D.addAll(this.C.H());
        }
        if (y48Var.Q() != null && y48Var.Q().getAuthor() != null) {
            this.P = y48Var.Q().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(y48Var);
        ArrayList<yn> arrayList = new ArrayList<>(y48Var.H());
        PostData p = p(arrayList);
        if (this.C.Q().isQuestionThread()) {
            postData = q(y48Var);
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
        if (!a27.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.C.u0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.Q = p;
        }
        if (!this.I && p != null) {
            arrayList.remove(p);
            if (y48Var.y0() && p.Z() != null) {
                p.b1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && y48Var.j() != null) {
            PostData j = y48Var.j();
            if (!this.I && y48Var.y0() && j.Z() != null) {
                j.b1(null);
            }
            if (!this.I && (postData5 = this.Q) != null && j.i0 == null) {
                y48Var.H0(postData5);
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
            if (y48Var.H().size() > 0 && (postData4 = y48Var.H().get(0)) != null && postData4.F() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        hw8.f(arrayList, 1);
        int A = A(y48Var, arrayList);
        if (A >= 0) {
            U(y48Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(y48Var, arrayList);
        if (F >= 0) {
            g58 g58Var = new g58(g58.c);
            g58Var.b(true);
            ListUtils.add(arrayList, F, g58Var);
        }
        int u = u(y48Var, arrayList);
        List<yn> v = v(y48Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            yn ynVar2 = (yn) ListUtils.getItem(arrayList, u);
            if (ynVar2 instanceof PostData) {
                ((PostData) ynVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(y48Var, arrayList, this.I);
        } else {
            i = -1;
        }
        if (i >= 0 && y48Var.U() != null) {
            PostData Z = y48Var.Z();
            ThreadData c2 = y48Var.U().c();
            if (Z != null && Z.o0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure o0 = Z.o0();
                VirtualImageCustomState p0 = Z.p0();
                c2.setCustomFigure(o0);
                c2.setCustomState(p0);
            }
            ListUtils.add(arrayList, i, y48Var.U());
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
        if (S(y48Var, postData2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && R(y48Var, arrayList, i) != null) {
            i++;
        }
        if (O(y48Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            yn V = V(arrayList, i);
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
                ynVar = M(arrayList, i5);
                if (ynVar != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = z11;
                ynVar = V;
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
                b88Var = null;
            } else {
                b88 T = T(arrayList, ynVar, i, i5);
                if (T != null) {
                    if (!z12) {
                        b88Var = T;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                b88Var = T;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            b88Var = null;
        }
        if (z2) {
            if (b88Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean N = N(y48Var, arrayList, z9, z10, i3, i6, u, A);
            if (b88Var != null) {
                b88Var.n = N;
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
        if (y48Var.U() != null) {
            y48Var.U().i(!z7);
        }
        if (this.b != null) {
            this.E = arrayList;
            List<yn> T2 = y48Var.T();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setData(H(arrayList, T2));
            } else {
                this.b.setData(this.E);
            }
        }
        e0(C0, z, i4, list);
        if (r(postData2, arrayList, z4)) {
            List<yn> T3 = y48Var.T();
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
            ArrayList<BdUniqueId> g = hw8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                mq7 b2 = rr7.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public final boolean r(PostData postData, ArrayList<yn> arrayList, boolean z) {
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
