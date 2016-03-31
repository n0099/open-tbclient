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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dp;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    public final View aDt;
    private PbActivity dfw;
    public final TextView dnF;
    public final ImageView dnG;
    public final ImageView dnH;
    public final ImageView dnI;
    public final NavigationBar mNavigationBar;
    private MorePopupWindow PS = null;
    private dp dnJ = null;

    public e(PbActivity pbActivity) {
        this.dfw = pbActivity;
        this.mNavigationBar = (NavigationBar) this.dfw.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new f(this));
        this.aDt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.boQ);
        this.dnF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.pb_title_textview, (View.OnClickListener) null);
        this.dnI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_add_floor, pbActivity.boQ);
        this.dnG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_host, pbActivity.boQ);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.c(this.dfw.getPageContext().getPageActivity(), t.e.ds30), 0, k.c(this.dfw.getPageContext().getPageActivity(), t.e.ds26), 0);
        this.dnG.setLayoutParams(layoutParams);
        this.dnH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, pbActivity.boQ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.c(this.dfw.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.dnH.setLayoutParams(layoutParams2);
        at.a(this.dnH, t.f.btn_more_selector_s, t.f.btn_more_selector);
        at.a(this.dnI, t.f.icon_floor_addition_selector_s, t.f.icon_floor_addition_selector);
        this.dnF.setOnClickListener(pbActivity.boQ);
    }

    public void gm(boolean z) {
        this.dnH.setVisibility(z ? 0 : 8);
    }

    public NavigationBar azu() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.dnF.setVisibility(0);
            this.aDt.setVisibility(0);
            return;
        }
        this.dnF.setVisibility(8);
        this.aDt.setVisibility(8);
    }

    public void kt(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dnF.setVisibility(0);
            this.dnF.setText(String.valueOf(str) + this.dfw.getPageContext().getString(t.j.bar));
            l.qE().ce(str);
        }
    }

    public void azv() {
        this.dnG.setVisibility(4);
        this.dnG.setEnabled(false);
    }

    public void gu(boolean z) {
        if (z) {
            at.c(this.dnG, t.f.s_only_host_button_bg);
            this.dnG.setContentDescription(this.dfw.getResources().getString(t.j.view_host_selected));
            return;
        }
        at.a(this.dnG, t.f.s_icon_floor_host_bg, t.f.icon_floor_host_bg);
        this.dnG.setContentDescription(this.dfw.getResources().getString(t.j.view_host));
    }

    public void gz(boolean z) {
        if (z) {
            this.dnI.setVisibility(0);
        } else {
            this.dnI.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.dfw.isProgressBarShown()) {
            if (this.PS == null) {
                this.dnJ = new dp((PbActivity) this.dfw.getPageContext().getOrignalPage(), this.dfw.boQ);
                int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                this.PS = new MorePopupWindow(this.dfw.getPageContext().getPageActivity(), this.dnJ.getView(), this.mNavigationBar, at.getDrawable(t.f.bg_pull_down_right_n), new g(this));
                this.PS.onChangeSkinType(this.dfw, skinType, at.getDrawable(t.f.bg_pull_down_right_n));
            }
            if (z4) {
                this.dnJ.gi(false);
            } else {
                this.dnJ.gi(true);
            }
            if (z3) {
                this.dnJ.gh(false);
            } else {
                this.dnJ.gh(true);
            }
            if (h.ag(this.dfw.getPageContext().getPageActivity())) {
                this.dnJ.axK().setVisibility(0);
                this.dnJ.axL().setVisibility(0);
            } else {
                this.dnJ.axK().setVisibility(8);
                this.dnJ.axL().setVisibility(8);
            }
            if (this.PS != null) {
                this.PS.refresh();
            }
            r(z, z2);
            this.PS.showWindowInRightBottomOfHost();
        }
    }

    private void r(boolean z, boolean z2) {
        if (this.dnJ != null) {
            if (!z) {
                this.dnJ.axN().setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_recommend_see_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.dnJ.axN().setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_recommend_see_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.dnJ.axB().setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_recommend_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.dnJ.axB().setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_recommend_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void pZ() {
        if (this.PS != null) {
            j.a(this.PS, this.dfw.getPageContext().getPageActivity());
        }
    }

    public dp azw() {
        return this.dnJ;
    }

    public boolean azx() {
        return this.PS != null && this.PS.isShowing();
    }

    public void anl() {
        this.PS = null;
        this.dnJ = null;
    }

    public void azy() {
        this.dnG.setVisibility(8);
        this.dnH.setVisibility(8);
    }
}
