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
/* loaded from: classes6.dex */
public class c {
    private ImageView KA;
    public final View dBy;
    public TextView ddE;
    private ImageView eyT;
    public TextView iOM;
    public View iON;
    private final ImageView iOO;
    private final LinearLayout iOP;
    public LinearLayout iOQ;
    public BarImageView iOR;
    private PopupWindow iOV;
    private boolean iOW;
    private int iOX;
    private int iOY;
    private int iOZ;
    private int iPa;
    private PbFragment iyA;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iOL = 6;
    private boolean iKg = false;
    private AlertDialog iOS = null;
    private ab iOT = null;
    private boolean iOU = false;
    private boolean iPb = true;
    private Runnable gHX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.iOW ? c.this.iON : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.iOW) {
                    g.showPopupWindowAsDropDown(c.this.iOV, view);
                    if (!c.this.iOW) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SHOW_SHARE, true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, true);
                    }
                    e.gy().removeCallbacks(c.this.gHY);
                    e.gy().postDelayed(c.this.gHY, 5000L);
                }
            }
        }
    };
    private Runnable gHY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bIB();
        }
    };
    private View.OnClickListener gHZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.coG();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.iOX = 0;
        this.iOY = 0;
        this.iOZ = 0;
        this.iPa = 0;
        this.iyA = pbFragment;
        this.iOX = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.iOY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.iOZ = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.iOZ - dimens > 0) {
            this.iOZ -= dimens;
        }
        this.iPa = (equipmentWidth - (this.iOZ * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.iyA.bBE();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.dBy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.gle);
        this.iOM = this.mNavigationBar.setCenterTextTitle("");
        this.iOO = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iOP = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iOP.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.iOO, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iOO.setVisibility(8);
        this.iOM.setOnClickListener(pbFragment.gle);
        this.iOO.setOnClickListener(pbFragment.gle);
        this.eyT = (ImageView) this.dBy.findViewById(R.id.widget_navi_back_button);
        if (this.iOQ == null) {
            this.iOQ = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iOR = (BarImageView) this.iOQ.findViewById(R.id.pb_nav_title_forum_image);
            this.iOR.setShowOval(true);
            this.iOR.setOnClickListener(pbFragment.gle);
            this.ddE = (TextView) this.iOQ.findViewById(R.id.pb_nav_title_forum_name);
            this.ddE.setOnClickListener(pbFragment.gle);
            if (this.iOQ.getLayoutParams() != null && (this.iOQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.iOZ > 0 && this.iPa > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iOQ.getLayoutParams();
                marginLayoutParams.leftMargin = this.iOZ;
                marginLayoutParams.rightMargin = this.iOZ;
                this.iOQ.setLayoutParams(marginLayoutParams);
            }
            if (this.iOQ.getVisibility() == 8) {
                this.iOQ.setVisibility(0);
            }
            if (this.iOQ.getAlpha() != 1.0f) {
                this.iOQ.setAlpha(1.0f);
            }
        }
    }

    public void qo(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.iKg = z;
        if (this.iON == null && this.KA == null) {
            this.iON = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.iyA.gle);
            this.KA = (ImageView) this.iON.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iOX, this.iOX);
            layoutParams.rightMargin = this.iOY;
            this.iON.setLayoutParams(layoutParams);
            SvgManager.aDW().a(this.KA, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iON.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void pU(boolean z) {
        if (this.iON != null) {
            this.iON.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cox() {
        return this.mNavigationBar;
    }

    public void qp(boolean z) {
        if (z) {
            this.dBy.setVisibility(0);
        } else {
            this.dBy.setVisibility(8);
        }
        qr(z);
    }

    public void Dt(String str) {
        if (!TextUtils.isEmpty(str) && !this.iKg) {
            this.iOM.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            qr(true);
            i.axf().setForumNameForWaterImage(str);
            return;
        }
        qr(false);
    }

    public void a(ac acVar) {
        if (!this.iyA.getBaseFragmentActivity().isProgressBarShown()) {
            this.iOT = new ab(this.iyA, this.iyA.gle);
            this.iOS = new AlertDialog.Builder(this.iyA.getContext(), R.style.DialogTheme).create();
            this.iOS.setCanceledOnTouchOutside(true);
            g.showDialog(this.iOS, this.iyA.getFragmentActivity());
            Window window = this.iOS.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iOT.getView());
            this.iOT.pK(acVar == null ? false : acVar.iGS);
            this.iOT.pL(acVar == null ? false : acVar.iGW);
            this.iOT.pM(acVar == null ? false : acVar.iHa);
            this.iOT.pN(acVar == null ? false : acVar.iGX);
            this.iOT.pO(acVar == null ? true : acVar.iGU);
            if (acVar == null) {
                this.iOT.Y(false, false);
                this.iOT.Z(false, false);
                this.iOT.v(false, "");
            } else {
                this.iOT.Y(acVar.iGY, acVar.iHf);
                this.iOT.Z(acVar.iGZ, acVar.iHe);
                this.iOT.v(StringUtils.isNull(acVar.iHc) ? false : true, acVar.iHc);
            }
            boolean z = acVar == null ? false : acVar.hS;
            boolean z2 = acVar == null ? false : acVar.isHostOnly;
            boolean z3 = acVar == null ? false : acVar.iGV;
            boolean z4 = acVar == null ? false : acVar.iGT;
            boolean z5 = acVar == null ? false : acVar.iHd;
            boolean z6 = acVar == null ? false : acVar.iHb;
            this.iOT.X(z3, z2);
            this.iOT.aa(z4, z);
            this.iOT.ab(z6, z5);
            if (acVar != null) {
                this.iOT.iGP = acVar.iHg;
                if (acVar.iHg) {
                    this.iOT.cmi().setText(R.string.report_text);
                    this.iOT.pN(false);
                }
            }
            coz();
        }
    }

    public void coy() {
        this.iOT.cmo().setText(TbadkCoreApplication.getInst().getResources().getString(R.string.haved_fans_call));
    }

    private void coz() {
        if (this.iOT != null) {
            this.iOT.cmp();
        }
    }

    public void apm() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iOS != null) {
                        g.dismissDialog(c.this.iOS, c.this.iyA.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.gy().postDelayed(this.runnable, 100L);
    }

    public void coA() {
        if (this.iOS != null) {
            g.dismissDialog(this.iOS, this.iyA.getPageContext().getPageActivity());
        }
    }

    public ab coB() {
        return this.iOT;
    }

    public View coC() {
        return this.iOO;
    }

    public boolean coD() {
        return this.iOS != null && this.iOS.isShowing();
    }

    public void releaseResources() {
        if (this.iOT != null) {
            this.iOT.release();
        }
        this.iOS = null;
        this.iOT = null;
        e.gy().removeCallbacks(this.runnable);
    }

    public void coE() {
        if (this.iON != null) {
            this.iON.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iyA.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aDW().a(this.eyT, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aDW().a(this.KA, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iOM, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.ddE, (int) R.color.cp_cont_b);
        coz();
    }

    public void yW(int i) {
        this.mNavigationBar.onChangeSkinType(this.iyA.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.KA != null) {
            SvgManager.aDW().a(this.KA, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iOM.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aDW().a(this.eyT, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void coF() {
        this.eyT.setVisibility(0);
        qr(false);
        if (this.iON != null) {
            this.iON.setVisibility(8);
        }
    }

    public void qq(boolean z) {
        this.eyT.setVisibility(0);
        qr(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iON != null) {
                this.iON.setVisibility(0);
            }
        } else if (this.iON != null) {
            this.iON.setVisibility(8);
        }
    }

    public void qr(boolean z) {
        if (!this.iKg && z && !"".equals(this.iOM.getText().toString())) {
            this.iOM.setVisibility(0);
        } else {
            this.iOM.setVisibility(8);
        }
    }

    public void qs(boolean z) {
        this.iOU = z;
    }

    public void qt(boolean z) {
        if (!this.iOU || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.CALLS_FAN_TIP_GUIDE, false)) {
                    qt(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
                return;
            }
            this.iOW = z;
            View inflate = LayoutInflater.from(this.iyA.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.getDimens(this.iyA.getContext(), R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.getDimens(this.iyA.getContext(), R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.gHZ);
                this.iOV = new PopupWindow(inflate, -2, -2);
                e.gy().removeCallbacks(this.gHX);
                e.gy().postDelayed(this.gHX, 500L);
            }
        }
    }

    public void coG() {
        if (this.gHX != null) {
            e.gy().removeCallbacks(this.gHX);
        }
        if (this.gHY != null) {
            e.gy().removeCallbacks(this.gHY);
        }
        bIB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        g.dismissPopupWindow(this.iOV);
    }

    public void cy(View view) {
    }

    public void dV(String str, String str2) {
        if (this.iyA != null) {
            if (StringUtils.isNull(str)) {
                this.iOR.setVisibility(8);
                this.ddE.setText("贴吧动态");
                return;
            }
            this.iOR.setVisibility(0);
            this.mForumName = str;
            au.a(this.ddE, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.iPa, false);
            i.axf().setForumNameForWaterImage(str);
            this.iOR.startLoad(str2, 10, false);
        }
    }
}
