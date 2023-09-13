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
import com.baidu.tieba.ax;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.vk9;
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
public class sm9 extends lm9<tha, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public vk9 D;
    public mp6<b15> E;
    public ax.a F;
    public dz G;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public aj9 l;
    public wq9 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.z p;
    public vk9 q;
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
        public final /* synthetic */ sm9 b;

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

        public f(sm9 sm9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var, pbFirstFloorViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm9Var;
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
                    pbFragment.M7(new a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sm9 a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(sm9 sm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sm9Var;
        }

        @Override // com.baidu.tieba.vk9.a
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

        @Override // com.baidu.tieba.vk9.a
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
    public class b extends mp6<b15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sm9 b;

        public b(sm9 sm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, b15 b15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, b15Var) == null) {
                super.a(view2, b15Var);
                if (b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().originalThreadData != null && this.b.l != null) {
                    OriginalThreadInfo originalThreadInfo = b15Var.getThreadData().originalThreadData;
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
                        nr9.s("c12602", Q, str, i);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sm9 a;

        public c(sm9 sm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sm9Var;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().originalThreadData != null) {
                OriginalThreadInfo originalThreadInfo = b15Var.getThreadData().originalThreadData;
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
        public final /* synthetic */ aj9 a;
        public final /* synthetic */ sm9 b;

        public d(sm9 sm9Var, aj9 aj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var, aj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm9Var;
            this.a = aj9Var;
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
        public final /* synthetic */ tha b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ SparseArray e;
        public final /* synthetic */ sm9 f;

        public e(sm9 sm9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar, View view2, int i, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var, pbFirstFloorViewHolder, thaVar, view2, Integer.valueOf(i), sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sm9Var;
            this.a = pbFirstFloorViewHolder;
            this.b = thaVar;
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
        public final /* synthetic */ sm9 a;

        public g(sm9 sm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sm9Var;
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

        public h(sm9 sm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var};
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
    public class i implements dz {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sm9 a;

        public i(sm9 sm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sm9Var;
        }

        @Override // com.baidu.tieba.dz
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.Q()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 2));
            }
        }

        @Override // com.baidu.tieba.dz
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.Q()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 1));
            }
        }

        @Override // com.baidu.tieba.dz
        public void onShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15022").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.Q()).param("fid", this.a.l.l()).param("obj_locate", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((rr9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.D = new vk9(new a(this));
        this.E = new b(this);
        this.F = new c(this);
        this.G = new i(this);
        if (pbFragment != null && pbFragment.X() != null) {
            this.C = pbFragment.X().q1();
            this.j = pbFragment.X();
        }
        this.x = pbFragment.getContext();
    }

    @Override // com.baidu.tieba.lm9, com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        S(i2, view2, viewGroup, (tha) obj, (PbFirstFloorViewHolder) viewHolder);
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
            pbModel.O2(3);
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

    public void e0(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, vk9Var) == null) {
            this.q = vk9Var;
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

    public void r(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, aj9Var) == null) {
            this.l = aj9Var;
        }
    }

    @Override // com.baidu.tieba.pm
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

    public final void L(PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar, TbRichText tbRichText) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder, thaVar, tbRichText) == null) {
            if (thaVar != null && thaVar.t() != null && thaVar.m0() != null) {
                if (tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(thaVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (thaVar.t().getSmallTailThemeData() != null) {
                    str = thaVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbFirstFloorViewHolder.l.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbFirstFloorViewHolder.m.setTag(R.id.tag_pb_small_tail_theme_id, str);
                cs9.c(thaVar.m0(), pbFirstFloorViewHolder.l, pbFirstFloorViewHolder.m, pbFirstFloorViewHolder.n, false, true, z, thaVar.t().getSmallTailThemeData());
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
        aj9 aj9Var = this.l;
        if (aj9Var != null && aj9Var.O() != null && this.l.O().getTaskInfoData() != null && this.l.O().getTaskInfoData().f() != null && this.l.O().getTaskInfoData().j() == 3) {
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
            ep9 ep9Var = this.a.e0().c;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.D);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new h(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(ep9Var.f);
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

    public void X() {
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
    public final void H(PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar, View view2, int i2) {
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
        if ((interceptable != null && interceptable.invokeLLLI(1048580, this, pbFirstFloorViewHolder, thaVar, view2, i2) != null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        int i3 = 1;
        if (thaVar.L() != 1) {
            if (TextUtils.isEmpty(thaVar.v())) {
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
        if (thaVar.L() == 1) {
            pbFirstFloorViewHolder.d(this.l, this.b.I0(), thaVar.Q);
            E(pbFirstFloorViewHolder.f, view2, this.w);
            if (thaVar.t() != null) {
                long userIdLong = thaVar.t().getUserIdLong();
                str = thaVar.t().getUserName();
                j = userIdLong;
                str2 = thaVar.t().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            aj9 aj9Var = this.l;
            if (aj9Var != null && aj9Var.O() != null) {
                pbFirstFloorViewHolder.v.b(thaVar.S(), str, str2, j, JavaTypesHelper.toLong(this.l.O().getId(), 0L), JavaTypesHelper.toLong(thaVar.U(), 0L));
            }
            aj9 aj9Var2 = this.l;
            if (aj9Var2 != null && aj9Var2.O() != null && this.l.O().getYulePostActivityData() != null) {
                u45 yulePostActivityData = this.l.O().getYulePostActivityData();
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
            aj9 aj9Var3 = this.l;
            if (aj9Var3 != null && aj9Var3.O() != null && this.l.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.y) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.y.getPaddingRight(), pbFirstFloorViewHolder.y.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().z(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, thaVar);
        sparseArray.put(R.id.tag_load_sub_data, thaVar);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(thaVar.L()));
        if (!thaVar.A0() && !thaVar.z0(false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.m == null) {
                wq9 wq9Var = new wq9(this.x);
                this.m = wq9Var;
                wq9Var.f(this.e);
                this.m.h(this.n);
                aj9 aj9Var4 = this.l;
                if (aj9Var4 != null) {
                    this.m.j(this.l.W(), TextUtils.equals(aj9Var4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.O());
                }
            }
            this.m.g(thaVar.U());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        aj9 aj9Var5 = this.l;
        if (aj9Var5 != null && aj9Var5.O() != null && this.l.O().isLinkThread()) {
            J(pbFirstFloorViewHolder, this.l.O().getLinkThreadData());
        }
        aj9 aj9Var6 = this.l;
        if (aj9Var6 != null && aj9Var6.O() != null && this.l.O().isShareThread && thaVar.d0() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (thaVar.d0().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.tbds14));
            }
            K(pbFirstFloorViewHolder, thaVar);
        } else {
            aj9 aj9Var7 = this.l;
            if (aj9Var7 != null && aj9Var7.O() != null && this.l.O().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.M_H_X007));
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(N(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(N(R.dimen.tbds24));
            }
        }
        M(pbFirstFloorViewHolder, this.l);
        TbRichText f0 = thaVar.f0();
        aj9 aj9Var8 = this.l;
        if (aj9Var8 == null || !aj9Var8.x0()) {
            tbRichText = f0;
        }
        if (this.l.O() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.Q());
            pbFirstFloorViewHolder.f.setPid(thaVar.U());
            pbFirstFloorViewHolder.f.setPosition(TbRichTextView.Position.PB_FIRST_FLOOR);
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        aj9 aj9Var9 = this.l;
        if (aj9Var9 != null && 3 == aj9Var9.f()) {
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
        L(pbFirstFloorViewHolder, thaVar, tbRichText);
        boolean z10 = !StringUtils.isNull(thaVar.t().getVirtualUserUrl());
        aj9 aj9Var10 = this.l;
        if (aj9Var10 != null && aj9Var10.W() != 0 && !oo9.c(this.l)) {
            if (this.l.W() != 3) {
                z4 = true;
                z5 = true;
            } else {
                z4 = false;
                z5 = false;
            }
            if (thaVar.t() != null) {
                String userId = thaVar.t().getUserId();
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
        aj9 aj9Var11 = this.l;
        if (aj9Var11 != null && aj9Var11.O() != null && this.l.O().getAuthor() != null && thaVar.t() != null) {
            String userId2 = this.l.O().getAuthor().getUserId();
            String userId3 = thaVar.t().getUserId();
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
                if (thaVar.t() != null && UtilHelper.isCurrentAccount(thaVar.t().getUserId())) {
                    z5 = true;
                    z7 = true;
                }
                if (z10) {
                    z4 = false;
                    z5 = false;
                    z6 = false;
                }
                if (thaVar.L() == 1) {
                    i3 = 0;
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, thaVar.U());
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    if (thaVar.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, thaVar.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, thaVar.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, thaVar.t().getPortrait());
                    }
                    aj9 aj9Var12 = this.l;
                    if (aj9Var12 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aj9Var12.W()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z6) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (thaVar.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, thaVar.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, thaVar.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, thaVar.t().getName_show());
                    }
                    aj9 aj9Var13 = this.l;
                    if (aj9Var13 != null && aj9Var13.O() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.l.O().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, thaVar.U());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(z));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(R.id.tag_del_post_id, thaVar.U());
                    aj9 aj9Var14 = this.l;
                    if (aj9Var14 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aj9Var14.W()));
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
        if (thaVar.t() != null) {
            z5 = true;
            z7 = true;
        }
        if (z10) {
        }
        if (thaVar.L() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, thaVar.U());
        if (!z4) {
        }
        if (!z6) {
        }
        if (!z5) {
        }
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
        D(pbFirstFloorViewHolder);
    }

    public final void I(PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar, View view2, int i2) {
        tha thaVar2;
        lj9 lj9Var;
        boolean z;
        aj9 aj9Var;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048581, this, pbFirstFloorViewHolder, thaVar, view2, i2) == null) && pbFirstFloorViewHolder != null && thaVar != null) {
            x9a.a("pb", true);
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.f.setTag(sparseArray);
            pbFirstFloorViewHolder.c.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbFirstFloorViewHolder.f.setIsHost(true);
            if (this.i) {
                pbFirstFloorViewHolder.i.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            swa.c(thaVar, pbFirstFloorViewHolder.f);
            if (!TextUtils.isEmpty(thaVar.v()) && this.h) {
                pbFirstFloorViewHolder.f.q0(thaVar.v(), new e(this, pbFirstFloorViewHolder, thaVar, view2, i2, sparseArray));
            } else {
                b0(pbFirstFloorViewHolder, thaVar, view2, i2);
            }
            aj9 aj9Var2 = this.l;
            if (aj9Var2 != null) {
                h0(aj9Var2);
            }
            aj9 aj9Var3 = this.l;
            if (aj9Var3 != null && aj9Var3.O() != null && this.l.O().isVideoThreadType() && this.l.O().getThreadVideoInfo() != null && ei.isEmpty(this.l.k().getName())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (thaVar.f0() != null && !ListUtils.isEmpty(thaVar.f0().O())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            } else {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            }
            if (thaVar.f0() != null) {
                if (thaVar.f0().P() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams.topMargin = s(R.dimen.tbds26);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams2.topMargin = s(R.dimen.tbds16);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams2);
                }
            }
            aj9 aj9Var4 = this.l;
            if (aj9Var4 != null && Q(aj9Var4.O())) {
                pbFirstFloorViewHolder.B.setDataForPb(this.l.O().getPollData(), this.l.O().getTid(), this.l.l());
                if (this.l.O().getTaskInfoData() != null) {
                    pbFirstFloorViewHolder.B.setupLiveThreadVoteInfo(this.l.O().getTaskInfoData().p());
                }
                if (thaVar.f0() != null && !ListUtils.isEmpty(thaVar.f0().O())) {
                    pbFirstFloorViewHolder.B.setMarginTop(BdUtilHelper.getDimens(this.x, R.dimen.tbds26));
                } else {
                    pbFirstFloorViewHolder.B.setMarginTop(BdUtilHelper.getDimens(this.x, R.dimen.tbds0));
                }
                pbFirstFloorViewHolder.B.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.B.setVisibility(8);
            }
            aj9 aj9Var5 = this.l;
            if (aj9Var5 != null && aj9Var5.O() != null && this.l.O().getSmartApp() != null && this.l.O().getThreadVideoInfo() == null) {
                pbFirstFloorViewHolder.q.setData(this.l.O().getSmartApp());
                pbFirstFloorViewHolder.q.setVisibility(0);
                aj9 aj9Var6 = this.l;
                if (aj9Var6 != null && aj9Var6.k() != null) {
                    pbFirstFloorViewHolder.q.setForumId(String.valueOf(this.l.k().getId()));
                }
                aj9 aj9Var7 = this.l;
                if (aj9Var7 != null && aj9Var7.Q() != null) {
                    pbFirstFloorViewHolder.q.setThreadId(this.l.Q());
                }
                pbFirstFloorViewHolder.q.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.q.setVisibility(8);
            }
            if (this.l != null) {
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.X() != null) {
                    pbFirstFloorViewHolder.D.g("1".equals(this.b.X().showReplyPanel));
                }
                pbFirstFloorViewHolder.D.setData(this.l.O(), this.l.P(), this.y);
            }
            if (NovelPaySwitch.isOn() && thaVar.b0() != null && !thaVar.b0().n() && this.l.p0()) {
                this.k = true;
                pbFirstFloorViewHolder.r.setVisibility(0);
                pbFirstFloorViewHolder.s.setVisibility(0);
                pbFirstFloorViewHolder.s.setData(thaVar.b0());
                if (this.j != null && (aj9Var = this.l) != null) {
                    NovelMemberCardView novelMemberCardView = pbFirstFloorViewHolder.s;
                    String Q = aj9Var.Q();
                    String l = this.l.l();
                    if (this.l.O() != null) {
                        i3 = this.l.O().getThreadType();
                    } else {
                        i3 = 0;
                    }
                    novelMemberCardView.setStatisticData(Q, l, i3, this.j.K0(), this.j.w1(), thaVar.b0().d());
                }
            } else {
                pbFirstFloorViewHolder.r.setVisibility(8);
                pbFirstFloorViewHolder.s.setVisibility(8);
            }
            if (pbFirstFloorViewHolder.t != null) {
                FullLengthNovel fullLengthNovel = thaVar.K0;
                if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 0);
                    if (pbFirstFloorViewHolder.t.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.t.getLayoutParams();
                        int i4 = 1080;
                        if (BdUtilHelper.getEquipmentWidth(this.x) < 1080) {
                            i4 = BdUtilHelper.getEquipmentWidth(this.x);
                        }
                        layoutParams3.height = (BdUtilHelper.getEquipmentWidth(this.x) * thaVar.K0.button_heigh.intValue()) / i4;
                        pbFirstFloorViewHolder.t.setLayoutParams(layoutParams3);
                    }
                    pbFirstFloorViewHolder.t.loadUrl(thaVar.K0.schema + "&curskintype=" + G());
                } else {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 8);
                }
            }
            aj9 aj9Var8 = this.l;
            if (aj9Var8 != null && (lj9Var = aj9Var8.h) != null) {
                if (pbFirstFloorViewHolder.p != null) {
                    if (TextUtils.isEmpty(lj9Var.e())) {
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
            aj9 aj9Var9 = this.l;
            if (aj9Var9 != null && aj9Var9.F() != null && this.l.F().size() > 0 && (thaVar2 = this.l.F().get(0)) != null) {
                list = thaVar2.z();
            }
            aj9 aj9Var10 = this.l;
            if (aj9Var10 != null && aj9Var10.O() != null && !Q(this.l.O()) && (!ListUtils.isEmpty(this.l.O().getLinkDataList()) || !ListUtils.isEmpty(this.l.O().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
                gy5 gy5Var = new gy5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
                aj9 aj9Var11 = this.l;
                pbLinkGoodsRootView.h(aj9Var11, gy5Var.b(aj9Var11.O().getLinkDataList(), this.l.O().getGoodsDataList(), list), this.l.m(), this.b, gy5Var.c());
                pbFirstFloorViewHolder.u.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.u.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.u.setVisibility(8);
            }
            aj9 aj9Var12 = this.l;
            if (aj9Var12 != null && aj9Var12.O() != null && this.l.O().getTaskInfoData() != null && this.l.O().getTaskInfoData().f() != null && this.l.O().getTaskInfoData().j() == 2) {
                pbFirstFloorViewHolder.E.setVisibility(0);
                pbFirstFloorViewHolder.E.onBindDataToView(this.l.O());
            } else {
                pbFirstFloorViewHolder.E.setVisibility(8);
            }
            F(pbFirstFloorViewHolder);
        }
    }

    public final void J(PbFirstFloorViewHolder pbFirstFloorViewHolder, w25 w25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbFirstFloorViewHolder, w25Var) == null) && w25Var != null && !ei.isEmpty(w25Var.e()) && w25Var.c() == w25.g) {
            if (!w25Var.f()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(BdUtilHelper.getDimens(this.x, R.dimen.obfuscated_res_0x7f0703e9));
            }
            pbFirstFloorViewHolder.v.c(w25Var);
        }
    }

    public final void K(PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar) {
        View a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbFirstFloorViewHolder, thaVar) == null) && pbFirstFloorViewHolder != null && thaVar != null) {
            pbFirstFloorViewHolder.w.setVisibility(0);
            if (pbFirstFloorViewHolder.x == null) {
                pbFirstFloorViewHolder.x = O(thaVar);
            }
            if (pbFirstFloorViewHolder.w.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.x.a()) != null) {
                pbFirstFloorViewHolder.w.addView(a2);
            }
            pbFirstFloorViewHolder.x.e(this.E);
            pbFirstFloorViewHolder.x.d(this.F);
            pbFirstFloorViewHolder.x.c(thaVar.d0());
            pbFirstFloorViewHolder.x.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void M(PbFirstFloorViewHolder pbFirstFloorViewHolder, aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbFirstFloorViewHolder, aj9Var) == null) && aj9Var != null && aj9Var.t() != null && this.x != null) {
            pbFirstFloorViewHolder.L.setVisibility(0);
            this.B = BdUtilHelper.getColorResourceId(this.x, aj9Var.t().background_color);
            EMManager.from(pbFirstFloorViewHolder.L).setCorner(R.string.J_X05).setBackGroundColor(this.B);
            pbFirstFloorViewHolder.H.setText(aj9Var.t().title_text);
            this.A = BdUtilHelper.getColorResourceId(this.x, aj9Var.t().title_color);
            EMManager.from(pbFirstFloorViewHolder.H).setTextColor(this.A).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02);
            pbFirstFloorViewHolder.G.startLoad(aj9Var.t().title_icon, 10, false);
            pbFirstFloorViewHolder.I.setText(aj9Var.t().link_text);
            this.z = BdUtilHelper.getColorResourceId(this.x, aj9Var.t().link_color);
            EMManager.from(pbFirstFloorViewHolder.I).setTextColor(this.z).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            pbFirstFloorViewHolder.J.startLoad(aj9Var.t().link_icon, 10, false);
            pbFirstFloorViewHolder.K.startLoad(aj9Var.t().link_url, 10, false);
            pbFirstFloorViewHolder.L.setOnClickListener(new d(this, aj9Var));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final hp9 O(tha thaVar) {
        InterceptResult invokeL;
        hp9 hp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, thaVar)) == null) {
            if (thaVar != null && thaVar.d0() != null && thaVar.d0().k()) {
                BaijiahaoData baijiahaoData = thaVar.d0().p;
                Item item = thaVar.d0().C;
                if (!thaVar.d0().m && !thaVar.y1()) {
                    if (item != null && item.item_id.longValue() != 0) {
                        if (thaVar.d0().a != 0 && thaVar.d0().a != 1) {
                            if (thaVar.d0().a == 3) {
                                hp9Var = new np9(this.b.getPageContext());
                            } else {
                                hp9Var = new lp9(this.b.getPageContext());
                            }
                        } else {
                            hp9Var = new mp9(this.b.getPageContext());
                        }
                    } else if (baijiahaoData != null && thaVar.d0().l()) {
                        int i2 = baijiahaoData.oriUgcType;
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        hp9Var = new jp9(this.b.getPageContext(), this.C);
                                    } else {
                                        hp9Var = new pp9(this.b.getPageContext(), this.C);
                                    }
                                } else {
                                    hp9Var = new op9(this.b.getPageContext(), this.C);
                                }
                            } else {
                                hp9Var = new pp9(this.b.getPageContext(), this.C);
                            }
                        } else {
                            hp9Var = new ip9(this.b.getPageContext(), this.C);
                        }
                    } else if (thaVar.d0().a != 0 && thaVar.d0().a != 1) {
                        if (thaVar.d0().a == 3) {
                            hp9Var = new pp9(this.b.getPageContext(), this.C);
                        }
                    } else {
                        hp9Var = new op9(this.b.getPageContext(), this.C);
                    }
                } else {
                    hp9Var = new kp9(this.b.getPageContext(), this.C);
                }
                if (hp9Var != null) {
                    return new jp9(this.b.getPageContext(), this.C);
                }
                return hp9Var;
            }
            hp9Var = null;
            if (hp9Var != null) {
            }
        } else {
            return (hp9) invokeL.objValue;
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
    @Override // com.baidu.tieba.pm
    /* renamed from: R */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d071c, viewGroup, false), this.h, this.g);
            g0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.v.f(this.C);
            pbFirstFloorViewHolder.F.setOnStatListener(this.G);
            pbFirstFloorViewHolder.E.setOnStatListener(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public void h0(@NonNull aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, aj9Var) == null) && aj9Var.O() != null && P() != null && P().b() != null) {
            ThreadData O = aj9Var.O();
            ImageView b2 = P().b();
            if ((!O.isShowTitle() || wn9.w(aj9Var)) && !O.isVideoThreadType()) {
                wn9.b(b2, O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
        }
    }

    public View S(int i2, View view2, ViewGroup viewGroup, tha thaVar, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, thaVar, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) thaVar, (tha) pbFirstFloorViewHolder);
            g0(pbFirstFloorViewHolder);
            a0(pbFirstFloorViewHolder);
            tha thaVar2 = (tha) getItem(i2);
            if (thaVar2 != null) {
                thaVar2.C1();
                thaVar2.f0 = i2 + 1;
                BdUniqueId uniqueId = this.b.getUniqueId();
                aj9 aj9Var = this.l;
                int i3 = thaVar2.f0;
                PbModel pbModel = this.j;
                if (pbModel == null) {
                    str = "";
                } else {
                    str = pbModel.w1();
                }
                PbModel pbModel2 = this.j;
                if (pbModel2 == null) {
                    str2 = "";
                } else {
                    str2 = pbModel2.K0();
                }
                nr9.f(uniqueId, aj9Var, thaVar2, i3, 1, str, str2);
                I(pbFirstFloorViewHolder, thaVar2, view2, i2);
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

    public void W() {
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
        if (this.b.X().W0()) {
            i2 = 1;
        } else if (this.b.X().Z0()) {
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

    public final void Z(PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar, View view2, int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{pbFirstFloorViewHolder, thaVar, view2, Integer.valueOf(i2), sparseArray}) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int s = s(R.dimen.obfuscated_res_0x7f07020f);
        Y(pbFirstFloorViewHolder, s, s(R.dimen.obfuscated_res_0x7f0701be), s, s);
        if (pbFirstFloorViewHolder.h != null) {
            if (!TextUtils.isEmpty(thaVar.D())) {
                pbFirstFloorViewHolder.h.setTag(sparseArray);
                pbFirstFloorViewHolder.h.setVisibility(0);
                pbFirstFloorViewHolder.h.k(qv4.a(thaVar.D()));
                hl9.c(pbFirstFloorViewHolder.h, view2);
            } else {
                pbFirstFloorViewHolder.h.setVisibility(8);
            }
        }
        this.w = true;
        H(pbFirstFloorViewHolder, thaVar, view2, i2);
    }

    public final void b0(PbFirstFloorViewHolder pbFirstFloorViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048599, this, pbFirstFloorViewHolder, thaVar, view2, i2) != null) || pbFirstFloorViewHolder == null) {
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
        H(pbFirstFloorViewHolder, thaVar, view2, i2);
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
