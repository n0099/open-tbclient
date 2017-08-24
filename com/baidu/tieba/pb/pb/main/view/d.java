package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class d {
    public final View aMc;
    public View cbe;
    private PbActivity eIw;
    public final TextView eWp;
    public final ImageView eWq;
    public final ImageView eWr;
    public final ImageView eWs;
    private final ImageView eWt;
    private final LinearLayout eWu;
    private View eWx;
    private ImageView ewy;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private f eWv = null;
    private x eWw = null;
    private boolean eWy = false;
    private boolean eRz = false;

    public d(PbActivity pbActivity) {
        this.eIw = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eIw.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eIw.afF();
            }
        });
        this.aMc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.clm);
        this.aMc.setPadding(k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds18), this.aMc.getPaddingTop(), this.aMc.getPaddingRight(), this.aMc.getPaddingBottom());
        this.cbe = new View(this.eIw.getPageContext().getPageActivity());
        this.cbe.setVisibility(8);
        ai.k(this.cbe, d.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.cbe, pbActivity.clm);
        if (this.cbe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbe.getLayoutParams();
            layoutParams.width = k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds1);
            layoutParams.height = k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds40);
            layoutParams.rightMargin = k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds20);
            this.cbe.setLayoutParams(layoutParams);
        }
        this.eWp = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.j.pb_title_textview, (View.OnClickListener) null);
        this.eWt = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eWu = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds20);
        this.eWu.setPadding(g, 0, g, 0);
        ai.b(this.eWt, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.eWt.setVisibility(8);
        this.eWq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_host, pbActivity.clm);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds30), 0, k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds26), 0);
        this.eWq.setLayoutParams(layoutParams2);
        this.eWq.setVisibility(8);
        this.eWs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_share, pbActivity.clm);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds40), 0);
        this.eWs.setLayoutParams(layoutParams3);
        this.eWs.setVisibility(8);
        ai.b(this.eWs, d.g.icon_pb_share_selector, d.g.icon_pb_share_selector);
        this.eWr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_more, pbActivity.clm);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds28), 0);
        this.eWr.setLayoutParams(layoutParams4);
        ai.b(this.eWr, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        this.eWp.setOnClickListener(pbActivity.clm);
        this.eWt.setOnClickListener(pbActivity.clm);
        this.ewy = (ImageView) this.aMc.findViewById(d.h.widget_navi_back_button);
        this.eWx = this.mNavigationBar.getBottomLine();
        if (this.eWx != null) {
            this.eWx.setVisibility(8);
        }
    }

    public void jG(boolean z) {
        this.eWr.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aVh() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aMc.setVisibility(0);
        } else {
            this.aMc.setVisibility(8);
        }
        jW(z);
    }

    public void nd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eWp.setText(this.eIw.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)));
            jW(true);
            h.oY().cx(str);
            return;
        }
        jW(false);
    }

    public void aVi() {
        this.eWq.setVisibility(4);
        this.eWq.setEnabled(false);
    }

    public void jK(boolean z) {
        if (z) {
            ai.c(this.eWq, d.g.s_only_host_button_bg);
            this.eWq.setContentDescription(this.eIw.getResources().getString(d.l.view_host_selected));
        } else {
            ai.b(this.eWq, d.g.icon_floor_host_bg, d.g.icon_floor_host_bg);
            this.eWq.setContentDescription(this.eIw.getResources().getString(d.l.view_host));
        }
        this.eRz = z;
    }

    public void a(y yVar) {
        if (!this.eIw.isProgressBarShown()) {
            if (this.eWv == null) {
                this.eWw = new x((PbActivity) this.eIw.getPageContext().getOrignalPage(), this.eIw.clm);
                this.eWv = new f(this.eIw.getPageContext().getPageActivity(), this.eWw.getView(), ai.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.d.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ou() {
                        d.this.eIw.aQW();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ov() {
                    }
                });
            }
            this.eWw.VO();
            this.eWv.showAtLocation(this.eIw.findViewById(d.h.pb_layout), 17, 0, 0);
            this.eWw.jt(yVar == null ? false : yVar.eOq);
            this.eWw.js(yVar == null ? false : yVar.eOs);
            this.eWw.jw(yVar == null ? false : yVar.eOy);
            this.eWw.jx(yVar == null ? false : yVar.eOz);
            this.eWw.ju(yVar == null ? false : yVar.eOr);
            this.eWw.jz(yVar == null ? false : yVar.eOv);
            this.eWw.jy(yVar == null ? false : yVar.eOA);
            if (yVar == null) {
                this.eWw.F(false, false);
                this.eWw.G(false, false);
            } else {
                this.eWw.F(yVar.eOw, yVar.eOC);
                this.eWw.G(yVar.eOx, yVar.eOB);
            }
            boolean z = yVar == null ? false : yVar.eOu;
            boolean z2 = yVar == null ? false : yVar.eGI;
            boolean z3 = yVar == null ? false : yVar.isHostOnly;
            boolean z4 = yVar == null ? false : yVar.eOD;
            this.eWw.jv(yVar != null ? yVar.eOt : false);
            this.eWw.E(z4, z3);
            j(z, z2, z3);
        }
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.eWw != null) {
            this.eWw.VS();
            if (z) {
                this.eWw.aSQ().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eWw.aSQ().setText(this.eIw.getResources().getString(d.l.view_reverse));
            } else {
                this.eWw.aSQ().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eWw.aSQ().setText(this.eIw.getResources().getString(d.l.view_positive_sequence));
            }
            if (z2) {
                this.eWw.aSH().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eWw.aSH().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eWw.aSU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eWw.aSU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void or() {
        if (this.eWw != null) {
            this.eWw.VP();
        }
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eWv != null) {
                        g.a(d.this.eWv, d.this.eIw.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ga().postDelayed(this.runnable, 100L);
    }

    public x aVj() {
        return this.eWw;
    }

    public View aVk() {
        return this.eWt;
    }

    public boolean XC() {
        return this.eWv != null && this.eWv.isShowing();
    }

    public void aCd() {
        if (this.eWw != null) {
            this.eWw.release();
        }
        this.eWv = null;
        this.eWw = null;
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.runnable);
    }

    public void aVl() {
        this.eWq.setVisibility(8);
        this.eWr.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.eIw.getPageContext(), i);
        }
        ai.b(this.eWr, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        ai.b(this.eWp, d.e.cp_cont_b, d.e.s_navbar_title_color);
        ai.k(this.cbe, d.e.cp_cont_f_alpha60);
    }

    public void pH(int i) {
        this.mNavigationBar.onChangeSkinType(this.eIw.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eIw.getResources().getColor(d.e.black_alpha85));
        this.eWx.setVisibility(8);
        aVi();
        this.eWs.setImageResource(d.g.icon_pb_share_selector);
        this.eWr.setImageResource(d.g.icon_more_bg);
        this.eWp.setTextColor(this.eIw.getResources().getColor(d.e.cp_cont_g));
        this.cbe.setBackgroundColor(this.eIw.getResources().getColor(d.e.cp_cont_g));
        this.ewy.setImageResource(d.g.icon_return_bg);
    }

    public void aVm() {
        this.ewy.setVisibility(0);
        jW(false);
        this.eWq.setVisibility(8);
        this.eWr.setVisibility(8);
    }

    public void jV(boolean z) {
        this.ewy.setVisibility(0);
        jW(z);
        this.eWq.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eWr.setVisibility(0);
        } else {
            this.eWr.setVisibility(8);
        }
    }

    public void jW(boolean z) {
        if (z && !"".equals(this.eWp.getText().toString())) {
            this.eWp.setVisibility(0);
            this.cbe.setVisibility(0);
            return;
        }
        this.eWp.setVisibility(8);
        this.cbe.setVisibility(8);
    }

    public void jX(boolean z) {
    }

    public void jY(boolean z) {
        this.eWy = z;
    }
}
