package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ds;
import com.baidu.tieba.pb.pb.main.du;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f {
    private Runnable BU;
    public final View aCJ;
    private View bnS;
    private ImageView dWl;
    private PbActivity ehi;
    public final TextView eqR;
    public final ImageView eqS;
    public final ImageView eqT;
    private View eqW;
    public final NavigationBar mNavigationBar;
    private com.baidu.tieba.pb.view.j eqU = null;
    private ds eqV = null;
    private boolean eoX = false;

    public f(PbActivity pbActivity) {
        this.ehi = pbActivity;
        this.mNavigationBar = (NavigationBar) this.ehi.findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new g(this));
        this.aCJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bHz);
        this.bnS = new View(this.ehi.getPageContext().getPageActivity());
        ap.k(this.bnS, r.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bnS, pbActivity.bHz);
        if (this.bnS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnS.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds20);
            this.bnS.setLayoutParams(layoutParams);
        }
        this.eqR = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.j.pb_title_textview, (View.OnClickListener) null);
        this.eqS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.nb_item_floor_host, pbActivity.bHz);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds30), 0, com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds26), 0);
        this.eqS.setLayoutParams(layoutParams2);
        this.eqT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.nb_item_floor_more, pbActivity.bHz);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds16), 0);
        this.eqT.setLayoutParams(layoutParams3);
        ap.b(this.eqT, r.g.icon_more_bg_s, r.g.icon_more_bg);
        this.eqR.setOnClickListener(pbActivity.bHz);
        this.dWl = (ImageView) this.aCJ.findViewById(r.h.widget_navi_back_button);
        this.eqW = this.mNavigationBar.getBottomLine();
        if (this.eqW != null) {
            this.eqW.setVisibility(0);
        }
    }

    public void iM(boolean z) {
        this.eqT.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aOw() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.eqR.setVisibility(0);
            this.aCJ.setVisibility(0);
            return;
        }
        this.eqR.setVisibility(8);
        this.aCJ.setVisibility(8);
    }

    public void lH(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eqR.setVisibility(0);
            this.eqR.setText(String.valueOf(str) + this.ehi.getPageContext().getString(r.l.bar));
            l.oC().cd(str);
        }
    }

    public void aOx() {
        this.eqS.setVisibility(4);
        this.eqS.setEnabled(false);
    }

    public void iT(boolean z) {
        if (z) {
            ap.c(this.eqS, r.g.s_only_host_button_bg);
            this.eqS.setContentDescription(this.ehi.getResources().getString(r.l.view_host_selected));
        } else {
            ap.b(this.eqS, r.g.s_icon_floor_host_bg_s, r.g.icon_floor_host_bg);
            this.eqS.setContentDescription(this.ehi.getResources().getString(r.l.view_host));
        }
        this.eoX = z;
    }

    public void a(du duVar) {
        if (!this.ehi.isProgressBarShown()) {
            if (this.eqU == null) {
                this.eqV = new ds((PbActivity) this.ehi.getPageContext().getOrignalPage(), this.ehi.bHz);
                this.eqU = new com.baidu.tieba.pb.view.j(this.ehi.getPageContext().getPageActivity(), this.eqV.getView(), ap.getDrawable(r.g.bg_pull_down_right_n), new h(this));
            }
            this.eqV.Rc();
            this.eqU.showAtLocation(this.ehi.findViewById(r.h.pb_layout), 17, 0, 0);
            this.eqV.iB(duVar == null ? false : duVar.elE);
            this.eqV.iA(duVar == null ? false : duVar.elG);
            this.eqV.iD(duVar == null ? false : duVar.elJ);
            this.eqV.iF(duVar == null ? false : duVar.elK);
            this.eqV.iG(duVar == null ? false : duVar.elN);
            this.eqV.iH(duVar == null ? false : duVar.elO);
            this.eqV.iC(duVar == null ? false : duVar.elF);
            this.eqV.iI(duVar == null ? false : duVar.elP);
            if (duVar == null) {
                this.eqV.x(false, false);
                this.eqV.y(false, false);
            } else {
                this.eqV.x(duVar.elL, duVar.elR);
                this.eqV.y(duVar.elM, duVar.elQ);
            }
            boolean z = duVar == null ? false : duVar.elI;
            boolean z2 = duVar == null ? false : duVar.efY;
            boolean z3 = duVar == null ? false : duVar.isHostOnly;
            boolean z4 = duVar == null ? false : duVar.elS;
            this.eqV.iE(duVar != null ? duVar.elH : false);
            this.eqV.w(z4, z3);
            f(z, z2, z3);
        }
    }

    private void f(boolean z, boolean z2, boolean z3) {
        if (this.eqV != null) {
            this.eqV.Rg();
            if (!z) {
                this.eqV.aMK().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eqV.aMK().setText(this.ehi.getResources().getString(r.l.view_positive_sequence));
            } else {
                this.eqV.aMK().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eqV.aMK().setText(this.ehi.getResources().getString(r.l.view_reverse));
            }
            if (z2) {
                this.eqV.aMz().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eqV.aMz().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eqV.aMR().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eqV.aMR().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(r.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void nX() {
        if (this.eqV != null) {
            this.eqV.Rd();
        }
        if (this.BU == null) {
            this.BU = new i(this);
        }
        com.baidu.adp.lib.g.h.eE().postDelayed(this.BU, 100L);
    }

    public ds aOy() {
        return this.eqV;
    }

    public boolean aOz() {
        return this.eqU != null && this.eqU.isShowing();
    }

    public void axJ() {
        if (this.eqV != null) {
            this.eqV.release();
        }
        this.eqU = null;
        this.eqV = null;
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.BU);
    }

    public void aOA() {
        this.eqS.setVisibility(8);
        this.eqT.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ehi.getPageContext(), i);
        }
        ap.b(this.eqT, r.g.icon_more_bg_s, r.g.icon_more_bg);
        ap.b(this.eqR, r.e.cp_cont_b, r.e.s_navbar_title_color);
        ap.k(this.bnS, r.e.cp_cont_f_alpha60);
    }

    public void aOB() {
        this.mNavigationBar.setBackgroundColor(0);
        this.eqW.setVisibility(8);
        aOx();
        this.eqT.setImageResource(r.g.icon_more_bg);
        this.eqR.setTextColor(this.ehi.getResources().getColor(r.e.cp_cont_g));
        this.bnS.setBackgroundColor(this.ehi.getResources().getColor(r.e.cp_cont_g));
        this.dWl.setImageResource(r.g.icon_return_bg);
    }

    public void aOC() {
        this.dWl.setVisibility(0);
        this.bnS.setVisibility(8);
        this.eqR.setVisibility(8);
        this.eqS.setVisibility(8);
        this.eqT.setVisibility(8);
    }

    public void aOD() {
        this.dWl.setVisibility(0);
        this.bnS.setVisibility(0);
        this.eqR.setVisibility(0);
        this.eqS.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eqT.setVisibility(0);
        } else {
            this.eqT.setVisibility(8);
        }
    }
}
