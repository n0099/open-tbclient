package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class qz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public ThreadData C;
    public ArrayList<nwa> D;
    public v3a E;
    public final CustomMessageListener F;
    public final CustomMessageListener G;
    public final View.OnClickListener H;
    public CustomMessageListener I;
    public List<ci> J;
    public PbFragment a;
    public vv9 b;
    public ArrayList<nwa> c;
    public ArrayList<pi> d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public String o;
    public nwa p;
    public nwa q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public View.OnClickListener t;
    public TbRichTextView.z u;
    public View.OnClickListener v;
    public px9 w;
    public View.OnLongClickListener x;
    public SortSwitchButton.f y;
    public Runnable z;

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz9 a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.v();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qz9 qz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz9Var, Integer.valueOf(i)};
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
            this.a = qz9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && !a5.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qz9 qz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz9Var, Integer.valueOf(i)};
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
            this.a = qz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof lwa)) {
                lwa lwaVar = (lwa) customResponsedMessage.getData();
                if (this.a.C != null && this.a.C.funAdData == lwaVar) {
                    this.a.C.funAdData.p(true);
                    if (this.a.E.s() != null) {
                        this.a.E.s().setData(this.a.d);
                    }
                    this.a.v();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz9 a;

        public c(qz9 qz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.b != null && this.a.b.W() != null) {
                this.a.a.i7().c1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ qz9 b;

        public d(qz9 qz9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz9Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.E.s().setSelectionFromTop(this.b.E.s().getHeaderViewsCount() + this.a.size(), 0 - this.b.A);
                this.b.l = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(qz9 qz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz9Var, Integer.valueOf(i)};
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
            this.a = qz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.J)) {
                this.a.E.e(this.a.J);
                qz9 qz9Var = this.a;
                qz9Var.D(qz9Var.b, false);
            }
        }
    }

    public qz9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.c = new ArrayList<>();
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = false;
        this.m = false;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.A = 0;
        this.B = -1;
        this.D = new ArrayList<>();
        this.F = new a(this, 2921523);
        this.G = new b(this, 2001118);
        this.H = new c(this);
        this.I = new e(this, 2016470);
        this.n = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        v3a v3aVar = new v3a(pbFragment, bdTypeListView);
        this.E = v3aVar;
        v3aVar.D(this.a, bdTypeListView);
        this.a.registerListener(this.F);
        i();
        pbFragment.registerListener(this.G);
        this.A = BdUtilHelper.getEquipmentHeight(this.a.getContext()) / 3;
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i = z;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.g = z;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h = z;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void M(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && this.E.n() != null) {
            this.E.n().x0(z);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.r = onClickListener;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.E.K(z);
        }
    }

    public void Q(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zVar) == null) {
            this.u = zVar;
        }
    }

    public void R(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onLongClickListener) == null) {
            this.x = onLongClickListener;
        }
    }

    public void S(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.y = fVar;
        }
    }

    public void T(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void U(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f = z;
        }
    }

    public void W(px9 px9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, px9Var) == null) {
            this.w = px9Var;
        }
    }

    public void Y(@NonNull vv9 vv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, vv9Var) == null) && this.E.w() != null) {
            this.E.w().h0(vv9Var);
        }
    }

    public final nwa j(vv9 vv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vv9Var)) == null) {
            if (vv9Var != null) {
                nwa X = vv9Var.X();
                this.q = X;
                return X;
            }
            return null;
        }
        return (nwa) invokeL.objValue;
    }

    public pi n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            return this.E.s().G(i);
        }
        return (pi) invokeI.objValue;
    }

    public BdUniqueId o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            if (this.E.s().G(i) != null) {
                return this.E.s().G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.E.G();
                        return;
                    }
                    return;
                }
                this.E.I();
                C(false);
                B();
                return;
            }
            this.E.H();
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && this.E.w() != null) {
            this.E.w().U(z);
        }
    }

    public final void A(boolean z, boolean z2, int i, List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.k || this.j) && i != -1 && !ListUtils.isEmpty(list) && !this.l) {
                this.z = new d(this, list);
                SafeHandler.getInst().post(this.z);
            }
        }
    }

    public void B() {
        nwa nwaVar;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != null && (nwaVar = this.p) != null && nwaVar.b0() != null && this.E.w() != null && this.E.w().Q() != null) {
            String T2 = this.b.T();
            String o = this.b.o();
            if (this.b.R() != null) {
                i = this.b.R().getThreadType();
            } else {
                i = 0;
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.l0() == null) {
                str = "";
            } else {
                str = this.a.l0().L0();
            }
            PbFragment pbFragment2 = this.a;
            if (pbFragment2 == null || pbFragment2.l0() == null) {
                str2 = "";
            } else {
                str2 = this.a.l0().x1();
            }
            no5.a().c(T2, o, this.p.b0(), this.E.w().Q().s, i, str, str2);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.a.i7() != null && this.a.u0() != null && this.a.u0().B1() != null) {
            uz9.a().f(this.a.u0().B1().h2(), this.E.u().y(), this.a.i7().i1(), this.a.u0().getPageStayDurationItem(), z, this.E.y().b(), this.a.getListView());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x0349  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(vv9 vv9Var, boolean z) {
        nwa nwaVar;
        boolean z2;
        boolean z3;
        nwa nwaVar2;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        boolean z8;
        int i2;
        int i3;
        boolean z9;
        l0a l0aVar;
        boolean z10;
        boolean z11;
        int i4;
        boolean z12;
        int i5;
        nwa nwaVar3;
        nwa nwaVar4;
        nwa nwaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, vv9Var, z) != null) || vv9Var == null) {
            return;
        }
        this.b = vv9Var;
        this.E.g(vv9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            w3a.u(this.b, this.a, this.h);
        }
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.clear();
        vv9 vv9Var2 = this.b;
        if (vv9Var2 != null && vv9Var2.I() != null && this.b.I().size() > 0) {
            this.c.addAll(this.b.I());
        }
        if (vv9Var.R() != null && vv9Var.R().getAuthor() != null) {
            this.o = vv9Var.R().getAuthor().getUserId();
        }
        if (this.E.w() == null && !i1a.z(this.a)) {
            return;
        }
        s(vv9Var);
        ArrayList<pi> arrayList = new ArrayList<>(vv9Var.I());
        nwa b2 = x3a.b(arrayList);
        if (this.b.R().isQuestionThread()) {
            nwaVar = j(vv9Var);
        } else {
            nwaVar = null;
        }
        if (nwaVar != null) {
            arrayList.remove(nwaVar);
        }
        if (b2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!s88.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.b.u0() && !ListUtils.isEmpty(arrayList)) {
            w3a.d(arrayList, z2, this.D, this.a, this.b);
        }
        if (b2 != null) {
            this.p = b2;
        }
        if (!this.h && b2 != null) {
            arrayList.remove(b2);
            if (vv9Var.y0() && b2.f0() != null) {
                b2.r1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && vv9Var.l() != null) {
            nwa l = vv9Var.l();
            if (!this.h && vv9Var.y0() && l.f0() != null) {
                l.r1(null);
            }
            boolean z13 = this.h;
            if ((!z13 || (z13 && this.j)) && (nwaVar5 = this.p) != null && l.t0 == null) {
                vv9Var.I0(nwaVar5);
                nwaVar2 = nwaVar5;
            } else {
                nwaVar2 = l;
            }
            z4 = true;
            z5 = true;
        } else {
            nwaVar2 = b2;
            z4 = z2;
            z5 = z3;
        }
        w3a.b(arrayList);
        if (this.a.Y6()) {
            if (vv9Var.I().size() > 0 && (nwaVar4 = vv9Var.I().get(0)) != null && nwaVar4.L() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int h = x3a.h(this.b, arrayList, this.h);
            if (h >= 0) {
                ListUtils.add(arrayList, h, this.b.F());
            }
        }
        int i6 = x3a.i(this.b, arrayList, this.h);
        if (i6 >= 0) {
            ListUtils.add(arrayList, i6, this.b.G());
        }
        ova.f(arrayList, 1);
        int f = x3a.f(vv9Var, arrayList);
        if (f >= 0) {
            w3a.p(vv9Var, arrayList, f, this.a);
            z6 = true;
        } else {
            z6 = false;
        }
        int k = x3a.k(vv9Var, arrayList, this.f);
        if (k >= 0) {
            fw9 fw9Var = new fw9(fw9.c);
            fw9Var.b(true);
            ListUtils.add(arrayList, k, fw9Var);
        }
        int d2 = x3a.d(vv9Var, arrayList, this.j, this.h, this.a);
        List<pi> e2 = x3a.e(vv9Var);
        if (!ListUtils.isEmpty(e2) && d2 >= 0) {
            pi piVar = (pi) ListUtils.getItem(arrayList, d2);
            if (piVar instanceof nwa) {
                ((nwa) piVar).R = true;
            }
            ListUtils.addAll(arrayList, d2, e2);
            z6 = true;
        }
        if (z4) {
            i = x3a.j(vv9Var, arrayList, this.h);
        } else {
            i = -1;
        }
        if (i >= 0 && vv9Var.V() != null) {
            nwa a0 = vv9Var.a0();
            ThreadData c2 = vv9Var.V().c();
            if (a0 != null && a0.w0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure w0 = a0.w0();
                VirtualImageCustomState x0 = a0.x0();
                c2.setCustomFigure(w0);
                c2.setCustomState(x0);
            }
            if (this.b.N() != null && c2 != null) {
                w3a.t(this.b, c2);
            }
            ListUtils.add(arrayList, i, vv9Var.V());
            z7 = true;
            z8 = true;
        } else {
            if (nwaVar2 != null) {
                nwaVar2.Q = true;
            }
            z7 = z6;
            z8 = false;
        }
        if ((this.b.R().isQuestionThread() && nwaVar != null) || (this.b.R().isQuestionThread() && this.q != null)) {
            if (nwaVar == null && (nwaVar3 = this.q) != null) {
                nwaVar = nwaVar3;
            }
            if (!arrayList.contains(nwaVar)) {
                i++;
                w3a.s(nwaVar, arrayList, i);
            }
        }
        if (w3a.j(vv9Var, arrayList, i) != null) {
            i++;
        }
        int i7 = i;
        if (w3a.k(vv9Var, nwaVar2, arrayList, i7, this.p, this.a)) {
            i7++;
        }
        if (w3a.g(vv9Var, arrayList, i7) != null) {
            i7++;
        }
        if (z4 && vv9Var.Q() != null && vv9Var.Q().similar_thread != null && vv9Var.Q().similar_thread.id.longValue() > 0) {
            w3a.r(vv9Var, arrayList, i7, this.a);
        } else {
            if (z4) {
                pi q = w3a.q(arrayList, i7, this.a, this.b);
                if (q != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    if (i7 >= 0) {
                        i5 = i7 + 1;
                    } else if (d2 >= 0) {
                        i5 = d2;
                    } else if (f >= 0) {
                        i5 = f;
                    } else {
                        i5 = -1;
                    }
                    q = w3a.e(arrayList, i5, this.b, this.a);
                    if (q != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    i4 = i5;
                } else {
                    i4 = -1;
                }
                if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12 && this.b.u0()) {
                    this.B = i4;
                    if (w3a.h(arrayList, i4, this.b, this.C, this.a) != null) {
                        this.B = -1;
                        i7++;
                    }
                }
                if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                    z9 = z11;
                    i2 = i4;
                    i3 = i7;
                } else {
                    l0a o = w3a.o(arrayList, q, i7, i4, this.b);
                    if (o != null) {
                        if (!z11) {
                            l0aVar = o;
                            i2 = i4;
                            i3 = i7;
                            z9 = true;
                            if (z4) {
                                if (l0aVar != null) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                boolean f2 = w3a.f(vv9Var, arrayList, z9, z10, i2, i3, d2, f);
                                if (l0aVar != null) {
                                    l0aVar.n = f2;
                                }
                            }
                        } else if (i4 > 0) {
                            i4++;
                        } else {
                            i7++;
                        }
                    }
                    l0aVar = o;
                    z9 = z11;
                    i2 = i4;
                    i3 = i7;
                    if (z4) {
                    }
                }
            } else {
                i2 = -1;
                i3 = i7;
                z9 = false;
            }
            l0aVar = null;
            if (z4) {
            }
        }
        if (i1a.z(this.a)) {
            bw9 bw9Var = new bw9();
            if (vv9Var.R().getTaskInfoData() != null) {
                bw9Var.f(vv9Var.R().getTaskInfoData().r());
                bw9Var.e(vv9Var.R().getTaskInfoData().q());
            }
            zf9.b(arrayList, bw9Var, 0);
            if (!z8 && vv9Var.V() != null) {
                nwa a02 = vv9Var.a0();
                ThreadData c3 = vv9Var.V().c();
                if (a02 != null && a02.w0() != null && c3 != null && c3.getCustomFigure() == null) {
                    VirtualImageCustomFigure w02 = a02.w0();
                    VirtualImageCustomState x02 = a02.x0();
                    c3.setCustomFigure(w02);
                    c3.setCustomState(x02);
                }
                w3a.t(this.b, c3);
                ListUtils.add(arrayList, 1, vv9Var.V());
                z7 = true;
                z8 = true;
            }
        }
        if (this.E.w() != null) {
            this.E.w().d0(!z7);
        }
        boolean Z = Z(nwaVar2);
        if (this.i && !Z) {
            arrayList.remove(nwaVar2);
            this.i = false;
        }
        if (vv9Var.V() != null) {
            vv9Var.V().h(!z8);
        }
        x3a.a(arrayList);
        if (this.E.s() != null) {
            this.d = arrayList;
            List<pi> U = vv9Var.U();
            if (!ListUtils.isEmpty(U)) {
                this.E.L(arrayList, U);
            } else {
                this.E.s().setData(this.d);
            }
        }
        A(Z, z, d2, e2);
        if (x3a.c(nwaVar2, arrayList, z5, this.p, this.j)) {
            List<pi> U2 = vv9Var.U();
            if (!ListUtils.isEmpty(U2)) {
                this.E.L(arrayList, U2);
            } else {
                this.E.s().setData(arrayList);
            }
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e = z;
            if (this.E.w() != null) {
                this.E.w().setFromCDN(z);
            }
            if (this.E.l() != null && (this.E.l() instanceof mha)) {
                ((mha) this.E.l()).setIsFromCDN(z);
            }
            Iterator<jy9> it = this.E.p().iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.E.t() != null) {
            this.E.t().A(2);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.a != null && !this.E.e(this.J)) {
            this.a.registerListener(this.I);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.E.y().b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<pi> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.E.s().getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.E.o();
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.E.B();
        }
        return invokeV.intValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.E.k();
        }
        return (View) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.E.F();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.z);
            this.E.J();
        }
    }

    public final boolean Z(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, nwaVar)) == null) {
            if (this.a.l0() != null && nwaVar != null && nwaVar.U() != null && nwaVar.U().equals(this.a.l0().S1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (i = this.B) > 0 && w3a.h(this.d, i, this.b, this.C, this.a) != null) {
            this.B = -1;
            this.E.s().setData(this.d);
            v();
        }
    }

    public final void s(@NonNull vv9 vv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, vv9Var) == null) {
            if (this.E.w() != null) {
                this.E.w().s(vv9Var);
                this.E.w().setFromCDN(this.e);
                this.E.w().l(this.n);
                this.E.w().c(this.g);
                this.E.w().e(this.s);
                this.E.w().k(this.r);
                this.E.w().o(this.u);
                this.E.w().d(this.x);
                this.E.w().c0(this.v);
                this.E.w().e0(this.w);
            }
            this.E.i().z(this.v);
            this.E.n().s(vv9Var);
            this.E.n().setFromCDN(this.e);
            this.E.n().p(this.o);
            this.E.n().c(this.g);
            this.E.n().e(this.s);
            this.E.n().k(this.r);
            this.E.n().o(this.u);
            this.E.n().d(this.x);
            this.E.n().z0(this.w);
            this.E.C().s(vv9Var);
            this.E.C().setFromCDN(this.e);
            this.E.C().p(this.o);
            this.E.C().c(this.g);
            this.E.C().e(this.s);
            this.E.C().k(this.r);
            this.E.C().o(this.u);
            this.E.C().d(this.x);
            this.E.C().z0(this.w);
            this.E.h().s(vv9Var);
            this.E.o().X(this.s);
            this.E.A().z(this.s);
            this.E.q().z(this.H);
            if (this.E.l() != null && (this.E.l() instanceof mha)) {
                ((mha) this.E.l()).setIsFromCDN(this.e);
            }
            Iterator<jy9> it = this.E.p().iterator();
            while (it.hasNext()) {
                jy9 next = it.next();
                if (next != null) {
                    next.s(vv9Var);
                    next.setFromCDN(this.e);
                    next.p(this.o);
                    next.l(this.n);
                    next.c(this.g);
                    next.f(this.h);
                    next.r(this.m);
                    next.e(this.s);
                    next.k(this.r);
                    next.o(this.u);
                    next.d(this.x);
                }
            }
            this.E.u().e(this.s);
            this.E.u().C(this.y);
            this.E.t().e(this.t);
            this.E.r().e(this.s);
            this.E.u().s(vv9Var);
            this.E.v().s(vv9Var);
            this.E.r().s(vv9Var);
            this.E.x().s(vv9Var);
            this.E.z().s(vv9Var);
            this.E.m().B(vv9Var);
            this.E.m().A(this.a.v1);
            this.E.j().z(vv9Var);
        }
    }

    public void x(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.i7() != null) {
            this.a.i7().s2(z, i);
        }
    }
}
