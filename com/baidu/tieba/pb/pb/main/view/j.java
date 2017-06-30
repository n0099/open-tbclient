package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.r;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ey;
import com.baidu.tieba.pb.pb.main.fa;
import com.baidu.tieba.pb.view.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j {
    private Runnable aEN;
    public final View aJD;
    public View bUX;
    public final TextView eGH;
    public final ImageView eGI;
    public final ImageView eGJ;
    public final ImageView eGK;
    private final ImageView eGL;
    private final LinearLayout eGM;
    private View eGP;
    private ImageView eib;
    private PbActivity euf;
    public final NavigationBar mNavigationBar;
    private x eGN = null;
    private ey eGO = null;
    private boolean eGQ = false;
    private boolean eDj = false;

    public j(PbActivity pbActivity) {
        this.euf = pbActivity;
        this.mNavigationBar = (NavigationBar) this.euf.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new k(this));
        this.aJD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cdH);
        this.aJD.setPadding(com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds22), this.aJD.getPaddingTop(), this.aJD.getPaddingRight(), this.aJD.getPaddingBottom());
        this.bUX = new View(this.euf.getPageContext().getPageActivity());
        this.bUX.setVisibility(8);
        as.k(this.bUX, w.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bUX, pbActivity.cdH);
        if (this.bUX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUX.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds20);
            this.bUX.setLayoutParams(layoutParams);
        }
        this.eGH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_title_textview, (View.OnClickListener) null);
        this.eGL = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eGM = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds20);
        this.eGM.setPadding(g, 0, g, 0);
        as.b(this.eGL, w.g.icon_pb_play_small, w.g.icon_pb_play_small);
        this.eGL.setVisibility(8);
        this.eGI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_host, pbActivity.cdH);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds26), 0);
        this.eGI.setLayoutParams(layoutParams2);
        this.eGI.setVisibility(8);
        this.eGK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_share, pbActivity.cdH);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds40), 0);
        this.eGK.setLayoutParams(layoutParams3);
        this.eGK.setVisibility(8);
        as.b(this.eGK, w.g.icon_pb_share_selector, w.g.icon_pb_share_selector);
        this.eGJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_more, pbActivity.cdH);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds40), 0);
        this.eGJ.setLayoutParams(layoutParams4);
        as.b(this.eGJ, w.g.icon_nav_more_selector, w.g.icon_nav_more_selector);
        this.eGH.setOnClickListener(pbActivity.cdH);
        this.eGL.setOnClickListener(pbActivity.cdH);
        this.eib = (ImageView) this.aJD.findViewById(w.h.widget_navi_back_button);
        this.eGP = this.mNavigationBar.getBottomLine();
        if (this.eGP != null) {
            this.eGP.setVisibility(8);
        }
    }

    public void jj(boolean z) {
        this.eGJ.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aRx() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aJD.setVisibility(0);
        } else {
            this.aJD.setVisibility(8);
        }
        jy(z);
    }

    public void mA(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eGH.setText(this.euf.getResources().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)));
            jy(true);
            r.oK().cj(str);
            return;
        }
        jy(false);
    }

    public void aRy() {
        this.eGI.setVisibility(4);
        this.eGI.setEnabled(false);
    }

    public void jn(boolean z) {
        if (z) {
            as.c(this.eGI, w.g.s_only_host_button_bg);
            this.eGI.setContentDescription(this.euf.getResources().getString(w.l.view_host_selected));
        } else {
            as.b(this.eGI, w.g.icon_floor_host_bg, w.g.icon_floor_host_bg);
            this.eGI.setContentDescription(this.euf.getResources().getString(w.l.view_host));
        }
        this.eDj = z;
    }

    public void a(fa faVar) {
        if (!this.euf.isProgressBarShown()) {
            if (this.eGN == null) {
                this.eGO = new ey((PbActivity) this.euf.getPageContext().getOrignalPage(), this.euf.cdH);
                this.eGN = new x(this.euf.getPageContext().getPageActivity(), this.eGO.getView(), as.getDrawable(w.g.bg_pull_down_right_n), new l(this));
            }
            this.eGO.UG();
            this.eGN.showAtLocation(this.euf.findViewById(w.h.pb_layout), 17, 0, 0);
            this.eGO.iW(faVar == null ? false : faVar.ezY);
            this.eGO.iV(faVar == null ? false : faVar.eAa);
            this.eGO.iZ(faVar == null ? false : faVar.eAg);
            this.eGO.ja(faVar == null ? false : faVar.eAh);
            this.eGO.iX(faVar == null ? false : faVar.ezZ);
            this.eGO.jc(faVar == null ? false : faVar.eAd);
            this.eGO.jb(faVar == null ? false : faVar.eAi);
            if (faVar == null) {
                this.eGO.A(false, false);
                this.eGO.B(false, false);
            } else {
                this.eGO.A(faVar.eAe, faVar.eAk);
                this.eGO.B(faVar.eAf, faVar.eAj);
            }
            boolean z = faVar == null ? false : faVar.eAc;
            boolean z2 = faVar == null ? false : faVar.esq;
            boolean z3 = faVar == null ? false : faVar.isHostOnly;
            boolean z4 = faVar == null ? false : faVar.eAl;
            this.eGO.iY(faVar != null ? faVar.eAb : false);
            this.eGO.z(z4, z3);
            g(z, z2, z3);
        }
    }

    private void g(boolean z, boolean z2, boolean z3) {
        if (this.eGO != null) {
            this.eGO.UK();
            if (z) {
                this.eGO.aPA().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eGO.aPA().setText(this.euf.getResources().getString(w.l.view_reverse));
            } else {
                this.eGO.aPA().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.getDrawable(w.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eGO.aPA().setText(this.euf.getResources().getString(w.l.view_positive_sequence));
            }
            if (z2) {
                this.eGO.aPr().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.getDrawable(w.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eGO.aPr().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eGO.aPE().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.getDrawable(w.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eGO.aPE().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void od() {
        if (this.eGO != null) {
            this.eGO.UH();
        }
        if (this.aEN == null) {
            this.aEN = new m(this);
        }
        com.baidu.adp.lib.g.h.fR().postDelayed(this.aEN, 100L);
    }

    public ey aRz() {
        return this.eGO;
    }

    public View aRA() {
        return this.eGL;
    }

    public boolean Ww() {
        return this.eGN != null && this.eGN.isShowing();
    }

    public void azN() {
        if (this.eGO != null) {
            this.eGO.release();
        }
        this.eGN = null;
        this.eGO = null;
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aEN);
    }

    public void aRB() {
        this.eGI.setVisibility(8);
        this.eGJ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(as.cP(w.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.euf.getPageContext(), i);
        }
        as.b(this.eGJ, w.g.icon_nav_more_selector, w.g.icon_nav_more_selector);
        as.b(this.eGH, w.e.cp_cont_b, w.e.s_navbar_title_color);
        as.k(this.bUX, w.e.cp_cont_f_alpha60);
    }

    public void pi(int i) {
        this.mNavigationBar.onChangeSkinType(this.euf.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(w.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.euf.getResources().getColor(w.e.black_alpha85));
        this.eGP.setVisibility(8);
        aRy();
        this.eGK.setImageResource(w.g.icon_pb_share_selector);
        this.eGJ.setImageResource(w.g.icon_more_bg);
        this.eGH.setTextColor(this.euf.getResources().getColor(w.e.cp_cont_g));
        this.bUX.setBackgroundColor(this.euf.getResources().getColor(w.e.cp_cont_g));
        this.eib.setImageResource(w.g.icon_return_bg);
    }

    public void aRC() {
        this.eib.setVisibility(0);
        jy(false);
        this.eGI.setVisibility(8);
        this.eGJ.setVisibility(8);
    }

    public void jx(boolean z) {
        this.eib.setVisibility(0);
        jy(z);
        this.eGI.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eGJ.setVisibility(0);
        } else {
            this.eGJ.setVisibility(8);
        }
    }

    public void jy(boolean z) {
        if (z && !"".equals(this.eGH.getText().toString())) {
            this.eGH.setVisibility(0);
            this.bUX.setVisibility(0);
            return;
        }
        this.eGH.setVisibility(8);
        this.bUX.setVisibility(8);
    }

    public void jz(boolean z) {
    }

    public void jA(boolean z) {
        this.eGQ = z;
    }
}
