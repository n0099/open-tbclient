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
    private ImageView jpx;
    private com.baidu.tieba.i.a kWn;
    private ImageView kXA;
    private TextView kXa;
    private ImageView kXb;
    private ImageView kXc;
    private UserIconBox kXd;
    private FrameLayout kXe;
    private TextView kXf;
    private TextView kXg;
    private FrameLayout kXh;
    private TextView kXi;
    private TextView kXj;
    private FrameLayout kXk;
    private TextView kXl;
    private TextView kXm;
    private ImageView kXn;
    private ImageView kXo;
    private TBSpecificationBtn kXp;
    private TBSpecificationBtn kXq;
    private TbImageView kXr;
    private ImageView kXs;
    private HeadPendantView kXt;
    private RelativeLayout kXu;
    private ImageView kXv;
    private TBLottieAnimationView kXw;
    private View kXx;
    private View kXy;
    private TextView kXz;
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
        this.kXa = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kXa.setAlpha(0.85f);
        this.kXa.setOnClickListener(this.mClickListener);
        this.kXb = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.kXb.setOnClickListener(this.mClickListener);
        this.kXd = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.kXd.setOnClickListener(this.mClickListener);
        this.kXf = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kXe = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kXe.setOnClickListener(this.mClickListener);
        this.kXg = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.kXg.setAlpha(0.8f);
        this.jpx = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.kXc = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kXi = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kXh = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kXh.setOnClickListener(this.mClickListener);
        this.kXj = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.kXj.setAlpha(0.8f);
        this.kXo = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.kXl = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.kXk = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.kXk.setOnClickListener(this.mClickListener);
        this.kXm = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.kXm.setAlpha(0.8f);
        this.kXn = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.kXp = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.kXp.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mW(R.color.cp_cont_b);
        this.kXp.setConfig(cVar);
        this.kXp.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.kXq = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.kXq.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.mZ(R.color.cp_cont_a);
        eVar.mR(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.D(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.kXq.setConfig(eVar);
        this.kXr = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kXr.setOnClickListener(this.mClickListener);
        this.kXs = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.kXt = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.kXt.setHasPendantStyle();
        this.kXt.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.kXt.getHeadView().setIsRound(true);
        this.kXt.getHeadView().setDrawBorder(false);
        this.kXt.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kXt.setOnClickListener(this.mClickListener);
        this.kXt.setBigVDimenSize(R.dimen.tbds57);
        this.kXt.setAuthIconType(3);
        this.kXt.setShowSimpleIcon(false);
        this.kXt.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kXx = this.mRootView.findViewById(R.id.person_header_ring);
        this.kXx.setAlpha(0.33f);
        this.kXy = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.kXz = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.kXA = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.kXy.setOnClickListener(this.mClickListener);
        this.kXv = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.kXw = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.kXu = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.a aVar) {
        String intro;
        if (userData != null) {
            this.mUserData = userData;
            this.kWn = aVar;
            if (!as.isEmpty(this.mUserData.getName_show())) {
                this.dKI.setText(this.mUserData.getName_show());
            }
            this.kXa.setVisibility(0);
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
                this.kXa.setVisibility(0);
                this.kXa.setText(intro);
                this.kXa.setEnabled(true);
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kXa.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kXa.setEnabled(false);
                                } else if (baijiahaoInfo != null && !as.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kXa.setEnabled(false);
                                }
                                b.this.kXb.setVisibility(8);
                                return;
                            }
                            b.this.kXb.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kXa.setVisibility(8);
            }
            this.kXd.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.kXf.setText(as.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.kXl.setText(as.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kXi.setText(as.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.kXp.setVisibility(8);
                this.kXq.setVisibility(8);
            } else {
                this.kXq.setVisibility(0);
                this.kXp.setVisibility(0);
                tW(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kXr.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kXr.setVisibility(0);
            } else if (this.mIsHost) {
                this.kXr.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
                this.kXr.setVisibility(0);
            } else {
                this.kXr.setVisibility(8);
            }
            int i = R.drawable.icon_mask_boy16_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.baR().a(this.kXs, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.kXs.setVisibility(8);
            } else {
                this.kXs.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.kXw.setVisibility(0);
                this.kXw.loop(true);
                this.kXw.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kXw.playAnimation();
                    }
                });
                this.kXx.setVisibility(8);
                db(this.kXu);
                this.kXv.setVisibility(0);
                this.kXt.setIsclearmode(true);
                this.kXt.ym(this.mUserData.getAvater());
            } else {
                this.kXt.a(this.mUserData);
                this.kXv.setVisibility(8);
                this.kXt.setIsclearmode(false);
                this.kXx.setVisibility(0);
            }
            if (this.kWn != null && this.kWn.ckV() && !TextUtils.isEmpty(this.kWn.goods_url)) {
                this.kXy.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ap("c13612").dn("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new ap("c13612").dn("obj_param1", "1"));
                    return;
                }
            }
            this.kXy.setVisibility(8);
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
        this.kXt.yl(str);
    }

    public void tW(boolean z) {
        if (z) {
            this.kXp.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.kXp.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.kXp.getStyleConfig()).bcR();
                return;
            }
            return;
        }
        this.kXp.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.kXp.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.kXp.getStyleConfig()).mW(R.color.cp_cont_b);
        }
    }

    public void tX(boolean z) {
        if (z) {
            this.kXc.setVisibility(0);
        } else {
            this.kXc.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.baR().a(this.kXn, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a(this.jpx, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a(this.kXo, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kXq.bci();
        this.kXp.bci();
        SvgManager.baR().a(this.kXb, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kXv.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.baR().a(this.kXA, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXa, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXf, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXg, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXi, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXj, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXl, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXm, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.kXz, R.color.cp_cont_a, 1, i);
        ao.setImageResource(this.kXc, R.drawable.icon_news_down_bar_one);
        ao.setBackgroundResource(this.kXx, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.baR().a(this.kXs, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.kXw != null) {
                this.kXw.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.kXv != null) {
                this.kXv.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.kXw != null) {
                this.kXw.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.kXv != null) {
                this.kXv.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.kXw != null) {
                this.kXw.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.kXv != null) {
                this.kXv.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cXH() {
        return this.kXr;
    }

    public View cXI() {
        return this.kXp;
    }

    public View cXJ() {
        return this.kXq;
    }

    public TextView getUserName() {
        return this.dKI;
    }

    public TextView cXK() {
        return this.kXa;
    }

    public UserIconBox cXL() {
        return this.kXd;
    }

    public FrameLayout cXM() {
        return this.kXe;
    }

    public FrameLayout cXN() {
        return this.kXh;
    }

    public FrameLayout cXO() {
        return this.kXk;
    }

    public HeadPendantView cXP() {
        return this.kXt;
    }

    public View cXQ() {
        return this.kXy;
    }

    public ImageView cXR() {
        return this.kXb;
    }

    public void onDestroy() {
        if (this.gnm != null) {
            this.gnm.cancel();
        }
        if (this.kXw != null) {
            this.kXw.cancelAnimation();
        }
    }
}
