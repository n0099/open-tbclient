package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h implements w {
    private ImageView fYc;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.fYc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.item_person_guess_navigation_more, (View.OnClickListener) null);
        this.fYc.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.fYc != null) {
            this.fYc.setOnClickListener(new i(this, mVar));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void bqQ() {
    }

    @Override // com.baidu.tieba.view.w
    public void T(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.w
    public void b(float f, boolean z) {
        float f2;
        if (this.fYc != null) {
            if (z) {
                av.b(this.fYc, r.f.icon_more_bg_s, r.f.icon_more_bg_s);
            } else {
                av.b(this.fYc, r.f.icon_more_bg, r.f.icon_more_bg);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fYc.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.fYc != null) {
            if (2 == i) {
                av.b(this.fYc, r.f.icon_more_bg_s, r.f.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                av.b(this.fYc, r.f.icon_more_bg, r.f.icon_more_bg);
            } else {
                av.b(this.fYc, r.f.icon_more_bg_s, r.f.icon_more_bg_s);
            }
        }
    }
}
