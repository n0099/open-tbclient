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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j implements w {
    public ImageView fuA;
    private RelativeLayout fuv;
    private ImageView fuw;
    public ImageView fux;
    private RelativeLayout fuy;
    private ImageView fuz;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fuv = (RelativeLayout) LayoutInflater.from(context).inflate(r.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fuw = (ImageView) this.fuv.findViewById(r.g.person_navigation_dressup_img);
            this.fux = (ImageView) this.fuv.findViewById(r.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fuy = (RelativeLayout) LayoutInflater.from(context).inflate(r.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.fuz = (ImageView) this.fuy.findViewById(r.g.person_navigation_setting_img);
            this.fuA = (ImageView) this.fuy.findViewById(r.g.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bkk() {
        if (this.fuv != null && this.fuv.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fuv, (View.OnClickListener) null);
        }
        if (this.fuy != null && this.fuy.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fuy, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fuv != null) {
            this.fuv.setOnClickListener(new k(this));
        }
        if (this.fuy != null) {
            this.fuy.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void G(int i, boolean z) {
        if (i == 5 && this.fuA != null) {
            this.fuA.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fux != null) {
            this.fux.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fuw != null) {
            if (2 == i) {
                ar.b(this.fuw, r.f.icon_person_dressup_s, r.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ar.b(this.fuw, r.f.icon_person_dressup, r.f.icon_person_dressup);
            } else {
                ar.b(this.fuw, r.f.icon_person_dressup_s, r.f.icon_person_dressup_s);
            }
            if (this.fux != null) {
                ar.c(this.fux, r.f.icon_news_down_bar_one);
            }
        }
        if (this.fuz != null) {
            if (2 == i) {
                ar.b(this.fuz, r.f.icon_home_setting_s, r.f.icon_home_setting);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ar.b(this.fuz, r.f.icon_home_setting_w, r.f.icon_home_setting_w);
            } else {
                ar.b(this.fuz, r.f.icon_home_setting_s, r.f.icon_home_setting_s);
            }
            if (this.fuA != null) {
                ar.c(this.fuA, r.f.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fuw != null) {
                ar.b(this.fuw, r.f.icon_person_dressup_s, r.f.icon_person_dressup_s);
            }
            if (this.fuz != null) {
                ar.b(this.fuz, r.f.icon_home_setting_s, r.f.icon_home_setting_s);
            }
        } else {
            if (this.fuw != null) {
                ar.b(this.fuw, r.f.icon_person_dressup, r.f.icon_person_dressup);
            }
            if (this.fuz != null) {
                ar.b(this.fuz, r.f.icon_home_setting_w, r.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fuw != null) {
                this.fuw.setAlpha(f2);
            }
            if (this.fuz != null) {
                this.fuz.setAlpha(f2);
            }
        }
    }
}
