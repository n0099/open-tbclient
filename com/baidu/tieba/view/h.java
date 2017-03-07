package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h implements w {
    private ImageView bzn;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.bzn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.item_person_guess_navigation_more, (View.OnClickListener) null);
        this.bzn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.bzn != null) {
            this.bzn.setOnClickListener(new i(this, mVar));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void blD() {
    }

    @Override // com.baidu.tieba.view.w
    public void H(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (this.bzn != null) {
            if (z) {
                aq.b(this.bzn, w.g.icon_more_bg_s, w.g.icon_more_bg);
            } else {
                aq.b(this.bzn, w.g.icon_more_bg, w.g.icon_more_bg_person);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.bzn.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.bzn != null) {
            if (2 == i) {
                aq.b(this.bzn, w.g.icon_more_bg_s, w.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.b(this.bzn, w.g.icon_more_bg, w.g.icon_more_bg_s);
            } else {
                aq.b(this.bzn, w.g.icon_more_bg_s, w.g.icon_more_bg_person);
            }
        }
    }
}
