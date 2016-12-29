package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h implements w {
    private ImageView fus;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.fus = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.item_person_guess_navigation_more, (View.OnClickListener) null);
        this.fus.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fus != null) {
            this.fus.setOnClickListener(new i(this, mVar));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bkk() {
    }

    @Override // com.baidu.tieba.view.w
    public void G(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (this.fus != null) {
            if (z) {
                ar.b(this.fus, r.f.icon_more_bg_s, r.f.icon_more_bg_s);
            } else {
                ar.b(this.fus, r.f.icon_more_bg, r.f.icon_more_bg);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fus.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fus != null) {
            if (2 == i) {
                ar.b(this.fus, r.f.icon_more_bg_s, r.f.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ar.b(this.fus, r.f.icon_more_bg, r.f.icon_more_bg);
            } else {
                ar.b(this.fus, r.f.icon_more_bg_s, r.f.icon_more_bg_s);
            }
        }
    }
}
