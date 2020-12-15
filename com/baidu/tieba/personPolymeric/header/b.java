package com.baidu.tieba.personPolymeric.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.d;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.c;
import com.baidu.tieba.personPolymeric.c.q;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.tieba.view.GodRecommendLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes24.dex */
public class b {
    public static final int msS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eBQ;
    private AnimatorSet hsD;
    private ImageView kIE;
    private boolean lkR;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private com.baidu.tieba.j.b mrv;
    private TBSpecificationBtn msA;
    private TbImageView msB;
    private ImageView msC;
    private HeadPendantView msD;
    private RelativeLayout msE;
    private GodRecommendLayout msF;
    private ImageView msG;
    private TBLottieAnimationView msH;
    private View msI;
    private ViewGroup msJ;
    private View msK;
    private TextView msL;
    private ImageView msM;
    private View msN;
    private TextView msO;
    private ImageView msP;
    private com.baidu.tieba.model.c msQ;
    private boolean msR;
    private AnimatorSet msT;
    private ValueAnimator msU;
    private ObjectAnimator msV;
    private ObjectAnimator msW;
    private com.baidu.tieba.personPolymeric.b.a msX;
    private boolean msY;
    private TextView msk;
    private ImageView msl;
    private ImageView msm;
    private UserIconBox msn;
    private FrameLayout mso;
    private TextView msp;
    private TextView msq;
    private FrameLayout msr;
    private TextView mss;
    private TextView mst;
    private FrameLayout msu;
    private TextView msv;
    private TextView msw;
    private ImageView msx;
    private ImageView msy;
    private FollowUserSpinnerBtn msz;
    private FollowUserSpinnerBtn.a msZ = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void at(boolean z, boolean z2) {
            if (bh.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.msY = z2;
                b.this.lkR = false;
                if (z) {
                    b.this.msF.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.msQ.bv(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.msF.setCouldStatistic(false);
                    b.this.msR = false;
                    b.this.dAB();
                    if (b.this.msT != null) {
                        b.this.msT.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new ar("c13900"));
                }
            }
        }
    };
    private c.a lkQ = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.msF.setData(qVar.dAA());
                if (!b.this.lkR) {
                    b.this.msR = true;
                    b.this.dAB();
                    if (b.this.msT != null) {
                        b.this.msT.start();
                    }
                }
                TiebaStatic.log(new ar("c13901").al("obj_type", b.this.msY ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).brB();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).brB();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).brB();
            }
        }
    };
    private View.OnClickListener mta = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.msQ != null && b.this.mUserData != null) {
                b.this.lkR = true;
                b.this.msQ.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new ar("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Lo();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eBQ = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eBQ.setOnClickListener(this.mClickListener);
        this.msk = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.msk.setAlpha(0.85f);
        this.msk.setOnClickListener(this.mClickListener);
        this.msl = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.msl.setOnClickListener(this.mClickListener);
        this.msn = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.msn.setOnClickListener(this.mClickListener);
        this.msn.setAutoChangedStyle(false);
        this.msp = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mso = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mso.setOnClickListener(this.mClickListener);
        this.msq = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.msq.setAlpha(0.8f);
        this.kIE = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.msm = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mss = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.msr = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.msr.setOnClickListener(this.mClickListener);
        this.mst = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mst.setAlpha(0.8f);
        this.msy = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.msv = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.msu = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.msu.setOnClickListener(this.mClickListener);
        this.msw = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.msw.setAlpha(0.8f);
        this.msx = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.msz = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.msz.h(this.mClickListener);
        this.msz.setOpenListener(this.msZ);
        this.msA = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.msA.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.rl(R.color.CAM_X0101);
        dVar.rc(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.msA.setConfig(dVar);
        this.msB = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.msB.setOnClickListener(this.mClickListener);
        this.msC = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.msD = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.msD.setHasPendantStyle();
        this.msD.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.msD.getHeadView().setIsRound(true);
        this.msD.getHeadView().setDrawBorder(false);
        this.msD.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.msD.setOnClickListener(this.mClickListener);
        this.msD.setBigVDimenSize(R.dimen.tbds57);
        this.msD.setAuthIconType(3);
        this.msD.setShowSimpleIcon(false);
        this.msD.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.msI = this.mRootView.findViewById(R.id.person_header_ring);
        this.msI.setAlpha(0.33f);
        this.msF = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.msF.setPageContext(this.mPageContext);
        this.msF.setPageUniqueId(this.mPageContext.getUniqueId());
        this.msF.setRefreshListener(this.mta);
        this.msQ = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.msQ.a(this.lkQ);
        this.msJ = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.msK = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.msL = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.msM = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.msK.setOnClickListener(this.mClickListener);
        this.msN = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.msO = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.msP = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.msN.setOnClickListener(this.mClickListener);
        this.msG = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.msH = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.msE = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Lo() {
        this.msU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.msU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.msS;
                ViewGroup.LayoutParams layoutParams = b.this.msF.getLayoutParams();
                if (b.this.msR) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.msS - floatValue);
                }
                if (b.this.msX != null) {
                    b.this.msX.DD(b.this.msR ? (int) floatValue : (int) (-floatValue));
                }
                b.this.msF.setLayoutParams(layoutParams);
                b.this.msF.onChangeSkinType();
            }
        });
        this.msU.setDuration(260L);
        this.msU.setInterpolator(new LinearInterpolator());
        this.msV = ObjectAnimator.ofFloat(this.msF, "alpha", 0.0f);
        this.msV.setDuration(240L);
        this.msV.setInterpolator(new LinearInterpolator());
        this.msW = ObjectAnimator.ofFloat(this.msz.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.msW.setDuration(100L);
        this.msT = new AnimatorSet();
        this.msT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.msF.getLayoutParams();
                if (b.this.msR) {
                    layoutParams.height = b.msS;
                } else {
                    layoutParams.height = 0;
                }
                b.this.msF.setLayoutParams(layoutParams);
                if (b.this.msX != null) {
                    b.this.msX.hC(b.this.msR);
                }
            }
        });
        this.msT.play(this.msU).with(this.msV).with(this.msW);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            this.mrv = bVar;
            if (!au.isEmpty(this.mUserData.getName_show())) {
                this.eBQ.setText(this.mUserData.getName_show());
            }
            this.msk.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (this.mUserData.isNewGod() && !au.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + ah.lf(this.mUserData.getNewGodData().isVideoGod()));
            } else if (this.mUserData.showBazhuGrade()) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, au.cutChineseAndEnglishWithSuffix(this.mUserData.getBazhuGradeData().getDesc(), 32, StringHelper.STRING_MORE));
            } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else {
                intro = this.mUserData.getIntro();
                if (!au.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!au.isEmpty(intro)) {
                this.msk.setVisibility(0);
                this.msk.setText(intro);
                this.msk.setEnabled(true);
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.msk.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.msk.setEnabled(false);
                                } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.msk.setEnabled(false);
                                }
                                b.this.msl.setVisibility(8);
                                return;
                            }
                            b.this.msl.setVisibility(0);
                        }
                    }
                });
            } else {
                this.msk.setVisibility(8);
            }
            this.msn.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.msp.setText(au.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.msv.setText(au.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mss.setText(au.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.msz.setVisibility(8);
                this.msA.setVisibility(8);
            } else {
                this.msA.setVisibility(0);
                this.msz.setVisibility(0);
                this.msz.setShowPullBtn(userData.isNewGod());
                this.msz.setFirstUpdate(true);
                wF(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.msB.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.msB.setVisibility(0);
            } else if (this.mIsHost) {
                this.msB.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.msB.setVisibility(0);
            } else {
                this.msB.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.btW().a(this.msC, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.msC.setVisibility(8);
            } else {
                this.msC.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.msH.setVisibility(0);
                this.msH.loop(true);
                this.msH.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.msH.playAnimation();
                    }
                });
                this.msI.setVisibility(8);
                dP(this.msE);
                this.msG.setVisibility(0);
                this.msD.setIsclearmode(true);
                this.msD.Cx(this.mUserData.getAvater());
            } else {
                this.msD.a(this.mUserData);
                this.msG.setVisibility(8);
                this.msD.setIsclearmode(false);
                this.msI.setVisibility(0);
            }
            if (this.mrv != null && this.mrv.cMY() && !TextUtils.isEmpty(this.mrv.goods_url)) {
                this.msK.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ar("c13612").dY("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new ar("c13612").dY("obj_param1", "1"));
                }
            } else {
                this.msK.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.msO.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.msN.setVisibility(0);
            } else {
                this.msN.setVisibility(8);
            }
            if (this.msK.getVisibility() == 0 || this.msN.getVisibility() == 0) {
                this.msJ.setVisibility(0);
            } else {
                this.msJ.setVisibility(8);
            }
        }
    }

    private void dP(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f);
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f);
        ofFloat2.setDuration(500);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.hsD = new AnimatorSet();
        this.hsD.play(ofFloat).with(ofFloat2);
        this.hsD.start();
    }

    public void dAB() {
        if (this.msV != null) {
            if (this.msR) {
                this.msV.setFloatValues(0.0f, 1.0f);
            } else {
                this.msV.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.msW != null) {
            if (this.msR) {
                this.msW.setFloatValues(0.0f, 180.0f);
            } else {
                this.msW.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dAC() {
        if (this.msT != null) {
            this.msT.start();
        }
    }

    public void wE(boolean z) {
        this.msR = z;
    }

    public void Rk(String str) {
        this.msD.Cw(str);
    }

    public void wF(boolean z) {
        this.msz.aP(z);
    }

    public void wG(boolean z) {
        if (z) {
            this.msm.setVisibility(0);
        } else {
            this.msm.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.btW().a(this.msx, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.kIE, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.msy, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.msA.bvt();
        this.msz.onChangeSkinType(i);
        SvgManager.btW().a(this.msl, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.msG.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.btW().a(this.msM, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.msP, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msk, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msp, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msq, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mss, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mst, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msv, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msw, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msL, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msO, R.color.CAM_X0101, 1, i);
        ap.setImageResource(this.msm, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.msI, R.drawable.person_header_bg, i);
        this.msF.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.btW().a(this.msC, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.msH != null) {
                this.msH.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.msG != null) {
                this.msG.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.msH != null) {
                this.msH.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.msG != null) {
                this.msG.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.msH != null) {
                this.msH.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.msG != null) {
                this.msG.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dAD() {
        return this.msB;
    }

    public FollowUserSpinnerBtn dAE() {
        return this.msz;
    }

    public View dAF() {
        return this.msA;
    }

    public TextView getUserName() {
        return this.eBQ;
    }

    public TextView dAG() {
        return this.msk;
    }

    public UserIconBox dAH() {
        return this.msn;
    }

    public FrameLayout dAI() {
        return this.mso;
    }

    public FrameLayout dAJ() {
        return this.msr;
    }

    public FrameLayout dAK() {
        return this.msu;
    }

    public HeadPendantView dAL() {
        return this.msD;
    }

    public View dAM() {
        return this.msK;
    }

    public View dAN() {
        return this.msN;
    }

    public ImageView dAO() {
        return this.msl;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.msX = aVar;
    }

    public void onDestroy() {
        if (this.hsD != null) {
            this.hsD.cancel();
        }
        if (this.msH != null) {
            this.msH.cancelAnimation();
        }
        if (this.msT != null) {
            this.msT.cancel();
        }
        if (this.msQ != null) {
            this.msQ.onDestory();
        }
    }
}
