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
    public final View aTJ;
    private PbActivity bwQ;
    public final TextView byZ;
    public final ImageView bza;
    public final ImageView bzb;
    public final ImageView bzc;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private br bzd = null;

    public a(PbActivity pbActivity) {
        this.bwQ = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bwQ.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.aTJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aCW);
        this.byZ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.pb_title_textview, (View.OnClickListener) null);
        this.bzc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_add_floor, pbActivity.aCW);
        this.bza = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_host, pbActivity.aCW);
        this.bzb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_more, pbActivity.aCW);
        this.byZ.setOnClickListener(pbActivity.aCW);
    }

    public NavigationBar Yn() {
        return this.mNavigationBar;
    }

    public void gY(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.byZ.setVisibility(0);
            this.byZ.setText(String.valueOf(str) + this.bwQ.getString(y.bar));
        }
    }

    public void Yo() {
        this.bza.setVisibility(4);
        this.bza.setEnabled(false);
    }

    public void ei(boolean z) {
        if (z) {
            aw.c(this.bza, u.icon_floor_host_s);
        } else {
            aw.c(this.bza, u.icon_floor_host_n);
        }
    }

    public void el(boolean z) {
        if (z) {
            this.bzc.setVisibility(0);
        } else {
            this.bzc.setVisibility(8);
        }
    }

    public void e(boolean z, boolean z2) {
        if (!this.bwQ.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bzd = new br(this.bwQ, this.bwQ.aCW);
                int skinType = TbadkApplication.m251getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bwQ, this.bzd.getView(), this.mNavigationBar, aw.getDrawable(u.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bwQ, skinType, aw.getDrawable(u.bg_pull_down_right_n));
            }
            if (i.y(this.bwQ)) {
                this.bzd.WV().setVisibility(0);
                this.bzd.WW().setVisibility(0);
            } else {
                this.bzd.WV().setVisibility(8);
                this.bzd.WW().setVisibility(8);
            }
            f(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void f(boolean z, boolean z2) {
        if (this.bzd != null) {
            if (!z) {
                this.bzd.WY().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bzd.WY().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bzd.WU().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bzd.WU().setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void Yp() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.bwQ);
        }
    }

    public br Yq() {
        return this.bzd;
    }

    public void Yr() {
        this.mPopWindow = null;
        this.bzd = null;
    }
}
