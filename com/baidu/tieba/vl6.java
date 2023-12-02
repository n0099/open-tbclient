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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recapp.localads.LocationCacheData;
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
/* loaded from: classes8.dex */
public class vl6 extends ml6<cn6> implements d26 {
    public static /* synthetic */ Interceptable $ic;
    public static final int R;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TextView B;
    public TextView C;
    public CardLiveLabelView D;
    public LinearLayout E;
    public TextView F;
    public ImageView G;
    public TbLiveContainer H;
    public ViewGroup I;
    public ImageView J;
    public TextView K;
    public TextView L;
    public TbImageView M;
    public boolean N;
    public int O;
    public View.OnClickListener P;
    public CustomMessageListener Q;
    public FrameLayout v;
    public LinearLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public RelativeLayout z;

    @Override // com.baidu.tieba.d26
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl6 a;

        public a(vl6 vl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f() != null) {
                this.a.f().a(view2, this.a.k);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vl6 vl6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl6Var, Integer.valueOf(i)};
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
            this.a = vl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && (t = this.a.k) != 0 && ((cn6) t).a != null && ((cn6) t).a.getTid() != null && this.a.y != null && ((String) customResponsedMessage.getData()).equals(((cn6) this.a.k).a.getTid())) {
                vl6 vl6Var = this.a;
                xl6.l(vl6Var.y, ((cn6) vl6Var.k).a.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244681, "Lcom/baidu/tieba/vl6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244681, "Lcom/baidu/tieba/vl6;");
                return;
            }
        }
        R = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    }

    public View N() {
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

    public TbLiveContainer O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.H;
        }
        return (TbLiveContainer) invokeV.objValue;
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.N) {
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

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.k;
            if (t != 0 && ((cn6) t).getThreadData() != null) {
                return ((cn6) this.k).getThreadData().isFromConcern;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.k;
            if (t != 0 && ((cn6) t).getThreadData() != null) {
                return ((cn6) this.k).getThreadData().isFromHomPage;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.N = false;
        this.O = 0;
        this.P = new a(this);
        this.Q = new b(this, 2001390);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        S(i());
    }

    public void Q() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (qv4.c().g() && (t = this.k) != 0 && ((cn6) t).getThreadData() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.A.setPlaceHolder(3);
                this.A.startLoad(((cn6) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.k;
            if (t != 0 && ((cn6) t).getThreadData() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                String str = ((cn6) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mRankShow;
                if (TextUtils.isEmpty(str)) {
                    this.I.setVisibility(8);
                    return;
                } else if (!U()) {
                    this.I.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isHotRankShowABTest()) {
                    this.I.setVisibility(8);
                    return;
                } else {
                    try {
                        String substring = str.substring(0, 3);
                        String substring2 = str.substring(3);
                        this.K.setText(substring);
                        this.L.setText(substring2);
                        this.I.setVisibility(0);
                        return;
                    } catch (Exception e) {
                        this.I.setVisibility(8);
                        e.printStackTrace();
                        return;
                    }
                }
            }
            this.I.setVisibility(8);
        }
    }

    public final void S(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.v = (FrameLayout) view2.findViewById(R.id.layout_root);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09081a);
            this.w = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view2.findViewById(R.id.card_home_page_ala_video_user_info_layout);
            this.x = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.i);
            this.x.setPageUniqueId(this.j);
            this.y = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b6);
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
            CardLiveLabelView cardLiveLabelView = (CardLiveLabelView) view2.findViewById(R.id.label_view);
            this.D = cardLiveLabelView;
            cardLiveLabelView.setViewType(2);
            this.D.setVisibility(0);
            this.I = (ViewGroup) view2.findViewById(R.id.ala_live_rank_show_layout);
            this.J = (ImageView) view2.findViewById(R.id.ala_live_rank_show_icon);
            this.K = (TextView) view2.findViewById(R.id.ala_live_rank_show_title);
            this.L = (TextView) view2.findViewById(R.id.ala_live_rank_show_number);
            this.M = (TbImageView) view2.findViewById(R.id.live_game_show_icon);
            this.B = (TextView) view2.findViewById(R.id.ala_live_recom_reason);
            this.q = (ForumEnterLayout) view2.findViewById(R.id.card_forum_enter_button);
            this.l = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.card_bottom_op_layout);
            this.m = (ThreadCardBottomOpSegmentWeightLayout) view2.findViewById(R.id.card_bottom_op_weight_layout);
            this.l.setUseDynamicLikeRes();
            this.l.setNeedMatchStrategy(true);
            this.m.setUseDynamicLikeRes();
            this.m.setNeedMatchStrategy(true);
            s(this.l);
            s(this.m);
            this.w.setOnClickListener(this);
            this.E = (LinearLayout) view2.findViewById(R.id.forum_friends_now_looking);
            this.F = (TextView) view2.findViewById(R.id.tv_forum_friends_now_looking);
            this.G = (ImageView) view2.findViewById(R.id.image_forum_friends_now_looking);
            this.H = (TbLiveContainer) view2.findViewById(R.id.tb_live_container);
            this.E.setOnClickListener(this);
            this.u = view2.findViewById(R.id.card_bottom_margin);
            HomeGroupUbsUIHelper.handleImgMask(view2.findViewById(R.id.obfuscated_res_0x7f0910fd));
        }
    }

    public final void V(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.b;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void W(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (f() != null) {
                f().a(view2, this.k);
            }
            T t = this.k;
            if (t != 0 && ((cn6) t).getThreadData() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo() != null) {
                AlaInfoData threadAlaInfo = ((cn6) this.k).getThreadData().getThreadAlaInfo();
                xl6.a(((cn6) this.k).a.getId());
                xl6.l(this.y, ((cn6) this.k).a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (threadAlaInfo.isLegalYYLiveData()) {
                    if (((cn6) this.k).getThreadData().isFromHomPage) {
                        str = YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                    } else if (((cn6) this.k).getThreadData().isFromConcern) {
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
                    Y(((cn6) this.k).getThreadData().getTid(), String.valueOf(((cn6) this.k).getThreadData().getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: X */
    public void j(cn6 cn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cn6Var) == null) {
            this.k = cn6Var;
            if (U() || T()) {
                C(true);
            }
            Z();
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.N = z;
        }
    }

    public void d0(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (threadCommentAndPraiseInfoLayout = this.l) != null) {
            threadCommentAndPraiseInfoLayout.f1076T = String.valueOf(i);
        }
    }

    public final void Y(String str, String str2, String str3, String str4, String str5) {
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

    public final void Z() {
        int dimenPixelSize;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            T t = this.k;
            if (t != 0 && ((cn6) t).getThreadData() != null) {
                this.v.setVisibility(0);
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.i.getPageActivity());
                if (equipmentWidth != this.O) {
                    boolean isFeedLiveCardStyleA = UbsABTestHelper.isFeedLiveCardStyleA();
                    if (isFeedLiveCardStyleA) {
                        dimenPixelSize = (int) (equipmentWidth * 0.6d);
                    } else {
                        dimenPixelSize = equipmentWidth - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                    layoutParams.width = dimenPixelSize;
                    if (isFeedLiveCardStyleA) {
                        i = (dimenPixelSize * 5) / 4;
                    } else {
                        i = (dimenPixelSize * 9) / 16;
                    }
                    layoutParams.height = i;
                    this.z.setLayoutParams(layoutParams);
                    this.O = equipmentWidth;
                }
                if (((cn6) this.k).getThreadData().getThreadAlaInfo() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    this.l.setShowFlag(10);
                    this.l.hideShareContainer();
                } else {
                    this.l.setShowFlag(11);
                    this.l.resetShareContainer();
                }
                this.x.setVisibility(0);
                this.x.setData(((cn6) this.k).getThreadData());
                this.x.setUserAfterClickListener(this.P);
                ((cn6) this.k).getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((cn6) this.k).getThreadData().getSpan_str());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setText(spannableStringBuilder);
                    this.y.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.y, ((cn6) this.k).getThreadData());
                }
                ((RelativeLayout.LayoutParams) this.I.getLayoutParams()).addRule(1, R.id.label_view);
                ((RelativeLayout.LayoutParams) this.I.getLayoutParams()).addRule(6, R.id.label_view);
                if (!UbsABTestHelper.isFeedLiveCardStyleA()) {
                    if (((cn6) this.k).a.getThreadAlaInfo() != null && ((cn6) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.C.setVisibility(0);
                        this.C.setText(String.format(this.i.getResources().getString(R.string.ala_audience_count_prefix_new), StringHelper.numFormatOverWan(((cn6) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.C.setVisibility(8);
                    }
                }
                this.I.setVisibility(8);
                this.B.setVisibility(8);
                if (!UbsABTestHelper.isFeedLiveCardStyleA() && ((cn6) this.k).a.getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((cn6) this.k).a.getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.B.setVisibility(0);
                        this.B.setText(str);
                    } else {
                        String latitude = ((cn6) this.k).a.getLatitude();
                        String longtitude = ((cn6) this.k).a.getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo createRecReqAppPosInfo = LocationCacheData.getInstance().createRecReqAppPosInfo();
                            String str2 = createRecReqAppPosInfo.latitude;
                            String str3 = createRecReqAppPosInfo.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && BdUtilHelper.getDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.B.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.B.setVisibility(0);
                            }
                        }
                    }
                }
                if (((cn6) this.k).a.getThreadAlaInfo() != null && !StringUtils.isNull(((cn6) this.k).a.getThreadAlaInfo().forumUserLiveMsg)) {
                    this.E.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((cn6) this.k).a.getThreadAlaInfo().forumUserLiveMsg, 10, "...");
                    this.F.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.E.setVisibility(8);
                }
                D(true);
                H(this.v);
                k(this.i, TbadkCoreApplication.getInst().getSkinType());
                if (xl6.k(((cn6) this.k).a.getId())) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0105, 1);
                }
                Q();
                this.H.b(((cn6) this.k).a);
                this.H.setStaticsLocationPage("1");
                c0();
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void a0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) && bdUniqueId != null && this.l != null && this.Q != null) {
            n(bdUniqueId);
            B(bdUniqueId);
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                cardUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            this.Q.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Q);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            T t = this.k;
            if (t != 0 && ((cn6) t).getThreadData() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                if (!U()) {
                    this.M.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isLiveCardGameShow()) {
                    this.M.setVisibility(8);
                    return;
                } else {
                    String str = ((cn6) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        this.M.setVisibility(8);
                        return;
                    }
                    this.M.setVisibility(0);
                    this.M.setPlaceHolder(0);
                    this.M.startLoad(str, 10, false);
                    return;
                }
            }
            this.M.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048596, this, tbPageContext, i) == null) && this.a != i) {
            A(tbPageContext, i);
            EMManager.from(this.w).setCorner(R.string.J_X06).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(BdUtilHelper.getDimens(c(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(R).into(this.E);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.G, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.x.onChangeSkinType(h(), TbadkCoreApplication.getInst().getSkinType());
            this.H.d(i);
            this.A.setPlaceHolder(3);
            EMManager.from(this.C).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.I).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0605);
            this.J.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_ala_live_rank_top, WebPManager.ResourceStateType.NORMAL_DISABLE));
            EMManager.from(this.K).setTextColor(R.color.CAM_X0314);
            EMManager.from(this.L).setTextColor(R.color.CAM_X0101);
            this.D.f();
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            if (view2 == this.w || view2 == this.l.getCommentContainer() || view2 == this.m.getCommentContainer() || view2 == this.E) {
                if (((cn6) this.k).getThreadData().getThreadAlaInfo() != null && ((cn6) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    V(((cn6) this.k).getThreadData().getThreadAlaInfo().thirdRoomId, ((cn6) this.k).getThreadData().getThreadAlaInfo().thirdLiveType);
                } else {
                    W(view2);
                }
            }
        }
    }
}
