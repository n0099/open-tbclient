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
    public final View dFK;
    public TextView dhT;
    private ImageView eEw;
    private PbFragment iDY;
    public TextView iTN;
    public View iTO;
    private final ImageView iTP;
    private final LinearLayout iTQ;
    public LinearLayout iTR;
    public BarImageView iTS;
    private PopupWindow iTW;
    private int iTX;
    private int iTY;
    private int iTZ;
    private int iUa;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iTM = 6;
    private boolean iPh = false;
    private AlertDialog iTT = null;
    private y iTU = null;
    private boolean iTV = false;
    private boolean iUb = true;
    private Runnable gNm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLg();
        }
    };
    private View.OnClickListener gNn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.crh();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.iTX = 0;
        this.iTY = 0;
        this.iTZ = 0;
        this.iUa = 0;
        this.iDY = pbFragment;
        this.iTX = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.iTY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.iTZ = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.iTZ - dimens > 0) {
            this.iTZ -= dimens;
        }
        this.iUa = (equipmentWidth - (this.iTZ * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.iDY.bEl();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.dFK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.gqq);
        this.iTN = this.mNavigationBar.setCenterTextTitle("");
        this.iTP = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iTQ = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iTQ.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.iTP, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iTP.setVisibility(8);
        this.iTN.setOnClickListener(pbFragment.gqq);
        this.iTP.setOnClickListener(pbFragment.gqq);
        this.eEw = (ImageView) this.dFK.findViewById(R.id.widget_navi_back_button);
        if (this.iTR == null) {
            this.iTR = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iTS = (BarImageView) this.iTR.findViewById(R.id.pb_nav_title_forum_image);
            this.iTS.setShowOval(true);
            this.iTS.setOnClickListener(pbFragment.gqq);
            this.dhT = (TextView) this.iTR.findViewById(R.id.pb_nav_title_forum_name);
            this.dhT.setOnClickListener(pbFragment.gqq);
            if (this.iTR.getLayoutParams() != null && (this.iTR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.iTZ > 0 && this.iUa > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iTR.getLayoutParams();
                marginLayoutParams.leftMargin = this.iTZ;
                marginLayoutParams.rightMargin = this.iTZ;
                this.iTR.setLayoutParams(marginLayoutParams);
            }
            if (this.iTR.getVisibility() == 8) {
                this.iTR.setVisibility(0);
            }
            if (this.iTR.getAlpha() != 1.0f) {
                this.iTR.setAlpha(1.0f);
            }
        }
    }

    public void qD(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.iPh = z;
        if (this.iTO == null && this.Lb == null) {
            this.iTO = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.iDY.gqq);
            this.Lb = (ImageView) this.iTO.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iTX, this.iTX);
            layoutParams.rightMargin = this.iTY;
            this.iTO.setLayoutParams(layoutParams);
            SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iTO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void qj(boolean z) {
        if (this.iTO != null) {
            this.iTO.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cqZ() {
        return this.mNavigationBar;
    }

    public void qE(boolean z) {
        if (z) {
            this.dFK.setVisibility(0);
        } else {
            this.dFK.setVisibility(8);
        }
        qG(z);
    }

    public void DT(String str) {
        if (!TextUtils.isEmpty(str) && !this.iPh) {
            this.iTN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            qG(true);
            i.azO().setForumNameForWaterImage(str);
            return;
        }
        qG(false);
    }

    public void a(z zVar) {
        if (!this.iDY.getBaseFragmentActivity().isProgressBarShown()) {
            this.iTU = new y(this.iDY, this.iDY.gqq);
            this.iTT = new AlertDialog.Builder(this.iDY.getContext(), R.style.DialogTheme).create();
            this.iTT.setCanceledOnTouchOutside(true);
            g.showDialog(this.iTT, this.iDY.getFragmentActivity());
            Window window = this.iTT.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iTU.getView());
            this.iTU.pZ(zVar == null ? false : zVar.iLU);
            this.iTU.qa(zVar == null ? false : zVar.iLY);
            this.iTU.qb(zVar == null ? false : zVar.iMc);
            this.iTU.qc(zVar == null ? false : zVar.iLZ);
            this.iTU.qd(zVar == null ? true : zVar.iLW);
            if (zVar == null) {
                this.iTU.aa(false, false);
                this.iTU.ab(false, false);
            } else {
                this.iTU.aa(zVar.iMa, zVar.iMg);
                this.iTU.ab(zVar.iMb, zVar.iMf);
            }
            boolean z = zVar == null ? false : zVar.hW;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iLX;
            boolean z4 = zVar == null ? false : zVar.iLV;
            boolean z5 = zVar == null ? false : zVar.iMe;
            boolean z6 = zVar == null ? false : zVar.iMd;
            this.iTU.Z(z3, z2);
            this.iTU.ac(z4, z);
            this.iTU.ad(z6, z5);
            if (zVar != null) {
                this.iTU.iLR = zVar.iMh;
                if (zVar.iMh) {
                    this.iTU.coJ().setText(R.string.report_text);
                    this.iTU.qc(false);
                }
            }
            cra();
        }
    }

    private void cra() {
        if (this.iTU != null) {
            this.iTU.coP();
        }
    }

    public void arU() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iTT != null) {
                        g.dismissDialog(c.this.iTT, c.this.iDY.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.gx().postDelayed(this.runnable, 100L);
    }

    public void crb() {
        if (this.iTT != null) {
            g.dismissDialog(this.iTT, this.iDY.getPageContext().getPageActivity());
        }
    }

    public y crc() {
        return this.iTU;
    }

    public View crd() {
        return this.iTP;
    }

    public boolean cre() {
        return this.iTT != null && this.iTT.isShowing();
    }

    public void releaseResources() {
        if (this.iTU != null) {
            this.iTU.release();
        }
        this.iTT = null;
        this.iTU = null;
        e.gx().removeCallbacks(this.runnable);
    }

    public void crf() {
        if (this.iTO != null) {
            this.iTO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iDY.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aGC().a(this.eEw, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iTN, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dhT, (int) R.color.cp_cont_b);
        cra();
    }

    public void zh(int i) {
        this.mNavigationBar.onChangeSkinType(this.iDY.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.Lb != null) {
            SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iTN.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aGC().a(this.eEw, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void crg() {
        this.eEw.setVisibility(0);
        qG(false);
        if (this.iTO != null) {
            this.iTO.setVisibility(8);
        }
    }

    public void qF(boolean z) {
        this.eEw.setVisibility(0);
        qG(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iTO != null) {
                this.iTO.setVisibility(0);
            }
        } else if (this.iTO != null) {
            this.iTO.setVisibility(8);
        }
    }

    public void qG(boolean z) {
        if (!this.iPh && z && !"".equals(this.iTN.getText().toString())) {
            this.iTN.setVisibility(0);
        } else {
            this.iTN.setVisibility(8);
        }
    }

    public void qH(boolean z) {
        this.iTV = z;
    }

    public void cpL() {
        if ((!this.iTV || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.iDY.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.iDY.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.iDY.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.gNn);
            this.iTW = new PopupWindow(inflate, -2, -2);
        }
    }

    public void crh() {
        if (this.gNm != null) {
            e.gx().removeCallbacks(this.gNm);
        }
        bLg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLg() {
        g.dismissPopupWindow(this.iTW);
    }

    public void cC(View view) {
    }

    public void eg(String str, String str2) {
        if (this.iDY != null) {
            if (StringUtils.isNull(str)) {
                this.iTS.setVisibility(8);
                this.dhT.setText("贴吧动态");
                return;
            }
            this.iTS.setVisibility(0);
            this.mForumName = str;
            au.a(this.dhT, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.iUa, false);
            i.azO().setForumNameForWaterImage(str);
            this.iTS.startLoad(str2, 10, false);
        }
    }
}
