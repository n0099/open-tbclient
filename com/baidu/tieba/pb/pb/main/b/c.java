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
import com.baidu.tieba.pb.pb.main.bp;
/* loaded from: classes.dex */
public class c {
    public final View azh;
    private PbActivity ciU;
    public final TextView clU;
    public final ImageView clV;
    public final ImageView clW;
    public final ImageView clX;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow = null;
    private bp clY = null;

    public c(PbActivity pbActivity) {
        this.ciU = pbActivity;
        this.mNavigationBar = (NavigationBar) this.ciU.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new d(this));
        this.azh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.aWQ);
        this.clU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.pb_title_textview, (View.OnClickListener) null);
        this.clX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_add_floor, pbActivity.aWQ);
        this.clV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_host, pbActivity.aWQ);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.d(this.ciU.getPageContext().getPageActivity(), i.d.ds30), 0, k.d(this.ciU.getPageContext().getPageActivity(), i.d.ds26), 0);
        this.clV.setLayoutParams(layoutParams);
        this.clW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, pbActivity.aWQ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.d(this.ciU.getPageContext().getPageActivity(), i.d.ds16), 0);
        this.clW.setLayoutParams(layoutParams2);
        an.a(this.clW, i.e.btn_more_selector_s, i.e.btn_more_selector);
        an.a(this.clX, i.e.icon_floor_addition_selector_s, i.e.icon_floor_addition_selector);
        this.clU.setOnClickListener(pbActivity.aWQ);
    }

    public void eG(boolean z) {
        this.clW.setVisibility(z ? 0 : 8);
    }

    public NavigationBar agQ() {
        return this.mNavigationBar;
    }

    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.clU.setVisibility(0);
            this.clU.setText(String.valueOf(str) + this.ciU.getPageContext().getString(i.h.bar));
        }
    }

    public void agR() {
        this.clV.setVisibility(4);
        this.clV.setEnabled(false);
    }

    public void eL(boolean z) {
        if (z) {
            an.c(this.clV, i.e.s_only_host_button_bg);
        } else {
            an.a(this.clV, i.e.s_icon_floor_host_bg, i.e.icon_floor_host_bg);
        }
    }

    public void eQ(boolean z) {
        if (z) {
            this.clX.setVisibility(0);
        } else {
            this.clX.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        if (!this.ciU.isProgressBarShown()) {
            if (this.mPopWindow == null) {
                this.clY = new bp((PbActivity) this.ciU.getPageContext().getOrignalPage(), this.ciU.aWQ);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.mPopWindow = new MorePopupWindow(this.ciU.getPageContext().getPageActivity(), this.clY.getView(), this.mNavigationBar, an.getDrawable(i.e.bg_pull_down_right_n), new e(this));
                this.mPopWindow.onChangeSkinType(this.ciU, skinType, an.getDrawable(i.e.bg_pull_down_right_n));
            }
            if (z3) {
                this.clY.eB(false);
            } else {
                this.clY.eB(true);
            }
            if (h.aj(this.ciU.getPageContext().getPageActivity())) {
                this.clY.afV().setVisibility(0);
                this.clY.afW().setVisibility(0);
            } else {
                this.clY.afV().setVisibility(8);
                this.clY.afW().setVisibility(8);
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.refresh();
            }
            k(z, z2);
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    private void k(boolean z, boolean z2) {
        if (this.clY != null) {
            if (!z) {
                this.clY.afY().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.clY.afY().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.clY.afU().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.clY.afU().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void qr() {
        if (this.mPopWindow != null) {
            j.a(this.mPopWindow, this.ciU.getPageContext().getPageActivity());
        }
    }

    public bp agS() {
        return this.clY;
    }

    public boolean agT() {
        return this.mPopWindow != null && this.mPopWindow.isShowing();
    }

    public void aaG() {
        this.mPopWindow = null;
        this.clY = null;
    }
}
