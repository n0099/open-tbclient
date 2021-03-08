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
import com.baidu.tbadk.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.c;
import com.baidu.tieba.personPolymeric.c.q;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.tieba.view.GodRecommendLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes7.dex */
public class b {
    public static final int mEV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eKp;
    private AnimatorSet hFZ;
    private ImageView kTB;
    private boolean lwo;
    private View.OnClickListener mClickListener;
    private com.baidu.tieba.j.b mDz;
    private ImageView mEA;
    private ImageView mEB;
    private FollowUserSpinnerBtn mEC;
    private TBSpecificationBtn mED;
    private TbImageView mEE;
    private ImageView mEF;
    private HeadPendantView mEG;
    private RelativeLayout mEH;
    private GodRecommendLayout mEI;
    private ImageView mEJ;
    private TBLottieAnimationView mEK;
    private View mEL;
    private ViewGroup mEM;
    private View mEN;
    private TextView mEO;
    private ImageView mEP;
    private View mEQ;
    private TextView mER;
    private ImageView mES;
    private com.baidu.tieba.model.c mET;
    private boolean mEU;
    private AnimatorSet mEW;
    private ValueAnimator mEX;
    private ObjectAnimator mEY;
    private ObjectAnimator mEZ;
    private TextView mEn;
    private ImageView mEo;
    private ImageView mEp;
    private UserIconBox mEq;
    private FrameLayout mEr;
    private TextView mEs;
    private TextView mEt;
    private FrameLayout mEu;
    private TextView mEv;
    private TextView mEw;
    private FrameLayout mEx;
    private TextView mEy;
    private TextView mEz;
    private com.baidu.tieba.personPolymeric.b.a mFa;
    private boolean mFb;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a mFc = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void av(boolean z, boolean z2) {
            if (bh.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.mFb = z2;
                b.this.lwo = false;
                if (z) {
                    b.this.mEI.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.mET.bD(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mEI.setCouldStatistic(false);
                    b.this.mEU = false;
                    b.this.dyY();
                    if (b.this.mEW != null) {
                        b.this.mEW.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new ar("c13900"));
                }
            }
        }
    };
    private c.a lwn = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mEI.setData(qVar.dyX());
                if (!b.this.lwo) {
                    b.this.mEU = true;
                    b.this.dyY();
                    if (b.this.mEW != null) {
                        b.this.mEW.start();
                    }
                }
                TiebaStatic.log(new ar("c13901").aq("obj_type", b.this.mFb ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqF();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bqF();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bqF();
            }
        }
    };
    private View.OnClickListener mFd = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.mET != null && b.this.mUserData != null) {
                b.this.lwo = true;
                b.this.mET.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new ar("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Il();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eKp = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eKp.setOnClickListener(this.mClickListener);
        this.mEn = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.mEn.setAlpha(0.85f);
        this.mEn.setOnClickListener(this.mClickListener);
        this.mEo = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mEo.setOnClickListener(this.mClickListener);
        this.mEq = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mEq.setOnClickListener(this.mClickListener);
        this.mEq.setAutoChangedStyle(false);
        this.mEs = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mEr = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mEr.setOnClickListener(this.mClickListener);
        this.mEt = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mEt.setAlpha(0.8f);
        this.kTB = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.mEp = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mEv = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mEu = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mEu.setOnClickListener(this.mClickListener);
        this.mEw = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mEw.setAlpha(0.8f);
        this.mEB = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mEy = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mEx = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mEx.setOnClickListener(this.mClickListener);
        this.mEz = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mEz.setAlpha(0.8f);
        this.mEA = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mEC = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mEC.i(this.mClickListener);
        this.mEC.setOpenListener(this.mFc);
        this.mED = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mED.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pW(R.color.CAM_X0101);
        dVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mED.setConfig(dVar);
        this.mEE = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mEE.setOnClickListener(this.mClickListener);
        this.mEF = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mEG = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mEG.setHasPendantStyle();
        this.mEG.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mEG.getHeadView().setIsRound(true);
        this.mEG.getHeadView().setDrawBorder(false);
        this.mEG.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mEG.setOnClickListener(this.mClickListener);
        this.mEG.setBigVDimenSize(R.dimen.tbds57);
        this.mEG.setAuthIconType(3);
        this.mEG.setShowSimpleIcon(false);
        this.mEG.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.mEL = this.mRootView.findViewById(R.id.person_header_ring);
        this.mEL.setAlpha(0.33f);
        this.mEI = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mEI.setPageContext(this.mPageContext);
        this.mEI.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mEI.setRefreshListener(this.mFd);
        this.mET = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.mET.a(this.lwn);
        this.mEM = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mEN = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mEO = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mEP = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mEN.setOnClickListener(this.mClickListener);
        this.mEQ = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.mER = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.mES = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.mEQ.setOnClickListener(this.mClickListener);
        this.mEJ = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mEK = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mEH = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Il() {
        this.mEX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mEX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.mEV;
                ViewGroup.LayoutParams layoutParams = b.this.mEI.getLayoutParams();
                if (b.this.mEU) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.mEV - floatValue);
                }
                if (b.this.mFa != null) {
                    b.this.mFa.CF(b.this.mEU ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mEI.setLayoutParams(layoutParams);
                b.this.mEI.onChangeSkinType();
            }
        });
        this.mEX.setDuration(260L);
        this.mEX.setInterpolator(new LinearInterpolator());
        this.mEY = ObjectAnimator.ofFloat(this.mEI, "alpha", 0.0f);
        this.mEY.setDuration(240L);
        this.mEY.setInterpolator(new LinearInterpolator());
        this.mEZ = ObjectAnimator.ofFloat(this.mEC.getArrow(), "rotation", 0.0f);
        this.mEZ.setDuration(100L);
        this.mEW = new AnimatorSet();
        this.mEW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mEI.getLayoutParams();
                if (b.this.mEU) {
                    layoutParams.height = b.mEV;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mEI.setLayoutParams(layoutParams);
                if (b.this.mFa != null) {
                    b.this.mFa.hS(b.this.mEU);
                }
            }
        });
        this.mEW.play(this.mEX).with(this.mEY).with(this.mEZ);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mDz = bVar;
            if (!au.isEmpty(this.mUserData.getName_show())) {
                this.eKp.setText(this.mUserData.getName_show());
            }
            this.mEn.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (this.mUserData.isNewGod() && !au.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + aj.lA(this.mUserData.getNewGodData().isVideoGod()));
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
                this.mEn.setVisibility(0);
                this.mEn.setText(intro);
                this.mEn.setEnabled(true);
                e.mA().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.mEn.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.mEn.setEnabled(false);
                                } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.mEn.setEnabled(false);
                                }
                                b.this.mEo.setVisibility(8);
                                return;
                            }
                            b.this.mEo.setVisibility(0);
                        }
                    }
                });
            } else {
                this.mEn.setVisibility(8);
            }
            this.mEq.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.mEs.setText(au.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mEy.setText(au.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mEv.setText(au.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mEC.setVisibility(8);
                this.mED.setVisibility(8);
            } else {
                this.mED.setVisibility(0);
                this.mEC.setVisibility(0);
                this.mEC.setShowPullBtn(userData.isNewGod());
                this.mEC.setFirstUpdate(true);
                wT(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mEE.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mEE.setVisibility(0);
            } else if (this.mIsHost) {
                this.mEE.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.mEE.setVisibility(0);
            } else {
                this.mEE.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bsU().a(this.mEF, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.mEF.setVisibility(8);
            } else {
                this.mEF.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mEK.setVisibility(0);
                this.mEK.loop(true);
                this.mEK.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mEK.playAnimation();
                    }
                });
                this.mEL.setVisibility(8);
                dX(this.mEH);
                this.mEJ.setVisibility(0);
                this.mEG.setIsclearmode(true);
                this.mEG.BH(this.mUserData.getAvater());
            } else {
                this.mEG.a(this.mUserData);
                this.mEJ.setVisibility(8);
                this.mEG.setIsclearmode(false);
                this.mEL.setVisibility(0);
            }
            if (this.mDz != null && this.mDz.cOF() && !TextUtils.isEmpty(this.mDz.goods_url)) {
                this.mEN.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "1"));
                }
            } else {
                this.mEN.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.mER.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.mEQ.setVisibility(0);
            } else {
                this.mEQ.setVisibility(8);
            }
            if (this.mEN.getVisibility() == 0 || this.mEQ.getVisibility() == 0) {
                this.mEM.setVisibility(0);
            } else {
                this.mEM.setVisibility(8);
            }
        }
    }

    private void dX(View view) {
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
        this.hFZ = new AnimatorSet();
        this.hFZ.play(ofFloat).with(ofFloat2);
        this.hFZ.start();
    }

    public void dyY() {
        if (this.mEY != null) {
            if (this.mEU) {
                this.mEY.setFloatValues(0.0f, 1.0f);
            } else {
                this.mEY.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.mEZ != null) {
            if (this.mEU) {
                this.mEZ.setFloatValues(0.0f, 180.0f);
            } else {
                this.mEZ.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dyZ() {
        if (this.mEW != null) {
            this.mEW.start();
        }
    }

    public void wS(boolean z) {
        this.mEU = z;
    }

    public void QG(String str) {
        this.mEG.BG(str);
    }

    public void wT(boolean z) {
        this.mEC.aM(z);
    }

    public void wU(boolean z) {
        if (z) {
            this.mEp.setVisibility(0);
        } else {
            this.mEp.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsU().a(this.mEA, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a(this.kTB, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a(this.mEB, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mED.bus();
        this.mEC.onChangeSkinType(i);
        SvgManager.bsU().a(this.mEo, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mEJ.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bsU().a(this.mEP, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a(this.mES, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eKp, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEn, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEs, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEt, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEv, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEw, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEy, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEz, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mEO, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mER, R.color.CAM_X0101, 1, i);
        ap.setImageResource(this.mEp, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.mEL, R.drawable.person_header_bg, i);
        this.mEI.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bsU().a(this.mEF, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mEK != null) {
                this.mEK.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mEJ != null) {
                this.mEJ.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mEK != null) {
                this.mEK.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mEJ != null) {
                this.mEJ.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mEK != null) {
                this.mEK.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mEJ != null) {
                this.mEJ.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dza() {
        return this.mEE;
    }

    public FollowUserSpinnerBtn dzb() {
        return this.mEC;
    }

    public View dzc() {
        return this.mED;
    }

    public TextView getUserName() {
        return this.eKp;
    }

    public TextView dzd() {
        return this.mEn;
    }

    public UserIconBox dze() {
        return this.mEq;
    }

    public FrameLayout dzf() {
        return this.mEr;
    }

    public FrameLayout dzg() {
        return this.mEu;
    }

    public FrameLayout dzh() {
        return this.mEx;
    }

    public HeadPendantView dzi() {
        return this.mEG;
    }

    public View dzj() {
        return this.mEN;
    }

    public View dzk() {
        return this.mEQ;
    }

    public ImageView dzl() {
        return this.mEo;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mFa = aVar;
    }

    public void onDestroy() {
        if (this.hFZ != null) {
            this.hFZ.cancel();
        }
        if (this.mEK != null) {
            this.mEK.cancelAnimation();
        }
        if (this.mEW != null) {
            this.mEW.cancel();
        }
        if (this.mET != null) {
            this.mET.onDestory();
        }
    }
}
