package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ck;
/* loaded from: classes.dex */
public class c {
    public final View azZ;
    private PbActivity cCy;
    public final TextView cGu;
    public final ImageView cGv;
    public final ImageView cGw;
    public final ImageView cGx;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private ck cGy = null;

    public c(PbActivity pbActivity) {
        this.cCy = pbActivity;
        this.mNavigationBar = (NavigationBar) this.cCy.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new d(this));
        this.azZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bcT);
        this.cGu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.g.pb_title_textview, (View.OnClickListener) null);
        this.cGx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_add_floor, pbActivity.bcT);
        this.cGv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_floor_host, pbActivity.bcT);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.d(this.cCy.getPageContext().getPageActivity(), n.d.ds30), 0, k.d(this.cCy.getPageContext().getPageActivity(), n.d.ds26), 0);
        this.cGv.setLayoutParams(layoutParams);
        this.cGw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_floor_more, pbActivity.bcT);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.d(this.cCy.getPageContext().getPageActivity(), n.d.ds16), 0);
        this.cGw.setLayoutParams(layoutParams2);
        as.a(this.cGw, n.e.btn_more_selector_s, n.e.btn_more_selector);
        as.a(this.cGx, n.e.icon_floor_addition_selector_s, n.e.icon_floor_addition_selector);
        this.cGu.setOnClickListener(pbActivity.bcT);
    }

    public void fn(boolean z) {
        this.cGw.setVisibility(z ? 0 : 8);
    }

    public NavigationBar ama() {
        return this.mNavigationBar;
    }

    public void kM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cGu.setVisibility(0);
            this.cGu.setText(String.valueOf(str) + this.cCy.getPageContext().getString(n.i.bar));
            m.rh().cg(str);
        }
    }

    public void amb() {
        this.cGv.setVisibility(4);
        this.cGv.setEnabled(false);
    }

    public void fs(boolean z) {
        if (z) {
            as.c(this.cGv, n.e.s_only_host_button_bg);
        } else {
            as.a(this.cGv, n.e.s_icon_floor_host_bg, n.e.icon_floor_host_bg);
        }
    }

    public void fx(boolean z) {
        if (z) {
            this.cGx.setVisibility(0);
        } else {
            this.cGx.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.cCy.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.cGy = new ck((PbActivity) this.cCy.getPageContext().getOrignalPage(), this.cCy.bcT);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.cCy.getPageContext().getPageActivity(), this.cGy.getView(), this.mNavigationBar, as.getDrawable(n.e.bg_pull_down_right_n), new e(this));
                this.mPopWindow.onChangeSkinType(this.cCy, skinType, as.getDrawable(n.e.bg_pull_down_right_n));
            }
            if (z4) {
                this.cGy.fk(false);
            } else {
                this.cGy.fk(true);
            }
            if (z3) {
                this.cGy.fj(false);
            } else {
                this.cGy.fj(true);
            }
            if (h.ak(this.cCy.getPageContext().getPageActivity())) {
                this.cGy.akY().setVisibility(0);
                this.cGy.akZ().setVisibility(0);
            } else {
                this.cGy.akY().setVisibility(8);
                this.cGy.akZ().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            l(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void l(boolean z, boolean z2) {
        if (this.cGy != null) {
            if (!z) {
                this.cGy.alb().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cGy.alb().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.cGy.akU().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cGy.akU().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qE() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.cCy.getPageContext().getPageActivity());
        }
    }

    public ck amc() {
        return this.cGy;
    }

    public boolean amd() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void aeH() {
        this.mPopWindow = null;
        this.cGy = null;
    }
}
