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
    private ImageView ioE;
    private ImageView ioF;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.ioF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.ioF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ioF.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.ioF.setLayoutParams(layoutParams);
        }
        this.ioE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.ioE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ioE.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.ioE.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.ioE.setVisibility(0);
            return;
        }
        this.ioE.setVisibility(8);
        if (this.ioF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ioF.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.ioF.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.ioE != null) {
            this.ioE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kc()) {
                        TiebaStatic.log(new an("c12503").bT("obj_locate", "2"));
                        b bVar = new b();
                        bVar.fcx = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.ioF != null) {
            this.ioF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12503").bT("obj_locate", "1"));
                    b bVar = new b();
                    bVar.fcx = 42;
                    bVar.azf = new Bundle();
                    bVar.azf.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void ccy() {
    }

    @Override // com.baidu.tieba.view.f
    public void P(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.ioE != null) {
            if (z) {
                am.c(this.ioE, (int) R.drawable.selector_topbar_more_black);
                am.c(this.ioF, (int) R.drawable.selector_topbar_chat_black);
            } else {
                am.c(this.ioE, (int) R.drawable.selector_topbar_more_white);
                am.c(this.ioF, (int) R.drawable.selector_topbar_chat_white);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.ioE.setAlpha(f2);
                this.ioF.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.ioE != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.c(this.ioE, (int) R.drawable.selector_topbar_more_white);
                am.c(this.ioF, (int) R.drawable.selector_topbar_chat_white);
                return;
            }
            am.c(this.ioE, (int) R.drawable.selector_topbar_more_black);
            am.c(this.ioF, (int) R.drawable.selector_topbar_chat_black);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }
}
