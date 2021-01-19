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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.d;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.util.ag;
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
    public static final int mtA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eGI;
    private AnimatorSet hzS;
    private ImageView kJi;
    private boolean llR;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private TextView msS;
    private ImageView msT;
    private ImageView msU;
    private UserIconBox msV;
    private FrameLayout msW;
    private TextView msX;
    private TextView msY;
    private FrameLayout msZ;
    private com.baidu.tieba.j.b msd;
    private AnimatorSet mtB;
    private ValueAnimator mtC;
    private ObjectAnimator mtD;
    private ObjectAnimator mtE;
    private com.baidu.tieba.personPolymeric.b.a mtF;
    private boolean mtG;
    private TextView mta;
    private TextView mtb;
    private FrameLayout mtc;
    private TextView mtd;
    private TextView mte;
    private ImageView mtf;
    private ImageView mtg;
    private FollowUserSpinnerBtn mth;
    private TBSpecificationBtn mti;
    private TbImageView mtj;
    private ImageView mtk;
    private HeadPendantView mtl;
    private RelativeLayout mtm;
    private GodRecommendLayout mtn;
    private ImageView mto;
    private TBLottieAnimationView mtp;
    private View mtq;
    private ViewGroup mtr;
    private View mts;
    private TextView mtt;
    private ImageView mtu;
    private View mtv;
    private TextView mtw;
    private ImageView mtx;
    private com.baidu.tieba.model.c mty;
    private boolean mtz;
    private FollowUserSpinnerBtn.a mtH = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void av(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.mtG = z2;
                b.this.llR = false;
                if (z) {
                    b.this.mtn.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.mty.bD(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mtn.setCouldStatistic(false);
                    b.this.mtz = false;
                    b.this.dwz();
                    if (b.this.mtB != null) {
                        b.this.mtB.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a llQ = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mtn.setData(qVar.dwy());
                if (!b.this.llR) {
                    b.this.mtz = true;
                    b.this.dwz();
                    if (b.this.mtB != null) {
                        b.this.mtB.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").an("obj_type", b.this.mtG ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqk();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bqk();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bqk();
            }
        }
    };
    private View.OnClickListener mtI = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.mty != null && b.this.mUserData != null) {
                b.this.llR = true;
                b.this.mty.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        GS();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eGI = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eGI.setOnClickListener(this.mClickListener);
        this.msS = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.msS.setAlpha(0.85f);
        this.msS.setOnClickListener(this.mClickListener);
        this.msT = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.msT.setOnClickListener(this.mClickListener);
        this.msV = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.msV.setOnClickListener(this.mClickListener);
        this.msV.setAutoChangedStyle(false);
        this.msX = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.msW = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.msW.setOnClickListener(this.mClickListener);
        this.msY = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.msY.setAlpha(0.8f);
        this.kJi = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.msU = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mta = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.msZ = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.msZ.setOnClickListener(this.mClickListener);
        this.mtb = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mtb.setAlpha(0.8f);
        this.mtg = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mtd = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mtc = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mtc.setOnClickListener(this.mClickListener);
        this.mte = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mte.setAlpha(0.8f);
        this.mtf = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mth = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mth.i(this.mClickListener);
        this.mth.setOpenListener(this.mtH);
        this.mti = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mti.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pQ(R.color.CAM_X0101);
        dVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mti.setConfig(dVar);
        this.mtj = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mtj.setOnClickListener(this.mClickListener);
        this.mtk = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mtl = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mtl.setHasPendantStyle();
        this.mtl.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mtl.getHeadView().setIsRound(true);
        this.mtl.getHeadView().setDrawBorder(false);
        this.mtl.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mtl.setOnClickListener(this.mClickListener);
        this.mtl.setBigVDimenSize(R.dimen.tbds57);
        this.mtl.setAuthIconType(3);
        this.mtl.setShowSimpleIcon(false);
        this.mtl.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.mtq = this.mRootView.findViewById(R.id.person_header_ring);
        this.mtq.setAlpha(0.33f);
        this.mtn = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mtn.setPageContext(this.mPageContext);
        this.mtn.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mtn.setRefreshListener(this.mtI);
        this.mty = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.mty.a(this.llQ);
        this.mtr = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mts = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mtt = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mtu = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mts.setOnClickListener(this.mClickListener);
        this.mtv = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.mtw = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.mtx = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.mtv.setOnClickListener(this.mClickListener);
        this.mto = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mtp = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mtm = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void GS() {
        this.mtC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.mtA;
                ViewGroup.LayoutParams layoutParams = b.this.mtn.getLayoutParams();
                if (b.this.mtz) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.mtA - floatValue);
                }
                if (b.this.mtF != null) {
                    b.this.mtF.Ck(b.this.mtz ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mtn.setLayoutParams(layoutParams);
                b.this.mtn.onChangeSkinType();
            }
        });
        this.mtC.setDuration(260L);
        this.mtC.setInterpolator(new LinearInterpolator());
        this.mtD = ObjectAnimator.ofFloat(this.mtn, "alpha", 0.0f);
        this.mtD.setDuration(240L);
        this.mtD.setInterpolator(new LinearInterpolator());
        this.mtE = ObjectAnimator.ofFloat(this.mth.getArrow(), "rotation", 0.0f);
        this.mtE.setDuration(100L);
        this.mtB = new AnimatorSet();
        this.mtB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mtn.getLayoutParams();
                if (b.this.mtz) {
                    layoutParams.height = b.mtA;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mtn.setLayoutParams(layoutParams);
                if (b.this.mtF != null) {
                    b.this.mtF.hQ(b.this.mtz);
                }
            }
        });
        this.mtB.play(this.mtC).with(this.mtD).with(this.mtE);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.msd = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.eGI.setText(this.mUserData.getName_show());
            }
            this.msS.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (this.mUserData.isNewGod() && !at.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + ag.lx(this.mUserData.getNewGodData().isVideoGod()));
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
                this.msS.setVisibility(0);
                this.msS.setText(intro);
                this.msS.setEnabled(true);
                e.mB().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.msS.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.msS.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.msS.setEnabled(false);
                                }
                                b.this.msT.setVisibility(8);
                                return;
                            }
                            b.this.msT.setVisibility(0);
                        }
                    }
                });
            } else {
                this.msS.setVisibility(8);
            }
            this.msV.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.msX.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mtd.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mta.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mth.setVisibility(8);
                this.mti.setVisibility(8);
            } else {
                this.mti.setVisibility(0);
                this.mth.setVisibility(0);
                this.mth.setShowPullBtn(userData.isNewGod());
                this.mth.setFirstUpdate(true);
                wC(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mtj.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mtj.setVisibility(0);
            } else if (this.mIsHost) {
                this.mtj.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
                this.mtj.setVisibility(0);
            } else {
                this.mtj.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bsx().a(this.mtk, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.mtk.setVisibility(8);
            } else {
                this.mtk.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mtp.setVisibility(0);
                this.mtp.loop(true);
                this.mtp.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mtp.playAnimation();
                    }
                });
                this.mtq.setVisibility(8);
                dZ(this.mtm);
                this.mto.setVisibility(0);
                this.mtl.setIsclearmode(true);
                this.mtl.Bj(this.mUserData.getAvater());
            } else {
                this.mtl.a(this.mUserData);
                this.mto.setVisibility(8);
                this.mtl.setIsclearmode(false);
                this.mtq.setVisibility(0);
            }
            if (this.msd != null && this.msd.cMu() && !TextUtils.isEmpty(this.msd.goods_url)) {
                this.mts.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dW("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new aq("c13612").dW("obj_param1", "1"));
                }
            } else {
                this.mts.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.mtw.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.mtv.setVisibility(0);
            } else {
                this.mtv.setVisibility(8);
            }
            if (this.mts.getVisibility() == 0 || this.mtv.getVisibility() == 0) {
                this.mtr.setVisibility(0);
            } else {
                this.mtr.setVisibility(8);
            }
        }
    }

    private void dZ(View view) {
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
        this.hzS = new AnimatorSet();
        this.hzS.play(ofFloat).with(ofFloat2);
        this.hzS.start();
    }

    public void dwz() {
        if (this.mtD != null) {
            if (this.mtz) {
                this.mtD.setFloatValues(0.0f, 1.0f);
            } else {
                this.mtD.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.mtE != null) {
            if (this.mtz) {
                this.mtE.setFloatValues(0.0f, 180.0f);
            } else {
                this.mtE.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dwA() {
        if (this.mtB != null) {
            this.mtB.start();
        }
    }

    public void wB(boolean z) {
        this.mtz = z;
    }

    public void PI(String str) {
        this.mtl.Bi(str);
    }

    public void wC(boolean z) {
        this.mth.aM(z);
    }

    public void wD(boolean z) {
        if (z) {
            this.msU.setVisibility(0);
        } else {
            this.msU.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsx().a(this.mtf, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a(this.kJi, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a(this.mtg, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mti.btV();
        this.mth.onChangeSkinType(i);
        SvgManager.bsx().a(this.msT, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mto.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bsx().a(this.mtu, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a(this.mtx, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.eGI, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.msS, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.msX, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.msY, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mta, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mtb, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mtd, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mte, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mtt, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mtw, R.color.CAM_X0101, 1, i);
        ao.setImageResource(this.msU, R.drawable.icon_news_down_bar_one);
        ao.setBackgroundResource(this.mtq, R.drawable.person_header_bg, i);
        this.mtn.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bsx().a(this.mtk, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mtp != null) {
                this.mtp.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mto != null) {
                this.mto.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mtp != null) {
                this.mtp.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mto != null) {
                this.mto.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mtp != null) {
                this.mtp.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mto != null) {
                this.mto.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dwB() {
        return this.mtj;
    }

    public FollowUserSpinnerBtn dwC() {
        return this.mth;
    }

    public View dwD() {
        return this.mti;
    }

    public TextView getUserName() {
        return this.eGI;
    }

    public TextView dwE() {
        return this.msS;
    }

    public UserIconBox dwF() {
        return this.msV;
    }

    public FrameLayout dwG() {
        return this.msW;
    }

    public FrameLayout dwH() {
        return this.msZ;
    }

    public FrameLayout dwI() {
        return this.mtc;
    }

    public HeadPendantView dwJ() {
        return this.mtl;
    }

    public View dwK() {
        return this.mts;
    }

    public View dwL() {
        return this.mtv;
    }

    public ImageView dwM() {
        return this.msT;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mtF = aVar;
    }

    public void onDestroy() {
        if (this.hzS != null) {
            this.hzS.cancel();
        }
        if (this.mtp != null) {
            this.mtp.cancelAnimation();
        }
        if (this.mtB != null) {
            this.mtB.cancel();
        }
        if (this.mty != null) {
            this.mty.onDestory();
        }
    }
}
