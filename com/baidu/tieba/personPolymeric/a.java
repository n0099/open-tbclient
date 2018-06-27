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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes3.dex */
public class a implements f {
    private ImageView fYp;
    private ImageView fYq;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.fYq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fYq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYq.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds4);
            this.fYq.setLayoutParams(layoutParams);
        }
        this.fYp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.fYp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fYp.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fYp.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.fYp.setVisibility(0);
            return;
        }
        this.fYp.setVisibility(8);
        if (this.fYq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fYq.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
            this.fYq.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.fYp != null) {
            this.fYp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jD()) {
                        TiebaStatic.log(new an("c12503").ah("obj_locate", "2"));
                        b bVar = new b();
                        bVar.cSt = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.fYq != null) {
            this.fYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12503").ah("obj_locate", "1"));
                    b bVar = new b();
                    bVar.cSt = 42;
                    bVar.cSu = new Bundle();
                    bVar.cSu.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bkv() {
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.fYp != null) {
            if (z) {
                am.c(this.fYp, d.f.selector_topbar_more_black);
                am.c(this.fYq, d.f.selector_topbar_chat_black);
            } else {
                am.c(this.fYp, d.f.selector_topbar_more_white);
                am.c(this.fYq, d.f.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.fYp.setAlpha(f2);
                this.fYq.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.fYp != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.c(this.fYp, d.f.selector_topbar_more_white);
                am.c(this.fYq, d.f.selector_topbar_chat_white);
                return;
            }
            am.c(this.fYp, d.f.selector_topbar_more_black);
            am.c(this.fYq, d.f.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
