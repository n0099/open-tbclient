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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private View aYj;
    private TextView bHV;
    private PersonInfoActivity bVg;
    private BdExpandImageView bWi;
    private ImageView bWj;
    private float bWk = 360.0f;
    private RelativeLayout bWl;
    private HeadImageView bWm;
    private UserIconBox bWn;
    private ImageView bWo;
    private TextView bWp;
    private TextView bWq;
    private UserIconBox bWr;
    private TextView bWs;
    private LinearLayout bWt;
    private ImageView bWu;
    private LinearLayout bWv;
    private ImageView bWw;
    private LinearLayout bWx;
    private ImageView bWy;
    private TextView bbl;
    private TextView buG;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds372)));
        initView();
    }

    private void initView() {
        this.aYj = this.mRootView.findViewById(com.baidu.tieba.q.root);
        this.bWi = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.q.expand_image);
        this.bWj = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.refresh_image);
        this.bWl = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.head);
        this.bWm = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.q.user_head);
        this.bWn = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.q.user_vip_icon);
        this.bWn.setOnClickListener(this.bVg);
        this.bHV = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.user_name);
        this.bWo = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.user_sex);
        this.bWp = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.user_bar_age);
        this.bWq = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.user_bar_age_num);
        this.bWr = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.q.user_icon);
        this.bWr.setOnClickListener(this.bVg);
        this.bWs = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.btn_attention);
        this.bWs.setOnClickListener(this.bVg);
        this.bWu = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.iv_site);
        this.bWt = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.dis_time);
        this.bWv = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.time_ll);
        this.bWw = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.iv_time);
        this.buG = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.distance);
        this.bbl = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.time);
        this.bWx = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.my_gift_ll);
        this.bWx.setOnClickListener(this.bVg);
        this.bWy = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.my_gift);
        afp();
        afq();
    }

    public void afn() {
        com.baidu.tbadk.imageManager.e.Am().dN(1152000);
        for (int i = 0; i < 3; i++) {
            this.mBitmap = ay.g((Resources) null, com.baidu.tieba.p.bg_mycenter_banner);
            if (this.mBitmap != null) {
                this.bWi.setImageBitmap(this.mBitmap);
                return;
            }
        }
    }

    public void afo() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.bS(com.baidu.tieba.p.bg_mycenter_banner);
            System.gc();
        }
        this.bWi.setImageBitmap(null);
    }

    private void afp() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.bWx.setVisibility(0);
        } else {
            this.bWx.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bWx.setVisibility(8);
            this.bWs.setVisibility(8);
            this.bWt.setVisibility(8);
        }
    }

    public void oG() {
        ay.j(this.aYj, com.baidu.tieba.n.cp_bg_line_c);
        ay.b(this.bHV, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.bWp, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.bWq, com.baidu.tieba.n.cp_cont_g, 1);
        ay.i(this.bWx, com.baidu.tieba.p.personinfo_head_icon);
        ay.c(this.bWy, com.baidu.tieba.p.icon_mycenter_gift);
        ay.i(this.bWt, com.baidu.tieba.p.bg_mycenter_bar);
        ay.i((View) this.bWs, com.baidu.tieba.p.bg_mycenter_bar);
        ay.b(this.bWs, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.buG, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.bbl, com.baidu.tieba.n.cp_cont_g, 1);
        ay.i(this.bWu, com.baidu.tieba.p.icon_mycenter_bar_site);
        ay.i(this.bWw, com.baidu.tieba.p.icon_mycenter_bar_date);
    }

    private void afq() {
        this.bWm.setIsRound(true);
        this.bWm.setDrawBorder(false);
        this.bWm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bWm.setDefaultResource(com.baidu.tieba.p.pic_mycenter_avatar_def);
        this.bWm.setOnClickListener(this.bVg);
    }

    public HeadImageView afr() {
        return this.bWm;
    }

    public UserIconBox afs() {
        return this.bWr;
    }

    public void j(float f) {
        if (!this.bWj.isShown()) {
            this.bWj.setVisibility(0);
            this.bWj.setImageDrawable(this.bVg.getResources().getDrawable(com.baidu.tieba.p.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bWk, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bWj.startAnimation(rotateAnimation);
        this.bWk = f;
    }

    public void hideProgress() {
        this.bWj.clearAnimation();
        this.bWj.setImageDrawable(null);
        this.bWj.setVisibility(8);
    }

    public void nd() {
        if (!this.bWj.isShown()) {
            this.bWj.setVisibility(0);
            this.bWj.setImageDrawable(this.bVg.getResources().getDrawable(com.baidu.tieba.p.icon_pop_refresh));
        }
        this.bWj.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.k.user_info_center_head_rotate));
    }

    public void afm() {
        v aeU = this.bVg.aeU();
        UserData userData = aeU.getUserData();
        i(userData);
        d(aeU.afy(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int yQ = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.yQ();
            if (yQ == 1 || (yQ == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.buG.setText(distance);
                    this.bbl.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bWv.setVisibility(8);
            this.buG.setText(com.baidu.tieba.t.lbs_private);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bWm.c(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bWn.setVisibility(0);
                this.bWn.a(tShowInfo, tShowInfo.size(), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10));
            } else {
                this.bWn.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.l.fj(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.l.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bHV.setText(str);
                if (isMem != 0) {
                    ay.b(this.bHV, com.baidu.tieba.n.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                ay.i(this.bWo, com.baidu.tieba.p.icon_pop_boy);
            } else if (sex == 2) {
                ay.i(this.bWo, com.baidu.tieba.p.icon_pop_girl);
            } else {
                this.bWo.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bWq.setText(String.valueOf(tb_age) + this.bVg.getResources().getString(com.baidu.tieba.t.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bWr.a(iconInfo, iconInfo.size(), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10));
            if (userData.getHave_attention() == 1) {
                this.bWs.setText(com.baidu.tieba.t.attention_cancel);
            } else {
                this.bWs.setText(com.baidu.tieba.t.attention);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bWs.setVisibility(8);
            this.bWv.setVisibility(8);
            this.bWt.setVisibility(8);
            this.bWx.setVisibility(8);
        }
    }

    public LinearLayout aft() {
        return this.bWx;
    }

    public TextView afu() {
        return this.bWs;
    }

    public UserIconBox afv() {
        return this.bWn;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
