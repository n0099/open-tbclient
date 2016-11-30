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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j implements w {
    private RelativeLayout gfD;
    private ImageView gfE;
    public ImageView gfF;
    private RelativeLayout gfG;
    private ImageView gfH;
    public ImageView gfI;
    private Context mContext;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.gfD = (RelativeLayout) LayoutInflater.from(context).inflate(r.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gfE = (ImageView) this.gfD.findViewById(r.g.person_navigation_dressup_img);
            this.gfF = (ImageView) this.gfD.findViewById(r.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.gfG = (RelativeLayout) LayoutInflater.from(context).inflate(r.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.gfH = (ImageView) this.gfG.findViewById(r.g.person_navigation_setting_img);
            this.gfI = (ImageView) this.gfG.findViewById(r.g.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void btj() {
        if (this.gfD != null && this.gfD.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gfD, (View.OnClickListener) null);
        }
        if (this.gfG != null && this.gfG.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gfG, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.gfD != null) {
            this.gfD.setOnClickListener(new k(this));
        }
        if (this.gfG != null) {
            this.gfG.setOnClickListener(new l(this));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void W(int i, boolean z) {
        if (i == 5 && this.gfI != null) {
            this.gfI.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gfF != null) {
            this.gfF.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.gfE != null) {
            if (2 == i) {
                at.b(this.gfE, r.f.icon_person_dressup_s, r.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                at.b(this.gfE, r.f.icon_person_dressup, r.f.icon_person_dressup);
            } else {
                at.b(this.gfE, r.f.icon_person_dressup_s, r.f.icon_person_dressup_s);
            }
            if (this.gfF != null) {
                at.c(this.gfF, r.f.icon_news_down_bar_one);
            }
        }
        if (this.gfH != null) {
            if (2 == i) {
                at.b(this.gfH, r.f.icon_home_setting_s, r.f.icon_home_setting);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                at.b(this.gfH, r.f.icon_home_setting_w, r.f.icon_home_setting_w);
            } else {
                at.b(this.gfH, r.f.icon_home_setting_s, r.f.icon_home_setting_s);
            }
            if (this.gfI != null) {
                at.c(this.gfI, r.f.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gfE != null) {
                at.b(this.gfE, r.f.icon_person_dressup_s, r.f.icon_person_dressup_s);
            }
            if (this.gfH != null) {
                at.b(this.gfH, r.f.icon_home_setting_s, r.f.icon_home_setting_s);
            }
        } else {
            if (this.gfE != null) {
                at.b(this.gfE, r.f.icon_person_dressup, r.f.icon_person_dressup);
            }
            if (this.gfH != null) {
                at.b(this.gfH, r.f.icon_home_setting_w, r.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gfE != null) {
                this.gfE.setAlpha(f2);
            }
            if (this.gfH != null) {
                this.gfH.setAlpha(f2);
            }
        }
    }
}
