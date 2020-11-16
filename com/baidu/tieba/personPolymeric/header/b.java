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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes23.dex */
public class b {
    public static final int meK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    private TextView euO;
    private AnimatorSet hje;
    private boolean kXw;
    private ImageView kvi;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;
    private com.baidu.tieba.j.b mdn;
    private View meA;
    private ViewGroup meB;
    private View meC;
    private TextView meD;
    private ImageView meE;
    private View meF;
    private TextView meG;
    private ImageView meH;
    private com.baidu.tieba.model.c meI;
    private boolean meJ;
    private AnimatorSet meL;
    private ValueAnimator meM;
    private ObjectAnimator meN;
    private ObjectAnimator meO;
    private com.baidu.tieba.personPolymeric.b.a meP;
    private boolean meQ;
    private TextView meb;
    private ImageView mec;
    private ImageView med;
    private UserIconBox mee;
    private FrameLayout mef;
    private TextView meg;
    private TextView meh;
    private FrameLayout mei;
    private TextView mej;
    private TextView mek;
    private FrameLayout mel;
    private TextView men;
    private TextView meo;
    private ImageView mep;
    private ImageView meq;
    private FollowUserSpinnerBtn mer;
    private TBSpecificationBtn mes;
    private TbImageView met;
    private ImageView meu;
    private HeadPendantView mev;
    private RelativeLayout mew;
    private GodRecommendLayout mex;
    private ImageView mey;
    private TBLottieAnimationView mez;
    private FollowUserSpinnerBtn.a meR = new FollowUserSpinnerBtn.a() { // from class: com.baidu.tieba.personPolymeric.header.b.1
        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.a
        public void at(boolean z, boolean z2) {
            if (bh.checkUpIsLogin(b.this.mPageContext.getPageActivity())) {
                b.this.meQ = z2;
                b.this.kXw = false;
                if (z) {
                    b.this.mex.setCouldStatistic(true);
                    if (b.this.mUserData != null) {
                        b.this.meI.bu(b.this.mUserData.getPortrait(), 0);
                    }
                } else {
                    b.this.mex.setCouldStatistic(false);
                    b.this.meJ = false;
                    b.this.dvi();
                    if (b.this.meL != null) {
                        b.this.meL.start();
                    }
                }
                if (z && !z2) {
                    TiebaStatic.log(new ar("c13900"));
                }
            }
        }
    };
    private c.a kXv = new c.a() { // from class: com.baidu.tieba.personPolymeric.header.b.2
        @Override // com.baidu.tieba.model.c.a
        public void a(q qVar, int i) {
            if (qVar != null && i == 0) {
                b.this.mex.setData(qVar.dvh());
                if (!b.this.kXw) {
                    b.this.meJ = true;
                    b.this.dvi();
                    if (b.this.meL != null) {
                        b.this.meL.start();
                    }
                }
                TiebaStatic.log(new ar("c13901").ak("obj_type", b.this.meQ ? 1 : 2));
            } else if (i == 1) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bom();
            } else if (i == 3) {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_refresh_error)).bom();
            } else {
                BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_limit_error)).bom();
            }
        }
    };
    private View.OnClickListener meS = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.meI != null && b.this.mUserData != null) {
                b.this.kXw = true;
                b.this.meI.request(b.this.mUserData.getPortrait());
            }
            TiebaStatic.log(new ar("c13904"));
        }
    };

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
        Jn();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.euO = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.euO.setOnClickListener(this.mClickListener);
        this.meb = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.meb.setAlpha(0.85f);
        this.meb.setOnClickListener(this.mClickListener);
        this.mec = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.mec.setOnClickListener(this.mClickListener);
        this.mee = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.mee.setOnClickListener(this.mClickListener);
        this.mee.setAutoChangedStyle(false);
        this.meg = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.mef = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.mef.setOnClickListener(this.mClickListener);
        this.meh = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.meh.setAlpha(0.8f);
        this.kvi = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.med = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.mej = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.mei = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.mei.setOnClickListener(this.mClickListener);
        this.mek = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.mek.setAlpha(0.8f);
        this.meq = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.men = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.mel = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.mel.setOnClickListener(this.mClickListener);
        this.meo = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.meo.setAlpha(0.8f);
        this.mep = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.mer = (FollowUserSpinnerBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.mer.h(this.mClickListener);
        this.mer.setOpenListener(this.meR);
        this.mes = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.mes.setOnClickListener(this.mClickListener);
        d dVar = new d();
        dVar.qK(R.color.CAM_X0101);
        dVar.qB(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.a(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.mes.setConfig(dVar);
        this.met = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.met.setOnClickListener(this.mClickListener);
        this.meu = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.mev = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.mev.setHasPendantStyle();
        this.mev.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.mev.getHeadView().setIsRound(true);
        this.mev.getHeadView().setDrawBorder(false);
        this.mev.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mev.setOnClickListener(this.mClickListener);
        this.mev.setBigVDimenSize(R.dimen.tbds57);
        this.mev.setAuthIconType(3);
        this.mev.setShowSimpleIcon(false);
        this.mev.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.meA = this.mRootView.findViewById(R.id.person_header_ring);
        this.meA.setAlpha(0.33f);
        this.mex = (GodRecommendLayout) this.mRootView.findViewById(R.id.recommend_god);
        this.mex.setPageContext(this.mPageContext);
        this.mex.setPageUniqueId(this.mPageContext.getUniqueId());
        this.mex.setRefreshListener(this.meS);
        this.meI = new com.baidu.tieba.model.c(this.mPageContext.getUniqueId());
        this.meI.a(this.kXv);
        this.meB = (ViewGroup) this.mRootView.findViewById(R.id.person_center_my_extra_layout);
        this.meC = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.meD = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.meE = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.meC.setOnClickListener(this.mClickListener);
        this.meF = this.mRootView.findViewById(R.id.person_center_my_friends_room_layout);
        this.meG = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.meH = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.meF.setOnClickListener(this.mClickListener);
        this.mey = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.mez = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.mew = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Jn() {
        this.meM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.meM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.header.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * b.meK;
                ViewGroup.LayoutParams layoutParams = b.this.mex.getLayoutParams();
                if (b.this.meJ) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (b.meK - floatValue);
                }
                if (b.this.meP != null) {
                    b.this.meP.CO(b.this.meJ ? (int) floatValue : (int) (-floatValue));
                }
                b.this.mex.setLayoutParams(layoutParams);
                b.this.mex.onChangeSkinType();
            }
        });
        this.meM.setDuration(260L);
        this.meM.setInterpolator(new LinearInterpolator());
        this.meN = ObjectAnimator.ofFloat(this.mex, "alpha", 0.0f);
        this.meN.setDuration(240L);
        this.meN.setInterpolator(new LinearInterpolator());
        this.meO = ObjectAnimator.ofFloat(this.mer.getArrow(), MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f);
        this.meO.setDuration(100L);
        this.meL = new AnimatorSet();
        this.meL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.personPolymeric.header.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = b.this.mex.getLayoutParams();
                if (b.this.meJ) {
                    layoutParams.height = b.meK;
                } else {
                    layoutParams.height = 0;
                }
                b.this.mex.setLayoutParams(layoutParams);
                if (b.this.meP != null) {
                    b.this.meP.hn(b.this.meJ);
                }
            }
        });
        this.meL.play(this.meM).with(this.meN).with(this.meO);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.j.b bVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.mdn = bVar;
            if (!au.isEmpty(this.mUserData.getName_show())) {
                this.euO.setText(this.mUserData.getName_show());
            }
            this.meb.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (this.mUserData.isNewGod() && !au.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + this.mPageContext.getResources().getString(R.string.field_new_god));
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
                this.meb.setVisibility(0);
                this.meb.setText(intro);
                this.meb.setEnabled(true);
                e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.meb.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.meb.setEnabled(false);
                                } else if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.meb.setEnabled(false);
                                }
                                b.this.mec.setVisibility(8);
                                return;
                            }
                            b.this.mec.setVisibility(0);
                        }
                    }
                });
            } else {
                this.meb.setVisibility(8);
            }
            this.mee.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.meg.setText(au.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.men.setText(au.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.mej.setText(au.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.mer.setVisibility(8);
                this.mes.setVisibility(8);
            } else {
                this.mes.setVisibility(0);
                this.mer.setVisibility(0);
                this.mer.setShowPullBtn(userData.isNewGod());
                this.mer.setFirstUpdate(true);
                wb(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.met.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.met.setVisibility(0);
            } else if (this.mIsHost) {
                this.met.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
                this.met.setVisibility(0);
            } else {
                this.met.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.bqB().a(this.meu, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.meu.setVisibility(8);
            } else {
                this.meu.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.mez.setVisibility(0);
                this.mez.loop(true);
                this.mez.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mez.playAnimation();
                    }
                });
                this.meA.setVisibility(8);
                dE(this.mew);
                this.mey.setVisibility(0);
                this.mev.setIsclearmode(true);
                this.mev.BP(this.mUserData.getAvater());
            } else {
                this.mev.a(this.mUserData);
                this.mey.setVisibility(8);
                this.mev.setIsclearmode(false);
                this.meA.setVisibility(0);
            }
            if (this.mdn != null && this.mdn.cHJ() && !TextUtils.isEmpty(this.mdn.goods_url)) {
                this.meC.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "0"));
                } else {
                    TiebaStatic.log(new ar("c13612").dR("obj_param1", "1"));
                }
            } else {
                this.meC.setVisibility(8);
            }
            if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && this.mUserData.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().btn_title)) {
                this.meG.setText(this.mUserData.getLiveRoomInfo().btn_title);
                this.meF.setVisibility(0);
            } else {
                this.meF.setVisibility(8);
            }
            if (this.meC.getVisibility() == 0 || this.meF.getVisibility() == 0) {
                this.meB.setVisibility(0);
            } else {
                this.meB.setVisibility(8);
            }
        }
    }

    private void dE(View view) {
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
        this.hje = new AnimatorSet();
        this.hje.play(ofFloat).with(ofFloat2);
        this.hje.start();
    }

    public void dvi() {
        if (this.meN != null) {
            if (this.meJ) {
                this.meN.setFloatValues(0.0f, 1.0f);
            } else {
                this.meN.setFloatValues(1.0f, 0.0f);
            }
        }
        if (this.meO != null) {
            if (this.meJ) {
                this.meO.setFloatValues(0.0f, 180.0f);
            } else {
                this.meO.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void dvj() {
        if (this.meL != null) {
            this.meL.start();
        }
    }

    public void wa(boolean z) {
        this.meJ = z;
    }

    public void Qb(String str) {
        this.mev.BO(str);
    }

    public void wb(boolean z) {
        this.mer.aP(z);
    }

    public void wc(boolean z) {
        if (z) {
            this.med.setVisibility(0);
        } else {
            this.med.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bqB().a(this.mep, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a(this.kvi, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a(this.meq, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mes.brT();
        this.mer.onChangeSkinType(i);
        SvgManager.bqB().a(this.mec, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.mey.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.bqB().a(this.meE, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a(this.meH, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.euO, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.meb, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.meg, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.meh, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mej, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.mek, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.men, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.meo, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.meD, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.meG, R.color.CAM_X0101, 1, i);
        ap.setImageResource(this.med, R.drawable.icon_news_down_bar_one);
        ap.setBackgroundResource(this.meA, R.drawable.person_header_bg, i);
        this.mex.onChangeSkinType();
        if (this.mUserData != null) {
            SvgManager.bqB().a(this.meu, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.mez != null) {
                this.mez.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.mey != null) {
                this.mey.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.mez != null) {
                this.mez.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.mey != null) {
                this.mey.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.mez != null) {
                this.mez.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.mey != null) {
                this.mey.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView dvk() {
        return this.met;
    }

    public FollowUserSpinnerBtn dvl() {
        return this.mer;
    }

    public View dvm() {
        return this.mes;
    }

    public TextView getUserName() {
        return this.euO;
    }

    public TextView dvn() {
        return this.meb;
    }

    public UserIconBox dvo() {
        return this.mee;
    }

    public FrameLayout dvp() {
        return this.mef;
    }

    public FrameLayout dvq() {
        return this.mei;
    }

    public FrameLayout dvr() {
        return this.mel;
    }

    public HeadPendantView dvs() {
        return this.mev;
    }

    public View dvt() {
        return this.meC;
    }

    public View dvu() {
        return this.meF;
    }

    public ImageView dvv() {
        return this.mec;
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.meP = aVar;
    }

    public void onDestroy() {
        if (this.hje != null) {
            this.hje.cancel();
        }
        if (this.mez != null) {
            this.mez.cancelAnimation();
        }
        if (this.meL != null) {
            this.meL.cancel();
        }
        if (this.meI != null) {
            this.meI.onDestory();
        }
    }
}
