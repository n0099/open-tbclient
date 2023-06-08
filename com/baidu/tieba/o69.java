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
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.s49;
import com.baidu.tieba.ux;
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
/* loaded from: classes7.dex */
public class o69 extends i69<jy9, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public s49 D;
    public go6<h15> E;
    public ux.a F;
    public yz G;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public m39 l;
    public ka9 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.a0 p;
    public s49 q;
    public View.OnLongClickListener r;
    public TbRichTextView.u s;
    public View.OnClickListener t;
    public boolean u;
    public final boolean v;
    public boolean w;
    public Context x;
    public boolean y;
    public int z;

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ o69 b;

        /* loaded from: classes7.dex */
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

        public f(o69 o69Var, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var, pbFirstFloorViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o69Var;
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
                    pbFragment.u6(new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements s49.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        @Override // com.baidu.tieba.s49.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // com.baidu.tieba.s49.a
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

        @Override // com.baidu.tieba.s49.a
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

    /* loaded from: classes7.dex */
    public class b extends go6<h15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 b;

        public b(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, h15 h15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, h15Var) == null) {
                super.a(view2, h15Var);
                if (h15Var != null && h15Var.getThreadData() != null && h15Var.getThreadData().originalThreadData != null && this.b.l != null) {
                    OriginalThreadInfo originalThreadInfo = h15Var.getThreadData().originalThreadData;
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
                        bb9.o("c12602", P, str, i);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public c(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(h15 h15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h15Var) == null) && h15Var != null && h15Var.getThreadData() != null && h15Var.getThreadData().originalThreadData != null) {
                OriginalThreadInfo originalThreadInfo = h15Var.getThreadData().originalThreadData;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.x);
                pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
                pbActivityConfig.setStartFrom(this.a.C);
                pbActivityConfig.setBjhData(originalThreadInfo.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m39 a;
        public final /* synthetic */ o69 b;

        public d(o69 o69Var, m39 m39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var, m39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o69Var;
            this.a = m39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.j0();
            qx4.v(this.b.x, null, this.a.t().link_url, true);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ jy9 b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ SparseArray e;
        public final /* synthetic */ o69 f;

        public e(o69 o69Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var, View view2, int i, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var, pbFirstFloorViewHolder, jy9Var, view2, Integer.valueOf(i), sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = o69Var;
            this.a = pbFirstFloorViewHolder;
            this.b = jy9Var;
            this.c = view2;
            this.d = i;
            this.e = sparseArray;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.c0(this.a, this.b, this.c, this.d);
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.a0(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public g(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
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

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public h(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
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

    /* loaded from: classes7.dex */
    public class i implements yz {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public i(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // com.baidu.tieba.yz
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.P()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 2));
            }
        }

        @Override // com.baidu.tieba.yz
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.P()).param("fid", this.a.l.l()).param("obj_locate", 2).param("obj_param1", 1));
            }
        }

        @Override // com.baidu.tieba.yz
        public void onShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15022").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.P()).param("fid", this.a.l.l()).param("obj_locate", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o69(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((fb9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.D = new s49(new a(this));
        this.E = new b(this);
        this.F = new c(this);
        this.G = new i(this);
        if (pbFragment != null && pbFragment.Q() != null) {
            this.C = pbFragment.Q().x1();
            this.j = pbFragment.Q();
        }
        this.x = pbFragment.getContext();
    }

    @Override // com.baidu.tieba.i69, com.baidu.tieba.in
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        U(i2, view2, viewGroup, (jy9) obj, (PbFirstFloorViewHolder) viewHolder);
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
            return vi.g(TbadkCoreApplication.getInst().getContext(), i2);
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

    public void f0(s49 s49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, s49Var) == null) {
            this.q = s49Var;
        }
    }

    public void g0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, uVar) == null) {
            this.s = uVar;
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

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, a0Var) == null) {
            this.p = a0Var;
        }
    }

    public void r(m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, m39Var) == null) {
            this.l = m39Var;
        }
    }

    @Override // com.baidu.tieba.in
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
        int m = (((vi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
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

    public final void M(PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var, TbRichText tbRichText) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder, jy9Var, tbRichText) == null) {
            if (jy9Var != null && jy9Var.p() != null && jy9Var.h0() != null) {
                if (tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(jy9Var.s())) {
                    z = true;
                } else {
                    z = false;
                }
                if (jy9Var.p().getSmallTailThemeData() != null) {
                    str = jy9Var.p().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbFirstFloorViewHolder.l.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbFirstFloorViewHolder.m.setTag(R.id.tag_pb_small_tail_theme_id, str);
                qb9.c(jy9Var.h0(), pbFirstFloorViewHolder.l, pbFirstFloorViewHolder.m, pbFirstFloorViewHolder.n, false, true, z, jy9Var.p().getSmallTailThemeData());
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
        m39 m39Var = this.l;
        if (m39Var != null && m39Var.N() != null && this.l.N().getTaskInfoData() != null && this.l.N().getTaskInfoData().f() != null && this.l.N().getTaskInfoData().j() == 3) {
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
            b99 b99Var = this.a.V().c;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.D);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new h(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(b99Var.f);
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
            m39 m39Var = this.l;
            if (m39Var != null && m39Var.N() != null) {
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
    public final void H(PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var, View view2, int i2) {
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
        if ((interceptable != null && interceptable.invokeLLLI(1048580, this, pbFirstFloorViewHolder, jy9Var, view2, i2) != null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        int i3 = 1;
        if (jy9Var.D() != 1) {
            if (TextUtils.isEmpty(jy9Var.s())) {
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
        if (jy9Var.D() == 1) {
            pbFirstFloorViewHolder.d(this.l, this.b.z0(), jy9Var.Q);
            E(pbFirstFloorViewHolder.f, view2, this.w);
            if (jy9Var.p() != null) {
                long userIdLong = jy9Var.p().getUserIdLong();
                str = jy9Var.p().getUserName();
                j = userIdLong;
                str2 = jy9Var.p().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            m39 m39Var = this.l;
            if (m39Var != null && m39Var.N() != null) {
                pbFirstFloorViewHolder.v.b(jy9Var.L(), str, str2, j, tg.g(this.l.N().getId(), 0L), tg.g(jy9Var.O(), 0L));
            }
            m39 m39Var2 = this.l;
            if (m39Var2 != null && m39Var2.N() != null && this.l.N().getYulePostActivityData() != null) {
                a55 yulePostActivityData = this.l.N().getYulePostActivityData();
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
            m39 m39Var3 = this.l;
            if (m39Var3 != null && m39Var3.N() != null && this.l.N().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.y) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.y.getPaddingRight(), pbFirstFloorViewHolder.y.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().z(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, jy9Var);
        sparseArray.put(R.id.tag_load_sub_data, jy9Var);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(jy9Var.D()));
        if (!jy9Var.v0() && !jy9Var.u0(false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.m == null) {
                ka9 ka9Var = new ka9(this.x);
                this.m = ka9Var;
                ka9Var.f(this.e);
                this.m.h(this.n);
                m39 m39Var4 = this.l;
                if (m39Var4 != null) {
                    this.m.j(this.l.V(), TextUtils.equals(m39Var4.N().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.N());
                }
            }
            this.m.g(jy9Var.O());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.transparent_bg);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().h(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        m39 m39Var5 = this.l;
        if (m39Var5 != null && m39Var5.N() != null && this.l.N().isLinkThread()) {
            J(pbFirstFloorViewHolder, this.l.N().getLinkThreadData());
        }
        m39 m39Var6 = this.l;
        if (m39Var6 != null && m39Var6.N() != null && this.l.N().isShareThread && jy9Var.Y() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (jy9Var.Y().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.tbds14));
            }
            K(pbFirstFloorViewHolder, jy9Var);
        } else {
            m39 m39Var7 = this.l;
            if (m39Var7 != null && m39Var7.N() != null && this.l.N().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.M_H_X007));
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(O(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(O(R.dimen.tbds24));
            }
        }
        N(pbFirstFloorViewHolder, this.l);
        TbRichText a0 = jy9Var.a0();
        m39 m39Var8 = this.l;
        if (m39Var8 == null || !m39Var8.w0()) {
            tbRichText = a0;
        }
        if (this.l.N() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.P());
            pbFirstFloorViewHolder.f.setPid(jy9Var.O());
            pbFirstFloorViewHolder.f.setPosition(TbRichTextView.Position.PB_FIRST_FLOOR);
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.N().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        m39 m39Var9 = this.l;
        if (m39Var9 != null && 3 == m39Var9.f()) {
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
        M(pbFirstFloorViewHolder, jy9Var, tbRichText);
        boolean z10 = !StringUtils.isNull(jy9Var.p().getVirtualUserUrl());
        m39 m39Var10 = this.l;
        if (m39Var10 != null && m39Var10.V() != 0 && !R()) {
            if (this.l.V() != 3) {
                z4 = true;
                z5 = true;
            } else {
                z4 = false;
                z5 = false;
            }
            if (jy9Var.p() != null) {
                String userId = jy9Var.p().getUserId();
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
        m39 m39Var11 = this.l;
        if (m39Var11 != null && m39Var11.N() != null && this.l.N().getAuthor() != null && jy9Var.p() != null) {
            String userId2 = this.l.N().getAuthor().getUserId();
            String userId3 = jy9Var.p().getUserId();
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
                if (jy9Var.p() != null && UtilHelper.isCurrentAccount(jy9Var.p().getUserId())) {
                    z5 = true;
                    z7 = true;
                }
                if (z10) {
                    z4 = false;
                    z5 = false;
                    z6 = false;
                }
                if (jy9Var.D() == 1) {
                    i3 = 0;
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, jy9Var.O());
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    if (jy9Var.p() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, jy9Var.p().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, jy9Var.p().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, jy9Var.p().getPortrait());
                    }
                    m39 m39Var12 = this.l;
                    if (m39Var12 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(m39Var12.V()));
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z6) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (jy9Var.p() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, jy9Var.p().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, jy9Var.p().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, jy9Var.p().getName_show());
                    }
                    m39 m39Var13 = this.l;
                    if (m39Var13 != null && m39Var13.N() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.l.N().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, jy9Var.O());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(z));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(R.id.tag_del_post_id, jy9Var.O());
                    m39 m39Var14 = this.l;
                    if (m39Var14 != null) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(m39Var14.V()));
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
        if (jy9Var.p() != null) {
            z5 = true;
            z7 = true;
        }
        if (z10) {
        }
        if (jy9Var.D() == 1) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, jy9Var.O());
        if (!z4) {
        }
        if (!z6) {
        }
        if (!z5) {
        }
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
        D(pbFirstFloorViewHolder);
    }

    public final void I(PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var, View view2, int i2) {
        jy9 jy9Var2;
        y39 y39Var;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048581, this, pbFirstFloorViewHolder, jy9Var, view2, i2) == null) && pbFirstFloorViewHolder != null && jy9Var != null) {
            zq9.a("pb", true);
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.f.setTag(sparseArray);
            pbFirstFloorViewHolder.c.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, jy9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbFirstFloorViewHolder.f.setIsHost(true);
            if (this.i) {
                pbFirstFloorViewHolder.i.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            oca.c(jy9Var, pbFirstFloorViewHolder.f);
            if (!TextUtils.isEmpty(jy9Var.s()) && this.h) {
                pbFirstFloorViewHolder.f.q0(jy9Var.s(), new e(this, pbFirstFloorViewHolder, jy9Var, view2, i2, sparseArray));
            } else {
                c0(pbFirstFloorViewHolder, jy9Var, view2, i2);
            }
            m39 m39Var = this.l;
            if (m39Var != null) {
                i0(m39Var);
            }
            m39 m39Var2 = this.l;
            if (m39Var2 != null && m39Var2.N() != null && this.l.N().isVideoThreadType() && this.l.N().getThreadVideoInfo() != null && ui.isEmpty(this.l.k().getName())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (jy9Var.a0() != null && !ListUtils.isEmpty(jy9Var.a0().W())) {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            } else {
                pbFirstFloorViewHolder.c(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            }
            if (jy9Var.a0() != null) {
                if (jy9Var.a0().X() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams.topMargin = s(R.dimen.tbds26);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.q.getLayoutParams();
                    layoutParams2.topMargin = s(R.dimen.tbds16);
                    pbFirstFloorViewHolder.q.setLayoutParams(layoutParams2);
                }
            }
            m39 m39Var3 = this.l;
            if (m39Var3 != null && S(m39Var3.N())) {
                pbFirstFloorViewHolder.B.setDataForPb(this.l.N().getPollData(), this.l.N().getTid(), this.l.l());
                pbFirstFloorViewHolder.B.setupLiveThreadVoteInfo(this.l.N());
                if (jy9Var.a0() != null && !ListUtils.isEmpty(jy9Var.a0().W())) {
                    pbFirstFloorViewHolder.B.setMarginTop(vi.g(this.x, R.dimen.tbds26));
                } else {
                    pbFirstFloorViewHolder.B.setMarginTop(vi.g(this.x, R.dimen.tbds0));
                }
                pbFirstFloorViewHolder.B.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.B.setVisibility(8);
            }
            m39 m39Var4 = this.l;
            if (m39Var4 != null && m39Var4.N() != null && this.l.N().getSmartApp() != null && this.l.N().getThreadVideoInfo() == null) {
                pbFirstFloorViewHolder.q.setData(this.l.N().getSmartApp());
                pbFirstFloorViewHolder.q.setVisibility(0);
                m39 m39Var5 = this.l;
                if (m39Var5 != null && m39Var5.k() != null) {
                    pbFirstFloorViewHolder.q.setForumId(String.valueOf(this.l.k().getId()));
                }
                m39 m39Var6 = this.l;
                if (m39Var6 != null && m39Var6.P() != null) {
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
            if (NovelPaySwitch.isOn() && jy9Var.W() != null && !jy9Var.W().i() && this.l.o0()) {
                this.k = true;
                pbFirstFloorViewHolder.r.setVisibility(0);
                pbFirstFloorViewHolder.s.setVisibility(0);
                pbFirstFloorViewHolder.s.setData(jy9Var.W());
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
                FullLengthNovel fullLengthNovel = jy9Var.I0;
                if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 0);
                    if (pbFirstFloorViewHolder.t.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.t.getLayoutParams();
                        int i4 = 1080;
                        if (vi.l(this.x) < 1080) {
                            i4 = vi.l(this.x);
                        }
                        layoutParams3.height = (vi.l(this.x) * jy9Var.I0.button_heigh.intValue()) / i4;
                        pbFirstFloorViewHolder.t.setLayoutParams(layoutParams3);
                    }
                    pbFirstFloorViewHolder.t.loadUrl(jy9Var.I0.schema + "&curskintype=" + G());
                } else {
                    ViewCommonUtil.setVisibility(pbFirstFloorViewHolder.t, 8);
                }
            }
            m39 m39Var7 = this.l;
            if (m39Var7 != null && (y39Var = m39Var7.h) != null) {
                if (pbFirstFloorViewHolder.p != null) {
                    if (TextUtils.isEmpty(y39Var.e())) {
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
            m39 m39Var8 = this.l;
            if (m39Var8 != null && m39Var8.F() != null && this.l.F().size() > 0 && (jy9Var2 = this.l.F().get(0)) != null) {
                list = jy9Var2.t();
            }
            m39 m39Var9 = this.l;
            if (m39Var9 != null && m39Var9.N() != null && !S(this.l.N()) && (!ListUtils.isEmpty(this.l.N().getLinkDataList()) || !ListUtils.isEmpty(this.l.N().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
                rx5 rx5Var = new rx5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
                m39 m39Var10 = this.l;
                pbLinkGoodsRootView.h(m39Var10, rx5Var.b(m39Var10.N().getLinkDataList(), this.l.N().getGoodsDataList(), list), this.l.m(), this.b, rx5Var.c());
                pbFirstFloorViewHolder.u.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.u.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.u.setVisibility(8);
            }
            m39 m39Var11 = this.l;
            if (m39Var11 != null && m39Var11.N() != null && this.l.N().getTaskInfoData() != null && this.l.N().getTaskInfoData().f() != null && this.l.N().getTaskInfoData().j() == 2) {
                pbFirstFloorViewHolder.E.setVisibility(0);
                pbFirstFloorViewHolder.E.a(this.l.N());
            } else {
                pbFirstFloorViewHolder.E.setVisibility(8);
            }
            F(pbFirstFloorViewHolder);
        }
    }

    public final void J(PbFirstFloorViewHolder pbFirstFloorViewHolder, b35 b35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbFirstFloorViewHolder, b35Var) == null) && b35Var != null && !ui.isEmpty(b35Var.e()) && b35Var.c() == b35.g) {
            if (!b35Var.f()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().n(vi.g(this.x, R.dimen.obfuscated_res_0x7f0703df));
            }
            pbFirstFloorViewHolder.v.c(b35Var);
        }
    }

    public final void K(PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var) {
        View a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbFirstFloorViewHolder, jy9Var) == null) && pbFirstFloorViewHolder != null && jy9Var != null) {
            pbFirstFloorViewHolder.w.setVisibility(0);
            if (pbFirstFloorViewHolder.x == null) {
                pbFirstFloorViewHolder.x = P(jy9Var);
            }
            if (pbFirstFloorViewHolder.w.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.x.a()) != null) {
                pbFirstFloorViewHolder.w.addView(a2);
            }
            pbFirstFloorViewHolder.x.e(this.E);
            pbFirstFloorViewHolder.x.d(this.F);
            pbFirstFloorViewHolder.x.c(jy9Var.Y());
            pbFirstFloorViewHolder.x.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void N(PbFirstFloorViewHolder pbFirstFloorViewHolder, m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbFirstFloorViewHolder, m39Var) == null) && m39Var != null && m39Var.t() != null && this.x != null) {
            pbFirstFloorViewHolder.L.setVisibility(0);
            this.B = vi.e(this.x, m39Var.t().background_color);
            o75 d2 = o75.d(pbFirstFloorViewHolder.L);
            d2.o(R.string.J_X05);
            d2.f(this.B);
            pbFirstFloorViewHolder.H.setText(m39Var.t().title_text);
            this.A = vi.e(this.x, m39Var.t().title_color);
            o75 d3 = o75.d(pbFirstFloorViewHolder.H);
            d3.w(this.A);
            d3.B(R.dimen.T_X07);
            d3.C(R.string.F_X02);
            pbFirstFloorViewHolder.G.N(m39Var.t().title_icon, 10, false);
            pbFirstFloorViewHolder.I.setText(m39Var.t().link_text);
            this.z = vi.e(this.x, m39Var.t().link_color);
            o75 d4 = o75.d(pbFirstFloorViewHolder.I);
            d4.w(this.z);
            d4.B(R.dimen.T_X09);
            d4.C(R.string.F_X01);
            pbFirstFloorViewHolder.J.N(m39Var.t().link_icon, 10, false);
            pbFirstFloorViewHolder.K.N(m39Var.t().link_url, 10, false);
            pbFirstFloorViewHolder.L.setOnClickListener(new d(this, m39Var));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e99 P(jy9 jy9Var) {
        InterceptResult invokeL;
        e99 e99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jy9Var)) == null) {
            if (jy9Var != null && jy9Var.Y() != null && jy9Var.Y().k()) {
                BaijiahaoData baijiahaoData = jy9Var.Y().p;
                Item item = jy9Var.Y().C;
                if (!jy9Var.Y().m && !jy9Var.n1()) {
                    if (item != null && item.item_id.longValue() != 0) {
                        if (jy9Var.Y().a != 0 && jy9Var.Y().a != 1) {
                            if (jy9Var.Y().a == 3) {
                                e99Var = new k99(this.b.getPageContext());
                            } else {
                                e99Var = new i99(this.b.getPageContext());
                            }
                        } else {
                            e99Var = new j99(this.b.getPageContext());
                        }
                    } else if (baijiahaoData != null && jy9Var.Y().l()) {
                        int i2 = baijiahaoData.oriUgcType;
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        e99Var = new g99(this.b.getPageContext(), this.C);
                                    } else {
                                        e99Var = new m99(this.b.getPageContext(), this.C);
                                    }
                                } else {
                                    e99Var = new l99(this.b.getPageContext(), this.C);
                                }
                            } else {
                                e99Var = new m99(this.b.getPageContext(), this.C);
                            }
                        } else {
                            e99Var = new f99(this.b.getPageContext(), this.C);
                        }
                    } else if (jy9Var.Y().a != 0 && jy9Var.Y().a != 1) {
                        if (jy9Var.Y().a == 3) {
                            e99Var = new m99(this.b.getPageContext(), this.C);
                        }
                    } else {
                        e99Var = new l99(this.b.getPageContext(), this.C);
                    }
                } else {
                    e99Var = new h99(this.b.getPageContext(), this.C);
                }
                if (e99Var != null) {
                    return new g99(this.b.getPageContext(), this.C);
                }
                return e99Var;
            }
            e99Var = null;
            if (e99Var != null) {
            }
        } else {
            return (e99) invokeL.objValue;
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
    @Override // com.baidu.tieba.in
    /* renamed from: T */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d06d4, viewGroup, false), this.h, this.g);
            h0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.v.f(this.C);
            pbFirstFloorViewHolder.F.setOnStatListener(this.G);
            pbFirstFloorViewHolder.E.setOnStatListener(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public void i0(@NonNull m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, m39Var) == null) && m39Var.N() != null && Q() != null && Q().b() != null) {
            ThreadData N = m39Var.N();
            ImageView b2 = Q().b();
            if ((!N.isShowTitle() || u79.x(m39Var)) && !N.isVideoThreadType()) {
                u79.b(b2, N.isHeadLinePost, N.isGoodThread(), N.isTopThread());
            }
        }
    }

    public View U(int i2, View view2, ViewGroup viewGroup, jy9 jy9Var, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jy9Var, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) jy9Var, (jy9) pbFirstFloorViewHolder);
            h0(pbFirstFloorViewHolder);
            b0(pbFirstFloorViewHolder);
            jy9 jy9Var2 = (jy9) getItem(i2);
            if (jy9Var2 != null) {
                jy9Var2.r1();
                jy9Var2.d0 = i2 + 1;
                bb9.d(this.b.getUniqueId(), this.l, jy9Var2, jy9Var2.d0, 1);
                I(pbFirstFloorViewHolder, jy9Var2, view2, i2);
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

    public final void a0(PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var, View view2, int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048598, this, new Object[]{pbFirstFloorViewHolder, jy9Var, view2, Integer.valueOf(i2), sparseArray}) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int s = s(R.dimen.obfuscated_res_0x7f07020f);
        Z(pbFirstFloorViewHolder, s, s(R.dimen.obfuscated_res_0x7f0701be), s, s);
        if (pbFirstFloorViewHolder.h != null) {
            if (!TextUtils.isEmpty(jy9Var.x())) {
                pbFirstFloorViewHolder.h.setTag(sparseArray);
                pbFirstFloorViewHolder.h.setVisibility(0);
                pbFirstFloorViewHolder.h.k(lw4.a(jy9Var.x()));
                e59.a(pbFirstFloorViewHolder.h, view2);
            } else {
                pbFirstFloorViewHolder.h.setVisibility(8);
            }
        }
        this.w = true;
        H(pbFirstFloorViewHolder, jy9Var, view2, i2);
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

    public final void c0(PbFirstFloorViewHolder pbFirstFloorViewHolder, jy9 jy9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048601, this, pbFirstFloorViewHolder, jy9Var, view2, i2) != null) || pbFirstFloorViewHolder == null) {
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
        H(pbFirstFloorViewHolder, jy9Var, view2, i2);
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
