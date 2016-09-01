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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j implements w {
    private RelativeLayout fWd;
    private ImageView fWe;
    public ImageView fWf;
    private RelativeLayout fWg;
    private ImageView fWh;
    public ImageView fWi;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fWd = (RelativeLayout) LayoutInflater.from(context).inflate(t.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fWe = (ImageView) this.fWd.findViewById(t.g.person_navigation_dressup_img);
            this.fWf = (ImageView) this.fWd.findViewById(t.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fWg = (RelativeLayout) LayoutInflater.from(context).inflate(t.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.fWh = (ImageView) this.fWg.findViewById(t.g.person_navigation_setting_img);
            this.fWi = (ImageView) this.fWg.findViewById(t.g.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bqm() {
        if (this.fWd != null && this.fWd.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fWd, (View.OnClickListener) null);
        }
        if (this.fWg != null && this.fWg.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fWg, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fWd != null) {
            this.fWd.setOnClickListener(new k(this));
        }
        if (this.fWg != null) {
            this.fWg.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void T(int i, boolean z) {
        if (i == 5 && this.fWi != null) {
            this.fWi.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fWf != null) {
            this.fWf.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fWe != null) {
            if (2 == i) {
                av.b(this.fWe, t.f.icon_person_dressup_s, t.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                av.b(this.fWe, t.f.icon_person_dressup_w, t.f.icon_person_dressup_w);
            } else {
                av.b(this.fWe, t.f.icon_person_dressup_s, t.f.icon_person_dressup_s);
            }
            if (this.fWf != null) {
                av.c(this.fWf, t.f.icon_news_down_bar_one);
            }
        }
        if (this.fWh != null) {
            if (2 == i) {
                av.b(this.fWh, t.f.icon_home_setting_s, t.f.icon_home_setting);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                av.b(this.fWh, t.f.icon_home_setting_w, t.f.icon_home_setting_w);
            } else {
                av.b(this.fWh, t.f.icon_home_setting_s, t.f.icon_home_setting_s);
            }
            if (this.fWi != null) {
                av.c(this.fWi, t.f.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fWe != null) {
                av.b(this.fWe, t.f.icon_person_dressup_s, t.f.icon_person_dressup_s);
            }
            if (this.fWh != null) {
                av.b(this.fWh, t.f.icon_home_setting_s, t.f.icon_home_setting_s);
            }
        } else {
            if (this.fWe != null) {
                av.b(this.fWe, t.f.icon_person_dressup_w, t.f.icon_person_dressup_w);
            }
            if (this.fWh != null) {
                av.b(this.fWh, t.f.icon_home_setting_w, t.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fWe != null) {
                this.fWe.setAlpha(f2);
            }
            if (this.fWh != null) {
                this.fWh.setAlpha(f2);
            }
        }
    }
}
