package com.baidu.tieba.personPolymeric.header;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.e;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.BaijiahaoInfo;
/* loaded from: classes9.dex */
public class b {
    private TextView bXF;
    private AnimatorSet eYY;
    private TBSpecificationBtn joA;
    private TbImageView joB;
    private ImageView joC;
    private HeadPendantView joD;
    private RelativeLayout joE;
    private ImageView joF;
    private TBLottieAnimationView joG;
    private View joH;
    private TextView joj;
    private ImageView jok;
    private ImageView jol;
    private UserIconBox jom;
    private FrameLayout jon;
    private TextView joo;
    private TextView jop;
    private FrameLayout joq;
    private TextView jor;
    private TextView jos;
    private FrameLayout jot;
    private TextView jou;
    private TextView jov;
    private ImageView jow;
    private ImageView jox;
    private ImageView joy;
    private TBSpecificationBtn joz;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.bXF = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.bXF.setOnClickListener(this.mClickListener);
        this.joj = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.joj.setAlpha(0.85f);
        this.joj.setOnClickListener(this.mClickListener);
        this.jok = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jok.setOnClickListener(this.mClickListener);
        this.jom = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.jom.setOnClickListener(this.mClickListener);
        this.joo = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.jon = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.jon.setOnClickListener(this.mClickListener);
        this.jop = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jop.setAlpha(0.8f);
        this.jox = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jol = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jor = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.joq = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.joq.setOnClickListener(this.mClickListener);
        this.jos = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jos.setAlpha(0.8f);
        this.joy = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jou = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.jot = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.jot.setOnClickListener(this.mClickListener);
        this.jov = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.jov.setAlpha(0.8f);
        this.jow = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.joz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.joz.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lc(R.color.cp_cont_b);
        this.joz.setConfig(cVar);
        this.joz.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.joA = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.joA.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lf(R.color.cp_cont_a);
        eVar.la(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.icon_mask_wo_list_gift24_svg, true);
        this.joA.setConfig(eVar);
        this.joB = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.joB.setOnClickListener(this.mClickListener);
        this.joC = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.joD = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.joD.setHasPendantStyle();
        this.joD.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.joD.getHeadView().setIsRound(true);
        this.joD.getHeadView().setDrawBorder(false);
        this.joD.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.joD.setOnClickListener(this.mClickListener);
        this.joD.setBigVDimenSize(R.dimen.tbds57);
        this.joD.setAuthIconType(3);
        this.joD.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.joH = this.mRootView.findViewById(R.id.person_header_ring);
        this.joH.setAlpha(0.33f);
        this.joF = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.joG = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.joE = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void e(UserData userData) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.bXF.setText(this.mUserData.getName_show());
            }
            this.joj.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else {
                intro = this.mUserData.getIntro();
                if (!aq.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!aq.isEmpty(intro)) {
                this.joj.setVisibility(0);
                this.joj.setText(intro);
                this.joj.setEnabled(true);
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.joj.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.joj.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.joj.setEnabled(false);
                                }
                                b.this.jok.setVisibility(8);
                                return;
                            }
                            b.this.jok.setVisibility(0);
                        }
                    }
                });
            } else {
                this.joj.setVisibility(8);
            }
            this.jom.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.joo.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jou.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jor.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.joz.setVisibility(8);
                this.joA.setVisibility(8);
            } else {
                this.joA.setVisibility(0);
                this.joz.setVisibility(0);
                rr(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.joB.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.joB.setVisibility(0);
            } else if (this.mIsHost) {
                this.joB.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.joB.setVisibility(0);
            } else {
                this.joB.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aEp().a(this.joC, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.joC.setVisibility(8);
            } else {
                this.joC.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.joG.setVisibility(0);
                this.joG.loop(true);
                this.joG.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.joG.playAnimation();
                    }
                });
                this.joH.setVisibility(8);
                cK(this.joE);
                this.joF.setVisibility(0);
                this.joD.setIsclearmode(true);
                this.joD.tD(this.mUserData.getAvater());
                return;
            }
            this.joD.a(this.mUserData);
            this.joF.setVisibility(8);
            this.joD.setIsclearmode(false);
            this.joH.setVisibility(0);
        }
    }

    private void cK(View view) {
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
        this.eYY = new AnimatorSet();
        this.eYY.play(ofFloat).with(ofFloat2);
        this.eYY.start();
    }

    public void GG(String str) {
        this.joD.tC(str);
    }

    public void rr(boolean z) {
        if (z) {
            this.joz.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.joz.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.joz.getStyleConfig()).aGc();
                return;
            }
            return;
        }
        this.joz.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.joz.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.joz.getStyleConfig()).lc(R.color.cp_cont_b);
        }
    }

    public void rs(boolean z) {
        if (z) {
            this.jol.setVisibility(0);
        } else {
            this.jol.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aEp().a(this.jow, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a(this.jox, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a(this.joy, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.joA.aFw();
        this.joz.aFw();
        SvgManager.aEp().a(this.jok, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.joF.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        am.setViewTextColor(this.bXF, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.joj, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.joo, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jop, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jor, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jos, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jou, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jov, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jol, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.joH, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aEp().a(this.joC, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.joG != null) {
                this.joG.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.joF != null) {
                this.joF.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.joG != null) {
                this.joG.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.joF != null) {
                this.joF.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.joG != null) {
                this.joG.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.joF != null) {
                this.joF.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cvM() {
        return this.joB;
    }

    public View cvN() {
        return this.joz;
    }

    public View cvO() {
        return this.joA;
    }

    public TextView getUserName() {
        return this.bXF;
    }

    public TextView cvP() {
        return this.joj;
    }

    public UserIconBox cvQ() {
        return this.jom;
    }

    public FrameLayout cvR() {
        return this.jon;
    }

    public FrameLayout cvS() {
        return this.joq;
    }

    public FrameLayout cvT() {
        return this.jot;
    }

    public HeadPendantView cvU() {
        return this.joD;
    }

    public ImageView cvV() {
        return this.jok;
    }

    public void onDestroy() {
        if (this.eYY != null) {
            this.eYY.cancel();
        }
        if (this.joG != null) {
            this.joG.cancelAnimation();
        }
    }
}
