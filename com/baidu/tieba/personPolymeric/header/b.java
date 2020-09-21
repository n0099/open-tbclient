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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.d;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.c;
import com.baidu.tieba.personPolymeric.c.q;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.tieba.view.GodRecommendLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes23.dex */
public class b {
    public static final int lwG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView dWe;
    private AnimatorSet gDv;
    private ImageView jNf;
    private boolean kpz;
    private com.baidu.tieba.i.b lvo;
    private View lwA;
    private View lwB;
    private TextView lwC;
    private ImageView lwD;
    private com.baidu.tieba.model.c lwE;
    private boolean lwF;
    private AnimatorSet lwH;
    private ValueAnimator lwI;
    private ObjectAnimator lwJ;
    private ObjectAnimator lwK;
    private com.baidu.tieba.personPolymeric.b.a lwL;
    private boolean lwM;
    private TextView lwc;
    private ImageView lwd;
    private ImageView lwe;
    private UserIconBox lwf;
    private FrameLayout lwg;
    private TextView lwh;
    private TextView lwi;
    private FrameLayout lwj;
    private TextView lwk;
    private TextView lwl;
    private FrameLayout lwm;
    private TextView lwn;
    private TextView lwo;
    private ImageView lwp;
    private ImageView lwq;
    private FollowUserSpinnerBtn lwr;
    private TBSpecificationBtn lws;
    private TbImageView lwt;
    private ImageView lwu;
    private HeadPendantView lwv;
    private RelativeLayout lww;
    private GodRecommendLayout lwx;
    private ImageView lwy;
    private TBLottieAnimationView lwz;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a lwN = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void au(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.lwM = z2;
                b.this.kpz = false;
                if (z) {
                    b.this.lwx.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.lwE.br(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.lwx.setCouldStatistic(false);
                    b.this.lwF = false;
                    b.this.dmp();
                    if (b.this.lwH != null) {
                        b.this.lwH.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a kpy = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.lwx.setData(qVar.dmo());
                if (!b.this.kpz) {
                    b.this.lwF = true;
                    b.this.dmp();
                    if (b.this.lwH != null) {
                        b.this.lwH.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").ai("obj_type", b.this.lwM ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).big();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).big();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).big();
            }
        }
    };
    private View.OnClickListener lwO = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.lwE != null && b.this.mUserData != null) {
                b.this.kpz = true;
                b.this.lwE.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Ig();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.dWe = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.dWe.setOnClickListener(this.mClickListener);
        this.lwc = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.lwc.setAlpha(0.85f);
        this.lwc.setOnClickListener(this.mClickListener);
        this.lwd = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.lwd.setOnClickListener(this.mClickListener);
        this.lwf = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.lwf.setOnClickListener(this.mClickListener);
        this.lwf.setAutoChangedStyle(false);
        this.lwh = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.lwg = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.lwg.setOnClickListener(this.mClickListener);
        this.lwi = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.lwi.setAlpha(0.8f);
        this.jNf = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.lwe = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.lwk = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.lwj = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.lwj.setOnClickListener(this.mClickListener);
        this.lwl = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.lwl.setAlpha(0.8f);
        this.lwq = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.lwn = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.lwm = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.lwm.setOnClickListener(this.mClickListener);
        this.lwo = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.lwo.setAlpha(0.8f);
        this.lwp = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.lwr = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.lwr.g(this.mClickListener);
        this.lwr.setOpenListener(this.lwN);
        this.lws = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.lws.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pt(R.color.cp_cont_a);
        dVar.pj(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.lws.setConfig(dVar);
        this.lwt = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.lwt.setOnClickListener(this.mClickListener);
        this.lwu = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.lwv = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.lwv.setHasPendantStyle();
        this.lwv.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.lwv.getHeadView().setIsRound(true);
        this.lwv.getHeadView().setDrawBorder(false);
        this.lwv.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lwv.setOnClickListener(this.mClickListener);
        this.lwv.setBigVDimenSize(R.dimen.tbds57);
        this.lwv.setAuthIconType(3);
        this.lwv.setShowSimpleIcon(false);
        this.lwv.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.lwA = this.mRootView.findViewById(R.id.person_header_ring);
        this.lwA.setAlpha(0.33f);
        this.lwx = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.lwx.setPageContext(this.mPageContext);
        this.lwx.setPageUniqueId(this.mPageContext.getUniqueId());
        this.lwx.setRefreshListener(this.lwO);
        this.lwE = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.lwE.a(this.kpy);
        this.lwB = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.lwC = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.lwD = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.lwB.setOnClickListener(this.mClickListener);
        this.lwy = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.lwz = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.lww = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Ig() {
        this.lwI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lwI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.lwG;
                ViewGroup.LayoutParams layoutParams = b.this.lwx.getLayoutParams();
                if (b.this.lwF) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.lwG - floatValue);
                }
                if (b.this.lwL != null) {
                    b.this.lwL.Be(b.this.lwF ? (int) floatValue : (int) (-floatValue));
                }
                b.this.lwx.setLayoutParams(layoutParams);
                b.this.lwx.onChangeSkinType();
            }
        });
        this.lwI.setDuration(260L);
        this.lwI.setInterpolator(new LinearInterpolator());
        this.lwJ = ObjectAnimator.ofFloat(this.lwx, "alpha", 0.0f);
        this.lwJ.setDuration(240L);
        this.lwJ.setInterpolator(new LinearInterpolator());
        this.lwK = ObjectAnimator.ofFloat(this.lwr.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.lwK.setDuration(100L);
        this.lwH = new AnimatorSet();
        this.lwH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.lwx.getLayoutParams();
                if (b.this.lwF) {
                    layoutParams.height = b.lwG;
                } else {
                    layoutParams.height = 0;
                }
                b.this.lwx.setLayoutParams(layoutParams);
                if (b.this.lwL != null) {
                    b.this.lwL.gs(b.this.lwF);
                }
            }
        });
        this.lwH.play(this.lwI).with(this.lwJ).with(this.lwK);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.b bVar) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            this.lvo = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.dWe.setText(this.mUserData.getName_show());
            }
            this.lwc.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (this.mUserData.isNewGod() && !at.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + this.mPageContext.getResources().getString(R.string.field_new_god));
            } else if (this.mUserData.showBazhuGrade()) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, at.cutChineseAndEnglishWithSuffix(this.mUserData.getBazhuGradeData().getDesc(), 32, StringHelper.STRING_MORE));
            } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else {
                intro = this.mUserData.getIntro();
                if (!at.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!at.isEmpty(intro)) {
                this.lwc.setVisibility(0);
                this.lwc.setText(intro);
                this.lwc.setEnabled(true);
                e.mX().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.lwc.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.lwc.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.lwc.setEnabled(false);
                                }
                                b.this.lwd.setVisibility(8);
                                return;
                            }
                            b.this.lwd.setVisibility(0);
                        }
                    }
                });
            } else {
                this.lwc.setVisibility(8);
            }
            this.lwf.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.lwh.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.lwn.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.lwk.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.lwr.setVisibility(8);
                this.lws.setVisibility(8);
            } else {
                this.lws.setVisibility(0);
                this.lwr.setVisibility(0);
                this.lwr.setShowPullBtn(userData.isNewGod());
                this.lwr.setFirstUpdate(true);
                uR(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.lwt.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.lwt.setVisibility(0);
            } else if (this.mIsHost) {
                this.lwt.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.lwt.setVisibility(0);
            } else {
                this.lwt.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bkl().a(this.lwu, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.lwu.setVisibility(8);
            } else {
                this.lwu.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.lwz.setVisibility(0);
                this.lwz.loop(true);
                this.lwz.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lwz.playAnimation();
                    }
                });
                this.lwA.setVisibility(8);
                dn(this.lww);
                this.lwy.setVisibility(0);
                this.lwv.setIsclearmode(true);
                this.lwv.AX(this.mUserData.getAvater());
            } else {
                this.lwv.a(this.mUserData);
                this.lwy.setVisibility(8);
                this.lwv.setIsclearmode(false);
                this.lwA.setVisibility(0);
            }
            if (this.lvo != null && this.lvo.cyY() && !TextUtils.isEmpty(this.lvo.goods_url)) {
                this.lwB.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dF("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new aq("c13612").dF("obj_param1", "1"));
                    return;
                }
            }
            this.lwB.setVisibility(8);
        }
    }

    private void dn(View view) {
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
        this.gDv = new AnimatorSet();
        this.gDv.play(ofFloat).with(ofFloat2);
        this.gDv.start();
    }

    public void dmp() {
        if (this.lwJ != null) {
            if (this.lwF) {
                this.lwJ.setFloatValues(0.0f, 1.0f);
            } else {
                this.lwJ.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.lwK != null) {
            if (this.lwF) {
                this.lwK.setFloatValues(0.0f, 180.0f);
            } else {
                this.lwK.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dmq() {
        if (this.lwH != null) {
            this.lwH.start();
        }
    }

    public void uQ(boolean z) {
        this.lwF = z;
    }

    public void Pc(String str) {
        this.lwv.AW(str);
    }

    public void uR(boolean z) {
        this.lwr.aN(z);
    }

    public void uS(boolean z) {
        if (z) {
            this.lwe.setVisibility(0);
        } else {
            this.lwe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bkl().a(this.lwp, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a(this.jNf, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a(this.lwq, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lws.blA();
        this.lwr.onChangeSkinType(i);
        SvgManager.bkl().a(this.lwd, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lwy.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bkl().a(this.lwD, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.dWe, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwc, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwh, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwi, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwk, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwl, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwn, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwo, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lwC, R.color.cp_cont_a, 1, i);
        ap.setImageResource(this.lwe, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.lwA, R.drawable.person_header_bg, i);
        this.lwx.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bkl().a(this.lwu, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.lwz != null) {
                this.lwz.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.lwy != null) {
                this.lwy.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.lwz != null) {
                this.lwz.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.lwy != null) {
                this.lwy.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.lwz != null) {
                this.lwz.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.lwy != null) {
                this.lwy.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dmr() {
        return this.lwt;
    }

    public FollowUserSpinnerBtn dms() {
        return this.lwr;
    }

    public View dmt() {
        return this.lws;
    }

    public TextView getUserName() {
        return this.dWe;
    }

    public TextView dmu() {
        return this.lwc;
    }

    public UserIconBox dmv() {
        return this.lwf;
    }

    public FrameLayout dmw() {
        return this.lwg;
    }

    public FrameLayout dmx() {
        return this.lwj;
    }

    public FrameLayout dmy() {
        return this.lwm;
    }

    public HeadPendantView dmz() {
        return this.lwv;
    }

    public View dmA() {
        return this.lwB;
    }

    public ImageView dmB() {
        return this.lwd;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lwL = aVar;
    }

    public void onDestroy() {
        if (this.gDv != null) {
            this.gDv.cancel();
        }
        if (this.lwz != null) {
            this.lwz.cancelAnimation();
        }
        if (this.lwH != null) {
            this.lwH.cancel();
        }
        if (this.lwE != null) {
            this.lwE.onDestory();
        }
    }
}
