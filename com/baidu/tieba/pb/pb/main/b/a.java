package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bv;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    private PbActivity bIF;
    public final TextView bMA;
    public final ImageView bMB;
    public final ImageView bMC;
    public final ImageView bMD;
    public final View baY;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bv bME = null;

    public a(PbActivity pbActivity) {
        this.bIF = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bIF.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.baY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aLA);
        this.bMA = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.pb_title_textview, (View.OnClickListener) null);
        this.bMD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_add_floor, pbActivity.aLA);
        this.bMB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_host, pbActivity.aLA);
        this.bMC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_more, pbActivity.aLA);
        this.bMA.setOnClickListener(pbActivity.aLA);
    }

    public NavigationBar aby() {
        return this.mNavigationBar;
    }

    public void hL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bMA.setVisibility(0);
            this.bMA.setText(String.valueOf(str) + this.bIF.getPageContext().getString(y.bar));
        }
    }

    public void abz() {
        this.bMB.setVisibility(4);
        this.bMB.setEnabled(false);
    }

    public void dW(boolean z) {
        if (z) {
            ba.c(this.bMB, u.icon_floor_host_s);
        } else {
            ba.c(this.bMB, u.icon_floor_host_n);
        }
    }

    public void dZ(boolean z) {
        if (z) {
            this.bMD.setVisibility(0);
        } else {
            this.bMD.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.bIF.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bME = new bv((PbActivity) this.bIF.getPageContext().getOrignalPage(), this.bIF.aLA);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bIF.getPageContext().getPageActivity(), this.bME.getView(), this.mNavigationBar, ba.getDrawable(u.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bIF, skinType, ba.getDrawable(u.bg_pull_down_right_n));
            }
            if (z3) {
                this.bME.dQ(false);
            } else {
                this.bME.dQ(true);
            }
            if (i.ae(this.bIF.getPageContext().getPageActivity())) {
                this.bME.aae().setVisibility(0);
                this.bME.aaf().setVisibility(0);
            } else {
                this.bME.aae().setVisibility(8);
                this.bME.aaf().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            d(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void d(boolean z, boolean z2) {
        if (this.bME != null) {
            if (!z) {
                this.bME.aah().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bME.aah().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bME.aad().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bME.aad().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oW() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bIF.getPageContext().getPageActivity());
        }
    }

    public bv abA() {
        return this.bME;
    }

    public void Wl() {
        this.mPopWindow = null;
        this.bME = null;
    }
}
