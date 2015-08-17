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
    public final View ayN;
    private PbActivity cbx;
    public final TextView cfr;
    public final ImageView cfs;
    public final ImageView cft;
    public final ImageView cfu;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bo cfv = null;

    public a(PbActivity pbActivity) {
        this.cbx = pbActivity;
        this.mNavigationBar = (NavigationBar) this.cbx.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new b(this));
        this.ayN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aXl);
        this.cfr = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.pb_title_textview, (View.OnClickListener) null);
        this.cfu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_add_floor, pbActivity.aXl);
        this.cfs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_host, pbActivity.aXl);
        this.cft = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, pbActivity.aXl);
        this.cfr.setOnClickListener(pbActivity.aXl);
    }

    public void et(boolean z) {
        this.cft.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aeH() {
        return this.mNavigationBar;
    }

    public void jp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cfr.setVisibility(0);
            this.cfr.setText(String.valueOf(str) + this.cbx.getPageContext().getString(i.C0057i.bar));
        }
    }

    public void aeI() {
        this.cfs.setVisibility(4);
        this.cfs.setEnabled(false);
    }

    public void ey(boolean z) {
        if (z) {
            al.c(this.cfs, i.e.icon_floor_host_s);
        } else {
            al.c(this.cfs, i.e.icon_floor_host_n);
        }
    }

    public void eD(boolean z) {
        if (z) {
            this.cfu.setVisibility(0);
        } else {
            this.cfu.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.cbx.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.cfv = new bo((PbActivity) this.cbx.getPageContext().getOrignalPage(), this.cbx.aXl);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.cbx.getPageContext().getPageActivity(), this.cfv.getView(), this.mNavigationBar, al.getDrawable(i.e.bg_pull_down_right_n), new c(this));
                this.mPopWindow.onChangeSkinType(this.cbx, skinType, al.getDrawable(i.e.bg_pull_down_right_n));
            }
            if (z3) {
                this.cfv.eo(false);
            } else {
                this.cfv.eo(true);
            }
            if (h.ak(this.cbx.getPageContext().getPageActivity())) {
                this.cfv.adN().setVisibility(0);
                this.cfv.adO().setVisibility(0);
            } else {
                this.cfv.adN().setVisibility(8);
                this.cfv.adO().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            i(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void i(boolean z, boolean z2) {
        if (this.cfv != null) {
            if (!z) {
                this.cfv.adQ().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cfv.adQ().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.cfv.adM().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cfv.adM().setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qB() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.cbx.getPageContext().getPageActivity());
        }
    }

    public bo aeJ() {
        return this.cfv;
    }

    public boolean aeK() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void Zw() {
        this.mPopWindow = null;
        this.cfv = null;
    }
}
