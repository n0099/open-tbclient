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
    private ImageView bBm;
    public final View cAO;
    public TextView caM;
    private Runnable cvT;
    private int dVJ;
    private PbActivity hGq;
    private ThreadForumEnterButtonContainer hIp;
    public TextView hSC;
    public View hSD;
    private final ImageView hSE;
    private final LinearLayout hSF;
    public LinearLayout hSG;
    public BarImageView hSH;
    private ImageView hSK;
    private PopupWindow hSM;
    private boolean hSN;
    private int hSO;
    private int hSQ;
    private int hSR;
    private int hSS;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hSB = 6;
    private boolean hPl = false;
    private AlertDialog hSI = null;
    private aa hSJ = null;
    private boolean hSL = false;
    private int[] hSP = new int[2];
    private boolean hST = true;
    private Runnable fNr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.hSN ? c.this.hSD : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.hSN) {
                    g.showPopupWindowAsDropDown(c.this.hSM, view);
                    if (!c.this.hSN) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("call_fan_guide", true);
                    }
                    e.iB().removeCallbacks(c.this.fNs);
                    e.iB().postDelayed(c.this.fNs, 5000L);
                }
            }
        }
    };
    private Runnable fNs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bqX();
        }
    };
    private View.OnClickListener fNt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bVU();
        }
    };

    public c(PbActivity pbActivity) {
        this.dVJ = 0;
        this.hSO = 0;
        this.hGq = pbActivity;
        this.dVJ = l.g(pbActivity, R.dimen.ds88);
        this.hSO = l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hGq.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGq.bki();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.cAO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fra);
        this.hSC = this.mNavigationBar.setCenterTextTitle("");
        this.hSE = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hSF = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hSF.setPadding(g, 0, g, 0);
        al.a(this.hSE, (int) R.drawable.icon_pb_play_small, (int) R.drawable.icon_pb_play_small);
        this.hSE.setVisibility(8);
        this.hSC.setOnClickListener(pbActivity.fra);
        this.hSE.setOnClickListener(pbActivity.fra);
        this.hSK = (ImageView) this.cAO.findViewById(R.id.widget_navi_back_button);
        if (this.hSG == null) {
            this.hSG = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hSH = (BarImageView) this.hSG.findViewById(R.id.pb_nav_title_forum_image);
            this.hSH.setShowOval(true);
            this.hSH.setOnClickListener(pbActivity.fra);
            this.caM = (TextView) this.hSG.findViewById(R.id.pb_nav_title_forum_name);
            this.caM.setOnClickListener(pbActivity.fra);
        }
    }

    public void oV(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hPl = z;
        if (this.hSD == null && this.bBm == null) {
            this.hSD = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hGq.fra);
            this.bBm = (ImageView) this.hSD.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dVJ, this.dVJ);
            layoutParams.rightMargin = this.hSO;
            this.hSD.setLayoutParams(layoutParams);
            al.a(this.bBm, (int) R.drawable.icon_nav_more_selector, (int) R.drawable.icon_nav_more_selector);
            this.hSD.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oC(boolean z) {
        if (this.hSD != null) {
            this.hSD.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bVN() {
        return this.mNavigationBar;
    }

    public void oW(boolean z) {
        if (z) {
            this.cAO.setVisibility(0);
        } else {
            this.cAO.setVisibility(8);
        }
        oY(z);
    }

    public void zh(String str) {
        if (!TextUtils.isEmpty(str) && !this.hPl) {
            this.hSC.setText(this.hGq.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oY(true);
            i.abb().lY(str);
            return;
        }
        oY(false);
    }

    public void a(ab abVar) {
        if (!this.hGq.isProgressBarShown()) {
            this.hSJ = new aa((PbActivity) this.hGq.getPageContext().getOrignalPage(), this.hGq.fra);
            this.hSI = new AlertDialog.Builder(this.hGq, R.style.DialogTheme).create();
            this.hSI.setCanceledOnTouchOutside(true);
            g.a(this.hSI, this.hGq);
            Window window = this.hSI.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hSJ.getView());
            this.hSJ.ot(abVar == null ? false : abVar.hLp);
            this.hSJ.ou(abVar == null ? false : abVar.hLt);
            this.hSJ.ov(abVar == null ? false : abVar.hLu);
            this.hSJ.ow(abVar == null ? false : abVar.hLv);
            this.hSJ.ox(abVar == null ? true : abVar.hLC);
            if (abVar == null) {
                this.hSJ.V(false, false);
                this.hSJ.W(false, false);
                this.hSJ.u(false, "");
            } else {
                this.hSJ.V(abVar.hLr, abVar.hLz);
                this.hSJ.W(abVar.hLs, abVar.hLy);
                this.hSJ.u(StringUtils.isNull(abVar.hLB) ? false : true, abVar.hLB);
            }
            boolean z = abVar == null ? false : abVar.ox;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hLA;
            boolean z4 = abVar == null ? false : abVar.hLq;
            boolean z5 = abVar == null ? false : abVar.hLw;
            boolean z6 = abVar == null ? false : abVar.hLx;
            this.hSJ.U(z3, z2);
            this.hSJ.X(z4, z);
            this.hSJ.Y(z6, z5);
            if (abVar != null) {
                this.hSJ.hLm = abVar.hLD;
                if (abVar.hLD) {
                    this.hSJ.bTL().setText(R.string.report_text);
                    this.hSJ.ow(false);
                }
            }
            ac(z, z2);
        }
    }

    public void bVO() {
        this.hSJ.bTR().setText(this.hGq.getResources().getString(R.string.haved_fans_call));
    }

    private void ac(boolean z, boolean z2) {
        if (this.hSJ != null) {
            this.hSJ.setBackGround();
        }
    }

    public void TU() {
        if (this.cvT == null) {
            this.cvT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hSI != null) {
                        g.b(c.this.hSI, c.this.hGq.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.iB().postDelayed(this.cvT, 100L);
    }

    public void bVP() {
        if (this.hSI != null) {
            g.b(this.hSI, this.hGq.getPageContext().getPageActivity());
        }
    }

    public aa bVQ() {
        return this.hSJ;
    }

    public View bVR() {
        return this.hSE;
    }

    public boolean aYy() {
        return this.hSI != null && this.hSI.isShowing();
    }

    public void bGY() {
        if (this.hSJ != null) {
            this.hSJ.release();
        }
        this.hSI = null;
        this.hSJ = null;
        e.iB().removeCallbacks(this.cvT);
    }

    public void bVS() {
        if (this.hSD != null) {
            this.hSD.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hGq.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
        aq.aik().d(this.hSK, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
        aq.aik().d(this.bBm, R.drawable.icon_topbar_more_n_svg, R.color.select_topbar_icon_color_tint);
        al.e(this.hSC, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.j(this.caM, R.color.cp_cont_b);
    }

    public void xI(int i) {
        this.mNavigationBar.onChangeSkinType(this.hGq.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hGq.getResources().getColor(R.color.black_alpha85));
        if (this.bBm != null) {
            this.bBm.setImageResource(R.drawable.icon_vnav_more_bg);
        }
        this.hSC.setTextColor(this.hGq.getResources().getColor(R.color.cp_cont_g));
        this.hSK.setImageResource(R.drawable.icon_return_bg);
    }

    public void bVT() {
        this.hSK.setVisibility(0);
        oY(false);
        if (this.hSD != null) {
            this.hSD.setVisibility(8);
        }
    }

    public void oX(boolean z) {
        this.hSK.setVisibility(0);
        oY(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hSD != null) {
                this.hSD.setVisibility(0);
            }
        } else if (this.hSD != null) {
            this.hSD.setVisibility(8);
        }
    }

    public void oY(boolean z) {
        if (!this.hPl && z && !"".equals(this.hSC.getText().toString())) {
            this.hSC.setVisibility(0);
        } else {
            this.hSC.setVisibility(8);
        }
    }

    public void oZ(boolean z) {
        this.hSL = z;
    }

    public void pa(boolean z) {
        if (!this.hSL || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("call_fan_guide", false)) {
                    pa(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_share", false)) {
                return;
            }
            this.hSN = z;
            View inflate = LayoutInflater.from(this.hGq.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.hGq, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.hGq, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fNt);
                this.hSM = new PopupWindow(inflate, -2, -2);
                e.iB().removeCallbacks(this.fNr);
                e.iB().postDelayed(this.fNr, 500L);
            }
        }
    }

    public void bVU() {
        if (this.fNr != null) {
            e.iB().removeCallbacks(this.fNr);
        }
        if (this.fNs != null) {
            e.iB().removeCallbacks(this.fNs);
        }
        bqX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqX() {
        g.a(this.hSM);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hSL) {
            this.hIp = threadForumEnterButtonContainer;
            this.hIp.getLocationOnScreen(this.hSP);
            this.hSQ = this.hSP[1];
            this.hSR = this.hIp.getHeight();
            this.hSS = this.mNavigationBar.getHeight();
            if (!this.hIp.isShown()) {
                if (this.hSG.getVisibility() == 8) {
                    this.hSG.setVisibility(0);
                }
                if (this.hSG.getAlpha() != 1.0f) {
                    this.hSG.setAlpha(1.0f);
                }
            } else if (this.hSQ >= this.hSS) {
                if (this.hSG.getVisibility() == 0) {
                    this.hSG.setVisibility(8);
                    this.hST = true;
                }
                if (this.hSG.getAlpha() != 0.0f) {
                    this.hSG.setAlpha(0.0f);
                }
            } else if (this.hSQ < this.hSS && this.hSQ > 0) {
                if (this.hSG.getVisibility() == 8) {
                    this.hSG.setVisibility(0);
                    bVV();
                }
                this.hSG.setAlpha(1.0f - ((((this.hSQ + this.hSR) - this.hSS) * 1.0f) / this.hSR));
            } else if (this.hSQ <= 0) {
                if (this.hSG.getVisibility() == 8) {
                    this.hSG.setVisibility(0);
                    bVV();
                }
                if (this.hSG.getAlpha() != 1.0f) {
                    this.hSG.setAlpha(1.0f);
                }
            }
        }
    }

    public void dN(String str, String str2) {
        if (this.hGq != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.caM.setText(str + this.hGq.getResources().getString(R.string.forum));
            this.hSH.startLoad(str2, 10, false);
        }
    }

    private void bVV() {
        if (this.hGq != null && this.hGq.bQS() != null && this.hST) {
            this.hST = false;
            am amVar = new am("c13400");
            amVar.bT("tid", this.hGq.bQS().bSJ());
            amVar.bT("fid", this.hGq.bQS().getForumId());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
