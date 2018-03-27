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
    private ImageView gnr;
    private ImageView gns;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.gns = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gns.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gns.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.gns.setLayoutParams(layoutParams);
        }
        this.gnr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gnr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gnr.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gnr.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.gnr.setVisibility(0);
            return;
        }
        this.gnr.setVisibility(8);
        if (this.gns.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gns.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.gns.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(final i iVar) {
        if (this.gnr != null) {
            this.gnr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oJ()) {
                        TiebaStatic.log(new ak("c12503").ab("obj_locate", "2"));
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.dro = 9;
                        iVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.gns != null) {
            this.gns.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12503").ab("obj_locate", "1"));
                    com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                    bVar.dro = 42;
                    bVar.drp = new Bundle();
                    bVar.drp.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    iVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void bjN() {
    }

    @Override // com.baidu.tieba.view.h
    public void Q(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (this.gnr != null) {
            if (z) {
                aj.c(this.gnr, d.f.selector_topbar_more_black);
                aj.c(this.gns, d.f.selector_topbar_chat_black);
            } else {
                aj.c(this.gnr, d.f.selector_topbar_more_white);
                aj.c(this.gns, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.gnr.setAlpha(f2);
                this.gns.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.gnr != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.c(this.gnr, d.f.selector_topbar_more_white);
                aj.c(this.gns, d.f.selector_topbar_chat_white);
                return;
            }
            aj.c(this.gnr, d.f.selector_topbar_more_black);
            aj.c(this.gns, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
