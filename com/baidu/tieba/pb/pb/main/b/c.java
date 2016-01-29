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
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cv;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    public final View aCv;
    private PbActivity cNL;
    public final TextView cSL;
    public final ImageView cSM;
    public final ImageView cSN;
    public final ImageView cSO;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow Su = null;
    private cv cSP = null;

    public c(PbActivity pbActivity) {
        this.cNL = pbActivity;
        this.mNavigationBar = (NavigationBar) this.cNL.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new d(this));
        this.aCv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bjG);
        this.cSL = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.pb_title_textview, (View.OnClickListener) null);
        this.cSO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_add_floor, pbActivity.bjG);
        this.cSM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_host, pbActivity.bjG);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.c(this.cNL.getPageContext().getPageActivity(), t.e.ds30), 0, k.c(this.cNL.getPageContext().getPageActivity(), t.e.ds26), 0);
        this.cSM.setLayoutParams(layoutParams);
        this.cSN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, pbActivity.bjG);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.c(this.cNL.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.cSN.setLayoutParams(layoutParams2);
        ar.a(this.cSN, t.f.btn_more_selector_s, t.f.btn_more_selector);
        ar.a(this.cSO, t.f.icon_floor_addition_selector_s, t.f.icon_floor_addition_selector);
        this.cSL.setOnClickListener(pbActivity.bjG);
    }

    public void fC(boolean z) {
        this.cSN.setVisibility(z ? 0 : 8);
    }

    public NavigationBar arM() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.cSL.setVisibility(0);
            this.aCv.setVisibility(0);
            return;
        }
        this.cSL.setVisibility(8);
        this.aCv.setVisibility(8);
    }

    public void kQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cSL.setVisibility(0);
            this.cSL.setText(String.valueOf(str) + this.cNL.getPageContext().getString(t.j.bar));
            l.rn().ch(str);
        }
    }

    public void arN() {
        this.cSM.setVisibility(4);
        this.cSM.setEnabled(false);
    }

    public void fI(boolean z) {
        if (z) {
            ar.c(this.cSM, t.f.s_only_host_button_bg);
        } else {
            ar.a(this.cSM, t.f.s_icon_floor_host_bg, t.f.icon_floor_host_bg);
        }
    }

    public void fL(boolean z) {
        if (z) {
            this.cSO.setVisibility(0);
        } else {
            this.cSO.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.cNL.isProgressBarShown()) {
            if (this.Su == null) {
                this.cSP = new cv((PbActivity) this.cNL.getPageContext().getOrignalPage(), this.cNL.bjG);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.Su = new MorePopupWindow(this.cNL.getPageContext().getPageActivity(), this.cSP.getView(), this.mNavigationBar, ar.getDrawable(t.f.bg_pull_down_right_n), new e(this));
                this.Su.onChangeSkinType(this.cNL, skinType, ar.getDrawable(t.f.bg_pull_down_right_n));
            }
            if (z4) {
                this.cSP.fy(false);
            } else {
                this.cSP.fy(true);
            }
            if (z3) {
                this.cSP.fx(false);
            } else {
                this.cSP.fx(true);
            }
            if (h.aj(this.cNL.getPageContext().getPageActivity())) {
                this.cSP.aqu().setVisibility(0);
                this.cSP.aqv().setVisibility(0);
            } else {
                this.cSP.aqu().setVisibility(8);
                this.cSP.aqv().setVisibility(8);
            }
            if (this.Su != null) {
                this.Su.refresh();
            }
            p(z, z2);
            this.Su.showWindowInRightBottomOfHost();
        }
    }

    private void p(boolean z, boolean z2) {
        if (this.cSP != null) {
            if (!z) {
                this.cSP.aqx().setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cSP.aqx().setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.cSP.aql().setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cSP.aql().setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qI() {
        if (this.Su != null) {
            j.a(this.Su, this.cNL.getPageContext().getPageActivity());
        }
    }

    public cv arO() {
        return this.cSP;
    }

    public boolean arP() {
        return this.Su != null && this.Su.isShowing();
    }

    public void ajS() {
        this.Su = null;
        this.cSP = null;
    }
}
