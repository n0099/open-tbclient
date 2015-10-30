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
    private TextView bMt;
    private View bnn;
    private TextView bsP;
    private TextView ccS;
    private PersonInfoActivity cqE;
    private TextView ctA;
    private UserIconBox ctB;
    private TextView ctC;
    private LinearLayout ctD;
    private ImageView ctE;
    private LinearLayout ctF;
    private ImageView ctG;
    private LinearLayout ctH;
    private ImageView ctI;
    private BdExpandImageView cts;
    private ImageView ctt;
    private RelativeLayout ctv;
    private HeadImageView ctw;
    private UserIconBox ctx;
    private ImageView cty;
    private TextView ctz;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;
    private float ctu = 360.0f;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azq = new x(this);

    public w(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.cqE.getResources().getDimensionPixelSize(i.d.ds372)));
        initView();
    }

    private void initView() {
        this.bnn = this.mRootView.findViewById(i.f.root);
        this.cts = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.ctt = (ImageView) this.mRootView.findViewById(i.f.refresh_image);
        this.ctv = (RelativeLayout) this.mRootView.findViewById(i.f.head);
        this.ctw = (HeadImageView) this.mRootView.findViewById(i.f.user_head);
        this.ctx = (UserIconBox) this.mRootView.findViewById(i.f.user_vip_icon);
        this.ctx.setOnClickListener(this.cqE);
        this.ccS = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.cty = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.ctz = (TextView) this.mRootView.findViewById(i.f.user_bar_age);
        this.ctA = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
        this.ctB = (UserIconBox) this.mRootView.findViewById(i.f.user_icon);
        this.ctB.setOnClickListener(this.cqE);
        this.ctC = (TextView) this.mRootView.findViewById(i.f.btn_attention);
        this.ctC.setOnClickListener(this.cqE);
        this.ctE = (ImageView) this.mRootView.findViewById(i.f.iv_site);
        this.ctD = (LinearLayout) this.mRootView.findViewById(i.f.dis_time);
        this.ctF = (LinearLayout) this.mRootView.findViewById(i.f.time_ll);
        this.ctG = (ImageView) this.mRootView.findViewById(i.f.iv_time);
        this.bMt = (TextView) this.mRootView.findViewById(i.f.distance);
        this.bsP = (TextView) this.mRootView.findViewById(i.f.time);
        this.ctH = (LinearLayout) this.mRootView.findViewById(i.f.my_gift_ll);
        this.ctH.setOnClickListener(this.cqE);
        this.ctI = (ImageView) this.mRootView.findViewById(i.f.my_gift);
        ajB();
        ajC();
    }

    public void f(UserData userData) {
        String bg_pic = userData.getBg_pic();
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Cc().en(1152000);
            for (int i = 0; i < 3; i++) {
                this.mBitmap = an.h((Resources) null, i.e.bg_mycenter_banner);
                if (this.mBitmap != null) {
                    this.cts.setImageBitmap(this.mBitmap);
                    return;
                }
            }
            return;
        }
        com.baidu.adp.lib.f.c.ha().a(bg_pic, 10, this.azq, 0, 0, null, new Object[0]);
    }

    public void ajA() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.cg(i.e.bg_mycenter_banner);
            System.gc();
        }
        if (this.ctw != null) {
            this.ctw.BZ();
        }
        this.cts.setImageBitmap(null);
    }

    private void ajB() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.ctH.setVisibility(0);
        } else {
            this.ctH.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.ctH.setVisibility(8);
        }
        if (this.mIsHost) {
            this.ctH.setVisibility(8);
            this.ctC.setVisibility(8);
            this.ctD.setVisibility(8);
        }
    }

    public void oO() {
        an.j(this.bnn, i.c.cp_bg_line_c);
        an.b(this.ccS, i.c.cp_cont_g, 1);
        an.b(this.ctz, i.c.cp_cont_g, 1);
        an.b(this.ctA, i.c.cp_cont_g, 1);
        an.i(this.ctH, i.e.personinfo_head_icon);
        an.c(this.ctI, i.e.icon_mycenter_gift);
        an.i(this.ctD, i.e.bg_mycenter_bar);
        an.i((View) this.ctC, i.e.bg_mycenter_bar);
        an.b(this.ctC, i.c.cp_cont_g, 1);
        an.b(this.bMt, i.c.cp_cont_g, 1);
        an.b(this.bsP, i.c.cp_cont_g, 1);
        an.i(this.ctE, i.e.icon_mycenter_bar_site);
        an.i(this.ctG, i.e.icon_mycenter_bar_date);
    }

    private void ajC() {
        this.ctw.setIsRound(true);
        this.ctw.setDrawBorder(false);
        this.ctw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        if (PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.ctw.setOnClickListener(this.cqE);
        }
    }

    public HeadImageView ajD() {
        return this.ctw;
    }

    public UserIconBox ajE() {
        return this.ctB;
    }

    public void j(float f) {
        if (!this.ctt.isShown()) {
            this.ctt.setVisibility(0);
            this.ctt.setImageDrawable(this.cqE.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ctu, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.ctt.startAnimation(rotateAnimation);
        this.ctu = f;
    }

    public void hideProgress() {
        this.ctt.clearAnimation();
        this.ctt.setImageDrawable(null);
        this.ctt.setVisibility(8);
    }

    public void nl() {
        if (!this.ctt.isShown()) {
            this.ctt.setVisibility(0);
            this.ctt.setImageDrawable(this.cqE.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        this.ctt.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cqE.getPageContext().getPageActivity(), i.a.user_info_center_head_rotate));
    }

    public void ajy() {
        y ajb = this.cqE.ajb();
        UserData userData = ajb.getUserData();
        f(userData);
        g(userData);
        d(ajb.ajJ(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.f personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int zV = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.zV();
            if (zV == 1 || (zV == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bMt.setText(distance);
                    this.bsP.setText(timeFormat);
                    return;
                }
                return;
            }
            this.ctF.setVisibility(8);
            this.bMt.setText(i.h.lbs_private);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ctw.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.ctx.setVisibility(0);
                this.ctx.a(tShowInfo, tShowInfo.size(), this.cqE.getResources().getDimensionPixelSize(i.d.ds34), this.cqE.getResources().getDimensionPixelSize(i.d.ds34), this.cqE.getResources().getDimensionPixelSize(i.d.ds10), true);
            } else {
                this.ctx.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.n.fO(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.ccS.setText(str);
                if (isMem != 0) {
                    an.b(this.ccS, i.c.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                an.i(this.cty, i.e.icon_pop_boy);
            } else if (sex == 2) {
                an.i(this.cty, i.e.icon_pop_girl);
            } else {
                this.cty.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.ctA.setText(String.valueOf(tb_age) + this.cqE.getResources().getString(i.h.user_info_center_head_viewpager_tb_age));
            }
            this.ctB.a(userData.getIconInfo(), 9, this.cqE.getResources().getDimensionPixelSize(i.d.ds34), this.cqE.getResources().getDimensionPixelSize(i.d.ds34), this.cqE.getResources().getDimensionPixelSize(i.d.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.ctC.setText(i.h.attention_cancel);
            } else {
                this.ctC.setText(i.h.attention);
            }
            h(userData);
        }
    }

    private void h(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.ctC.setVisibility(8);
            this.ctF.setVisibility(8);
            this.ctD.setVisibility(8);
            this.ctH.setVisibility(8);
        }
    }

    public LinearLayout ajF() {
        return this.ctH;
    }

    public TextView ajG() {
        return this.ctC;
    }

    public UserIconBox ajH() {
        return this.ctx;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
