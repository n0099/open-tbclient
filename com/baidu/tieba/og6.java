package com.baidu.tieba;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.ng6;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class og6 extends yf6<CardPersonDynamicThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TbImageView B;
    public ImageView C;
    public LinearLayout D;
    public TextView E;
    public LinearLayout F;
    public LinearLayout G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TBLottieAnimationView K;
    public TextView L;
    public TextView M;
    public OriginalThreadCardView N;
    public View O;
    public View P;
    public ThreadCardBottomOpSegmentLayout Q;
    public boolean R;
    public boolean S;
    public EMTextView T;
    public View.OnClickListener U;
    public ng6.j V;
    public final View.OnClickListener W;
    public final View.OnClickListener X;
    public TbImageView.f Y;
    public PlayVoiceBntNew i;
    public ThreadViewAndCommentInfoLayout j;
    public View k;
    public int l;
    public CardPersonDynamicThreadData m;
    public TbPageContext<?> n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public ng6 v;
    public TextView w;
    public TextView x;
    public ConstrainImageGroup y;
    public boolean z;

    @Override // com.baidu.tieba.yf6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.card_person_dynamic_thread : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og6Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.B != null) {
                this.a.B.setDefaultBgResource(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        public b(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e() != null) {
                this.a.e().a(view2, this.a.m);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardPersonDynamicThreadData a;
        public final /* synthetic */ og6 b;

        public c(og6 og6Var, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var, cardPersonDynamicThreadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og6Var;
            this.a = cardPersonDynamicThreadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.n != null) {
                if (this.b.v == null) {
                    og6 og6Var = this.b;
                    og6Var.v = new ng6(og6Var.n);
                    this.b.v.o();
                    this.b.v.s(this.b.V);
                }
                ng6 ng6Var = this.b.v;
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.b.m;
                boolean z = true;
                if (this.a.H != 1) {
                    z = false;
                }
                ng6Var.n(cardPersonDynamicThreadData, z);
                this.b.v.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements wt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ og6 c;

        public d(og6 og6Var, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = og6Var;
            this.a = linkedList;
            this.b = threadData;
        }

        @Override // com.baidu.tieba.wt5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.c.N();
                } else {
                    this.c.W(view2, this.a, i, this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends iy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 b;

        public e(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og6Var;
        }

        @Override // com.baidu.tieba.iy9
        public void a(TextPaint textPaint, boolean z) {
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, textPaint, z) == null) {
                if (z) {
                    color = this.b.c.getResources().getColor(R.color.CAM_X0304);
                } else {
                    color = this.b.c.getResources().getColor(R.color.CAM_X0302);
                }
                textPaint.setColor(color);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && this.b.m != null && !StringUtils.isNull(this.b.m.h)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.c).createNormalCfg(this.b.m.h, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        public f(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e() != null) {
                    this.a.e().a(view2, this.a.m);
                }
                if (this.a.m.k == 60) {
                    TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                    if (this.a.m.p.getThreadAlaInfo().live_status == 1) {
                        this.a.K();
                    } else {
                        this.a.P();
                    }
                } else if ((this.a.m.k == 40 && this.a.m.n == 2) || this.a.S) {
                    BdToast b = BdToast.b(this.a.getContext(), this.a.getContext().getString(R.string.video_check_click_msg));
                    b.g(BdToast.ToastIcon.FAILURE);
                    b.o();
                } else if (this.a.m.k == 40) {
                    og6 og6Var = this.a;
                    og6Var.O(og6Var.m.b);
                } else if (this.a.m.p.isShareThread && this.a.m.p.originalThreadData.k == 40) {
                    og6 og6Var2 = this.a;
                    og6Var2.O(og6Var2.m.p.originalThreadData.f);
                } else {
                    this.a.N();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(og6 og6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var, Integer.valueOf(i)};
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
            this.a = og6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.a.m != null && this.a.m.b != null && this.a.w != null && this.a.x != null && ((String) customResponsedMessage.getData()).equals(this.a.m.b) && !this.a.J()) {
                jg6.l(this.a.w, this.a.m.b, R.color.CAM_X0105, R.color.CAM_X0109);
                jg6.l(this.a.x, this.a.m.b, R.color.CAM_X0107, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ng6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        public h(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og6Var;
        }

        @Override // com.baidu.tieba.ng6.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.U(z);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        public i(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xg6<CardPersonDynamicThreadData> e = this.a.e();
                if (e != null) {
                    view2.setTag("1");
                    e.a(view2, this.a.m);
                }
                this.a.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        public j(og6 og6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            xg6<CardPersonDynamicThreadData> e;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (e = this.a.e()) != null) {
                view2.setTag("2");
                e.a(view2, this.a.m);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og6(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.z = true;
        new e(this);
        this.U = new f(this);
        new g(this, 2001390);
        this.V = new h(this);
        this.W = new i(this);
        this.X = new j(this);
        this.Y = new a(this);
        View h2 = h();
        this.k = h2;
        this.n = tbPageContext;
        this.o = (TextView) h2.findViewById(R.id.year_num);
        this.p = (LinearLayout) this.k.findViewById(R.id.left_time_view);
        this.q = (TextView) this.k.findViewById(R.id.month_num);
        this.r = (TextView) this.k.findViewById(R.id.day_num);
        this.s = (TextView) this.k.findViewById(R.id.source_bar);
        this.M = (TextView) this.k.findViewById(R.id.video_under_review);
        this.t = (TextView) this.k.findViewById(R.id.tv_privacy_status);
        this.u = (ImageView) this.k.findViewById(R.id.iv_more);
        this.w = (TextView) this.k.findViewById(R.id.thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.k.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.i = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.X);
        TextView textView = (TextView) this.k.findViewById(R.id.thread_content);
        this.x = textView;
        textView.setVisibility(8);
        this.y = (ConstrainImageGroup) this.k.findViewById(R.id.card_dynamic_thread_img_layout);
        this.y.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.y.setChildClickListener(this.W);
        tt5 tt5Var = new tt5(3);
        tt5Var.d(1.0d);
        this.y.setImageProcessor(tt5Var);
        this.A = this.k.findViewById(R.id.thread_view_img_container);
        this.B = (TbImageView) this.k.findViewById(R.id.thread_video_thumbnail);
        this.C = (ImageView) this.k.findViewById(R.id.thread_img_pause_play);
        this.j = (ThreadViewAndCommentInfoLayout) this.k.findViewById(R.id.card_dynamic_thread_info_layout);
        this.G = (LinearLayout) this.k.findViewById(R.id.duration_container);
        this.H = (TextView) this.k.findViewById(R.id.video_duration);
        this.I = (TextView) this.k.findViewById(R.id.video_play_count);
        this.J = (TextView) this.k.findViewById(R.id.audience_count);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.k.findViewById(R.id.obfuscated_res_0x7f090226);
        this.K = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.K, R.raw.obfuscated_res_0x7f110007);
        this.L = (TextView) this.k.findViewById(R.id.fake_video_state);
        this.D = (LinearLayout) this.k.findViewById(R.id.shared_ala_live_layout);
        this.E = (TextView) this.k.findViewById(R.id.shared_ala_live_room_title);
        LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.llAlaLivingLogLayout);
        this.F = linearLayout;
        linearLayout.setVisibility(8);
        this.N = (OriginalThreadCardView) this.k.findViewById(R.id.original_thread_info);
        this.O = this.k.findViewById(R.id.divider_line_thick);
        this.P = this.k.findViewById(R.id.divider_line_thin);
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = (ThreadCardBottomOpSegmentLayout) this.k.findViewById(R.id.card_thread_info_layout);
        this.Q = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.hideDisagree();
        if (this.Q.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Q.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.Q.setLayoutParams(layoutParams);
        }
        this.Q.setOnClickListener(this.U);
        this.Q.setReplyTimeVisible(false);
        this.Q.setShowPraiseNum(true);
        this.Q.setNeedAddPraiseIcon(true);
        this.Q.setNeedAddReplyIcon(true);
        this.Q.setShareVisible(true);
        this.Q.setIsBarViewVisible(false);
        this.Q.setFrom(13);
        pw4 pw4Var = new pw4();
        pw4Var.b = 8;
        pw4Var.h = 3;
        this.Q.setAgreeStatisticData(pw4Var);
        this.Q.setShareReportFrom(6);
        this.Q.setStType("person_page");
        this.Q.setForumAfterClickListener(new b(this));
        this.T = (EMTextView) this.k.findViewById(R.id.tv_ueg_view);
    }

    public void R(xf<TbImageView> xfVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xfVar) == null) && (constrainImageGroup = this.y) != null) {
            constrainImageGroup.setImageViewPool(xfVar);
        }
    }

    public void S(xf<ConstrainImageLayout> xfVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, xfVar) == null) && (constrainImageGroup = this.y) != null) {
            constrainImageGroup.setConstrainLayoutPool(xfVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && view2 == this.N) {
            M();
        }
    }

    public final void I(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, cardPersonDynamicThreadData) != null) || cardPersonDynamicThreadData == null) {
            return;
        }
        if (!this.R && !this.S) {
            this.Q.setCommentClickable(true);
            this.Q.setAgreeClickable(true);
            this.Q.setShareClickable(true);
            this.N.setClickable(true);
            this.u.setClickable(true);
        } else {
            this.Q.setCommentClickable(false);
            this.Q.setAgreeClickable(false);
            this.Q.setShareClickable(false);
            this.N.setClickable(false);
            this.u.setClickable(false);
        }
        this.Q.setCommentNumEnable(true);
        if (cardPersonDynamicThreadData.k == 60) {
            this.Q.setCommentNumEnable(false);
        }
        CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.B;
        if (multipleForumArr != null) {
            this.Q.setMultiForumCount(multipleForumArr.length);
        }
        ThreadData threadData = cardPersonDynamicThreadData.p;
        if (threadData != null) {
            this.Q.setForumId(String.valueOf(threadData.getFid()));
        }
        this.Q.setData(cardPersonDynamicThreadData.p);
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m.F;
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.i.setClickable(true);
            int childCount = this.y.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.y.getChildAt(i2);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void K() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cardPersonDynamicThreadData = this.m) != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.getThreadAlaInfo() != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ii.P(this.n.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!J()) {
                jg6.a(this.m.b);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.m.p.getThreadAlaInfo());
            if (this.m.p.getThreadAlaInfo().user_info != null) {
                alaLiveInfoCoreData.userName = this.m.p.getThreadAlaInfo().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.n.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    public final void M() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ThreadData threadData;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cardPersonDynamicThreadData = this.m) != null && (threadData = cardPersonDynamicThreadData.p) != null && (originalThreadInfo = threadData.originalThreadData) != null) {
            if (originalThreadInfo.k == 40) {
                O(originalThreadInfo.f);
            } else {
                PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.n.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.f, null, "person_page", 18005);
                createCfgForPersonCenter.setStartFrom(this.h);
                createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            }
            StatisticItem param = new StatisticItem("c12943").param("obj_type", "3").param("tid", this.m.b);
            if (this.m.F) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(param.param("obj_param1", i2));
        }
    }

    public final void P() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (cardPersonDynamicThreadData = this.m) != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.getThreadAlaInfo() != null && this.m.p.getThreadAlaInfo().share_info != null) {
            if (!J()) {
                jg6.a(this.m.b);
            }
            if (this.m.p.getThreadAlaInfo().share_info.record_tid <= 0) {
                K();
                return;
            }
            String valueOf = String.valueOf(this.m.p.getThreadAlaInfo().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.n.getPageActivity());
            pbActivityConfig.setVideo_source(Scopes.PROFILE);
            pbActivityConfig.setStartFrom(this.h);
            pbActivityConfig.setThreadData(this.m.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    public final void N() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.m == null) {
            return;
        }
        if (!J()) {
            jg6.a(this.m.b);
            jg6.l(this.w, this.m.b, R.color.CAM_X0105, R.color.CAM_X0109);
            jg6.l(this.x, this.m.b, R.color.CAM_X0107, R.color.CAM_X0109);
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.n.getPageActivity());
        if (this.m.k == 40) {
            pbActivityConfig.setVideo_source(Scopes.PROFILE);
        }
        pbActivityConfig.createFromThreadCfg(this.m.p, null, "person_page", 18005, true, false, false);
        pbActivityConfig.setForumId(String.valueOf(this.m.p.getFid()));
        pbActivityConfig.setForumName(this.m.p.getForum_name());
        pbActivityConfig.setStartFrom(this.h);
        pbActivityConfig.setIsShareThread(this.m.p.isShareThread);
        pbActivityConfig.setThreadData(this.m.p);
        pbActivityConfig.setIsPrivacy(this.m.o);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        ThreadData threadData = this.m.p;
        if (threadData != null && threadData.isShareThread) {
            StatisticItem param = new StatisticItem("c12943").param("obj_type", "2").param("tid", this.m.b);
            if (this.m.F) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(param.param("obj_param1", i2));
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || this.m == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = str;
        arrayList.add(videoItemData);
        new VideoRecommentPlayActivityConfig(getContext(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_MY_THREADS).start();
    }

    public final void X(boolean z) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048590, this, z) != null) || (constrainImageGroup = this.y) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) constrainImageGroup.getLayoutParams();
        if (z) {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
        } else {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        }
        this.y.setLayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e9  */
    @Override // com.baidu.tieba.yf6
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cardPersonDynamicThreadData) == null) {
            if (cardPersonDynamicThreadData == null) {
                if (h() != null) {
                    h().setVisibility(8);
                    return;
                }
                return;
            }
            this.m = cardPersonDynamicThreadData;
            if (h() != null) {
                h().setVisibility(0);
                h().setOnClickListener(this.U);
            }
            TextView textView = this.o;
            if (cardPersonDynamicThreadData.D) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            LinearLayout linearLayout = this.p;
            if (cardPersonDynamicThreadData.C) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            linearLayout.setVisibility(i3);
            View view2 = this.O;
            if (cardPersonDynamicThreadData.C) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view2.setVisibility(i4);
            View view3 = this.P;
            if (cardPersonDynamicThreadData.C) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            view3.setVisibility(i5);
            if (cardPersonDynamicThreadData.E) {
                this.O.setVisibility(8);
                this.P.setVisibility(8);
            }
            if (cardPersonDynamicThreadData.k == 40 && cardPersonDynamicThreadData.n == 2) {
                z = true;
            } else {
                z = false;
            }
            this.R = z;
            V(cardPersonDynamicThreadData);
            ThreadData threadData = cardPersonDynamicThreadData.p;
            if (threadData != null) {
                if (threadData.isShareThread && cardPersonDynamicThreadData.n == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.S = z2;
            }
            this.o.setText(cardPersonDynamicThreadData.r);
            this.q.setText(cardPersonDynamicThreadData.s);
            this.r.setText(cardPersonDynamicThreadData.t);
            CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.B;
            if (multipleForumArr != null && multipleForumArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                int i6 = 0;
                while (true) {
                    CardPersonDynamicThreadData.MultipleForum[] multipleForumArr2 = cardPersonDynamicThreadData.B;
                    if (i6 >= multipleForumArr2.length) {
                        break;
                    }
                    sb.append(StringHelper.cutChineseAndEnglishWithSuffix(multipleForumArr2[i6].forum_name, 14, StringHelper.STRING_MORE));
                    if (i6 < cardPersonDynamicThreadData.B.length - 1) {
                        sb.append("吧、");
                    } else if (sb.lastIndexOf(this.c.getString(R.string.obfuscated_res_0x7f0f06b5)) != sb.length() - 1) {
                        sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f06b5));
                    }
                    i6++;
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    this.s.setText(sb2);
                    this.s.setVisibility(0);
                } else {
                    this.s.setText(R.string.person_homepage);
                }
            } else {
                this.s.setText(R.string.person_homepage);
            }
            this.T.setVisibility(8);
            if (cardPersonDynamicThreadData.F) {
                int i7 = cardPersonDynamicThreadData.q;
                if (i7 == 3) {
                    this.t.setVisibility(8);
                } else if (i7 == 1) {
                    this.t.setVisibility(0);
                }
                U(cardPersonDynamicThreadData.o);
                if (cardPersonDynamicThreadData.H == 1) {
                    this.t.setVisibility(8);
                    this.T.setVisibility(0);
                }
                this.u.setVisibility(0);
                this.u.setOnClickListener(new c(this, cardPersonDynamicThreadData));
            } else {
                this.t.setVisibility(8);
                this.u.setVisibility(8);
            }
            VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.z;
            if (voiceModelArr != null && voiceModelArr.length > 0) {
                this.i.setVisibility(0);
                X(true);
                VoiceData.VoiceModel voiceModel = voiceModelArr[0];
                this.i.setVoiceModel(voiceModel);
                this.i.setTag(voiceModel);
                this.i.e();
                if (voiceModel != null) {
                    this.i.m(voiceModel.voice_status.intValue());
                }
                this.i.o();
            } else {
                this.i.setVisibility(8);
                X(false);
            }
            MediaData[] mediaDataArr = cardPersonDynamicThreadData.x;
            SkinManager.setBackgroundResource(this.D, R.color.transparent);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.D.setVisibility(0);
            this.A.setVisibility(8);
            this.L.setVisibility(8);
            this.G.setVisibility(8);
            this.J.setVisibility(8);
            this.K.cancelAnimation();
            this.K.setVisibility(8);
            long j2 = cardPersonDynamicThreadData.k;
            if (j2 == 36) {
                this.y.setVisibility(8);
            } else {
                if (j2 != 40) {
                    long j3 = this.m.k;
                    if (j3 != 50) {
                        if (j3 != 60 && j3 != 49) {
                            if (rv4.c().g() && mediaDataArr.length > 0) {
                                LinkedList linkedList = new LinkedList();
                                ThreadData threadData2 = cardPersonDynamicThreadData.p;
                                for (MediaData mediaData : mediaDataArr) {
                                    if (mediaData != null && mediaData.getType() == 3) {
                                        linkedList.add(mediaData);
                                    }
                                }
                                if (ListUtils.getCount(linkedList) > 0) {
                                    this.y.setVisibility(0);
                                    this.y.setFromCDN(this.z);
                                    this.y.setSingleImageRatio(0.67d);
                                    this.y.setImageClickListener(new d(this, linkedList, threadData2));
                                    this.y.setImageMediaList(linkedList);
                                } else {
                                    this.y.setVisibility(8);
                                }
                            } else {
                                this.y.setVisibility(8);
                            }
                            this.D.setVisibility(8);
                        } else {
                            this.y.setVisibility(8);
                            if (this.m.p.getThreadAlaInfo() != null && this.m.p.getThreadAlaInfo().user_info != null) {
                                CardPersonDynamicThreadData cardPersonDynamicThreadData2 = this.m;
                                if (cardPersonDynamicThreadData2.k == 60) {
                                    String str = cardPersonDynamicThreadData2.p.getThreadAlaInfo().user_info.user_name;
                                    if (jr5.e(str) > 14) {
                                        str = jr5.m(str, 14) + StringHelper.STRING_MORE;
                                    }
                                    this.E.setText(jg6.d(str + ":", this.m.p.getTitle()));
                                    this.E.setVisibility(0);
                                    if (rv4.c().g()) {
                                        this.A.setVisibility(0);
                                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                                        int width = this.A.getWidth();
                                        if (width == 0 || width > ii.l(this.c)) {
                                            width = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0702df);
                                        }
                                        layoutParams.height = (width * 9) / 16;
                                        this.A.setLayoutParams(layoutParams);
                                        if (this.m.p.getThreadAlaInfo() != null) {
                                            this.B.setPlaceHolder(3);
                                            this.B.setEvent(this.Y);
                                            this.B.N(cardPersonDynamicThreadData.p.getThreadAlaInfo().cover, 10, false);
                                            this.C.setVisibility(8);
                                            this.K.setVisibility(0);
                                            this.K.playAnimation();
                                            SkinManager.setBackgroundResource(this.D, R.color.CAM_X0205);
                                            this.J.setVisibility(0);
                                            this.J.setText(String.format(this.c.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.m.p.getThreadAlaInfo().audience_count)));
                                            this.Q.getCommentContainer().setOnClickListener(this.U);
                                        } else {
                                            this.Q.getCommentContainer().setOnClickListener(this.Q);
                                        }
                                    }
                                }
                            }
                            this.E.setVisibility(8);
                            if (rv4.c().g()) {
                            }
                        }
                    }
                }
                this.y.setVisibility(8);
                if (rv4.c().g()) {
                    this.A.setVisibility(0);
                    this.C.setVisibility(0);
                    this.C.setImageResource(R.drawable.icon_play_video);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                    int width2 = this.A.getWidth();
                    if (width2 == 0 || width2 > ii.l(this.c)) {
                        width2 = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0702f2);
                    }
                    layoutParams2.height = (int) (width2 * 0.5625d);
                    this.A.setLayoutParams(layoutParams2);
                    if (this.m.y != null) {
                        this.B.setPlaceHolder(3);
                        this.B.setEvent(this.Y);
                        this.B.N(this.m.y.thumbnail_url, 17, false);
                        if (this.R) {
                            this.L.setVisibility(0);
                            this.L.setText(String.format(this.c.getResources().getString(R.string.video_review_state), new Object[0]));
                        } else {
                            this.G.setVisibility(0);
                            this.H.setText(StringHelper.stringForVideoTime(this.m.y.video_duration.intValue() * 1000));
                            this.I.setText(String.format(this.c.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.m.y.play_count.intValue())));
                        }
                    }
                }
            }
            ThreadData threadData3 = cardPersonDynamicThreadData.p;
            if (threadData3 != null && threadData3.originalThreadData != null) {
                this.N.setVisibility(0);
                this.N.i(cardPersonDynamicThreadData.p.originalThreadData);
                this.N.setOnClickListener(this);
                this.i.setVisibility(8);
                this.y.setVisibility(8);
                this.D.setVisibility(8);
                if (this.S) {
                    this.M.setVisibility(0);
                } else {
                    this.M.setVisibility(8);
                }
            } else {
                this.N.setVisibility(8);
                this.M.setVisibility(8);
            }
            T();
            I(cardPersonDynamicThreadData);
        }
    }

    public final void U(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || (textView = this.t) == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.obfuscated_res_0x7f0f0fd3);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_card_privacy);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.t.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        textView.setText(R.string.public_open);
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_card_open);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.t.setCompoundDrawables(drawable2, null, null, null);
    }

    public final boolean V(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cardPersonDynamicThreadData)) == null) {
            if (cardPersonDynamicThreadData == null || (threadData = cardPersonDynamicThreadData.p) == null) {
                return false;
            }
            SpannableStringBuilder parseTitleOrAbstractForFrs = threadData.parseTitleOrAbstractForFrs(false, true, this.R);
            if (parseTitleOrAbstractForFrs != null && !StringUtils.isNull(parseTitleOrAbstractForFrs.toString())) {
                this.w.setVisibility(0);
                this.w.setOnTouchListener(new ky9(parseTitleOrAbstractForFrs));
                this.w.setText(parseTitleOrAbstractForFrs);
                if (!J()) {
                    jg6.l(this.w, cardPersonDynamicThreadData.b, R.color.CAM_X0105, R.color.CAM_X0109);
                }
            } else {
                this.w.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W(View view2, List<MediaData> list, int i2, ThreadData threadData) {
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048589, this, view2, list, i2, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                ii.P(this.n.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                    arrayList.add(mediaData.getPicUrl());
                    ImageUrlData imageUrlData = new ImageUrlData();
                    if (this.z) {
                        i3 = 13;
                    } else {
                        i3 = 14;
                    }
                    imageUrlData.urlType = i3;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = gg.g(threadData.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
                }
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.A(arrayList);
            builder.E(i2);
            builder.C(threadData.getForum_name());
            builder.O(threadData.getFirst_post_id());
            builder.B(String.valueOf(threadData.getFid()));
            builder.R(threadData.getTid());
            builder.F(this.z);
            if (arrayList.size() > 0) {
                str = arrayList.get(0);
            } else {
                str = "";
            }
            builder.M(str);
            builder.I(true);
            builder.y(concurrentHashMap);
            builder.K(true);
            builder.Q(threadData);
            builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
            ImageViewerConfig x = builder.x(this.n.getPageActivity());
            x.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x));
        }
    }

    @Override // com.baidu.tieba.yf6
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i2) == null) {
            if (this.l != i2) {
                SkinManager.setLottieAnimation(this.K, R.raw.obfuscated_res_0x7f110007);
                SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0109);
                if (this.u != null) {
                    this.u.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
                }
                SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0106);
                ng6 ng6Var = this.v;
                if (ng6Var != null) {
                    ng6Var.r();
                }
                this.j.b();
                this.Q.onChangeSkinType();
                SkinManager.setBackgroundColor(this.O, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.P, R.color.CAM_X0205);
                SkinManager.setBackgroundColor(this.E, R.color.CAM_X0205);
                OriginalThreadCardView originalThreadCardView = this.N;
                if (originalThreadCardView != null) {
                    originalThreadCardView.s();
                }
                q25 d2 = q25.d(this.T);
                d2.w(R.color.CAM_X0109);
                d2.C(R.string.F_X01);
            }
            this.l = i2;
        }
    }
}
