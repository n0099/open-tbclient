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
/* loaded from: classes6.dex */
public class a implements f {
    private ImageView hPw;
    private ImageView hPx;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.hPx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.hPx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPx.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.hPx.setLayoutParams(layoutParams);
        }
        this.hPw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.hPw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hPw.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.hPw.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.hPw.setVisibility(0);
            return;
        }
        this.hPw.setVisibility(8);
        if (this.hPx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hPx.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.hPx.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.hPw != null) {
            this.hPw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kY()) {
                        TiebaStatic.log(new am("c12503").bJ("obj_locate", "2"));
                        b bVar = new b();
                        bVar.eHl = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.hPx != null) {
            this.hPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12503").bJ("obj_locate", "1"));
                    b bVar = new b();
                    bVar.eHl = 42;
                    bVar.eHm = new Bundle();
                    bVar.eHm.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bRy() {
    }

    @Override // com.baidu.tieba.view.f
    public void I(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.hPw != null) {
            if (z) {
                al.c(this.hPw, d.f.selector_topbar_more_black);
                al.c(this.hPx, d.f.selector_topbar_chat_black);
            } else {
                al.c(this.hPw, d.f.selector_topbar_more_white);
                al.c(this.hPx, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.hPw.setAlpha(f2);
                this.hPx.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hPw != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.c(this.hPw, d.f.selector_topbar_more_white);
                al.c(this.hPx, d.f.selector_topbar_chat_white);
                return;
            }
            al.c(this.hPw, d.f.selector_topbar_more_black);
            al.c(this.hPx, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }
}
