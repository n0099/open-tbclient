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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes6.dex */
public class a implements f {
    private ImageView ipI;
    private ImageView ipJ;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.ipJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.ipJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ipJ.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.ipJ.setLayoutParams(layoutParams);
        }
        this.ipI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.ipI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ipI.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.ipI.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.ipI.setVisibility(0);
            return;
        }
        this.ipI.setVisibility(8);
        if (this.ipJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ipJ.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.ipJ.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.ipI != null) {
            this.ipI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kc()) {
                        TiebaStatic.log(new an("c12503").bT("obj_locate", "2"));
                        b bVar = new b();
                        bVar.fcX = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.ipJ != null) {
            this.ipJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12503").bT("obj_locate", "1"));
                    b bVar = new b();
                    bVar.fcX = 42;
                    bVar.azf = new Bundle();
                    bVar.azf.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void ccQ() {
    }

    @Override // com.baidu.tieba.view.f
    public void P(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.ipI != null) {
            if (z) {
                am.c(this.ipI, (int) R.drawable.selector_topbar_more_black);
                am.c(this.ipJ, (int) R.drawable.selector_topbar_chat_black);
            } else {
                am.c(this.ipI, (int) R.drawable.selector_topbar_more_white);
                am.c(this.ipJ, (int) R.drawable.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.ipI.setAlpha(f2);
                this.ipJ.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.ipI != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.c(this.ipI, (int) R.drawable.selector_topbar_more_white);
                am.c(this.ipJ, (int) R.drawable.selector_topbar_chat_white);
                return;
            }
            am.c(this.ipI, (int) R.drawable.selector_topbar_more_black);
            am.c(this.ipJ, (int) R.drawable.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }
}
