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
    private PbActivity bKZ;
    public final TextView bOO;
    public final ImageView bOP;
    public final ImageView bOQ;
    public final ImageView bOR;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bt bOS = null;

    public a(PbActivity pbActivity) {
        this.bKZ = pbActivity;
        this.mNavigationBar = (NavigationBar) this.bKZ.findViewById(q.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.arG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aNU);
        this.bOO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.pb_title_textview, (View.OnClickListener) null);
        this.bOR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.widget_nb_add_floor, pbActivity.aNU);
        this.bOP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.nb_item_floor_host, pbActivity.aNU);
        this.bOQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.nb_item_floor_more, pbActivity.aNU);
        this.bOO.setOnClickListener(pbActivity.aNU);
    }

    public void ec(boolean z) {
        this.bOQ.setVisibility(z ? 0 : 8);
    }

    public NavigationBar acF() {
        return this.mNavigationBar;
    }

    public void it(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bOO.setVisibility(0);
            this.bOO.setText(String.valueOf(str) + this.bKZ.getPageContext().getString(t.bar));
        }
    }

    public void acG() {
        this.bOP.setVisibility(4);
        this.bOP.setEnabled(false);
    }

    public void eg(boolean z) {
        if (z) {
            ay.c(this.bOP, p.icon_floor_host_s);
        } else {
            ay.c(this.bOP, p.icon_floor_host_n);
        }
    }

    public void ej(boolean z) {
        if (z) {
            this.bOR.setVisibility(0);
        } else {
            this.bOR.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.bKZ.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.bOS = new bt((PbActivity) this.bKZ.getPageContext().getOrignalPage(), this.bKZ.aNU);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.bKZ.getPageContext().getPageActivity(), this.bOS.getView(), this.mNavigationBar, ay.getDrawable(p.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.bKZ, skinType, ay.getDrawable(p.bg_pull_down_right_n));
            }
            if (z3) {
                this.bOS.dZ(false);
            } else {
                this.bOS.dZ(true);
            }
            if (i.ai(this.bKZ.getPageContext().getPageActivity())) {
                this.bOS.abF().setVisibility(0);
                this.bOS.abG().setVisibility(0);
            } else {
                this.bOS.abF().setVisibility(8);
                this.bOS.abG().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            e(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void e(boolean z, boolean z2) {
        if (this.bOS != null) {
            if (!z) {
                this.bOS.abI().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bOS.abI().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.bOS.abE().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bOS.abE().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(p.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void pA() {
        if (this.mPopWindow != null) {
            k.a(this.mPopWindow, this.bKZ.getPageContext().getPageActivity());
        }
    }

    public bt acH() {
        return this.bOS;
    }

    public void XQ() {
        this.mPopWindow = null;
        this.bOS = null;
    }
}
