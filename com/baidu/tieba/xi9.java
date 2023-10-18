package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.tbadk.switchs.NovelPaySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tg9;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FullLengthNovel;
import tbclient.Item;
import tbclient.ItemInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class xi9 extends qi9<pea, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public tg9 D;
    public bk6<jv4> E;
    public wr.a F;
    public zt G;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public ye9 l;
    public gn9 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.z p;
    public tg9 q;
    public View.OnLongClickListener r;
    public TbRichTextView.t s;
    public View.OnClickListener t;
    public boolean u;
    public final boolean v;
    public boolean w;
    public Context x;
    public boolean y;
    public int z;

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ xi9 b;

        /* loaded from: classes8.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    f fVar = this.a;
                    fVar.a.F.j(fVar.b.l.O());
                    this.a.a.F.g();
                }
            }
        }

        public f(xi9 xi9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var, pbFirstFloorViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xi9Var;
            this.a = pbFirstFloorViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.G != null) {
                    this.b.G.b();
                }
                if (this.b.l.O().getHasAgree() == 1) {
                    this.a.F.g();
                    return;
                }
                PbFragment pbFragment = this.b.b;
                if (pbFragment != null) {
                    pbFragment.J7(new a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements tg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi9 a;

        @Override // com.baidu.tieba.tg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(xi9 xi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi9Var;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.q != null) {
                    this.a.q.a(view2);
                    this.a.q.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, motionEvent));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends bk6<jv4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi9 b;

        public b(xi9 xi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xi9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, jv4Var) == null) {
                super.a(view2, jv4Var);
                if (jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null && this.b.l != null) {
                    OriginalThreadInfo originalThreadInfo = jv4Var.getThreadData().originalThreadData;
                    String Q = this.b.l.Q();
                    String str = originalThreadInfo.f;
                    int i = 1;
                    int i2 = originalThreadInfo.a;
                    if (i2 == 3) {
                        i = 2;
                    } else if (i2 == 4) {
                        i = 3;
                    }
                    if (!StringUtils.isNull(Q) && !StringUtils.isNull(str)) {
                        xn9.s("c12602", Q, str, i);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi9 a;

        public c(xi9 xi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi9Var;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                OriginalThreadInfo originalThreadInfo = jv4Var.getThreadData().originalThreadData;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.x);
                pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
                pbActivityConfig.setStartFrom(this.a.C);
                pbActivityConfig.setBjhData(originalThreadInfo.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye9 a;
        public final /* synthetic */ xi9 b;

        public d(xi9 xi9Var, ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var, ye9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xi9Var;
            this.a = ye9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.i0();
            BrowserHelper.startWebActivity(this.b.x, (String) null, this.a.t().link_url, true);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TbRichTextView.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ pea b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ SparseArray e;
        public final /* synthetic */ xi9 f;

        public e(xi9 xi9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar, View view2, int i, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var, pbFirstFloorViewHolder, peaVar, view2, Integer.valueOf(i), sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xi9Var;
            this.a = pbFirstFloorViewHolder;
            this.b = peaVar;
            this.c = view2;
            this.d = i;
            this.e = sparseArray;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.b0(this.a, this.b, this.c, this.d);
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.Z(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi9 a;

        public g(xi9 xi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.q != null) {
                    this.a.q.a(view2);
                    return this.a.q.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public h(xi9 xi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements zt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi9 a;

        public i(xi9 xi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi9Var;
        }

        @Override // com.baidu.tieba.zt
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.Q()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 2));
            }
        }

        @Override // com.baidu.tieba.zt
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.Q()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 1));
            }
        }

        @Override // com.baidu.tieba.zt
        public void onShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15022").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.Q()).param("fid", this.a.l.l()).param("obj_locate", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xi9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bo9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        boolean z = true;
        this.h = true;
        this.i = true;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = false;
        int i4 = Build.VERSION.SDK_INT;
        this.v = (i4 < 14 || i4 > 16) ? false : false;
        this.w = false;
        this.C = 0;
        this.D = new tg9(new a(this));
        this.E = new b(this);
        this.F = new c(this);
        this.G = new i(this);
        if (pbFragment != null && pbFragment.e0() != null) {
            this.C = pbFragment.e0().r1();
            this.j = pbFragment.e0();
        }
        this.x = pbFragment.getContext();
    }

    @Override // com.baidu.tieba.qi9, com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        S(i2, view2, viewGroup, (pea) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public final void D(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f.setTextViewOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setTextViewCheckSelection(false);
            pbFirstFloorViewHolder.h.setOnTouchListener(new g(this));
        }
    }

    public final int N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), i2);
        }
        return invokeI.intValue;
    }

    public void T(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (pbModel = this.j) != null && z && this.k) {
            pbModel.P2(3);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.h = z;
        }
    }

    public void c0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.i = z;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void e0(tg9 tg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, tg9Var) == null) {
            this.q = tg9Var;
        }
    }

    public void f0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tVar) == null) {
            this.s = tVar;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.g = i2;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, zVar) == null) {
            this.p = zVar;
        }
    }

    public void q(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, ye9Var) == null) {
            this.l = ye9Var;
        }
    }

    @Override // com.baidu.tieba.lh
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.y = z;
        }
    }

    public final void E(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichTextView, view2, z) != null) || tbRichTextView == null) {
            return;
        }
        int equipmentWidth = (((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i2 = 0;
        if (z) {
            i2 = s(R.dimen.obfuscated_res_0x7f070275);
        }
        if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
            equipmentWidth /= 2;
        }
        int min = Math.min(equipmentWidth - i2, this.g);
        tbRichTextView.getLayoutStrategy().r(min);
        tbRichTextView.getLayoutStrategy().q((int) (min * 1.618f));
    }

    public final void L(PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar, TbRichText tbRichText) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder, peaVar, tbRichText) == null) {
            if (peaVar != null && peaVar.t() != null && peaVar.m0() != null) {
                if (tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(peaVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (peaVar.t().getSmallTailThemeData() != null) {
                    str = peaVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbFirstFloorViewHolder.l.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbFirstFloorViewHolder.m.setTag(R.id.tag_pb_small_tail_theme_id, str);
                mo9.c(peaVar.m0(), pbFirstFloorViewHolder.l, pbFirstFloorViewHolder.m, pbFirstFloorViewHolder.n, false, true, z, peaVar.t().getSmallTailThemeData());
                return;
            }
            pbFirstFloorViewHolder.l.setVisibility(8);
            pbFirstFloorViewHolder.m.setVisibility(8);
        }
    }

    public final void F(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder) != null) || pbFirstFloorViewHolder.F == null) {
            return;
        }
        ye9 ye9Var = this.l;
        if (ye9Var != null && ye9Var.O() != null && this.l.O().getTaskInfoData() != null && this.l.O().getTaskInfoData().f() != null && this.l.O().getTaskInfoData().j() == 3) {
            pbFirstFloorViewHolder.F.setVisibility(0);
            pbFirstFloorViewHolder.F.onBindDataToView(this.l.O());
            pbFirstFloorViewHolder.F.setItemBtnClickListener(new f(this, pbFirstFloorViewHolder));
            return;
        }
        pbFirstFloorViewHolder.F.setVisibility(8);
    }

    public final void a0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.c.setOnTouchListener(this.q);
            pbFirstFloorViewHolder.c.setOnLongClickListener(this.r);
            nl9 nl9Var = this.a.l0().c;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.D);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new h(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(nl9Var.f);
            pbFirstFloorViewHolder.l.setOnClickListener(this.o);
            pbFirstFloorViewHolder.m.setOnClickListener(this.o);
            pbFirstFloorViewHolder.y.setAfterItemClickListener(this.o);
            pbFirstFloorViewHolder.z.setAfterItemClickListener(this.o);
        }
    }

    public final String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 4) {
                return "default";
            }
            return "dark";
        }
        return (String) invokeV.objValue;
    }

    public PbFirstFloorViewHolder P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (PbFirstFloorViewHolder) this.viewholder;
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void U() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).v.d();
        }
    }

    public void W() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).v.e();
            ((PbFirstFloorViewHolder) this.viewholder).s.h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0513  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048580, this, pbFirstFloorViewHolder, peaVar, view2, i2) != null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        int i3 = 1;
        if (peaVar.L() != 1) {
            if (TextUtils.isEmpty(peaVar.v())) {
                pbFirstFloorViewHolder.f.setOnClickListener(this.o);
                pbFirstFloorViewHolder.f.setTextViewOnClickListener(this.o);
            } else {
                pbFirstFloorViewHolder.f.setOnClickListener(null);
                pbFirstFloorViewHolder.f.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.c.setOnClickListener(this.o);
        } else {
            pbFirstFloorViewHolder.c.setOnClickListener(null);
        }
        if (peaVar.L() == 1) {
            pbFirstFloorViewHolder.d(this.l, this.b.P0(), peaVar.Q);
            E(pbFirstFloorViewHolder.f, view2, this.w);
            if (peaVar.t() != null) {
                long userIdLong = peaVar.t().getUserIdLong();
                str = peaVar.t().getUserName();
                j = userIdLong;
                str2 = peaVar.t().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            ye9 ye9Var = this.l;
            if (ye9Var != null && ye9Var.O() != null) {
                pbFirstFloorViewHolder.v.b(peaVar.S(), str, str2, j, JavaTypesHelper.toLong(this.l.O().getId(), 0L), JavaTypesHelper.toLong(peaVar.U(), 0L));
            }
            ye9 ye9Var2 = this.l;
            if (ye9Var2 != null && ye9Var2.O() != null && this.l.O().getYulePostActivityData() != null) {
                dz4 yulePostActivityData = this.l.O().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.j.setVisibility(0);
                    pbFirstFloorViewHolder.j.startLoad(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.j.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.k;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            ye9 ye9Var3 = this.l;
            if (ye9Var3 != null && ye9Var3.O() != null && this.l.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.y) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.y.getPaddingRight(), pbFirstFloorViewHolder.y.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().z(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, peaVar);
        sparseArray.put(R.id.tag_load_sub_data, peaVar);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(peaVar.L()));
        if (!peaVar.A0() && !peaVar.z0(false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.m == null) {
                gn9 gn9Var = new gn9(this.x);
                this.m = gn9Var;
                gn9Var.f(this.e);
                this.m.h(this.n);
                ye9 ye9Var4 = this.l;
                if (ye9Var4 != null) {
                    this.m.j(this.l.W(), TextUtils.equals(ye9Var4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.O());
                }
            }
            this.m.g(peaVar.U());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        ye9 ye9Var5 = this.l;
        if (ye9Var5 != null && ye9Var5.O() != null && this.l.O().isLinkThread()) {
            J(pbFirstFloorViewHolder, this.l.O().getLinkThreadData());
        }
        ye9 ye9Var6 = this.l;
        if (ye9Var6 != null && ye9Var6.O() != null && this.l.O().isShareThread && peaVar.d0() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (peaVar.d0().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.tbds14));
            }
            K(pbFirstFloorViewHolder, peaVar);
        } else {
            ye9 ye9Var7 = this.l;
            if (ye9Var7 != null && ye9Var7.O() != null && this.l.O().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.M_H_X007));
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(N(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.tbds24));
            }
        }
        M(pbFirstFloorViewHolder, this.l);
        TbRichText f0 = peaVar.f0();
        ye9 ye9Var8 = this.l;
        if (ye9Var8 == null || !ye9Var8.x0()) {
            tbRichText = f0;
        }
        if (this.l.O() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.Q());
            pbFirstFloorViewHolder.f.setPid(peaVar.U());
            pbFirstFloorViewHolder.f.setPosition(TbRichTextView.Position.PB_FIRST_FLOOR);
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        ye9 ye9Var9 = this.l;
        if (ye9Var9 != null && 3 == ye9Var9.f()) {
            TbRichTextView tbRichTextView = pbFirstFloorViewHolder.f;
            if (!this.u && this.v) {
                z9 = true;
            } else {
                z9 = false;
            }
            tbRichTextView.setText(tbRichText, z9, this.s, true, false);
        } else {
            TbRichTextView tbRichTextView2 = pbFirstFloorViewHolder.f;
            if (!this.u && this.v) {
                z3 = true;
            } else {
                z3 = false;
            }
            tbRichTextView2.setText(tbRichText, z3, this.s, false, true);
        }
        L(pbFirstFloorViewHolder, peaVar, tbRichText);
        boolean z10 = !StringUtils.isNull(peaVar.t().getVirtualUserUrl());
        ye9 ye9Var10 = this.l;
        if (ye9Var10 != null && ye9Var10.W() != 0 && !xk9.w(this.l)) {
            if (this.l.W() != 3) {
                z4 = true;
                z5 = true;
            } else {
                z4 = false;
                z5 = false;
            }
            if (peaVar.t() != null) {
                String userId = peaVar.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z4 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z4 = false;
                }
            }
        } else {
            z4 = false;
            z5 = false;
        }
        ye9 ye9Var11 = this.l;
        if (ye9Var11 != null && ye9Var11.O() != null && this.l.O().getAuthor() != null && peaVar.t() != null) {
            String userId2 = this.l.O().getAuthor().getUserId();
            String userId3 = peaVar.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = true;
                    z6 = false;
                    z7 = true;
                } else {
                    z5 = true;
                    z6 = true;
                    z7 = false;
                }
                z8 = true;
                if (peaVar.t() != null && UtilHelper.isCurrentAccount(peaVar.t().getUserId())) {
                    z5 = true;
                    z7 = true;
                }
                if (z10) {
                    z4 = false;
                    z5 = false;
                    z6 = false;
                }
                if (peaVar.L() == 1) {
                    i3 = 0;
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, peaVar.U());
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    if (peaVar.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, peaVar.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, peaVar.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, peaVar.t().getPortrait());
                    }
                    ye9 ye9Var12 = this.l;
                    if (ye9Var12 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ye9Var12.W()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z6) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (peaVar.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, peaVar.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, peaVar.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, peaVar.t().getName_show());
                    }
                    ye9 ye9Var13 = this.l;
                    if (ye9Var13 != null && ye9Var13.O() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.l.O().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, peaVar.U());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(z));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(R.id.tag_del_post_id, peaVar.U());
                    ye9 ye9Var14 = this.l;
                    if (ye9Var14 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ye9Var14.W()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
                D(pbFirstFloorViewHolder);
            }
        }
        z6 = false;
        z7 = false;
        z8 = false;
        if (peaVar.t() != null) {
            z5 = true;
            z7 = true;
        }
        if (z10) {
        }
        if (peaVar.L() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, peaVar.U());
        if (!z4) {
        }
        if (!z6) {
        }
        if (!z5) {
        }
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
        D(pbFirstFloorViewHolder);
    }

    public final void I(PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar, View view2, int i2) {
        pea peaVar2;
        jf9 jf9Var;
        boolean z;
        ye9 ye9Var;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048581, this, pbFirstFloorViewHolder, peaVar, view2, i2) == null) && pbFirstFloorViewHolder != null && peaVar != null) {
            t6a.a("pb", true);
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.f.setTag(sparseArray);
            pbFirstFloorViewHolder.c.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, peaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbFirstFloorViewHolder.f.setIsHost(true);
            if (this.i) {
                pbFirstFloorViewHolder.i.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            cta.c(peaVar, pbFirstFloorViewHolder.f);
            if (!TextUtils.isEmpty(peaVar.v()) && this.h) {
                pbFirstFloorViewHolder.f.q0(peaVar.v(), new e(this, pbFirstFloorViewHolder, peaVar, view2, i2, sparseArray));
            } else {
                b0(pbFirstFloorViewHolder, peaVar, view2, i2);
            }
            ye9 ye9Var2 = this.l;
            if (ye9Var2 != null) {
                h0(ye9Var2);
            }
            ye9 ye9Var3 = this.l;
            if (ye9Var3 != null && ye9Var3.O() != null && this.l.O().isVideoThreadType() && this.l.O().getThreadVideoInfo() != null && ad.isEmpty(this.l.k().getName())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (peaVar.f0() != null && !ListUtils.isEmpty(peaVar.f0().P())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            } else {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            }
            if (peaVar.f0() != null) {
                if (peaVar.f0().Q() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams.topMargin = s(R.dimen.tbds26);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams2.topMargin = s(R.dimen.tbds16);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams2);
                }
            }
            ye9 ye9Var4 = this.l;
            if (ye9Var4 != null && Q(ye9Var4.O())) {
                pbFirstFloorViewHolder.B.setDataForPb(this.l.O().getPollData(), this.l.O().getTid(), this.l.l());
                if (this.l.O().getTaskInfoData() != null) {
                    pbFirstFloorViewHolder.B.setupLiveThreadVoteInfo(this.l.O().getTaskInfoData().p());
                }
                if (peaVar.f0() != null && !ListUtils.isEmpty(peaVar.f0().P())) {
                    pbFirstFloorViewHolder.B.setMarginTop(BdUtilHelper.getDimens(this.x, R.dimen.tbds26));
                } else {
                    pbFirstFloorViewHolder.B.setMarginTop(BdUtilHelper.getDimens(this.x, R.dimen.tbds0));
                }
                pbFirstFloorViewHolder.B.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.B.setVisibility(8);
            }
            ye9 ye9Var5 = this.l;
            if (ye9Var5 != null && ye9Var5.O() != null && this.l.O().getSmartApp() != null && this.l.O().getThreadVideoInfo() == null) {
                pbFirstFloorViewHolder.q.setData(this.l.O().getSmartApp());
                pbFirstFloorViewHolder.q.setVisibility(0);
                ye9 ye9Var6 = this.l;
                if (ye9Var6 != null && ye9Var6.k() != null) {
                    pbFirstFloorViewHolder.q.setForumId(String.valueOf(this.l.k().getId()));
                }
                ye9 ye9Var7 = this.l;
                if (ye9Var7 != null && ye9Var7.Q() != null) {
                    pbFirstFloorViewHolder.q.setThreadId(this.l.Q());
                }
                pbFirstFloorViewHolder.q.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.q.setVisibility(8);
            }
            if (this.l != null) {
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.e0() != null) {
                    pbFirstFloorViewHolder.D.g("1".equals(this.b.e0().showReplyPanel));
                }
                pbFirstFloorViewHolder.D.setData(this.l.O(), this.l.P(), this.y);
            }
            if (NovelPaySwitch.isOn() && peaVar.b0() != null && !peaVar.b0().n() && this.l.p0()) {
                this.k = true;
                pbFirstFloorViewHolder.r.setVisibility(0);
                pbFirstFloorViewHolder.s.setVisibility(0);
                pbFirstFloorViewHolder.s.setData(peaVar.b0());
                if (this.j != null && (ye9Var = this.l) != null) {
                    NovelMemberCardView novelMemberCardView = pbFirstFloorViewHolder.s;
                    String Q = ye9Var.Q();
                    String l = this.l.l();
                    if (this.l.O() != null) {
                        i3 = this.l.O().getThreadType();
                    } else {
                        i3 = 0;
                    }
                    novelMemberCardView.setStatisticData(Q, l, i3, this.j.L0(), this.j.x1(), peaVar.b0().d());
                }
            } else {
                pbFirstFloorViewHolder.r.setVisibility(8);
                pbFirstFloorViewHolder.s.setVisibility(8);
            }
            if (pbFirstFloorViewHolder.t != null) {
                FullLengthNovel fullLengthNovel = peaVar.K0;
                if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 0);
                    if (pbFirstFloorViewHolder.t.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.t.getLayoutParams();
                        int i4 = 1080;
                        if (BdUtilHelper.getEquipmentWidth(this.x) < 1080) {
                            i4 = BdUtilHelper.getEquipmentWidth(this.x);
                        }
                        layoutParams3.height = (BdUtilHelper.getEquipmentWidth(this.x) * peaVar.K0.button_heigh.intValue()) / i4;
                        pbFirstFloorViewHolder.t.setLayoutParams(layoutParams3);
                    }
                    pbFirstFloorViewHolder.t.loadUrl(peaVar.K0.schema + "&curskintype=" + G());
                } else {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 8);
                }
            }
            ye9 ye9Var8 = this.l;
            if (ye9Var8 != null && (jf9Var = ye9Var8.h) != null) {
                if (pbFirstFloorViewHolder.p != null) {
                    if (TextUtils.isEmpty(jf9Var.e())) {
                        pbFirstFloorViewHolder.p.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.p.setVisibility(0);
                        pbFirstFloorViewHolder.p.setText(this.l.h.e());
                    }
                }
                if (pbFirstFloorViewHolder.o != null && pbFirstFloorViewHolder.A.h() == null) {
                    pbFirstFloorViewHolder.o.addView(pbFirstFloorViewHolder.A.a(this.l));
                    String fromPageKey = UtilHelper.getFromPageKey(this.b.getPageContext());
                    Context context = this.x;
                    if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getIntent() != null) {
                        z = ((AbsPbActivity) this.x).getIntent().getBooleanExtra("is_from_bar_vote", false);
                        if (z) {
                            new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 1).eventStat();
                        }
                    } else {
                        z = false;
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals("a002")) {
                            new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 3).eventStat();
                        } else if (fromPageKey.equals("a006")) {
                            new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 2).eventStat();
                        } else if (fromPageKey.equals("a026")) {
                            new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 4).eventStat();
                        }
                    }
                }
            }
            LinearLayout linearLayout = pbFirstFloorViewHolder.u;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            List<CardLinkInfoData> list = null;
            ye9 ye9Var9 = this.l;
            if (ye9Var9 != null && ye9Var9.F() != null && this.l.F().size() > 0 && (peaVar2 = this.l.F().get(0)) != null) {
                list = peaVar2.z();
            }
            ye9 ye9Var10 = this.l;
            if (ye9Var10 != null && ye9Var10.O() != null && !Q(this.l.O()) && (!ListUtils.isEmpty(this.l.O().getLinkDataList()) || !ListUtils.isEmpty(this.l.O().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
                ps5 ps5Var = new ps5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
                ye9 ye9Var11 = this.l;
                pbLinkGoodsRootView.h(ye9Var11, ps5Var.b(ye9Var11.O().getLinkDataList(), this.l.O().getGoodsDataList(), list), this.l.m(), this.b, ps5Var.c());
                pbFirstFloorViewHolder.u.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.u.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.u.setVisibility(8);
            }
            ye9 ye9Var12 = this.l;
            if (ye9Var12 != null && ye9Var12.O() != null && this.l.O().getTaskInfoData() != null && this.l.O().getTaskInfoData().f() != null && this.l.O().getTaskInfoData().j() == 2) {
                pbFirstFloorViewHolder.E.setVisibility(0);
                pbFirstFloorViewHolder.E.onBindDataToView(this.l.O());
            } else {
                pbFirstFloorViewHolder.E.setVisibility(8);
            }
            F(pbFirstFloorViewHolder);
        }
    }

    public final void J(PbFirstFloorViewHolder pbFirstFloorViewHolder, ex4 ex4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbFirstFloorViewHolder, ex4Var) == null) && ex4Var != null && !ad.isEmpty(ex4Var.e()) && ex4Var.c() == ex4.g) {
            if (!ex4Var.f()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(BdUtilHelper.getDimens(this.x, R.dimen.obfuscated_res_0x7f0703e5));
            }
            pbFirstFloorViewHolder.v.c(ex4Var);
        }
    }

    public final void K(PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar) {
        View a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbFirstFloorViewHolder, peaVar) == null) && pbFirstFloorViewHolder != null && peaVar != null) {
            pbFirstFloorViewHolder.w.setVisibility(0);
            if (pbFirstFloorViewHolder.x == null) {
                pbFirstFloorViewHolder.x = O(peaVar);
            }
            if (pbFirstFloorViewHolder.w.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.x.a()) != null) {
                pbFirstFloorViewHolder.w.addView(a2);
            }
            pbFirstFloorViewHolder.x.e(this.E);
            pbFirstFloorViewHolder.x.d(this.F);
            pbFirstFloorViewHolder.x.c(peaVar.d0());
            pbFirstFloorViewHolder.x.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void M(PbFirstFloorViewHolder pbFirstFloorViewHolder, ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbFirstFloorViewHolder, ye9Var) == null) && ye9Var != null && ye9Var.t() != null && this.x != null) {
            pbFirstFloorViewHolder.L.setVisibility(0);
            this.B = BdUtilHelper.getColorResourceId(this.x, ye9Var.t().background_color);
            EMManager.from(pbFirstFloorViewHolder.L).setCorner(R.string.J_X05).setBackGroundColor(this.B);
            pbFirstFloorViewHolder.H.setText(ye9Var.t().title_text);
            this.A = BdUtilHelper.getColorResourceId(this.x, ye9Var.t().title_color);
            EMManager.from(pbFirstFloorViewHolder.H).setTextColor(this.A).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02);
            pbFirstFloorViewHolder.G.startLoad(ye9Var.t().title_icon, 10, false);
            pbFirstFloorViewHolder.I.setText(ye9Var.t().link_text);
            this.z = BdUtilHelper.getColorResourceId(this.x, ye9Var.t().link_color);
            EMManager.from(pbFirstFloorViewHolder.I).setTextColor(this.z).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            pbFirstFloorViewHolder.J.startLoad(ye9Var.t().link_icon, 10, false);
            pbFirstFloorViewHolder.K.startLoad(ye9Var.t().link_url, 10, false);
            pbFirstFloorViewHolder.L.setOnClickListener(new d(this, ye9Var));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ql9 O(pea peaVar) {
        InterceptResult invokeL;
        ql9 ql9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, peaVar)) == null) {
            if (peaVar != null && peaVar.d0() != null && peaVar.d0().k()) {
                BaijiahaoData baijiahaoData = peaVar.d0().p;
                Item item = peaVar.d0().C;
                if (!peaVar.d0().m && !peaVar.y1()) {
                    if (item != null && item.item_id.longValue() != 0) {
                        if (peaVar.d0().a != 0 && peaVar.d0().a != 1) {
                            if (peaVar.d0().a == 3) {
                                ql9Var = new wl9(this.b.getPageContext());
                            } else {
                                ql9Var = new ul9(this.b.getPageContext());
                            }
                        } else {
                            ql9Var = new vl9(this.b.getPageContext());
                        }
                    } else if (baijiahaoData != null && peaVar.d0().l()) {
                        int i2 = baijiahaoData.oriUgcType;
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        ql9Var = new sl9(this.b.getPageContext(), this.C);
                                    } else {
                                        ql9Var = new yl9(this.b.getPageContext(), this.C);
                                    }
                                } else {
                                    ql9Var = new xl9(this.b.getPageContext(), this.C);
                                }
                            } else {
                                ql9Var = new yl9(this.b.getPageContext(), this.C);
                            }
                        } else {
                            ql9Var = new rl9(this.b.getPageContext(), this.C);
                        }
                    } else if (peaVar.d0().a != 0 && peaVar.d0().a != 1) {
                        if (peaVar.d0().a == 3) {
                            ql9Var = new yl9(this.b.getPageContext(), this.C);
                        }
                    } else {
                        ql9Var = new xl9(this.b.getPageContext(), this.C);
                    }
                } else {
                    ql9Var = new tl9(this.b.getPageContext(), this.C);
                }
                if (ql9Var != null) {
                    return new sl9(this.b.getPageContext(), this.C);
                }
                return ql9Var;
            }
            ql9Var = null;
            if (ql9Var != null) {
            }
        } else {
            return (ql9) invokeL.objValue;
        }
    }

    public final boolean Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, threadData)) == null) {
            if (threadData != null && threadData.getPollData() != null && threadData.getPollData().getOptions() != null && threadData.getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: R */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d070e, viewGroup, false), this.h, this.g);
            g0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.v.f(this.C);
            pbFirstFloorViewHolder.F.setOnStatListener(this.G);
            pbFirstFloorViewHolder.E.setOnStatListener(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public void h0(@NonNull ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, ye9Var) == null) && ye9Var.O() != null && P() != null && P().b() != null) {
            ThreadData O = ye9Var.O();
            ImageView b2 = P().b();
            if ((!O.isShowTitle() || ck9.x(ye9Var)) && !O.isVideoThreadType()) {
                ck9.c(b2, O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
        }
    }

    public View S(int i2, View view2, ViewGroup viewGroup, pea peaVar, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, peaVar, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) peaVar, (pea) pbFirstFloorViewHolder);
            g0(pbFirstFloorViewHolder);
            a0(pbFirstFloorViewHolder);
            pea peaVar2 = (pea) getItem(i2);
            if (peaVar2 != null) {
                peaVar2.C1();
                peaVar2.f0 = i2 + 1;
                BdUniqueId uniqueId = this.b.getUniqueId();
                ye9 ye9Var = this.l;
                int i3 = peaVar2.f0;
                PbModel pbModel = this.j;
                if (pbModel == null) {
                    str = "";
                } else {
                    str = pbModel.x1();
                }
                PbModel pbModel2 = this.j;
                if (pbModel2 == null) {
                    str2 = "";
                } else {
                    str2 = pbModel2.L0();
                }
                xn9.f(uniqueId, ye9Var, peaVar2, i3, 1, str, str2);
                I(pbFirstFloorViewHolder, peaVar2, view2, i2);
            }
            if (!this.u && this.v && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f.L() && (listView = this.b.getListView()) != null) {
                this.u = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.C.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void V() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (v = this.viewholder) == 0) {
            return;
        }
        if (((PbFirstFloorViewHolder) v).v != null) {
            ((PbFirstFloorViewHolder) v).v.a();
        }
        V v2 = this.viewholder;
        if (((PbFirstFloorViewHolder) v2).z != null) {
            ((PbFirstFloorViewHolder) v2).z.g();
        }
        V v3 = this.viewholder;
        if (((PbFirstFloorViewHolder) v3).s != null) {
            ((PbFirstFloorViewHolder) v3).s.g();
        }
        V v4 = this.viewholder;
        if (((PbFirstFloorViewHolder) v4).t != null) {
            ViewCommonUtil.removeFromParentLayout(((PbFirstFloorViewHolder) v4).t);
            ((PbFirstFloorViewHolder) this.viewholder).t.removeAllViews();
            ((PbFirstFloorViewHolder) this.viewholder).t.setVisibility(8);
            ((PbFirstFloorViewHolder) this.viewholder).t.destroy();
            ((PbFirstFloorViewHolder) this.viewholder).t = null;
        }
    }

    public final void i0() {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.l == null) {
            return;
        }
        int i3 = 0;
        if (this.b.e0().X0()) {
            i2 = 1;
        } else if (this.b.e0().a1()) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(this.l.m());
        if (itemInfo != null) {
            i3 = itemInfo.id.intValue();
            str = itemInfo.name;
        } else {
            str = "";
        }
        new StatisticItem("c15063").addParam("obj_locate", i2).addParam("fid", this.l.l()).addParam("fname", this.l.m()).addParam("post_id", this.l.Q()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
    }

    public final void Y(PbFirstFloorViewHolder pbFirstFloorViewHolder, int i2, int i3, int i4, int i5) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{pbFirstFloorViewHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && pbFirstFloorViewHolder != null && (relativeLayout = pbFirstFloorViewHolder.g) != null && relativeLayout.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.g.getLayoutParams();
            layoutParams.bottomMargin = i5;
            layoutParams.topMargin = i3;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i4;
            pbFirstFloorViewHolder.g.setLayoutParams(layoutParams);
        }
    }

    public final void Z(PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar, View view2, int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{pbFirstFloorViewHolder, peaVar, view2, Integer.valueOf(i2), sparseArray}) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int s = s(R.dimen.obfuscated_res_0x7f07020f);
        Y(pbFirstFloorViewHolder, s, s(R.dimen.obfuscated_res_0x7f0701be), s, s);
        if (pbFirstFloorViewHolder.h != null) {
            if (!TextUtils.isEmpty(peaVar.D())) {
                pbFirstFloorViewHolder.h.setTag(sparseArray);
                pbFirstFloorViewHolder.h.setVisibility(0);
                pbFirstFloorViewHolder.h.k(xp4.a(peaVar.D()));
                mh9.c(pbFirstFloorViewHolder.h, view2);
            } else {
                pbFirstFloorViewHolder.h.setVisibility(8);
            }
        }
        this.w = true;
        H(pbFirstFloorViewHolder, peaVar, view2, i2);
    }

    public final void b0(PbFirstFloorViewHolder pbFirstFloorViewHolder, pea peaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048599, this, pbFirstFloorViewHolder, peaVar, view2, i2) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        Y(pbFirstFloorViewHolder, 0, 0, 0, 0);
        TbRichTextView tbRichTextView = pbFirstFloorViewHolder.f;
        if (tbRichTextView != null) {
            tbRichTextView.p0(null);
        }
        TbAlphaVideo tbAlphaVideo = pbFirstFloorViewHolder.h;
        if (tbAlphaVideo != null) {
            tbAlphaVideo.setVisibility(8);
        }
        this.w = false;
        H(pbFirstFloorViewHolder, peaVar, view2, i2);
    }

    public final void g0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, pbFirstFloorViewHolder) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.b != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.C, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.c, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.i, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.L, this.B);
            pbFirstFloorViewHolder.H.setTextColor(SkinManager.getColor(this.A));
            pbFirstFloorViewHolder.I.setTextColor(SkinManager.getColor(this.z));
            pbFirstFloorViewHolder.f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.q.c();
            pbFirstFloorViewHolder.s.e();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.y;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.z;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.p, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.A.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.B;
            if (voteView != null) {
                voteView.D(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.r, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            pbFirstFloorViewHolder.D.i();
            if (pbFirstFloorViewHolder.h.getVisibility() == 0) {
                pbFirstFloorViewHolder.h.g(skinType);
            }
        }
        pbFirstFloorViewHolder.b = TbadkCoreApplication.getInst().getSkinType();
    }
}
