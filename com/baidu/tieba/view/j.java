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
    private RelativeLayout fLW;
    private ImageView fLX;
    public ImageView fLY;
    private RelativeLayout fLZ;
    private ImageView fMa;
    public ImageView fMb;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fLW = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fLX = (ImageView) this.fLW.findViewById(w.h.person_navigation_dressup_img);
            this.fLY = (ImageView) this.fLW.findViewById(w.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fLZ = (RelativeLayout) LayoutInflater.from(context).inflate(w.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.fMa = (ImageView) this.fLZ.findViewById(w.h.person_navigation_setting_img);
            this.fMb = (ImageView) this.fLZ.findViewById(w.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bno() {
        if (this.fLW != null && this.fLW.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fLW, (View.OnClickListener) null);
        }
        if (this.fLZ != null && this.fLZ.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fLZ, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fLW != null) {
            this.fLW.setOnClickListener(new k(this));
        }
        if (this.fLZ != null) {
            this.fLZ.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void H(int i, boolean z) {
        if (i == 5 && this.fMb != null) {
            this.fMb.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fLY != null) {
            this.fLY.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fLX != null) {
            if (2 == i) {
                aq.b(this.fLX, w.g.icon_person_dressup_s, w.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fLX, w.g.icon_person_dressup, w.g.icon_person_dressup);
            } else {
                aq.b(this.fLX, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fLY != null) {
                aq.c(this.fLY, w.g.icon_news_down_bar_one);
            }
        }
        if (this.fMa != null) {
            if (2 == i) {
                aq.b(this.fMa, w.g.icon_home_setting_s, w.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.fMa, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            } else {
                aq.b(this.fMa, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
            if (this.fMb != null) {
                aq.c(this.fMb, w.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fLX != null) {
                aq.b(this.fLX, w.g.icon_person_dressup_s, w.g.icon_person_dressup_s);
            }
            if (this.fMa != null) {
                aq.b(this.fMa, w.g.icon_home_setting_s, w.g.icon_home_setting_s);
            }
        } else {
            if (this.fLX != null) {
                aq.b(this.fLX, w.g.icon_person_dressup, w.g.icon_person_dressup);
            }
            if (this.fMa != null) {
                aq.b(this.fMa, w.g.icon_home_setting_w, w.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fLX != null) {
                this.fLX.setAlpha(f2);
            }
            if (this.fMa != null) {
                this.fMa.setAlpha(f2);
            }
        }
    }
}
