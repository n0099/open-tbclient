package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bo;
/* loaded from: classes.dex */
public class a {
    public final View aAv;
    private PbActivity ccs;
    public final TextView cgo;
    public final ImageView cgp;
    public final ImageView cgq;
    public final ImageView cgr;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bo cgs = null;

    public a(PbActivity pbActivity) {
        this.ccs = pbActivity;
        this.mNavigationBar = (NavigationBar) this.ccs.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.aAv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aXl);
        this.cgo = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.pb_title_textview, (View.OnClickListener) null);
        this.cgr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_add_floor, pbActivity.aXl);
        this.cgp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_host, pbActivity.aXl);
        this.cgq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, pbActivity.aXl);
        this.cgo.setOnClickListener(pbActivity.aXl);
    }

    public void eB(boolean z) {
        this.cgq.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aeV() {
        return this.mNavigationBar;
    }

    public void jx(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cgo.setVisibility(0);
            this.cgo.setText(String.valueOf(str) + this.ccs.getPageContext().getString(i.h.bar));
        }
    }

    public void aeW() {
        this.cgp.setVisibility(4);
        this.cgp.setEnabled(false);
    }

    public void eG(boolean z) {
        if (z) {
            al.c(this.cgp, i.e.icon_floor_host_s);
        } else {
            al.c(this.cgp, i.e.icon_floor_host_n);
        }
    }

    public void eL(boolean z) {
        if (z) {
            this.cgr.setVisibility(0);
        } else {
            this.cgr.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.ccs.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.cgs = new bo((PbActivity) this.ccs.getPageContext().getOrignalPage(), this.ccs.aXl);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.ccs.getPageContext().getPageActivity(), this.cgs.getView(), this.mNavigationBar, al.getDrawable(i.e.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.ccs, skinType, al.getDrawable(i.e.bg_pull_down_right_n));
            }
            if (z3) {
                this.cgs.ew(false);
            } else {
                this.cgs.ew(true);
            }
            if (h.ak(this.ccs.getPageContext().getPageActivity())) {
                this.cgs.aeb().setVisibility(0);
                this.cgs.aec().setVisibility(0);
            } else {
                this.cgs.aeb().setVisibility(8);
                this.cgs.aec().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            i(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void i(boolean z, boolean z2) {
        if (this.cgs != null) {
            if (!z) {
                this.cgs.aee().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cgs.aee().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.cgs.aea().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cgs.aea().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qy() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.ccs.getPageContext().getPageActivity());
        }
    }

    public bo aeX() {
        return this.cgs;
    }

    public boolean aeY() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void ZA() {
        this.mPopWindow = null;
        this.cgs = null;
    }
}
