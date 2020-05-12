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
    private TextView cBd;
    private AnimatorSet fHl;
    private com.baidu.tieba.i.a kat;
    private TbImageView kbA;
    private ImageView kbB;
    private HeadPendantView kbC;
    private RelativeLayout kbD;
    private ImageView kbE;
    private TBLottieAnimationView kbF;
    private View kbG;
    private View kbH;
    private TextView kbI;
    private ImageView kbJ;
    private TextView kbi;
    private ImageView kbj;
    private ImageView kbk;
    private UserIconBox kbl;
    private FrameLayout kbm;
    private TextView kbn;
    private TextView kbo;
    private FrameLayout kbp;
    private TextView kbq;
    private TextView kbr;
    private FrameLayout kbs;
    private TextView kbt;
    private TextView kbu;
    private ImageView kbv;
    private ImageView kbw;
    private ImageView kbx;
    private TBSpecificationBtn kby;
    private TBSpecificationBtn kbz;
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
        this.cBd = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.cBd.setOnClickListener(this.mClickListener);
        this.kbi = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kbi.setAlpha(0.85f);
        this.kbi.setOnClickListener(this.mClickListener);
        this.kbj = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.kbj.setOnClickListener(this.mClickListener);
        this.kbl = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.kbl.setOnClickListener(this.mClickListener);
        this.kbn = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kbm = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kbm.setOnClickListener(this.mClickListener);
        this.kbo = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.kbo.setAlpha(0.8f);
        this.kbw = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.kbk = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kbq = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kbp = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kbp.setOnClickListener(this.mClickListener);
        this.kbr = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.kbr.setAlpha(0.8f);
        this.kbx = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.kbt = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.kbs = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.kbs.setOnClickListener(this.mClickListener);
        this.kbu = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.kbu.setAlpha(0.8f);
        this.kbv = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.kby = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.kby.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lH(R.color.cp_cont_b);
        this.kby.setConfig(cVar);
        this.kby.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.kbz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.kbz.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lK(R.color.cp_cont_a);
        eVar.lD(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.z(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.kbz.setConfig(eVar);
        this.kbA = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kbA.setOnClickListener(this.mClickListener);
        this.kbB = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.kbC = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.kbC.setHasPendantStyle();
        this.kbC.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.kbC.getHeadView().setIsRound(true);
        this.kbC.getHeadView().setDrawBorder(false);
        this.kbC.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kbC.setOnClickListener(this.mClickListener);
        this.kbC.setBigVDimenSize(R.dimen.tbds57);
        this.kbC.setAuthIconType(3);
        this.kbC.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kbG = this.mRootView.findViewById(R.id.person_header_ring);
        this.kbG.setAlpha(0.33f);
        this.kbH = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.kbI = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.kbJ = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.kbH.setOnClickListener(this.mClickListener);
        this.kbE = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.kbF = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.kbD = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.kat = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.cBd.setText(this.mUserData.getName_show());
            }
            this.kbi.setVisibility(0);
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
                this.kbi.setVisibility(0);
                this.kbi.setText(intro);
                this.kbi.setEnabled(true);
                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kbi.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kbi.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kbi.setEnabled(false);
                                }
                                b.this.kbj.setVisibility(8);
                                return;
                            }
                            b.this.kbj.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kbi.setVisibility(8);
            }
            this.kbl.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.kbn.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.kbt.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kbq.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.kby.setVisibility(8);
                this.kbz.setVisibility(8);
            } else {
                this.kbz.setVisibility(0);
                this.kby.setVisibility(0);
                sE(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kbA.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kbA.setVisibility(0);
            } else if (this.mIsHost) {
                this.kbA.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.kbA.setVisibility(0);
            } else {
                this.kbA.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aOR().a(this.kbB, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.kbB.setVisibility(8);
            } else {
                this.kbB.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.kbF.setVisibility(0);
                this.kbF.loop(true);
                this.kbF.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kbF.playAnimation();
                    }
                });
                this.kbG.setVisibility(8);
                cT(this.kbD);
                this.kbE.setVisibility(0);
                this.kbC.setIsclearmode(true);
                this.kbC.vk(this.mUserData.getAvater());
            } else {
                this.kbC.a(this.mUserData);
                this.kbE.setVisibility(8);
                this.kbC.setIsclearmode(false);
                this.kbG.setVisibility(0);
            }
            if (this.kat != null && this.kat.bXs() && !TextUtils.isEmpty(this.kat.goods_url)) {
                this.kbH.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").cI("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").cI("obj_param1", "1"));
                    return;
                }
            }
            this.kbH.setVisibility(8);
        }
    }

    private void cT(View view) {
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
        this.fHl = new AnimatorSet();
        this.fHl.play(ofFloat).with(ofFloat2);
        this.fHl.start();
    }

    public void IF(String str) {
        this.kbC.vj(str);
    }

    public void sE(boolean z) {
        if (z) {
            this.kby.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.kby.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.kby.getStyleConfig()).aQR();
                return;
            }
            return;
        }
        this.kby.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.kby.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.kby.getStyleConfig()).lH(R.color.cp_cont_b);
        }
    }

    public void sF(boolean z) {
        if (z) {
            this.kbk.setVisibility(0);
        } else {
            this.kbk.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aOR().a(this.kbv, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOR().a(this.kbw, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOR().a(this.kbx, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kbz.aQm();
        this.kby.aQm();
        SvgManager.aOR().a(this.kbj, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kbE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aOR().a(this.kbJ, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.cBd, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbi, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbn, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbo, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbq, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbr, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbt, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbu, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbI, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.kbk, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.kbG, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aOR().a(this.kbB, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.kbF != null) {
                this.kbF.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.kbE != null) {
                this.kbE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.kbF != null) {
                this.kbF.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.kbE != null) {
                this.kbE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.kbF != null) {
                this.kbF.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.kbE != null) {
                this.kbE.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cIk() {
        return this.kbA;
    }

    public View cIl() {
        return this.kby;
    }

    public View cIm() {
        return this.kbz;
    }

    public TextView getUserName() {
        return this.cBd;
    }

    public TextView cIn() {
        return this.kbi;
    }

    public UserIconBox cIo() {
        return this.kbl;
    }

    public FrameLayout cIp() {
        return this.kbm;
    }

    public FrameLayout cIq() {
        return this.kbp;
    }

    public FrameLayout cIr() {
        return this.kbs;
    }

    public HeadPendantView cIs() {
        return this.kbC;
    }

    public View cIt() {
        return this.kbH;
    }

    public ImageView cIu() {
        return this.kbj;
    }

    public void onDestroy() {
        if (this.fHl != null) {
            this.fHl.cancel();
        }
        if (this.kbF != null) {
            this.kbF.cancelAnimation();
        }
    }
}
