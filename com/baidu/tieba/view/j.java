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
public class j implements z {
    public ImageView fIA;
    private RelativeLayout fIB;
    private ImageView fIC;
    public ImageView fID;
    private PopupWindow fIE;
    private RelativeLayout fIy;
    private ImageView fIz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean fIF = false;
    private Handler mHandler = new Handler();
    private Runnable fzd = new k(this);
    private Runnable fze = new l(this);
    private View.OnClickListener fzf = new m(this);

    @Override // com.baidu.tieba.view.z
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fIy = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fIz = (ImageView) this.fIy.findViewById(w.h.person_navigation_dressup_img);
            this.fIA = (ImageView) this.fIy.findViewById(w.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fIB = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.fIC = (ImageView) this.fIB.findViewById(w.h.person_navigation_setting_img);
            this.fID = (ImageView) this.fIB.findViewById(w.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.z
    public void bkU() {
        if (this.fIB != null && this.fIB.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fIB, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.z
    public void setOnViewResponseListener(p pVar) {
        if (this.fIy != null) {
            this.fIy.setOnClickListener(new n(this));
        }
        if (this.fIB != null) {
            this.fIB.setOnClickListener(new o(this));
        }
    }

    @Override // com.baidu.tieba.view.z
    public void G(int i, boolean z) {
        if (i == 5 && this.fID != null) {
            this.fID.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fIA != null) {
            this.fIA.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.z
    public void onChangeSkinType(int i) {
        if (this.fIz != null) {
            if (2 == i) {
                aq.b(this.fIz, w.g.icon_person_dressup_s, w.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fIz, w.g.icon_person_dressup, w.g.icon_person_dressup);
            } else {
                aq.b(this.fIz, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fIA != null) {
                aq.c(this.fIA, w.g.icon_news_down_bar_one);
            }
        }
        if (this.fIC != null) {
            if (2 == i) {
                aq.b(this.fIC, w.g.icon_home_setting_s, w.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fIC, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            } else {
                aq.b(this.fIC, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
            if (this.fID != null) {
                aq.c(this.fID, w.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.z
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fIz != null) {
                aq.b(this.fIz, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fIC != null) {
                aq.b(this.fIC, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
        } else {
            if (this.fIz != null) {
                aq.b(this.fIz, w.g.icon_person_dressup, w.g.icon_person_dressup);
            }
            if (this.fIC != null) {
                aq.b(this.fIC, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fIz != null) {
                this.fIz.setAlpha(f2);
            }
            if (this.fIC != null) {
                this.fIC.setAlpha(f2);
            }
        }
    }

    public void aPO() {
        if (!this.fIF) {
            this.fIF = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.fIF) {
                View inflate = LayoutInflater.from(this.mContext).inflate(w.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(w.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                textView.setText(w.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.fzf);
                this.fIE = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fzd, 100L);
            }
        }
    }

    public void aPP() {
        this.mHandler.removeCallbacks(this.fzd);
        this.mHandler.removeCallbacks(this.fze);
        biF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biF() {
        com.baidu.adp.lib.g.j.a(this.fIE);
    }
}
