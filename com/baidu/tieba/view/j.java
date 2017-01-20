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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j implements w {
    private RelativeLayout fDq;
    private ImageView fDr;
    public ImageView fDs;
    private RelativeLayout fDt;
    private ImageView fDu;
    public ImageView fDv;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fDq = (RelativeLayout) LayoutInflater.from(context).inflate(r.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fDr = (ImageView) this.fDq.findViewById(r.h.person_navigation_dressup_img);
            this.fDs = (ImageView) this.fDq.findViewById(r.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fDt = (RelativeLayout) LayoutInflater.from(context).inflate(r.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.fDu = (ImageView) this.fDt.findViewById(r.h.person_navigation_setting_img);
            this.fDv = (ImageView) this.fDt.findViewById(r.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void blO() {
        if (this.fDq != null && this.fDq.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fDq, (View.OnClickListener) null);
        }
        if (this.fDt != null && this.fDt.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fDt, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fDq != null) {
            this.fDq.setOnClickListener(new k(this));
        }
        if (this.fDt != null) {
            this.fDt.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void G(int i, boolean z) {
        if (i == 5 && this.fDv != null) {
            this.fDv.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fDs != null) {
            this.fDs.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fDr != null) {
            if (2 == i) {
                ap.b(this.fDr, r.g.icon_person_dressup_s, r.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ap.b(this.fDr, r.g.icon_person_dressup, r.g.icon_person_dressup);
            } else {
                ap.b(this.fDr, r.g.icon_person_dressup_s, r.g.icon_person_dressup_s);
            }
            if (this.fDs != null) {
                ap.c(this.fDs, r.g.icon_news_down_bar_one);
            }
        }
        if (this.fDu != null) {
            if (2 == i) {
                ap.b(this.fDu, r.g.icon_home_setting_s, r.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ap.b(this.fDu, r.g.icon_home_setting_w, r.g.icon_home_setting_w);
            } else {
                ap.b(this.fDu, r.g.icon_home_setting_s, r.g.icon_home_setting_s);
            }
            if (this.fDv != null) {
                ap.c(this.fDv, r.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fDr != null) {
                ap.b(this.fDr, r.g.icon_person_dressup_s, r.g.icon_person_dressup_s);
            }
            if (this.fDu != null) {
                ap.b(this.fDu, r.g.icon_home_setting_s, r.g.icon_home_setting_s);
            }
        } else {
            if (this.fDr != null) {
                ap.b(this.fDr, r.g.icon_person_dressup, r.g.icon_person_dressup);
            }
            if (this.fDu != null) {
                ap.b(this.fDu, r.g.icon_home_setting_w, r.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fDr != null) {
                this.fDr.setAlpha(f2);
            }
            if (this.fDu != null) {
                this.fDu.setAlpha(f2);
            }
        }
    }
}
