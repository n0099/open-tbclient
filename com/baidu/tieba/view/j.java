package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements w {
    private RelativeLayout fJA;
    private ImageView fJB;
    public ImageView fJC;
    private RelativeLayout fJD;
    private ImageView fJE;
    public ImageView fJF;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fJA = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fJB = (ImageView) this.fJA.findViewById(w.h.person_navigation_dressup_img);
            this.fJC = (ImageView) this.fJA.findViewById(w.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fJD = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.fJE = (ImageView) this.fJD.findViewById(w.h.person_navigation_setting_img);
            this.fJF = (ImageView) this.fJD.findViewById(w.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bmn() {
        if (this.fJA != null && this.fJA.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fJA, (View.OnClickListener) null);
        }
        if (this.fJD != null && this.fJD.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fJD, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fJA != null) {
            this.fJA.setOnClickListener(new k(this));
        }
        if (this.fJD != null) {
            this.fJD.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void H(int i, boolean z) {
        if (i == 5 && this.fJF != null) {
            this.fJF.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fJC != null) {
            this.fJC.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fJB != null) {
            if (2 == i) {
                aq.b(this.fJB, w.g.icon_person_dressup_s, w.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fJB, w.g.icon_person_dressup, w.g.icon_person_dressup);
            } else {
                aq.b(this.fJB, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fJC != null) {
                aq.c(this.fJC, w.g.icon_news_down_bar_one);
            }
        }
        if (this.fJE != null) {
            if (2 == i) {
                aq.b(this.fJE, w.g.icon_home_setting_s, w.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fJE, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            } else {
                aq.b(this.fJE, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
            if (this.fJF != null) {
                aq.c(this.fJF, w.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fJB != null) {
                aq.b(this.fJB, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fJE != null) {
                aq.b(this.fJE, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
        } else {
            if (this.fJB != null) {
                aq.b(this.fJB, w.g.icon_person_dressup, w.g.icon_person_dressup);
            }
            if (this.fJE != null) {
                aq.b(this.fJE, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fJB != null) {
                this.fJB.setAlpha(f2);
            }
            if (this.fJE != null) {
                this.fJE.setAlpha(f2);
            }
        }
    }
}
