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
    public static final int mes = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView ewx;
    private AnimatorSet hjx;
    private boolean kXe;
    private ImageView kuy;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private com.baidu.tieba.i.b mcV;
    private TextView mdJ;
    private ImageView mdK;
    private ImageView mdL;
    private UserIconBox mdM;
    private FrameLayout mdN;
    private TextView mdO;
    private TextView mdP;
    private FrameLayout mdQ;
    private TextView mdR;
    private TextView mdS;
    private FrameLayout mdT;
    private TextView mdU;
    private TextView mdV;
    private ImageView mdW;
    private ImageView mdX;
    private FollowUserSpinnerBtn mdY;
    private TBSpecificationBtn mdZ;
    private TbImageView mea;
    private ImageView meb;
    private HeadPendantView mec;
    private RelativeLayout med;
    private GodRecommendLayout mee;
    private ImageView mef;
    private TBLottieAnimationView meg;
    private View meh;
    private ViewGroup mei;
    private View mej;
    private TextView mek;
    private ImageView mel;
    private View men;
    private TextView meo;
    private ImageView mep;
    private com.baidu.tieba.model.c meq;
    private boolean mer;
    private AnimatorSet met;
    private ValueAnimator meu;
    private ObjectAnimator mev;
    private ObjectAnimator mew;
    private com.baidu.tieba.personPolymeric.b.a mex;
    private boolean mey;
    private FollowUserSpinnerBtn.a mez = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void aw(boolean z, boolean z2) {
            if (bg.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.mey = z2;
                b.this.kXe = false;
                if (z) {
                    b.this.mee.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.meq.bv(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mee.setCouldStatistic(false);
                    b.this.mer = false;
                    b.this.dvI();
                    if (b.this.met != null) {
                        b.this.met.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new aq("c13900"));
                }
            }
        }
    };
    private c.a kXd = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mee.setData(qVar.dvH());
                if (!b.this.kXe) {
                    b.this.mer = true;
                    b.this.dvI();
                    if (b.this.met != null) {
                        b.this.met.start();
                    }
                }
                TiebaStatic.log(new aq("c13901").al("obj_type", b.this.mey ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bpi();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bpi();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bpi();
            }
        }
    };
    private View.OnClickListener meA = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.meq != null && b.this.mUserData != null) {
                b.this.kXe = true;
                b.this.meq.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new aq("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        JW();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.ewx = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.ewx.setOnClickListener(this.mClickListener);
        this.mdJ = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.mdJ.setAlpha(0.85f);
        this.mdJ.setOnClickListener(this.mClickListener);
        this.mdK = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mdK.setOnClickListener(this.mClickListener);
        this.mdM = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mdM.setOnClickListener(this.mClickListener);
        this.mdM.setAutoChangedStyle(false);
        this.mdO = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mdN = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mdN.setOnClickListener(this.mClickListener);
        this.mdP = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.mdP.setAlpha(0.8f);
        this.kuy = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.mdL = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mdR = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mdQ = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mdQ.setOnClickListener(this.mClickListener);
        this.mdS = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mdS.setAlpha(0.8f);
        this.mdX = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.mdU = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mdT = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mdT.setOnClickListener(this.mClickListener);
        this.mdV = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.mdV.setAlpha(0.8f);
        this.mdW = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mdY = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mdY.h(this.mClickListener);
        this.mdY.setOpenListener(this.mez);
        this.mdZ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mdZ.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.qm(R.color.cp_cont_a);
        dVar.qd(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mdZ.setConfig(dVar);
        this.mea = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.mea.setOnClickListener(this.mClickListener);
        this.meb = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mec = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mec.setHasPendantStyle();
        this.mec.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mec.getHeadView().setIsRound(true);
        this.mec.getHeadView().setDrawBorder(false);
        this.mec.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mec.setOnClickListener(this.mClickListener);
        this.mec.setBigVDimenSize(R.dimen.tbds57);
        this.mec.setAuthIconType(3);
        this.mec.setShowSimpleIcon(false);
        this.mec.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.meh = this.mRootView.findViewById(R.id.person_header_ring);
        this.meh.setAlpha(0.33f);
        this.mee = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mee.setPageContext(this.mPageContext);
        this.mee.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mee.setRefreshListener(this.meA);
        this.meq = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.meq.a(this.kXd);
        this.mei = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.mej = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.mek = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.mel = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.mej.setOnClickListener(this.mClickListener);
        this.men = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.meo = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.mep = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.men.setOnClickListener(this.mClickListener);
        this.mef = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.meg = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.med = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void JW() {
        this.meu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.meu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.mes;
                ViewGroup.LayoutParams layoutParams = b.this.mee.getLayoutParams();
                if (b.this.mer) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.mes - floatValue);
                }
                if (b.this.mex != null) {
                    b.this.mex.Cq(b.this.mer ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mee.setLayoutParams(layoutParams);
                b.this.mee.onChangeSkinType();
            }
        });
        this.meu.setDuration(260L);
        this.meu.setInterpolator(new LinearInterpolator());
        this.mev = ObjectAnimator.ofFloat(this.mee, "alpha", 0.0f);
        this.mev.setDuration(240L);
        this.mev.setInterpolator(new LinearInterpolator());
        this.mew = ObjectAnimator.ofFloat(this.mdY.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.mew.setDuration(100L);
        this.met = new AnimatorSet();
        this.met.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mee.getLayoutParams();
                if (b.this.mer) {
                    layoutParams.height = b.mes;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mee.setLayoutParams(layoutParams);
                if (b.this.mex != null) {
                    b.this.mex.hk(b.this.mer);
                }
            }
        });
        this.met.play(this.meu).with(this.mev).with(this.mew);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.b bVar) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            this.mcV = bVar;
            if (!at.isEmpty(this.mUserData.getName_show())) {
                this.ewx.setText(this.mUserData.getName_show());
            }
            this.mdJ.setVisibility(0);
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
                this.mdJ.setVisibility(0);
                this.mdJ.setText(intro);
                this.mdJ.setEnabled(true);
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.mdJ.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.mdJ.setEnabled(false);
                                } else if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.mdJ.setEnabled(false);
                                }
                                b.this.mdK.setVisibility(8);
                                return;
                            }
                            b.this.mdK.setVisibility(0);
                        }
                    }
                });
            } else {
                this.mdJ.setVisibility(8);
            }
            this.mdM.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.mdO.setText(at.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.mdU.setText(at.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mdR.setText(at.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mdY.setVisibility(8);
                this.mdZ.setVisibility(8);
            } else {
                this.mdZ.setVisibility(0);
                this.mdY.setVisibility(0);
                this.mdY.setShowPullBtn(userData.isNewGod());
                this.mdY.setFirstUpdate(true);
                vY(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.mea.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.mea.setVisibility(0);
            } else if (this.mIsHost) {
                this.mea.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.mea.setVisibility(0);
            } else {
                this.mea.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.brn().a(this.meb, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.meb.setVisibility(8);
            } else {
                this.meb.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.meg.setVisibility(0);
                this.meg.loop(true);
                this.meg.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.meg.playAnimation();
                    }
                });
                this.meh.setVisibility(8);
                dA(this.med);
                this.mef.setVisibility(0);
                this.mec.setIsclearmode(true);
                this.mec.Cq(this.mUserData.getAvater());
            } else {
                this.mec.a(this.mUserData);
                this.mef.setVisibility(8);
                this.mec.setIsclearmode(false);
                this.meh.setVisibility(0);
            }
            if (this.mcV != null && this.mcV.cIe() && !TextUtils.isEmpty(this.mcV.goods_url)) {
                this.mej.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new aq("c13612").dR("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new aq("c13612").dR("obj_param1", "1"));
                }
            } else {
                this.mej.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.meo.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.men.setVisibility(0);
            } else {
                this.men.setVisibility(8);
            }
            if (this.mej.getVisibility() == 0 || this.men.getVisibility() == 0) {
                this.mei.setVisibility(0);
            } else {
                this.mei.setVisibility(8);
            }
        }
    }

    private void dA(View view) {
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
        this.hjx = new AnimatorSet();
        this.hjx.play(ofFloat).with(ofFloat2);
        this.hjx.start();
    }

    public void dvI() {
        if (this.mev != null) {
            if (this.mer) {
                this.mev.setFloatValues(0.0f, 1.0f);
            } else {
                this.mev.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.mew != null) {
            if (this.mer) {
                this.mew.setFloatValues(0.0f, 180.0f);
            } else {
                this.mew.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dvJ() {
        if (this.met != null) {
            this.met.start();
        }
    }

    public void vX(boolean z) {
        this.mer = z;
    }

    public void QG(String str) {
        this.mec.Cp(str);
    }

    public void vY(boolean z) {
        this.mdY.aN(z);
    }

    public void vZ(boolean z) {
        if (z) {
            this.mdL.setVisibility(0);
        } else {
            this.mdL.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.brn().a(this.mdW, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a(this.kuy, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a(this.mdX, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.mdZ.bsD();
        this.mdY.onChangeSkinType(i);
        SvgManager.brn().a(this.mdK, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.mef.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.brn().a(this.mel, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a(this.mep, R.drawable.ic_icon_mask_wo_yujin_16, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.ewx, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdJ, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdO, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdP, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdR, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdS, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdU, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mdV, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mek, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.meo, R.color.cp_cont_a, 1, i);
        ap.setImageResource(this.mdL, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.meh, R.drawable.person_header_bg, i);
        this.mee.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.brn().a(this.meb, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.meg != null) {
                this.meg.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mef != null) {
                this.mef.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.meg != null) {
                this.meg.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mef != null) {
                this.mef.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.meg != null) {
                this.meg.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mef != null) {
                this.mef.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dvK() {
        return this.mea;
    }

    public FollowUserSpinnerBtn dvL() {
        return this.mdY;
    }

    public View dvM() {
        return this.mdZ;
    }

    public TextView getUserName() {
        return this.ewx;
    }

    public TextView dvN() {
        return this.mdJ;
    }

    public UserIconBox dvO() {
        return this.mdM;
    }

    public FrameLayout dvP() {
        return this.mdN;
    }

    public FrameLayout dvQ() {
        return this.mdQ;
    }

    public FrameLayout dvR() {
        return this.mdT;
    }

    public HeadPendantView dvS() {
        return this.mec;
    }

    public View dvT() {
        return this.mej;
    }

    public View dvU() {
        return this.men;
    }

    public ImageView dvV() {
        return this.mdK;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mex = aVar;
    }

    public void onDestroy() {
        if (this.hjx != null) {
            this.hjx.cancel();
        }
        if (this.meg != null) {
            this.meg.cancelAnimation();
        }
        if (this.met != null) {
            this.met.cancel();
        }
        if (this.meq != null) {
            this.meq.onDestory();
        }
    }
}
