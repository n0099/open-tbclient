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
    private TextView cbJ;
    private AnimatorSet fcl;
    private com.baidu.tieba.i.a joo;
    private View jpA;
    private View jpB;
    private TextView jpC;
    private ImageView jpD;
    private TextView jpc;
    private ImageView jpd;
    private ImageView jpe;
    private UserIconBox jpf;
    private FrameLayout jpg;
    private TextView jph;
    private TextView jpi;
    private FrameLayout jpj;
    private TextView jpk;
    private TextView jpl;
    private FrameLayout jpm;
    private TextView jpn;
    private TextView jpo;
    private ImageView jpp;
    private ImageView jpq;
    private ImageView jpr;
    private TBSpecificationBtn jps;
    private TBSpecificationBtn jpt;
    private TbImageView jpu;
    private ImageView jpv;
    private HeadPendantView jpw;
    private RelativeLayout jpx;
    private ImageView jpy;
    private TBLottieAnimationView jpz;
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
        this.cbJ = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.cbJ.setOnClickListener(this.mClickListener);
        this.jpc = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.jpc.setAlpha(0.85f);
        this.jpc.setOnClickListener(this.mClickListener);
        this.jpd = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jpd.setOnClickListener(this.mClickListener);
        this.jpf = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.jpf.setOnClickListener(this.mClickListener);
        this.jph = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.jpg = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.jpg.setOnClickListener(this.mClickListener);
        this.jpi = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jpi.setAlpha(0.8f);
        this.jpq = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jpe = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jpk = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.jpj = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.jpj.setOnClickListener(this.mClickListener);
        this.jpl = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jpl.setAlpha(0.8f);
        this.jpr = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jpn = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.jpm = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.jpm.setOnClickListener(this.mClickListener);
        this.jpo = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.jpo.setAlpha(0.8f);
        this.jpp = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.jps = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.jps.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lt(R.color.cp_cont_b);
        this.jps.setConfig(cVar);
        this.jps.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.jpt = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.jpt.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lw(R.color.cp_cont_a);
        eVar.lr(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.icon_mask_wo_list_gift24_svg, true);
        this.jpt.setConfig(eVar);
        this.jpu = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.jpu.setOnClickListener(this.mClickListener);
        this.jpv = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.jpw = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.jpw.setHasPendantStyle();
        this.jpw.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.jpw.getHeadView().setIsRound(true);
        this.jpw.getHeadView().setDrawBorder(false);
        this.jpw.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jpw.setOnClickListener(this.mClickListener);
        this.jpw.setBigVDimenSize(R.dimen.tbds57);
        this.jpw.setAuthIconType(3);
        this.jpw.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.jpA = this.mRootView.findViewById(R.id.person_header_ring);
        this.jpA.setAlpha(0.33f);
        this.jpB = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.jpC = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.jpD = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.jpB.setOnClickListener(this.mClickListener);
        this.jpy = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.jpz = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.jpx = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.joo = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.cbJ.setText(this.mUserData.getName_show());
            }
            this.jpc.setVisibility(0);
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
                this.jpc.setVisibility(0);
                this.jpc.setText(intro);
                this.jpc.setEnabled(true);
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.jpc.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.jpc.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.jpc.setEnabled(false);
                                }
                                b.this.jpd.setVisibility(8);
                                return;
                            }
                            b.this.jpd.setVisibility(0);
                        }
                    }
                });
            } else {
                this.jpc.setVisibility(8);
            }
            this.jpf.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.jph.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jpn.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jpk.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.jps.setVisibility(8);
                this.jpt.setVisibility(8);
            } else {
                this.jpt.setVisibility(0);
                this.jps.setVisibility(0);
                ru(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.jpu.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.jpu.setVisibility(0);
            } else if (this.mIsHost) {
                this.jpu.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.jpu.setVisibility(0);
            } else {
                this.jpu.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aGA().a(this.jpv, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.jpv.setVisibility(8);
            } else {
                this.jpv.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.jpz.setVisibility(0);
                this.jpz.loop(true);
                this.jpz.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jpz.playAnimation();
                    }
                });
                this.jpA.setVisibility(8);
                cL(this.jpx);
                this.jpy.setVisibility(0);
                this.jpw.setIsclearmode(true);
                this.jpw.tT(this.mUserData.getAvater());
            } else {
                this.jpw.a(this.mUserData);
                this.jpy.setVisibility(8);
                this.jpw.setIsclearmode(false);
                this.jpA.setVisibility(0);
            }
            if (this.joo != null && this.joo.bMB() && !TextUtils.isEmpty(this.joo.goods_url)) {
                this.jpB.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").cy("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").cy("obj_param1", "1"));
                    return;
                }
            }
            this.jpB.setVisibility(8);
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
        this.fcl = new AnimatorSet();
        this.fcl.play(ofFloat).with(ofFloat2);
        this.fcl.start();
    }

    public void GU(String str) {
        this.jpw.tS(str);
    }

    public void ru(boolean z) {
        if (z) {
            this.jps.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.jps.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.jps.getStyleConfig()).aIr();
                return;
            }
            return;
        }
        this.jps.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.jps.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.jps.getStyleConfig()).lt(R.color.cp_cont_b);
        }
    }

    public void rv(boolean z) {
        if (z) {
            this.jpe.setVisibility(0);
        } else {
            this.jpe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGA().a(this.jpp, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGA().a(this.jpq, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGA().a(this.jpr, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jpt.aHL();
        this.jps.aHL();
        SvgManager.aGA().a(this.jpd, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jpy.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aGA().a(this.jpD, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.cbJ, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpc, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jph, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpi, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpk, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpl, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpn, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpo, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpC, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jpe, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.jpA, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aGA().a(this.jpv, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.jpz != null) {
                this.jpz.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.jpy != null) {
                this.jpy.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.jpz != null) {
                this.jpz.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.jpy != null) {
                this.jpy.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.jpz != null) {
                this.jpz.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.jpy != null) {
                this.jpy.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cxg() {
        return this.jpu;
    }

    public View cxh() {
        return this.jps;
    }

    public View cxi() {
        return this.jpt;
    }

    public TextView getUserName() {
        return this.cbJ;
    }

    public TextView cxj() {
        return this.jpc;
    }

    public UserIconBox cxk() {
        return this.jpf;
    }

    public FrameLayout cxl() {
        return this.jpg;
    }

    public FrameLayout cxm() {
        return this.jpj;
    }

    public FrameLayout cxn() {
        return this.jpm;
    }

    public HeadPendantView cxo() {
        return this.jpw;
    }

    public View cxp() {
        return this.jpB;
    }

    public ImageView cxq() {
        return this.jpd;
    }

    public void onDestroy() {
        if (this.fcl != null) {
            this.fcl.cancel();
        }
        if (this.jpz != null) {
            this.jpz.cancelAnimation();
        }
    }
}
