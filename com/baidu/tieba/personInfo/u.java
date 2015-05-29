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
    private View aYi;
    private TextView bHU;
    private PersonInfoActivity bVf;
    private BdExpandImageView bWh;
    private ImageView bWi;
    private float bWj = 360.0f;
    private RelativeLayout bWk;
    private HeadImageView bWl;
    private UserIconBox bWm;
    private ImageView bWn;
    private TextView bWo;
    private TextView bWp;
    private UserIconBox bWq;
    private TextView bWr;
    private LinearLayout bWs;
    private ImageView bWt;
    private LinearLayout bWu;
    private ImageView bWv;
    private LinearLayout bWw;
    private ImageView bWx;
    private TextView bbk;
    private TextView buF;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;

    public u(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_head_view, null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds372)));
        initView();
    }

    private void initView() {
        this.aYi = this.mRootView.findViewById(com.baidu.tieba.q.root);
        this.bWh = (BdExpandImageView) this.mRootView.findViewById(com.baidu.tieba.q.expand_image);
        this.bWi = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.refresh_image);
        this.bWk = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.head);
        this.bWl = (HeadImageView) this.mRootView.findViewById(com.baidu.tieba.q.user_head);
        this.bWm = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.q.user_vip_icon);
        this.bWm.setOnClickListener(this.bVf);
        this.bHU = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.user_name);
        this.bWn = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.user_sex);
        this.bWo = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.user_bar_age);
        this.bWp = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.user_bar_age_num);
        this.bWq = (UserIconBox) this.mRootView.findViewById(com.baidu.tieba.q.user_icon);
        this.bWq.setOnClickListener(this.bVf);
        this.bWr = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.btn_attention);
        this.bWr.setOnClickListener(this.bVf);
        this.bWt = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.iv_site);
        this.bWs = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.dis_time);
        this.bWu = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.time_ll);
        this.bWv = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.iv_time);
        this.buF = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.distance);
        this.bbk = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.time);
        this.bWw = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.my_gift_ll);
        this.bWw.setOnClickListener(this.bVf);
        this.bWx = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.my_gift);
        afo();
        afp();
    }

    public void afm() {
        com.baidu.tbadk.imageManager.e.Al().dN(1152000);
        for (int i = 0; i < 3; i++) {
            this.mBitmap = ay.g((Resources) null, com.baidu.tieba.p.bg_mycenter_banner);
            if (this.mBitmap != null) {
                this.bWh.setImageBitmap(this.mBitmap);
                return;
            }
        }
    }

    public void afn() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.bS(com.baidu.tieba.p.bg_mycenter_banner);
            System.gc();
        }
        this.bWh.setImageBitmap(null);
    }

    private void afo() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.bWw.setVisibility(0);
        } else {
            this.bWw.setVisibility(8);
        }
        if (this.mIsHost || TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bWw.setVisibility(8);
            this.bWr.setVisibility(8);
            this.bWs.setVisibility(8);
        }
    }

    public void oG() {
        ay.j(this.aYi, com.baidu.tieba.n.cp_bg_line_c);
        ay.b(this.bHU, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.bWo, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.bWp, com.baidu.tieba.n.cp_cont_g, 1);
        ay.i(this.bWw, com.baidu.tieba.p.personinfo_head_icon);
        ay.c(this.bWx, com.baidu.tieba.p.icon_mycenter_gift);
        ay.i(this.bWs, com.baidu.tieba.p.bg_mycenter_bar);
        ay.i((View) this.bWr, com.baidu.tieba.p.bg_mycenter_bar);
        ay.b(this.bWr, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.buF, com.baidu.tieba.n.cp_cont_g, 1);
        ay.b(this.bbk, com.baidu.tieba.n.cp_cont_g, 1);
        ay.i(this.bWt, com.baidu.tieba.p.icon_mycenter_bar_site);
        ay.i(this.bWv, com.baidu.tieba.p.icon_mycenter_bar_date);
    }

    private void afp() {
        this.bWl.setIsRound(true);
        this.bWl.setDrawBorder(false);
        this.bWl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bWl.setDefaultResource(com.baidu.tieba.p.pic_mycenter_avatar_def);
        this.bWl.setOnClickListener(this.bVf);
    }

    public HeadImageView afq() {
        return this.bWl;
    }

    public UserIconBox afr() {
        return this.bWq;
    }

    public void j(float f) {
        if (!this.bWi.isShown()) {
            this.bWi.setVisibility(0);
            this.bWi.setImageDrawable(this.bVf.getResources().getDrawable(com.baidu.tieba.p.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bWj, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bWi.startAnimation(rotateAnimation);
        this.bWj = f;
    }

    public void hideProgress() {
        this.bWi.clearAnimation();
        this.bWi.setImageDrawable(null);
        this.bWi.setVisibility(8);
    }

    public void nd() {
        if (!this.bWi.isShown()) {
            this.bWi.setVisibility(0);
            this.bWi.setImageDrawable(this.bVf.getResources().getDrawable(com.baidu.tieba.p.icon_pop_refresh));
        }
        this.bWi.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.k.user_info_center_head_rotate));
    }

    public void afl() {
        v aeT = this.bVf.aeT();
        UserData userData = aeT.getUserData();
        i(userData);
        d(aeT.afx(), userData);
    }

    private void d(PersonTainInfo personTainInfo, UserData userData) {
        com.baidu.tbadk.data.h personPrivate;
        if (personTainInfo != null) {
            int isFriend = personTainInfo.getIsFriend();
            int yP = (userData == null || (personPrivate = userData.getPersonPrivate()) == null) ? 1 : personPrivate.yP();
            if (yP == 1 || (yP == 2 && isFriend == 1)) {
                DistanceInfo distanceInfo = personTainInfo.getDistanceInfo();
                if (distanceInfo != null) {
                    String distance = distanceInfo.getDistance();
                    String timeFormat = distanceInfo.getTimeFormat();
                    this.buF.setText(distance);
                    this.bbk.setText(timeFormat);
                    return;
                }
                return;
            }
            this.bWu.setVisibility(8);
            this.buF.setText(com.baidu.tieba.t.lbs_private);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.bWl.c(portrait, 25, false);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                this.bWm.setVisibility(0);
                this.bWm.a(tShowInfo, tShowInfo.size(), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10));
            } else {
                this.bWm.setVisibility(8);
            }
            String name_show = userData.getName_show();
            String str = com.baidu.tbadk.util.l.fj(name_show) > 14 ? String.valueOf(com.baidu.tbadk.util.l.f(name_show, 0, 14)) + "..." : name_show;
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(str)) {
                this.bHU.setText(str);
                if (isMem != 0) {
                    ay.b(this.bHU, com.baidu.tieba.n.cp_other_b, 1);
                }
            }
            int sex = userData.getSex();
            if (sex == 1) {
                ay.i(this.bWn, com.baidu.tieba.p.icon_pop_boy);
            } else if (sex == 2) {
                ay.i(this.bWn, com.baidu.tieba.p.icon_pop_girl);
            } else {
                this.bWn.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.bWp.setText(String.valueOf(tb_age) + this.bVf.getResources().getString(com.baidu.tieba.t.user_info_center_head_viewpager_tb_age));
            }
            ArrayList<IconData> iconInfo = userData.getIconInfo();
            this.bWq.a(iconInfo, iconInfo.size(), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds34), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10));
            if (userData.getHave_attention() == 1) {
                this.bWr.setText(com.baidu.tieba.t.attention_cancel);
            } else {
                this.bWr.setText(com.baidu.tieba.t.attention);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bWr.setVisibility(8);
            this.bWu.setVisibility(8);
            this.bWs.setVisibility(8);
            this.bWw.setVisibility(8);
        }
    }

    public LinearLayout afs() {
        return this.bWw;
    }

    public TextView aft() {
        return this.bWr;
    }

    public UserIconBox afu() {
        return this.bWm;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
