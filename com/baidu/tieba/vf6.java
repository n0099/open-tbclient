package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vf6 extends mo6<ThreadData> implements kp6, n56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public TextView B;
    public AlaVideoContainer C;
    public RelativeLayout D;
    public LinearLayout E;
    public ThreadSourceShareAndPraiseLayout F;
    public View G;
    public String H;
    public String I;
    public View J;
    public final View.OnClickListener K;
    public LinearLayout v;
    public RelativeLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public TextView z;

    @Override // com.baidu.tieba.no6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.obfuscated_res_0x7f0d034e : invokeV.intValue;
    }

    @Override // com.baidu.tieba.kp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf6 a;

        public a(vf6 vf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf6Var;
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
    public vf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.K = new a(this);
        l(bdUniqueId);
        this.i = tbPageContext;
        View h = h();
        RelativeLayout relativeLayout = (RelativeLayout) h.findViewById(R.id.layout_root);
        this.w = relativeLayout;
        relativeLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) h.findViewById(R.id.video_card_content_layout);
        this.v = linearLayout;
        linearLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f090242);
        this.D = relativeLayout2;
        this.E = (LinearLayout) relativeLayout2.findViewById(R.id.challenge_root);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) h.findViewById(R.id.obfuscated_res_0x7f09057e);
        this.x = cardUserInfoLayout;
        cardUserInfoLayout.setShowFlag(6141);
        HeadImageView headImageView = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f090243);
        this.A = headImageView;
        headImageView.setIsRound(true);
        this.A.setDrawBorder(false);
        this.A.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.A.setAutoChangeStyle(false);
        this.B = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090244);
        this.y = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092502);
        this.z = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090209);
        AlaVideoContainer alaVideoContainer = (AlaVideoContainer) h.findViewById(R.id.obfuscated_res_0x7f090246);
        this.C = alaVideoContainer;
        alaVideoContainer.setOnVideoClickListener(this);
        View findViewById = h.findViewById(R.id.thread_multi_del_mask_view);
        this.J = findViewById;
        findViewById.setClickable(true);
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
        this.l.setShareReportFrom(1);
        h15 h15Var = new h15();
        h15Var.b = 2;
        h15Var.h = 2;
        this.l.setAgreeStatisticData(h15Var);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) h.findViewById(R.id.card_bottom_op_weight_layout);
        this.m = threadCommentAndPraiseInfoLayout2;
        t(threadCommentAndPraiseInfoLayout2);
        this.m.setFrom(2);
        this.m.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) h.findViewById(R.id.obfuscated_res_0x7f0924d9);
        this.F = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.b.setOnClickListener(this);
        this.F.b.getCommentContainer().setOnClickListener(this);
        this.F.setFrom(2);
        this.F.setShareReportFrom(1);
        this.F.setSourceFromForPb(3);
        this.F.setStType("frs_page");
        this.F.setHideBarName(true);
        this.G = h.findViewById(R.id.divider_below_reply_number_layout);
        this.C.setLigvingLogLayoutVisible(8);
    }

    public int O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return m56.c().b(this.I, i);
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.no6
    /* renamed from: S */
    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            T();
        }
    }

    public void U(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) && bdUniqueId != null && this.l != null) {
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                cardUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            l(bdUniqueId);
            z(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.kp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.H = str;
        }
    }

    @Override // com.baidu.tieba.n56
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.I = str;
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            if (this.y.getVisibility() == 0) {
                layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            }
            this.D.setLayoutParams(layoutParams);
        }
    }

    public ThreadCommentAndPraiseInfoLayout N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public ThreadCommentAndPraiseInfoLayout P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.F;
            if (threadSourceShareAndPraiseLayout != null) {
                return threadSourceShareAndPraiseLayout.b;
            }
            return null;
        }
        return (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public void Q(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) && tbPageContext != null && (t = this.k) != 0 && ((ThreadData) t).getThreadAlaInfo() != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(tbPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            AlaInfoData threadAlaInfo = ((ThreadData) this.k).getThreadAlaInfo();
            if (threadAlaInfo.isLegalYYLiveData()) {
                TbPageContext<?> tbPageContext2 = this.i;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext2, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
            }
        }
    }

    public final void R(TbPageContext<?> tbPageContext) {
        T t;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) && (t = this.k) != 0 && ((ThreadData) t).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().share_info != null) {
            if (((ThreadData) this.k).getThreadAlaInfo().share_info.record_tid <= 0) {
                Q(this.b);
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((ThreadData) this.k).getThreadAlaInfo().share_info.record_tid), null, "frs_page");
            if (((ThreadData) this.k).isFloor5Video()) {
                str = "floor5";
            } else {
                str = "frs";
            }
            createNormalCfg.setVideo_source(str);
            createNormalCfg.setFromSmartFrs(((ThreadData) this.k).isSmartFrsThread());
            createNormalCfg.setSmartFrsPosition(((ThreadData) this.k).getSmartFrsPosition());
            createNormalCfg.setStartFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.k;
            int i = 8;
            if (t != 0 && ((ThreadData) t).getAuthor() != null) {
                this.w.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
                layoutParams.bottomMargin = 0;
                this.x.setData((ThreadData) this.k);
                this.x.setUserAfterClickListener(this.K);
                this.C.getController().d((ThreadData) this.k, this.H, "", false);
                this.C.getController().c();
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().share_info != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().share_info.content)) {
                    this.y.setVisibility(0);
                    this.y.setText(((ThreadData) this.k).getThreadAlaInfo().share_info.content);
                } else {
                    this.y.setVisibility(8);
                }
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().user_info != null) {
                    String str = ((ThreadData) this.k).getThreadAlaInfo().user_info.user_name;
                    if (ey5.e(str) > 14) {
                        str = ey5.m(str, 14) + "...";
                    }
                    this.B.setText(str + ":");
                    if (TextUtils.isEmpty(((ThreadData) this.k).getThreadAlaInfo().user_info.portrait)) {
                        this.A.setPlaceHolder(1);
                    } else {
                        this.A.startLoad(((ThreadData) this.k).getThreadAlaInfo().user_info.portrait, 10, false, false);
                    }
                }
                String title = ((ThreadData) this.k).getTitle();
                if (!StringUtils.isNull(title)) {
                    this.z.setText(title);
                    this.z.setVisibility(0);
                } else {
                    this.z.setVisibility(8);
                }
                W(O(1));
                if (((ThreadData) this.k).getThreadAlaInfo().mChallengeInfoData != null && ((ThreadData) this.k).getThreadAlaInfo().mChallengeInfoData.challenge_id > 0) {
                    this.E.setVisibility(0);
                } else {
                    this.E.setVisibility(8);
                }
                this.J.setVisibility((wh7.f().i() || vh7.h().j()) ? 0 : 0);
                F(this.w);
                j(g(), TbadkCoreApplication.getInst().getSkinType());
                M();
                return;
            }
            this.w.setVisibility(8);
        }
    }

    public void W(int i) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || (t = this.k) == 0) {
            return;
        }
        if (i == 1) {
            this.l.setVisibility(8);
            this.F.g((ThreadData) this.k);
            return;
        }
        this.l.setData((ThreadData) t);
        this.F.setVisibility(8);
    }

    @Override // com.baidu.tieba.no6
    public void j(TbPageContext<?> tbPageContext, int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i) == null) {
            if (this.a != i) {
                y(tbPageContext, i);
                EMManager.from(this.w).setCorner(R.string.J_X06).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0204);
                AlaVideoContainer alaVideoContainer = this.C;
                if (alaVideoContainer != null) {
                    alaVideoContainer.o(i);
                }
                this.x.onChangeSkinType(g(), TbadkCoreApplication.getInst().getSkinType());
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
                HeadImageView headImageView = this.A;
                if (headImageView != null) {
                    headImageView.setPlaceHolder(1);
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.F;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.F.f();
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.F;
                if (threadSourceShareAndPraiseLayout2 != null && (threadCommentAndPraiseInfoLayout = threadSourceShareAndPraiseLayout2.b) != null) {
                    threadCommentAndPraiseInfoLayout.setUseDynamicLikeResImmediately();
                }
            }
            T t = this.k;
            if (t != 0 && xo6.k(((ThreadData) t).getId())) {
                SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0201);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, view2) == null) && !wh7.f().i() && !vh7.h().j()) {
            int i = 1;
            if (view2 != this.w && view2 != this.l.getCommentContainer() && this.v != view2 && view2 != this.F.b.getCommentContainer() && view2 != this.m.getCommentContainer()) {
                if (view2.getId() == R.id.video_container) {
                    if (e() != null) {
                        e().a(view2, this.k);
                    }
                    TiebaStatic.log(new StatisticItem("c12323"));
                    if (((ThreadData) this.k).getThreadAlaInfo().live_status == 1) {
                        Q(this.b);
                        return;
                    } else {
                        R(this.b);
                        return;
                    }
                }
                return;
            }
            T t = this.k;
            if (t != 0) {
                xo6.a(((ThreadData) t).getId());
            }
            if (e() != null) {
                e().a(this.w, this.k);
            }
            TiebaStatic.log(new StatisticItem("c12323"));
            if (((ThreadData) this.k).getThreadAlaInfo().live_status == 1) {
                Q(this.b);
                i = 5;
            } else {
                R(this.b);
            }
            if (view2 == this.l.getCommentContainer() || view2 == this.F.b.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("tid", ((ThreadData) this.k).getTid());
                statisticItem.param("obj_type", i);
                statisticItem.param("nid", ((ThreadData) this.k).getNid());
                ms5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
