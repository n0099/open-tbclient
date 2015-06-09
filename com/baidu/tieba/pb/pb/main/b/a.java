package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.i;
import com.baidu.tieba.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bt;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public final View arG;
    private PbActivity bLa;
    public final TextView bOP;
    public final ImageView bOQ;
    public final ImageView bOR;
    public final ImageView bOS;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bt bOT = null;

    public a(PbActivity pbActivity) {
        this.bLa = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bLa.findViewById(q.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.arG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aNV);
        this.bOP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.pb_title_textview, (View.OnClickListener) null);
        this.bOS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.widget_nb_add_floor, pbActivity.aNV);
        this.bOQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.nb_item_floor_host, pbActivity.aNV);
        this.bOR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.nb_item_floor_more, pbActivity.aNV);
        this.bOP.setOnClickListener(pbActivity.aNV);
    }

    public void ec(boolean z) {
        this.bOR.setVisibility(z ? 0 : 8);
    }

    public NavigationBar acG() {
        return this.mNavigationBar;
    }

    public void it(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bOP.setVisibility(0);
            this.bOP.setText(String.valueOf(str) + this.bLa.getPageContext().getString(t.bar));
        }
    }

    public void acH() {
        this.bOQ.setVisibility(4);
        this.bOQ.setEnabled(false);
    }

    public void eg(boolean z) {
        if (z) {
            ay.c(this.bOQ, p.icon_floor_host_s);
        } else {
            ay.c(this.bOQ, p.icon_floor_host_n);
        }
    }

    public void ej(boolean z) {
        if (z) {
            this.bOS.setVisibility(0);
        } else {
            this.bOS.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.bLa.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bOT = new bt((PbActivity) this.bLa.getPageContext().getOrignalPage(), this.bLa.aNV);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bLa.getPageContext().getPageActivity(), this.bOT.getView(), this.mNavigationBar, ay.getDrawable(p.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bLa, skinType, ay.getDrawable(p.bg_pull_down_right_n));
            }
            if (z3) {
                this.bOT.dZ(false);
            } else {
                this.bOT.dZ(true);
            }
            if (i.ai(this.bLa.getPageContext().getPageActivity())) {
                this.bOT.abG().setVisibility(0);
                this.bOT.abH().setVisibility(0);
            } else {
                this.bOT.abG().setVisibility(8);
                this.bOT.abH().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            e(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void e(boolean z, boolean z2) {
        if (this.bOT != null) {
            if (!z) {
                this.bOT.abJ().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bOT.abJ().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bOT.abF().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bOT.abF().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void pA() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bLa.getPageContext().getPageActivity());
        }
    }

    public bt acI() {
        return this.bOT;
    }

    public void XR() {
        this.mPopWindow = null;
        this.bOT = null;
    }
}
