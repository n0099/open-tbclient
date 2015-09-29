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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bp;
/* loaded from: classes.dex */
public class c {
    public final View ayW;
    private PbActivity ciJ;
    public final TextView clJ;
    public final ImageView clK;
    public final ImageView clL;
    public final ImageView clM;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bp clN = null;

    public c(PbActivity pbActivity) {
        this.ciJ = pbActivity;
        this.mNavigationBar = (NavigationBar) this.ciJ.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new d(this));
        this.ayW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aWF);
        this.clJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.pb_title_textview, (View.OnClickListener) null);
        this.clM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_add_floor, pbActivity.aWF);
        this.clK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_host, pbActivity.aWF);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.d(this.ciJ.getPageContext().getPageActivity(), i.d.ds30), 0, k.d(this.ciJ.getPageContext().getPageActivity(), i.d.ds26), 0);
        this.clK.setLayoutParams(layoutParams);
        this.clL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, pbActivity.aWF);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.d(this.ciJ.getPageContext().getPageActivity(), i.d.ds16), 0);
        this.clL.setLayoutParams(layoutParams2);
        am.a(this.clL, i.e.btn_more_selector_s, i.e.btn_more_selector);
        am.a(this.clM, i.e.icon_floor_addition_selector_s, i.e.icon_floor_addition_selector);
        this.clJ.setOnClickListener(pbActivity.aWF);
    }

    public void eG(boolean z) {
        this.clL.setVisibility(z ? 0 : 8);
    }

    public NavigationBar agU() {
        return this.mNavigationBar;
    }

    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.clJ.setVisibility(0);
            this.clJ.setText(String.valueOf(str) + this.ciJ.getPageContext().getString(i.h.bar));
        }
    }

    public void agV() {
        this.clK.setVisibility(4);
        this.clK.setEnabled(false);
    }

    public void eL(boolean z) {
        if (z) {
            am.c(this.clK, i.e.s_only_host_button_bg);
        } else {
            am.a(this.clK, i.e.s_icon_floor_host_bg, i.e.icon_floor_host_bg);
        }
    }

    public void eQ(boolean z) {
        if (z) {
            this.clM.setVisibility(0);
        } else {
            this.clM.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.ciJ.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.clN = new bp((PbActivity) this.ciJ.getPageContext().getOrignalPage(), this.ciJ.aWF);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.ciJ.getPageContext().getPageActivity(), this.clN.getView(), this.mNavigationBar, am.getDrawable(i.e.bg_pull_down_right_n), new e(this));
                this.mPopWindow.onChangeSkinType(this.ciJ, skinType, am.getDrawable(i.e.bg_pull_down_right_n));
            }
            if (z3) {
                this.clN.eB(false);
            } else {
                this.clN.eB(true);
            }
            if (h.aj(this.ciJ.getPageContext().getPageActivity())) {
                this.clN.afZ().setVisibility(0);
                this.clN.aga().setVisibility(0);
            } else {
                this.clN.afZ().setVisibility(8);
                this.clN.aga().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            k(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void k(boolean z, boolean z2) {
        if (this.clN != null) {
            if (!z) {
                this.clN.agc().setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.clN.agc().setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.clN.afY().setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.clN.afY().setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qu() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.ciJ.getPageContext().getPageActivity());
        }
    }

    public bp agW() {
        return this.clN;
    }

    public boolean agX() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void aaK() {
        this.mPopWindow = null;
        this.clN = null;
    }
}
