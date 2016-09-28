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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j implements w {
    private RelativeLayout fYi;
    private ImageView fYj;
    public ImageView fYk;
    private RelativeLayout fYl;
    private ImageView fYm;
    public ImageView fYn;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.fYi = (RelativeLayout) LayoutInflater.from(context).inflate(r.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.fYj = (ImageView) this.fYi.findViewById(r.g.person_navigation_dressup_img);
            this.fYk = (ImageView) this.fYi.findViewById(r.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.fYl = (RelativeLayout) LayoutInflater.from(context).inflate(r.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.fYm = (ImageView) this.fYl.findViewById(r.g.person_navigation_setting_img);
            this.fYn = (ImageView) this.fYl.findViewById(r.g.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bqQ() {
        if (this.fYi != null && this.fYi.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fYi, (View.OnClickListener) null);
        }
        if (this.fYl != null && this.fYl.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fYl, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fYi != null) {
            this.fYi.setOnClickListener(new k(this));
        }
        if (this.fYl != null) {
            this.fYl.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void T(int i, boolean z) {
        if (i == 5 && this.fYn != null) {
            this.fYn.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.fYk != null) {
            this.fYk.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fYj != null) {
            if (2 == i) {
                av.b(this.fYj, r.f.icon_person_dressup_s, r.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                av.b(this.fYj, r.f.icon_person_dressup_w, r.f.icon_person_dressup_w);
            } else {
                av.b(this.fYj, r.f.icon_person_dressup_s, r.f.icon_person_dressup_s);
            }
            if (this.fYk != null) {
                av.c(this.fYk, r.f.icon_news_down_bar_one);
            }
        }
        if (this.fYm != null) {
            if (2 == i) {
                av.b(this.fYm, r.f.icon_home_setting_s, r.f.icon_home_setting);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                av.b(this.fYm, r.f.icon_home_setting_w, r.f.icon_home_setting_w);
            } else {
                av.b(this.fYm, r.f.icon_home_setting_s, r.f.icon_home_setting_s);
            }
            if (this.fYn != null) {
                av.c(this.fYn, r.f.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.fYj != null) {
                av.b(this.fYj, r.f.icon_person_dressup_s, r.f.icon_person_dressup_s);
            }
            if (this.fYm != null) {
                av.b(this.fYm, r.f.icon_home_setting_s, r.f.icon_home_setting_s);
            }
        } else {
            if (this.fYj != null) {
                av.b(this.fYj, r.f.icon_person_dressup_w, r.f.icon_person_dressup_w);
            }
            if (this.fYm != null) {
                av.b(this.fYm, r.f.icon_home_setting_w, r.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.fYj != null) {
                this.fYj.setAlpha(f2);
            }
            if (this.fYm != null) {
                this.fYm.setAlpha(f2);
            }
        }
    }
}
