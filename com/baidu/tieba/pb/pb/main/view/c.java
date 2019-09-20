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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes4.dex */
public class c {
    private ImageView bCG;
    public final View cDi;
    public TextView ccP;
    private Runnable cyl;
    private int ebs;
    private PbActivity hPu;
    public TextView ibI;
    public View ibJ;
    private final ImageView ibK;
    private final LinearLayout ibL;
    public LinearLayout ibM;
    public BarImageView ibN;
    private ImageView ibQ;
    private PopupWindow ibS;
    private boolean ibT;
    private int ibU;
    private View ibV;
    private int ibX;
    private int ibY;
    private int ibZ;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int ibH = 6;
    private boolean hYr = false;
    private AlertDialog ibO = null;
    private aa ibP = null;
    private boolean ibR = false;
    private int[] ibW = new int[2];
    private boolean ica = true;
    private Runnable fUV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.ibT ? c.this.ibJ : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.ibT) {
                    g.showPopupWindowAsDropDown(c.this.ibS, view);
                    if (!c.this.ibT) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("call_fan_guide", true);
                    }
                    e.iK().removeCallbacks(c.this.fUW);
                    e.iK().postDelayed(c.this.fUW, 5000L);
                }
            }
        }
    };
    private Runnable fUW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.btZ();
        }
    };
    private View.OnClickListener fUX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bZN();
        }
    };

    public c(PbActivity pbActivity) {
        this.ebs = 0;
        this.ibU = 0;
        this.hPu = pbActivity;
        this.ebs = l.g(pbActivity, R.dimen.ds88);
        this.ibU = l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hPu.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hPu.bnf();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.cDi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fyk);
        this.ibI = this.mNavigationBar.setCenterTextTitle("");
        this.ibK = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ibL = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds20);
        this.ibL.setPadding(g, 0, g, 0);
        am.a(this.ibK, (int) R.drawable.icon_pb_play_small, (int) R.drawable.icon_pb_play_small);
        this.ibK.setVisibility(8);
        this.ibI.setOnClickListener(pbActivity.fyk);
        this.ibK.setOnClickListener(pbActivity.fyk);
        this.ibQ = (ImageView) this.cDi.findViewById(R.id.widget_navi_back_button);
        if (this.ibM == null) {
            this.ibM = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.ibN = (BarImageView) this.ibM.findViewById(R.id.pb_nav_title_forum_image);
            this.ibN.setShowOval(true);
            this.ibN.setOnClickListener(pbActivity.fyk);
            this.ccP = (TextView) this.ibM.findViewById(R.id.pb_nav_title_forum_name);
            this.ccP.setOnClickListener(pbActivity.fyk);
        }
    }

    public void pn(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hYr = z;
        if (this.ibJ == null && this.bCG == null) {
            this.ibJ = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hPu.fyk);
            this.bCG = (ImageView) this.ibJ.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ebs, this.ebs);
            layoutParams.rightMargin = this.ibU;
            this.ibJ.setLayoutParams(layoutParams);
            SvgManager.ajv().a(this.bCG, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.ibJ.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oU(boolean z) {
        if (this.ibJ != null) {
            this.ibJ.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bZF() {
        return this.mNavigationBar;
    }

    public void po(boolean z) {
        if (z) {
            this.cDi.setVisibility(0);
        } else {
            this.cDi.setVisibility(8);
        }
        pq(z);
    }

    public void As(String str) {
        if (!TextUtils.isEmpty(str) && !this.hYr) {
            this.ibI.setText(this.hPu.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            pq(true);
            i.ace().mk(str);
            return;
        }
        pq(false);
    }

    public void a(ab abVar) {
        if (!this.hPu.isProgressBarShown()) {
            this.ibP = new aa((PbActivity) this.hPu.getPageContext().getOrignalPage(), this.hPu.fyk);
            this.ibO = new AlertDialog.Builder(this.hPu, R.style.DialogTheme).create();
            this.ibO.setCanceledOnTouchOutside(true);
            g.a(this.ibO, this.hPu);
            Window window = this.ibO.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.ibP.getView());
            this.ibP.oL(abVar == null ? false : abVar.hUu);
            this.ibP.oM(abVar == null ? false : abVar.hUy);
            this.ibP.oN(abVar == null ? false : abVar.hUz);
            this.ibP.oO(abVar == null ? false : abVar.hUA);
            this.ibP.oP(abVar == null ? true : abVar.hUH);
            if (abVar == null) {
                this.ibP.X(false, false);
                this.ibP.Y(false, false);
                this.ibP.v(false, "");
            } else {
                this.ibP.X(abVar.hUw, abVar.hUE);
                this.ibP.Y(abVar.hUx, abVar.hUD);
                this.ibP.v(StringUtils.isNull(abVar.hUG) ? false : true, abVar.hUG);
            }
            boolean z = abVar == null ? false : abVar.oy;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hUF;
            boolean z4 = abVar == null ? false : abVar.hUv;
            boolean z5 = abVar == null ? false : abVar.hUB;
            boolean z6 = abVar == null ? false : abVar.hUC;
            this.ibP.W(z3, z2);
            this.ibP.Z(z4, z);
            this.ibP.aa(z6, z5);
            if (abVar != null) {
                this.ibP.hUr = abVar.hUI;
                if (abVar.hUI) {
                    this.ibP.bXB().setText(R.string.report_text);
                    this.ibP.oO(false);
                }
            }
            bZH();
        }
    }

    public void bZG() {
        this.ibP.bXH().setText(this.hPu.getResources().getString(R.string.haved_fans_call));
    }

    private void bZH() {
        if (this.ibP != null) {
            this.ibP.setBackGround();
        }
    }

    public void UQ() {
        if (this.cyl == null) {
            this.cyl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ibO != null) {
                        g.b(c.this.ibO, c.this.hPu.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.iK().postDelayed(this.cyl, 100L);
    }

    public void bZI() {
        if (this.ibO != null) {
            g.b(this.ibO, this.hPu.getPageContext().getPageActivity());
        }
    }

    public aa bZJ() {
        return this.ibP;
    }

    public View bZK() {
        return this.ibK;
    }

    public boolean bbd() {
        return this.ibO != null && this.ibO.isShowing();
    }

    public void bKG() {
        if (this.ibP != null) {
            this.ibP.release();
        }
        this.ibO = null;
        this.ibP = null;
        e.iK().removeCallbacks(this.cyl);
    }

    public void bZL() {
        if (this.ibJ != null) {
            this.ibJ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hPu.getPageContext(), i);
            am.k(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.ajv().a(this.ibQ, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.bCG, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.e(this.ibI, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.j(this.ccP, R.color.cp_cont_b);
        bZH();
    }

    public void yr(int i) {
        this.mNavigationBar.onChangeSkinType(this.hPu.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hPu.getResources().getColor(R.color.black_alpha85));
        if (this.bCG != null) {
            SvgManager.ajv().a(this.bCG, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.ibI.setTextColor(this.hPu.getResources().getColor(R.color.cp_cont_g));
        SvgManager.ajv().a(this.ibQ, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void bZM() {
        this.ibQ.setVisibility(0);
        pq(false);
        if (this.ibJ != null) {
            this.ibJ.setVisibility(8);
        }
    }

    public void pp(boolean z) {
        this.ibQ.setVisibility(0);
        pq(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.ibJ != null) {
                this.ibJ.setVisibility(0);
            }
        } else if (this.ibJ != null) {
            this.ibJ.setVisibility(8);
        }
    }

    public void pq(boolean z) {
        if (!this.hYr && z && !"".equals(this.ibI.getText().toString())) {
            this.ibI.setVisibility(0);
        } else {
            this.ibI.setVisibility(8);
        }
    }

    public void pr(boolean z) {
        this.ibR = z;
    }

    public void ps(boolean z) {
        if (!this.ibR || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("call_fan_guide", false)) {
                    ps(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_share", false)) {
                return;
            }
            this.ibT = z;
            View inflate = LayoutInflater.from(this.hPu.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.hPu, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.hPu, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fUX);
                this.ibS = new PopupWindow(inflate, -2, -2);
                e.iK().removeCallbacks(this.fUV);
                e.iK().postDelayed(this.fUV, 500L);
            }
        }
    }

    public void bZN() {
        if (this.fUV != null) {
            e.iK().removeCallbacks(this.fUV);
        }
        if (this.fUW != null) {
            e.iK().removeCallbacks(this.fUW);
        }
        btZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btZ() {
        g.a(this.ibS);
    }

    public void cG(View view) {
        if (view != null && !aq.isEmpty(this.mForumName) && !this.ibR) {
            this.ibV = view;
            this.ibV.getLocationOnScreen(this.ibW);
            this.ibX = this.ibW[1];
            this.ibY = this.ibV.getHeight();
            this.ibZ = this.mNavigationBar.getHeight();
            if (!this.ibV.isShown()) {
                if (this.ibM.getVisibility() == 8) {
                    this.ibM.setVisibility(0);
                }
                if (this.ibM.getAlpha() != 1.0f) {
                    this.ibM.setAlpha(1.0f);
                }
            } else if (this.ibX >= this.ibZ) {
                if (this.ibM.getVisibility() == 0) {
                    this.ibM.setVisibility(8);
                    this.ica = true;
                }
                if (this.ibM.getAlpha() != 0.0f) {
                    this.ibM.setAlpha(0.0f);
                }
            } else if (this.ibX < this.ibZ && this.ibX > 0) {
                if (this.ibM.getVisibility() == 8) {
                    this.ibM.setVisibility(0);
                    bZO();
                }
                this.ibM.setAlpha(1.0f - ((((this.ibX + this.ibY) - this.ibZ) * 1.0f) / this.ibY));
            } else if (this.ibX <= 0) {
                if (this.ibM.getVisibility() == 8) {
                    this.ibM.setVisibility(0);
                    bZO();
                }
                if (this.ibM.getAlpha() != 1.0f) {
                    this.ibM.setAlpha(1.0f);
                }
            }
        }
    }

    public void dQ(String str, String str2) {
        if (this.hPu != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.ccP.setText(str + this.hPu.getResources().getString(R.string.forum));
            this.ibN.startLoad(str2, 10, false);
        }
    }

    private void bZO() {
        if (this.hPu != null && this.hPu.bUE() != null && this.ica) {
            this.ica = false;
            an anVar = new an("c13400");
            anVar.bT("tid", this.hPu.bUE().bWy());
            anVar.bT("fid", this.hPu.bUE().getForumId());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
        }
    }
}
