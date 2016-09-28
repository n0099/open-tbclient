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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private Runnable CI;
    public final View aDK;
    private ImageView ecK;
    private PbActivity eow;
    public final TextView exi;
    public final ImageView exj;
    public final ImageView exk;
    public final ImageView exl;
    public final NavigationBar mNavigationBar;
    private s exm = null;
    private dq exn = null;
    private boolean evz = false;
    private int exo = 2;

    public e(PbActivity pbActivity) {
        this.eow = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eow.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new f(this));
        this.aDK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bRx);
        this.exi = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.h.pb_title_textview, (View.OnClickListener) null);
        this.exl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_add_floor, pbActivity.bRx);
        this.exj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_floor_host, pbActivity.bRx);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.e(this.eow.getPageContext().getPageActivity(), r.e.ds30), 0, k.e(this.eow.getPageContext().getPageActivity(), r.e.ds26), 0);
        this.exj.setLayoutParams(layoutParams);
        this.exk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_floor_more, pbActivity.bRx);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.e(this.eow.getPageContext().getPageActivity(), r.e.ds16), 0);
        this.exk.setLayoutParams(layoutParams2);
        av.b(this.exk, r.f.btn_more_selector_s, r.f.btn_more_selector);
        av.b(this.exl, r.f.icon_floor_addition_selector_s, r.f.icon_floor_addition_selector);
        this.exi.setOnClickListener(pbActivity.bRx);
        this.ecK = (ImageView) this.aDK.findViewById(r.g.widget_navi_back_button);
    }

    public void is(boolean z) {
        this.exk.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aQN() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.exi.setVisibility(0);
            this.aDK.setVisibility(0);
            return;
        }
        this.exi.setVisibility(8);
        this.aDK.setVisibility(8);
    }

    public void mV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.exi.setVisibility(0);
            this.exi.setText(String.valueOf(str) + this.eow.getPageContext().getString(r.j.bar));
            l.oH().cd(str);
        }
    }

    public void aQO() {
        this.exj.setVisibility(4);
        this.exj.setEnabled(false);
    }

    public void iA(boolean z) {
        if (z) {
            av.c(this.exj, r.f.s_only_host_button_bg);
            this.exj.setContentDescription(this.eow.getResources().getString(r.j.view_host_selected));
        } else {
            av.b(this.exj, r.f.s_icon_floor_host_bg_s, r.f.icon_floor_host_bg);
            this.exj.setContentDescription(this.eow.getResources().getString(r.j.view_host));
        }
        if (this.exo == 1) {
            av.c(this.exj, r.f.ecomm_icn_shop_pb_lz_n);
        }
        this.evz = z;
    }

    public void iH(boolean z) {
        if (z) {
            this.exl.setVisibility(0);
        } else {
            this.exl.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (!this.eow.isProgressBarShown()) {
            if (this.exm == null) {
                this.exn = new dq((PbActivity) this.eow.getPageContext().getOrignalPage(), this.eow.bRx);
                this.exm = new s(this.eow.getPageContext().getPageActivity(), this.exn.getView(), av.getDrawable(r.f.bg_pull_down_right_n), new g(this));
            }
            this.exn.aPk();
            this.exm.showAtLocation(this.eow.findViewById(r.g.pb_layout), 17, 0, 0);
            if (z4) {
                this.exn.in(false);
            } else {
                this.exn.in(true);
            }
            if (z3) {
                this.exn.il(false);
            } else {
                this.exn.il(true);
            }
            this.exn.io(z6);
            this.exn.im(!z5);
            x(z, z2);
        }
    }

    private void x(boolean z, boolean z2) {
        if (this.exn != null) {
            this.exn.aPn();
            if (!z) {
                this.exn.aPe().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(r.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.exn.aPe().setText(this.eow.getResources().getString(r.j.view_positive_sequence));
            } else {
                this.exn.aPe().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(r.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.exn.aPe().setText(this.eow.getResources().getString(r.j.view_reverse));
            }
            if (z2) {
                this.exn.aOU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(r.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.exn.aOU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(r.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void ob() {
        if (this.exn != null) {
            this.exn.aPl();
        }
        if (this.CI == null) {
            this.CI = new h(this);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this.CI, 100L);
    }

    public dq aQP() {
        return this.exn;
    }

    public boolean aQQ() {
        return this.exm != null && this.exm.isShowing();
    }

    public void aBt() {
        if (this.exn != null) {
            this.exn.release();
        }
        this.exm = null;
        this.exn = null;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.CI);
    }

    public void aQR() {
        this.exj.setVisibility(8);
        this.exk.setVisibility(8);
    }

    public void ap(float f) {
        float f2;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (f == 0.0f) {
            this.mNavigationBar.setBackgroundColor(0);
        } else if (skinType == 2) {
            if (this.exo == 1) {
                this.mNavigationBar.setBackgroundColor(0);
            } else {
                this.mNavigationBar.onChangeSkinType(this.eow.getPageContext(), skinType);
            }
        } else {
            this.mNavigationBar.setBackgroundColor(com.baidu.tieba.tbadkCore.c.g(av.getColor(r.d.cp_bg_line_d), f));
        }
        if (f == 1.0f) {
            this.mNavigationBar.showBottomLine(true);
        } else {
            this.mNavigationBar.showBottomLine(false);
        }
        if (f < 0.7d) {
            float f3 = (float) (1.0d - (f / 0.7d));
            if (this.exo == 2) {
                this.exo = 1;
                av.c(this.ecK, r.f.ecomm_icn_shop_pb_return_n);
                av.c(this.exk, r.f.ecomm_icon_shop_pb_more_n);
                av.c(this.exj, r.f.ecomm_icn_shop_pb_lz_n);
                av.j((View) this.exi, TbadkCoreApplication.m9getInst().getSkinType() == 1 ? r.d.cp_cont_i_alpha70 : r.d.cp_cont_n);
                this.exi.setShadowLayer(1.0f, 0.0f, 1.0f, r.d.black_alpha30);
                f2 = f3;
            } else {
                f2 = f3;
            }
        } else {
            f2 = (float) (1.0d - ((1.0f - f) / 0.3d));
            if (this.exo == 1) {
                av.b(this.ecK, r.f.icon_return_bg_s, r.f.icon_return_bg);
                av.b(this.exk, r.f.btn_more_selector_s, r.f.btn_more_selector);
                if (this.evz) {
                    av.c(this.exj, r.f.s_only_host_button_bg);
                } else {
                    av.b(this.exj, r.f.s_icon_floor_host_bg, r.f.icon_floor_host_bg);
                }
                av.j((View) this.exi, r.d.cp_cont_b);
                this.exi.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                this.exo = 2;
            }
        }
        this.aDK.setAlpha(f2);
        this.exk.setAlpha(f2);
        this.exj.setAlpha(f2);
        this.exi.setAlpha(f2);
    }
}
