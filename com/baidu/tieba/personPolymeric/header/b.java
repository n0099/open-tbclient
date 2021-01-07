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
/* loaded from: classes8.dex */
public class b {
    public static final int mye = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eLt;
    private AnimatorSet hEy;
    private ImageView kNN;
    private boolean lqB;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private com.baidu.tieba.j.b mwI;
    private FrameLayout mxA;
    private TextView mxB;
    private TextView mxC;
    private FrameLayout mxD;
    private TextView mxE;
    private TextView mxF;
    private FrameLayout mxG;
    private TextView mxH;
    private TextView mxI;
    private ImageView mxJ;
    private ImageView mxK;
    private FollowUserSpinnerBtn mxL;
    private TBSpecificationBtn mxM;
    private TbImageView mxN;
    private ImageView mxO;
    private HeadPendantView mxP;
    private RelativeLayout mxQ;
    private GodRecommendLayout mxR;
    private ImageView mxS;
    private TBLottieAnimationView mxT;
    private View mxU;
    private ViewGroup mxV;
    private View mxW;
    private TextView mxX;
    private ImageView mxY;
    private View mxZ;
    private TextView mxw;
    private ImageView mxx;
    private ImageView mxy;
    private UserIconBox mxz;
    private TextView mya;
    private ImageView myb;
    private com.baidu.tieba.model.c myc;
    private boolean myd;
    private AnimatorSet myf;
    private ValueAnimator myg;
    private ObjectAnimator myh;
    private ObjectAnimator myi;
    private com.baidu.tieba.personPolymeric.b.a myj;
    private boolean myk;
    private FollowUserSpinnerBtn.a myl = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void av(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.myk = z2;
                b.this.lqB = false;
                if (z) {
                    b.this.mxR.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.myc.bC(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mxR.setCouldStatistic(false);
                    b.this.myd = false;
                    b.this.dAr();
                    if (b.this.myf != null) {
                        b.this.myf.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a lqA = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mxR.setData(qVar.dAq());
                if (!b.this.lqB) {
                    b.this.myd = true;
                    b.this.dAr();
                    if (b.this.myf != null) {
                        b.this.myf.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").an("obj_type", b.this.myk ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bue();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bue();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bue();
            }
        }
    };
    private View.OnClickListener mym = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.myc != null && b.this.mUserData != null) {
                b.this.lqB = true;
                b.this.myc.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        KN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eLt = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eLt.setOnClickListener(this.mClickListener);
        this.mxw = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.mxw.setAlpha(0.85f);
        this.mxw.setOnClickListener(this.mClickListener);
        this.mxx = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mxx.setOnClickListener(this.mClickListener);
        this.mxz = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mxz.setOnClickListener(this.mClickListener);
        this.mxz.setAutoChangedStyle(false);
        this.mxB = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mxA = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mxA.setOnClickListener(this.mClickListener);
        this.mxC = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mxC.setAlpha(0.8f);
        this.kNN = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.mxy = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mxE = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mxD = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mxD.setOnClickListener(this.mClickListener);
        this.mxF = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mxF.setAlpha(0.8f);
        this.mxK = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mxH = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mxG = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mxG.setOnClickListener(this.mClickListener);
        this.mxI = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mxI.setAlpha(0.8f);
        this.mxJ = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mxL = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mxL.i(this.mClickListener);
        this.mxL.setOpenListener(this.myl);
        this.mxM = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mxM.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.rw(R.color.CAM_X0101);
        dVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mxM.setConfig(dVar);
        this.mxN = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mxN.setOnClickListener(this.mClickListener);
        this.mxO = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mxP = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mxP.setHasPendantStyle();
        this.mxP.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mxP.getHeadView().setIsRound(true);
        this.mxP.getHeadView().setDrawBorder(false);
        this.mxP.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mxP.setOnClickListener(this.mClickListener);
        this.mxP.setBigVDimenSize(R.dimen.tbds57);
        this.mxP.setAuthIconType(3);
        this.mxP.setShowSimpleIcon(false);
        this.mxP.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.mxU = this.mRootView.findViewById(R.id.person_header_ring);
        this.mxU.setAlpha(0.33f);
        this.mxR = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mxR.setPageContext(this.mPageContext);
        this.mxR.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mxR.setRefreshListener(this.mym);
        this.myc = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.myc.a(this.lqA);
        this.mxV = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mxW = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mxX = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mxY = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mxW.setOnClickListener(this.mClickListener);
        this.mxZ = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.mya = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.myb = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.mxZ.setOnClickListener(this.mClickListener);
        this.mxS = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mxT = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mxQ = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void KN() {
        this.myg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.myg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.mye;
                ViewGroup.LayoutParams layoutParams = b.this.mxR.getLayoutParams();
                if (b.this.myd) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.mye - floatValue);
                }
                if (b.this.myj != null) {
                    b.this.myj.DR(b.this.myd ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mxR.setLayoutParams(layoutParams);
                b.this.mxR.onChangeSkinType();
            }
        });
        this.myg.setDuration(260L);
        this.myg.setInterpolator(new LinearInterpolator());
        this.myh = ObjectAnimator.ofFloat(this.mxR, "alpha", 0.0f);
        this.myh.setDuration(240L);
        this.myh.setInterpolator(new LinearInterpolator());
        this.myi = ObjectAnimator.ofFloat(this.mxL.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.myi.setDuration(100L);
        this.myf = new AnimatorSet();
        this.myf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mxR.getLayoutParams();
                if (b.this.myd) {
                    layoutParams.height = b.mye;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mxR.setLayoutParams(layoutParams);
                if (b.this.myj != null) {
                    b.this.myj.hU(b.this.myd);
                }
            }
        });
        this.myf.play(this.myg).with(this.myh).with(this.myi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mwI = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.eLt.setText(this.mUserData.getName_show());
            }
            this.mxw.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (this.mUserData.isNewGod() && !at.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + ag.lB(this.mUserData.getNewGodData().isVideoGod()));
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
                this.mxw.setVisibility(0);
                this.mxw.setText(intro);
                this.mxw.setEnabled(true);
                e.mB().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.mxw.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.mxw.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.mxw.setEnabled(false);
                                }
                                b.this.mxx.setVisibility(8);
                                return;
                            }
                            b.this.mxx.setVisibility(0);
                        }
                    }
                });
            } else {
                this.mxw.setVisibility(8);
            }
            this.mxz.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.mxB.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mxH.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mxE.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mxL.setVisibility(8);
                this.mxM.setVisibility(8);
            } else {
                this.mxM.setVisibility(0);
                this.mxL.setVisibility(0);
                this.mxL.setShowPullBtn(userData.isNewGod());
                this.mxL.setFirstUpdate(true);
                wG(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mxN.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mxN.setVisibility(0);
            } else if (this.mIsHost) {
                this.mxN.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
                this.mxN.setVisibility(0);
            } else {
                this.mxN.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bwr().a(this.mxO, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.mxO.setVisibility(8);
            } else {
                this.mxO.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mxT.setVisibility(0);
                this.mxT.loop(true);
                this.mxT.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mxT.playAnimation();
                    }
                });
                this.mxU.setVisibility(8);
                dZ(this.mxQ);
                this.mxS.setVisibility(0);
                this.mxP.setIsclearmode(true);
                this.mxP.Cu(this.mUserData.getAvater());
            } else {
                this.mxP.a(this.mUserData);
                this.mxS.setVisibility(8);
                this.mxP.setIsclearmode(false);
                this.mxU.setVisibility(0);
            }
            if (this.mwI != null && this.mwI.cQm() && !TextUtils.isEmpty(this.mwI.goods_url)) {
                this.mxW.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dX("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new aq("c13612").dX("obj_param1", "1"));
                }
            } else {
                this.mxW.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.mya.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.mxZ.setVisibility(0);
            } else {
                this.mxZ.setVisibility(8);
            }
            if (this.mxW.getVisibility() == 0 || this.mxZ.getVisibility() == 0) {
                this.mxV.setVisibility(0);
            } else {
                this.mxV.setVisibility(8);
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
        this.hEy = new AnimatorSet();
        this.hEy.play(ofFloat).with(ofFloat2);
        this.hEy.start();
    }

    public void dAr() {
        if (this.myh != null) {
            if (this.myd) {
                this.myh.setFloatValues(0.0f, 1.0f);
            } else {
                this.myh.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.myi != null) {
            if (this.myd) {
                this.myi.setFloatValues(0.0f, 180.0f);
            } else {
                this.myi.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dAs() {
        if (this.myf != null) {
            this.myf.start();
        }
    }

    public void wF(boolean z) {
        this.myd = z;
    }

    public void QP(String str) {
        this.mxP.Ct(str);
    }

    public void wG(boolean z) {
        this.mxL.aM(z);
    }

    public void wH(boolean z) {
        if (z) {
            this.mxy.setVisibility(0);
        } else {
            this.mxy.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bwr().a(this.mxJ, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a(this.kNN, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a(this.mxK, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mxM.bxP();
        this.mxL.onChangeSkinType(i);
        SvgManager.bwr().a(this.mxx, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mxS.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bwr().a(this.mxY, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a(this.myb, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxw, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxB, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxC, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxE, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxF, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxH, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxI, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxX, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mya, R.color.CAM_X0101, 1, i);
        ao.setImageResource(this.mxy, R.drawable.icon_news_down_bar_one);
        ao.setBackgroundResource(this.mxU, R.drawable.person_header_bg, i);
        this.mxR.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bwr().a(this.mxO, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mxT != null) {
                this.mxT.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mxS != null) {
                this.mxS.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mxT != null) {
                this.mxT.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mxS != null) {
                this.mxS.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mxT != null) {
                this.mxT.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mxS != null) {
                this.mxS.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dAt() {
        return this.mxN;
    }

    public FollowUserSpinnerBtn dAu() {
        return this.mxL;
    }

    public View dAv() {
        return this.mxM;
    }

    public TextView getUserName() {
        return this.eLt;
    }

    public TextView dAw() {
        return this.mxw;
    }

    public UserIconBox dAx() {
        return this.mxz;
    }

    public FrameLayout dAy() {
        return this.mxA;
    }

    public FrameLayout dAz() {
        return this.mxD;
    }

    public FrameLayout dAA() {
        return this.mxG;
    }

    public HeadPendantView dAB() {
        return this.mxP;
    }

    public View dAC() {
        return this.mxW;
    }

    public View dAD() {
        return this.mxZ;
    }

    public ImageView dAE() {
        return this.mxx;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.myj = aVar;
    }

    public void onDestroy() {
        if (this.hEy != null) {
            this.hEy.cancel();
        }
        if (this.mxT != null) {
            this.mxT.cancelAnimation();
        }
        if (this.myf != null) {
            this.myf.cancel();
        }
        if (this.myc != null) {
            this.myc.onDestory();
        }
    }
}
