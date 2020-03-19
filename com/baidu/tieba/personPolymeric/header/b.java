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
    private TextView cbW;
    private AnimatorSet fcX;
    private TextView jqP;
    private ImageView jqQ;
    private ImageView jqR;
    private UserIconBox jqS;
    private FrameLayout jqT;
    private TextView jqU;
    private TextView jqV;
    private FrameLayout jqW;
    private TextView jqX;
    private TextView jqY;
    private FrameLayout jqZ;
    private com.baidu.tieba.i.a jqb;
    private TextView jra;
    private TextView jrb;
    private ImageView jrc;
    private ImageView jrd;
    private ImageView jre;
    private TBSpecificationBtn jrf;
    private TBSpecificationBtn jrg;
    private TbImageView jrh;
    private ImageView jri;
    private HeadPendantView jrj;
    private RelativeLayout jrk;
    private ImageView jrl;
    private TBLottieAnimationView jrm;
    private View jrn;
    private View jro;
    private TextView jrp;
    private ImageView jrq;
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
        this.cbW = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.cbW.setOnClickListener(this.mClickListener);
        this.jqP = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.jqP.setAlpha(0.85f);
        this.jqP.setOnClickListener(this.mClickListener);
        this.jqQ = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jqQ.setOnClickListener(this.mClickListener);
        this.jqS = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.jqS.setOnClickListener(this.mClickListener);
        this.jqU = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.jqT = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.jqT.setOnClickListener(this.mClickListener);
        this.jqV = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jqV.setAlpha(0.8f);
        this.jrd = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jqR = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jqX = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.jqW = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.jqW.setOnClickListener(this.mClickListener);
        this.jqY = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jqY.setAlpha(0.8f);
        this.jre = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jra = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.jqZ = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.jqZ.setOnClickListener(this.mClickListener);
        this.jrb = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.jrb.setAlpha(0.8f);
        this.jrc = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.jrf = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.jrf.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lv(R.color.cp_cont_b);
        this.jrf.setConfig(cVar);
        this.jrf.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.jrg = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.jrg.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.ly(R.color.cp_cont_a);
        eVar.lr(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.jrg.setConfig(eVar);
        this.jrh = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.jrh.setOnClickListener(this.mClickListener);
        this.jri = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.jrj = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.jrj.setHasPendantStyle();
        this.jrj.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.jrj.getHeadView().setIsRound(true);
        this.jrj.getHeadView().setDrawBorder(false);
        this.jrj.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jrj.setOnClickListener(this.mClickListener);
        this.jrj.setBigVDimenSize(R.dimen.tbds57);
        this.jrj.setAuthIconType(3);
        this.jrj.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.jrn = this.mRootView.findViewById(R.id.person_header_ring);
        this.jrn.setAlpha(0.33f);
        this.jro = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.jrp = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.jrq = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.jro.setOnClickListener(this.mClickListener);
        this.jrl = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.jrm = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.jrk = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.jqb = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.cbW.setText(this.mUserData.getName_show());
            }
            this.jqP.setVisibility(0);
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
                this.jqP.setVisibility(0);
                this.jqP.setText(intro);
                this.jqP.setEnabled(true);
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.jqP.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.jqP.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.jqP.setEnabled(false);
                                }
                                b.this.jqQ.setVisibility(8);
                                return;
                            }
                            b.this.jqQ.setVisibility(0);
                        }
                    }
                });
            } else {
                this.jqP.setVisibility(8);
            }
            this.jqS.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.jqU.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jra.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jqX.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.jrf.setVisibility(8);
                this.jrg.setVisibility(8);
            } else {
                this.jrg.setVisibility(0);
                this.jrf.setVisibility(0);
                rA(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.jrh.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.jrh.setVisibility(0);
            } else if (this.mIsHost) {
                this.jrh.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.jrh.setVisibility(0);
            } else {
                this.jrh.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aGG().a(this.jri, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.jri.setVisibility(8);
            } else {
                this.jri.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.jrm.setVisibility(0);
                this.jrm.loop(true);
                this.jrm.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jrm.playAnimation();
                    }
                });
                this.jrn.setVisibility(8);
                cL(this.jrk);
                this.jrl.setVisibility(0);
                this.jrj.setIsclearmode(true);
                this.jrj.tU(this.mUserData.getAvater());
            } else {
                this.jrj.a(this.mUserData);
                this.jrl.setVisibility(8);
                this.jrj.setIsclearmode(false);
                this.jrn.setVisibility(0);
            }
            if (this.jqb != null && this.jqb.bMS() && !TextUtils.isEmpty(this.jqb.goods_url)) {
                this.jro.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").cx("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").cx("obj_param1", "1"));
                    return;
                }
            }
            this.jro.setVisibility(8);
        }
    }

    private void cL(View view) {
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
        this.fcX = new AnimatorSet();
        this.fcX.play(ofFloat).with(ofFloat2);
        this.fcX.start();
    }

    public void GV(String str) {
        this.jrj.tT(str);
    }

    public void rA(boolean z) {
        if (z) {
            this.jrf.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.jrf.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.jrf.getStyleConfig()).aIy();
                return;
            }
            return;
        }
        this.jrf.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.jrf.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.jrf.getStyleConfig()).lv(R.color.cp_cont_b);
        }
    }

    public void rB(boolean z) {
        if (z) {
            this.jqR.setVisibility(0);
        } else {
            this.jqR.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGG().a(this.jrc, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGG().a(this.jrd, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGG().a(this.jre, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jrg.aHS();
        this.jrf.aHS();
        SvgManager.aGG().a(this.jqQ, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jrl.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aGG().a(this.jrq, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.cbW, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jqP, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jqU, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jqV, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jqX, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jqY, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jra, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jrb, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jrp, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jqR, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.jrn, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aGG().a(this.jri, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.jrm != null) {
                this.jrm.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.jrl != null) {
                this.jrl.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.jrm != null) {
                this.jrm.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.jrl != null) {
                this.jrl.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.jrm != null) {
                this.jrm.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.jrl != null) {
                this.jrl.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cxC() {
        return this.jrh;
    }

    public View cxD() {
        return this.jrf;
    }

    public View cxE() {
        return this.jrg;
    }

    public TextView getUserName() {
        return this.cbW;
    }

    public TextView cxF() {
        return this.jqP;
    }

    public UserIconBox cxG() {
        return this.jqS;
    }

    public FrameLayout cxH() {
        return this.jqT;
    }

    public FrameLayout cxI() {
        return this.jqW;
    }

    public FrameLayout cxJ() {
        return this.jqZ;
    }

    public HeadPendantView cxK() {
        return this.jrj;
    }

    public View cxL() {
        return this.jro;
    }

    public ImageView cxM() {
        return this.jqQ;
    }

    public void onDestroy() {
        if (this.fcX != null) {
            this.fcX.cancel();
        }
        if (this.jrm != null) {
            this.jrm.cancelAnimation();
        }
    }
}
