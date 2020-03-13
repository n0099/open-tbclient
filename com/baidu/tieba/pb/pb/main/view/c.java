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
    public final View dFX;
    public TextView dih;
    private ImageView eEJ;
    private PbFragment iEk;
    public TextView iTZ;
    public View iUa;
    private final ImageView iUb;
    private final LinearLayout iUc;
    public LinearLayout iUd;
    public BarImageView iUe;
    private PopupWindow iUi;
    private int iUj;
    private int iUk;
    private int iUl;
    private int iUm;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int iTY = 6;
    private boolean iPt = false;
    private AlertDialog iUf = null;
    private y iUg = null;
    private boolean iUh = false;
    private boolean iUn = true;
    private Runnable gNy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLh();
        }
    };
    private View.OnClickListener gNz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cri();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.iUj = 0;
        this.iUk = 0;
        this.iUl = 0;
        this.iUm = 0;
        this.iEk = pbFragment;
        this.iUj = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.iUk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.iUl = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.iUl - dimens > 0) {
            this.iUl -= dimens;
        }
        this.iUm = (equipmentWidth - (this.iUl * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.iEk.bEm();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.dFX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.gqD);
        this.iTZ = this.mNavigationBar.setCenterTextTitle("");
        this.iUb = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iUc = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iUc.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.iUb, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iUb.setVisibility(8);
        this.iTZ.setOnClickListener(pbFragment.gqD);
        this.iUb.setOnClickListener(pbFragment.gqD);
        this.eEJ = (ImageView) this.dFX.findViewById(R.id.widget_navi_back_button);
        if (this.iUd == null) {
            this.iUd = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.iUe = (BarImageView) this.iUd.findViewById(R.id.pb_nav_title_forum_image);
            this.iUe.setShowOval(true);
            this.iUe.setOnClickListener(pbFragment.gqD);
            this.dih = (TextView) this.iUd.findViewById(R.id.pb_nav_title_forum_name);
            this.dih.setOnClickListener(pbFragment.gqD);
            if (this.iUd.getLayoutParams() != null && (this.iUd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.iUl > 0 && this.iUm > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iUd.getLayoutParams();
                marginLayoutParams.leftMargin = this.iUl;
                marginLayoutParams.rightMargin = this.iUl;
                this.iUd.setLayoutParams(marginLayoutParams);
            }
            if (this.iUd.getVisibility() == 8) {
                this.iUd.setVisibility(0);
            }
            if (this.iUd.getAlpha() != 1.0f) {
                this.iUd.setAlpha(1.0f);
            }
        }
    }

    public void qD(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.iPt = z;
        if (this.iUa == null && this.Lb == null) {
            this.iUa = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.iEk.gqD);
            this.Lb = (ImageView) this.iUa.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iUj, this.iUj);
            layoutParams.rightMargin = this.iUk;
            this.iUa.setLayoutParams(layoutParams);
            SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iUa.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void qj(boolean z) {
        if (this.iUa != null) {
            this.iUa.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cra() {
        return this.mNavigationBar;
    }

    public void qE(boolean z) {
        if (z) {
            this.dFX.setVisibility(0);
        } else {
            this.dFX.setVisibility(8);
        }
        qG(z);
    }

    public void DU(String str) {
        if (!TextUtils.isEmpty(str) && !this.iPt) {
            this.iTZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            qG(true);
            i.azO().setForumNameForWaterImage(str);
            return;
        }
        qG(false);
    }

    public void a(z zVar) {
        if (!this.iEk.getBaseFragmentActivity().isProgressBarShown()) {
            this.iUg = new y(this.iEk, this.iEk.gqD);
            this.iUf = new AlertDialog.Builder(this.iEk.getContext(), R.style.DialogTheme).create();
            this.iUf.setCanceledOnTouchOutside(true);
            g.showDialog(this.iUf, this.iEk.getFragmentActivity());
            Window window = this.iUf.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iUg.getView());
            this.iUg.pZ(zVar == null ? false : zVar.iMg);
            this.iUg.qa(zVar == null ? false : zVar.iMk);
            this.iUg.qb(zVar == null ? false : zVar.iMo);
            this.iUg.qc(zVar == null ? false : zVar.iMl);
            this.iUg.qd(zVar == null ? true : zVar.iMi);
            if (zVar == null) {
                this.iUg.aa(false, false);
                this.iUg.ab(false, false);
            } else {
                this.iUg.aa(zVar.iMm, zVar.iMs);
                this.iUg.ab(zVar.iMn, zVar.iMr);
            }
            boolean z = zVar == null ? false : zVar.hW;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iMj;
            boolean z4 = zVar == null ? false : zVar.iMh;
            boolean z5 = zVar == null ? false : zVar.iMq;
            boolean z6 = zVar == null ? false : zVar.iMp;
            this.iUg.Z(z3, z2);
            this.iUg.ac(z4, z);
            this.iUg.ad(z6, z5);
            if (zVar != null) {
                this.iUg.iMd = zVar.iMt;
                if (zVar.iMt) {
                    this.iUg.coK().setText(R.string.report_text);
                    this.iUg.qc(false);
                }
            }
            crb();
        }
    }

    private void crb() {
        if (this.iUg != null) {
            this.iUg.coQ();
        }
    }

    public void arU() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iUf != null) {
                        g.dismissDialog(c.this.iUf, c.this.iEk.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.gx().postDelayed(this.runnable, 100L);
    }

    public void crc() {
        if (this.iUf != null) {
            g.dismissDialog(this.iUf, this.iEk.getPageContext().getPageActivity());
        }
    }

    public y crd() {
        return this.iUg;
    }

    public View cre() {
        return this.iUb;
    }

    public boolean crf() {
        return this.iUf != null && this.iUf.isShowing();
    }

    public void releaseResources() {
        if (this.iUg != null) {
            this.iUg.release();
        }
        this.iUf = null;
        this.iUg = null;
        e.gx().removeCallbacks(this.runnable);
    }

    public void crg() {
        if (this.iUa != null) {
            this.iUa.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iEk.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aGC().a(this.eEJ, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.iTZ, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dih, (int) R.color.cp_cont_b);
        crb();
    }

    public void zh(int i) {
        this.mNavigationBar.onChangeSkinType(this.iEk.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.Lb != null) {
            SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iTZ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aGC().a(this.eEJ, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void crh() {
        this.eEJ.setVisibility(0);
        qG(false);
        if (this.iUa != null) {
            this.iUa.setVisibility(8);
        }
    }

    public void qF(boolean z) {
        this.eEJ.setVisibility(0);
        qG(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.iUa != null) {
                this.iUa.setVisibility(0);
            }
        } else if (this.iUa != null) {
            this.iUa.setVisibility(8);
        }
    }

    public void qG(boolean z) {
        if (!this.iPt && z && !"".equals(this.iTZ.getText().toString())) {
            this.iTZ.setVisibility(0);
        } else {
            this.iTZ.setVisibility(8);
        }
    }

    public void qH(boolean z) {
        this.iUh = z;
    }

    public void cpM() {
        if ((!this.iUh || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.iEk.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.iEk.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.iEk.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.gNz);
            this.iUi = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cri() {
        if (this.gNy != null) {
            e.gx().removeCallbacks(this.gNy);
        }
        bLh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLh() {
        g.dismissPopupWindow(this.iUi);
    }

    public void cC(View view) {
    }

    public void eg(String str, String str2) {
        if (this.iEk != null) {
            if (StringUtils.isNull(str)) {
                this.iUe.setVisibility(8);
                this.dih.setText("贴吧动态");
                return;
            }
            this.iUe.setVisibility(0);
            this.mForumName = str;
            au.a(this.dih, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.iUm, false);
            i.azO().setForumNameForWaterImage(str);
            this.iUe.startLoad(str2, 10, false);
        }
    }
}
