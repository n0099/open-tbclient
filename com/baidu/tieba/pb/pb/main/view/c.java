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
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.main.z;
/* loaded from: classes9.dex */
public class c {
    private ImageView Lb;
    public final View dGn;
    public TextView diw;
    private ImageView eFf;
    private PbFragment iFL;
    public TextView iVA;
    public View iVB;
    private final ImageView iVC;
    private final LinearLayout iVD;
    public LinearLayout iVE;
    public BarImageView iVF;
    private PopupWindow iVJ;
    private int iVK;
    private int iVL;
    private int iVM;
    private int iVN;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iVz = 6;
    private boolean iQU = false;
    private AlertDialog iVG = null;
    private y iVH = null;
    private boolean iVI = false;
    private boolean iVO = true;
    private Runnable gOF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLv();
        }
    };
    private View.OnClickListener gOG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.crD();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.iVK = 0;
        this.iVL = 0;
        this.iVM = 0;
        this.iVN = 0;
        this.iFL = pbFragment;
        this.iVK = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.iVL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.iVM = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.iVM - dimens > 0) {
            this.iVM -= dimens;
        }
        this.iVN = (equipmentWidth - (this.iVM * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.iFL.bEv();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.dGn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.grn);
        this.iVA = this.mNavigationBar.setCenterTextTitle("");
        this.iVC = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iVD = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iVD.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.iVC, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iVC.setVisibility(8);
        this.iVA.setOnClickListener(pbFragment.grn);
        this.iVC.setOnClickListener(pbFragment.grn);
        this.eFf = (ImageView) this.dGn.findViewById(R.id.widget_navi_back_button);
        if (this.iVE == null) {
            this.iVE = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iVF = (BarImageView) this.iVE.findViewById(R.id.pb_nav_title_forum_image);
            this.iVF.setShowOval(true);
            this.iVF.setOnClickListener(pbFragment.grn);
            this.diw = (TextView) this.iVE.findViewById(R.id.pb_nav_title_forum_name);
            this.diw.setOnClickListener(pbFragment.grn);
            if (this.iVE.getLayoutParams() != null && (this.iVE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.iVM > 0 && this.iVN > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iVE.getLayoutParams();
                marginLayoutParams.leftMargin = this.iVM;
                marginLayoutParams.rightMargin = this.iVM;
                this.iVE.setLayoutParams(marginLayoutParams);
            }
            if (this.iVE.getVisibility() == 8) {
                this.iVE.setVisibility(0);
            }
            if (this.iVE.getAlpha() != 1.0f) {
                this.iVE.setAlpha(1.0f);
            }
        }
    }

    public void qJ(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.iQU = z;
        if (this.iVB == null && this.Lb == null) {
            this.iVB = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.iFL.grn);
            this.Lb = (ImageView) this.iVB.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iVK, this.iVK);
            layoutParams.rightMargin = this.iVL;
            this.iVB.setLayoutParams(layoutParams);
            SvgManager.aGG().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iVB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void qp(boolean z) {
        if (this.iVB != null) {
            this.iVB.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar crv() {
        return this.mNavigationBar;
    }

    public void qK(boolean z) {
        if (z) {
            this.dGn.setVisibility(0);
        } else {
            this.dGn.setVisibility(8);
        }
        qM(z);
    }

    public void DU(String str) {
        if (!TextUtils.isEmpty(str) && !this.iQU) {
            this.iVA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            qM(true);
            i.azR().setForumNameForWaterImage(str);
            return;
        }
        qM(false);
    }

    public void a(z zVar) {
        if (!this.iFL.getBaseFragmentActivity().isProgressBarShown()) {
            this.iVH = new y(this.iFL, this.iFL.grn);
            this.iVG = new AlertDialog.Builder(this.iFL.getContext(), R.style.DialogTheme).create();
            this.iVG.setCanceledOnTouchOutside(true);
            g.showDialog(this.iVG, this.iFL.getFragmentActivity());
            Window window = this.iVG.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iVH.getView());
            this.iVH.qf(zVar == null ? false : zVar.iNH);
            this.iVH.qg(zVar == null ? false : zVar.iNL);
            this.iVH.qh(zVar == null ? false : zVar.iNP);
            this.iVH.qi(zVar == null ? false : zVar.iNM);
            this.iVH.qj(zVar == null ? true : zVar.iNJ);
            if (zVar == null) {
                this.iVH.aa(false, false);
                this.iVH.ab(false, false);
            } else {
                this.iVH.aa(zVar.iNN, zVar.iNT);
                this.iVH.ab(zVar.iNO, zVar.iNS);
            }
            boolean z = zVar == null ? false : zVar.hV;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iNK;
            boolean z4 = zVar == null ? false : zVar.iNI;
            boolean z5 = zVar == null ? false : zVar.iNR;
            boolean z6 = zVar == null ? false : zVar.iNQ;
            this.iVH.Z(z3, z2);
            this.iVH.ac(z4, z);
            this.iVH.ad(z6, z5);
            if (zVar != null) {
                this.iVH.iNE = zVar.iNU;
                if (zVar.iNU) {
                    this.iVH.cpf().setText(R.string.report_text);
                    this.iVH.qi(false);
                }
            }
            crw();
        }
    }

    private void crw() {
        if (this.iVH != null) {
            this.iVH.cpl();
        }
    }

    public void arX() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iVG != null) {
                        g.dismissDialog(c.this.iVG, c.this.iFL.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.gx().postDelayed(this.runnable, 100L);
    }

    public void crx() {
        if (this.iVG != null) {
            g.dismissDialog(this.iVG, this.iFL.getPageContext().getPageActivity());
        }
    }

    public y cry() {
        return this.iVH;
    }

    public View crz() {
        return this.iVC;
    }

    public boolean crA() {
        return this.iVG != null && this.iVG.isShowing();
    }

    public void releaseResources() {
        if (this.iVH != null) {
            this.iVH.release();
        }
        this.iVG = null;
        this.iVH = null;
        e.gx().removeCallbacks(this.runnable);
    }

    public void crB() {
        if (this.iVB != null) {
            this.iVB.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iFL.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aGG().a(this.eFf, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iVA, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.diw, (int) R.color.cp_cont_b);
        crw();
    }

    public void zp(int i) {
        this.mNavigationBar.onChangeSkinType(this.iFL.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.Lb != null) {
            SvgManager.aGG().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iVA.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aGG().a(this.eFf, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void crC() {
        this.eFf.setVisibility(0);
        qM(false);
        if (this.iVB != null) {
            this.iVB.setVisibility(8);
        }
    }

    public void qL(boolean z) {
        this.eFf.setVisibility(0);
        qM(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iVB != null) {
                this.iVB.setVisibility(0);
            }
        } else if (this.iVB != null) {
            this.iVB.setVisibility(8);
        }
    }

    public void qM(boolean z) {
        if (!this.iQU && z && !"".equals(this.iVA.getText().toString())) {
            this.iVA.setVisibility(0);
        } else {
            this.iVA.setVisibility(8);
        }
    }

    public void qN(boolean z) {
        this.iVI = z;
    }

    public void cqh() {
        if ((!this.iVI || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.iFL.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.iFL.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.iFL.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.gOG);
            this.iVJ = new PopupWindow(inflate, -2, -2);
        }
    }

    public void crD() {
        if (this.gOF != null) {
            e.gx().removeCallbacks(this.gOF);
        }
        bLv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLv() {
        g.dismissPopupWindow(this.iVJ);
    }

    public void cC(View view) {
    }

    public void ee(String str, String str2) {
        if (this.iFL != null) {
            if (StringUtils.isNull(str)) {
                this.iVF.setVisibility(8);
                this.diw.setText("贴吧动态");
                return;
            }
            this.iVF.setVisibility(0);
            this.mForumName = str;
            au.a(this.diw, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.iVN, false);
            i.azR().setForumNameForWaterImage(str);
            this.iVF.startLoad(str2, 10, false);
        }
    }
}
