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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.ac;
/* loaded from: classes7.dex */
public class c {
    private ImageView KG;
    public final View dBI;
    public TextView ddO;
    private ImageView eAe;
    private PbFragment iCe;
    private boolean iSA;
    private int iSB;
    private int iSC;
    private int iSD;
    private int iSE;
    public TextView iSq;
    public View iSr;
    private final ImageView iSs;
    private final LinearLayout iSt;
    public LinearLayout iSu;
    public BarImageView iSv;
    private PopupWindow iSz;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iSp = 6;
    private boolean iNK = false;
    private AlertDialog iSw = null;
    private ab iSx = null;
    private boolean iSy = false;
    private boolean iSF = true;
    private Runnable gLk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.iSA ? c.this.iSr : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.iSA) {
                    g.showPopupWindowAsDropDown(c.this.iSz, view);
                    if (!c.this.iSA) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_SHARE, true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, true);
                    }
                    e.gx().removeCallbacks(c.this.gLl);
                    e.gx().postDelayed(c.this.gLl, 5000L);
                }
            }
        }
    };
    private Runnable gLl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bJD();
        }
    };
    private View.OnClickListener gLm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cpN();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.iSB = 0;
        this.iSC = 0;
        this.iSD = 0;
        this.iSE = 0;
        this.iCe = pbFragment;
        this.iSB = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.iSC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.iSD = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.iSD - dimens > 0) {
            this.iSD -= dimens;
        }
        this.iSE = (equipmentWidth - (this.iSD * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.iCe.bCG();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.dBI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.gon);
        this.iSq = this.mNavigationBar.setCenterTextTitle("");
        this.iSs = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iSt = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iSt.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.iSs, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iSs.setVisibility(8);
        this.iSq.setOnClickListener(pbFragment.gon);
        this.iSs.setOnClickListener(pbFragment.gon);
        this.eAe = (ImageView) this.dBI.findViewById(R.id.widget_navi_back_button);
        if (this.iSu == null) {
            this.iSu = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iSv = (BarImageView) this.iSu.findViewById(R.id.pb_nav_title_forum_image);
            this.iSv.setShowOval(true);
            this.iSv.setOnClickListener(pbFragment.gon);
            this.ddO = (TextView) this.iSu.findViewById(R.id.pb_nav_title_forum_name);
            this.ddO.setOnClickListener(pbFragment.gon);
            if (this.iSu.getLayoutParams() != null && (this.iSu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.iSD > 0 && this.iSE > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iSu.getLayoutParams();
                marginLayoutParams.leftMargin = this.iSD;
                marginLayoutParams.rightMargin = this.iSD;
                this.iSu.setLayoutParams(marginLayoutParams);
            }
            if (this.iSu.getVisibility() == 8) {
                this.iSu.setVisibility(0);
            }
            if (this.iSu.getAlpha() != 1.0f) {
                this.iSu.setAlpha(1.0f);
            }
        }
    }

    public void qA(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.iNK = z;
        if (this.iSr == null && this.KG == null) {
            this.iSr = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.iCe.gon);
            this.KG = (ImageView) this.iSr.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iSB, this.iSB);
            layoutParams.rightMargin = this.iSC;
            this.iSr.setLayoutParams(layoutParams);
            SvgManager.aEp().a(this.KG, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iSr.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void qg(boolean z) {
        if (this.iSr != null) {
            this.iSr.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cpE() {
        return this.mNavigationBar;
    }

    public void qB(boolean z) {
        if (z) {
            this.dBI.setVisibility(0);
        } else {
            this.dBI.setVisibility(8);
        }
        qD(z);
    }

    public void DD(String str) {
        if (!TextUtils.isEmpty(str) && !this.iNK) {
            this.iSq.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            qD(true);
            i.axy().setForumNameForWaterImage(str);
            return;
        }
        qD(false);
    }

    public void a(ac acVar) {
        if (!this.iCe.getBaseFragmentActivity().isProgressBarShown()) {
            this.iSx = new ab(this.iCe, this.iCe.gon);
            this.iSw = new AlertDialog.Builder(this.iCe.getContext(), R.style.DialogTheme).create();
            this.iSw.setCanceledOnTouchOutside(true);
            g.showDialog(this.iSw, this.iCe.getFragmentActivity());
            Window window = this.iSw.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iSx.getView());
            this.iSx.pW(acVar == null ? false : acVar.iKw);
            this.iSx.pX(acVar == null ? false : acVar.iKA);
            this.iSx.pY(acVar == null ? false : acVar.iKE);
            this.iSx.pZ(acVar == null ? false : acVar.iKB);
            this.iSx.qa(acVar == null ? true : acVar.iKy);
            if (acVar == null) {
                this.iSx.Y(false, false);
                this.iSx.Z(false, false);
                this.iSx.v(false, "");
            } else {
                this.iSx.Y(acVar.iKC, acVar.iKJ);
                this.iSx.Z(acVar.iKD, acVar.iKI);
                this.iSx.v(StringUtils.isNull(acVar.iKG) ? false : true, acVar.iKG);
            }
            boolean z = acVar == null ? false : acVar.hS;
            boolean z2 = acVar == null ? false : acVar.isHostOnly;
            boolean z3 = acVar == null ? false : acVar.iKz;
            boolean z4 = acVar == null ? false : acVar.iKx;
            boolean z5 = acVar == null ? false : acVar.iKH;
            boolean z6 = acVar == null ? false : acVar.iKF;
            this.iSx.X(z3, z2);
            this.iSx.aa(z4, z);
            this.iSx.ab(z6, z5);
            if (acVar != null) {
                this.iSx.iKt = acVar.iKK;
                if (acVar.iKK) {
                    this.iSx.cnp().setText(R.string.report_text);
                    this.iSx.pZ(false);
                }
            }
            cpG();
        }
    }

    public void cpF() {
        this.iSx.cnv().setText(TbadkCoreApplication.getInst().getResources().getString(R.string.haved_fans_call));
    }

    private void cpG() {
        if (this.iSx != null) {
            this.iSx.cnw();
        }
    }

    public void apF() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iSw != null) {
                        g.dismissDialog(c.this.iSw, c.this.iCe.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.gx().postDelayed(this.runnable, 100L);
    }

    public void cpH() {
        if (this.iSw != null) {
            g.dismissDialog(this.iSw, this.iCe.getPageContext().getPageActivity());
        }
    }

    public ab cpI() {
        return this.iSx;
    }

    public View cpJ() {
        return this.iSs;
    }

    public boolean cpK() {
        return this.iSw != null && this.iSw.isShowing();
    }

    public void releaseResources() {
        if (this.iSx != null) {
            this.iSx.release();
        }
        this.iSw = null;
        this.iSx = null;
        e.gx().removeCallbacks(this.runnable);
    }

    public void cpL() {
        if (this.iSr != null) {
            this.iSr.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iCe.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aEp().a(this.eAe, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.KG, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iSq, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.ddO, (int) R.color.cp_cont_b);
        cpG();
    }

    public void zb(int i) {
        this.mNavigationBar.onChangeSkinType(this.iCe.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.KG != null) {
            SvgManager.aEp().a(this.KG, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iSq.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aEp().a(this.eAe, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cpM() {
        this.eAe.setVisibility(0);
        qD(false);
        if (this.iSr != null) {
            this.iSr.setVisibility(8);
        }
    }

    public void qC(boolean z) {
        this.eAe.setVisibility(0);
        qD(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iSr != null) {
                this.iSr.setVisibility(0);
            }
        } else if (this.iSr != null) {
            this.iSr.setVisibility(8);
        }
    }

    public void qD(boolean z) {
        if (!this.iNK && z && !"".equals(this.iSq.getText().toString())) {
            this.iSq.setVisibility(0);
        } else {
            this.iSq.setVisibility(8);
        }
    }

    public void qE(boolean z) {
        this.iSy = z;
    }

    public void qF(boolean z) {
        if (!this.iSy || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, false)) {
                    qF(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
                return;
            }
            this.iSA = z;
            View inflate = LayoutInflater.from(this.iCe.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.getDimens(this.iCe.getContext(), R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.getDimens(this.iCe.getContext(), R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.gLm);
                this.iSz = new PopupWindow(inflate, -2, -2);
                e.gx().removeCallbacks(this.gLk);
                e.gx().postDelayed(this.gLk, 500L);
            }
        }
    }

    public void cpN() {
        if (this.gLk != null) {
            e.gx().removeCallbacks(this.gLk);
        }
        if (this.gLl != null) {
            e.gx().removeCallbacks(this.gLl);
        }
        bJD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJD() {
        g.dismissPopupWindow(this.iSz);
    }

    public void cD(View view) {
    }

    public void dX(String str, String str2) {
        if (this.iCe != null) {
            if (StringUtils.isNull(str)) {
                this.iSv.setVisibility(8);
                this.ddO.setText("贴吧动态");
                return;
            }
            this.iSv.setVisibility(0);
            this.mForumName = str;
            au.a(this.ddO, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.iSE, false);
            i.axy().setForumNameForWaterImage(str);
            this.iSv.startLoad(str2, 10, false);
        }
    }
}
