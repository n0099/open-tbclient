package com.baidu.tieba.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
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
    public final View aVy;
    private PbActivity bAW;
    public final TextView bDj;
    public final ImageView bDk;
    public final ImageView bDl;
    public final ImageView bDm;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bu bDn = null;

    public a(PbActivity pbActivity) {
        this.bAW = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bAW.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.aVy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aEH);
        this.bDj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.pb_title_textview, (View.OnClickListener) null);
        this.bDm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_add_floor, pbActivity.aEH);
        this.bDk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_host, pbActivity.aEH);
        this.bDl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_more, pbActivity.aEH);
        this.bDj.setOnClickListener(pbActivity.aEH);
    }

    public NavigationBar YO() {
        return this.mNavigationBar;
    }

    public void hx(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bDj.setVisibility(0);
            this.bDj.setText(String.valueOf(str) + this.bAW.getPageContext().getString(z.bar));
        }
    }

    public void YP() {
        this.bDk.setVisibility(4);
        this.bDk.setEnabled(false);
    }

    public void dT(boolean z) {
        if (z) {
            ax.c(this.bDk, v.icon_floor_host_s);
        } else {
            ax.c(this.bDk, v.icon_floor_host_n);
        }
    }

    public void dW(boolean z) {
        if (z) {
            this.bDm.setVisibility(0);
        } else {
            this.bDm.setVisibility(8);
        }
    }

    public void f(boolean z, boolean z2) {
        if (!this.bAW.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bDn = new bu((PbActivity) this.bAW.getPageContext().getOrignalPage(), this.bAW.aEH);
                int skinType = TbadkCoreApplication.m255getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bAW.getPageContext().getPageActivity(), this.bDn.getView(), this.mNavigationBar, ax.getDrawable(v.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bAW, skinType, ax.getDrawable(v.bg_pull_down_right_n));
            }
            if (g.V(this.bAW.getPageContext().getPageActivity())) {
                this.bDn.Xv().setVisibility(0);
                this.bDn.Xw().setVisibility(0);
            } else {
                this.bDn.Xv().setVisibility(8);
                this.bDn.Xw().setVisibility(8);
            }
            g(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void g(boolean z, boolean z2) {
        if (this.bDn != null) {
            if (!z) {
                this.bDn.Xy().setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(v.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bDn.Xy().setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(v.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bDn.Xu().setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(v.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bDn.Xu().setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(v.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void YQ() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bAW.getPageContext().getPageActivity());
        }
    }

    public bu YR() {
        return this.bDn;
    }

    public void YS() {
        this.mPopWindow = null;
        this.bDn = null;
    }
}
