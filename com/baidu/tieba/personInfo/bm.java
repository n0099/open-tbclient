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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bm extends a {
    private View bUM;
    private BaseFragmentActivity bfw;
    private TextView bmZ;
    private ImageView bna;
    private TextView cGC;
    private boolean cgJ;
    private TextView dbl;
    private HeadImageView diR;
    private TextView diT;
    private f efz;
    private TextView ejD;
    private ImageView epA;
    private RelativeLayout epB;
    private UserIconBox epC;
    private TextView epD;
    private ImageView epE;
    private TextView epF;
    private TextView epG;
    private LinearLayout epH;
    private UserIconBox epI;
    private LinearLayout epJ;
    private LinearLayout epK;
    private LinearLayout epL;
    private ImageView epM;
    private LinearLayout epN;
    private ImageView epO;
    private LinearLayout epP;
    private ImageView epQ;
    private LinearLayout epR;
    private TextView epS;
    private TextView epT;
    private ImageView epU;
    private BdExpandImageView epz;
    private View mRootView;
    private float bRH = 360.0f;
    private int epV = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAA = new bn(this);
    View.OnClickListener epW = new bo(this);

    public bm(f fVar, boolean z) {
        this.efz = fVar;
        this.bfw = fVar.getBaseFragmentActivity();
        this.cgJ = z;
        this.mRootView = LayoutInflater.from(this.bfw.getPageContext().getPageActivity()).inflate(u.h.personinfo_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bUM = this.mRootView.findViewById(u.g.root);
        this.epz = (BdExpandImageView) this.mRootView.findViewById(u.g.expand_image);
        this.epA = (ImageView) this.mRootView.findViewById(u.g.refresh_image);
        this.epB = (RelativeLayout) this.mRootView.findViewById(u.g.head);
        this.diR = (HeadImageView) this.mRootView.findViewById(u.g.user_head);
        this.diR.setContentDescription(this.efz.getResources().getString(u.j.my_portrait));
        this.epC = (UserIconBox) this.mRootView.findViewById(u.g.user_vip_icon);
        this.epJ = (LinearLayout) this.mRootView.findViewById(u.g.yinji_wrapper);
        this.epK = (LinearLayout) this.mRootView.findViewById(u.g.sign_wrapper);
        this.epK.setOnClickListener(this.efz);
        this.epJ.setOnClickListener(this.efz);
        this.epC.setOnClickListener(this.efz);
        this.epz.setOnClickListener(this.efz);
        this.diT = (TextView) this.mRootView.findViewById(u.g.user_name);
        this.epD = (TextView) this.mRootView.findViewById(u.g.user_signs);
        this.epH = (LinearLayout) this.mRootView.findViewById(u.g.user_age_wrapper);
        this.epE = (ImageView) this.mRootView.findViewById(u.g.user_sex);
        this.epF = (TextView) this.mRootView.findViewById(u.g.user_bar_age);
        this.epG = (TextView) this.mRootView.findViewById(u.g.user_bar_age_num);
        this.epI = (UserIconBox) this.mRootView.findViewById(u.g.user_icon);
        this.epI.setOnClickListener(this.efz);
        this.bmZ = (TextView) this.mRootView.findViewById(u.g.btn_attention);
        this.bna = (ImageView) this.mRootView.findViewById(u.g.follow_icon);
        this.epL = (LinearLayout) this.mRootView.findViewById(u.g.btn_attention_wrapper);
        this.epL.setOnClickListener(this.efz);
        this.epP = (LinearLayout) this.mRootView.findViewById(u.g.my_gift_ll);
        this.epP.setOnClickListener(this.efz);
        this.epQ = (ImageView) this.mRootView.findViewById(u.g.my_gift);
        this.ejD = (TextView) this.mRootView.findViewById(u.g.my_tdou_value);
        this.epR = (LinearLayout) this.mRootView.findViewById(u.g.personinfo_tdou_wrapper);
        this.epS = (TextView) this.mRootView.findViewById(u.g.my_tdou_get);
        this.epT = (TextView) this.mRootView.findViewById(u.g.tdou_divider);
        this.epU = (ImageView) this.mRootView.findViewById(u.g.my_tdou_arrow);
        aLH();
        aLI();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CQ().eD(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.bfw.getApplicationContext(), u.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.bfw.getApplicationContext(), u.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.epz.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.dG().a(bg_pic, 10, this.aAA, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aLG() {
        if (this.diR != null) {
            this.diR.CN();
        }
        this.epz.setImageBitmap(null);
    }

    private void aLH() {
        if (TbadkCoreApplication.m9getInst().isGiftSwitchOn()) {
            this.epP.setVisibility(0);
        } else {
            this.epP.setVisibility(8);
        }
        if (TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.epP.setVisibility(8);
        }
        if (this.cgJ) {
            this.epP.setVisibility(8);
            this.epL.setVisibility(8);
            return;
        }
        this.epR.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void kX() {
        com.baidu.tbadk.core.util.av.l(this.bUM, u.d.cp_bg_line_c);
        UserData userData = this.efz.aLZ().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.diT.setTextColor(this.bfw.getResources().getColor(u.d.cp_other_b));
            } else {
                this.diT.setTextColor(this.bfw.getResources().getColor(u.d.cp_cont_g));
            }
        } else {
            this.diT.setTextColor(this.bfw.getResources().getColor(u.d.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.av.c(this.epD, u.d.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.av.c(this.epD, u.d.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.av.c(this.epD, u.d.cp_cont_d, 1);
        }
        this.epF.setTextColor(this.bfw.getResources().getColor(u.d.cp_cont_g));
        this.epG.setTextColor(this.bfw.getResources().getColor(u.d.cp_cont_g));
        com.baidu.tbadk.core.util.av.k(this.epP, u.f.personinfo_head_icon);
        com.baidu.tbadk.core.util.av.c(this.epQ, u.f.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.av.k(this.epL, u.f.btn_pop_news);
                com.baidu.tbadk.core.util.av.c(this.bmZ, u.d.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.av.k(this.epL, u.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.av.k(this.bna, u.f.icon_person_add_n);
                com.baidu.tbadk.core.util.av.c(this.bmZ, u.d.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.av.k(this.epL, u.f.personinfo_follow_btn);
            com.baidu.tbadk.core.util.av.k(this.bna, u.f.icon_person_add_n);
            com.baidu.tbadk.core.util.av.c(this.bmZ, u.d.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.av.c(this.dbl, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.c(this.cGC, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.k(this.epM, u.f.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.av.k(this.epO, u.f.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.av.k(this.epJ, u.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.k(this.epK, u.d.cp_bg_line_d);
        this.ejD.setCompoundDrawablesWithIntrinsicBounds(this.bfw.getResources().getDrawable(u.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void aLI() {
        this.diR.setIsRound(true);
        this.diR.setDrawBorder(false);
        this.diR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.diR.setOnClickListener(this.efz);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.diR;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return this.epI;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
        if (this.epQ != null) {
            if (z) {
                com.baidu.tbadk.core.util.av.c(this.epQ, u.f.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.av.c(this.epQ, u.f.icon_mycenter_gift);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public void j(float f) {
        if (!this.epA.isShown()) {
            this.epA.setVisibility(0);
            this.epA.setImageDrawable(this.bfw.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bRH, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.epA.startAnimation(rotateAnimation);
        this.bRH = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void US() {
        this.epA.clearAnimation();
        this.epA.setImageDrawable(null);
        this.epA.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void jn() {
        if (!this.epA.isShown()) {
            this.epA.setVisibility(0);
            this.epA.setImageDrawable(this.bfw.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        this.epA.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bfw.getPageContext().getPageActivity(), u.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Ri() {
        bp aLZ = this.efz.aLZ();
        UserData userData = aLZ.getUserData();
        setBackBitmap(userData);
        i(userData);
        h(userData);
        aLZ.aMy();
    }

    public void h(UserData userData) {
        if (!aLJ()) {
            this.epR.setVisibility(8);
            return;
        }
        if (this.cgJ) {
            this.epR.setVisibility(0);
        } else {
            this.epR.setVisibility(8);
        }
        if (userData != null) {
            long tDouNum = userData.getTDouNum();
            this.ejD.setText(com.baidu.tbadk.core.util.ba.M(tDouNum));
            this.ejD.setContentDescription(String.valueOf(this.bfw.getResources().getString(u.j.self_tdou)) + com.baidu.tbadk.core.util.ba.M(tDouNum));
            this.ejD.setOnClickListener(this.epW);
            this.epS.setOnClickListener(this.epW);
            this.epR.setOnClickListener(this.epW);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String di = com.baidu.tbadk.core.util.q.di(portrait);
                this.diR.setUrl(di);
                this.diR.c(di, 25, false);
            } else {
                this.diR.setImageResource(u.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.epC.setTag(tShowInfo.get(0).getUrl());
                this.epC.setVisibility(0);
                this.epC.a(tShowInfo, tShowInfo.size(), this.bfw.getResources().getDimensionPixelSize(u.e.ds34), this.bfw.getResources().getDimensionPixelSize(u.e.ds34), this.bfw.getResources().getDimensionPixelSize(u.e.ds10), true);
            } else {
                this.epC.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.diT.setText(name_show);
                this.diT.setContentDescription(name_show);
                this.diT.setClickable(true);
                if (isMem > 0) {
                    this.diT.setTextColor(this.bfw.getResources().getColor(u.d.cp_other_b));
                } else {
                    this.diT.setTextColor(this.bfw.getResources().getColor(u.d.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.epD.setText(intro);
                com.baidu.tbadk.core.util.av.c(this.epD, u.d.cp_cont_f, 1);
            } else {
                this.epD.setText(u.j.no_person_sign);
                com.baidu.tbadk.core.util.av.c(this.epD, u.d.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.epE.setImageResource(u.f.icon_pop_boy);
            } else if (sex == 2) {
                this.epE.setImageResource(u.f.icon_pop_girl);
            } else {
                this.epE.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                String string = this.bfw.getResources().getString(u.j.user_info_center_head_viewpager_forum_age_text);
                String str = String.valueOf(tb_age) + this.bfw.getResources().getString(u.j.user_info_center_head_viewpager_tb_age);
                this.epG.setText(str);
                this.epH.setClickable(true);
                this.epH.setContentDescription(String.valueOf(string) + str);
            }
            this.epI.a(userData.getIconInfo(), 9, this.bfw.getResources().getDimensionPixelSize(u.e.ds34), this.bfw.getResources().getDimensionPixelSize(u.e.ds34), this.bfw.getResources().getDimensionPixelSize(u.e.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.bmZ.setText(u.j.attention_cancel);
                this.bna.setVisibility(8);
                com.baidu.tbadk.core.util.av.k(this.epL, u.f.btn_pop_news);
                com.baidu.tbadk.core.util.av.c(this.bmZ, u.d.cp_link_tip_c, 1);
            } else {
                this.bmZ.setText(u.j.attention);
                this.bna.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(this.epL, u.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.av.k(this.bna, u.f.icon_person_add_n);
                com.baidu.tbadk.core.util.av.c(this.bmZ, u.d.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.epL.setVisibility(8);
            this.epN.setVisibility(8);
            this.epP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return this.epP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.personInfo.a
    /* renamed from: aMv */
    public LinearLayout getAttentionView() {
        return this.epL;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.epC;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return this.epJ;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aLJ() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.epz;
    }
}
