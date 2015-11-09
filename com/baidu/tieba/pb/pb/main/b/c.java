package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ce;
/* loaded from: classes.dex */
public class c {
    public final View axV;
    private PbActivity cjZ;
    public final TextView cnj;
    public final ImageView cnk;
    public final ImageView cnl;
    public final ImageView cnm;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private ce cnn = null;

    public c(PbActivity pbActivity) {
        this.cjZ = pbActivity;
        this.mNavigationBar = (NavigationBar) this.cjZ.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new d(this));
        this.axV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aWY);
        this.cnj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.pb_title_textview, (View.OnClickListener) null);
        this.cnm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_add_floor, pbActivity.aWY);
        this.cnk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_host, pbActivity.aWY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.d(this.cjZ.getPageContext().getPageActivity(), i.d.ds30), 0, k.d(this.cjZ.getPageContext().getPageActivity(), i.d.ds26), 0);
        this.cnk.setLayoutParams(layoutParams);
        this.cnl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, pbActivity.aWY);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.d(this.cjZ.getPageContext().getPageActivity(), i.d.ds16), 0);
        this.cnl.setLayoutParams(layoutParams2);
        an.a(this.cnl, i.e.btn_more_selector_s, i.e.btn_more_selector);
        an.a(this.cnm, i.e.icon_floor_addition_selector_s, i.e.icon_floor_addition_selector);
        this.cnj.setOnClickListener(pbActivity.aWY);
    }

    public void eJ(boolean z) {
        this.cnl.setVisibility(z ? 0 : 8);
    }

    public NavigationBar ahw() {
        return this.mNavigationBar;
    }

    public void jU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cnj.setVisibility(0);
            this.cnj.setText(String.valueOf(str) + this.cjZ.getPageContext().getString(i.h.bar));
        }
    }

    public void ahx() {
        this.cnk.setVisibility(4);
        this.cnk.setEnabled(false);
    }

    public void eO(boolean z) {
        if (z) {
            an.c(this.cnk, i.e.s_only_host_button_bg);
        } else {
            an.a(this.cnk, i.e.s_icon_floor_host_bg, i.e.icon_floor_host_bg);
        }
    }

    public void eT(boolean z) {
        if (z) {
            this.cnm.setVisibility(0);
        } else {
            this.cnm.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.cjZ.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.cnn = new ce((PbActivity) this.cjZ.getPageContext().getOrignalPage(), this.cjZ.aWY);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.cjZ.getPageContext().getPageActivity(), this.cnn.getView(), this.mNavigationBar, an.getDrawable(i.e.bg_pull_down_right_n), new e(this));
                this.mPopWindow.onChangeSkinType(this.cjZ, skinType, an.getDrawable(i.e.bg_pull_down_right_n));
            }
            if (z3) {
                this.cnn.eE(false);
            } else {
                this.cnn.eE(true);
            }
            if (h.aj(this.cjZ.getPageContext().getPageActivity())) {
                this.cnn.agA().setVisibility(0);
                this.cnn.agB().setVisibility(0);
            } else {
                this.cnn.agA().setVisibility(8);
                this.cnn.agB().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            k(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void k(boolean z, boolean z2) {
        if (this.cnn != null) {
            if (!z) {
                this.cnn.agD().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cnn.agD().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.cnn.agz().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cnn.agz().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qs() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.cjZ.getPageContext().getPageActivity());
        }
    }

    public ce ahy() {
        return this.cnn;
    }

    public boolean ahz() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void abb() {
        this.mPopWindow = null;
        this.cnn = null;
    }
}
