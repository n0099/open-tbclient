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
import com.baidu.tieba.pb.pb.main.bw;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    private PbActivity bIT;
    public final TextView bMQ;
    public final ImageView bMR;
    public final ImageView bMS;
    public final ImageView bMT;
    public final View bbo;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bw bMU = null;

    public a(PbActivity pbActivity) {
        this.bIT = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bIT.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.bbo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aLK);
        this.bMQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.pb_title_textview, (View.OnClickListener) null);
        this.bMT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_add_floor, pbActivity.aLK);
        this.bMR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_host, pbActivity.aLK);
        this.bMS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_more, pbActivity.aLK);
        this.bMQ.setOnClickListener(pbActivity.aLK);
    }

    public NavigationBar abN() {
        return this.mNavigationBar;
    }

    public void hO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bMQ.setVisibility(0);
            this.bMQ.setText(String.valueOf(str) + this.bIT.getPageContext().getString(y.bar));
        }
    }

    public void abO() {
        this.bMR.setVisibility(4);
        this.bMR.setEnabled(false);
    }

    public void dU(boolean z) {
        if (z) {
            ba.c(this.bMR, u.icon_floor_host_s);
        } else {
            ba.c(this.bMR, u.icon_floor_host_n);
        }
    }

    public void dX(boolean z) {
        if (z) {
            this.bMT.setVisibility(0);
        } else {
            this.bMT.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.bIT.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bMU = new bw((PbActivity) this.bIT.getPageContext().getOrignalPage(), this.bIT.aLK);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bIT.getPageContext().getPageActivity(), this.bMU.getView(), this.mNavigationBar, ba.getDrawable(u.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bIT, skinType, ba.getDrawable(u.bg_pull_down_right_n));
            }
            if (z3) {
                this.bMU.dO(false);
            } else {
                this.bMU.dO(true);
            }
            if (i.ae(this.bIT.getPageContext().getPageActivity())) {
                this.bMU.aar().setVisibility(0);
                this.bMU.aas().setVisibility(0);
            } else {
                this.bMU.aar().setVisibility(8);
                this.bMU.aas().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            d(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void d(boolean z, boolean z2) {
        if (this.bMU != null) {
            if (!z) {
                this.bMU.aau().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bMU.aau().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bMU.aaq().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bMU.aaq().setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(u.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oW() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bIT.getPageContext().getPageActivity());
        }
    }

    public bw abP() {
        return this.bMU;
    }

    public void Wy() {
        this.mPopWindow = null;
        this.bMU = null;
    }
}
