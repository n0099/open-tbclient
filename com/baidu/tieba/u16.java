package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.CardLiveLabelView;
import com.baidu.tbadk.widget.CardLiveLottieView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes6.dex */
public class u16 extends z76<ThreadData> implements x86, as5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TextView B;
    public TbImageView C;
    public RelativeLayout D;
    public TbImageView E;
    public TextView F;
    public FrameLayout G;
    public LinearLayout H;
    public TextView I;
    public ImageView J;
    public TbLiveContainer K;
    public CardLiveLabelView L;
    public CardLiveLottieView M;
    public String N;
    public boolean O;
    public String P;
    public View Q;
    public boolean R;
    public int S;
    public n16 T;
    public final View.OnClickListener U;
    public CardUserInfoLayout v;
    public ThreadSourceShareAndPraiseLayout w;
    public View x;
    public LinearLayout y;
    public ThreadSkinView z;

    @Override // com.baidu.tieba.a86
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.obfuscated_res_0x7f0d02ff : invokeV.intValue;
    }

    @Override // com.baidu.tieba.x86
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u16 a;

        public a(u16 u16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e() != null) {
                this.a.e().a(view2, this.a.k);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u16(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.O = false;
        this.S = 0;
        this.U = new a(this);
        o(bdUniqueId);
        this.i = tbPageContext;
        View h = h();
        RelativeLayout relativeLayout = (RelativeLayout) h.findViewById(R.id.layout_root);
        this.A = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.y = (LinearLayout) h.findViewById(R.id.video_card_content_layout);
        this.A.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f092606);
        this.C = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.C.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) h.findViewById(R.id.obfuscated_res_0x7f0904e5);
        this.v = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.U);
        this.B = (TextView) h.findViewById(R.id.text_title);
        this.D = (RelativeLayout) h.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) h.findViewById(R.id.image_video);
        this.E = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.E.setPlaceHolder(3);
        this.E.setDefaultResource(0);
        this.E.setRadiusById(R.string.J_X05);
        this.E.setConrers(15);
        this.E.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.E.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.E.setBorderSurroundContent(true);
        this.E.setDrawBorder(true);
        this.F = (TextView) h.findViewById(R.id.ala_live_recom_reason);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) h.findViewById(R.id.text_bottom);
        this.l = threadCommentAndPraiseInfoLayout;
        t(threadCommentAndPraiseInfoLayout);
        this.l.setSelectVisible(false);
        this.l.setIsBarViewVisible(false);
        this.l.setCommentNumEnable(true);
        this.l.setLiveShareEnable(false);
        this.l.setFrom(2);
        this.l.getCommentContainer().setOnClickListener(this);
        this.l.hideDisagree();
        ls4 ls4Var = new ls4();
        ls4Var.b = 2;
        ls4Var.h = 2;
        this.l.setAgreeStatisticData(ls4Var);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) h.findViewById(R.id.card_bottom_op_weight_layout);
        this.m = threadCommentAndPraiseInfoLayout2;
        t(threadCommentAndPraiseInfoLayout2);
        this.m.setFrom(2);
        this.m.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) h.findViewById(R.id.obfuscated_res_0x7f092210);
        this.w = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.b.setOnClickListener(this);
        this.w.b.getCommentContainer().setOnClickListener(this);
        this.w.setFrom(2);
        this.w.setShareReportFrom(1);
        this.w.setSourceFromForPb(3);
        this.w.setStType("frs_page");
        this.w.setHideBarName(true);
        this.x = h.findViewById(R.id.divider_below_reply_number_layout);
        this.z = (ThreadSkinView) h.findViewById(R.id.frs_thread_skin);
        View findViewById = h.findViewById(R.id.thread_multi_del_mask_view);
        this.Q = findViewById;
        findViewById.setClickable(true);
        n16 n16Var = new n16(tbPageContext, this.v.getSuffixContainer());
        this.T = n16Var;
        n16Var.d(f());
        this.G = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f092211);
        this.H = (LinearLayout) h.findViewById(R.id.forum_friends_now_looking);
        this.I = (TextView) h.findViewById(R.id.tv_forum_friends_now_looking);
        this.J = (ImageView) h.findViewById(R.id.image_forum_friends_now_looking);
        this.K = (TbLiveContainer) h.findViewById(R.id.tb_live_container);
        this.u = h.findViewById(R.id.card_bottom_margin);
        this.M = (CardLiveLottieView) h.findViewById(R.id.lottie_view);
        this.L = (CardLiveLabelView) h.findViewById(R.id.label_view);
        if (UbsABTestHelper.isAlaLiveCardStyleTest()) {
            this.L.setViewType(1);
            this.L.setVisibility(0);
            this.M.setVisibility(8);
        }
        if (UbsABTestHelper.isAlaLiveCardStyleTestB()) {
            this.L.setViewType(3);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
        }
        if (UbsABTestHelper.isAlaLiveCardStyleTestA()) {
            this.L.setViewType(4);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
        }
    }

    public int N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return zr5.c().b(this.P, i);
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a86
    /* renamed from: R */
    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            if (UbsABTestHelper.isAlaLiveCardInteractionTest()) {
                y(true);
            }
            if (UbsABTestHelper.isAlaLiveCardInteractionTestA()) {
                y(false);
            }
            T();
        }
    }

    public void U(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) && bdUniqueId != null && this.l != null) {
            CardUserInfoLayout cardUserInfoLayout = this.v;
            if (cardUserInfoLayout != null) {
                cardUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            o(bdUniqueId);
            x(bdUniqueId);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.O = z;
        }
    }

    @Override // com.baidu.tieba.x86
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.N = str;
        }
    }

    @Override // com.baidu.tieba.as5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.P = str;
        }
    }

    public final void L(ThreadData threadData, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (this.O) {
                i = 2;
            } else {
                i = 1;
            }
            TiebaStatic.log(param.param("obj_locate", i).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
            if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", threadData.getId()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (threadData.getForum_name().equals(this.N)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", threadData.getFid()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", threadData.getFid()));
                }
            }
        }
    }

    public final void M(ThreadData threadData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12125").param("tid", threadData.getId());
        if (this.O) {
            i = 2;
        } else {
            i = 1;
        }
        TiebaStatic.log(param.param("obj_locate", i).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
            TiebaStatic.log(new StatisticItem("c12800").param("tid", threadData.getId()));
        }
    }

    public TbLiveContainer O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.K;
        }
        return (TbLiveContainer) invokeV.objValue;
    }

    public void P() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (nr4.c().g() && (t = this.k) != 0 && ((ThreadData) t).getThreadData() != null && ((ThreadData) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.E.setPlaceHolder(3);
                this.E.K(((ThreadData) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void Q(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, context, threadData) == null) && context != null && threadData != null && threadData.getThreadAlaInfo() != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                zi.P(context, R.string.no_network_guide);
                return;
            }
            if (this.R) {
                str = AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE;
            } else {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            }
            if (threadData.getFromType() != null) {
                str = threadData.getFromType();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + threadData.getFid();
            } else if (frsCurTabType == 13) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + threadData.getFid();
            }
            L(threadData, str);
            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
            if (threadAlaInfo.isLegalYYLiveData()) {
                TbPageContext<?> tbPageContext = this.i;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
                S(((ThreadData) this.k).getTid(), String.valueOf(((ThreadData) this.k).getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
            }
        }
    }

    @Override // com.baidu.tieba.a86
    @SuppressLint({"ResourceAsColor"})
    public void j(TbPageContext<?> tbPageContext, int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i) == null) {
            if (this.a != i) {
                w(tbPageContext, i);
                cx4 d = cx4.d(this.A);
                d.n(R.string.J_X06);
                d.i(R.color.CAM_X0205, R.color.CAM_X0206);
                cx4 d2 = cx4.d(this.D);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0401);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0611);
                SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(zi.g(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.H);
                SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.J, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.v.onChangeSkinType(g(), TbadkCoreApplication.getInst().getSkinType());
                this.E.setPlaceHolder(3);
                this.l.onChangeSkinType();
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.l;
                if (threadCommentAndPraiseInfoLayout2 != null) {
                    threadCommentAndPraiseInfoLayout2.setUseDynamicLikeResImmediately();
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout3 = this.m;
                if (threadCommentAndPraiseInfoLayout3 != null) {
                    threadCommentAndPraiseInfoLayout3.setUseDynamicLikeResImmediately();
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.w;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.w.f();
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.w;
                if (threadSourceShareAndPraiseLayout2 != null && (threadCommentAndPraiseInfoLayout = threadSourceShareAndPraiseLayout2.b) != null) {
                    threadCommentAndPraiseInfoLayout.setUseDynamicLikeResImmediately();
                }
                this.L.l();
                this.M.c();
                this.a = i;
            }
            T t = this.k;
            if (t != 0 && l86.k(((ThreadData) t).getId())) {
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.Q, R.color.CAM_X0201);
            this.T.c();
            this.K.d(i);
        }
    }

    public final void S(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, str4, str5) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("fid", str2);
                if (TextUtils.equals("0", str3)) {
                    str3 = null;
                }
                jSONObject.put("roomId", str3);
                if (TextUtils.equals("0", str4)) {
                    str4 = null;
                }
                jSONObject.put("liveId", str4);
                jSONObject.put("sid", str5);
                jSONObject.put("roomInfo", "roomInfo");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public final void T() {
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T t = this.k;
            int i = 8;
            if (t != 0 && ((ThreadData) t).getAuthor() != null) {
                this.A.setVisibility(0);
                int l = zi.l(this.i.getPageActivity());
                if (l != this.S) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                    int l2 = zi.l(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = l2;
                    layoutParams.height = (l2 * 9) / 16;
                    this.D.setLayoutParams(layoutParams);
                    this.S = l;
                }
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().user_info != null && ((ThreadData) this.k).getThreadAlaInfo().user_info.is_official == 2) {
                    this.R = true;
                    sparseArray = ((ThreadData) this.k).getThreadAlaInfo().dislikeInfo;
                    this.C.setVisibility(0);
                    int[] s = zi.s(getContext());
                    ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
                    layoutParams2.width = s[0];
                    layoutParams2.height = (s[0] * Cea708Decoder.COMMAND_DS4) / 1080;
                    this.C.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl)) {
                        this.C.K(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.v.setLayoutParams(marginLayoutParams);
                } else {
                    this.R = false;
                    this.C.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams2.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.v.setLayoutParams(marginLayoutParams2);
                    sparseArray = null;
                }
                if (this.R && sparseArray != null && sparseArray.size() > 0) {
                    this.T.b((ThreadData) this.k, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.T.a() != null) {
                    this.T.a().setVisibility(8);
                }
                ((ThreadData) this.k).parserSpecTitleForFrsAndPb(false, true);
                this.v.setData((ThreadData) this.k);
                SpannableStringBuilder span_str = ((ThreadData) this.k).getSpan_str();
                if (span_str != null && !StringUtils.isNull(span_str.toString())) {
                    this.B.setText(((ThreadData) this.k).getSpan_str());
                    this.B.setVisibility(0);
                } else {
                    this.B.setVisibility(8);
                }
                if (UbsABTestHelper.isAlaLiveCardStyleTest()) {
                    T t2 = this.k;
                    if (t2 != 0 && ((ThreadData) t2).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().audience_count > 0) {
                        this.L.m(String.format(this.i.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((ThreadData) this.k).getThreadAlaInfo().audience_count)));
                    } else {
                        this.L.m(null);
                    }
                }
                if (UbsABTestHelper.isAlaLiveCardStyleTestB()) {
                    T t3 = this.k;
                    if (t3 != 0 && ((ThreadData) t3).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().audience_count > 0) {
                        this.M.d(String.format(this.i.getResources().getString(R.string.ala_live_watch_count_prefix), StringHelper.numFormatOverWan(((ThreadData) this.k).getThreadAlaInfo().audience_count)));
                    } else {
                        this.M.d(null);
                    }
                    T t4 = this.k;
                    if (t4 != 0 && ((ThreadData) t4).getThreadAlaInfo() != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().label_name)) {
                        this.L.n(((ThreadData) this.k).getThreadAlaInfo().label_name);
                    } else {
                        this.L.n(null);
                    }
                }
                if (UbsABTestHelper.isAlaLiveCardStyleTestA()) {
                    T t5 = this.k;
                    if (t5 != 0 && ((ThreadData) t5).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().audience_count > 0) {
                        this.M.d(String.format(this.i.getResources().getString(R.string.ala_live_watch_count_prefix), StringHelper.numFormatOverWan(((ThreadData) this.k).getThreadAlaInfo().audience_count)));
                    } else {
                        this.M.d(null);
                    }
                    T t6 = this.k;
                    if (t6 != 0 && ((ThreadData) t6).getThreadAlaInfo() != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().label_name)) {
                        this.L.o(((ThreadData) this.k).getThreadAlaInfo().label_name);
                    } else {
                        this.L.o(null);
                    }
                }
                this.F.setVisibility(8);
                if (((ThreadData) this.k).getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((ThreadData) this.k).getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.F.setVisibility(0);
                        this.F.setText(str);
                    } else {
                        String latitude = ((ThreadData) this.k).getLatitude();
                        String longtitude = ((ThreadData) this.k).getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c = ap8.e().c();
                            String str2 = c.latitude;
                            String str3 = c.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && zi.h(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.F.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.F.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                if (((ThreadData) this.k).getThreadAlaInfo() != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg)) {
                    this.H.setVisibility(0);
                    this.I.setText(StringHelper.cutChineseAndEnglishWithSuffix(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg, 10, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                    layoutParams3.addRule(3, R.id.forum_friends_now_looking);
                } else {
                    this.H.setVisibility(8);
                    layoutParams3.addRule(3, R.id.video_card_content_layout);
                }
                this.G.setLayoutParams(layoutParams3);
                W(N(1));
                M((ThreadData) this.k);
                this.Q.setVisibility((gn6.f().i() || fn6.h().j()) ? 0 : 0);
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
                P();
                D(this.A);
                this.K.b((ThreadData) this.k);
                this.K.setStaticsLocationPage("2");
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public void W(int i) {
        T t;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || (t = this.k) == 0) {
            return;
        }
        if (i == 1) {
            this.l.setVisibility(8);
            this.w.g((ThreadData) this.k);
            return;
        }
        boolean data = this.l.setData((ThreadData) t);
        View view2 = this.x;
        if (data) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view2.setVisibility(i2);
        this.w.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view2) == null) && !gn6.f().i() && !fn6.h().j()) {
            if (view2 != this.A && view2 != this.l.getCommentContainer() && view2 != this.y && view2 != this.w.b.getCommentContainer() && view2 != this.m.getCommentContainer() && view2 != this.H) {
                if (view2.getId() == R.id.video_container) {
                    if (e() != null) {
                        e().a(view2, this.k);
                    }
                    Q(getContext(), (ThreadData) this.k);
                    return;
                }
                return;
            }
            T t = this.k;
            if (t != 0) {
                l86.a(((ThreadData) t).getId());
            }
            if (e() != null) {
                e().a(this.A, this.k);
            }
            Q(getContext(), (ThreadData) this.k);
            if (this.k != 0) {
                if (view2 == this.l.getCommentContainer() || view2 == this.w.b.getCommentContainer()) {
                    StatisticItem statisticItem = new StatisticItem("c12942");
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_type", 5);
                    statisticItem.param("tid", ((ThreadData) this.k).getTid());
                    statisticItem.param("nid", ((ThreadData) this.k).getNid());
                    ef5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                    if (findPageExtraByView != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }
}
