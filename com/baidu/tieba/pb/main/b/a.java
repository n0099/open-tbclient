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
    public final View aWR;
    private PbActivity bCG;
    public final TextView bEU;
    public final ImageView bEV;
    public final ImageView bEW;
    public final ImageView bEX;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bu bEY = null;

    public a(PbActivity pbActivity) {
        this.bCG = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bCG.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.aWR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aFK);
        this.bEU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.pb_title_textview, (View.OnClickListener) null);
        this.bEX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_add_floor, pbActivity.aFK);
        this.bEV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_host, pbActivity.aFK);
        this.bEW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_more, pbActivity.aFK);
        this.bEU.setOnClickListener(pbActivity.aFK);
    }

    public NavigationBar Zt() {
        return this.mNavigationBar;
    }

    public void hE(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bEU.setVisibility(0);
            this.bEU.setText(String.valueOf(str) + this.bCG.getPageContext().getString(z.bar));
        }
    }

    public void Zu() {
        this.bEV.setVisibility(4);
        this.bEV.setEnabled(false);
    }

    public void dZ(boolean z) {
        if (z) {
            bc.c(this.bEV, v.icon_floor_host_s);
        } else {
            bc.c(this.bEV, v.icon_floor_host_n);
        }
    }

    public void ec(boolean z) {
        if (z) {
            this.bEX.setVisibility(0);
        } else {
            this.bEX.setVisibility(8);
        }
    }

    public void g(boolean z, boolean z2) {
        if (!this.bCG.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bEY = new bu((PbActivity) this.bCG.getPageContext().getOrignalPage(), this.bCG.aFK);
                int skinType = TbadkCoreApplication.m255getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bCG.getPageContext().getPageActivity(), this.bEY.getView(), this.mNavigationBar, bc.getDrawable(v.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bCG, skinType, bc.getDrawable(v.bg_pull_down_right_n));
            }
            if (g.V(this.bCG.getPageContext().getPageActivity())) {
                this.bEY.Ya().setVisibility(0);
                this.bEY.Yb().setVisibility(0);
            } else {
                this.bEY.Ya().setVisibility(8);
                this.bEY.Yb().setVisibility(8);
            }
            h(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void h(boolean z, boolean z2) {
        if (this.bEY != null) {
            if (!z) {
                this.bEY.Yd().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bEY.Yd().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bEY.XZ().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bEY.XZ().setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void Zv() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bCG.getPageContext().getPageActivity());
        }
    }

    public bu Zw() {
        return this.bEY;
    }

    public void Zx() {
        this.mPopWindow = null;
        this.bEY = null;
    }
}
