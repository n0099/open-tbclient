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
    public TextView bSS;
    private ImageView bug;
    private Runnable cnK;
    public final View csD;
    private int dLi;
    public View hAA;
    private final ImageView hAB;
    private final LinearLayout hAC;
    public LinearLayout hAD;
    public BarImageView hAE;
    private ImageView hAH;
    private PopupWindow hAJ;
    private boolean hAK;
    private int hAL;
    private int hAN;
    private int hAO;
    private int hAP;
    public TextView hAz;
    private PbActivity hoJ;
    private ThreadForumEnterButtonContainer hqH;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hAy = 6;
    private boolean hxy = false;
    private AlertDialog hAF = null;
    private aa hAG = null;
    private boolean hAI = false;
    private int[] hAM = new int[2];
    private boolean hAQ = true;
    private Runnable fwy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            View view = b.this.hAK ? b.this.hAA : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.hAK) {
                    g.showPopupWindowAsDropDown(b.this.hAJ, view);
                    if (!b.this.hAK) {
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
        this.dLi = 0;
        this.hAL = 0;
        this.hoJ = pbActivity;
        this.dLi = l.h(pbActivity, d.e.ds88);
        this.hAL = l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.hoJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hoJ.bcL();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.csD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.faL);
        this.hAz = this.mNavigationBar.setCenterTextTitle("");
        this.hAB = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hAC = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds20);
        this.hAC.setPadding(h, 0, h, 0);
        al.a(this.hAB, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.hAB.setVisibility(8);
        this.hAz.setOnClickListener(pbActivity.faL);
        this.hAB.setOnClickListener(pbActivity.faL);
        this.hAH = (ImageView) this.csD.findViewById(d.g.widget_navi_back_button);
        if (this.hAD == null) {
            this.hAD = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hAE = (BarImageView) this.hAD.findViewById(d.g.pb_nav_title_forum_image);
            this.hAE.setShowOval(true);
            this.hAE.setOnClickListener(pbActivity.faL);
            this.bSS = (TextView) this.hAD.findViewById(d.g.pb_nav_title_forum_name);
            this.bSS.setOnClickListener(pbActivity.faL);
        }
    }

    public void of(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hxy = z;
        if (this.hAA == null && this.bug == null) {
            this.hAA = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.hoJ.faL);
            this.bug = (ImageView) this.hAA.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dLi, this.dLi);
            layoutParams.rightMargin = this.hAL;
            this.hAA.setLayoutParams(layoutParams);
            al.a(this.bug, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.hAA.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void nM(boolean z) {
        if (this.hAA != null) {
            this.hAA.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bNQ() {
        return this.mNavigationBar;
    }

    public void og(boolean z) {
        if (z) {
            this.csD.setVisibility(0);
        } else {
            this.csD.setVisibility(8);
        }
        oi(z);
    }

    public void xP(String str) {
        if (!TextUtils.isEmpty(str) && !this.hxy) {
            this.hAz.setText(this.hoJ.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oi(true);
            i.Wv().kU(str);
            return;
        }
        oi(false);
    }

    public void a(ab abVar) {
        if (!this.hoJ.isProgressBarShown()) {
            this.hAG = new aa((PbActivity) this.hoJ.getPageContext().getOrignalPage(), this.hoJ.faL);
            this.hAF = new AlertDialog.Builder(this.hoJ, d.k.DialogTheme).create();
            this.hAF.setCanceledOnTouchOutside(true);
            g.a(this.hAF, this.hoJ);
            Window window = this.hAF.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hAG.getView());
            this.hAG.nD(abVar == null ? false : abVar.htG);
            this.hAG.nE(abVar == null ? false : abVar.htK);
            this.hAG.nF(abVar == null ? false : abVar.htL);
            this.hAG.nG(abVar == null ? false : abVar.htM);
            this.hAG.nH(abVar == null ? true : abVar.htT);
            if (abVar == null) {
                this.hAG.U(false, false);
                this.hAG.V(false, false);
                this.hAG.v(false, "");
            } else {
                this.hAG.U(abVar.htI, abVar.htQ);
                this.hAG.V(abVar.htJ, abVar.htP);
                this.hAG.v(StringUtils.isNull(abVar.htS) ? false : true, abVar.htS);
            }
            boolean z = abVar == null ? false : abVar.qV;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.htR;
            boolean z4 = abVar == null ? false : abVar.htH;
            boolean z5 = abVar == null ? false : abVar.htN;
            boolean z6 = abVar == null ? false : abVar.htO;
            this.hAG.T(z3, z2);
            this.hAG.W(z4, z);
            this.hAG.X(z6, z5);
            if (abVar != null) {
                this.hAG.htD = abVar.htU;
                if (abVar.htU) {
                    this.hAG.bLQ().setText(d.j.report_text);
                    this.hAG.nG(false);
                }
            }
            ab(z, z2);
        }
    }

    public void bNR() {
        this.hAG.bLW().setText(this.hoJ.getResources().getString(d.j.haved_fans_call));
    }

    private void ab(boolean z, boolean z2) {
        if (this.hAG != null) {
            this.hAG.setBackGround();
        }
    }

    public void Qi() {
        if (this.cnK == null) {
            this.cnK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hAF != null) {
                        g.b(b.this.hAF, b.this.hoJ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnK, 100L);
    }

    public void bNS() {
        if (this.hAF != null) {
            g.b(this.hAF, this.hoJ.getPageContext().getPageActivity());
        }
    }

    public aa bNT() {
        return this.hAG;
    }

    public View bNU() {
        return this.hAB;
    }

    public boolean aRm() {
        return this.hAF != null && this.hAF.isShowing();
    }

    public void bzk() {
        if (this.hAG != null) {
            this.hAG.release();
        }
        this.hAF = null;
        this.hAG = null;
        e.jH().removeCallbacks(this.cnK);
    }

    public void bNV() {
        if (this.hAA != null) {
            this.hAA.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hoJ.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        }
        aq.adl().d(this.hAH, d.f.icon_topbar_return_n_svg, d.C0277d.select_topbar_icon_color_tint);
        aq.adl().d(this.bug, d.f.icon_topbar_more_n_svg, d.C0277d.select_topbar_icon_color_tint);
        al.c(this.hAz, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
        al.j(this.bSS, d.C0277d.cp_cont_b);
    }

    public void wC(int i) {
        this.mNavigationBar.onChangeSkinType(this.hoJ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hoJ.getResources().getColor(d.C0277d.black_alpha85));
        if (this.bug != null) {
            this.bug.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.hAz.setTextColor(this.hoJ.getResources().getColor(d.C0277d.cp_cont_g));
        this.hAH.setImageResource(d.f.icon_return_bg);
    }

    public void bNW() {
        this.hAH.setVisibility(0);
        oi(false);
        if (this.hAA != null) {
            this.hAA.setVisibility(8);
        }
    }

    public void oh(boolean z) {
        this.hAH.setVisibility(0);
        oi(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hAA != null) {
                this.hAA.setVisibility(0);
            }
        } else if (this.hAA != null) {
            this.hAA.setVisibility(8);
        }
    }

    public void oi(boolean z) {
        if (!this.hxy && z && !"".equals(this.hAz.getText().toString())) {
            this.hAz.setVisibility(0);
        } else {
            this.hAz.setVisibility(8);
        }
    }

    public void oj(boolean z) {
        this.hAI = z;
    }

    public void ok(boolean z) {
        if (!this.hAI || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    ok(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.hAK = z;
            View inflate = LayoutInflater.from(this.hoJ.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.hoJ, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.hoJ, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fwA);
                this.hAJ = new PopupWindow(inflate, -2, -2);
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
        g.a(this.hAJ);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hAI) {
            this.hqH = threadForumEnterButtonContainer;
            this.hqH.getLocationOnScreen(this.hAM);
            this.hAN = this.hAM[1];
            this.hAO = this.hqH.getHeight();
            this.hAP = this.mNavigationBar.getHeight();
            if (!this.hqH.isShown()) {
                if (this.hAD.getVisibility() == 8) {
                    this.hAD.setVisibility(0);
                }
                if (this.hAD.getAlpha() != 1.0f) {
                    this.hAD.setAlpha(1.0f);
                }
            } else if (this.hAN >= this.hAP) {
                if (this.hAD.getVisibility() == 0) {
                    this.hAD.setVisibility(8);
                    this.hAQ = true;
                }
                if (this.hAD.getAlpha() != 0.0f) {
                    this.hAD.setAlpha(0.0f);
                }
            } else if (this.hAN < this.hAP && this.hAN > 0) {
                if (this.hAD.getVisibility() == 8) {
                    this.hAD.setVisibility(0);
                    bNY();
                }
                this.hAD.setAlpha(1.0f - ((((this.hAN + this.hAO) - this.hAP) * 1.0f) / this.hAO));
            } else if (this.hAN <= 0) {
                if (this.hAD.getVisibility() == 8) {
                    this.hAD.setVisibility(0);
                    bNY();
                }
                if (this.hAD.getAlpha() != 1.0f) {
                    this.hAD.setAlpha(1.0f);
                }
            }
        }
    }

    public void dB(String str, String str2) {
        if (this.hoJ != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.bSS.setText(str + this.hoJ.getResources().getString(d.j.forum));
            this.hAE.startLoad(str2, 10, false);
        }
    }

    private void bNY() {
        if (this.hoJ != null && this.hoJ.bIX() != null && this.hAQ) {
            this.hAQ = false;
            am amVar = new am("c13400");
            amVar.bJ("tid", this.hoJ.bIX().bKO());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hoJ.bIX().getForumId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
