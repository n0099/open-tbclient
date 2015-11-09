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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w {
    private TextView bMO;
    private View bnR;
    private TextView btt;
    private TextView cdt;
    private PersonInfoActivity csa;
    private BdExpandImageView cuO;
    private ImageView cuP;
    private RelativeLayout cuR;
    private HeadImageView cuS;
    private UserIconBox cuT;
    private ImageView cuU;
    private TextView cuV;
    private TextView cuW;
    private UserIconBox cuX;
    private TextView cuY;
    private LinearLayout cuZ;
    private ImageView cva;
    private LinearLayout cvb;
    private ImageView cvc;
    private LinearLayout cvd;
    private ImageView cve;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;
    private float cuQ = 360.0f;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aye = new x(this);

    public w(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.csa.getResources().getDimensionPixelSize(i.d.ds372)));
        initView();
    }

    private void initView() {
        this.bnR = this.mRootView.findViewById(i.f.root);
        this.cuO = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.cuP = (ImageView) this.mRootView.findViewById(i.f.refresh_image);
        this.cuR = (RelativeLayout) this.mRootView.findViewById(i.f.head);
        this.cuS = (HeadImageView) this.mRootView.findViewById(i.f.user_head);
        this.cuT = (UserIconBox) this.mRootView.findViewById(i.f.user_vip_icon);
        this.cuT.setOnClickListener(this.csa);
        this.cdt = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.cuU = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.cuV = (TextView) this.mRootView.findViewById(i.f.user_bar_age);
        this.cuW = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
        this.cuX = (UserIconBox) this.mRootView.findViewById(i.f.user_icon);
        this.cuX.setOnClickListener(this.csa);
        this.cuY = (TextView) this.mRootView.findViewById(i.f.btn_attention);
        this.cuY.setOnClickListener(this.csa);
        this.cva = (ImageView) this.mRootView.findViewById(i.f.iv_site);
        this.cuZ = (LinearLayout) this.mRootView.findViewById(i.f.dis_time);
        this.cvb = (LinearLayout) this.mRootView.findViewById(i.f.time_ll);
        this.cvc = (ImageView) this.mRootView.findViewById(i.f.iv_time);
        this.bMO = (TextView) this.mRootView.findViewById(i.f.distance);
        this.btt = (TextView) this.mRootView.findViewById(i.f.time);
        this.cvd = (LinearLayout) this.mRootView.findViewById(i.f.my_gift_ll);
        this.cvd.setOnClickListener(this.csa);
        this.cve = (ImageView) this.mRootView.findViewById(i.f.my_gift);
        akh();
        aki();
    }

    public void f(UserData userData) {
        String bg_pic = userData.getBg_pic();
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.BV().el(1152000);
            for (int i = 0; i < 3; i++) {
                this.mBitmap = an.h((Resources) null, i.e.bg_mycenter_banner);
                if (this.mBitmap != null) {
                    this.cuO.setImageBitmap(this.mBitmap);
                    return;
                }
            }
            return;
        }
        com.baidu.adp.lib.f.c.hb().a(bg_pic, 10, this.aye, 0, 0, null, new Object[0]);
    }

    public void akg() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.cg(i.e.bg_mycenter_banner);
            System.gc();
        }
        if (this.cuS != null) {
            this.cuS.BS();
        }
        this.cuO.setImageBitmap(null);
    }

    private void akh() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.cvd.setVisibility(0);
        } else {
            this.cvd.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cvd.setVisibility(8);
        }
        if (this.mIsHost) {
            this.cvd.setVisibility(8);
            this.cuY.setVisibility(8);
            this.cuZ.setVisibility(8);
        }
    }

    public void oP() {
        an.j(this.bnR, i.c.cp_bg_line_c);
        an.b(this.cdt, i.c.cp_cont_g, 1);
        an.b(this.cuV, i.c.cp_cont_g, 1);
        an.b(this.cuW, i.c.cp_cont_g, 1);
        an.i(this.cvd, i.e.personinfo_head_icon);
        an.c(this.cve, i.e.icon_mycenter_gift);
        an.i(this.cuZ, i.e.bg_mycenter_bar);
        an.i((View) this.cuY, i.e.bg_mycenter_bar);
        an.b(this.cuY, i.c.cp_cont_g, 1);
        an.b(this.bMO, i.c.cp_cont_g, 1);
        an.b(this.btt, i.c.cp_cont_g, 1);
        an.i(this.cva, i.e.icon_mycenter_bar_site);
        an.i(this.cvc, i.e.icon_mycenter_bar_date);
    }

    private void aki() {
        this.cuS.setIsRound(true);
        this.cuS.setDrawBorder(false);
        this.cuS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        if (PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cuS.setOnClickListener(this.csa);
        }
    }

    public HeadImageView akj() {
        return this.cuS;
    }

    public UserIconBox akk() {
        return this.cuX;
    }

    public void j(float f) {
        if (!this.cuP.isShown()) {
            this.cuP.setVisibility(0);
            this.cuP.setImageDrawable(this.csa.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cuQ, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.cuP.startAnimation(rotateAnimation);
        this.cuQ = f;
    }

    public void hideProgress() {
        this.cuP.clearAnimation();
        this.cuP.setImageDrawable(null);
        this.cuP.setVisibility(8);
    }

    public void nm() {
        if (!this.cuP.isShown()) {
            this.cuP.setVisibility(0);
            this.cuP.setImageDrawable(this.csa.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        this.cuP.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.csa.getPageContext().getPageActivity(), i.a.user_info_center_head_rotate));
    }

    public void ake() {
        y ajH = this.csa.ajH();
        UserData userData = ajH.getUserData();
        f(userData);
        g(userData);
        d(ajH.akp(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.f personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int Aa = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.Aa();
            if (Aa == 1 || (Aa == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bMO.setText(distance);
                    this.btt.setText(timeFormat);
                    return;
                }
                return;
            }
            this.cvb.setVisibility(8);
            this.bMO.setText(i.h.lbs_private);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.cuS.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.cuT.setVisibility(0);
                this.cuT.a(tShowInfo, tShowInfo.size(), this.csa.getResources().getDimensionPixelSize(i.d.ds34), this.csa.getResources().getDimensionPixelSize(i.d.ds34), this.csa.getResources().getDimensionPixelSize(i.d.ds10), true);
            } else {
                this.cuT.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.n.fQ(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.cdt.setText(str);
                if (isMem != 0) {
                    an.b(this.cdt, i.c.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                an.i(this.cuU, i.e.icon_pop_boy);
            } else if (sex == 2) {
                an.i(this.cuU, i.e.icon_pop_girl);
            } else {
                this.cuU.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.cuW.setText(String.valueOf(tb_age) + this.csa.getResources().getString(i.h.user_info_center_head_viewpager_tb_age));
            }
            this.cuX.a(userData.getIconInfo(), 9, this.csa.getResources().getDimensionPixelSize(i.d.ds34), this.csa.getResources().getDimensionPixelSize(i.d.ds34), this.csa.getResources().getDimensionPixelSize(i.d.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.cuY.setText(i.h.attention_cancel);
            } else {
                this.cuY.setText(i.h.attention);
            }
            h(userData);
        }
    }

    private void h(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.cuY.setVisibility(8);
            this.cvb.setVisibility(8);
            this.cuZ.setVisibility(8);
            this.cvd.setVisibility(8);
        }
    }

    public LinearLayout akl() {
        return this.cvd;
    }

    public TextView akm() {
        return this.cuY;
    }

    public UserIconBox akn() {
        return this.cuT;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
