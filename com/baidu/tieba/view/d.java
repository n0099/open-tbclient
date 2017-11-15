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
    private ImageView gNn;
    private ImageView gNo;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.g
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.gNo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gNo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gNo.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.gNo.setLayoutParams(layoutParams);
        }
        this.gNn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gNn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gNn.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gNn.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.gNn.setVisibility(0);
            return;
        }
        this.gNn.setVisibility(8);
        if (this.gNo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gNo.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gNo.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(final h hVar) {
        if (this.gNn != null) {
            this.gNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.hh()) {
                        TiebaStatic.log(new ak("c12503").ac("obj_locate", "2"));
                        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                        aVar.cmv = 9;
                        hVar.a(view, aVar);
                    }
                }
            });
        }
        if (this.gNo != null) {
            this.gNo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12503").ac("obj_locate", "1"));
                    com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                    aVar.cmv = 42;
                    aVar.cmw = new Bundle();
                    aVar.cmw.putSerializable(UserData.TYPE_USER, d.this.mUserData);
                    hVar.a(view, aVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.g
    public void bBu() {
    }

    @Override // com.baidu.tieba.view.g
    public void A(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.g
    public void c(float f, boolean z) {
        float f2;
        if (this.gNn != null) {
            if (z) {
                aj.c(this.gNn, d.f.selector_topbar_more_black);
                aj.c(this.gNo, d.f.selector_topbar_chat_black);
            } else {
                aj.c(this.gNn, d.f.selector_topbar_more_white);
                aj.c(this.gNo, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.gNn.setAlpha(f2);
                this.gNo.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.gNn != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.c(this.gNn, d.f.selector_topbar_more_white);
                aj.c(this.gNo, d.f.selector_topbar_chat_white);
                return;
            }
            aj.c(this.gNn, d.f.selector_topbar_more_black);
            aj.c(this.gNo, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void f(UserData userData) {
        this.mUserData = userData;
    }
}
