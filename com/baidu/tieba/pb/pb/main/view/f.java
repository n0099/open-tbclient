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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.eg;
import com.baidu.tieba.pb.pb.main.ei;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    private Runnable aDM;
    public final View aIC;
    public View bIo;
    private ImageView dBl;
    private PbActivity efF;
    public final TextView eqa;
    public final ImageView eqb;
    public final ImageView eqc;
    private final ImageView eqd;
    private final LinearLayout eqe;
    private View eqh;
    public final NavigationBar mNavigationBar;
    private com.baidu.tieba.pb.view.j eqf = null;
    private eg eqg = null;
    private boolean eqi = false;
    private boolean eok = false;

    public f(PbActivity pbActivity) {
        this.efF = pbActivity;
        this.mNavigationBar = (NavigationBar) this.efF.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new g(this));
        this.aIC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bPI);
        this.aIC.setPadding(com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds22), this.aIC.getPaddingTop(), this.aIC.getPaddingRight(), this.aIC.getPaddingBottom());
        this.bIo = new View(this.efF.getPageContext().getPageActivity());
        this.bIo.setVisibility(8);
        aq.k(this.bIo, w.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bIo, pbActivity.bPI);
        if (this.bIo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIo.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds20);
            this.bIo.setLayoutParams(layoutParams);
        }
        this.eqa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_title_textview, (View.OnClickListener) null);
        this.eqd = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eqe = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds20);
        this.eqe.setPadding(g, 0, g, 0);
        aq.b(this.eqd, w.g.icon_pb_play_small, w.g.icon_pb_play_small);
        this.eqe.setVisibility(8);
        this.eqb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_host, pbActivity.bPI);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds26), 0);
        this.eqb.setLayoutParams(layoutParams2);
        this.eqc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_more, pbActivity.bPI);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds40), 0);
        this.eqc.setLayoutParams(layoutParams3);
        aq.b(this.eqc, w.g.icon_nav_more_selector, w.g.icon_nav_more_selector);
        this.eqa.setOnClickListener(pbActivity.bPI);
        this.eqe.setOnClickListener(pbActivity.bPI);
        this.dBl = (ImageView) this.aIC.findViewById(w.h.widget_navi_back_button);
        this.eqh = this.mNavigationBar.getBottomLine();
        if (this.eqh != null) {
            this.eqh.setVisibility(8);
        }
    }

    public void iw(boolean z) {
        this.eqc.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aMn() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aIC.setVisibility(0);
        } else {
            this.aIC.setVisibility(8);
        }
        iK(z);
    }

    public void lt(String str) {
        if (!TextUtils.isEmpty(str)) {
            iK(true);
            this.eqa.setText(String.format(this.efF.getResources().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)), new Object[0]));
            r.oV().cd(str);
            return;
        }
        iK(false);
    }

    public void aMo() {
        this.eqb.setVisibility(4);
        this.eqb.setEnabled(false);
    }

    public void iC(boolean z) {
        if (z) {
            aq.c(this.eqb, w.g.s_only_host_button_bg);
            this.eqb.setContentDescription(this.efF.getResources().getString(w.l.view_host_selected));
        } else {
            aq.b(this.eqb, w.g.icon_floor_host_bg, w.g.icon_floor_host_bg);
            this.eqb.setContentDescription(this.efF.getResources().getString(w.l.view_host));
        }
        this.eok = z;
    }

    public void a(ei eiVar) {
        if (!this.efF.isProgressBarShown()) {
            if (this.eqf == null) {
                this.eqg = new eg((PbActivity) this.efF.getPageContext().getOrignalPage(), this.efF.bPI);
                this.eqf = new com.baidu.tieba.pb.view.j(this.efF.getPageContext().getPageActivity(), this.eqg.getView(), aq.getDrawable(w.g.bg_pull_down_right_n), new h(this));
            }
            this.eqg.SS();
            this.eqf.showAtLocation(this.efF.findViewById(w.h.pb_layout), 17, 0, 0);
            this.eqg.il(eiVar == null ? false : eiVar.ela);
            this.eqg.ik(eiVar == null ? false : eiVar.elc);
            this.eqg.io(eiVar == null ? false : eiVar.eli);
            this.eqg.ip(eiVar == null ? false : eiVar.elj);
            this.eqg.im(eiVar == null ? false : eiVar.elb);
            this.eqg.iq(eiVar == null ? false : eiVar.elk);
            if (eiVar == null) {
                this.eqg.w(false, false);
                this.eqg.x(false, false);
            } else {
                this.eqg.w(eiVar.elg, eiVar.elm);
                this.eqg.x(eiVar.elh, eiVar.ell);
            }
            boolean z = eiVar == null ? false : eiVar.ele;
            boolean z2 = eiVar == null ? false : eiVar.edS;
            boolean z3 = eiVar == null ? false : eiVar.isHostOnly;
            boolean z4 = eiVar == null ? false : eiVar.eln;
            this.eqg.in(eiVar != null ? eiVar.eld : false);
            this.eqg.v(z4, z3);
            h(z, z2, z3);
        }
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.eqg != null) {
            this.eqg.SW();
            if (z) {
                this.eqg.aKH().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eqg.aKH().setText(this.efF.getResources().getString(w.l.view_reverse));
            } else {
                this.eqg.aKH().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eqg.aKH().setText(this.efF.getResources().getString(w.l.view_positive_sequence));
            }
            if (z2) {
                this.eqg.aKy().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eqg.aKy().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eqg.aKL().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eqg.aKL().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void op() {
        if (this.eqg != null) {
            this.eqg.ST();
        }
        if (this.aDM == null) {
            this.aDM = new i(this);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this.aDM, 100L);
    }

    public eg aMp() {
        return this.eqg;
    }

    public View aMq() {
        return this.eqe;
    }

    public boolean Ub() {
        return this.eqf != null && this.eqf.isShowing();
    }

    public void auV() {
        if (this.eqg != null) {
            this.eqg.release();
        }
        this.eqf = null;
        this.eqg = null;
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aDM);
    }

    public void aMr() {
        this.eqb.setVisibility(8);
        this.eqc.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cM(w.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.efF.getPageContext(), i);
        }
        aq.b(this.eqc, w.g.icon_nav_more_selector, w.g.icon_nav_more_selector);
        aq.b(this.eqa, w.e.cp_cont_b, w.e.s_navbar_title_color);
        aq.k(this.bIo, w.e.cp_cont_f_alpha60);
    }

    public void or(int i) {
        this.mNavigationBar.onChangeSkinType(this.efF.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(w.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.efF.getResources().getColor(w.e.black_alpha85));
        this.eqh.setVisibility(8);
        aMo();
        this.eqc.setImageResource(w.g.icon_more_bg);
        this.eqa.setTextColor(this.efF.getResources().getColor(w.e.cp_cont_g));
        this.bIo.setBackgroundColor(this.efF.getResources().getColor(w.e.cp_cont_g));
        this.dBl.setImageResource(w.g.icon_return_bg);
    }

    public void aMs() {
        this.dBl.setVisibility(0);
        iK(false);
        this.eqb.setVisibility(8);
        this.eqc.setVisibility(8);
    }

    public void aMt() {
        this.dBl.setVisibility(0);
        iK(false);
        this.eqb.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eqc.setVisibility(0);
        } else {
            this.eqc.setVisibility(8);
        }
    }

    public void iK(boolean z) {
        if (z) {
            this.eqa.setVisibility(0);
            this.bIo.setVisibility(0);
            return;
        }
        this.eqa.setVisibility(8);
        this.bIo.setVisibility(8);
    }

    public void iL(boolean z) {
        this.eqi = z;
    }
}
