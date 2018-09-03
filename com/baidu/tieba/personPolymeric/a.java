package com.baidu.tieba.personPolymeric;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes3.dex */
public class a implements f {
    private ImageView fYG;
    private ImageView fYH;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.fYH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.fYH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYH.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(f.e.ds4);
            this.fYH.setLayoutParams(layoutParams);
        }
        this.fYG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.fYG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fYG.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(f.e.ds14);
            this.fYG.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.fYG.setVisibility(0);
            return;
        }
        this.fYG.setVisibility(8);
        if (this.fYH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fYH.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(f.e.ds14);
            this.fYH.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.fYG != null) {
            this.fYG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jE()) {
                        TiebaStatic.log(new an("c12503").ae("obj_locate", "2"));
                        b bVar = new b();
                        bVar.cVc = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.fYH != null) {
            this.fYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12503").ae("obj_locate", "1"));
                    b bVar = new b();
                    bVar.cVc = 42;
                    bVar.cVd = new Bundle();
                    bVar.cVd.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void biL() {
    }

    @Override // com.baidu.tieba.view.f
    public void B(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.fYG != null) {
            if (z) {
                am.c(this.fYG, f.C0146f.selector_topbar_more_black);
                am.c(this.fYH, f.C0146f.selector_topbar_chat_black);
            } else {
                am.c(this.fYG, f.C0146f.selector_topbar_more_white);
                am.c(this.fYH, f.C0146f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fYG.setAlpha(f2);
                this.fYH.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.fYG != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.c(this.fYG, f.C0146f.selector_topbar_more_white);
                am.c(this.fYH, f.C0146f.selector_topbar_chat_white);
                return;
            }
            am.c(this.fYG, f.C0146f.selector_topbar_more_black);
            am.c(this.fYH, f.C0146f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
