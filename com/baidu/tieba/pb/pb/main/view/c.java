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
    private int dVI;
    private PbActivity hGm;
    private ThreadForumEnterButtonContainer hIl;
    private final ImageView hSA;
    private final LinearLayout hSB;
    public LinearLayout hSC;
    public BarImageView hSD;
    private ImageView hSG;
    private PopupWindow hSI;
    private boolean hSJ;
    private int hSK;
    private int hSM;
    private int hSN;
    private int hSO;
    public TextView hSy;
    public View hSz;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hSx = 6;
    private boolean hPh = false;
    private AlertDialog hSE = null;
    private aa hSF = null;
    private boolean hSH = false;
    private int[] hSL = new int[2];
    private boolean hSP = true;
    private Runnable fNo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.hSJ ? c.this.hSz : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.hSJ) {
                    g.showPopupWindowAsDropDown(c.this.hSI, view);
                    if (!c.this.hSJ) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("call_fan_guide", true);
                    }
                    e.iB().removeCallbacks(c.this.fNp);
                    e.iB().postDelayed(c.this.fNp, 5000L);
                }
            }
        }
    };
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bqS();
        }
    };
    private View.OnClickListener fNq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bVQ();
        }
    };

    public c(PbActivity pbActivity) {
        this.dVI = 0;
        this.hSK = 0;
        this.hGm = pbActivity;
        this.dVI = l.g(pbActivity, R.dimen.ds88);
        this.hSK = l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hGm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGm.bkf();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fqZ);
        this.hSy = this.mNavigationBar.setCenterTextTitle("");
        this.hSA = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hSB = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hSB.setPadding(g, 0, g, 0);
        al.a(this.hSA, (int) R.drawable.icon_pb_play_small, (int) R.drawable.icon_pb_play_small);
        this.hSA.setVisibility(8);
        this.hSy.setOnClickListener(pbActivity.fqZ);
        this.hSA.setOnClickListener(pbActivity.fqZ);
        this.hSG = (ImageView) this.cAN.findViewById(R.id.widget_navi_back_button);
        if (this.hSC == null) {
            this.hSC = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hSD = (BarImageView) this.hSC.findViewById(R.id.pb_nav_title_forum_image);
            this.hSD.setShowOval(true);
            this.hSD.setOnClickListener(pbActivity.fqZ);
            this.caL = (TextView) this.hSC.findViewById(R.id.pb_nav_title_forum_name);
            this.caL.setOnClickListener(pbActivity.fqZ);
        }
    }

    public void oU(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hPh = z;
        if (this.hSz == null && this.bBk == null) {
            this.hSz = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hGm.fqZ);
            this.bBk = (ImageView) this.hSz.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dVI, this.dVI);
            layoutParams.rightMargin = this.hSK;
            this.hSz.setLayoutParams(layoutParams);
            al.a(this.bBk, (int) R.drawable.icon_nav_more_selector, (int) R.drawable.icon_nav_more_selector);
            this.hSz.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oB(boolean z) {
        if (this.hSz != null) {
            this.hSz.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bVJ() {
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
        if (!TextUtils.isEmpty(str) && !this.hPh) {
            this.hSy.setText(this.hGm.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oX(true);
            i.abb().lZ(str);
            return;
        }
        oX(false);
    }

    public void a(ab abVar) {
        if (!this.hGm.isProgressBarShown()) {
            this.hSF = new aa((PbActivity) this.hGm.getPageContext().getOrignalPage(), this.hGm.fqZ);
            this.hSE = new AlertDialog.Builder(this.hGm, R.style.DialogTheme).create();
            this.hSE.setCanceledOnTouchOutside(true);
            g.a(this.hSE, this.hGm);
            Window window = this.hSE.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hSF.getView());
            this.hSF.os(abVar == null ? false : abVar.hLl);
            this.hSF.ot(abVar == null ? false : abVar.hLp);
            this.hSF.ou(abVar == null ? false : abVar.hLq);
            this.hSF.ov(abVar == null ? false : abVar.hLr);
            this.hSF.ow(abVar == null ? true : abVar.hLy);
            if (abVar == null) {
                this.hSF.V(false, false);
                this.hSF.W(false, false);
                this.hSF.u(false, "");
            } else {
                this.hSF.V(abVar.hLn, abVar.hLv);
                this.hSF.W(abVar.hLo, abVar.hLu);
                this.hSF.u(StringUtils.isNull(abVar.hLx) ? false : true, abVar.hLx);
            }
            boolean z = abVar == null ? false : abVar.ox;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hLw;
            boolean z4 = abVar == null ? false : abVar.hLm;
            boolean z5 = abVar == null ? false : abVar.hLs;
            boolean z6 = abVar == null ? false : abVar.hLt;
            this.hSF.U(z3, z2);
            this.hSF.X(z4, z);
            this.hSF.Y(z6, z5);
            if (abVar != null) {
                this.hSF.hLi = abVar.hLz;
                if (abVar.hLz) {
                    this.hSF.bTH().setText(R.string.report_text);
                    this.hSF.ov(false);
                }
            }
            ac(z, z2);
        }
    }

    public void bVK() {
        this.hSF.bTN().setText(this.hGm.getResources().getString(R.string.haved_fans_call));
    }

    private void ac(boolean z, boolean z2) {
        if (this.hSF != null) {
            this.hSF.setBackGround();
        }
    }

    public void TU() {
        if (this.cvS == null) {
            this.cvS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hSE != null) {
                        g.b(c.this.hSE, c.this.hGm.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.iB().postDelayed(this.cvS, 100L);
    }

    public void bVL() {
        if (this.hSE != null) {
            g.b(this.hSE, this.hGm.getPageContext().getPageActivity());
        }
    }

    public aa bVM() {
        return this.hSF;
    }

    public View bVN() {
        return this.hSA;
    }

    public boolean aYv() {
        return this.hSE != null && this.hSE.isShowing();
    }

    public void bGU() {
        if (this.hSF != null) {
            this.hSF.release();
        }
        this.hSE = null;
        this.hSF = null;
        e.iB().removeCallbacks(this.cvS);
    }

    public void bVO() {
        if (this.hSz != null) {
            this.hSz.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hGm.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
        aq.aik().d(this.hSG, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
        aq.aik().d(this.bBk, R.drawable.icon_topbar_more_n_svg, R.color.select_topbar_icon_color_tint);
        al.e(this.hSy, R.color.cp_cont_b, R.color.s_navbar_title_color);
        al.j(this.caL, R.color.cp_cont_b);
    }

    public void xI(int i) {
        this.mNavigationBar.onChangeSkinType(this.hGm.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hGm.getResources().getColor(R.color.black_alpha85));
        if (this.bBk != null) {
            this.bBk.setImageResource(R.drawable.icon_vnav_more_bg);
        }
        this.hSy.setTextColor(this.hGm.getResources().getColor(R.color.cp_cont_g));
        this.hSG.setImageResource(R.drawable.icon_return_bg);
    }

    public void bVP() {
        this.hSG.setVisibility(0);
        oX(false);
        if (this.hSz != null) {
            this.hSz.setVisibility(8);
        }
    }

    public void oW(boolean z) {
        this.hSG.setVisibility(0);
        oX(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hSz != null) {
                this.hSz.setVisibility(0);
            }
        } else if (this.hSz != null) {
            this.hSz.setVisibility(8);
        }
    }

    public void oX(boolean z) {
        if (!this.hPh && z && !"".equals(this.hSy.getText().toString())) {
            this.hSy.setVisibility(0);
        } else {
            this.hSy.setVisibility(8);
        }
    }

    public void oY(boolean z) {
        this.hSH = z;
    }

    public void oZ(boolean z) {
        if (!this.hSH || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("call_fan_guide", false)) {
                    oZ(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_share", false)) {
                return;
            }
            this.hSJ = z;
            View inflate = LayoutInflater.from(this.hGm.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.hGm, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.hGm, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fNq);
                this.hSI = new PopupWindow(inflate, -2, -2);
                e.iB().removeCallbacks(this.fNo);
                e.iB().postDelayed(this.fNo, 500L);
            }
        }
    }

    public void bVQ() {
        if (this.fNo != null) {
            e.iB().removeCallbacks(this.fNo);
        }
        if (this.fNp != null) {
            e.iB().removeCallbacks(this.fNp);
        }
        bqS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        g.a(this.hSI);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hSH) {
            this.hIl = threadForumEnterButtonContainer;
            this.hIl.getLocationOnScreen(this.hSL);
            this.hSM = this.hSL[1];
            this.hSN = this.hIl.getHeight();
            this.hSO = this.mNavigationBar.getHeight();
            if (!this.hIl.isShown()) {
                if (this.hSC.getVisibility() == 8) {
                    this.hSC.setVisibility(0);
                }
                if (this.hSC.getAlpha() != 1.0f) {
                    this.hSC.setAlpha(1.0f);
                }
            } else if (this.hSM >= this.hSO) {
                if (this.hSC.getVisibility() == 0) {
                    this.hSC.setVisibility(8);
                    this.hSP = true;
                }
                if (this.hSC.getAlpha() != 0.0f) {
                    this.hSC.setAlpha(0.0f);
                }
            } else if (this.hSM < this.hSO && this.hSM > 0) {
                if (this.hSC.getVisibility() == 8) {
                    this.hSC.setVisibility(0);
                    bVR();
                }
                this.hSC.setAlpha(1.0f - ((((this.hSM + this.hSN) - this.hSO) * 1.0f) / this.hSN));
            } else if (this.hSM <= 0) {
                if (this.hSC.getVisibility() == 8) {
                    this.hSC.setVisibility(0);
                    bVR();
                }
                if (this.hSC.getAlpha() != 1.0f) {
                    this.hSC.setAlpha(1.0f);
                }
            }
        }
    }

    public void dN(String str, String str2) {
        if (this.hGm != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.caL.setText(str + this.hGm.getResources().getString(R.string.forum));
            this.hSD.startLoad(str2, 10, false);
        }
    }

    private void bVR() {
        if (this.hGm != null && this.hGm.bQO() != null && this.hSP) {
            this.hSP = false;
            am amVar = new am("c13400");
            amVar.bT("tid", this.hGm.bQO().bSF());
            amVar.bT("fid", this.hGm.bQO().getForumId());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
