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
    private ImageView iqh;
    private ImageView iqi;
    private NavigationBar mNavigationBar;
    private UserData mUserData;

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        this.iqi = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.iqi.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iqi.getLayoutParams();
            layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.iqi.setLayoutParams(layoutParams);
        }
        this.iqh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.iqh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iqh.getLayoutParams();
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.iqh.setLayoutParams(layoutParams2);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.iqh.setVisibility(0);
            return;
        }
        this.iqh.setVisibility(8);
        if (this.iqi.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iqi.getLayoutParams();
            layoutParams3.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.iqi.setLayoutParams(layoutParams3);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(final g gVar) {
        if (this.iqh != null) {
            this.iqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        TiebaStatic.log(new an("c12503").bS("obj_locate", "2"));
                        b bVar = new b();
                        bVar.fhu = 9;
                        gVar.a(view, bVar);
                    }
                }
            });
        }
        if (this.iqi != null) {
            this.iqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12503").bS("obj_locate", "1"));
                    b bVar = new b();
                    bVar.fhu = 42;
                    bVar.aSR = new Bundle();
                    bVar.aSR.putSerializable(UserData.TYPE_USER, a.this.mUserData);
                    gVar.a(view, bVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void caF() {
    }

    @Override // com.baidu.tieba.view.f
    public void O(int i, boolean z) {
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (this.iqh != null) {
            if (z) {
                SvgManager.amN().a(this.iqh, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amN().a(this.iqi, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amN().a(this.iqh, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amN().a(this.iqi, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.iqh.setAlpha(f2);
                this.iqi.setAlpha(f2);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.iqh != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.amN().a(this.iqh, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amN().a(this.iqi, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.amN().a(this.iqh, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.amN().a(this.iqi, R.drawable.icon_pure_topbar_createchat_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }
}
