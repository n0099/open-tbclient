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
public class bc extends a {
    private View bDS;
    private boolean bDs;
    private TextView bQi;
    private BaseFragmentActivity cZG;
    private f cZH;
    private TextView cks;
    private HeadImageView crT;
    private TextView crV;
    private TextView ddr;
    private BdExpandImageView diK;
    private ImageView diL;
    private RelativeLayout diM;
    private UserIconBox diN;
    private TextView diO;
    private ImageView diP;
    private TextView diQ;
    private TextView diR;
    private UserIconBox diS;
    private LinearLayout diT;
    private LinearLayout diU;
    private LinearLayout diV;
    private ImageView diW;
    private TextView diX;
    private ImageView diY;
    private LinearLayout diZ;
    private ImageView dja;
    private LinearLayout djb;
    private ImageView djc;
    private LinearLayout djd;
    private TextView dje;
    private TextView djf;
    private ImageView djg;
    private View mRootView;
    private float ddb = 360.0f;
    private int djh = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aCG = new bd(this);

    public bc(f fVar, boolean z) {
        this.cZH = fVar;
        this.cZG = fVar.getBaseFragmentActivity();
        this.bDs = z;
        this.mRootView = LayoutInflater.from(this.cZG.getPageContext().getPageActivity()).inflate(t.h.personinfo_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bDS = this.mRootView.findViewById(t.g.root);
        this.diK = (BdExpandImageView) this.mRootView.findViewById(t.g.expand_image);
        this.diL = (ImageView) this.mRootView.findViewById(t.g.refresh_image);
        this.diM = (RelativeLayout) this.mRootView.findViewById(t.g.head);
        this.crT = (HeadImageView) this.mRootView.findViewById(t.g.user_head);
        this.diN = (UserIconBox) this.mRootView.findViewById(t.g.user_vip_icon);
        this.diT = (LinearLayout) this.mRootView.findViewById(t.g.yinji_wrapper);
        this.diU = (LinearLayout) this.mRootView.findViewById(t.g.sign_wrapper);
        this.diN.setOnClickListener(this.cZH);
        this.crV = (TextView) this.mRootView.findViewById(t.g.user_name);
        this.diO = (TextView) this.mRootView.findViewById(t.g.user_signs);
        this.diP = (ImageView) this.mRootView.findViewById(t.g.user_sex);
        this.diQ = (TextView) this.mRootView.findViewById(t.g.user_bar_age);
        this.diR = (TextView) this.mRootView.findViewById(t.g.user_bar_age_num);
        this.diS = (UserIconBox) this.mRootView.findViewById(t.g.user_icon);
        this.diS.setOnClickListener(this.cZH);
        this.diX = (TextView) this.mRootView.findViewById(t.g.btn_attention);
        this.diW = (ImageView) this.mRootView.findViewById(t.g.follow_icon);
        this.diV = (LinearLayout) this.mRootView.findViewById(t.g.btn_attention_wrapper);
        this.diV.setOnClickListener(this.cZH);
        this.djb = (LinearLayout) this.mRootView.findViewById(t.g.my_gift_ll);
        this.djb.setOnClickListener(this.cZH);
        this.djc = (ImageView) this.mRootView.findViewById(t.g.my_gift);
        this.ddr = (TextView) this.mRootView.findViewById(t.g.my_tdou_value);
        this.djd = (LinearLayout) this.mRootView.findViewById(t.g.personinfo_tdou_wrapper);
        this.dje = (TextView) this.mRootView.findViewById(t.g.my_tdou_get);
        this.djf = (TextView) this.mRootView.findViewById(t.g.tdou_divider);
        this.djg = (ImageView) this.mRootView.findViewById(t.g.my_tdou_arrow);
        auM();
        auN();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ed().eN(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.cZG.getApplicationContext(), t.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.cZG.getApplicationContext(), t.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.diK.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.hl().a(bg_pic, 10, this.aCG, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void auL() {
        if (this.crT != null) {
            this.crT.Ea();
        }
        this.diK.setImageBitmap(null);
    }

    private void auM() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.djb.setVisibility(0);
        } else {
            this.djb.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.djb.setVisibility(8);
        }
        if (this.bDs) {
            this.djb.setVisibility(8);
            this.diV.setVisibility(8);
            return;
        }
        this.djd.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void oO() {
        com.baidu.tbadk.core.util.ar.l(this.bDS, t.d.cp_bg_line_c);
        UserData userData = this.cZH.avb().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.crV.setTextColor(this.cZG.getResources().getColor(t.d.cp_other_b));
            } else {
                this.crV.setTextColor(this.cZG.getResources().getColor(t.d.cp_cont_g));
            }
        } else {
            this.crV.setTextColor(this.cZG.getResources().getColor(t.d.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.ar.b(this.diO, t.d.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(this.diO, t.d.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.ar.b(this.diO, t.d.cp_cont_d, 1);
        }
        this.diQ.setTextColor(this.cZG.getResources().getColor(t.d.cp_cont_g));
        this.diR.setTextColor(this.cZG.getResources().getColor(t.d.cp_cont_g));
        com.baidu.tbadk.core.util.ar.k(this.djb, t.f.personinfo_head_icon);
        com.baidu.tbadk.core.util.ar.c(this.djc, t.f.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.ar.k(this.diV, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.ar.b(this.diX, t.d.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.k(this.diV, t.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.ar.k(this.diW, t.f.icon_person_add_n);
                com.baidu.tbadk.core.util.ar.b(this.diX, t.d.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.ar.k(this.diV, t.f.personinfo_follow_btn);
            com.baidu.tbadk.core.util.ar.k(this.diW, t.f.icon_person_add_n);
            com.baidu.tbadk.core.util.ar.b(this.diX, t.d.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.ar.b(this.cks, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.ar.b(this.bQi, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.ar.k(this.diY, t.f.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.ar.k(this.dja, t.f.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.ar.k(this.diT, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.k(this.diU, t.d.cp_bg_line_d);
        this.ddr.setCompoundDrawablesWithIntrinsicBounds(this.cZG.getResources().getDrawable(t.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void auN() {
        this.crT.setIsRound(true);
        this.crT.setDrawBorder(false);
        this.crT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.crT.setOnClickListener(this.cZH);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.crT;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return this.diS;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
        if (this.djc != null) {
            if (z) {
                com.baidu.tbadk.core.util.ar.c(this.djc, t.f.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.ar.c(this.djc, t.f.icon_mycenter_gift);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public void l(float f) {
        if (!this.diL.isShown()) {
            this.diL.setVisibility(0);
            this.diL.setImageDrawable(this.cZG.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ddb, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.diL.startAnimation(rotateAnimation);
        this.ddb = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Oz() {
        this.diL.clearAnimation();
        this.diL.setImageDrawable(null);
        this.diL.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void nf() {
        if (!this.diL.isShown()) {
            this.diL.setVisibility(0);
            this.diL.setImageDrawable(this.cZG.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.diL.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cZG.getPageContext().getPageActivity(), t.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void akY() {
        bf avb = this.cZH.avb();
        UserData userData = avb.getUserData();
        setBackBitmap(userData);
        i(userData);
        h(userData);
        avb.avA();
    }

    public void h(UserData userData) {
        if (!auO()) {
            this.djd.setVisibility(8);
            return;
        }
        if (this.bDs) {
            this.djd.setVisibility(0);
        } else {
            this.djd.setVisibility(8);
        }
        if (userData != null) {
            this.ddr.setText(com.baidu.tbadk.core.util.aw.G(userData.getTDouNum()));
            this.djd.setOnClickListener(new be(this));
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dj = com.baidu.tbadk.core.util.q.dj(portrait);
                this.crT.setUrl(dj);
                this.crT.d(dj, 25, false);
            } else {
                this.crT.setImageResource(t.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.diN.setVisibility(0);
                this.diN.a(tShowInfo, tShowInfo.size(), this.cZG.getResources().getDimensionPixelSize(t.e.ds34), this.cZG.getResources().getDimensionPixelSize(t.e.ds34), this.cZG.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.diN.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.crV.setText(name_show);
                if (isMem > 0) {
                    this.crV.setTextColor(this.cZG.getResources().getColor(t.d.cp_other_b));
                } else {
                    this.crV.setTextColor(this.cZG.getResources().getColor(t.d.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.diO.setText(intro);
                com.baidu.tbadk.core.util.ar.b(this.diO, t.d.cp_cont_f, 1);
            } else {
                this.diO.setText(t.j.no_person_sign);
                com.baidu.tbadk.core.util.ar.b(this.diO, t.d.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.diP.setImageResource(t.f.icon_pop_boy);
            } else if (sex == 2) {
                this.diP.setImageResource(t.f.icon_pop_girl);
            } else {
                this.diP.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.diR.setText(String.valueOf(tb_age) + this.cZG.getResources().getString(t.j.user_info_center_head_viewpager_tb_age));
            }
            this.diS.a(userData.getIconInfo(), 9, this.cZG.getResources().getDimensionPixelSize(t.e.ds34), this.cZG.getResources().getDimensionPixelSize(t.e.ds34), this.cZG.getResources().getDimensionPixelSize(t.e.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.diX.setText(t.j.attention_cancel);
                this.diW.setVisibility(8);
                com.baidu.tbadk.core.util.ar.k(this.diV, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.ar.b(this.diX, t.d.cp_link_tip_c, 1);
            } else {
                this.diX.setText(t.j.attention);
                this.diW.setVisibility(0);
                com.baidu.tbadk.core.util.ar.k(this.diV, t.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.ar.k(this.diW, t.f.icon_person_add_n);
                com.baidu.tbadk.core.util.ar.b(this.diX, t.d.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.diV.setVisibility(8);
            this.diZ.setVisibility(8);
            this.djb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return this.djb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.personInfo.a
    /* renamed from: avx */
    public LinearLayout getAttentionView() {
        return this.diV;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.diN;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return this.diT;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean auO() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }
}
