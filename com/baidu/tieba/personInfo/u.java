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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private View aVC;
    private TextView aYD;
    private TextView bEZ;
    private PersonInfoActivity bSy;
    private BdExpandImageView bTA;
    private ImageView bTB;
    private float bTC = 360.0f;
    private RelativeLayout bTD;
    private HeadImageView bTE;
    private UserIconBox bTF;
    private ImageView bTG;
    private TextView bTH;
    private TextView bTI;
    private UserIconBox bTJ;
    private TextView bTK;
    private LinearLayout bTL;
    private ImageView bTM;
    private LinearLayout bTN;
    private ImageView bTO;
    private LinearLayout bTP;
    private ImageView bTQ;
    private TextView brT;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds372)));
        initView();
    }

    private void initView() {
        this.aVC = this.mRootView.findViewById(com.baidu.tieba.v.root);
        this.bTA = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.v.expand_image);
        this.bTB = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.refresh_image);
        this.bTD = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.head);
        this.bTE = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.v.user_head);
        this.bTF = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.v.user_vip_icon);
        this.bTF.setOnClickListener(this.bSy);
        this.bEZ = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.user_name);
        this.bTG = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.user_sex);
        this.bTH = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.user_bar_age);
        this.bTI = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.user_bar_age_num);
        this.bTJ = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.v.user_icon);
        this.bTJ.setOnClickListener(this.bSy);
        this.bTK = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.btn_attention);
        this.bTK.setOnClickListener(this.bSy);
        this.bTM = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.iv_site);
        this.bTL = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.dis_time);
        this.bTN = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.time_ll);
        this.bTO = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.iv_time);
        this.brT = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.distance);
        this.aYD = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.time);
        this.bTP = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.my_gift_ll);
        this.bTP.setOnClickListener(this.bSy);
        this.bTQ = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.my_gift);
        aej();
        aek();
    }

    public void aeh() {
        com.baidu.tbadk.imageManager.e.zy().dE(1152000);
        this.mBitmap = ba.g((Resources) null, com.baidu.tieba.u.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bTA.setImageBitmap(this.mBitmap);
        }
    }

    public void aei() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.bP(com.baidu.tieba.u.bg_mycenter_banner);
            System.gc();
        }
        this.bTA.setImageBitmap(null);
    }

    private void aej() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.bTP.setVisibility(0);
        } else {
            this.bTP.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bTP.setVisibility(8);
            this.bTK.setVisibility(8);
            this.bTL.setVisibility(8);
        }
    }

    public void oq() {
        ba.j(this.aVC, com.baidu.tieba.s.cp_bg_line_c);
        ba.b(this.bEZ, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.bTH, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.bTI, com.baidu.tieba.s.cp_cont_g, 1);
        ba.i(this.bTP, com.baidu.tieba.u.personinfo_head_icon);
        ba.c(this.bTQ, com.baidu.tieba.u.icon_mycenter_gift);
        ba.i(this.bTL, com.baidu.tieba.u.bg_mycenter_bar);
        ba.i((View) this.bTK, com.baidu.tieba.u.bg_mycenter_bar);
        ba.b(this.bTK, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.brT, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.aYD, com.baidu.tieba.s.cp_cont_g, 1);
        ba.i(this.bTM, com.baidu.tieba.u.icon_mycenter_bar_site);
        ba.i(this.bTO, com.baidu.tieba.u.icon_mycenter_bar_date);
    }

    private void aek() {
        this.bTE.setIsRound(true);
        this.bTE.setDrawBorder(false);
        this.bTE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bTE.setDefaultResource(com.baidu.tieba.u.pic_mycenter_avatar_def);
        this.bTE.setOnClickListener(this.bSy);
    }

    public HeadImageView ael() {
        return this.bTE;
    }

    public UserIconBox aem() {
        return this.bTJ;
    }

    public void j(float f) {
        if (!this.bTB.isShown()) {
            this.bTB.setVisibility(0);
            this.bTB.setImageDrawable(this.bSy.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bTC, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bTB.startAnimation(rotateAnimation);
        this.bTC = f;
    }

    public void hideProgress() {
        this.bTB.clearAnimation();
        this.bTB.setImageDrawable(null);
        this.bTB.setVisibility(8);
    }

    public void mK() {
        if (!this.bTB.isShown()) {
            this.bTB.setVisibility(0);
            this.bTB.setImageDrawable(this.bSy.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        this.bTB.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.p.user_info_center_head_rotate));
    }

    public void aeg() {
        v adN = this.bSy.adN();
        UserData userData = adN.getUserData();
        i(userData);
        d(adN.aes(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int yc = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.yc();
            if (yc == 1 || (yc == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.brT.setText(distance);
                    this.aYD.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bTN.setVisibility(8);
            this.brT.setText(com.baidu.tieba.y.lbs_private);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bTE.c(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bTF.setVisibility(0);
                this.bTF.a(tShowInfo, tShowInfo.size(), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            } else {
                this.bTF.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.l.eO(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.l.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bEZ.setText(str);
                if (isMem != 0) {
                    ba.b(this.bEZ, com.baidu.tieba.s.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                ba.i(this.bTG, com.baidu.tieba.u.icon_pop_boy);
            } else if (sex == 2) {
                ba.i(this.bTG, com.baidu.tieba.u.icon_pop_girl);
            } else {
                this.bTG.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bTI.setText(String.valueOf(tb_age) + this.bSy.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bTJ.a(iconInfo, iconInfo.size(), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            if (userData.getHave_attention() == 1) {
                this.bTK.setText(com.baidu.tieba.y.attention_cancel);
            } else {
                this.bTK.setText(com.baidu.tieba.y.attention);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bTK.setVisibility(8);
            this.bTN.setVisibility(8);
            this.bTL.setVisibility(8);
            this.bTP.setVisibility(8);
        }
    }

    public LinearLayout aen() {
        return this.bTP;
    }

    public TextView aeo() {
        return this.bTK;
    }

    public UserIconBox aep() {
        return this.bTF;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
