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
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class c {
    private int DS4;
    private ImageView RC;
    private Runnable aGI;
    public final View aLM;
    private int bGT;
    private int cQu;
    private PbActivity eMB;
    public TextView eYM;
    public View eYN;
    public View eYO;
    private ImageView eYP;
    private final ImageView eYQ;
    private final LinearLayout eYR;
    public FrameLayout eYS;
    public PbNavbarUserConcernView eYT;
    public HeadImageView eYU;
    private ImageView eYX;
    private PopupWindow eYZ;
    private boolean eZa;
    private int eZb;
    public final NavigationBar mNavigationBar;
    private boolean eTY = false;
    private f eYV = null;
    private y eYW = null;
    private boolean eYY = false;
    private Runnable eZc = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.eTY) {
                view = c.this.eZa ? c.this.eYN : c.this.eYO;
            } else {
                view = c.this.eYO;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.eZa) {
                    g.showPopupWindowAsDropDown(c.this.eYZ, view);
                    if (!c.this.eZa) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fP().removeCallbacks(c.this.eZd);
                    e.fP().postDelayed(c.this.eZd, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eZd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aWj();
        }
    };
    private View.OnClickListener eZe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aWi();
        }
    };

    public c(PbActivity pbActivity) {
        this.cQu = 0;
        this.bGT = 0;
        this.eZb = 0;
        this.DS4 = 0;
        this.eMB = pbActivity;
        this.cQu = l.f(pbActivity, d.e.ds88);
        this.bGT = l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds34);
        this.eZb = l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.eMB.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eMB.ajz();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aLM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.czv);
        this.eYM = this.mNavigationBar.setCenterTextTitle("");
        this.eYQ = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eYR = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds20);
        this.eYR.setPadding(f, 0, f, 0);
        aj.a(this.eYQ, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.eYQ.setVisibility(8);
        this.eYM.setOnClickListener(pbActivity.czv);
        this.eYQ.setOnClickListener(pbActivity.czv);
        this.eYX = (ImageView) this.aLM.findViewById(d.g.widget_navi_back_button);
    }

    public void jH(boolean z) {
        NavigationBar.ControlAlign controlAlign = z ? NavigationBar.ControlAlign.HORIZONTAL_LEFT : NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        if (this.eTY != z) {
            ViewGroup viewGroup = this.mNavigationBar.getViewGroup(this.eTY ? NavigationBar.ControlAlign.HORIZONTAL_LEFT : NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            viewGroup.removeView(this.eYO);
            viewGroup.removeView(this.eYN);
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).removeView(this.eYS);
            this.eYO = null;
            this.eYP = null;
            this.eYN = null;
            this.RC = null;
            this.eYS = null;
            this.eYT = null;
        }
        this.eTY = z;
        if (this.eYO == null && this.eYP == null) {
            this.eYO = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.eMB.czv);
            this.eYP = (ImageView) this.eYO.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cQu, this.cQu);
            layoutParams.rightMargin = this.DS4;
            this.eYO.setLayoutParams(layoutParams);
            aj.a(this.eYP, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.eYN == null && this.RC == null) {
            this.eYN = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.eMB.czv);
            this.RC = (ImageView) this.eYN.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cQu, this.cQu);
            layoutParams2.rightMargin = this.eZb;
            this.eYN.setLayoutParams(layoutParams2);
            aj.a(this.RC, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.eYN.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.eYS == null) {
                this.eYS = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.eYT = (PbNavbarUserConcernView) this.eYS.findViewById(d.g.view_add_concern);
                this.eYU = (HeadImageView) this.eYS.findViewById(d.g.view_host_photo);
                this.eYU.setIsRound(true);
                this.eYU.setDefaultResource(d.f.icon_default_avatar100);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(0, 0, this.bGT, 0);
                this.eYS.setLayoutParams(layoutParams3);
                this.eYT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (this.eYS != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).removeView(this.eYS);
        }
    }

    public void jp(boolean z) {
        if (this.eYN != null) {
            this.eYN.setVisibility(z ? 0 : 8);
        }
    }

    public void jI(boolean z) {
        if (this.eYO != null && !z) {
            this.eYO.setVisibility(8);
        }
    }

    public NavigationBar aWc() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aLM.setVisibility(0);
        } else {
            this.aLM.setVisibility(8);
        }
        jK(z);
    }

    public void nx(String str) {
        if (!TextUtils.isEmpty(str) && !this.eTY) {
            this.eYM.setText(this.eMB.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            jK(true);
            h.oT().cs(str);
            return;
        }
        jK(false);
    }

    public void a(z zVar) {
        if (!this.eMB.isProgressBarShown()) {
            if (this.eYV == null) {
                this.eYW = new y((PbActivity) this.eMB.getPageContext().getOrignalPage(), this.eMB.czv);
                this.eYV = new f(this.eMB.getPageContext().getPageActivity(), this.eYW.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void op() {
                        c.this.eMB.aRA();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oq() {
                    }
                });
            }
            this.eYW.aTM();
            this.eYV.showAtLocation(this.eMB.findViewById(d.g.pb_layout), 17, 0, 0);
            this.eYW.jg(zVar == null ? false : zVar.eQe);
            this.eYW.ji(zVar == null ? false : zVar.eQk);
            this.eYW.jj(zVar == null ? false : zVar.eQl);
            this.eYW.jk(zVar == null ? false : zVar.eQm);
            this.eYW.jl(zVar == null ? true : zVar.eQt);
            if (zVar == null) {
                this.eYW.I(false, false);
                this.eYW.J(false, false);
                this.eYW.l(false, "");
            } else {
                this.eYW.I(zVar.eQi, zVar.eQq);
                this.eYW.J(zVar.eQj, zVar.eQp);
                this.eYW.l(StringUtils.isNull(zVar.eQs) ? false : true, zVar.eQs);
            }
            boolean z = zVar == null ? false : zVar.eQg;
            boolean z2 = zVar == null ? false : zVar.eHB;
            boolean z3 = zVar == null ? false : zVar.isHostOnly;
            boolean z4 = zVar == null ? false : zVar.eQr;
            boolean z5 = zVar == null ? false : zVar.eQh;
            boolean z6 = zVar == null ? false : zVar.eQn;
            boolean z7 = zVar == null ? false : zVar.eQo;
            this.eYW.jh(zVar == null ? false : zVar.eQf);
            this.eYW.H(z4, z3);
            this.eYW.K(z5, z);
            this.eYW.L(z7, z6);
            if (zVar != null) {
                this.eYW.eQa = zVar.eQu;
                if (zVar.eQu) {
                    this.eYW.aTF().setText(d.j.report_text);
                    this.eYW.jk(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aWd() {
        this.eYW.aTL().setText(this.eMB.getResources().getString(d.j.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.eYW != null) {
            this.eYW.abt();
            if (z) {
                this.eYW.aTs().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eYW.aTs().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.eYW.aTs().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eYW.aTs().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eYW.aTD().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eYW.aTD().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void om() {
        if (this.eYW != null) {
            this.eYW.aTN();
        }
        if (this.aGI == null) {
            this.aGI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.eYV != null) {
                        g.a(c.this.eYV, c.this.eMB.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fP().postDelayed(this.aGI, 100L);
    }

    public y aWe() {
        return this.eYW;
    }

    public View aWf() {
        return this.eYQ;
    }

    public boolean aaQ() {
        return this.eYV != null && this.eYV.isShowing();
    }

    public void aFn() {
        if (this.eYW != null) {
            this.eYW.release();
        }
        this.eYV = null;
        this.eYW = null;
        e.fP().removeCallbacks(this.aGI);
    }

    public void aWg() {
        if (this.eYN != null) {
            this.eYN.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eMB.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.C0080d.cp_bg_line_d);
        }
        if (this.RC != null) {
            aj.a(this.RC, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        if (this.eYP != null) {
            aj.a(this.eYP, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.eYT != null) {
            this.eYT.onChangeSkinType(i);
        }
        aj.b(this.eYM, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color);
    }

    public void qb(int i) {
        this.mNavigationBar.onChangeSkinType(this.eMB.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eMB.getResources().getColor(d.C0080d.black_alpha85));
        if (this.eYP != null) {
            this.eYP.setImageResource(d.f.pb_ala_share);
        }
        if (this.RC != null) {
            this.RC.setImageResource(d.f.icon_more_bg);
        }
        this.eYM.setTextColor(this.eMB.getResources().getColor(d.C0080d.cp_cont_g));
        this.eYX.setImageResource(d.f.icon_return_bg);
    }

    public void aWh() {
        this.eYX.setVisibility(0);
        jK(false);
        if (this.eYN != null) {
            this.eYN.setVisibility(8);
        }
        if (this.eYO != null) {
            this.eYO.setVisibility(8);
        }
    }

    public void jJ(boolean z) {
        this.eYX.setVisibility(0);
        jK(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.eYO != null) {
                this.eYO.setVisibility(0);
            }
            if (this.eYN != null) {
                this.eYN.setVisibility(0);
                return;
            }
            return;
        }
        if (this.eYO != null) {
            this.eYO.setVisibility(8);
        }
        if (this.eYN != null) {
            this.eYN.setVisibility(8);
        }
    }

    public void jK(boolean z) {
        if (!this.eTY && z && !"".equals(this.eYM.getText().toString())) {
            this.eYM.setVisibility(0);
        } else {
            this.eYM.setVisibility(8);
        }
    }

    public void jL(boolean z) {
        this.eYY = z;
    }

    public void jM(boolean z) {
        if (!this.eYY || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    jM(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.eZa = z;
            View inflate = LayoutInflater.from(this.eMB.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                if (this.eTY) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eMB, d.e.ds24);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 17;
                    layoutParams.leftMargin = l.f(this.eMB, d.e.ds18);
                } else {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eMB, d.e.ds38);
                }
                textView.setText(d.j.share_tip);
            } else {
                if (this.eTY) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eMB.getPageContext().getContext(), d.e.ds114);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eMB.getPageContext().getContext(), d.e.ds56);
                }
                textView.setText(d.j.fans_call_tip);
            }
            textView.setOnClickListener(this.eZe);
            this.eYZ = new PopupWindow(inflate, -2, -2);
            e.fP().removeCallbacks(this.eZc);
            e.fP().postDelayed(this.eZc, 500L);
        }
    }

    public void aWi() {
        if (this.eZc != null) {
            e.fP().removeCallbacks(this.eZc);
        }
        if (this.eZd != null) {
            e.fP().removeCallbacks(this.eZd);
        }
        aWj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWj() {
        g.a(this.eYZ);
    }
}
