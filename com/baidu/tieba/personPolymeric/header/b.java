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
    private AnimatorSet fVr;
    private com.baidu.tieba.i.a kts;
    private HeadPendantView kuA;
    private RelativeLayout kuB;
    private ImageView kuC;
    private TBLottieAnimationView kuD;
    private View kuE;
    private View kuF;
    private TextView kuG;
    private ImageView kuH;
    private TextView kug;
    private ImageView kuh;
    private ImageView kui;
    private UserIconBox kuj;
    private FrameLayout kuk;
    private TextView kul;
    private TextView kum;
    private FrameLayout kun;
    private TextView kuo;
    private TextView kup;
    private FrameLayout kuq;
    private TextView kur;
    private TextView kus;
    private ImageView kut;
    private ImageView kuu;
    private ImageView kuv;
    private TBSpecificationBtn kuw;
    private TBSpecificationBtn kux;
    private TbImageView kuy;
    private ImageView kuz;
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
        this.kug = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.kug.setAlpha(0.85f);
        this.kug.setOnClickListener(this.mClickListener);
        this.kuh = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.kuh.setOnClickListener(this.mClickListener);
        this.kuj = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.kuj.setOnClickListener(this.mClickListener);
        this.kul = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.kuk = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.kuk.setOnClickListener(this.mClickListener);
        this.kum = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.kum.setAlpha(0.8f);
        this.kuu = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.kui = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.kuo = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.kun = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.kun.setOnClickListener(this.mClickListener);
        this.kup = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.kup.setAlpha(0.8f);
        this.kuv = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.kur = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.kuq = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.kuq.setOnClickListener(this.mClickListener);
        this.kus = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.kus.setAlpha(0.8f);
        this.kut = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.kuw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.kuw.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ml(R.color.cp_cont_b);
        this.kuw.setConfig(cVar);
        this.kuw.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.kux = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.kux.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.mo(R.color.cp_cont_a);
        eVar.mh(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.C(R.drawable.ic_icon_pure_personalba_gift24_svg, true);
        this.kux.setConfig(eVar);
        this.kuy = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.kuy.setOnClickListener(this.mClickListener);
        this.kuz = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.kuA = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.kuA.setHasPendantStyle();
        this.kuA.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.kuA.getHeadView().setIsRound(true);
        this.kuA.getHeadView().setDrawBorder(false);
        this.kuA.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kuA.setOnClickListener(this.mClickListener);
        this.kuA.setBigVDimenSize(R.dimen.tbds57);
        this.kuA.setAuthIconType(3);
        this.kuA.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.kuE = this.mRootView.findViewById(R.id.person_header_ring);
        this.kuE.setAlpha(0.33f);
        this.kuF = this.mRootView.findViewById(R.id.person_center_my_store_layout);
        this.kuG = (TextView) this.mRootView.findViewById(R.id.btn_person_center_my_store_text);
        this.kuH = (ImageView) this.mRootView.findViewById(R.id.btn_person_center_my_store_img);
        this.kuF.setOnClickListener(this.mClickListener);
        this.kuC = (ImageView) this.mRootView.findViewById(R.id.person_header_ala_live);
        this.kuD = (TBLottieAnimationView) this.mRootView.findViewById(R.id.living_bg_lottie);
        this.kuB = (RelativeLayout) this.mRootView.findViewById(R.id.userheaderview_container);
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
            this.kts = aVar;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.dXU.setText(this.mUserData.getName_show());
            }
            this.kug.setVisibility(0);
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
                this.kug.setVisibility(0);
                this.kug.setText(intro);
                this.kug.setEnabled(true);
                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.kug.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.kug.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.kug.setEnabled(false);
                                }
                                b.this.kuh.setVisibility(8);
                                return;
                            }
                            b.this.kuh.setVisibility(0);
                        }
                    }
                });
            } else {
                this.kug.setVisibility(8);
            }
            this.kuj.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.kul.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.kur.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.kuo.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.kuw.setVisibility(8);
                this.kux.setVisibility(8);
            } else {
                this.kux.setVisibility(0);
                this.kuw.setVisibility(0);
                tc(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.kuy.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.kuy.setVisibility(0);
            } else if (this.mIsHost) {
                this.kuy.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.kuy.setVisibility(0);
            } else {
                this.kuy.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aUW().a(this.kuz, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.kuz.setVisibility(8);
            } else {
                this.kuz.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.kuD.setVisibility(0);
                this.kuD.loop(true);
                this.kuD.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kuD.playAnimation();
                    }
                });
                this.kuE.setVisibility(8);
                cU(this.kuB);
                this.kuC.setVisibility(0);
                this.kuA.setIsclearmode(true);
                this.kuA.wQ(this.mUserData.getAvater());
            } else {
                this.kuA.a(this.mUserData);
                this.kuC.setVisibility(8);
                this.kuA.setIsclearmode(false);
                this.kuE.setVisibility(0);
            }
            if (this.kts != null && this.kts.cdY() && !TextUtils.isEmpty(this.kts.goods_url)) {
                this.kuF.setVisibility(0);
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c13612").dh("obj_param1", "0"));
                    return;
                } else {
                    TiebaStatic.log(new an("c13612").dh("obj_param1", "1"));
                    return;
                }
            }
            this.kuF.setVisibility(8);
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
        this.fVr = new AnimatorSet();
        this.fVr.play(ofFloat).with(ofFloat2);
        this.fVr.start();
    }

    public void Ks(String str) {
        this.kuA.wP(str);
    }

    public void tc(boolean z) {
        if (z) {
            this.kuw.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.kuw.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.kuw.getStyleConfig()).aXa();
                return;
            }
            return;
        }
        this.kuw.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.kuw.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.kuw.getStyleConfig()).ml(R.color.cp_cont_b);
        }
    }

    public void td(boolean z) {
        if (z) {
            this.kui.setVisibility(0);
        } else {
            this.kui.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aUW().a(this.kut, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUW().a(this.kuu, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUW().a(this.kuv, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kux.aWr();
        this.kuw.aWr();
        SvgManager.aUW().a(this.kuh, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.kuC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.aUW().a(this.kuH, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.dXU, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kug, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kul, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kum, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kuo, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kup, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kur, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kus, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kuG, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.kui, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.kuE, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aUW().a(this.kuz, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            if (this.kuD != null) {
                this.kuD.setAnimation("live/personcenter_live_bg_black.json");
            }
            if (this.kuC != null) {
                this.kuC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            if (this.kuD != null) {
                this.kuD.setAnimation("live/personcenter_live_bg_night.json");
            }
            if (this.kuC != null) {
                this.kuC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            if (this.kuD != null) {
                this.kuD.setAnimation("live/personcenter_live_bg.json");
            }
            if (this.kuC != null) {
                this.kuC.setImageDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public TbImageView cPz() {
        return this.kuy;
    }

    public View cPA() {
        return this.kuw;
    }

    public View cPB() {
        return this.kux;
    }

    public TextView getUserName() {
        return this.dXU;
    }

    public TextView cPC() {
        return this.kug;
    }

    public UserIconBox cPD() {
        return this.kuj;
    }

    public FrameLayout cPE() {
        return this.kuk;
    }

    public FrameLayout cPF() {
        return this.kun;
    }

    public FrameLayout cPG() {
        return this.kuq;
    }

    public HeadPendantView cPH() {
        return this.kuA;
    }

    public View cPI() {
        return this.kuF;
    }

    public ImageView cPJ() {
        return this.kuh;
    }

    public void onDestroy() {
        if (this.fVr != null) {
            this.fVr.cancel();
        }
        if (this.kuD != null) {
            this.kuD.cancelAnimation();
        }
    }
}
