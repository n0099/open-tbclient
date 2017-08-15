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
    public final View aMb;
    public View cbd;
    private PbActivity eIu;
    public final TextView eWn;
    public final ImageView eWo;
    public final ImageView eWp;
    public final ImageView eWq;
    private final ImageView eWr;
    private final LinearLayout eWs;
    private View eWv;
    private ImageView eww;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private f eWt = null;
    private x eWu = null;
    private boolean eWw = false;
    private boolean eRx = false;

    public d(PbActivity pbActivity) {
        this.eIu = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eIu.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eIu.afL();
            }
        });
        this.aMb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cll);
        this.aMb.setPadding(k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds18), this.aMb.getPaddingTop(), this.aMb.getPaddingRight(), this.aMb.getPaddingBottom());
        this.cbd = new View(this.eIu.getPageContext().getPageActivity());
        this.cbd.setVisibility(8);
        ai.k(this.cbd, d.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.cbd, pbActivity.cll);
        if (this.cbd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbd.getLayoutParams();
            layoutParams.width = k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds1);
            layoutParams.height = k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds40);
            layoutParams.rightMargin = k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds20);
            this.cbd.setLayoutParams(layoutParams);
        }
        this.eWn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.j.pb_title_textview, (View.OnClickListener) null);
        this.eWr = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eWs = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds20);
        this.eWs.setPadding(g, 0, g, 0);
        ai.b(this.eWr, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.eWr.setVisibility(8);
        this.eWo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_host, pbActivity.cll);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds30), 0, k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds26), 0);
        this.eWo.setLayoutParams(layoutParams2);
        this.eWo.setVisibility(8);
        this.eWq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_share, pbActivity.cll);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds40), 0);
        this.eWq.setLayoutParams(layoutParams3);
        this.eWq.setVisibility(8);
        ai.b(this.eWq, d.g.icon_pb_share_selector, d.g.icon_pb_share_selector);
        this.eWp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_more, pbActivity.cll);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds28), 0);
        this.eWp.setLayoutParams(layoutParams4);
        ai.b(this.eWp, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        this.eWn.setOnClickListener(pbActivity.cll);
        this.eWr.setOnClickListener(pbActivity.cll);
        this.eww = (ImageView) this.aMb.findViewById(d.h.widget_navi_back_button);
        this.eWv = this.mNavigationBar.getBottomLine();
        if (this.eWv != null) {
            this.eWv.setVisibility(8);
        }
    }

    public void jG(boolean z) {
        this.eWp.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aVm() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aMb.setVisibility(0);
        } else {
            this.aMb.setVisibility(8);
        }
        jW(z);
    }

    public void mY(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eWn.setText(this.eIu.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)));
            jW(true);
            h.oX().cu(str);
            return;
        }
        jW(false);
    }

    public void aVn() {
        this.eWo.setVisibility(4);
        this.eWo.setEnabled(false);
    }

    public void jK(boolean z) {
        if (z) {
            ai.c(this.eWo, d.g.s_only_host_button_bg);
            this.eWo.setContentDescription(this.eIu.getResources().getString(d.l.view_host_selected));
        } else {
            ai.b(this.eWo, d.g.icon_floor_host_bg, d.g.icon_floor_host_bg);
            this.eWo.setContentDescription(this.eIu.getResources().getString(d.l.view_host));
        }
        this.eRx = z;
    }

    public void a(y yVar) {
        if (!this.eIu.isProgressBarShown()) {
            if (this.eWt == null) {
                this.eWu = new x((PbActivity) this.eIu.getPageContext().getOrignalPage(), this.eIu.cll);
                this.eWt = new f(this.eIu.getPageContext().getPageActivity(), this.eWu.getView(), ai.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.d.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ot() {
                        d.this.eIu.aRb();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ou() {
                    }
                });
            }
            this.eWu.VR();
            this.eWt.showAtLocation(this.eIu.findViewById(d.h.pb_layout), 17, 0, 0);
            this.eWu.jt(yVar == null ? false : yVar.eOo);
            this.eWu.js(yVar == null ? false : yVar.eOq);
            this.eWu.jw(yVar == null ? false : yVar.eOw);
            this.eWu.jx(yVar == null ? false : yVar.eOx);
            this.eWu.ju(yVar == null ? false : yVar.eOp);
            this.eWu.jz(yVar == null ? false : yVar.eOt);
            this.eWu.jy(yVar == null ? false : yVar.eOy);
            if (yVar == null) {
                this.eWu.F(false, false);
                this.eWu.G(false, false);
            } else {
                this.eWu.F(yVar.eOu, yVar.eOA);
                this.eWu.G(yVar.eOv, yVar.eOz);
            }
            boolean z = yVar == null ? false : yVar.eOs;
            boolean z2 = yVar == null ? false : yVar.eGG;
            boolean z3 = yVar == null ? false : yVar.isHostOnly;
            boolean z4 = yVar == null ? false : yVar.eOB;
            this.eWu.jv(yVar != null ? yVar.eOr : false);
            this.eWu.E(z4, z3);
            j(z, z2, z3);
        }
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.eWu != null) {
            this.eWu.VV();
            if (z) {
                this.eWu.aSV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eWu.aSV().setText(this.eIu.getResources().getString(d.l.view_reverse));
            } else {
                this.eWu.aSV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eWu.aSV().setText(this.eIu.getResources().getString(d.l.view_positive_sequence));
            }
            if (z2) {
                this.eWu.aSM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eWu.aSM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eWu.aSZ().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eWu.aSZ().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oq() {
        if (this.eWu != null) {
            this.eWu.VS();
        }
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eWt != null) {
                        g.a(d.this.eWt, d.this.eIu.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ga().postDelayed(this.runnable, 100L);
    }

    public x aVo() {
        return this.eWu;
    }

    public View aVp() {
        return this.eWr;
    }

    public boolean XF() {
        return this.eWt != null && this.eWt.isShowing();
    }

    public void aCi() {
        if (this.eWu != null) {
            this.eWu.release();
        }
        this.eWt = null;
        this.eWu = null;
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.runnable);
    }

    public void aVq() {
        this.eWo.setVisibility(8);
        this.eWp.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.eIu.getPageContext(), i);
        }
        ai.b(this.eWp, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        ai.b(this.eWn, d.e.cp_cont_b, d.e.s_navbar_title_color);
        ai.k(this.cbd, d.e.cp_cont_f_alpha60);
    }

    public void pH(int i) {
        this.mNavigationBar.onChangeSkinType(this.eIu.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eIu.getResources().getColor(d.e.black_alpha85));
        this.eWv.setVisibility(8);
        aVn();
        this.eWq.setImageResource(d.g.icon_pb_share_selector);
        this.eWp.setImageResource(d.g.icon_more_bg);
        this.eWn.setTextColor(this.eIu.getResources().getColor(d.e.cp_cont_g));
        this.cbd.setBackgroundColor(this.eIu.getResources().getColor(d.e.cp_cont_g));
        this.eww.setImageResource(d.g.icon_return_bg);
    }

    public void aVr() {
        this.eww.setVisibility(0);
        jW(false);
        this.eWo.setVisibility(8);
        this.eWp.setVisibility(8);
    }

    public void jV(boolean z) {
        this.eww.setVisibility(0);
        jW(z);
        this.eWo.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eWp.setVisibility(0);
        } else {
            this.eWp.setVisibility(8);
        }
    }

    public void jW(boolean z) {
        if (z && !"".equals(this.eWn.getText().toString())) {
            this.eWn.setVisibility(0);
            this.cbd.setVisibility(0);
            return;
        }
        this.eWn.setVisibility(8);
        this.cbd.setVisibility(8);
    }

    public void jX(boolean z) {
    }

    public void jY(boolean z) {
        this.eWw = z;
    }
}
