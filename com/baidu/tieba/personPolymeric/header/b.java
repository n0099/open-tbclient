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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.e;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.BaijiahaoInfo;
/* loaded from: classes18.dex */
public class b {
    private TextView dKI;
    private AnimatorSet gnm;
    private ImageView jpz;
    private com.baidu.tieba.i.a kWp;
    private View kXA;
    private TextView kXB;
    private ImageView kXC;
    private TextView kXc;
    private ImageView kXd;
    private ImageView kXe;
    private UserIconBox kXf;
    private FrameLayout kXg;
    private TextView kXh;
    private TextView kXi;
    private FrameLayout kXj;
    private TextView kXk;
    private TextView kXl;
    private FrameLayout kXm;
    private TextView kXn;
    private TextView kXo;
    private ImageView kXp;
    private ImageView kXq;
    private TBSpecificationBtn kXr;
    private TBSpecificationBtn kXs;
    private TbImageView kXt;
    private ImageView kXu;
    private HeadPendantView kXv;
    private RelativeLayout kXw;
    private ImageView kXx;
    private TBLottieAnimationView kXy;
    private View kXz;
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
        this.dKI = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.dKI.setOnClickListener(this.mClickListener);
        this.kXc = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kXc.setAlpha(0.85f);
        this.kXc.setOnClickListener(this.mClickListener);
        this.kXd = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.kXd.setOnClickListener(this.mClickListener);
        this.kXf = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.kXf.setOnClickListener(this.mClickListener);
        this.kXh = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kXg = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kXg.setOnClickListener(this.mClickListener);
        this.kXi = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.kXi.setAlpha(0.8f);
        this.jpz = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.kXe = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kXk = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kXj = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kXj.setOnClickListener(this.mClickListener);
        this.kXl = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.kXl.setAlpha(0.8f);
        this.kXq = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.kXn = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.kXm = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.kXm.setOnClickListener(this.mClickListener);
        this.kXo = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.kXo.setAlpha(0.8f);
        this.kXp = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.kXr = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.kXr.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mW(R.color.cp_cont_b);
        this.kXr.setConfig(cVar);
        this.kXr.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.kXs = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.kXs.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.mZ(R.color.cp_cont_a);
        eVar.mR(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.D(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.kXs.setConfig(eVar);
        this.kXt = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kXt.setOnClickListener(this.mClickListener);
        this.kXu = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.kXv = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.kXv.setHasPendantStyle();
        this.kXv.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.kXv.getHeadView().setIsRound(true);
        this.kXv.getHeadView().setDrawBorder(false);
        this.kXv.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kXv.setOnClickListener(this.mClickListener);
        this.kXv.setBigVDimenSize(R.dimen.tbds57);
        this.kXv.setAuthIconType(3);
        this.kXv.setShowSimpleIcon(false);
        this.kXv.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kXz = this.mRootView.findViewById(R.id.person_header_ring);
        this.kXz.setAlpha(0.33f);
        this.kXA = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.kXB = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.kXC = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.kXA.setOnClickListener(this.mClickListener);
        this.kXx = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.kXy = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.kXw = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.a aVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.kWp = aVar;
            if (!as.isEmpty(this.mUserData.getName_show())) {
                this.dKI.setText(this.mUserData.getName_show());
            }
            this.kXc.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !as.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else if (this.mUserData.showBazhuGrade()) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, as.cutChineseAndEnglishWithSuffix(this.mUserData.getBazhuGradeData().getDesc(), 32, StringHelper.STRING_MORE));
            } else if (this.mUserData.isNewGod() && !as.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + this.mPageContext.getResources().getString(R.string.field_new_god));
            } else {
                intro = this.mUserData.getIntro();
                if (!as.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!as.isEmpty(intro)) {
                this.kXc.setVisibility(0);
                this.kXc.setText(intro);
                this.kXc.setEnabled(true);
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kXc.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kXc.setEnabled(false);
                                } else if (baijiahaoInfo != null && !as.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kXc.setEnabled(false);
                                }
                                b.this.kXd.setVisibility(8);
                                return;
                            }
                            b.this.kXd.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kXc.setVisibility(8);
            }
            this.kXf.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.kXh.setText(as.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.kXn.setText(as.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kXk.setText(as.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.kXr.setVisibility(8);
                this.kXs.setVisibility(8);
            } else {
                this.kXs.setVisibility(0);
                this.kXr.setVisibility(0);
                tW(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kXt.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kXt.setVisibility(0);
            } else if (this.mIsHost) {
                this.kXt.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
                this.kXt.setVisibility(0);
            } else {
                this.kXt.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.baR().a(this.kXu, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.kXu.setVisibility(8);
            } else {
                this.kXu.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.kXy.setVisibility(0);
                this.kXy.loop(true);
                this.kXy.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kXy.playAnimation();
                    }
                });
                this.kXz.setVisibility(8);
                db(this.kXw);
                this.kXx.setVisibility(0);
                this.kXv.setIsclearmode(true);
                this.kXv.ym(this.mUserData.getAvater());
            } else {
                this.kXv.a(this.mUserData);
                this.kXx.setVisibility(8);
                this.kXv.setIsclearmode(false);
                this.kXz.setVisibility(0);
            }
            if (this.kWp != null && this.kWp.ckV() && !TextUtils.isEmpty(this.kWp.goods_url)) {
                this.kXA.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ap("c13612").dn("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new ap("c13612").dn("obj_param1", "1"));
                    return;
                }
            }
            this.kXA.setVisibility(8);
        }
    }

    private void db(View view) {
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
        this.gnm = new AnimatorSet();
        this.gnm.play(ofFloat).with(ofFloat2);
        this.gnm.start();
    }

    public void LH(String str) {
        this.kXv.yl(str);
    }

    public void tW(boolean z) {
        if (z) {
            this.kXr.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.kXr.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.kXr.getStyleConfig()).bcR();
                return;
            }
            return;
        }
        this.kXr.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.kXr.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.kXr.getStyleConfig()).mW(R.color.cp_cont_b);
        }
    }

    public void tX(boolean z) {
        if (z) {
            this.kXe.setVisibility(0);
        } else {
            this.kXe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.baR().a(this.kXp, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a(this.jpz, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a(this.kXq, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kXs.bci();
        this.kXr.bci();
        SvgManager.baR().a(this.kXd, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kXx.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.baR().a(this.kXC, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXc, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXh, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXi, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXk, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXl, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXn, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXo, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXB, R.color.cp_cont_a, 1, i);
        ao.setImageResource(this.kXe, R.drawable.icon_news_down_bar_one);
        ao.setBackgroundResource(this.kXz, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.baR().a(this.kXu, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.kXy != null) {
                this.kXy.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.kXx != null) {
                this.kXx.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.kXy != null) {
                this.kXy.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.kXx != null) {
                this.kXx.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.kXy != null) {
                this.kXy.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.kXx != null) {
                this.kXx.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cXH() {
        return this.kXt;
    }

    public View cXI() {
        return this.kXr;
    }

    public View cXJ() {
        return this.kXs;
    }

    public TextView getUserName() {
        return this.dKI;
    }

    public TextView cXK() {
        return this.kXc;
    }

    public UserIconBox cXL() {
        return this.kXf;
    }

    public FrameLayout cXM() {
        return this.kXg;
    }

    public FrameLayout cXN() {
        return this.kXj;
    }

    public FrameLayout cXO() {
        return this.kXm;
    }

    public HeadPendantView cXP() {
        return this.kXv;
    }

    public View cXQ() {
        return this.kXA;
    }

    public ImageView cXR() {
        return this.kXd;
    }

    public void onDestroy() {
        if (this.gnm != null) {
            this.gnm.cancel();
        }
        if (this.kXy != null) {
            this.kXy.cancelAnimation();
        }
    }
}
