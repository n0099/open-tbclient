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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w {
    private TextView bMi;
    private View bnc;
    private TextView bsE;
    private TextView ccH;
    private PersonInfoActivity cqt;
    private BdExpandImageView cth;
    private ImageView cti;
    private RelativeLayout ctk;
    private HeadImageView ctl;
    private UserIconBox ctm;
    private ImageView ctn;
    private TextView cto;
    private TextView ctp;
    private UserIconBox ctq;
    private TextView ctr;
    private LinearLayout cts;
    private ImageView ctt;
    private LinearLayout ctu;
    private ImageView ctv;
    private LinearLayout ctw;
    private ImageView ctx;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;
    private float ctj = 360.0f;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azf = new x(this);

    public w(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.cqt.getResources().getDimensionPixelSize(i.d.ds372)));
        initView();
    }

    private void initView() {
        this.bnc = this.mRootView.findViewById(i.f.root);
        this.cth = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.cti = (ImageView) this.mRootView.findViewById(i.f.refresh_image);
        this.ctk = (RelativeLayout) this.mRootView.findViewById(i.f.head);
        this.ctl = (HeadImageView) this.mRootView.findViewById(i.f.user_head);
        this.ctm = (UserIconBox) this.mRootView.findViewById(i.f.user_vip_icon);
        this.ctm.setOnClickListener(this.cqt);
        this.ccH = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.ctn = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.cto = (TextView) this.mRootView.findViewById(i.f.user_bar_age);
        this.ctp = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
        this.ctq = (UserIconBox) this.mRootView.findViewById(i.f.user_icon);
        this.ctq.setOnClickListener(this.cqt);
        this.ctr = (TextView) this.mRootView.findViewById(i.f.btn_attention);
        this.ctr.setOnClickListener(this.cqt);
        this.ctt = (ImageView) this.mRootView.findViewById(i.f.iv_site);
        this.cts = (LinearLayout) this.mRootView.findViewById(i.f.dis_time);
        this.ctu = (LinearLayout) this.mRootView.findViewById(i.f.time_ll);
        this.ctv = (ImageView) this.mRootView.findViewById(i.f.iv_time);
        this.bMi = (TextView) this.mRootView.findViewById(i.f.distance);
        this.bsE = (TextView) this.mRootView.findViewById(i.f.time);
        this.ctw = (LinearLayout) this.mRootView.findViewById(i.f.my_gift_ll);
        this.ctw.setOnClickListener(this.cqt);
        this.ctx = (ImageView) this.mRootView.findViewById(i.f.my_gift);
        ajF();
        ajG();
    }

    public void f(UserData userData) {
        String bg_pic = userData.getBg_pic();
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Cf().en(1152000);
            for (int i = 0; i < 3; i++) {
                this.mBitmap = am.h((Resources) null, i.e.bg_mycenter_banner);
                if (this.mBitmap != null) {
                    this.cth.setImageBitmap(this.mBitmap);
                    return;
                }
            }
            return;
        }
        com.baidu.adp.lib.f.c.ha().a(bg_pic, 10, this.azf, 0, 0, null, new Object[0]);
    }

    public void ajE() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.cg(i.e.bg_mycenter_banner);
            System.gc();
        }
        if (this.ctl != null) {
            this.ctl.Cc();
        }
        this.cth.setImageBitmap(null);
    }

    private void ajF() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.ctw.setVisibility(0);
        } else {
            this.ctw.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.ctw.setVisibility(8);
        }
        if (this.mIsHost) {
            this.ctw.setVisibility(8);
            this.ctr.setVisibility(8);
            this.cts.setVisibility(8);
        }
    }

    public void oO() {
        am.j(this.bnc, i.c.cp_bg_line_c);
        am.b(this.ccH, i.c.cp_cont_g, 1);
        am.b(this.cto, i.c.cp_cont_g, 1);
        am.b(this.ctp, i.c.cp_cont_g, 1);
        am.i(this.ctw, i.e.personinfo_head_icon);
        am.c(this.ctx, i.e.icon_mycenter_gift);
        am.i(this.cts, i.e.bg_mycenter_bar);
        am.i((View) this.ctr, i.e.bg_mycenter_bar);
        am.b(this.ctr, i.c.cp_cont_g, 1);
        am.b(this.bMi, i.c.cp_cont_g, 1);
        am.b(this.bsE, i.c.cp_cont_g, 1);
        am.i(this.ctt, i.e.icon_mycenter_bar_site);
        am.i(this.ctv, i.e.icon_mycenter_bar_date);
    }

    private void ajG() {
        this.ctl.setIsRound(true);
        this.ctl.setDrawBorder(false);
        this.ctl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        if (PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.ctl.setOnClickListener(this.cqt);
        }
    }

    public HeadImageView ajH() {
        return this.ctl;
    }

    public UserIconBox ajI() {
        return this.ctq;
    }

    public void j(float f) {
        if (!this.cti.isShown()) {
            this.cti.setVisibility(0);
            this.cti.setImageDrawable(this.cqt.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ctj, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.cti.startAnimation(rotateAnimation);
        this.ctj = f;
    }

    public void hideProgress() {
        this.cti.clearAnimation();
        this.cti.setImageDrawable(null);
        this.cti.setVisibility(8);
    }

    public void nl() {
        if (!this.cti.isShown()) {
            this.cti.setVisibility(0);
            this.cti.setImageDrawable(this.cqt.getResources().getDrawable(i.e.icon_pop_refresh));
        }
        this.cti.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.cqt.getPageContext().getPageActivity(), i.a.user_info_center_head_rotate));
    }

    public void ajC() {
        y ajf = this.cqt.ajf();
        UserData userData = ajf.getUserData();
        f(userData);
        g(userData);
        d(ajf.ajN(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.f personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int zY = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.zY();
            if (zY == 1 || (zY == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.bMi.setText(distance);
                    this.bsE.setText(timeFormat);
                    return;
                }
                return;
            }
            this.ctu.setVisibility(8);
            this.bMi.setText(i.h.lbs_private);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ctl.d(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.ctm.setVisibility(0);
                this.ctm.a(tShowInfo, tShowInfo.size(), this.cqt.getResources().getDimensionPixelSize(i.d.ds34), this.cqt.getResources().getDimensionPixelSize(i.d.ds34), this.cqt.getResources().getDimensionPixelSize(i.d.ds10), true);
            } else {
                this.ctm.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.n.fO(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.ccH.setText(str);
                if (isMem != 0) {
                    am.b(this.ccH, i.c.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                am.i(this.ctn, i.e.icon_pop_boy);
            } else if (sex == 2) {
                am.i(this.ctn, i.e.icon_pop_girl);
            } else {
                this.ctn.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.ctp.setText(String.valueOf(tb_age) + this.cqt.getResources().getString(i.h.user_info_center_head_viewpager_tb_age));
            }
            this.ctq.a(userData.getIconInfo(), 9, this.cqt.getResources().getDimensionPixelSize(i.d.ds34), this.cqt.getResources().getDimensionPixelSize(i.d.ds34), this.cqt.getResources().getDimensionPixelSize(i.d.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.ctr.setText(i.h.attention_cancel);
            } else {
                this.ctr.setText(i.h.attention);
            }
            h(userData);
        }
    }

    private void h(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.ctr.setVisibility(8);
            this.ctu.setVisibility(8);
            this.cts.setVisibility(8);
            this.ctw.setVisibility(8);
        }
    }

    public LinearLayout ajJ() {
        return this.ctw;
    }

    public TextView ajK() {
        return this.ctr;
    }

    public UserIconBox ajL() {
        return this.ctm;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
