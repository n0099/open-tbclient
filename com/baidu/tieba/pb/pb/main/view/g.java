package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ds;
import com.baidu.tieba.pb.pb.main.du;
import com.baidu.tieba.pb.view.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g {
    private Runnable CI;
    public final View aEA;
    private View bPN;
    public final TextView eDH;
    public final ImageView eDI;
    public final ImageView eDJ;
    private View eDM;
    private ImageView eiI;
    private PbActivity eug;
    public final NavigationBar mNavigationBar;
    private q eDK = null;
    private ds eDL = null;
    private boolean eBL = false;
    private int eDN = 2;

    public g(PbActivity pbActivity) {
        this.eug = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eug.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new h(this));
        this.aEA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.bTO);
        this.bPN = new View(this.eug.getPageContext().getPageActivity());
        at.l(this.bPN, r.d.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bPN, pbActivity.bTO);
        if (this.bPN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bPN.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds1);
            layoutParams.height = com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds40);
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds20);
            this.bPN.setLayoutParams(layoutParams);
        }
        this.eDH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.h.pb_title_textview, (View.OnClickListener) null);
        this.eDI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_floor_host, pbActivity.bTO);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds30), 0, com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds26), 0);
        this.eDI.setLayoutParams(layoutParams2);
        this.eDJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_floor_more, pbActivity.bTO);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds16), 0);
        this.eDJ.setLayoutParams(layoutParams3);
        at.b(this.eDJ, r.f.icon_more_bg_s, r.f.icon_more_bg);
        this.eDH.setOnClickListener(pbActivity.bTO);
        this.eiI = (ImageView) this.aEA.findViewById(r.g.widget_navi_back_button);
        this.eDM = this.mNavigationBar.getBottomLine();
        if (this.eDM != null) {
            this.eDM.setVisibility(0);
        }
    }

    public void iQ(boolean z) {
        this.eDJ.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aSN() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.eDH.setVisibility(0);
            this.aEA.setVisibility(0);
            return;
        }
        this.eDH.setVisibility(8);
        this.aEA.setVisibility(8);
    }

    public void nh(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eDH.setVisibility(0);
            this.eDH.setText(String.valueOf(str) + this.eug.getPageContext().getString(r.j.bar));
            com.baidu.tbadk.core.l.oJ().ce(str);
        }
    }

    public void aSO() {
        this.eDI.setVisibility(4);
        this.eDI.setEnabled(false);
    }

    public void iX(boolean z) {
        if (z) {
            at.c(this.eDI, r.f.s_only_host_button_bg);
            this.eDI.setContentDescription(this.eug.getResources().getString(r.j.view_host_selected));
        } else {
            at.b(this.eDI, r.f.s_icon_floor_host_bg_s, r.f.icon_floor_host_bg);
            this.eDI.setContentDescription(this.eug.getResources().getString(r.j.view_host));
        }
        if (this.eDN == 1) {
            at.c(this.eDI, r.f.ecomm_icn_shop_pb_lz_n);
        }
        this.eBL = z;
    }

    public void a(du duVar) {
        if (!this.eug.isProgressBarShown()) {
            if (this.eDK == null) {
                this.eDL = new ds((PbActivity) this.eug.getPageContext().getOrignalPage(), this.eug.bTO);
                this.eDK = new q(this.eug.getPageContext().getPageActivity(), this.eDL.getView(), at.getDrawable(r.f.bg_pull_down_right_n), new i(this));
            }
            this.eDL.aRl();
            this.eDK.showAtLocation(this.eug.findViewById(r.g.pb_layout), 17, 0, 0);
            this.eDL.iF(duVar == null ? false : duVar.eyz);
            this.eDL.iD(duVar == null ? false : duVar.eyC);
            this.eDL.iH(duVar == null ? false : duVar.eyF);
            this.eDL.iJ(duVar == null ? false : duVar.eyG);
            this.eDL.iK(duVar == null ? false : duVar.eyJ);
            this.eDL.iL(duVar == null ? false : duVar.eyK);
            this.eDL.iG(duVar == null ? false : duVar.eyB);
            this.eDL.iE(duVar == null ? false : duVar.eyA);
            this.eDL.iM(duVar == null ? false : duVar.eyL);
            if (duVar == null) {
                this.eDL.x(false, false);
                this.eDL.y(false, false);
            } else {
                this.eDL.x(duVar.eyH, duVar.eyN);
                this.eDL.y(duVar.eyI, duVar.eyM);
            }
            boolean z = duVar == null ? false : duVar.eyE;
            boolean z2 = duVar == null ? false : duVar.esE;
            this.eDL.iI(duVar != null ? duVar.eyD : false);
            z(z, z2);
        }
    }

    private void z(boolean z, boolean z2) {
        if (this.eDL != null) {
            this.eDL.aRo();
            if (!z) {
                this.eDL.aQY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(r.f.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eDL.aQY().setText(this.eug.getResources().getString(r.j.view_positive_sequence));
            } else {
                this.eDL.aQY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(r.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eDL.aQY().setText(this.eug.getResources().getString(r.j.view_reverse));
            }
            if (z2) {
                this.eDL.aQN().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(r.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eDL.aQN().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.getDrawable(r.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void od() {
        if (this.eDL != null) {
            this.eDL.aRm();
        }
        if (this.CI == null) {
            this.CI = new j(this);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this.CI, 100L);
    }

    public ds aSP() {
        return this.eDL;
    }

    public boolean aSQ() {
        return this.eDK != null && this.eDK.isShowing();
    }

    public void aDp() {
        if (this.eDL != null) {
            this.eDL.release();
        }
        this.eDK = null;
        this.eDL = null;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.CI);
    }

    public void aSR() {
        this.eDI.setVisibility(8);
        this.eDJ.setVisibility(8);
    }

    public void aq(float f) {
        float f2;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (f == 0.0f) {
            this.mNavigationBar.setBackgroundColor(0);
        } else if (skinType == 2) {
            if (this.eDN == 1) {
                this.mNavigationBar.setBackgroundColor(0);
            } else {
                this.mNavigationBar.onChangeSkinType(this.eug.getPageContext(), skinType);
            }
        } else {
            this.mNavigationBar.setBackgroundColor(com.baidu.tieba.tbadkCore.c.f(at.getColor(r.d.cp_bg_line_d), f));
        }
        if (f == 1.0f) {
            if (this.eDM != null) {
                this.eDM.setVisibility(0);
            }
        } else if (this.eDM != null) {
            this.eDM.setVisibility(8);
        }
        if (f < 0.7d) {
            float f3 = (float) (1.0d - (f / 0.7d));
            if (this.eDN == 2) {
                this.eDN = 1;
                at.c(this.eiI, r.f.ecomm_icn_shop_pb_return_n);
                at.c(this.eDJ, r.f.ecomm_icon_shop_pb_more_n);
                at.c(this.eDI, r.f.ecomm_icn_shop_pb_lz_n);
                at.j((View) this.eDH, TbadkCoreApplication.m9getInst().getSkinType() == 1 ? r.d.cp_cont_i_alpha70 : r.d.cp_cont_n);
                this.eDH.setShadowLayer(1.0f, 0.0f, 1.0f, r.d.black_alpha30);
                f2 = f3;
            } else {
                f2 = f3;
            }
        } else {
            f2 = (float) (1.0d - ((1.0f - f) / 0.3d));
            if (this.eDN == 1) {
                at.b(this.eiI, r.f.icon_return_bg_s, r.f.icon_return_pb_bg);
                at.b(this.eDJ, r.f.icon_more_bg_s, r.f.icon_more_bg);
                if (this.eBL) {
                    at.c(this.eDI, r.f.s_only_host_button_bg);
                } else {
                    at.b(this.eDI, r.f.s_icon_floor_host_bg, r.f.icon_floor_host_bg);
                }
                at.j((View) this.eDH, r.d.cp_cont_b);
                this.eDH.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                this.eDN = 2;
            }
        }
        this.aEA.setAlpha(f2);
        this.eDJ.setAlpha(f2);
        this.eDI.setAlpha(f2);
        this.eDH.setAlpha(f2);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eug.getPageContext(), i);
        }
        at.b(this.eDJ, r.f.icon_more_bg_s, r.f.icon_more_bg);
        at.b(this.eDH, r.d.cp_cont_b, r.d.s_navbar_title_color);
        at.l(this.bPN, r.d.cp_cont_f_alpha60);
    }
}
