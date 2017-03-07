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
    private RelativeLayout fHR;
    private ImageView fHS;
    public ImageView fHT;
    private RelativeLayout fHU;
    private ImageView fHV;
    public ImageView fHW;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fHR = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fHS = (ImageView) this.fHR.findViewById(w.h.person_navigation_dressup_img);
            this.fHT = (ImageView) this.fHR.findViewById(w.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fHU = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.fHV = (ImageView) this.fHU.findViewById(w.h.person_navigation_setting_img);
            this.fHW = (ImageView) this.fHU.findViewById(w.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void blD() {
        if (this.fHR != null && this.fHR.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fHR, (View.OnClickListener) null);
        }
        if (this.fHU != null && this.fHU.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fHU, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fHR != null) {
            this.fHR.setOnClickListener(new k(this));
        }
        if (this.fHU != null) {
            this.fHU.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void H(int i, boolean z) {
        if (i == 5 && this.fHW != null) {
            this.fHW.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fHT != null) {
            this.fHT.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fHS != null) {
            if (2 == i) {
                aq.b(this.fHS, w.g.icon_person_dressup_s, w.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fHS, w.g.icon_person_dressup, w.g.icon_person_dressup);
            } else {
                aq.b(this.fHS, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fHT != null) {
                aq.c(this.fHT, w.g.icon_news_down_bar_one);
            }
        }
        if (this.fHV != null) {
            if (2 == i) {
                aq.b(this.fHV, w.g.icon_home_setting_s, w.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fHV, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            } else {
                aq.b(this.fHV, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
            if (this.fHW != null) {
                aq.c(this.fHW, w.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fHS != null) {
                aq.b(this.fHS, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fHV != null) {
                aq.b(this.fHV, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
        } else {
            if (this.fHS != null) {
                aq.b(this.fHS, w.g.icon_person_dressup, w.g.icon_person_dressup);
            }
            if (this.fHV != null) {
                aq.b(this.fHV, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fHS != null) {
                this.fHS.setAlpha(f2);
            }
            if (this.fHV != null) {
                this.fHV.setAlpha(f2);
            }
        }
    }
}
