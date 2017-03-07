package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dt;
import com.baidu.tieba.pb.pb.main.dv;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    private Runnable Jj;
    public final View aIg;
    public View buO;
    private ImageView dZf;
    private PbActivity eka;
    public final TextView euc;
    public final ImageView eud;
    public final ImageView eue;
    private final ImageView euf;
    private final LinearLayout eug;
    private View euj;
    public final NavigationBar mNavigationBar;
    private com.baidu.tieba.pb.view.j euh = null;
    private dt eui = null;
    private boolean euk = false;
    private boolean esb = false;

    public f(PbActivity pbActivity) {
        this.eka = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eka.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new g(this));
        this.aIg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bOI);
        this.buO = new View(this.eka.getPageContext().getPageActivity());
        aq.k(this.buO, w.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.buO, pbActivity.bOI);
        if (this.buO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.buO.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds20);
            this.buO.setLayoutParams(layoutParams);
        }
        this.euc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_title_textview, (View.OnClickListener) null);
        this.euf = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eug = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds20);
        this.eug.setPadding(g, 0, g, 0);
        aq.b(this.euf, w.g.icon_pb_play_small, w.g.icon_pb_play_small);
        this.eug.setVisibility(8);
        this.eud = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_host, pbActivity.bOI);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds26), 0);
        this.eud.setLayoutParams(layoutParams2);
        this.eue = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_more, pbActivity.bOI);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds16), 0);
        this.eue.setLayoutParams(layoutParams3);
        aq.b(this.eue, w.g.icon_more_bg_s, w.g.icon_more_bg);
        this.euc.setOnClickListener(pbActivity.bOI);
        this.eug.setOnClickListener(pbActivity.bOI);
        this.dZf = (ImageView) this.aIg.findViewById(w.h.widget_navi_back_button);
        this.euj = this.mNavigationBar.getBottomLine();
        if (this.euj != null) {
            this.euj.setVisibility(0);
        }
    }

    public void iH(boolean z) {
        this.eue.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aNO() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aIg.setVisibility(0);
        } else {
            this.aIg.setVisibility(8);
        }
        iW(z);
    }

    public void li(String str) {
        if (!TextUtils.isEmpty(str)) {
            iW(true);
            this.euc.setText(String.valueOf(str) + this.eka.getPageContext().getString(w.l.bar));
            l.oQ().bW(str);
        }
    }

    public void aNP() {
        this.eud.setVisibility(4);
        this.eud.setEnabled(false);
    }

    public void iO(boolean z) {
        if (z) {
            aq.c(this.eud, w.g.s_only_host_button_bg);
            this.eud.setContentDescription(this.eka.getResources().getString(w.l.view_host_selected));
        } else {
            aq.b(this.eud, w.g.s_icon_floor_host_bg_s, w.g.icon_floor_host_bg);
            this.eud.setContentDescription(this.eka.getResources().getString(w.l.view_host));
        }
        this.esb = z;
    }

    public void a(dv dvVar) {
        if (!this.eka.isProgressBarShown()) {
            if (this.euh == null) {
                this.eui = new dt((PbActivity) this.eka.getPageContext().getOrignalPage(), this.eka.bOI);
                this.euh = new com.baidu.tieba.pb.view.j(this.eka.getPageContext().getPageActivity(), this.eui.getView(), aq.getDrawable(w.g.bg_pull_down_right_n), new h(this));
            }
            this.eui.RY();
            this.euh.showAtLocation(this.eka.findViewById(w.h.pb_layout), 17, 0, 0);
            this.eui.ix(dvVar == null ? false : dvVar.eoC);
            this.eui.iw(dvVar == null ? false : dvVar.eoE);
            this.eui.iA(dvVar == null ? false : dvVar.eoH);
            this.eui.iB(dvVar == null ? false : dvVar.eoK);
            this.eui.iC(dvVar == null ? false : dvVar.eoL);
            this.eui.iy(dvVar == null ? false : dvVar.eoD);
            this.eui.iD(dvVar == null ? false : dvVar.eoM);
            if (dvVar == null) {
                this.eui.w(false, false);
                this.eui.x(false, false);
            } else {
                this.eui.w(dvVar.eoI, dvVar.eoO);
                this.eui.x(dvVar.eoJ, dvVar.eoN);
            }
            boolean z = dvVar == null ? false : dvVar.eoG;
            boolean z2 = dvVar == null ? false : dvVar.eiu;
            boolean z3 = dvVar == null ? false : dvVar.isHostOnly;
            boolean z4 = dvVar == null ? false : dvVar.eoP;
            this.eui.iz(dvVar != null ? dvVar.eoF : false);
            this.eui.v(z4, z3);
            f(z, z2, z3);
        }
    }

    private void f(boolean z, boolean z2, boolean z3) {
        if (this.eui != null) {
            this.eui.Sc();
            if (!z) {
                this.eui.aMf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eui.aMf().setText(this.eka.getResources().getString(w.l.view_positive_sequence));
            } else {
                this.eui.aMf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eui.aMf().setText(this.eka.getResources().getString(w.l.view_reverse));
            }
            if (z2) {
                this.eui.aLW().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eui.aLW().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eui.aMk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eui.aMk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void ol() {
        if (this.eui != null) {
            this.eui.RZ();
        }
        if (this.Jj == null) {
            this.Jj = new i(this);
        }
        com.baidu.adp.lib.g.h.fM().postDelayed(this.Jj, 100L);
    }

    public dt aNQ() {
        return this.eui;
    }

    public View aNR() {
        return this.eug;
    }

    public boolean Tj() {
        return this.euh != null && this.euh.isShowing();
    }

    public void axf() {
        if (this.eui != null) {
            this.eui.release();
        }
        this.euh = null;
        this.eui = null;
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.Jj);
    }

    public void aNS() {
        this.eud.setVisibility(8);
        this.eue.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eka.getPageContext(), i);
        }
        aq.b(this.eue, w.g.icon_more_bg_s, w.g.icon_more_bg);
        aq.b(this.euc, w.e.cp_cont_b, w.e.s_navbar_title_color);
        aq.k(this.buO, w.e.cp_cont_f_alpha60);
    }

    public void ox(int i) {
        this.mNavigationBar.onChangeSkinType(this.eka.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(w.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eka.getResources().getColor(w.e.black_alpha85));
        this.euj.setVisibility(8);
        aNP();
        this.eue.setImageResource(w.g.icon_more_bg);
        this.euc.setTextColor(this.eka.getResources().getColor(w.e.cp_cont_g));
        this.buO.setBackgroundColor(this.eka.getResources().getColor(w.e.cp_cont_g));
        this.dZf.setImageResource(w.g.icon_return_bg);
    }

    public void aNT() {
        this.dZf.setVisibility(0);
        iW(false);
        this.eud.setVisibility(8);
        this.eue.setVisibility(8);
    }

    public void aNU() {
        this.dZf.setVisibility(0);
        iW(true);
        this.eud.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eue.setVisibility(0);
        } else {
            this.eue.setVisibility(8);
        }
    }

    public void iW(boolean z) {
        if (this.euk) {
            this.euc.setVisibility(8);
            this.buO.setVisibility(8);
            return;
        }
        this.buO.setVisibility(z ? 0 : 8);
        this.euc.setVisibility(z ? 0 : 8);
    }

    public void iX(boolean z) {
        this.euk = z;
    }
}
