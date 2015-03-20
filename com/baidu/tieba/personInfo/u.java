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
    private View aVn;
    private TextView aYn;
    private TextView bEM;
    private PersonInfoActivity bSi;
    private ImageView bTA;
    private BdExpandImageView bTk;
    private ImageView bTl;
    private float bTm = 360.0f;
    private RelativeLayout bTn;
    private HeadImageView bTo;
    private UserIconBox bTp;
    private ImageView bTq;
    private TextView bTr;
    private TextView bTs;
    private UserIconBox bTt;
    private TextView bTu;
    private LinearLayout bTv;
    private ImageView bTw;
    private LinearLayout bTx;
    private ImageView bTy;
    private LinearLayout bTz;
    private TextView brD;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds372)));
        initView();
    }

    private void initView() {
        this.aVn = this.mRootView.findViewById(com.baidu.tieba.v.root);
        this.bTk = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.v.expand_image);
        this.bTl = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.refresh_image);
        this.bTn = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.head);
        this.bTo = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.v.user_head);
        this.bTp = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.v.user_vip_icon);
        this.bTp.setOnClickListener(this.bSi);
        this.bEM = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.user_name);
        this.bTq = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.user_sex);
        this.bTr = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.user_bar_age);
        this.bTs = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.user_bar_age_num);
        this.bTt = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.v.user_icon);
        this.bTt.setOnClickListener(this.bSi);
        this.bTu = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.btn_attention);
        this.bTu.setOnClickListener(this.bSi);
        this.bTw = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.iv_site);
        this.bTv = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.dis_time);
        this.bTx = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.time_ll);
        this.bTy = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.iv_time);
        this.brD = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.distance);
        this.aYn = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.time);
        this.bTz = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.my_gift_ll);
        this.bTz.setOnClickListener(this.bSi);
        this.bTA = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.my_gift);
        adU();
        adV();
    }

    public void adS() {
        com.baidu.tbadk.imageManager.e.zs().dE(1152000);
        this.mBitmap = ba.g((Resources) null, com.baidu.tieba.u.bg_mycenter_banner);
        if (this.mBitmap != null) {
            this.bTk.setImageBitmap(this.mBitmap);
        }
    }

    public void adT() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.bP(com.baidu.tieba.u.bg_mycenter_banner);
            System.gc();
        }
        this.bTk.setImageBitmap(null);
    }

    private void adU() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.bTz.setVisibility(0);
        } else {
            this.bTz.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bTz.setVisibility(8);
            this.bTu.setVisibility(8);
            this.bTv.setVisibility(8);
        }
    }

    public void oq() {
        ba.j(this.aVn, com.baidu.tieba.s.cp_bg_line_c);
        ba.b(this.bEM, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.bTr, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.bTs, com.baidu.tieba.s.cp_cont_g, 1);
        ba.i(this.bTz, com.baidu.tieba.u.personinfo_head_icon);
        ba.c(this.bTA, com.baidu.tieba.u.icon_mycenter_gift);
        ba.i(this.bTv, com.baidu.tieba.u.bg_mycenter_bar);
        ba.i((View) this.bTu, com.baidu.tieba.u.bg_mycenter_bar);
        ba.b(this.bTu, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.brD, com.baidu.tieba.s.cp_cont_g, 1);
        ba.b(this.aYn, com.baidu.tieba.s.cp_cont_g, 1);
        ba.i(this.bTw, com.baidu.tieba.u.icon_mycenter_bar_site);
        ba.i(this.bTy, com.baidu.tieba.u.icon_mycenter_bar_date);
    }

    private void adV() {
        this.bTo.setIsRound(true);
        this.bTo.setDrawBorder(false);
        this.bTo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bTo.setDefaultResource(com.baidu.tieba.u.pic_mycenter_avatar_def);
        this.bTo.setOnClickListener(this.bSi);
    }

    public HeadImageView adW() {
        return this.bTo;
    }

    public UserIconBox adX() {
        return this.bTt;
    }

    public void j(float f) {
        if (!this.bTl.isShown()) {
            this.bTl.setVisibility(0);
            this.bTl.setImageDrawable(this.bSi.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bTm, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bTl.startAnimation(rotateAnimation);
        this.bTm = f;
    }

    public void hideProgress() {
        this.bTl.clearAnimation();
        this.bTl.setImageDrawable(null);
        this.bTl.setVisibility(8);
    }

    public void mK() {
        if (!this.bTl.isShown()) {
            this.bTl.setVisibility(0);
            this.bTl.setImageDrawable(this.bSi.getResources().getDrawable(com.baidu.tieba.u.icon_pop_refresh));
        }
        this.bTl.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.p.user_info_center_head_rotate));
    }

    public void adR() {
        v ady = this.bSi.ady();
        UserData userData = ady.getUserData();
        i(userData);
        d(ady.aed(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int xW = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.xW();
            if (xW == 1 || (xW == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.brD.setText(distance);
                    this.aYn.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bTx.setVisibility(8);
            this.brD.setText(com.baidu.tieba.y.lbs_private);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bTo.c(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bTp.setVisibility(0);
                this.bTp.a(tShowInfo, tShowInfo.size(), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            } else {
                this.bTp.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.l.eL(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.l.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bEM.setText(str);
                if (isMem != 0) {
                    ba.b(this.bEM, com.baidu.tieba.s.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                ba.i(this.bTq, com.baidu.tieba.u.icon_pop_boy);
            } else if (sex == 2) {
                ba.i(this.bTq, com.baidu.tieba.u.icon_pop_girl);
            } else {
                this.bTq.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bTs.setText(String.valueOf(tb_age) + this.bSi.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bTt.a(iconInfo, iconInfo.size(), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds34), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10));
            if (userData.getHave_attention() == 1) {
                this.bTu.setText(com.baidu.tieba.y.attention_cancel);
            } else {
                this.bTu.setText(com.baidu.tieba.y.attention);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bTu.setVisibility(8);
            this.bTx.setVisibility(8);
            this.bTv.setVisibility(8);
            this.bTz.setVisibility(8);
        }
    }

    public LinearLayout adY() {
        return this.bTz;
    }

    public TextView adZ() {
        return this.bTu;
    }

    public UserIconBox aea() {
        return this.bTp;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
