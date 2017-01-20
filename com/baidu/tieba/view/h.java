package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h implements w {
    private ImageView bsj;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.w
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.bsj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.item_person_guess_navigation_more, (View.OnClickListener) null);
        this.bsj.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.w
    public void setOnViewResponseListener(m mVar) {
        if (this.bsj != null) {
            this.bsj.setOnClickListener(new i(this, mVar));
        }
    }

    @Override // com.baidu.tieba.view.w
    public void blO() {
    }

    @Override // com.baidu.tieba.view.w
    public void G(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.w
    public void c(float f, boolean z) {
        float f2;
        if (this.bsj != null) {
            if (z) {
                ap.b(this.bsj, r.g.icon_more_bg_s, r.g.icon_more_bg);
            } else {
                ap.b(this.bsj, r.g.icon_more_bg, r.g.icon_more_bg_person);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.bsj.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        if (this.bsj != null) {
            if (2 == i) {
                ap.b(this.bsj, r.g.icon_more_bg_s, r.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ap.b(this.bsj, r.g.icon_more_bg, r.g.icon_more_bg_s);
            } else {
                ap.b(this.bsj, r.g.icon_more_bg_s, r.g.icon_more_bg_person);
            }
        }
    }
}
