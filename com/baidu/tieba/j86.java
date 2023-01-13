package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.CardLiveLabelView;
import com.baidu.tbadk.widget.CardLiveLottieView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class j86 extends z76<n96> implements as5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int S;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TextView B;
    public TextView C;
    public CardLiveLottieView D;
    public CardLiveLabelView E;
    public LinearLayout F;
    public TextView G;
    public ImageView H;
    public TbLiveContainer I;
    public ViewGroup J;
    public ImageView K;
    public TextView L;
    public TextView M;
    public TbImageView N;
    public boolean O;
    public int P;
    public View.OnClickListener Q;
    public CustomMessageListener R;
    public FrameLayout v;
    public LinearLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public RelativeLayout z;

    @Override // com.baidu.tieba.as5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.a86
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j86 a;

        public a(j86 j86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e() != null) {
                this.a.e().a(view2, this.a.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j86 j86Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j86Var, Integer.valueOf(i)};
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
            this.a = j86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && (t = this.a.k) != 0 && ((n96) t).a != null && ((n96) t).a.getTid() != null && this.a.y != null && ((String) customResponsedMessage.getData()).equals(((n96) this.a.k).a.getTid())) {
                j86 j86Var = this.a;
                l86.l(j86Var.y, ((n96) j86Var.k).a.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837217, "Lcom/baidu/tieba/j86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837217, "Lcom/baidu/tieba/j86;");
                return;
            }
        }
        S = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public TbLiveContainer L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.I;
        }
        return (TbLiveContainer) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.O) {
                CardUserInfoLayout cardUserInfoLayout = this.x;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.y;
        }
        return (View) invokeV.objValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.k;
            if (t != 0 && ((n96) t).getThreadData() != null) {
                return ((n96) this.k).getThreadData().isFromConcern;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.k;
            if (t != 0 && ((n96) t).getThreadData() != null) {
                return ((n96) this.k).getThreadData().isFromHomPage;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j86(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.O = false;
        this.P = 0;
        this.Q = new a(this);
        this.R = new b(this, 2001390);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        P(h());
    }

    public void N() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (nr4.c().g() && (t = this.k) != 0 && ((n96) t).getThreadData() != null && ((n96) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.A.setPlaceHolder(3);
                this.A.K(((n96) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.k;
            if (t != 0 && ((n96) t).getThreadData() != null && ((n96) this.k).getThreadData().getThreadAlaInfo() != null && ((n96) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                String str = ((n96) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mRankShow;
                if (TextUtils.isEmpty(str)) {
                    this.J.setVisibility(8);
                    return;
                } else if (!R()) {
                    this.J.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isHotRankShowABTest()) {
                    this.J.setVisibility(8);
                    return;
                } else {
                    try {
                        String substring = str.substring(0, 3);
                        String substring2 = str.substring(3);
                        this.L.setText(substring);
                        this.M.setText(substring2);
                        this.J.setVisibility(0);
                        return;
                    } catch (Exception e) {
                        this.J.setVisibility(8);
                        e.printStackTrace();
                        return;
                    }
                }
            }
            this.J.setVisibility(8);
        }
    }

    public final void P(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.v = (FrameLayout) view2.findViewById(R.id.layout_root);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.content_layout);
            this.w = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view2.findViewById(R.id.card_home_page_ala_video_user_info_layout);
            this.x = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.i);
            this.x.setPageUniqueId(this.j);
            this.y = (TextView) view2.findViewById(R.id.text_title);
            this.z = (RelativeLayout) view2.findViewById(R.id.frame_video);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.image_video);
            this.A = tbImageView;
            tbImageView.setDrawCorner(true);
            this.A.setPlaceHolder(3);
            this.A.setDefaultResource(0);
            this.A.setRadiusById(R.string.J_X05);
            this.A.setConrers(15);
            this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.A.setBorderSurroundContent(true);
            this.A.setDrawBorder(true);
            this.C = (TextView) view2.findViewById(R.id.play_count_new);
            this.E = (CardLiveLabelView) view2.findViewById(R.id.label_view);
            this.D = (CardLiveLottieView) view2.findViewById(R.id.lottie_view);
            if (UbsABTestHelper.isAlaLiveCardStyleTest()) {
                this.E.setViewType(2);
                this.E.setVisibility(0);
                this.D.setVisibility(8);
            }
            if (UbsABTestHelper.isAlaLiveCardStyleTestB()) {
                this.E.setViewType(3);
                this.E.setVisibility(0);
                this.D.setVisibility(0);
            }
            if (UbsABTestHelper.isAlaLiveCardStyleTestA()) {
                this.E.setViewType(4);
                this.E.setVisibility(0);
                this.D.setVisibility(0);
            }
            this.J = (ViewGroup) view2.findViewById(R.id.ala_live_rank_show_layout);
            this.K = (ImageView) view2.findViewById(R.id.ala_live_rank_show_icon);
            this.L = (TextView) view2.findViewById(R.id.ala_live_rank_show_title);
            this.M = (TextView) view2.findViewById(R.id.ala_live_rank_show_number);
            this.N = (TbImageView) view2.findViewById(R.id.live_game_show_icon);
            this.B = (TextView) view2.findViewById(R.id.ala_live_recom_reason);
            this.q = (ForumEnterLayout) view2.findViewById(R.id.card_forum_enter_button);
            this.l = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.card_bottom_op_layout);
            this.m = (ThreadCardBottomOpSegmentWeightLayout) view2.findViewById(R.id.card_bottom_op_weight_layout);
            this.l.setUseDynamicLikeRes();
            this.l.setNeedMatchStrategy(true);
            this.m.setUseDynamicLikeRes();
            this.m.setNeedMatchStrategy(true);
            t(this.l);
            t(this.m);
            this.w.setOnClickListener(this);
            this.F = (LinearLayout) view2.findViewById(R.id.forum_friends_now_looking);
            this.G = (TextView) view2.findViewById(R.id.tv_forum_friends_now_looking);
            this.H = (ImageView) view2.findViewById(R.id.image_forum_friends_now_looking);
            this.I = (TbLiveContainer) view2.findViewById(R.id.tb_live_container);
            this.F.setOnClickListener(this);
            this.u = view2.findViewById(R.id.card_bottom_margin);
            HomeGroupUbsUIHelper.handleImgMask(view2.findViewById(R.id.obfuscated_res_0x7f090f21));
        }
    }

    public final void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.b;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void T(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.k);
            }
            T t = this.k;
            if (t != 0 && ((n96) t).getThreadData() != null && ((n96) this.k).getThreadData().getThreadAlaInfo() != null) {
                AlaInfoData threadAlaInfo = ((n96) this.k).getThreadData().getThreadAlaInfo();
                l86.a(((n96) this.k).a.getId());
                l86.l(this.y, ((n96) this.k).a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (threadAlaInfo.isLegalYYLiveData()) {
                    if (((n96) this.k).getThreadData().isFromHomPage) {
                        str = YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                    } else if (((n96) this.k).getThreadData().isFromConcern) {
                        str = YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD;
                    } else {
                        str = YYLiveUtil.SOURCE_NOT_DEFINE;
                    }
                    String str2 = str;
                    TbPageContext<?> tbPageContext = this.i;
                    YyExtData yyExtData = threadAlaInfo.mYyExtData;
                    String str3 = yyExtData.mSid;
                    String str4 = yyExtData.mSsid;
                    String str5 = yyExtData.mTemplateId;
                    YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, str2);
                    V(((n96) this.k).getThreadData().getTid(), String.valueOf(((n96) this.k).getThreadData().getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a86
    /* renamed from: U */
    public void i(n96 n96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, n96Var) == null) {
            this.k = n96Var;
            if (UbsABTestHelper.isAlaLiveCardInteractionTest() && (R() || Q())) {
                y(true);
            }
            if (UbsABTestHelper.isAlaLiveCardInteractionTestA()) {
                y(false);
            }
            W();
        }
    }

    public void X(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) && bdUniqueId != null && this.l != null && this.R != null) {
            o(bdUniqueId);
            x(bdUniqueId);
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                cardUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            this.R.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.R);
        }
    }

    public final void V(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, str, str2, str3, str4, str5) == null) {
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

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            T t = this.k;
            if (t != 0 && ((n96) t).getThreadData() != null) {
                this.v.setVisibility(0);
                int l = zi.l(this.i.getPageActivity());
                if (l != this.P) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                    int dimenPixelSize = l - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.z.setLayoutParams(layoutParams);
                    this.P = l;
                }
                if (((n96) this.k).getThreadData().getThreadAlaInfo() != null && ((n96) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    this.l.setShowFlag(10);
                    this.l.hideShareContainer();
                } else {
                    this.l.setShowFlag(11);
                    this.l.resetShareContainer();
                }
                this.x.setVisibility(0);
                this.x.setData(((n96) this.k).getThreadData());
                this.x.setUserAfterClickListener(this.Q);
                ((n96) this.k).getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((n96) this.k).getThreadData().getSpan_str());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setText(spannableStringBuilder);
                    this.y.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.y, ((n96) this.k).getThreadData());
                }
                ((RelativeLayout.LayoutParams) this.J.getLayoutParams()).addRule(1, R.id.label_view);
                ((RelativeLayout.LayoutParams) this.J.getLayoutParams()).addRule(6, R.id.label_view);
                if (UbsABTestHelper.isAlaLiveCardStyleTest()) {
                    if (((n96) this.k).a.getThreadAlaInfo() != null && ((n96) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.C.setVisibility(0);
                        this.C.setText(String.format(this.i.getResources().getString(R.string.ala_audience_count_prefix_new), StringHelper.numFormatOverWan(((n96) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.C.setVisibility(8);
                    }
                }
                if (UbsABTestHelper.isAlaLiveCardStyleTestB()) {
                    if (((n96) this.k).a.getThreadAlaInfo() != null && ((n96) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.D.d(String.format(this.i.getResources().getString(R.string.ala_live_watch_count_prefix), StringHelper.numFormatOverWan(((n96) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.D.d(null);
                    }
                    if (((n96) this.k).a.getThreadAlaInfo() != null && !StringUtils.isNull(((n96) this.k).a.getThreadAlaInfo().label_name)) {
                        this.E.n(((n96) this.k).a.getThreadAlaInfo().label_name);
                    } else {
                        this.E.n(null);
                    }
                }
                if (UbsABTestHelper.isAlaLiveCardStyleTestA()) {
                    if (((n96) this.k).a.getThreadAlaInfo() != null && ((n96) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.D.d(String.format(this.i.getResources().getString(R.string.ala_live_watch_count_prefix), StringHelper.numFormatOverWan(((n96) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.D.d(null);
                    }
                    if (((n96) this.k).a.getThreadAlaInfo() != null && !StringUtils.isNull(((n96) this.k).a.getThreadAlaInfo().label_name)) {
                        this.E.o(((n96) this.k).a.getThreadAlaInfo().label_name);
                    } else {
                        this.E.o(null);
                    }
                }
                this.J.setVisibility(8);
                this.B.setVisibility(8);
                if (((n96) this.k).a.getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((n96) this.k).a.getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.B.setVisibility(0);
                        this.B.setText(str);
                    } else {
                        String latitude = ((n96) this.k).a.getLatitude();
                        String longtitude = ((n96) this.k).a.getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c = ap8.e().c();
                            String str2 = c.latitude;
                            String str3 = c.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && zi.h(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.B.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.B.setVisibility(0);
                            }
                        }
                    }
                }
                if (((n96) this.k).a.getThreadAlaInfo() != null && !StringUtils.isNull(((n96) this.k).a.getThreadAlaInfo().forumUserLiveMsg)) {
                    this.F.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((n96) this.k).a.getThreadAlaInfo().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.G.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.F.setVisibility(8);
                }
                z(true);
                D(this.v);
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
                if (l86.k(((n96) this.k).a.getId())) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0105, 1);
                }
                N();
                this.I.b(((n96) this.k).a);
                this.I.setStaticsLocationPage("1");
                Z();
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.O = z;
        }
    }

    public void a0(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (threadCommentAndPraiseInfoLayout = this.l) != null) {
            threadCommentAndPraiseInfoLayout.T = String.valueOf(i);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            T t = this.k;
            if (t != 0 && ((n96) t).getThreadData() != null && ((n96) this.k).getThreadData().getThreadAlaInfo() != null && ((n96) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                if (!R()) {
                    this.N.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isLiveCardGameShow()) {
                    this.N.setVisibility(8);
                    return;
                } else {
                    String str = ((n96) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        this.N.setVisibility(8);
                        return;
                    }
                    this.N.setVisibility(0);
                    this.N.setPlaceHolder(0);
                    this.N.K(str, 10, false);
                    return;
                }
            }
            this.N.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a86
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048596, this, tbPageContext, i) == null) && this.a != i) {
            w(tbPageContext, i);
            cx4 d = cx4.d(this.w);
            d.n(R.string.J_X06);
            d.i(R.color.CAM_X0205, R.color.CAM_X0206);
            zi.g(getContext(), R.dimen.tbds31);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(zi.g(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(S).into(this.F);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.H, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.x.onChangeSkinType(g(), TbadkCoreApplication.getInst().getSkinType());
            this.I.d(i);
            this.A.setPlaceHolder(3);
            cx4 d2 = cx4.d(this.C);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            cx4 d3 = cx4.d(this.J);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0605);
            this.K.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_ala_live_rank_top, WebPManager.ResourceStateType.NORMAL_DISABLE));
            cx4.d(this.L).v(R.color.CAM_X0314);
            cx4.d(this.M).v(R.color.CAM_X0101);
            this.E.l();
            this.D.c();
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            if (view2 == this.w || view2 == this.l.getCommentContainer() || view2 == this.m.getCommentContainer() || view2 == this.F) {
                if (((n96) this.k).getThreadData().getThreadAlaInfo() != null && ((n96) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    S(((n96) this.k).getThreadData().getThreadAlaInfo().thirdRoomId, ((n96) this.k).getThreadData().getThreadAlaInfo().thirdLiveType);
                } else {
                    T(view2);
                }
            }
        }
    }
}
