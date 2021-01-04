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
    public static final int myf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eLt;
    private AnimatorSet hEy;
    private ImageView kNN;
    private boolean lqB;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private com.baidu.tieba.j.b mwJ;
    private UserIconBox mxA;
    private FrameLayout mxB;
    private TextView mxC;
    private TextView mxD;
    private FrameLayout mxE;
    private TextView mxF;
    private TextView mxG;
    private FrameLayout mxH;
    private TextView mxI;
    private TextView mxJ;
    private ImageView mxK;
    private ImageView mxL;
    private FollowUserSpinnerBtn mxM;
    private TBSpecificationBtn mxN;
    private TbImageView mxO;
    private ImageView mxP;
    private HeadPendantView mxQ;
    private RelativeLayout mxR;
    private GodRecommendLayout mxS;
    private ImageView mxT;
    private TBLottieAnimationView mxU;
    private View mxV;
    private ViewGroup mxW;
    private View mxX;
    private TextView mxY;
    private ImageView mxZ;
    private TextView mxx;
    private ImageView mxy;
    private ImageView mxz;
    private View mya;
    private TextView myb;
    private ImageView myc;
    private com.baidu.tieba.model.c myd;
    private boolean mye;
    private AnimatorSet myg;
    private ValueAnimator myh;
    private ObjectAnimator myi;
    private ObjectAnimator myj;
    private com.baidu.tieba.personPolymeric.b.a myk;
    private boolean myl;
    private FollowUserSpinnerBtn.a mym = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void av(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.myl = z2;
                b.this.lqB = false;
                if (z) {
                    b.this.mxS.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.myd.bC(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mxS.setCouldStatistic(false);
                    b.this.mye = false;
                    b.this.dAq();
                    if (b.this.myg != null) {
                        b.this.myg.start();
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
                b.this.mxS.setData(qVar.dAp());
                if (!b.this.lqB) {
                    b.this.mye = true;
                    b.this.dAq();
                    if (b.this.myg != null) {
                        b.this.myg.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").an("obj_type", b.this.myl ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bud();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bud();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bud();
            }
        }
    };
    private View.OnClickListener myn = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.myd != null && b.this.mUserData != null) {
                b.this.lqB = true;
                b.this.myd.request(b.this.mUserData.getPortrait());
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
        this.mxx = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.mxx.setAlpha(0.85f);
        this.mxx.setOnClickListener(this.mClickListener);
        this.mxy = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mxy.setOnClickListener(this.mClickListener);
        this.mxA = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mxA.setOnClickListener(this.mClickListener);
        this.mxA.setAutoChangedStyle(false);
        this.mxC = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mxB = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mxB.setOnClickListener(this.mClickListener);
        this.mxD = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mxD.setAlpha(0.8f);
        this.kNN = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.mxz = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mxF = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mxE = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mxE.setOnClickListener(this.mClickListener);
        this.mxG = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mxG.setAlpha(0.8f);
        this.mxL = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mxI = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mxH = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mxH.setOnClickListener(this.mClickListener);
        this.mxJ = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mxJ.setAlpha(0.8f);
        this.mxK = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mxM = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mxM.i(this.mClickListener);
        this.mxM.setOpenListener(this.mym);
        this.mxN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mxN.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.rw(R.color.CAM_X0101);
        dVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mxN.setConfig(dVar);
        this.mxO = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mxO.setOnClickListener(this.mClickListener);
        this.mxP = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mxQ = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mxQ.setHasPendantStyle();
        this.mxQ.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mxQ.getHeadView().setIsRound(true);
        this.mxQ.getHeadView().setDrawBorder(false);
        this.mxQ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mxQ.setOnClickListener(this.mClickListener);
        this.mxQ.setBigVDimenSize(R.dimen.tbds57);
        this.mxQ.setAuthIconType(3);
        this.mxQ.setShowSimpleIcon(false);
        this.mxQ.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.mxV = this.mRootView.findViewById(R.id.person_header_ring);
        this.mxV.setAlpha(0.33f);
        this.mxS = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mxS.setPageContext(this.mPageContext);
        this.mxS.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mxS.setRefreshListener(this.myn);
        this.myd = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.myd.a(this.lqA);
        this.mxW = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mxX = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mxY = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mxZ = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mxX.setOnClickListener(this.mClickListener);
        this.mya = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.myb = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.myc = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.mya.setOnClickListener(this.mClickListener);
        this.mxT = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mxU = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mxR = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void KN() {
        this.myh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.myh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.myf;
                ViewGroup.LayoutParams layoutParams = b.this.mxS.getLayoutParams();
                if (b.this.mye) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.myf - floatValue);
                }
                if (b.this.myk != null) {
                    b.this.myk.DR(b.this.mye ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mxS.setLayoutParams(layoutParams);
                b.this.mxS.onChangeSkinType();
            }
        });
        this.myh.setDuration(260L);
        this.myh.setInterpolator(new LinearInterpolator());
        this.myi = ObjectAnimator.ofFloat(this.mxS, "alpha", 0.0f);
        this.myi.setDuration(240L);
        this.myi.setInterpolator(new LinearInterpolator());
        this.myj = ObjectAnimator.ofFloat(this.mxM.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.myj.setDuration(100L);
        this.myg = new AnimatorSet();
        this.myg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mxS.getLayoutParams();
                if (b.this.mye) {
                    layoutParams.height = b.myf;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mxS.setLayoutParams(layoutParams);
                if (b.this.myk != null) {
                    b.this.myk.hU(b.this.mye);
                }
            }
        });
        this.myg.play(this.myh).with(this.myi).with(this.myj);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mwJ = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.eLt.setText(this.mUserData.getName_show());
            }
            this.mxx.setVisibility(0);
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
                this.mxx.setVisibility(0);
                this.mxx.setText(intro);
                this.mxx.setEnabled(true);
                e.mB().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.mxx.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.mxx.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.mxx.setEnabled(false);
                                }
                                b.this.mxy.setVisibility(8);
                                return;
                            }
                            b.this.mxy.setVisibility(0);
                        }
                    }
                });
            } else {
                this.mxx.setVisibility(8);
            }
            this.mxA.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.mxC.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mxI.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mxF.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mxM.setVisibility(8);
                this.mxN.setVisibility(8);
            } else {
                this.mxN.setVisibility(0);
                this.mxM.setVisibility(0);
                this.mxM.setShowPullBtn(userData.isNewGod());
                this.mxM.setFirstUpdate(true);
                wG(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mxO.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mxO.setVisibility(0);
            } else if (this.mIsHost) {
                this.mxO.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
                this.mxO.setVisibility(0);
            } else {
                this.mxO.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bwq().a(this.mxP, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.mxP.setVisibility(8);
            } else {
                this.mxP.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mxU.setVisibility(0);
                this.mxU.loop(true);
                this.mxU.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mxU.playAnimation();
                    }
                });
                this.mxV.setVisibility(8);
                dZ(this.mxR);
                this.mxT.setVisibility(0);
                this.mxQ.setIsclearmode(true);
                this.mxQ.Cv(this.mUserData.getAvater());
            } else {
                this.mxQ.a(this.mUserData);
                this.mxT.setVisibility(8);
                this.mxQ.setIsclearmode(false);
                this.mxV.setVisibility(0);
            }
            if (this.mwJ != null && this.mwJ.cQl() && !TextUtils.isEmpty(this.mwJ.goods_url)) {
                this.mxX.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dX("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new aq("c13612").dX("obj_param1", "1"));
                }
            } else {
                this.mxX.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.myb.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.mya.setVisibility(0);
            } else {
                this.mya.setVisibility(8);
            }
            if (this.mxX.getVisibility() == 0 || this.mya.getVisibility() == 0) {
                this.mxW.setVisibility(0);
            } else {
                this.mxW.setVisibility(8);
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

    public void dAq() {
        if (this.myi != null) {
            if (this.mye) {
                this.myi.setFloatValues(0.0f, 1.0f);
            } else {
                this.myi.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.myj != null) {
            if (this.mye) {
                this.myj.setFloatValues(0.0f, 180.0f);
            } else {
                this.myj.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dAr() {
        if (this.myg != null) {
            this.myg.start();
        }
    }

    public void wF(boolean z) {
        this.mye = z;
    }

    public void QQ(String str) {
        this.mxQ.Cu(str);
    }

    public void wG(boolean z) {
        this.mxM.aM(z);
    }

    public void wH(boolean z) {
        if (z) {
            this.mxz.setVisibility(0);
        } else {
            this.mxz.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bwq().a(this.mxK, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a(this.kNN, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a(this.mxL, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mxN.bxO();
        this.mxM.onChangeSkinType(i);
        SvgManager.bwq().a(this.mxy, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mxT.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bwq().a(this.mxZ, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a(this.myc, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxx, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxC, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxD, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxF, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxG, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxI, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxJ, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.mxY, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.myb, R.color.CAM_X0101, 1, i);
        ao.setImageResource(this.mxz, R.drawable.icon_news_down_bar_one);
        ao.setBackgroundResource(this.mxV, R.drawable.person_header_bg, i);
        this.mxS.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bwq().a(this.mxP, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mxU != null) {
                this.mxU.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mxT != null) {
                this.mxT.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mxU != null) {
                this.mxU.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mxT != null) {
                this.mxT.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mxU != null) {
                this.mxU.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mxT != null) {
                this.mxT.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dAs() {
        return this.mxO;
    }

    public FollowUserSpinnerBtn dAt() {
        return this.mxM;
    }

    public View dAu() {
        return this.mxN;
    }

    public TextView getUserName() {
        return this.eLt;
    }

    public TextView dAv() {
        return this.mxx;
    }

    public UserIconBox dAw() {
        return this.mxA;
    }

    public FrameLayout dAx() {
        return this.mxB;
    }

    public FrameLayout dAy() {
        return this.mxE;
    }

    public FrameLayout dAz() {
        return this.mxH;
    }

    public HeadPendantView dAA() {
        return this.mxQ;
    }

    public View dAB() {
        return this.mxX;
    }

    public View dAC() {
        return this.mya;
    }

    public ImageView dAD() {
        return this.mxy;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.myk = aVar;
    }

    public void onDestroy() {
        if (this.hEy != null) {
            this.hEy.cancel();
        }
        if (this.mxU != null) {
            this.mxU.cancelAnimation();
        }
        if (this.myg != null) {
            this.myg.cancel();
        }
        if (this.myd != null) {
            this.myd.onDestory();
        }
    }
}
