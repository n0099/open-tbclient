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
/* loaded from: classes24.dex */
public class b {
    public static final int lYs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eqE;
    private AnimatorSet hdB;
    private boolean kRi;
    private ImageView koC;
    private com.baidu.tieba.i.b lWW;
    private TextView lXK;
    private ImageView lXL;
    private ImageView lXM;
    private UserIconBox lXN;
    private FrameLayout lXO;
    private TextView lXP;
    private TextView lXQ;
    private FrameLayout lXR;
    private TextView lXS;
    private TextView lXT;
    private FrameLayout lXU;
    private TextView lXV;
    private TextView lXW;
    private ImageView lXX;
    private ImageView lXY;
    private FollowUserSpinnerBtn lXZ;
    private TBSpecificationBtn lYa;
    private TbImageView lYb;
    private ImageView lYc;
    private HeadPendantView lYd;
    private RelativeLayout lYe;
    private GodRecommendLayout lYf;
    private ImageView lYg;
    private TBLottieAnimationView lYh;
    private View lYi;
    private ViewGroup lYj;
    private View lYk;
    private TextView lYl;
    private ImageView lYm;
    private View lYn;
    private TextView lYo;
    private ImageView lYp;
    private com.baidu.tieba.model.c lYq;
    private boolean lYr;
    private AnimatorSet lYt;
    private ValueAnimator lYu;
    private ObjectAnimator lYv;
    private ObjectAnimator lYw;
    private com.baidu.tieba.personPolymeric.b.a lYx;
    private boolean lYy;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a lYz = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void aw(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.lYy = z2;
                b.this.kRi = false;
                if (z) {
                    b.this.lYf.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.lYq.bt(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.lYf.setCouldStatistic(false);
                    b.this.lYr = false;
                    b.this.dtg();
                    if (b.this.lYt != null) {
                        b.this.lYt.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a kRh = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.lYf.setData(qVar.dtf());
                if (!b.this.kRi) {
                    b.this.lYr = true;
                    b.this.dtg();
                    if (b.this.lYt != null) {
                        b.this.lYt.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").aj("obj_type", b.this.lYy ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bmI();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bmI();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bmI();
            }
        }
    };
    private View.OnClickListener lYA = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.lYq != null && b.this.mUserData != null) {
                b.this.kRi = true;
                b.this.lYq.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Jw();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eqE = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eqE.setOnClickListener(this.mClickListener);
        this.lXK = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.lXK.setAlpha(0.85f);
        this.lXK.setOnClickListener(this.mClickListener);
        this.lXL = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.lXL.setOnClickListener(this.mClickListener);
        this.lXN = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.lXN.setOnClickListener(this.mClickListener);
        this.lXN.setAutoChangedStyle(false);
        this.lXP = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.lXO = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.lXO.setOnClickListener(this.mClickListener);
        this.lXQ = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.lXQ.setAlpha(0.8f);
        this.koC = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.lXM = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.lXS = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.lXR = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.lXR.setOnClickListener(this.mClickListener);
        this.lXT = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.lXT.setAlpha(0.8f);
        this.lXY = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.lXV = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.lXU = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.lXU.setOnClickListener(this.mClickListener);
        this.lXW = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.lXW.setAlpha(0.8f);
        this.lXX = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.lXZ = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.lXZ.g(this.mClickListener);
        this.lXZ.setOpenListener(this.lYz);
        this.lYa = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.lYa.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.qc(R.color.cp_cont_a);
        dVar.pT(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.lYa.setConfig(dVar);
        this.lYb = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.lYb.setOnClickListener(this.mClickListener);
        this.lYc = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.lYd = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.lYd.setHasPendantStyle();
        this.lYd.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.lYd.getHeadView().setIsRound(true);
        this.lYd.getHeadView().setDrawBorder(false);
        this.lYd.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lYd.setOnClickListener(this.mClickListener);
        this.lYd.setBigVDimenSize(R.dimen.tbds57);
        this.lYd.setAuthIconType(3);
        this.lYd.setShowSimpleIcon(false);
        this.lYd.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.lYi = this.mRootView.findViewById(R.id.person_header_ring);
        this.lYi.setAlpha(0.33f);
        this.lYf = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.lYf.setPageContext(this.mPageContext);
        this.lYf.setPageUniqueId(this.mPageContext.getUniqueId());
        this.lYf.setRefreshListener(this.lYA);
        this.lYq = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.lYq.a(this.kRh);
        this.lYj = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.lYk = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.lYl = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.lYm = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.lYk.setOnClickListener(this.mClickListener);
        this.lYn = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.lYo = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.lYp = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.lYn.setOnClickListener(this.mClickListener);
        this.lYg = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.lYh = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.lYe = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Jw() {
        this.lYu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.lYs;
                ViewGroup.LayoutParams layoutParams = b.this.lYf.getLayoutParams();
                if (b.this.lYr) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.lYs - floatValue);
                }
                if (b.this.lYx != null) {
                    b.this.lYx.Cd(b.this.lYr ? (int) floatValue : (int) (-floatValue));
                }
                b.this.lYf.setLayoutParams(layoutParams);
                b.this.lYf.onChangeSkinType();
            }
        });
        this.lYu.setDuration(260L);
        this.lYu.setInterpolator(new LinearInterpolator());
        this.lYv = ObjectAnimator.ofFloat(this.lYf, "alpha", 0.0f);
        this.lYv.setDuration(240L);
        this.lYv.setInterpolator(new LinearInterpolator());
        this.lYw = ObjectAnimator.ofFloat(this.lXZ.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.lYw.setDuration(100L);
        this.lYt = new AnimatorSet();
        this.lYt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.lYf.getLayoutParams();
                if (b.this.lYr) {
                    layoutParams.height = b.lYs;
                } else {
                    layoutParams.height = 0;
                }
                b.this.lYf.setLayoutParams(layoutParams);
                if (b.this.lYx != null) {
                    b.this.lYx.hb(b.this.lYr);
                }
            }
        });
        this.lYt.play(this.lYu).with(this.lYv).with(this.lYw);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.lWW = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.eqE.setText(this.mUserData.getName_show());
            }
            this.lXK.setVisibility(0);
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
                this.lXK.setVisibility(0);
                this.lXK.setText(intro);
                this.lXK.setEnabled(true);
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.lXK.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.lXK.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.lXK.setEnabled(false);
                                }
                                b.this.lXL.setVisibility(8);
                                return;
                            }
                            b.this.lXL.setVisibility(0);
                        }
                    }
                });
            } else {
                this.lXK.setVisibility(8);
            }
            this.lXN.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.lXP.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.lXV.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.lXS.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.lXZ.setVisibility(8);
                this.lYa.setVisibility(8);
            } else {
                this.lYa.setVisibility(0);
                this.lXZ.setVisibility(0);
                this.lXZ.setShowPullBtn(userData.isNewGod());
                this.lXZ.setFirstUpdate(true);
                vP(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.lYb.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.lYb.setVisibility(0);
            } else if (this.mIsHost) {
                this.lYb.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.lYb.setVisibility(0);
            } else {
                this.lYb.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.boN().a(this.lYc, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.lYc.setVisibility(8);
            } else {
                this.lYc.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.lYh.setVisibility(0);
                this.lYh.loop(true);
                this.lYh.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lYh.playAnimation();
                    }
                });
                this.lYi.setVisibility(8);
                dv(this.lYe);
                this.lYg.setVisibility(0);
                this.lYd.setIsclearmode(true);
                this.lYd.Cc(this.mUserData.getAvater());
            } else {
                this.lYd.a(this.mUserData);
                this.lYg.setVisibility(8);
                this.lYd.setIsclearmode(false);
                this.lYi.setVisibility(0);
            }
            if (this.lWW != null && this.lWW.cFD() && !TextUtils.isEmpty(this.lWW.goods_url)) {
                this.lYk.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dR("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new aq("c13612").dR("obj_param1", "1"));
                }
            } else {
                this.lYk.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.lYo.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.lYn.setVisibility(0);
            } else {
                this.lYn.setVisibility(8);
            }
            if (this.lYk.getVisibility() == 0 || this.lYn.getVisibility() == 0) {
                this.lYj.setVisibility(0);
            } else {
                this.lYj.setVisibility(8);
            }
        }
    }

    private void dv(View view) {
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
        this.hdB = new AnimatorSet();
        this.hdB.play(ofFloat).with(ofFloat2);
        this.hdB.start();
    }

    public void dtg() {
        if (this.lYv != null) {
            if (this.lYr) {
                this.lYv.setFloatValues(0.0f, 1.0f);
            } else {
                this.lYv.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.lYw != null) {
            if (this.lYr) {
                this.lYw.setFloatValues(0.0f, 180.0f);
            } else {
                this.lYw.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dth() {
        if (this.lYt != null) {
            this.lYt.start();
        }
    }

    public void vO(boolean z) {
        this.lYr = z;
    }

    public void Qp(String str) {
        this.lYd.Cb(str);
    }

    public void vP(boolean z) {
        this.lXZ.aN(z);
    }

    public void vQ(boolean z) {
        if (z) {
            this.lXM.setVisibility(0);
        } else {
            this.lXM.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.boN().a(this.lXX, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a(this.koC, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a(this.lXY, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lYa.bqd();
        this.lXZ.onChangeSkinType(i);
        SvgManager.boN().a(this.lXL, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lYg.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.boN().a(this.lYm, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a(this.lYp, R.drawable.ic_icon_mask_wo_yujin_16, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eqE, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXK, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXP, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXQ, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXS, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXT, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXV, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lXW, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lYl, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lYo, R.color.cp_cont_a, 1, i);
        ap.setImageResource(this.lXM, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.lYi, R.drawable.person_header_bg, i);
        this.lYf.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.boN().a(this.lYc, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.lYh != null) {
                this.lYh.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.lYg != null) {
                this.lYg.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.lYh != null) {
                this.lYh.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.lYg != null) {
                this.lYg.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.lYh != null) {
                this.lYh.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.lYg != null) {
                this.lYg.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dti() {
        return this.lYb;
    }

    public FollowUserSpinnerBtn dtj() {
        return this.lXZ;
    }

    public View dtk() {
        return this.lYa;
    }

    public TextView getUserName() {
        return this.eqE;
    }

    public TextView dtl() {
        return this.lXK;
    }

    public UserIconBox dtm() {
        return this.lXN;
    }

    public FrameLayout dtn() {
        return this.lXO;
    }

    public FrameLayout dto() {
        return this.lXR;
    }

    public FrameLayout dtp() {
        return this.lXU;
    }

    public HeadPendantView dtq() {
        return this.lYd;
    }

    public View dtr() {
        return this.lYk;
    }

    public View dts() {
        return this.lYn;
    }

    public ImageView dtt() {
        return this.lXL;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lYx = aVar;
    }

    public void onDestroy() {
        if (this.hdB != null) {
            this.hdB.cancel();
        }
        if (this.lYh != null) {
            this.lYh.cancelAnimation();
        }
        if (this.lYt != null) {
            this.lYt.cancel();
        }
        if (this.lYq != null) {
            this.lYq.onDestory();
        }
    }
}
