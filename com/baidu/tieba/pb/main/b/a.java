package com.baidu.tieba.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.i;
import com.baidu.tieba.pb.main.PbActivity;
import com.baidu.tieba.pb.main.br;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    public final View aTX;
    private PbActivity bxe;
    public final TextView bzn;
    public final ImageView bzo;
    public final ImageView bzp;
    public final ImageView bzq;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private br bzr = null;

    public a(PbActivity pbActivity) {
        this.bxe = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bxe.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.aTX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aDg);
        this.bzn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.pb_title_textview, (View.OnClickListener) null);
        this.bzq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_add_floor, pbActivity.aDg);
        this.bzo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_host, pbActivity.aDg);
        this.bzp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_more, pbActivity.aDg);
        this.bzn.setOnClickListener(pbActivity.aDg);
    }

    public NavigationBar Yq() {
        return this.mNavigationBar;
    }

    public void gY(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bzn.setVisibility(0);
            this.bzn.setText(String.valueOf(str) + this.bxe.getString(y.bar));
        }
    }

    public void Yr() {
        this.bzo.setVisibility(4);
        this.bzo.setEnabled(false);
    }

    public void ei(boolean z) {
        if (z) {
            aw.c(this.bzo, u.icon_floor_host_s);
        } else {
            aw.c(this.bzo, u.icon_floor_host_n);
        }
    }

    public void el(boolean z) {
        if (z) {
            this.bzq.setVisibility(0);
        } else {
            this.bzq.setVisibility(8);
        }
    }

    public void e(boolean z, boolean z2) {
        if (!this.bxe.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bzr = new br(this.bxe, this.bxe.aDg);
                int skinType = TbadkApplication.m251getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bxe, this.bzr.getView(), this.mNavigationBar, aw.getDrawable(u.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bxe, skinType, aw.getDrawable(u.bg_pull_down_right_n));
            }
            if (i.y(this.bxe)) {
                this.bzr.WY().setVisibility(0);
                this.bzr.WZ().setVisibility(0);
            } else {
                this.bzr.WY().setVisibility(8);
                this.bzr.WZ().setVisibility(8);
            }
            f(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void f(boolean z, boolean z2) {
        if (this.bzr != null) {
            if (!z) {
                this.bzr.Xb().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bzr.Xb().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bzr.WX().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bzr.WX().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void Ys() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.bxe);
        }
    }

    public br Yt() {
        return this.bzr;
    }

    public void Yu() {
        this.mPopWindow = null;
        this.bzr = null;
    }
}
