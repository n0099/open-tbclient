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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private View aNd;
    private TextView aSz;
    private TextView aYB;
    private PersonInfoActivity bIn;
    private LinearLayout bJA;
    private ImageView bJB;
    private LinearLayout bJC;
    private ImageView bJD;
    private LinearLayout bJE;
    private ImageView bJF;
    private BdExpandImageView bJp;
    private ImageView bJq;
    private float bJr = 360.0f;
    private RelativeLayout bJs;
    private HeadImageView bJt;
    private UserIconBox bJu;
    private ImageView bJv;
    private TextView bJw;
    private TextView bJx;
    private UserIconBox bJy;
    private TextView bJz;
    private TextView bxR;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds372)));
        initView();
    }

    private void initView() {
        this.aNd = this.mRootView.findViewById(com.baidu.tieba.w.root);
        this.bJp = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.w.expand_image);
        this.bJq = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.refresh_image);
        this.bJs = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.head);
        this.bJt = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.w.user_head);
        this.bJu = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.w.user_vip_icon);
        this.bJu.setOnClickListener(this.bIn);
        this.bxR = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_name);
        this.bJv = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.user_sex);
        this.bJw = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_bar_age);
        this.bJx = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.user_bar_age_num);
        this.bJy = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.w.user_icon);
        this.bJy.setOnClickListener(this.bIn);
        this.bJz = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.btn_attention);
        this.bJz.setOnClickListener(this.bIn);
        this.bJB = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_site);
        this.bJA = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.dis_time);
        this.bJC = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.time_ll);
        this.bJD = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.iv_time);
        this.aYB = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.distance);
        this.aSz = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.time);
        this.bJE = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.my_gift_ll);
        this.bJE.setOnClickListener(this.bIn);
        this.bJF = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.my_gift);
        abh();
        abi();
    }

    public void abf() {
        this.mBitmap = ax.g((Resources) null, com.baidu.tieba.v.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bJp.setImageBitmap(this.mBitmap);
        }
    }

    public void abg() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.d.bJ(com.baidu.tieba.v.bg_mycenter_banner);
            System.gc();
        }
        this.bJp.setImageBitmap(null);
    }

    private void abh() {
        if (TbadkCoreApplication.m255getInst().isGiftSwitchOn()) {
            this.bJE.setVisibility(0);
        } else {
            this.bJE.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m255getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bJE.setVisibility(8);
            this.bJz.setVisibility(8);
            this.bJA.setVisibility(8);
        }
    }

    public void kE() {
        ax.j(this.aNd, com.baidu.tieba.t.cp_bg_line_c);
        ax.b(this.bxR, com.baidu.tieba.t.cp_cont_g, 1);
        ax.b(this.bJw, com.baidu.tieba.t.cp_cont_g, 1);
        ax.b(this.bJx, com.baidu.tieba.t.cp_cont_g, 1);
        ax.i(this.bJE, com.baidu.tieba.v.personinfo_head_icon);
        ax.c(this.bJF, com.baidu.tieba.v.icon_mycenter_gift);
        ax.i(this.bJA, com.baidu.tieba.v.bg_mycenter_bar);
        ax.i((View) this.bJz, com.baidu.tieba.v.bg_mycenter_bar);
        ax.b(this.bJz, com.baidu.tieba.t.cp_cont_g, 1);
        ax.b(this.aYB, com.baidu.tieba.t.cp_cont_g, 1);
        ax.b(this.aSz, com.baidu.tieba.t.cp_cont_g, 1);
        ax.i(this.bJB, com.baidu.tieba.v.icon_mycenter_bar_site);
        ax.i(this.bJD, com.baidu.tieba.v.icon_mycenter_bar_date);
    }

    private void abi() {
        this.bJt.setIsRound(true);
        this.bJt.setDrawBorder(false);
        this.bJt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bJt.setDefaultResource(com.baidu.tieba.v.pic_mycenter_avatar_def);
        this.bJt.setOnClickListener(this.bIn);
    }

    public HeadImageView abj() {
        return this.bJt;
    }

    public UserIconBox abk() {
        return this.bJy;
    }

    public void j(float f) {
        if (!this.bJq.isShown()) {
            this.bJq.setVisibility(0);
            this.bJq.setImageDrawable(this.bIn.getResources().getDrawable(com.baidu.tieba.v.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bJr, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bJq.startAnimation(rotateAnimation);
        this.bJr = f;
    }

    public void hideProgress() {
        this.bJq.clearAnimation();
        this.bJq.setImageDrawable(null);
        this.bJq.setVisibility(8);
    }

    public void ju() {
        if (!this.bJq.isShown()) {
            this.bJq.setVisibility(0);
            this.bJq.setImageDrawable(this.bIn.getResources().getDrawable(com.baidu.tieba.v.icon_pop_refresh));
        }
        this.bJq.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.q.user_info_center_head_rotate));
    }

    public void abe() {
        v aaL = this.bIn.aaL();
        UserData userData = aaL.getUserData();
        j(userData);
        d(aaL.abr(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int uv = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.uv();
            if (uv == 1 || (uv == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.aYB.setText(distance);
                    this.aSz.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bJC.setVisibility(8);
            this.aYB.setText(com.baidu.tieba.z.lbs_private);
        }
    }

    private void j(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bJt.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bJu.setVisibility(0);
                this.bJu.a(tShowInfo, tShowInfo.size(), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10));
            } else {
                this.bJu.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.j.eI(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.j.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bxR.setText(str);
                if (isMem != 0) {
                    ax.b(this.bxR, com.baidu.tieba.t.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                ax.i(this.bJv, com.baidu.tieba.v.icon_pop_boy);
            } else if (sex == 2) {
                ax.i(this.bJv, com.baidu.tieba.v.icon_pop_girl);
            } else {
                this.bJv.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bJx.setText(String.valueOf(tb_age) + this.bIn.getResources().getString(com.baidu.tieba.z.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bJy.a(iconInfo, iconInfo.size(), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds34), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds10));
            if (userData.getHave_attention() == 1) {
                this.bJz.setText(com.baidu.tieba.z.attention_cancel);
            } else {
                this.bJz.setText(com.baidu.tieba.z.attention);
            }
            k(userData);
        }
    }

    private void k(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bJz.setVisibility(8);
            this.bJC.setVisibility(8);
            this.bJA.setVisibility(8);
            this.bJE.setVisibility(8);
        }
    }

    public LinearLayout abl() {
        return this.bJE;
    }

    public TextView abm() {
        return this.bJz;
    }

    public UserIconBox abn() {
        return this.bJu;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
