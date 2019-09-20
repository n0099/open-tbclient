package com.baidu.tieba.personPolymeric;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.event.b;
import com.baidu.tieba.view.f;
import com.baidu.tieba.view.g;
/* loaded from: classes6.dex */
public class a implements f {
    private ImageView irH;
    private ImageView irI;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.irI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.irI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.irI.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.irI.setLayoutParams(layoutParams);
        }
        this.irH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.irH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.irH.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.irH.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.irH.setVisibility(0);
            return;
        }
        this.irH.setVisibility(8);
        if (this.irI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.irI.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.irI.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.irH != null) {
            this.irH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kc()) {
                        TiebaStatic.log(new an("c12503").bT("obj_locate", "2"));
                        b bVar = new b();
                        bVar.feK = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.irI != null) {
            this.irI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12503").bT("obj_locate", "1"));
                    b bVar = new b();
                    bVar.feK = 42;
                    bVar.azD = new Bundle();
                    bVar.azD.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void cdE() {
    }

    @Override // com.baidu.tieba.view.f
    public void Q(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.irH != null) {
            if (z) {
                SvgManager.ajv().a(this.irH, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.ajv().a(this.irI, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.ajv().a(this.irH, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.ajv().a(this.irI, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.irH.setAlpha(f2);
                this.irI.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.irH != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.ajv().a(this.irH, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.ajv().a(this.irI, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.ajv().a(this.irH, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.ajv().a(this.irI, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }
}
