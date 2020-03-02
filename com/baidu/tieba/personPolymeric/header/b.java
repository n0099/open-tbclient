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
    private TextView cbK;
    private AnimatorSet fcm;
    private com.baidu.tieba.i.a joq;
    private ImageView jpA;
    private TBLottieAnimationView jpB;
    private View jpC;
    private View jpD;
    private TextView jpE;
    private ImageView jpF;
    private TextView jpe;
    private ImageView jpf;
    private ImageView jpg;
    private UserIconBox jph;
    private FrameLayout jpi;
    private TextView jpj;
    private TextView jpk;
    private FrameLayout jpl;
    private TextView jpm;
    private TextView jpn;
    private FrameLayout jpo;
    private TextView jpp;
    private TextView jpq;
    private ImageView jpr;
    private ImageView jps;
    private ImageView jpt;
    private TBSpecificationBtn jpu;
    private TBSpecificationBtn jpv;
    private TbImageView jpw;
    private ImageView jpx;
    private HeadPendantView jpy;
    private RelativeLayout jpz;
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
        this.cbK = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.cbK.setOnClickListener(this.mClickListener);
        this.jpe = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.jpe.setAlpha(0.85f);
        this.jpe.setOnClickListener(this.mClickListener);
        this.jpf = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jpf.setOnClickListener(this.mClickListener);
        this.jph = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.jph.setOnClickListener(this.mClickListener);
        this.jpj = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.jpi = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.jpi.setOnClickListener(this.mClickListener);
        this.jpk = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jpk.setAlpha(0.8f);
        this.jps = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jpg = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jpm = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.jpl = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.jpl.setOnClickListener(this.mClickListener);
        this.jpn = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jpn.setAlpha(0.8f);
        this.jpt = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jpp = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.jpo = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.jpo.setOnClickListener(this.mClickListener);
        this.jpq = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.jpq.setAlpha(0.8f);
        this.jpr = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.jpu = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.jpu.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lt(R.color.cp_cont_b);
        this.jpu.setConfig(cVar);
        this.jpu.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.jpv = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.jpv.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lw(R.color.cp_cont_a);
        eVar.lr(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.icon_mask_wo_list_gift24_svg, true);
        this.jpv.setConfig(eVar);
        this.jpw = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.jpw.setOnClickListener(this.mClickListener);
        this.jpx = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.jpy = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.jpy.setHasPendantStyle();
        this.jpy.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.jpy.getHeadView().setIsRound(true);
        this.jpy.getHeadView().setDrawBorder(false);
        this.jpy.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jpy.setOnClickListener(this.mClickListener);
        this.jpy.setBigVDimenSize(R.dimen.tbds57);
        this.jpy.setAuthIconType(3);
        this.jpy.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.jpC = this.mRootView.findViewById(R.id.person_header_ring);
        this.jpC.setAlpha(0.33f);
        this.jpD = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.jpE = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.jpF = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.jpD.setOnClickListener(this.mClickListener);
        this.jpA = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.jpB = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.jpz = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.joq = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.cbK.setText(this.mUserData.getName_show());
            }
            this.jpe.setVisibility(0);
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
                this.jpe.setVisibility(0);
                this.jpe.setText(intro);
                this.jpe.setEnabled(true);
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.jpe.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.jpe.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.jpe.setEnabled(false);
                                }
                                b.this.jpf.setVisibility(8);
                                return;
                            }
                            b.this.jpf.setVisibility(0);
                        }
                    }
                });
            } else {
                this.jpe.setVisibility(8);
            }
            this.jph.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.jpj.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jpp.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jpm.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.jpu.setVisibility(8);
                this.jpv.setVisibility(8);
            } else {
                this.jpv.setVisibility(0);
                this.jpu.setVisibility(0);
                ru(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.jpw.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.jpw.setVisibility(0);
            } else if (this.mIsHost) {
                this.jpw.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.jpw.setVisibility(0);
            } else {
                this.jpw.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aGC().a(this.jpx, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.jpx.setVisibility(8);
            } else {
                this.jpx.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.jpB.setVisibility(0);
                this.jpB.loop(true);
                this.jpB.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jpB.playAnimation();
                    }
                });
                this.jpC.setVisibility(8);
                cL(this.jpz);
                this.jpA.setVisibility(0);
                this.jpy.setIsclearmode(true);
                this.jpy.tT(this.mUserData.getAvater());
            } else {
                this.jpy.a(this.mUserData);
                this.jpA.setVisibility(8);
                this.jpy.setIsclearmode(false);
                this.jpC.setVisibility(0);
            }
            if (this.joq != null && this.joq.bMD() && !TextUtils.isEmpty(this.joq.goods_url)) {
                this.jpD.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").cy("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").cy("obj_param1", "1"));
                    return;
                }
            }
            this.jpD.setVisibility(8);
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
        this.fcm = new AnimatorSet();
        this.fcm.play(ofFloat).with(ofFloat2);
        this.fcm.start();
    }

    public void GU(String str) {
        this.jpy.tS(str);
    }

    public void ru(boolean z) {
        if (z) {
            this.jpu.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.jpu.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.jpu.getStyleConfig()).aIt();
                return;
            }
            return;
        }
        this.jpu.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.jpu.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.jpu.getStyleConfig()).lt(R.color.cp_cont_b);
        }
    }

    public void rv(boolean z) {
        if (z) {
            this.jpg.setVisibility(0);
        } else {
            this.jpg.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGC().a(this.jpr, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a(this.jps, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a(this.jpt, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jpv.aHN();
        this.jpu.aHN();
        SvgManager.aGC().a(this.jpf, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jpA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aGC().a(this.jpF, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.cbK, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpe, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpj, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpk, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpm, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpn, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpp, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpq, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpE, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jpg, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.jpC, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aGC().a(this.jpx, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.jpB != null) {
                this.jpB.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.jpA != null) {
                this.jpA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.jpB != null) {
                this.jpB.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.jpA != null) {
                this.jpA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.jpB != null) {
                this.jpB.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.jpA != null) {
                this.jpA.setImageDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cxi() {
        return this.jpw;
    }

    public View cxj() {
        return this.jpu;
    }

    public View cxk() {
        return this.jpv;
    }

    public TextView getUserName() {
        return this.cbK;
    }

    public TextView cxl() {
        return this.jpe;
    }

    public UserIconBox cxm() {
        return this.jph;
    }

    public FrameLayout cxn() {
        return this.jpi;
    }

    public FrameLayout cxo() {
        return this.jpl;
    }

    public FrameLayout cxp() {
        return this.jpo;
    }

    public HeadPendantView cxq() {
        return this.jpy;
    }

    public View cxr() {
        return this.jpD;
    }

    public ImageView cxs() {
        return this.jpf;
    }

    public void onDestroy() {
        if (this.fcm != null) {
            this.fcm.cancel();
        }
        if (this.jpB != null) {
            this.jpB.cancelAnimation();
        }
    }
}
