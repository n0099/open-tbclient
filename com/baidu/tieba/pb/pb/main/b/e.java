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
import com.baidu.tieba.pb.pb.main.dq;
import com.baidu.tieba.pb.view.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e {
    private Runnable Au;
    public final View aBf;
    private ImageView dOK;
    private PbActivity eat;
    public final TextView eiV;
    public final ImageView eiW;
    public final ImageView eiX;
    public final ImageView eiY;
    public final NavigationBar mNavigationBar;
    private s eiZ = null;
    private dq eja = null;
    private boolean ehk = false;
    private int ejb = 2;

    public e(PbActivity pbActivity) {
        this.eat = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eat.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new f(this));
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bGw);
        this.eiV = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, u.h.pb_title_textview, (View.OnClickListener) null);
        this.eiY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_add_floor, pbActivity.bGw);
        this.eiW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_host, pbActivity.bGw);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.c(this.eat.getPageContext().getPageActivity(), u.e.ds30), 0, k.c(this.eat.getPageContext().getPageActivity(), u.e.ds26), 0);
        this.eiW.setLayoutParams(layoutParams);
        this.eiX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more, pbActivity.bGw);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.c(this.eat.getPageContext().getPageActivity(), u.e.ds16), 0);
        this.eiX.setLayoutParams(layoutParams2);
        av.b(this.eiX, u.f.btn_more_selector_s, u.f.btn_more_selector);
        av.b(this.eiY, u.f.icon_floor_addition_selector_s, u.f.icon_floor_addition_selector);
        this.eiV.setOnClickListener(pbActivity.bGw);
        this.dOK = (ImageView) this.aBf.findViewById(u.g.widget_navi_back_button);
    }

    public void hU(boolean z) {
        this.eiX.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aLn() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.eiV.setVisibility(0);
            this.aBf.setVisibility(0);
            return;
        }
        this.eiV.setVisibility(8);
        this.aBf.setVisibility(8);
    }

    public void lZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eiV.setVisibility(0);
            this.eiV.setText(String.valueOf(str) + this.eat.getPageContext().getString(u.j.bar));
            l.nL().cc(str);
        }
    }

    public void aLo() {
        this.eiW.setVisibility(4);
        this.eiW.setEnabled(false);
    }

    public void ic(boolean z) {
        if (z) {
            av.c(this.eiW, u.f.s_only_host_button_bg);
            this.eiW.setContentDescription(this.eat.getResources().getString(u.j.view_host_selected));
        } else {
            av.b(this.eiW, u.f.s_icon_floor_host_bg_s, u.f.icon_floor_host_bg);
            this.eiW.setContentDescription(this.eat.getResources().getString(u.j.view_host));
        }
        if (this.ejb == 1) {
            av.c(this.eiW, u.f.ecomm_icn_shop_pb_lz_n);
        }
        this.ehk = z;
    }

    public void ij(boolean z) {
        if (z) {
            this.eiY.setVisibility(0);
        } else {
            this.eiY.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (!this.eat.isProgressBarShown()) {
            if (this.eiZ == null) {
                this.eja = new dq((PbActivity) this.eat.getPageContext().getOrignalPage(), this.eat.bGw);
                this.eiZ = new s(this.eat.getPageContext().getPageActivity(), this.eja.getView(), av.getDrawable(u.f.bg_pull_down_right_n), new g(this));
            }
            this.eja.aJL();
            this.eiZ.showAtLocation(this.eat.findViewById(u.g.pb_layout), 17, 0, 0);
            if (z4) {
                this.eja.hP(false);
            } else {
                this.eja.hP(true);
            }
            if (z3) {
                this.eja.hN(false);
            } else {
                this.eja.hN(true);
            }
            this.eja.hQ(z6);
            this.eja.hO(!z5);
            s(z, z2);
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.eja != null) {
            this.eja.aJO();
            if (!z) {
                this.eja.aJF().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eja.aJF().setText(this.eat.getResources().getString(u.j.view_positive_sequence));
            } else {
                this.eja.aJF().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eja.aJF().setText(this.eat.getResources().getString(u.j.view_reverse));
            }
            if (z2) {
                this.eja.aJv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eja.aJv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void nf() {
        if (this.eja != null) {
            this.eja.aJM();
        }
        if (this.Au == null) {
            this.Au = new h(this);
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(this.Au, 100L);
    }

    public dq aLp() {
        return this.eja;
    }

    public boolean aLq() {
        return this.eiZ != null && this.eiZ.isShowing();
    }

    public void awi() {
        if (this.eja != null) {
            this.eja.release();
        }
        this.eiZ = null;
        this.eja = null;
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.Au);
    }

    public void aLr() {
        this.eiW.setVisibility(8);
        this.eiX.setVisibility(8);
    }

    public void V(float f) {
        float f2;
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (f == 0.0f) {
            this.mNavigationBar.setBackgroundColor(0);
        } else if (skinType == 2) {
            if (this.ejb == 1) {
                this.mNavigationBar.setBackgroundColor(0);
            } else {
                this.mNavigationBar.onChangeSkinType(this.eat.getPageContext(), skinType);
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
            if (this.ejb == 2) {
                this.ejb = 1;
                av.c(this.dOK, u.f.ecomm_icn_shop_pb_return_n);
                av.c(this.eiX, u.f.ecomm_icon_shop_pb_more_n);
                av.c(this.eiW, u.f.ecomm_icn_shop_pb_lz_n);
                av.j((View) this.eiV, TbadkCoreApplication.m10getInst().getSkinType() == 1 ? u.d.cp_cont_i_alpha70 : u.d.cp_cont_n);
                this.eiV.setShadowLayer(1.0f, 0.0f, 1.0f, u.d.black_alpha30);
                f2 = f3;
            } else {
                f2 = f3;
            }
        } else {
            f2 = (float) (1.0d - ((1.0f - f) / 0.3d));
            if (this.ejb == 1) {
                av.b(this.dOK, u.f.icon_return_bg_s, u.f.icon_return_bg);
                av.b(this.eiX, u.f.btn_more_selector_s, u.f.btn_more_selector);
                if (this.ehk) {
                    av.c(this.eiW, u.f.s_only_host_button_bg);
                } else {
                    av.b(this.eiW, u.f.s_icon_floor_host_bg, u.f.icon_floor_host_bg);
                }
                av.j((View) this.eiV, u.d.cp_cont_b);
                this.eiV.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                this.ejb = 2;
            }
        }
        this.aBf.setAlpha(f2);
        this.eiX.setAlpha(f2);
        this.eiW.setAlpha(f2);
        this.eiV.setAlpha(f2);
    }
}
