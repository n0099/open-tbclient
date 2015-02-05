package com.baidu.tieba.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.pb.main.PbActivity;
import com.baidu.tieba.pb.main.bu;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class a {
    public final View aWQ;
    private PbActivity bCF;
    public final TextView bET;
    public final ImageView bEU;
    public final ImageView bEV;
    public final ImageView bEW;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bu bEX = null;

    public a(PbActivity pbActivity) {
        this.bCF = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bCF.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.aWQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aFH);
        this.bET = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.pb_title_textview, (View.OnClickListener) null);
        this.bEW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_add_floor, pbActivity.aFH);
        this.bEU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_host, pbActivity.aFH);
        this.bEV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_more, pbActivity.aFH);
        this.bET.setOnClickListener(pbActivity.aFH);
    }

    public NavigationBar Zo() {
        return this.mNavigationBar;
    }

    public void hB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bET.setVisibility(0);
            this.bET.setText(String.valueOf(str) + this.bCF.getPageContext().getString(z.bar));
        }
    }

    public void Zp() {
        this.bEU.setVisibility(4);
        this.bEU.setEnabled(false);
    }

    public void dZ(boolean z) {
        if (z) {
            bc.c(this.bEU, v.icon_floor_host_s);
        } else {
            bc.c(this.bEU, v.icon_floor_host_n);
        }
    }

    public void ec(boolean z) {
        if (z) {
            this.bEW.setVisibility(0);
        } else {
            this.bEW.setVisibility(8);
        }
    }

    public void g(boolean z, boolean z2) {
        if (!this.bCF.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bEX = new bu((PbActivity) this.bCF.getPageContext().getOrignalPage(), this.bCF.aFH);
                int skinType = TbadkCoreApplication.m255getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bCF.getPageContext().getPageActivity(), this.bEX.getView(), this.mNavigationBar, bc.getDrawable(v.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bCF, skinType, bc.getDrawable(v.bg_pull_down_right_n));
            }
            if (g.V(this.bCF.getPageContext().getPageActivity())) {
                this.bEX.XV().setVisibility(0);
                this.bEX.XW().setVisibility(0);
            } else {
                this.bEX.XV().setVisibility(8);
                this.bEX.XW().setVisibility(8);
            }
            h(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void h(boolean z, boolean z2) {
        if (this.bEX != null) {
            if (!z) {
                this.bEX.XY().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bEX.XY().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bEX.XU().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bEX.XU().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void Zq() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bCF.getPageContext().getPageActivity());
        }
    }

    public bu Zr() {
        return this.bEX;
    }

    public void Zs() {
        this.mPopWindow = null;
        this.bEX = null;
    }
}
