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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.ba9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.wx;
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
public class yb9 extends rb9<n4a, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public ba9 D;
    public qo6<l15> E;
    public wx.a F;
    public a00 G;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public u89 l;
    public ag9 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.z p;
    public ba9 q;
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
        public final /* synthetic */ yb9 b;

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
                    fVar.a.F.k(fVar.b.l.N());
                    this.a.a.F.h();
                }
            }
        }

        public f(yb9 yb9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var, pbFirstFloorViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yb9Var;
            this.a = pbFirstFloorViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.G != null) {
                    this.b.G.b();
                }
                if (this.b.l.N().getHasAgree() == 1) {
                    this.a.F.h();
                    return;
                }
                PbFragment pbFragment = this.b.b;
                if (pbFragment != null) {
                    pbFragment.v6(new a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ba9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb9 a;

        @Override // com.baidu.tieba.ba9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(yb9 yb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yb9Var;
        }

        @Override // com.baidu.tieba.ba9.a
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

        @Override // com.baidu.tieba.ba9.a
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
    public class b extends qo6<l15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb9 b;

        public b(yb9 yb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yb9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, l15 l15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, l15Var) == null) {
                super.a(view2, l15Var);
                if (l15Var != null && l15Var.getThreadData() != null && l15Var.getThreadData().originalThreadData != null && this.b.l != null) {
                    OriginalThreadInfo originalThreadInfo = l15Var.getThreadData().originalThreadData;
                    String P = this.b.l.P();
                    String str = originalThreadInfo.f;
                    int i = 1;
                    int i2 = originalThreadInfo.a;
                    if (i2 == 3) {
                        i = 2;
                    } else if (i2 == 4) {
                        i = 3;
                    }
                    if (!StringUtils.isNull(P) && !StringUtils.isNull(str)) {
                        rg9.q("c12602", P, str, i);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements wx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb9 a;

        public c(yb9 yb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yb9Var;
        }

        @Override // com.baidu.tieba.wx.a
        public void a(l15 l15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, l15Var) == null) && l15Var != null && l15Var.getThreadData() != null && l15Var.getThreadData().originalThreadData != null) {
                OriginalThreadInfo originalThreadInfo = l15Var.getThreadData().originalThreadData;
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
        public final /* synthetic */ u89 a;
        public final /* synthetic */ yb9 b;

        public d(yb9 yb9Var, u89 u89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var, u89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yb9Var;
            this.a = u89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.j0();
            ux4.v(this.b.x, null, this.a.t().link_url, true);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TbRichTextView.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ n4a b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ SparseArray e;
        public final /* synthetic */ yb9 f;

        public e(yb9 yb9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar, View view2, int i, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var, pbFirstFloorViewHolder, n4aVar, view2, Integer.valueOf(i), sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yb9Var;
            this.a = pbFirstFloorViewHolder;
            this.b = n4aVar;
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
            this.f.c0(this.a, this.b, this.c, this.d);
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.a0(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb9 a;

        public g(yb9 yb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yb9Var;
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

        public h(yb9 yb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var};
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
    public class i implements a00 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb9 a;

        public i(yb9 yb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yb9Var;
        }

        @Override // com.baidu.tieba.a00
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.P()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 2));
            }
        }

        @Override // com.baidu.tieba.a00
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.P()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 1));
            }
        }

        @Override // com.baidu.tieba.a00
        public void onShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15022").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.P()).param("fid", this.a.l.l()).param("obj_locate", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((vg9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.D = new ba9(new a(this));
        this.E = new b(this);
        this.F = new c(this);
        this.G = new i(this);
        if (pbFragment != null && pbFragment.Q() != null) {
            this.C = pbFragment.Q().x1();
            this.j = pbFragment.Q();
        }
        this.x = pbFragment.getContext();
    }

    @Override // com.baidu.tieba.rb9, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        U(i2, view2, viewGroup, (n4a) obj, (PbFirstFloorViewHolder) viewHolder);
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

    public final int O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            return xi.g(TbadkCoreApplication.getInst().getContext(), i2);
        }
        return invokeI.intValue;
    }

    public void V(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (pbModel = this.j) != null && z && this.k) {
            pbModel.T2(3);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public void d0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.i = z;
        }
    }

    public void f0(ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, ba9Var) == null) {
            this.q = ba9Var;
        }
    }

    public void g0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, tVar) == null) {
            this.s = tVar;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.g = i2;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, zVar) == null) {
            this.p = zVar;
        }
    }

    public void r(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, u89Var) == null) {
            this.l = u89Var;
        }
    }

    @Override // com.baidu.tieba.kn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.y = z;
        }
    }

    public final void E(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichTextView, view2, z) != null) || tbRichTextView == null) {
            return;
        }
        int m = (((xi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i2 = 0;
        if (z) {
            i2 = s(R.dimen.obfuscated_res_0x7f070275);
        }
        if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
            m /= 2;
        }
        int min = Math.min(m - i2, this.g);
        tbRichTextView.getLayoutStrategy().r(min);
        tbRichTextView.getLayoutStrategy().q((int) (min * 1.618f));
    }

    public final void M(PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar, TbRichText tbRichText) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder, n4aVar, tbRichText) == null) {
            if (n4aVar != null && n4aVar.q() != null && n4aVar.l0() != null) {
                if (tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(n4aVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (n4aVar.q().getSmallTailThemeData() != null) {
                    str = n4aVar.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbFirstFloorViewHolder.l.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbFirstFloorViewHolder.m.setTag(R.id.tag_pb_small_tail_theme_id, str);
                gh9.c(n4aVar.l0(), pbFirstFloorViewHolder.l, pbFirstFloorViewHolder.m, pbFirstFloorViewHolder.n, false, true, z, n4aVar.q().getSmallTailThemeData());
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
        u89 u89Var = this.l;
        if (u89Var != null && u89Var.N() != null && this.l.N().getTaskInfoData() != null && this.l.N().getTaskInfoData().f() != null && this.l.N().getTaskInfoData().j() == 3) {
            pbFirstFloorViewHolder.F.setVisibility(0);
            pbFirstFloorViewHolder.F.a(this.l.N());
            pbFirstFloorViewHolder.F.setItemBtnClickListener(new f(this, pbFirstFloorViewHolder));
            return;
        }
        pbFirstFloorViewHolder.F.setVisibility(8);
    }

    public final void b0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.c.setOnTouchListener(this.q);
            pbFirstFloorViewHolder.c.setOnLongClickListener(this.r);
            je9 je9Var = this.a.V().c;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.D);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new h(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(je9Var.f);
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

    public PbFirstFloorViewHolder Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (PbFirstFloorViewHolder) this.viewholder;
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            u89 u89Var = this.l;
            if (u89Var != null && u89Var.N() != null) {
                return this.l.N().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void W() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).v.d();
        }
    }

    public void Y() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).v.e();
            ((PbFirstFloorViewHolder) this.viewholder).s.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0511  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar, View view2, int i2) {
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
        if ((interceptable != null && interceptable.invokeLLLI(1048580, this, pbFirstFloorViewHolder, n4aVar, view2, i2) != null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        int i3 = 1;
        if (n4aVar.I() != 1) {
            if (TextUtils.isEmpty(n4aVar.t())) {
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
        if (n4aVar.I() == 1) {
            pbFirstFloorViewHolder.d(this.l, this.b.z0(), n4aVar.Q);
            E(pbFirstFloorViewHolder.f, view2, this.w);
            if (n4aVar.q() != null) {
                long userIdLong = n4aVar.q().getUserIdLong();
                str = n4aVar.q().getUserName();
                j = userIdLong;
                str2 = n4aVar.q().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            u89 u89Var = this.l;
            if (u89Var != null && u89Var.N() != null) {
                pbFirstFloorViewHolder.v.b(n4aVar.Q(), str, str2, j, vg.g(this.l.N().getId(), 0L), vg.g(n4aVar.S(), 0L));
            }
            u89 u89Var2 = this.l;
            if (u89Var2 != null && u89Var2.N() != null && this.l.N().getYulePostActivityData() != null) {
                e55 yulePostActivityData = this.l.N().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.j.setVisibility(0);
                    pbFirstFloorViewHolder.j.N(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.j.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.k;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            u89 u89Var3 = this.l;
            if (u89Var3 != null && u89Var3.N() != null && this.l.N().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.y) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.y.getPaddingRight(), pbFirstFloorViewHolder.y.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().z(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, n4aVar);
        sparseArray.put(R.id.tag_load_sub_data, n4aVar);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(n4aVar.I()));
        if (!n4aVar.z0() && !n4aVar.y0(false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.m == null) {
                ag9 ag9Var = new ag9(this.x);
                this.m = ag9Var;
                ag9Var.f(this.e);
                this.m.h(this.n);
                u89 u89Var4 = this.l;
                if (u89Var4 != null) {
                    this.m.j(this.l.V(), TextUtils.equals(u89Var4.N().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.N());
                }
            }
            this.m.g(n4aVar.S());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        u89 u89Var5 = this.l;
        if (u89Var5 != null && u89Var5.N() != null && this.l.N().isLinkThread()) {
            J(pbFirstFloorViewHolder, this.l.N().getLinkThreadData());
        }
        u89 u89Var6 = this.l;
        if (u89Var6 != null && u89Var6.N() != null && this.l.N().isShareThread && n4aVar.c0() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (n4aVar.c0().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.tbds14));
            }
            K(pbFirstFloorViewHolder, n4aVar);
        } else {
            u89 u89Var7 = this.l;
            if (u89Var7 != null && u89Var7.N() != null && this.l.N().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.M_H_X007));
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(O(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.tbds24));
            }
        }
        N(pbFirstFloorViewHolder, this.l);
        TbRichText e0 = n4aVar.e0();
        u89 u89Var8 = this.l;
        if (u89Var8 == null || !u89Var8.w0()) {
            tbRichText = e0;
        }
        if (this.l.N() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.P());
            pbFirstFloorViewHolder.f.setPid(n4aVar.S());
            pbFirstFloorViewHolder.f.setPosition(TbRichTextView.Position.PB_FIRST_FLOOR);
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.N().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        u89 u89Var9 = this.l;
        if (u89Var9 != null && 3 == u89Var9.f()) {
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
        M(pbFirstFloorViewHolder, n4aVar, tbRichText);
        boolean z10 = !StringUtils.isNull(n4aVar.q().getVirtualUserUrl());
        u89 u89Var10 = this.l;
        if (u89Var10 != null && u89Var10.V() != 0 && !R()) {
            if (this.l.V() != 3) {
                z4 = true;
                z5 = true;
            } else {
                z4 = false;
                z5 = false;
            }
            if (n4aVar.q() != null) {
                String userId = n4aVar.q().getUserId();
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
        u89 u89Var11 = this.l;
        if (u89Var11 != null && u89Var11.N() != null && this.l.N().getAuthor() != null && n4aVar.q() != null) {
            String userId2 = this.l.N().getAuthor().getUserId();
            String userId3 = n4aVar.q().getUserId();
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
                if (n4aVar.q() != null && UtilHelper.isCurrentAccount(n4aVar.q().getUserId())) {
                    z5 = true;
                    z7 = true;
                }
                if (z10) {
                    z4 = false;
                    z5 = false;
                    z6 = false;
                }
                if (n4aVar.I() == 1) {
                    i3 = 0;
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, n4aVar.S());
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    if (n4aVar.q() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, n4aVar.q().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, n4aVar.q().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, n4aVar.q().getPortrait());
                    }
                    u89 u89Var12 = this.l;
                    if (u89Var12 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(u89Var12.V()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z6) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (n4aVar.q() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, n4aVar.q().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, n4aVar.q().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, n4aVar.q().getName_show());
                    }
                    u89 u89Var13 = this.l;
                    if (u89Var13 != null && u89Var13.N() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.l.N().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, n4aVar.S());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(z));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(R.id.tag_del_post_id, n4aVar.S());
                    u89 u89Var14 = this.l;
                    if (u89Var14 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(u89Var14.V()));
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
        if (n4aVar.q() != null) {
            z5 = true;
            z7 = true;
        }
        if (z10) {
        }
        if (n4aVar.I() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, n4aVar.S());
        if (!z4) {
        }
        if (!z6) {
        }
        if (!z5) {
        }
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
        D(pbFirstFloorViewHolder);
    }

    public final void I(PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar, View view2, int i2) {
        n4a n4aVar2;
        f99 f99Var;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048581, this, pbFirstFloorViewHolder, n4aVar, view2, i2) == null) && pbFirstFloorViewHolder != null && n4aVar != null) {
            dx9.a("pb", true);
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.f.setTag(sparseArray);
            pbFirstFloorViewHolder.c.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, n4aVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbFirstFloorViewHolder.f.setIsHost(true);
            if (this.i) {
                pbFirstFloorViewHolder.i.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            via.c(n4aVar, pbFirstFloorViewHolder.f);
            if (!TextUtils.isEmpty(n4aVar.t()) && this.h) {
                pbFirstFloorViewHolder.f.q0(n4aVar.t(), new e(this, pbFirstFloorViewHolder, n4aVar, view2, i2, sparseArray));
            } else {
                c0(pbFirstFloorViewHolder, n4aVar, view2, i2);
            }
            u89 u89Var = this.l;
            if (u89Var != null) {
                i0(u89Var);
            }
            u89 u89Var2 = this.l;
            if (u89Var2 != null && u89Var2.N() != null && this.l.N().isVideoThreadType() && this.l.N().getThreadVideoInfo() != null && wi.isEmpty(this.l.k().getName())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (n4aVar.e0() != null && !ListUtils.isEmpty(n4aVar.e0().W())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            } else {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            }
            if (n4aVar.e0() != null) {
                if (n4aVar.e0().X() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams.topMargin = s(R.dimen.tbds26);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams2.topMargin = s(R.dimen.tbds16);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams2);
                }
            }
            u89 u89Var3 = this.l;
            if (u89Var3 != null && S(u89Var3.N())) {
                pbFirstFloorViewHolder.B.setDataForPb(this.l.N().getPollData(), this.l.N().getTid(), this.l.l());
                pbFirstFloorViewHolder.B.setupLiveThreadVoteInfo(this.l.N());
                if (n4aVar.e0() != null && !ListUtils.isEmpty(n4aVar.e0().W())) {
                    pbFirstFloorViewHolder.B.setMarginTop(xi.g(this.x, R.dimen.tbds26));
                } else {
                    pbFirstFloorViewHolder.B.setMarginTop(xi.g(this.x, R.dimen.tbds0));
                }
                pbFirstFloorViewHolder.B.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.B.setVisibility(8);
            }
            u89 u89Var4 = this.l;
            if (u89Var4 != null && u89Var4.N() != null && this.l.N().getSmartApp() != null && this.l.N().getThreadVideoInfo() == null) {
                pbFirstFloorViewHolder.q.setData(this.l.N().getSmartApp());
                pbFirstFloorViewHolder.q.setVisibility(0);
                u89 u89Var5 = this.l;
                if (u89Var5 != null && u89Var5.k() != null) {
                    pbFirstFloorViewHolder.q.setForumId(String.valueOf(this.l.k().getId()));
                }
                u89 u89Var6 = this.l;
                if (u89Var6 != null && u89Var6.P() != null) {
                    pbFirstFloorViewHolder.q.setThreadId(this.l.P());
                }
                pbFirstFloorViewHolder.q.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.q.setVisibility(8);
            }
            if (this.l != null) {
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.Q() != null) {
                    pbFirstFloorViewHolder.D.g("1".equals(this.b.Q().showReplyPanel));
                }
                pbFirstFloorViewHolder.D.setData(this.l.N(), this.l.O(), this.y);
            }
            if (NovelPaySwitch.isOn() && n4aVar.a0() != null && !n4aVar.a0().i() && this.l.o0()) {
                this.k = true;
                pbFirstFloorViewHolder.r.setVisibility(0);
                pbFirstFloorViewHolder.s.setVisibility(0);
                pbFirstFloorViewHolder.s.setData(n4aVar.a0());
                NovelMemberCardView novelMemberCardView = pbFirstFloorViewHolder.s;
                String P = this.l.P();
                String l = this.l.l();
                if (this.l.N() != null) {
                    i3 = this.l.N().getThreadType();
                } else {
                    i3 = 0;
                }
                novelMemberCardView.setStatisticData(P, l, i3);
            } else {
                pbFirstFloorViewHolder.r.setVisibility(8);
                pbFirstFloorViewHolder.s.setVisibility(8);
            }
            if (pbFirstFloorViewHolder.t != null) {
                FullLengthNovel fullLengthNovel = n4aVar.J0;
                if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 0);
                    if (pbFirstFloorViewHolder.t.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.t.getLayoutParams();
                        int i4 = 1080;
                        if (xi.l(this.x) < 1080) {
                            i4 = xi.l(this.x);
                        }
                        layoutParams3.height = (xi.l(this.x) * n4aVar.J0.button_heigh.intValue()) / i4;
                        pbFirstFloorViewHolder.t.setLayoutParams(layoutParams3);
                    }
                    pbFirstFloorViewHolder.t.loadUrl(n4aVar.J0.schema + "&curskintype=" + G());
                } else {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 8);
                }
            }
            u89 u89Var7 = this.l;
            if (u89Var7 != null && (f99Var = u89Var7.h) != null) {
                if (pbFirstFloorViewHolder.p != null) {
                    if (TextUtils.isEmpty(f99Var.e())) {
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
            u89 u89Var8 = this.l;
            if (u89Var8 != null && u89Var8.F() != null && this.l.F().size() > 0 && (n4aVar2 = this.l.F().get(0)) != null) {
                list = n4aVar2.y();
            }
            u89 u89Var9 = this.l;
            if (u89Var9 != null && u89Var9.N() != null && !S(this.l.N()) && (!ListUtils.isEmpty(this.l.N().getLinkDataList()) || !ListUtils.isEmpty(this.l.N().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
                by5 by5Var = new by5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
                u89 u89Var10 = this.l;
                pbLinkGoodsRootView.h(u89Var10, by5Var.b(u89Var10.N().getLinkDataList(), this.l.N().getGoodsDataList(), list), this.l.m(), this.b, by5Var.c());
                pbFirstFloorViewHolder.u.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.u.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.u.setVisibility(8);
            }
            u89 u89Var11 = this.l;
            if (u89Var11 != null && u89Var11.N() != null && this.l.N().getTaskInfoData() != null && this.l.N().getTaskInfoData().f() != null && this.l.N().getTaskInfoData().j() == 2) {
                pbFirstFloorViewHolder.E.setVisibility(0);
                pbFirstFloorViewHolder.E.a(this.l.N());
            } else {
                pbFirstFloorViewHolder.E.setVisibility(8);
            }
            F(pbFirstFloorViewHolder);
        }
    }

    public final void J(PbFirstFloorViewHolder pbFirstFloorViewHolder, f35 f35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbFirstFloorViewHolder, f35Var) == null) && f35Var != null && !wi.isEmpty(f35Var.e()) && f35Var.c() == f35.g) {
            if (!f35Var.f()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(xi.g(this.x, R.dimen.obfuscated_res_0x7f0703df));
            }
            pbFirstFloorViewHolder.v.c(f35Var);
        }
    }

    public final void K(PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar) {
        View a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbFirstFloorViewHolder, n4aVar) == null) && pbFirstFloorViewHolder != null && n4aVar != null) {
            pbFirstFloorViewHolder.w.setVisibility(0);
            if (pbFirstFloorViewHolder.x == null) {
                pbFirstFloorViewHolder.x = P(n4aVar);
            }
            if (pbFirstFloorViewHolder.w.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.x.a()) != null) {
                pbFirstFloorViewHolder.w.addView(a2);
            }
            pbFirstFloorViewHolder.x.e(this.E);
            pbFirstFloorViewHolder.x.d(this.F);
            pbFirstFloorViewHolder.x.c(n4aVar.c0());
            pbFirstFloorViewHolder.x.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void N(PbFirstFloorViewHolder pbFirstFloorViewHolder, u89 u89Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbFirstFloorViewHolder, u89Var) == null) && u89Var != null && u89Var.t() != null && this.x != null) {
            pbFirstFloorViewHolder.L.setVisibility(0);
            this.B = xi.e(this.x, u89Var.t().background_color);
            s75 d2 = s75.d(pbFirstFloorViewHolder.L);
            d2.o(R.string.J_X05);
            d2.f(this.B);
            pbFirstFloorViewHolder.H.setText(u89Var.t().title_text);
            this.A = xi.e(this.x, u89Var.t().title_color);
            s75 d3 = s75.d(pbFirstFloorViewHolder.H);
            d3.x(this.A);
            d3.C(R.dimen.T_X07);
            d3.D(R.string.F_X02);
            pbFirstFloorViewHolder.G.N(u89Var.t().title_icon, 10, false);
            pbFirstFloorViewHolder.I.setText(u89Var.t().link_text);
            this.z = xi.e(this.x, u89Var.t().link_color);
            s75 d4 = s75.d(pbFirstFloorViewHolder.I);
            d4.x(this.z);
            d4.C(R.dimen.T_X09);
            d4.D(R.string.F_X01);
            pbFirstFloorViewHolder.J.N(u89Var.t().link_icon, 10, false);
            pbFirstFloorViewHolder.K.N(u89Var.t().link_url, 10, false);
            pbFirstFloorViewHolder.L.setOnClickListener(new d(this, u89Var));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final me9 P(n4a n4aVar) {
        InterceptResult invokeL;
        me9 me9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, n4aVar)) == null) {
            if (n4aVar != null && n4aVar.c0() != null && n4aVar.c0().k()) {
                BaijiahaoData baijiahaoData = n4aVar.c0().p;
                Item item = n4aVar.c0().C;
                if (!n4aVar.c0().m && !n4aVar.u1()) {
                    if (item != null && item.item_id.longValue() != 0) {
                        if (n4aVar.c0().a != 0 && n4aVar.c0().a != 1) {
                            if (n4aVar.c0().a == 3) {
                                me9Var = new se9(this.b.getPageContext());
                            } else {
                                me9Var = new qe9(this.b.getPageContext());
                            }
                        } else {
                            me9Var = new re9(this.b.getPageContext());
                        }
                    } else if (baijiahaoData != null && n4aVar.c0().l()) {
                        int i2 = baijiahaoData.oriUgcType;
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        me9Var = new oe9(this.b.getPageContext(), this.C);
                                    } else {
                                        me9Var = new ue9(this.b.getPageContext(), this.C);
                                    }
                                } else {
                                    me9Var = new te9(this.b.getPageContext(), this.C);
                                }
                            } else {
                                me9Var = new ue9(this.b.getPageContext(), this.C);
                            }
                        } else {
                            me9Var = new ne9(this.b.getPageContext(), this.C);
                        }
                    } else if (n4aVar.c0().a != 0 && n4aVar.c0().a != 1) {
                        if (n4aVar.c0().a == 3) {
                            me9Var = new ue9(this.b.getPageContext(), this.C);
                        }
                    } else {
                        me9Var = new te9(this.b.getPageContext(), this.C);
                    }
                } else {
                    me9Var = new pe9(this.b.getPageContext(), this.C);
                }
                if (me9Var != null) {
                    return new oe9(this.b.getPageContext(), this.C);
                }
                return me9Var;
            }
            me9Var = null;
            if (me9Var != null) {
            }
        } else {
            return (me9) invokeL.objValue;
        }
    }

    public final boolean S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, threadData)) == null) {
            if (threadData != null && threadData.getPollData() != null && threadData.getPollData().getOptions() != null && threadData.getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: T */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d06e5, viewGroup, false), this.h, this.g);
            h0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.v.f(this.C);
            pbFirstFloorViewHolder.F.setOnStatListener(this.G);
            pbFirstFloorViewHolder.E.setOnStatListener(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public void i0(@NonNull u89 u89Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, u89Var) == null) && u89Var.N() != null && Q() != null && Q().b() != null) {
            ThreadData N = u89Var.N();
            ImageView b2 = Q().b();
            if ((!N.isShowTitle() || cd9.x(u89Var)) && !N.isVideoThreadType()) {
                cd9.b(b2, N.isHeadLinePost, N.isGoodThread(), N.isTopThread());
            }
        }
    }

    public View U(int i2, View view2, ViewGroup viewGroup, n4a n4aVar, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, n4aVar, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) n4aVar, (n4a) pbFirstFloorViewHolder);
            h0(pbFirstFloorViewHolder);
            b0(pbFirstFloorViewHolder);
            n4a n4aVar2 = (n4a) getItem(i2);
            if (n4aVar2 != null) {
                n4aVar2.y1();
                n4aVar2.e0 = i2 + 1;
                rg9.d(this.b.getUniqueId(), this.l, n4aVar2, n4aVar2.e0, 1);
                I(pbFirstFloorViewHolder, n4aVar2, view2, i2);
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

    public final void a0(PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar, View view2, int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048598, this, new Object[]{pbFirstFloorViewHolder, n4aVar, view2, Integer.valueOf(i2), sparseArray}) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int s = s(R.dimen.obfuscated_res_0x7f07020f);
        Z(pbFirstFloorViewHolder, s, s(R.dimen.obfuscated_res_0x7f0701be), s, s);
        if (pbFirstFloorViewHolder.h != null) {
            if (!TextUtils.isEmpty(n4aVar.B())) {
                pbFirstFloorViewHolder.h.setTag(sparseArray);
                pbFirstFloorViewHolder.h.setVisibility(0);
                pbFirstFloorViewHolder.h.k(pw4.a(n4aVar.B()));
                na9.a(pbFirstFloorViewHolder.h, view2);
            } else {
                pbFirstFloorViewHolder.h.setVisibility(8);
            }
        }
        this.w = true;
        H(pbFirstFloorViewHolder, n4aVar, view2, i2);
    }

    public void X() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (v = this.viewholder) == 0) {
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
            ((PbFirstFloorViewHolder) v3).s.i();
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

    public final void j0() {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048610, this) != null) || this.l == null) {
            return;
        }
        int i3 = 0;
        if (this.b.Q().d1()) {
            i2 = 1;
        } else if (this.b.Q().g1()) {
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
        new StatisticItem("c15063").addParam("obj_locate", i2).addParam("fid", this.l.l()).addParam("fname", this.l.m()).addParam("post_id", this.l.P()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
    }

    public final void Z(PbFirstFloorViewHolder pbFirstFloorViewHolder, int i2, int i3, int i4, int i5) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{pbFirstFloorViewHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && pbFirstFloorViewHolder != null && (relativeLayout = pbFirstFloorViewHolder.g) != null && relativeLayout.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.g.getLayoutParams();
            layoutParams.bottomMargin = i5;
            layoutParams.topMargin = i3;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i4;
            pbFirstFloorViewHolder.g.setLayoutParams(layoutParams);
        }
    }

    public final void c0(PbFirstFloorViewHolder pbFirstFloorViewHolder, n4a n4aVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048601, this, pbFirstFloorViewHolder, n4aVar, view2, i2) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        Z(pbFirstFloorViewHolder, 0, 0, 0, 0);
        TbRichTextView tbRichTextView = pbFirstFloorViewHolder.f;
        if (tbRichTextView != null) {
            tbRichTextView.p0(null);
        }
        TbAlphaVideo tbAlphaVideo = pbFirstFloorViewHolder.h;
        if (tbAlphaVideo != null) {
            tbAlphaVideo.setVisibility(8);
        }
        this.w = false;
        H(pbFirstFloorViewHolder, n4aVar, view2, i2);
    }

    public final void h0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, pbFirstFloorViewHolder) != null) || pbFirstFloorViewHolder == null) {
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
            pbFirstFloorViewHolder.s.g();
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
