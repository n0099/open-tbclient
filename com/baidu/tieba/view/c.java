package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements f {
    private ImageView bJD;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.bJD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.item_person_guess_navigation_more, (View.OnClickListener) null).findViewById(d.h.more_img);
        this.bJD.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 4);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.bJD != null) {
            this.bJD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                    aVar.ceT = 9;
                    gVar.a(view, aVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void XB() {
    }

    @Override // com.baidu.tieba.view.f
    public void l(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (this.bJD != null) {
            if (z) {
                aj.j(this.bJD, d.g.icon_more_bg_s);
            } else {
                aj.j(this.bJD, d.g.icon_more_bg);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.bJD.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.bJD != null) {
            if (2 == i) {
                aj.a(this.bJD, d.g.icon_more_bg_s, d.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.j(this.bJD, d.g.icon_more_bg);
            } else {
                aj.j(this.bJD, d.g.icon_more_bg_s);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void dF(boolean z) {
    }
}
