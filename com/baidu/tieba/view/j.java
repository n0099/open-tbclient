package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements q {
    private RelativeLayout gai;
    private ImageView gaj;
    public ImageView gak;
    private RelativeLayout gal;
    private ImageView gam;
    public ImageView gan;
    private PopupWindow gao;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean gap = false;
    private Handler mHandler = new Handler();
    private Runnable fQP = new k(this);
    private Runnable fQQ = new l(this);
    private View.OnClickListener fQR = new m(this);

    @Override // com.baidu.tieba.view.q
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.gai = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gaj = (ImageView) this.gai.findViewById(w.h.person_navigation_dressup_img);
            this.gak = (ImageView) this.gai.findViewById(w.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.gal = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.gam = (ImageView) this.gal.findViewById(w.h.person_navigation_setting_img);
            this.gan = (ImageView) this.gal.findViewById(w.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void Vi() {
        if (this.gal != null && this.gal.getParent() == null) {
            this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gal, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void setOnViewResponseListener(r rVar) {
        if (this.gai != null) {
            this.gai.setOnClickListener(new n(this));
        }
        if (this.gal != null) {
            this.gal.setOnClickListener(new o(this));
        }
    }

    @Override // com.baidu.tieba.view.q
    public void l(int i, boolean z) {
        if (i == 5 && this.gan != null) {
            this.gan.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gak != null) {
            this.gak.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void onChangeSkinType(int i) {
        if (this.gaj != null) {
            if (2 == i) {
                as.b(this.gaj, w.g.icon_person_dressup_s, w.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                as.b(this.gaj, w.g.icon_person_dressup, w.g.icon_person_dressup);
            } else {
                as.b(this.gaj, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.gak != null) {
                as.c(this.gak, w.g.icon_news_down_bar_one);
            }
        }
        if (this.gam != null) {
            if (2 == i) {
                as.b(this.gam, w.g.icon_home_setting_s, w.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                as.b(this.gam, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            } else {
                as.b(this.gam, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
            if (this.gan != null) {
                as.c(this.gan, w.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gaj != null) {
                as.b(this.gaj, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.gam != null) {
                as.b(this.gam, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
        } else {
            if (this.gaj != null) {
                as.b(this.gaj, w.g.icon_person_dressup, w.g.icon_person_dressup);
            }
            if (this.gam != null) {
                as.b(this.gam, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gaj != null) {
                this.gaj.setAlpha(f2);
            }
            if (this.gam != null) {
                this.gam.setAlpha(f2);
            }
        }
    }

    public void aVs() {
        if (!this.gap) {
            this.gap = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gap) {
                View inflate = LayoutInflater.from(this.mContext).inflate(w.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(w.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                textView.setText(w.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.fQR);
                this.gao = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fQP);
                this.mHandler.postDelayed(this.fQP, 100L);
            }
        }
    }

    public void aVt() {
        this.mHandler.removeCallbacks(this.fQP);
        this.mHandler.removeCallbacks(this.fQQ);
        boq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        com.baidu.adp.lib.g.j.a(this.gao);
    }

    @Override // com.baidu.tieba.view.q
    public void dr(boolean z) {
    }
}
