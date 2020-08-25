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
    public static final int lnz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView dTQ;
    private AnimatorSet gAc;
    private ImageView jEx;
    private TextView lmU;
    private ImageView lmV;
    private ImageView lmW;
    private UserIconBox lmX;
    private FrameLayout lmY;
    private TextView lmZ;
    private com.baidu.tieba.i.b lmg;
    private AnimatorSet lnA;
    private ValueAnimator lnB;
    private ObjectAnimator lnC;
    private ObjectAnimator lnD;
    private com.baidu.tieba.personPolymeric.b.a lnE;
    private boolean lnF;
    private TextView lna;
    private FrameLayout lnb;
    private TextView lnc;
    private TextView lnd;
    private FrameLayout lne;
    private TextView lnf;
    private TextView lnh;
    private ImageView lni;
    private ImageView lnj;
    private FollowUserSpinnerBtn lnk;
    private TBSpecificationBtn lnl;
    private TbImageView lnm;
    private ImageView lnn;
    private HeadPendantView lno;
    private RelativeLayout lnp;
    private GodRecommendLayout lnq;
    private ImageView lnr;
    private TBLottieAnimationView lns;
    private View lnt;
    private View lnu;
    private TextView lnv;
    private ImageView lnw;
    private com.baidu.tieba.model.c lnx;
    private boolean lny;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a lnG = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void as(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.lnF = z2;
                if (z) {
                    b.this.lnq.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.lnx.br(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.lnq.setCouldStatistic(false);
                    b.this.lny = false;
                    b.this.diH();
                    if (b.this.lnA != null) {
                        b.this.lnA.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a kgR = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.lny = true;
                b.this.lnq.setData(qVar.diG());
                if (qVar.gcm == 1) {
                    b.this.diH();
                    if (b.this.lnA != null) {
                        b.this.lnA.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").ai("obj_type", b.this.lnF ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bhm();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bhm();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bhm();
            }
        }
    };
    private View.OnClickListener lnH = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.lnx != null && b.this.mUserData != null) {
                b.this.lnx.request(b.this.mUserData.getPortrait());
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
        this.dTQ = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.dTQ.setOnClickListener(this.mClickListener);
        this.lmU = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.lmU.setAlpha(0.85f);
        this.lmU.setOnClickListener(this.mClickListener);
        this.lmV = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.lmV.setOnClickListener(this.mClickListener);
        this.lmX = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.lmX.setOnClickListener(this.mClickListener);
        this.lmX.setAutoChangedStyle(false);
        this.lmZ = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.lmY = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.lmY.setOnClickListener(this.mClickListener);
        this.lna = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.lna.setAlpha(0.8f);
        this.jEx = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.lmW = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.lnc = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.lnb = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.lnb.setOnClickListener(this.mClickListener);
        this.lnd = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.lnd.setAlpha(0.8f);
        this.lnj = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.lnf = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.lne = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.lne.setOnClickListener(this.mClickListener);
        this.lnh = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.lnh.setAlpha(0.8f);
        this.lni = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.lnk = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.lnk.g(this.mClickListener);
        this.lnk.setOpenListener(this.lnG);
        this.lnl = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.lnl.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pf(R.color.cp_cont_a);
        dVar.oX(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.lnl.setConfig(dVar);
        this.lnm = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.lnm.setOnClickListener(this.mClickListener);
        this.lnn = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.lno = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.lno.setHasPendantStyle();
        this.lno.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.lno.getHeadView().setIsRound(true);
        this.lno.getHeadView().setDrawBorder(false);
        this.lno.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lno.setOnClickListener(this.mClickListener);
        this.lno.setBigVDimenSize(R.dimen.tbds57);
        this.lno.setAuthIconType(3);
        this.lno.setShowSimpleIcon(false);
        this.lno.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.lnt = this.mRootView.findViewById(R.id.person_header_ring);
        this.lnt.setAlpha(0.33f);
        this.lnq = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.lnq.setPageContext(this.mPageContext);
        this.lnq.setPageUniqueId(this.mPageContext.getUniqueId());
        this.lnq.setRefreshListener(this.lnH);
        this.lnx = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.lnx.a(this.kgR);
        this.lnu = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.lnv = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.lnw = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.lnu.setOnClickListener(this.mClickListener);
        this.lnr = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.lns = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.lnp = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void HE() {
        this.lnB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lnB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.lnz;
                ViewGroup.LayoutParams layoutParams = b.this.lnq.getLayoutParams();
                if (b.this.lny) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.lnz - floatValue);
                }
                if (b.this.lnE != null) {
                    b.this.lnE.AD(b.this.lny ? (int) floatValue : (int) (-floatValue));
                }
                b.this.lnq.setLayoutParams(layoutParams);
                b.this.lnq.onChangeSkinType();
            }
        });
        this.lnB.setDuration(260L);
        this.lnB.setInterpolator(new LinearInterpolator());
        this.lnC = ObjectAnimator.ofFloat(this.lnq, "alpha", 0.0f);
        this.lnC.setDuration(240L);
        this.lnC.setInterpolator(new LinearInterpolator());
        this.lnD = ObjectAnimator.ofFloat(this.lnk.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.lnD.setDuration(100L);
        this.lnA = new AnimatorSet();
        this.lnA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.lnq.getLayoutParams();
                if (b.this.lny) {
                    layoutParams.height = b.lnz;
                } else {
                    layoutParams.height = 0;
                }
                b.this.lnq.setLayoutParams(layoutParams);
                if (b.this.lnE != null) {
                    b.this.lnE.gt(b.this.lny);
                }
            }
        });
        this.lnA.play(this.lnB).with(this.lnC).with(this.lnD);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.lmg = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.dTQ.setText(this.mUserData.getName_show());
            }
            this.lmU.setVisibility(0);
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
                this.lmU.setVisibility(0);
                this.lmU.setText(intro);
                this.lmU.setEnabled(true);
                e.mS().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.lmU.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.lmU.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.lmU.setEnabled(false);
                                }
                                b.this.lmV.setVisibility(8);
                                return;
                            }
                            b.this.lmV.setVisibility(0);
                        }
                    }
                });
            } else {
                this.lmU.setVisibility(8);
            }
            this.lmX.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.lmZ.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.lnf.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.lnc.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.lnk.setVisibility(8);
                this.lnl.setVisibility(8);
            } else {
                this.lnl.setVisibility(0);
                this.lnk.setVisibility(0);
                this.lnk.setShowPullBtn(userData.isNewGod());
                this.lnk.setFirstUpdate(true);
                uH(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.lnm.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.lnm.setVisibility(0);
            } else if (this.mIsHost) {
                this.lnm.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.lnm.setVisibility(0);
            } else {
                this.lnm.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bjq().a(this.lnn, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.lnn.setVisibility(8);
            } else {
                this.lnn.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.lns.setVisibility(0);
                this.lns.loop(true);
                this.lns.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lns.playAnimation();
                    }
                });
                this.lnt.setVisibility(8);
                df(this.lnp);
                this.lnr.setVisibility(0);
                this.lno.setIsclearmode(true);
                this.lno.AA(this.mUserData.getAvater());
            } else {
                this.lno.a(this.mUserData);
                this.lnr.setVisibility(8);
                this.lno.setIsclearmode(false);
                this.lnt.setVisibility(0);
            }
            if (this.lmg != null && this.lmg.cvE() && !TextUtils.isEmpty(this.lmg.goods_url)) {
                this.lnu.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dD("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new aq("c13612").dD("obj_param1", "1"));
                    return;
                }
            }
            this.lnu.setVisibility(8);
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
        this.gAc = new AnimatorSet();
        this.gAc.play(ofFloat).with(ofFloat2);
        this.gAc.start();
    }

    public void diH() {
        if (this.lnC != null) {
            if (this.lny) {
                this.lnC.setFloatValues(0.0f, 1.0f);
            } else {
                this.lnC.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.lnD != null) {
            if (this.lny) {
                this.lnD.setFloatValues(0.0f, 180.0f);
            } else {
                this.lnD.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void diI() {
        if (this.lnA != null) {
            this.lnA.start();
        }
    }

    public void uG(boolean z) {
        this.lny = z;
    }

    public void OA(String str) {
        this.lno.Az(str);
    }

    public void uH(boolean z) {
        this.lnk.aN(z);
    }

    public void uI(boolean z) {
        if (z) {
            this.lmW.setVisibility(0);
        } else {
            this.lmW.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bjq().a(this.lni, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.jEx, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.lnj, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lnl.bkF();
        this.lnk.onChangeSkinType(i);
        SvgManager.bjq().a(this.lmV, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lnr.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bjq().a(this.lnw, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.dTQ, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lmU, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lmZ, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lna, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnc, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnd, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnf, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnh, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lnv, R.color.cp_cont_a, 1, i);
        ap.setImageResource(this.lmW, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.lnt, R.drawable.person_header_bg, i);
        this.lnq.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bjq().a(this.lnn, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.lns != null) {
                this.lns.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.lnr != null) {
                this.lnr.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.lns != null) {
                this.lns.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.lnr != null) {
                this.lnr.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.lns != null) {
                this.lns.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.lnr != null) {
                this.lnr.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView diJ() {
        return this.lnm;
    }

    public FollowUserSpinnerBtn diK() {
        return this.lnk;
    }

    public View diL() {
        return this.lnl;
    }

    public TextView getUserName() {
        return this.dTQ;
    }

    public TextView diM() {
        return this.lmU;
    }

    public UserIconBox diN() {
        return this.lmX;
    }

    public FrameLayout diO() {
        return this.lmY;
    }

    public FrameLayout diP() {
        return this.lnb;
    }

    public FrameLayout diQ() {
        return this.lne;
    }

    public HeadPendantView diR() {
        return this.lno;
    }

    public View diS() {
        return this.lnu;
    }

    public ImageView diT() {
        return this.lmV;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lnE = aVar;
    }

    public void onDestroy() {
        if (this.gAc != null) {
            this.gAc.cancel();
        }
        if (this.lns != null) {
            this.lns.cancelAnimation();
        }
        if (this.lnA != null) {
            this.lnA.cancel();
        }
        if (this.lnx != null) {
            this.lnx.onDestory();
        }
    }
}
