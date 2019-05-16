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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes6.dex */
public class a implements f {
    private ImageView iii;
    private ImageView iij;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.iij = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.iij.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iij.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.iij.setLayoutParams(layoutParams);
        }
        this.iii = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.iii.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iii.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.iii.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.iii.setVisibility(0);
            return;
        }
        this.iii.setVisibility(8);
        if (this.iij.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iij.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.iij.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.iii != null) {
            this.iii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jS()) {
                        TiebaStatic.log(new am("c12503").bT("obj_locate", "2"));
                        b bVar = new b();
                        bVar.eXv = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.iij != null) {
            this.iij.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12503").bT("obj_locate", "1"));
                    b bVar = new b();
                    bVar.eXv = 42;
                    bVar.ayy = new Bundle();
                    bVar.ayy.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bZF() {
    }

    @Override // com.baidu.tieba.view.f
    public void N(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.iii != null) {
            if (z) {
                al.c(this.iii, (int) R.drawable.selector_topbar_more_black);
                al.c(this.iij, (int) R.drawable.selector_topbar_chat_black);
            } else {
                al.c(this.iii, (int) R.drawable.selector_topbar_more_white);
                al.c(this.iij, (int) R.drawable.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.iii.setAlpha(f2);
                this.iij.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.iii != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.c(this.iii, (int) R.drawable.selector_topbar_more_white);
                al.c(this.iij, (int) R.drawable.selector_topbar_chat_white);
                return;
            }
            al.c(this.iii, (int) R.drawable.selector_topbar_more_black);
            al.c(this.iij, (int) R.drawable.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }
}
