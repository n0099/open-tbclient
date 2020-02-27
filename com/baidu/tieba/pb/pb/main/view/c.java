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
    public final View dFJ;
    public TextView dhS;
    private ImageView eEv;
    private PbFragment iDW;
    public TextView iTL;
    public View iTM;
    private final ImageView iTN;
    private final LinearLayout iTO;
    public LinearLayout iTP;
    public BarImageView iTQ;
    private PopupWindow iTU;
    private int iTV;
    private int iTW;
    private int iTX;
    private int iTY;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iTK = 6;
    private boolean iPf = false;
    private AlertDialog iTR = null;
    private y iTS = null;
    private boolean iTT = false;
    private boolean iTZ = true;
    private Runnable gNk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLe();
        }
    };
    private View.OnClickListener gNl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.crf();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.iTV = 0;
        this.iTW = 0;
        this.iTX = 0;
        this.iTY = 0;
        this.iDW = pbFragment;
        this.iTV = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.iTW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.iTX = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.iTX - dimens > 0) {
            this.iTX -= dimens;
        }
        this.iTY = (equipmentWidth - (this.iTX * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.iDW.bEj();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.dFJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.gqo);
        this.iTL = this.mNavigationBar.setCenterTextTitle("");
        this.iTN = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iTO = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iTO.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.iTN, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iTN.setVisibility(8);
        this.iTL.setOnClickListener(pbFragment.gqo);
        this.iTN.setOnClickListener(pbFragment.gqo);
        this.eEv = (ImageView) this.dFJ.findViewById(R.id.widget_navi_back_button);
        if (this.iTP == null) {
            this.iTP = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iTQ = (BarImageView) this.iTP.findViewById(R.id.pb_nav_title_forum_image);
            this.iTQ.setShowOval(true);
            this.iTQ.setOnClickListener(pbFragment.gqo);
            this.dhS = (TextView) this.iTP.findViewById(R.id.pb_nav_title_forum_name);
            this.dhS.setOnClickListener(pbFragment.gqo);
            if (this.iTP.getLayoutParams() != null && (this.iTP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.iTX > 0 && this.iTY > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iTP.getLayoutParams();
                marginLayoutParams.leftMargin = this.iTX;
                marginLayoutParams.rightMargin = this.iTX;
                this.iTP.setLayoutParams(marginLayoutParams);
            }
            if (this.iTP.getVisibility() == 8) {
                this.iTP.setVisibility(0);
            }
            if (this.iTP.getAlpha() != 1.0f) {
                this.iTP.setAlpha(1.0f);
            }
        }
    }

    public void qD(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.iPf = z;
        if (this.iTM == null && this.Lb == null) {
            this.iTM = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.iDW.gqo);
            this.Lb = (ImageView) this.iTM.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iTV, this.iTV);
            layoutParams.rightMargin = this.iTW;
            this.iTM.setLayoutParams(layoutParams);
            SvgManager.aGA().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iTM.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void qj(boolean z) {
        if (this.iTM != null) {
            this.iTM.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cqX() {
        return this.mNavigationBar;
    }

    public void qE(boolean z) {
        if (z) {
            this.dFJ.setVisibility(0);
        } else {
            this.dFJ.setVisibility(8);
        }
        qG(z);
    }

    public void DT(String str) {
        if (!TextUtils.isEmpty(str) && !this.iPf) {
            this.iTL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            qG(true);
            i.azM().setForumNameForWaterImage(str);
            return;
        }
        qG(false);
    }

    public void a(z zVar) {
        if (!this.iDW.getBaseFragmentActivity().isProgressBarShown()) {
            this.iTS = new y(this.iDW, this.iDW.gqo);
            this.iTR = new AlertDialog.Builder(this.iDW.getContext(), R.style.DialogTheme).create();
            this.iTR.setCanceledOnTouchOutside(true);
            g.showDialog(this.iTR, this.iDW.getFragmentActivity());
            Window window = this.iTR.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iTS.getView());
            this.iTS.pZ(zVar == null ? false : zVar.iLS);
            this.iTS.qa(zVar == null ? false : zVar.iLW);
            this.iTS.qb(zVar == null ? false : zVar.iMa);
            this.iTS.qc(zVar == null ? false : zVar.iLX);
            this.iTS.qd(zVar == null ? true : zVar.iLU);
            if (zVar == null) {
                this.iTS.aa(false, false);
                this.iTS.ab(false, false);
            } else {
                this.iTS.aa(zVar.iLY, zVar.iMe);
                this.iTS.ab(zVar.iLZ, zVar.iMd);
            }
            boolean z = zVar == null ? false : zVar.hW;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iLV;
            boolean z4 = zVar == null ? false : zVar.iLT;
            boolean z5 = zVar == null ? false : zVar.iMc;
            boolean z6 = zVar == null ? false : zVar.iMb;
            this.iTS.Z(z3, z2);
            this.iTS.ac(z4, z);
            this.iTS.ad(z6, z5);
            if (zVar != null) {
                this.iTS.iLP = zVar.iMf;
                if (zVar.iMf) {
                    this.iTS.coH().setText(R.string.report_text);
                    this.iTS.qc(false);
                }
            }
            cqY();
        }
    }

    private void cqY() {
        if (this.iTS != null) {
            this.iTS.coN();
        }
    }

    public void arS() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iTR != null) {
                        g.dismissDialog(c.this.iTR, c.this.iDW.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.gx().postDelayed(this.runnable, 100L);
    }

    public void cqZ() {
        if (this.iTR != null) {
            g.dismissDialog(this.iTR, this.iDW.getPageContext().getPageActivity());
        }
    }

    public y cra() {
        return this.iTS;
    }

    public View crb() {
        return this.iTN;
    }

    public boolean crc() {
        return this.iTR != null && this.iTR.isShowing();
    }

    public void releaseResources() {
        if (this.iTS != null) {
            this.iTS.release();
        }
        this.iTR = null;
        this.iTS = null;
        e.gx().removeCallbacks(this.runnable);
    }

    public void crd() {
        if (this.iTM != null) {
            this.iTM.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iDW.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aGA().a(this.eEv, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iTL, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dhS, (int) R.color.cp_cont_b);
        cqY();
    }

    public void zh(int i) {
        this.mNavigationBar.onChangeSkinType(this.iDW.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.Lb != null) {
            SvgManager.aGA().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iTL.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aGA().a(this.eEv, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cre() {
        this.eEv.setVisibility(0);
        qG(false);
        if (this.iTM != null) {
            this.iTM.setVisibility(8);
        }
    }

    public void qF(boolean z) {
        this.eEv.setVisibility(0);
        qG(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iTM != null) {
                this.iTM.setVisibility(0);
            }
        } else if (this.iTM != null) {
            this.iTM.setVisibility(8);
        }
    }

    public void qG(boolean z) {
        if (!this.iPf && z && !"".equals(this.iTL.getText().toString())) {
            this.iTL.setVisibility(0);
        } else {
            this.iTL.setVisibility(8);
        }
    }

    public void qH(boolean z) {
        this.iTT = z;
    }

    public void cpJ() {
        if ((!this.iTT || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.iDW.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.iDW.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.iDW.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.gNl);
            this.iTU = new PopupWindow(inflate, -2, -2);
        }
    }

    public void crf() {
        if (this.gNk != null) {
            e.gx().removeCallbacks(this.gNk);
        }
        bLe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLe() {
        g.dismissPopupWindow(this.iTU);
    }

    public void cC(View view) {
    }

    public void eg(String str, String str2) {
        if (this.iDW != null) {
            if (StringUtils.isNull(str)) {
                this.iTQ.setVisibility(8);
                this.dhS.setText("贴吧动态");
                return;
            }
            this.iTQ.setVisibility(0);
            this.mForumName = str;
            au.a(this.dhS, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.iTY, false);
            i.azM().setForumNameForWaterImage(str);
            this.iTQ.startLoad(str2, 10, false);
        }
    }
}
