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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes11.dex */
public class b {
    private TextView dXU;
    private AnimatorSet fVg;
    private com.baidu.tieba.i.a ksm;
    private TextView ktA;
    private ImageView ktB;
    private TextView kta;
    private ImageView ktb;
    private ImageView ktc;
    private UserIconBox ktd;
    private FrameLayout kte;
    private TextView ktf;
    private TextView ktg;
    private FrameLayout kth;
    private TextView kti;
    private TextView ktj;
    private FrameLayout ktk;
    private TextView ktl;
    private TextView ktm;
    private ImageView ktn;
    private ImageView kto;
    private ImageView ktp;
    private TBSpecificationBtn ktq;
    private TBSpecificationBtn ktr;
    private TbImageView kts;
    private ImageView ktt;
    private HeadPendantView ktu;
    private RelativeLayout ktv;
    private ImageView ktw;
    private TBLottieAnimationView ktx;
    private View kty;
    private View ktz;
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
        this.dXU = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.dXU.setOnClickListener(this.mClickListener);
        this.kta = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kta.setAlpha(0.85f);
        this.kta.setOnClickListener(this.mClickListener);
        this.ktb = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.ktb.setOnClickListener(this.mClickListener);
        this.ktd = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.ktd.setOnClickListener(this.mClickListener);
        this.ktf = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kte = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kte.setOnClickListener(this.mClickListener);
        this.ktg = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.ktg.setAlpha(0.8f);
        this.kto = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.ktc = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kti = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kth = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kth.setOnClickListener(this.mClickListener);
        this.ktj = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.ktj.setAlpha(0.8f);
        this.ktp = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.ktl = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.ktk = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.ktk.setOnClickListener(this.mClickListener);
        this.ktm = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.ktm.setAlpha(0.8f);
        this.ktn = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.ktq = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.ktq.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mj(R.color.cp_cont_b);
        this.ktq.setConfig(cVar);
        this.ktq.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.ktr = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.ktr.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.mm(R.color.cp_cont_a);
        eVar.mf(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.C(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.ktr.setConfig(eVar);
        this.kts = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kts.setOnClickListener(this.mClickListener);
        this.ktt = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.ktu = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.ktu.setHasPendantStyle();
        this.ktu.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.ktu.getHeadView().setIsRound(true);
        this.ktu.getHeadView().setDrawBorder(false);
        this.ktu.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ktu.setOnClickListener(this.mClickListener);
        this.ktu.setBigVDimenSize(R.dimen.tbds57);
        this.ktu.setAuthIconType(3);
        this.ktu.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kty = this.mRootView.findViewById(R.id.person_header_ring);
        this.kty.setAlpha(0.33f);
        this.ktz = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.ktA = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.ktB = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.ktz.setOnClickListener(this.mClickListener);
        this.ktw = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.ktx = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.ktv = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.ksm = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.dXU.setText(this.mUserData.getName_show());
            }
            this.kta.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else if (this.mUserData.isNewGod() && !aq.isEmpty(this.mUserData.getNewGodData().getFieldName())) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, this.mUserData.getNewGodData().getFieldName() + this.mPageContext.getResources().getString(R.string.field_new_god));
            } else {
                intro = this.mUserData.getIntro();
                if (!aq.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!aq.isEmpty(intro)) {
                this.kta.setVisibility(0);
                this.kta.setText(intro);
                this.kta.setEnabled(true);
                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kta.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kta.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kta.setEnabled(false);
                                }
                                b.this.ktb.setVisibility(8);
                                return;
                            }
                            b.this.ktb.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kta.setVisibility(8);
            }
            this.ktd.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.ktf.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.ktl.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kti.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.ktq.setVisibility(8);
                this.ktr.setVisibility(8);
            } else {
                this.ktr.setVisibility(0);
                this.ktq.setVisibility(0);
                tc(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kts.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kts.setVisibility(0);
            } else if (this.mIsHost) {
                this.kts.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.kts.setVisibility(0);
            } else {
                this.kts.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aUV().a(this.ktt, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.ktt.setVisibility(8);
            } else {
                this.ktt.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.ktx.setVisibility(0);
                this.ktx.loop(true);
                this.ktx.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ktx.playAnimation();
                    }
                });
                this.kty.setVisibility(8);
                cU(this.ktv);
                this.ktw.setVisibility(0);
                this.ktu.setIsclearmode(true);
                this.ktu.wQ(this.mUserData.getAvater());
            } else {
                this.ktu.a(this.mUserData);
                this.ktw.setVisibility(8);
                this.ktu.setIsclearmode(false);
                this.kty.setVisibility(0);
            }
            if (this.ksm != null && this.ksm.cdQ() && !TextUtils.isEmpty(this.ksm.goods_url)) {
                this.ktz.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").dh("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").dh("obj_param1", "1"));
                    return;
                }
            }
            this.ktz.setVisibility(8);
        }
    }

    private void cU(View view) {
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
        this.fVg = new AnimatorSet();
        this.fVg.play(ofFloat).with(ofFloat2);
        this.fVg.start();
    }

    public void Kr(String str) {
        this.ktu.wP(str);
    }

    public void tc(boolean z) {
        if (z) {
            this.ktq.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.ktq.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.ktq.getStyleConfig()).aWZ();
                return;
            }
            return;
        }
        this.ktq.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.ktq.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.ktq.getStyleConfig()).mj(R.color.cp_cont_b);
        }
    }

    public void td(boolean z) {
        if (z) {
            this.ktc.setVisibility(0);
        } else {
            this.ktc.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aUV().a(this.ktn, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUV().a(this.kto, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUV().a(this.ktp, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.ktr.aWq();
        this.ktq.aWq();
        SvgManager.aUV().a(this.ktb, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.ktw.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aUV().a(this.ktB, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.dXU, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kta, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.ktf, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.ktg, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kti, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.ktj, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.ktl, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.ktm, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.ktA, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.ktc, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.kty, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aUV().a(this.ktt, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.ktx != null) {
                this.ktx.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.ktw != null) {
                this.ktw.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.ktx != null) {
                this.ktx.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.ktw != null) {
                this.ktw.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.ktx != null) {
                this.ktx.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.ktw != null) {
                this.ktw.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cPj() {
        return this.kts;
    }

    public View cPk() {
        return this.ktq;
    }

    public View cPl() {
        return this.ktr;
    }

    public TextView getUserName() {
        return this.dXU;
    }

    public TextView cPm() {
        return this.kta;
    }

    public UserIconBox cPn() {
        return this.ktd;
    }

    public FrameLayout cPo() {
        return this.kte;
    }

    public FrameLayout cPp() {
        return this.kth;
    }

    public FrameLayout cPq() {
        return this.ktk;
    }

    public HeadPendantView cPr() {
        return this.ktu;
    }

    public View cPs() {
        return this.ktz;
    }

    public ImageView cPt() {
        return this.ktb;
    }

    public void onDestroy() {
        if (this.fVg != null) {
            this.fVg.cancel();
        }
        if (this.ktx != null) {
            this.ktx.cancelAnimation();
        }
    }
}
