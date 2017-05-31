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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements q {
    private RelativeLayout fQr;
    private ImageView fQs;
    public ImageView fQt;
    private RelativeLayout fQu;
    private ImageView fQv;
    public ImageView fQw;
    private PopupWindow fQx;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean fQy = false;
    private Handler mHandler = new Handler();
    private Runnable fGY = new k(this);
    private Runnable fGZ = new l(this);
    private View.OnClickListener fHa = new m(this);

    @Override // com.baidu.tieba.view.q
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fQr = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fQs = (ImageView) this.fQr.findViewById(w.h.person_navigation_dressup_img);
            this.fQt = (ImageView) this.fQr.findViewById(w.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fQu = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.fQv = (ImageView) this.fQu.findViewById(w.h.person_navigation_setting_img);
            this.fQw = (ImageView) this.fQu.findViewById(w.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void TT() {
        if (this.fQu != null && this.fQu.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fQu, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void setOnViewResponseListener(r rVar) {
        if (this.fQr != null) {
            this.fQr.setOnClickListener(new n(this));
        }
        if (this.fQu != null) {
            this.fQu.setOnClickListener(new o(this));
        }
    }

    @Override // com.baidu.tieba.view.q
    public void l(int i, boolean z) {
        if (i == 5 && this.fQw != null) {
            this.fQw.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fQt != null) {
            this.fQt.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void onChangeSkinType(int i) {
        if (this.fQs != null) {
            if (2 == i) {
                aq.b(this.fQs, w.g.icon_person_dressup_s, w.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fQs, w.g.icon_person_dressup, w.g.icon_person_dressup);
            } else {
                aq.b(this.fQs, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fQt != null) {
                aq.c(this.fQt, w.g.icon_news_down_bar_one);
            }
        }
        if (this.fQv != null) {
            if (2 == i) {
                aq.b(this.fQv, w.g.icon_home_setting_s, w.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fQv, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            } else {
                aq.b(this.fQv, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
            if (this.fQw != null) {
                aq.c(this.fQw, w.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fQs != null) {
                aq.b(this.fQs, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fQv != null) {
                aq.b(this.fQv, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
        } else {
            if (this.fQs != null) {
                aq.b(this.fQs, w.g.icon_person_dressup, w.g.icon_person_dressup);
            }
            if (this.fQv != null) {
                aq.b(this.fQv, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fQs != null) {
                this.fQs.setAlpha(f2);
            }
            if (this.fQv != null) {
                this.fQv.setAlpha(f2);
            }
        }
    }

    public void Tv() {
        if (!this.fQy) {
            this.fQy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.fQy) {
                View inflate = LayoutInflater.from(this.mContext).inflate(w.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(w.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                textView.setText(w.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.fHa);
                this.fQx = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fGY, 100L);
            }
        }
    }

    public void Tw() {
        this.mHandler.removeCallbacks(this.fGY);
        this.mHandler.removeCallbacks(this.fGZ);
        bkd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkd() {
        com.baidu.adp.lib.g.j.a(this.fQx);
    }

    @Override // com.baidu.tieba.view.q
    /* renamed from: do */
    public void mo19do(boolean z) {
    }
}
