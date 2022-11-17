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
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.ry7;
import com.baidu.tieba.tbadkCore.data.PostData;
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
/* loaded from: classes4.dex */
public class k08 extends g08<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public ry7 D;
    public m46<tr4> E;
    public ax.a F;
    public az G;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public px7 l;
    public z38 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.y p;
    public ry7 q;
    public View.OnLongClickListener r;
    public TbRichTextView.s s;
    public View.OnClickListener t;
    public boolean u;
    public final boolean v;
    public boolean w;
    public Context x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ k08 b;

        /* loaded from: classes4.dex */
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
                    fVar.a.G.k(fVar.b.l.Q());
                    this.a.a.G.h();
                }
            }
        }

        public f(k08 k08Var, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var, pbFirstFloorViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k08Var;
            this.a = pbFirstFloorViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.G != null) {
                    this.b.G.b();
                }
                if (this.b.l.Q().getHasAgree() == 1) {
                    this.a.G.h();
                    return;
                }
                PbFragment pbFragment = this.b.b;
                if (pbFragment != null) {
                    pbFragment.l6(new a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ry7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 a;

        @Override // com.baidu.tieba.ry7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k08Var;
        }

        @Override // com.baidu.tieba.ry7.a
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

        @Override // com.baidu.tieba.ry7.a
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

    /* loaded from: classes4.dex */
    public class b extends m46<tr4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 b;

        public b(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m46
        /* renamed from: d */
        public void a(View view2, tr4 tr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tr4Var) == null) {
                super.a(view2, tr4Var);
                if (tr4Var != null && tr4Var.getThreadData() != null && tr4Var.getThreadData().originalThreadData != null && this.b.l != null) {
                    OriginalThreadInfo originalThreadInfo = tr4Var.getThreadData().originalThreadData;
                    String S = this.b.l.S();
                    String str = originalThreadInfo.f;
                    int i = 1;
                    int i2 = originalThreadInfo.a;
                    if (i2 == 3) {
                        i = 2;
                    } else if (i2 == 4) {
                        i = 3;
                    }
                    if (!StringUtils.isNull(S) && !StringUtils.isNull(str)) {
                        q48.o("c12602", S, str, i);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 a;

        public c(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k08Var;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(tr4 tr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, tr4Var) == null) && tr4Var != null && tr4Var.getThreadData() != null && tr4Var.getThreadData().originalThreadData != null) {
                OriginalThreadInfo originalThreadInfo = tr4Var.getThreadData().originalThreadData;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.x);
                pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
                pbActivityConfig.setStartFrom(this.a.C);
                pbActivityConfig.setBjhData(originalThreadInfo.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px7 a;
        public final /* synthetic */ k08 b;

        public d(k08 k08Var, px7 px7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var, px7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k08Var;
            this.a = px7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.c0();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.x, null, this.a.u().link_url, true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ SparseArray c;
        public final /* synthetic */ View d;
        public final /* synthetic */ int e;
        public final /* synthetic */ k08 f;

        public e(k08 k08Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, SparseArray sparseArray, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var, pbFirstFloorViewHolder, postData, sparseArray, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = k08Var;
            this.a = pbFirstFloorViewHolder;
            this.b = postData;
            this.c = sparseArray;
            this.d = view2;
            this.e = i;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.g.getLayoutParams();
                layoutParams.topMargin = this.f.s(R.dimen.obfuscated_res_0x7f0701be);
                int s = this.f.s(R.dimen.obfuscated_res_0x7f07020f);
                layoutParams.bottomMargin = s;
                layoutParams.leftMargin = s;
                layoutParams.rightMargin = s;
                this.a.g.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(this.b.z())) {
                    this.a.h.setTag(this.c);
                    this.a.h.setVisibility(0);
                    this.a.h.k(so4.a(this.b.z()));
                    dz7.a(this.a.h, this.d);
                } else {
                    this.a.h.setVisibility(8);
                }
                this.f.E(this.a, this.b, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 a;

        public g(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k08Var;
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

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public h(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
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

    /* loaded from: classes4.dex */
    public class i implements az {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 a;

        public i(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k08Var;
        }

        @Override // com.baidu.tieba.az
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.S()).param("fid", this.a.l.m()).param("obj_locate", 2).param("obj_param1", 2));
            }
        }

        @Override // com.baidu.tieba.az
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.S()).param("fid", this.a.l.m()).param("obj_locate", 2).param("obj_param1", 1));
            }
        }

        @Override // com.baidu.tieba.az
        public void onShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c15022").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.l.S()).param("fid", this.a.l.m()).param("obj_locate", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k08(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((a58) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.D = new ry7(new a(this));
        this.E = new b(this);
        this.F = new c(this);
        this.G = new i(this);
        if (pbFragment != null && pbFragment.K() != null) {
            this.C = pbFragment.K().R1();
            this.j = pbFragment.K();
        }
        this.x = pbFragment.getContext();
    }

    public final void A(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f.setTextViewOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setTextViewCheckSelection(false);
            pbFirstFloorViewHolder.h.setOnTouchListener(new g(this));
        }
    }

    public final int L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            return yi.g(TbadkCoreApplication.getInst().getContext(), i2);
        }
        return invokeI.intValue;
    }

    public void S(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (pbModel = this.j) != null && z && this.k) {
            pbModel.o3(3);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.i = z;
        }
    }

    public void Z(ry7 ry7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ry7Var) == null) {
            this.q = ry7Var;
        }
    }

    public void a0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, sVar) == null) {
            this.s = sVar;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.g = i2;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, yVar) == null) {
            this.p = yVar;
        }
    }

    public void r(px7 px7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, px7Var) == null) {
            this.l = px7Var;
        }
    }

    @Override // com.baidu.tieba.kn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.y = z;
        }
    }

    @Override // com.baidu.tieba.g08, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        R(i2, view2, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public final void B(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichTextView, view2, z) != null) || tbRichTextView == null) {
            return;
        }
        int m = (((yi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i2 = 0;
        if (z) {
            i2 = s(R.dimen.obfuscated_res_0x7f070275);
        }
        if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
            m /= 2;
        }
        int min = Math.min(m - i2, this.g);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    public final void I(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.s() != null && postData.e0() != null) {
                if (tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (postData.s().getSmallTailThemeData() != null) {
                    str = postData.s().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbFirstFloorViewHolder.m.setTag(R.id.obfuscated_res_0x7f0920c4, str);
                pbFirstFloorViewHolder.n.setTag(R.id.obfuscated_res_0x7f0920c4, str);
                x58.c(postData.e0(), pbFirstFloorViewHolder.m, pbFirstFloorViewHolder.n, pbFirstFloorViewHolder.o, false, true, z, postData.s().getSmallTailThemeData());
                return;
            }
            pbFirstFloorViewHolder.m.setVisibility(8);
            pbFirstFloorViewHolder.n.setVisibility(8);
        }
    }

    public final void C(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder) != null) || pbFirstFloorViewHolder.G == null) {
            return;
        }
        px7 px7Var = this.l;
        if (px7Var != null && px7Var.Q() != null && this.l.Q().getTaskInfoData() != null && this.l.Q().getTaskInfoData().e() != null && this.l.Q().getTaskInfoData().h() == 3) {
            pbFirstFloorViewHolder.G.setVisibility(0);
            pbFirstFloorViewHolder.G.a(this.l.Q());
            pbFirstFloorViewHolder.G.setItemBtnClickListener(new f(this, pbFirstFloorViewHolder));
            return;
        }
        pbFirstFloorViewHolder.G.setVisibility(8);
    }

    public final void W(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.c.setOnTouchListener(this.q);
            pbFirstFloorViewHolder.c.setOnLongClickListener(this.r);
            x28 x28Var = this.a.P().d;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.D);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.D);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new h(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(x28Var.f);
            pbFirstFloorViewHolder.m.setOnClickListener(this.o);
            pbFirstFloorViewHolder.n.setOnClickListener(this.o);
            pbFirstFloorViewHolder.z.setAfterItemClickListener(this.o);
            pbFirstFloorViewHolder.A.setAfterItemClickListener(this.o);
        }
    }

    public final String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return "default";
                }
                return "dark";
            }
            return "night";
        }
        return (String) invokeV.objValue;
    }

    public PbFirstFloorViewHolder N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (PbFirstFloorViewHolder) this.viewholder;
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            px7 px7Var = this.l;
            if (px7Var != null && px7Var.Q() != null) {
                return this.l.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).w.d();
        }
    }

    public void V() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).w.e();
            ((PbFirstFloorViewHolder) this.viewholder).t.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0528  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048580, this, pbFirstFloorViewHolder, postData, view2, i2) != null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        int i3 = 1;
        if (postData.D() != 1) {
            if (TextUtils.isEmpty(postData.v())) {
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
        if (postData.D() == 1) {
            pbFirstFloorViewHolder.c(this.l, this.b.t0(), postData.Q);
            B(pbFirstFloorViewHolder.f, view2, this.w);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                str = postData.s().getUserName();
                j = userIdLong;
                str2 = postData.s().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            px7 px7Var = this.l;
            if (px7Var != null && px7Var.Q() != null) {
                pbFirstFloorViewHolder.w.b(postData.K(), str, str2, j, xg.g(this.l.Q().getId(), 0L), xg.g(postData.M(), 0L));
            }
            if (this.b.y5().S1()) {
                pbFirstFloorViewHolder.f.setVisibility(8);
            }
            px7 px7Var2 = this.l;
            if (px7Var2 != null && px7Var2.Q() != null && this.l.Q().getYulePostActivityData() != null) {
                iv4 yulePostActivityData = this.l.Q().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.k.setVisibility(0);
                    pbFirstFloorViewHolder.k.K(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.k.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.l;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            px7 px7Var3 = this.l;
            if (px7Var3 != null && px7Var3.Q() != null && this.l.Q().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.z) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.z.getPaddingRight(), pbFirstFloorViewHolder.z.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f0920b1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f0920b3, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f0920c2, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f0920c1, Integer.valueOf(postData.D()));
        if (!postData.r0() && !postData.q0(false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.m == null) {
                z38 z38Var = new z38(this.x);
                this.m = z38Var;
                z38Var.f(this.e);
                this.m.h(this.n);
                px7 px7Var4 = this.l;
                if (px7Var4 != null) {
                    this.m.j(this.l.Y(), TextUtils.equals(px7Var4.Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.Q());
                }
            }
            this.m.g(postData.M());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08127e);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        px7 px7Var5 = this.l;
        if (px7Var5 != null && px7Var5.Q() != null && this.l.Q().isLinkThread()) {
            G(pbFirstFloorViewHolder, this.l.Q().getLinkThreadData());
        }
        px7 px7Var6 = this.l;
        if (px7Var6 != null && px7Var6.Q() != null && this.l.Q().isShareThread && postData.V() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (postData.V().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(L(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(L(R.dimen.tbds14));
            }
            H(pbFirstFloorViewHolder, postData);
        } else {
            px7 px7Var7 = this.l;
            if (px7Var7 != null && px7Var7.Q() != null && this.l.Q().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(L(R.dimen.M_H_X007));
                pbFirstFloorViewHolder.f.getLayoutStrategy().l(L(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(L(R.dimen.tbds24));
            }
        }
        K(pbFirstFloorViewHolder, this.l);
        TbRichText X = postData.X();
        px7 px7Var8 = this.l;
        if (px7Var8 == null || !px7Var8.y0()) {
            tbRichText = X;
        }
        if (this.l.Q() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.S());
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.Q().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        px7 px7Var9 = this.l;
        if (px7Var9 != null && 3 == px7Var9.g()) {
            if (!this.u && this.v) {
                pbFirstFloorViewHolder.f.setText(tbRichText, true, this.s, true, false);
            } else {
                pbFirstFloorViewHolder.f.setText(tbRichText, false, this.s, true, false);
            }
        } else if (!this.u && this.v) {
            pbFirstFloorViewHolder.f.setText(tbRichText, true, this.s, false, true);
        } else {
            pbFirstFloorViewHolder.f.setText(tbRichText, false, this.s, false, true);
        }
        I(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z8 = !StringUtils.isNull(postData.s().getVirtualUserUrl());
        px7 px7Var10 = this.l;
        if (px7Var10 != null && px7Var10.Y() != 0 && !O()) {
            if (this.l.Y() != 3) {
                z3 = true;
                z4 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z3 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z3 = false;
                }
            }
        } else {
            z3 = false;
            z4 = false;
        }
        px7 px7Var11 = this.l;
        if (px7Var11 != null && px7Var11.Q() != null && this.l.Q().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.Q().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = true;
                    z5 = false;
                    z6 = true;
                } else {
                    z4 = true;
                    z5 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z3 = false;
                    z4 = false;
                    z5 = false;
                }
                if (postData.D() == 1) {
                    i3 = 0;
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData.M());
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a1, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a2, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a3, postData.s().getPortrait());
                    }
                    px7 px7Var12 = this.l;
                    if (px7Var12 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(px7Var12.Y()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f0920ab, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ed, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ee, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ec, postData.s().getName_show());
                    }
                    px7 px7Var13 = this.l;
                    if (px7Var13 != null && px7Var13.Q() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920f0, this.l.Q().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920ef, postData.M());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(z));
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i3));
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.M());
                    px7 px7Var14 = this.l;
                    if (px7Var14 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(px7Var14.Y()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z7));
                A(pbFirstFloorViewHolder);
            }
        }
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData.s() != null) {
            z4 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.D() == 1) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData.M());
        if (!z3) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z7));
        A(pbFirstFloorViewHolder);
    }

    public final void F(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i2) {
        PostData postData2;
        yx7 yx7Var;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048581, this, pbFirstFloorViewHolder, postData, view2, i2) == null) && pbFirstFloorViewHolder != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.f.setTag(sparseArray);
            pbFirstFloorViewHolder.c.setTag(R.id.obfuscated_res_0x7f0920a7, sparseArray);
            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
            pbFirstFloorViewHolder.f.setIsHost(true);
            if (this.i) {
                pbFirstFloorViewHolder.i.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            List<CardLinkInfoData> list = null;
            if (!TextUtils.isEmpty(postData.v()) && this.h) {
                this.w = true;
                pbFirstFloorViewHolder.f.l0(postData.v(), new e(this, pbFirstFloorViewHolder, postData, sparseArray, view2, i2));
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.g.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.g.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.f.k0(null);
                pbFirstFloorViewHolder.h.setVisibility(8);
                this.w = false;
                E(pbFirstFloorViewHolder, postData, view2, i2);
            }
            px7 px7Var = this.l;
            if (px7Var != null && px7Var.Q() != null && this.l.Q().isVideoThreadType() && this.l.Q().getThreadVideoInfo() != null && xi.isEmpty(this.l.l().getName())) {
                pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.X() != null && !ListUtils.isEmpty(postData.X().B())) {
                pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            } else {
                pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            }
            if (postData.X() != null) {
                if (postData.X().C() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.r.getLayoutParams();
                    layoutParams2.topMargin = s(R.dimen.tbds26);
                    pbFirstFloorViewHolder.r.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.r.getLayoutParams();
                    layoutParams3.topMargin = s(R.dimen.tbds16);
                    pbFirstFloorViewHolder.r.setLayoutParams(layoutParams3);
                }
            }
            px7 px7Var2 = this.l;
            if (px7Var2 != null && P(px7Var2.Q())) {
                pbFirstFloorViewHolder.C.setDataForPb(this.l.Q().getPollData(), this.l.Q().getTid(), this.l.m());
                pbFirstFloorViewHolder.C.setupLiveThreadVoteInfo(this.l.Q());
                if (postData.X() != null && !ListUtils.isEmpty(postData.X().B())) {
                    pbFirstFloorViewHolder.C.setMarginTop(yi.g(this.x, R.dimen.tbds26));
                } else {
                    pbFirstFloorViewHolder.C.setMarginTop(yi.g(this.x, R.dimen.tbds0));
                }
                pbFirstFloorViewHolder.C.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.C.setVisibility(8);
            }
            px7 px7Var3 = this.l;
            if (px7Var3 != null && px7Var3.Q() != null && this.l.Q().getSmartApp() != null && this.l.Q().getThreadVideoInfo() == null) {
                pbFirstFloorViewHolder.r.setData(this.l.Q().getSmartApp());
                pbFirstFloorViewHolder.r.setVisibility(0);
                px7 px7Var4 = this.l;
                if (px7Var4 != null && px7Var4.l() != null) {
                    pbFirstFloorViewHolder.r.setForumId(String.valueOf(this.l.l().getId()));
                }
                px7 px7Var5 = this.l;
                if (px7Var5 != null && px7Var5.S() != null) {
                    pbFirstFloorViewHolder.r.setThreadId(this.l.S());
                }
                pbFirstFloorViewHolder.r.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.r.setVisibility(8);
            }
            px7 px7Var6 = this.l;
            if (px7Var6 != null) {
                pbFirstFloorViewHolder.E.setData(px7Var6.Q(), this.l.R(), this.y);
            }
            if (NovelPaySwitch.isOn() && postData.U() != null && !postData.U().i() && this.l.q0()) {
                this.k = true;
                pbFirstFloorViewHolder.s.setVisibility(0);
                pbFirstFloorViewHolder.t.setVisibility(0);
                pbFirstFloorViewHolder.t.setData(postData.U());
                NovelMemberCardView novelMemberCardView = pbFirstFloorViewHolder.t;
                String S = this.l.S();
                String m = this.l.m();
                if (this.l.Q() != null) {
                    i3 = this.l.Q().getThreadType();
                } else {
                    i3 = 0;
                }
                novelMemberCardView.setStatisticData(S, m, i3);
            } else {
                pbFirstFloorViewHolder.s.setVisibility(8);
                pbFirstFloorViewHolder.t.setVisibility(8);
            }
            FullLengthNovel fullLengthNovel = postData.H0;
            if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
                pbFirstFloorViewHolder.u.setVisibility(0);
                if (pbFirstFloorViewHolder.u.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.u.getLayoutParams();
                    layoutParams4.height = (yi.l(this.x) * postData.H0.button_heigh.intValue()) / 1080;
                    pbFirstFloorViewHolder.u.setLayoutParams(layoutParams4);
                }
                pbFirstFloorViewHolder.u.loadUrl(postData.H0.schema + "&curskintype=" + D());
            } else {
                pbFirstFloorViewHolder.u.setVisibility(8);
            }
            px7 px7Var7 = this.l;
            if (px7Var7 != null && (yx7Var = px7Var7.h) != null) {
                if (pbFirstFloorViewHolder.q != null) {
                    if (TextUtils.isEmpty(yx7Var.e())) {
                        pbFirstFloorViewHolder.q.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.q.setVisibility(0);
                        pbFirstFloorViewHolder.q.setText(this.l.h.e());
                    }
                }
                if (pbFirstFloorViewHolder.p != null && pbFirstFloorViewHolder.B.h() == null) {
                    pbFirstFloorViewHolder.p.addView(pbFirstFloorViewHolder.B.a(this.l));
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
            LinearLayout linearLayout = pbFirstFloorViewHolder.v;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            px7 px7Var8 = this.l;
            if (px7Var8 != null && px7Var8.H() != null && this.l.H().size() > 0 && (postData2 = this.l.H().get(0)) != null) {
                list = postData2.w();
            }
            px7 px7Var9 = this.l;
            if (px7Var9 != null && px7Var9.Q() != null && !P(this.l.Q()) && (!ListUtils.isEmpty(this.l.Q().getLinkDataList()) || !ListUtils.isEmpty(this.l.Q().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
                xj5 xj5Var = new xj5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
                px7 px7Var10 = this.l;
                pbLinkGoodsRootView.i(px7Var10, xj5Var.b(px7Var10.Q().getLinkDataList(), this.l.Q().getGoodsDataList(), list), this.l.n(), this.b, xj5Var.c());
                pbFirstFloorViewHolder.v.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.v.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.v.setVisibility(8);
            }
            px7 px7Var11 = this.l;
            if (px7Var11 != null && px7Var11.Q() != null && this.l.Q().getTaskInfoData() != null && this.l.Q().getTaskInfoData().e() != null && this.l.Q().getTaskInfoData().h() == 2) {
                pbFirstFloorViewHolder.F.setVisibility(0);
                pbFirstFloorViewHolder.F.a(this.l.Q());
            } else {
                pbFirstFloorViewHolder.F.setVisibility(8);
            }
            C(pbFirstFloorViewHolder);
        }
    }

    public final void G(PbFirstFloorViewHolder pbFirstFloorViewHolder, lt4 lt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbFirstFloorViewHolder, lt4Var) == null) && lt4Var != null && !xi.isEmpty(lt4Var.e()) && lt4Var.c() == lt4.g) {
            if (!lt4Var.f()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(yi.g(this.x, R.dimen.obfuscated_res_0x7f0702cb));
            }
            pbFirstFloorViewHolder.w.c(lt4Var);
        }
    }

    public final void H(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbFirstFloorViewHolder, postData) == null) && pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.x.setVisibility(0);
            if (pbFirstFloorViewHolder.y == null) {
                pbFirstFloorViewHolder.y = M(postData);
            }
            if (pbFirstFloorViewHolder.x.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.y.a()) != null) {
                pbFirstFloorViewHolder.x.addView(a2);
            }
            pbFirstFloorViewHolder.y.e(this.E);
            pbFirstFloorViewHolder.y.d(this.F);
            pbFirstFloorViewHolder.y.c(postData.V());
            pbFirstFloorViewHolder.y.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void K(PbFirstFloorViewHolder pbFirstFloorViewHolder, px7 px7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbFirstFloorViewHolder, px7Var) == null) && px7Var != null && px7Var.u() != null && this.x != null) {
            pbFirstFloorViewHolder.M.setVisibility(0);
            this.B = yi.e(this.x, px7Var.u().background_color);
            qw4 d2 = qw4.d(pbFirstFloorViewHolder.M);
            d2.n(R.string.J_X05);
            d2.f(this.B);
            pbFirstFloorViewHolder.I.setText(px7Var.u().title_text);
            this.A = yi.e(this.x, px7Var.u().title_color);
            qw4 d3 = qw4.d(pbFirstFloorViewHolder.I);
            d3.v(this.A);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X02);
            pbFirstFloorViewHolder.H.K(px7Var.u().title_icon, 10, false);
            pbFirstFloorViewHolder.J.setText(px7Var.u().link_text);
            this.z = yi.e(this.x, px7Var.u().link_color);
            qw4 d4 = qw4.d(pbFirstFloorViewHolder.J);
            d4.v(this.z);
            d4.z(R.dimen.T_X09);
            d4.A(R.string.F_X01);
            pbFirstFloorViewHolder.K.K(px7Var.u().link_icon, 10, false);
            pbFirstFloorViewHolder.L.K(px7Var.u().link_url, 10, false);
            pbFirstFloorViewHolder.M.setOnClickListener(new d(this, px7Var));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a38 M(PostData postData) {
        InterceptResult invokeL;
        a38 a38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, postData)) == null) {
            if (postData != null && postData.V() != null && postData.V().k()) {
                BaijiahaoData baijiahaoData = postData.V().p;
                Item item = postData.V().C;
                if (!postData.V().m && !postData.i1()) {
                    if (item != null && item.item_id.longValue() != 0) {
                        if (postData.V().a != 0 && postData.V().a != 1) {
                            if (postData.V().a == 3) {
                                a38Var = new g38(this.b.getPageContext());
                            } else {
                                a38Var = new e38(this.b.getPageContext());
                            }
                        } else {
                            a38Var = new f38(this.b.getPageContext());
                        }
                    } else if (baijiahaoData != null && postData.V().l()) {
                        int i2 = baijiahaoData.oriUgcType;
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        a38Var = new c38(this.b.getPageContext(), this.C);
                                    } else {
                                        a38Var = new i38(this.b.getPageContext(), this.C);
                                    }
                                } else {
                                    a38Var = new h38(this.b.getPageContext(), this.C);
                                }
                            } else {
                                a38Var = new i38(this.b.getPageContext(), this.C);
                            }
                        } else {
                            a38Var = new b38(this.b.getPageContext(), this.C);
                        }
                    } else if (postData.V().a != 0 && postData.V().a != 1) {
                        if (postData.V().a == 3) {
                            a38Var = new i38(this.b.getPageContext(), this.C);
                        }
                    } else {
                        a38Var = new h38(this.b.getPageContext(), this.C);
                    }
                } else {
                    a38Var = new d38(this.b.getPageContext(), this.C);
                }
                if (a38Var != null) {
                    return new c38(this.b.getPageContext(), this.C);
                }
                return a38Var;
            }
            a38Var = null;
            if (a38Var != null) {
            }
        } else {
            return (a38) invokeL.objValue;
        }
    }

    public final boolean P(ThreadData threadData) {
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
    /* renamed from: Q */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d065a, viewGroup, false), this.h, this.g);
            b0(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.w.f(this.C);
            pbFirstFloorViewHolder.G.setOnStatListener(this.G);
            pbFirstFloorViewHolder.F.setOnStatListener(this.G);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View R(int i2, View view2, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbFirstFloorViewHolder);
            b0(pbFirstFloorViewHolder);
            W(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.l1();
                postData2.d0 = i2 + 1;
                q48.d(this.b.getUniqueId(), this.l, postData2, postData2.d0, 1);
                F(pbFirstFloorViewHolder, postData2, view2, i2);
            }
            if (!this.u && this.v && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f.G() && (listView = this.b.getListView()) != null) {
                this.u = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.D.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void U() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (v = this.viewholder) == 0) {
            return;
        }
        if (((PbFirstFloorViewHolder) v).w != null) {
            ((PbFirstFloorViewHolder) v).w.a();
        }
        V v2 = this.viewholder;
        if (((PbFirstFloorViewHolder) v2).A != null) {
            ((PbFirstFloorViewHolder) v2).A.g();
        }
        V v3 = this.viewholder;
        if (((PbFirstFloorViewHolder) v3).t != null) {
            ((PbFirstFloorViewHolder) v3).t.i();
        }
        V v4 = this.viewholder;
        if (((PbFirstFloorViewHolder) v4).u != null) {
            ((PbFirstFloorViewHolder) v4).u.destroy();
        }
    }

    public final void b0(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, pbFirstFloorViewHolder) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.b != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.D, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.c, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.i, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.M, this.B);
            pbFirstFloorViewHolder.I.setTextColor(SkinManager.getColor(this.A));
            pbFirstFloorViewHolder.J.setTextColor(SkinManager.getColor(this.z));
            pbFirstFloorViewHolder.f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.r.c();
            pbFirstFloorViewHolder.t.g();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.z;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.A;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.q, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.B.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.C;
            if (voteView != null) {
                voteView.D(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.s, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            pbFirstFloorViewHolder.E.h();
            if (pbFirstFloorViewHolder.h.getVisibility() == 0) {
                pbFirstFloorViewHolder.h.g(skinType);
            }
        }
        pbFirstFloorViewHolder.b = TbadkCoreApplication.getInst().getSkinType();
    }

    public final void c0() {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || this.l == null) {
            return;
        }
        int i3 = 0;
        if (this.b.K().x1()) {
            i2 = 1;
        } else if (this.b.K().A1()) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(this.l.n());
        if (itemInfo != null) {
            i3 = itemInfo.id.intValue();
            str = itemInfo.name;
        } else {
            str = "";
        }
        new StatisticItem("c15063").addParam("obj_locate", i2).addParam("fid", this.l.m()).addParam("fname", this.l.n()).addParam("post_id", this.l.S()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
    }
}
