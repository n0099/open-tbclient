package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h implements q {
    private ImageView bzR;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.q
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.bzR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.item_person_guess_navigation_more, (View.OnClickListener) null).findViewById(w.h.more_img);
        this.bzR.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 4);
    }

    @Override // com.baidu.tieba.view.q
    public void setOnViewResponseListener(r rVar) {
        if (this.bzR != null) {
            this.bzR.setOnClickListener(new i(this, rVar));
        }
    }

    @Override // com.baidu.tieba.view.q
    public void Vi() {
    }

    @Override // com.baidu.tieba.view.q
    public void l(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.q
    public void b(float f, boolean z) {
        float f2;
        if (this.bzR != null) {
            if (z) {
                as.j(this.bzR, w.g.icon_more_bg_s);
            } else {
                as.j(this.bzR, w.g.icon_more_bg);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.bzR.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public void onChangeSkinType(int i) {
        if (this.bzR != null) {
            if (2 == i) {
                as.b(this.bzR, w.g.icon_more_bg_s, w.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                as.j(this.bzR, w.g.icon_more_bg);
            } else {
                as.j(this.bzR, w.g.icon_more_bg_s);
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public void dr(boolean z) {
    }
}
