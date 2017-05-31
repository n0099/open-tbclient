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
import com.baidu.tieba.pb.pb.main.ep;
import com.baidu.tieba.pb.pb.main.er;
import com.baidu.tieba.pb.view.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    private Runnable aDz;
    public final View aIp;
    public View bOc;
    private ImageView dGK;
    private PbActivity elf;
    public final TextView exi;
    public final ImageView exj;
    public final ImageView exk;
    public final ImageView exl;
    private final ImageView exm;
    private final LinearLayout exn;
    private View exq;
    public final NavigationBar mNavigationBar;
    private x exo = null;
    private ep exp = null;
    private boolean exr = false;
    private boolean etY = false;

    public h(PbActivity pbActivity) {
        this.elf = pbActivity;
        this.mNavigationBar = (NavigationBar) this.elf.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new i(this));
        this.aIp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bVy);
        this.aIp.setPadding(com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds22), this.aIp.getPaddingTop(), this.aIp.getPaddingRight(), this.aIp.getPaddingBottom());
        this.bOc = new View(this.elf.getPageContext().getPageActivity());
        this.bOc.setVisibility(8);
        aq.k(this.bOc, w.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bOc, pbActivity.bVy);
        if (this.bOc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bOc.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds20);
            this.bOc.setLayoutParams(layoutParams);
        }
        this.exi = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_title_textview, (View.OnClickListener) null);
        this.exm = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.exn = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds20);
        this.exn.setPadding(g, 0, g, 0);
        aq.b(this.exm, w.g.icon_pb_play_small, w.g.icon_pb_play_small);
        this.exm.setVisibility(8);
        this.exj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_host, pbActivity.bVy);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds26), 0);
        this.exj.setLayoutParams(layoutParams2);
        this.exj.setVisibility(8);
        this.exl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_share, pbActivity.bVy);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds40), 0);
        this.exl.setLayoutParams(layoutParams3);
        this.exl.setVisibility(8);
        aq.b(this.exl, w.g.icon_pb_share_selector, w.g.icon_pb_share_selector);
        this.exk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_floor_more, pbActivity.bVy);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds40), 0);
        this.exk.setLayoutParams(layoutParams4);
        aq.b(this.exk, w.g.icon_nav_more_selector, w.g.icon_nav_more_selector);
        this.exi.setOnClickListener(pbActivity.bVy);
        this.exm.setOnClickListener(pbActivity.bVy);
        this.dGK = (ImageView) this.aIp.findViewById(w.h.widget_navi_back_button);
        this.exq = this.mNavigationBar.getBottomLine();
        if (this.exq != null) {
            this.exq.setVisibility(8);
        }
    }

    public void iN(boolean z) {
        this.exk.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aNx() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aIp.setVisibility(0);
        } else {
            this.aIp.setVisibility(8);
        }
        ja(z);
    }

    public void lD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.exi.setText(this.elf.getResources().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)));
            ja(true);
            r.oN().cd(str);
            return;
        }
        ja(false);
    }

    public void aNy() {
        this.exj.setVisibility(4);
        this.exj.setEnabled(false);
    }

    public void iR(boolean z) {
        if (z) {
            aq.c(this.exj, w.g.s_only_host_button_bg);
            this.exj.setContentDescription(this.elf.getResources().getString(w.l.view_host_selected));
        } else {
            aq.b(this.exj, w.g.icon_floor_host_bg, w.g.icon_floor_host_bg);
            this.exj.setContentDescription(this.elf.getResources().getString(w.l.view_host));
        }
        this.etY = z;
    }

    public void a(er erVar) {
        if (!this.elf.isProgressBarShown()) {
            if (this.exo == null) {
                this.exp = new ep((PbActivity) this.elf.getPageContext().getOrignalPage(), this.elf.bVy);
                this.exo = new x(this.elf.getPageContext().getPageActivity(), this.exp.getView(), aq.getDrawable(w.g.bg_pull_down_right_n), new j(this));
            }
            this.exp.Te();
            this.exo.showAtLocation(this.elf.findViewById(w.h.pb_layout), 17, 0, 0);
            this.exp.iA(erVar == null ? false : erVar.eqN);
            this.exp.iz(erVar == null ? false : erVar.eqP);
            this.exp.iD(erVar == null ? false : erVar.eqV);
            this.exp.iE(erVar == null ? false : erVar.eqW);
            this.exp.iB(erVar == null ? false : erVar.eqO);
            this.exp.iG(erVar == null ? false : erVar.eqS);
            this.exp.iF(erVar == null ? false : erVar.eqX);
            if (erVar == null) {
                this.exp.z(false, false);
                this.exp.A(false, false);
            } else {
                this.exp.z(erVar.eqT, erVar.eqZ);
                this.exp.A(erVar.eqU, erVar.eqY);
            }
            boolean z = erVar == null ? false : erVar.eqR;
            boolean z2 = erVar == null ? false : erVar.ejs;
            boolean z3 = erVar == null ? false : erVar.isHostOnly;
            boolean z4 = erVar == null ? false : erVar.era;
            this.exp.iC(erVar != null ? erVar.eqQ : false);
            this.exp.y(z4, z3);
            h(z, z2, z3);
        }
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.exp != null) {
            this.exp.Ti();
            if (z) {
                this.exp.aLC().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.exp.aLC().setText(this.elf.getResources().getString(w.l.view_reverse));
            } else {
                this.exp.aLC().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.exp.aLC().setText(this.elf.getResources().getString(w.l.view_positive_sequence));
            }
            if (z2) {
                this.exp.aLt().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.exp.aLt().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.exp.aLG().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.exp.aLG().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oh() {
        if (this.exp != null) {
            this.exp.Tf();
        }
        if (this.aDz == null) {
            this.aDz = new k(this);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this.aDz, 100L);
    }

    public ep aNz() {
        return this.exp;
    }

    public View aNA() {
        return this.exm;
    }

    public boolean Vf() {
        return this.exo != null && this.exo.isShowing();
    }

    public void avP() {
        if (this.exp != null) {
            this.exp.release();
        }
        this.exo = null;
        this.exp = null;
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aDz);
    }

    public void aNB() {
        this.exj.setVisibility(8);
        this.exk.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aq.cN(w.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.elf.getPageContext(), i);
        }
        aq.b(this.exk, w.g.icon_nav_more_selector, w.g.icon_nav_more_selector);
        aq.b(this.exi, w.e.cp_cont_b, w.e.s_navbar_title_color);
        aq.k(this.bOc, w.e.cp_cont_f_alpha60);
    }

    public void oP(int i) {
        this.mNavigationBar.onChangeSkinType(this.elf.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(w.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.elf.getResources().getColor(w.e.black_alpha85));
        this.exq.setVisibility(8);
        aNy();
        this.exl.setImageResource(w.g.icon_pb_share_selector);
        this.exk.setImageResource(w.g.icon_more_bg);
        this.exi.setTextColor(this.elf.getResources().getColor(w.e.cp_cont_g));
        this.bOc.setBackgroundColor(this.elf.getResources().getColor(w.e.cp_cont_g));
        this.dGK.setImageResource(w.g.icon_return_bg);
    }

    public void aNC() {
        this.dGK.setVisibility(0);
        ja(false);
        this.exj.setVisibility(8);
        this.exk.setVisibility(8);
    }

    public void iZ(boolean z) {
        this.dGK.setVisibility(0);
        ja(z);
        this.exj.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.exk.setVisibility(0);
        } else {
            this.exk.setVisibility(8);
        }
    }

    public void ja(boolean z) {
        if (z && !"".equals(this.exi.getText().toString())) {
            this.exi.setVisibility(0);
            this.bOc.setVisibility(0);
            return;
        }
        this.exi.setVisibility(8);
        this.bOc.setVisibility(8);
    }

    public void jb(boolean z) {
    }

    public void jc(boolean z) {
        this.exr = z;
    }
}
