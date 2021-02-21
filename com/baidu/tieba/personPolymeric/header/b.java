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
/* loaded from: classes8.dex */
public class b {
    public static final int mCQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eIO;
    private AnimatorSet hEq;
    private ImageView kRz;
    private boolean lum;
    private com.baidu.tieba.j.b mBt;
    private ImageView mCA;
    private HeadPendantView mCB;
    private RelativeLayout mCC;
    private GodRecommendLayout mCD;
    private ImageView mCE;
    private TBLottieAnimationView mCF;
    private View mCG;
    private ViewGroup mCH;
    private View mCI;
    private TextView mCJ;
    private ImageView mCK;
    private View mCL;
    private TextView mCM;
    private ImageView mCN;
    private com.baidu.tieba.model.c mCO;
    private boolean mCP;
    private AnimatorSet mCR;
    private ValueAnimator mCS;
    private ObjectAnimator mCT;
    private ObjectAnimator mCU;
    private com.baidu.tieba.personPolymeric.b.a mCV;
    private boolean mCW;
    private TextView mCh;
    private ImageView mCi;
    private ImageView mCj;
    private UserIconBox mCk;
    private FrameLayout mCl;
    private View.OnClickListener mClickListener;
    private TextView mCm;
    private TextView mCn;
    private FrameLayout mCo;
    private TextView mCp;
    private TextView mCq;
    private FrameLayout mCr;
    private TextView mCs;
    private TextView mCt;
    private ImageView mCu;
    private ImageView mCw;
    private FollowUserSpinnerBtn mCx;
    private TBSpecificationBtn mCy;
    private TbImageView mCz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a mCX = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void av(boolean z, boolean z2) {
            if (bh.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.mCW = z2;
                b.this.lum = false;
                if (z) {
                    b.this.mCD.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.mCO.bD(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mCD.setCouldStatistic(false);
                    b.this.mCP = false;
                    b.this.dyP();
                    if (b.this.mCR != null) {
                        b.this.mCR.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new ar("c13900"));
                }
            }
        }
    };
    private c.a lul = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mCD.setData(qVar.dyO());
                if (!b.this.lum) {
                    b.this.mCP = true;
                    b.this.dyP();
                    if (b.this.mCR != null) {
                        b.this.mCR.start();
                    }
                }
                TiebaStatic.log(new ar("c13901").ap("obj_type", b.this.mCW ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqD();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bqD();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bqD();
            }
        }
    };
    private View.OnClickListener mCY = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.mCO != null && b.this.mUserData != null) {
                b.this.lum = true;
                b.this.mCO.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new ar("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Ii();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.eIO = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.eIO.setOnClickListener(this.mClickListener);
        this.mCh = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.mCh.setAlpha(0.85f);
        this.mCh.setOnClickListener(this.mClickListener);
        this.mCi = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mCi.setOnClickListener(this.mClickListener);
        this.mCk = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mCk.setOnClickListener(this.mClickListener);
        this.mCk.setAutoChangedStyle(false);
        this.mCm = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mCl = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mCl.setOnClickListener(this.mClickListener);
        this.mCn = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mCn.setAlpha(0.8f);
        this.kRz = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.mCj = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mCp = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mCo = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mCo.setOnClickListener(this.mClickListener);
        this.mCq = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mCq.setAlpha(0.8f);
        this.mCw = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mCs = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mCr = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mCr.setOnClickListener(this.mClickListener);
        this.mCt = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mCt.setAlpha(0.8f);
        this.mCu = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mCx = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mCx.i(this.mClickListener);
        this.mCx.setOpenListener(this.mCX);
        this.mCy = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mCy.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pV(R.color.CAM_X0101);
        dVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mCy.setConfig(dVar);
        this.mCz = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mCz.setOnClickListener(this.mClickListener);
        this.mCA = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mCB = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mCB.setHasPendantStyle();
        this.mCB.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mCB.getHeadView().setIsRound(true);
        this.mCB.getHeadView().setDrawBorder(false);
        this.mCB.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mCB.setOnClickListener(this.mClickListener);
        this.mCB.setBigVDimenSize(R.dimen.tbds57);
        this.mCB.setAuthIconType(3);
        this.mCB.setShowSimpleIcon(false);
        this.mCB.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.mCG = this.mRootView.findViewById(R.id.person_header_ring);
        this.mCG.setAlpha(0.33f);
        this.mCD = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mCD.setPageContext(this.mPageContext);
        this.mCD.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mCD.setRefreshListener(this.mCY);
        this.mCO = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.mCO.a(this.lul);
        this.mCH = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mCI = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mCJ = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mCK = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mCI.setOnClickListener(this.mClickListener);
        this.mCL = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.mCM = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.mCN = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.mCL.setOnClickListener(this.mClickListener);
        this.mCE = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mCF = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mCC = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Ii() {
        this.mCS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mCS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.mCQ;
                ViewGroup.LayoutParams layoutParams = b.this.mCD.getLayoutParams();
                if (b.this.mCP) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.mCQ - floatValue);
                }
                if (b.this.mCV != null) {
                    b.this.mCV.CC(b.this.mCP ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mCD.setLayoutParams(layoutParams);
                b.this.mCD.onChangeSkinType();
            }
        });
        this.mCS.setDuration(260L);
        this.mCS.setInterpolator(new LinearInterpolator());
        this.mCT = ObjectAnimator.ofFloat(this.mCD, "alpha", 0.0f);
        this.mCT.setDuration(240L);
        this.mCT.setInterpolator(new LinearInterpolator());
        this.mCU = ObjectAnimator.ofFloat(this.mCx.getArrow(), "rotation", 0.0f);
        this.mCU.setDuration(100L);
        this.mCR = new AnimatorSet();
        this.mCR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mCD.getLayoutParams();
                if (b.this.mCP) {
                    layoutParams.height = b.mCQ;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mCD.setLayoutParams(layoutParams);
                if (b.this.mCV != null) {
                    b.this.mCV.hS(b.this.mCP);
                }
            }
        });
        this.mCR.play(this.mCS).with(this.mCT).with(this.mCU);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mBt = bVar;
            if (!au.isEmpty(this.mUserData.getName_show())) {
                this.eIO.setText(this.mUserData.getName_show());
            }
            this.mCh.setVisibility(0);
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
                this.mCh.setVisibility(0);
                this.mCh.setText(intro);
                this.mCh.setEnabled(true);
                e.mA().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.mCh.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.mCh.setEnabled(false);
                                } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.mCh.setEnabled(false);
                                }
                                b.this.mCi.setVisibility(8);
                                return;
                            }
                            b.this.mCi.setVisibility(0);
                        }
                    }
                });
            } else {
                this.mCh.setVisibility(8);
            }
            this.mCk.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.mCm.setText(au.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mCs.setText(au.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mCp.setText(au.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mCx.setVisibility(8);
                this.mCy.setVisibility(8);
            } else {
                this.mCy.setVisibility(0);
                this.mCx.setVisibility(0);
                this.mCx.setShowPullBtn(userData.isNewGod());
                this.mCx.setFirstUpdate(true);
                wT(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mCz.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mCz.setVisibility(0);
            } else if (this.mIsHost) {
                this.mCz.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.mCz.setVisibility(0);
            } else {
                this.mCz.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bsR().a(this.mCA, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.mCA.setVisibility(8);
            } else {
                this.mCA.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mCF.setVisibility(0);
                this.mCF.loop(true);
                this.mCF.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mCF.playAnimation();
                    }
                });
                this.mCG.setVisibility(8);
                dX(this.mCC);
                this.mCE.setVisibility(0);
                this.mCB.setIsclearmode(true);
                this.mCB.BA(this.mUserData.getAvater());
            } else {
                this.mCB.a(this.mUserData);
                this.mCE.setVisibility(8);
                this.mCB.setIsclearmode(false);
                this.mCG.setVisibility(0);
            }
            if (this.mBt != null && this.mBt.cOy() && !TextUtils.isEmpty(this.mBt.goods_url)) {
                this.mCI.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "1"));
                }
            } else {
                this.mCI.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.mCM.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.mCL.setVisibility(0);
            } else {
                this.mCL.setVisibility(8);
            }
            if (this.mCI.getVisibility() == 0 || this.mCL.getVisibility() == 0) {
                this.mCH.setVisibility(0);
            } else {
                this.mCH.setVisibility(8);
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
        this.hEq = new AnimatorSet();
        this.hEq.play(ofFloat).with(ofFloat2);
        this.hEq.start();
    }

    public void dyP() {
        if (this.mCT != null) {
            if (this.mCP) {
                this.mCT.setFloatValues(0.0f, 1.0f);
            } else {
                this.mCT.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.mCU != null) {
            if (this.mCP) {
                this.mCU.setFloatValues(0.0f, 180.0f);
            } else {
                this.mCU.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dyQ() {
        if (this.mCR != null) {
            this.mCR.start();
        }
    }

    public void wS(boolean z) {
        this.mCP = z;
    }

    public void QA(String str) {
        this.mCB.Bz(str);
    }

    public void wT(boolean z) {
        this.mCx.aM(z);
    }

    public void wU(boolean z) {
        if (z) {
            this.mCj.setVisibility(0);
        } else {
            this.mCj.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsR().a(this.mCu, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.kRz, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.mCw, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mCy.bup();
        this.mCx.onChangeSkinType(i);
        SvgManager.bsR().a(this.mCi, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mCE.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bsR().a(this.mCK, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.mCN, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCh, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCm, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCn, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCp, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCq, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCs, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCt, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCJ, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCM, R.color.CAM_X0101, 1, i);
        ap.setImageResource(this.mCj, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.mCG, R.drawable.person_header_bg, i);
        this.mCD.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bsR().a(this.mCA, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mCF != null) {
                this.mCF.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mCE != null) {
                this.mCE.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mCF != null) {
                this.mCF.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mCE != null) {
                this.mCE.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mCF != null) {
                this.mCF.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mCE != null) {
                this.mCE.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dyR() {
        return this.mCz;
    }

    public FollowUserSpinnerBtn dyS() {
        return this.mCx;
    }

    public View dyT() {
        return this.mCy;
    }

    public TextView getUserName() {
        return this.eIO;
    }

    public TextView dyU() {
        return this.mCh;
    }

    public UserIconBox dyV() {
        return this.mCk;
    }

    public FrameLayout dyW() {
        return this.mCl;
    }

    public FrameLayout dyX() {
        return this.mCo;
    }

    public FrameLayout dyY() {
        return this.mCr;
    }

    public HeadPendantView dyZ() {
        return this.mCB;
    }

    public View dza() {
        return this.mCI;
    }

    public View dzb() {
        return this.mCL;
    }

    public ImageView dzc() {
        return this.mCi;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mCV = aVar;
    }

    public void onDestroy() {
        if (this.hEq != null) {
            this.hEq.cancel();
        }
        if (this.mCF != null) {
            this.mCF.cancelAnimation();
        }
        if (this.mCR != null) {
            this.mCR.cancel();
        }
        if (this.mCO != null) {
            this.mCO.onDestory();
        }
    }
}
