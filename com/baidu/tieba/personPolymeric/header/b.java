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
    private TextView cbL;
    private AnimatorSet fcz;
    private com.baidu.tieba.i.a joC;
    private FrameLayout jpA;
    private TextView jpB;
    private TextView jpC;
    private ImageView jpD;
    private ImageView jpE;
    private ImageView jpF;
    private TBSpecificationBtn jpG;
    private TBSpecificationBtn jpH;
    private TbImageView jpI;
    private ImageView jpJ;
    private HeadPendantView jpK;
    private RelativeLayout jpL;
    private ImageView jpM;
    private TBLottieAnimationView jpN;
    private View jpO;
    private View jpP;
    private TextView jpQ;
    private ImageView jpR;
    private TextView jpq;
    private ImageView jpr;
    private ImageView jps;
    private UserIconBox jpt;
    private FrameLayout jpu;
    private TextView jpv;
    private TextView jpw;
    private FrameLayout jpx;
    private TextView jpy;
    private TextView jpz;
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
        this.cbL = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.cbL.setOnClickListener(this.mClickListener);
        this.jpq = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.jpq.setAlpha(0.85f);
        this.jpq.setOnClickListener(this.mClickListener);
        this.jpr = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jpr.setOnClickListener(this.mClickListener);
        this.jpt = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.jpt.setOnClickListener(this.mClickListener);
        this.jpv = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.jpu = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.jpu.setOnClickListener(this.mClickListener);
        this.jpw = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jpw.setAlpha(0.8f);
        this.jpE = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jps = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jpy = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.jpx = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.jpx.setOnClickListener(this.mClickListener);
        this.jpz = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jpz.setAlpha(0.8f);
        this.jpF = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jpB = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.jpA = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.jpA.setOnClickListener(this.mClickListener);
        this.jpC = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.jpC.setAlpha(0.8f);
        this.jpD = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.jpG = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.jpG.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lt(R.color.cp_cont_b);
        this.jpG.setConfig(cVar);
        this.jpG.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.jpH = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.jpH.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lw(R.color.cp_cont_a);
        eVar.lr(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.icon_mask_wo_list_gift24_svg, true);
        this.jpH.setConfig(eVar);
        this.jpI = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.jpI.setOnClickListener(this.mClickListener);
        this.jpJ = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.jpK = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.jpK.setHasPendantStyle();
        this.jpK.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.jpK.getHeadView().setIsRound(true);
        this.jpK.getHeadView().setDrawBorder(false);
        this.jpK.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jpK.setOnClickListener(this.mClickListener);
        this.jpK.setBigVDimenSize(R.dimen.tbds57);
        this.jpK.setAuthIconType(3);
        this.jpK.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.jpO = this.mRootView.findViewById(R.id.person_header_ring);
        this.jpO.setAlpha(0.33f);
        this.jpP = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.jpQ = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.jpR = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.jpP.setOnClickListener(this.mClickListener);
        this.jpM = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.jpN = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.jpL = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.joC = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.cbL.setText(this.mUserData.getName_show());
            }
            this.jpq.setVisibility(0);
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
                this.jpq.setVisibility(0);
                this.jpq.setText(intro);
                this.jpq.setEnabled(true);
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.jpq.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.jpq.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.jpq.setEnabled(false);
                                }
                                b.this.jpr.setVisibility(8);
                                return;
                            }
                            b.this.jpr.setVisibility(0);
                        }
                    }
                });
            } else {
                this.jpq.setVisibility(8);
            }
            this.jpt.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.jpv.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jpB.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jpy.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.jpG.setVisibility(8);
                this.jpH.setVisibility(8);
            } else {
                this.jpH.setVisibility(0);
                this.jpG.setVisibility(0);
                ru(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.jpI.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.jpI.setVisibility(0);
            } else if (this.mIsHost) {
                this.jpI.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.jpI.setVisibility(0);
            } else {
                this.jpI.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aGC().a(this.jpJ, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.jpJ.setVisibility(8);
            } else {
                this.jpJ.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.jpN.setVisibility(0);
                this.jpN.loop(true);
                this.jpN.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jpN.playAnimation();
                    }
                });
                this.jpO.setVisibility(8);
                cL(this.jpL);
                this.jpM.setVisibility(0);
                this.jpK.setIsclearmode(true);
                this.jpK.tU(this.mUserData.getAvater());
            } else {
                this.jpK.a(this.mUserData);
                this.jpM.setVisibility(8);
                this.jpK.setIsclearmode(false);
                this.jpO.setVisibility(0);
            }
            if (this.joC != null && this.joC.bME() && !TextUtils.isEmpty(this.joC.goods_url)) {
                this.jpP.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").cy("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").cy("obj_param1", "1"));
                    return;
                }
            }
            this.jpP.setVisibility(8);
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
        this.fcz = new AnimatorSet();
        this.fcz.play(ofFloat).with(ofFloat2);
        this.fcz.start();
    }

    public void GV(String str) {
        this.jpK.tT(str);
    }

    public void ru(boolean z) {
        if (z) {
            this.jpG.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.jpG.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.jpG.getStyleConfig()).aIu();
                return;
            }
            return;
        }
        this.jpG.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.jpG.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.jpG.getStyleConfig()).lt(R.color.cp_cont_b);
        }
    }

    public void rv(boolean z) {
        if (z) {
            this.jps.setVisibility(0);
        } else {
            this.jps.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGC().a(this.jpD, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a(this.jpE, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a(this.jpF, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jpH.aHO();
        this.jpG.aHO();
        SvgManager.aGC().a(this.jpr, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jpM.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aGC().a(this.jpR, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.cbL, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpq, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpv, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpw, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpy, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpz, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpB, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpC, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jpQ, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jps, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.jpO, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aGC().a(this.jpJ, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.jpN != null) {
                this.jpN.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.jpM != null) {
                this.jpM.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.jpN != null) {
                this.jpN.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.jpM != null) {
                this.jpM.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.jpN != null) {
                this.jpN.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.jpM != null) {
                this.jpM.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cxj() {
        return this.jpI;
    }

    public View cxk() {
        return this.jpG;
    }

    public View cxl() {
        return this.jpH;
    }

    public TextView getUserName() {
        return this.cbL;
    }

    public TextView cxm() {
        return this.jpq;
    }

    public UserIconBox cxn() {
        return this.jpt;
    }

    public FrameLayout cxo() {
        return this.jpu;
    }

    public FrameLayout cxp() {
        return this.jpx;
    }

    public FrameLayout cxq() {
        return this.jpA;
    }

    public HeadPendantView cxr() {
        return this.jpK;
    }

    public View cxs() {
        return this.jpP;
    }

    public ImageView cxt() {
        return this.jpr;
    }

    public void onDestroy() {
        if (this.fcz != null) {
            this.fcz.cancel();
        }
        if (this.jpN != null) {
            this.jpN.cancelAnimation();
        }
    }
}
