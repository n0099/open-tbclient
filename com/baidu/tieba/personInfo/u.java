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
    private View aOl;
    private TextView aTI;
    private TextView aZW;
    private PersonInfoActivity bJY;
    private BdExpandImageView bLa;
    private ImageView bLb;
    private float bLc = 360.0f;
    private HeadImageView bLd;
    private UserIconBox bLe;
    private ImageView bLf;
    private TextView bLg;
    private TextView bLh;
    private UserIconBox bLi;
    private TextView bLj;
    private LinearLayout bLk;
    private ImageView bLl;
    private LinearLayout bLm;
    private ImageView bLn;
    private LinearLayout bLo;
    private ImageView bLp;
    private TextView bzz;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds372)));
        initView();
    }

    private void initView() {
        this.aOl = this.mRootView.findViewById(com.baidu.tieba.w.root);
        this.bLa = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.w.expand_image);
        this.bLb = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.refresh_image);
        this.bLd = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.w.user_head);
        this.bLe = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.w.user_vip_icon);
        this.bLe.setOnClickListener(this.bJY);
        this.bzz = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_name);
        this.bLf = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.user_sex);
        this.bLg = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_bar_age);
        this.bLh = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_bar_age_num);
        this.bLi = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.w.user_icon);
        this.bLi.setOnClickListener(this.bJY);
        this.bLj = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.btn_attention);
        this.bLj.setOnClickListener(this.bJY);
        this.bLl = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_site);
        this.bLk = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.dis_time);
        this.bLm = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.time_ll);
        this.bLn = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_time);
        this.aZW = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.distance);
        this.aTI = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.time);
        this.bLo = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.my_gift_ll);
        this.bLo.setOnClickListener(this.bJY);
        this.bLp = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.my_gift);
        abG();
        abH();
    }

    public void abE() {
        this.mBitmap = bc.g((Resources) null, com.baidu.tieba.v.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bLa.setImageBitmap(this.mBitmap);
        }
    }

    public void abF() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.d.bO(com.baidu.tieba.v.bg_mycenter_banner);
            System.gc();
        }
        this.bLa.setImageBitmap(null);
    }

    private void abG() {
        if (TbadkCoreApplication.m255getInst().isGiftSwitchOn()) {
            this.bLo.setVisibility(0);
        } else {
            this.bLo.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m255getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bLo.setVisibility(8);
            this.bLj.setVisibility(8);
            this.bLk.setVisibility(8);
        }
    }

    public void kx() {
        bc.j(this.aOl, com.baidu.tieba.t.cp_bg_line_c);
        bc.b(this.bzz, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.bLg, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.bLh, com.baidu.tieba.t.cp_cont_g, 1);
        bc.i(this.bLo, com.baidu.tieba.v.personinfo_head_icon);
        bc.c(this.bLp, com.baidu.tieba.v.icon_mycenter_gift);
        bc.i(this.bLk, com.baidu.tieba.v.bg_mycenter_bar);
        bc.i((View) this.bLj, com.baidu.tieba.v.bg_mycenter_bar);
        bc.b(this.bLj, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.aZW, com.baidu.tieba.t.cp_cont_g, 1);
        bc.b(this.aTI, com.baidu.tieba.t.cp_cont_g, 1);
        bc.i(this.bLl, com.baidu.tieba.v.icon_mycenter_bar_site);
        bc.i(this.bLn, com.baidu.tieba.v.icon_mycenter_bar_date);
    }

    private void abH() {
        this.bLd.setIsRound(true);
        this.bLd.setDrawBorder(false);
        this.bLd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bLd.setDefaultResource(com.baidu.tieba.v.pic_mycenter_avatar_def);
        this.bLd.setOnClickListener(this.bJY);
    }

    public HeadImageView abI() {
        return this.bLd;
    }

    public UserIconBox abJ() {
        return this.bLi;
    }

    public void j(float f) {
        if (!this.bLb.isShown()) {
            this.bLb.setVisibility(0);
            this.bLb.setImageDrawable(this.bJY.getResources().getDrawable(com.baidu.tieba.v.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bLc, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bLb.startAnimation(rotateAnimation);
        this.bLc = f;
    }

    public void hideProgress() {
        this.bLb.clearAnimation();
        this.bLb.setImageDrawable(null);
        this.bLb.setVisibility(8);
    }

    public void jo() {
        if (!this.bLb.isShown()) {
            this.bLb.setVisibility(0);
            this.bLb.setImageDrawable(this.bJY.getResources().getDrawable(com.baidu.tieba.v.icon_pop_refresh));
        }
        this.bLb.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.q.user_info_center_head_rotate));
    }

    public void abD() {
        v abl = this.bJY.abl();
        UserData userData = abl.getUserData();
        j(userData);
        d(abl.abQ(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int uG = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.uG();
            if (uG == 1 || (uG == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.aZW.setText(distance);
                    this.aTI.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bLm.setVisibility(8);
            this.aZW.setText(com.baidu.tieba.z.lbs_private);
        }
    }

    private void j(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bLd.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bLe.setVisibility(0);
                this.bLe.a(tShowInfo, tShowInfo.size(), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10));
            } else {
                this.bLe.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.m.eG(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.m.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bzz.setText(str);
                if (isMem != 0) {
                    bc.b(this.bzz, com.baidu.tieba.t.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                bc.i(this.bLf, com.baidu.tieba.v.icon_pop_boy);
            } else if (sex == 2) {
                bc.i(this.bLf, com.baidu.tieba.v.icon_pop_girl);
            } else {
                this.bLf.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bLh.setText(String.valueOf(tb_age) + this.bJY.getResources().getString(com.baidu.tieba.z.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bLi.a(iconInfo, iconInfo.size(), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10));
            if (userData.getHave_attention() == 1) {
                this.bLj.setText(com.baidu.tieba.z.attention_cancel);
            } else {
                this.bLj.setText(com.baidu.tieba.z.attention);
            }
            k(userData);
        }
    }

    private void k(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bLj.setVisibility(8);
            this.bLm.setVisibility(8);
            this.bLk.setVisibility(8);
            this.bLo.setVisibility(8);
        }
    }

    public LinearLayout abK() {
        return this.bLo;
    }

    public TextView abL() {
        return this.bLj;
    }

    public UserIconBox abM() {
        return this.bLe;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
