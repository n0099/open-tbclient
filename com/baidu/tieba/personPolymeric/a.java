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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes3.dex */
public class a implements f {
    private ImageView fHO;
    private ImageView fHP;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.fHP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fHP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHP.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.fHP.setLayoutParams(layoutParams);
        }
        this.fHO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHO.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fHO.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.fHO.setVisibility(0);
            return;
        }
        this.fHO.setVisibility(8);
        if (this.fHP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fHP.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fHP.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.fHO != null) {
            this.fHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (j.gP()) {
                        TiebaStatic.log(new al("c12503").ac("obj_locate", "2"));
                        b bVar = new b();
                        bVar.cKf = 9;
                        gVar.a(view2, bVar);
                    }
                }
            });
        }
        if (this.fHP != null) {
            this.fHP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12503").ac("obj_locate", "1"));
                    b bVar = new b();
                    bVar.cKf = 42;
                    bVar.cKg = new Bundle();
                    bVar.cKg.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view2, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void beP() {
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.fHO != null) {
            if (z) {
                ak.c(this.fHO, d.f.selector_topbar_more_black);
                ak.c(this.fHP, d.f.selector_topbar_chat_black);
            } else {
                ak.c(this.fHO, d.f.selector_topbar_more_white);
                ak.c(this.fHP, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fHO.setAlpha(f2);
                this.fHP.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.fHO != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.c(this.fHO, d.f.selector_topbar_more_white);
                ak.c(this.fHP, d.f.selector_topbar_chat_white);
                return;
            }
            ak.c(this.fHO, d.f.selector_topbar_more_black);
            ak.c(this.fHP, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
