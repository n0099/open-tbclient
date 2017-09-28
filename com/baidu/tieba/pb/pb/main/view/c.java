package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class c {
    private ImageView Rx;
    private Runnable aGd;
    public final View aLh;
    private int cGZ;
    private PbActivity eDC;
    private int eEw;
    public TextView ePN;
    public View ePO;
    public View ePP;
    public View ePQ;
    private ImageView ePR;
    private final ImageView ePS;
    private final LinearLayout ePT;
    public FrameLayout ePV;
    public PbNavbarUserConcernView ePW;
    public HeadImageView ePX;
    private ImageView eQa;
    public View eQb;
    private PopupWindow eQd;
    private boolean eQe;
    private int eQf;
    public final NavigationBar mNavigationBar;
    private boolean eLd = false;
    private boolean ePU = false;
    private f ePY = null;
    private w ePZ = null;
    private boolean eQc = false;
    private boolean eKl = false;
    private Runnable eQg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.eLd) {
                view = c.this.eQe ? c.this.ePO : c.this.ePP;
            } else {
                view = c.this.ePP;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.eQe) {
                    g.showPopupWindowAsDropDown(c.this.eQd, view);
                    if (!c.this.eQe) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    c.this.ePU = true;
                    e.fP().removeCallbacks(c.this.eQh);
                    e.fP().postDelayed(c.this.eQh, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eQh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aSS();
        }
    };
    private View.OnClickListener eQi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aSR();
        }
    };

    public c(PbActivity pbActivity) {
        this.cGZ = 0;
        this.eEw = 0;
        this.eQf = 0;
        this.eDC = pbActivity;
        this.cGZ = l.f(pbActivity, d.f.ds88);
        this.eEw = l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds34);
        this.eQf = l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds14);
        this.mNavigationBar = (NavigationBar) this.eDC.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eDC.ahi();
            }
        });
        this.aLh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.crU);
        this.aLh.setPadding(l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds18), this.aLh.getPaddingTop(), this.aLh.getPaddingRight(), this.aLh.getPaddingBottom());
        this.ePN = this.mNavigationBar.setCenterTextTitle("");
        this.ePS = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ePT = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds20);
        this.ePT.setPadding(f, 0, f, 0);
        aj.a(this.ePS, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.ePS.setVisibility(8);
        this.ePN.setOnClickListener(pbActivity.crU);
        this.ePS.setOnClickListener(pbActivity.crU);
        this.eQa = (ImageView) this.aLh.findViewById(d.h.widget_navi_back_button);
        this.eQb = this.mNavigationBar.getBottomLine();
        if (this.eQb != null) {
            this.eQb.setVisibility(8);
        }
    }

    public void jI(boolean z) {
        NavigationBar.ControlAlign controlAlign = z ? NavigationBar.ControlAlign.HORIZONTAL_LEFT : NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.eLd = z;
        if (this.ePP == null && this.ePR == null) {
            this.ePP = this.mNavigationBar.addCustomView(controlAlign, d.j.nb_item_floor_share, this.eDC.crU);
            this.ePR = (ImageView) this.ePP.findViewById(d.h.navigationBarBtnShare);
            this.ePP.setLayoutParams(new LinearLayout.LayoutParams(this.cGZ, this.cGZ));
            aj.a(this.ePR, d.g.icon_pb_navi_selector, d.g.icon_pb_navi_selector);
        }
        if (this.ePO == null && this.Rx == null) {
            this.ePO = this.mNavigationBar.addCustomView(controlAlign, d.j.nb_item_floor_more, this.eDC.crU);
            this.Rx = (ImageView) this.ePO.findViewById(d.h.navigationBarBtnMore);
            this.ePO.setLayoutParams(new LinearLayout.LayoutParams(this.cGZ, this.cGZ));
            aj.a(this.Rx, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
            this.ePO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (this.ePQ == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eQf, this.eQf);
            this.ePQ = this.mNavigationBar.addCustomView(controlAlign, d.j.nb_space, (View.OnClickListener) null);
            this.ePQ.setLayoutParams(layoutParams);
            this.ePQ.setVisibility(4);
        }
        if (z && this.ePV == null) {
            this.ePV = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_user_concern_layout, (View.OnClickListener) null);
            this.ePW = (PbNavbarUserConcernView) this.ePV.findViewById(d.h.view_add_concern);
            this.ePX = (HeadImageView) this.ePV.findViewById(d.h.view_host_photo);
            this.ePX.setIsRound(true);
            this.ePX.setDefaultResource(d.g.icon_default_avatar100);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, this.eEw, 0);
            this.ePV.setLayoutParams(layoutParams2);
            this.ePW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jr(boolean z) {
        if (this.ePO != null) {
            this.ePO.setVisibility(z ? 0 : 8);
        }
    }

    public void jJ(boolean z) {
        if (this.ePP != null && !z) {
            this.ePP.setVisibility(8);
        }
    }

    public NavigationBar aSL() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aLh.setVisibility(0);
        } else {
            this.aLh.setVisibility(8);
        }
        jL(z);
    }

    public void nb(String str) {
        if (!TextUtils.isEmpty(str) && !this.eLd) {
            this.ePN.setText(this.eDC.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, true)));
            jL(true);
            h.oT().cn(str);
            return;
        }
        jL(false);
    }

    public void a(x xVar) {
        if (!this.eDC.isProgressBarShown()) {
            if (this.ePY == null) {
                this.ePZ = new w((PbActivity) this.eDC.getPageContext().getOrignalPage(), this.eDC.crU);
                this.ePY = new f(this.eDC.getPageContext().getPageActivity(), this.ePZ.getView(), aj.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void op() {
                        c.this.eDC.aOq();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oq() {
                    }
                });
            }
            this.ePZ.aQA();
            this.ePY.showAtLocation(this.eDC.findViewById(d.h.pb_layout), 17, 0, 0);
            this.ePZ.jf(xVar == null ? false : xVar.eHq);
            this.ePZ.ji(xVar == null ? false : xVar.eHw);
            this.ePZ.jj(xVar == null ? false : xVar.eHx);
            this.ePZ.jg(xVar == null ? false : xVar.eHp);
            this.ePZ.jk(xVar == null ? false : xVar.eHy);
            this.ePZ.jl(xVar == null ? true : xVar.eHD);
            if (xVar == null) {
                this.ePZ.H(false, false);
                this.ePZ.I(false, false);
                this.ePZ.k(false, "");
            } else {
                this.ePZ.H(xVar.eHu, xVar.eHA);
                this.ePZ.I(xVar.eHv, xVar.eHz);
                this.ePZ.k(StringUtils.isNull(xVar.eHC) ? false : true, xVar.eHC);
            }
            this.ePZ.jm(xVar == null ? false : xVar.eHt);
            boolean z = xVar == null ? false : xVar.eHs;
            boolean z2 = xVar == null ? false : xVar.ezs;
            boolean z3 = xVar == null ? false : xVar.isHostOnly;
            boolean z4 = xVar == null ? false : xVar.eHB;
            this.ePZ.jh(xVar == null ? false : xVar.eHr);
            this.ePZ.G(z4, z3);
            if (xVar != null) {
                this.ePZ.eHm = xVar.eHE;
                if (xVar.eHE) {
                    this.ePZ.aQv().setText(d.l.report_text);
                    this.ePZ.jk(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aSM() {
        this.ePZ.aQz().setText(this.eDC.getResources().getString(d.l.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.ePZ != null) {
            this.ePZ.Zb();
            if (z2) {
                this.ePZ.aQh().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ePZ.aQh().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.ePZ.aQt().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ePZ.aQt().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void om() {
        if (this.ePZ != null) {
            this.ePZ.aQB();
        }
        if (this.aGd == null) {
            this.aGd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ePY != null) {
                        g.a(c.this.ePY, c.this.eDC.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fP().postDelayed(this.aGd, 100L);
    }

    public w aSN() {
        return this.ePZ;
    }

    public View aSO() {
        return this.ePS;
    }

    public boolean Yy() {
        return this.ePY != null && this.ePY.isShowing();
    }

    public void aCT() {
        if (this.ePZ != null) {
            this.ePZ.release();
        }
        this.ePY = null;
        this.ePZ = null;
        e.fP().removeCallbacks(this.aGd);
    }

    public void aSP() {
        if (this.ePO != null) {
            this.ePO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eDC.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.e.cp_bg_line_d);
        }
        if (this.Rx != null) {
            aj.a(this.Rx, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        }
        if (this.ePR != null) {
            aj.a(this.ePR, d.g.icon_pb_navi_selector, d.g.icon_pb_navi_selector);
        }
        if (this.ePW != null) {
            this.ePW.onChangeSkinType(i);
        }
        aj.b(this.ePN, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void pH(int i) {
        this.mNavigationBar.onChangeSkinType(this.eDC.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eDC.getResources().getColor(d.e.black_alpha85));
        if (this.ePR != null) {
            this.ePR.setImageResource(d.g.pb_ala_share);
        }
        if (this.Rx != null) {
            this.Rx.setImageResource(d.g.icon_more_bg);
        }
        this.ePN.setTextColor(this.eDC.getResources().getColor(d.e.cp_cont_g));
        this.eQa.setImageResource(d.g.icon_return_bg);
    }

    public void aSQ() {
        this.eQa.setVisibility(0);
        jL(false);
        if (this.ePO != null) {
            this.ePO.setVisibility(8);
        }
        if (this.ePP != null) {
            this.ePP.setVisibility(8);
        }
    }

    public void jK(boolean z) {
        this.eQa.setVisibility(0);
        jL(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.ePP != null) {
                this.ePP.setVisibility(0);
            }
            if (this.ePO != null) {
                this.ePO.setVisibility(0);
                return;
            }
            return;
        }
        if (this.ePP != null) {
            this.ePP.setVisibility(8);
        }
        if (this.ePO != null) {
            this.ePO.setVisibility(8);
        }
    }

    public void jL(boolean z) {
        if (!this.eLd && z && !"".equals(this.ePN.getText().toString())) {
            this.ePN.setVisibility(0);
        } else {
            this.ePN.setVisibility(8);
        }
    }

    public void jM(boolean z) {
        this.eQc = z;
    }

    public void jN(boolean z) {
        if (!this.eQc || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    jN(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.eQe = z;
            View inflate = LayoutInflater.from(this.eDC.getPageContext().getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.h.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.h.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                if (this.eLd) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eDC, d.f.ds24);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 17;
                    layoutParams.leftMargin = l.f(this.eDC, d.f.ds18);
                } else {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eDC, d.f.ds38);
                }
                textView.setText(d.l.share_tip);
            } else {
                if (this.eLd) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eDC.getPageContext().getContext(), d.f.ds114);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eDC.getPageContext().getContext(), d.f.ds56);
                }
                textView.setText(d.l.fans_call_tip);
            }
            textView.setOnClickListener(this.eQi);
            this.eQd = new PopupWindow(inflate, -2, -2);
            e.fP().removeCallbacks(this.eQg);
            e.fP().postDelayed(this.eQg, 500L);
        }
    }

    public void aSR() {
        if (this.eQg != null) {
            e.fP().removeCallbacks(this.eQg);
        }
        if (this.eQh != null) {
            e.fP().removeCallbacks(this.eQh);
        }
        aSS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSS() {
        g.a(this.eQd);
    }
}
