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
    private View HT;
    private View aGj;
    private TextView aQV;
    private PersonInfoActivity bES;
    private BdExpandImageView bFU;
    private ImageView bFV;
    private float bFW = 360.0f;
    private RelativeLayout bFX;
    private HeadImageView bFY;
    private UserIconBox bFZ;
    private ImageView bGa;
    private TextView bGb;
    private TextView bGc;
    private UserIconBox bGd;
    private TextView bGe;
    private LinearLayout bGf;
    private ImageView bGg;
    private TextView bGh;
    private LinearLayout bGi;
    private ImageView bGj;
    private LinearLayout bGk;
    private ImageView bGl;
    private TextView buo;
    private Bitmap mBitmap;
    private boolean mIsHost;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.personinfo_head_view, null);
        this.HT.setLayoutParams(new AbsListView.LayoutParams(-1, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds372)));
        nu();
    }

    private void nu() {
        this.aGj = this.HT.findViewById(com.baidu.tieba.v.root);
        this.bFU = (BdExpandImageView) this.HT.findViewById(com.baidu.tieba.v.expand_image);
        this.bFV = (ImageView) this.HT.findViewById(com.baidu.tieba.v.refresh_image);
        this.bFX = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.head);
        this.bFY = (HeadImageView) this.HT.findViewById(com.baidu.tieba.v.user_head);
        this.bFZ = (UserIconBox) this.HT.findViewById(com.baidu.tieba.v.user_vip_icon);
        this.bFZ.setOnClickListener(this.bES);
        this.buo = (TextView) this.HT.findViewById(com.baidu.tieba.v.user_name);
        this.bGa = (ImageView) this.HT.findViewById(com.baidu.tieba.v.user_sex);
        this.bGb = (TextView) this.HT.findViewById(com.baidu.tieba.v.user_bar_age);
        this.bGc = (TextView) this.HT.findViewById(com.baidu.tieba.v.user_bar_age_num);
        this.bGd = (UserIconBox) this.HT.findViewById(com.baidu.tieba.v.user_icon);
        this.bGd.setOnClickListener(this.bES);
        this.bGe = (TextView) this.HT.findViewById(com.baidu.tieba.v.btn_attention);
        this.bGe.setOnClickListener(this.bES);
        this.bGg = (ImageView) this.HT.findViewById(com.baidu.tieba.v.iv_site);
        this.bGf = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.dis_time);
        this.bGi = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.time_ll);
        this.bGj = (ImageView) this.HT.findViewById(com.baidu.tieba.v.iv_time);
        this.bGh = (TextView) this.HT.findViewById(com.baidu.tieba.v.distance);
        this.aQV = (TextView) this.HT.findViewById(com.baidu.tieba.v.time);
        this.bGk = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.my_gift_ll);
        this.bGk.setOnClickListener(this.bES);
        this.bGl = (ImageView) this.HT.findViewById(com.baidu.tieba.v.my_gift);
        aaM();
        aaN();
    }

    public void aaK() {
        this.mBitmap = aw.f((Resources) null, com.baidu.tieba.u.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bFU.setImageBitmap(this.mBitmap);
        }
    }

    public void aaL() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.d.bm(com.baidu.tieba.u.bg_mycenter_banner);
            System.gc();
        }
        this.bFU.setImageBitmap(null);
    }

    private void aaM() {
        if (TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.bGk.setVisibility(0);
        } else {
            this.bGk.setVisibility(8);
        }
        if (this.mIsHost) {
            this.bGk.setVisibility(8);
            this.bGe.setVisibility(8);
            this.bGf.setVisibility(8);
        }
    }

    public void pU() {
        aw.i(this.aGj, com.baidu.tieba.s.cp_bg_line_c);
        aw.b(this.buo, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.bGb, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.bGc, com.baidu.tieba.s.cp_cont_g, 1);
        aw.h(this.bGk, com.baidu.tieba.u.personinfo_head_icon);
        aw.c(this.bGl, com.baidu.tieba.u.icon_mycenter_gift);
        aw.h(this.bGf, com.baidu.tieba.u.bg_mycenter_bar);
        aw.h((View) this.bGe, com.baidu.tieba.u.bg_mycenter_bar);
        aw.b(this.bGe, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.bGh, com.baidu.tieba.s.cp_cont_g, 1);
        aw.b(this.aQV, com.baidu.tieba.s.cp_cont_g, 1);
        aw.h(this.bGg, com.baidu.tieba.u.icon_mycenter_bar_site);
        aw.h(this.bGj, com.baidu.tieba.u.icon_mycenter_bar_date);
    }

    private void aaN() {
        this.bFY.setIsRound(true);
        this.bFY.setDrawBorder(false);
        this.bFY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bFY.setDefaultResource(com.baidu.tieba.u.pic_mycenter_avatar_def);
        this.bFY.setOnClickListener(this.bES);
    }

    public HeadImageView aaO() {
        return this.bFY;
    }

    public UserIconBox aaP() {
        return this.bGd;
    }

    public void i(float f) {
        if (!this.bFV.isShown()) {
            this.bFV.setVisibility(0);
            this.bFV.setImageDrawable(this.bES.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bFW, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bFV.startAnimation(rotateAnimation);
        this.bFW = f;
    }

    public void hideProgress() {
        this.bFV.clearAnimation();
        this.bFV.setImageDrawable(null);
        this.bFV.setVisibility(8);
    }

    public void hx() {
        if (!this.bFV.isShown()) {
            this.bFV.setVisibility(0);
            this.bFV.setImageDrawable(this.bES.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        this.bFV.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bES, com.baidu.tieba.p.user_info_center_head_rotate));
    }

    public void aaJ() {
        v aar = this.bES.aar();
        UserData userData = aar.getUserData();
        g(userData);
        d(aar.aaV(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.c personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int qT = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.qT();
            if (qT == 1 || (qT == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bGh.setText(distance);
                    this.aQV.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bGi.setVisibility(8);
            this.bGh.setText(com.baidu.tieba.y.lbs_private);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bFY.c(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bFZ.setVisibility(0);
                this.bFZ.a(tShowInfo, tShowInfo.size(), this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            } else {
                this.bFZ.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tieba.game.a.g.fy(name_show) > 14 ? String.valueOf(com.baidu.tieba.game.a.g.g(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.buo.setText(str);
                if (isMem != 0) {
                    aw.b(this.buo, com.baidu.tieba.s.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                aw.h(this.bGa, com.baidu.tieba.u.icon_pop_boy);
            } else if (sex == 2) {
                aw.h(this.bGa, com.baidu.tieba.u.icon_pop_girl);
            } else {
                this.bGa.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bGc.setText(String.valueOf(tb_age) + this.bES.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bGd.a(iconInfo, iconInfo.size(), this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            if (userData.getHave_attention() == 1) {
                this.bGe.setText(com.baidu.tieba.y.attention_cancel);
            } else {
                this.bGe.setText(com.baidu.tieba.y.attention);
            }
        }
    }

    public LinearLayout aaQ() {
        return this.bGk;
    }

    public TextView aaR() {
        return this.bGe;
    }

    public UserIconBox aaS() {
        return this.bFZ;
    }

    public View getRootView() {
        return this.HT;
    }
}
