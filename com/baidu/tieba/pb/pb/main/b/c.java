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
import com.baidu.tieba.pb.pb.main.co;
/* loaded from: classes.dex */
public class c {
    public final View aBG;
    private PbActivity cGj;
    public final TextView cKt;
    public final ImageView cKu;
    public final ImageView cKv;
    public final ImageView cKw;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private co cKx = null;

    public c(PbActivity pbActivity) {
        this.cGj = pbActivity;
        this.mNavigationBar = (NavigationBar) this.cGj.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new d(this));
        this.aBG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bgT);
        this.cKt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.h.pb_title_textview, (View.OnClickListener) null);
        this.cKw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_add_floor, pbActivity.bgT);
        this.cKu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_floor_host, pbActivity.bgT);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.d(this.cGj.getPageContext().getPageActivity(), n.e.ds30), 0, k.d(this.cGj.getPageContext().getPageActivity(), n.e.ds26), 0);
        this.cKu.setLayoutParams(layoutParams);
        this.cKv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_floor_more, pbActivity.bgT);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.d(this.cGj.getPageContext().getPageActivity(), n.e.ds16), 0);
        this.cKv.setLayoutParams(layoutParams2);
        as.a(this.cKv, n.f.btn_more_selector_s, n.f.btn_more_selector);
        as.a(this.cKw, n.f.icon_floor_addition_selector_s, n.f.icon_floor_addition_selector);
        this.cKt.setOnClickListener(pbActivity.bgT);
    }

    public void fm(boolean z) {
        this.cKv.setVisibility(z ? 0 : 8);
    }

    public NavigationBar anm() {
        return this.mNavigationBar;
    }

    public void kK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cKt.setVisibility(0);
            this.cKt.setText(String.valueOf(str) + this.cGj.getPageContext().getString(n.j.bar));
            m.qQ().ci(str);
        }
    }

    public void ann() {
        this.cKu.setVisibility(4);
        this.cKu.setEnabled(false);
    }

    public void fr(boolean z) {
        if (z) {
            as.c(this.cKu, n.f.s_only_host_button_bg);
        } else {
            as.a(this.cKu, n.f.s_icon_floor_host_bg, n.f.icon_floor_host_bg);
        }
    }

    public void fw(boolean z) {
        if (z) {
            this.cKw.setVisibility(0);
        } else {
            this.cKw.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.cGj.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.cKx = new co((PbActivity) this.cGj.getPageContext().getOrignalPage(), this.cGj.bgT);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.cGj.getPageContext().getPageActivity(), this.cKx.getView(), this.mNavigationBar, as.getDrawable(n.f.bg_pull_down_right_n), new e(this));
                this.mPopWindow.onChangeSkinType(this.cGj, skinType, as.getDrawable(n.f.bg_pull_down_right_n));
            }
            if (z4) {
                this.cKx.fj(false);
            } else {
                this.cKx.fj(true);
            }
            if (z3) {
                this.cKx.fi(false);
            } else {
                this.cKx.fi(true);
            }
            if (h.aj(this.cGj.getPageContext().getPageActivity())) {
                this.cKx.amk().setVisibility(0);
                this.cKx.aml().setVisibility(0);
            } else {
                this.cKx.amk().setVisibility(8);
                this.cKx.aml().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            n(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void n(boolean z, boolean z2) {
        if (this.cKx != null) {
            if (!z) {
                this.cKx.amn().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cKx.amn().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.cKx.amf().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.cKx.amf().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qn() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.cGj.getPageContext().getPageActivity());
        }
    }

    public co ano() {
        return this.cKx;
    }

    public boolean anp() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void afQ() {
        this.mPopWindow = null;
        this.cKx = null;
    }
}
