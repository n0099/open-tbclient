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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private Runnable CI;
    public final View aEm;
    private ImageView eaP;
    private PbActivity emy;
    public final TextView evc;
    public final ImageView evd;
    public final ImageView eve;
    public final ImageView evf;
    public final NavigationBar mNavigationBar;
    private s evg = null;
    private dq evh = null;
    private boolean etr = false;
    private int evi = 2;

    public e(PbActivity pbActivity) {
        this.emy = pbActivity;
        this.mNavigationBar = (NavigationBar) this.emy.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new f(this));
        this.aEm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bRE);
        this.evc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.pb_title_textview, (View.OnClickListener) null);
        this.evf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_add_floor, pbActivity.bRE);
        this.evd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_host, pbActivity.bRE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(k.e(this.emy.getPageContext().getPageActivity(), t.e.ds30), 0, k.e(this.emy.getPageContext().getPageActivity(), t.e.ds26), 0);
        this.evd.setLayoutParams(layoutParams);
        this.eve = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, pbActivity.bRE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.e(this.emy.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.eve.setLayoutParams(layoutParams2);
        av.b(this.eve, t.f.btn_more_selector_s, t.f.btn_more_selector);
        av.b(this.evf, t.f.icon_floor_addition_selector_s, t.f.icon_floor_addition_selector);
        this.evc.setOnClickListener(pbActivity.bRE);
        this.eaP = (ImageView) this.aEm.findViewById(t.g.widget_navi_back_button);
    }

    public void ip(boolean z) {
        this.eve.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aQe() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.evc.setVisibility(0);
            this.aEm.setVisibility(0);
            return;
        }
        this.evc.setVisibility(8);
        this.aEm.setVisibility(8);
    }

    public void mI(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.evc.setVisibility(0);
            this.evc.setText(String.valueOf(str) + this.emy.getPageContext().getString(t.j.bar));
            l.oG().cd(str);
        }
    }

    public void aQf() {
        this.evd.setVisibility(4);
        this.evd.setEnabled(false);
    }

    public void ix(boolean z) {
        if (z) {
            av.c(this.evd, t.f.s_only_host_button_bg);
            this.evd.setContentDescription(this.emy.getResources().getString(t.j.view_host_selected));
        } else {
            av.b(this.evd, t.f.s_icon_floor_host_bg_s, t.f.icon_floor_host_bg);
            this.evd.setContentDescription(this.emy.getResources().getString(t.j.view_host));
        }
        if (this.evi == 1) {
            av.c(this.evd, t.f.ecomm_icn_shop_pb_lz_n);
        }
        this.etr = z;
    }

    public void iE(boolean z) {
        if (z) {
            this.evf.setVisibility(0);
        } else {
            this.evf.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (!this.emy.isProgressBarShown()) {
            if (this.evg == null) {
                this.evh = new dq((PbActivity) this.emy.getPageContext().getOrignalPage(), this.emy.bRE);
                this.evg = new s(this.emy.getPageContext().getPageActivity(), this.evh.getView(), av.getDrawable(t.f.bg_pull_down_right_n), new g(this));
            }
            this.evh.aOC();
            this.evg.showAtLocation(this.emy.findViewById(t.g.pb_layout), 17, 0, 0);
            if (z4) {
                this.evh.ik(false);
            } else {
                this.evh.ik(true);
            }
            if (z3) {
                this.evh.ii(false);
            } else {
                this.evh.ii(true);
            }
            this.evh.il(z6);
            this.evh.ij(!z5);
            v(z, z2);
        }
    }

    private void v(boolean z, boolean z2) {
        if (this.evh != null) {
            this.evh.aOF();
            if (!z) {
                this.evh.aOw().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(t.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.evh.aOw().setText(this.emy.getResources().getString(t.j.view_positive_sequence));
            } else {
                this.evh.aOw().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(t.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.evh.aOw().setText(this.emy.getResources().getString(t.j.view_reverse));
            }
            if (z2) {
                this.evh.aOm().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(t.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.evh.aOm().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(t.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void oa() {
        if (this.evh != null) {
            this.evh.aOD();
        }
        if (this.CI == null) {
            this.CI = new h(this);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this.CI, 100L);
    }

    public dq aQg() {
        return this.evh;
    }

    public boolean aQh() {
        return this.evg != null && this.evg.isShowing();
    }

    public void aAV() {
        if (this.evh != null) {
            this.evh.release();
        }
        this.evg = null;
        this.evh = null;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.CI);
    }

    public void aQi() {
        this.evd.setVisibility(8);
        this.eve.setVisibility(8);
    }

    public void ap(float f) {
        float f2;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (f == 0.0f) {
            this.mNavigationBar.setBackgroundColor(0);
        } else if (skinType == 2) {
            if (this.evi == 1) {
                this.mNavigationBar.setBackgroundColor(0);
            } else {
                this.mNavigationBar.onChangeSkinType(this.emy.getPageContext(), skinType);
            }
        } else {
            this.mNavigationBar.setBackgroundColor(com.baidu.tieba.tbadkCore.c.g(av.getColor(t.d.cp_bg_line_d), f));
        }
        if (f == 1.0f) {
            this.mNavigationBar.showBottomLine(true);
        } else {
            this.mNavigationBar.showBottomLine(false);
        }
        if (f < 0.7d) {
            float f3 = (float) (1.0d - (f / 0.7d));
            if (this.evi == 2) {
                this.evi = 1;
                av.c(this.eaP, t.f.ecomm_icn_shop_pb_return_n);
                av.c(this.eve, t.f.ecomm_icon_shop_pb_more_n);
                av.c(this.evd, t.f.ecomm_icn_shop_pb_lz_n);
                av.j((View) this.evc, TbadkCoreApplication.m9getInst().getSkinType() == 1 ? t.d.cp_cont_i_alpha70 : t.d.cp_cont_n);
                this.evc.setShadowLayer(1.0f, 0.0f, 1.0f, t.d.black_alpha30);
                f2 = f3;
            } else {
                f2 = f3;
            }
        } else {
            f2 = (float) (1.0d - ((1.0f - f) / 0.3d));
            if (this.evi == 1) {
                av.b(this.eaP, t.f.icon_return_bg_s, t.f.icon_return_bg);
                av.b(this.eve, t.f.btn_more_selector_s, t.f.btn_more_selector);
                if (this.etr) {
                    av.c(this.evd, t.f.s_only_host_button_bg);
                } else {
                    av.b(this.evd, t.f.s_icon_floor_host_bg, t.f.icon_floor_host_bg);
                }
                av.j((View) this.evc, t.d.cp_cont_b);
                this.evc.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                this.evi = 2;
            }
        }
        this.aEm.setAlpha(f2);
        this.eve.setAlpha(f2);
        this.evd.setAlpha(f2);
        this.evc.setAlpha(f2);
    }
}
