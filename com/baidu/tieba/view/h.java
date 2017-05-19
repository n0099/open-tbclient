package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h implements z {
    private ImageView bBy;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.z
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.bBy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.item_person_guess_navigation_more, (View.OnClickListener) null);
        this.bBy.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 4);
    }

    @Override // com.baidu.tieba.view.z
    public void setOnViewResponseListener(p pVar) {
        if (this.bBy != null) {
            this.bBy.setOnClickListener(new i(this, pVar));
        }
    }

    @Override // com.baidu.tieba.view.z
    public void bkU() {
    }

    @Override // com.baidu.tieba.view.z
    public void G(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.z
    public void c(float f, boolean z) {
        float f2;
        if (this.bBy != null) {
            if (z) {
                aq.b(this.bBy, w.g.icon_more_bg_s, w.g.icon_more_bg);
            } else {
                aq.b(this.bBy, w.g.icon_more_bg, w.g.icon_more_bg_person);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.bBy.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.z
    public void onChangeSkinType(int i) {
        if (this.bBy != null) {
            if (2 == i) {
                aq.b(this.bBy, w.g.icon_more_bg_s, w.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.bBy, w.g.icon_more_bg, w.g.icon_more_bg_s);
            } else {
                aq.b(this.bBy, w.g.icon_more_bg_s, w.g.icon_more_bg_person);
            }
        }
    }
}
