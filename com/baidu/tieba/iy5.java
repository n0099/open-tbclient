package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
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
/* loaded from: classes4.dex */
public class iy5 extends o16 implements n26, zo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TextView B;
    public TbImageView C;
    public RelativeLayout D;
    public TbImageView E;
    public TBLottieAnimationView F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public View J;
    public FrameLayout K;
    public LinearLayout L;
    public TextView M;
    public ImageView N;
    public TbLiveContainer O;
    public String P;
    public boolean Q;
    public String R;
    public View S;
    public boolean T;
    public int U;
    public by5 V;
    public final View.OnClickListener W;
    public CardUserInfoLayout v;
    public ThreadSourceShareAndPraiseLayout w;
    public View x;
    public LinearLayout y;
    public ThreadSkinView z;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.obfuscated_res_0x7f0d02fa : invokeV.intValue;
    }

    @Override // com.baidu.tieba.n26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy5 a;

        public a(iy5 iy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy5Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.F.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy5 a;

        public b(iy5 iy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy5Var;
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
    public iy5(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.Q = false;
        this.U = 0;
        this.W = new b(this);
        o(bdUniqueId);
        this.i = tbPageContext;
        View k = k();
        RelativeLayout relativeLayout = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f09129b);
        this.A = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.y = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0924fc);
        this.A.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0924fe);
        this.C = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.C.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f0904d9);
        this.v = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.W);
        this.B = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092136);
        this.D = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f090ade);
        TbImageView tbImageView2 = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090ea2);
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
        this.I = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0901ed);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) k.findViewById(R.id.obfuscated_res_0x7f0901ec);
        this.F = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.F, R.raw.ala_live2);
        this.F.addOnAttachStateChangeListener(new a(this));
        this.G = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0919e9);
        this.H = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0901f6);
        this.J = k.findViewById(R.id.obfuscated_res_0x7f0919ea);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f09210e);
        this.l = threadCommentAndPraiseInfoLayout;
        t(threadCommentAndPraiseInfoLayout);
        this.l.setSelectVisible(false);
        this.l.setIsBarViewVisible(false);
        this.l.setCommentNumEnable(true);
        this.l.setLiveShareEnable(false);
        this.l.setFrom(2);
        this.l.getCommentContainer().setOnClickListener(this);
        this.l.hideDisagree();
        gr4 gr4Var = new gr4();
        gr4Var.b = 2;
        gr4Var.h = 2;
        this.l.setAgreeStatisticData(gr4Var);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f0904df);
        this.m = threadCommentAndPraiseInfoLayout2;
        t(threadCommentAndPraiseInfoLayout2);
        this.m.setFrom(2);
        this.m.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k.findViewById(R.id.obfuscated_res_0x7f09210f);
        this.w = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.b.setOnClickListener(this);
        this.w.b.getCommentContainer().setOnClickListener(this);
        this.w.setFrom(2);
        this.w.setShareReportFrom(1);
        this.w.setSourceFromForPb(3);
        this.w.setStType("frs_page");
        this.w.setHideBarName(true);
        this.x = k.findViewById(R.id.obfuscated_res_0x7f090809);
        this.z = (ThreadSkinView) k.findViewById(R.id.obfuscated_res_0x7f090c17);
        View findViewById = k.findViewById(R.id.obfuscated_res_0x7f09219d);
        this.S = findViewById;
        findViewById.setClickable(true);
        by5 by5Var = new by5(tbPageContext, this.v.getSuffixContainer());
        this.V = by5Var;
        by5Var.d(f());
        this.K = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f092110);
        this.L = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090a78);
        this.M = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092390);
        this.N = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090e90);
        this.O = (TbLiveContainer) k.findViewById(R.id.obfuscated_res_0x7f0920db);
    }

    public int O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return yo5.c().b(this.R, i);
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: S */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            U();
        }
    }

    public void V(BdUniqueId bdUniqueId) {
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

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.Q = z;
        }
    }

    @Override // com.baidu.tieba.n26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.P = str;
        }
    }

    @Override // com.baidu.tieba.zo5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.R = str;
        }
    }

    public final void M(ThreadData threadData, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (this.Q) {
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
                if (threadData.getForum_name().equals(this.P)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", threadData.getFid()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", threadData.getFid()));
                }
            }
        }
    }

    public final void N(ThreadData threadData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12125").param("tid", threadData.getId());
        if (this.Q) {
            i = 2;
        } else {
            i = 1;
        }
        TiebaStatic.log(param.param("obj_locate", i).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
            TiebaStatic.log(new StatisticItem("c12800").param("tid", threadData.getId()));
        }
    }

    public TbLiveContainer P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.O;
        }
        return (TbLiveContainer) invokeV.objValue;
    }

    public void Q() {
        ar4 ar4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (jq4.c().g() && (ar4Var = this.k) != null && ((ThreadData) ar4Var).getThreadData() != null && ((ThreadData) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.E.setPlaceHolder(3);
                this.E.L(((ThreadData) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void R(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, context, threadData) == null) && context != null && threadData != null && threadData.getThreadAlaInfo() != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                fj.M(context, R.string.obfuscated_res_0x7f0f0ca3);
                return;
            }
            if (this.T) {
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
            M(threadData, str);
            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
            if (threadAlaInfo.isLegalYYLiveData()) {
                TbPageContext tbPageContext = this.i;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
                T(((ThreadData) this.k).getTid(), String.valueOf(((ThreadData) this.k).getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
            }
        }
    }

    public final void T(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, str4, str5) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("fid", str2);
                if (TextUtils.equals("0", str3)) {
                    str3 = null;
                }
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str3);
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

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ar4 ar4Var = this.k;
            int i = 8;
            if (ar4Var != null && ((ThreadData) ar4Var).getAuthor() != null) {
                this.A.setVisibility(0);
                int k = fj.k(this.i.getPageActivity());
                if (k != this.U) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                    int k2 = fj.k(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = k2;
                    layoutParams.height = (k2 * 9) / 16;
                    this.D.setLayoutParams(layoutParams);
                    this.U = k;
                }
                SparseArray<String> sparseArray = null;
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().user_info != null && ((ThreadData) this.k).getThreadAlaInfo().user_info.is_official == 2) {
                    this.T = true;
                    sparseArray = ((ThreadData) this.k).getThreadAlaInfo().dislikeInfo;
                    this.C.setVisibility(0);
                    int[] q = fj.q(getContext());
                    ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
                    layoutParams2.width = q[0];
                    layoutParams2.height = (q[0] * Cea708Decoder.COMMAND_DS4) / 1080;
                    this.C.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl)) {
                        this.C.L(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.v.setLayoutParams(marginLayoutParams);
                } else {
                    this.T = false;
                    this.C.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams2.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.v.setLayoutParams(marginLayoutParams2);
                }
                if (this.T && sparseArray != null && sparseArray.size() > 0) {
                    this.V.b((ThreadData) this.k, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.V.a() != null) {
                    this.V.a().setVisibility(8);
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
                if (((ThreadData) this.k).getThreadAlaInfo().audience_count > 0) {
                    this.J.setVisibility(0);
                    this.G.setVisibility(0);
                    this.G.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f0202), StringHelper.numFormatOverWan(((ThreadData) this.k).getThreadAlaInfo().audience_count)));
                } else {
                    this.J.setVisibility(8);
                    this.G.setVisibility(8);
                }
                this.H.setVisibility(8);
                if (((ThreadData) this.k).getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((ThreadData) this.k).getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.H.setVisibility(0);
                        this.H.setText(str);
                    } else {
                        String latitude = ((ThreadData) this.k).getLatitude();
                        String longtitude = ((ThreadData) this.k).getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c = uf8.e().c();
                            String str2 = c.latitude;
                            String str3 = c.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && fj.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0248));
                                this.H.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                if (((ThreadData) this.k).getThreadAlaInfo() != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg)) {
                    this.L.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.M.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f021f));
                    layoutParams3.addRule(3, R.id.obfuscated_res_0x7f090a78);
                } else {
                    this.L.setVisibility(8);
                    layoutParams3.addRule(3, R.id.obfuscated_res_0x7f0924fc);
                }
                this.K.setLayoutParams(layoutParams3);
                X(O(1));
                N((ThreadData) this.k);
                this.S.setVisibility((bh6.f().i() || ah6.h().j()) ? 0 : 0);
                m(this.i, TbadkCoreApplication.getInst().getSkinType());
                Q();
                this.F.playAnimation();
                D(this.A);
                this.O.b((ThreadData) this.k);
                this.O.setStaticsLocationPage("2");
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public void X(int i) {
        ar4 ar4Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || (ar4Var = this.k) == null) {
            return;
        }
        if (i == 1) {
            this.l.setVisibility(8);
            this.w.g((ThreadData) this.k);
            return;
        }
        boolean data = this.l.setData((ThreadData) ar4Var);
        View view2 = this.x;
        if (data) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view2.setVisibility(i2);
        this.w.setVisibility(8);
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i) == null) {
            if (this.a != i) {
                w(tbPageContext, i);
                nv4 d = nv4.d(this.A);
                d.n(R.string.J_X06);
                d.i(R.color.CAM_X0205, R.color.CAM_X0206);
                nv4 d2 = nv4.d(this.D);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0401);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0611);
                float f = fj.f(getContext(), R.dimen.tbds31);
                SkinManager.setBackgroundEndColorToAutoColor(this.I, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{f, f, f, f, f, f, f, f});
                SkinManager.setBackgroundColor(this.J, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(fj.f(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.L);
                SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.N, R.drawable.obfuscated_res_0x7f080679, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                this.a = i;
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.w;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.w.f();
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.w;
                if (threadSourceShareAndPraiseLayout2 != null && (threadCommentAndPraiseInfoLayout = threadSourceShareAndPraiseLayout2.b) != null) {
                    threadCommentAndPraiseInfoLayout.setUseDynamicLikeResImmediately();
                }
            }
            ar4 ar4Var = this.k;
            if (ar4Var != null && a26.k(((ThreadData) ar4Var).getId())) {
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0201);
            this.V.c();
            this.O.d(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view2) == null) && !bh6.f().i() && !ah6.h().j()) {
            if (view2 != this.A && view2 != this.l.getCommentContainer() && view2 != this.y && view2 != this.w.b.getCommentContainer() && view2 != this.m.getCommentContainer() && view2 != this.L) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092500) {
                    if (e() != null) {
                        e().a(view2, this.k);
                    }
                    R(getContext(), (ThreadData) this.k);
                    return;
                }
                return;
            }
            ar4 ar4Var = this.k;
            if (ar4Var != null) {
                a26.a(((ThreadData) ar4Var).getId());
            }
            if (e() != null) {
                e().a(this.A, this.k);
            }
            R(getContext(), (ThreadData) this.k);
            if (this.k != null) {
                if (view2 == this.l.getCommentContainer() || view2 == this.w.b.getCommentContainer()) {
                    StatisticItem statisticItem = new StatisticItem("c12942");
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_type", 5);
                    statisticItem.param("tid", ((ThreadData) this.k).getTid());
                    statisticItem.param("nid", ((ThreadData) this.k).getNid());
                    tc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
