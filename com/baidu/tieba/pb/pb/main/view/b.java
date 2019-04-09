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
    public TextView bST;
    private ImageView buh;
    private Runnable cnL;
    public final View csE;
    private int dLj;
    public TextView hAA;
    public View hAB;
    private final ImageView hAC;
    private final LinearLayout hAD;
    public LinearLayout hAE;
    public BarImageView hAF;
    private ImageView hAI;
    private PopupWindow hAK;
    private boolean hAL;
    private int hAM;
    private int hAO;
    private int hAP;
    private int hAQ;
    private PbActivity hoK;
    private ThreadForumEnterButtonContainer hqI;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hAz = 6;
    private boolean hxz = false;
    private AlertDialog hAG = null;
    private aa hAH = null;
    private boolean hAJ = false;
    private int[] hAN = new int[2];
    private boolean hAR = true;
    private Runnable fwy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            View view = b.this.hAL ? b.this.hAB : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.hAL) {
                    g.showPopupWindowAsDropDown(b.this.hAK, view);
                    if (!b.this.hAL) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jH().removeCallbacks(b.this.fwz);
                    e.jH().postDelayed(b.this.fwz, 5000L);
                }
            }
        }
    };
    private Runnable fwz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.bjA();
        }
    };
    private View.OnClickListener fwA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bNX();
        }
    };

    public b(PbActivity pbActivity) {
        this.dLj = 0;
        this.hAM = 0;
        this.hoK = pbActivity;
        this.dLj = l.h(pbActivity, d.e.ds88);
        this.hAM = l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.hoK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hoK.bcL();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.csE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.faL);
        this.hAA = this.mNavigationBar.setCenterTextTitle("");
        this.hAC = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hAD = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds20);
        this.hAD.setPadding(h, 0, h, 0);
        al.a(this.hAC, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.hAC.setVisibility(8);
        this.hAA.setOnClickListener(pbActivity.faL);
        this.hAC.setOnClickListener(pbActivity.faL);
        this.hAI = (ImageView) this.csE.findViewById(d.g.widget_navi_back_button);
        if (this.hAE == null) {
            this.hAE = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hAF = (BarImageView) this.hAE.findViewById(d.g.pb_nav_title_forum_image);
            this.hAF.setShowOval(true);
            this.hAF.setOnClickListener(pbActivity.faL);
            this.bST = (TextView) this.hAE.findViewById(d.g.pb_nav_title_forum_name);
            this.bST.setOnClickListener(pbActivity.faL);
        }
    }

    public void of(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hxz = z;
        if (this.hAB == null && this.buh == null) {
            this.hAB = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.hoK.faL);
            this.buh = (ImageView) this.hAB.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dLj, this.dLj);
            layoutParams.rightMargin = this.hAM;
            this.hAB.setLayoutParams(layoutParams);
            al.a(this.buh, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.hAB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void nM(boolean z) {
        if (this.hAB != null) {
            this.hAB.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bNQ() {
        return this.mNavigationBar;
    }

    public void og(boolean z) {
        if (z) {
            this.csE.setVisibility(0);
        } else {
            this.csE.setVisibility(8);
        }
        oi(z);
    }

    public void xP(String str) {
        if (!TextUtils.isEmpty(str) && !this.hxz) {
            this.hAA.setText(this.hoK.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oi(true);
            i.Wv().kU(str);
            return;
        }
        oi(false);
    }

    public void a(ab abVar) {
        if (!this.hoK.isProgressBarShown()) {
            this.hAH = new aa((PbActivity) this.hoK.getPageContext().getOrignalPage(), this.hoK.faL);
            this.hAG = new AlertDialog.Builder(this.hoK, d.k.DialogTheme).create();
            this.hAG.setCanceledOnTouchOutside(true);
            g.a(this.hAG, this.hoK);
            Window window = this.hAG.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hAH.getView());
            this.hAH.nD(abVar == null ? false : abVar.htH);
            this.hAH.nE(abVar == null ? false : abVar.htL);
            this.hAH.nF(abVar == null ? false : abVar.htM);
            this.hAH.nG(abVar == null ? false : abVar.htN);
            this.hAH.nH(abVar == null ? true : abVar.htU);
            if (abVar == null) {
                this.hAH.U(false, false);
                this.hAH.V(false, false);
                this.hAH.v(false, "");
            } else {
                this.hAH.U(abVar.htJ, abVar.htR);
                this.hAH.V(abVar.htK, abVar.htQ);
                this.hAH.v(StringUtils.isNull(abVar.htT) ? false : true, abVar.htT);
            }
            boolean z = abVar == null ? false : abVar.qV;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.htS;
            boolean z4 = abVar == null ? false : abVar.htI;
            boolean z5 = abVar == null ? false : abVar.htO;
            boolean z6 = abVar == null ? false : abVar.htP;
            this.hAH.T(z3, z2);
            this.hAH.W(z4, z);
            this.hAH.X(z6, z5);
            if (abVar != null) {
                this.hAH.htE = abVar.htV;
                if (abVar.htV) {
                    this.hAH.bLQ().setText(d.j.report_text);
                    this.hAH.nG(false);
                }
            }
            ab(z, z2);
        }
    }

    public void bNR() {
        this.hAH.bLW().setText(this.hoK.getResources().getString(d.j.haved_fans_call));
    }

    private void ab(boolean z, boolean z2) {
        if (this.hAH != null) {
            this.hAH.setBackGround();
        }
    }

    public void Qi() {
        if (this.cnL == null) {
            this.cnL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hAG != null) {
                        g.b(b.this.hAG, b.this.hoK.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnL, 100L);
    }

    public void bNS() {
        if (this.hAG != null) {
            g.b(this.hAG, this.hoK.getPageContext().getPageActivity());
        }
    }

    public aa bNT() {
        return this.hAH;
    }

    public View bNU() {
        return this.hAC;
    }

    public boolean aRm() {
        return this.hAG != null && this.hAG.isShowing();
    }

    public void bzk() {
        if (this.hAH != null) {
            this.hAH.release();
        }
        this.hAG = null;
        this.hAH = null;
        e.jH().removeCallbacks(this.cnL);
    }

    public void bNV() {
        if (this.hAB != null) {
            this.hAB.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hoK.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        }
        aq.adl().d(this.hAI, d.f.icon_topbar_return_n_svg, d.C0277d.select_topbar_icon_color_tint);
        aq.adl().d(this.buh, d.f.icon_topbar_more_n_svg, d.C0277d.select_topbar_icon_color_tint);
        al.c(this.hAA, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.j(this.bST, d.C0277d.cp_cont_b);
    }

    public void wC(int i) {
        this.mNavigationBar.onChangeSkinType(this.hoK.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hoK.getResources().getColor(d.C0277d.black_alpha85));
        if (this.buh != null) {
            this.buh.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.hAA.setTextColor(this.hoK.getResources().getColor(d.C0277d.cp_cont_g));
        this.hAI.setImageResource(d.f.icon_return_bg);
    }

    public void bNW() {
        this.hAI.setVisibility(0);
        oi(false);
        if (this.hAB != null) {
            this.hAB.setVisibility(8);
        }
    }

    public void oh(boolean z) {
        this.hAI.setVisibility(0);
        oi(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hAB != null) {
                this.hAB.setVisibility(0);
            }
        } else if (this.hAB != null) {
            this.hAB.setVisibility(8);
        }
    }

    public void oi(boolean z) {
        if (!this.hxz && z && !"".equals(this.hAA.getText().toString())) {
            this.hAA.setVisibility(0);
        } else {
            this.hAA.setVisibility(8);
        }
    }

    public void oj(boolean z) {
        this.hAJ = z;
    }

    public void ok(boolean z) {
        if (!this.hAJ || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    ok(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.hAL = z;
            View inflate = LayoutInflater.from(this.hoK.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.hoK, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.hoK, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fwA);
                this.hAK = new PopupWindow(inflate, -2, -2);
                e.jH().removeCallbacks(this.fwy);
                e.jH().postDelayed(this.fwy, 500L);
            }
        }
    }

    public void bNX() {
        if (this.fwy != null) {
            e.jH().removeCallbacks(this.fwy);
        }
        if (this.fwz != null) {
            e.jH().removeCallbacks(this.fwz);
        }
        bjA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjA() {
        g.a(this.hAK);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hAJ) {
            this.hqI = threadForumEnterButtonContainer;
            this.hqI.getLocationOnScreen(this.hAN);
            this.hAO = this.hAN[1];
            this.hAP = this.hqI.getHeight();
            this.hAQ = this.mNavigationBar.getHeight();
            if (!this.hqI.isShown()) {
                if (this.hAE.getVisibility() == 8) {
                    this.hAE.setVisibility(0);
                }
                if (this.hAE.getAlpha() != 1.0f) {
                    this.hAE.setAlpha(1.0f);
                }
            } else if (this.hAO >= this.hAQ) {
                if (this.hAE.getVisibility() == 0) {
                    this.hAE.setVisibility(8);
                    this.hAR = true;
                }
                if (this.hAE.getAlpha() != 0.0f) {
                    this.hAE.setAlpha(0.0f);
                }
            } else if (this.hAO < this.hAQ && this.hAO > 0) {
                if (this.hAE.getVisibility() == 8) {
                    this.hAE.setVisibility(0);
                    bNY();
                }
                this.hAE.setAlpha(1.0f - ((((this.hAO + this.hAP) - this.hAQ) * 1.0f) / this.hAP));
            } else if (this.hAO <= 0) {
                if (this.hAE.getVisibility() == 8) {
                    this.hAE.setVisibility(0);
                    bNY();
                }
                if (this.hAE.getAlpha() != 1.0f) {
                    this.hAE.setAlpha(1.0f);
                }
            }
        }
    }

    public void dB(String str, String str2) {
        if (this.hoK != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.bST.setText(str + this.hoK.getResources().getString(d.j.forum));
            this.hAF.startLoad(str2, 10, false);
        }
    }

    private void bNY() {
        if (this.hoK != null && this.hoK.bIX() != null && this.hAR) {
            this.hAR = false;
            am amVar = new am("c13400");
            amVar.bJ("tid", this.hoK.bIX().bKO());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hoK.bIX().getForumId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
