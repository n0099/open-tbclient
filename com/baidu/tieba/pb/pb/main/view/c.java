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
    private Runnable aGA;
    public final View aLE;
    private int bGG;
    private int cQa;
    private PbActivity eMh;
    private ImageView eYC;
    private PopupWindow eYE;
    private boolean eYF;
    private int eYG;
    public TextView eYr;
    public View eYs;
    public View eYt;
    private ImageView eYu;
    private final ImageView eYv;
    private final LinearLayout eYw;
    public FrameLayout eYx;
    public PbNavbarUserConcernView eYy;
    public HeadImageView eYz;
    public final NavigationBar mNavigationBar;
    private boolean eTD = false;
    private f eYA = null;
    private y eYB = null;
    private boolean eYD = false;
    private Runnable eYH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.eTD) {
                view = c.this.eYF ? c.this.eYs : c.this.eYt;
            } else {
                view = c.this.eYt;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.eYF) {
                    g.showPopupWindowAsDropDown(c.this.eYE, view);
                    if (!c.this.eYF) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fP().removeCallbacks(c.this.eYI);
                    e.fP().postDelayed(c.this.eYI, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eYI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aWb();
        }
    };
    private View.OnClickListener eYJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aWa();
        }
    };

    public c(PbActivity pbActivity) {
        this.cQa = 0;
        this.bGG = 0;
        this.eYG = 0;
        this.DS4 = 0;
        this.eMh = pbActivity;
        this.cQa = l.f(pbActivity, d.e.ds88);
        this.bGG = l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds34);
        this.eYG = l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.eMh.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eMh.ajl();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aLE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.czc);
        this.eYr = this.mNavigationBar.setCenterTextTitle("");
        this.eYv = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eYw = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds20);
        this.eYw.setPadding(f, 0, f, 0);
        aj.a(this.eYv, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.eYv.setVisibility(8);
        this.eYr.setOnClickListener(pbActivity.czc);
        this.eYv.setOnClickListener(pbActivity.czc);
        this.eYC = (ImageView) this.aLE.findViewById(d.g.widget_navi_back_button);
    }

    public void jB(boolean z) {
        NavigationBar.ControlAlign controlAlign = z ? NavigationBar.ControlAlign.HORIZONTAL_LEFT : NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        if (this.eTD != z) {
            ViewGroup viewGroup = this.mNavigationBar.getViewGroup(this.eTD ? NavigationBar.ControlAlign.HORIZONTAL_LEFT : NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            viewGroup.removeView(this.eYt);
            viewGroup.removeView(this.eYs);
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).removeView(this.eYx);
            this.eYt = null;
            this.eYu = null;
            this.eYs = null;
            this.RC = null;
            this.eYx = null;
            this.eYy = null;
        }
        this.eTD = z;
        if (this.eYt == null && this.eYu == null) {
            this.eYt = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.eMh.czc);
            this.eYu = (ImageView) this.eYt.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cQa, this.cQa);
            layoutParams.rightMargin = this.DS4;
            this.eYt.setLayoutParams(layoutParams);
            aj.a(this.eYu, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.eYs == null && this.RC == null) {
            this.eYs = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.eMh.czc);
            this.RC = (ImageView) this.eYs.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cQa, this.cQa);
            layoutParams2.rightMargin = this.eYG;
            this.eYs.setLayoutParams(layoutParams2);
            aj.a(this.RC, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.eYs.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.eYx == null) {
                this.eYx = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.eYy = (PbNavbarUserConcernView) this.eYx.findViewById(d.g.view_add_concern);
                this.eYz = (HeadImageView) this.eYx.findViewById(d.g.view_host_photo);
                this.eYz.setIsRound(true);
                this.eYz.setDefaultResource(d.f.icon_default_avatar100);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(0, 0, this.bGG, 0);
                this.eYx.setLayoutParams(layoutParams3);
                this.eYy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (this.eYx != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).removeView(this.eYx);
        }
    }

    public void jj(boolean z) {
        if (this.eYs != null) {
            this.eYs.setVisibility(z ? 0 : 8);
        }
    }

    public void jC(boolean z) {
        if (this.eYt != null && !z) {
            this.eYt.setVisibility(8);
        }
    }

    public NavigationBar aVU() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aLE.setVisibility(0);
        } else {
            this.aLE.setVisibility(8);
        }
        jE(z);
    }

    public void nv(String str) {
        if (!TextUtils.isEmpty(str) && !this.eTD) {
            this.eYr.setText(this.eMh.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            jE(true);
            h.oT().cs(str);
            return;
        }
        jE(false);
    }

    public void a(z zVar) {
        if (!this.eMh.isProgressBarShown()) {
            if (this.eYA == null) {
                this.eYB = new y((PbActivity) this.eMh.getPageContext().getOrignalPage(), this.eMh.czc);
                this.eYA = new f(this.eMh.getPageContext().getPageActivity(), this.eYB.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void op() {
                        c.this.eMh.aRs();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oq() {
                    }
                });
            }
            this.eYB.aTE();
            this.eYA.showAtLocation(this.eMh.findViewById(d.g.pb_layout), 17, 0, 0);
            this.eYB.ja(zVar == null ? false : zVar.ePK);
            this.eYB.jc(zVar == null ? false : zVar.ePQ);
            this.eYB.jd(zVar == null ? false : zVar.ePR);
            this.eYB.je(zVar == null ? false : zVar.ePS);
            this.eYB.jf(zVar == null ? true : zVar.ePZ);
            if (zVar == null) {
                this.eYB.I(false, false);
                this.eYB.J(false, false);
                this.eYB.k(false, "");
            } else {
                this.eYB.I(zVar.ePO, zVar.ePW);
                this.eYB.J(zVar.ePP, zVar.ePV);
                this.eYB.k(StringUtils.isNull(zVar.ePY) ? false : true, zVar.ePY);
            }
            boolean z = zVar == null ? false : zVar.ePM;
            boolean z2 = zVar == null ? false : zVar.eHh;
            boolean z3 = zVar == null ? false : zVar.isHostOnly;
            boolean z4 = zVar == null ? false : zVar.ePX;
            boolean z5 = zVar == null ? false : zVar.ePN;
            boolean z6 = zVar == null ? false : zVar.ePT;
            boolean z7 = zVar == null ? false : zVar.ePU;
            this.eYB.jb(zVar == null ? false : zVar.ePL);
            this.eYB.H(z4, z3);
            this.eYB.K(z5, z);
            this.eYB.L(z7, z6);
            if (zVar != null) {
                this.eYB.ePG = zVar.eQa;
                if (zVar.eQa) {
                    this.eYB.aTx().setText(d.j.report_text);
                    this.eYB.je(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aVV() {
        this.eYB.aTD().setText(this.eMh.getResources().getString(d.j.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.eYB != null) {
            this.eYB.abh();
            if (z) {
                this.eYB.aTk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eYB.aTk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.eYB.aTk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eYB.aTk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eYB.aTv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eYB.aTv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void om() {
        if (this.eYB != null) {
            this.eYB.aTF();
        }
        if (this.aGA == null) {
            this.aGA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.eYA != null) {
                        g.a(c.this.eYA, c.this.eMh.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fP().postDelayed(this.aGA, 100L);
    }

    public y aVW() {
        return this.eYB;
    }

    public View aVX() {
        return this.eYv;
    }

    public boolean aaE() {
        return this.eYA != null && this.eYA.isShowing();
    }

    public void aFj() {
        if (this.eYB != null) {
            this.eYB.release();
        }
        this.eYA = null;
        this.eYB = null;
        e.fP().removeCallbacks(this.aGA);
    }

    public void aVY() {
        if (this.eYs != null) {
            this.eYs.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eMh.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.C0080d.cp_bg_line_d);
        }
        if (this.RC != null) {
            aj.a(this.RC, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        if (this.eYu != null) {
            aj.a(this.eYu, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.eYy != null) {
            this.eYy.onChangeSkinType(i);
        }
        aj.b(this.eYr, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color);
    }

    public void qa(int i) {
        this.mNavigationBar.onChangeSkinType(this.eMh.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eMh.getResources().getColor(d.C0080d.black_alpha85));
        if (this.eYu != null) {
            this.eYu.setImageResource(d.f.pb_ala_share);
        }
        if (this.RC != null) {
            this.RC.setImageResource(d.f.icon_more_bg);
        }
        this.eYr.setTextColor(this.eMh.getResources().getColor(d.C0080d.cp_cont_g));
        this.eYC.setImageResource(d.f.icon_return_bg);
    }

    public void aVZ() {
        this.eYC.setVisibility(0);
        jE(false);
        if (this.eYs != null) {
            this.eYs.setVisibility(8);
        }
        if (this.eYt != null) {
            this.eYt.setVisibility(8);
        }
    }

    public void jD(boolean z) {
        this.eYC.setVisibility(0);
        jE(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.eYt != null) {
                this.eYt.setVisibility(0);
            }
            if (this.eYs != null) {
                this.eYs.setVisibility(0);
                return;
            }
            return;
        }
        if (this.eYt != null) {
            this.eYt.setVisibility(8);
        }
        if (this.eYs != null) {
            this.eYs.setVisibility(8);
        }
    }

    public void jE(boolean z) {
        if (!this.eTD && z && !"".equals(this.eYr.getText().toString())) {
            this.eYr.setVisibility(0);
        } else {
            this.eYr.setVisibility(8);
        }
    }

    public void jF(boolean z) {
        this.eYD = z;
    }

    public void jG(boolean z) {
        if (!this.eYD || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    jG(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.eYF = z;
            View inflate = LayoutInflater.from(this.eMh.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                if (this.eTD) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eMh, d.e.ds24);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 17;
                    layoutParams.leftMargin = l.f(this.eMh, d.e.ds18);
                } else {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eMh, d.e.ds38);
                }
                textView.setText(d.j.share_tip);
            } else {
                if (this.eTD) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eMh.getPageContext().getContext(), d.e.ds114);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eMh.getPageContext().getContext(), d.e.ds56);
                }
                textView.setText(d.j.fans_call_tip);
            }
            textView.setOnClickListener(this.eYJ);
            this.eYE = new PopupWindow(inflate, -2, -2);
            e.fP().removeCallbacks(this.eYH);
            e.fP().postDelayed(this.eYH, 500L);
        }
    }

    public void aWa() {
        if (this.eYH != null) {
            e.fP().removeCallbacks(this.eYH);
        }
        if (this.eYI != null) {
            e.fP().removeCallbacks(this.eYI);
        }
        aWb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        g.a(this.eYE);
    }
}
