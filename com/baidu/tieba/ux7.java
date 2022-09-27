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
public class ux7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zw7 A;
    public jv7 B;
    public ArrayList<PostData> C;
    public ArrayList<Cdo> D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public String O;
    public PostData P;
    public PostData Q;
    public View.OnClickListener R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    public TbRichTextView.y U;
    public View.OnClickListener V;
    public lw7 W;
    public View.OnLongClickListener X;
    public SortSwitchButton.f Y;
    public final List<qn> Z;
    public PbFragment a;
    public final List<qn> a0;
    public BdTypeListView b;
    public Runnable b0;
    public ey7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public ThreadData f0;
    public vz7 g;
    public List<PostData> g0;
    public dz7 h;
    public final CustomMessageListener h0;
    public ry7 i;
    public CustomMessageListener i0;
    public dz7 j;
    public final CustomMessageListener j0;
    public yx7 k;
    public final View.OnClickListener k0;
    public hz7 l;
    public CustomMessageListener l0;
    public k28 m;
    public List<qn> m0;
    public e36 n;
    public qn o;
    public qn p;
    public qn q;
    public qn r;
    public qn s;
    public zy7 t;
    public bz7 u;
    public yy7 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<yw7> x;
    public vx7 y;
    public ly7 z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof in8)) {
                return;
            }
            in8 in8Var = (in8) customResponsedMessage.getData();
            if (this.a.f0 == null || this.a.f0.funAdData != in8Var) {
                return;
            }
            this.a.f0.funAdData.p(true);
            this.a.b.setData(this.a.D);
            this.a.a0();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof zm8)) {
                AbsDelegateAdapterList a = ((zm8) customResponsedMessage.getData()).a();
                Iterator<qn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    qn<?, ?> next = it.next();
                    if (next instanceof ay7) {
                        ((ay7) next).t(this.a.a);
                        if (next instanceof yw7) {
                            this.a.x.add((yw7) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.a0.clear();
                this.a.a0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

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
        public c(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.B == null || w9.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
                return;
            }
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public d(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.B == null || this.a.B.T() == null) {
                return;
            }
            this.a.a.P5().W0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ ux7 b;

        public e(ux7 ux7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.d0);
                this.b.L = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.m0)) {
                this.a.n();
                ux7 ux7Var = this.a;
                ux7Var.i0(ux7Var.B, false);
            }
        }
    }

    public ux7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.C = new ArrayList<>();
        this.E = false;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = false;
        this.M = false;
        this.N = 0;
        this.O = null;
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
        this.Z = new ArrayList();
        this.a0 = new ArrayList();
        this.c0 = -1;
        this.d0 = 0;
        this.e0 = -1;
        this.g0 = new ArrayList();
        this.h0 = new a(this, 2921523);
        this.i0 = new b(this, 2004015);
        this.j0 = new c(this, 2001118);
        this.k0 = new d(this);
        this.l0 = new f(this, 2016470);
        this.N = ej.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.j0);
        this.d0 = ej.i(this.a.getContext()) / 3;
    }

    public final int A(jv7 jv7Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jv7Var, arrayList)) == null) {
            if (jv7Var == null || ListUtils.isEmpty(jv7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(jv7Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    i = 0;
                    break;
                }
                Cdo cdo = arrayList.get(i);
                if (cdo instanceof PostData) {
                    PostData postData = (PostData) cdo;
                    if (postData.C() == 1 && postData.N == 0) {
                        z = true;
                        break;
                    }
                }
                i++;
            }
            if (z) {
                return i + 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public void A0(lw7 lw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lw7Var) == null) {
            this.W = lw7Var;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i = 0; i < this.b.getData().size(); i++) {
                Cdo cdo = this.b.getData().get(i);
                if (cdo != null && cdo.getType() == wv7.i) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0() {
        ry7 ry7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ry7Var = this.i) == null) {
            return;
        }
        ry7Var.x(2);
    }

    public int C(jv7 jv7Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, jv7Var, arrayList, z)) == null) {
            if (jv7Var == null || jv7Var.F() == null || jv7Var.D() == null || jv7Var.F().size() == 0 || jv7Var.O() == null || arrayList == null || !jv7Var.D().j1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (jv7Var.F().get(0) == null || jv7Var.F().get(0).C() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (jv7Var.y() == null || jv7Var.y().a() != jv7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) ? (this.a.K() == null || postData == null || postData.L() == null || !postData.L().equals(this.a.K().s2())) ? false : true : invokeL.booleanValue;
    }

    public int D(jv7 jv7Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, jv7Var, arrayList, z)) == null) {
            if (jv7Var == null || jv7Var.F() == null || jv7Var.E() == null || jv7Var.F().size() == 0 || jv7Var.O() == null || arrayList == null || !jv7Var.E().j1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (jv7Var.F().get(0) == null || jv7Var.F().get(0).C() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (jv7Var.y() == null || jv7Var.y().a() != jv7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void D0() {
        jv7 jv7Var;
        jn8 jn8Var;
        jn8 jn8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jv7Var = this.B) == null || jv7Var.b0 || jv7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = jv7Var.F();
        ArrayList<jn8> e2 = this.B.e();
        if (ah7.e(F) || ah7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<jn8> it = e2.iterator();
        while (it.hasNext()) {
            jn8 next = it.next();
            if (next != null && next.k1() != null) {
                sb.append(next.k1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<jn8> it2 = e2.iterator();
        while (it2.hasNext()) {
            jn8 next2 = it2.next();
            if (next2 != null) {
                next2.c1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<jn8> it3 = e2.iterator();
        while (it3.hasNext()) {
            jn8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    of8.j(next3, n);
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
            jn8 jn8Var3 = (jn8) sparseArray.valueAt(i);
            if (jn8Var3 != null && (jn8Var2 = (jn8) hashMap.put(jn8Var3.j1(), jn8Var3)) != null) {
                of8.j(jn8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (jn8Var = (jn8) entry.getValue()) != null) {
                sparseArray.put(jn8Var.getPosition(), jn8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            ah7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        int i3 = 1;
        for (int i4 = 0; i4 < ah7.i(arrayList); i4++) {
            jn8 jn8Var4 = (jn8) sparseArray.get(((Integer) ah7.d(arrayList, i4)).intValue());
            if (this.B.l() != null) {
                jn8Var4.W0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                jn8Var4.Z0 = dh.g(this.B.O().getId(), 0L);
            }
            jv7 jv7Var2 = this.B;
            if (jv7Var2 != null && jv7Var2.y() != null) {
                jn8Var4.a1 = this.B.y().a();
            }
            l(jn8Var4);
            int position = jn8Var4.getPosition() + this.B.a0;
            if (position >= ah7.i(F)) {
                jn8Var4.c1 = position;
                of8.k(jn8Var4, 2, position, ah7.i(F));
                return;
            }
            if (!this.H) {
                position--;
                jn8Var4.c1 = position;
            }
            if (position < 0) {
                of8.j(jn8Var4, 23);
            } else {
                jn8Var4.d1 = i3;
                ah7.b(F, jn8Var4, position);
                i3++;
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", jn8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void E0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (i = this.e0) <= 0 || Q(this.D, i) == null) {
            return;
        }
        this.e0 = -1;
        this.b.setData(this.D);
        a0();
    }

    public final int F(jv7 jv7Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, jv7Var, arrayList, z)) == null) {
            if (jv7Var == null || ListUtils.isEmpty(jv7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (jv7Var == null || !jv7Var.u0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (jv7Var.F().get(0) == null || jv7Var.F().get(0).C() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(jv7 jv7Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, jv7Var, arrayList)) == null) {
            int i = -1;
            if (jv7Var == null || jv7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = jv7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.F) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof wv7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return jv7Var.L() == 4 ? i + 1 : i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c0 : invokeV.intValue;
    }

    public final ArrayList<Cdo> I(List<Cdo> list, List<Cdo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            pv7 pv7Var = new pv7();
            PbListView a1 = this.a.P5().a1();
            if (a1 != null && a1.n()) {
                pv7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dfc);
                pv7Var.b = true;
            } else {
                pv7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09ff);
                pv7Var.b = false;
            }
            arrayList.add(pv7Var);
            h36 h36Var = new h36();
            h36Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb2);
            h36Var.needTopMargin = false;
            arrayList.add(h36Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ey7 ey7Var = this.c;
            if (ey7Var == null || ey7Var.I() == null) {
                return null;
            }
            if (this.c.I().A != null && this.c.I().A.isShown()) {
                return this.c.I().A;
            }
            return this.c.I().z;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<Cdo> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = m05.i();
        int j = m05.j() - 1;
        if (bool.booleanValue()) {
            Cdo cdo = arrayList.get(0);
            if ((cdo instanceof PostData) && ((PostData) cdo).C() == 1) {
                j++;
            }
        }
        int k = m05.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.K() != null && this.a.K().c2() == 3) {
            this.g0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbFragment, bdTypeListView) == null) {
            ey7 ey7Var = new ey7(pbFragment, PostData.K0);
            this.c = ey7Var;
            ey7Var.W(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, xv7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, lv7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), mv7.c);
            this.g = new vz7(pbFragment, ev7.c);
            this.h = new dz7(pbFragment, wv7.i);
            this.i = new ry7(pbFragment, rv7.c);
            this.j = new dz7(pbFragment, wv7.j);
            yx7 yx7Var = new yx7(pbFragment, PostData.L0);
            this.k = yx7Var;
            yx7Var.v0(pbFragment);
            hz7 hz7Var = new hz7(pbFragment, PostData.M0);
            this.l = hz7Var;
            hz7Var.s0(pbFragment);
            this.o = be8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = be8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = xu6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = xu6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = xu6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new yy7(pbFragment, tv7.a1);
            this.t = new zy7(pbFragment, xy7.X0);
            this.u = new bz7(pbFragment, dt4.d1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.S0);
            this.m = new k28(pbFragment, l28.a);
            this.n = new e36(pbFragment.getPageContext());
            this.y = new vx7(pbFragment, pr4.e);
            this.z = new ly7(pbFragment, pbFragment.getUniqueId());
            zw7 zw7Var = new zw7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.A = zw7Var;
            this.Z.addAll(zw7Var.a());
            this.Z.add(this.c);
            this.Z.add(this.d);
            this.Z.add(this.e);
            this.Z.add(this.f);
            this.Z.add(this.g);
            this.Z.add(this.k);
            this.Z.add(this.l);
            this.Z.add(this.h);
            this.Z.add(this.i);
            this.Z.add(this.j);
            this.Z.add(this.o);
            this.Z.add(this.p);
            this.Z.add(this.q);
            this.Z.add(this.r);
            this.Z.add(this.s);
            this.Z.add(this.v);
            this.Z.add(this.t);
            this.Z.add(this.u);
            this.Z.add(this.m);
            this.Z.add(this.w);
            this.Z.add(this.n);
            this.Z.add(this.y);
            this.Z.add(this.z);
            this.Z.add(new PbPrivateTitleAdapter(pbFragment));
            this.i0.setPriority(1);
            this.i0.setSelfListener(true);
            pbFragment.registerListener(this.i0);
            pbFragment.registerListener(this.h0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new zm8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.Z);
        }
    }

    public final void M(@NonNull jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jv7Var) == null) {
            this.c.r(jv7Var);
            this.c.setFromCDN(this.E);
            this.c.l(this.N);
            this.c.c(this.G);
            this.c.e(this.S);
            this.c.k(this.R);
            this.c.n(this.U);
            this.c.d(this.X);
            this.c.T(this.V);
            this.c.V(this.W);
            this.f.w(this.V);
            this.k.r(jv7Var);
            this.k.setFromCDN(this.E);
            this.k.o(this.O);
            this.k.c(this.G);
            this.k.e(this.S);
            this.k.k(this.R);
            this.k.n(this.U);
            this.k.d(this.X);
            this.k.u0(this.W);
            this.l.r(jv7Var);
            this.l.setFromCDN(this.E);
            this.l.o(this.O);
            this.l.c(this.G);
            this.l.e(this.S);
            this.l.k(this.R);
            this.l.n(this.U);
            this.l.d(this.X);
            this.l.r0(this.W);
            this.d.G(this.S);
            this.w.w(this.S);
            this.m.w(this.k0);
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof xd8)) {
                ((xd8) qnVar).setIsFromCDN(this.E);
            }
            Iterator<yw7> it = this.x.iterator();
            while (it.hasNext()) {
                yw7 next = it.next();
                if (next != null) {
                    next.r(jv7Var);
                    next.setFromCDN(this.E);
                    next.o(this.O);
                    next.l(this.N);
                    next.c(this.G);
                    next.f(this.H);
                    next.q(this.M);
                    next.e(this.S);
                    next.k(this.R);
                    next.n(this.U);
                    next.d(this.X);
                }
            }
            this.h.e(this.S);
            this.h.z(this.Y);
            this.i.e(this.T);
            this.j.e(this.S);
            this.h.r(jv7Var);
            this.g.r(jv7Var);
            this.j.r(jv7Var);
            this.t.r(jv7Var);
            this.u.r(jv7Var);
            this.y.y(jv7Var);
            this.y.x(this.a.r1);
            this.z.w(jv7Var);
            this.A.f(jv7Var);
        }
    }

    public final Cdo N(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (this.B == null) {
                return null;
            }
            jn8 l1 = this.a.K().l1();
            if (l1 == null) {
                l1 = this.B.z();
            }
            if (l1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert m1 = l1.m1();
            if (m1 != null) {
                m1.setAdvertAppInfo(l1.getAdvertAppInfo());
            }
            int n = l1.getAdvertAppInfo().n();
            if (n != 0) {
                of8.j(l1, n);
                if (n != 28 && n != 31) {
                    l1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.B.l() != null) {
                l1.W0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                l1.Z0 = dh.g(this.B.O().getId(), 0L);
            }
            jv7 jv7Var = this.B;
            if (jv7Var != null && jv7Var.y() != null) {
                l1.a1 = this.B.y().a();
            }
            l(l1);
            if (i >= 0) {
                l1.d1 = 1;
                bp5.k().q(true);
                ah7.b(arrayList, l1, i);
                return l1;
            }
            return null;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final boolean O(jv7 jv7Var, ArrayList<Cdo> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{jv7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(jv7Var.f()) && jv7Var.f().size() > 2) {
                int min = Math.min(jv7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    pr4 pr4Var = jv7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        pr4Var.n(true);
                    }
                    if (pr4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            pr4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        pr4Var.s(true);
                    } else if (i5 == min - 1) {
                        pr4Var.r(true);
                    }
                    arrayList2.add(pr4Var);
                }
            }
            if (arrayList2.size() > 0) {
                int i6 = (!z || i < 0) ? z ? i2 + 2 : i2 >= 0 ? i2 + 1 : i3 >= 0 ? i3 : i4 >= 0 ? i4 : -1 : i + 1;
                if (i6 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i6, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final Cdo P(jv7 jv7Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        ev7 ev7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, jv7Var, arrayList, i)) == null) {
            if (i < 0 || jv7Var == null || !jv7Var.k || (ev7Var = jv7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, ev7Var);
            return ev7Var;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final Cdo Q(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        jv7 jv7Var;
        in8 in8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (jv7Var = this.B) != null && jv7Var.q0()) {
                String d2 = cv6.e().d("pb_banner");
                if (this.f0 == null && wu6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.f0 = threadData;
                    threadData.funAdData = new in8();
                    jv7 jv7Var2 = this.B;
                    if (jv7Var2 != null) {
                        this.f0.funAdData.m(jv7Var2.m());
                        this.f0.funAdData.r(this.B.Q());
                    }
                }
                ThreadData threadData2 = this.f0;
                if (threadData2 != null && (in8Var = threadData2.funAdData) != null) {
                    in8Var.j(1);
                    bp5.k().q(true);
                    ListUtils.add(arrayList, i, this.f0);
                }
            }
            return this.f0;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<Cdo> listIterator = arrayList.listIterator();
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                if (i5 >= i3) {
                    break;
                }
                if (i5 < this.g0.size()) {
                    listIterator.add(this.g0.get(i5));
                } else {
                    PostData postData = new PostData();
                    in8 in8Var = new in8();
                    jv7 jv7Var = this.B;
                    in8Var.m(jv7Var != null ? jv7Var.m() : "");
                    jv7 jv7Var2 = this.B;
                    in8Var.r(jv7Var2 != null ? jv7Var2.Q() : "");
                    in8Var.n(true);
                    postData.u0 = in8Var;
                    in8Var.j(i6);
                    listIterator.add(postData);
                    i6++;
                    this.g0.add(postData);
                }
                i5++;
            }
            listIterator.next();
            i4++;
        }
        if (i4 != i || i5 >= i3) {
            return;
        }
        PostData postData2 = new PostData();
        in8 in8Var2 = new in8();
        jv7 jv7Var3 = this.B;
        in8Var2.m(jv7Var3 != null ? jv7Var3.m() : "");
        jv7 jv7Var4 = this.B;
        in8Var2.r(jv7Var4 != null ? jv7Var4.Q() : "");
        in8Var2.n(true);
        postData2.u0 = in8Var2;
        in8Var2.j(1);
        listIterator.add(postData2);
        this.g0.add(postData2);
    }

    public final Cdo S(jv7 jv7Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        lv7 lv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, jv7Var, arrayList, i)) == null) {
            if (jv7Var.l() == null || StringUtils.isNull(jv7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(jv7Var.l().getName(), this.a.K().r1()) && this.a.K().x1()) {
                return null;
            }
            if (!this.a.u0() && !ListUtils.isEmpty(jv7Var.p())) {
                lv7Var = new lv7(jv7Var.p().get(0));
            } else {
                lv7Var = new lv7(jv7Var.l());
            }
            lv7Var.g = this.a.K().m2();
            ListUtils.add(arrayList, i + 1, lv7Var);
            return lv7Var;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final Cdo T(jv7 jv7Var, PostData postData, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048600, this, jv7Var, postData, arrayList, i)) == null) {
            mv7 mv7Var = null;
            if (jv7Var.l() == null || StringUtils.isNull(jv7Var.l().getName()) || !TextUtils.equals(jv7Var.l().getName(), this.a.K().r1()) || !this.a.K().x1()) {
                if (postData != null) {
                    if (postData.j0 != null) {
                        mv7Var = new mv7(postData.j0);
                    }
                } else {
                    PostData postData2 = this.P;
                    if (postData2 != null && postData2.j0 != null) {
                        mv7Var = new mv7(this.P.j0);
                    }
                }
                if (mv7Var != null) {
                    mv7Var.b = this.a.K().m2();
                    ListUtils.add(arrayList, i + 1, mv7Var);
                }
                return mv7Var;
            }
            return null;
        }
        return (Cdo) invokeLLLI.objValue;
    }

    public final my7 U(ArrayList<Cdo> arrayList, Cdo cdo, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048601, this, arrayList, cdo, i, i2)) == null) {
            my7 B = this.B.B();
            if (B != null) {
                if (cdo != null) {
                    if (i2 >= 0 || cdo.getType() == AdvertAppInfo.z) {
                        i2 = cdo.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof my7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (my7) invokeLLII.objValue;
    }

    public final void V(jv7 jv7Var, ArrayList<Cdo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, jv7Var, arrayList, i) == null) {
            wv7 wv7Var = new wv7(wv7.i);
            ThreadData O = jv7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            wv7Var.d = this.a.l6();
            wv7Var.c = jv7Var.g;
            jv7Var.c();
            wv7Var.e = jv7Var.i0();
            wv7Var.g = jv7Var.f;
            wv7Var.h = O != null && O.isQuestionThread();
            ListUtils.add(arrayList, i, wv7Var);
            if (jv7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new vv7());
            }
        }
    }

    public final Cdo W(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, arrayList, i)) == null) {
            if (i < 0 || (K = this.a.K()) == null || TextUtils.isEmpty(K.W1())) {
                return null;
            }
            jn8 jn8Var = new jn8();
            l(jn8Var);
            ListUtils.add(arrayList, i + 1, jn8Var);
            return jn8Var;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final void X(PostData postData, ArrayList<Cdo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, postData, arrayList, i) == null) {
            postData.b1(true);
            arrayList.add(i, postData);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.c0 = B();
            if (this.b.getAdapter2() instanceof un) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == 1) {
                ey7 ey7Var = this.c;
                if (ey7Var != null) {
                    ey7Var.P();
                }
                qn qnVar = this.p;
                if (qnVar instanceof sd8) {
                    ((sd8) qnVar).onPause();
                }
                qn qnVar2 = this.q;
                if (qnVar2 instanceof sd8) {
                    ((sd8) qnVar2).onPause();
                }
                qn qnVar3 = this.s;
                if (qnVar3 instanceof sd8) {
                    ((sd8) qnVar3).onPause();
                }
                zx7.a().j(this.a.P());
                jc5.a().d();
            } else if (i == 2) {
                ey7 ey7Var2 = this.c;
                if (ey7Var2 != null) {
                    ey7Var2.R();
                }
                qn qnVar4 = this.p;
                if (qnVar4 instanceof sd8) {
                    ((sd8) qnVar4).onResume();
                }
                qn qnVar5 = this.q;
                if (qnVar5 instanceof sd8) {
                    ((sd8) qnVar5).onResume();
                }
                qn qnVar6 = this.s;
                if (qnVar6 instanceof sd8) {
                    ((sd8) qnVar6).onResume();
                }
                h0(false);
                g0();
            } else if (i != 3) {
            } else {
                ey7 ey7Var3 = this.c;
                if (ey7Var3 != null) {
                    ey7Var3.Q();
                }
                qn qnVar7 = this.p;
                if (qnVar7 instanceof sd8) {
                    ((sd8) qnVar7).onDestroy();
                }
                qn qnVar8 = this.q;
                if (qnVar8 instanceof sd8) {
                    ((sd8) qnVar8).onDestroy();
                }
                qn qnVar9 = this.s;
                if (qnVar9 instanceof sd8) {
                    ((sd8) qnVar9).onDestroy();
                }
                zx7.a().d();
            }
        }
    }

    public void c0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (pbFragment = this.a) == null || pbFragment.P5() == null) {
            return;
        }
        this.a.P5().c2(z, i);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            gh.a().removeCallbacks(this.b0);
            dz7 dz7Var = this.h;
            if (dz7Var != null) {
                dz7Var.onDestroy();
            }
            dz7 dz7Var2 = this.j;
            if (dz7Var2 != null) {
                dz7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            vz7 vz7Var = this.g;
            if (vz7Var != null) {
                vz7Var.onDestroy();
            }
            bp5.k().q(false);
        }
    }

    public void e0(boolean z) {
        ey7 ey7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (ey7Var = this.c) == null) {
            return;
        }
        ey7Var.O(z);
    }

    public final void f0(boolean z, boolean z2, int i, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.K && !this.J) || i == -1 || ListUtils.isEmpty(list) || this.L) {
            return;
        }
        this.b0 = new e(this, list);
        gh.a().post(this.b0);
    }

    public void g0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.B == null || (postData = this.P) == null || postData.T() == null || this.c.I() == null) {
            return;
        }
        jc5.a().c(this.B.Q(), this.B.m(), this.P.T(), this.c.I().t, this.B.O() != null ? this.B.O().getThreadType() : 0);
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || this.a.P5() == null || this.a.P() == null || this.a.P().j1() == null) {
            return;
        }
        zx7.a().g(this.a.P().j1().D2(), this.h.v(), this.a.P5().c1(), this.a.P().getPageStayDurationItem(), z, this.A.b(), this.a.getListView());
    }

    public void i0(jv7 jv7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        my7 my7Var;
        boolean z7;
        List<Cdo> list;
        int i3;
        Cdo cdo;
        int i4;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048615, this, jv7Var, z) == null) || jv7Var == null) {
            return;
        }
        this.B = jv7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.clear();
        jv7 jv7Var2 = this.B;
        if (jv7Var2 != null && jv7Var2.F() != null && this.B.F().size() > 0) {
            this.C.addAll(this.B.F());
        }
        if (jv7Var.O() != null && jv7Var.O().getAuthor() != null) {
            this.O = jv7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(jv7Var);
        ArrayList<Cdo> arrayList = new ArrayList<>(jv7Var.F());
        PostData p = p(arrayList);
        PostData q = this.B.O().isQuestionThread() ? q(jv7Var) : null;
        if (q != null) {
            arrayList.remove(q);
        }
        boolean z8 = p != null;
        if (!dv6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.B.q0()) {
            K(arrayList, Boolean.valueOf(z8));
        }
        if (p != null) {
            this.P = p;
        }
        if (this.H || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (jv7Var.u0() && p.W() != null) {
                p.V0(null);
            }
            z8 = true;
            z2 = true;
        }
        if (z8 || jv7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = jv7Var.j();
            if (!this.H && jv7Var.u0() && j.W() != null) {
                j.V0(null);
            }
            if (this.H || (postData4 = this.P) == null || j.h0 != null) {
                postData = j;
            } else {
                jv7Var.D0(postData4);
                postData = postData4;
            }
            z8 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.C5()) {
            if (jv7Var.F().size() > 0 && (postData3 = jv7Var.F().get(0)) != null && postData3.C() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.B, arrayList, this.H);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.B.D());
            }
        }
        int D = D(this.B, arrayList, this.H);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.B.E());
        }
        jm8.f(arrayList, 1);
        int A = A(jv7Var, arrayList);
        if (A >= 0) {
            V(jv7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(jv7Var, arrayList);
        if (G >= 0) {
            rv7 rv7Var = new rv7(rv7.c);
            rv7Var.b(true);
            ListUtils.add(arrayList, G, rv7Var);
        }
        int u = u(jv7Var, arrayList);
        List<Cdo> v = v(jv7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, u);
            if (cdo2 instanceof PostData) {
                ((PostData) cdo2).Q = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z8 ? F(jv7Var, arrayList, this.H) : -1;
        if (F < 0 || jv7Var.S() == null) {
            if (postData != null) {
                postData.P = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, jv7Var.S());
            z5 = true;
            z6 = true;
        }
        if ((this.B.O().isQuestionThread() && q != null) || (this.B.O().isQuestionThread() && this.Q != null)) {
            if (q == null && (postData2 = this.Q) != null) {
                q = postData2;
            }
            if (!arrayList.contains(q)) {
                F++;
                X(q, arrayList, F);
            }
        }
        boolean z9 = T(jv7Var, postData, arrayList, F) != null;
        if (z9) {
            F++;
        }
        if (!z9 && S(jv7Var, arrayList, F) != null) {
            F++;
        }
        if (P(jv7Var, arrayList, F) != null) {
            F++;
        }
        if (z8) {
            Cdo W = W(arrayList, F);
            boolean z10 = W != null;
            if (z10) {
                z7 = z10;
                cdo = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                cdo = N(arrayList, i4);
                z7 = cdo != null;
            }
            boolean z11 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z11 && this.B.q0()) {
                this.e0 = i4;
                if (Q(arrayList, i4) != null) {
                    this.e0 = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z11) {
                i = F;
                my7Var = null;
            } else {
                my7 U = U(arrayList, cdo, F, i4);
                if (U != null) {
                    if (!z7) {
                        my7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                my7Var = U;
                i = F;
            }
            i2 = i4;
        } else {
            i = F;
            i2 = -1;
            my7Var = null;
            z7 = false;
        }
        if (z8) {
            list = v;
            i3 = u;
            boolean O = O(jv7Var, arrayList, z7, my7Var != null, i2, i, u, A);
            if (my7Var != null) {
                my7Var.n = O;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.c.U(!z5);
        boolean C0 = C0(postData);
        if (this.I && !C0) {
            arrayList.remove(postData);
            this.I = false;
        }
        if (jv7Var.S() != null) {
            jv7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.D = arrayList;
            List<Cdo> R = jv7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.D);
            }
        }
        f0(C0, z, i3, list);
        if (r(postData, arrayList, z3)) {
            List<Cdo> R2 = jv7Var.R();
            if (!ListUtils.isEmpty(R2)) {
                this.b.setData(I(arrayList, R2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.E = z;
            this.c.setFromCDN(z);
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof xd8)) {
                ((xd8) qnVar).setIsFromCDN(z);
            }
            Iterator<yw7> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.I = z;
        }
    }

    public final void l(jn8 jn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, jn8Var) == null) || jn8Var == null || this.B == null || jn8Var.getAdvertAppInfo() == null) {
            return;
        }
        jn8Var.getAdvertAppInfo().i = new dr4();
        if (this.B.y() != null) {
            jn8Var.getAdvertAppInfo().i.b = this.B.y().a();
        }
        jn8Var.getAdvertAppInfo().i.a = jn8Var.l1();
        if (this.B.l() != null && (l = this.B.l()) != null) {
            jn8Var.getAdvertAppInfo().i.c = l.getId();
            jn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            jn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            jn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        jn8Var.getAdvertAppInfo().i.g = jn8Var.getAdvertAppInfo().g;
        jn8Var.getAdvertAppInfo().i.h = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.G = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.l0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.M = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.m0 = new ArrayList();
            ArrayList<BdUniqueId> g = jm8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                sg7 b2 = xh7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.Z.add(b2);
                    this.m0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.m0)) {
                return true;
            }
            this.b.a(this.m0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.J = z;
        }
    }

    public final void o(List<Cdo> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.R())) {
                    os4 os4Var = new os4();
                    os4Var.h(postData.R());
                    list.set(i, os4Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.K = z;
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
                    if (postData.C() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.H = z;
        }
    }

    public final PostData q(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.U() == null) {
                return null;
            }
            PostData U = jv7Var.U();
            this.Q = U;
            return U;
        }
        return (PostData) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.L = z;
        }
    }

    public final boolean r(PostData postData, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, postData, arrayList, z)) == null) {
            if (postData != null) {
                if (z) {
                    ListUtils.add(arrayList, 0, postData);
                    return true;
                }
                return false;
            }
            PostData postData2 = this.P;
            if (postData2 != null && !this.J) {
                ListUtils.add(arrayList, 0, postData2);
            } else {
                PostData postData3 = new PostData();
                postData3.D0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.A.b() : (View) invokeV.objValue;
    }

    public void s0(boolean z) {
        yx7 yx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || (yx7Var = this.k) == null) {
            return;
        }
        yx7Var.s0(z);
    }

    public ArrayList<Cdo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.D : (ArrayList) invokeV.objValue;
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final int u(jv7 jv7Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, jv7Var, arrayList)) == null) {
            if (this.J || jv7Var == null || ListUtils.isEmpty(jv7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (jv7Var != null && jv7Var.u0() && this.H) ? 0 : -1;
            } else if (this.a.K() == null || !this.a.K().B1()) {
                if (this.a.P5() == null || !this.a.P5().S0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        Cdo cdo = arrayList.get(i);
                        if (cdo instanceof PostData) {
                            PostData postData = (PostData) cdo;
                            if (postData.C() == 1 && postData.N == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? jv7Var.u0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            yx7 yx7Var = this.k;
            if (yx7Var != null) {
                yx7Var.t0(z);
            }
            dz7 dz7Var = this.h;
            if (dz7Var != null) {
                dz7Var.y(z);
            }
            qn qnVar = this.s;
            if (qnVar != null) {
                qnVar.setMulDel(z);
            }
            qn qnVar2 = this.p;
            if (qnVar2 != null) {
                qnVar2.setMulDel(z);
            }
            ey7 ey7Var = this.c;
            if (ey7Var != null) {
                ey7Var.setMulDel(z);
            }
        }
    }

    public final List<Cdo> v(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.T() == null || ListUtils.isEmpty(jv7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = jv7Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.b0 = true;
                    postData.O = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(jv7Var.T().b) > 2) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo instanceof PostData) {
                    ((PostData) cdo).O = false;
                }
                arrayList.add(new l28());
            } else {
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo2 instanceof PostData) {
                    ((PostData) cdo2).O = true;
                }
            }
            wv7 wv7Var = new wv7(wv7.j);
            wv7Var.a = jv7Var.T().c;
            arrayList.add(0, wv7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yVar) == null) {
            this.U = yVar;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.b.getHeaderViewsCount() : invokeV.intValue;
    }

    public void w0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.X = onLongClickListener;
        }
    }

    public Cdo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) ? this.b.G(i) : (Cdo) invokeI.objValue;
    }

    public void x0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) {
            this.Y = fVar;
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
            this.S = onClickListener;
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }
}
