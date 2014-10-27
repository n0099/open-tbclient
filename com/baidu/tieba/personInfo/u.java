package com.baidu.tieba.personInfo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private View HS;
    private View aFZ;
    private TextView aQH;
    private PersonInfoActivity bEE;
    private BdExpandImageView bFG;
    private ImageView bFH;
    private float bFI = 360.0f;
    private RelativeLayout bFJ;
    private HeadImageView bFK;
    private UserIconBox bFL;
    private ImageView bFM;
    private TextView bFN;
    private TextView bFO;
    private UserIconBox bFP;
    private TextView bFQ;
    private LinearLayout bFR;
    private ImageView bFS;
    private TextView bFT;
    private LinearLayout bFU;
    private ImageView bFV;
    private LinearLayout bFW;
    private ImageView bFX;
    private TextView bua;
    private Bitmap mBitmap;
    private boolean mIsHost;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.personinfo_head_view, null);
        this.HS.setLayoutParams(new AbsListView.LayoutParams(-1, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds372)));
        nu();
    }

    private void nu() {
        this.aFZ = this.HS.findViewById(com.baidu.tieba.v.root);
        this.bFG = (BdExpandImageView) this.HS.findViewById(com.baidu.tieba.v.expand_image);
        this.bFH = (ImageView) this.HS.findViewById(com.baidu.tieba.v.refresh_image);
        this.bFJ = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.head);
        this.bFK = (HeadImageView) this.HS.findViewById(com.baidu.tieba.v.user_head);
        this.bFL = (UserIconBox) this.HS.findViewById(com.baidu.tieba.v.user_vip_icon);
        this.bFL.setOnClickListener(this.bEE);
        this.bua = (TextView) this.HS.findViewById(com.baidu.tieba.v.user_name);
        this.bFM = (ImageView) this.HS.findViewById(com.baidu.tieba.v.user_sex);
        this.bFN = (TextView) this.HS.findViewById(com.baidu.tieba.v.user_bar_age);
        this.bFO = (TextView) this.HS.findViewById(com.baidu.tieba.v.user_bar_age_num);
        this.bFP = (UserIconBox) this.HS.findViewById(com.baidu.tieba.v.user_icon);
        this.bFP.setOnClickListener(this.bEE);
        this.bFQ = (TextView) this.HS.findViewById(com.baidu.tieba.v.btn_attention);
        this.bFQ.setOnClickListener(this.bEE);
        this.bFS = (ImageView) this.HS.findViewById(com.baidu.tieba.v.iv_site);
        this.bFR = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.dis_time);
        this.bFU = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.time_ll);
        this.bFV = (ImageView) this.HS.findViewById(com.baidu.tieba.v.iv_time);
        this.bFT = (TextView) this.HS.findViewById(com.baidu.tieba.v.distance);
        this.aQH = (TextView) this.HS.findViewById(com.baidu.tieba.v.time);
        this.bFW = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.my_gift_ll);
        this.bFW.setOnClickListener(this.bEE);
        this.bFX = (ImageView) this.HS.findViewById(com.baidu.tieba.v.my_gift);
        aaJ();
        aaK();
    }

    public void aaH() {
        this.mBitmap = aw.f((Resources) null, com.baidu.tieba.u.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bFG.setImageBitmap(this.mBitmap);
        }
    }

    public void aaI() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.d.bm(com.baidu.tieba.u.bg_mycenter_banner);
            System.gc();
        }
        this.bFG.setImageBitmap(null);
    }

    private void aaJ() {
        if (TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.bFW.setVisibility(0);
        } else {
            this.bFW.setVisibility(8);
        }
        if (this.mIsHost) {
            this.bFW.setVisibility(8);
            this.bFQ.setVisibility(8);
            this.bFR.setVisibility(8);
        }
    }

    public void pS() {
        aw.i(this.aFZ, com.baidu.tieba.s.cp_bg_line_c);
        aw.b(this.bua, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.bFN, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.bFO, com.baidu.tieba.s.cp_cont_g, 1);
        aw.h(this.bFW, com.baidu.tieba.u.personinfo_head_icon);
        aw.c(this.bFX, com.baidu.tieba.u.icon_mycenter_gift);
        aw.h(this.bFR, com.baidu.tieba.u.bg_mycenter_bar);
        aw.h((View) this.bFQ, com.baidu.tieba.u.bg_mycenter_bar);
        aw.b(this.bFQ, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.bFT, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.aQH, com.baidu.tieba.s.cp_cont_g, 1);
        aw.h(this.bFS, com.baidu.tieba.u.icon_mycenter_bar_site);
        aw.h(this.bFV, com.baidu.tieba.u.icon_mycenter_bar_date);
    }

    private void aaK() {
        this.bFK.setIsRound(true);
        this.bFK.setDrawBorder(false);
        this.bFK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bFK.setDefaultResource(com.baidu.tieba.u.pic_mycenter_avatar_def);
        this.bFK.setOnClickListener(this.bEE);
    }

    public HeadImageView aaL() {
        return this.bFK;
    }

    public UserIconBox aaM() {
        return this.bFP;
    }

    public void i(float f) {
        if (!this.bFH.isShown()) {
            this.bFH.setVisibility(0);
            this.bFH.setImageDrawable(this.bEE.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bFI, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bFH.startAnimation(rotateAnimation);
        this.bFI = f;
    }

    public void hideProgress() {
        this.bFH.clearAnimation();
        this.bFH.setImageDrawable(null);
        this.bFH.setVisibility(8);
    }

    public void hx() {
        if (!this.bFH.isShown()) {
            this.bFH.setVisibility(0);
            this.bFH.setImageDrawable(this.bEE.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        this.bFH.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bEE, com.baidu.tieba.p.user_info_center_head_rotate));
    }

    public void Hu() {
        v aap = this.bEE.aap();
        UserData userData = aap.getUserData();
        g(userData);
        d(aap.aaS(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.c personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int qR = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.qR();
            if (qR == 1 || (qR == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bFT.setText(distance);
                    this.aQH.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bFU.setVisibility(8);
            this.bFT.setText(com.baidu.tieba.y.lbs_private);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bFK.c(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bFL.setVisibility(0);
                this.bFL.a(tShowInfo, tShowInfo.size(), this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            } else {
                this.bFL.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tieba.game.a.g.fy(name_show) > 14 ? String.valueOf(com.baidu.tieba.game.a.g.g(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bua.setText(str);
                if (isMem != 0) {
                    aw.b(this.bua, com.baidu.tieba.s.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                aw.h(this.bFM, com.baidu.tieba.u.icon_pop_boy);
            } else if (sex == 2) {
                aw.h(this.bFM, com.baidu.tieba.u.icon_pop_girl);
            } else {
                this.bFM.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bFO.setText(String.valueOf(tb_age) + this.bEE.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bFP.a(iconInfo, iconInfo.size(), this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            if (userData.getHave_attention() == 1) {
                this.bFQ.setText(com.baidu.tieba.y.attention_cancel);
            } else {
                this.bFQ.setText(com.baidu.tieba.y.attention);
            }
        }
    }

    public LinearLayout aaN() {
        return this.bFW;
    }

    public TextView aaO() {
        return this.bFQ;
    }

    public UserIconBox aaP() {
        return this.bFL;
    }

    public View getRootView() {
        return this.HS;
    }
}
