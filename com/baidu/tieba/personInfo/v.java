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
    private TextView bJd;
    private TextView bYV;
    private View bmB;
    private TextView bpD;
    private PersonInfoActivity ckP;
    private BdExpandImageView cnB;
    private ImageView cnC;
    private float cnD = 360.0f;
    private RelativeLayout cnE;
    private HeadImageView cnF;
    private UserIconBox cnG;
    private ImageView cnH;
    private TextView cnI;
    private TextView cnJ;
    private UserIconBox cnK;
    private TextView cnL;
    private LinearLayout cnM;
    private ImageView cnN;
    private LinearLayout cnO;
    private ImageView cnP;
    private LinearLayout cnQ;
    private ImageView cnR;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public v(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.ckP.getResources().getDimensionPixelSize(i.d.ds372)));
        initView();
    }

    private void initView() {
        this.bmB = this.mRootView.findViewById(i.f.root);
        this.cnB = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.cnC = (ImageView) this.mRootView.findViewById(i.f.refresh_image);
        this.cnE = (RelativeLayout) this.mRootView.findViewById(i.f.head);
        this.cnF = (HeadImageView) this.mRootView.findViewById(i.f.user_head);
        this.cnG = (UserIconBox) this.mRootView.findViewById(i.f.user_vip_icon);
        this.cnG.setOnClickListener(this.ckP);
        this.bYV = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.cnH = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.cnI = (TextView) this.mRootView.findViewById(i.f.user_bar_age);
        this.cnJ = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
        this.cnK = (UserIconBox) this.mRootView.findViewById(i.f.user_icon);
        this.cnK.setOnClickListener(this.ckP);
        this.cnL = (TextView) this.mRootView.findViewById(i.f.btn_attention);
        this.cnL.setOnClickListener(this.ckP);
        this.cnN = (ImageView) this.mRootView.findViewById(i.f.iv_site);
        this.cnM = (LinearLayout) this.mRootView.findViewById(i.f.dis_time);
        this.cnO = (LinearLayout) this.mRootView.findViewById(i.f.time_ll);
        this.cnP = (ImageView) this.mRootView.findViewById(i.f.iv_time);
        this.bJd = (TextView) this.mRootView.findViewById(i.f.distance);
        this.bpD = (TextView) this.mRootView.findViewById(i.f.time);
        this.cnQ = (LinearLayout) this.mRootView.findViewById(i.f.my_gift_ll);
        this.cnQ.setOnClickListener(this.ckP);
        this.cnR = (ImageView) this.mRootView.findViewById(i.f.my_gift);
        ahE();
        ahF();
    }

    public void ahC() {
        com.baidu.tbadk.imageManager.c.Cs().em(1152000);
        for (int i = 0; i < 3; i++) {
            this.mBitmap = al.e((Resources) null, i.e.bg_mycenter_banner);
            if (this.mBitmap != null) {
                this.cnB.setImageBitmap(this.mBitmap);
                return;
            }
        }
    }

    public void ahD() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.ce(i.e.bg_mycenter_banner);
            System.gc();
        }
        if (this.cnF != null) {
            this.cnF.Cp();
        }
        this.cnB.setImageBitmap(null);
    }

    private void ahE() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.cnQ.setVisibility(0);
        } else {
            this.cnQ.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cnQ.setVisibility(8);
        }
        if (this.mIsHost) {
            this.cnQ.setVisibility(8);
            this.cnL.setVisibility(8);
            this.cnM.setVisibility(8);
        }
    }

    public void oN() {
        al.i(this.bmB, i.c.cp_bg_line_c);
        al.b(this.bYV, i.c.cp_cont_g, 1);
        al.b(this.cnI, i.c.cp_cont_g, 1);
        al.b(this.cnJ, i.c.cp_cont_g, 1);
        al.h(this.cnQ, i.e.personinfo_head_icon);
        al.c(this.cnR, i.e.icon_mycenter_gift);
        al.h(this.cnM, i.e.bg_mycenter_bar);
        al.h((View) this.cnL, i.e.bg_mycenter_bar);
        al.b(this.cnL, i.c.cp_cont_g, 1);
        al.b(this.bJd, i.c.cp_cont_g, 1);
        al.b(this.bpD, i.c.cp_cont_g, 1);
        al.h(this.cnN, i.e.icon_mycenter_bar_site);
        al.h(this.cnP, i.e.icon_mycenter_bar_date);
    }

    private void ahF() {
        this.cnF.setIsRound(true);
        this.cnF.setDrawBorder(false);
        this.cnF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        if (PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cnF.setOnClickListener(this.ckP);
        }
    }

    public HeadImageView ahG() {
        return this.cnF;
    }

    public UserIconBox ahH() {
        return this.cnK;
    }

    public void j(float f) {
        if (!this.cnC.isShown()) {
            this.cnC.setVisibility(0);
            this.cnC.setImageDrawable(this.ckP.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cnD, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.cnC.startAnimation(rotateAnimation);
        this.cnD = f;
    }

    public void hideProgress() {
        this.cnC.clearAnimation();
        this.cnC.setImageDrawable(null);
        this.cnC.setVisibility(8);
    }

    public void nk() {
        if (!this.cnC.isShown()) {
            this.cnC.setVisibility(0);
            this.cnC.setImageDrawable(this.ckP.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        this.cnC.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.ckP.getPageContext().getPageActivity(), i.a.user_info_center_head_rotate));
    }

    public void ahA() {
        w ahd = this.ckP.ahd();
        UserData userData = ahd.getUserData();
        f(userData);
        d(ahd.ahM(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.g personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int An = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.An();
            if (An == 1 || (An == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bJd.setText(distance);
                    this.bpD.setText(timeFormat);
                    return;
                }
                return;
            }
            this.cnO.setVisibility(8);
            this.bJd.setText(i.h.lbs_private);
        }
    }

    private void f(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.cnF.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.cnG.setVisibility(0);
                this.cnG.a(tShowInfo, tShowInfo.size(), this.ckP.getResources().getDimensionPixelSize(i.d.ds34), this.ckP.getResources().getDimensionPixelSize(i.d.ds34), this.ckP.getResources().getDimensionPixelSize(i.d.ds10), true);
            } else {
                this.cnG.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.k.fJ(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.k.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bYV.setText(str);
                if (isMem != 0) {
                    al.b(this.bYV, i.c.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                al.h(this.cnH, i.e.icon_pop_boy);
            } else if (sex == 2) {
                al.h(this.cnH, i.e.icon_pop_girl);
            } else {
                this.cnH.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.cnJ.setText(String.valueOf(tb_age) + this.ckP.getResources().getString(i.h.user_info_center_head_viewpager_tb_age));
            }
            this.cnK.a(userData.getIconInfo(), 9, this.ckP.getResources().getDimensionPixelSize(i.d.ds34), this.ckP.getResources().getDimensionPixelSize(i.d.ds34), this.ckP.getResources().getDimensionPixelSize(i.d.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.cnL.setText(i.h.attention_cancel);
            } else {
                this.cnL.setText(i.h.attention);
            }
            g(userData);
        }
    }

    private void g(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.cnL.setVisibility(8);
            this.cnO.setVisibility(8);
            this.cnM.setVisibility(8);
            this.cnQ.setVisibility(8);
        }
    }

    public LinearLayout ahI() {
        return this.cnQ;
    }

    public TextView ahJ() {
        return this.cnL;
    }

    public UserIconBox ahK() {
        return this.cnG;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
