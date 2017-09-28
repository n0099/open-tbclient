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
public class c implements f {
    private ImageView gCG;
    private ImageView gCH;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.gCH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.view_topbar_icon, (View.OnClickListener) null);
        if (this.gCH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCH.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds4);
            this.gCH.setLayoutParams(layoutParams);
        }
        this.gCG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.view_topbar_icon, (View.OnClickListener) null);
        if (this.gCG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCG.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds14);
            this.gCG.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.gCG.setVisibility(0);
            return;
        }
        this.gCG.setVisibility(8);
        if (this.gCH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gCH.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds14);
            this.gCH.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.gCG != null) {
            this.gCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.j.hh()) {
                        TiebaStatic.log(new ak("c12503").ad("obj_locate", "2"));
                        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                        aVar.ceU = 9;
                        gVar.a(view, aVar);
                    }
                }
            });
        }
        if (this.gCH != null) {
            this.gCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12503").ad("obj_locate", "1"));
                    com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                    aVar.ceU = 42;
                    aVar.ceV = new Bundle();
                    aVar.ceV.putSerializable(UserData.TYPE_USER, c.this.mUserData);
                    gVar.a(view, aVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bxY() {
    }

    @Override // com.baidu.tieba.view.f
    public void y(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.gCG != null) {
            if (z) {
                aj.c(this.gCG, d.g.selector_topbar_more_black);
                aj.c(this.gCH, d.g.selector_topbar_chat_black);
            } else {
                aj.c(this.gCG, d.g.selector_topbar_more_white);
                aj.c(this.gCH, d.g.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.gCG.setAlpha(f2);
                this.gCH.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gCG != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.c(this.gCG, d.g.selector_topbar_more_white);
                aj.c(this.gCH, d.g.selector_topbar_chat_white);
                return;
            }
            aj.c(this.gCG, d.g.selector_topbar_more_black);
            aj.c(this.gCH, d.g.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
