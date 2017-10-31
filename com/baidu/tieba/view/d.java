package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d implements g {
    private ImageView gMf;
    private ImageView gMg;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.g
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.gMg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gMg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMg.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.gMg.setLayoutParams(layoutParams);
        }
        this.gMf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gMf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gMf.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gMf.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.gMf.setVisibility(0);
            return;
        }
        this.gMf.setVisibility(8);
        if (this.gMg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gMg.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gMg.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(final h hVar) {
        if (this.gMf != null) {
            this.gMf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.hh()) {
                        TiebaStatic.log(new ak("c12503").ac("obj_locate", "2"));
                        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                        aVar.cmb = 9;
                        hVar.a(view, aVar);
                    }
                }
            });
        }
        if (this.gMg != null) {
            this.gMg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12503").ac("obj_locate", "1"));
                    com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                    aVar.cmb = 42;
                    aVar.cmc = new Bundle();
                    aVar.cmc.putSerializable(UserData.TYPE_USER, d.this.mUserData);
                    hVar.a(view, aVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.g
    public void bBi() {
    }

    @Override // com.baidu.tieba.view.g
    public void z(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.g
    public void c(float f, boolean z) {
        float f2;
        if (this.gMf != null) {
            if (z) {
                aj.c(this.gMf, d.f.selector_topbar_more_black);
                aj.c(this.gMg, d.f.selector_topbar_chat_black);
            } else {
                aj.c(this.gMf, d.f.selector_topbar_more_white);
                aj.c(this.gMg, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.gMf.setAlpha(f2);
                this.gMg.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.gMf != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.c(this.gMf, d.f.selector_topbar_more_white);
                aj.c(this.gMg, d.f.selector_topbar_chat_white);
                return;
            }
            aj.c(this.gMf, d.f.selector_topbar_more_black);
            aj.c(this.gMg, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void f(UserData userData) {
        this.mUserData = userData;
    }
}
