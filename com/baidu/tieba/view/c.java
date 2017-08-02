package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements f {
    private ImageView bDY;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.bDY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.item_person_guess_navigation_more, (View.OnClickListener) null).findViewById(d.h.more_img);
        this.bDY.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 4);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.bDY != null) {
            this.bDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                    aVar.bZr = 9;
                    gVar.a(view, aVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void VP() {
    }

    @Override // com.baidu.tieba.view.f
    public void m(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (this.bDY != null) {
            if (z) {
                ai.j(this.bDY, d.g.icon_more_bg_s);
            } else {
                ai.j(this.bDY, d.g.icon_more_bg);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.bDY.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.bDY != null) {
            if (2 == i) {
                ai.b(this.bDY, d.g.icon_more_bg_s, d.g.icon_more_bg);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.j(this.bDY, d.g.icon_more_bg);
            } else {
                ai.j(this.bDY, d.g.icon_more_bg_s);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void dA(boolean z) {
    }
}
