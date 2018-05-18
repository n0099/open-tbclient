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
    private ImageView fIR;
    private ImageView fIS;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.fIS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fIS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fIS.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.fIS.setLayoutParams(layoutParams);
        }
        this.fIR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fIR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fIR.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fIR.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.fIR.setVisibility(0);
            return;
        }
        this.fIR.setVisibility(8);
        if (this.fIS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fIS.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fIS.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.fIR != null) {
            this.fIR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (j.gP()) {
                        TiebaStatic.log(new al("c12503").ac("obj_locate", "2"));
                        b bVar = new b();
                        bVar.cLl = 9;
                        gVar.a(view2, bVar);
                    }
                }
            });
        }
        if (this.fIS != null) {
            this.fIS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12503").ac("obj_locate", "1"));
                    b bVar = new b();
                    bVar.cLl = 42;
                    bVar.cLm = new Bundle();
                    bVar.cLm.putSerializable(UserData.TYPE_USER, a.this.mUserData);
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
        if (this.fIR != null) {
            if (z) {
                ak.c(this.fIR, d.f.selector_topbar_more_black);
                ak.c(this.fIS, d.f.selector_topbar_chat_black);
            } else {
                ak.c(this.fIR, d.f.selector_topbar_more_white);
                ak.c(this.fIS, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fIR.setAlpha(f2);
                this.fIS.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.fIR != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.c(this.fIR, d.f.selector_topbar_more_white);
                ak.c(this.fIS, d.f.selector_topbar_chat_white);
                return;
            }
            ak.c(this.fIR, d.f.selector_topbar_more_black);
            ak.c(this.fIS, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
