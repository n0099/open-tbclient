package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.pb.view.j;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    public final View azx;
    private PbActivity dhY;
    public final TextView dpU;
    public final ImageView dpV;
    public final ImageView dpW;
    public final ImageView dpX;
    private j dpY = null;
    private df dpZ = null;
    public final NavigationBar mNavigationBar;
    private Runnable zT;

    public e(PbActivity pbActivity) {
        this.dhY = pbActivity;
        this.mNavigationBar = (NavigationBar) this.dhY.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new f(this));
        this.azx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bjV);
        this.dpU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.pb_title_textview, (View.OnClickListener) null);
        this.dpX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_add_floor, pbActivity.bjV);
        this.dpV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_host, pbActivity.bjV);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.c(this.dhY.getPageContext().getPageActivity(), t.e.ds30), 0, k.c(this.dhY.getPageContext().getPageActivity(), t.e.ds26), 0);
        this.dpV.setLayoutParams(layoutParams);
        this.dpW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, pbActivity.bjV);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.c(this.dhY.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.dpW.setLayoutParams(layoutParams2);
        at.a(this.dpW, t.f.btn_more_selector_s, t.f.btn_more_selector);
        at.a(this.dpX, t.f.icon_floor_addition_selector_s, t.f.icon_floor_addition_selector);
        this.dpU.setOnClickListener(pbActivity.bjV);
    }

    public void gP(boolean z) {
        this.dpW.setVisibility(z ? 0 : 8);
    }

    public NavigationBar azL() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.dpU.setVisibility(0);
            this.azx.setVisibility(0);
            return;
        }
        this.dpU.setVisibility(8);
        this.azx.setVisibility(8);
    }

    public void kx(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dpU.setVisibility(0);
            this.dpU.setText(String.valueOf(str) + this.dhY.getPageContext().getString(t.j.bar));
            l.ob().cc(str);
        }
    }

    public void azM() {
        this.dpV.setVisibility(4);
        this.dpV.setEnabled(false);
    }

    public void gX(boolean z) {
        if (z) {
            at.c(this.dpV, t.f.s_only_host_button_bg);
            this.dpV.setContentDescription(this.dhY.getResources().getString(t.j.view_host_selected));
            return;
        }
        at.a(this.dpV, t.f.s_icon_floor_host_bg_s, t.f.icon_floor_host_bg);
        this.dpV.setContentDescription(this.dhY.getResources().getString(t.j.view_host));
    }

    public void hd(boolean z) {
        if (z) {
            this.dpX.setVisibility(0);
        } else {
            this.dpX.setVisibility(8);
        }
    }

    public void b(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!this.dhY.isProgressBarShown()) {
            if (this.dpY == null) {
                this.dpZ = new df((PbActivity) this.dhY.getPageContext().getOrignalPage(), this.dhY.bjV);
                this.dpY = new j(this.dhY.getPageContext().getPageActivity(), this.dpZ.getView(), at.getDrawable(t.f.bg_pull_down_right_n), new g(this));
            }
            this.dpZ.ayo();
            this.dpY.showAtLocation(this.dhY.findViewById(t.g.pb_layout), 17, 0, 0);
            if (z4) {
                this.dpZ.gL(false);
            } else {
                this.dpZ.gL(true);
            }
            if (z3) {
                this.dpZ.gK(false);
            } else {
                this.dpZ.gK(true);
            }
            if (com.baidu.tbadk.coreExtra.share.h.af(this.dhY.getPageContext().getPageActivity())) {
                this.dpZ.ayh().setVisibility(0);
            } else {
                this.dpZ.ayh().setVisibility(8);
            }
            r(z, z2);
        }
    }

    private void r(boolean z, boolean z2) {
        if (this.dpZ != null) {
            this.dpZ.ayq();
            if (!z) {
                this.dpZ.ayj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(t.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.dpZ.ayj().setText(this.dhY.getResources().getString(t.j.view_positive_sequence));
            } else {
                this.dpZ.ayj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(t.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.dpZ.ayj().setText(this.dhY.getResources().getString(t.j.view_reverse));
            }
            if (z2) {
                this.dpZ.axY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(t.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.dpZ.axY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(t.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void nv() {
        if (this.dpZ != null) {
            this.dpZ.ayp();
        }
        if (this.zT == null) {
            this.zT = new h(this);
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(this.zT, 100L);
    }

    public df azN() {
        return this.dpZ;
    }

    public boolean azO() {
        return this.dpY != null && this.dpY.isShowing();
    }

    public void anh() {
        if (this.dpZ != null) {
            this.dpZ.release();
        }
        this.dpY = null;
        this.dpZ = null;
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.zT);
    }

    public void azP() {
        this.dpV.setVisibility(8);
        this.dpW.setVisibility(8);
    }
}
