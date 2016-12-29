package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dl;
import com.baidu.tieba.pb.pb.main.dn;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g {
    private Runnable CJ;
    public final View aDT;
    private View bvR;
    private ImageView dNp;
    private PbActivity dYB;
    public final TextView ehI;
    public final ImageView ehJ;
    public final ImageView ehK;
    private View ehN;
    public final NavigationBar mNavigationBar;
    private com.baidu.tieba.pb.view.j ehL = null;
    private dl ehM = null;
    private boolean efR = false;

    public g(PbActivity pbActivity) {
        this.dYB = pbActivity;
        this.mNavigationBar = (NavigationBar) this.dYB.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new h(this));
        this.aDT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bzZ);
        this.bvR = new View(this.dYB.getPageContext().getPageActivity());
        ar.l(this.bvR, r.d.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bvR, pbActivity.bzZ);
        if (this.bvR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvR.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds20);
            this.bvR.setLayoutParams(layoutParams);
        }
        this.ehI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.h.pb_title_textview, (View.OnClickListener) null);
        this.ehJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_floor_host, pbActivity.bzZ);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds30), 0, com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds26), 0);
        this.ehJ.setLayoutParams(layoutParams2);
        this.ehK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_floor_more, pbActivity.bzZ);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds16), 0);
        this.ehK.setLayoutParams(layoutParams3);
        ar.b(this.ehK, r.f.icon_more_bg_s, r.f.icon_more_bg);
        this.ehI.setOnClickListener(pbActivity.bzZ);
        this.dNp = (ImageView) this.aDT.findViewById(r.g.widget_navi_back_button);
        this.ehN = this.mNavigationBar.getBottomLine();
        if (this.ehN != null) {
            this.ehN.setVisibility(0);
        }
    }

    public void iC(boolean z) {
        this.ehK.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aME() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.ehI.setVisibility(0);
            this.aDT.setVisibility(0);
            return;
        }
        this.ehI.setVisibility(8);
        this.aDT.setVisibility(8);
    }

    public void lu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ehI.setVisibility(0);
            this.ehI.setText(String.valueOf(str) + this.dYB.getPageContext().getString(r.j.bar));
            com.baidu.tbadk.core.l.oJ().cf(str);
        }
    }

    public void aMF() {
        this.ehJ.setVisibility(4);
        this.ehJ.setEnabled(false);
    }

    public void iJ(boolean z) {
        if (z) {
            ar.c(this.ehJ, r.f.s_only_host_button_bg);
            this.ehJ.setContentDescription(this.dYB.getResources().getString(r.j.view_host_selected));
        } else {
            ar.b(this.ehJ, r.f.s_icon_floor_host_bg_s, r.f.icon_floor_host_bg);
            this.ehJ.setContentDescription(this.dYB.getResources().getString(r.j.view_host));
        }
        this.efR = z;
    }

    public void a(dn dnVar) {
        if (!this.dYB.isProgressBarShown()) {
            if (this.ehL == null) {
                this.ehM = new dl((PbActivity) this.dYB.getPageContext().getOrignalPage(), this.dYB.bzZ);
                this.ehL = new com.baidu.tieba.pb.view.j(this.dYB.getPageContext().getPageActivity(), this.ehM.getView(), ar.getDrawable(r.f.bg_pull_down_right_n), new i(this));
            }
            this.ehM.Oj();
            this.ehL.showAtLocation(this.dYB.findViewById(r.g.pb_layout), 17, 0, 0);
            this.ehM.ir(dnVar == null ? false : dnVar.ecM);
            this.ehM.iq(dnVar == null ? false : dnVar.ecO);
            this.ehM.it(dnVar == null ? false : dnVar.ecR);
            this.ehM.iv(dnVar == null ? false : dnVar.ecS);
            this.ehM.iw(dnVar == null ? false : dnVar.ecV);
            this.ehM.ix(dnVar == null ? false : dnVar.ecW);
            this.ehM.is(dnVar == null ? false : dnVar.ecN);
            this.ehM.iy(dnVar == null ? false : dnVar.ecX);
            if (dnVar == null) {
                this.ehM.y(false, false);
                this.ehM.z(false, false);
            } else {
                this.ehM.y(dnVar.ecT, dnVar.ecZ);
                this.ehM.z(dnVar.ecU, dnVar.ecY);
            }
            boolean z = dnVar == null ? false : dnVar.ecQ;
            boolean z2 = dnVar == null ? false : dnVar.dXc;
            this.ehM.iu(dnVar != null ? dnVar.ecP : false);
            A(z, z2);
        }
    }

    private void A(boolean z, boolean z2) {
        if (this.ehM != null) {
            this.ehM.On();
            if (!z) {
                this.ehM.aKX().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.getDrawable(r.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.ehM.aKX().setText(this.dYB.getResources().getString(r.j.view_positive_sequence));
            } else {
                this.ehM.aKX().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.getDrawable(r.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.ehM.aKX().setText(this.dYB.getResources().getString(r.j.view_reverse));
            }
            if (z2) {
                this.ehM.aKM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.getDrawable(r.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ehM.aKM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.getDrawable(r.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void od() {
        if (this.ehM != null) {
            this.ehM.Ok();
        }
        if (this.CJ == null) {
            this.CJ = new j(this);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this.CJ, 100L);
    }

    public dl aMG() {
        return this.ehM;
    }

    public boolean aMH() {
        return this.ehL != null && this.ehL.isShowing();
    }

    public void awC() {
        if (this.ehM != null) {
            this.ehM.release();
        }
        this.ehL = null;
        this.ehM = null;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.CJ);
    }

    public void aMI() {
        this.ehJ.setVisibility(8);
        this.ehK.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dYB.getPageContext(), i);
        }
        ar.b(this.ehK, r.f.icon_more_bg_s, r.f.icon_more_bg);
        ar.b(this.ehI, r.d.cp_cont_b, r.d.s_navbar_title_color);
        ar.l(this.bvR, r.d.cp_cont_f_alpha60);
    }
}
