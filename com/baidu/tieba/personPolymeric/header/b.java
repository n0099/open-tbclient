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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.e;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.BaijiahaoInfo;
/* loaded from: classes11.dex */
public class b {
    private TextView dEL;
    private AnimatorSet gio;
    private com.baidu.tieba.i.a kNp;
    private TBLottieAnimationView kOA;
    private View kOB;
    private View kOC;
    private TextView kOD;
    private ImageView kOE;
    private TextView kOd;
    private ImageView kOe;
    private ImageView kOf;
    private UserIconBox kOg;
    private FrameLayout kOh;
    private TextView kOi;
    private TextView kOj;
    private FrameLayout kOk;
    private TextView kOl;
    private TextView kOm;
    private FrameLayout kOn;
    private TextView kOo;
    private TextView kOp;
    private ImageView kOq;
    private ImageView kOr;
    private ImageView kOs;
    private TBSpecificationBtn kOt;
    private TBSpecificationBtn kOu;
    private TbImageView kOv;
    private ImageView kOw;
    private HeadPendantView kOx;
    private RelativeLayout kOy;
    private ImageView kOz;
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
        this.dEL = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.dEL.setOnClickListener(this.mClickListener);
        this.kOd = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kOd.setAlpha(0.85f);
        this.kOd.setOnClickListener(this.mClickListener);
        this.kOe = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.kOe.setOnClickListener(this.mClickListener);
        this.kOg = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.kOg.setOnClickListener(this.mClickListener);
        this.kOi = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kOh = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kOh.setOnClickListener(this.mClickListener);
        this.kOj = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.kOj.setAlpha(0.8f);
        this.kOr = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.kOf = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kOl = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kOk = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kOk.setOnClickListener(this.mClickListener);
        this.kOm = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.kOm.setAlpha(0.8f);
        this.kOs = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.kOo = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.kOn = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.kOn.setOnClickListener(this.mClickListener);
        this.kOp = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.kOp.setAlpha(0.8f);
        this.kOq = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.kOt = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.kOt.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mD(R.color.cp_cont_b);
        this.kOt.setConfig(cVar);
        this.kOt.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.kOu = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.kOu.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.mG(R.color.cp_cont_a);
        eVar.my(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.D(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.kOu.setConfig(eVar);
        this.kOv = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kOv.setOnClickListener(this.mClickListener);
        this.kOw = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.kOx = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.kOx.setHasPendantStyle();
        this.kOx.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.kOx.getHeadView().setIsRound(true);
        this.kOx.getHeadView().setDrawBorder(false);
        this.kOx.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kOx.setOnClickListener(this.mClickListener);
        this.kOx.setBigVDimenSize(R.dimen.tbds57);
        this.kOx.setAuthIconType(3);
        this.kOx.setShowSimpleIcon(false);
        this.kOx.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kOB = this.mRootView.findViewById(R.id.person_header_ring);
        this.kOB.setAlpha(0.33f);
        this.kOC = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.kOD = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.kOE = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.kOC.setOnClickListener(this.mClickListener);
        this.kOz = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.kOA = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.kOy = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(UserData userData, com.baidu.tieba.i.a aVar) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            this.kNp = aVar;
            if (!ar.isEmpty(this.mUserData.getName_show())) {
                this.dEL.setText(this.mUserData.getName_show());
            }
            this.kOd.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !ar.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else if (this.mUserData.showBazhuGrade()) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, ar.cutChineseAndEnglishWithSuffix(this.mUserData.getBazhuGradeData().getDesc(), 32, StringHelper.STRING_MORE));
            } else if (this.mUserData.isNewGod() && !ar.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + this.mPageContext.getResources().getString(R.string.field_new_god));
            } else {
                intro = this.mUserData.getIntro();
                if (!ar.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!ar.isEmpty(intro)) {
                this.kOd.setVisibility(0);
                this.kOd.setText(intro);
                this.kOd.setEnabled(true);
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kOd.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kOd.setEnabled(false);
                                } else if (baijiahaoInfo != null && !ar.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kOd.setEnabled(false);
                                }
                                b.this.kOe.setVisibility(8);
                                return;
                            }
                            b.this.kOe.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kOd.setVisibility(8);
            }
            this.kOg.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.kOi.setText(ar.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.kOo.setText(ar.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kOl.setText(ar.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.kOt.setVisibility(8);
                this.kOu.setVisibility(8);
            } else {
                this.kOu.setVisibility(0);
                this.kOt.setVisibility(0);
                tq(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kOv.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kOv.setVisibility(0);
            } else if (this.mIsHost) {
                this.kOv.setImageDrawable(an.getDrawable(R.drawable.icon_crown_super_non));
                this.kOv.setVisibility(0);
            } else {
                this.kOv.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aWQ().a(this.kOw, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.kOw.setVisibility(8);
            } else {
                this.kOw.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.kOA.setVisibility(0);
                this.kOA.loop(true);
                this.kOA.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kOA.playAnimation();
                    }
                });
                this.kOB.setVisibility(8);
                cV(this.kOy);
                this.kOz.setVisibility(0);
                this.kOx.setIsclearmode(true);
                this.kOx.xh(this.mUserData.getAvater());
            } else {
                this.kOx.a(this.mUserData);
                this.kOz.setVisibility(8);
                this.kOx.setIsclearmode(false);
                this.kOB.setVisibility(0);
            }
            if (this.kNp != null && this.kNp.chw() && !TextUtils.isEmpty(this.kNp.goods_url)) {
                this.kOC.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new ao("c13612").dk("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new ao("c13612").dk("obj_param1", "1"));
                    return;
                }
            }
            this.kOC.setVisibility(8);
        }
    }

    private void cV(View view) {
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
        this.gio = new AnimatorSet();
        this.gio.play(ofFloat).with(ofFloat2);
        this.gio.start();
    }

    public void KT(String str) {
        this.kOx.xg(str);
    }

    public void tq(boolean z) {
        if (z) {
            this.kOt.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.kOt.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.kOt.getStyleConfig()).aYU();
                return;
            }
            return;
        }
        this.kOt.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.kOt.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.kOt.getStyleConfig()).mD(R.color.cp_cont_b);
        }
    }

    public void tr(boolean z) {
        if (z) {
            this.kOf.setVisibility(0);
        } else {
            this.kOf.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aWQ().a(this.kOq, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aWQ().a(this.kOr, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aWQ().a(this.kOs, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kOu.aYj();
        this.kOt.aYj();
        SvgManager.aWQ().a(this.kOe, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kOz.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aWQ().a(this.kOE, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        an.setViewTextColor(this.dEL, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOd, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOi, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOj, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOl, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOm, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOo, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOp, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.kOD, R.color.cp_cont_a, 1, i);
        an.setImageResource(this.kOf, R.drawable.icon_news_down_bar_one);
        an.setBackgroundResource(this.kOB, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aWQ().a(this.kOw, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.kOA != null) {
                this.kOA.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.kOz != null) {
                this.kOz.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.kOA != null) {
                this.kOA.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.kOz != null) {
                this.kOz.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.kOA != null) {
                this.kOA.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.kOz != null) {
                this.kOz.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cTR() {
        return this.kOv;
    }

    public View cTS() {
        return this.kOt;
    }

    public View cTT() {
        return this.kOu;
    }

    public TextView getUserName() {
        return this.dEL;
    }

    public TextView cTU() {
        return this.kOd;
    }

    public UserIconBox cTV() {
        return this.kOg;
    }

    public FrameLayout cTW() {
        return this.kOh;
    }

    public FrameLayout cTX() {
        return this.kOk;
    }

    public FrameLayout cTY() {
        return this.kOn;
    }

    public HeadPendantView cTZ() {
        return this.kOx;
    }

    public View cUa() {
        return this.kOC;
    }

    public ImageView cUb() {
        return this.kOe;
    }

    public void onDestroy() {
        if (this.gio != null) {
            this.gio.cancel();
        }
        if (this.kOA != null) {
            this.kOA.cancelAnimation();
        }
    }
}
