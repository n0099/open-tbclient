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
    public final View aMa;
    public View car;
    private PbActivity eGA;
    private View eUC;
    public final TextView eUu;
    public final ImageView eUv;
    public final ImageView eUw;
    public final ImageView eUx;
    private final ImageView eUy;
    private final LinearLayout eUz;
    private ImageView euC;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private f eUA = null;
    private x eUB = null;
    private boolean eUD = false;
    private boolean ePE = false;

    public d(PbActivity pbActivity) {
        this.eGA = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eGA.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eGA.afp();
            }
        });
        this.aMa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.ckz);
        this.aMa.setPadding(k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds18), this.aMa.getPaddingTop(), this.aMa.getPaddingRight(), this.aMa.getPaddingBottom());
        this.car = new View(this.eGA.getPageContext().getPageActivity());
        this.car.setVisibility(8);
        ai.k(this.car, d.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.car, pbActivity.ckz);
        if (this.car.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.car.getLayoutParams();
            layoutParams.width = k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds1);
            layoutParams.height = k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds40);
            layoutParams.rightMargin = k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds20);
            this.car.setLayoutParams(layoutParams);
        }
        this.eUu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.j.pb_title_textview, (View.OnClickListener) null);
        this.eUy = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eUz = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds20);
        this.eUz.setPadding(g, 0, g, 0);
        ai.b(this.eUy, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.eUy.setVisibility(8);
        this.eUv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_host, pbActivity.ckz);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds30), 0, k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds26), 0);
        this.eUv.setLayoutParams(layoutParams2);
        this.eUv.setVisibility(8);
        this.eUx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_share, pbActivity.ckz);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds40), 0);
        this.eUx.setLayoutParams(layoutParams3);
        this.eUx.setVisibility(8);
        ai.b(this.eUx, d.g.icon_pb_share_selector, d.g.icon_pb_share_selector);
        this.eUw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_more, pbActivity.ckz);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds28), 0);
        this.eUw.setLayoutParams(layoutParams4);
        ai.b(this.eUw, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        this.eUu.setOnClickListener(pbActivity.ckz);
        this.eUy.setOnClickListener(pbActivity.ckz);
        this.euC = (ImageView) this.aMa.findViewById(d.h.widget_navi_back_button);
        this.eUC = this.mNavigationBar.getBottomLine();
        if (this.eUC != null) {
            this.eUC.setVisibility(8);
        }
    }

    public void jD(boolean z) {
        this.eUw.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aUF() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aMa.setVisibility(0);
        } else {
            this.aMa.setVisibility(8);
        }
        jT(z);
    }

    public void mU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eUu.setText(this.eGA.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)));
            jT(true);
            h.oX().cu(str);
            return;
        }
        jT(false);
    }

    public void aUG() {
        this.eUv.setVisibility(4);
        this.eUv.setEnabled(false);
    }

    public void jH(boolean z) {
        if (z) {
            ai.c(this.eUv, d.g.s_only_host_button_bg);
            this.eUv.setContentDescription(this.eGA.getResources().getString(d.l.view_host_selected));
        } else {
            ai.b(this.eUv, d.g.icon_floor_host_bg, d.g.icon_floor_host_bg);
            this.eUv.setContentDescription(this.eGA.getResources().getString(d.l.view_host));
        }
        this.ePE = z;
    }

    public void a(y yVar) {
        if (!this.eGA.isProgressBarShown()) {
            if (this.eUA == null) {
                this.eUB = new x((PbActivity) this.eGA.getPageContext().getOrignalPage(), this.eGA.ckz);
                this.eUA = new f(this.eGA.getPageContext().getPageActivity(), this.eUB.getView(), ai.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.d.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ot() {
                        d.this.eGA.aQu();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ou() {
                    }
                });
            }
            this.eUB.Vv();
            this.eUA.showAtLocation(this.eGA.findViewById(d.h.pb_layout), 17, 0, 0);
            this.eUB.jq(yVar == null ? false : yVar.eMu);
            this.eUB.jp(yVar == null ? false : yVar.eMw);
            this.eUB.jt(yVar == null ? false : yVar.eMC);
            this.eUB.ju(yVar == null ? false : yVar.eMD);
            this.eUB.jr(yVar == null ? false : yVar.eMv);
            this.eUB.jw(yVar == null ? false : yVar.eMz);
            this.eUB.jv(yVar == null ? false : yVar.eME);
            if (yVar == null) {
                this.eUB.E(false, false);
                this.eUB.F(false, false);
            } else {
                this.eUB.E(yVar.eMA, yVar.eMG);
                this.eUB.F(yVar.eMB, yVar.eMF);
            }
            boolean z = yVar == null ? false : yVar.eMy;
            boolean z2 = yVar == null ? false : yVar.eEM;
            boolean z3 = yVar == null ? false : yVar.isHostOnly;
            boolean z4 = yVar == null ? false : yVar.eMH;
            this.eUB.js(yVar != null ? yVar.eMx : false);
            this.eUB.D(z4, z3);
            i(z, z2, z3);
        }
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.eUB != null) {
            this.eUB.Vz();
            if (z) {
                this.eUB.aSo().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eUB.aSo().setText(this.eGA.getResources().getString(d.l.view_reverse));
            } else {
                this.eUB.aSo().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eUB.aSo().setText(this.eGA.getResources().getString(d.l.view_positive_sequence));
            }
            if (z2) {
                this.eUB.aSf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eUB.aSf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eUB.aSs().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eUB.aSs().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oq() {
        if (this.eUB != null) {
            this.eUB.Vw();
        }
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eUA != null) {
                        g.a(d.this.eUA, d.this.eGA.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ga().postDelayed(this.runnable, 100L);
    }

    public x aUH() {
        return this.eUB;
    }

    public View aUI() {
        return this.eUy;
    }

    public boolean Xj() {
        return this.eUA != null && this.eUA.isShowing();
    }

    public void aBB() {
        if (this.eUB != null) {
            this.eUB.release();
        }
        this.eUA = null;
        this.eUB = null;
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.runnable);
    }

    public void aUJ() {
        this.eUv.setVisibility(8);
        this.eUw.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.eGA.getPageContext(), i);
        }
        ai.b(this.eUw, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        ai.b(this.eUu, d.e.cp_cont_b, d.e.s_navbar_title_color);
        ai.k(this.car, d.e.cp_cont_f_alpha60);
    }

    public void px(int i) {
        this.mNavigationBar.onChangeSkinType(this.eGA.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eGA.getResources().getColor(d.e.black_alpha85));
        this.eUC.setVisibility(8);
        aUG();
        this.eUx.setImageResource(d.g.icon_pb_share_selector);
        this.eUw.setImageResource(d.g.icon_more_bg);
        this.eUu.setTextColor(this.eGA.getResources().getColor(d.e.cp_cont_g));
        this.car.setBackgroundColor(this.eGA.getResources().getColor(d.e.cp_cont_g));
        this.euC.setImageResource(d.g.icon_return_bg);
    }

    public void aUK() {
        this.euC.setVisibility(0);
        jT(false);
        this.eUv.setVisibility(8);
        this.eUw.setVisibility(8);
    }

    public void jS(boolean z) {
        this.euC.setVisibility(0);
        jT(z);
        this.eUv.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eUw.setVisibility(0);
        } else {
            this.eUw.setVisibility(8);
        }
    }

    public void jT(boolean z) {
        if (z && !"".equals(this.eUu.getText().toString())) {
            this.eUu.setVisibility(0);
            this.car.setVisibility(0);
            return;
        }
        this.eUu.setVisibility(8);
        this.car.setVisibility(8);
    }

    public void jU(boolean z) {
    }

    public void jV(boolean z) {
        this.eUD = z;
    }
}
