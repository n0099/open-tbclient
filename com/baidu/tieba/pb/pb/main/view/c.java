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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes4.dex */
public class c {
    private ImageView bCi;
    public final View cCf;
    public TextView cbO;
    private Runnable cxi;
    private int dZB;
    private PbActivity hMD;
    private ThreadForumEnterButtonContainer hOC;
    public TextView hYP;
    public View hYQ;
    private final ImageView hYR;
    private final LinearLayout hYS;
    public LinearLayout hYT;
    public BarImageView hYU;
    private ImageView hYX;
    private PopupWindow hYZ;
    private boolean hZa;
    private int hZb;
    private int hZd;
    private int hZe;
    private int hZf;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hYO = 6;
    private boolean hVy = false;
    private AlertDialog hYV = null;
    private aa hYW = null;
    private boolean hYY = false;
    private int[] hZc = new int[2];
    private boolean hZg = true;
    private Runnable fSo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.hZa ? c.this.hYQ : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.hZa) {
                    g.showPopupWindowAsDropDown(c.this.hYZ, view);
                    if (!c.this.hZa) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("call_fan_guide", true);
                    }
                    e.iK().removeCallbacks(c.this.fSp);
                    e.iK().postDelayed(c.this.fSp, 5000L);
                }
            }
        }
    };
    private Runnable fSp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bsY();
        }
    };
    private View.OnClickListener fSq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bYI();
        }
    };

    public c(PbActivity pbActivity) {
        this.dZB = 0;
        this.hZb = 0;
        this.hMD = pbActivity;
        this.dZB = l.g(pbActivity, R.dimen.ds88);
        this.hZb = l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hMD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hMD.bmk();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.cCf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fvY);
        this.hYP = this.mNavigationBar.setCenterTextTitle("");
        this.hYR = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hYS = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hYS.setPadding(g, 0, g, 0);
        am.a(this.hYR, (int) R.drawable.icon_pb_play_small, (int) R.drawable.icon_pb_play_small);
        this.hYR.setVisibility(8);
        this.hYP.setOnClickListener(pbActivity.fvY);
        this.hYR.setOnClickListener(pbActivity.fvY);
        this.hYX = (ImageView) this.cCf.findViewById(R.id.widget_navi_back_button);
        if (this.hYT == null) {
            this.hYT = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hYU = (BarImageView) this.hYT.findViewById(R.id.pb_nav_title_forum_image);
            this.hYU.setShowOval(true);
            this.hYU.setOnClickListener(pbActivity.fvY);
            this.cbO = (TextView) this.hYT.findViewById(R.id.pb_nav_title_forum_name);
            this.cbO.setOnClickListener(pbActivity.fvY);
        }
    }

    public void pj(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hVy = z;
        if (this.hYQ == null && this.bCi == null) {
            this.hYQ = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hMD.fvY);
            this.bCi = (ImageView) this.hYQ.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dZB, this.dZB);
            layoutParams.rightMargin = this.hZb;
            this.hYQ.setLayoutParams(layoutParams);
            am.a(this.bCi, (int) R.drawable.icon_nav_more_selector, (int) R.drawable.icon_nav_more_selector);
            this.hYQ.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oQ(boolean z) {
        if (this.hYQ != null) {
            this.hYQ.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bYB() {
        return this.mNavigationBar;
    }

    public void pk(boolean z) {
        if (z) {
            this.cCf.setVisibility(0);
        } else {
            this.cCf.setVisibility(8);
        }
        pm(z);
    }

    public void zS(String str) {
        if (!TextUtils.isEmpty(str) && !this.hVy) {
            this.hYP.setText(this.hMD.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            pm(true);
            i.aca().mi(str);
            return;
        }
        pm(false);
    }

    public void a(ab abVar) {
        if (!this.hMD.isProgressBarShown()) {
            this.hYW = new aa((PbActivity) this.hMD.getPageContext().getOrignalPage(), this.hMD.fvY);
            this.hYV = new AlertDialog.Builder(this.hMD, R.style.DialogTheme).create();
            this.hYV.setCanceledOnTouchOutside(true);
            g.a(this.hYV, this.hMD);
            Window window = this.hYV.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hYW.getView());
            this.hYW.oH(abVar == null ? false : abVar.hRC);
            this.hYW.oI(abVar == null ? false : abVar.hRG);
            this.hYW.oJ(abVar == null ? false : abVar.hRH);
            this.hYW.oK(abVar == null ? false : abVar.hRI);
            this.hYW.oL(abVar == null ? true : abVar.hRP);
            if (abVar == null) {
                this.hYW.Y(false, false);
                this.hYW.Z(false, false);
                this.hYW.v(false, "");
            } else {
                this.hYW.Y(abVar.hRE, abVar.hRM);
                this.hYW.Z(abVar.hRF, abVar.hRL);
                this.hYW.v(StringUtils.isNull(abVar.hRO) ? false : true, abVar.hRO);
            }
            boolean z = abVar == null ? false : abVar.oy;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hRN;
            boolean z4 = abVar == null ? false : abVar.hRD;
            boolean z5 = abVar == null ? false : abVar.hRJ;
            boolean z6 = abVar == null ? false : abVar.hRK;
            this.hYW.X(z3, z2);
            this.hYW.aa(z4, z);
            this.hYW.ab(z6, z5);
            if (abVar != null) {
                this.hYW.hRz = abVar.hRQ;
                if (abVar.hRQ) {
                    this.hYW.bWy().setText(R.string.report_text);
                    this.hYW.oK(false);
                }
            }
            af(z, z2);
        }
    }

    public void bYC() {
        this.hYW.bWE().setText(this.hMD.getResources().getString(R.string.haved_fans_call));
    }

    private void af(boolean z, boolean z2) {
        if (this.hYW != null) {
            this.hYW.setBackGround();
        }
    }

    public void UM() {
        if (this.cxi == null) {
            this.cxi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hYV != null) {
                        g.b(c.this.hYV, c.this.hMD.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.iK().postDelayed(this.cxi, 100L);
    }

    public void bYD() {
        if (this.hYV != null) {
            g.b(this.hYV, this.hMD.getPageContext().getPageActivity());
        }
    }

    public aa bYE() {
        return this.hYW;
    }

    public View bYF() {
        return this.hYR;
    }

    public boolean bax() {
        return this.hYV != null && this.hYV.isShowing();
    }

    public void bJF() {
        if (this.hYW != null) {
            this.hYW.release();
        }
        this.hYV = null;
        this.hYW = null;
        e.iK().removeCallbacks(this.cxi);
    }

    public void bYG() {
        if (this.hYQ != null) {
            this.hYQ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hMD.getPageContext(), i);
            am.k(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
        ar.ajn().d(this.hYX, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
        ar.ajn().d(this.bCi, R.drawable.icon_topbar_more_n_svg, R.color.select_topbar_icon_color_tint);
        am.e(this.hYP, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.j(this.cbO, R.color.cp_cont_b);
    }

    public void ym(int i) {
        this.mNavigationBar.onChangeSkinType(this.hMD.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hMD.getResources().getColor(R.color.black_alpha85));
        if (this.bCi != null) {
            this.bCi.setImageResource(R.drawable.icon_vnav_more_bg);
        }
        this.hYP.setTextColor(this.hMD.getResources().getColor(R.color.cp_cont_g));
        this.hYX.setImageResource(R.drawable.icon_return_bg);
    }

    public void bYH() {
        this.hYX.setVisibility(0);
        pm(false);
        if (this.hYQ != null) {
            this.hYQ.setVisibility(8);
        }
    }

    public void pl(boolean z) {
        this.hYX.setVisibility(0);
        pm(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hYQ != null) {
                this.hYQ.setVisibility(0);
            }
        } else if (this.hYQ != null) {
            this.hYQ.setVisibility(8);
        }
    }

    public void pm(boolean z) {
        if (!this.hVy && z && !"".equals(this.hYP.getText().toString())) {
            this.hYP.setVisibility(0);
        } else {
            this.hYP.setVisibility(8);
        }
    }

    public void pn(boolean z) {
        this.hYY = z;
    }

    public void po(boolean z) {
        if (!this.hYY || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("call_fan_guide", false)) {
                    po(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_share", false)) {
                return;
            }
            this.hZa = z;
            View inflate = LayoutInflater.from(this.hMD.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.hMD, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.hMD, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fSq);
                this.hYZ = new PopupWindow(inflate, -2, -2);
                e.iK().removeCallbacks(this.fSo);
                e.iK().postDelayed(this.fSo, 500L);
            }
        }
    }

    public void bYI() {
        if (this.fSo != null) {
            e.iK().removeCallbacks(this.fSo);
        }
        if (this.fSp != null) {
            e.iK().removeCallbacks(this.fSp);
        }
        bsY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsY() {
        g.a(this.hYZ);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !aq.isEmpty(this.mForumName) && !this.hYY) {
            this.hOC = threadForumEnterButtonContainer;
            this.hOC.getLocationOnScreen(this.hZc);
            this.hZd = this.hZc[1];
            this.hZe = this.hOC.getHeight();
            this.hZf = this.mNavigationBar.getHeight();
            if (!this.hOC.isShown()) {
                if (this.hYT.getVisibility() == 8) {
                    this.hYT.setVisibility(0);
                }
                if (this.hYT.getAlpha() != 1.0f) {
                    this.hYT.setAlpha(1.0f);
                }
            } else if (this.hZd >= this.hZf) {
                if (this.hYT.getVisibility() == 0) {
                    this.hYT.setVisibility(8);
                    this.hZg = true;
                }
                if (this.hYT.getAlpha() != 0.0f) {
                    this.hYT.setAlpha(0.0f);
                }
            } else if (this.hZd < this.hZf && this.hZd > 0) {
                if (this.hYT.getVisibility() == 8) {
                    this.hYT.setVisibility(0);
                    bYJ();
                }
                this.hYT.setAlpha(1.0f - ((((this.hZd + this.hZe) - this.hZf) * 1.0f) / this.hZe));
            } else if (this.hZd <= 0) {
                if (this.hYT.getVisibility() == 8) {
                    this.hYT.setVisibility(0);
                    bYJ();
                }
                if (this.hYT.getAlpha() != 1.0f) {
                    this.hYT.setAlpha(1.0f);
                }
            }
        }
    }

    public void dO(String str, String str2) {
        if (this.hMD != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.cbO.setText(str + this.hMD.getResources().getString(R.string.forum));
            this.hYU.startLoad(str2, 10, false);
        }
    }

    private void bYJ() {
        if (this.hMD != null && this.hMD.bTD() != null && this.hZg) {
            this.hZg = false;
            an anVar = new an("c13400");
            anVar.bT("tid", this.hMD.bTD().bVv());
            anVar.bT("fid", this.hMD.bTD().getForumId());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
        }
    }
}
