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
    private ImageView joA;
    private TBLottieAnimationView joB;
    private View joC;
    private TextView joe;
    private ImageView jof;
    private ImageView jog;
    private UserIconBox joh;
    private FrameLayout joi;
    private TextView joj;
    private TextView jok;
    private FrameLayout jol;
    private TextView jom;
    private TextView jon;
    private FrameLayout joo;
    private TextView jop;
    private TextView joq;
    private ImageView jor;
    private ImageView jos;
    private ImageView jot;
    private TBSpecificationBtn jou;
    private TBSpecificationBtn jov;
    private TbImageView jow;
    private ImageView jox;
    private HeadPendantView joy;
    private RelativeLayout joz;
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
        this.joe = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.joe.setAlpha(0.85f);
        this.joe.setOnClickListener(this.mClickListener);
        this.jof = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jof.setOnClickListener(this.mClickListener);
        this.joh = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.joh.setOnClickListener(this.mClickListener);
        this.joj = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.joi = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.joi.setOnClickListener(this.mClickListener);
        this.jok = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jok.setAlpha(0.8f);
        this.jos = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jog = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jom = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.jol = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.jol.setOnClickListener(this.mClickListener);
        this.jon = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jon.setAlpha(0.8f);
        this.jot = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jop = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.joo = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.joo.setOnClickListener(this.mClickListener);
        this.joq = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.joq.setAlpha(0.8f);
        this.jor = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.jou = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.jou.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lc(R.color.cp_cont_b);
        this.jou.setConfig(cVar);
        this.jou.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.jov = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.jov.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lf(R.color.cp_cont_a);
        eVar.la(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.icon_mask_wo_list_gift24_svg, true);
        this.jov.setConfig(eVar);
        this.jow = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.jow.setOnClickListener(this.mClickListener);
        this.jox = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.joy = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.joy.setHasPendantStyle();
        this.joy.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.joy.getHeadView().setIsRound(true);
        this.joy.getHeadView().setDrawBorder(false);
        this.joy.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.joy.setOnClickListener(this.mClickListener);
        this.joy.setBigVDimenSize(R.dimen.tbds57);
        this.joy.setAuthIconType(3);
        this.joy.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.joC = this.mRootView.findViewById(R.id.person_header_ring);
        this.joC.setAlpha(0.33f);
        this.joA = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.joB = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.joz = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.joe.setVisibility(0);
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
                this.joe.setVisibility(0);
                this.joe.setText(intro);
                this.joe.setEnabled(true);
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.joe.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.joe.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.joe.setEnabled(false);
                                }
                                b.this.jof.setVisibility(8);
                                return;
                            }
                            b.this.jof.setVisibility(0);
                        }
                    }
                });
            } else {
                this.joe.setVisibility(8);
            }
            this.joh.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.joj.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jop.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jom.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.jou.setVisibility(8);
                this.jov.setVisibility(8);
            } else {
                this.jov.setVisibility(0);
                this.jou.setVisibility(0);
                rr(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.jow.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.jow.setVisibility(0);
            } else if (this.mIsHost) {
                this.jow.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.jow.setVisibility(0);
            } else {
                this.jow.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aEp().a(this.jox, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.jox.setVisibility(8);
            } else {
                this.jox.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.joB.setVisibility(0);
                this.joB.loop(true);
                this.joB.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.joB.playAnimation();
                    }
                });
                this.joC.setVisibility(8);
                cK(this.joz);
                this.joA.setVisibility(0);
                this.joy.setIsclearmode(true);
                this.joy.tD(this.mUserData.getAvater());
                return;
            }
            this.joy.a(this.mUserData);
            this.joA.setVisibility(8);
            this.joy.setIsclearmode(false);
            this.joC.setVisibility(0);
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
        this.joy.tC(str);
    }

    public void rr(boolean z) {
        if (z) {
            this.jou.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.jou.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.jou.getStyleConfig()).aGc();
                return;
            }
            return;
        }
        this.jou.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.jou.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.jou.getStyleConfig()).lc(R.color.cp_cont_b);
        }
    }

    public void rs(boolean z) {
        if (z) {
            this.jog.setVisibility(0);
        } else {
            this.jog.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aEp().a(this.jor, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a(this.jos, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a(this.jot, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jov.aFw();
        this.jou.aFw();
        SvgManager.aEp().a(this.jof, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.joA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        am.setViewTextColor(this.bXF, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.joe, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.joj, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jok, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jom, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jon, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jop, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.joq, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jog, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.joC, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aEp().a(this.jox, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.joB != null) {
                this.joB.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.joA != null) {
                this.joA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.joB != null) {
                this.joB.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.joA != null) {
                this.joA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.joB != null) {
                this.joB.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.joA != null) {
                this.joA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cvK() {
        return this.jow;
    }

    public View cvL() {
        return this.jou;
    }

    public View cvM() {
        return this.jov;
    }

    public TextView getUserName() {
        return this.bXF;
    }

    public TextView cvN() {
        return this.joe;
    }

    public UserIconBox cvO() {
        return this.joh;
    }

    public FrameLayout cvP() {
        return this.joi;
    }

    public FrameLayout cvQ() {
        return this.jol;
    }

    public FrameLayout cvR() {
        return this.joo;
    }

    public HeadPendantView cvS() {
        return this.joy;
    }

    public ImageView cvT() {
        return this.jof;
    }

    public void onDestroy() {
        if (this.eYY != null) {
            this.eYY.cancel();
        }
        if (this.joB != null) {
            this.joB.cancelAnimation();
        }
    }
}
