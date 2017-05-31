package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h implements q {
    private ImageView byV;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.q
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.byV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.item_person_guess_navigation_more, (View.OnClickListener) null).findViewById(w.h.more_img);
        this.byV.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 4);
    }

    @Override // com.baidu.tieba.view.q
    public void setOnViewResponseListener(r rVar) {
        if (this.byV != null) {
            this.byV.setOnClickListener(new i(this, rVar));
        }
    }

    @Override // com.baidu.tieba.view.q
    public void TT() {
    }

    @Override // com.baidu.tieba.view.q
    public void l(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.q
    public void b(float f, boolean z) {
        float f2;
        if (this.byV != null) {
            if (z) {
                aq.j(this.byV, w.g.icon_more_bg_s);
            } else {
                aq.j(this.byV, w.g.icon_more_bg);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.byV.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public void onChangeSkinType(int i) {
        if (this.byV != null) {
            if (2 == i) {
                aq.b(this.byV, w.g.icon_more_bg_s, w.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aq.j(this.byV, w.g.icon_more_bg);
            } else {
                aq.j(this.byV, w.g.icon_more_bg_s);
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    /* renamed from: do  reason: not valid java name */
    public void mo19do(boolean z) {
    }
}
