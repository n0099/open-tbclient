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
    public static final int lLW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eig;
    private AnimatorSet gRO;
    private boolean kEL;
    private ImageView kcd;
    private com.baidu.tieba.i.b lKA;
    private TextView lLA;
    private ImageView lLB;
    private ImageView lLC;
    private FollowUserSpinnerBtn lLD;
    private TBSpecificationBtn lLE;
    private TbImageView lLF;
    private ImageView lLG;
    private HeadPendantView lLH;
    private RelativeLayout lLI;
    private GodRecommendLayout lLJ;
    private ImageView lLK;
    private TBLottieAnimationView lLL;
    private View lLM;
    private ViewGroup lLN;
    private View lLO;
    private TextView lLP;
    private ImageView lLQ;
    private View lLR;
    private TextView lLS;
    private ImageView lLT;
    private com.baidu.tieba.model.c lLU;
    private boolean lLV;
    private AnimatorSet lLX;
    private ValueAnimator lLY;
    private ObjectAnimator lLZ;
    private TextView lLo;
    private ImageView lLp;
    private ImageView lLq;
    private UserIconBox lLr;
    private FrameLayout lLs;
    private TextView lLt;
    private TextView lLu;
    private FrameLayout lLv;
    private TextView lLw;
    private TextView lLx;
    private FrameLayout lLy;
    private TextView lLz;
    private ObjectAnimator lMa;
    private com.baidu.tieba.personPolymeric.b.a lMb;
    private boolean lMc;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a lMd = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void at(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.lMc = z2;
                b.this.kEL = false;
                if (z) {
                    b.this.lLJ.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.lLU.bs(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.lLJ.setCouldStatistic(false);
                    b.this.lLV = false;
                    b.this.dpZ();
                    if (b.this.lLX != null) {
                        b.this.lLX.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a kEK = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.lLJ.setData(qVar.dpY());
                if (!b.this.kEL) {
                    b.this.lLV = true;
                    b.this.dpZ();
                    if (b.this.lLX != null) {
                        b.this.lLX.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").aj("obj_type", b.this.lMc ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bkP();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bkP();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bkP();
            }
        }
    };
    private View.OnClickListener lMe = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.lLU != null && b.this.mUserData != null) {
                b.this.kEL = true;
                b.this.lLU.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Jd();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eig = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eig.setOnClickListener(this.mClickListener);
        this.lLo = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.lLo.setAlpha(0.85f);
        this.lLo.setOnClickListener(this.mClickListener);
        this.lLp = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.lLp.setOnClickListener(this.mClickListener);
        this.lLr = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.lLr.setOnClickListener(this.mClickListener);
        this.lLr.setAutoChangedStyle(false);
        this.lLt = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.lLs = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.lLs.setOnClickListener(this.mClickListener);
        this.lLu = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.lLu.setAlpha(0.8f);
        this.kcd = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.lLq = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.lLw = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.lLv = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.lLv.setOnClickListener(this.mClickListener);
        this.lLx = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.lLx.setAlpha(0.8f);
        this.lLC = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.lLz = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.lLy = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.lLy.setOnClickListener(this.mClickListener);
        this.lLA = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.lLA.setAlpha(0.8f);
        this.lLB = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.lLD = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.lLD.g(this.mClickListener);
        this.lLD.setOpenListener(this.lMd);
        this.lLE = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.lLE.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pR(R.color.cp_cont_a);
        dVar.pI(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.lLE.setConfig(dVar);
        this.lLF = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.lLF.setOnClickListener(this.mClickListener);
        this.lLG = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.lLH = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.lLH.setHasPendantStyle();
        this.lLH.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.lLH.getHeadView().setIsRound(true);
        this.lLH.getHeadView().setDrawBorder(false);
        this.lLH.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lLH.setOnClickListener(this.mClickListener);
        this.lLH.setBigVDimenSize(R.dimen.tbds57);
        this.lLH.setAuthIconType(3);
        this.lLH.setShowSimpleIcon(false);
        this.lLH.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.lLM = this.mRootView.findViewById(R.id.person_header_ring);
        this.lLM.setAlpha(0.33f);
        this.lLJ = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.lLJ.setPageContext(this.mPageContext);
        this.lLJ.setPageUniqueId(this.mPageContext.getUniqueId());
        this.lLJ.setRefreshListener(this.lMe);
        this.lLU = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.lLU.a(this.kEK);
        this.lLN = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.lLO = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.lLP = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.lLQ = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.lLO.setOnClickListener(this.mClickListener);
        this.lLR = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.lLS = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.lLT = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.lLR.setOnClickListener(this.mClickListener);
        this.lLK = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.lLL = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.lLI = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Jd() {
        this.lLY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lLY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.lLW;
                ViewGroup.LayoutParams layoutParams = b.this.lLJ.getLayoutParams();
                if (b.this.lLV) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.lLW - floatValue);
                }
                if (b.this.lMb != null) {
                    b.this.lMb.BK(b.this.lLV ? (int) floatValue : (int) (-floatValue));
                }
                b.this.lLJ.setLayoutParams(layoutParams);
                b.this.lLJ.onChangeSkinType();
            }
        });
        this.lLY.setDuration(260L);
        this.lLY.setInterpolator(new LinearInterpolator());
        this.lLZ = ObjectAnimator.ofFloat(this.lLJ, "alpha", 0.0f);
        this.lLZ.setDuration(240L);
        this.lLZ.setInterpolator(new LinearInterpolator());
        this.lMa = ObjectAnimator.ofFloat(this.lLD.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.lMa.setDuration(100L);
        this.lLX = new AnimatorSet();
        this.lLX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.lLJ.getLayoutParams();
                if (b.this.lLV) {
                    layoutParams.height = b.lLW;
                } else {
                    layoutParams.height = 0;
                }
                b.this.lLJ.setLayoutParams(layoutParams);
                if (b.this.lMb != null) {
                    b.this.lMb.gO(b.this.lLV);
                }
            }
        });
        this.lLX.play(this.lLY).with(this.lLZ).with(this.lMa);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.lKA = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.eig.setText(this.mUserData.getName_show());
            }
            this.lLo.setVisibility(0);
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
                this.lLo.setVisibility(0);
                this.lLo.setText(intro);
                this.lLo.setEnabled(true);
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.lLo.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.lLo.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.lLo.setEnabled(false);
                                }
                                b.this.lLp.setVisibility(8);
                                return;
                            }
                            b.this.lLp.setVisibility(0);
                        }
                    }
                });
            } else {
                this.lLo.setVisibility(8);
            }
            this.lLr.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.lLt.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.lLz.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.lLw.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.lLD.setVisibility(8);
                this.lLE.setVisibility(8);
            } else {
                this.lLE.setVisibility(0);
                this.lLD.setVisibility(0);
                this.lLD.setShowPullBtn(userData.isNewGod());
                this.lLD.setFirstUpdate(true);
                vy(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.lLF.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.lLF.setVisibility(0);
            } else if (this.mIsHost) {
                this.lLF.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.lLF.setVisibility(0);
            } else {
                this.lLF.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bmU().a(this.lLG, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.lLG.setVisibility(8);
            } else {
                this.lLG.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.lLL.setVisibility(0);
                this.lLL.loop(true);
                this.lLL.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lLL.playAnimation();
                    }
                });
                this.lLM.setVisibility(8);
                dr(this.lLI);
                this.lLK.setVisibility(0);
                this.lLH.setIsclearmode(true);
                this.lLH.BJ(this.mUserData.getAvater());
            } else {
                this.lLH.a(this.mUserData);
                this.lLK.setVisibility(8);
                this.lLH.setIsclearmode(false);
                this.lLM.setVisibility(0);
            }
            if (this.lKA != null && this.lKA.cCw() && !TextUtils.isEmpty(this.lKA.goods_url)) {
                this.lLO.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dK("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new aq("c13612").dK("obj_param1", "1"));
                }
            } else {
                this.lLO.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.lLS.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.lLR.setVisibility(0);
            } else {
                this.lLR.setVisibility(8);
            }
            if (this.lLO.getVisibility() == 0 || this.lLR.getVisibility() == 0) {
                this.lLN.setVisibility(0);
            } else {
                this.lLN.setVisibility(8);
            }
        }
    }

    private void dr(View view) {
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
        this.gRO = new AnimatorSet();
        this.gRO.play(ofFloat).with(ofFloat2);
        this.gRO.start();
    }

    public void dpZ() {
        if (this.lLZ != null) {
            if (this.lLV) {
                this.lLZ.setFloatValues(0.0f, 1.0f);
            } else {
                this.lLZ.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.lMa != null) {
            if (this.lLV) {
                this.lMa.setFloatValues(0.0f, 180.0f);
            } else {
                this.lMa.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dqa() {
        if (this.lLX != null) {
            this.lLX.start();
        }
    }

    public void vx(boolean z) {
        this.lLV = z;
    }

    public void PR(String str) {
        this.lLH.BI(str);
    }

    public void vy(boolean z) {
        this.lLD.aN(z);
    }

    public void vz(boolean z) {
        if (z) {
            this.lLq.setVisibility(0);
        } else {
            this.lLq.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bmU().a(this.lLB, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a(this.kcd, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a(this.lLC, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lLE.bok();
        this.lLD.onChangeSkinType(i);
        SvgManager.bmU().a(this.lLp, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.lLK.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bmU().a(this.lLQ, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a(this.lLT, R.drawable.ic_icon_mask_wo_yujin_16, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eig, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLo, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLt, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLu, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLw, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLx, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLz, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLA, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLP, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.lLS, R.color.cp_cont_a, 1, i);
        ap.setImageResource(this.lLq, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.lLM, R.drawable.person_header_bg, i);
        this.lLJ.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bmU().a(this.lLG, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.lLL != null) {
                this.lLL.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.lLK != null) {
                this.lLK.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.lLL != null) {
                this.lLL.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.lLK != null) {
                this.lLK.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.lLL != null) {
                this.lLL.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.lLK != null) {
                this.lLK.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dqb() {
        return this.lLF;
    }

    public FollowUserSpinnerBtn dqc() {
        return this.lLD;
    }

    public View dqd() {
        return this.lLE;
    }

    public TextView getUserName() {
        return this.eig;
    }

    public TextView dqe() {
        return this.lLo;
    }

    public UserIconBox dqf() {
        return this.lLr;
    }

    public FrameLayout dqg() {
        return this.lLs;
    }

    public FrameLayout dqh() {
        return this.lLv;
    }

    public FrameLayout dqi() {
        return this.lLy;
    }

    public HeadPendantView dqj() {
        return this.lLH;
    }

    public View dqk() {
        return this.lLO;
    }

    public View dql() {
        return this.lLR;
    }

    public ImageView dqm() {
        return this.lLp;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lMb = aVar;
    }

    public void onDestroy() {
        if (this.gRO != null) {
            this.gRO.cancel();
        }
        if (this.lLL != null) {
            this.lLL.cancelAnimation();
        }
        if (this.lLX != null) {
            this.lLX.cancel();
        }
        if (this.lLU != null) {
            this.lLU.onDestory();
        }
    }
}
