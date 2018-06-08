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
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes3.dex */
public class a implements f {
    private ImageView fUn;
    private ImageView fUo;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.fUo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fUo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fUo.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.fUo.setLayoutParams(layoutParams);
        }
        this.fUn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fUn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fUn.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fUn.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.fUn.setVisibility(0);
            return;
        }
        this.fUn.setVisibility(8);
        if (this.fUo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fUo.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fUo.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.fUn != null) {
            this.fUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jD()) {
                        TiebaStatic.log(new am("c12503").ah("obj_locate", "2"));
                        b bVar = new b();
                        bVar.cUr = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.fUo != null) {
            this.fUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12503").ah("obj_locate", "1"));
                    b bVar = new b();
                    bVar.cUr = 42;
                    bVar.cUs = new Bundle();
                    bVar.cUs.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bjP() {
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.fUn != null) {
            if (z) {
                al.c(this.fUn, d.f.selector_topbar_more_black);
                al.c(this.fUo, d.f.selector_topbar_chat_black);
            } else {
                al.c(this.fUn, d.f.selector_topbar_more_white);
                al.c(this.fUo, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fUn.setAlpha(f2);
                this.fUo.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.fUn != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.c(this.fUn, d.f.selector_topbar_more_white);
                al.c(this.fUo, d.f.selector_topbar_chat_white);
                return;
            }
            al.c(this.fUn, d.f.selector_topbar_more_black);
            al.c(this.fUo, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
