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
    private Runnable IL;
    public final View aIy;
    public View bwX;
    private ImageView dGO;
    private PbActivity ekw;
    private final ImageView euA;
    private final LinearLayout euB;
    private View euE;
    public final TextView eux;
    public final ImageView euy;
    public final ImageView euz;
    public final NavigationBar mNavigationBar;
    private com.baidu.tieba.pb.view.j euC = null;
    private dr euD = null;
    private boolean euF = false;
    private boolean esB = false;

    public f(PbActivity pbActivity) {
        this.ekw = pbActivity;
        this.mNavigationBar = (NavigationBar) this.ekw.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new g(this));
        this.aIy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bQO);
        this.bwX = new View(this.ekw.getPageContext().getPageActivity());
        aq.k(this.bwX, w.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bwX, pbActivity.bQO);
        if (this.bwX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwX.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds20);
            this.bwX.setLayoutParams(layoutParams);
        }
        this.eux = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_title_textview, (View.OnClickListener) null);
        this.euA = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.euB = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds20);
        this.euB.setPadding(g, 0, g, 0);
        aq.b(this.euA, w.g.icon_pb_play_small, w.g.icon_pb_play_small);
        this.euB.setVisibility(8);
        this.euy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_host, pbActivity.bQO);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds26), 0);
        this.euy.setLayoutParams(layoutParams2);
        this.euz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_more, pbActivity.bQO);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds16), 0);
        this.euz.setLayoutParams(layoutParams3);
        aq.b(this.euz, w.g.icon_more_bg_s, w.g.icon_more_bg);
        this.eux.setOnClickListener(pbActivity.bQO);
        this.euB.setOnClickListener(pbActivity.bQO);
        this.dGO = (ImageView) this.aIy.findViewById(w.h.widget_navi_back_button);
        this.euE = this.mNavigationBar.getBottomLine();
        if (this.euE != null) {
            this.euE.setVisibility(0);
        }
    }

    public void iQ(boolean z) {
        this.euz.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aOY() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aIy.setVisibility(0);
        } else {
            this.aIy.setVisibility(8);
        }
        jf(z);
    }

    public void lp(String str) {
        if (!TextUtils.isEmpty(str)) {
            jf(true);
            this.eux.setText(String.valueOf(str) + this.ekw.getPageContext().getString(w.l.bar));
            q.po().cd(str);
        }
    }

    public void aOZ() {
        this.euy.setVisibility(4);
        this.euy.setEnabled(false);
    }

    public void iX(boolean z) {
        if (z) {
            aq.c(this.euy, w.g.s_only_host_button_bg);
            this.euy.setContentDescription(this.ekw.getResources().getString(w.l.view_host_selected));
        } else {
            aq.b(this.euy, w.g.s_icon_floor_host_bg_s, w.g.icon_floor_host_bg);
            this.euy.setContentDescription(this.ekw.getResources().getString(w.l.view_host));
        }
        this.esB = z;
    }

    public void a(dt dtVar) {
        if (!this.ekw.isProgressBarShown()) {
            if (this.euC == null) {
                this.euD = new dr((PbActivity) this.ekw.getPageContext().getOrignalPage(), this.ekw.bQO);
                this.euC = new com.baidu.tieba.pb.view.j(this.ekw.getPageContext().getPageActivity(), this.euD.getView(), aq.getDrawable(w.g.bg_pull_down_right_n), new h(this));
            }
            this.euD.Ty();
            this.euC.showAtLocation(this.ekw.findViewById(w.h.pb_layout), 17, 0, 0);
            this.euD.iG(dtVar == null ? false : dtVar.epc);
            this.euD.iF(dtVar == null ? false : dtVar.epe);
            this.euD.iJ(dtVar == null ? false : dtVar.eph);
            this.euD.iK(dtVar == null ? false : dtVar.epk);
            this.euD.iL(dtVar == null ? false : dtVar.epl);
            this.euD.iH(dtVar == null ? false : dtVar.epd);
            this.euD.iM(dtVar == null ? false : dtVar.epm);
            if (dtVar == null) {
                this.euD.w(false, false);
                this.euD.x(false, false);
            } else {
                this.euD.w(dtVar.epi, dtVar.epo);
                this.euD.x(dtVar.epj, dtVar.epn);
            }
            boolean z = dtVar == null ? false : dtVar.epg;
            boolean z2 = dtVar == null ? false : dtVar.eiR;
            boolean z3 = dtVar == null ? false : dtVar.isHostOnly;
            boolean z4 = dtVar == null ? false : dtVar.epp;
            this.euD.iI(dtVar != null ? dtVar.epf : false);
            this.euD.v(z4, z3);
            f(z, z2, z3);
        }
    }

    private void f(boolean z, boolean z2, boolean z3) {
        if (this.euD != null) {
            this.euD.TC();
            if (!z) {
                this.euD.aNp().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.euD.aNp().setText(this.ekw.getResources().getString(w.l.view_positive_sequence));
            } else {
                this.euD.aNp().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.euD.aNp().setText(this.ekw.getResources().getString(w.l.view_reverse));
            }
            if (z2) {
                this.euD.aNg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.euD.aNg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.euD.aNu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.euD.aNu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oI() {
        if (this.euD != null) {
            this.euD.Tz();
        }
        if (this.IL == null) {
            this.IL = new i(this);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this.IL, 100L);
    }

    public dr aPa() {
        return this.euD;
    }

    public View aPb() {
        return this.euB;
    }

    public boolean UI() {
        return this.euC != null && this.euC.isShowing();
    }

    public void axZ() {
        if (this.euD != null) {
            this.euD.release();
        }
        this.euC = null;
        this.euD = null;
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.IL);
    }

    public void aPc() {
        this.euy.setVisibility(8);
        this.euz.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ekw.getPageContext(), i);
        }
        aq.b(this.euz, w.g.icon_more_bg_s, w.g.icon_more_bg);
        aq.b(this.eux, w.e.cp_cont_b, w.e.s_navbar_title_color);
        aq.k(this.bwX, w.e.cp_cont_f_alpha60);
    }

    public void oB(int i) {
        this.mNavigationBar.onChangeSkinType(this.ekw.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(w.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.ekw.getResources().getColor(w.e.black_alpha85));
        this.euE.setVisibility(8);
        aOZ();
        this.euz.setImageResource(w.g.icon_more_bg);
        this.eux.setTextColor(this.ekw.getResources().getColor(w.e.cp_cont_g));
        this.bwX.setBackgroundColor(this.ekw.getResources().getColor(w.e.cp_cont_g));
        this.dGO.setImageResource(w.g.icon_return_bg);
    }

    public void aPd() {
        this.dGO.setVisibility(0);
        jf(false);
        this.euy.setVisibility(8);
        this.euz.setVisibility(8);
    }

    public void aPe() {
        this.dGO.setVisibility(0);
        jf(true);
        this.euy.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.euz.setVisibility(0);
        } else {
            this.euz.setVisibility(8);
        }
    }

    public void jf(boolean z) {
        if (this.euF) {
            this.eux.setVisibility(8);
            this.bwX.setVisibility(8);
            return;
        }
        this.bwX.setVisibility(z ? 0 : 8);
        this.eux.setVisibility(z ? 0 : 8);
    }

    public void jg(boolean z) {
        this.euF = z;
    }
}
