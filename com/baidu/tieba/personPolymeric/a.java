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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes3.dex */
public class a implements f {
    private ImageView gyF;
    private ImageView gyG;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.gyG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gyG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gyG.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds4);
            this.gyG.setLayoutParams(layoutParams);
        }
        this.gyF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.gyF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gyF.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds14);
            this.gyF.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.gyF.setVisibility(0);
            return;
        }
        this.gyF.setVisibility(8);
        if (this.gyG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gyG.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds14);
            this.gyG.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.gyF != null) {
            this.gyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kV()) {
                        TiebaStatic.log(new am("c12503").aA("obj_locate", "2"));
                        b bVar = new b();
                        bVar.dtB = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.gyG != null) {
            this.gyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12503").aA("obj_locate", "1"));
                    b bVar = new b();
                    bVar.dtB = 42;
                    bVar.dtC = new Bundle();
                    bVar.dtC.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bqw() {
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.gyF != null) {
            if (z) {
                al.c(this.gyF, e.f.selector_topbar_more_black);
                al.c(this.gyG, e.f.selector_topbar_chat_black);
            } else {
                al.c(this.gyF, e.f.selector_topbar_more_white);
                al.c(this.gyG, e.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.gyF.setAlpha(f2);
                this.gyG.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gyF != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.c(this.gyF, e.f.selector_topbar_more_white);
                al.c(this.gyG, e.f.selector_topbar_chat_white);
                return;
            }
            al.c(this.gyF, e.f.selector_topbar_more_black);
            al.c(this.gyG, e.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
