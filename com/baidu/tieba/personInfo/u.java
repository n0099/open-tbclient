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
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private View aOm;
    private TextView aTJ;
    private TextView aZX;
    private PersonInfoActivity bJZ;
    private BdExpandImageView bLb;
    private ImageView bLc;
    private float bLd = 360.0f;
    private HeadImageView bLe;
    private UserIconBox bLf;
    private ImageView bLg;
    private TextView bLh;
    private TextView bLi;
    private UserIconBox bLj;
    private TextView bLk;
    private LinearLayout bLl;
    private ImageView bLm;
    private LinearLayout bLn;
    private ImageView bLo;
    private LinearLayout bLp;
    private ImageView bLq;
    private TextView bzA;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJZ = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds372)));
        initView();
    }

    private void initView() {
        this.aOm = this.mRootView.findViewById(com.baidu.tieba.w.root);
        this.bLb = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.w.expand_image);
        this.bLc = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.refresh_image);
        this.bLe = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.w.user_head);
        this.bLf = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.w.user_vip_icon);
        this.bLf.setOnClickListener(this.bJZ);
        this.bzA = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_name);
        this.bLg = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.user_sex);
        this.bLh = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_bar_age);
        this.bLi = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_bar_age_num);
        this.bLj = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.w.user_icon);
        this.bLj.setOnClickListener(this.bJZ);
        this.bLk = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.btn_attention);
        this.bLk.setOnClickListener(this.bJZ);
        this.bLm = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_site);
        this.bLl = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.dis_time);
        this.bLn = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.time_ll);
        this.bLo = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_time);
        this.aZX = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.distance);
        this.aTJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.time);
        this.bLp = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.my_gift_ll);
        this.bLp.setOnClickListener(this.bJZ);
        this.bLq = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.my_gift);
        abL();
        abM();
    }

    public void abJ() {
        this.mBitmap = bc.g((Resources) null, com.baidu.tieba.v.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bLb.setImageBitmap(this.mBitmap);
        }
    }

    public void abK() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.d.bO(com.baidu.tieba.v.bg_mycenter_banner);
            System.gc();
        }
        this.bLb.setImageBitmap(null);
    }

    private void abL() {
        if (TbadkCoreApplication.m255getInst().isGiftSwitchOn()) {
            this.bLp.setVisibility(0);
        } else {
            this.bLp.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m255getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bLp.setVisibility(8);
            this.bLk.setVisibility(8);
            this.bLl.setVisibility(8);
        }
    }

    public void kE() {
        bc.j(this.aOm, com.baidu.tieba.t.cp_bg_line_c);
        bc.b(this.bzA, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.bLh, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.bLi, com.baidu.tieba.t.cp_cont_g, 1);
        bc.i(this.bLp, com.baidu.tieba.v.personinfo_head_icon);
        bc.c(this.bLq, com.baidu.tieba.v.icon_mycenter_gift);
        bc.i(this.bLl, com.baidu.tieba.v.bg_mycenter_bar);
        bc.i((View) this.bLk, com.baidu.tieba.v.bg_mycenter_bar);
        bc.b(this.bLk, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.aZX, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.aTJ, com.baidu.tieba.t.cp_cont_g, 1);
        bc.i(this.bLm, com.baidu.tieba.v.icon_mycenter_bar_site);
        bc.i(this.bLo, com.baidu.tieba.v.icon_mycenter_bar_date);
    }

    private void abM() {
        this.bLe.setIsRound(true);
        this.bLe.setDrawBorder(false);
        this.bLe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bLe.setDefaultResource(com.baidu.tieba.v.pic_mycenter_avatar_def);
        this.bLe.setOnClickListener(this.bJZ);
    }

    public HeadImageView abN() {
        return this.bLe;
    }

    public UserIconBox abO() {
        return this.bLj;
    }

    public void j(float f) {
        if (!this.bLc.isShown()) {
            this.bLc.setVisibility(0);
            this.bLc.setImageDrawable(this.bJZ.getResources().getDrawable(com.baidu.tieba.v.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bLd, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bLc.startAnimation(rotateAnimation);
        this.bLd = f;
    }

    public void hideProgress() {
        this.bLc.clearAnimation();
        this.bLc.setImageDrawable(null);
        this.bLc.setVisibility(8);
    }

    public void jv() {
        if (!this.bLc.isShown()) {
            this.bLc.setVisibility(0);
            this.bLc.setImageDrawable(this.bJZ.getResources().getDrawable(com.baidu.tieba.v.icon_pop_refresh));
        }
        this.bLc.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.q.user_info_center_head_rotate));
    }

    public void abI() {
        v abq = this.bJZ.abq();
        UserData userData = abq.getUserData();
        j(userData);
        d(abq.abV(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int uM = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.uM();
            if (uM == 1 || (uM == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.aZX.setText(distance);
                    this.aTJ.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bLn.setVisibility(8);
            this.aZX.setText(com.baidu.tieba.z.lbs_private);
        }
    }

    private void j(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bLe.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bLf.setVisibility(0);
                this.bLf.a(tShowInfo, tShowInfo.size(), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10));
            } else {
                this.bLf.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.m.eJ(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.m.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bzA.setText(str);
                if (isMem != 0) {
                    bc.b(this.bzA, com.baidu.tieba.t.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                bc.i(this.bLg, com.baidu.tieba.v.icon_pop_boy);
            } else if (sex == 2) {
                bc.i(this.bLg, com.baidu.tieba.v.icon_pop_girl);
            } else {
                this.bLg.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bLi.setText(String.valueOf(tb_age) + this.bJZ.getResources().getString(com.baidu.tieba.z.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bLj.a(iconInfo, iconInfo.size(), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10));
            if (userData.getHave_attention() == 1) {
                this.bLk.setText(com.baidu.tieba.z.attention_cancel);
            } else {
                this.bLk.setText(com.baidu.tieba.z.attention);
            }
            k(userData);
        }
    }

    private void k(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bLk.setVisibility(8);
            this.bLn.setVisibility(8);
            this.bLl.setVisibility(8);
            this.bLp.setVisibility(8);
        }
    }

    public LinearLayout abP() {
        return this.bLp;
    }

    public TextView abQ() {
        return this.bLk;
    }

    public UserIconBox abR() {
        return this.bLf;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
