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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes4.dex */
public class c {
    private ImageView bBk;
    public final View cAN;
    public TextView caL;
    private Runnable cvS;
    private int dVJ;
    private PbActivity hGp;
    private ThreadForumEnterButtonContainer hIo;
    public TextView hSB;
    public View hSC;
    private final ImageView hSD;
    private final LinearLayout hSE;
    public LinearLayout hSF;
    public BarImageView hSG;
    private ImageView hSJ;
    private PopupWindow hSL;
    private boolean hSM;
    private int hSN;
    private int hSP;
    private int hSQ;
    private int hSR;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hSA = 6;
    private boolean hPk = false;
    private AlertDialog hSH = null;
    private aa hSI = null;
    private boolean hSK = false;
    private int[] hSO = new int[2];
    private boolean hSS = true;
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.hSM ? c.this.hSC : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.hSM) {
                    g.showPopupWindowAsDropDown(c.this.hSL, view);
                    if (!c.this.hSM) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("call_fan_guide", true);
                    }
                    e.iB().removeCallbacks(c.this.fNq);
                    e.iB().postDelayed(c.this.fNq, 5000L);
                }
            }
        }
    };
    private Runnable fNq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bqV();
        }
    };
    private View.OnClickListener fNr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bVT();
        }
    };

    public c(PbActivity pbActivity) {
        this.dVJ = 0;
        this.hSN = 0;
        this.hGp = pbActivity;
        this.dVJ = l.g(pbActivity, R.dimen.ds88);
        this.hSN = l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hGp.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGp.bki();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fra);
        this.hSB = this.mNavigationBar.setCenterTextTitle("");
        this.hSD = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hSE = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hSE.setPadding(g, 0, g, 0);
        al.a(this.hSD, (int) R.drawable.icon_pb_play_small, (int) R.drawable.icon_pb_play_small);
        this.hSD.setVisibility(8);
        this.hSB.setOnClickListener(pbActivity.fra);
        this.hSD.setOnClickListener(pbActivity.fra);
        this.hSJ = (ImageView) this.cAN.findViewById(R.id.widget_navi_back_button);
        if (this.hSF == null) {
            this.hSF = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hSG = (BarImageView) this.hSF.findViewById(R.id.pb_nav_title_forum_image);
            this.hSG.setShowOval(true);
            this.hSG.setOnClickListener(pbActivity.fra);
            this.caL = (TextView) this.hSF.findViewById(R.id.pb_nav_title_forum_name);
            this.caL.setOnClickListener(pbActivity.fra);
        }
    }

    public void oU(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hPk = z;
        if (this.hSC == null && this.bBk == null) {
            this.hSC = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hGp.fra);
            this.bBk = (ImageView) this.hSC.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dVJ, this.dVJ);
            layoutParams.rightMargin = this.hSN;
            this.hSC.setLayoutParams(layoutParams);
            al.a(this.bBk, (int) R.drawable.icon_nav_more_selector, (int) R.drawable.icon_nav_more_selector);
            this.hSC.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oB(boolean z) {
        if (this.hSC != null) {
            this.hSC.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bVM() {
        return this.mNavigationBar;
    }

    public void oV(boolean z) {
        if (z) {
            this.cAN.setVisibility(0);
        } else {
            this.cAN.setVisibility(8);
        }
        oX(z);
    }

    public void zf(String str) {
        if (!TextUtils.isEmpty(str) && !this.hPk) {
            this.hSB.setText(this.hGp.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oX(true);
            i.abb().lZ(str);
            return;
        }
        oX(false);
    }

    public void a(ab abVar) {
        if (!this.hGp.isProgressBarShown()) {
            this.hSI = new aa((PbActivity) this.hGp.getPageContext().getOrignalPage(), this.hGp.fra);
            this.hSH = new AlertDialog.Builder(this.hGp, R.style.DialogTheme).create();
            this.hSH.setCanceledOnTouchOutside(true);
            g.a(this.hSH, this.hGp);
            Window window = this.hSH.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hSI.getView());
            this.hSI.os(abVar == null ? false : abVar.hLo);
            this.hSI.ot(abVar == null ? false : abVar.hLs);
            this.hSI.ou(abVar == null ? false : abVar.hLt);
            this.hSI.ov(abVar == null ? false : abVar.hLu);
            this.hSI.ow(abVar == null ? true : abVar.hLB);
            if (abVar == null) {
                this.hSI.V(false, false);
                this.hSI.W(false, false);
                this.hSI.u(false, "");
            } else {
                this.hSI.V(abVar.hLq, abVar.hLy);
                this.hSI.W(abVar.hLr, abVar.hLx);
                this.hSI.u(StringUtils.isNull(abVar.hLA) ? false : true, abVar.hLA);
            }
            boolean z = abVar == null ? false : abVar.ox;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hLz;
            boolean z4 = abVar == null ? false : abVar.hLp;
            boolean z5 = abVar == null ? false : abVar.hLv;
            boolean z6 = abVar == null ? false : abVar.hLw;
            this.hSI.U(z3, z2);
            this.hSI.X(z4, z);
            this.hSI.Y(z6, z5);
            if (abVar != null) {
                this.hSI.hLl = abVar.hLC;
                if (abVar.hLC) {
                    this.hSI.bTK().setText(R.string.report_text);
                    this.hSI.ov(false);
                }
            }
            ac(z, z2);
        }
    }

    public void bVN() {
        this.hSI.bTQ().setText(this.hGp.getResources().getString(R.string.haved_fans_call));
    }

    private void ac(boolean z, boolean z2) {
        if (this.hSI != null) {
            this.hSI.setBackGround();
        }
    }

    public void TU() {
        if (this.cvS == null) {
            this.cvS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hSH != null) {
                        g.b(c.this.hSH, c.this.hGp.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.iB().postDelayed(this.cvS, 100L);
    }

    public void bVO() {
        if (this.hSH != null) {
            g.b(this.hSH, this.hGp.getPageContext().getPageActivity());
        }
    }

    public aa bVP() {
        return this.hSI;
    }

    public View bVQ() {
        return this.hSD;
    }

    public boolean aYy() {
        return this.hSH != null && this.hSH.isShowing();
    }

    public void bGX() {
        if (this.hSI != null) {
            this.hSI.release();
        }
        this.hSH = null;
        this.hSI = null;
        e.iB().removeCallbacks(this.cvS);
    }

    public void bVR() {
        if (this.hSC != null) {
            this.hSC.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hGp.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
        aq.aik().d(this.hSJ, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
        aq.aik().d(this.bBk, R.drawable.icon_topbar_more_n_svg, R.color.select_topbar_icon_color_tint);
        al.e(this.hSB, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.j(this.caL, R.color.cp_cont_b);
    }

    public void xI(int i) {
        this.mNavigationBar.onChangeSkinType(this.hGp.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hGp.getResources().getColor(R.color.black_alpha85));
        if (this.bBk != null) {
            this.bBk.setImageResource(R.drawable.icon_vnav_more_bg);
        }
        this.hSB.setTextColor(this.hGp.getResources().getColor(R.color.cp_cont_g));
        this.hSJ.setImageResource(R.drawable.icon_return_bg);
    }

    public void bVS() {
        this.hSJ.setVisibility(0);
        oX(false);
        if (this.hSC != null) {
            this.hSC.setVisibility(8);
        }
    }

    public void oW(boolean z) {
        this.hSJ.setVisibility(0);
        oX(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hSC != null) {
                this.hSC.setVisibility(0);
            }
        } else if (this.hSC != null) {
            this.hSC.setVisibility(8);
        }
    }

    public void oX(boolean z) {
        if (!this.hPk && z && !"".equals(this.hSB.getText().toString())) {
            this.hSB.setVisibility(0);
        } else {
            this.hSB.setVisibility(8);
        }
    }

    public void oY(boolean z) {
        this.hSK = z;
    }

    public void oZ(boolean z) {
        if (!this.hSK || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("call_fan_guide", false)) {
                    oZ(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_share", false)) {
                return;
            }
            this.hSM = z;
            View inflate = LayoutInflater.from(this.hGp.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.hGp, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.hGp, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fNr);
                this.hSL = new PopupWindow(inflate, -2, -2);
                e.iB().removeCallbacks(this.fNp);
                e.iB().postDelayed(this.fNp, 500L);
            }
        }
    }

    public void bVT() {
        if (this.fNp != null) {
            e.iB().removeCallbacks(this.fNp);
        }
        if (this.fNq != null) {
            e.iB().removeCallbacks(this.fNq);
        }
        bqV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqV() {
        g.a(this.hSL);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hSK) {
            this.hIo = threadForumEnterButtonContainer;
            this.hIo.getLocationOnScreen(this.hSO);
            this.hSP = this.hSO[1];
            this.hSQ = this.hIo.getHeight();
            this.hSR = this.mNavigationBar.getHeight();
            if (!this.hIo.isShown()) {
                if (this.hSF.getVisibility() == 8) {
                    this.hSF.setVisibility(0);
                }
                if (this.hSF.getAlpha() != 1.0f) {
                    this.hSF.setAlpha(1.0f);
                }
            } else if (this.hSP >= this.hSR) {
                if (this.hSF.getVisibility() == 0) {
                    this.hSF.setVisibility(8);
                    this.hSS = true;
                }
                if (this.hSF.getAlpha() != 0.0f) {
                    this.hSF.setAlpha(0.0f);
                }
            } else if (this.hSP < this.hSR && this.hSP > 0) {
                if (this.hSF.getVisibility() == 8) {
                    this.hSF.setVisibility(0);
                    bVU();
                }
                this.hSF.setAlpha(1.0f - ((((this.hSP + this.hSQ) - this.hSR) * 1.0f) / this.hSQ));
            } else if (this.hSP <= 0) {
                if (this.hSF.getVisibility() == 8) {
                    this.hSF.setVisibility(0);
                    bVU();
                }
                if (this.hSF.getAlpha() != 1.0f) {
                    this.hSF.setAlpha(1.0f);
                }
            }
        }
    }

    public void dN(String str, String str2) {
        if (this.hGp != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.caL.setText(str + this.hGp.getResources().getString(R.string.forum));
            this.hSG.startLoad(str2, 10, false);
        }
    }

    private void bVU() {
        if (this.hGp != null && this.hGp.bQR() != null && this.hSS) {
            this.hSS = false;
            am amVar = new am("c13400");
            amVar.bT("tid", this.hGp.bQR().bSI());
            amVar.bT("fid", this.hGp.bQR().getForumId());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
