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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
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
    private ImageView bVb;
    public final View cOr;
    public TextView crd;
    private ImageView dLv;
    private PbActivity hNY;
    private int iaA;
    private int iaB;
    private View iaC;
    private int iaE;
    private int iaF;
    private int iaG;
    public TextView iap;
    public View iaq;
    private final ImageView iar;
    private final LinearLayout ias;
    public LinearLayout iat;
    public BarImageView iau;
    private PopupWindow iay;
    private boolean iaz;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iao = 6;
    private boolean hXa = false;
    private AlertDialog iav = null;
    private aa iaw = null;
    private boolean iax = false;
    private int[] iaD = new int[2];
    private boolean iaH = true;
    private Runnable fUp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.iaz ? c.this.iaq : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.iaz) {
                    g.showPopupWindowAsDropDown(c.this.iay, view);
                    if (!c.this.iaz) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_SHARE, true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, true);
                    }
                    e.fZ().removeCallbacks(c.this.fUq);
                    e.fZ().postDelayed(c.this.fUq, 5000L);
                }
            }
        }
    };
    private Runnable fUq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.brc();
        }
    };
    private View.OnClickListener fUr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bWP();
        }
    };

    public c(PbActivity pbActivity) {
        this.iaA = 0;
        this.iaB = 0;
        this.hNY = pbActivity;
        this.iaA = l.getDimens(pbActivity, R.dimen.ds88);
        this.iaB = l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hNY.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hNY.bkl();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.cOr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fxy);
        this.iap = this.mNavigationBar.setCenterTextTitle("");
        this.iar = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ias = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens = l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds20);
        this.ias.setPadding(dimens, 0, dimens, 0);
        am.setNavbarIconSrc(this.iar, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iar.setVisibility(8);
        this.iap.setOnClickListener(pbActivity.fxy);
        this.iar.setOnClickListener(pbActivity.fxy);
        this.dLv = (ImageView) this.cOr.findViewById(R.id.widget_navi_back_button);
        if (this.iat == null) {
            this.iat = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iau = (BarImageView) this.iat.findViewById(R.id.pb_nav_title_forum_image);
            this.iau.setShowOval(true);
            this.iau.setOnClickListener(pbActivity.fxy);
            this.crd = (TextView) this.iat.findViewById(R.id.pb_nav_title_forum_name);
            this.crd.setOnClickListener(pbActivity.fxy);
        }
    }

    public void oW(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hXa = z;
        if (this.iaq == null && this.bVb == null) {
            this.iaq = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hNY.fxy);
            this.bVb = (ImageView) this.iaq.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iaA, this.iaA);
            layoutParams.rightMargin = this.iaB;
            this.iaq.setLayoutParams(layoutParams);
            SvgManager.amN().a(this.bVb, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iaq.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oD(boolean z) {
        if (this.iaq != null) {
            this.iaq.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bWH() {
        return this.mNavigationBar;
    }

    public void oX(boolean z) {
        if (z) {
            this.cOr.setVisibility(0);
        } else {
            this.cOr.setVisibility(8);
        }
        oZ(z);
    }

    public void yK(String str) {
        if (!TextUtils.isEmpty(str) && !this.hXa) {
            this.iap.setText(this.hNY.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oZ(true);
            i.agq().setForumNameForWaterImage(str);
            return;
        }
        oZ(false);
    }

    public void a(ab abVar) {
        if (!this.hNY.isProgressBarShown()) {
            this.iaw = new aa((PbActivity) this.hNY.getPageContext().getOrignalPage(), this.hNY.fxy);
            this.iav = new AlertDialog.Builder(this.hNY, R.style.DialogTheme).create();
            this.iav.setCanceledOnTouchOutside(true);
            g.showDialog(this.iav, this.hNY);
            Window window = this.iav.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iaw.getView());
            this.iaw.ou(abVar == null ? false : abVar.hTc);
            this.iaw.ov(abVar == null ? false : abVar.hTg);
            this.iaw.ow(abVar == null ? false : abVar.hTh);
            this.iaw.ox(abVar == null ? false : abVar.hTi);
            this.iaw.oy(abVar == null ? true : abVar.hTp);
            if (abVar == null) {
                this.iaw.Z(false, false);
                this.iaw.aa(false, false);
                this.iaw.v(false, "");
            } else {
                this.iaw.Z(abVar.hTe, abVar.hTm);
                this.iaw.aa(abVar.hTf, abVar.hTl);
                this.iaw.v(StringUtils.isNull(abVar.hTo) ? false : true, abVar.hTo);
            }
            boolean z = abVar == null ? false : abVar.gR;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hTn;
            boolean z4 = abVar == null ? false : abVar.hTd;
            boolean z5 = abVar == null ? false : abVar.hTj;
            boolean z6 = abVar == null ? false : abVar.hTk;
            this.iaw.Y(z3, z2);
            this.iaw.ab(z4, z);
            this.iaw.ac(z6, z5);
            if (abVar != null) {
                this.iaw.hSZ = abVar.hTq;
                if (abVar.hTq) {
                    this.iaw.bUD().setText(R.string.report_text);
                    this.iaw.ox(false);
                }
            }
            bWJ();
        }
    }

    public void bWI() {
        this.iaw.bUJ().setText(this.hNY.getResources().getString(R.string.haved_fans_call));
    }

    private void bWJ() {
        if (this.iaw != null) {
            this.iaw.setBackGround();
        }
    }

    public void ZF() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iav != null) {
                        g.dismissDialog(c.this.iav, c.this.hNY.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fZ().postDelayed(this.runnable, 100L);
    }

    public void bWK() {
        if (this.iav != null) {
            g.dismissDialog(this.iav, this.hNY.getPageContext().getPageActivity());
        }
    }

    public aa bWL() {
        return this.iaw;
    }

    public View bWM() {
        return this.iar;
    }

    public boolean bbg() {
        return this.iav != null && this.iav.isShowing();
    }

    public void bHq() {
        if (this.iaw != null) {
            this.iaw.release();
        }
        this.iav = null;
        this.iaw = null;
        e.fZ().removeCallbacks(this.runnable);
    }

    public void bWN() {
        if (this.iaq != null) {
            this.iaq.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hNY.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.amN().a(this.dLv, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amN().a(this.bVb, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iap, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.crd, (int) R.color.cp_cont_b);
        bWJ();
    }

    public void wX(int i) {
        this.mNavigationBar.onChangeSkinType(this.hNY.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hNY.getResources().getColor(R.color.black_alpha85));
        if (this.bVb != null) {
            SvgManager.amN().a(this.bVb, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iap.setTextColor(this.hNY.getResources().getColor(R.color.cp_cont_g));
        SvgManager.amN().a(this.dLv, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void bWO() {
        this.dLv.setVisibility(0);
        oZ(false);
        if (this.iaq != null) {
            this.iaq.setVisibility(8);
        }
    }

    public void oY(boolean z) {
        this.dLv.setVisibility(0);
        oZ(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iaq != null) {
                this.iaq.setVisibility(0);
            }
        } else if (this.iaq != null) {
            this.iaq.setVisibility(8);
        }
    }

    public void oZ(boolean z) {
        if (!this.hXa && z && !"".equals(this.iap.getText().toString())) {
            this.iap.setVisibility(0);
        } else {
            this.iap.setVisibility(8);
        }
    }

    public void pa(boolean z) {
        this.iax = z;
    }

    public void pb(boolean z) {
        if (!this.iax || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, false)) {
                    pb(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
                return;
            }
            this.iaz = z;
            View inflate = LayoutInflater.from(this.hNY.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.getDimens(this.hNY, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.getDimens(this.hNY, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fUr);
                this.iay = new PopupWindow(inflate, -2, -2);
                e.fZ().removeCallbacks(this.fUp);
                e.fZ().postDelayed(this.fUp, 500L);
            }
        }
    }

    public void bWP() {
        if (this.fUp != null) {
            e.fZ().removeCallbacks(this.fUp);
        }
        if (this.fUq != null) {
            e.fZ().removeCallbacks(this.fUq);
        }
        brc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brc() {
        g.dismissPopupWindow(this.iay);
    }

    public void cC(View view) {
        if (view != null && !aq.isEmpty(this.mForumName) && !this.iax) {
            this.iaC = view;
            this.iaC.getLocationOnScreen(this.iaD);
            this.iaE = this.iaD[1];
            this.iaF = this.iaC.getHeight();
            this.iaG = this.mNavigationBar.getHeight();
            if (!this.iaC.isShown()) {
                if (this.iat.getVisibility() == 8) {
                    this.iat.setVisibility(0);
                }
                if (this.iat.getAlpha() != 1.0f) {
                    this.iat.setAlpha(1.0f);
                }
            } else if (this.iaE >= this.iaG) {
                if (this.iat.getVisibility() == 0) {
                    this.iat.setVisibility(8);
                    this.iaH = true;
                }
                if (this.iat.getAlpha() != 0.0f) {
                    this.iat.setAlpha(0.0f);
                }
            } else if (this.iaE < this.iaG && this.iaE > 0) {
                if (this.iat.getVisibility() == 8) {
                    this.iat.setVisibility(0);
                    bWQ();
                }
                this.iat.setAlpha(1.0f - ((((this.iaE + this.iaF) - this.iaG) * 1.0f) / this.iaF));
            } else if (this.iaE <= 0) {
                if (this.iat.getVisibility() == 8) {
                    this.iat.setVisibility(0);
                    bWQ();
                }
                if (this.iat.getAlpha() != 1.0f) {
                    this.iat.setAlpha(1.0f);
                }
            }
        }
    }

    public void dC(String str, String str2) {
        if (this.hNY != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + StringHelper.STRING_MORE;
            }
            this.crd.setText(str + this.hNY.getResources().getString(R.string.forum));
            this.iau.startLoad(str2, 10, false);
        }
    }

    private void bWQ() {
        if (this.hNY != null && this.hNY.bRF() != null && this.iaH) {
            this.iaH = false;
            an anVar = new an("c13400");
            anVar.bS("tid", this.hNY.bRF().bTA());
            anVar.bS("fid", this.hNY.bRF().getForumId());
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
        }
    }
}
