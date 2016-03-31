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
    private boolean bIP;
    private View bJp;
    private HeadImageView cCt;
    private TextView cCv;
    private TextView caB;
    private TextView cuY;
    private ImageView dDA;
    private LinearLayout dDB;
    private ImageView dDC;
    private LinearLayout dDD;
    private TextView dDE;
    private TextView dDF;
    private ImageView dDG;
    private BdExpandImageView dDk;
    private ImageView dDl;
    private RelativeLayout dDm;
    private UserIconBox dDn;
    private TextView dDo;
    private ImageView dDp;
    private TextView dDq;
    private TextView dDr;
    private UserIconBox dDs;
    private LinearLayout dDt;
    private LinearLayout dDu;
    private LinearLayout dDv;
    private ImageView dDw;
    private TextView dDx;
    private ImageView dDy;
    private LinearLayout dDz;
    private BaseFragmentActivity duj;
    private f duk;
    private TextView dxT;
    private View mRootView;
    private float dxD = 360.0f;
    private int dDH = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDE = new bd(this);

    public bc(f fVar, boolean z) {
        this.duk = fVar;
        this.duj = fVar.getBaseFragmentActivity();
        this.bIP = z;
        this.mRootView = LayoutInflater.from(this.duj.getPageContext().getPageActivity()).inflate(t.h.personinfo_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bJp = this.mRootView.findViewById(t.g.root);
        this.dDk = (BdExpandImageView) this.mRootView.findViewById(t.g.expand_image);
        this.dDl = (ImageView) this.mRootView.findViewById(t.g.refresh_image);
        this.dDm = (RelativeLayout) this.mRootView.findViewById(t.g.head);
        this.cCt = (HeadImageView) this.mRootView.findViewById(t.g.user_head);
        this.cCt.setContentDescription(this.duk.getResources().getString(t.j.my_portrait));
        this.dDn = (UserIconBox) this.mRootView.findViewById(t.g.user_vip_icon);
        this.dDt = (LinearLayout) this.mRootView.findViewById(t.g.yinji_wrapper);
        this.dDu = (LinearLayout) this.mRootView.findViewById(t.g.sign_wrapper);
        this.dDu.setOnClickListener(this.duk);
        this.dDt.setOnClickListener(this.duk);
        this.dDn.setOnClickListener(this.duk);
        this.dDk.setOnClickListener(this.duk);
        this.cCv = (TextView) this.mRootView.findViewById(t.g.user_name);
        this.dDo = (TextView) this.mRootView.findViewById(t.g.user_signs);
        this.dDp = (ImageView) this.mRootView.findViewById(t.g.user_sex);
        this.dDq = (TextView) this.mRootView.findViewById(t.g.user_bar_age);
        this.dDr = (TextView) this.mRootView.findViewById(t.g.user_bar_age_num);
        this.dDs = (UserIconBox) this.mRootView.findViewById(t.g.user_icon);
        this.dDs.setOnClickListener(this.duk);
        this.dDx = (TextView) this.mRootView.findViewById(t.g.btn_attention);
        this.dDw = (ImageView) this.mRootView.findViewById(t.g.follow_icon);
        this.dDv = (LinearLayout) this.mRootView.findViewById(t.g.btn_attention_wrapper);
        this.dDv.setOnClickListener(this.duk);
        this.dDB = (LinearLayout) this.mRootView.findViewById(t.g.my_gift_ll);
        this.dDB.setOnClickListener(this.duk);
        this.dDC = (ImageView) this.mRootView.findViewById(t.g.my_gift);
        this.dxT = (TextView) this.mRootView.findViewById(t.g.my_tdou_value);
        this.dDD = (LinearLayout) this.mRootView.findViewById(t.g.personinfo_tdou_wrapper);
        this.dDE = (TextView) this.mRootView.findViewById(t.g.my_tdou_get);
        this.dDF = (TextView) this.mRootView.findViewById(t.g.tdou_divider);
        this.dDG = (ImageView) this.mRootView.findViewById(t.g.my_tdou_arrow);
        aCs();
        aCt();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.EO().eT(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.duj.getApplicationContext(), t.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.duj.getApplicationContext(), t.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.dDk.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.hr().a(bg_pic, 10, this.aDE, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aCr() {
        if (this.cCt != null) {
            this.cCt.EL();
        }
        this.dDk.setImageBitmap(null);
    }

    private void aCs() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.dDB.setVisibility(0);
        } else {
            this.dDB.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.dDB.setVisibility(8);
        }
        if (this.bIP) {
            this.dDB.setVisibility(8);
            this.dDv.setVisibility(8);
            return;
        }
        this.dDD.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void oH() {
        com.baidu.tbadk.core.util.at.l(this.bJp, t.d.cp_bg_line_c);
        UserData userData = this.duk.aCH().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.cCv.setTextColor(this.duj.getResources().getColor(t.d.cp_other_b));
            } else {
                this.cCv.setTextColor(this.duj.getResources().getColor(t.d.cp_cont_g));
            }
        } else {
            this.cCv.setTextColor(this.duj.getResources().getColor(t.d.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.at.b(this.dDo, t.d.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(this.dDo, t.d.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.at.b(this.dDo, t.d.cp_cont_d, 1);
        }
        this.dDq.setTextColor(this.duj.getResources().getColor(t.d.cp_cont_g));
        this.dDr.setTextColor(this.duj.getResources().getColor(t.d.cp_cont_g));
        com.baidu.tbadk.core.util.at.k(this.dDB, t.f.personinfo_head_icon);
        com.baidu.tbadk.core.util.at.c(this.dDC, t.f.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.at.k(this.dDv, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.at.b(this.dDx, t.d.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.k(this.dDv, t.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.at.k(this.dDw, t.f.icon_person_add_n);
                com.baidu.tbadk.core.util.at.b(this.dDx, t.d.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.at.k(this.dDv, t.f.personinfo_follow_btn);
            com.baidu.tbadk.core.util.at.k(this.dDw, t.f.icon_person_add_n);
            com.baidu.tbadk.core.util.at.b(this.dDx, t.d.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.at.b(this.cuY, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.b(this.caB, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.k(this.dDy, t.f.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.at.k(this.dDA, t.f.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.at.k(this.dDt, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.k(this.dDu, t.d.cp_bg_line_d);
        this.dxT.setCompoundDrawablesWithIntrinsicBounds(this.duj.getResources().getDrawable(t.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void aCt() {
        this.cCt.setIsRound(true);
        this.cCt.setDrawBorder(false);
        this.cCt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cCt.setOnClickListener(this.duk);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.cCt;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return this.dDs;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
        if (this.dDC != null) {
            if (z) {
                com.baidu.tbadk.core.util.at.c(this.dDC, t.f.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.at.c(this.dDC, t.f.icon_mycenter_gift);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public void l(float f) {
        if (!this.dDl.isShown()) {
            this.dDl.setVisibility(0);
            this.dDl.setImageDrawable(this.duj.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dxD, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.dDl.startAnimation(rotateAnimation);
        this.dxD = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Qo() {
        this.dDl.clearAnimation();
        this.dDl.setImageDrawable(null);
        this.dDl.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void mW() {
        if (!this.dDl.isShown()) {
            this.dDl.setVisibility(0);
            this.dDl.setImageDrawable(this.duj.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.dDl.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.duj.getPageContext().getPageActivity(), t.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void arP() {
        bf aCH = this.duk.aCH();
        UserData userData = aCH.getUserData();
        setBackBitmap(userData);
        i(userData);
        h(userData);
        aCH.aDf();
    }

    public void h(UserData userData) {
        if (!aCu()) {
            this.dDD.setVisibility(8);
            return;
        }
        if (this.bIP) {
            this.dDD.setVisibility(0);
        } else {
            this.dDD.setVisibility(8);
        }
        if (userData != null) {
            this.dxT.setText(com.baidu.tbadk.core.util.ay.I(userData.getTDouNum()));
            this.dDD.setOnClickListener(new be(this));
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dm = com.baidu.tbadk.core.util.q.dm(portrait);
                this.cCt.setUrl(dm);
                this.cCt.c(dm, 25, false);
            } else {
                this.cCt.setImageResource(t.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.dDn.setVisibility(0);
                this.dDn.a(tShowInfo, tShowInfo.size(), this.duj.getResources().getDimensionPixelSize(t.e.ds34), this.duj.getResources().getDimensionPixelSize(t.e.ds34), this.duj.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.dDn.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.cCv.setText(name_show);
                if (isMem > 0) {
                    this.cCv.setTextColor(this.duj.getResources().getColor(t.d.cp_other_b));
                } else {
                    this.cCv.setTextColor(this.duj.getResources().getColor(t.d.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.dDo.setText(intro);
                com.baidu.tbadk.core.util.at.b(this.dDo, t.d.cp_cont_f, 1);
            } else {
                this.dDo.setText(t.j.no_person_sign);
                com.baidu.tbadk.core.util.at.b(this.dDo, t.d.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.dDp.setImageResource(t.f.icon_pop_boy);
            } else if (sex == 2) {
                this.dDp.setImageResource(t.f.icon_pop_girl);
            } else {
                this.dDp.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.dDr.setText(String.valueOf(tb_age) + this.duj.getResources().getString(t.j.user_info_center_head_viewpager_tb_age));
            }
            this.dDs.a(userData.getIconInfo(), 9, this.duj.getResources().getDimensionPixelSize(t.e.ds34), this.duj.getResources().getDimensionPixelSize(t.e.ds34), this.duj.getResources().getDimensionPixelSize(t.e.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.dDx.setText(t.j.attention_cancel);
                this.dDw.setVisibility(8);
                com.baidu.tbadk.core.util.at.k(this.dDv, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.at.b(this.dDx, t.d.cp_link_tip_c, 1);
            } else {
                this.dDx.setText(t.j.attention);
                this.dDw.setVisibility(0);
                com.baidu.tbadk.core.util.at.k(this.dDv, t.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.at.k(this.dDw, t.f.icon_person_add_n);
                com.baidu.tbadk.core.util.at.b(this.dDx, t.d.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.dDv.setVisibility(8);
            this.dDz.setVisibility(8);
            this.dDB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return this.dDB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.personInfo.a
    /* renamed from: aDc */
    public LinearLayout getAttentionView() {
        return this.dDv;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.dDn;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return this.dDt;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aCu() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.dDk;
    }
}
