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
    public static final int mCB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView eIO;
    private AnimatorSet hEc;
    private ImageView kRl;
    private boolean ltY;
    private TextView mBS;
    private ImageView mBT;
    private ImageView mBU;
    private UserIconBox mBV;
    private FrameLayout mBW;
    private TextView mBX;
    private TextView mBY;
    private FrameLayout mBZ;
    private com.baidu.tieba.j.b mBd;
    private boolean mCA;
    private AnimatorSet mCC;
    private ValueAnimator mCD;
    private ObjectAnimator mCE;
    private ObjectAnimator mCF;
    private com.baidu.tieba.personPolymeric.b.a mCG;
    private boolean mCH;
    private TextView mCa;
    private TextView mCb;
    private FrameLayout mCc;
    private TextView mCd;
    private TextView mCe;
    private ImageView mCf;
    private ImageView mCg;
    private FollowUserSpinnerBtn mCh;
    private TBSpecificationBtn mCi;
    private TbImageView mCj;
    private ImageView mCk;
    private HeadPendantView mCl;
    private View.OnClickListener mClickListener;
    private RelativeLayout mCm;
    private GodRecommendLayout mCn;
    private ImageView mCo;
    private TBLottieAnimationView mCp;
    private View mCq;
    private ViewGroup mCr;
    private View mCs;
    private TextView mCt;
    private ImageView mCu;
    private View mCw;
    private TextView mCx;
    private ImageView mCy;
    private com.baidu.tieba.model.c mCz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private FollowUserSpinnerBtn.a mCI = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void av(boolean z, boolean z2) {
            if (bh.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.mCH = z2;
                b.this.ltY = false;
                if (z) {
                    b.this.mCn.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.mCz.bD(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mCn.setCouldStatistic(false);
                    b.this.mCA = false;
                    b.this.dyI();
                    if (b.this.mCC != null) {
                        b.this.mCC.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new ar("c13900"));
                }
            }
        }
    };
    private c.a ltX = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mCn.setData(qVar.dyH());
                if (!b.this.ltY) {
                    b.this.mCA = true;
                    b.this.dyI();
                    if (b.this.mCC != null) {
                        b.this.mCC.start();
                    }
                }
                TiebaStatic.log(new ar("c13901").ap("obj_type", b.this.mCH ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqD();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bqD();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bqD();
            }
        }
    };
    private View.OnClickListener mCJ = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.mCz != null && b.this.mUserData != null) {
                b.this.ltY = true;
                b.this.mCz.request(b.this.mUserData.getPortrait());
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
        this.mBS = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.mBS.setAlpha(0.85f);
        this.mBS.setOnClickListener(this.mClickListener);
        this.mBT = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mBT.setOnClickListener(this.mClickListener);
        this.mBV = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mBV.setOnClickListener(this.mClickListener);
        this.mBV.setAutoChangedStyle(false);
        this.mBX = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mBW = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mBW.setOnClickListener(this.mClickListener);
        this.mBY = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mBY.setAlpha(0.8f);
        this.kRl = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.mBU = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mCa = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mBZ = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mBZ.setOnClickListener(this.mClickListener);
        this.mCb = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mCb.setAlpha(0.8f);
        this.mCg = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mCd = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mCc = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mCc.setOnClickListener(this.mClickListener);
        this.mCe = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mCe.setAlpha(0.8f);
        this.mCf = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mCh = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mCh.i(this.mClickListener);
        this.mCh.setOpenListener(this.mCI);
        this.mCi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mCi.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.pV(R.color.CAM_X0101);
        dVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mCi.setConfig(dVar);
        this.mCj = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mCj.setOnClickListener(this.mClickListener);
        this.mCk = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mCl = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mCl.setHasPendantStyle();
        this.mCl.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mCl.getHeadView().setIsRound(true);
        this.mCl.getHeadView().setDrawBorder(false);
        this.mCl.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mCl.setOnClickListener(this.mClickListener);
        this.mCl.setBigVDimenSize(R.dimen.tbds57);
        this.mCl.setAuthIconType(3);
        this.mCl.setShowSimpleIcon(false);
        this.mCl.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.mCq = this.mRootView.findViewById(R.id.person_header_ring);
        this.mCq.setAlpha(0.33f);
        this.mCn = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mCn.setPageContext(this.mPageContext);
        this.mCn.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mCn.setRefreshListener(this.mCJ);
        this.mCz = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.mCz.a(this.ltX);
        this.mCr = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mCs = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mCt = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mCu = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mCs.setOnClickListener(this.mClickListener);
        this.mCw = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.mCx = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.mCy = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.mCw.setOnClickListener(this.mClickListener);
        this.mCo = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mCp = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mCm = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Ii() {
        this.mCD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mCD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.mCB;
                ViewGroup.LayoutParams layoutParams = b.this.mCn.getLayoutParams();
                if (b.this.mCA) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.mCB - floatValue);
                }
                if (b.this.mCG != null) {
                    b.this.mCG.CC(b.this.mCA ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mCn.setLayoutParams(layoutParams);
                b.this.mCn.onChangeSkinType();
            }
        });
        this.mCD.setDuration(260L);
        this.mCD.setInterpolator(new LinearInterpolator());
        this.mCE = ObjectAnimator.ofFloat(this.mCn, "alpha", 0.0f);
        this.mCE.setDuration(240L);
        this.mCE.setInterpolator(new LinearInterpolator());
        this.mCF = ObjectAnimator.ofFloat(this.mCh.getArrow(), "rotation", 0.0f);
        this.mCF.setDuration(100L);
        this.mCC = new AnimatorSet();
        this.mCC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mCn.getLayoutParams();
                if (b.this.mCA) {
                    layoutParams.height = b.mCB;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mCn.setLayoutParams(layoutParams);
                if (b.this.mCG != null) {
                    b.this.mCG.hS(b.this.mCA);
                }
            }
        });
        this.mCC.play(this.mCD).with(this.mCE).with(this.mCF);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mBd = bVar;
            if (!au.isEmpty(this.mUserData.getName_show())) {
                this.eIO.setText(this.mUserData.getName_show());
            }
            this.mBS.setVisibility(0);
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
                this.mBS.setVisibility(0);
                this.mBS.setText(intro);
                this.mBS.setEnabled(true);
                e.mA().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.mBS.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.mBS.setEnabled(false);
                                } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.mBS.setEnabled(false);
                                }
                                b.this.mBT.setVisibility(8);
                                return;
                            }
                            b.this.mBT.setVisibility(0);
                        }
                    }
                });
            } else {
                this.mBS.setVisibility(8);
            }
            this.mBV.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.mBX.setText(au.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mCd.setText(au.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mCa.setText(au.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mCh.setVisibility(8);
                this.mCi.setVisibility(8);
            } else {
                this.mCi.setVisibility(0);
                this.mCh.setVisibility(0);
                this.mCh.setShowPullBtn(userData.isNewGod());
                this.mCh.setFirstUpdate(true);
                wT(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mCj.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mCj.setVisibility(0);
            } else if (this.mIsHost) {
                this.mCj.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.mCj.setVisibility(0);
            } else {
                this.mCj.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bsR().a(this.mCk, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.mCk.setVisibility(8);
            } else {
                this.mCk.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mCp.setVisibility(0);
                this.mCp.loop(true);
                this.mCp.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mCp.playAnimation();
                    }
                });
                this.mCq.setVisibility(8);
                dX(this.mCm);
                this.mCo.setVisibility(0);
                this.mCl.setIsclearmode(true);
                this.mCl.BA(this.mUserData.getAvater());
            } else {
                this.mCl.a(this.mUserData);
                this.mCo.setVisibility(8);
                this.mCl.setIsclearmode(false);
                this.mCq.setVisibility(0);
            }
            if (this.mBd != null && this.mBd.cOr() && !TextUtils.isEmpty(this.mBd.goods_url)) {
                this.mCs.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "1"));
                }
            } else {
                this.mCs.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.mCx.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.mCw.setVisibility(0);
            } else {
                this.mCw.setVisibility(8);
            }
            if (this.mCs.getVisibility() == 0 || this.mCw.getVisibility() == 0) {
                this.mCr.setVisibility(0);
            } else {
                this.mCr.setVisibility(8);
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
        this.hEc = new AnimatorSet();
        this.hEc.play(ofFloat).with(ofFloat2);
        this.hEc.start();
    }

    public void dyI() {
        if (this.mCE != null) {
            if (this.mCA) {
                this.mCE.setFloatValues(0.0f, 1.0f);
            } else {
                this.mCE.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.mCF != null) {
            if (this.mCA) {
                this.mCF.setFloatValues(0.0f, 180.0f);
            } else {
                this.mCF.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dyJ() {
        if (this.mCC != null) {
            this.mCC.start();
        }
    }

    public void wS(boolean z) {
        this.mCA = z;
    }

    public void Qz(String str) {
        this.mCl.Bz(str);
    }

    public void wT(boolean z) {
        this.mCh.aM(z);
    }

    public void wU(boolean z) {
        if (z) {
            this.mBU.setVisibility(0);
        } else {
            this.mBU.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsR().a(this.mCf, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.kRl, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.mCg, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mCi.bup();
        this.mCh.onChangeSkinType(i);
        SvgManager.bsR().a(this.mBT, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mCo.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bsR().a(this.mCu, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.mCy, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mBS, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mBX, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mBY, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCa, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCb, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCd, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCe, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCt, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mCx, R.color.CAM_X0101, 1, i);
        ap.setImageResource(this.mBU, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.mCq, R.drawable.person_header_bg, i);
        this.mCn.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bsR().a(this.mCk, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mCp != null) {
                this.mCp.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mCo != null) {
                this.mCo.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mCp != null) {
                this.mCp.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mCo != null) {
                this.mCo.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mCp != null) {
                this.mCp.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mCo != null) {
                this.mCo.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dyK() {
        return this.mCj;
    }

    public FollowUserSpinnerBtn dyL() {
        return this.mCh;
    }

    public View dyM() {
        return this.mCi;
    }

    public TextView getUserName() {
        return this.eIO;
    }

    public TextView dyN() {
        return this.mBS;
    }

    public UserIconBox dyO() {
        return this.mBV;
    }

    public FrameLayout dyP() {
        return this.mBW;
    }

    public FrameLayout dyQ() {
        return this.mBZ;
    }

    public FrameLayout dyR() {
        return this.mCc;
    }

    public HeadPendantView dyS() {
        return this.mCl;
    }

    public View dyT() {
        return this.mCs;
    }

    public View dyU() {
        return this.mCw;
    }

    public ImageView dyV() {
        return this.mBT;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mCG = aVar;
    }

    public void onDestroy() {
        if (this.hEc != null) {
            this.hEc.cancel();
        }
        if (this.mCp != null) {
            this.mCp.cancelAnimation();
        }
        if (this.mCC != null) {
            this.mCC.cancel();
        }
        if (this.mCz != null) {
            this.mCz.onDestory();
        }
    }
}
