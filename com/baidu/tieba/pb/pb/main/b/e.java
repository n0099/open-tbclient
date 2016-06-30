package com.baidu.tieba.pb.pb.main.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dp;
import com.baidu.tieba.pb.view.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e {
    public final View aAp;
    private PbActivity dOg;
    public final TextView dWs;
    public final ImageView dWt;
    public final ImageView dWu;
    public final ImageView dWv;
    private ImageView dWy;
    public final NavigationBar mNavigationBar;
    private Runnable zS;
    private s dWw = null;
    private dp dWx = null;
    private boolean dUJ = false;
    private int dWz = 2;

    public e(PbActivity pbActivity) {
        this.dOg = pbActivity;
        this.mNavigationBar = (NavigationBar) this.dOg.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new f(this));
        this.aAp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bFi);
        this.dWs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, u.h.pb_title_textview, (View.OnClickListener) null);
        this.dWv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_add_floor, pbActivity.bFi);
        this.dWt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_host, pbActivity.bFi);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.c(this.dOg.getPageContext().getPageActivity(), u.e.ds30), 0, k.c(this.dOg.getPageContext().getPageActivity(), u.e.ds26), 0);
        this.dWt.setLayoutParams(layoutParams);
        this.dWu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more, pbActivity.bFi);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.c(this.dOg.getPageContext().getPageActivity(), u.e.ds16), 0);
        this.dWu.setLayoutParams(layoutParams2);
        av.a(this.dWu, u.f.btn_more_selector_s, u.f.btn_more_selector);
        av.a(this.dWv, u.f.icon_floor_addition_selector_s, u.f.icon_floor_addition_selector);
        this.dWs.setOnClickListener(pbActivity.bFi);
        this.dWy = (ImageView) this.aAp.findViewById(u.g.widget_navi_back_button);
    }

    public void hI(boolean z) {
        this.dWu.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aIc() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.dWs.setVisibility(0);
            this.aAp.setVisibility(0);
            return;
        }
        this.dWs.setVisibility(8);
        this.aAp.setVisibility(8);
    }

    public void lS(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dWs.setVisibility(0);
            this.dWs.setText(String.valueOf(str) + this.dOg.getPageContext().getString(u.j.bar));
            l.nW().cb(str);
        }
    }

    public void aId() {
        this.dWt.setVisibility(4);
        this.dWt.setEnabled(false);
    }

    public void hQ(boolean z) {
        if (z) {
            av.c(this.dWt, u.f.s_only_host_button_bg);
            this.dWt.setContentDescription(this.dOg.getResources().getString(u.j.view_host_selected));
        } else {
            av.a(this.dWt, u.f.s_icon_floor_host_bg_s, u.f.icon_floor_host_bg);
            this.dWt.setContentDescription(this.dOg.getResources().getString(u.j.view_host));
        }
        if (this.dWz == 1) {
            av.c(this.dWt, u.f.ecomm_icn_shop_pb_lz_n);
        }
        this.dUJ = z;
    }

    public void hX(boolean z) {
        if (z) {
            this.dWv.setVisibility(0);
        } else {
            this.dWv.setVisibility(8);
        }
    }

    public void c(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!this.dOg.isProgressBarShown()) {
            if (this.dWw == null) {
                this.dWx = new dp((PbActivity) this.dOg.getPageContext().getOrignalPage(), this.dOg.bFi);
                this.dWw = new s(this.dOg.getPageContext().getPageActivity(), this.dWx.getView(), av.getDrawable(u.f.bg_pull_down_right_n), new g(this));
            }
            this.dWx.aGz();
            this.dWw.showAtLocation(this.dOg.findViewById(u.g.pb_layout), 17, 0, 0);
            if (z4) {
                this.dWx.hE(false);
            } else {
                this.dWx.hE(true);
            }
            if (z3) {
                this.dWx.hC(false);
            } else {
                this.dWx.hC(true);
            }
            this.dWx.hD(!z5);
            s(z, z2);
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.dWx != null) {
            this.dWx.aGB();
            if (!z) {
                this.dWx.aGu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.dWx.aGu().setText(this.dOg.getResources().getString(u.j.view_positive_sequence));
            } else {
                this.dWx.aGu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.dWx.aGu().setText(this.dOg.getResources().getString(u.j.view_reverse));
            }
            if (z2) {
                this.dWx.aGk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.dWx.aGk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void nq() {
        if (this.dWx != null) {
            this.dWx.aGA();
        }
        if (this.zS == null) {
            this.zS = new h(this);
        }
        com.baidu.adp.lib.h.h.dM().postDelayed(this.zS, 100L);
    }

    public dp aIe() {
        return this.dWx;
    }

    public boolean aIf() {
        return this.dWw != null && this.dWw.isShowing();
    }

    public void avw() {
        if (this.dWx != null) {
            this.dWx.release();
        }
        this.dWw = null;
        this.dWx = null;
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.zS);
    }

    public void aIg() {
        this.dWt.setVisibility(8);
        this.dWu.setVisibility(8);
    }

    public void L(float f) {
        float f2;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (f == 0.0f) {
            this.mNavigationBar.setBackgroundColor(0);
        } else if (skinType == 2) {
            if (this.dWz == 1) {
                this.mNavigationBar.setBackgroundColor(0);
            } else {
                this.mNavigationBar.onChangeSkinType(this.dOg.getPageContext(), skinType);
            }
        } else {
            this.mNavigationBar.setBackgroundColor(com.baidu.tieba.tbadkCore.c.g(av.getColor(u.d.cp_bg_line_d), f));
        }
        if (f == 1.0f) {
            this.mNavigationBar.showBottomLine(true);
        } else {
            this.mNavigationBar.showBottomLine(false);
        }
        if (f < 0.7d) {
            float f3 = (float) (1.0d - (f / 0.7d));
            if (this.dWz == 2) {
                this.dWz = 1;
                av.c(this.dWy, u.f.ecomm_icn_shop_pb_return_n);
                av.c(this.dWu, u.f.ecomm_icon_shop_pb_more_n);
                av.c(this.dWt, u.f.ecomm_icn_shop_pb_lz_n);
                av.j((View) this.dWs, TbadkCoreApplication.m9getInst().getSkinType() == 1 ? u.d.cp_cont_i_alpha70 : u.d.cp_cont_n);
                this.dWs.setShadowLayer(1.0f, 0.0f, 1.0f, u.d.black_alpha30);
                f2 = f3;
            } else {
                f2 = f3;
            }
        } else {
            f2 = (float) (1.0d - ((1.0f - f) / 0.3d));
            if (this.dWz == 1) {
                av.a(this.dWy, u.f.icon_return_bg_s, u.f.icon_return_bg);
                av.a(this.dWu, u.f.btn_more_selector_s, u.f.btn_more_selector);
                if (this.dUJ) {
                    av.c(this.dWt, u.f.s_only_host_button_bg);
                } else {
                    av.a(this.dWt, u.f.s_icon_floor_host_bg, u.f.icon_floor_host_bg);
                }
                av.j((View) this.dWs, u.d.cp_cont_b);
                this.dWs.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                this.dWz = 2;
            }
        }
        this.aAp.setAlpha(f2);
        this.dWu.setAlpha(f2);
        this.dWt.setAlpha(f2);
        this.dWs.setAlpha(f2);
    }
}
