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
    private TextView cAX;
    private AnimatorSet fHg;
    private com.baidu.tieba.i.a kap;
    private ImageView kbA;
    private TBLottieAnimationView kbB;
    private View kbC;
    private View kbD;
    private TextView kbE;
    private ImageView kbF;
    private TextView kbe;
    private ImageView kbf;
    private ImageView kbg;
    private UserIconBox kbh;
    private FrameLayout kbi;
    private TextView kbj;
    private TextView kbk;
    private FrameLayout kbl;
    private TextView kbm;
    private TextView kbn;
    private FrameLayout kbo;
    private TextView kbp;
    private TextView kbq;
    private ImageView kbr;
    private ImageView kbs;
    private ImageView kbt;
    private TBSpecificationBtn kbu;
    private TBSpecificationBtn kbv;
    private TbImageView kbw;
    private ImageView kbx;
    private HeadPendantView kby;
    private RelativeLayout kbz;
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
        this.cAX = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.cAX.setOnClickListener(this.mClickListener);
        this.kbe = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kbe.setAlpha(0.85f);
        this.kbe.setOnClickListener(this.mClickListener);
        this.kbf = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.kbf.setOnClickListener(this.mClickListener);
        this.kbh = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.kbh.setOnClickListener(this.mClickListener);
        this.kbj = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kbi = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kbi.setOnClickListener(this.mClickListener);
        this.kbk = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.kbk.setAlpha(0.8f);
        this.kbs = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.kbg = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kbm = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kbl = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kbl.setOnClickListener(this.mClickListener);
        this.kbn = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.kbn.setAlpha(0.8f);
        this.kbt = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.kbp = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.kbo = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.kbo.setOnClickListener(this.mClickListener);
        this.kbq = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.kbq.setAlpha(0.8f);
        this.kbr = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.kbu = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.kbu.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lH(R.color.cp_cont_b);
        this.kbu.setConfig(cVar);
        this.kbu.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.kbv = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.kbv.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lK(R.color.cp_cont_a);
        eVar.lD(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.z(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.kbv.setConfig(eVar);
        this.kbw = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kbw.setOnClickListener(this.mClickListener);
        this.kbx = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.kby = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.kby.setHasPendantStyle();
        this.kby.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.kby.getHeadView().setIsRound(true);
        this.kby.getHeadView().setDrawBorder(false);
        this.kby.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kby.setOnClickListener(this.mClickListener);
        this.kby.setBigVDimenSize(R.dimen.tbds57);
        this.kby.setAuthIconType(3);
        this.kby.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kbC = this.mRootView.findViewById(R.id.person_header_ring);
        this.kbC.setAlpha(0.33f);
        this.kbD = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.kbE = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.kbF = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.kbD.setOnClickListener(this.mClickListener);
        this.kbA = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.kbB = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.kbz = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.kap = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.cAX.setText(this.mUserData.getName_show());
            }
            this.kbe.setVisibility(0);
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
                this.kbe.setVisibility(0);
                this.kbe.setText(intro);
                this.kbe.setEnabled(true);
                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kbe.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kbe.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kbe.setEnabled(false);
                                }
                                b.this.kbf.setVisibility(8);
                                return;
                            }
                            b.this.kbf.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kbe.setVisibility(8);
            }
            this.kbh.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.kbj.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.kbp.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kbm.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.kbu.setVisibility(8);
                this.kbv.setVisibility(8);
            } else {
                this.kbv.setVisibility(0);
                this.kbu.setVisibility(0);
                sE(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kbw.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kbw.setVisibility(0);
            } else if (this.mIsHost) {
                this.kbw.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.kbw.setVisibility(0);
            } else {
                this.kbw.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aOU().a(this.kbx, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.kbx.setVisibility(8);
            } else {
                this.kbx.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.kbB.setVisibility(0);
                this.kbB.loop(true);
                this.kbB.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kbB.playAnimation();
                    }
                });
                this.kbC.setVisibility(8);
                cT(this.kbz);
                this.kbA.setVisibility(0);
                this.kby.setIsclearmode(true);
                this.kby.vh(this.mUserData.getAvater());
            } else {
                this.kby.a(this.mUserData);
                this.kbA.setVisibility(8);
                this.kby.setIsclearmode(false);
                this.kbC.setVisibility(0);
            }
            if (this.kap != null && this.kap.bXt() && !TextUtils.isEmpty(this.kap.goods_url)) {
                this.kbD.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").cI("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").cI("obj_param1", "1"));
                    return;
                }
            }
            this.kbD.setVisibility(8);
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
        this.fHg = new AnimatorSet();
        this.fHg.play(ofFloat).with(ofFloat2);
        this.fHg.start();
    }

    public void IC(String str) {
        this.kby.vg(str);
    }

    public void sE(boolean z) {
        if (z) {
            this.kbu.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.kbu.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.kbu.getStyleConfig()).aQU();
                return;
            }
            return;
        }
        this.kbu.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.kbu.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.kbu.getStyleConfig()).lH(R.color.cp_cont_b);
        }
    }

    public void sF(boolean z) {
        if (z) {
            this.kbg.setVisibility(0);
        } else {
            this.kbg.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aOU().a(this.kbr, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOU().a(this.kbs, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOU().a(this.kbt, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kbv.aQp();
        this.kbu.aQp();
        SvgManager.aOU().a(this.kbf, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kbA.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aOU().a(this.kbF, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.cAX, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbe, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbj, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbk, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbm, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbn, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbp, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbq, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kbE, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.kbg, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.kbC, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aOU().a(this.kbx, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.kbB != null) {
                this.kbB.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.kbA != null) {
                this.kbA.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.kbB != null) {
                this.kbB.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.kbA != null) {
                this.kbA.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.kbB != null) {
                this.kbB.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.kbA != null) {
                this.kbA.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cIm() {
        return this.kbw;
    }

    public View cIn() {
        return this.kbu;
    }

    public View cIo() {
        return this.kbv;
    }

    public TextView getUserName() {
        return this.cAX;
    }

    public TextView cIp() {
        return this.kbe;
    }

    public UserIconBox cIq() {
        return this.kbh;
    }

    public FrameLayout cIr() {
        return this.kbi;
    }

    public FrameLayout cIs() {
        return this.kbl;
    }

    public FrameLayout cIt() {
        return this.kbo;
    }

    public HeadPendantView cIu() {
        return this.kby;
    }

    public View cIv() {
        return this.kbD;
    }

    public ImageView cIw() {
        return this.kbf;
    }

    public void onDestroy() {
        if (this.fHg != null) {
            this.fHg.cancel();
        }
        if (this.kbB != null) {
            this.kbB.cancelAnimation();
        }
    }
}
