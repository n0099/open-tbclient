package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.q;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dr;
import com.baidu.tieba.pb.pb.main.dt;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    private Runnable IJ;
    public final View aIw;
    public View buG;
    private ImageView dEy;
    private PbActivity eig;
    public final TextView esf;
    public final ImageView esg;
    public final ImageView esh;
    private final ImageView esi;
    private final LinearLayout esj;
    private View esm;
    public final NavigationBar mNavigationBar;
    private com.baidu.tieba.pb.view.j esk = null;
    private dr esl = null;
    private boolean esn = false;
    private boolean eqk = false;

    public f(PbActivity pbActivity) {
        this.eig = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eig.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new g(this));
        this.aIw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bOx);
        this.buG = new View(this.eig.getPageContext().getPageActivity());
        aq.k(this.buG, w.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.buG, pbActivity.bOx);
        if (this.buG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.buG.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds20);
            this.buG.setLayoutParams(layoutParams);
        }
        this.esf = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_title_textview, (View.OnClickListener) null);
        this.esi = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.esj = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds20);
        this.esj.setPadding(g, 0, g, 0);
        aq.b(this.esi, w.g.icon_pb_play_small, w.g.icon_pb_play_small);
        this.esj.setVisibility(8);
        this.esg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_host, pbActivity.bOx);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds26), 0);
        this.esg.setLayoutParams(layoutParams2);
        this.esh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_more, pbActivity.bOx);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds16), 0);
        this.esh.setLayoutParams(layoutParams3);
        aq.b(this.esh, w.g.icon_more_bg_s, w.g.icon_more_bg);
        this.esf.setOnClickListener(pbActivity.bOx);
        this.esj.setOnClickListener(pbActivity.bOx);
        this.dEy = (ImageView) this.aIw.findViewById(w.h.widget_navi_back_button);
        this.esm = this.mNavigationBar.getBottomLine();
        if (this.esm != null) {
            this.esm.setVisibility(0);
        }
    }

    public void iG(boolean z) {
        this.esh.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aNX() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aIw.setVisibility(0);
        } else {
            this.aIw.setVisibility(8);
        }
        iV(z);
    }

    public void lo(String str) {
        if (!TextUtils.isEmpty(str)) {
            iV(true);
            this.esf.setText(String.valueOf(str) + this.eig.getPageContext().getString(w.l.bar));
            q.po().cd(str);
        }
    }

    public void aNY() {
        this.esg.setVisibility(4);
        this.esg.setEnabled(false);
    }

    public void iN(boolean z) {
        if (z) {
            aq.c(this.esg, w.g.s_only_host_button_bg);
            this.esg.setContentDescription(this.eig.getResources().getString(w.l.view_host_selected));
        } else {
            aq.b(this.esg, w.g.s_icon_floor_host_bg_s, w.g.icon_floor_host_bg);
            this.esg.setContentDescription(this.eig.getResources().getString(w.l.view_host));
        }
        this.eqk = z;
    }

    public void a(dt dtVar) {
        if (!this.eig.isProgressBarShown()) {
            if (this.esk == null) {
                this.esl = new dr((PbActivity) this.eig.getPageContext().getOrignalPage(), this.eig.bOx);
                this.esk = new com.baidu.tieba.pb.view.j(this.eig.getPageContext().getPageActivity(), this.esl.getView(), aq.getDrawable(w.g.bg_pull_down_right_n), new h(this));
            }
            this.esl.Sw();
            this.esk.showAtLocation(this.eig.findViewById(w.h.pb_layout), 17, 0, 0);
            this.esl.iw(dtVar == null ? false : dtVar.emJ);
            this.esl.iv(dtVar == null ? false : dtVar.emL);
            this.esl.iz(dtVar == null ? false : dtVar.emO);
            this.esl.iA(dtVar == null ? false : dtVar.emR);
            this.esl.iB(dtVar == null ? false : dtVar.emS);
            this.esl.ix(dtVar == null ? false : dtVar.emK);
            this.esl.iC(dtVar == null ? false : dtVar.emT);
            if (dtVar == null) {
                this.esl.w(false, false);
                this.esl.x(false, false);
            } else {
                this.esl.w(dtVar.emP, dtVar.emV);
                this.esl.x(dtVar.emQ, dtVar.emU);
            }
            boolean z = dtVar == null ? false : dtVar.emN;
            boolean z2 = dtVar == null ? false : dtVar.egB;
            boolean z3 = dtVar == null ? false : dtVar.isHostOnly;
            boolean z4 = dtVar == null ? false : dtVar.emW;
            this.esl.iy(dtVar != null ? dtVar.emM : false);
            this.esl.v(z4, z3);
            f(z, z2, z3);
        }
    }

    private void f(boolean z, boolean z2, boolean z3) {
        if (this.esl != null) {
            this.esl.SA();
            if (!z) {
                this.esl.aMo().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.esl.aMo().setText(this.eig.getResources().getString(w.l.view_positive_sequence));
            } else {
                this.esl.aMo().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.esl.aMo().setText(this.eig.getResources().getString(w.l.view_reverse));
            }
            if (z2) {
                this.esl.aMf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.esl.aMf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.esl.aMt().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.esl.aMt().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oI() {
        if (this.esl != null) {
            this.esl.Sx();
        }
        if (this.IJ == null) {
            this.IJ = new i(this);
        }
        com.baidu.adp.lib.g.h.fR().postDelayed(this.IJ, 100L);
    }

    public dr aNZ() {
        return this.esl;
    }

    public View aOa() {
        return this.esj;
    }

    public boolean TH() {
        return this.esk != null && this.esk.isShowing();
    }

    public void awY() {
        if (this.esl != null) {
            this.esl.release();
        }
        this.esk = null;
        this.esl = null;
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.IJ);
    }

    public void aOb() {
        this.esg.setVisibility(8);
        this.esh.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eig.getPageContext(), i);
        }
        aq.b(this.esh, w.g.icon_more_bg_s, w.g.icon_more_bg);
        aq.b(this.esf, w.e.cp_cont_b, w.e.s_navbar_title_color);
        aq.k(this.buG, w.e.cp_cont_f_alpha60);
    }

    public void ov(int i) {
        this.mNavigationBar.onChangeSkinType(this.eig.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(w.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eig.getResources().getColor(w.e.black_alpha85));
        this.esm.setVisibility(8);
        aNY();
        this.esh.setImageResource(w.g.icon_more_bg);
        this.esf.setTextColor(this.eig.getResources().getColor(w.e.cp_cont_g));
        this.buG.setBackgroundColor(this.eig.getResources().getColor(w.e.cp_cont_g));
        this.dEy.setImageResource(w.g.icon_return_bg);
    }

    public void aOc() {
        this.dEy.setVisibility(0);
        iV(false);
        this.esg.setVisibility(8);
        this.esh.setVisibility(8);
    }

    public void aOd() {
        this.dEy.setVisibility(0);
        iV(true);
        this.esg.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.esh.setVisibility(0);
        } else {
            this.esh.setVisibility(8);
        }
    }

    public void iV(boolean z) {
        if (this.esn) {
            this.esf.setVisibility(8);
            this.buG.setVisibility(8);
            return;
        }
        this.buG.setVisibility(z ? 0 : 8);
        this.esf.setVisibility(z ? 0 : 8);
    }

    public void iW(boolean z) {
        this.esn = z;
    }
}
