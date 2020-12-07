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
    public static final int msQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eBQ;
    private AnimatorSet hsB;
    private ImageView kIC;
    private boolean lkP;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private com.baidu.tieba.j.b mrt;
    private ImageView msA;
    private HeadPendantView msB;
    private RelativeLayout msC;
    private GodRecommendLayout msD;
    private ImageView msE;
    private TBLottieAnimationView msF;
    private View msG;
    private ViewGroup msH;
    private View msI;
    private TextView msJ;
    private ImageView msK;
    private View msL;
    private TextView msM;
    private ImageView msN;
    private com.baidu.tieba.model.c msO;
    private boolean msP;
    private AnimatorSet msR;
    private ValueAnimator msS;
    private ObjectAnimator msT;
    private ObjectAnimator msU;
    private com.baidu.tieba.personPolymeric.b.a msV;
    private boolean msW;
    private TextView msi;
    private ImageView msj;
    private ImageView msk;
    private UserIconBox msl;
    private FrameLayout msm;
    private TextView msn;
    private TextView mso;
    private FrameLayout msp;
    private TextView msq;
    private TextView msr;
    private FrameLayout mss;
    private TextView mst;
    private TextView msu;
    private ImageView msv;
    private ImageView msw;
    private FollowUserSpinnerBtn msx;
    private TBSpecificationBtn msy;
    private TbImageView msz;
    private FollowUserSpinnerBtn.a msX = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void at(boolean z, boolean z2) {
            if (bh.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.msW = z2;
                b.this.lkP = false;
                if (z) {
                    b.this.msD.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.msO.bv(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.msD.setCouldStatistic(false);
                    b.this.msP = false;
                    b.this.dAA();
                    if (b.this.msR != null) {
                        b.this.msR.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new ar("c13900"));
                }
            }
        }
    };
    private c.a lkO = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.msD.setData(qVar.dAz());
                if (!b.this.lkP) {
                    b.this.msP = true;
                    b.this.dAA();
                    if (b.this.msR != null) {
                        b.this.msR.start();
                    }
                }
                TiebaStatic.log(new ar("c13901").al("obj_type", b.this.msW ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).brB();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).brB();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).brB();
            }
        }
    };
    private View.OnClickListener msY = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.msO != null && b.this.mUserData != null) {
                b.this.lkP = true;
                b.this.msO.request(b.this.mUserData.getPortrait());
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
        this.msi = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.msi.setAlpha(0.85f);
        this.msi.setOnClickListener(this.mClickListener);
        this.msj = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.msj.setOnClickListener(this.mClickListener);
        this.msl = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.msl.setOnClickListener(this.mClickListener);
        this.msl.setAutoChangedStyle(false);
        this.msn = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.msm = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.msm.setOnClickListener(this.mClickListener);
        this.mso = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mso.setAlpha(0.8f);
        this.kIC = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.msk = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.msq = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.msp = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.msp.setOnClickListener(this.mClickListener);
        this.msr = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.msr.setAlpha(0.8f);
        this.msw = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mst = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mss = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mss.setOnClickListener(this.mClickListener);
        this.msu = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.msu.setAlpha(0.8f);
        this.msv = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.msx = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.msx.h(this.mClickListener);
        this.msx.setOpenListener(this.msX);
        this.msy = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.msy.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.rl(R.color.CAM_X0101);
        dVar.rc(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.msy.setConfig(dVar);
        this.msz = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.msz.setOnClickListener(this.mClickListener);
        this.msA = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.msB = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.msB.setHasPendantStyle();
        this.msB.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.msB.getHeadView().setIsRound(true);
        this.msB.getHeadView().setDrawBorder(false);
        this.msB.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.msB.setOnClickListener(this.mClickListener);
        this.msB.setBigVDimenSize(R.dimen.tbds57);
        this.msB.setAuthIconType(3);
        this.msB.setShowSimpleIcon(false);
        this.msB.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.msG = this.mRootView.findViewById(R.id.person_header_ring);
        this.msG.setAlpha(0.33f);
        this.msD = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.msD.setPageContext(this.mPageContext);
        this.msD.setPageUniqueId(this.mPageContext.getUniqueId());
        this.msD.setRefreshListener(this.msY);
        this.msO = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.msO.a(this.lkO);
        this.msH = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.msI = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.msJ = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.msK = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.msI.setOnClickListener(this.mClickListener);
        this.msL = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.msM = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.msN = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.msL.setOnClickListener(this.mClickListener);
        this.msE = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.msF = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.msC = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Lo() {
        this.msS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.msS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.msQ;
                ViewGroup.LayoutParams layoutParams = b.this.msD.getLayoutParams();
                if (b.this.msP) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.msQ - floatValue);
                }
                if (b.this.msV != null) {
                    b.this.msV.DD(b.this.msP ? (int) floatValue : (int) (-floatValue));
                }
                b.this.msD.setLayoutParams(layoutParams);
                b.this.msD.onChangeSkinType();
            }
        });
        this.msS.setDuration(260L);
        this.msS.setInterpolator(new LinearInterpolator());
        this.msT = ObjectAnimator.ofFloat(this.msD, "alpha", 0.0f);
        this.msT.setDuration(240L);
        this.msT.setInterpolator(new LinearInterpolator());
        this.msU = ObjectAnimator.ofFloat(this.msx.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.msU.setDuration(100L);
        this.msR = new AnimatorSet();
        this.msR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.msD.getLayoutParams();
                if (b.this.msP) {
                    layoutParams.height = b.msQ;
                } else {
                    layoutParams.height = 0;
                }
                b.this.msD.setLayoutParams(layoutParams);
                if (b.this.msV != null) {
                    b.this.msV.hC(b.this.msP);
                }
            }
        });
        this.msR.play(this.msS).with(this.msT).with(this.msU);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mrt = bVar;
            if (!au.isEmpty(this.mUserData.getName_show())) {
                this.eBQ.setText(this.mUserData.getName_show());
            }
            this.msi.setVisibility(0);
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
                this.msi.setVisibility(0);
                this.msi.setText(intro);
                this.msi.setEnabled(true);
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.msi.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.msi.setEnabled(false);
                                } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.msi.setEnabled(false);
                                }
                                b.this.msj.setVisibility(8);
                                return;
                            }
                            b.this.msj.setVisibility(0);
                        }
                    }
                });
            } else {
                this.msi.setVisibility(8);
            }
            this.msl.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.msn.setText(au.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mst.setText(au.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.msq.setText(au.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.msx.setVisibility(8);
                this.msy.setVisibility(8);
            } else {
                this.msy.setVisibility(0);
                this.msx.setVisibility(0);
                this.msx.setShowPullBtn(userData.isNewGod());
                this.msx.setFirstUpdate(true);
                wF(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.msz.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.msz.setVisibility(0);
            } else if (this.mIsHost) {
                this.msz.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.msz.setVisibility(0);
            } else {
                this.msz.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.btW().a(this.msA, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.msA.setVisibility(8);
            } else {
                this.msA.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.msF.setVisibility(0);
                this.msF.loop(true);
                this.msF.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.msF.playAnimation();
                    }
                });
                this.msG.setVisibility(8);
                dP(this.msC);
                this.msE.setVisibility(0);
                this.msB.setIsclearmode(true);
                this.msB.Cx(this.mUserData.getAvater());
            } else {
                this.msB.a(this.mUserData);
                this.msE.setVisibility(8);
                this.msB.setIsclearmode(false);
                this.msG.setVisibility(0);
            }
            if (this.mrt != null && this.mrt.cMX() && !TextUtils.isEmpty(this.mrt.goods_url)) {
                this.msI.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ar("c13612").dY("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new ar("c13612").dY("obj_param1", "1"));
                }
            } else {
                this.msI.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.msM.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.msL.setVisibility(0);
            } else {
                this.msL.setVisibility(8);
            }
            if (this.msI.getVisibility() == 0 || this.msL.getVisibility() == 0) {
                this.msH.setVisibility(0);
            } else {
                this.msH.setVisibility(8);
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
        this.hsB = new AnimatorSet();
        this.hsB.play(ofFloat).with(ofFloat2);
        this.hsB.start();
    }

    public void dAA() {
        if (this.msT != null) {
            if (this.msP) {
                this.msT.setFloatValues(0.0f, 1.0f);
            } else {
                this.msT.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.msU != null) {
            if (this.msP) {
                this.msU.setFloatValues(0.0f, 180.0f);
            } else {
                this.msU.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dAB() {
        if (this.msR != null) {
            this.msR.start();
        }
    }

    public void wE(boolean z) {
        this.msP = z;
    }

    public void Rk(String str) {
        this.msB.Cw(str);
    }

    public void wF(boolean z) {
        this.msx.aP(z);
    }

    public void wG(boolean z) {
        if (z) {
            this.msk.setVisibility(0);
        } else {
            this.msk.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.btW().a(this.msv, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.kIC, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.msw, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.msy.bvt();
        this.msx.onChangeSkinType(i);
        SvgManager.btW().a(this.msj, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.msE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.btW().a(this.msK, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.msN, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msi, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msn, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mso, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msq, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msr, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mst, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msu, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msJ, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.msM, R.color.CAM_X0101, 1, i);
        ap.setImageResource(this.msk, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.msG, R.drawable.person_header_bg, i);
        this.msD.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.btW().a(this.msA, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.msF != null) {
                this.msF.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.msE != null) {
                this.msE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.msF != null) {
                this.msF.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.msE != null) {
                this.msE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.msF != null) {
                this.msF.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.msE != null) {
                this.msE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dAC() {
        return this.msz;
    }

    public FollowUserSpinnerBtn dAD() {
        return this.msx;
    }

    public View dAE() {
        return this.msy;
    }

    public TextView getUserName() {
        return this.eBQ;
    }

    public TextView dAF() {
        return this.msi;
    }

    public UserIconBox dAG() {
        return this.msl;
    }

    public FrameLayout dAH() {
        return this.msm;
    }

    public FrameLayout dAI() {
        return this.msp;
    }

    public FrameLayout dAJ() {
        return this.mss;
    }

    public HeadPendantView dAK() {
        return this.msB;
    }

    public View dAL() {
        return this.msI;
    }

    public View dAM() {
        return this.msL;
    }

    public ImageView dAN() {
        return this.msj;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.msV = aVar;
    }

    public void onDestroy() {
        if (this.hsB != null) {
            this.hsB.cancel();
        }
        if (this.msF != null) {
            this.msF.cancelAnimation();
        }
        if (this.msR != null) {
            this.msR.cancel();
        }
        if (this.msO != null) {
            this.msO.onDestory();
        }
    }
}
