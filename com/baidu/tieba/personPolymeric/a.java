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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.view.h;
import com.baidu.tieba.view.i;
/* loaded from: classes3.dex */
public class a implements h {
    private ImageView gnb;
    private ImageView gnc;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.gnc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gnc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnc.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.gnc.setLayoutParams(layoutParams);
        }
        this.gnb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gnb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gnb.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gnb.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.gnb.setVisibility(0);
            return;
        }
        this.gnb.setVisibility(8);
        if (this.gnc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gnc.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gnc.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(final i iVar) {
        if (this.gnb != null) {
            this.gnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oJ()) {
                        TiebaStatic.log(new ak("c12503").ab("obj_locate", "2"));
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.drl = 9;
                        iVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.gnc != null) {
            this.gnc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12503").ab("obj_locate", "1"));
                    com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                    bVar.drl = 42;
                    bVar.drm = new Bundle();
                    bVar.drm.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    iVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void bjM() {
    }

    @Override // com.baidu.tieba.view.h
    public void Q(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (this.gnb != null) {
            if (z) {
                aj.c(this.gnb, d.f.selector_topbar_more_black);
                aj.c(this.gnc, d.f.selector_topbar_chat_black);
            } else {
                aj.c(this.gnb, d.f.selector_topbar_more_white);
                aj.c(this.gnc, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.gnb.setAlpha(f2);
                this.gnc.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.gnb != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.c(this.gnb, d.f.selector_topbar_more_white);
                aj.c(this.gnc, d.f.selector_topbar_chat_white);
                return;
            }
            aj.c(this.gnb, d.f.selector_topbar_more_black);
            aj.c(this.gnc, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
