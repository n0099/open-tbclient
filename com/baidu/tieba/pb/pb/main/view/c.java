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
    private ImageView bUk;
    public final View cNA;
    public TextView cql;
    private ImageView dKE;
    private PbActivity hNh;
    private final ImageView hZA;
    private final LinearLayout hZB;
    public LinearLayout hZC;
    public BarImageView hZD;
    private PopupWindow hZH;
    private boolean hZI;
    private int hZJ;
    private int hZK;
    private View hZL;
    private int hZN;
    private int hZO;
    private int hZP;
    public TextView hZy;
    public View hZz;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int hZx = 6;
    private boolean hWj = false;
    private AlertDialog hZE = null;
    private aa hZF = null;
    private boolean hZG = false;
    private int[] hZM = new int[2];
    private boolean hZQ = true;
    private Runnable fTy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.hZI ? c.this.hZz : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.hZI) {
                    g.showPopupWindowAsDropDown(c.this.hZH, view);
                    if (!c.this.hZI) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_SHARE, true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, true);
                    }
                    e.fZ().removeCallbacks(c.this.fTz);
                    e.fZ().postDelayed(c.this.fTz, 5000L);
                }
            }
        }
    };
    private Runnable fTz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bra();
        }
    };
    private View.OnClickListener fTA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bWN();
        }
    };

    public c(PbActivity pbActivity) {
        this.hZJ = 0;
        this.hZK = 0;
        this.hNh = pbActivity;
        this.hZJ = l.getDimens(pbActivity, R.dimen.ds88);
        this.hZK = l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hNh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hNh.bkj();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.cNA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fwH);
        this.hZy = this.mNavigationBar.setCenterTextTitle("");
        this.hZA = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hZB = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens = l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hZB.setPadding(dimens, 0, dimens, 0);
        am.setNavbarIconSrc(this.hZA, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.hZA.setVisibility(8);
        this.hZy.setOnClickListener(pbActivity.fwH);
        this.hZA.setOnClickListener(pbActivity.fwH);
        this.dKE = (ImageView) this.cNA.findViewById(R.id.widget_navi_back_button);
        if (this.hZC == null) {
            this.hZC = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hZD = (BarImageView) this.hZC.findViewById(R.id.pb_nav_title_forum_image);
            this.hZD.setShowOval(true);
            this.hZD.setOnClickListener(pbActivity.fwH);
            this.cql = (TextView) this.hZC.findViewById(R.id.pb_nav_title_forum_name);
            this.cql.setOnClickListener(pbActivity.fwH);
        }
    }

    public void oW(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hWj = z;
        if (this.hZz == null && this.bUk == null) {
            this.hZz = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hNh.fwH);
            this.bUk = (ImageView) this.hZz.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hZJ, this.hZJ);
            layoutParams.rightMargin = this.hZK;
            this.hZz.setLayoutParams(layoutParams);
            SvgManager.amL().a(this.bUk, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hZz.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oD(boolean z) {
        if (this.hZz != null) {
            this.hZz.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bWF() {
        return this.mNavigationBar;
    }

    public void oX(boolean z) {
        if (z) {
            this.cNA.setVisibility(0);
        } else {
            this.cNA.setVisibility(8);
        }
        oZ(z);
    }

    public void yK(String str) {
        if (!TextUtils.isEmpty(str) && !this.hWj) {
            this.hZy.setText(this.hNh.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oZ(true);
            i.ago().setForumNameForWaterImage(str);
            return;
        }
        oZ(false);
    }

    public void a(ab abVar) {
        if (!this.hNh.isProgressBarShown()) {
            this.hZF = new aa((PbActivity) this.hNh.getPageContext().getOrignalPage(), this.hNh.fwH);
            this.hZE = new AlertDialog.Builder(this.hNh, R.style.DialogTheme).create();
            this.hZE.setCanceledOnTouchOutside(true);
            g.showDialog(this.hZE, this.hNh);
            Window window = this.hZE.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hZF.getView());
            this.hZF.ou(abVar == null ? false : abVar.hSl);
            this.hZF.ov(abVar == null ? false : abVar.hSp);
            this.hZF.ow(abVar == null ? false : abVar.hSq);
            this.hZF.ox(abVar == null ? false : abVar.hSr);
            this.hZF.oy(abVar == null ? true : abVar.hSy);
            if (abVar == null) {
                this.hZF.Z(false, false);
                this.hZF.aa(false, false);
                this.hZF.v(false, "");
            } else {
                this.hZF.Z(abVar.hSn, abVar.hSv);
                this.hZF.aa(abVar.hSo, abVar.hSu);
                this.hZF.v(StringUtils.isNull(abVar.hSx) ? false : true, abVar.hSx);
            }
            boolean z = abVar == null ? false : abVar.gs;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hSw;
            boolean z4 = abVar == null ? false : abVar.hSm;
            boolean z5 = abVar == null ? false : abVar.hSs;
            boolean z6 = abVar == null ? false : abVar.hSt;
            this.hZF.Y(z3, z2);
            this.hZF.ab(z4, z);
            this.hZF.ac(z6, z5);
            if (abVar != null) {
                this.hZF.hSi = abVar.hSz;
                if (abVar.hSz) {
                    this.hZF.bUB().setText(R.string.report_text);
                    this.hZF.ox(false);
                }
            }
            bWH();
        }
    }

    public void bWG() {
        this.hZF.bUH().setText(this.hNh.getResources().getString(R.string.haved_fans_call));
    }

    private void bWH() {
        if (this.hZF != null) {
            this.hZF.setBackGround();
        }
    }

    public void ZD() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hZE != null) {
                        g.dismissDialog(c.this.hZE, c.this.hNh.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fZ().postDelayed(this.runnable, 100L);
    }

    public void bWI() {
        if (this.hZE != null) {
            g.dismissDialog(this.hZE, this.hNh.getPageContext().getPageActivity());
        }
    }

    public aa bWJ() {
        return this.hZF;
    }

    public View bWK() {
        return this.hZA;
    }

    public boolean bbe() {
        return this.hZE != null && this.hZE.isShowing();
    }

    public void bHo() {
        if (this.hZF != null) {
            this.hZF.release();
        }
        this.hZE = null;
        this.hZF = null;
        e.fZ().removeCallbacks(this.runnable);
    }

    public void bWL() {
        if (this.hZz != null) {
            this.hZz.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hNh.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.amL().a(this.dKE, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.bUk, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.hZy, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.cql, (int) R.color.cp_cont_b);
        bWH();
    }

    public void wW(int i) {
        this.mNavigationBar.onChangeSkinType(this.hNh.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hNh.getResources().getColor(R.color.black_alpha85));
        if (this.bUk != null) {
            SvgManager.amL().a(this.bUk, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.hZy.setTextColor(this.hNh.getResources().getColor(R.color.cp_cont_g));
        SvgManager.amL().a(this.dKE, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void bWM() {
        this.dKE.setVisibility(0);
        oZ(false);
        if (this.hZz != null) {
            this.hZz.setVisibility(8);
        }
    }

    public void oY(boolean z) {
        this.dKE.setVisibility(0);
        oZ(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hZz != null) {
                this.hZz.setVisibility(0);
            }
        } else if (this.hZz != null) {
            this.hZz.setVisibility(8);
        }
    }

    public void oZ(boolean z) {
        if (!this.hWj && z && !"".equals(this.hZy.getText().toString())) {
            this.hZy.setVisibility(0);
        } else {
            this.hZy.setVisibility(8);
        }
    }

    public void pa(boolean z) {
        this.hZG = z;
    }

    public void pb(boolean z) {
        if (!this.hZG || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, false)) {
                    pb(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
                return;
            }
            this.hZI = z;
            View inflate = LayoutInflater.from(this.hNh.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.getDimens(this.hNh, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.getDimens(this.hNh, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fTA);
                this.hZH = new PopupWindow(inflate, -2, -2);
                e.fZ().removeCallbacks(this.fTy);
                e.fZ().postDelayed(this.fTy, 500L);
            }
        }
    }

    public void bWN() {
        if (this.fTy != null) {
            e.fZ().removeCallbacks(this.fTy);
        }
        if (this.fTz != null) {
            e.fZ().removeCallbacks(this.fTz);
        }
        bra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        g.dismissPopupWindow(this.hZH);
    }

    public void cC(View view) {
        if (view != null && !aq.isEmpty(this.mForumName) && !this.hZG) {
            this.hZL = view;
            this.hZL.getLocationOnScreen(this.hZM);
            this.hZN = this.hZM[1];
            this.hZO = this.hZL.getHeight();
            this.hZP = this.mNavigationBar.getHeight();
            if (!this.hZL.isShown()) {
                if (this.hZC.getVisibility() == 8) {
                    this.hZC.setVisibility(0);
                }
                if (this.hZC.getAlpha() != 1.0f) {
                    this.hZC.setAlpha(1.0f);
                }
            } else if (this.hZN >= this.hZP) {
                if (this.hZC.getVisibility() == 0) {
                    this.hZC.setVisibility(8);
                    this.hZQ = true;
                }
                if (this.hZC.getAlpha() != 0.0f) {
                    this.hZC.setAlpha(0.0f);
                }
            } else if (this.hZN < this.hZP && this.hZN > 0) {
                if (this.hZC.getVisibility() == 8) {
                    this.hZC.setVisibility(0);
                    bWO();
                }
                this.hZC.setAlpha(1.0f - ((((this.hZN + this.hZO) - this.hZP) * 1.0f) / this.hZO));
            } else if (this.hZN <= 0) {
                if (this.hZC.getVisibility() == 8) {
                    this.hZC.setVisibility(0);
                    bWO();
                }
                if (this.hZC.getAlpha() != 1.0f) {
                    this.hZC.setAlpha(1.0f);
                }
            }
        }
    }

    public void dC(String str, String str2) {
        if (this.hNh != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + StringHelper.STRING_MORE;
            }
            this.cql.setText(str + this.hNh.getResources().getString(R.string.forum));
            this.hZD.startLoad(str2, 10, false);
        }
    }

    private void bWO() {
        if (this.hNh != null && this.hNh.bRD() != null && this.hZQ) {
            this.hZQ = false;
            an anVar = new an("c13400");
            anVar.bS("tid", this.hNh.bRD().bTy());
            anVar.bS("fid", this.hNh.bRD().getForumId());
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
        }
    }
}
