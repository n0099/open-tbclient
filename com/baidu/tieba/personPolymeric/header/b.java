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
/* loaded from: classes18.dex */
public class b {
    public static final int lnK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView dTU;
    private AnimatorSet gAg;
    private ImageView jED;
    private com.baidu.tieba.i.b lmr;
    private RelativeLayout lnA;
    private GodRecommendLayout lnB;
    private ImageView lnC;
    private TBLottieAnimationView lnD;
    private View lnE;
    private View lnF;
    private TextView lnG;
    private ImageView lnH;
    private com.baidu.tieba.model.c lnI;
    private boolean lnJ;
    private AnimatorSet lnL;
    private ValueAnimator lnM;
    private ObjectAnimator lnN;
    private ObjectAnimator lnO;
    private com.baidu.tieba.personPolymeric.b.a lnP;
    private boolean lnQ;
    private TextView lnf;
    private ImageView lnh;
    private ImageView lni;
    private UserIconBox lnj;
    private FrameLayout lnk;
    private TextView lnl;
    private TextView lnm;
    private FrameLayout lnn;
    private TextView lno;
    private TextView lnp;
    private FrameLayout lnq;
    private TextView lnr;
    private TextView lns;
    private ImageView lnt;
    private ImageView lnu;
    private FollowUserSpinnerBtn lnv;
    private TBSpecificationBtn lnw;
    private TbImageView lnx;
    private ImageView lny;
    private HeadPendantView lnz;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a lnR = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void as(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.lnQ = z2;
                if (z) {
                    b.this.lnB.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.lnI.br(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.lnB.setCouldStatistic(false);
                    b.this.lnJ = false;
                    b.this.diK();
                    if (b.this.lnL != null) {
                        b.this.lnL.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a kgY = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.lnJ = true;
                b.this.lnB.setData(qVar.diJ());
                if (qVar.gcq == 1) {
                    b.this.diK();
                    if (b.this.lnL != null) {
                        b.this.lnL.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").ai("obj_type", b.this.lnQ ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bhm();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bhm();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bhm();
            }
        }
    };
    private View.OnClickListener lnS = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.lnI != null && b.this.mUserData != null) {
                b.this.lnI.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        HE();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.dTU = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.dTU.setOnClickListener(this.mClickListener);
        this.lnf = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.lnf.setAlpha(0.85f);
        this.lnf.setOnClickListener(this.mClickListener);
        this.lnh = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.lnh.setOnClickListener(this.mClickListener);
        this.lnj = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.lnj.setOnClickListener(this.mClickListener);
        this.lnj.setAutoChangedStyle(false);
        this.lnl = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.lnk = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.lnk.setOnClickListener(this.mClickListener);
        this.lnm = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.lnm.setAlpha(0.8f);
        this.jED = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.lni = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.lno = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.lnn = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.lnn.setOnClickListener(this.mClickListener);
        this.lnp = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.lnp.setAlpha(0.8f);
        this.lnu = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.lnr = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.lnq = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.lnq.setOnClickListener(this.mClickListener);
        this.lns = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.lns.setAlpha(0.8f);
        this.lnt = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.lnv = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.lnv.g(this.mClickListener);
        this.lnv.setOpenListener(this.lnR);
        this.lnw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.lnw.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pf(R.color.cp_cont_a);
        dVar.oX(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.lnw.setConfig(dVar);
        this.lnx = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.lnx.setOnClickListener(this.mClickListener);
        this.lny = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.lnz = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.lnz.setHasPendantStyle();
        this.lnz.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.lnz.getHeadView().setIsRound(true);
        this.lnz.getHeadView().setDrawBorder(false);
        this.lnz.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lnz.setOnClickListener(this.mClickListener);
        this.lnz.setBigVDimenSize(R.dimen.tbds57);
        this.lnz.setAuthIconType(3);
        this.lnz.setShowSimpleIcon(false);
        this.lnz.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.lnE = this.mRootView.findViewById(R.id.person_header_ring);
        this.lnE.setAlpha(0.33f);
        this.lnB = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.lnB.setPageContext(this.mPageContext);
        this.lnB.setPageUniqueId(this.mPageContext.getUniqueId());
        this.lnB.setRefreshListener(this.lnS);
        this.lnI = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.lnI.a(this.kgY);
        this.lnF = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.lnG = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.lnH = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.lnF.setOnClickListener(this.mClickListener);
        this.lnC = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.lnD = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.lnA = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void HE() {
        this.lnM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lnM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.lnK;
                ViewGroup.LayoutParams layoutParams = b.this.lnB.getLayoutParams();
                if (b.this.lnJ) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.lnK - floatValue);
                }
                if (b.this.lnP != null) {
                    b.this.lnP.AD(b.this.lnJ ? (int) floatValue : (int) (-floatValue));
                }
                b.this.lnB.setLayoutParams(layoutParams);
                b.this.lnB.onChangeSkinType();
            }
        });
        this.lnM.setDuration(260L);
        this.lnM.setInterpolator(new LinearInterpolator());
        this.lnN = ObjectAnimator.ofFloat(this.lnB, "alpha", 0.0f);
        this.lnN.setDuration(240L);
        this.lnN.setInterpolator(new LinearInterpolator());
        this.lnO = ObjectAnimator.ofFloat(this.lnv.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.lnO.setDuration(100L);
        this.lnL = new AnimatorSet();
        this.lnL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.lnB.getLayoutParams();
                if (b.this.lnJ) {
                    layoutParams.height = b.lnK;
                } else {
                    layoutParams.height = 0;
                }
                b.this.lnB.setLayoutParams(layoutParams);
                if (b.this.lnP != null) {
                    b.this.lnP.gu(b.this.lnJ);
                }
            }
        });
        this.lnL.play(this.lnM).with(this.lnN).with(this.lnO);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.b bVar) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            this.lmr = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.dTU.setText(this.mUserData.getName_show());
            }
            this.lnf.setVisibility(0);
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
                this.lnf.setVisibility(0);
                this.lnf.setText(intro);
                this.lnf.setEnabled(true);
                e.mS().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.lnf.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.lnf.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.lnf.setEnabled(false);
                                }
                                b.this.lnh.setVisibility(8);
                                return;
                            }
                            b.this.lnh.setVisibility(0);
                        }
                    }
                });
            } else {
                this.lnf.setVisibility(8);
            }
            this.lnj.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.lnl.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.lnr.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.lno.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.lnv.setVisibility(8);
                this.lnw.setVisibility(8);
            } else {
                this.lnw.setVisibility(0);
                this.lnv.setVisibility(0);
                this.lnv.setShowPullBtn(userData.isNewGod());
                this.lnv.setFirstUpdate(true);
                uJ(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.lnx.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.lnx.setVisibility(0);
            } else if (this.mIsHost) {
                this.lnx.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.lnx.setVisibility(0);
            } else {
                this.lnx.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bjq().a(this.lny, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.lny.setVisibility(8);
            } else {
                this.lny.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.lnD.setVisibility(0);
                this.lnD.loop(true);
                this.lnD.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lnD.playAnimation();
                    }
                });
                this.lnE.setVisibility(8);
                df(this.lnA);
                this.lnC.setVisibility(0);
                this.lnz.setIsclearmode(true);
                this.lnz.AB(this.mUserData.getAvater());
            } else {
                this.lnz.a(this.mUserData);
                this.lnC.setVisibility(8);
                this.lnz.setIsclearmode(false);
                this.lnE.setVisibility(0);
            }
            if (this.lmr != null && this.lmr.cvF() && !TextUtils.isEmpty(this.lmr.goods_url)) {
                this.lnF.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dD("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new aq("c13612").dD("obj_param1", "1"));
                    return;
                }
            }
            this.lnF.setVisibility(8);
        }
    }

    private void df(View view) {
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
        this.gAg = new AnimatorSet();
        this.gAg.play(ofFloat).with(ofFloat2);
        this.gAg.start();
    }

    public void diK() {
        if (this.lnN != null) {
            if (this.lnJ) {
                this.lnN.setFloatValues(0.0f, 1.0f);
            } else {
                this.lnN.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.lnO != null) {
            if (this.lnJ) {
                this.lnO.setFloatValues(0.0f, 180.0f);
            } else {
                this.lnO.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void diL() {
        if (this.lnL != null) {
            this.lnL.start();
        }
    }

    public void uI(boolean z) {
        this.lnJ = z;
    }

    public void OB(String str) {
        this.lnz.AA(str);
    }

    public void uJ(boolean z) {
        this.lnv.aN(z);
    }

    public void uK(boolean z) {
        if (z) {
            this.lni.setVisibility(0);
        } else {
            this.lni.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bjq().a(this.lnt, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.jED, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.lnu, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lnw.bkF();
        this.lnv.onChangeSkinType(i);
        SvgManager.bjq().a(this.lnh, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lnC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bjq().a(this.lnH, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.dTU, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnf, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnl, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnm, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lno, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnp, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnr, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lns, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnG, R.color.cp_cont_a, 1, i);
        ap.setImageResource(this.lni, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.lnE, R.drawable.person_header_bg, i);
        this.lnB.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bjq().a(this.lny, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.lnD != null) {
                this.lnD.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.lnC != null) {
                this.lnC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.lnD != null) {
                this.lnD.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.lnC != null) {
                this.lnC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.lnD != null) {
                this.lnD.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.lnC != null) {
                this.lnC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView diM() {
        return this.lnx;
    }

    public FollowUserSpinnerBtn diN() {
        return this.lnv;
    }

    public View diO() {
        return this.lnw;
    }

    public TextView getUserName() {
        return this.dTU;
    }

    public TextView diP() {
        return this.lnf;
    }

    public UserIconBox diQ() {
        return this.lnj;
    }

    public FrameLayout diR() {
        return this.lnk;
    }

    public FrameLayout diS() {
        return this.lnn;
    }

    public FrameLayout diT() {
        return this.lnq;
    }

    public HeadPendantView diU() {
        return this.lnz;
    }

    public View diV() {
        return this.lnF;
    }

    public ImageView diW() {
        return this.lnh;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lnP = aVar;
    }

    public void onDestroy() {
        if (this.gAg != null) {
            this.gAg.cancel();
        }
        if (this.lnD != null) {
            this.lnD.cancelAnimation();
        }
        if (this.lnL != null) {
            this.lnL.cancel();
        }
        if (this.lnI != null) {
            this.lnI.onDestory();
        }
    }
}
