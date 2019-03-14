package com.baidu.tieba.pb.pb.main.view;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes4.dex */
public class b {
    public TextView bSQ;
    private ImageView buc;
    private Runnable cnI;
    public final View csB;
    private int dLR;
    public TextView hAN;
    public View hAO;
    private final ImageView hAP;
    private final LinearLayout hAQ;
    public LinearLayout hAR;
    public BarImageView hAS;
    private ImageView hAV;
    private PopupWindow hAX;
    private boolean hAY;
    private int hAZ;
    private int hBb;
    private int hBc;
    private int hBd;
    private PbActivity hoW;
    private ThreadForumEnterButtonContainer hqU;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hAM = 6;
    private boolean hxM = false;
    private AlertDialog hAT = null;
    private aa hAU = null;
    private boolean hAW = false;
    private int[] hBa = new int[2];
    private boolean hBe = true;
    private Runnable fwL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            View view = b.this.hAY ? b.this.hAO : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.hAY) {
                    g.showPopupWindowAsDropDown(b.this.hAX, view);
                    if (!b.this.hAY) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jH().removeCallbacks(b.this.fwM);
                    e.jH().postDelayed(b.this.fwM, 5000L);
                }
            }
        }
    };
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.bjC();
        }
    };
    private View.OnClickListener fwN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bOa();
        }
    };

    public b(PbActivity pbActivity) {
        this.dLR = 0;
        this.hAZ = 0;
        this.hoW = pbActivity;
        this.dLR = l.h(pbActivity, d.e.ds88);
        this.hAZ = l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.hoW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hoW.bcN();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.faY);
        this.hAN = this.mNavigationBar.setCenterTextTitle("");
        this.hAP = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hAQ = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds20);
        this.hAQ.setPadding(h, 0, h, 0);
        al.a(this.hAP, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.hAP.setVisibility(8);
        this.hAN.setOnClickListener(pbActivity.faY);
        this.hAP.setOnClickListener(pbActivity.faY);
        this.hAV = (ImageView) this.csB.findViewById(d.g.widget_navi_back_button);
        if (this.hAR == null) {
            this.hAR = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hAS = (BarImageView) this.hAR.findViewById(d.g.pb_nav_title_forum_image);
            this.hAS.setShowOval(true);
            this.hAS.setOnClickListener(pbActivity.faY);
            this.bSQ = (TextView) this.hAR.findViewById(d.g.pb_nav_title_forum_name);
            this.bSQ.setOnClickListener(pbActivity.faY);
        }
    }

    public void of(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hxM = z;
        if (this.hAO == null && this.buc == null) {
            this.hAO = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.hoW.faY);
            this.buc = (ImageView) this.hAO.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dLR, this.dLR);
            layoutParams.rightMargin = this.hAZ;
            this.hAO.setLayoutParams(layoutParams);
            al.a(this.buc, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.hAO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void nM(boolean z) {
        if (this.hAO != null) {
            this.hAO.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bNT() {
        return this.mNavigationBar;
    }

    public void og(boolean z) {
        if (z) {
            this.csB.setVisibility(0);
        } else {
            this.csB.setVisibility(8);
        }
        oi(z);
    }

    public void xQ(String str) {
        if (!TextUtils.isEmpty(str) && !this.hxM) {
            this.hAN.setText(this.hoW.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oi(true);
            i.Wy().kT(str);
            return;
        }
        oi(false);
    }

    public void a(ab abVar) {
        if (!this.hoW.isProgressBarShown()) {
            this.hAU = new aa((PbActivity) this.hoW.getPageContext().getOrignalPage(), this.hoW.faY);
            this.hAT = new AlertDialog.Builder(this.hoW, d.k.DialogTheme).create();
            this.hAT.setCanceledOnTouchOutside(true);
            g.a(this.hAT, this.hoW);
            Window window = this.hAT.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hAU.getView());
            this.hAU.nD(abVar == null ? false : abVar.htT);
            this.hAU.nE(abVar == null ? false : abVar.htX);
            this.hAU.nF(abVar == null ? false : abVar.htY);
            this.hAU.nG(abVar == null ? false : abVar.htZ);
            this.hAU.nH(abVar == null ? true : abVar.hug);
            if (abVar == null) {
                this.hAU.W(false, false);
                this.hAU.X(false, false);
                this.hAU.v(false, "");
            } else {
                this.hAU.W(abVar.htV, abVar.hud);
                this.hAU.X(abVar.htW, abVar.huc);
                this.hAU.v(StringUtils.isNull(abVar.huf) ? false : true, abVar.huf);
            }
            boolean z = abVar == null ? false : abVar.qV;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hue;
            boolean z4 = abVar == null ? false : abVar.htU;
            boolean z5 = abVar == null ? false : abVar.hua;
            boolean z6 = abVar == null ? false : abVar.hub;
            this.hAU.V(z3, z2);
            this.hAU.Y(z4, z);
            this.hAU.Z(z6, z5);
            if (abVar != null) {
                this.hAU.htQ = abVar.huh;
                if (abVar.huh) {
                    this.hAU.bLT().setText(d.j.report_text);
                    this.hAU.nG(false);
                }
            }
            ad(z, z2);
        }
    }

    public void bNU() {
        this.hAU.bLZ().setText(this.hoW.getResources().getString(d.j.haved_fans_call));
    }

    private void ad(boolean z, boolean z2) {
        if (this.hAU != null) {
            this.hAU.setBackGround();
        }
    }

    public void Qk() {
        if (this.cnI == null) {
            this.cnI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hAT != null) {
                        g.b(b.this.hAT, b.this.hoW.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnI, 100L);
    }

    public void bNV() {
        if (this.hAT != null) {
            g.b(this.hAT, this.hoW.getPageContext().getPageActivity());
        }
    }

    public aa bNW() {
        return this.hAU;
    }

    public View bNX() {
        return this.hAP;
    }

    public boolean aRo() {
        return this.hAT != null && this.hAT.isShowing();
    }

    public void bzn() {
        if (this.hAU != null) {
            this.hAU.release();
        }
        this.hAT = null;
        this.hAU = null;
        e.jH().removeCallbacks(this.cnI);
    }

    public void bNY() {
        if (this.hAO != null) {
            this.hAO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hoW.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        }
        aq.ado().d(this.hAV, d.f.icon_topbar_return_n_svg, d.C0277d.select_topbar_icon_color_tint);
        aq.ado().d(this.buc, d.f.icon_topbar_more_n_svg, d.C0277d.select_topbar_icon_color_tint);
        al.c(this.hAN, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.j(this.bSQ, d.C0277d.cp_cont_b);
    }

    public void wG(int i) {
        this.mNavigationBar.onChangeSkinType(this.hoW.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hoW.getResources().getColor(d.C0277d.black_alpha85));
        if (this.buc != null) {
            this.buc.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.hAN.setTextColor(this.hoW.getResources().getColor(d.C0277d.cp_cont_g));
        this.hAV.setImageResource(d.f.icon_return_bg);
    }

    public void bNZ() {
        this.hAV.setVisibility(0);
        oi(false);
        if (this.hAO != null) {
            this.hAO.setVisibility(8);
        }
    }

    public void oh(boolean z) {
        this.hAV.setVisibility(0);
        oi(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hAO != null) {
                this.hAO.setVisibility(0);
            }
        } else if (this.hAO != null) {
            this.hAO.setVisibility(8);
        }
    }

    public void oi(boolean z) {
        if (!this.hxM && z && !"".equals(this.hAN.getText().toString())) {
            this.hAN.setVisibility(0);
        } else {
            this.hAN.setVisibility(8);
        }
    }

    public void oj(boolean z) {
        this.hAW = z;
    }

    public void ok(boolean z) {
        if (!this.hAW || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    ok(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.hAY = z;
            View inflate = LayoutInflater.from(this.hoW.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.hoW, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.hoW, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fwN);
                this.hAX = new PopupWindow(inflate, -2, -2);
                e.jH().removeCallbacks(this.fwL);
                e.jH().postDelayed(this.fwL, 500L);
            }
        }
    }

    public void bOa() {
        if (this.fwL != null) {
            e.jH().removeCallbacks(this.fwL);
        }
        if (this.fwM != null) {
            e.jH().removeCallbacks(this.fwM);
        }
        bjC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        g.a(this.hAX);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hAW) {
            this.hqU = threadForumEnterButtonContainer;
            this.hqU.getLocationOnScreen(this.hBa);
            this.hBb = this.hBa[1];
            this.hBc = this.hqU.getHeight();
            this.hBd = this.mNavigationBar.getHeight();
            if (!this.hqU.isShown()) {
                if (this.hAR.getVisibility() == 8) {
                    this.hAR.setVisibility(0);
                }
                if (this.hAR.getAlpha() != 1.0f) {
                    this.hAR.setAlpha(1.0f);
                }
            } else if (this.hBb >= this.hBd) {
                if (this.hAR.getVisibility() == 0) {
                    this.hAR.setVisibility(8);
                    this.hBe = true;
                }
                if (this.hAR.getAlpha() != 0.0f) {
                    this.hAR.setAlpha(0.0f);
                }
            } else if (this.hBb < this.hBd && this.hBb > 0) {
                if (this.hAR.getVisibility() == 8) {
                    this.hAR.setVisibility(0);
                    bOb();
                }
                this.hAR.setAlpha(1.0f - ((((this.hBb + this.hBc) - this.hBd) * 1.0f) / this.hBc));
            } else if (this.hBb <= 0) {
                if (this.hAR.getVisibility() == 8) {
                    this.hAR.setVisibility(0);
                    bOb();
                }
                if (this.hAR.getAlpha() != 1.0f) {
                    this.hAR.setAlpha(1.0f);
                }
            }
        }
    }

    public void dA(String str, String str2) {
        if (this.hoW != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.bSQ.setText(str + this.hoW.getResources().getString(d.j.forum));
            this.hAS.startLoad(str2, 10, false);
        }
    }

    private void bOb() {
        if (this.hoW != null && this.hoW.bJa() != null && this.hBe) {
            this.hBe = false;
            am amVar = new am("c13400");
            amVar.bJ("tid", this.hoW.bJa().bKR());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hoW.bJa().getForumId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
