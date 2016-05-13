package com.baidu.tieba.personInfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bd extends a {
    private boolean bIW;
    private View bxh;
    private HeadImageView cDt;
    private TextView cDv;
    private BaseFragmentActivity cSp;
    private TextView cbg;
    private TextView cvV;
    private TextView dAY;
    private TextView dGA;
    private LinearLayout dGB;
    private UserIconBox dGC;
    private LinearLayout dGD;
    private LinearLayout dGE;
    private LinearLayout dGF;
    private ImageView dGG;
    private TextView dGH;
    private ImageView dGI;
    private LinearLayout dGJ;
    private ImageView dGK;
    private LinearLayout dGL;
    private ImageView dGM;
    private LinearLayout dGN;
    private TextView dGO;
    private TextView dGP;
    private ImageView dGQ;
    private BdExpandImageView dGt;
    private ImageView dGu;
    private RelativeLayout dGv;
    private UserIconBox dGw;
    private TextView dGx;
    private ImageView dGy;
    private TextView dGz;
    private f dxd;
    private View mRootView;
    private float btX = 360.0f;
    private int dGR = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> azI = new be(this);
    View.OnClickListener dGS = new bf(this);

    public bd(f fVar, boolean z) {
        this.dxd = fVar;
        this.cSp = fVar.getBaseFragmentActivity();
        this.bIW = z;
        this.mRootView = LayoutInflater.from(this.cSp.getPageContext().getPageActivity()).inflate(t.h.personinfo_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bxh = this.mRootView.findViewById(t.g.root);
        this.dGt = (BdExpandImageView) this.mRootView.findViewById(t.g.expand_image);
        this.dGu = (ImageView) this.mRootView.findViewById(t.g.refresh_image);
        this.dGv = (RelativeLayout) this.mRootView.findViewById(t.g.head);
        this.cDt = (HeadImageView) this.mRootView.findViewById(t.g.user_head);
        this.cDt.setContentDescription(this.dxd.getResources().getString(t.j.my_portrait));
        this.dGw = (UserIconBox) this.mRootView.findViewById(t.g.user_vip_icon);
        this.dGD = (LinearLayout) this.mRootView.findViewById(t.g.yinji_wrapper);
        this.dGE = (LinearLayout) this.mRootView.findViewById(t.g.sign_wrapper);
        this.dGE.setOnClickListener(this.dxd);
        this.dGD.setOnClickListener(this.dxd);
        this.dGw.setOnClickListener(this.dxd);
        this.dGt.setOnClickListener(this.dxd);
        this.cDv = (TextView) this.mRootView.findViewById(t.g.user_name);
        this.dGx = (TextView) this.mRootView.findViewById(t.g.user_signs);
        this.dGB = (LinearLayout) this.mRootView.findViewById(t.g.user_age_wrapper);
        this.dGy = (ImageView) this.mRootView.findViewById(t.g.user_sex);
        this.dGz = (TextView) this.mRootView.findViewById(t.g.user_bar_age);
        this.dGA = (TextView) this.mRootView.findViewById(t.g.user_bar_age_num);
        this.dGC = (UserIconBox) this.mRootView.findViewById(t.g.user_icon);
        this.dGC.setOnClickListener(this.dxd);
        this.dGH = (TextView) this.mRootView.findViewById(t.g.btn_attention);
        this.dGG = (ImageView) this.mRootView.findViewById(t.g.follow_icon);
        this.dGF = (LinearLayout) this.mRootView.findViewById(t.g.btn_attention_wrapper);
        this.dGF.setOnClickListener(this.dxd);
        this.dGL = (LinearLayout) this.mRootView.findViewById(t.g.my_gift_ll);
        this.dGL.setOnClickListener(this.dxd);
        this.dGM = (ImageView) this.mRootView.findViewById(t.g.my_gift);
        this.dAY = (TextView) this.mRootView.findViewById(t.g.my_tdou_value);
        this.dGN = (LinearLayout) this.mRootView.findViewById(t.g.personinfo_tdou_wrapper);
        this.dGO = (TextView) this.mRootView.findViewById(t.g.my_tdou_get);
        this.dGP = (TextView) this.mRootView.findViewById(t.g.tdou_divider);
        this.dGQ = (ImageView) this.mRootView.findViewById(t.g.my_tdou_arrow);
        aCN();
        aCO();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CI().ey(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.cSp.getApplicationContext(), t.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.cSp.getApplicationContext(), t.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.dGt.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.dF().a(bg_pic, 10, this.azI, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aCM() {
        if (this.cDt != null) {
            this.cDt.CF();
        }
        this.dGt.setImageBitmap(null);
    }

    private void aCN() {
        if (TbadkCoreApplication.m11getInst().isGiftSwitchOn()) {
            this.dGL.setVisibility(0);
        } else {
            this.dGL.setVisibility(8);
        }
        if (TbadkCoreApplication.m11getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.dGL.setVisibility(8);
        }
        if (this.bIW) {
            this.dGL.setVisibility(8);
            this.dGF.setVisibility(8);
            return;
        }
        this.dGN.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void kU() {
        com.baidu.tbadk.core.util.at.l(this.bxh, t.d.cp_bg_line_c);
        UserData userData = this.dxd.aDe().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.cDv.setTextColor(this.cSp.getResources().getColor(t.d.cp_other_b));
            } else {
                this.cDv.setTextColor(this.cSp.getResources().getColor(t.d.cp_cont_g));
            }
        } else {
            this.cDv.setTextColor(this.cSp.getResources().getColor(t.d.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.at.c(this.dGx, t.d.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(this.dGx, t.d.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.at.c(this.dGx, t.d.cp_cont_d, 1);
        }
        this.dGz.setTextColor(this.cSp.getResources().getColor(t.d.cp_cont_g));
        this.dGA.setTextColor(this.cSp.getResources().getColor(t.d.cp_cont_g));
        com.baidu.tbadk.core.util.at.k(this.dGL, t.f.personinfo_head_icon);
        com.baidu.tbadk.core.util.at.c(this.dGM, t.f.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.at.k(this.dGF, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.at.c(this.dGH, t.d.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.k(this.dGF, t.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.at.k(this.dGG, t.f.icon_person_add_n);
                com.baidu.tbadk.core.util.at.c(this.dGH, t.d.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.at.k(this.dGF, t.f.personinfo_follow_btn);
            com.baidu.tbadk.core.util.at.k(this.dGG, t.f.icon_person_add_n);
            com.baidu.tbadk.core.util.at.c(this.dGH, t.d.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.at.c(this.cvV, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.c(this.cbg, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.k(this.dGI, t.f.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.at.k(this.dGK, t.f.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.at.k(this.dGD, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.k(this.dGE, t.d.cp_bg_line_d);
        this.dAY.setCompoundDrawablesWithIntrinsicBounds(this.cSp.getResources().getDrawable(t.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void aCO() {
        this.cDt.setIsRound(true);
        this.cDt.setDrawBorder(false);
        this.cDt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cDt.setOnClickListener(this.dxd);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.cDt;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return this.dGC;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
        if (this.dGM != null) {
            if (z) {
                com.baidu.tbadk.core.util.at.c(this.dGM, t.f.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.at.c(this.dGM, t.f.icon_mycenter_gift);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public void j(float f) {
        if (!this.dGu.isShown()) {
            this.dGu.setVisibility(0);
            this.dGu.setImageDrawable(this.cSp.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.btX, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.dGu.startAnimation(rotateAnimation);
        this.btX = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Pn() {
        this.dGu.clearAnimation();
        this.dGu.setImageDrawable(null);
        this.dGu.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void jk() {
        if (!this.dGu.isShown()) {
            this.dGu.setVisibility(0);
            this.dGu.setImageDrawable(this.cSp.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.dGu.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cSp.getPageContext().getPageActivity(), t.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aCa() {
        bg aDe = this.dxd.aDe();
        UserData userData = aDe.getUserData();
        setBackBitmap(userData);
        i(userData);
        h(userData);
        aDe.aDD();
    }

    public void h(UserData userData) {
        if (!aCP()) {
            this.dGN.setVisibility(8);
            return;
        }
        if (this.bIW) {
            this.dGN.setVisibility(0);
        } else {
            this.dGN.setVisibility(8);
        }
        if (userData != null) {
            long tDouNum = userData.getTDouNum();
            this.dAY.setText(com.baidu.tbadk.core.util.ay.J(tDouNum));
            this.dAY.setContentDescription(String.valueOf(this.cSp.getResources().getString(t.j.self_tdou)) + com.baidu.tbadk.core.util.ay.J(tDouNum));
            this.dAY.setOnClickListener(this.dGS);
            this.dGO.setOnClickListener(this.dGS);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dk = com.baidu.tbadk.core.util.q.dk(portrait);
                this.cDt.setUrl(dk);
                this.cDt.c(dk, 25, false);
            } else {
                this.cDt.setImageResource(t.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.dGw.setTag(tShowInfo.get(0).getUrl());
                this.dGw.setVisibility(0);
                this.dGw.a(tShowInfo, tShowInfo.size(), this.cSp.getResources().getDimensionPixelSize(t.e.ds34), this.cSp.getResources().getDimensionPixelSize(t.e.ds34), this.cSp.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.dGw.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.cDv.setText(name_show);
                this.cDv.setContentDescription(name_show);
                this.cDv.setClickable(true);
                if (isMem > 0) {
                    this.cDv.setTextColor(this.cSp.getResources().getColor(t.d.cp_other_b));
                } else {
                    this.cDv.setTextColor(this.cSp.getResources().getColor(t.d.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.dGx.setText(intro);
                com.baidu.tbadk.core.util.at.c(this.dGx, t.d.cp_cont_f, 1);
            } else {
                this.dGx.setText(t.j.no_person_sign);
                com.baidu.tbadk.core.util.at.c(this.dGx, t.d.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.dGy.setImageResource(t.f.icon_pop_boy);
            } else if (sex == 2) {
                this.dGy.setImageResource(t.f.icon_pop_girl);
            } else {
                this.dGy.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                String string = this.cSp.getResources().getString(t.j.user_info_center_head_viewpager_forum_age_text);
                String str = String.valueOf(tb_age) + this.cSp.getResources().getString(t.j.user_info_center_head_viewpager_tb_age);
                this.dGA.setText(str);
                this.dGB.setClickable(true);
                this.dGB.setContentDescription(String.valueOf(string) + str);
            }
            this.dGC.a(userData.getIconInfo(), 9, this.cSp.getResources().getDimensionPixelSize(t.e.ds34), this.cSp.getResources().getDimensionPixelSize(t.e.ds34), this.cSp.getResources().getDimensionPixelSize(t.e.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.dGH.setText(t.j.attention_cancel);
                this.dGG.setVisibility(8);
                com.baidu.tbadk.core.util.at.k(this.dGF, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.at.c(this.dGH, t.d.cp_link_tip_c, 1);
            } else {
                this.dGH.setText(t.j.attention);
                this.dGG.setVisibility(0);
                com.baidu.tbadk.core.util.at.k(this.dGF, t.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.at.k(this.dGG, t.f.icon_person_add_n);
                com.baidu.tbadk.core.util.at.c(this.dGH, t.d.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.dGF.setVisibility(8);
            this.dGJ.setVisibility(8);
            this.dGL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return this.dGL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.personInfo.a
    /* renamed from: aDA */
    public LinearLayout getAttentionView() {
        return this.dGF;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.dGw;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return this.dGD;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aCP() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.dGt;
    }
}
