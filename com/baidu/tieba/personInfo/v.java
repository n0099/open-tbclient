package com.baidu.tieba.personInfo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v {
    private TextView bIw;
    private TextView bYb;
    private View bmf;
    private TextView bpf;
    private PersonInfoActivity cjU;
    private ImageView cmA;
    private float cmB = 360.0f;
    private RelativeLayout cmC;
    private HeadImageView cmD;
    private UserIconBox cmE;
    private ImageView cmF;
    private TextView cmG;
    private TextView cmH;
    private UserIconBox cmI;
    private TextView cmJ;
    private LinearLayout cmK;
    private ImageView cmL;
    private LinearLayout cmM;
    private ImageView cmN;
    private LinearLayout cmO;
    private ImageView cmP;
    private BdExpandImageView cmz;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public v(PersonInfoActivity personInfoActivity, boolean z) {
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.cjU.getResources().getDimensionPixelSize(i.d.ds372)));
        initView();
    }

    private void initView() {
        this.bmf = this.mRootView.findViewById(i.f.root);
        this.cmz = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.cmA = (ImageView) this.mRootView.findViewById(i.f.refresh_image);
        this.cmC = (RelativeLayout) this.mRootView.findViewById(i.f.head);
        this.cmD = (HeadImageView) this.mRootView.findViewById(i.f.user_head);
        this.cmE = (UserIconBox) this.mRootView.findViewById(i.f.user_vip_icon);
        this.cmE.setOnClickListener(this.cjU);
        this.bYb = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.cmF = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.cmG = (TextView) this.mRootView.findViewById(i.f.user_bar_age);
        this.cmH = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
        this.cmI = (UserIconBox) this.mRootView.findViewById(i.f.user_icon);
        this.cmI.setOnClickListener(this.cjU);
        this.cmJ = (TextView) this.mRootView.findViewById(i.f.btn_attention);
        this.cmJ.setOnClickListener(this.cjU);
        this.cmL = (ImageView) this.mRootView.findViewById(i.f.iv_site);
        this.cmK = (LinearLayout) this.mRootView.findViewById(i.f.dis_time);
        this.cmM = (LinearLayout) this.mRootView.findViewById(i.f.time_ll);
        this.cmN = (ImageView) this.mRootView.findViewById(i.f.iv_time);
        this.bIw = (TextView) this.mRootView.findViewById(i.f.distance);
        this.bpf = (TextView) this.mRootView.findViewById(i.f.time);
        this.cmO = (LinearLayout) this.mRootView.findViewById(i.f.my_gift_ll);
        this.cmO.setOnClickListener(this.cjU);
        this.cmP = (ImageView) this.mRootView.findViewById(i.f.my_gift);
        ahm();
        ahn();
    }

    public void ahk() {
        com.baidu.tbadk.imageManager.c.Ce().ee(1152000);
        for (int i = 0; i < 3; i++) {
            this.mBitmap = al.e((Resources) null, i.e.bg_mycenter_banner);
            if (this.mBitmap != null) {
                this.cmz.setImageBitmap(this.mBitmap);
                return;
            }
        }
    }

    public void ahl() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.ca(i.e.bg_mycenter_banner);
            System.gc();
        }
        if (this.cmD != null) {
            this.cmD.Cb();
        }
        this.cmz.setImageBitmap(null);
    }

    private void ahm() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.cmO.setVisibility(0);
        } else {
            this.cmO.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cmO.setVisibility(8);
            this.cmJ.setVisibility(8);
            this.cmK.setVisibility(8);
        }
    }

    public void oQ() {
        al.j(this.bmf, i.c.cp_bg_line_c);
        al.b(this.bYb, i.c.cp_cont_g, 1);
        al.b(this.cmG, i.c.cp_cont_g, 1);
        al.b(this.cmH, i.c.cp_cont_g, 1);
        al.i(this.cmO, i.e.personinfo_head_icon);
        al.c(this.cmP, i.e.icon_mycenter_gift);
        al.i(this.cmK, i.e.bg_mycenter_bar);
        al.i((View) this.cmJ, i.e.bg_mycenter_bar);
        al.b(this.cmJ, i.c.cp_cont_g, 1);
        al.b(this.bIw, i.c.cp_cont_g, 1);
        al.b(this.bpf, i.c.cp_cont_g, 1);
        al.i(this.cmL, i.e.icon_mycenter_bar_site);
        al.i(this.cmN, i.e.icon_mycenter_bar_date);
    }

    private void ahn() {
        this.cmD.setIsRound(true);
        this.cmD.setDrawBorder(false);
        this.cmD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        if (PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cmD.setOnClickListener(this.cjU);
        }
    }

    public HeadImageView aho() {
        return this.cmD;
    }

    public UserIconBox ahp() {
        return this.cmI;
    }

    public void j(float f) {
        if (!this.cmA.isShown()) {
            this.cmA.setVisibility(0);
            this.cmA.setImageDrawable(this.cjU.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cmB, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.cmA.startAnimation(rotateAnimation);
        this.cmB = f;
    }

    public void hideProgress() {
        this.cmA.clearAnimation();
        this.cmA.setImageDrawable(null);
        this.cmA.setVisibility(8);
    }

    public void nn() {
        if (!this.cmA.isShown()) {
            this.cmA.setVisibility(0);
            this.cmA.setImageDrawable(this.cjU.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        this.cmA.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cjU.getPageContext().getPageActivity(), i.a.user_info_center_head_rotate));
    }

    public void ahi() {
        w agL = this.cjU.agL();
        UserData userData = agL.getUserData();
        f(userData);
        d(agL.ahu(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.g personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int Aa = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.Aa();
            if (Aa == 1 || (Aa == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bIw.setText(distance);
                    this.bpf.setText(timeFormat);
                    return;
                }
                return;
            }
            this.cmM.setVisibility(8);
            this.bIw.setText(i.C0057i.lbs_private);
        }
    }

    private void f(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.cmD.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.cmE.setVisibility(0);
                this.cmE.a(tShowInfo, tShowInfo.size(), this.cjU.getResources().getDimensionPixelSize(i.d.ds34), this.cjU.getResources().getDimensionPixelSize(i.d.ds34), this.cjU.getResources().getDimensionPixelSize(i.d.ds10), true);
            } else {
                this.cmE.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.k.fB(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.k.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bYb.setText(str);
                if (isMem != 0) {
                    al.b(this.bYb, i.c.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                al.i(this.cmF, i.e.icon_pop_boy);
            } else if (sex == 2) {
                al.i(this.cmF, i.e.icon_pop_girl);
            } else {
                this.cmF.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.cmH.setText(String.valueOf(tb_age) + this.cjU.getResources().getString(i.C0057i.user_info_center_head_viewpager_tb_age));
            }
            this.cmI.a(userData.getIconInfo(), 9, this.cjU.getResources().getDimensionPixelSize(i.d.ds34), this.cjU.getResources().getDimensionPixelSize(i.d.ds34), this.cjU.getResources().getDimensionPixelSize(i.d.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.cmJ.setText(i.C0057i.attention_cancel);
            } else {
                this.cmJ.setText(i.C0057i.attention);
            }
            g(userData);
        }
    }

    private void g(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.cmJ.setVisibility(8);
            this.cmM.setVisibility(8);
            this.cmK.setVisibility(8);
            this.cmO.setVisibility(8);
        }
    }

    public LinearLayout ahq() {
        return this.cmO;
    }

    public TextView ahr() {
        return this.cmJ;
    }

    public UserIconBox ahs() {
        return this.cmE;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
